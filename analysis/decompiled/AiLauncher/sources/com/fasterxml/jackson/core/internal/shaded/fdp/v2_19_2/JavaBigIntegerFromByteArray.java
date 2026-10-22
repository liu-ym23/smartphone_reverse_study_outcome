package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.autonavi.aps.amapapi.config.Const;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
class JavaBigIntegerFromByteArray extends AbstractBigIntegerParser {
    private BigInteger parseDecDigits(byte[] bArr, int i10, int i11, boolean z10) {
        int i12 = i11 - i10;
        if (AbstractBigIntegerParser.hasManyDigits(i12)) {
            return parseManyDecDigits(bArr, i10, i11, z10);
        }
        int i13 = (i12 & 7) + i10;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(bArr, i10, i13);
        boolean z11 = jTryToParseUpTo7Digits >= 0;
        while (i13 < i11) {
            int iTryToParseEightDigitsUtf8 = FastDoubleSwar.tryToParseEightDigitsUtf8(bArr, i13);
            z11 &= iTryToParseEightDigitsUtf8 >= 0;
            jTryToParseUpTo7Digits = (jTryToParseUpTo7Digits * 100000000) + iTryToParseEightDigitsUtf8;
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

    private BigInteger parseHexDigits(byte[] bArr, int i10, int i11, boolean z10) {
        int i12;
        boolean z11;
        int iSkipZeroes = skipZeroes(bArr, i10, i11);
        int i13 = i11 - iSkipZeroes;
        if (i13 <= 0) {
            return BigInteger.ZERO;
        }
        AbstractBigIntegerParser.checkHexBigIntegerBounds(i13);
        byte[] bArr2 = new byte[((i13 + 1) >> 1) + 1];
        if ((i13 & 1) != 0) {
            int i14 = iSkipZeroes + 1;
            int iLookupHex = AbstractNumberParser.lookupHex(bArr[iSkipZeroes]);
            bArr2[1] = (byte) iLookupHex;
            i12 = 2;
            z11 = iLookupHex < 0;
            iSkipZeroes = i14;
        } else {
            i12 = 1;
            z11 = false;
        }
        int i15 = ((i11 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i15) {
            byte b10 = bArr[iSkipZeroes];
            byte b11 = bArr[iSkipZeroes + 1];
            int iLookupHex2 = AbstractNumberParser.lookupHex(b10);
            int iLookupHex3 = AbstractNumberParser.lookupHex(b11);
            int i16 = i12 + 1;
            bArr2[i12] = (byte) ((iLookupHex2 << 4) | iLookupHex3);
            z11 |= iLookupHex2 < 0 || iLookupHex3 < 0;
            iSkipZeroes += 2;
            i12 = i16;
        }
        while (iSkipZeroes < i11) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(bArr, iSkipZeroes);
            FastDoubleSwar.writeIntBE(bArr2, i12, (int) jTryToParseEightHexDigits);
            z11 |= jTryToParseEightHexDigits < 0;
            iSkipZeroes += 8;
            i12 += 4;
        }
        if (z11) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        BigInteger bigInteger = new BigInteger(bArr2);
        return z10 ? bigInteger.negate() : bigInteger;
    }

    private BigInteger parseManyDecDigits(byte[] bArr, int i10, int i11, boolean z10) {
        int iSkipZeroes = skipZeroes(bArr, i10, i11);
        AbstractBigIntegerParser.checkDecBigIntegerBounds(i11 - iSkipZeroes);
        BigInteger digitsRecursive = ParseDigitsTaskByteArray.parseDigitsRecursive(bArr, iSkipZeroes, i11, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i11), Const.I_TILE_TINY);
        return z10 ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(byte[] bArr, int i10, int i11) {
        while (i10 < i11 - 8 && FastDoubleSwar.isEightZeroes(bArr, i10)) {
            i10 += 8;
        }
        while (i10 < i11 && bArr[i10] == 48) {
            i10++;
        }
        return i10;
    }

    public BigInteger parseBigIntegerString(byte[] bArr, int i10, int i11, int i12) throws NumberFormatException {
        int i13;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(bArr.length, i10, i11);
            byte b10 = bArr[i10];
            boolean z10 = b10 == 45;
            if (z10 || b10 == 43) {
                i13 = i10 + 1;
                if (AbstractNumberParser.charAt(bArr, i13, iCheckBounds) == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            } else {
                i13 = i10;
            }
            return i12 != 10 ? i12 != 16 ? new BigInteger(new String(bArr, i10, i11, StandardCharsets.ISO_8859_1), i12) : parseHexDigits(bArr, i13, iCheckBounds, z10) : parseDecDigits(bArr, i13, iCheckBounds, z10);
        } catch (ArithmeticException e10) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }
}
