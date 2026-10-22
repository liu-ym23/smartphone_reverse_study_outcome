package net.sourceforge.jeval.function.math;

import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Tan implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        try {
            return new FunctionResult(new Double(Math.tan(new Double(str).doubleValue())).toString(), 0);
        } catch (Exception e4) {
            throw new FunctionException("Invalid argument.", e4);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "tan";
    }
}
