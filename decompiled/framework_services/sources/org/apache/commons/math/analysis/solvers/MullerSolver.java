package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MullerSolver extends UnivariateRealSolverImpl {
    @Deprecated
    public MullerSolver(UnivariateRealFunction f) {
        super(f, 100, 1.0E-6d);
    }

    @Deprecated
    public MullerSolver() {
        super(100, 1.0E-6d);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max) throws ConvergenceException, FunctionEvaluationException {
        return solve(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max, double initial) throws ConvergenceException, FunctionEvaluationException {
        return solve(this.f, min, max, initial);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max, initial);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
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
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        double y0 = f.value(min);
        double x1 = f.value(max);
        double r14 = 0.5d;
        double x2 = (min + max) * 0.5d;
        double y1 = f.value(x2);
        if (y0 != 0.0d) goto L6;
        return min;
    L6:
        if (x1 != 0.0d) goto L8;
        return max;
    L8:
        double x3 = x2;
        verifyBracketing(min, max, f);
        int i = 1;
        double oldx = Double.POSITIVE_INFINITY;
        double x = min;
        double x4 = max;
        double x5 = y0;
    L10:
        if (i > this.maximalIterationCount) goto L60;
        double d01 = (y1 - x5) / (x3 - x);
        double d12 = (x1 - y1) / (x4 - x3);
        double d012 = (d12 - d01) / (x4 - x);
        double c1 = d01 + ((x3 - x) * d012);
        double delta = (c1 * c1) - ((4.0d * y1) * d012);
        double xplus = x3 + ((y1 * (-2.0d)) / (c1 + FastMath.sqrt(delta)));
        double xminus = x3 + (((-2.0d) * y1) / (c1 - FastMath.sqrt(delta)));
        double r36 = r14;
        if (isSequence(x, xplus, x4) == false) goto L14;
        double r32 = xplus;
    L15:
        double x6 = r32;
        double x0 = x;
        double y = f.value(x6);
        double r3 = this.relativeAccuracy * FastMath.abs(x6);
        double x7 = x4;
        double x8 = this.absoluteAccuracy;
        double tolerance = FastMath.max(r3, x8);
        if (FastMath.abs(x6 - oldx) <= tolerance) goto L17;
        double r5 = FastMath.abs(y);
        double tolerance2 = this.functionValueAccuracy;
        if (r5 <= tolerance2) goto L21;
        if (x6 >= x3) goto L28;
        if ((x3 - x0) <= ((x7 - x0) * 0.95d)) goto L28;
    L33:
        boolean bisect = true;
    L35:
        if (bisect == false) goto L37;
        double xm = (x0 + x7) * r36;
        double ym = f.value(xm);
        if ((MathUtils.sign(x5) + MathUtils.sign(ym)) != 0.0d) goto L56;
        x7 = xm;
        x1 = ym;
    L57:
        double x9 = (x0 + x7) * r36;
        double y2 = f.value(x9);
        x3 = x9;
        oldx = Double.POSITIVE_INFINITY;
        x = x0;
        x4 = x7;
    L58:
        y1 = y2;
        i = i + 1;
        r14 = r36;
        goto L10
    L56:
        x0 = xm;
        x5 = ym;
        goto L57
    L37:
        if (x6 >= x3) goto L39;
        double x10 = x0;
    L41:
        if (x6 >= x3) goto L43;
        double y3 = x5;
    L45:
        if (x6 <= x3) goto L47;
        double x11 = x7;
    L49:
        if (x6 <= x3) goto L51;
        double y4 = x1;
    L52:
        y2 = y;
        x = x10;
        oldx = x6;
        x4 = x11;
        x3 = x6;
        x5 = y3;
        x1 = y4;
        goto L58
    L51:
        y4 = y1;
        goto L52
    L47:
        x11 = x3;
        goto L49
    L43:
        y3 = y1;
        goto L45
    L39:
        x10 = x3;
    L28:
        if (x6 <= x3) goto L32;
        if ((x7 - x3) > ((x7 - x0) * 0.95d)) goto L33;
    L32:
        if (x6 == x3) goto L33;
        bisect = false;
        goto L35
    L21:
        setResult(x6, i);
        return this.result;
    L17:
        setResult(x6, i);
        return this.result;
    L14:
        r32 = xminus;
        goto L15
    L60:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }

    @Deprecated
    public double solve2(double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve2(this.f, min, max);
    }

    @Deprecated
    public double solve2(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        UnivariateRealFunction r5 = f;
        double x0 = min;
        double y0 = r5.value(x0);
        double x1 = max;
        double y1 = r5.value(x1);
        double x2 = (x0 + x1) * 0.5d;
        double y2 = r5.value(x2);
        if (y0 != 0.0d) goto L6;
        return min;
    L6:
        if (y1 != 0.0d) goto L8;
        return max;
    L8:
        verifyBracketing(min, max, r5);
        double oldx = Double.POSITIVE_INFINITY;
        int i = 1;
    L10:
        if (i > this.maximalIterationCount) goto L40;
        double q = (x2 - x1) / (x1 - x0);
        double a = ((y2 - ((q + 1.0d) * y1)) + (q * y0)) * q;
        double b = ((((q * 2.0d) + 1.0d) * y2) - (((q + 1.0d) * (q + 1.0d)) * y1)) + ((q * q) * y0);
        double c = (q + 1.0d) * y2;
        double delta = (b * b) - ((4.0d * a) * c);
        if (delta < 0.0d) goto L18;
        double dplus = b + FastMath.sqrt(delta);
        double dminus = b - FastMath.sqrt(delta);
        if (FastMath.abs(dplus) <= FastMath.abs(dminus)) goto L16;
        double denominator = dplus;
    L20:
        if (denominator == 0.0d) goto L29;
        double x = x2 - (((2.0d * c) * (x2 - x1)) / denominator);
    L23:
        if (x == x1) goto L28;
        if (x == x2) goto L28;
        double r40 = x;
        double x3 = oldx;
        oldx = r40;
    L30:
        double y = r5.value(oldx);
        double tolerance = FastMath.max(this.relativeAccuracy * FastMath.abs(oldx), this.absoluteAccuracy);
        if (FastMath.abs(oldx - x3) <= tolerance) goto L32;
        double r6 = FastMath.abs(y);
        double tolerance2 = this.functionValueAccuracy;
        if (r6 <= tolerance2) goto L36;
        x0 = x1;
        y0 = y1;
        x1 = x2;
        y1 = y2;
        x2 = oldx;
        y2 = y;
        i = i + 1;
        r5 = f;
        goto L10
    L36:
        setResult(oldx, i);
        return this.result;
    L32:
        setResult(oldx, i);
        return this.result;
    L28:
        double oldx2 = oldx;
        double oldx3 = this.absoluteAccuracy;
        x = x + oldx3;
        oldx = oldx2;
        goto L23
    L29:
        double oldx4 = FastMath.random();
        double x4 = min + (oldx4 * (max - min));
        x3 = Double.POSITIVE_INFINITY;
        oldx = x4;
        goto L30
    L16:
        denominator = dminus;
        goto L20
    L18:
        denominator = FastMath.sqrt((b * b) - delta);
        goto L20
    L40:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }
}
