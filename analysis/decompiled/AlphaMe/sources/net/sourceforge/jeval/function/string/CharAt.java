package net.sourceforge.jeval.function.string;

import java.util.ArrayList;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class CharAt implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList oneStringAndOneInteger = FunctionHelper.getOneStringAndOneInteger(str, ',');
        if (oneStringAndOneInteger.size() != 2) {
            throw new FunctionException("One string and one integer argument are required.");
        }
        try {
            return new FunctionResult(new String(new char[]{FunctionHelper.trimAndRemoveQuoteChars((String) oneStringAndOneInteger.get(0), evaluator.getQuoteCharacter()).charAt(((Integer) oneStringAndOneInteger.get(1)).intValue())}), 1);
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("One string and one integer argument are required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "charAt";
    }
}
