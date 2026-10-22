package org.apache.commons.math.fraction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BigFraction extends Number implements FieldElement<BigFraction>, Comparable<BigFraction>, Serializable {
    public static final BigFraction FOUR_FIFTHS = null;
    public static final BigFraction MINUS_ONE = null;
    public static final BigFraction ONE = null;
    public static final BigFraction ONE_FIFTH = null;
    public static final BigFraction ONE_HALF = null;
    private static final BigInteger ONE_HUNDRED_DOUBLE = null;
    public static final BigFraction ONE_QUARTER = null;
    public static final BigFraction ONE_THIRD = null;
    public static final BigFraction THREE_FIFTHS = null;
    public static final BigFraction THREE_QUARTERS = null;
    public static final BigFraction TWO = null;
    public static final BigFraction TWO_FIFTHS = null;
    public static final BigFraction TWO_QUARTERS = null;
    public static final BigFraction TWO_THIRDS = null;
    public static final BigFraction ZERO = null;
    private static final long serialVersionUID = -5630213147331578515L;
    private final BigInteger denominator;
    private final BigInteger numerator;

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigFraction add(BigFraction r1) {
        return add2(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BigFraction r1) {
        return compareTo2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigFraction divide(BigFraction r1) throws ArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Field<BigFraction> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigFraction multiply(BigFraction r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigFraction subtract(BigFraction r1) {
        return subtract2(r1);
    }

    static {
        TWO = new BigFraction(2);
        ONE = new BigFraction(1);
        ZERO = new BigFraction(0);
        MINUS_ONE = new BigFraction(-1);
        FOUR_FIFTHS = new BigFraction(4, 5);
        ONE_FIFTH = new BigFraction(1, 5);
        ONE_HALF = new BigFraction(1, 2);
        ONE_QUARTER = new BigFraction(1, 4);
        ONE_THIRD = new BigFraction(1, 3);
        THREE_FIFTHS = new BigFraction(3, 5);
        THREE_QUARTERS = new BigFraction(3, 4);
        TWO_FIFTHS = new BigFraction(2, 5);
        TWO_QUARTERS = new BigFraction(2, 4);
        TWO_THIRDS = new BigFraction(2, 3);
        ONE_HUNDRED_DOUBLE = BigInteger.valueOf(100);
    }

    public BigFraction(BigInteger num) {
        this(num, BigInteger.ONE);
    }

    public BigFraction(BigInteger num, BigInteger den) {
        if (num == null) goto L23;
        if (den == null) goto L21;
        if (BigInteger.ZERO.equals(den) == true) goto L19;
        if (BigInteger.ZERO.equals(num) == false) goto L10;
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
        return;
    L10:
        BigInteger gcd = num.gcd(den);
        if (BigInteger.ONE.compareTo(gcd) >= 0) goto L14;
        num = num.divide(gcd);
        den = den.divide(gcd);
    L14:
        if (BigInteger.ZERO.compareTo(den) <= 0) goto L16;
        num = num.negate();
        den = den.negate();
    L16:
        this.numerator = num;
        this.denominator = den;
        return;
    L19:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L21:
        throw new NullPointerException(LocalizedFormats.DENOMINATOR.getSourceString());
    L23:
        throw new NullPointerException(LocalizedFormats.NUMERATOR.getSourceString());
    }

    public BigFraction(double value) throws IllegalArgumentException {
        if (Double.isNaN(value) == true) goto L25;
        if (Double.isInfinite(value) == true) goto L23;
        long bits = Double.doubleToLongBits(value);
        long sign = Long.MIN_VALUE & bits;
        long exponent = 9218868437227405312L & bits;
        long m = 4503599627370495L & bits;
        if (exponent == 0) goto L10;
        m = m | 4503599627370496L;
    L10:
        if (sign == 0) goto L12;
        m = -m;
    L12:
        int k = ((int) (exponent >> 52)) - 1075;
    L14:
        if ((9007199254740990L & m) == 0) goto L18;
        if ((1 & m) != 0) goto L18;
        m = m >> 1;
        k = k + 1;
    L18:
        if (k >= 0) goto L20;
        this.numerator = BigInteger.valueOf(m);
        this.denominator = BigInteger.ZERO.flipBit(-k);
        return;
    L20:
        this.numerator = BigInteger.valueOf(m).multiply(BigInteger.ZERO.flipBit(k));
        this.denominator = BigInteger.ONE;
        return;
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INFINITE_VALUE_CONVERSION, new Object[0]);
    L25:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NAN_VALUE_CONVERSION, new Object[0]);
    }

    public BigFraction(double value, double epsilon, int maxIterations) throws FractionConversionException {
        this(value, epsilon, Integer.MAX_VALUE, maxIterations);
    }

    private BigFraction(double value, double epsilon, int maxDenominator, int maxIterations) throws FractionConversionException {
        long overflow = 2147483647L;
        long a0 = (long) FastMath.floor(value);
        if (a0 > 2147483647L) goto L34;
        if (FastMath.abs(a0 - value) >= epsilon) goto L8;
        this.numerator = BigInteger.valueOf(a0);
        this.denominator = BigInteger.ONE;
        return;
    L8:
        int n = 0;
        boolean stop = false;
        long a1 = a0;
        long a2 = 0;
        long q1 = a0;
        double r0 = value;
        long p1 = 1;
        long q2 = 1;
        long q0 = 0;
    L9:
        n = n + 1;
        double r1 = 1.0d / (r0 - a1);
        long a3 = (long) FastMath.floor(r1);
        long a4 = (a3 * q1) + p1;
        long p2 = a3 * q2;
        long q3 = p2 + q0;
        if (a4 > overflow) goto L32;
        if (q3 > overflow) goto L32;
        long overflow2 = overflow;
        double convergent = a4 / q3;
        if (n < maxIterations) goto L16;
    L20:
        stop = true;
    L21:
        if (stop == true) goto L22;
        overflow = overflow2;
        a2 = a4;
        goto L9
    L22:
        if (n >= maxIterations) goto L29;
        if (q3 >= maxDenominator) goto L26;
        this.numerator = BigInteger.valueOf(a4);
        this.denominator = BigInteger.valueOf(q3);
        return;
    L26:
        this.numerator = BigInteger.valueOf(q1);
        this.denominator = BigInteger.valueOf(q2);
        return;
    L29:
        throw new FractionConversionException(value, maxIterations);
    L16:
        if (FastMath.abs(convergent - value) <= epsilon) goto L20;
        if (q3 >= maxDenominator) goto L20;
        long p0 = q1;
        q0 = q2;
        a1 = a3;
        r0 = r1;
        q2 = q3;
        q1 = a4;
        p1 = p0;
    L32:
        throw new FractionConversionException(value, a4, q3);
    L34:
        throw new FractionConversionException(value, a0, 1);
    }

    public BigFraction(double value, int maxDenominator) throws FractionConversionException {
        this(value, 0.0d, maxDenominator, 100);
    }

    public BigFraction(int num) {
        this(BigInteger.valueOf(num), BigInteger.ONE);
    }

    public BigFraction(int num, int den) {
        this(BigInteger.valueOf(num), BigInteger.valueOf(den));
    }

    public BigFraction(long num) {
        this(BigInteger.valueOf(num), BigInteger.ONE);
    }

    public BigFraction(long num, long den) {
        this(BigInteger.valueOf(num), BigInteger.valueOf(den));
    }

    public static BigFraction getReducedFraction(int numerator, int denominator) {
        if (numerator != 0) goto L6;
        return ZERO;
    L6:
        return new BigFraction(numerator, denominator);
    }

    public BigFraction abs() {
        if (BigInteger.ZERO.compareTo(this.numerator) > 0) goto L6;
        return this;
    L6:
        return negate();
    }

    public BigFraction add(BigInteger bg) {
        return new BigFraction(this.numerator.add(this.denominator.multiply(bg)), this.denominator);
    }

    public BigFraction add(int i) {
        return add(BigInteger.valueOf(i));
    }

    public BigFraction add(long l) {
        return add(BigInteger.valueOf(l));
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public BigFraction add2(BigFraction fraction) {
        if (fraction == null) goto L13;
        if (ZERO.equals(fraction) == false) goto L7;
        return this;
    L7:
        if (this.denominator.equals(fraction.denominator) == false) goto L9;
        BigInteger num = this.numerator.add(fraction.numerator);
        BigInteger den = this.denominator;
    L11:
        return new BigFraction(num, den);
    L9:
        num = this.numerator.multiply(fraction.denominator).add(fraction.numerator.multiply(this.denominator));
        den = this.denominator.multiply(fraction.denominator);
        goto L11
    L13:
        throw new NullPointerException(LocalizedFormats.FRACTION.getSourceString());
    }

    public BigDecimal bigDecimalValue() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator));
    }

    public BigDecimal bigDecimalValue(int roundingMode) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), roundingMode);
    }

    public BigDecimal bigDecimalValue(int scale, int roundingMode) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), scale, roundingMode);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BigFraction object) {
        BigInteger nOd = this.numerator.multiply(object.denominator);
        BigInteger dOn = this.denominator.multiply(object.numerator);
        return nOd.compareTo(dOn);
    }

    public BigFraction divide(BigInteger bg) {
        if (BigInteger.ZERO.equals(bg) == true) goto L7;
        return new BigFraction(this.numerator, this.denominator.multiply(bg));
    L7:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public BigFraction divide(int i) {
        return divide(BigInteger.valueOf(i));
    }

    public BigFraction divide(long l) {
        return divide(BigInteger.valueOf(l));
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public BigFraction divide2(BigFraction fraction) {
        if (fraction == null) goto L10;
        if (BigInteger.ZERO.equals(fraction.numerator) == true) goto L8;
        return multiply2(fraction.reciprocal());
    L8:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L10:
        throw new NullPointerException(LocalizedFormats.FRACTION.getSourceString());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.numerator.doubleValue() / this.denominator.doubleValue();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof BigFraction) == false) goto L16;
        BigFraction rhs = ((BigFraction) other).reduce();
        BigFraction thisOne = reduce();
        if (thisOne.numerator.equals(rhs.numerator) == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        boolean ret = r3;
        return ret;
    L10:
        if (thisOne.denominator.equals(rhs.denominator) == false) goto L12;
        r3 = true;
        goto L13
    L16:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator.floatValue() / this.denominator.floatValue();
    }

    public BigInteger getDenominator() {
        return this.denominator;
    }

    public int getDenominatorAsInt() {
        return this.denominator.intValue();
    }

    public long getDenominatorAsLong() {
        return this.denominator.longValue();
    }

    public BigInteger getNumerator() {
        return this.numerator;
    }

    public int getNumeratorAsInt() {
        return this.numerator.intValue();
    }

    public long getNumeratorAsLong() {
        return this.numerator.longValue();
    }

    public int hashCode() {
        return ((this.numerator.hashCode() + 629) * 37) + this.denominator.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator.divide(this.denominator).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator.divide(this.denominator).longValue();
    }

    public BigFraction multiply(BigInteger bg) {
        if (bg == null) goto L6;
        return new BigFraction(bg.multiply(this.numerator), this.denominator);
    L6:
        throw new NullPointerException();
    }

    public BigFraction multiply(int i) {
        return multiply(BigInteger.valueOf(i));
    }

    public BigFraction multiply(long l) {
        return multiply(BigInteger.valueOf(l));
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigFraction multiply2(BigFraction fraction) {
        if (fraction == null) goto L13;
        if (this.numerator.equals(BigInteger.ZERO) == true) goto L11;
        if (fraction.numerator.equals(BigInteger.ZERO) == true) goto L11;
        return new BigFraction(this.numerator.multiply(fraction.numerator), this.denominator.multiply(fraction.denominator));
    L11:
        return ZERO;
    L13:
        throw new NullPointerException(LocalizedFormats.FRACTION.getSourceString());
    }

    public BigFraction negate() {
        return new BigFraction(this.numerator.negate(), this.denominator);
    }

    public double percentageValue() {
        return this.numerator.divide(this.denominator).multiply(ONE_HUNDRED_DOUBLE).doubleValue();
    }

    public BigFraction pow(int exponent) {
        if (exponent >= 0) goto L6;
        return new BigFraction(this.denominator.pow(-exponent), this.numerator.pow(-exponent));
    L6:
        return new BigFraction(this.numerator.pow(exponent), this.denominator.pow(exponent));
    }

    public BigFraction pow(long exponent) {
        if (exponent >= 0) goto L7;
        return new BigFraction(MathUtils.pow(this.denominator, -exponent), MathUtils.pow(this.numerator, -exponent));
    L7:
        return new BigFraction(MathUtils.pow(this.numerator, exponent), MathUtils.pow(this.denominator, exponent));
    }

    public BigFraction pow(BigInteger exponent) {
        if (exponent.compareTo(BigInteger.ZERO) >= 0) goto L7;
        BigInteger eNeg = exponent.negate();
        return new BigFraction(MathUtils.pow(this.denominator, eNeg), MathUtils.pow(this.numerator, eNeg));
    L7:
        return new BigFraction(MathUtils.pow(this.numerator, exponent), MathUtils.pow(this.denominator, exponent));
    }

    public double pow(double exponent) {
        return FastMath.pow(this.numerator.doubleValue(), exponent) / FastMath.pow(this.denominator.doubleValue(), exponent);
    }

    public BigFraction reciprocal() {
        return new BigFraction(this.denominator, this.numerator);
    }

    public BigFraction reduce() {
        BigInteger gcd = this.numerator.gcd(this.denominator);
        return new BigFraction(this.numerator.divide(gcd), this.denominator.divide(gcd));
    }

    public BigFraction subtract(BigInteger bg) {
        if (bg == null) goto L6;
        return new BigFraction(this.numerator.subtract(this.denominator.multiply(bg)), this.denominator);
    L6:
        throw new NullPointerException();
    }

    public BigFraction subtract(int i) {
        return subtract(BigInteger.valueOf(i));
    }

    public BigFraction subtract(long l) {
        return subtract(BigInteger.valueOf(l));
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public BigFraction subtract2(BigFraction fraction) {
        if (fraction == null) goto L13;
        if (ZERO.equals(fraction) == false) goto L7;
        return this;
    L7:
        if (this.denominator.equals(fraction.denominator) == false) goto L9;
        BigInteger num = this.numerator.subtract(fraction.numerator);
        BigInteger den = this.denominator;
    L11:
        return new BigFraction(num, den);
    L9:
        num = this.numerator.multiply(fraction.denominator).subtract(fraction.numerator.multiply(this.denominator));
        den = this.denominator.multiply(fraction.denominator);
        goto L11
    L13:
        throw new NullPointerException(LocalizedFormats.FRACTION.getSourceString());
    }

    public String toString() {
        if (BigInteger.ONE.equals(this.denominator) == false) goto L6;
        String str = this.numerator.toString();
        return str;
    L6:
        if (BigInteger.ZERO.equals(this.numerator) == false) goto L8;
        return "0";
    L8:
        String str2 = this.numerator + " / " + this.denominator;
        return str2;
    }

    @Override // org.apache.commons.math.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<BigFraction> getField2() {
        return BigFractionField.getInstance();
    }
}
