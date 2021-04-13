import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 270;

    public MainFrame() {
        super("Вычислить значение функции");
        setSize(WIDTH, HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);
        JTextField textFieldX = new JTextField("0.0", 10);
        JTextField textFieldP = new JTextField("0.0", 10);
        textFieldX.setMaximumSize(new Dimension(2 * textFieldX.getPreferredSize().width,
                textFieldX.getPreferredSize().height));
        textFieldP.setMaximumSize(new Dimension(2 * textFieldP.getPreferredSize().width,
                textFieldP.getPreferredSize().height));

        JLabel labelY = new JLabel("");
        labelY.setMinimumSize(textFieldX.getMaximumSize());
        labelY.setPreferredSize(textFieldX.getPreferredSize());

        JButton incrementPlus = new JButton("+");
        JButton incrementMinus = new JButton("-");


        Box hBoxPValueButtons = Box.createHorizontalBox();
        hBoxPValueButtons.add(Box.createHorizontalGlue());
        hBoxPValueButtons.add(incrementMinus);
        hBoxPValueButtons.add(Box.createHorizontalGlue());
        hBoxPValueButtons.add(Box.createHorizontalStrut(5));
        hBoxPValueButtons.add(incrementPlus);
        hBoxPValueButtons.add(Box.createHorizontalGlue());

        hBoxPValueButtons.setMaximumSize(new Dimension(hBoxPValueButtons.getMaximumSize().width,
                hBoxPValueButtons.getPreferredSize().height));

        Box hBoxPValue = Box.createHorizontalBox();
        hBoxPValue.add(Box.createHorizontalStrut(35));
        hBoxPValue.add(Box.createHorizontalGlue());
        hBoxPValue.add(new JLabel("P: "));
        hBoxPValue.add(Box.createVerticalGlue());
        hBoxPValue.add(Box.createHorizontalStrut(5));
        hBoxPValue.add(textFieldP);
        hBoxPValue.add(Box.createHorizontalGlue());
        hBoxPValue.add(Box.createHorizontalStrut(5));
        hBoxPValue.add(hBoxPValueButtons);
        hBoxPValue.add(Box.createHorizontalStrut(40));
        hBoxPValue.add(Box.createHorizontalGlue());
        hBoxPValue.setMaximumSize(new Dimension(hBoxPValue.getMaximumSize().width,
                hBoxPValue.getPreferredSize().height));
        Box hBoxPValueUnder = Box.createHorizontalBox();
        hBoxPValueUnder.add(Box.createHorizontalGlue());

        hBoxPValueUnder.setAlignmentX(CENTER_ALIGNMENT);
        hBoxPValueUnder.add(new JLabel("Формула: f(x) = P - X"));
        hBoxPValueUnder.add(Box.createHorizontalGlue());


        Box hBoxXValue = Box.createHorizontalBox();
        hBoxXValue.add(Box.createHorizontalGlue());
        hBoxXValue.add(new JLabel("X: "));
        hBoxXValue.add(Box.createHorizontalStrut(10));
        hBoxXValue.add(textFieldX);
        hBoxXValue.add(Box.createHorizontalGlue());
        hBoxXValue.setMaximumSize(new Dimension(hBoxXValue.getMaximumSize().width,
                hBoxXValue.getPreferredSize().height));

        Box hBoxYValue = Box.createHorizontalBox();
        hBoxYValue.add(Box.createHorizontalGlue());
        hBoxYValue.add(new JLabel("Y: "));
        hBoxYValue.add(Box.createHorizontalStrut(10));
        hBoxYValue.add(labelY);
        hBoxYValue.add(Box.createHorizontalGlue());
        hBoxYValue.setMaximumSize(new Dimension(hBoxYValue.getMaximumSize().width,
                hBoxYValue.getPreferredSize().height));


        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.setAlignmentX(CENTER_ALIGNMENT);
        //Calculate
        buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double X = Double.parseDouble(textFieldX.getText());
                    Double P = Double.parseDouble(textFieldP.getText());
                    labelY.setText(Double.toString(P - X));
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(new MainFrame(), "Wrong input values!");
                    textFieldP.setText("0.0");
                    textFieldX.setText("0.0");
                }

            }
        });

        //Minus
        incrementMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double P = Double.parseDouble(textFieldP.getText());
                    textFieldP.setText(Double.toString( --P));
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(new MainFrame(), "Wrong input values!");
                    textFieldP.setText("0.0");
                }
            }
        });

        //Plus
        incrementPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double P = Double.parseDouble(textFieldP.getText());
                    textFieldP.setText(Double.toString( ++P));
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(new MainFrame(), "Wrong input values!");
                    textFieldP.setText("0.0");
                }
            }
        });


        //UPPER FRAME
        Box vBoxPFunction = Box.createVerticalBox();
        vBoxPFunction.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Параметры функции:"
        ));
        vBoxPFunction.add(Box.createVerticalStrut(10));
        vBoxPFunction.add(Box.createHorizontalGlue());
        vBoxPFunction.add(hBoxPValue);
        vBoxPFunction.add(Box.createHorizontalGlue());
        vBoxPFunction.add(Box.createHorizontalStrut(0));
        vBoxPFunction.add(Box.createVerticalStrut(10));
        vBoxPFunction.add(hBoxPValueUnder);
        vBoxPFunction.add(Box.createHorizontalGlue());
        vBoxPFunction.add(Box.createVerticalGlue());
        vBoxPFunction.add(Box.createVerticalStrut(10));


        Box vBoxCalculator = Box.createVerticalBox();
        vBoxCalculator.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Расчет значения функции:"
        ));
        vBoxCalculator.add(Box.createVerticalStrut(10));
        vBoxCalculator.add(Box.createHorizontalGlue());
        vBoxCalculator.add(hBoxXValue);
        vBoxCalculator.add(Box.createHorizontalStrut(10));
        vBoxCalculator.add(hBoxYValue);
        vBoxCalculator.add(Box.createHorizontalStrut(20));
        vBoxCalculator.add(Box.createVerticalStrut(15));
        vBoxCalculator.add(buttonCalc);
        vBoxCalculator.add(Box.createVerticalStrut(20));
        vBoxCalculator.add(Box.createVerticalGlue());

        Box application = Box.createVerticalBox();
        application.add(vBoxPFunction);
        application.add(vBoxCalculator);
        getContentPane().add(application);
    }
}
