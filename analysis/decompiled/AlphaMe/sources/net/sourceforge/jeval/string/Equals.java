package net.sourceforge.jeval.string;

import java.util.ArrayList;
import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Equals implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList strings = FunctionHelper.getStrings(str, ',');
        if (strings.size() != 2) {
            throw new FunctionException("Two string arguments are required.");
        }
        try {
            return new FunctionResult(FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(0), evaluator.getQuoteCharacter()).equals(FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(1), evaluator.getQuoteCharacter())) ? EvaluationConstants.BOOLEAN_STRING_TRUE : EvaluationConstants.BOOLEAN_STRING_FALSE, 0);
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("Two string arguments are required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "equals";
    }
}
