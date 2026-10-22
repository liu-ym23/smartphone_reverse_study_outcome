package org.apache.commons.math.complex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class Complex implements FieldElement<Complex>, Serializable {
    public static final Complex I = null;
    public static final Complex INF = null;
    public static final Complex NaN = null;
    public static final Complex ONE = null;
    public static final Complex ZERO = null;
    private static final long serialVersionUID = -6195664516687396620L;
    private final double imaginary;
    private final transient boolean isInfinite;
    private final transient boolean isNaN;
    private final double real;

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Complex add(Complex r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Complex divide(Complex r1) throws ArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Field<Complex> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Complex multiply(Complex r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Complex subtract(Complex r1) {
        return subtract2(r1);
    }

    static {
        I = new Complex(0.0d, 1.0d);
        NaN = new Complex(Double.NaN, Double.NaN);
        INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        ONE = new Complex(1.0d, 0.0d);
        ZERO = new Complex(0.0d, 0.0d);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        boolean r1 = true;
        if (Double.isNaN(real) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.isNaN = r0;
        if (this.isNaN == false) goto L12;
    L16:
        r1 = false;
    L17:
        this.isInfinite = r1;
        return;
    L12:
        if (Double.isInfinite(real) == true) goto L17;
        if (Double.isInfinite(imaginary) == false) goto L16;
    L5:
        if (Double.isNaN(imaginary) == true) goto L8;
        r0 = false;
        goto L9
    }

    public double abs() {
        if (isNaN() == false) goto L7;
        return Double.NaN;
    L7:
        if (isInfinite() == false) goto L11;
        return Double.POSITIVE_INFINITY;
    L11:
        if (FastMath.abs(this.real) >= FastMath.abs(this.imaginary)) goto L19;
        if (this.imaginary == 0.0d) goto L15;
        double q = this.real / this.imaginary;
        return FastMath.abs(this.imaginary) * FastMath.sqrt((q * q) + 1.0d);
    L15:
        return FastMath.abs(this.real);
    L19:
        if (this.real == 0.0d) goto L21;
        double q2 = this.imaginary / this.real;
        return FastMath.abs(this.real) * FastMath.sqrt((q2 * q2) + 1.0d);
    L21:
        return FastMath.abs(this.imaginary);
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Complex add2(Complex rhs) {
        return createComplex(this.real + rhs.getReal(), this.imaginary + rhs.getImaginary());
    }

    public Complex conjugate() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(this.real, -this.imaginary);
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public Complex divide2(Complex rhs) {
        if (isNaN() == true) goto L26;
        if (rhs.isNaN() == true) goto L26;
        double c = rhs.getReal();
        double d = rhs.getImaginary();
        if (c != 0.0d) goto L14;
        if (d != 0.0d) goto L14;
        return NaN;
    L14:
        if (rhs.isInfinite() == false) goto L20;
        if (isInfinite() == true) goto L20;
        return ZERO;
    L20:
        if (FastMath.abs(c) >= FastMath.abs(d)) goto L23;
        double q = c / d;
        double denominator = (c * q) + d;
        return createComplex(((this.real * q) + this.imaginary) / denominator, ((this.imaginary * q) - this.real) / denominator);
    L23:
        double q2 = d / c;
        double denominator2 = (d * q2) + c;
        return createComplex(((this.imaginary * q2) + this.real) / denominator2, (this.imaginary - (this.real * q2)) / denominator2);
    L26:
        return NaN;
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof Complex) == false) goto L18;
        Complex rhs = (Complex) other;
        if (rhs.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.real != rhs.real) goto L17;
        if (this.imaginary != rhs.imaginary) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 7;
    L7:
        return ((MathUtils.hash(this.imaginary) * 17) + MathUtils.hash(this.real)) * 37;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public boolean isNaN() {
        return this.isNaN;
    }

    public boolean isInfinite() {
        return this.isInfinite;
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Complex multiply2(Complex rhs) {
        if (isNaN() == true) goto L21;
        if (rhs.isNaN() == true) goto L21;
        if (Double.isInfinite(this.real) == true) goto L19;
        if (Double.isInfinite(this.imaginary) == true) goto L19;
        if (Double.isInfinite(rhs.real) == true) goto L19;
        if (Double.isInfinite(rhs.imaginary) == true) goto L19;
        return createComplex((this.real * rhs.real) - (this.imaginary * rhs.imaginary), (this.real * rhs.imaginary) + (this.imaginary * rhs.real));
    L19:
        return INF;
    L21:
        return NaN;
    }

    public Complex multiply(double rhs) {
        if (isNaN() == true) goto L19;
        if (Double.isNaN(rhs) == true) goto L19;
        if (Double.isInfinite(this.real) == true) goto L17;
        if (Double.isInfinite(this.imaginary) == true) goto L17;
        if (Double.isInfinite(rhs) == true) goto L17;
        return createComplex(this.real * rhs, this.imaginary * rhs);
    L17:
        return INF;
    L19:
        return NaN;
    }

    public Complex negate() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(-this.real, -this.imaginary);
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Complex subtract2(Complex rhs) {
        if (isNaN() == true) goto L10;
        if (rhs.isNaN() == true) goto L10;
        return createComplex(this.real - rhs.getReal(), this.imaginary - rhs.getImaginary());
    L10:
        return NaN;
    }

    public Complex acos() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return add2(sqrt1z().multiply2(I)).log().multiply2(I.negate());
    }

    public Complex asin() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return sqrt1z().add2(multiply2(I)).log().multiply2(I.negate());
    }

    public Complex atan() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return add2(I).divide2(I.subtract2(this)).log().multiply2(I.divide2(createComplex(2.0d, 0.0d)));
    }

    public Complex cos() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.cos(this.real) * MathUtils.cosh(this.imaginary), (-FastMath.sin(this.real)) * MathUtils.sinh(this.imaginary));
    }

    public Complex cosh() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(MathUtils.cosh(this.real) * FastMath.cos(this.imaginary), MathUtils.sinh(this.real) * FastMath.sin(this.imaginary));
    }

    public Complex exp() {
        if (isNaN() == true) goto L5;
        double expReal = FastMath.exp(this.real);
        return createComplex(FastMath.cos(this.imaginary) * expReal, FastMath.sin(this.imaginary) * expReal);
    L5:
        return NaN;
    }

    public Complex log() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.log(abs()), FastMath.atan2(this.imaginary, this.real));
    }

    public Complex pow(Complex x) {
        if (x == null) goto L6;
        return log().multiply2(x).exp();
    L6:
        throw new NullPointerException();
    }

    public Complex sin() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.sin(this.real) * MathUtils.cosh(this.imaginary), FastMath.cos(this.real) * MathUtils.sinh(this.imaginary));
    }

    public Complex sinh() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        return createComplex(MathUtils.sinh(this.real) * FastMath.cos(this.imaginary), MathUtils.cosh(this.real) * FastMath.sin(this.imaginary));
    }

    public Complex sqrt() {
        if (isNaN() == false) goto L7;
        return NaN;
    L7:
        if (this.real == 0.0d) goto L9;
    L12:
        double t = FastMath.sqrt((FastMath.abs(this.real) + abs()) / 2.0d);
        if (this.real < 0.0d) goto L17;
        return createComplex(t, this.imaginary / (2.0d * t));
    L17:
        return createComplex(FastMath.abs(this.imaginary) / (2.0d * t), MathUtils.indicator(this.imaginary) * t);
    L9:
        if (this.imaginary != 0.0d) goto L12;
        return createComplex(0.0d, 0.0d);
    }

    public Complex sqrt1z() {
        return createComplex(1.0d, 0.0d).subtract2(multiply2(this)).sqrt();
    }

    public Complex tan() {
        if (isNaN() == true) goto L5;
        double real2 = this.real * 2.0d;
        double imaginary2 = this.imaginary * 2.0d;
        double d = FastMath.cos(real2) + MathUtils.cosh(imaginary2);
        return createComplex(FastMath.sin(real2) / d, MathUtils.sinh(imaginary2) / d);
    L5:
        return NaN;
    }

    public Complex tanh() {
        if (isNaN() == true) goto L5;
        double real2 = this.real * 2.0d;
        double imaginary2 = this.imaginary * 2.0d;
        double d = MathUtils.cosh(real2) + FastMath.cos(imaginary2);
        return createComplex(MathUtils.sinh(real2) / d, FastMath.sin(imaginary2) / d);
    L5:
        return NaN;
    }

    public double getArgument() {
        return FastMath.atan2(getImaginary(), getReal());
    }

    public List<Complex> nthRoot(int n) throws IllegalArgumentException {
        int r0 = n;
        if (r0 <= 0) goto L18;
        List<Complex> result = new ArrayList();
        if (isNaN() == false) goto L9;
        result.add(NaN);
        return result;
    L9:
        if (isInfinite() == false) goto L12;
        result.add(INF);
        return result;
    L12:
        double nthRootOfAbs = FastMath.pow(abs(), 1.0d / ((double) r0));
        double nthPhi = getArgument() / ((double) r0);
        double slice = 6.283185307179586d / ((double) r0);
        double innerPart = nthPhi;
        int k = 0;
    L13:
        if (k >= r0) goto L16;
        double realPart = FastMath.cos(innerPart) * nthRootOfAbs;
        double imaginaryPart = FastMath.sin(innerPart) * nthRootOfAbs;
        result.add(createComplex(realPart, imaginaryPart));
        innerPart = innerPart + slice;
        k = k + 1;
        r0 = n;
        goto L13
    L16:
        return result;
    L18:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N, new Object[]{Integer.valueOf(n)});
    }

    protected Complex createComplex(double realPart, double imaginaryPart) {
        return new Complex(realPart, imaginaryPart);
    }

    protected final Object readResolve() {
        return createComplex(this.real, this.imaginary);
    }

    @Override // org.apache.commons.math.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<Complex> getField2() {
        return ComplexField.getInstance();
    }
}
