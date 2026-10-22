package net.sourceforge.jeval.function.string;

import java.util.ArrayList;
import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class StartsWith implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList twoStringsAndOneInteger = FunctionHelper.getTwoStringsAndOneInteger(str, ',');
        if (twoStringsAndOneInteger.size() != 3) {
            throw new FunctionException("Two string arguments and one integer argument are required.");
        }
        try {
            return new FunctionResult(FunctionHelper.trimAndRemoveQuoteChars((String) twoStringsAndOneInteger.get(0), evaluator.getQuoteCharacter()).startsWith(FunctionHelper.trimAndRemoveQuoteChars((String) twoStringsAndOneInteger.get(1), evaluator.getQuoteCharacter()), ((Integer) twoStringsAndOneInteger.get(2)).intValue()) ? EvaluationConstants.BOOLEAN_STRING_TRUE : EvaluationConstants.BOOLEAN_STRING_FALSE, 0);
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("Two string arguments and one integer argument are required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "startsWith";
    }
}
