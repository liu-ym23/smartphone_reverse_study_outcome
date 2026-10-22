package com.fasterxml.jackson.core.io;

import androidx.activity.b;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaBigDecimalParser;
import java.math.BigDecimal;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class BigDecimalParser {
    static final int MAX_CHARS_TO_REPORT = 1000;
    private static final int SIZE_FOR_SWITCH_TO_FASTDOUBLEPARSER = 500;

    private BigDecimalParser() {
    }

    private static String _generateExceptionMessage(String str, String str2) {
        return b.j("Value ", str, " can not be deserialized as `java.math.BigDecimal`, reason:  ", str2);
    }

    private static String _getValueDesc(char[] cArr, int i, int i3) {
        return i3 <= 1000 ? a.C("\"", new String(cArr, i, i3), "\"") : String.format("\"%s\" (truncated to %d chars (from %d))", new String(cArr, i, 1000), 1000, Integer.valueOf(i3));
    }

    private static NumberFormatException _parseFailure(Exception exc, String str) {
        String message = exc.getMessage();
        if (message == null) {
            message = "Not a valid number representation";
        }
        return new NumberFormatException(_generateExceptionMessage(_getValueDesc(str), message));
    }

    public static BigDecimal parse(String str) {
        try {
            return str.length() < 500 ? new BigDecimal(str) : JavaBigDecimalParser.parseBigDecimal(str);
        } catch (ArithmeticException | NumberFormatException e10) {
            throw _parseFailure(e10, str);
        }
    }

    public static BigDecimal parseWithFastParser(String str) {
        try {
            return JavaBigDecimalParser.parseBigDecimal(str);
        } catch (ArithmeticException | NumberFormatException e10) {
            throw _parseFailure(e10, str);
        }
    }

    public static BigDecimal parseWithFastParser(char[] cArr, int i, int i3) {
        try {
            return JavaBigDecimalParser.parseBigDecimal(cArr, i, i3);
        } catch (ArithmeticException | NumberFormatException e10) {
            throw _parseFailure(e10, cArr, i, i3);
        }
    }

    private static NumberFormatException _parseFailure(Exception exc, char[] cArr, int i, int i3) {
        String message = exc.getMessage();
        if (message == null) {
            message = "Not a valid number representation";
        }
        return new NumberFormatException(_generateExceptionMessage(_getValueDesc(cArr, i, i3), message));
    }

    public static BigDecimal parse(char[] cArr, int i, int i3) {
        try {
            if (i3 < 500) {
                return new BigDecimal(cArr, i, i3);
            }
            return JavaBigDecimalParser.parseBigDecimal(cArr, i, i3);
        } catch (ArithmeticException | NumberFormatException e10) {
            throw _parseFailure(e10, cArr, i, i3);
        }
    }

    public static BigDecimal parse(char[] cArr) {
        return parse(cArr, 0, cArr.length);
    }

    private static String _getValueDesc(String str) {
        int length = str.length();
        if (length <= 1000) {
            return a.C("\"", str, "\"");
        }
        return String.format("\"%s\" (truncated to %d chars (from %d))", str.substring(0, 1000), 1000, Integer.valueOf(length));
    }
}
