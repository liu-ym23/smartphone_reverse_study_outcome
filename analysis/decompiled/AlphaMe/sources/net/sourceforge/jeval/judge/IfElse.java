package net.sourceforge.jeval.judge;

import java.util.ArrayList;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class IfElse implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList doubles = FunctionHelper.getDoubles(str, ',');
        if (doubles.size() != 3) {
            throw new FunctionException("Three numeric arguments are required.");
        }
        try {
            double dDoubleValue = ((Double) doubles.get(0)).doubleValue();
            String string = ((Double) doubles.get(1)).toString();
            String string2 = ((Double) doubles.get(2)).toString();
            if (dDoubleValue <= 0.0d) {
                string = string2;
            }
            return new FunctionResult(string, 0);
        } catch (Exception e4) {
            throw new FunctionException("Three numeric arguments are required.", e4);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "ifelse";
    }
}
