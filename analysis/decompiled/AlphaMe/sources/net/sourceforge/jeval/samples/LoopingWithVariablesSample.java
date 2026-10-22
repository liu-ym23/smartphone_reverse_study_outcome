package net.sourceforge.jeval.samples;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class LoopingWithVariablesSample {
    private static void loadData(List list, int i4, int i5) {
        for (int i6 = 0; i6 < i4; i6++) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < i5; i7++) {
                arrayList.add(Long.valueOf(Math.round(Math.random() * 10.0d)));
            }
            list.add(arrayList);
        }
    }

    public static void main(String[] strArr) throws IllegalArgumentException {
        Evaluator evaluator = new Evaluator();
        ArrayList arrayList = new ArrayList();
        loadData(arrayList, 50, 3);
        try {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                List list = (List) arrayList.get(i4);
                Long l4 = (Long) list.get(0);
                Long l5 = (Long) list.get(1);
                Long l6 = (Long) list.get(2);
                evaluator.putVariable("a", l4.toString());
                evaluator.putVariable("b", l5.toString());
                evaluator.putVariable("c", l6.toString());
                long time = new Date().getTime();
                String strEvaluate = evaluator.evaluate("#{a} >= 2 && #{b} >= 5 && #{c} >= 8");
                long time2 = new Date().getTime();
                PrintStream printStream = System.out;
                printStream.println("Execution time (row number = " + i4 + "):" + (time2 - time) + " ms");
                if (strEvaluate.equals(EvaluationConstants.BOOLEAN_STRING_TRUE)) {
                    printStream.println("Row number " + i4 + " meets our criteria. A=" + l4 + " B=" + l5 + " C=" + l6);
                }
            }
        } catch (EvaluationException e4) {
            System.out.println(e4);
        }
    }
}
