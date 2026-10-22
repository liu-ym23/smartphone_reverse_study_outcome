package net.sourceforge.jeval.function.math;

import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Random implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        return new FunctionResult(new Double(Math.random()).toString(), 0);
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "random";
    }
}
