package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.autonavi.aps.amapapi.config.Const;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;

/* loaded from: classes.dex */
final class JavaBigDecimalFromByteArray extends AbstractBigDecimalParser {
    public BigDecimal parseBigDecimalString(byte[] bArr, int i10, int i11) {
        boolean z10;
        int i12;
        long j10;
        int i13;
        int i14;
        long j11;
        int iTryToParseFourDigits;
        int i15 = i10;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(bArr.length, i15, i11);
            if (AbstractBigDecimalParser.hasManyDigits(i11)) {
                return parseBigDecimalStringWithManyDigits(bArr, i10, i11);
            }
            byte bCharAt = AbstractNumberParser.charAt(bArr, i15, iCheckBounds);
            boolean z11 = bCharAt == 45;
            if (z11 || bCharAt == 43) {
                i15++;
                bCharAt = AbstractNumberParser.charAt(bArr, i15, iCheckBounds);
                if (bCharAt == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            }
            byte b10 = bCharAt;
            int i16 = i15;
            byte b11 = b10;
            int i17 = -1;
            int i18 = i16;
            long j12 = 0;
            boolean z12 = false;
            while (true) {
                if (i18 >= iCheckBounds) {
                    z10 = true;
                    break;
                }
                b11 = bArr[i18];
                z10 = true;
                char c10 = (char) (b11 - 48);
                if (c10 >= '\n') {
                    if (b11 != 46) {
                        break;
                    }
                    z12 |= i17 >= 0;
                    int i19 = i18;
                    while (i19 < iCheckBounds - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i19 + 1)) >= 0) {
                        j12 = (j12 * 10000) + iTryToParseFourDigits;
                        i19 += 4;
                    }
                    i17 = i18;
                    i18 = i19;
                } else {
                    j12 = (j12 * 10) + c10;
                }
                i18++;
            }
            if (i17 < 0) {
                i12 = i18 - i16;
                i13 = i18;
                j10 = 0;
            } else {
                i12 = (i18 - i16) - 1;
                j10 = (i17 - i18) + 1;
                i13 = i17;
            }
            if ((b11 | 32) == 101) {
                int i20 = i18 + 1;
                byte bCharAt2 = AbstractNumberParser.charAt(bArr, i20, iCheckBounds);
                boolean z13 = bCharAt2 == 45 ? z10 : false;
                if (z13 || bCharAt2 == 43) {
                    i20 = i18 + 2;
                    bCharAt2 = AbstractNumberParser.charAt(bArr, i20, iCheckBounds);
                }
                char c11 = (char) (bCharAt2 - 48);
                z12 |= c11 >= '\n' ? z10 : false;
                long j13 = 0;
                while (true) {
                    if (j13 < 2147483647L) {
                        j13 = (j13 * 10) + c11;
                    }
                    j11 = j13;
                    i20++;
                    char cCharAt = (char) (AbstractNumberParser.charAt(bArr, i20, iCheckBounds) - 48);
                    if (cCharAt >= '\n') {
                        break;
                    }
                    j13 = j11;
                    c11 = cCharAt;
                }
                if (z13) {
                    j11 = -j11;
                }
                j10 += j11;
                i14 = i20;
            } else {
                i14 = i18;
                i18 = iCheckBounds;
            }
            long j14 = j10;
            if (i12 != 0) {
                z10 = false;
            }
            AbstractBigDecimalParser.checkParsedBigDecimalBounds(z12 | z10, i14, iCheckBounds, i12, j14);
            if (i12 >= 19) {
                return valueOfBigDecimalString(bArr, i16, i13, i13 + 1, i18, z11, (int) j14);
            }
            if (z11) {
                j12 = -j12;
            }
            return new BigDecimal(j12).scaleByPowerOfTen((int) j14);
        } catch (ArithmeticException e10) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public BigDecimal parseBigDecimalStringWithManyDigits(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        int i14;
        long j10;
        int i15;
        boolean z11;
        long j11;
        int i16;
        boolean z12;
        int i17;
        int i18 = i10;
        int i19 = i18 + i11;
        byte bCharAt = AbstractNumberParser.charAt(bArr, i18, i19);
        boolean z13 = bCharAt == 45;
        if ((z13 || bCharAt == 43) && (bCharAt = AbstractNumberParser.charAt(bArr, (i18 = i18 + 1), i19)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        int iMin = Math.min(i19 - 8, 1073741824);
        int i20 = i18;
        while (i20 < iMin && FastDoubleSwar.isEightZeroes(bArr, i20)) {
            i20 += 8;
        }
        while (i20 < i19 && bArr[i20] == 48) {
            i20++;
        }
        int i21 = i20;
        while (i21 < iMin && FastDoubleSwar.isEightDigits(bArr, i21)) {
            i21 += 8;
        }
        while (i21 < i19) {
            bCharAt = bArr[i21];
            if (!FastDoubleSwar.isDigit(bCharAt)) {
                break;
            }
            i21++;
        }
        if (bCharAt == 46) {
            int i22 = i21 + 1;
            while (i22 < iMin && FastDoubleSwar.isEightZeroes(bArr, i22)) {
                i22 += 8;
            }
            while (i22 < i19 && bArr[i22] == 48) {
                i22++;
            }
            int i23 = i22;
            while (i23 < iMin && FastDoubleSwar.isEightDigits(bArr, i23)) {
                i23 += 8;
            }
            while (i23 < i19) {
                bCharAt = bArr[i23];
                if (!FastDoubleSwar.isDigit(bCharAt)) {
                    break;
                }
                i23++;
            }
            i13 = i22;
            i12 = i21;
            i21 = i23;
        } else {
            i12 = -1;
            i13 = -1;
        }
        long j12 = 0;
        if (i12 < 0) {
            z10 = true;
            i15 = i21 - i20;
            i13 = i21;
            i12 = i13;
            i14 = i12;
            j10 = 0;
        } else {
            z10 = true;
            i14 = i21;
            j10 = (i12 - i21) + 1;
            i15 = i20 == i12 ? i21 - i13 : (i21 - i20) - 1;
        }
        if ((bCharAt | 32) == 101) {
            int i24 = i14 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i24, i19);
            boolean z14 = bCharAt2 == 45 ? z10 : false;
            if (z14 || bCharAt2 == 43) {
                i24 = i14 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i24, i19);
            }
            char cCharAt = (char) (bCharAt2 - 48);
            z12 = cCharAt >= '\n' ? z10 : false;
            while (true) {
                if (j12 < 2147483647L) {
                    z11 = z13;
                    j12 = (j12 * 10) + cCharAt;
                } else {
                    z11 = z13;
                }
                i24++;
                cCharAt = (char) (AbstractNumberParser.charAt(bArr, i24, i19) - 48);
                if (cCharAt >= '\n') {
                    break;
                }
                z13 = z11;
            }
            if (z14) {
                j12 = -j12;
            }
            i16 = i24;
            j11 = j10 + j12;
            i17 = i14;
        } else {
            z11 = z13;
            j11 = j10;
            i16 = i14;
            z12 = false;
            i17 = i19;
        }
        AbstractBigDecimalParser.checkParsedBigDecimalBounds(z12 | ((i18 == i12 && i12 == i17) ? z10 : false), i16, i19, i15, j11);
        return valueOfBigDecimalString(bArr, i20, i12, i13, i17, z11, (int) j11);
    }

    public BigDecimal valueOfBigDecimalString(byte[] bArr, int i10, int i11, int i12, int i13, boolean z10, int i14) {
        BigInteger bigIntegerNegate;
        BigInteger digitsIterative;
        int i15 = (i13 - i11) - 1;
        int i16 = i13 - i12;
        int i17 = i11 - i10;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map = null;
        if (i17 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else if (i17 > 400) {
            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
            FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i10, i11);
            bigIntegerNegate = ParseDigitsTaskByteArray.parseDigitsRecursive(bArr, i10, i11, navigableMapCreatePowersOfTenFloor16Map, Const.I_TILE_TINY);
        } else {
            bigIntegerNegate = ParseDigitsTaskByteArray.parseDigitsIterative(bArr, i10, i11);
        }
        if (i15 > 0) {
            if (i16 > 400) {
                if (navigableMapCreatePowersOfTenFloor16Map == null) {
                    navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                }
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i12, i13);
                digitsIterative = ParseDigitsTaskByteArray.parseDigitsRecursive(bArr, i12, i13, navigableMapCreatePowersOfTenFloor16Map, Const.I_TILE_TINY);
            } else {
                digitsIterative = ParseDigitsTaskByteArray.parseDigitsIterative(bArr, i12, i13);
            }
            bigIntegerNegate = bigIntegerNegate.signum() == 0 ? digitsIterative : FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i15)).add(digitsIterative);
        }
        if (z10) {
            bigIntegerNegate = bigIntegerNegate.negate();
        }
        return new BigDecimal(bigIntegerNegate, -i14);
    }
}
