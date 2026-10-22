package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class ParseDigitsTaskByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private ParseDigitsTaskByteArray() {
    }

    public static BigInteger parseDigitsIterative(byte[] bArr, int i, int i3) {
        int i10 = i3 - i;
        BigSignificand bigSignificand = new BigSignificand(FastIntegerMath.estimateNumBits(i10));
        int i11 = (i10 & 7) + i;
        int iTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(bArr, i, i11);
        boolean z10 = iTryToParseUpTo7Digits >= 0;
        bigSignificand.add(iTryToParseUpTo7Digits);
        while (i11 < i3) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(bArr, i11);
            z10 &= iTryToParseEightDigits >= 0;
            bigSignificand.fma(100000000, iTryToParseEightDigits);
            i11 += 8;
        }
        if (z10) {
            return bigSignificand.toBigInteger();
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }

    public static BigInteger parseDigitsRecursive(byte[] bArr, int i, int i3, Map<Integer, BigInteger> map, int i10) {
        if (i3 - i <= i10) {
            return parseDigitsIterative(bArr, i, i3);
        }
        int iSplitFloor16 = FastIntegerMath.splitFloor16(i, i3);
        return parseDigitsRecursive(bArr, iSplitFloor16, i3, map, i10).add(FftMultiplier.multiply(parseDigitsRecursive(bArr, i, iSplitFloor16, map, i10), map.get(Integer.valueOf(i3 - iSplitFloor16))));
    }
}
