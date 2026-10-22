package org.apache.commons.math.util;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ContinuedFraction {
    private static final double DEFAULT_EPSILON = 1.0E-8d;

    protected abstract double getA(int r1, double r2);

    protected abstract double getB(int r1, double r2);

    protected ContinuedFraction() {
    }

    public double evaluate(double x) throws MathException {
        return evaluate(x, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public double evaluate(double x, double epsilon) throws MathException {
        return evaluate(x, epsilon, Integer.MAX_VALUE);
    }

    public double evaluate(double x, int maxIterations) throws MathException {
        return evaluate(x, DEFAULT_EPSILON, maxIterations);
    }

    public double evaluate(double x, double epsilon, int maxIterations) throws MathException {
        ContinuedFraction r0 = this;
        double r1 = x;
        double p0 = 1.0d;
        double p1 = r0.getA(0, r1);
        double q0 = 0.0d;
        double q1 = 1.0d;
        double c = p1 / 1.0d;
        int n = 0;
        double relativeError = Double.MAX_VALUE;
    L3:
        if (n >= maxIterations) goto L45;
        if (relativeError <= epsilon) goto L45;
        n = n + 1;
        double p2 = p1;
        double a = r0.getA(n, r1);
        double p3 = p0;
        double b = r0.getB(n, r1);
        double p4 = (a * p2) + (b * p3);
        double q2 = (a * q1) + (b * q0);
        boolean infinite = false;
        if (Double.isInfinite(p4) == false) goto L9;
    L10:
        double scaleFactor = 1.0d;
        double scale = FastMath.max(a, b);
        if (scale <= 0.0d) goto L43;
        infinite = true;
        int i = 0;
    L14:
        if (i >= 5) goto L34;
        double lastScaleFactor = scaleFactor;
        scaleFactor = scaleFactor * scale;
        if (a == 0.0d) goto L21;
        if (a <= b) goto L21;
        q2 = (q1 / lastScaleFactor) + ((b / scaleFactor) * q0);
        p4 = (p2 / lastScaleFactor) + ((b / scaleFactor) * p3);
    L24:
        if (Double.isInfinite(p4) == false) goto L26;
    L29:
        boolean r2 = true;
    L30:
        infinite = r2;
        if (infinite == false) goto L34;
        i = i + 1;
        goto L14
    L26:
        if (Double.isInfinite(q2) == true) goto L29;
        r2 = false;
    L21:
        if (b == 0.0d) goto L24;
        q2 = ((a / scaleFactor) * q1) + (q0 / lastScaleFactor);
        p4 = ((a / scaleFactor) * p2) + (p3 / lastScaleFactor);
    L34:
        if (infinite == true) goto L41;
        double r = p4 / q2;
        if (Double.isNaN(r) == true) goto L39;
        relativeError = FastMath.abs((r / c) - 1.0d);
        c = p4 / q2;
        q0 = q1;
        q1 = q2;
        r0 = this;
        r1 = x;
        p1 = p4;
        p0 = p2;
        goto L3
    L39:
        throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_NAN_DIVERGENCE, new Object[]{Double.valueOf(x)});
    L41:
        throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_INFINITY_DIVERGENCE, new Object[]{Double.valueOf(x)});
    L43:
        throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_INFINITY_DIVERGENCE, new Object[]{Double.valueOf(x)});
    L9:
        if (Double.isInfinite(q2) == false) goto L34;
    L45:
        if (n >= maxIterations) goto L48;
        return c;
    L48:
        throw new MaxIterationsExceededException(maxIterations, LocalizedFormats.NON_CONVERGENT_CONTINUED_FRACTION, new Object[]{Double.valueOf(x)});
    }
}
