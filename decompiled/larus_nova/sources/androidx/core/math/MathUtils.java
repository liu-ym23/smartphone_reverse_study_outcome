package androidx.core.math;

import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes17.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static double clamp(double r100, double r101, double r102) {
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        if (r100 <= r102) goto L8;
        return r102;
    L8:
        return r100;
    }

    public static float clamp(float r100, float r101, float r102) {
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        if (r100 <= r102) goto L8;
        return r102;
    L8:
        return r100;
    }

    public static int clamp(int r100, int r101, int r102) {
        if (r100 >= r101) goto L4;
        return r101;
    L4:
        if (r100 <= r102) goto L6;
        return r102;
    L6:
        return r100;
    }

    public static long clamp(long r100, long r101, long r102) {
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        if (r100 <= r102) goto L8;
        return r102;
    L8:
        return r100;
    }

    public static long decrementExact(long r100) {
        if (r100 == Long.MIN_VALUE) goto L7;
        return r100 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long r100) {
        if (r100 == Long.MAX_VALUE) goto L7;
        return r100 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long r100) {
        if (r100 == Long.MIN_VALUE) goto L7;
        return -r100;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int toIntExact(long r100) {
        if (r100 > SieveCacheKt.NodeLinkMask) goto L9;
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        return (int) r100;
    L9:
        throw new ArithmeticException("integer overflow");
    }

    public static int decrementExact(int r100) {
        if (r100 == Integer.MIN_VALUE) goto L7;
        return r100 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int r100) {
        if (r100 == Integer.MAX_VALUE) goto L7;
        return r100 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int r100) {
        if (r100 == Integer.MIN_VALUE) goto L7;
        return -r100;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long r100, long r101) {
        long r102 = r100 + r101;
        boolean r103 = true;
        if (r100 < 0) goto L5;
        boolean r104 = true;
    L7:
        if (r101 < 0) goto L9;
        boolean r105 = true;
    L10:
        if (r104 != r105) goto L22;
        if (r100 < 0) goto L13;
        boolean r106 = true;
    L15:
        if (r102 >= 0) goto L18;
        r103 = false;
    L18:
        if (r106 == r103) goto L22;
        throw new ArithmeticException("integer overflow");
    L13:
        r106 = false;
    L22:
        return r102;
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    public static long multiplyExact(long r100, long r101) {
        long r102 = r100 * r101;
        if (r100 != 0) goto L5;
    L13:
        return r102;
    L5:
        if (r101 == 0) goto L13;
        if ((r102 / r100) != r101) goto L12;
        if ((r102 / r101) == r100) goto L13;
    L12:
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long r100, long r101) {
        long r102 = r100 - r101;
        boolean r103 = true;
        if (r100 >= 0) goto L5;
        boolean r104 = true;
    L7:
        if (r101 >= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r104 == r105) goto L22;
        if (r100 >= 0) goto L13;
        boolean r106 = true;
    L15:
        if (r102 < 0) goto L18;
        r103 = false;
    L18:
        if (r106 == r103) goto L22;
        throw new ArithmeticException("integer overflow");
    L13:
        r106 = false;
    L22:
        return r102;
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    public static int addExact(int r100, int r101) {
        int r102 = r100 + r101;
        boolean r103 = true;
        if (r100 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r101 < 0) goto L8;
        boolean r105 = true;
    L9:
        if (r104 != r105) goto L20;
        if (r100 < 0) goto L12;
        boolean r106 = true;
    L13:
        if (r102 >= 0) goto L16;
        r103 = false;
    L16:
        if (r106 == r103) goto L20;
        throw new ArithmeticException("integer overflow");
    L12:
        r106 = false;
    L20:
        return r102;
    L8:
        r105 = false;
        goto L9
    L5:
        r104 = false;
        goto L6
    }

    public static int multiplyExact(int r100, int r101) {
        int r102 = r100 * r101;
        if (r100 == 0) goto L12;
        if (r101 == 0) goto L12;
        if ((r102 / r100) != r101) goto L11;
        if ((r102 / r101) == r100) goto L12;
    L11:
        throw new ArithmeticException("integer overflow");
    L12:
        return r102;
    }

    public static int subtractExact(int r100, int r101) {
        int r102 = r100 - r101;
        boolean r103 = true;
        if (r100 >= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r101 >= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r104 == r105) goto L20;
        if (r100 >= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r102 < 0) goto L16;
        r103 = false;
    L16:
        if (r106 == r103) goto L20;
        throw new ArithmeticException("integer overflow");
    L12:
        r106 = false;
    L20:
        return r102;
    L8:
        r105 = false;
        goto L9
    L5:
        r104 = false;
        goto L6
    }
}
