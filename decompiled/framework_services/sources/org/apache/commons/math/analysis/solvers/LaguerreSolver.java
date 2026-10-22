package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class LaguerreSolver extends UnivariateRealSolverImpl {

    @Deprecated
    private final PolynomialFunction p;

    @Deprecated
    public LaguerreSolver(UnivariateRealFunction f) throws IllegalArgumentException {
        super(f, 100, 1.0E-6d);
        if ((f instanceof PolynomialFunction) == false) goto L7;
        this.p = (PolynomialFunction) f;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FUNCTION_NOT_POLYNOMIAL, new Object[0]);
    }

    @Deprecated
    public LaguerreSolver() {
        super(100, 1.0E-6d);
        this.p = null;
    }

    @Deprecated
    public PolynomialFunction getPolynomialFunction() {
        return new PolynomialFunction(this.p.getCoefficients());
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max) throws ConvergenceException, FunctionEvaluationException {
        return solve(this.p, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max, double initial) throws ConvergenceException, FunctionEvaluationException {
        return solve(this.p, min, max, initial);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max, double initial) throws ConvergenceException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max, initial);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max, double initial) throws ConvergenceException, FunctionEvaluationException {
        if (f.value(min) != 0.0d) goto L6;
        return min;
    L6:
        if (f.value(max) != 0.0d) goto L9;
        return max;
    L9:
        if (f.value(initial) != 0.0d) goto L11;
        return initial;
    L11:
        verifyBracketing(min, max, f);
        verifySequence(min, initial, max);
        if (isBracketing(min, initial, f) == false) goto L16;
        return solve(f, min, initial);
    L16:
        return solve(f, initial, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max) throws ConvergenceException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max) throws ConvergenceException, FunctionEvaluationException {
        if ((f instanceof PolynomialFunction) == false) goto L29;
        if (f.value(min) != 0.0d) goto L8;
        return min;
    L8:
        if (f.value(max) != 0.0d) goto L10;
        return max;
    L10:
        verifyBracketing(min, max, f);
        double[] coefficients = ((PolynomialFunction) f).getCoefficients();
        Complex[] c = new Complex[coefficients.length];
        int i = 0;
    L12:
        if (i >= coefficients.length) goto L14;
        c[i] = new Complex(coefficients[i], 0.0d);
        i = i + 1;
        goto L12
    L14:
        Complex initial = new Complex((min + max) * 0.5d, 0.0d);
        Complex z = solve(c, initial);
        if (isRootOK(min, max, z) == false) goto L18;
        setResult(z.getReal(), this.iterationCount);
        return this.result;
    L18:
        Complex[] root = solveAll(c, initial);
        int i2 = 0;
    L20:
        if (i2 >= root.length) goto L27;
        if (isRootOK(min, max, root[i2]) == true) goto L23;
        i2 = i2 + 1;
        goto L20
    L23:
        setResult(root[i2].getReal(), this.iterationCount);
        return this.result;
    L27:
        throw new ConvergenceException();
    L29:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FUNCTION_NOT_POLYNOMIAL, new Object[0]);
    }

    protected boolean isRootOK(double min, double max, Complex z) {
        double tolerance = FastMath.max(this.relativeAccuracy * z.abs(), this.absoluteAccuracy);
        if (isSequence(min, z.getReal(), max) == true) goto L5;
    L9:
        return false;
    L5:
        if (FastMath.abs(z.getImaginary()) > tolerance) goto L7;
    L8:
        return true;
    L7:
        if (z.abs() > this.functionValueAccuracy) goto L9;
        goto L8
    }

    @Deprecated
    public Complex[] solveAll(double[] coefficients, double initial) throws ConvergenceException, FunctionEvaluationException {
        Complex[] c = new Complex[coefficients.length];
        Complex z = new Complex(initial, 0.0d);
        int i = 0;
    L4:
        if (i >= c.length) goto L7;
        c[i] = new Complex(coefficients[i], 0.0d);
        i = i + 1;
        goto L4
    L7:
        return solveAll(c, z);
    }

    @Deprecated
    public Complex[] solveAll(Complex[] coefficients, Complex initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        int n = coefficients.length - 1;
        int iterationCount = 0;
        if (n < 1) goto L16;
        Complex[] c = new Complex[n + 1];
        int i = 0;
    L5:
        if (i > n) goto L7;
        c[i] = coefficients[i];
        i = i + 1;
        goto L5
    L7:
        Complex[] root = new Complex[n];
        int i2 = 0;
    L8:
        if (i2 >= n) goto L13;
        Complex[] subarray = new Complex[(n - i2) + 1];
        System.arraycopy(c, 0, subarray, 0, subarray.length);
        root[i2] = solve(subarray, initial);
        Complex newc = c[n - i2];
        int j = (n - i2) - 1;
    L10:
        if (j < 0) goto L12;
        Complex oldc = c[j];
        c[j] = newc;
        newc = oldc.add2(newc.multiply2(root[i2]));
        j = j - 1;
        goto L10
    L12:
        int j2 = this.iterationCount;
        iterationCount = iterationCount + j2;
        i2 = i2 + 1;
        goto L8
    L13:
        this.resultComputed = true;
        this.iterationCount = iterationCount;
        return root;
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NON_POSITIVE_POLYNOMIAL_DEGREE, new Object[]{Integer.valueOf(n)});
    }

    @Deprecated
    public Complex solve(Complex[] coefficients, Complex initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        Complex[] r1 = coefficients;
        int n = r1.length - 1;
        if (n < 1) goto L30;
        Complex N = new Complex(n, 0.0d);
        Complex N1 = new Complex(n - 1, 0.0d);
        int i = 1;
        Complex G = null;
        Complex G2 = null;
        Complex H = null;
        Complex N2 = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Complex z = initial;
    L6:
        if (i > this.maximalIterationCount) goto L28;
        Complex pv = r1[n];
        Complex pv2 = Complex.ZERO;
        Complex d2v = Complex.ZERO;
        int j = n - 1;
        Complex pv3 = pv;
        Complex dv = pv2;
    L8:
        if (j < 0) goto L10;
        d2v = dv.add2(z.multiply2(d2v));
        dv = pv3.add2(z.multiply2(dv));
        pv3 = coefficients[j].add2(z.multiply2(pv3));
        j = j - 1;
        n = n;
        goto L8
    L10:
        int n2 = n;
        Complex d2v2 = d2v.multiply2(new Complex(2.0d, 0.0d));
        double tolerance = FastMath.max(this.relativeAccuracy * z.abs(), this.absoluteAccuracy);
        if (z.subtract2(N2).abs() <= tolerance) goto L12;
        if (pv3.abs() <= this.functionValueAccuracy) goto L16;
        Complex G3 = dv.divide2(pv3);
        G2 = G3.multiply2(G3);
        H = G2.subtract2(d2v2.divide2(pv3));
        Complex delta = N1.multiply2(N.multiply2(H).subtract2(G2));
        Complex deltaSqrt = delta.sqrt();
        Complex dplus = G3.add2(deltaSqrt);
        Complex dminus = G3.subtract2(deltaSqrt);
        if (dplus.abs() <= dminus.abs()) goto L21;
        Complex r22 = dplus;
    L22:
        Complex denominator = r22;
        if (denominator.equals(new Complex(0.0d, 0.0d)) == false) goto L25;
        z = z.add2(new Complex(this.absoluteAccuracy, this.absoluteAccuracy));
        Complex z2 = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    L26:
        i = i + 1;
        N1 = N1;
        G = G3;
        n = n2;
        N2 = z2;
        r1 = coefficients;
        goto L6
    L25:
        z2 = z;
        z = z.subtract2(N.divide2(denominator));
        goto L26
    L21:
        r22 = dminus;
        goto L22
    L16:
        this.resultComputed = true;
        this.iterationCount = i;
        return z;
    L12:
        this.resultComputed = true;
        this.iterationCount = i;
        return z;
    L28:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    L30:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NON_POSITIVE_POLYNOMIAL_DEGREE, new Object[]{Integer.valueOf(n)});
    }
}
