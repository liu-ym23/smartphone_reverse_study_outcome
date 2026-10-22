package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromByteArray extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(byte[] bArr, int i10, int i11, int i12, boolean z10, boolean z11) {
        byte b10;
        long j10;
        int i13;
        int i14;
        int i15;
        int i16;
        long j11;
        boolean z12;
        int i17;
        AbstractJavaFloatingPointBitsFromByteArray abstractJavaFloatingPointBitsFromByteArray;
        int i18;
        boolean z13;
        int i19;
        long j12;
        byte bCharAt;
        int iTryToParseFourDigits;
        int i20 = -1;
        int i21 = i10;
        long j13 = 0;
        byte b11 = 0;
        boolean z14 = false;
        while (true) {
            b10 = 46;
            j10 = 10;
            if (i21 >= i12) {
                break;
            }
            b11 = bArr[i21];
            char c10 = (char) (b11 - 48);
            if (c10 >= '\n') {
                if (b11 != 46) {
                    break;
                }
                z14 |= i20 >= 0;
                int i22 = i21;
                while (i22 < i12 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i22 + 1)) >= 0) {
                    j13 = (j13 * 10000) + iTryToParseFourDigits;
                    i22 += 4;
                }
                int i23 = i21;
                i21 = i22;
                i20 = i23;
            } else {
                j13 = (j13 * 10) + c10;
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
        if ((b11 | 32) == 101) {
            i15 = i21 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i15, i12);
            boolean z15 = bCharAt2 == 45;
            if (z15 || bCharAt2 == 43) {
                i15 = i21 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i15, i12);
            }
            char c11 = (char) (bCharAt2 - 48);
            boolean z16 = z14 | (c11 >= '\n');
            int i24 = 0;
            while (true) {
                if (i24 < 1024) {
                    i24 = (i24 * 10) + c11;
                }
                i15++;
                bCharAt = AbstractNumberParser.charAt(bArr, i15, i12);
                char c12 = (char) (bCharAt - 48);
                if (c12 >= '\n') {
                    break;
                }
                c11 = c12;
            }
            if (z15) {
                i24 = -i24;
            }
            i14 += i24;
            int i25 = i24;
            b11 = bCharAt;
            i16 = i25;
            z14 = z16;
        } else {
            i15 = i21;
            i16 = 0;
        }
        if ((b11 | 34) == 102) {
            i15++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i15, i12);
        if (z14 || iSkipWhitespace < i12 || (!z11 && i13 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i13 > 19) {
            int i26 = i10;
            int i27 = 0;
            long j14 = 0;
            while (i26 < i21) {
                byte b12 = bArr[i26];
                if (b12 != b10) {
                    j12 = j10;
                    if (Long.compareUnsigned(j14, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j14 = ((j14 * j12) + b12) - 48;
                } else {
                    i27++;
                    j12 = j10;
                }
                i26++;
                j10 = j12;
                b10 = 46;
            }
            i17 = (i20 - i26) + i27 + i16;
            j11 = j14;
            z12 = i26 < i21;
            abstractJavaFloatingPointBitsFromByteArray = this;
            z13 = z10;
            i19 = i14;
            i18 = i11;
        } else {
            j11 = j13;
            z12 = false;
            i17 = 0;
            abstractJavaFloatingPointBitsFromByteArray = this;
            i18 = i11;
            z13 = z10;
            i19 = i14;
        }
        return abstractJavaFloatingPointBitsFromByteArray.valueOfFloatLiteral(bArr, i18, i12, z13, j11, i19, z12, i17);
    }

    private long parseHexFloatingPointLiteral(byte[] bArr, int i10, int i11, int i12, boolean z10) {
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
        byte bCharAt;
        int i18 = -1;
        int i19 = i10;
        long j11 = 0;
        byte b10 = 0;
        boolean z12 = false;
        while (true) {
            c10 = 4;
            if (i19 >= i12) {
                break;
            }
            b10 = bArr[i19];
            int iLookupHex = AbstractNumberParser.lookupHex(b10);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z12 |= i18 >= 0;
                i18 = i19;
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
        boolean z13 = (b10 | 32) == 112;
        if (z13) {
            i14 = i19 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i14, i12);
            boolean z14 = bCharAt2 == 45;
            if (z14 || bCharAt2 == 43) {
                i14 = i19 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i14, i12);
            }
            char c12 = (char) (bCharAt2 - 48);
            boolean z15 = z12 | (c12 >= '\n');
            int i20 = 0;
            while (true) {
                if (i20 < 1024) {
                    i20 = (i20 * 10) + c12;
                }
                i14++;
                bCharAt = AbstractNumberParser.charAt(bArr, i14, i12);
                c11 = c10;
                char c13 = (char) (bCharAt - 48);
                if (c13 >= '\n') {
                    break;
                }
                c12 = c13;
                c10 = c11;
            }
            if (z14) {
                i20 = -i20;
            }
            iMin += i20;
            b10 = bCharAt;
            i15 = i20;
            z12 = z15;
        } else {
            c11 = 4;
            i14 = i19;
            i15 = 0;
        }
        if ((b10 | 34) == 102) {
            i14++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i14, i12);
        if (z12 || iSkipWhitespace < i12 || i13 == 0 || !z13) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i13 > 16) {
            int i21 = i10;
            int i22 = 0;
            long j12 = 0;
            while (i21 < i19) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(bArr[i21]);
                if (iLookupHex2 < 0) {
                    i22++;
                } else {
                    if (Long.compareUnsigned(j12, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j12 = (j12 << c11) | iLookupHex2;
                }
                i21++;
            }
            boolean z16 = i21 < i19;
            int i23 = i22;
            iSkipWhitespace = i21;
            i17 = i23;
            i16 = i15;
            j10 = j12;
            z11 = z16;
        } else {
            i16 = i15;
            j10 = j11;
            i17 = 0;
            z11 = false;
        }
        return valueOfHexLiteral(bArr, i11, i12, z10, j10, iMin, z11, (((i18 - iSkipWhitespace) + i17) * 4) + i16);
    }

    private long parseNaNOrInfinity(byte[] bArr, int i10, int i11, boolean z10) {
        if (bArr[i10] == 78) {
            int i12 = i10 + 2;
            if (i12 < i11 && bArr[i10 + 1] == 97 && bArr[i12] == 78 && skipWhitespace(bArr, i10 + 3, i11) == i11) {
                return nan();
            }
        } else if (i10 + 7 < i11 && FastDoubleSwar.readLongLE(bArr, i10) == 8751735898823355977L && skipWhitespace(bArr, i10 + 8, i11) == i11) {
            return z10 ? negativeInfinity() : positiveInfinity();
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    private static int skipWhitespace(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && (bArr[i10] & 255) <= 32) {
            i10++;
        }
        return i10;
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public long parseFloatingPointLiteral(byte[] bArr, int i10, int i11) {
        int i12;
        int iCheckBounds = AbstractNumberParser.checkBounds(bArr.length, i10, i11);
        int iSkipWhitespace = skipWhitespace(bArr, i10, iCheckBounds);
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
            int i13 = iSkipWhitespace + 1;
            if ((AbstractNumberParser.charAt(bArr, i13, iCheckBounds) | 32) == 120) {
                return parseHexFloatingPointLiteral(bArr, iSkipWhitespace + 2, i10, iCheckBounds, z10);
            }
            i12 = i13;
        } else {
            i12 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(bArr, i12, i10, iCheckBounds, z10, z11);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(byte[] bArr, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13);

    public abstract long valueOfHexLiteral(byte[] bArr, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13);
}
