package net.sourceforge.jeval.math;

import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class ToDegrees implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        try {
            return new FunctionResult(new Double(Math.toDegrees(new Double(str).doubleValue())).toString(), 0);
        } catch (Exception e4) {
            throw new FunctionException("Invalid argument.", e4);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "toDegrees";
    }
}
