package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class StringOperatorsSample {
    public static void main(String[] strArr) {
        Evaluator evaluator = new Evaluator();
        try {
            PrintStream printStream = System.out;
            printStream.println(evaluator.evaluate("'A' + 'C'"));
            printStream.println(evaluator.evaluate("'A' < 'C'"));
            evaluator.setQuoteCharacter('\"');
            printStream.println(evaluator.evaluate("\"AB\" + \"C\""));
            printStream.println("An exception is expected in the next evaluation.");
            printStream.println(evaluator.evaluate("a + b"));
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
