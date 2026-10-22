package net.sourceforge.jeval.math;

import java.util.ArrayList;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Min implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList doubles = FunctionHelper.getDoubles(str, ',');
        if (doubles.size() != 2) {
            throw new FunctionException("Two numeric arguments are required.");
        }
        try {
            return new FunctionResult(new Double(Math.min(((Double) doubles.get(0)).doubleValue(), ((Double) doubles.get(1)).doubleValue())).toString(), 0);
        } catch (Exception e4) {
            throw new FunctionException("Two numeric arguments are required.", e4);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "min";
    }
}
