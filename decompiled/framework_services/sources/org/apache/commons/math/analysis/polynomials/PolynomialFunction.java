package org.apache.commons.math.analysis.polynomials;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class PolynomialFunction implements DifferentiableUnivariateRealFunction, Serializable {
    private static final long serialVersionUID = -7726511984200295583L;
    private final double[] coefficients;

    public PolynomialFunction(double[] c) {
        int n = c.length;
        if (n == 0) goto L12;
    L5:
        if (n <= 1) goto L9;
        if (c[n - 1] != 0.0d) goto L9;
        n = n - 1;
    L9:
        this.coefficients = new double[n];
        System.arraycopy(c, 0, this.coefficients, 0, n);
        return;
    L12:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double x) {
        return evaluate(this.coefficients, x);
    }

    public int degree() {
        return this.coefficients.length - 1;
    }

    public double[] getCoefficients() {
        return (double[]) this.coefficients.clone();
    }

    protected static double evaluate(double[] coefficients, double argument) {
        int n = coefficients.length;
        if (n == 0) goto L10;
        double result = coefficients[n - 1];
        int j = n - 2;
    L5:
        if (j < 0) goto L8;
        result = (argument * result) + coefficients[j];
        j = j - 1;
        goto L5
    L8:
        return result;
    L10:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    public PolynomialFunction add(PolynomialFunction p) {
        int lowLength = FastMath.min(this.coefficients.length, p.coefficients.length);
        int highLength = FastMath.max(this.coefficients.length, p.coefficients.length);
        double[] newCoefficients = new double[highLength];
        int i = 0;
    L3:
        if (i >= lowLength) goto L6;
        newCoefficients[i] = this.coefficients[i] + p.coefficients[i];
        i = i + 1;
        goto L3
    L6:
        if (this.coefficients.length >= p.coefficients.length) goto L8;
        double[] r3 = p.coefficients;
    L9:
        System.arraycopy(r3, lowLength, newCoefficients, lowLength, highLength - lowLength);
        return new PolynomialFunction(newCoefficients);
    L8:
        r3 = this.coefficients;
        goto L9
    }

    public PolynomialFunction subtract(PolynomialFunction p) {
        int lowLength = FastMath.min(this.coefficients.length, p.coefficients.length);
        int highLength = FastMath.max(this.coefficients.length, p.coefficients.length);
        double[] newCoefficients = new double[highLength];
        int i = 0;
    L3:
        if (i >= lowLength) goto L6;
        newCoefficients[i] = this.coefficients[i] - p.coefficients[i];
        i = i + 1;
        goto L3
    L6:
        if (this.coefficients.length >= p.coefficients.length) goto L11;
        int i2 = lowLength;
    L8:
        if (i2 >= highLength) goto L13;
        newCoefficients[i2] = -p.coefficients[i2];
        i2 = i2 + 1;
    L13:
        return new PolynomialFunction(newCoefficients);
    L11:
        System.arraycopy(this.coefficients, lowLength, newCoefficients, lowLength, highLength - lowLength);
        goto L13
    }

    public PolynomialFunction negate() {
        double[] newCoefficients = new double[this.coefficients.length];
        int i = 0;
    L4:
        if (i >= this.coefficients.length) goto L7;
        newCoefficients[i] = -this.coefficients[i];
        i = i + 1;
        goto L4
    L7:
        return new PolynomialFunction(newCoefficients);
    }

    public PolynomialFunction multiply(PolynomialFunction p) {
        double[] newCoefficients = new double[(this.coefficients.length + p.coefficients.length) - 1];
        int i = 0;
    L4:
        if (i >= newCoefficients.length) goto L11;
        newCoefficients[i] = 0.0d;
        int j = FastMath.max(0, (i + 1) - p.coefficients.length);
    L7:
        if (j >= FastMath.min(this.coefficients.length, i + 1)) goto L9;
        newCoefficients[i] = newCoefficients[i] + (this.coefficients[j] * p.coefficients[i - j]);
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return new PolynomialFunction(newCoefficients);
    }

    protected static double[] differentiate(double[] coefficients) {
        int n = coefficients.length;
        if (n == 0) goto L13;
        if (n == 1) goto L6;
        double[] result = new double[n - 1];
        int i = n - 1;
    L8:
        if (i <= 0) goto L11;
        result[i - 1] = ((double) i) * coefficients[i];
        i = i - 1;
        goto L8
    L11:
        return result;
    L6:
        return new double[]{0.0d};
    L13:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    public PolynomialFunction polynomialDerivative() {
        return new PolynomialFunction(differentiate(this.coefficients));
    }

    @Override // org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction
    public UnivariateRealFunction derivative() {
        return polynomialDerivative();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.coefficients[0] == 0.0d) goto L5;
        s.append(Double.toString(this.coefficients[0]));
    L9:
        int i = 1;
    L11:
        if (i >= this.coefficients.length) goto L31;
        if (this.coefficients[i] == 0.0d) goto L29;
        if (s.length() <= 0) goto L21;
        if (this.coefficients[i] >= 0.0d) goto L19;
        s.append(" - ");
    L23:
        double absAi = FastMath.abs(this.coefficients[i]);
        if ((absAi - 1.0d) == 0.0d) goto L26;
        s.append(Double.toString(absAi));
        s.append(' ');
    L26:
        s.append("x");
        if (i <= 1) goto L29;
        s.append('^');
        s.append(Integer.toString(i));
        goto L29
    L19:
        s.append(" + ");
        goto L23
    L21:
        if (this.coefficients[i] >= 0.0d) goto L23;
        s.append("-");
    L29:
        i = i + 1;
        goto L11
    L31:
        return s.toString();
    L5:
        if (this.coefficients.length != 1) goto L9;
        return "0";
    }

    public int hashCode() {
        int result = (1 * 31) + Arrays.hashCode(this.coefficients);
        return result;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof PolynomialFunction) == true) goto L8;
        return false;
    L8:
        PolynomialFunction other = (PolynomialFunction) obj;
        if (Arrays.equals(this.coefficients, other.coefficients) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
