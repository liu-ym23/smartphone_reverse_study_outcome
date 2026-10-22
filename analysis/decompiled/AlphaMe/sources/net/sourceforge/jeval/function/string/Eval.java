package net.sourceforge.jeval.function.string;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Eval implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException, NumberFormatException {
        int i4 = 1;
        try {
            String strEvaluate = evaluator.evaluate(str, false, true);
            try {
                Double.parseDouble(strEvaluate);
                i4 = 0;
            } catch (NumberFormatException unused) {
            }
            return new FunctionResult(strEvaluate, i4);
        } catch (EvaluationException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "eval";
    }
}
