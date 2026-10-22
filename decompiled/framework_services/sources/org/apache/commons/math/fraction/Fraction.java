package org.apache.commons.math.fraction;

import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class Fraction extends Number implements FieldElement<Fraction>, Comparable<Fraction>, Serializable {
    public static final Fraction FOUR_FIFTHS = null;
    public static final Fraction MINUS_ONE = null;
    public static final Fraction ONE = null;
    public static final Fraction ONE_FIFTH = null;
    public static final Fraction ONE_HALF = null;
    public static final Fraction ONE_QUARTER = null;
    public static final Fraction ONE_THIRD = null;
    public static final Fraction THREE_FIFTHS = null;
    public static final Fraction THREE_QUARTERS = null;
    public static final Fraction TWO = null;
    public static final Fraction TWO_FIFTHS = null;
    public static final Fraction TWO_QUARTERS = null;
    public static final Fraction TWO_THIRDS = null;
    public static final Fraction ZERO = null;
    private static final long serialVersionUID = 3698073679419233275L;
    private final int denominator;
    private final int numerator;

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Fraction add(Fraction r1) {
        return add2(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Fraction r1) {
        return compareTo2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Fraction divide(Fraction r1) throws ArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Field<Fraction> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Fraction multiply(Fraction r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Fraction subtract(Fraction r1) {
        return subtract2(r1);
    }

    static {
        TWO = new Fraction(2, 1);
        ONE = new Fraction(1, 1);
        ZERO = new Fraction(0, 1);
        FOUR_FIFTHS = new Fraction(4, 5);
        ONE_FIFTH = new Fraction(1, 5);
        ONE_HALF = new Fraction(1, 2);
        ONE_QUARTER = new Fraction(1, 4);
        ONE_THIRD = new Fraction(1, 3);
        THREE_FIFTHS = new Fraction(3, 5);
        THREE_QUARTERS = new Fraction(3, 4);
        TWO_FIFTHS = new Fraction(2, 5);
        TWO_QUARTERS = new Fraction(2, 4);
        TWO_THIRDS = new Fraction(2, 3);
        MINUS_ONE = new Fraction(-1, 1);
    }

    public Fraction(double value) throws FractionConversionException {
        this(value, 1.0E-5d, 100);
    }

    public Fraction(double value, double epsilon, int maxIterations) throws FractionConversionException {
        this(value, epsilon, Integer.MAX_VALUE, maxIterations);
    }

    public Fraction(double value, int maxDenominator) throws FractionConversionException {
        this(value, 0.0d, maxDenominator, 100);
    }

    private Fraction(double value, double epsilon, int maxDenominator, int maxIterations) throws FractionConversionException {
        long p1 = 2147483647L;
        long a0 = (long) FastMath.floor(value);
        if (a0 > 2147483647L) goto L35;
        int r6 = 1;
        if (FastMath.abs(a0 - value) >= epsilon) goto L8;
        this.numerator = (int) a0;
        this.denominator = 1;
        return;
    L8:
        int n = 0;
        boolean stop = false;
        long q1 = a0;
        long q2 = 1;
        long a1 = a0;
        long q0 = 0;
        double r0 = value;
        long p2 = 1;
    L9:
        n = n + r6;
        double r1 = 1.0d / (r0 - q1);
        long a2 = (long) FastMath.floor(r1);
        long p3 = (a2 * a1) + p2;
        long a3 = (a2 * q2) + q0;
        if (p3 > p1) goto L33;
        if (a3 > p1) goto L33;
        long overflow = p1;
        double convergent = p3 / a3;
        if (n >= maxIterations) goto L21;
        if (FastMath.abs(convergent - value) <= epsilon) goto L21;
        if (a3 >= maxDenominator) goto L21;
        long p0 = a1;
        q0 = q2;
        r0 = r1;
        p2 = p0;
        long p4 = p3;
        long q3 = a2;
        long a4 = a3;
    L22:
        if (stop == true) goto L23;
        q2 = a4;
        q1 = q3;
        a1 = p4;
        p1 = overflow;
        r6 = 1;
        goto L9
    L23:
        if (n >= maxIterations) goto L30;
        if (a3 >= maxDenominator) goto L27;
        this.numerator = (int) p3;
        this.denominator = (int) a3;
        return;
    L27:
        this.numerator = (int) p4;
        this.denominator = (int) a4;
        return;
    L30:
        throw new FractionConversionException(value, maxIterations);
    L21:
        stop = true;
        p4 = a1;
        q3 = q1;
        a4 = q2;
    L33:
        throw new FractionConversionException(value, p3, a3);
    L35:
        throw new FractionConversionException(value, a0, 1);
    }

    public Fraction(int num) {
        this(num, 1);
    }

    public Fraction(int num, int den) {
        if (den == 0) goto L19;
        if (den < 0) goto L6;
    L11:
        int d = MathUtils.gcd(num, den);
        if (d <= 1) goto L14;
        num = num / d;
        den = den / d;
    L14:
        if (den >= 0) goto L16;
        num = -num;
        den = -den;
    L16:
        this.numerator = num;
        this.denominator = den;
        return;
    L6:
        if (num == Integer.MIN_VALUE) goto L10;
        if (den == Integer.MIN_VALUE) goto L10;
        num = -num;
        den = -den;
    L10:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, new Object[]{Integer.valueOf(num), Integer.valueOf(den)});
    L19:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, new Object[]{Integer.valueOf(num), Integer.valueOf(den)});
    }

    public Fraction abs() {
        if (this.numerator < 0) goto L6;
        return this;
    L6:
        return negate();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Fraction object) {
        long nOd = ((long) this.numerator) * ((long) object.denominator);
        long dOn = ((long) this.denominator) * ((long) object.numerator);
        if (nOd >= dOn) goto L6;
        return -1;
    L6:
        if (nOd <= dOn) goto L8;
        return 1;
    L8:
        return 0;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof Fraction) == false) goto L14;
        Fraction rhs = (Fraction) other;
        if (this.numerator != rhs.numerator) goto L13;
        if (this.denominator != rhs.denominator) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int hashCode() {
        return ((this.numerator + 629) * 37) + this.denominator;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) doubleValue();
    }

    public Fraction negate() {
        if (this.numerator == Integer.MIN_VALUE) goto L7;
        return new Fraction(-this.numerator, this.denominator);
    L7:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, new Object[]{Integer.valueOf(this.numerator), Integer.valueOf(this.denominator)});
    }

    public Fraction reciprocal() {
        return new Fraction(this.denominator, this.numerator);
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Fraction add2(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction add(int i) {
        return new Fraction(this.numerator + (this.denominator * i), this.denominator);
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Fraction subtract2(Fraction fraction) {
        return addSub(fraction, false);
    }

    public Fraction subtract(int i) {
        return new Fraction(this.numerator - (this.denominator * i), this.denominator);
    }

    private Fraction addSub(Fraction fraction, boolean isAdd) {
        if (fraction == null) goto L35;
        if (this.numerator != 0) goto L10;
        if (isAdd == false) goto L8;
        return fraction;
    L8:
        return fraction.negate();
    L10:
        if (fraction.numerator != 0) goto L12;
        return this;
    L12:
        int d1 = MathUtils.gcd(this.denominator, fraction.denominator);
        if (d1 != 1) goto L20;
        int uvp = MathUtils.mulAndCheck(this.numerator, fraction.denominator);
        int upv = MathUtils.mulAndCheck(fraction.numerator, this.denominator);
        if (isAdd == false) goto L17;
        int r4 = MathUtils.addAndCheck(uvp, upv);
    L19:
        return new Fraction(r4, MathUtils.mulAndCheck(this.denominator, fraction.denominator));
    L17:
        r4 = MathUtils.subAndCheck(uvp, upv);
        goto L19
    L20:
        BigInteger uvp2 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / d1));
        BigInteger upv2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / d1));
        if (isAdd == false) goto L23;
        BigInteger t = uvp2.add(upv2);
    L24:
        int tmodd1 = t.mod(BigInteger.valueOf(d1)).intValue();
        if (tmodd1 != 0) goto L27;
        int d2 = d1;
    L28:
        BigInteger w = t.divide(BigInteger.valueOf(d2));
        if (w.bitLength() > 31) goto L33;
        return new Fraction(w.intValue(), MathUtils.mulAndCheck(this.denominator / d1, fraction.denominator / d2));
    L33:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.NUMERATOR_OVERFLOW_AFTER_MULTIPLY, new Object[]{w});
    L27:
        d2 = MathUtils.gcd(tmodd1, d1);
        goto L28
    L23:
        t = uvp2.subtract(upv2);
        goto L24
    L35:
        throw new NullArgumentException(LocalizedFormats.FRACTION);
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Fraction multiply2(Fraction fraction) {
        if (fraction == null) goto L13;
        if (this.numerator == 0) goto L11;
        if (fraction.numerator == 0) goto L11;
        int d1 = MathUtils.gcd(this.numerator, fraction.denominator);
        int d2 = MathUtils.gcd(fraction.numerator, this.denominator);
        return getReducedFraction(MathUtils.mulAndCheck(this.numerator / d1, fraction.numerator / d2), MathUtils.mulAndCheck(this.denominator / d2, fraction.denominator / d1));
    L11:
        return ZERO;
    L13:
        throw new NullArgumentException(LocalizedFormats.FRACTION);
    }

    public Fraction multiply(int i) {
        return new Fraction(this.numerator * i, this.denominator);
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public Fraction divide2(Fraction fraction) {
        if (fraction == null) goto L10;
        if (fraction.numerator == 0) goto L8;
        return multiply2(fraction.reciprocal());
    L8:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_FRACTION_TO_DIVIDE_BY, new Object[]{Integer.valueOf(fraction.numerator), Integer.valueOf(fraction.denominator)});
    L10:
        throw new NullArgumentException(LocalizedFormats.FRACTION);
    }

    public Fraction divide(int i) {
        return new Fraction(this.numerator, this.denominator * i);
    }

    public static Fraction getReducedFraction(int numerator, int denominator) {
        if (denominator == 0) goto L20;
        if (numerator != 0) goto L7;
        return ZERO;
    L7:
        if (denominator == Integer.MIN_VALUE) goto L9;
    L11:
        if (denominator >= 0) goto L17;
        if (numerator == Integer.MIN_VALUE) goto L16;
        if (denominator == Integer.MIN_VALUE) goto L16;
        numerator = -numerator;
        denominator = -denominator;
    L16:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, new Object[]{Integer.valueOf(numerator), Integer.valueOf(denominator)});
    L17:
        int gcd = MathUtils.gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    L9:
        if ((numerator & 1) != 0) goto L11;
        numerator = numerator / 2;
        denominator = denominator / 2;
        goto L11
    L20:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, new Object[]{Integer.valueOf(numerator), Integer.valueOf(denominator)});
    }

    public String toString() {
        if (this.denominator != 1) goto L6;
        String str = Integer.toString(this.numerator);
        return str;
    L6:
        if (this.numerator != 0) goto L8;
        return "0";
    L8:
        String str2 = this.numerator + " / " + this.denominator;
        return str2;
    }

    @Override // org.apache.commons.math.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<Fraction> getField2() {
        return FractionField.getInstance();
    }
}
