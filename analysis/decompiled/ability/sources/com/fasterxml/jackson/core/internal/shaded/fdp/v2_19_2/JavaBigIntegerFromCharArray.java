package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;

/* loaded from: classes2.dex */
class JavaBigIntegerFromCharArray extends AbstractBigIntegerParser {
    private BigInteger parseDecDigits(char[] cArr, int i, int i6, boolean z10) {
        int i10 = i6 - i;
        if (AbstractBigIntegerParser.hasManyDigits(i10)) {
            return parseManyDecDigits(cArr, i, i6, z10);
        }
        int i11 = (i10 & 7) + i;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(cArr, i, i11);
        boolean z11 = jTryToParseUpTo7Digits >= 0;
        while (i11 < i6) {
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

    private BigInteger parseHexDigits(char[] cArr, int i, int i6, boolean z10) {
        int i10;
        boolean z11;
        int iSkipZeroes = skipZeroes(cArr, i, i6);
        int i11 = i6 - iSkipZeroes;
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
        int i13 = ((i6 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i13) {
            char c = cArr[iSkipZeroes];
            char c2 = cArr[iSkipZeroes + 1];
            int iLookupHex2 = AbstractNumberParser.lookupHex(c);
            int iLookupHex3 = AbstractNumberParser.lookupHex(c2);
            int i14 = i10 + 1;
            bArr[i10] = (byte) ((iLookupHex2 << 4) | iLookupHex3);
            z11 |= iLookupHex2 < 0 || iLookupHex3 < 0;
            iSkipZeroes += 2;
            i10 = i14;
        }
        while (iSkipZeroes < i6) {
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

    private BigInteger parseManyDecDigits(char[] cArr, int i, int i6, boolean z10) {
        int iSkipZeroes = skipZeroes(cArr, i, i6);
        AbstractBigIntegerParser.checkDecBigIntegerBounds(i6 - iSkipZeroes);
        BigInteger digitsRecursive = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, iSkipZeroes, i6, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i6), 400);
        return z10 ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(char[] cArr, int i, int i6) {
        while (i < i6 - 8 && FastDoubleSwar.isEightZeroes(cArr, i)) {
            i += 8;
        }
        while (i < i6 && cArr[i] == '0') {
            i++;
        }
        return i;
    }

    public BigInteger parseBigIntegerString(char[] cArr, int i, int i6, int i10) throws NumberFormatException {
        int i11;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(cArr.length, i, i6);
            char c = cArr[i];
            boolean z10 = c == '-';
            if (z10 || c == '+') {
                i11 = i + 1;
                if (AbstractNumberParser.charAt(cArr, i11, iCheckBounds) == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            } else {
                i11 = i;
            }
            return i10 != 10 ? i10 != 16 ? new BigInteger(new String(cArr, i, i6), i10) : parseHexDigits(cArr, i11, iCheckBounds, z10) : parseDecDigits(cArr, i11, iCheckBounds, z10);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }
}
