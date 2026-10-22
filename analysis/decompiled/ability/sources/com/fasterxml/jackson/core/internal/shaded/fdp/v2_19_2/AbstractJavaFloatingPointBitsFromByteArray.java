package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes2.dex */
abstract class AbstractJavaFloatingPointBitsFromByteArray extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(byte[] bArr, int i, int i6, int i10, boolean z10, boolean z11) {
        byte b;
        long j5;
        int i11;
        int i12;
        int i13;
        int i14;
        long j6;
        boolean z12;
        int i15;
        AbstractJavaFloatingPointBitsFromByteArray abstractJavaFloatingPointBitsFromByteArray;
        int i16;
        boolean z13;
        int i17;
        long j10;
        byte bCharAt;
        int iTryToParseFourDigits;
        int i18 = -1;
        int i19 = i;
        long j11 = 0;
        byte b5 = 0;
        boolean z14 = false;
        while (true) {
            b = 46;
            j5 = 10;
            if (i19 >= i10) {
                break;
            }
            b5 = bArr[i19];
            char c = (char) (b5 - 48);
            if (c >= '\n') {
                if (b5 != 46) {
                    break;
                }
                z14 |= i18 >= 0;
                int i20 = i19;
                while (i20 < i10 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i20 + 1)) >= 0) {
                    j11 = (j11 * 10000) + iTryToParseFourDigits;
                    i20 += 4;
                }
                int i21 = i19;
                i19 = i20;
                i18 = i21;
            } else {
                j11 = (j11 * 10) + c;
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
        if ((b5 | 32) == 101) {
            i13 = i19 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i13, i10);
            boolean z15 = bCharAt2 == 45;
            if (z15 || bCharAt2 == 43) {
                i13 = i19 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i13, i10);
            }
            char c2 = (char) (bCharAt2 - 48);
            boolean z16 = z14 | (c2 >= '\n');
            int i22 = 0;
            while (true) {
                if (i22 < 1024) {
                    i22 = (i22 * 10) + c2;
                }
                i13++;
                bCharAt = AbstractNumberParser.charAt(bArr, i13, i10);
                char c5 = (char) (bCharAt - 48);
                if (c5 >= '\n') {
                    break;
                }
                c2 = c5;
            }
            if (z15) {
                i22 = -i22;
            }
            i12 += i22;
            int i23 = i22;
            b5 = bCharAt;
            i14 = i23;
            z14 = z16;
        } else {
            i13 = i19;
            i14 = 0;
        }
        if ((b5 | 34) == 102) {
            i13++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i13, i10);
        if (z14 || iSkipWhitespace < i10 || (!z11 && i11 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 19) {
            int i24 = i;
            int i25 = 0;
            long j12 = 0;
            while (i24 < i19) {
                byte b10 = bArr[i24];
                if (b10 != b) {
                    j10 = j5;
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = ((j12 * j10) + b10) - 48;
                } else {
                    i25++;
                    j10 = j5;
                }
                i24++;
                j5 = j10;
                b = 46;
            }
            i15 = (i18 - i24) + i25 + i14;
            j6 = j12;
            z12 = i24 < i19;
            abstractJavaFloatingPointBitsFromByteArray = this;
            z13 = z10;
            i17 = i12;
            i16 = i6;
        } else {
            j6 = j11;
            z12 = false;
            i15 = 0;
            abstractJavaFloatingPointBitsFromByteArray = this;
            i16 = i6;
            z13 = z10;
            i17 = i12;
        }
        return abstractJavaFloatingPointBitsFromByteArray.valueOfFloatLiteral(bArr, i16, i10, z13, j6, i17, z12, i15);
    }

    private long parseHexFloatingPointLiteral(byte[] bArr, int i, int i6, int i10, boolean z10) {
        char c;
        int i11;
        int iMin;
        char c2;
        int i12;
        int i13;
        int i14;
        long j5;
        int i15;
        boolean z11;
        byte bCharAt;
        int i16 = -1;
        int i17 = i;
        long j6 = 0;
        byte b = 0;
        boolean z12 = false;
        while (true) {
            c = 4;
            if (i17 >= i10) {
                break;
            }
            b = bArr[i17];
            int iLookupHex = AbstractNumberParser.lookupHex(b);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z12 |= i16 >= 0;
                i16 = i17;
            } else {
                j6 = (j6 << 4) | iLookupHex;
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
        boolean z13 = (b | 32) == 112;
        if (z13) {
            i12 = i17 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i12, i10);
            boolean z14 = bCharAt2 == 45;
            if (z14 || bCharAt2 == 43) {
                i12 = i17 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i12, i10);
            }
            char c5 = (char) (bCharAt2 - 48);
            boolean z15 = z12 | (c5 >= '\n');
            int i18 = 0;
            while (true) {
                if (i18 < 1024) {
                    i18 = (i18 * 10) + c5;
                }
                i12++;
                bCharAt = AbstractNumberParser.charAt(bArr, i12, i10);
                c2 = c;
                char c10 = (char) (bCharAt - 48);
                if (c10 >= '\n') {
                    break;
                }
                c5 = c10;
                c = c2;
            }
            if (z14) {
                i18 = -i18;
            }
            iMin += i18;
            b = bCharAt;
            i13 = i18;
            z12 = z15;
        } else {
            c2 = 4;
            i12 = i17;
            i13 = 0;
        }
        if ((b | 34) == 102) {
            i12++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i12, i10);
        if (z12 || iSkipWhitespace < i10 || i11 == 0 || !z13) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i11 > 16) {
            int i19 = i;
            int i20 = 0;
            long j10 = 0;
            while (i19 < i17) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(bArr[i19]);
                if (iLookupHex2 < 0) {
                    i20++;
                } else {
                    if (Long.compareUnsigned(j10, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j10 = (j10 << c2) | iLookupHex2;
                }
                i19++;
            }
            boolean z16 = i19 < i17;
            int i21 = i20;
            iSkipWhitespace = i19;
            i15 = i21;
            i14 = i13;
            j5 = j10;
            z11 = z16;
        } else {
            i14 = i13;
            j5 = j6;
            i15 = 0;
            z11 = false;
        }
        return valueOfHexLiteral(bArr, i6, i10, z10, j5, iMin, z11, (((i16 - iSkipWhitespace) + i15) * 4) + i14);
    }

    private long parseNaNOrInfinity(byte[] bArr, int i, int i6, boolean z10) {
        if (bArr[i] == 78) {
            int i10 = i + 2;
            if (i10 < i6 && bArr[i + 1] == 97 && bArr[i10] == 78 && skipWhitespace(bArr, i + 3, i6) == i6) {
                return nan();
            }
        } else if (i + 7 < i6 && FastDoubleSwar.readLongLE(bArr, i) == 8751735898823355977L && skipWhitespace(bArr, i + 8, i6) == i6) {
            return z10 ? negativeInfinity() : positiveInfinity();
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(byte[] bArr, int i, int i6) {
        while (i < i6 && (bArr[i] & 255) <= 32) {
            i++;
        }
        return i;
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public long parseFloatingPointLiteral(byte[] bArr, int i, int i6) {
        int i10;
        int iCheckBounds = AbstractNumberParser.checkBounds(bArr.length, i, i6);
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

    public abstract long valueOfFloatLiteral(byte[] bArr, int i, int i6, boolean z10, long j5, int i10, boolean z11, int i11);

    public abstract long valueOfHexLiteral(byte[] bArr, int i, int i6, boolean z10, long j5, int i10, boolean z11, int i11);
}
