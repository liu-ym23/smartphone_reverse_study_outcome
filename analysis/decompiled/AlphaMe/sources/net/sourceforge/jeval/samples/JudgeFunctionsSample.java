package net.sourceforge.jeval.samples;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.PrintStream;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public class JudgeFunctionsSample {
    public static void main(String[] strArr) throws IllegalArgumentException {
        Evaluator evaluator = new Evaluator();
        try {
            evaluator.putVariable("x", "20");
            evaluator.putVariable("y", "20");
            String strEvaluate = evaluator.evaluate("eq(min(#{x},2),#{y})");
            PrintStream printStream = System.out;
            printStream.println("eq(x,y) // x==y ? 1 : 0    result:" + strEvaluate);
            evaluator.clearVariables();
            evaluator.putVariable("x", "-100");
            evaluator.putVariable("y", "20");
            printStream.println("gt(x,y) // x>y ? 1 : 0         result:" + evaluator.evaluate("gt(1 + abs(#{x}),#{y})"));
            evaluator.clearVariables();
            evaluator.putVariable("x", "20");
            evaluator.putVariable("y", "20");
            printStream.println("ge(x,y) // x>=y ? 1 : 0       result:" + evaluator.evaluate("ge(#{x},#{y})"));
            evaluator.clearVariables();
            evaluator.putVariable("x", "20");
            evaluator.putVariable("y", "20");
            printStream.println("ne(x,y) // x!=y ? 1 : 0      result:" + evaluator.evaluate("ne(#{x},#{y})"));
            evaluator.clearVariables();
            evaluator.putVariable("x", "20");
            evaluator.putVariable("y", "20");
            printStream.println("lt(x,y)  // x<y ? 1 : 0        result:" + evaluator.evaluate("lt(#{x},#{y})"));
            evaluator.clearVariables();
            evaluator.putVariable("x", "20");
            evaluator.putVariable("y", "20");
            printStream.println("le(x,y) // x<=y ? 1 : 0        result:" + evaluator.evaluate("le(#{x},#{y})"));
            evaluator.clearVariables();
            printStream.println("isnull(x) // x==null ? 1 : 0         result:" + evaluator.evaluate("isnull(' ')"));
            evaluator.clearVariables();
            evaluator.putVariable("x", "-20");
            evaluator.putVariable("y", "6");
            evaluator.putVariable(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "40.4");
            printStream.println("ifelse(x,y,z) // x>0 ? y : z        result:" + evaluator.evaluate("ifelse(#{x},#{y},round(#{z})) + 5*#{PI}"));
            evaluator.clearVariables();
        } catch (EvaluationException e4) {
            e4.printStackTrace();
        }
    }
}
