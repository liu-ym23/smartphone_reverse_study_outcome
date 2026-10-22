package ig;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static int a(int r10, int r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 <= r11) goto L8;
        return 1;
    L8:
        return 0;
    }

    public static int b(long r10, long r11) {
        if (r10 >= r11) goto L6;
        return -1;
    L6:
        if (r10 <= r11) goto L9;
        return 1;
    L9:
        return 0;
    }

    public static boolean c(Object r10, Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r11 != null) goto L10;
        return false;
    L10:
        return r10.equals(r11);
    }

    public static long d(long r10, long r11) {
        if (r10 < 0) goto L6;
        return r10 / r11;
    L6:
        return ((r10 + 1) / r11) - 1;
    }

    public static int e(int r10, int r11) {
        return ((r10 % r11) + r11) % r11;
    }

    public static int f(long r10, int r11) {
        long r12 = r11;
        return (int) (((r10 % r12) + r12) % r12);
    }

    public static long g(long r10, long r11) {
        return ((r10 % r11) + r11) % r11;
    }

    public static Object h(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11 + " must not be null");
    }

    public static int i(int r10, int r11) {
        int r12 = r10 + r11;
        if ((r10 ^ r12) < 0) goto L5;
    L9:
        return r12;
    L5:
        if ((r10 ^ r11) < 0) goto L9;
        throw new ArithmeticException("Addition overflows an int: " + r10 + " + " + r11);
    }

    public static long j(long r10, long r11) {
        long r12 = r10 + r11;
        if ((r10 ^ r12) < 0) goto L5;
    L9:
        return r12;
    L5:
        if ((r10 ^ r11) < 0) goto L9;
        throw new ArithmeticException("Addition overflows a long: " + r10 + " + " + r11);
    }

    public static int k(int r10, int r11) {
        long r12 = ((long) r10) * ((long) r11);
        if (r12 < (-2147483648L)) goto L9;
        if (r12 > 2147483647L) goto L9;
        return (int) r12;
    L9:
        throw new ArithmeticException("Multiplication overflows an int: " + r10 + " * " + r11);
    }

    public static long l(long r10, int r11) {
        if (r11 == (-1)) goto L16;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if (r11 == 1) goto L12;
        long r12 = r11;
        long r13 = r10 * r12;
        if ((r13 / r12) != r10) goto L11;
        return r13;
    L11:
        throw new ArithmeticException("Multiplication overflows a long: " + r10 + " * " + r11);
    L12:
        return r10;
    L16:
        if (r10 == Long.MIN_VALUE) goto L20;
        return -r10;
    L20:
        throw new ArithmeticException("Multiplication overflows a long: " + r10 + " * " + r11);
    }

    public static long m(long r10, long r11) {
        if (r11 != 1) goto L6;
        return r10;
    L6:
        if (r10 != 1) goto L9;
        return r11;
    L9:
        if (r10 != 0) goto L11;
    L26:
        return 0;
    L11:
        if (r11 == 0) goto L26;
        long r12 = r10 * r11;
        if ((r12 / r11) != r10) goto L25;
        if (r10 != Long.MIN_VALUE) goto L20;
        if (r11 == (-1)) goto L25;
    L20:
        if (r11 == Long.MIN_VALUE) goto L22;
    L23:
        return r12;
    L22:
        if (r10 != (-1)) goto L23;
    L25:
        throw new ArithmeticException("Multiplication overflows a long: " + r10 + " * " + r11);
    }

    public static int n(int r10, int r11) {
        int r12 = r10 - r11;
        if ((r10 ^ r12) < 0) goto L5;
    L9:
        return r12;
    L5:
        if ((r10 ^ r11) >= 0) goto L9;
        throw new ArithmeticException("Subtraction overflows an int: " + r10 + " - " + r11);
    }

    public static long o(long r10, long r11) {
        long r12 = r10 - r11;
        if ((r10 ^ r12) < 0) goto L5;
    L9:
        return r12;
    L5:
        if ((r10 ^ r11) >= 0) goto L9;
        throw new ArithmeticException("Subtraction overflows a long: " + r10 + " - " + r11);
    }

    public static int p(long r10) {
        if (r10 > 2147483647L) goto L9;
        if (r10 < (-2147483648L)) goto L9;
        return (int) r10;
    L9:
        throw new ArithmeticException("Calculation overflows an int: " + r10);
    }
}
