package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class JavaBigDecimalFromCharSequence extends AbstractBigDecimalParser {
    public BigDecimal parseBigDecimalString(CharSequence charSequence, int i, int i3) {
        boolean z10;
        int i10;
        long j10;
        int i11;
        int i12;
        long j11;
        int iTryToParseFourDigits;
        int i13 = i;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i13, i3);
            if (AbstractBigDecimalParser.hasManyDigits(i3)) {
                return parseBigDecimalStringWithManyDigits(charSequence, i, i3);
            }
            char cCharAt = AbstractNumberParser.charAt(charSequence, i13, iCheckBounds);
            boolean z11 = cCharAt == '-';
            if (z11 || cCharAt == '+') {
                i13++;
                cCharAt = AbstractNumberParser.charAt(charSequence, i13, iCheckBounds);
                if (cCharAt == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            }
            char c9 = cCharAt;
            int i14 = i13;
            char cCharAt2 = c9;
            int i15 = -1;
            int i16 = i14;
            long j12 = 0;
            boolean z12 = false;
            while (true) {
                if (i16 >= iCheckBounds) {
                    z10 = true;
                    break;
                }
                cCharAt2 = charSequence.charAt(i16);
                z10 = true;
                char c10 = (char) (cCharAt2 - '0');
                if (c10 >= '\n') {
                    if (cCharAt2 != '.') {
                        break;
                    }
                    z12 |= i15 >= 0;
                    int i17 = i16;
                    while (i17 < iCheckBounds - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(charSequence, i17 + 1)) >= 0) {
                        j12 = (j12 * 10000) + iTryToParseFourDigits;
                        i17 += 4;
                    }
                    i15 = i16;
                    i16 = i17;
                } else {
                    j12 = (j12 * 10) + c10;
                }
                i16++;
            }
            if (i15 < 0) {
                i10 = i16 - i14;
                i11 = i16;
                j10 = 0;
            } else {
                i10 = (i16 - i14) - 1;
                j10 = (i15 - i16) + 1;
                i11 = i15;
            }
            if ((cCharAt2 | ' ') == 101) {
                int i18 = i16 + 1;
                char cCharAt3 = AbstractNumberParser.charAt(charSequence, i18, iCheckBounds);
                boolean z13 = cCharAt3 == '-' ? z10 : false;
                if (z13 || cCharAt3 == '+') {
                    i18 = i16 + 2;
                    cCharAt3 = AbstractNumberParser.charAt(charSequence, i18, iCheckBounds);
                }
                char c11 = (char) (cCharAt3 - '0');
                z12 |= c11 >= '\n' ? z10 : false;
                long j13 = 0;
                while (true) {
                    if (j13 < 2147483647L) {
                        j13 = (j13 * 10) + c11;
                    }
                    j11 = j13;
                    i18++;
                    char cCharAt4 = (char) (AbstractNumberParser.charAt(charSequence, i18, iCheckBounds) - '0');
                    if (cCharAt4 >= '\n') {
                        break;
                    }
                    j13 = j11;
                    c11 = cCharAt4;
                }
                if (z13) {
                    j11 = -j11;
                }
                j10 += j11;
                i12 = i18;
            } else {
                i12 = i16;
                i16 = iCheckBounds;
            }
            long j14 = j10;
            if (i10 != 0) {
                z10 = false;
            }
            AbstractBigDecimalParser.checkParsedBigDecimalBounds(z12 | z10, i12, iCheckBounds, i10, j14);
            if (i10 >= 19) {
                return valueOfBigDecimalString(charSequence, i14, i11, i11 + 1, i16, z11, (int) j14);
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

    public BigDecimal parseBigDecimalStringWithManyDigits(CharSequence charSequence, int i, int i3) {
        int i10;
        int i11;
        boolean z10;
        int i12;
        long j10;
        int i13;
        boolean z11;
        long j11;
        int i14;
        boolean z12;
        int i15;
        int i16 = i;
        int i17 = i16 + i3;
        char cCharAt = AbstractNumberParser.charAt(charSequence, i16, i17);
        boolean z13 = cCharAt == '-';
        if ((z13 || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(charSequence, (i16 = i16 + 1), i17)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        int iMin = Math.min(i17 - 8, 1073741824);
        int i18 = i16;
        while (i18 < iMin && FastDoubleSwar.isEightZeroes(charSequence, i18)) {
            i18 += 8;
        }
        while (i18 < i17 && charSequence.charAt(i18) == '0') {
            i18++;
        }
        int i19 = i18;
        while (i19 < iMin && FastDoubleSwar.isEightDigits(charSequence, i19)) {
            i19 += 8;
        }
        while (i19 < i17) {
            cCharAt = charSequence.charAt(i19);
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                break;
            }
            i19++;
        }
        if (cCharAt == '.') {
            int i20 = i19 + 1;
            while (i20 < iMin && FastDoubleSwar.isEightZeroes(charSequence, i20)) {
                i20 += 8;
            }
            while (i20 < i17 && charSequence.charAt(i20) == '0') {
                i20++;
            }
            int i21 = i20;
            while (i21 < iMin && FastDoubleSwar.isEightDigits(charSequence, i21)) {
                i21 += 8;
            }
            while (i21 < i17) {
                cCharAt = charSequence.charAt(i21);
                if (!FastDoubleSwar.isDigit(cCharAt)) {
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
        long j12 = 0;
        if (i10 < 0) {
            z10 = true;
            i13 = i19 - i18;
            i11 = i19;
            i10 = i11;
            i12 = i10;
            j10 = 0;
        } else {
            z10 = true;
            i12 = i19;
            j10 = (i10 - i19) + 1;
            i13 = i18 == i10 ? i19 - i11 : (i19 - i18) - 1;
        }
        if ((cCharAt | ' ') == 101) {
            int i22 = i12 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(charSequence, i22, i17);
            boolean z14 = cCharAt2 == '-' ? z10 : false;
            if (z14 || cCharAt2 == '+') {
                i22 = i12 + 2;
                cCharAt2 = AbstractNumberParser.charAt(charSequence, i22, i17);
            }
            char cCharAt3 = (char) (cCharAt2 - '0');
            z12 = cCharAt3 >= '\n' ? z10 : false;
            while (true) {
                if (j12 < 2147483647L) {
                    z11 = z13;
                    j12 = (j12 * 10) + cCharAt3;
                } else {
                    z11 = z13;
                }
                i22++;
                cCharAt3 = (char) (AbstractNumberParser.charAt(charSequence, i22, i17) - '0');
                if (cCharAt3 >= '\n') {
                    break;
                }
                z13 = z11;
            }
            if (z14) {
                j12 = -j12;
            }
            i14 = i22;
            j11 = j10 + j12;
            i15 = i12;
        } else {
            z11 = z13;
            j11 = j10;
            i14 = i12;
            z12 = false;
            i15 = i17;
        }
        AbstractBigDecimalParser.checkParsedBigDecimalBounds(z12 | ((i16 == i10 && i10 == i15) ? z10 : false), i14, i17, i13, j11);
        return valueOfBigDecimalString(charSequence, i18, i10, i11, i15, z11, (int) j11);
    }

    public BigDecimal valueOfBigDecimalString(CharSequence charSequence, int i, int i3, int i10, int i11, boolean z10, int i12) {
        BigInteger bigIntegerNegate;
        BigInteger digitsIterative;
        int i13 = (i11 - i3) - 1;
        int i14 = i11 - i10;
        int i15 = i3 - i;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map = null;
        if (i15 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else if (i15 > 400) {
            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
            FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i, i3);
            bigIntegerNegate = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i, i3, navigableMapCreatePowersOfTenFloor16Map, 400);
        } else {
            bigIntegerNegate = ParseDigitsTaskCharSequence.parseDigitsIterative(charSequence, i, i3);
        }
        if (i13 > 0) {
            if (i14 > 400) {
                if (navigableMapCreatePowersOfTenFloor16Map == null) {
                    navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                }
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i10, i11);
                digitsIterative = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i10, i11, navigableMapCreatePowersOfTenFloor16Map, 400);
            } else {
                digitsIterative = ParseDigitsTaskCharSequence.parseDigitsIterative(charSequence, i10, i11);
            }
            bigIntegerNegate = bigIntegerNegate.signum() == 0 ? digitsIterative : FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i13)).add(digitsIterative);
        }
        if (z10) {
            bigIntegerNegate = bigIntegerNegate.negate();
        }
        return new BigDecimal(bigIntegerNegate, -i12);
    }
}
