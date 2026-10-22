package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.fasterxml.jackson.core.JsonFactory;

/* loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromCharSequence extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(CharSequence charSequence, int i10, int i11, int i12, boolean z10, boolean z11) {
        char c10;
        long j10;
        int i13;
        int i14;
        int i15;
        int i16;
        long j11;
        boolean z12;
        int i17;
        AbstractJavaFloatingPointBitsFromCharSequence abstractJavaFloatingPointBitsFromCharSequence;
        int i18;
        boolean z13;
        int i19;
        long j12;
        char cCharAt;
        int i20 = -1;
        int i21 = i10;
        long j13 = 0;
        char cCharAt2 = 0;
        boolean z14 = false;
        while (true) {
            c10 = '.';
            j10 = 10;
            if (i21 >= i12) {
                break;
            }
            cCharAt2 = charSequence.charAt(i21);
            char c11 = (char) (cCharAt2 - '0');
            if (c11 >= '\n') {
                if (cCharAt2 != '.') {
                    break;
                }
                z14 |= i20 >= 0;
                i20 = i21;
            } else {
                j13 = (j13 * 10) + c11;
            }
            i21++;
        }
        if (i20 < 0) {
            i13 = i21 - i10;
            i20 = i21;
            i14 = 0;
        } else {
            i13 = (i21 - i10) - 1;
            i14 = (i20 - i21) + 1;
        }
        if ((cCharAt2 | ' ') == 101) {
            i15 = i21 + 1;
            char cCharAt3 = AbstractNumberParser.charAt(charSequence, i15, i12);
            boolean z15 = cCharAt3 == '-';
            if (z15 || cCharAt3 == '+') {
                i15 = i21 + 2;
                cCharAt3 = AbstractNumberParser.charAt(charSequence, i15, i12);
            }
            char c12 = (char) (cCharAt3 - '0');
            boolean z16 = z14 | (c12 >= '\n');
            int i22 = 0;
            while (true) {
                if (i22 < 1024) {
                    i22 = (i22 * 10) + c12;
                }
                i15++;
                cCharAt = AbstractNumberParser.charAt(charSequence, i15, i12);
                char c13 = (char) (cCharAt - '0');
                if (c13 >= '\n') {
                    break;
                }
                c12 = c13;
            }
            if (z15) {
                i22 = -i22;
            }
            i14 += i22;
            int i23 = i22;
            cCharAt2 = cCharAt;
            i16 = i23;
            z14 = z16;
        } else {
            i15 = i21;
            i16 = 0;
        }
        if ((cCharAt2 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i15++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i15, i12);
        if (z14 || iSkipWhitespace < i12 || (!z11 && i13 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i13 > 19) {
            int i24 = i10;
            int i25 = 0;
            long j14 = 0;
            while (i24 < i21) {
                char cCharAt4 = charSequence.charAt(i24);
                if (cCharAt4 != c10) {
                    j12 = j10;
                    if (Long.compareUnsigned(j14, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j14 = ((j14 * j12) + cCharAt4) - 48;
                } else {
                    i25++;
                    j12 = j10;
                }
                i24++;
                j10 = j12;
                c10 = '.';
            }
            i17 = (i20 - i24) + i25 + i16;
            j11 = j14;
            z12 = i24 < i21;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            z13 = z10;
            i19 = i14;
            i18 = i11;
        } else {
            j11 = j13;
            z12 = false;
            i17 = 0;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            i18 = i11;
            z13 = z10;
            i19 = i14;
        }
        return abstractJavaFloatingPointBitsFromCharSequence.valueOfFloatLiteral(charSequence, i18, i12, z13, j11, i19, z12, i17);
    }

    private long parseHexFloatLiteral(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
        char c10;
        int i13;
        int iMin;
        char c11;
        int i14;
        int i15;
        int i16;
        long j10;
        int i17;
        boolean z11;
        char cCharAt;
        int i18 = -1;
        int i19 = i10;
        long j11 = 0;
        char cCharAt2 = 0;
        boolean z12 = false;
        while (true) {
            c10 = 4;
            if (i19 >= i12) {
                break;
            }
            cCharAt2 = charSequence.charAt(i19);
            int iLookupHex = AbstractNumberParser.lookupHex(cCharAt2);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z12 |= i18 >= 0;
                int i20 = i19;
                while (i20 < i12 - 8) {
                    long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, i20 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j11 = (j11 << 32) + jTryToParseEightHexDigits;
                    i20 += 8;
                }
                int i21 = i19;
                i19 = i20;
                i18 = i21;
            } else {
                j11 = (j11 << 4) | iLookupHex;
            }
            i19++;
        }
        if (i18 < 0) {
            i13 = i19 - i10;
            i18 = i19;
            iMin = 0;
        } else {
            i13 = (i19 - i10) - 1;
            iMin = Math.min((i18 - i19) + 1, 1024) * 4;
        }
        boolean z13 = (cCharAt2 | ' ') == 112;
        if (z13) {
            i14 = i19 + 1;
            char cCharAt3 = AbstractNumberParser.charAt(charSequence, i14, i12);
            boolean z14 = cCharAt3 == '-';
            if (z14 || cCharAt3 == '+') {
                i14 = i19 + 2;
                cCharAt3 = AbstractNumberParser.charAt(charSequence, i14, i12);
            }
            char c12 = (char) (cCharAt3 - '0');
            boolean z15 = z12 | (c12 >= '\n');
            int i22 = 0;
            while (true) {
                if (i22 < 1024) {
                    i22 = (i22 * 10) + c12;
                }
                i14++;
                cCharAt = AbstractNumberParser.charAt(charSequence, i14, i12);
                c11 = c10;
                char c13 = (char) (cCharAt - '0');
                if (c13 >= '\n') {
                    break;
                }
                c12 = c13;
                c10 = c11;
            }
            if (z14) {
                i22 = -i22;
            }
            iMin += i22;
            cCharAt2 = cCharAt;
            i15 = i22;
            z12 = z15;
        } else {
            c11 = 4;
            i14 = i19;
            i15 = 0;
        }
        if ((cCharAt2 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i14++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i14, i12);
        if (z12 || iSkipWhitespace < i12 || i13 == 0 || !z13) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i13 > 16) {
            int i23 = i10;
            int i24 = 0;
            long j12 = 0;
            while (i23 < i19) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(charSequence.charAt(i23));
                if (iLookupHex2 < 0) {
                    i24++;
                } else {
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = (j12 << c11) | iLookupHex2;
                }
                i23++;
            }
            boolean z16 = i23 < i19;
            int i25 = i24;
            iSkipWhitespace = i23;
            i17 = i25;
            i16 = i15;
            j10 = j12;
            z11 = z16;
        } else {
            i16 = i15;
            j10 = j11;
            i17 = 0;
            z11 = false;
        }
        return valueOfHexLiteral(charSequence, i11, i12, z10, j10, iMin, z11, (((i18 - iSkipWhitespace) + i17) * 4) + i16);
    }

    private long parseNaNOrInfinity(CharSequence charSequence, int i10, int i11, boolean z10) {
        if (charSequence.charAt(i10) == 'N') {
            int i12 = i10 + 2;
            if (i12 < i11 && charSequence.charAt(i10 + 1) == 'a' && charSequence.charAt(i12) == 'N' && skipWhitespace(charSequence, i10 + 3, i11) == i11) {
                return nan();
            }
        } else {
            int i13 = i10 + 7;
            if (i13 < i11 && charSequence.charAt(i10) == 'I' && charSequence.charAt(i10 + 1) == 'n' && charSequence.charAt(i10 + 2) == 'f' && charSequence.charAt(i10 + 3) == 'i' && charSequence.charAt(i10 + 4) == 'n' && charSequence.charAt(i10 + 5) == 'i' && charSequence.charAt(i10 + 6) == 't' && charSequence.charAt(i13) == 'y' && skipWhitespace(charSequence, i10 + 8, i11) == i11) {
                return z10 ? negativeInfinity() : positiveInfinity();
            }
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11 && charSequence.charAt(i10) <= ' ') {
            i10++;
        }
        return i10;
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public final long parseFloatingPointLiteral(CharSequence charSequence, int i10, int i11) {
        int i12;
        int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i10, i11);
        int iSkipWhitespace = skipWhitespace(charSequence, i10, iCheckBounds);
        if (iSkipWhitespace == iCheckBounds) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        char cCharAt = charSequence.charAt(iSkipWhitespace);
        boolean z10 = cCharAt == '-';
        if ((z10 || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(charSequence, (iSkipWhitespace = iSkipWhitespace + 1), iCheckBounds)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (cCharAt >= 'I') {
            return parseNaNOrInfinity(charSequence, iSkipWhitespace, iCheckBounds, z10);
        }
        boolean z11 = cCharAt == '0';
        if (z11) {
            int i13 = iSkipWhitespace + 1;
            if ((AbstractNumberParser.charAt(charSequence, i13, iCheckBounds) | ' ') == 120) {
                return parseHexFloatLiteral(charSequence, iSkipWhitespace + 2, i10, iCheckBounds, z10);
            }
            i12 = i13;
        } else {
            i12 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(charSequence, i12, i10, iCheckBounds, z10, z11);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(CharSequence charSequence, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13);

    public abstract long valueOfHexLiteral(CharSequence charSequence, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13);
}
