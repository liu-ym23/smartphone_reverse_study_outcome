package org.apache.commons.math.optimization.fitting;

import org.apache.commons.math.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer;
import org.apache.commons.math.optimization.OptimizationException;

/* JADX INFO: loaded from: classes3.dex */
public class PolynomialFitter {
    private final int degree;
    private final CurveFitter fitter;

    /* JADX INFO: renamed from: org.apache.commons.math.optimization.fitting.PolynomialFitter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ParametricPolynomial implements ParametricRealFunction {
        private ParametricPolynomial() {
        }

        /* synthetic */ ParametricPolynomial(AnonymousClass1 x0) {
            this();
        }

        @Override // org.apache.commons.math.optimization.fitting.ParametricRealFunction
        public double[] gradient(double x, double[] parameters) {
            double[] gradient = new double[parameters.length];
            double xn = 1.0d;
            int i = 0;
        L4:
            if (i >= parameters.length) goto L7;
            gradient[i] = xn;
            xn = xn * x;
            i = i + 1;
            goto L4
        L7:
            return gradient;
        }

        @Override // org.apache.commons.math.optimization.fitting.ParametricRealFunction
        public double value(double x, double[] parameters) {
            double y = 0.0d;
            int i = parameters.length - 1;
        L3:
            if (i < 0) goto L6;
            y = (y * x) + parameters[i];
            i = i - 1;
            goto L3
        L6:
            return y;
        }
    }

    public PolynomialFitter(int degree, DifferentiableMultivariateVectorialOptimizer optimizer) {
        this.fitter = new CurveFitter(optimizer);
        this.degree = degree;
    }

    public void addObservedPoint(double weight, double x, double y) {
        this.fitter.addObservedPoint(weight, x, y);
    }

    public void clearObservations() {
        this.fitter.clearObservations();
    }

    public PolynomialFunction fit() throws OptimizationException {
        return new PolynomialFunction(this.fitter.fit(new ParametricPolynomial(null), new double[this.degree + 1]));
    L4:
        fee = move-exception;
        throw new RuntimeException(fee);
    }
}
