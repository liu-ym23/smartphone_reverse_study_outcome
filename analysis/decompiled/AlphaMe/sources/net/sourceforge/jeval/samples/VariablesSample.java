package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class VariablesSample {
    public static void main(String[] strArr) throws IllegalArgumentException {
        Evaluator evaluator = new Evaluator();
        try {
            evaluator.putVariable("a", "'Hello'");
            evaluator.putVariable("b", "'World'");
            PrintStream printStream = System.out;
            printStream.println(evaluator.evaluate("#{a}"));
            printStream.println(evaluator.evaluate("#{b}"));
            printStream.println(evaluator.evaluate("#{PI}"));
            printStream.println(evaluator.evaluate("#{a} + ' ' + #{b} + '!'"));
            evaluator.clearVariables();
            evaluator.setVariableResolver(new MockVariableResolver());
            printStream.println(evaluator.evaluate("#{MockVariable1} + #{MockVariable2}"));
            printStream.println("An exception is expected in the next evaluation.");
            printStream.println(evaluator.evaluate("#{a}"));
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
