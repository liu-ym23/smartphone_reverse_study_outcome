package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.fasterxml.jackson.core.JsonFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromCharArray extends AbstractFloatValueParser {
    private static final boolean CONDITIONAL_COMPILATION_PARSE_EIGHT_HEX_DIGITS = true;

    private long parseDecFloatLiteral(char[] cArr, int i, int i3, int i10, boolean z10, boolean z11) {
        char c9;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j11;
        boolean z12;
        int i15;
        long j12;
        char cCharAt;
        int iMin = Math.min(i10 - 4, 1073741824);
        int i16 = -1;
        int i17 = i;
        long j13 = 0;
        char c10 = 0;
        boolean z13 = false;
        while (true) {
            c9 = '.';
            j10 = 10;
            if (i17 >= i10) {
                break;
            }
            c10 = cArr[i17];
            char c11 = (char) (c10 - '0');
            if (c11 >= '\n') {
                if (c10 != '.') {
                    break;
                }
                z13 |= i16 >= 0;
                int i18 = i17;
                while (i18 < iMin) {
                    int iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr, i18 + 1);
                    if (iTryToParseFourDigits < 0) {
                        break;
                    }
                    j13 = (j13 * 10000) + iTryToParseFourDigits;
                    i18 += 4;
                }
                int i19 = i17;
                i17 = i18;
                i16 = i19;
            } else {
                j13 = (j13 * 10) + c11;
            }
            i17++;
        }
        if (i16 < 0) {
            i11 = i17 - i;
            i16 = i17;
            i12 = 0;
        } else {
            i11 = (i17 - i) - 1;
            i12 = (i16 - i17) + 1;
        }
        if ((c10 | ' ') == 101) {
            i13 = i17 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr, i13, i10);
            boolean z14 = cCharAt2 == '-';
            if (z14 || cCharAt2 == '+') {
                i13 = i17 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr, i13, i10);
            }
            char c12 = (char) (cCharAt2 - '0');
            boolean z15 = z13 | (c12 >= '\n');
            int i20 = 0;
            while (true) {
                if (i20 < 1024) {
                    i20 = (i20 * 10) + c12;
                }
                i13++;
                cCharAt = AbstractNumberParser.charAt(cArr, i13, i10);
                char c13 = (char) (cCharAt - '0');
                if (c13 >= '\n') {
                    break;
                }
                c12 = c13;
            }
            if (z14) {
                i20 = -i20;
            }
            i12 += i20;
            int i21 = i20;
            c10 = cCharAt;
            i14 = i21;
            z13 = z15;
        } else {
            i13 = i17;
            i14 = 0;
        }
        if ((c10 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i13++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i13, i10);
        if (z13 || iSkipWhitespace < i10 || (!z11 && i11 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 19) {
            int i22 = i;
            int i23 = 0;
            long j14 = 0;
            while (i22 < i17) {
                char c14 = cArr[i22];
                if (c14 != c9) {
                    j12 = j10;
                    if (Long.compareUnsigned(j14, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j14 = ((j14 * j12) + c14) - 48;
                } else {
                    i23++;
                    j12 = j10;
                }
                i22++;
                j10 = j12;
                c9 = '.';
            }
            i15 = i14 + (i16 - i22) + i23;
            j11 = j14;
            z12 = i22 < i17;
        } else {
            j11 = j13;
            z12 = false;
            i15 = 0;
        }
        return valueOfFloatLiteral(cArr, i3, i10, z10, j11, i12, z12, i15);
    }

    private long parseHexFloatLiteral(char[] cArr, int i, int i3, int i10, boolean z10) {
        int i11;
        int iMin;
        char c9;
        boolean z11;
        int i12;
        int i13;
        long j10;
        boolean z12;
        int i14;
        int i15 = -1;
        int i16 = i;
        long j11 = 0;
        char cCharAt = 0;
        boolean z13 = false;
        while (i16 < i10) {
            cCharAt = cArr[i16];
            int iLookupHex = AbstractNumberParser.lookupHex(cCharAt);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z13 |= i15 >= 0;
                int i17 = i16;
                while (i17 < i10 - 8) {
                    long jTryToParseEightHexDigits = tryToParseEightHexDigits(cArr, i17 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j11 = (j11 << 32) + jTryToParseEightHexDigits;
                    i17 += 8;
                }
                int i18 = i16;
                i16 = i17;
                i15 = i18;
            } else {
                j11 = (j11 << 4) | iLookupHex;
            }
            i16++;
        }
        int i19 = 1024;
        if (i15 < 0) {
            i11 = i16 - i;
            i15 = i16;
            iMin = 0;
        } else {
            i11 = (i16 - i) - 1;
            iMin = Math.min((i15 - i16) + 1, 1024) * 4;
        }
        boolean z14 = (cCharAt | ' ') == 112;
        if (z14) {
            i12 = i16 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr, i12, i10);
            c9 = 4;
            boolean z15 = cCharAt2 == '-';
            z11 = true;
            if (z15 || cCharAt2 == '+') {
                i12 = i16 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr, i12, i10);
            }
            char c10 = (char) (cCharAt2 - '0');
            boolean z16 = z13 | (c10 >= '\n');
            int i20 = 0;
            while (true) {
                if (i20 < i19) {
                    i20 = (i20 * 10) + c10;
                }
                i12++;
                cCharAt = AbstractNumberParser.charAt(cArr, i12, i10);
                char c11 = (char) (cCharAt - '0');
                if (c11 >= '\n') {
                    break;
                }
                c10 = c11;
                i19 = 1024;
            }
            if (z15) {
                i20 = -i20;
            }
            iMin += i20;
            i13 = i20;
            z13 = z16;
        } else {
            c9 = 4;
            z11 = true;
            i12 = i16;
            i13 = 0;
        }
        if ((cCharAt | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i12++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i12, i10);
        if (z13 || iSkipWhitespace < i10 || i11 == 0 || !z14) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 16) {
            int i21 = i;
            int i22 = 0;
            long j12 = 0;
            while (i21 < i16) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(cArr[i21]);
                if (iLookupHex2 < 0) {
                    i22++;
                } else {
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = (j12 << c9) | iLookupHex2;
                }
                i21++;
            }
            boolean z17 = i21 < i16 ? z11 : false;
            j10 = j12;
            z12 = z17;
            i14 = i22;
            iSkipWhitespace = i21;
        } else {
            j10 = j11;
            z12 = false;
            i14 = 0;
        }
        return valueOfHexLiteral(cArr, i3, i10, z10, j10, iMin, z12, (((i15 - iSkipWhitespace) + i14) * 4) + i13);
    }

    private long parseNaNOrInfinity(char[] cArr, int i, int i3, boolean z10) {
        char c9 = cArr[i];
        if (c9 == 'N') {
            int i10 = i + 2;
            if (i10 < i3 && cArr[i + 1] == 'a' && cArr[i10] == 'N' && skipWhitespace(cArr, i + 3, i3) == i3) {
                return nan();
            }
        } else {
            int i11 = i + 7;
            if (i11 < i3 && c9 == 'I' && cArr[i + 1] == 'n' && cArr[i + 2] == 'f' && cArr[i + 3] == 'i' && cArr[i + 4] == 'n' && cArr[i + 5] == 'i' && cArr[i + 6] == 't' && cArr[i11] == 'y' && skipWhitespace(cArr, i + 8, i3) == i3) {
                return z10 ? negativeInfinity() : positiveInfinity();
            }
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(char[] cArr, int i, int i3) {
        while (i < i3 && cArr[i] <= ' ') {
            i++;
        }
        return i;
    }

    private long tryToParseEightHexDigits(char[] cArr, int i) {
        return FastDoubleSwar.tryToParseEightHexDigits(cArr, i);
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public long parseFloatingPointLiteral(char[] cArr, int i, int i3) {
        int i10;
        int iCheckBounds = AbstractNumberParser.checkBounds(cArr.length, i, i3);
        int iSkipWhitespace = skipWhitespace(cArr, i, iCheckBounds);
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
            int i11 = iSkipWhitespace + 1;
            if ((AbstractNumberParser.charAt(cArr, i11, iCheckBounds) | ' ') == 120) {
                return parseHexFloatLiteral(cArr, iSkipWhitespace + 2, i, iCheckBounds, z10);
            }
            i10 = i11;
        } else {
            i10 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(cArr, i10, i, iCheckBounds, z10, z11);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(char[] cArr, int i, int i3, boolean z10, long j10, int i10, boolean z11, int i11);

    public abstract long valueOfHexLiteral(char[] cArr, int i, int i3, boolean z10, long j10, int i10, boolean z11, int i11);
}
