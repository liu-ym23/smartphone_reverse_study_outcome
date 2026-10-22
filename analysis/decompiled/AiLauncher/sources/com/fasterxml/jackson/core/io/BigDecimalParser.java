package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaBigDecimalParser;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class BigDecimalParser {
    static final int MAX_CHARS_TO_REPORT = 1000;
    private static final int SIZE_FOR_SWITCH_TO_FASTDOUBLEPARSER = 500;

    private BigDecimalParser() {
    }

    private static String _generateExceptionMessage(String str, String str2) {
        return String.format("Value %s can not be deserialized as `java.math.BigDecimal`, reason:  %s", str, str2);
    }

    private static String _getValueDesc(String str) {
        int length = str.length();
        return length <= 1000 ? String.format("\"%s\"", str) : String.format("\"%s\" (truncated to %d chars (from %d))", str.substring(0, 1000), 1000, Integer.valueOf(length));
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

    public static BigDecimal parseWithFastParser(char[] cArr, int i10, int i11) {
        try {
            return JavaBigDecimalParser.parseBigDecimal(cArr, i10, i11);
        } catch (ArithmeticException | NumberFormatException e10) {
            throw _parseFailure(e10, cArr, i10, i11);
        }
    }

    private static NumberFormatException _parseFailure(Exception exc, char[] cArr, int i10, int i11) {
        String message = exc.getMessage();
        if (message == null) {
            message = "Not a valid number representation";
        }
        return new NumberFormatException(_generateExceptionMessage(_getValueDesc(cArr, i10, i11), message));
    }

    public static BigDecimal parse(char[] cArr, int i10, int i11) {
        try {
            if (i11 < 500) {
                return new BigDecimal(cArr, i10, i11);
            }
            return JavaBigDecimalParser.parseBigDecimal(cArr, i10, i11);
        } catch (ArithmeticException | NumberFormatException e10) {
            throw _parseFailure(e10, cArr, i10, i11);
        }
    }

    private static String _getValueDesc(char[] cArr, int i10, int i11) {
        if (i11 <= 1000) {
            return String.format("\"%s\"", new String(cArr, i10, i11));
        }
        return String.format("\"%s\" (truncated to %d chars (from %d))", new String(cArr, i10, 1000), 1000, Integer.valueOf(i11));
    }

    public static BigDecimal parse(char[] cArr) {
        return parse(cArr, 0, cArr.length);
    }
}
