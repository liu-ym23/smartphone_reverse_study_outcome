package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.fasterxml.jackson.core.JsonFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromCharSequence extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(CharSequence charSequence, int i, int i3, int i10, boolean z10, boolean z11) {
        char c9;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j11;
        boolean z12;
        int i15;
        AbstractJavaFloatingPointBitsFromCharSequence abstractJavaFloatingPointBitsFromCharSequence;
        int i16;
        boolean z13;
        int i17;
        long j12;
        char cCharAt;
        int i18 = -1;
        int i19 = i;
        long j13 = 0;
        char cCharAt2 = 0;
        boolean z14 = false;
        while (true) {
            c9 = '.';
            j10 = 10;
            if (i19 >= i10) {
                break;
            }
            cCharAt2 = charSequence.charAt(i19);
            char c10 = (char) (cCharAt2 - '0');
            if (c10 >= '\n') {
                if (cCharAt2 != '.') {
                    break;
                }
                z14 |= i18 >= 0;
                i18 = i19;
            } else {
                j13 = (j13 * 10) + c10;
            }
            i19++;
        }
        if (i18 < 0) {
            i11 = i19 - i;
            i18 = i19;
            i12 = 0;
        } else {
            i11 = (i19 - i) - 1;
            i12 = (i18 - i19) + 1;
        }
        if ((cCharAt2 | ' ') == 101) {
            i13 = i19 + 1;
            char cCharAt3 = AbstractNumberParser.charAt(charSequence, i13, i10);
            boolean z15 = cCharAt3 == '-';
            if (z15 || cCharAt3 == '+') {
                i13 = i19 + 2;
                cCharAt3 = AbstractNumberParser.charAt(charSequence, i13, i10);
            }
            char c11 = (char) (cCharAt3 - '0');
            boolean z16 = z14 | (c11 >= '\n');
            int i20 = 0;
            while (true) {
                if (i20 < 1024) {
                    i20 = (i20 * 10) + c11;
                }
                i13++;
                cCharAt = AbstractNumberParser.charAt(charSequence, i13, i10);
                char c12 = (char) (cCharAt - '0');
                if (c12 >= '\n') {
                    break;
                }
                c11 = c12;
            }
            if (z15) {
                i20 = -i20;
            }
            i12 += i20;
            int i21 = i20;
            cCharAt2 = cCharAt;
            i14 = i21;
            z14 = z16;
        } else {
            i13 = i19;
            i14 = 0;
        }
        if ((cCharAt2 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i13++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i13, i10);
        if (z14 || iSkipWhitespace < i10 || (!z11 && i11 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 19) {
            int i22 = i;
            int i23 = 0;
            long j14 = 0;
            while (i22 < i19) {
                char cCharAt4 = charSequence.charAt(i22);
                if (cCharAt4 != c9) {
                    j12 = j10;
                    if (Long.compareUnsigned(j14, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j14 = ((j14 * j12) + cCharAt4) - 48;
                } else {
                    i23++;
                    j12 = j10;
                }
                i22++;
                j10 = j12;
                c9 = '.';
            }
            i15 = (i18 - i22) + i23 + i14;
            j11 = j14;
            z12 = i22 < i19;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            z13 = z10;
            i17 = i12;
            i16 = i3;
        } else {
            j11 = j13;
            z12 = false;
            i15 = 0;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            i16 = i3;
            z13 = z10;
            i17 = i12;
        }
        return abstractJavaFloatingPointBitsFromCharSequence.valueOfFloatLiteral(charSequence, i16, i10, z13, j11, i17, z12, i15);
    }

    private long parseHexFloatLiteral(CharSequence charSequence, int i, int i3, int i10, boolean z10) {
        char c9;
        int i11;
        int iMin;
        char c10;
        int i12;
        int i13;
        int i14;
        long j10;
        int i15;
        boolean z11;
        char cCharAt;
        int i16 = -1;
        int i17 = i;
        long j11 = 0;
        char cCharAt2 = 0;
        boolean z12 = false;
        while (true) {
            c9 = 4;
            if (i17 >= i10) {
                break;
            }
            cCharAt2 = charSequence.charAt(i17);
            int iLookupHex = AbstractNumberParser.lookupHex(cCharAt2);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z12 |= i16 >= 0;
                int i18 = i17;
                while (i18 < i10 - 8) {
                    long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, i18 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j11 = (j11 << 32) + jTryToParseEightHexDigits;
                    i18 += 8;
                }
                int i19 = i17;
                i17 = i18;
                i16 = i19;
            } else {
                j11 = (j11 << 4) | iLookupHex;
            }
            i17++;
        }
        if (i16 < 0) {
            i11 = i17 - i;
            i16 = i17;
            iMin = 0;
        } else {
            i11 = (i17 - i) - 1;
            iMin = Math.min((i16 - i17) + 1, 1024) * 4;
        }
        boolean z13 = (cCharAt2 | ' ') == 112;
        if (z13) {
            i12 = i17 + 1;
            char cCharAt3 = AbstractNumberParser.charAt(charSequence, i12, i10);
            boolean z14 = cCharAt3 == '-';
            if (z14 || cCharAt3 == '+') {
                i12 = i17 + 2;
                cCharAt3 = AbstractNumberParser.charAt(charSequence, i12, i10);
            }
            char c11 = (char) (cCharAt3 - '0');
            boolean z15 = z12 | (c11 >= '\n');
            int i20 = 0;
            while (true) {
                if (i20 < 1024) {
                    i20 = (i20 * 10) + c11;
                }
                i12++;
                cCharAt = AbstractNumberParser.charAt(charSequence, i12, i10);
                c10 = c9;
                char c12 = (char) (cCharAt - '0');
                if (c12 >= '\n') {
                    break;
                }
                c11 = c12;
                c9 = c10;
            }
            if (z14) {
                i20 = -i20;
            }
            iMin += i20;
            cCharAt2 = cCharAt;
            i13 = i20;
            z12 = z15;
        } else {
            c10 = 4;
            i12 = i17;
            i13 = 0;
        }
        if ((cCharAt2 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i12++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i12, i10);
        if (z12 || iSkipWhitespace < i10 || i11 == 0 || !z13) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 16) {
            int i21 = i;
            int i22 = 0;
            long j12 = 0;
            while (i21 < i17) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(charSequence.charAt(i21));
                if (iLookupHex2 < 0) {
                    i22++;
                } else {
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = (j12 << c10) | iLookupHex2;
                }
                i21++;
            }
            boolean z16 = i21 < i17;
            int i23 = i22;
            iSkipWhitespace = i21;
            i15 = i23;
            i14 = i13;
            j10 = j12;
            z11 = z16;
        } else {
            i14 = i13;
            j10 = j11;
            i15 = 0;
            z11 = false;
        }
        return valueOfHexLiteral(charSequence, i3, i10, z10, j10, iMin, z11, (((i16 - iSkipWhitespace) + i15) * 4) + i14);
    }

    private long parseNaNOrInfinity(CharSequence charSequence, int i, int i3, boolean z10) {
        if (charSequence.charAt(i) == 'N') {
            int i10 = i + 2;
            if (i10 < i3 && charSequence.charAt(i + 1) == 'a' && charSequence.charAt(i10) == 'N' && skipWhitespace(charSequence, i + 3, i3) == i3) {
                return nan();
            }
        } else {
            int i11 = i + 7;
            if (i11 < i3 && charSequence.charAt(i) == 'I' && charSequence.charAt(i + 1) == 'n' && charSequence.charAt(i + 2) == 'f' && charSequence.charAt(i + 3) == 'i' && charSequence.charAt(i + 4) == 'n' && charSequence.charAt(i + 5) == 'i' && charSequence.charAt(i + 6) == 't' && charSequence.charAt(i11) == 'y' && skipWhitespace(charSequence, i + 8, i3) == i3) {
                return z10 ? negativeInfinity() : positiveInfinity();
            }
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(CharSequence charSequence, int i, int i3) {
        while (i < i3 && charSequence.charAt(i) <= ' ') {
            i++;
        }
        return i;
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public final long parseFloatingPointLiteral(CharSequence charSequence, int i, int i3) {
        int i10;
        int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i, i3);
        int iSkipWhitespace = skipWhitespace(charSequence, i, iCheckBounds);
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
            int i11 = iSkipWhitespace + 1;
            if ((AbstractNumberParser.charAt(charSequence, i11, iCheckBounds) | ' ') == 120) {
                return parseHexFloatLiteral(charSequence, iSkipWhitespace + 2, i, iCheckBounds, z10);
            }
            i10 = i11;
        } else {
            i10 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(charSequence, i10, i, iCheckBounds, z10, z11);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(CharSequence charSequence, int i, int i3, boolean z10, long j10, int i10, boolean z11, int i11);

    public abstract long valueOfHexLiteral(CharSequence charSequence, int i, int i3, boolean z10, long j10, int i10, boolean z11, int i11);
}
