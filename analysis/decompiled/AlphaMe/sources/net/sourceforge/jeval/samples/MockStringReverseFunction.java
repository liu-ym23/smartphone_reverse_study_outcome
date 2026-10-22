package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class MockStringReverseFunction implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        try {
            String strTrimAndRemoveQuoteChars = FunctionHelper.trimAndRemoveQuoteChars(new Evaluator().evaluate(str, true, false), evaluator.getQuoteCharacter());
            String str2 = "";
            for (int length = strTrimAndRemoveQuoteChars.length() - 1; length >= 0; length--) {
                str2 = str2 + strTrimAndRemoveQuoteChars.charAt(length);
            }
            return new FunctionResult(str2, 1);
        } catch (EvaluationException e4) {
            throw new FunctionException("Invalid expression in arguments.", e4);
        } catch (FunctionException e5) {
            throw new FunctionException(e5.getMessage(), e5);
        } catch (Exception e6) {
            throw new FunctionException("One string argument is required.", e6);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "stringReverse";
    }
}
