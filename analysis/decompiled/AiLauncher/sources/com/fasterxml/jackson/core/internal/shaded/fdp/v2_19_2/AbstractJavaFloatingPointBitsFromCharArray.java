package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.fasterxml.jackson.core.JsonFactory;

/* loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromCharArray extends AbstractFloatValueParser {
    private static final boolean CONDITIONAL_COMPILATION_PARSE_EIGHT_HEX_DIGITS = true;

    private long parseDecFloatLiteral(char[] cArr, int i10, int i11, int i12, boolean z10, boolean z11) {
        char c10;
        long j10;
        int i13;
        int i14;
        int i15;
        int i16;
        long j11;
        boolean z12;
        int i17;
        long j12;
        char cCharAt;
        int iMin = Math.min(i12 - 4, 1073741824);
        int i18 = -1;
        int i19 = i10;
        long j13 = 0;
        char c11 = 0;
        boolean z13 = false;
        while (true) {
            c10 = '.';
            j10 = 10;
            if (i19 >= i12) {
                break;
            }
            c11 = cArr[i19];
            char c12 = (char) (c11 - '0');
            if (c12 >= '\n') {
                if (c11 != '.') {
                    break;
                }
                z13 |= i18 >= 0;
                int i20 = i19;
                while (i20 < iMin) {
                    int iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr, i20 + 1);
                    if (iTryToParseFourDigits < 0) {
                        break;
                    }
                    j13 = (j13 * 10000) + iTryToParseFourDigits;
                    i20 += 4;
                }
                int i21 = i19;
                i19 = i20;
                i18 = i21;
            } else {
                j13 = (j13 * 10) + c12;
            }
            i19++;
        }
        if (i18 < 0) {
            i13 = i19 - i10;
            i18 = i19;
            i14 = 0;
        } else {
            i13 = (i19 - i10) - 1;
            i14 = (i18 - i19) + 1;
        }
        if ((c11 | ' ') == 101) {
            i15 = i19 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr, i15, i12);
            boolean z14 = cCharAt2 == '-';
            if (z14 || cCharAt2 == '+') {
                i15 = i19 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr, i15, i12);
            }
            char c13 = (char) (cCharAt2 - '0');
            boolean z15 = z13 | (c13 >= '\n');
            int i22 = 0;
            while (true) {
                if (i22 < 1024) {
                    i22 = (i22 * 10) + c13;
                }
                i15++;
                cCharAt = AbstractNumberParser.charAt(cArr, i15, i12);
                char c14 = (char) (cCharAt - '0');
                if (c14 >= '\n') {
                    break;
                }
                c13 = c14;
            }
            if (z14) {
                i22 = -i22;
            }
            i14 += i22;
            int i23 = i22;
            c11 = cCharAt;
            i16 = i23;
            z13 = z15;
        } else {
            i15 = i19;
            i16 = 0;
        }
        if ((c11 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i15++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i15, i12);
        if (z13 || iSkipWhitespace < i12 || (!z11 && i13 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i13 > 19) {
            int i24 = i10;
            int i25 = 0;
            long j14 = 0;
            while (i24 < i19) {
                char c15 = cArr[i24];
                if (c15 != c10) {
                    j12 = j10;
                    if (Long.compareUnsigned(j14, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j14 = ((j14 * j12) + c15) - 48;
                } else {
                    i25++;
                    j12 = j10;
                }
                i24++;
                j10 = j12;
                c10 = '.';
            }
            i17 = i16 + (i18 - i24) + i25;
            j11 = j14;
            z12 = i24 < i19;
        } else {
            j11 = j13;
            z12 = false;
            i17 = 0;
        }
        return valueOfFloatLiteral(cArr, i11, i12, z10, j11, i14, z12, i17);
    }

    private long parseHexFloatLiteral(char[] cArr, int i10, int i11, int i12, boolean z10) {
        int i13;
        int iMin;
        char c10;
        boolean z11;
        int i14;
        int i15;
        long j10;
        boolean z12;
        int i16;
        int i17 = -1;
        int i18 = i10;
        long j11 = 0;
        char cCharAt = 0;
        boolean z13 = false;
        while (i18 < i12) {
            cCharAt = cArr[i18];
            int iLookupHex = AbstractNumberParser.lookupHex(cCharAt);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z13 |= i17 >= 0;
                int i19 = i18;
                while (i19 < i12 - 8) {
                    long jTryToParseEightHexDigits = tryToParseEightHexDigits(cArr, i19 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j11 = (j11 << 32) + jTryToParseEightHexDigits;
                    i19 += 8;
                }
                int i20 = i18;
                i18 = i19;
                i17 = i20;
            } else {
                j11 = (j11 << 4) | iLookupHex;
            }
            i18++;
        }
        int i21 = 1024;
        if (i17 < 0) {
            i13 = i18 - i10;
            i17 = i18;
            iMin = 0;
        } else {
            i13 = (i18 - i10) - 1;
            iMin = Math.min((i17 - i18) + 1, 1024) * 4;
        }
        boolean z14 = (cCharAt | ' ') == 112;
        if (z14) {
            i14 = i18 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr, i14, i12);
            c10 = 4;
            boolean z15 = cCharAt2 == '-';
            z11 = true;
            if (z15 || cCharAt2 == '+') {
                i14 = i18 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr, i14, i12);
            }
            char c11 = (char) (cCharAt2 - '0');
            boolean z16 = z13 | (c11 >= '\n');
            int i22 = 0;
            while (true) {
                if (i22 < i21) {
                    i22 = (i22 * 10) + c11;
                }
                i14++;
                cCharAt = AbstractNumberParser.charAt(cArr, i14, i12);
                char c12 = (char) (cCharAt - '0');
                if (c12 >= '\n') {
                    break;
                }
                c11 = c12;
                i21 = 1024;
            }
            if (z15) {
                i22 = -i22;
            }
            iMin += i22;
            i15 = i22;
            z13 = z16;
        } else {
            c10 = 4;
            z11 = true;
            i14 = i18;
            i15 = 0;
        }
        if ((cCharAt | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i14++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i14, i12);
        if (z13 || iSkipWhitespace < i12 || i13 == 0 || !z14) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i13 > 16) {
            int i23 = i10;
            int i24 = 0;
            long j12 = 0;
            while (i23 < i18) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(cArr[i23]);
                if (iLookupHex2 < 0) {
                    i24++;
                } else {
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = (j12 << c10) | iLookupHex2;
                }
                i23++;
            }
            boolean z17 = i23 < i18 ? z11 : false;
            j10 = j12;
            z12 = z17;
            i16 = i24;
            iSkipWhitespace = i23;
        } else {
            j10 = j11;
            z12 = false;
            i16 = 0;
        }
        return valueOfHexLiteral(cArr, i11, i12, z10, j10, iMin, z12, (((i17 - iSkipWhitespace) + i16) * 4) + i15);
    }

    private long parseNaNOrInfinity(char[] cArr, int i10, int i11, boolean z10) {
        char c10 = cArr[i10];
        if (c10 == 'N') {
            int i12 = i10 + 2;
            if (i12 < i11 && cArr[i10 + 1] == 'a' && cArr[i12] == 'N' && skipWhitespace(cArr, i10 + 3, i11) == i11) {
                return nan();
            }
        } else {
            int i13 = i10 + 7;
            if (i13 < i11 && c10 == 'I' && cArr[i10 + 1] == 'n' && cArr[i10 + 2] == 'f' && cArr[i10 + 3] == 'i' && cArr[i10 + 4] == 'n' && cArr[i10 + 5] == 'i' && cArr[i10 + 6] == 't' && cArr[i13] == 'y' && skipWhitespace(cArr, i10 + 8, i11) == i11) {
                return z10 ? negativeInfinity() : positiveInfinity();
            }
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(char[] cArr, int i10, int i11) {
        while (i10 < i11 && cArr[i10] <= ' ') {
            i10++;
        }
        return i10;
    }

    private long tryToParseEightHexDigits(char[] cArr, int i10) {
        return FastDoubleSwar.tryToParseEightHexDigits(cArr, i10);
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public long parseFloatingPointLiteral(char[] cArr, int i10, int i11) {
        int i12;
        int iCheckBounds = AbstractNumberParser.checkBounds(cArr.length, i10, i11);
        int iSkipWhitespace = skipWhitespace(cArr, i10, iCheckBounds);
        if (iSkipWhitespace == iCheckBounds) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        char cCharAt = cArr[iSkipWhitespace];
        boolean z10 = cCharAt == '-';
        if ((z10 || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(cArr, (iSkipWhitespace = iSkipWhitespace + 1), iCheckBounds)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (cCharAt >= 'I') {
            return parseNaNOrInfinity(cArr, iSkipWhitespace, iCheckBounds, z10);
        }
        boolean z11 = cCharAt == '0';
        if (z11) {
            int i13 = iSkipWhitespace + 1;
            if ((AbstractNumberParser.charAt(cArr, i13, iCheckBounds) | ' ') == 120) {
                return parseHexFloatLiteral(cArr, iSkipWhitespace + 2, i10, iCheckBounds, z10);
            }
            i12 = i13;
        } else {
            i12 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(cArr, i12, i10, iCheckBounds, z10, z11);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(char[] cArr, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13);

    public abstract long valueOfHexLiteral(char[] cArr, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13);
}
