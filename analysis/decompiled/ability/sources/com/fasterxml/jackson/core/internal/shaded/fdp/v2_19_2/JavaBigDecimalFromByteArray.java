package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;

/* loaded from: classes2.dex */
final class JavaBigDecimalFromByteArray extends AbstractBigDecimalParser {
    public BigDecimal parseBigDecimalString(byte[] bArr, int i, int i6) {
        boolean z10;
        int i10;
        long j5;
        int i11;
        int i12;
        long j6;
        int iTryToParseFourDigits;
        int i13 = i;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(bArr.length, i13, i6);
            if (AbstractBigDecimalParser.hasManyDigits(i6)) {
                return parseBigDecimalStringWithManyDigits(bArr, i, i6);
            }
            byte bCharAt = AbstractNumberParser.charAt(bArr, i13, iCheckBounds);
            boolean z11 = bCharAt == 45;
            if (z11 || bCharAt == 43) {
                i13++;
                bCharAt = AbstractNumberParser.charAt(bArr, i13, iCheckBounds);
                if (bCharAt == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            }
            byte b = bCharAt;
            int i14 = i13;
            byte b5 = b;
            int i15 = -1;
            int i16 = i14;
            long j10 = 0;
            boolean z12 = false;
            while (true) {
                if (i16 >= iCheckBounds) {
                    z10 = true;
                    break;
                }
                b5 = bArr[i16];
                z10 = true;
                char c = (char) (b5 - 48);
                if (c >= '\n') {
                    if (b5 != 46) {
                        break;
                    }
                    z12 |= i15 >= 0;
                    int i17 = i16;
                    while (i17 < iCheckBounds - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i17 + 1)) >= 0) {
                        j10 = (j10 * 10000) + iTryToParseFourDigits;
                        i17 += 4;
                    }
                    i15 = i16;
                    i16 = i17;
                } else {
                    j10 = (j10 * 10) + c;
                }
                i16++;
            }
            if (i15 < 0) {
                i10 = i16 - i14;
                i11 = i16;
                j5 = 0;
            } else {
                i10 = (i16 - i14) - 1;
                j5 = (i15 - i16) + 1;
                i11 = i15;
            }
            if ((b5 | 32) == 101) {
                int i18 = i16 + 1;
                byte bCharAt2 = AbstractNumberParser.charAt(bArr, i18, iCheckBounds);
                boolean z13 = bCharAt2 == 45 ? z10 : false;
                if (z13 || bCharAt2 == 43) {
                    i18 = i16 + 2;
                    bCharAt2 = AbstractNumberParser.charAt(bArr, i18, iCheckBounds);
                }
                char c2 = (char) (bCharAt2 - 48);
                z12 |= c2 >= '\n' ? z10 : false;
                long j11 = 0;
                while (true) {
                    if (j11 < SieveCacheKt.NodeLinkMask) {
                        j11 = (j11 * 10) + c2;
                    }
                    j6 = j11;
                    i18++;
                    char cCharAt = (char) (AbstractNumberParser.charAt(bArr, i18, iCheckBounds) - 48);
                    if (cCharAt >= '\n') {
                        break;
                    }
                    j11 = j6;
                    c2 = cCharAt;
                }
                if (z13) {
                    j6 = -j6;
                }
                j5 += j6;
                i12 = i18;
            } else {
                i12 = i16;
                i16 = iCheckBounds;
            }
            long j12 = j5;
            if (i10 != 0) {
                z10 = false;
            }
            AbstractBigDecimalParser.checkParsedBigDecimalBounds(z12 | z10, i12, iCheckBounds, i10, j12);
            if (i10 >= 19) {
                return valueOfBigDecimalString(bArr, i14, i11, i11 + 1, i16, z11, (int) j12);
            }
            if (z11) {
                j10 = -j10;
            }
            return new BigDecimal(j10).scaleByPowerOfTen((int) j12);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public BigDecimal parseBigDecimalStringWithManyDigits(byte[] bArr, int i, int i6) {
        int i10;
        int i11;
        boolean z10;
        int i12;
        long j5;
        int i13;
        boolean z11;
        long j6;
        int i14;
        boolean z12;
        int i15;
        int i16 = i;
        int i17 = i16 + i6;
        byte bCharAt = AbstractNumberParser.charAt(bArr, i16, i17);
        boolean z13 = bCharAt == 45;
        if ((z13 || bCharAt == 43) && (bCharAt = AbstractNumberParser.charAt(bArr, (i16 = i16 + 1), i17)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        int iMin = Math.min(i17 - 8, BasicMeasure.EXACTLY);
        int i18 = i16;
        while (i18 < iMin && FastDoubleSwar.isEightZeroes(bArr, i18)) {
            i18 += 8;
        }
        while (i18 < i17 && bArr[i18] == 48) {
            i18++;
        }
        int i19 = i18;
        while (i19 < iMin && FastDoubleSwar.isEightDigits(bArr, i19)) {
            i19 += 8;
        }
        while (i19 < i17) {
            bCharAt = bArr[i19];
            if (!FastDoubleSwar.isDigit(bCharAt)) {
                break;
            }
            i19++;
        }
        if (bCharAt == 46) {
            int i20 = i19 + 1;
            while (i20 < iMin && FastDoubleSwar.isEightZeroes(bArr, i20)) {
                i20 += 8;
            }
            while (i20 < i17 && bArr[i20] == 48) {
                i20++;
            }
            int i21 = i20;
            while (i21 < iMin && FastDoubleSwar.isEightDigits(bArr, i21)) {
                i21 += 8;
            }
            while (i21 < i17) {
                bCharAt = bArr[i21];
                if (!FastDoubleSwar.isDigit(bCharAt)) {
                    break;
                }
                i21++;
            }
            i11 = i20;
            i10 = i19;
            i19 = i21;
        } else {
            i10 = -1;
            i11 = -1;
        }
        long j10 = 0;
        if (i10 < 0) {
            z10 = true;
            i13 = i19 - i18;
            i11 = i19;
            i10 = i11;
            i12 = i10;
            j5 = 0;
        } else {
            z10 = true;
            i12 = i19;
            j5 = (i10 - i19) + 1;
            i13 = i18 == i10 ? i19 - i11 : (i19 - i18) - 1;
        }
        if ((bCharAt | 32) == 101) {
            int i22 = i12 + 1;
            byte bCharAt2 = AbstractNumberParser.charAt(bArr, i22, i17);
            boolean z14 = bCharAt2 == 45 ? z10 : false;
            if (z14 || bCharAt2 == 43) {
                i22 = i12 + 2;
                bCharAt2 = AbstractNumberParser.charAt(bArr, i22, i17);
            }
            char cCharAt = (char) (bCharAt2 - 48);
            z12 = cCharAt >= '\n' ? z10 : false;
            while (true) {
                if (j10 < SieveCacheKt.NodeLinkMask) {
                    z11 = z13;
                    j10 = (j10 * 10) + cCharAt;
                } else {
                    z11 = z13;
                }
                i22++;
                cCharAt = (char) (AbstractNumberParser.charAt(bArr, i22, i17) - 48);
                if (cCharAt >= '\n') {
                    break;
                }
                z13 = z11;
            }
            if (z14) {
                j10 = -j10;
            }
            i14 = i22;
            j6 = j5 + j10;
            i15 = i12;
        } else {
            z11 = z13;
            j6 = j5;
            i14 = i12;
            z12 = false;
            i15 = i17;
        }
        AbstractBigDecimalParser.checkParsedBigDecimalBounds(z12 | ((i16 == i10 && i10 == i15) ? z10 : false), i14, i17, i13, j6);
        return valueOfBigDecimalString(bArr, i18, i10, i11, i15, z11, (int) j6);
    }

    public BigDecimal valueOfBigDecimalString(byte[] bArr, int i, int i6, int i10, int i11, boolean z10, int i12) {
        BigInteger bigIntegerNegate;
        BigInteger digitsIterative;
        int i13 = (i11 - i6) - 1;
        int i14 = i11 - i10;
        int i15 = i6 - i;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map = null;
        if (i15 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else if (i15 > 400) {
            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
            FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i, i6);
            bigIntegerNegate = ParseDigitsTaskByteArray.parseDigitsRecursive(bArr, i, i6, navigableMapCreatePowersOfTenFloor16Map, 400);
        } else {
            bigIntegerNegate = ParseDigitsTaskByteArray.parseDigitsIterative(bArr, i, i6);
        }
        if (i13 > 0) {
            if (i14 > 400) {
                if (navigableMapCreatePowersOfTenFloor16Map == null) {
                    navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                }
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i10, i11);
                digitsIterative = ParseDigitsTaskByteArray.parseDigitsRecursive(bArr, i10, i11, navigableMapCreatePowersOfTenFloor16Map, 400);
            } else {
                digitsIterative = ParseDigitsTaskByteArray.parseDigitsIterative(bArr, i10, i11);
            }
            bigIntegerNegate = bigIntegerNegate.signum() == 0 ? digitsIterative : FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i13)).add(digitsIterative);
        }
        if (z10) {
            bigIntegerNegate = bigIntegerNegate.negate();
        }
        return new BigDecimal(bigIntegerNegate, -i12);
    }
}
