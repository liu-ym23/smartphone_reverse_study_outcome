package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class NestedFunctionsSample {
    public static void main(String[] strArr) {
        Evaluator evaluator = new Evaluator();
        try {
            PrintStream printStream = System.out;
            printStream.println(evaluator.evaluate("toUpperCase(trim( trim(' a b c ') ))"));
            printStream.println(evaluator.evaluate("atan2(atan2(1, 1), 1)"));
            Evaluator evaluator2 = new Evaluator('\'', true, true, true, true, false);
            printStream.println("An exception is expected in the next evaluation.");
            printStream.println(evaluator2.evaluate("toUpperCase(trim( trim(' a b c ') ))"));
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
