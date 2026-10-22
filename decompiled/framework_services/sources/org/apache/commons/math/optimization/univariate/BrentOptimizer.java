package org.apache.commons.math.optimization.univariate;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BrentOptimizer extends AbstractUnivariateRealOptimizer {
    private static final double GOLDEN_SECTION = 0.0d;

    static {
        GOLDEN_SECTION = (3.0d - FastMath.sqrt(5.0d)) * 0.5d;
    }

    public BrentOptimizer() {
        setMaxEvaluations(1000);
        setMaximalIterationCount(100);
        setAbsoluteAccuracy(1.0E-11d);
        setRelativeAccuracy(1.0E-9d);
    }

    @Override // org.apache.commons.math.optimization.univariate.AbstractUnivariateRealOptimizer
    protected double doOptimize() throws MaxIterationsExceededException, FunctionEvaluationException {
        if (getGoalType() != GoalType.MINIMIZE) goto L6;
        boolean r0 = true;
    L5:
        boolean r2 = r0;
        return localMin(r2, getMin(), getStartValue(), getMax(), getRelativeAccuracy(), getAbsoluteAccuracy());
    L6:
        r0 = false;
        goto L5
    }

    private double localMin(boolean isMinim, double lo, double mid, double hi, double eps, double t) throws MaxIterationsExceededException, FunctionEvaluationException {
        if (eps <= 0.0d) goto L94;
        if (t <= 0.0d) goto L92;
        if (lo >= hi) goto L9;
        double a = lo;
        double b = hi;
    L10:
        double u = mid;
        double v = u;
        double w = u;
        double d = 0.0d;
        double e = 0.0d;
        double fx = computeObjectiveValue(u);
        if (isMinim == true) goto L13;
        fx = -fx;
    L13:
        double fv = fx;
        double fw = fx;
    L14:
        double m = (a + b) * 0.5d;
        double a2 = a;
        double a3 = (FastMath.abs(u) * eps) + t;
        double tol2 = a3 * 2.0d;
        if (FastMath.abs(u - m) <= (tol2 - ((b - a2) * 0.5d))) goto L85;
        if (FastMath.abs(e) <= a3) goto L43;
        double r = (u - w) * (fx - fv);
        double q = (u - v) * (fx - fw);
        double b2 = b;
        double b3 = ((u - v) * q) - ((u - w) * r);
        double p = q - r;
        double x = u;
        double x2 = p * 2.0d;
        if (x2 <= 0.0d) goto L21;
        double p2 = -b3;
        double p3 = p2;
        double q2 = x2;
    L22:
        double r2 = e;
        double e2 = d;
        if (p3 <= ((a2 - x) * q2)) goto L39;
        if (p3 >= ((b2 - x) * q2)) goto L39;
        if (FastMath.abs(p3) >= FastMath.abs((0.5d * q2) * r2)) goto L39;
        double d2 = p3 / q2;
        double u2 = x + d2;
        if ((u2 - a2) < tol2) goto L35;
        if ((b2 - u2) < tol2) goto L35;
        e = e2;
        d = d2;
    L48:
        double e3 = FastMath.abs(d);
        if (e3 < a3) goto L51;
        u = x + d;
    L55:
        double fu = computeObjectiveValue(u);
        if (isMinim == true) goto L59;
        fu = -fu;
    L59:
        if (fu > fx) goto L66;
        if (u >= x) goto L63;
        b2 = x;
        double a4 = a2;
    L64:
        v = w;
        fv = fw;
        w = x;
        fw = fx;
        fx = fu;
    L84:
        b = b2;
        incrementIterationsCounter();
        a = a4;
        goto L14
    L63:
        a4 = x;
        goto L64
    L66:
        if (u >= x) goto L68;
        a4 = u;
    L70:
        if (fu > fw) goto L72;
    L83:
        v = w;
        fv = fw;
        w = u;
        fw = fu;
        u = x;
        goto L84
    L72:
        if (w == x) goto L83;
        if (fu > fv) goto L77;
    L82:
        v = u;
        fv = fu;
        u = x;
        goto L84
    L77:
        if (v == x) goto L82;
        if (v == w) goto L82;
        u = x;
        goto L84
    L68:
        double a5 = u;
        b2 = a5;
        a4 = a2;
        goto L70
    L51:
        if (d < 0.0d) goto L53;
        u = x + a3;
        goto L55
    L53:
        u = x - a3;
    L35:
        if (x > m) goto L37;
        e = e2;
        d = a3;
        goto L48
    L37:
        double d3 = -a3;
        e = e2;
        d = d3;
    L39:
        if (x >= m) goto L41;
        double e4 = b2 - x;
    L42:
        e = e4;
        d = GOLDEN_SECTION * e4;
        goto L48
    L41:
        e4 = a2 - x;
        goto L42
    L21:
        p3 = b3;
        q2 = -x2;
        goto L22
    L43:
        b2 = b;
        x = u;
        if (x >= m) goto L46;
        double e5 = b2 - x;
    L47:
        e = e5;
        d = GOLDEN_SECTION * e5;
        goto L48
    L46:
        e5 = a2 - x;
        goto L47
    L85:
        double x3 = u;
        if (isMinim == false) goto L88;
        double r5 = fx;
    L89:
        setFunctionValue(r5);
        return x3;
    L88:
        r5 = -fx;
        goto L89
    L9:
        a = hi;
        b = lo;
        goto L10
    L92:
        throw new NotStrictlyPositiveException(Double.valueOf(t));
    L94:
        throw new NotStrictlyPositiveException(Double.valueOf(eps));
    }
}
