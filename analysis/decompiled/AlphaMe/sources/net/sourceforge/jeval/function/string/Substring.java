package net.sourceforge.jeval.function.string;

import java.util.ArrayList;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Substring implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList oneStringAndTwoIntegers = FunctionHelper.getOneStringAndTwoIntegers(str, ',');
        if (oneStringAndTwoIntegers.size() != 3) {
            throw new FunctionException("One string argument and two integer arguments are required.");
        }
        try {
            return new FunctionResult(FunctionHelper.trimAndRemoveQuoteChars((String) oneStringAndTwoIntegers.get(0), evaluator.getQuoteCharacter()).substring(((Integer) oneStringAndTwoIntegers.get(1)).intValue(), ((Integer) oneStringAndTwoIntegers.get(2)).intValue()), 1);
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("One string argument and two integer arguments are required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return "substring";
    }
}
