package net.sourceforge.jeval.function.string;

import ch.qos.logback.core.pattern.parser.Parser;
import java.util.ArrayList;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/* loaded from: classes2.dex */
public class Replace implements Function {
    @Override // net.sourceforge.jeval.function.Function
    public FunctionResult execute(Evaluator evaluator, String str) throws FunctionException {
        ArrayList strings = FunctionHelper.getStrings(str, ',');
        if (strings.size() != 3) {
            throw new FunctionException("One string argument and two character arguments are required.");
        }
        try {
            String strTrimAndRemoveQuoteChars = FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(0), evaluator.getQuoteCharacter());
            String strTrimAndRemoveQuoteChars2 = FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(1), evaluator.getQuoteCharacter());
            String strTrimAndRemoveQuoteChars3 = FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(2), evaluator.getQuoteCharacter());
            if (strTrimAndRemoveQuoteChars2.length() != 1) {
                throw new FunctionException("One string argument and two character arguments are required.");
            }
            char cCharAt = strTrimAndRemoveQuoteChars2.charAt(0);
            if (strTrimAndRemoveQuoteChars3.length() == 1) {
                return new FunctionResult(strTrimAndRemoveQuoteChars.replace(cCharAt, strTrimAndRemoveQuoteChars3.charAt(0)), 1);
            }
            throw new FunctionException("One string argument and two character arguments are required.");
        } catch (FunctionException e4) {
            throw new FunctionException(e4.getMessage(), e4);
        } catch (Exception e5) {
            throw new FunctionException("One string argument and two character arguments are required.", e5);
        }
    }

    @Override // net.sourceforge.jeval.function.Function
    public String getName() {
        return Parser.REPLACE_CONVERTER_WORD;
    }
}
