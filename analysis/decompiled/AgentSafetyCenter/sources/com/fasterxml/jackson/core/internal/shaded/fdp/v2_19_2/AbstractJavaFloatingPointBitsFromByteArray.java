package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromByteArray extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(byte[] bArr, int i, int i3, int i10, boolean z10, boolean z11) {
        byte b10;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j11;
        boolean z12;
        int i15;
        AbstractJavaFloatingPointBitsFromByteArray abstractJavaFloatingPointBitsFromByteArray;
        int i16;
        boolean z13;
        int i17;
        long j12;
        byte bCharAt;
        int iTryToParseFourDigits;
        int i18 = -1;
        int i19 = i;
        long j13 = 0;
        byte b11 = 0;
        boolean z14 = false;
        while (true) {
            b10 = 46;
            j10 = 10;
            if (i19 >= i10) {
                break;
            }
            b11 = bArr[i19];
            char c9 = (char) (b11 - 48);
            if (c9 >= '\n') {
                if (b11 != 46) {
                    break;
                }
                z14 |= i18 >= 0;
                int i20 = i19;
                while (i20 < i10 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i20 + 1)) >= 0) {
                    j13 = (j13 * 10000) + iTryToParseFourDigits;
                    i20 += 4;
                }
                int i21 = i19;
                i19 = i20;
                i18 = i21;
            } else {
                j13 = (j13 * 10) + c9;
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
        if ((b11 | 32) == 101) {
            i13 = i19 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i13, i10);
            boolean z15 = bCharAt2 == 45;
            if (z15 || bCharAt2 == 43) {
                i13 = i19 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i13, i10);
            }
            char c10 = (char) (bCharAt2 - 48);
            boolean z16 = z14 | (c10 >= '\n');
            int i22 = 0;
            while (true) {
                if (i22 < 1024) {
                    i22 = (i22 * 10) + c10;
                }
                i13++;
                bCharAt = AbstractNumberParser.charAt(bArr, i13, i10);
                char c11 = (char) (bCharAt - 48);
                if (c11 >= '\n') {
                    break;
                }
                c10 = c11;
            }
            if (z15) {
                i22 = -i22;
            }
            i12 += i22;
            int i23 = i22;
            b11 = bCharAt;
            i14 = i23;
            z14 = z16;
        } else {
            i13 = i19;
            i14 = 0;
        }
        if ((b11 | 34) == 102) {
            i13++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i13, i10);
        if (z14 || iSkipWhitespace < i10 || (!z11 && i11 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 19) {
            int i24 = i;
            int i25 = 0;
            long j14 = 0;
            while (i24 < i19) {
                byte b12 = bArr[i24];
                if (b12 != b10) {
                    j12 = j10;
                    if (Long.compareUnsigned(j14, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j14 = ((j14 * j12) + b12) - 48;
                } else {
                    i25++;
                    j12 = j10;
                }
                i24++;
                j10 = j12;
                b10 = 46;
            }
            i15 = (i18 - i24) + i25 + i14;
            j11 = j14;
            z12 = i24 < i19;
            abstractJavaFloatingPointBitsFromByteArray = this;
            z13 = z10;
            i17 = i12;
            i16 = i3;
        } else {
            j11 = j13;
            z12 = false;
            i15 = 0;
            abstractJavaFloatingPointBitsFromByteArray = this;
            i16 = i3;
            z13 = z10;
            i17 = i12;
        }
        return abstractJavaFloatingPointBitsFromByteArray.valueOfFloatLiteral(bArr, i16, i10, z13, j11, i17, z12, i15);
    }

    private long parseHexFloatingPointLiteral(byte[] bArr, int i, int i3, int i10, boolean z10) {
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
        byte bCharAt;
        int i16 = -1;
        int i17 = i;
        long j11 = 0;
        byte b10 = 0;
        boolean z12 = false;
        while (true) {
            c9 = 4;
            if (i17 >= i10) {
                break;
            }
            b10 = bArr[i17];
            int iLookupHex = AbstractNumberParser.lookupHex(b10);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z12 |= i16 >= 0;
                i16 = i17;
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
        boolean z13 = (b10 | 32) == 112;
        if (z13) {
            i12 = i17 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i12, i10);
            boolean z14 = bCharAt2 == 45;
            if (z14 || bCharAt2 == 43) {
                i12 = i17 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i12, i10);
            }
            char c11 = (char) (bCharAt2 - 48);
            boolean z15 = z12 | (c11 >= '\n');
            int i18 = 0;
            while (true) {
                if (i18 < 1024) {
                    i18 = (i18 * 10) + c11;
                }
                i12++;
                bCharAt = AbstractNumberParser.charAt(bArr, i12, i10);
                c10 = c9;
                char c12 = (char) (bCharAt - 48);
                if (c12 >= '\n') {
                    break;
                }
                c11 = c12;
                c9 = c10;
            }
            if (z14) {
                i18 = -i18;
            }
            iMin += i18;
            b10 = bCharAt;
            i13 = i18;
            z12 = z15;
        } else {
            c10 = 4;
            i12 = i17;
            i13 = 0;
        }
        if ((b10 | 34) == 102) {
            i12++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i12, i10);
        if (z12 || iSkipWhitespace < i10 || i11 == 0 || !z13) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 16) {
            int i19 = i;
            int i20 = 0;
            long j12 = 0;
            while (i19 < i17) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(bArr[i19]);
                if (iLookupHex2 < 0) {
                    i20++;
                } else {
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = (j12 << c10) | iLookupHex2;
                }
                i19++;
            }
            boolean z16 = i19 < i17;
            int i21 = i20;
            iSkipWhitespace = i19;
            i15 = i21;
            i14 = i13;
            j10 = j12;
            z11 = z16;
        } else {
            i14 = i13;
            j10 = j11;
            i15 = 0;
            z11 = false;
        }
        return valueOfHexLiteral(bArr, i3, i10, z10, j10, iMin, z11, (((i16 - iSkipWhitespace) + i15) * 4) + i14);
    }

    private long parseNaNOrInfinity(byte[] bArr, int i, int i3, boolean z10) {
        if (bArr[i] == 78) {
            int i10 = i + 2;
            if (i10 < i3 && bArr[i + 1] == 97 && bArr[i10] == 78 && skipWhitespace(bArr, i + 3, i3) == i3) {
                return nan();
            }
        } else if (i + 7 < i3 && FastDoubleSwar.readLongLE(bArr, i) == 8751735898823355977L && skipWhitespace(bArr, i + 8, i3) == i3) {
            return z10 ? negativeInfinity() : positiveInfinity();
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(byte[] bArr, int i, int i3) {
        while (i < i3 && (bArr[i] & 255) <= 32) {
            i++;
        }
        return i;
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public long parseFloatingPointLiteral(byte[] bArr, int i, int i3) {
        int i10;
        int iCheckBounds = AbstractNumberParser.checkBounds(bArr.length, i, i3);
        int iSkipWhitespace = skipWhitespace(bArr, i, iCheckBounds);
        if (iSkipWhitespace == iCheckBounds) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        byte bCharAt = bArr[iSkipWhitespace];
        boolean z10 = bCharAt == 45;
        if ((z10 || bCharAt == 43) && (bCharAt = AbstractNumberParser.charAt(bArr, (iSkipWhitespace = iSkipWhitespace + 1), iCheckBounds)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (bCharAt >= 73) {
            return parseNaNOrInfinity(bArr, iSkipWhitespace, iCheckBounds, z10);
        }
        boolean z11 = bCharAt == 48;
        if (z11) {
            int i11 = iSkipWhitespace + 1;
            if ((AbstractNumberParser.charAt(bArr, i11, iCheckBounds) | 32) == 120) {
                return parseHexFloatingPointLiteral(bArr, iSkipWhitespace + 2, i, iCheckBounds, z10);
            }
            i10 = i11;
        } else {
            i10 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(bArr, i10, i, iCheckBounds, z10, z11);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(byte[] bArr, int i, int i3, boolean z10, long j10, int i10, boolean z11, int i11);

    public abstract long valueOfHexLiteral(byte[] bArr, int i, int i3, boolean z10, long j10, int i10, boolean z11, int i11);
}
