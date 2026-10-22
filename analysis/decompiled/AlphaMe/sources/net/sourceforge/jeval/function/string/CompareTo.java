package net.sourceforge.jeval.function.string;

import java.util.ArrayList;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class CompareTo implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList strings = FunctionHelper.getStrings(str, ',');
        if (strings.size() != 2) {
            throw new FunctionException("Two string arguments are required.");
        }
        try {
            return new FunctionResult(new Integer(FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(0), evaluator.getQuoteCharacter()).compareTo(FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(1), evaluator.getQuoteCharacter()))).toString(), 0);
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("Two string arguments are required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "compareTo";
    }
}
