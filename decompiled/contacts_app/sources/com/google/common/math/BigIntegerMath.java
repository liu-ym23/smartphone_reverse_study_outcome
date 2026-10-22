package com.google.common.math;

import com.google.common.base.Preconditions;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class BigIntegerMath {
    private static final double LN_10 = 0.0d;
    private static final double LN_2 = 0.0d;
    static final BigInteger SQRT2_PRECOMPUTED_BITS = null;
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;

    /* JADX INFO: renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static boolean isPowerOfTwo(BigInteger r2) {
        Preconditions.checkNotNull(r2);
        if (r2.signum() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r2.getLowestSetBit() != (r2.bitLength() - 1)) goto L7;
        return true;
    }

    public static int log2(BigInteger r2, RoundingMode r3) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, (BigInteger) Preconditions.checkNotNull(r2));
        int r0 = r2.bitLength() - 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r3.ordinal()]) {
            case 1: goto L23;
            case 2: goto L24;
            case 3: goto L24;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L5;
        };
    L23:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r2));
    L24:
        return r0;
    L5:
        throw new AssertionError();
    L7:
        if (r0 >= 256) goto L14;
        if (r2.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - r0)) > 0) goto L12;
        return r0;
    L12:
        return r0 + 1;
    L14:
        if ((r2.pow(2).bitLength() - 1) >= ((r0 * 2) + 1)) goto L17;
        return r0;
    L17:
        return r0 + 1;
    L19:
        if (isPowerOfTwo(r2) == false) goto L22;
        return r0;
    L22:
        return r0 + 1;
    }

    static {
        SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
        LN_10 = Math.log(10.0d);
        LN_2 = Math.log(2.0d);
    }

    public static int log10(BigInteger r7, RoundingMode r8) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r7);
        if (fitsInLong(r7) == true) goto L5;
        int r0 = (int) ((((double) log2(r7, RoundingMode.FLOOR)) * LN_2) / LN_10);
        BigInteger r1 = BigInteger.TEN.pow(r0);
        int r2 = r1.compareTo(r7);
        if (r2 <= 0) goto L11;
    L8:
        r0 = r0 - 1;
        r1 = r1.divide(BigInteger.TEN);
        int r3 = r1.compareTo(r7);
        if (r3 > 0) goto L8;
    L16:
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r8.ordinal()]) {
            case 1: goto L29;
            case 2: goto L33;
            case 3: goto L33;
            case 4: goto L25;
            case 5: goto L25;
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L20;
            default: goto L18;
        };
    L29:
        if (r3 != 0) goto L31;
        boolean r9 = true;
    L32:
        MathPreconditions.checkRoundingUnnecessary(r9);
        goto L33
    L31:
        r9 = false;
    L33:
        return r0;
    L18:
        throw new AssertionError();
    L20:
        if (r7.pow(2).compareTo(r1.pow(2).multiply(BigInteger.TEN)) > 0) goto L23;
        return r0;
    L23:
        return r0 + 1;
    L25:
        if (r1.equals(r7) == false) goto L28;
        return r0;
    L28:
        return r0 + 1;
    L11:
        BigInteger r4 = BigInteger.TEN.multiply(r1);
        int r5 = r2;
        int r6 = r4.compareTo(r7);
    L12:
        if (r6 > 0) goto L14;
        r0 = r0 + 1;
        BigInteger r10 = BigInteger.TEN.multiply(r4);
        int r11 = r10.compareTo(r7);
        BigInteger r12 = r4;
        r4 = r10;
        r1 = r12;
        r5 = r6;
        r6 = r11;
        goto L12
    L14:
        r3 = r5;
        goto L16
    L5:
        return LongMath.log10(r7.longValue(), r8);
    }

    public static BigInteger sqrt(BigInteger r3, RoundingMode r4) {
        MathPreconditions.checkNonNegative(MaterialConfigFormatNames.X, r3);
        if (fitsInLong(r3) == true) goto L5;
        BigInteger r0 = sqrtFloor(r3);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r4.ordinal()]) {
            case 1: goto L25;
            case 2: goto L26;
            case 3: goto L26;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L9;
        };
    L15:
        int r5 = r0.intValue();
        if ((r5 * r5) == r3.intValue()) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L24;
        return r0;
    L24:
        return r0.add(BigInteger.ONE);
    L18:
        if (r0.pow(2).equals(r3) == false) goto L20;
        r6 = true;
        goto L21
    L25:
        MathPreconditions.checkRoundingUnnecessary(r0.pow(2).equals(r3));
    L26:
        return r0;
    L9:
        throw new AssertionError();
    L11:
        if (r0.pow(2).add(r0).compareTo(r3) < 0) goto L14;
        return r0;
    L14:
        return r0.add(BigInteger.ONE);
    L5:
        return BigInteger.valueOf(LongMath.sqrt(r3.longValue(), r4));
    }

    private static BigInteger sqrtFloor(BigInteger r4) {
        int r0 = log2(r4, RoundingMode.FLOOR);
        if (r0 >= 1023) goto L5;
        BigInteger r1 = sqrtApproxWithDoubles(r4);
    L6:
        BigInteger r2 = r1.add(r4.divide(r1)).shiftRight(1);
        if (r1.equals(r2) == false) goto L9;
        return r1;
    L9:
        BigInteger r3 = r2.add(r4.divide(r2)).shiftRight(1);
        if (r3.compareTo(r2) >= 0) goto L11;
        r2 = r3;
        goto L9
    L11:
        return r2;
    L5:
        int r5 = (r0 - 52) & (-2);
        r1 = sqrtApproxWithDoubles(r4.shiftRight(r5)).shiftLeft(r5 >> 1);
        goto L6
    }

    private static BigInteger sqrtApproxWithDoubles(BigInteger r2) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(r2)), RoundingMode.HALF_EVEN);
    }

    public static BigInteger divide(BigInteger r1, BigInteger r2, RoundingMode r3) {
        return new BigDecimal(r1).divide(new BigDecimal(r2), 0, r3).toBigIntegerExact();
    }

    public static BigInteger factorial(int r17) {
        MathPreconditions.checkNonNegative("n", r17);
        if (r17 < LongMath.factorials.length) goto L5;
        ArrayList r2 = new ArrayList(IntMath.divide(IntMath.log2(r17, RoundingMode.CEILING) * r17, 64, RoundingMode.CEILING));
        int r1 = LongMath.factorials.length;
        long r4 = LongMath.factorials[r1 - 1];
        int r6 = Long.numberOfTrailingZeros(r4);
        long r5 = r4 >> r6;
        int r7 = LongMath.log2(r5, RoundingMode.FLOOR) + 1;
        long r9 = r1;
        int r3 = LongMath.log2(r9, RoundingMode.FLOOR) + 1;
        int r11 = 1 << (r3 - 1);
    L8:
        if (r9 > r17) goto L17;
        if ((r9 & ((long) r11)) == 0) goto L12;
        r11 = r11 << 1;
        r3 = r3 + 1;
    L12:
        int r12 = Long.numberOfTrailingZeros(r9);
        long r13 = r9 >> r12;
        r6 = r6 + r12;
        if (((r3 - r12) + r7) < 64) goto L15;
        r2.add(BigInteger.valueOf(r5));
        r5 = 1;
    L15:
        r5 = r5 * r13;
        r7 = LongMath.log2(r5, RoundingMode.FLOOR) + 1;
        r9 = r9 + 1;
        goto L8
    L17:
        if (r5 <= 1) goto L20;
        r2.add(BigInteger.valueOf(r5));
    L20:
        return listProduct(r2).shiftLeft(r6);
    L5:
        return BigInteger.valueOf(LongMath.factorials[r17]);
    }

    static BigInteger listProduct(List<BigInteger> r2) {
        return listProduct(r2, 0, r2.size());
    }

    static BigInteger listProduct(List<BigInteger> r4, int r5, int r6) {
        int r0 = r6 - r5;
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L13;
        int r1 = (r6 + r5) >>> 1;
        return listProduct(r4, r5, r1).multiply(listProduct(r4, r1, r6));
    L13:
        return r4.get(r5).multiply(r4.get(r5 + 1)).multiply(r4.get(r5 + 2));
    L15:
        return r4.get(r5).multiply(r4.get(r5 + 1));
    L17:
        return r4.get(r5);
    L19:
        return BigInteger.ONE;
    }

    public static BigInteger binomial(int r10, int r11) {
        MathPreconditions.checkNonNegative("n", r10);
        MathPreconditions.checkNonNegative("k", r11);
        int r1 = 1;
        if (r11 > r10) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "k (%s) > n (%s)", new Object[]{Integer.valueOf(r11), Integer.valueOf(r10)});
        if (r11 <= (r10 >> 1)) goto L10;
        r11 = r10 - r11;
    L10:
        if (r11 < LongMath.biggestBinomials.length) goto L12;
    L15:
        BigInteger r0 = BigInteger.ONE;
        long r3 = r10;
        int r4 = LongMath.log2(r3, RoundingMode.CEILING);
        long r5 = 1;
    L16:
        int r7 = r4;
    L17:
        if (r1 >= r11) goto L23;
        int r8 = r10 - r1;
        r1 = r1 + 1;
        r7 = r7 + r4;
        if (r7 >= 63) goto L20;
        r3 = r3 * ((long) r8);
        r5 = r5 * ((long) r1);
        goto L17
    L20:
        r0 = r0.multiply(BigInteger.valueOf(r3)).divide(BigInteger.valueOf(r5));
        r3 = r8;
        r5 = r1;
        goto L16
    L23:
        return r0.multiply(BigInteger.valueOf(r3)).divide(BigInteger.valueOf(r5));
    L12:
        if (r10 > LongMath.biggestBinomials[r11]) goto L15;
        return BigInteger.valueOf(LongMath.binomial(r10, r11));
    L5:
        r2 = false;
        goto L6
    }

    static boolean fitsInLong(BigInteger r1) {
        if (r1.bitLength() > 63) goto L5;
        return true;
    L5:
        return false;
    }

    private BigIntegerMath() {
    }
}
