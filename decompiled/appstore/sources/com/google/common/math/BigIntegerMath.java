package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class BigIntegerMath {
    private static final double LN_10 = 0.0d;
    private static final double LN_2 = 0.0d;

    @VisibleForTesting
    static final BigInteger SQRT2_PRECOMPUTED_BITS = null;

    @VisibleForTesting
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;

    /* JADX INFO: renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r10 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r10;
            r10[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
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

    static {
        SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
        LN_10 = Math.log(10.0d);
        LN_2 = Math.log(2.0d);
    }

    private BigIntegerMath() {
    }

    public static BigInteger binomial(int r10, int r11) {
        MathPreconditions.checkNonNegative("n", r10);
        MathPreconditions.checkNonNegative("k", r11);
        int r12 = 1;
        if (r11 > r10) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "k (%s) > n (%s)", r11, r10);
        if (r11 <= (r10 >> 1)) goto L9;
        r11 = r10 - r11;
    L9:
        int[] r14 = LongMath.biggestBinomials;
        if (r11 < r14.length) goto L12;
    L15:
        BigInteger r15 = BigInteger.ONE;
        long r16 = r10;
        int r17 = LongMath.log2(r16, RoundingMode.CEILING);
        long r18 = 1;
    L16:
        int r19 = r17;
    L17:
        if (r12 >= r11) goto L23;
        int r20 = r10 - r12;
        r12 = r12 + 1;
        r19 = r19 + r17;
        if (r19 >= 63) goto L20;
        r16 = r16 * ((long) r20);
        r18 = r18 * ((long) r12);
        goto L17
    L20:
        r15 = r15.multiply(BigInteger.valueOf(r16)).divide(BigInteger.valueOf(r18));
        r16 = r20;
        r18 = r12;
        goto L16
    L23:
        return r15.multiply(BigInteger.valueOf(r16)).divide(BigInteger.valueOf(r18));
    L12:
        if (r10 > r14[r11]) goto L15;
        return BigInteger.valueOf(LongMath.binomial(r10, r11));
    L5:
        r13 = false;
        goto L6
    }

    @Beta
    public static BigInteger ceilingPowerOfTwo(BigInteger r10) {
        return BigInteger.ZERO.setBit(log2(r10, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger divide(BigInteger r10, BigInteger r11, RoundingMode r12) {
        return new BigDecimal(r10).divide(new BigDecimal(r11), 0, r12).toBigIntegerExact();
    }

    public static BigInteger factorial(int r17) {
        MathPreconditions.checkNonNegative("n", r17);
        long[] r10 = LongMath.factorials;
        if (r17 < r10.length) goto L5;
        RoundingMode r11 = RoundingMode.CEILING;
        ArrayList r12 = new ArrayList(IntMath.divide(IntMath.log2(r17, r11) * r17, 64, r11));
        int r13 = r10.length;
        long r14 = r10[r13 - 1];
        int r15 = Long.numberOfTrailingZeros(r14);
        long r16 = r14 >> r15;
        RoundingMode r18 = RoundingMode.FLOOR;
        int r19 = LongMath.log2(r16, r18) + 1;
        long r110 = r13;
        int r20 = LongMath.log2(r110, r18);
        int r21 = r20 + 1;
        int r22 = 1 << r20;
    L8:
        if (r110 > r17) goto L17;
        if ((r110 & ((long) r22)) == 0) goto L12;
        r22 = r22 << 1;
        r21 = r21 + 1;
    L12:
        int r111 = Long.numberOfTrailingZeros(r110);
        long r112 = r110 >> r111;
        r15 = r15 + r111;
        if (((r21 - r111) + r19) < 64) goto L15;
        r12.add(BigInteger.valueOf(r16));
        r16 = 1;
    L15:
        r16 = r16 * r112;
        r19 = LongMath.log2(r16, RoundingMode.FLOOR) + 1;
        r110 = r110 + 1;
        goto L8
    L17:
        if (r16 <= 1) goto L20;
        r12.add(BigInteger.valueOf(r16));
    L20:
        return listProduct(r12).shiftLeft(r15);
    L5:
        return BigInteger.valueOf(r10[r17]);
    }

    @GwtIncompatible
    public static boolean fitsInLong(BigInteger r10) {
        if (r10.bitLength() > 63) goto L5;
        return true;
    L5:
        return false;
    }

    @Beta
    public static BigInteger floorPowerOfTwo(BigInteger r10) {
        return BigInteger.ZERO.setBit(log2(r10, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger r10) {
        Preconditions.checkNotNull(r10);
        if (r10.signum() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r10.getLowestSetBit() != (r10.bitLength() - 1)) goto L7;
        return true;
    }

    public static BigInteger listProduct(List<BigInteger> r10) {
        return listProduct(r10, 0, r10.size());
    }

    @GwtIncompatible
    public static int log10(BigInteger r10, RoundingMode r11) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        if (fitsInLong(r10) == true) goto L5;
        int r12 = (int) ((((double) log2(r10, RoundingMode.FLOOR)) * LN_2) / LN_10);
        BigInteger r13 = BigInteger.TEN;
        BigInteger r14 = r13.pow(r12);
        int r15 = r14.compareTo(r10);
        if (r15 <= 0) goto L11;
    L8:
        r12 = r12 - 1;
        r14 = r14.divide(BigInteger.TEN);
        int r16 = r14.compareTo(r10);
        if (r16 > 0) goto L8;
    L16:
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
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
        if (r16 != 0) goto L31;
        boolean r17 = true;
    L32:
        MathPreconditions.checkRoundingUnnecessary(r17);
        goto L33
    L31:
        r17 = false;
    L33:
        return r12;
    L18:
        throw new AssertionError();
    L20:
        if (r10.pow(2).compareTo(r14.pow(2).multiply(BigInteger.TEN)) > 0) goto L23;
        return r12;
    L23:
        return r12 + 1;
    L25:
        if (r14.equals(r10) == false) goto L28;
        return r12;
    L28:
        return r12 + 1;
    L11:
        BigInteger r18 = r13.multiply(r14);
        int r19 = r15;
        int r20 = r18.compareTo(r10);
    L12:
        if (r20 > 0) goto L14;
        r12 = r12 + 1;
        BigInteger r21 = BigInteger.TEN.multiply(r18);
        int r22 = r21.compareTo(r10);
        r14 = r18;
        r18 = r21;
        r19 = r20;
        r20 = r22;
        goto L12
    L14:
        r16 = r19;
        goto L16
    L5:
        return LongMath.log10(r10.longValue(), r11);
    }

    public static int log2(BigInteger r10, RoundingMode r11) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, (BigInteger) Preconditions.checkNotNull(r10));
        int r12 = r10.bitLength();
        int r13 = r12 - 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L20;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L5;
        };
    L20:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r10));
    L21:
        return r13;
    L5:
        throw new AssertionError();
    L7:
        if (r13 >= 256) goto L13;
        if (r10.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - r13)) > 0) goto L11;
        return r13;
    L11:
        return r12;
    L13:
        if ((r10.pow(2).bitLength() - 1) < ((r13 * 2) + 1)) goto L15;
        return r12;
    L15:
        return r13;
    L17:
        if (isPowerOfTwo(r10) == true) goto L19;
        return r12;
    L19:
        return r13;
    }

    @GwtIncompatible
    public static BigInteger sqrt(BigInteger r10, RoundingMode r11) {
        MathPreconditions.checkNonNegative(FixCard.FixStyle.KEY_X, r10);
        if (fitsInLong(r10) == true) goto L5;
        BigInteger r12 = sqrtFloor(r10);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L22;
            case 2: goto L23;
            case 3: goto L23;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L9;
        };
    L15:
        int r13 = r12.intValue();
        if ((r13 * r13) != r10.intValue()) goto L21;
        if (r12.pow(2).equals(r10) == false) goto L21;
        return r12;
    L21:
        return r12.add(BigInteger.ONE);
    L22:
        MathPreconditions.checkRoundingUnnecessary(r12.pow(2).equals(r10));
    L23:
        return r12;
    L9:
        throw new AssertionError();
    L11:
        if (r12.pow(2).add(r12).compareTo(r10) < 0) goto L14;
        return r12;
    L14:
        return r12.add(BigInteger.ONE);
    L5:
        return BigInteger.valueOf(LongMath.sqrt(r10.longValue(), r11));
    }

    @GwtIncompatible
    private static BigInteger sqrtApproxWithDoubles(BigInteger r10) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(r10)), RoundingMode.HALF_EVEN);
    }

    @GwtIncompatible
    private static BigInteger sqrtFloor(BigInteger r10) {
        int r11 = log2(r10, RoundingMode.FLOOR);
        if (r11 >= 1023) goto L5;
        BigInteger r12 = sqrtApproxWithDoubles(r10);
    L6:
        BigInteger r13 = r12.add(r10.divide(r12)).shiftRight(1);
        if (r12.equals(r13) == false) goto L9;
        return r12;
    L9:
        BigInteger r14 = r13.add(r10.divide(r13)).shiftRight(1);
        if (r14.compareTo(r13) >= 0) goto L11;
        r13 = r14;
        goto L9
    L11:
        return r13;
    L5:
        int r15 = (r11 - 52) & (-2);
        r12 = sqrtApproxWithDoubles(r10.shiftRight(r15)).shiftLeft(r15 >> 1);
        goto L6
    }

    public static BigInteger listProduct(List<BigInteger> r10, int r11, int r12) {
        int r13 = r12 - r11;
        if (r13 == 0) goto L19;
        if (r13 == 1) goto L17;
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L13;
        int r14 = (r12 + r11) >>> 1;
        return listProduct(r10, r11, r14).multiply(listProduct(r10, r14, r12));
    L13:
        return r10.get(r11).multiply(r10.get(r11 + 1)).multiply(r10.get(r11 + 2));
    L15:
        return r10.get(r11).multiply(r10.get(r11 + 1));
    L17:
        return r10.get(r11);
    L19:
        return BigInteger.ONE;
    }
}
