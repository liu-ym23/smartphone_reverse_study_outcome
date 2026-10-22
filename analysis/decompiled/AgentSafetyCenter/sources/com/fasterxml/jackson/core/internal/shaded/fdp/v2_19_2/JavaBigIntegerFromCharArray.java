package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class JavaBigIntegerFromCharArray extends AbstractBigIntegerParser {
    private BigInteger parseDecDigits(char[] cArr, int i, int i3, boolean z10) {
        int i10 = i3 - i;
        if (AbstractBigIntegerParser.hasManyDigits(i10)) {
            return parseManyDecDigits(cArr, i, i3, z10);
        }
        int i11 = (i10 & 7) + i;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(cArr, i, i11);
        boolean z11 = jTryToParseUpTo7Digits >= 0;
        while (i11 < i3) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(cArr, i11);
            z11 &= iTryToParseEightDigits >= 0;
            jTryToParseUpTo7Digits = (jTryToParseUpTo7Digits * 100000000) + iTryToParseEightDigits;
            i11 += 8;
        }
        if (!z11) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (z10) {
            jTryToParseUpTo7Digits = -jTryToParseUpTo7Digits;
        }
        return BigInteger.valueOf(jTryToParseUpTo7Digits);
    }

    private BigInteger parseHexDigits(char[] cArr, int i, int i3, boolean z10) {
        int i10;
        boolean z11;
        int iSkipZeroes = skipZeroes(cArr, i, i3);
        int i11 = i3 - iSkipZeroes;
        if (i11 <= 0) {
            return BigInteger.ZERO;
        }
        AbstractBigIntegerParser.checkHexBigIntegerBounds(i11);
        byte[] bArr = new byte[((i11 + 1) >> 1) + 1];
        if ((i11 & 1) != 0) {
            int i12 = iSkipZeroes + 1;
            int iLookupHex = AbstractNumberParser.lookupHex(cArr[iSkipZeroes]);
            bArr[1] = (byte) iLookupHex;
            i10 = 2;
            z11 = iLookupHex < 0;
            iSkipZeroes = i12;
        } else {
            i10 = 1;
            z11 = false;
        }
        int i13 = ((i3 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i13) {
            char c9 = cArr[iSkipZeroes];
            char c10 = cArr[iSkipZeroes + 1];
            int iLookupHex2 = AbstractNumberParser.lookupHex(c9);
            int iLookupHex3 = AbstractNumberParser.lookupHex(c10);
            int i14 = i10 + 1;
            bArr[i10] = (byte) ((iLookupHex2 << 4) | iLookupHex3);
            z11 |= iLookupHex2 < 0 || iLookupHex3 < 0;
            iSkipZeroes += 2;
            i10 = i14;
        }
        while (iSkipZeroes < i3) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(cArr, iSkipZeroes);
            FastDoubleSwar.writeIntBE(bArr, i10, (int) jTryToParseEightHexDigits);
            z11 |= jTryToParseEightHexDigits < 0;
            iSkipZeroes += 8;
            i10 += 4;
        }
        if (z11) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        BigInteger bigInteger = new BigInteger(bArr);
        return z10 ? bigInteger.negate() : bigInteger;
    }

    private BigInteger parseManyDecDigits(char[] cArr, int i, int i3, boolean z10) {
        int iSkipZeroes = skipZeroes(cArr, i, i3);
        AbstractBigIntegerParser.checkDecBigIntegerBounds(i3 - iSkipZeroes);
        BigInteger digitsRecursive = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, iSkipZeroes, i3, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i3), 400);
        return z10 ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(char[] cArr, int i, int i3) {
        while (i < i3 - 8 && FastDoubleSwar.isEightZeroes(cArr, i)) {
            i += 8;
        }
        while (i < i3 && cArr[i] == '0') {
            i++;
        }
        return i;
    }

    public BigInteger parseBigIntegerString(char[] cArr, int i, int i3, int i10) {
        int i11;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(cArr.length, i, i3);
            char c9 = cArr[i];
            boolean z10 = c9 == '-';
            if (z10 || c9 == '+') {
                i11 = i + 1;
                if (AbstractNumberParser.charAt(cArr, i11, iCheckBounds) == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            } else {
                i11 = i;
            }
            return i10 != 10 ? i10 != 16 ? new BigInteger(new String(cArr, i, i3), i10) : parseHexDigits(cArr, i11, iCheckBounds, z10) : parseDecDigits(cArr, i11, iCheckBounds, z10);
        } catch (ArithmeticException e10) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }
}
