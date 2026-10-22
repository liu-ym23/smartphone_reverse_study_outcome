package androidx.core.math;

import androidx.collection.SieveCacheKt;

/* loaded from: classes2.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i, int i6) {
        int i10 = i + i6;
        if ((i >= 0) == (i6 >= 0)) {
            if ((i >= 0) != (i10 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i10;
    }

    public static double clamp(double d, double d6, double d10) {
        return d < d6 ? d6 : d > d10 ? d10 : d;
    }

    public static int decrementExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return i - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i) {
        if (i != Integer.MAX_VALUE) {
            return i + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i, int i6) {
        int i10 = i * i6;
        if (i == 0 || i6 == 0 || (i10 / i == i6 && i10 / i6 == i)) {
            return i10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return -i;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i, int i6) {
        int i10 = i - i6;
        if ((i < 0) != (i6 < 0)) {
            if ((i < 0) != (i10 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i10;
    }

    public static int toIntExact(long j5) {
        if (j5 > SieveCacheKt.NodeLinkMask || j5 < SieveCacheKt.NodeMetaAndPreviousMask) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j5;
    }

    public static long addExact(long j5, long j6) {
        long j10 = j5 + j6;
        if ((j5 >= 0) == (j6 >= 0)) {
            if ((j5 >= 0) != (j10 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j10;
    }

    public static float clamp(float f, float f7, float f9) {
        return f < f7 ? f7 : f > f9 ? f9 : f;
    }

    public static long decrementExact(long j5) {
        if (j5 != Long.MIN_VALUE) {
            return j5 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j5) {
        if (j5 != Long.MAX_VALUE) {
            return j5 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j5) {
        if (j5 != Long.MIN_VALUE) {
            return -j5;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j5, long j6) {
        long j10 = j5 - j6;
        if ((j5 < 0) != (j6 < 0)) {
            if ((j5 < 0) != (j10 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j10;
    }

    public static int clamp(int i, int i6, int i10) {
        return i < i6 ? i6 : i > i10 ? i10 : i;
    }

    public static long multiplyExact(long j5, long j6) {
        long j10 = j5 * j6;
        if (j5 == 0 || j6 == 0 || (j10 / j5 == j6 && j10 / j6 == j5)) {
            return j10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j5, long j6, long j10) {
        return j5 < j6 ? j6 : j5 > j10 ? j10 : j5;
    }
}
