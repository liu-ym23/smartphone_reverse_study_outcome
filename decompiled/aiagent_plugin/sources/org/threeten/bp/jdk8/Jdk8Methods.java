package org.threeten.bp.jdk8;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class Jdk8Methods {
    public static int compareInts(int r0, int r1) {
        if (r0 >= r1) goto L5;
        return -1;
    L5:
        if (r0 <= r1) goto L8;
        return 1;
    L8:
        return 0;
    }

    public static int compareLongs(long r0, long r2) {
        if (r0 >= r2) goto L6;
        return -1;
    L6:
        if (r0 <= r2) goto L9;
        return 1;
    L9:
        return 0;
    }

    private Jdk8Methods() {
    }

    public static <T> T requireNonNull(T r1) {
        Objects.requireNonNull(r1, "Value must not be null");
        return r1;
    }

    public static <T> T requireNonNull(T r1, String r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new NullPointerException(r2 + " must not be null");
    }

    public static boolean equals(Object r1, Object r2) {
        if (r1 != null) goto L7;
        if (r2 != null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r2 != null) goto L10;
        return false;
    L10:
        return r1.equals(r2);
    }

    public static int safeAdd(int r3, int r4) {
        int r0 = r3 + r4;
        if ((r3 ^ r0) < 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r3 ^ r4) < 0) goto L9;
        throw new ArithmeticException("Addition overflows an int: " + r3 + " + " + r4);
    }

    public static long safeAdd(long r6, long r8) {
        long r0 = r6 + r8;
        if ((r6 ^ r0) < 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r6 ^ r8) < 0) goto L9;
        throw new ArithmeticException("Addition overflows a long: " + r6 + " + " + r8);
    }

    public static int safeSubtract(int r3, int r4) {
        int r0 = r3 - r4;
        if ((r3 ^ r0) < 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r3 ^ r4) >= 0) goto L9;
        throw new ArithmeticException("Subtraction overflows an int: " + r3 + " - " + r4);
    }

    public static long safeSubtract(long r6, long r8) {
        long r0 = r6 - r8;
        if ((r6 ^ r0) < 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r6 ^ r8) >= 0) goto L9;
        throw new ArithmeticException("Subtraction overflows a long: " + r6 + " - " + r8);
    }

    public static int safeMultiply(int r4, int r5) {
        long r0 = ((long) r4) * ((long) r5);
        if (r0 < (-2147483648L)) goto L9;
        if (r0 > 2147483647L) goto L9;
        return (int) r0;
    L9:
        throw new ArithmeticException("Multiplication overflows an int: " + r4 + " * " + r5);
    }

    public static long safeMultiply(long r7, int r9) {
        if (r9 == (-1)) goto L16;
        if (r9 != 0) goto L6;
        return 0;
    L6:
        if (r9 == 1) goto L12;
        long r3 = r9;
        long r5 = r7 * r3;
        if ((r5 / r3) != r7) goto L11;
        return r5;
    L11:
        throw new ArithmeticException("Multiplication overflows a long: " + r7 + " * " + r9);
    L12:
        return r7;
    L16:
        if (r7 == Long.MIN_VALUE) goto L20;
        return -r7;
    L20:
        throw new ArithmeticException("Multiplication overflows a long: " + r7 + " * " + r9);
    }

    public static long safeMultiply(long r7, long r9) {
        if (r9 != 1) goto L6;
        return r7;
    L6:
        if (r7 != 1) goto L9;
        return r9;
    L9:
        if (r7 != 0) goto L11;
    L26:
        return 0;
    L11:
        if (r9 == 0) goto L26;
        long r0 = r7 * r9;
        if ((r0 / r9) != r7) goto L25;
        if (r7 != Long.MIN_VALUE) goto L20;
        if (r9 == (-1)) goto L25;
    L20:
        if (r9 == Long.MIN_VALUE) goto L22;
    L23:
        return r0;
    L22:
        if (r7 != (-1)) goto L23;
    L25:
        throw new ArithmeticException("Multiplication overflows a long: " + r7 + " * " + r9);
    }

    public static int safeToInt(long r3) {
        if (r3 > 2147483647L) goto L9;
        if (r3 < (-2147483648L)) goto L9;
        return (int) r3;
    L9:
        throw new ArithmeticException("Calculation overflows an int: " + r3);
    }

    public static long floorDiv(long r2, long r4) {
        if (r2 < 0) goto L6;
        return r2 / r4;
    L6:
        return ((r2 + 1) / r4) - 1;
    }

    public static long floorMod(long r0, long r2) {
        return ((r0 % r2) + r2) % r2;
    }

    public static int floorMod(long r2, int r4) {
        long r0 = r4;
        return (int) (((r2 % r0) + r0) % r0);
    }

    public static int floorDiv(int r0, int r1) {
        if (r0 < 0) goto L5;
        return r0 / r1;
    L5:
        return ((r0 + 1) / r1) - 1;
    }

    public static int floorMod(int r0, int r1) {
        return ((r0 % r1) + r1) % r1;
    }
}
