package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaDoubleParser;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaFloatParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;

    @Deprecated
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
    private static final Pattern PATTERN_FLOAT = Pattern.compile("[+-]?[0-9]*[\\.]?[0-9]+([eE][+-]?[0-9]+)?");
    private static final Pattern PATTERN_FLOAT_TRAILING_DOT = Pattern.compile("[+-]?[0-9]+[\\.]");

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

    public static double parseAsDouble(String str, double d7, boolean z10) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                try {
                    return parseDouble(strTrim, z10);
                } catch (NumberFormatException unused) {
                    return d7;
                }
            }
        }
        return d7;
    }

    public static int parseAsInt(String str, int i) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i;
        }
        int i3 = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i3 = 1;
        }
        while (i3 < length) {
            char cCharAt2 = strTrim.charAt(i3);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) parseDouble(strTrim, true);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            i3++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }

    public static long parseAsLong(String str, long j10) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j10;
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
                    return j10;
                }
            }
            i++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j10;
        }
    }

    public static BigDecimal parseBigDecimal(char[] cArr, boolean z10) {
        return z10 ? BigDecimalParser.parseWithFastParser(cArr, 0, cArr.length) : BigDecimalParser.parse(cArr);
    }

    public static BigInteger parseBigInteger(String str, boolean z10) {
        return z10 ? BigIntegerParser.parseWithFastParser(str) : new BigInteger(str);
    }

    public static BigInteger parseBigIntegerWithRadix(String str, int i, boolean z10) {
        return z10 ? BigIntegerParser.parseWithFastParser(str, i) : new BigInteger(str, i);
    }

    public static double parseDouble(char[] cArr, int i, int i3, boolean z10) {
        return z10 ? JavaDoubleParser.parseDouble(cArr, i, i3) : Double.parseDouble(new String(cArr, i, i3));
    }

    public static float parseFloat(char[] cArr, int i, int i3, boolean z10) {
        return z10 ? JavaFloatParser.parseFloat(cArr, i, i3) : Float.parseFloat(new String(cArr, i, i3));
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

    public static long parseLong(char[] cArr, int i, int i3) {
        int i10 = i3 - 9;
        return (parseInt(cArr, i, i10) * L_BILLION) + parseInt(cArr, i + i10, 9);
    }

    public static long parseLong19(char[] cArr, int i, boolean z10) {
        long j10 = 0;
        for (int i3 = 0; i3 < 19; i3++) {
            j10 = (j10 * 10) + (cArr[i + i3] - '0');
        }
        return z10 ? -j10 : j10;
    }

    @Deprecated
    public static BigInteger parseBigInteger(String str) {
        return parseBigInteger(str, false);
    }

    public static BigDecimal parseBigDecimal(String str, boolean z10) {
        if (z10) {
            return BigDecimalParser.parseWithFastParser(str);
        }
        return BigDecimalParser.parse(str);
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i3) {
        return BigDecimalParser.parse(cArr, i, i3);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i3, boolean z10) {
        if (z10) {
            return BigDecimalParser.parseWithFastParser(cArr, i, i3);
        }
        return BigDecimalParser.parse(cArr, i, i3);
    }

    public static double parseDouble(String str, boolean z10) {
        return z10 ? JavaDoubleParser.parseDouble(str) : Double.parseDouble(str);
    }

    public static float parseFloat(String str, boolean z10) {
        if (z10) {
            return JavaFloatParser.parseFloat(str);
        }
        return Float.parseFloat(str);
    }

    public static double parseDouble(char[] cArr, boolean z10) {
        return parseDouble(cArr, 0, cArr.length, z10);
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(char[] cArr) {
        return BigDecimalParser.parse(cArr);
    }

    @Deprecated
    public static double parseDouble(String str) {
        return parseDouble(str, false);
    }

    public static float parseFloat(char[] cArr, boolean z10) {
        return parseFloat(cArr, 0, cArr.length, z10);
    }

    public static double parseAsDouble(String str, double d7) {
        return parseAsDouble(str, d7, false);
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(String str) {
        return parseBigDecimal(str, false);
    }

    @Deprecated
    public static float parseFloat(String str) {
        return parseFloat(str, false);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(char[] cArr, int i, int i3, boolean z10) {
        String str = z10 ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i3 < length) {
            return true;
        }
        if (i3 > length) {
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

    public static int parseInt(char[] cArr, int i, int i3) {
        if (i3 > 0 && cArr[i] == '+') {
            i++;
            i3--;
        }
        int i10 = cArr[(i + i3) - 1] - '0';
        switch (i3) {
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
                i10 += (cArr[i] - '0') * 100000;
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
}
