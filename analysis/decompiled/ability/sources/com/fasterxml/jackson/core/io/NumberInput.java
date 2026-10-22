package com.fasterxml.jackson.core.io;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaDoubleParser;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaFloatParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;

    @Deprecated
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
    private static final Pattern PATTERN_FLOAT = Pattern.compile("[+-]?[0-9]*[\\.]?[0-9]+([eE][+-]?[0-9]+)?");
    private static final Pattern PATTERN_FLOAT_TRAILING_DOT = Pattern.compile("[+-]?[0-9]+[\\.]");

    public static boolean inLongRange(char[] cArr, int i, int i6, boolean z10) {
        String str = z10 ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i6 < length) {
            return true;
        }
        if (i6 > length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            int iCharAt = cArr[i + i10] - str.charAt(i10);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static boolean looksLikeValidNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.length() != 1) {
            return PATTERN_FLOAT.matcher(str).matches() || PATTERN_FLOAT_TRAILING_DOT.matcher(str).matches();
        }
        char cCharAt = str.charAt(0);
        return cCharAt <= '9' && cCharAt >= '0';
    }

    public static double parseAsDouble(String str, double d) {
        return parseAsDouble(str, d, false);
    }

    public static int parseAsInt(String str, int i) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i;
        }
        int i6 = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i6 = 1;
        }
        while (i6 < length) {
            char cCharAt2 = strTrim.charAt(i6);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) parseDouble(strTrim, true);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            i6++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }

    public static long parseAsLong(String str, long j5) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j5;
        }
        int i = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i = 1;
        }
        while (i < length) {
            char cCharAt2 = strTrim.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (long) parseDouble(strTrim, true);
                } catch (NumberFormatException unused) {
                    return j5;
                }
            }
            i++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j5;
        }
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        return parseBigDecimal(str, false);
    }

    @Deprecated
    public static BigInteger parseBigInteger(String str) throws NumberFormatException {
        return parseBigInteger(str, false);
    }

    public static BigInteger parseBigIntegerWithRadix(String str, int i, boolean z10) throws NumberFormatException {
        return z10 ? BigIntegerParser.parseWithFastParser(str, i) : new BigInteger(str, i);
    }

    @Deprecated
    public static double parseDouble(String str) throws NumberFormatException {
        return parseDouble(str, false);
    }

    @Deprecated
    public static float parseFloat(String str) throws NumberFormatException {
        return parseFloat(str, false);
    }

    public static int parseInt(char[] cArr, int i, int i6) {
        if (i6 > 0 && cArr[i] == '+') {
            i++;
            i6--;
        }
        int i10 = cArr[(i + i6) - 1] - '0';
        switch (i6) {
            case 9:
                i10 += (cArr[i] - '0') * 100000000;
                i++;
            case 8:
                i10 += (cArr[i] - '0') * 10000000;
                i++;
            case 7:
                i10 += (cArr[i] - '0') * 1000000;
                i++;
            case 6:
                i10 += (cArr[i] - '0') * AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
                i++;
            case 5:
                i10 += (cArr[i] - '0') * 10000;
                i++;
            case 4:
                i10 += (cArr[i] - '0') * 1000;
                i++;
            case 3:
                i10 += (cArr[i] - '0') * 100;
                i++;
            case 2:
                return ((cArr[i] - '0') * 10) + i10;
            default:
                return i10;
        }
    }

    public static long parseLong(char[] cArr, int i, int i6) {
        int i10 = i6 - 9;
        return (parseInt(cArr, i, i10) * L_BILLION) + parseInt(cArr, i + i10, 9);
    }

    public static long parseLong19(char[] cArr, int i, boolean z10) {
        long j5 = 0;
        for (int i6 = 0; i6 < 19; i6++) {
            j5 = (j5 * 10) + (cArr[i + i6] - '0');
        }
        return z10 ? -j5 : j5;
    }

    public static double parseAsDouble(String str, double d, boolean z10) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                try {
                    return parseDouble(strTrim, z10);
                } catch (NumberFormatException unused) {
                    return d;
                }
            }
        }
        return d;
    }

    public static BigDecimal parseBigDecimal(String str, boolean z10) throws NumberFormatException {
        return z10 ? BigDecimalParser.parseWithFastParser(str) : BigDecimalParser.parse(str);
    }

    public static BigInteger parseBigInteger(String str, boolean z10) throws NumberFormatException {
        return z10 ? BigIntegerParser.parseWithFastParser(str) : new BigInteger(str);
    }

    public static double parseDouble(String str, boolean z10) throws NumberFormatException {
        return z10 ? JavaDoubleParser.parseDouble(str) : Double.parseDouble(str);
    }

    public static float parseFloat(String str, boolean z10) throws NumberFormatException {
        return z10 ? JavaFloatParser.parseFloat(str) : Float.parseFloat(str);
    }

    public static double parseDouble(char[] cArr, boolean z10) throws NumberFormatException {
        return parseDouble(cArr, 0, cArr.length, z10);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z10) {
        String str2 = z10 ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i6) throws NumberFormatException {
        return BigDecimalParser.parse(cArr, i, i6);
    }

    public static double parseDouble(char[] cArr, int i, int i6, boolean z10) throws NumberFormatException {
        if (z10) {
            return JavaDoubleParser.parseDouble(cArr, i, i6);
        }
        return Double.parseDouble(new String(cArr, i, i6));
    }

    public static float parseFloat(char[] cArr, boolean z10) throws NumberFormatException {
        return parseFloat(cArr, 0, cArr.length, z10);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i6, boolean z10) throws NumberFormatException {
        if (z10) {
            return BigDecimalParser.parseWithFastParser(cArr, i, i6);
        }
        return BigDecimalParser.parse(cArr, i, i6);
    }

    public static float parseFloat(char[] cArr, int i, int i6, boolean z10) throws NumberFormatException {
        if (z10) {
            return JavaFloatParser.parseFloat(cArr, i, i6);
        }
        return Float.parseFloat(new String(cArr, i, i6));
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return BigDecimalParser.parse(cArr);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, boolean z10) throws NumberFormatException {
        if (z10) {
            return BigDecimalParser.parseWithFastParser(cArr, 0, cArr.length);
        }
        return BigDecimalParser.parse(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        return java.lang.Integer.parseInt(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int parseInt(java.lang.String r10) {
        /*
            r0 = 0
            char r1 = r10.charAt(r0)
            int r2 = r10.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = r4
        Lf:
            r3 = 2
            r5 = 10
            if (r0 == 0) goto L24
            if (r2 == r4) goto L1f
            if (r2 <= r5) goto L19
            goto L1f
        L19:
            char r1 = r10.charAt(r4)
            r4 = r3
            goto L2d
        L1f:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L24:
            r6 = 9
            if (r2 <= r6) goto L2d
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L2d:
            r6 = 57
            if (r1 > r6) goto L82
            r7 = 48
            if (r1 >= r7) goto L36
            goto L82
        L36:
            int r1 = r1 - r7
            if (r4 >= r2) goto L7d
            int r8 = r4 + 1
            char r9 = r10.charAt(r4)
            if (r9 > r6) goto L78
            if (r9 >= r7) goto L44
            goto L78
        L44:
            int r1 = r1 * 10
            int r9 = r9 - r7
            int r1 = r1 + r9
            if (r8 >= r2) goto L7d
            int r4 = r4 + r3
            char r3 = r10.charAt(r8)
            if (r3 > r6) goto L73
            if (r3 >= r7) goto L54
            goto L73
        L54:
            int r1 = r1 * 10
            int r3 = r3 - r7
            int r1 = r1 + r3
            if (r4 >= r2) goto L7d
        L5a:
            int r3 = r4 + 1
            char r4 = r10.charAt(r4)
            if (r4 > r6) goto L6e
            if (r4 >= r7) goto L65
            goto L6e
        L65:
            int r1 = r1 * r5
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r3 < r2) goto L6c
            goto L7d
        L6c:
            r4 = r3
            goto L5a
        L6e:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L73:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L78:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L7d:
            if (r0 == 0) goto L81
            int r10 = -r1
            return r10
        L81:
            return r1
        L82:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }
}
