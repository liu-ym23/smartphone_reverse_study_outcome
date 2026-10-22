package com.google.common.math;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.math.RoundingMode;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class LongMath {

    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;

    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;

    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final int[] biggestBinomials = null;

    @VisibleForTesting
    static final int[] biggestSimpleBinomials = null;
    static final long[] factorials = null;

    @VisibleForTesting
    @GwtIncompatible
    static final long[] halfPowersOf10 = null;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = null;
    private static final long[][] millerRabinBaseSets = null;

    @VisibleForTesting
    @GwtIncompatible
    static final long[] powersOf10 = null;

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
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

    public static abstract enum MillerRabinTester extends Enum<MillerRabinTester> {
        private static final /* synthetic */ MillerRabinTester[] $VALUES = null;
        public static final MillerRabinTester LARGE = null;
        public static final MillerRabinTester SMALL = null;

        static {
            final String r10 = "SMALL";
            final int r11 = 0;
            MillerRabinTester r12 = new AnonymousClass1(r10, r11);
            SMALL = r12;
            final String r13 = "LARGE";
            final int r14 = 1;
            MillerRabinTester r15 = new AnonymousClass2(r13, r14);
            LARGE = r15;
            $VALUES = new MillerRabinTester[]{r12, r15};
        }

        private MillerRabinTester(String r10, int r11) {
            super(r10, r11);
        }

        private long powMod(long r10, long r12, long r14) {
            long r11 = 1;
        L4:
            if (r12 == 0) goto L9;
            if ((r12 & 1) == 0) goto L8;
            r11 = mulMod(r11, r10, r14);
        L8:
            r10 = squareMod(r10, r14);
            r12 = r12 >> 1;
            goto L4
        L9:
            return r11;
        }

        public static boolean test(long r10, long r11) {
            if (r11 > LongMath.FLOOR_SQRT_MAX_LONG) goto L5;
            MillerRabinTester r12 = SMALL;
        L7:
            return r12.testWitness(r10, r11);
        L5:
            r12 = LARGE;
            goto L7
        }

        private boolean testWitness(long r16, long r18) {
            long r11 = r18 - 1;
            int r13 = Long.numberOfTrailingZeros(r11);
            long r10 = r11 >> r13;
            long r12 = r16 % r18;
            if (r12 != 0) goto L5;
            return true;
        L5:
            long r14 = powMod(r12, r10, r18);
            if (r14 != 1) goto L8;
            return true;
        L8:
            int r15 = 0;
        L10:
            if (r14 == r11) goto L15;
            r15 = r15 + 1;
            if (r15 == r13) goto L13;
            r14 = squareMod(r14, r18);
            goto L10
        L13:
            return false;
        L15:
            return true;
        }

        public static MillerRabinTester valueOf(String r10) {
            return (MillerRabinTester) Enum.valueOf(MillerRabinTester.class, r10);
        }

        public static MillerRabinTester[] values() {
            return (MillerRabinTester[]) $VALUES.clone();
        }

        public abstract long mulMod(long r10, long r11, long r12);

        public abstract long squareMod(long r10, long r11);

        public /* synthetic */ MillerRabinTester(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    static {
        maxLog10ForLeadingZeros = new byte[]{19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
        powersOf10 = new long[]{1, 10, 100, 1000, 10000, 100000, BatteryFactorConfig.WIFI_BPS, StackLeakChecker.CHECK_INTERVAL_10_SEC, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        halfPowersOf10 = new long[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
        factorials = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
        biggestBinomials = new int[]{Channel.UNLIMITED, Channel.UNLIMITED, Channel.UNLIMITED, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
        biggestSimpleBinomials = new int[]{Channel.UNLIMITED, Channel.UNLIMITED, Channel.UNLIMITED, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
        millerRabinBaseSets = new long[][]{new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    }

    private LongMath() {
    }

    public static long binomial(int r11, int r12) {
        MathPreconditions.checkNonNegative("n", r11);
        MathPreconditions.checkNonNegative("k", r12);
        if (r12 > r11) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkArgument(r10, "k (%s) > n (%s)", r12, r11);
        if (r12 <= (r11 >> 1)) goto L9;
        r12 = r11 - r12;
    L9:
        long r13 = 1;
        if (r12 == 0) goto L42;
        if (r12 == 1) goto L41;
        long[] r14 = factorials;
        if (r11 < r14.length) goto L15;
        int[] r15 = biggestBinomials;
        if (r12 < r15.length) goto L19;
        return Long.MAX_VALUE;
    L19:
        if (r11 > r15[r12]) goto L47;
        int[] r16 = biggestSimpleBinomials;
        int r17 = 2;
        if (r12 < r16.length) goto L24;
    L29:
        long r18 = r11;
        int r19 = log2(r18, RoundingMode.CEILING);
        int r110 = r11 - 1;
        int r20 = r19;
        int r21 = 2;
        long r22 = r18;
        long r23 = 1;
    L30:
        if (r21 > r12) goto L37;
        r20 = r20 + r19;
        if (r20 >= 63) goto L34;
        r22 = r22 * ((long) r110);
        r23 = r23 * ((long) r21);
    L35:
        r21 = r21 + 1;
        r110 = r110 - 1;
        goto L30
    L34:
        r13 = multiplyFraction(r13, r22, r23);
        r22 = r110;
        r23 = r21;
        r20 = r19;
        goto L35
    L37:
        return multiplyFraction(r13, r22, r23);
    L24:
        if (r11 > r16[r12]) goto L29;
        int r24 = r11 - 1;
        long r25 = r11;
    L26:
        if (r17 > r12) goto L28;
        r25 = (r25 * ((long) r24)) / ((long) r17);
        r24 = r24 - 1;
        r17 = r17 + 1;
        goto L26
    L28:
        return r25;
    L47:
        return Long.MAX_VALUE;
    L15:
        return r14[r11] / (r14[r12] * r14[r11 - r12]);
    L41:
        return r11;
    L42:
        return 1;
    L5:
        r10 = false;
        goto L6
    }

    @Beta
    public static long ceilingPowerOfTwo(long r10) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        if (r10 > 4611686018427387904L) goto L7;
        return 1 << (-Long.numberOfLeadingZeros(r10 - 1));
    L7:
        throw new ArithmeticException("ceilingPowerOfTwo(" + r10 + ") is not representable as a long");
    }

    @GwtIncompatible
    public static long checkedAdd(long r10, long r12) {
        long r11 = r10 + r12;
        boolean r13 = false;
        if ((r10 ^ r12) >= 0) goto L5;
        boolean r14 = true;
    L7:
        if ((r10 ^ r11) < 0) goto L9;
        r13 = true;
    L9:
        MathPreconditions.checkNoOverflow(r14 | r13, "checkedAdd", r10, r12);
        return r11;
    L5:
        r14 = false;
        goto L7
    }

    public static long checkedMultiply(long r12, long r14) {
        int r10 = ((Long.numberOfLeadingZeros(r12) + Long.numberOfLeadingZeros(~r12)) + Long.numberOfLeadingZeros(r14)) + Long.numberOfLeadingZeros(~r14);
        if (r10 <= 65) goto L7;
        return r12 * r14;
    L7:
        if (r10 < 64) goto L9;
        boolean r11 = true;
    L10:
        MathPreconditions.checkNoOverflow(r11, "checkedMultiply", r12, r14);
        if (r12 < 0) goto L13;
        boolean r13 = true;
    L15:
        if (r14 == Long.MIN_VALUE) goto L17;
        boolean r15 = true;
    L18:
        MathPreconditions.checkNoOverflow(r13 | r15, "checkedMultiply", r12, r14);
        long r16 = r12 * r14;
        if (r12 != 0) goto L21;
    L24:
        boolean r17 = true;
    L25:
        MathPreconditions.checkNoOverflow(r17, "checkedMultiply", r12, r14);
        return r16;
    L21:
        if ((r16 / r12) == r14) goto L24;
        r17 = false;
        goto L25
    L17:
        r15 = false;
        goto L18
    L13:
        r13 = false;
        goto L15
    L9:
        r11 = false;
        goto L10
    }

    @GwtIncompatible
    public static long checkedPow(long r13, int r15) {
        MathPreconditions.checkNonNegative("exponent", r15);
        if (r13 < (-2)) goto L5;
        boolean r10 = true;
    L7:
        if (r13 > 2) goto L9;
        boolean r11 = true;
    L10:
        long r12 = 1;
        if ((r10 & r11) == false) goto L47;
        int r14 = (int) r13;
        if (r14 == (-2)) goto L39;
        if (r14 == (-1)) goto L34;
        if (r14 == 0) goto L29;
        if (r14 != 1) goto L19;
        return 1;
    L19:
        if (r14 != 2) goto L27;
        if (r15 >= 63) goto L23;
        boolean r16 = true;
    L24:
        MathPreconditions.checkNoOverflow(r16, "checkedPow", r13, r15);
        return 1 << r15;
    L23:
        r16 = false;
        goto L24
    L27:
        throw new AssertionError();
    L29:
        if (r15 == 0) goto L70;
        return 0;
    L70:
        return 1;
    L34:
        if ((r15 & 1) != 0) goto L37;
        return 1;
    L37:
        return -1;
    L39:
        if (r15 >= 64) goto L41;
        boolean r17 = true;
    L42:
        MathPreconditions.checkNoOverflow(r17, "checkedPow", r13, r15);
        if ((r15 & 1) != 0) goto L46;
        return 1 << r15;
    L46:
        return (-1) << r15;
    L41:
        r17 = false;
        goto L42
    L47:
        long r18 = r13;
        int r19 = r15;
    L48:
        if (r19 == 0) goto L65;
        if (r19 == 1) goto L64;
        if ((r19 & 1) == 0) goto L53;
        r12 = checkedMultiply(r12, r18);
    L53:
        long r110 = r12;
        int r20 = r19 >> 1;
        if (r20 <= 0) goto L62;
        if ((-3037000499L) <= r18) goto L58;
    L60:
        boolean r21 = false;
    L61:
        MathPreconditions.checkNoOverflow(r21, "checkedPow", r18, r20);
        r18 = r18 * r18;
        goto L62
    L58:
        if (r18 > FLOOR_SQRT_MAX_LONG) goto L60;
        r21 = true;
    L62:
        r19 = r20;
        r12 = r110;
        goto L48
    L64:
        return checkedMultiply(r12, r18);
    L65:
        return r12;
    L9:
        r11 = false;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    @GwtIncompatible
    public static long checkedSubtract(long r10, long r12) {
        long r11 = r10 - r12;
        boolean r13 = false;
        if ((r10 ^ r12) < 0) goto L5;
        boolean r14 = true;
    L7:
        if ((r10 ^ r11) < 0) goto L9;
        r13 = true;
    L9:
        MathPreconditions.checkNoOverflow(r14 | r13, "checkedSubtract", r10, r12);
        return r11;
    L5:
        r14 = false;
        goto L7
    }

    @GwtIncompatible
    public static long divide(long r10, long r11, RoundingMode r13) {
        Preconditions.checkNotNull(r13);
        long r12 = r10 / r11;
        long r14 = r10 - (r11 * r12);
        if (r14 != 0) goto L5;
        return r12;
    L5:
        boolean r15 = true;
        int r16 = ((int) ((r10 ^ r11) >> 63)) | 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r13.ordinal()]) {
            case 1: goto L30;
            case 2: goto L34;
            case 3: goto L28;
            case 4: goto L35;
            case 5: goto L26;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        long r17 = Math.abs(r14);
        long r18 = r17 - (Math.abs(r11) - r17);
        if (r18 == 0) goto L12;
        if (r18 <= 0) goto L34;
    L12:
        if (r13 != RoundingMode.HALF_UP) goto L14;
        boolean r19 = true;
    L16:
        if (r13 != RoundingMode.HALF_EVEN) goto L18;
        boolean r110 = true;
    L20:
        if ((1 & r12) != 0) goto L23;
        r15 = false;
    L23:
        r15 = (r15 & r110) | r19;
        goto L35
    L18:
        r110 = false;
        goto L20
    L14:
        r19 = false;
        goto L16
    L26:
        if (r16 <= 0) goto L34;
    L28:
        if (r16 >= 0) goto L34;
    L30:
        if (r14 == 0) goto L33;
        r15 = false;
    L33:
        MathPreconditions.checkRoundingUnnecessary(r15);
    L34:
        r15 = false;
    L35:
        if (r15 == true) goto L37;
        return r12;
    L37:
        return r12 + ((long) r16);
    L8:
        throw new AssertionError();
    }

    @GwtIncompatible
    public static long factorial(int r10) {
        MathPreconditions.checkNonNegative("n", r10);
        long[] r11 = factorials;
        if (r10 < r11.length) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r11[r10];
    }

    public static boolean fitsInInt(long r10) {
        if (((int) r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Beta
    public static long floorPowerOfTwo(long r10) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        return 1 << (63 - Long.numberOfLeadingZeros(r10));
    }

    public static long gcd(long r10, long r11) {
        MathPreconditions.checkNonNegative("a", r10);
        MathPreconditions.checkNonNegative("b", r11);
        if (r10 != 0) goto L6;
        return r11;
    L6:
        if (r11 != 0) goto L8;
        return r10;
    L8:
        int r12 = Long.numberOfTrailingZeros(r10);
        long r13 = r10 >> r12;
        int r14 = Long.numberOfTrailingZeros(r11);
        long r15 = r11 >> r14;
    L10:
        if (r13 == r15) goto L13;
        long r16 = r13 - r15;
        long r17 = (r16 >> 63) & r16;
        long r18 = (r16 - r17) - r17;
        r15 = r15 + r17;
        r13 = r18 >> Long.numberOfTrailingZeros(r18);
        goto L10
    L13:
        return r13 << Math.min(r12, r14);
    }

    public static boolean isPowerOfTwo(long r10) {
        boolean r11 = false;
        if (r10 <= 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r10 & (r10 - 1)) != 0) goto L10;
        r11 = true;
    L10:
        return r12 & r11;
    L5:
        r12 = false;
        goto L7
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long r11) {
        if (r11 >= 2) goto L7;
        MathPreconditions.checkNonNegative("n", r11);
        return false;
    L7:
        if (r11 != 2) goto L9;
    L48:
        return true;
    L9:
        if (r11 == 3) goto L48;
        if (r11 == 5) goto L48;
        if (r11 == 7) goto L48;
        if (r11 == 11) goto L48;
        if (r11 == 13) goto L48;
        if (((1 << ((int) (r11 % 30))) & SIEVE_30) == 0) goto L23;
        return false;
    L23:
        if ((r11 % 7) != 0) goto L25;
    L47:
        return false;
    L25:
        if ((r11 % 11) == 0) goto L47;
        if ((r11 % 13) == 0) goto L47;
        if (r11 >= 289) goto L32;
        return true;
    L32:
        long[][] r10 = millerRabinBaseSets;
        int r12 = r10.length;
        int r13 = 0;
    L33:
        if (r13 >= r12) goto L46;
        long[] r14 = r10[r13];
        if (r11 <= r14[0]) goto L36;
        r13 = r13 + 1;
        goto L33
    L36:
        int r15 = 1;
    L38:
        if (r15 >= r14.length) goto L43;
        if (MillerRabinTester.test(r14[r15], r11) == false) goto L41;
        r15 = r15 + 1;
        goto L38
    L41:
        return false;
    L43:
        return true;
    L46:
        throw new AssertionError();
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long r10, long r11) {
        return (int) ((~(~(r10 - r11))) >>> 63);
    }

    @GwtIncompatible
    public static int log10(long r10, RoundingMode r11) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        int r12 = log10Floor(r10);
        long r13 = powersOf10[r12];
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L11;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r14 = lessThanBranchFree(halfPowersOf10[r12], r10);
    L8:
        return r12 + r14;
    L9:
        r14 = lessThanBranchFree(r13, r10);
    L15:
        return r12;
    L5:
        throw new AssertionError();
    L11:
        if (r10 != r13) goto L13;
        boolean r15 = true;
    L14:
        MathPreconditions.checkRoundingUnnecessary(r15);
        goto L15
    L13:
        r15 = false;
        goto L14
    }

    @GwtIncompatible
    public static int log10Floor(long r10) {
        byte r11 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(r10)];
        return r11 - lessThanBranchFree(r10, powersOf10[r11]);
    }

    public static int log2(long r10, RoundingMode r11) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L10;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r12 = Long.numberOfLeadingZeros(r10);
        long r13 = MAX_POWER_OF_SQRT2_UNSIGNED >>> r12;
        return (63 - r12) + lessThanBranchFree(r13, r10);
    L10:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r10));
        goto L12
    L5:
        throw new AssertionError("impossible");
    L9:
        return 64 - Long.numberOfLeadingZeros(r10 - 1);
    L12:
        return 63 - Long.numberOfLeadingZeros(r10);
    }

    public static long mean(long r10, long r11) {
        return (r10 & r11) + ((r10 ^ r11) >> 1);
    }

    @GwtIncompatible
    public static int mod(long r10, int r11) {
        return (int) mod(r10, r11);
    }

    public static long multiplyFraction(long r10, long r11, long r12) {
        if (r10 == 1) goto L5;
        long r13 = gcd(r10, r12);
        return (r10 / r13) * (r11 / (r12 / r13));
    L5:
        return r11 / r12;
    }

    @GwtIncompatible
    public static long pow(long r10, int r11) {
        MathPreconditions.checkNonNegative("exponent", r11);
        if ((-2) <= r10) goto L5;
    L36:
        long r12 = 1;
    L37:
        if (r11 == 0) goto L54;
        if (r11 == 1) goto L45;
        if ((r11 & 1) != 0) goto L42;
        long r13 = 1;
    L43:
        r12 = r12 * r13;
        r10 = r10 * r10;
        r11 = r11 >> 1;
        goto L37
    L42:
        r13 = r10;
        goto L43
    L45:
        return r12 * r10;
    L54:
        return r12;
    L5:
        if (r10 > 2) goto L36;
        int r14 = (int) r10;
        if (r14 != (-2)) goto L9;
        if (r11 < 64) goto L31;
        return 0;
    L31:
        if ((r11 & 1) != 0) goto L34;
        return 1 << r11;
    L34:
        return -(1 << r11);
    L9:
        if (r14 == (-1)) goto L25;
        if (r14 == 0) goto L20;
        if (r14 != 1) goto L13;
        return 1;
    L13:
        if (r14 != 2) goto L18;
        if (r11 < 64) goto L16;
        return 0;
    L16:
        return 1 << r11;
    L18:
        throw new AssertionError();
    L20:
        if (r11 != 0) goto L23;
        return 1;
    L23:
        return 0;
    L25:
        if ((r11 & 1) == 0) goto L52;
        return -1;
    L52:
        return 1;
    }

    @Beta
    public static long saturatedAdd(long r10, long r11) {
        long r12 = r10 + r11;
        boolean r13 = false;
        if ((r11 ^ r10) >= 0) goto L5;
        boolean r14 = true;
    L7:
        if ((r10 ^ r12) < 0) goto L10;
        r13 = true;
    L10:
        if ((r14 | r13) == false) goto L13;
        return r12;
    L13:
        return ((r12 >>> 63) ^ 1) + Long.MAX_VALUE;
    L5:
        r14 = false;
        goto L7
    }

    @Beta
    public static long saturatedMultiply(long r10, long r11) {
        int r12 = ((Long.numberOfLeadingZeros(r10) + Long.numberOfLeadingZeros(~r10)) + Long.numberOfLeadingZeros(r11)) + Long.numberOfLeadingZeros(~r11);
        if (r12 > 65) goto L5;
        long r13 = ((r10 ^ r11) >>> 63) + Long.MAX_VALUE;
        boolean r14 = false;
        if (r12 >= 64) goto L9;
        boolean r15 = true;
    L11:
        if (r10 >= 0) goto L13;
        boolean r16 = true;
    L15:
        if (r11 != Long.MIN_VALUE) goto L18;
        r14 = true;
    L18:
        if ((r15 | (r14 & r16)) == false) goto L20;
        return r13;
    L20:
        long r17 = r10 * r11;
        if (r10 != 0) goto L23;
    L26:
        return r17;
    L23:
        if ((r17 / r10) == r11) goto L26;
        return r13;
    L13:
        r16 = false;
        goto L15
    L9:
        r15 = false;
        goto L11
    L5:
        return r10 * r11;
    }

    @Beta
    public static long saturatedPow(long r12, int r14) {
        MathPreconditions.checkNonNegative("exponent", r14);
        if (r12 < (-2)) goto L5;
        boolean r10 = true;
    L7:
        if (r12 > 2) goto L9;
        boolean r11 = true;
    L10:
        long r13 = 1;
        if ((r10 & r11) == false) goto L45;
        int r15 = (int) r12;
        if (r15 == (-2)) goto L37;
        if (r15 == (-1)) goto L32;
        if (r15 == 0) goto L27;
        if (r15 != 1) goto L19;
        return 1;
    L19:
        if (r15 != 2) goto L25;
        if (r14 < 63) goto L23;
        return Long.MAX_VALUE;
    L23:
        return 1 << r14;
    L25:
        throw new AssertionError();
    L27:
        if (r14 == 0) goto L75;
        return 0;
    L75:
        return 1;
    L32:
        if ((r14 & 1) != 0) goto L35;
        return 1;
    L35:
        return -1;
    L37:
        if (r14 < 64) goto L41;
        return ((long) (r14 & 1)) + Long.MAX_VALUE;
    L41:
        if ((r14 & 1) != 0) goto L44;
        return 1 << r14;
    L44:
        return (-1) << r14;
    L45:
        long r16 = ((r12 >>> 63) & ((long) (r14 & 1))) + Long.MAX_VALUE;
    L46:
        if (r14 == 0) goto L67;
        if (r14 == 1) goto L66;
        if ((r14 & 1) == 0) goto L51;
        r13 = saturatedMultiply(r13, r12);
    L51:
        r14 = r14 >> 1;
        if (r14 <= 0) goto L46;
        if ((-3037000499L) <= r12) goto L56;
        boolean r17 = true;
    L58:
        if (r12 <= FLOOR_SQRT_MAX_LONG) goto L60;
        boolean r18 = true;
    L62:
        if ((r17 | r18) == true) goto L63;
        r12 = r12 * r12;
        goto L46
    L63:
        return r16;
    L60:
        r18 = false;
        goto L62
    L56:
        r17 = false;
        goto L58
    L66:
        return saturatedMultiply(r13, r12);
    L67:
        return r13;
    L9:
        r11 = false;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    @Beta
    public static long saturatedSubtract(long r10, long r11) {
        long r12 = r10 - r11;
        boolean r13 = false;
        if ((r11 ^ r10) < 0) goto L5;
        boolean r14 = true;
    L7:
        if ((r10 ^ r12) < 0) goto L10;
        r13 = true;
    L10:
        if ((r14 | r13) == false) goto L13;
        return r12;
    L13:
        return ((r12 >>> 63) ^ 1) + Long.MAX_VALUE;
    L5:
        r14 = false;
        goto L7
    }

    @GwtIncompatible
    public static long sqrt(long r10, RoundingMode r11) {
        MathPreconditions.checkNonNegative(FixCard.FixStyle.KEY_X, r10);
        if (fitsInInt(r10) == true) goto L5;
        long r12 = (long) Math.sqrt(r10);
        long r13 = r12 * r12;
        boolean r14 = false;
        int r15 = 0;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L24;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        throw new AssertionError();
    L11:
        if (r10 >= r13) goto L13;
        r15 = 1;
    L13:
        long r16 = r12 - ((long) r15);
        return r16 + ((long) lessThanBranchFree((r16 * r16) + r16, r10));
    L16:
        if (r10 > r13) goto L18;
        return r12;
    L18:
        return r12 + 1;
    L20:
        if (r10 < r13) goto L22;
        return r12;
    L22:
        return r12 - 1;
    L24:
        if (r13 != r10) goto L26;
        r14 = true;
    L26:
        MathPreconditions.checkRoundingUnnecessary(r14);
        return r12;
    L5:
        return IntMath.sqrt((int) r10, r11);
    }

    @GwtIncompatible
    public static long mod(long r10, long r11) {
        if (r11 <= 0) goto L10;
        long r12 = r10 % r11;
        if (r12 < 0) goto L8;
        return r12;
    L8:
        return r12 + r11;
    L10:
        throw new ArithmeticException("Modulus must be positive");
    }
}
