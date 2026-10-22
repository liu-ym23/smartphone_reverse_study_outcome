package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SecantSolver extends UnivariateRealSolverImpl {
    @Deprecated
    public SecantSolver(UnivariateRealFunction f) {
        super(f, 100, 1.0E-6d);
    }

    @Deprecated
    public SecantSolver() {
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
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        UnivariateRealFunction r1 = f;
        clearResult();
        verifyInterval(min, max);
        double x0 = min;
        double x1 = max;
        double y0 = r1.value(x0);
        double y1 = r1.value(x1);
        if ((y0 * y1) >= 0.0d) goto L39;
        double x2 = x0;
        double y2 = y0;
        double oldDelta = x2 - x1;
        int i = 0;
    L6:
        if (i >= this.maximalIterationCount) goto L37;
        if (FastMath.abs(y2) >= FastMath.abs(y1)) goto L11;
        x0 = x1;
        x1 = x2;
        x2 = x0;
        y0 = y1;
        y1 = y2;
        y2 = y0;
    L11:
        if (FastMath.abs(y1) <= this.functionValueAccuracy) goto L12;
        double x3 = x0;
        if (FastMath.abs(oldDelta) < FastMath.max(this.relativeAccuracy * FastMath.abs(x1), this.absoluteAccuracy)) goto L16;
        if (FastMath.abs(y1) <= FastMath.abs(y0)) goto L21;
        double delta = 0.5d * oldDelta;
    L25:
        x0 = x1;
        y0 = y1;
        x1 = x1 + delta;
        y1 = r1.value(x1);
        if (y1 <= 0.0d) goto L28;
        boolean r3 = true;
    L30:
        if (y2 <= 0.0d) goto L32;
        boolean r2 = true;
    L33:
        if (r3 != r2) goto L35;
        x2 = x0;
        y2 = y0;
    L35:
        oldDelta = x2 - x1;
        i = i + 1;
        r1 = f;
        goto L6
    L32:
        r2 = false;
        goto L33
    L28:
        r3 = false;
        goto L30
    L21:
        double delta2 = (x3 - x1) / (1.0d - (y0 / y1));
        if ((delta2 / oldDelta) <= 1.0d) goto L24;
        delta = 0.5d * oldDelta;
        goto L25
    L24:
        delta = delta2;
        goto L25
    L16:
        setResult(x1, i);
        return this.result;
    L12:
        setResult(x1, i);
        return this.result;
    L37:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    L39:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, new Object[]{Double.valueOf(min), Double.valueOf(max), Double.valueOf(y0), Double.valueOf(y1)});
    }
}
