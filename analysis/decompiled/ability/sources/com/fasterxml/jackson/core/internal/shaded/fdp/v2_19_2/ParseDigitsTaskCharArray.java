package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;
import java.util.Map;

/* loaded from: classes2.dex */
class ParseDigitsTaskCharArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private ParseDigitsTaskCharArray() {
    }

    public static BigInteger parseDigitsIterative(char[] cArr, int i, int i6) {
        int i10 = i6 - i;
        BigSignificand bigSignificand = new BigSignificand(FastIntegerMath.estimateNumBits(i10));
        int i11 = (i10 & 7) + i;
        int iTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(cArr, i, i11);
        boolean z10 = iTryToParseUpTo7Digits >= 0;
        bigSignificand.add(iTryToParseUpTo7Digits);
        while (i11 < i6) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(cArr, i11);
            z10 &= iTryToParseEightDigits >= 0;
            bigSignificand.fma(100000000, iTryToParseEightDigits);
            i11 += 8;
        }
        if (z10) {
            return bigSignificand.toBigInteger();
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    public static BigInteger parseDigitsRecursive(char[] cArr, int i, int i6, Map<Integer, BigInteger> map, int i10) {
        if (i6 - i <= i10) {
            return parseDigitsIterative(cArr, i, i6);
        }
        int iSplitFloor16 = FastIntegerMath.splitFloor16(i, i6);
        return parseDigitsRecursive(cArr, iSplitFloor16, i6, map, i10).add(FftMultiplier.multiply(parseDigitsRecursive(cArr, i, iSplitFloor16, map, i10), map.get(Integer.valueOf(i6 - iSplitFloor16))));
    }
}
