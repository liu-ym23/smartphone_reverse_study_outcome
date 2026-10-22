package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class MathematicalOperationsSample {
    public static void main(String[] strArr) {
        Evaluator evaluator = new Evaluator();
        try {
            PrintStream printStream = System.out;
            printStream.println(evaluator.evaluate("4 + 1"));
            printStream.println(evaluator.evaluate("1 / 3"));
            printStream.println(evaluator.evaluate("4 + (3 + 1) + (3 + 1) + 1"));
            printStream.println("An exception is expected in the next evaluation.");
            printStream.println(evaluator.evaluate("4 + "));
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
