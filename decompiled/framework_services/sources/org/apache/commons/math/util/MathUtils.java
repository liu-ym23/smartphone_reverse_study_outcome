package org.apache.commons.math.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.NonMonotonousSequenceException;
import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public final class MathUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final double EPSILON = 1.1102230246251565E-16d;
    private static final long[] FACTORIALS = null;
    private static final int NAN_GAP = 4194304;
    private static final byte NB = -1;
    private static final short NS = -1;
    private static final byte PB = 1;
    private static final short PS = 1;
    public static final double SAFE_MIN = Double.MIN_NORMAL;
    private static final long SGN_MASK = Long.MIN_VALUE;
    private static final int SGN_MASK_FLOAT = Integer.MIN_VALUE;
    public static final double TWO_PI = 6.283185307179586d;
    private static final byte ZB = 0;
    private static final short ZS = 0;

    public static final enum OrderDirection extends Enum<OrderDirection> {
        private static final /* synthetic */ OrderDirection[] $VALUES = null;
        public static final OrderDirection DECREASING = null;
        public static final OrderDirection INCREASING = null;

        private static /* synthetic */ OrderDirection[] $values() {
            return new OrderDirection[]{INCREASING, DECREASING};
        }

        private OrderDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static OrderDirection valueOf(String name) {
            return (OrderDirection) Enum.valueOf(OrderDirection.class, name);
        }

        public static OrderDirection[] values() {
            return (OrderDirection[]) $VALUES.clone();
        }

        static {
            INCREASING = new OrderDirection("INCREASING", 0);
            DECREASING = new OrderDirection("DECREASING", 1);
            $VALUES = $values();
        }
    }

    static {
        FACTORIALS = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    }

    private MathUtils() {
    }

    public static int addAndCheck(int x, int y) {
        long s = ((long) x) + ((long) y);
        if (s < (-2147483648L)) goto L9;
        if (s > 2147483647L) goto L9;
        return (int) s;
    L9:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Integer.valueOf(x), Integer.valueOf(y)});
    }

    public static long addAndCheck(long a, long b) {
        return addAndCheck(a, b, LocalizedFormats.OVERFLOW_IN_ADDITION);
    }

    private static long addAndCheck(long a, long b, Localizable pattern) {
        if (a <= b) goto L6;
        long ret = addAndCheck(b, a, pattern);
        return ret;
    L6:
        if (a >= 0) goto L16;
        if (b < 0) goto L10;
        long ret2 = a + b;
        return ret2;
    L10:
        if ((Long.MIN_VALUE - b) > a) goto L13;
        long ret3 = a + b;
        return ret3;
    L13:
        throw MathRuntimeException.createArithmeticException(pattern, new Object[]{Long.valueOf(a), Long.valueOf(b)});
    L16:
        if (a > (Long.MAX_VALUE - b)) goto L20;
        long ret4 = a + b;
        return ret4;
    L20:
        throw MathRuntimeException.createArithmeticException(pattern, new Object[]{Long.valueOf(a), Long.valueOf(b)});
    }

    public static long binomialCoefficient(int n, int k) {
        checkBinomial(n, k);
        if (n == k) goto L33;
        if (k != 0) goto L7;
        return 1;
    L7:
        if (k == 1) goto L32;
        if (k == (n - 1)) goto L32;
        if (k > (n / 2)) goto L14;
        long result = 1;
        if (n > 61) goto L22;
        int i = (n - k) + 1;
        int j = 1;
    L18:
        if (j > k) goto L30;
        result = (((long) i) * result) / ((long) j);
        i = i + 1;
        j = j + 1;
    L30:
        return result;
    L22:
        if (n > 66) goto L27;
        int i2 = (n - k) + 1;
        int j2 = 1;
    L24:
        if (j2 > k) goto L30;
        long d = gcd(i2, j2);
        result = (result / (((long) j2) / d)) * (((long) i2) / d);
        i2 = i2 + 1;
        j2 = j2 + 1;
        goto L24
    L27:
        int i3 = (n - k) + 1;
        int j3 = 1;
    L28:
        if (j3 > k) goto L30;
        long d2 = gcd(i3, j3);
        result = mulAndCheck(result / (((long) j3) / d2), ((long) i3) / d2);
        i3 = i3 + 1;
        j3 = j3 + 1;
        goto L28
    L14:
        return binomialCoefficient(n, n - k);
    L32:
        return n;
    L33:
        return 1;
    }

    public static double binomialCoefficientDouble(int n, int k) {
        checkBinomial(n, k);
        if (n == k) goto L26;
        if (k != 0) goto L7;
        return 1.0d;
    L7:
        if (k != 1) goto L9;
    L24:
        double result = n;
        return result;
    L9:
        if (k == (n - 1)) goto L24;
        if (k <= (n / 2)) goto L16;
        return binomialCoefficientDouble(n, n - k);
    L16:
        if (n < 67) goto L18;
        double result2 = 1.0d;
        int i = 1;
    L20:
        if (i > k) goto L23;
        result2 = result2 * (((double) ((n - k) + i)) / ((double) i));
        i = i + 1;
        goto L20
    L23:
        return FastMath.floor(0.5d + result2);
    L18:
        return binomialCoefficient(n, k);
    L26:
        return 1.0d;
    }

    public static double binomialCoefficientLog(int n, int k) {
        checkBinomial(n, k);
        if (n == k) goto L33;
        if (k != 0) goto L7;
        return 0.0d;
    L7:
        if (k == 1) goto L32;
        if (k == (n - 1)) goto L32;
        if (n >= 67) goto L16;
        return FastMath.log(binomialCoefficient(n, k));
    L16:
        if (n >= 1030) goto L20;
        return FastMath.log(binomialCoefficientDouble(n, k));
    L20:
        if (k > (n / 2)) goto L22;
        double logSum = 0.0d;
        int i = (n - k) + 1;
    L24:
        if (i > n) goto L26;
        logSum = logSum + FastMath.log(i);
        i = i + 1;
        goto L24
    L26:
        int i2 = 2;
    L27:
        if (i2 > k) goto L30;
        logSum = logSum - FastMath.log(i2);
        i2 = i2 + 1;
        goto L27
    L30:
        return logSum;
    L22:
        return binomialCoefficientLog(n, n - k);
    L32:
        return FastMath.log(n);
    L33:
        return 0.0d;
    }

    private static void checkBinomial(int n, int k) throws IllegalArgumentException {
        if (n < k) goto L8;
        if (n < 0) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.BINOMIAL_NEGATIVE_PARAMETER, new Object[]{Integer.valueOf(n)});
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.BINOMIAL_INVALID_PARAMETERS_ORDER, new Object[]{Integer.valueOf(n), Integer.valueOf(k)});
    }

    public static int compareTo(double x, double y, double eps) {
        if (equals(x, y, eps) == false) goto L7;
        return 0;
    L7:
        if (x >= y) goto L10;
        return -1;
    L10:
        return 1;
    }

    public static double cosh(double x) {
        return (FastMath.exp(x) + FastMath.exp(-x)) / 2.0d;
    }

    @Deprecated
    public static boolean equals(float x, float y) {
        if (Float.isNaN(x) == false) goto L7;
        if (Float.isNaN(y) == false) goto L7;
    L8:
        return true;
    L7:
        if (x == y) goto L8;
        return false;
    }

    public static boolean equalsIncludingNaN(float x, float y) {
        if (Float.isNaN(x) == false) goto L7;
        if (Float.isNaN(y) == false) goto L7;
        return true;
    L7:
        if (equals(x, y, 1) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean equals(float x, float y, float eps) {
        if (equals(x, y, 1) == false) goto L5;
        return true;
    L5:
        if (FastMath.abs(y - x) <= eps) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean equalsIncludingNaN(float x, float y, float eps) {
        if (equalsIncludingNaN(x, y) == false) goto L5;
    L8:
        return true;
    L5:
        if (FastMath.abs(y - x) <= eps) goto L8;
        return false;
    }

    public static boolean equals(float x, float y, int maxUlps) {
        int xInt = Float.floatToIntBits(x);
        int yInt = Float.floatToIntBits(y);
        if (xInt >= 0) goto L5;
        xInt = Integer.MIN_VALUE - xInt;
    L5:
        if (yInt >= 0) goto L8;
        yInt = Integer.MIN_VALUE - yInt;
    L8:
        if (FastMath.abs(xInt - yInt) > maxUlps) goto L10;
        boolean isEqual = true;
    L11:
        if (isEqual == true) goto L13;
        return false;
    L13:
        if (Float.isNaN(x) == false) goto L15;
        return false;
    L15:
        if (Float.isNaN(y) == false) goto L17;
        return false;
    L17:
        return true;
    L10:
        isEqual = false;
        goto L11
    }

    public static boolean equalsIncludingNaN(float x, float y, int maxUlps) {
        if (Float.isNaN(x) == false) goto L7;
        if (Float.isNaN(y) == false) goto L7;
    L8:
        return true;
    L7:
        if (equals(x, y, maxUlps) == true) goto L8;
        return false;
    }

    @Deprecated
    public static boolean equals(float[] x, float[] y) {
        boolean r0 = false;
        if (x == null) goto L18;
        if (y == null) goto L18;
        if (x.length == y.length) goto L9;
        return false;
    L9:
        int i = 0;
    L11:
        if (i >= x.length) goto L17;
        if (equals(x[i], y[i]) == false) goto L14;
        i = i + 1;
        goto L11
    L14:
        return false;
    L17:
        return true;
    L18:
        if (x != null) goto L20;
        boolean r2 = true;
    L21:
        if (y != null) goto L24;
        r0 = true;
    L24:
        return !(r0 ^ r2);
    L20:
        r2 = false;
        goto L21
    }

    public static boolean equalsIncludingNaN(float[] x, float[] y) {
        boolean r0 = false;
        if (x == null) goto L18;
        if (y == null) goto L18;
        if (x.length == y.length) goto L9;
        return false;
    L9:
        int i = 0;
    L11:
        if (i >= x.length) goto L17;
        if (equalsIncludingNaN(x[i], y[i]) == false) goto L14;
        i = i + 1;
        goto L11
    L14:
        return false;
    L17:
        return true;
    L18:
        if (x != null) goto L20;
        boolean r2 = true;
    L21:
        if (y != null) goto L24;
        r0 = true;
    L24:
        return !(r0 ^ r2);
    L20:
        r2 = false;
        goto L21
    }

    public static boolean equals(double x, double y) {
        if (Double.isNaN(x) == false) goto L7;
        if (Double.isNaN(y) == false) goto L7;
    L8:
        return true;
    L7:
        if (x == y) goto L8;
        return false;
    }

    public static boolean equalsIncludingNaN(double x, double y) {
        if (Double.isNaN(x) == false) goto L7;
        if (Double.isNaN(y) == false) goto L7;
        return true;
    L7:
        if (equals(x, y, 1) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean equals(double x, double y, double eps) {
        if (equals(x, y) == false) goto L5;
    L8:
        return true;
    L5:
        if (FastMath.abs(y - x) <= eps) goto L8;
        return false;
    }

    public static boolean equalsIncludingNaN(double x, double y, double eps) {
        if (equalsIncludingNaN(x, y) == false) goto L5;
    L8:
        return true;
    L5:
        if (FastMath.abs(y - x) <= eps) goto L8;
        return false;
    }

    public static boolean equals(double x, double y, int maxUlps) {
        long xInt = Double.doubleToLongBits(x);
        long yInt = Double.doubleToLongBits(y);
        if (xInt >= 0) goto L6;
        xInt = Long.MIN_VALUE - xInt;
    L6:
        if (yInt >= 0) goto L9;
        yInt = Long.MIN_VALUE - yInt;
    L9:
        if (FastMath.abs(xInt - yInt) > maxUlps) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean equalsIncludingNaN(double x, double y, int maxUlps) {
        if (Double.isNaN(x) == false) goto L7;
        if (Double.isNaN(y) == false) goto L7;
    L8:
        return true;
    L7:
        if (equals(x, y, maxUlps) == true) goto L8;
        return false;
    }

    public static boolean equals(double[] x, double[] y) {
        boolean r0 = false;
        if (x == null) goto L18;
        if (y == null) goto L18;
        if (x.length == y.length) goto L9;
        return false;
    L9:
        int i = 0;
    L11:
        if (i >= x.length) goto L17;
        if (equals(x[i], y[i]) == false) goto L14;
        i = i + 1;
        goto L11
    L14:
        return false;
    L17:
        return true;
    L18:
        if (x != null) goto L20;
        boolean r2 = true;
    L21:
        if (y != null) goto L24;
        r0 = true;
    L24:
        return !(r0 ^ r2);
    L20:
        r2 = false;
        goto L21
    }

    public static boolean equalsIncludingNaN(double[] x, double[] y) {
        boolean r0 = false;
        if (x == null) goto L18;
        if (y == null) goto L18;
        if (x.length == y.length) goto L9;
        return false;
    L9:
        int i = 0;
    L11:
        if (i >= x.length) goto L17;
        if (equalsIncludingNaN(x[i], y[i]) == false) goto L14;
        i = i + 1;
        goto L11
    L14:
        return false;
    L17:
        return true;
    L18:
        if (x != null) goto L20;
        boolean r2 = true;
    L21:
        if (y != null) goto L24;
        r0 = true;
    L24:
        return !(r0 ^ r2);
    L20:
        r2 = false;
        goto L21
    }

    public static long factorial(int n) {
        if (n < 0) goto L10;
        if (n > 20) goto L8;
        return FACTORIALS[n];
    L8:
        throw new ArithmeticException("factorial value is too large to fit in a long");
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, new Object[]{Integer.valueOf(n)});
    }

    public static double factorialDouble(int n) {
        if (n < 0) goto L10;
        if (n >= 21) goto L8;
        return factorial(n);
    L8:
        return FastMath.floor(FastMath.exp(factorialLog(n)) + 0.5d);
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, new Object[]{Integer.valueOf(n)});
    }

    public static double factorialLog(int n) {
        if (n < 0) goto L13;
        if (n < 21) goto L6;
        double logSum = 0.0d;
        int i = 2;
    L8:
        if (i > n) goto L11;
        logSum = logSum + FastMath.log(i);
        i = i + 1;
        goto L8
    L11:
        return logSum;
    L6:
        return FastMath.log(factorial(n));
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, new Object[]{Integer.valueOf(n)});
    }

    public static int gcd(int p, int q) {
        int u = p;
        int v = q;
        if (u == 0) goto L35;
        if (v == 0) goto L35;
        if (u <= 0) goto L8;
        u = -u;
    L8:
        if (v <= 0) goto L10;
        v = -v;
    L10:
        int k = 0;
    L12:
        if ((u & 1) != 0) goto L17;
        if ((v & 1) != 0) goto L17;
        if (k >= 31) goto L17;
        u = u / 2;
        v = v / 2;
        k = k + 1;
    L17:
        if (k == 31) goto L33;
        if ((u & 1) != 1) goto L21;
        int t = v;
    L23:
        if ((t & 1) == 0) goto L24;
        if (t <= 0) goto L27;
        u = -t;
    L28:
        t = (v - u) / 2;
        if (t != 0) goto L23;
        return (-u) * (1 << k);
    L27:
        v = t;
        goto L28
    L24:
        t = t / 2;
        goto L23
    L21:
        t = -(u / 2);
        goto L23
    L33:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(p), Integer.valueOf(q)});
    L35:
        if (u == Integer.MIN_VALUE) goto L40;
        if (v == Integer.MIN_VALUE) goto L40;
        return FastMath.abs(u) + FastMath.abs(v);
    L40:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(p), Integer.valueOf(q)});
    }

    public static long gcd(long p, long q) {
        long u = p;
        long v = q;
        if (u == 0) goto L39;
        if (v == 0) goto L39;
        if (u <= 0) goto L11;
        u = -u;
    L11:
        if (v <= 0) goto L13;
        v = -v;
    L13:
        int k = 0;
    L15:
        if ((u & 1) != 0) goto L20;
        if ((v & 1) != 0) goto L20;
        if (k >= 63) goto L20;
        u = u / 2;
        v = v / 2;
        k = k + 1;
    L20:
        if (k == 63) goto L37;
        if ((u & 1) != 1) goto L24;
        long t = v;
    L26:
        if ((t & 1) == 0) goto L27;
        if (t <= 0) goto L31;
        u = -t;
    L32:
        t = (v - u) / 2;
        if (t != 0) goto L26;
        return (-u) * (1 << k);
    L31:
        v = t;
        goto L32
    L27:
        t = t / 2;
        goto L26
    L24:
        t = -(u / 2);
        goto L26
    L37:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, new Object[]{Long.valueOf(p), Long.valueOf(q)});
    L39:
        if (u == Long.MIN_VALUE) goto L45;
        if (v == Long.MIN_VALUE) goto L45;
        return FastMath.abs(u) + FastMath.abs(v);
    L45:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, new Object[]{Long.valueOf(p), Long.valueOf(q)});
    }

    public static int hash(double value) {
        return new Double(value).hashCode();
    }

    public static int hash(double[] value) {
        return Arrays.hashCode(value);
    }

    public static byte indicator(byte x) {
        if (x < 0) goto L4;
        return 1;
    L4:
        return -1;
    }

    public static double indicator(double x) {
        if (Double.isNaN(x) == false) goto L7;
        return Double.NaN;
    L7:
        if (x < 0.0d) goto L9;
        return 1.0d;
    L9:
        return -1.0d;
    }

    public static float indicator(float x) {
        if (Float.isNaN(x) == false) goto L7;
        return Float.NaN;
    L7:
        if (x < 0.0f) goto L9;
        return 1.0f;
    L9:
        return -1.0f;
    }

    public static int indicator(int x) {
        if (x < 0) goto L4;
        return 1;
    L4:
        return -1;
    }

    public static long indicator(long x) {
        if (x < 0) goto L5;
        return 1;
    L5:
        return -1;
    }

    public static short indicator(short x) {
        if (x < 0) goto L4;
        return 1;
    L4:
        return NS;
    }

    public static int lcm(int a, int b) {
        if (a == 0) goto L10;
        if (b == 0) goto L12;
        int lcm = FastMath.abs(mulAndCheck(a / gcd(a, b), b));
        if (lcm == Integer.MIN_VALUE) goto L9;
        return lcm;
    L9:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.LCM_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(a), Integer.valueOf(b)});
    L12:
        return 0;
    L10:
        return 0;
    }

    public static long lcm(long a, long b) {
        if (a != 0) goto L5;
    L12:
        return 0;
    L5:
        if (b == 0) goto L12;
        long lcm = FastMath.abs(mulAndCheck(a / gcd(a, b), b));
        if (lcm == Long.MIN_VALUE) goto L11;
        return lcm;
    L11:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.LCM_OVERFLOW_64_BITS, new Object[]{Long.valueOf(a), Long.valueOf(b)});
    }

    public static double log(double base, double x) {
        return FastMath.log(x) / FastMath.log(base);
    }

    public static int mulAndCheck(int x, int y) {
        long m = ((long) x) * ((long) y);
        if (m < (-2147483648L)) goto L9;
        if (m > 2147483647L) goto L9;
        return (int) m;
    L9:
        throw new ArithmeticException("overflow: mul");
    }

    public static long mulAndCheck(long a, long b) {
        if (a <= b) goto L6;
        long ret = mulAndCheck(b, a);
        return ret;
    L6:
        if (a >= 0) goto L23;
        if (b >= 0) goto L15;
        if (a < (Long.MAX_VALUE / b)) goto L13;
        long ret2 = a * b;
        return ret2;
    L13:
        throw new ArithmeticException("overflow: multiply");
    L15:
        if (b > 0) goto L17;
        return 0;
    L17:
        if ((Long.MIN_VALUE / b) > a) goto L20;
        long ret3 = a * b;
        return ret3;
    L20:
        throw new ArithmeticException("overflow: multiply");
    L23:
        if (a > 0) goto L25;
        return 0;
    L25:
        if (a > (Long.MAX_VALUE / b)) goto L28;
        long ret4 = a * b;
        return ret4;
    L28:
        throw new ArithmeticException("overflow: multiply");
    }

    @Deprecated
    public static double nextAfter(double d, double direction) {
        if (Double.isNaN(d) == false) goto L5;
    L28:
        return d;
    L5:
        if (Double.isInfinite(d) == true) goto L28;
        if (d == 0.0d) goto L10;
        long bits = Double.doubleToLongBits(d);
        long sign = Long.MIN_VALUE & bits;
        long exponent = 9218868437227405312L & bits;
        long mantissa = bits & 4503599627370495L;
        if (((direction - d) * d) < 0.0d) goto L23;
        if (mantissa != 4503599627370495L) goto L21;
        return Double.longBitsToDouble(sign | (4503599627370496L + exponent));
    L21:
        return Double.longBitsToDouble((sign | exponent) | (1 + mantissa));
    L23:
        if (mantissa != 0) goto L27;
        return Double.longBitsToDouble(((exponent - 4503599627370496L) | sign) | 4503599627370495L);
    L27:
        return Double.longBitsToDouble((sign | exponent) | (mantissa - 1));
    L10:
        if (direction >= 0.0d) goto L12;
        return -4.9E-324d;
    L12:
        return Double.MIN_VALUE;
    }

    @Deprecated
    public static double scalb(double d, int scaleFactor) {
        return FastMath.scalb(d, scaleFactor);
    }

    public static double normalizeAngle(double a, double center) {
        return a - (FastMath.floor(((3.141592653589793d + a) - center) / 6.283185307179586d) * 6.283185307179586d);
    }

    public static double[] normalizeArray(double[] values, double normalizedSum) throws ArithmeticException, IllegalArgumentException {
        if (Double.isInfinite(normalizedSum) == true) goto L32;
        if (Double.isNaN(normalizedSum) == true) goto L30;
        double sum = 0.0d;
        int len = values.length;
        double[] out = new double[len];
        int i = 0;
    L7:
        if (i >= len) goto L17;
        if (Double.isInfinite(values[i]) == true) goto L15;
        if (Double.isNaN(values[i]) == true) goto L13;
        sum = sum + values[i];
    L13:
        i = i + 1;
        goto L7
    L15:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, new Object[]{Double.valueOf(values[i]), Integer.valueOf(i)});
    L17:
        if (sum == 0.0d) goto L28;
        int i2 = 0;
    L19:
        if (i2 >= len) goto L26;
        if (Double.isNaN(values[i2]) == false) goto L23;
        out[i2] = Double.NaN;
    L24:
        i2 = i2 + 1;
        goto L19
    L23:
        out[i2] = (values[i2] * normalizedSum) / sum;
        goto L24
    L26:
        return out;
    L28:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ARRAY_SUMS_TO_ZERO, new Object[0]);
    L30:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NORMALIZE_NAN, new Object[0]);
    L32:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NORMALIZE_INFINITE, new Object[0]);
    }

    public static double round(double x, int scale) {
        return round(x, scale, 4);
    }

    public static double round(double x, int scale, int roundingMethod) {
        return new BigDecimal(Double.toString(x)).setScale(scale, roundingMethod).doubleValue();
    L6:
        if (Double.isInfinite(x) == false) goto L8;
        return x;
    L8:
        return Double.NaN;
    }

    public static float round(float x, int scale) {
        return round(x, scale, 4);
    }

    public static float round(float x, int scale, int roundingMethod) {
        float sign = indicator(x);
        float factor = ((float) FastMath.pow(10.0d, scale)) * sign;
        return ((float) roundUnscaled(x * factor, sign, roundingMethod)) / factor;
    }

    private static double roundUnscaled(double unscaled, double sign, int roundingMethod) {
        switch(roundingMethod) {
            case 0: goto L39;
            case 1: goto L52;
            case 2: goto L34;
            case 3: goto L30;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L11;
            case 7: goto L7;
            default: goto L5;
        };
    L11:
        double fraction = unscaled - FastMath.floor(unscaled);
        if (fraction <= 0.5d) goto L15;
        return FastMath.ceil(unscaled);
    L15:
        if (fraction >= 0.5d) goto L18;
        return FastMath.floor(unscaled);
    L18:
        if ((FastMath.floor(unscaled) / 2.0d) != FastMath.floor(Math.floor(unscaled) / 2.0d)) goto L43;
        return FastMath.floor(unscaled);
    L43:
        return FastMath.ceil(unscaled);
    L21:
        double unscaled2 = nextAfter(unscaled, Double.NEGATIVE_INFINITY);
        double fraction2 = unscaled2 - FastMath.floor(unscaled2);
        if (fraction2 <= 0.5d) goto L45;
        return FastMath.ceil(unscaled2);
    L45:
        return FastMath.floor(unscaled2);
    L25:
        double unscaled3 = nextAfter(unscaled, Double.POSITIVE_INFINITY);
        double fraction3 = unscaled3 - FastMath.floor(unscaled3);
        if (fraction3 < 0.5d) goto L47;
        return FastMath.ceil(unscaled3);
    L47:
        return FastMath.floor(unscaled3);
    L5:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_ROUNDING_METHOD, new Object[]{Integer.valueOf(roundingMethod), "ROUND_CEILING", 2, "ROUND_DOWN", 1, "ROUND_FLOOR", 3, "ROUND_HALF_DOWN", 5, "ROUND_HALF_EVEN", 6, "ROUND_HALF_UP", 4, "ROUND_UNNECESSARY", 7, "ROUND_UP", 0});
    L7:
        if (unscaled != FastMath.floor(unscaled)) goto L10;
        return unscaled;
    L10:
        throw new ArithmeticException("Inexact result from rounding");
    L30:
        if (sign != (-1.0d)) goto L49;
        return FastMath.ceil(nextAfter(unscaled, Double.POSITIVE_INFINITY));
    L49:
        return FastMath.floor(nextAfter(unscaled, Double.NEGATIVE_INFINITY));
    L34:
        if (sign != (-1.0d)) goto L51;
        return FastMath.floor(nextAfter(unscaled, Double.NEGATIVE_INFINITY));
    L51:
        return FastMath.ceil(nextAfter(unscaled, Double.POSITIVE_INFINITY));
    L52:
        return FastMath.floor(nextAfter(unscaled, Double.NEGATIVE_INFINITY));
    L39:
        return FastMath.ceil(nextAfter(unscaled, Double.POSITIVE_INFINITY));
    }

    public static byte sign(byte x) {
        if (x != 0) goto L4;
        return 0;
    L4:
        if (x <= 0) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static double sign(double x) {
        if (Double.isNaN(x) == false) goto L7;
        return Double.NaN;
    L7:
        if (x != 0.0d) goto L10;
        return 0.0d;
    L10:
        if (x <= 0.0d) goto L12;
        return 1.0d;
    L12:
        return -1.0d;
    }

    public static float sign(float x) {
        if (Float.isNaN(x) == false) goto L7;
        return Float.NaN;
    L7:
        if (x != 0.0f) goto L10;
        return 0.0f;
    L10:
        if (x <= 0.0f) goto L12;
        return 1.0f;
    L12:
        return -1.0f;
    }

    public static int sign(int x) {
        if (x != 0) goto L4;
        return 0;
    L4:
        if (x <= 0) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static long sign(long x) {
        if (x != 0) goto L6;
        return 0;
    L6:
        if (x <= 0) goto L8;
        return 1;
    L8:
        return -1;
    }

    public static short sign(short x) {
        if (x != 0) goto L4;
        return 0;
    L4:
        if (x <= 0) goto L6;
        return 1;
    L6:
        return NS;
    }

    public static double sinh(double x) {
        return (FastMath.exp(x) - FastMath.exp(-x)) / 2.0d;
    }

    public static int subAndCheck(int x, int y) {
        long s = ((long) x) - ((long) y);
        if (s < (-2147483648L)) goto L9;
        if (s > 2147483647L) goto L9;
        return (int) s;
    L9:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, new Object[]{Integer.valueOf(x), Integer.valueOf(y)});
    }

    public static long subAndCheck(long a, long b) {
        if (b == Long.MIN_VALUE) goto L5;
        long ret = addAndCheck(a, -b, LocalizedFormats.OVERFLOW_IN_ADDITION);
        return ret;
    L5:
        if (a >= 0) goto L8;
        long ret2 = a - b;
        return ret2;
    L8:
        throw new ArithmeticException("overflow: subtract");
    }

    public static int pow(int k, int e) throws IllegalArgumentException {
        if (e < 0) goto L11;
        int result = 1;
        int k2p = k;
    L4:
        if (e == 0) goto L9;
        if ((e & 1) == 0) goto L8;
        result = result * k2p;
    L8:
        k2p = k2p * k2p;
        e = e >> 1;
        goto L4
    L9:
        return result;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{Integer.valueOf(k), Integer.valueOf(e)});
    }

    public static int pow(int k, long e) throws IllegalArgumentException {
        if (e < 0) goto L13;
        int result = 1;
        int k2p = k;
    L6:
        if (e == 0) goto L11;
        if ((1 & e) == 0) goto L10;
        result = result * k2p;
    L10:
        k2p = k2p * k2p;
        e = e >> 1;
        goto L6
    L11:
        return result;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{Integer.valueOf(k), Long.valueOf(e)});
    }

    public static long pow(long k, int e) throws IllegalArgumentException {
        if (e < 0) goto L11;
        long result = 1;
        long k2p = k;
    L4:
        if (e == 0) goto L9;
        if ((e & 1) == 0) goto L8;
        result = result * k2p;
    L8:
        k2p = k2p * k2p;
        e = e >> 1;
        goto L4
    L9:
        return result;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{Long.valueOf(k), Integer.valueOf(e)});
    }

    public static long pow(long k, long e) throws IllegalArgumentException {
        if (e < 0) goto L13;
        long result = 1;
        long k2p = k;
    L6:
        if (e == 0) goto L11;
        if ((1 & e) == 0) goto L10;
        result = result * k2p;
    L10:
        k2p = k2p * k2p;
        e = e >> 1;
        goto L6
    L11:
        return result;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{Long.valueOf(k), Long.valueOf(e)});
    }

    public static BigInteger pow(BigInteger k, int e) throws IllegalArgumentException {
        if (e < 0) goto L6;
        return k.pow(e);
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{k, Integer.valueOf(e)});
    }

    public static BigInteger pow(BigInteger k, long e) throws IllegalArgumentException {
        if (e < 0) goto L13;
        BigInteger result = BigInteger.ONE;
        BigInteger k2p = k;
    L6:
        if (e == 0) goto L11;
        if ((1 & e) == 0) goto L10;
        result = result.multiply(k2p);
    L10:
        k2p = k2p.multiply(k2p);
        e = e >> 1;
        goto L6
    L11:
        return result;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{k, Long.valueOf(e)});
    }

    public static BigInteger pow(BigInteger k, BigInteger e) throws IllegalArgumentException {
        if (e.compareTo(BigInteger.ZERO) < 0) goto L13;
        BigInteger result = BigInteger.ONE;
        BigInteger k2p = k;
    L6:
        if (BigInteger.ZERO.equals(e) == true) goto L11;
        if (e.testBit(0) == false) goto L10;
        result = result.multiply(k2p);
    L10:
        k2p = k2p.multiply(k2p);
        e = e.shiftRight(1);
        goto L6
    L11:
        return result;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POWER_NEGATIVE_PARAMETERS, new Object[]{k, e});
    }

    public static double distance1(double[] p1, double[] p2) {
        double sum = 0.0d;
        int i = 0;
    L4:
        if (i >= p1.length) goto L7;
        sum = sum + FastMath.abs(p1[i] - p2[i]);
        i = i + 1;
        goto L4
    L7:
        return sum;
    }

    public static int distance1(int[] p1, int[] p2) {
        int sum = 0;
        int i = 0;
    L4:
        if (i >= p1.length) goto L7;
        sum = sum + FastMath.abs(p1[i] - p2[i]);
        i = i + 1;
        goto L4
    L7:
        return sum;
    }

    public static double distance(double[] p1, double[] p2) {
        double sum = 0.0d;
        int i = 0;
    L4:
        if (i >= p1.length) goto L7;
        double dp = p1[i] - p2[i];
        sum = sum + (dp * dp);
        i = i + 1;
        goto L4
    L7:
        return FastMath.sqrt(sum);
    }

    public static double distance(int[] p1, int[] p2) {
        double sum = 0.0d;
        int i = 0;
    L4:
        if (i >= p1.length) goto L7;
        double dp = p1[i] - p2[i];
        sum = sum + (dp * dp);
        i = i + 1;
        goto L4
    L7:
        return FastMath.sqrt(sum);
    }

    public static double distanceInf(double[] p1, double[] p2) {
        double max = 0.0d;
        int i = 0;
    L4:
        if (i >= p1.length) goto L7;
        max = FastMath.max(max, FastMath.abs(p1[i] - p2[i]));
        i = i + 1;
        goto L4
    L7:
        return max;
    }

    public static int distanceInf(int[] p1, int[] p2) {
        int max = 0;
        int i = 0;
    L4:
        if (i >= p1.length) goto L7;
        max = FastMath.max(max, FastMath.abs(p1[i] - p2[i]));
        i = i + 1;
        goto L4
    L7:
        return max;
    }

    public static void checkOrder(double[] val, OrderDirection dir, boolean strict) {
        double previous = val[0];
        boolean ok = true;
        int max = val.length;
        int i = 1;
    L3:
        if (i >= max) goto L27;
        switch(dir.ordinal()) {
            case 0: goto L15;
            case 1: goto L8;
            default: goto L7;
        };
    L8:
        if (strict == false) goto L13;
        if (val[i] < previous) goto L22;
        ok = false;
    L22:
        if (ok == false) goto L25;
        previous = val[i];
        i = i + 1;
        goto L3
    L25:
        throw new NonMonotonousSequenceException(Double.valueOf(val[i]), Double.valueOf(previous), i, dir, strict);
    L13:
        if (val[i] <= previous) goto L22;
        ok = false;
        goto L22
    L15:
        if (strict == false) goto L20;
        if (val[i] > previous) goto L22;
        ok = false;
        goto L22
    L20:
        if (val[i] >= previous) goto L22;
        ok = false;
        goto L22
    L7:
        throw new IllegalArgumentException();
    }

    public static void checkOrder(double[] val) {
        checkOrder(val, OrderDirection.INCREASING, true);
    }

    @Deprecated
    public static void checkOrder(double[] val, int dir, boolean strict) {
        if (dir <= 0) goto L4;
        checkOrder(val, OrderDirection.INCREASING, strict);
        return;
    L4:
        checkOrder(val, OrderDirection.DECREASING, strict);
    }

    public static double safeNorm(double[] v) {
        double s1 = 0.0d;
        double s2 = 0.0d;
        double s3 = 0.0d;
        double x1max = 0.0d;
        double x3max = 0.0d;
        double floatn = v.length;
        double agiant = 1.304E19d / floatn;
        int i = 0;
    L3:
        double floatn2 = floatn;
        if (i >= v.length) goto L25;
        double xabs = Math.abs(v[i]);
        if (xabs < 3.834E-20d) goto L12;
        if (xabs > agiant) goto L12;
        s2 = s2 + (xabs * xabs);
    L23:
        i = i + 1;
        floatn = floatn2;
    L12:
        if (xabs <= 3.834E-20d) goto L18;
        if (xabs <= x1max) goto L16;
        double r = x1max / xabs;
        x1max = xabs;
        s1 = ((s1 * r) * r) + 1.0d;
        goto L23
    L16:
        double r2 = xabs / x1max;
        s1 = s1 + (r2 * r2);
        goto L23
    L18:
        if (xabs <= x3max) goto L21;
        double r3 = x3max / xabs;
        x3max = xabs;
        s3 = ((s3 * r3) * r3) + 1.0d;
        goto L23
    L21:
        if (xabs == 0.0d) goto L23;
        double r4 = xabs / x3max;
        s3 = s3 + (r4 * r4);
        goto L23
    L25:
        if (s1 == 0.0d) goto L28;
        double norm = Math.sqrt(((s2 / x1max) / x1max) + s1) * x1max;
        return norm;
    L28:
        if (s2 != 0.0d) goto L31;
        double norm2 = Math.sqrt(s3) * x3max;
        return norm2;
    L31:
        if (s2 < x3max) goto L33;
        double norm3 = Math.sqrt((((x3max / s2) * (x3max * s3)) + 1.0d) * s2);
        return norm3;
    L33:
        double norm4 = s2 / x3max;
        return Math.sqrt((norm4 + (x3max * s3)) * x3max);
    }
}
