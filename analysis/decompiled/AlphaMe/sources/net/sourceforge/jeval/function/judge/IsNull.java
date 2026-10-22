package net.sourceforge.jeval.function.judge;

import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class IsNull implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        String str2;
        try {
            String strTrim = FunctionHelper.trimAndRemoveQuoteChars(str, evaluator.getQuoteCharacter()).trim();
            if (strTrim != null) {
                str2 = strTrim.length() <= 0 ? EvaluationConstants.BOOLEAN_STRING_TRUE : EvaluationConstants.BOOLEAN_STRING_FALSE;
            }
            return new FunctionResult(str2, 0);
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("One string argument is required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "isnull";
    }
}
