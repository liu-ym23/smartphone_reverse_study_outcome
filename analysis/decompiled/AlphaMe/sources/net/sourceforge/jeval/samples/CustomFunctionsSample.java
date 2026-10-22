package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class CustomFunctionsSample {
    public static void main(String[] strArr) throws IllegalArgumentException {
        Evaluator evaluator = new Evaluator();
        try {
            evaluator.putFunction(new MockStringReverseFunction());
            PrintStream printStream = System.out;
            printStream.println(evaluator.evaluate("stringReverse('Hello World!')"));
            printStream.println(evaluator.evaluate("'*' + stringReverse('test') + '*'"));
            evaluator.clearFunctions();
            printStream.println("An exception is expected in the next evaluation.");
            printStream.println(evaluator.evaluate("stringReverse('Hello World!')"));
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
