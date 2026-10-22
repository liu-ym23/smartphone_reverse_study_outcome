package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class StringFunctionsSample {
    public static void main(String[] strArr) {
        Evaluator evaluator = new Evaluator();
        try {
            PrintStream printStream = System.out;
            printStream.println(evaluator.evaluate("toLowerCase('Hello World!')"));
            printStream.println(evaluator.evaluate("trim('abc ') + 'd'"));
            printStream.println(evaluator.evaluate("lastIndexOf('abcabcabc', 'abc', 8)"));
            printStream.println(evaluator.evaluate("eval(1 + 2)"));
            printStream.println("An exception is expected in the next evaluation.");
            printStream.println(evaluator.evaluate("round()"));
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
