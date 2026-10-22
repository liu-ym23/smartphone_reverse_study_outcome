package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.autonavi.aps.amapapi.config.Const;
import java.math.BigInteger;

/* loaded from: classes.dex */
class JavaBigIntegerFromCharSequence extends AbstractBigIntegerParser {
    private BigInteger parseDecDigits(CharSequence charSequence, int i10, int i11, boolean z10) {
        int i12 = i11 - i10;
        if (AbstractBigIntegerParser.hasManyDigits(i12)) {
            return parseManyDecDigits(charSequence, i10, i11, z10);
        }
        int i13 = (i12 & 7) + i10;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(charSequence, i10, i13);
        boolean z11 = jTryToParseUpTo7Digits >= 0;
        while (i13 < i11) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(charSequence, i13);
            z11 &= iTryToParseEightDigits >= 0;
            jTryToParseUpTo7Digits = (jTryToParseUpTo7Digits * 100000000) + iTryToParseEightDigits;
            i13 += 8;
        }
        if (!z11) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (z10) {
            jTryToParseUpTo7Digits = -jTryToParseUpTo7Digits;
        }
        return BigInteger.valueOf(jTryToParseUpTo7Digits);
    }

    private BigInteger parseHexDigits(CharSequence charSequence, int i10, int i11, boolean z10) {
        int i12;
        boolean z11;
        int iSkipZeroes = skipZeroes(charSequence, i10, i11);
        int i13 = i11 - iSkipZeroes;
        if (i13 <= 0) {
            return BigInteger.ZERO;
        }
        AbstractBigIntegerParser.checkHexBigIntegerBounds(i13);
        byte[] bArr = new byte[((i13 + 1) >> 1) + 1];
        if ((i13 & 1) != 0) {
            int i14 = iSkipZeroes + 1;
            int iLookupHex = AbstractNumberParser.lookupHex(charSequence.charAt(iSkipZeroes));
            bArr[1] = (byte) iLookupHex;
            i12 = 2;
            z11 = iLookupHex < 0;
            iSkipZeroes = i14;
        } else {
            i12 = 1;
            z11 = false;
        }
        int i15 = ((i11 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i15) {
            char cCharAt = charSequence.charAt(iSkipZeroes);
            char cCharAt2 = charSequence.charAt(iSkipZeroes + 1);
            int iLookupHex2 = AbstractNumberParser.lookupHex(cCharAt);
            int iLookupHex3 = AbstractNumberParser.lookupHex(cCharAt2);
            int i16 = i12 + 1;
            bArr[i12] = (byte) ((iLookupHex2 << 4) | iLookupHex3);
            z11 |= iLookupHex3 < 0 || iLookupHex2 < 0;
            iSkipZeroes += 2;
            i12 = i16;
        }
        while (iSkipZeroes < i11) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, iSkipZeroes);
            FastDoubleSwar.writeIntBE(bArr, i12, (int) jTryToParseEightHexDigits);
            z11 |= jTryToParseEightHexDigits < 0;
            iSkipZeroes += 8;
            i12 += 4;
        }
        if (z11) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        BigInteger bigInteger = new BigInteger(bArr);
        return z10 ? bigInteger.negate() : bigInteger;
    }

    private BigInteger parseManyDecDigits(CharSequence charSequence, int i10, int i11, boolean z10) {
        int iSkipZeroes = skipZeroes(charSequence, i10, i11);
        AbstractBigIntegerParser.checkDecBigIntegerBounds(i11 - iSkipZeroes);
        BigInteger digitsRecursive = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, iSkipZeroes, i11, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i11), Const.I_TILE_TINY);
        return z10 ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11 && charSequence.charAt(i10) == '0') {
            i10++;
        }
        return i10;
    }

    public BigInteger parseBigIntegerString(CharSequence charSequence, int i10, int i11, int i12) throws NumberFormatException {
        int i13;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i10, i11);
            char cCharAt = charSequence.charAt(i10);
            boolean z10 = cCharAt == '-';
            if (z10 || cCharAt == '+') {
                i13 = i10 + 1;
                if (AbstractNumberParser.charAt(charSequence, i13, iCheckBounds) == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            } else {
                i13 = i10;
            }
            return i12 != 10 ? i12 != 16 ? new BigInteger(charSequence.subSequence(i10, i11).toString(), i12) : parseHexDigits(charSequence, i13, iCheckBounds, z10) : parseDecDigits(charSequence, i13, iCheckBounds, z10);
        } catch (ArithmeticException e10) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }
}
