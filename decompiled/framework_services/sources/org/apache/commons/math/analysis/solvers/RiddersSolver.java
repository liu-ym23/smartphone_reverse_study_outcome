package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RiddersSolver extends UnivariateRealSolverImpl {
    @Deprecated
    public RiddersSolver(UnivariateRealFunction f) {
        super(f, 100, 1.0E-6d);
    }

    @Deprecated
    public RiddersSolver() {
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
        UnivariateRealFunction r5 = f;
        double x2 = min;
        double y1 = r5.value(x2);
        double x3 = max;
        double y2 = r5.value(x3);
        double r14 = 0.0d;
        if (y1 != 0.0d) goto L6;
        return min;
    L6:
        if (y2 != 0.0d) goto L8;
        return max;
    L8:
        verifyBracketing(min, max, r5);
        int i = 1;
        double correction = Double.POSITIVE_INFINITY;
    L10:
        if (i > this.maximalIterationCount) goto L35;
        double r20 = r14;
        double x4 = (x2 + x3) * 0.5d;
        double y3 = r5.value(x4);
        double r18 = FastMath.abs(y3);
        double oldx = correction;
        double oldx2 = this.functionValueAccuracy;
        if (r18 <= oldx2) goto L13;
        double delta = 1.0d - ((y1 * y2) / (y3 * y3));
        double correction2 = ((MathUtils.sign(y2) * MathUtils.sign(y3)) * (x4 - x2)) / FastMath.sqrt(delta);
        correction = x4 - correction2;
        double y = r5.value(correction);
        double r4 = this.relativeAccuracy * FastMath.abs(correction);
        double x1 = x2;
        double x5 = this.absoluteAccuracy;
        double tolerance = FastMath.max(r4, x5);
        if (FastMath.abs(correction - oldx) <= tolerance) goto L17;
        double r6 = FastMath.abs(y);
        double tolerance2 = this.functionValueAccuracy;
        if (r6 <= tolerance2) goto L21;
        if (correction2 > r20) goto L26;
        double x6 = MathUtils.sign(y2);
        if ((x6 + MathUtils.sign(y)) != r20) goto L32;
        y1 = y;
        x2 = correction;
    L33:
        i = i + 1;
        r14 = r20;
        r5 = f;
        goto L10
    L32:
        y1 = y3;
        y2 = y;
        x3 = correction;
        x2 = x4;
        goto L33
    L26:
        if ((MathUtils.sign(y1) + MathUtils.sign(y)) != r20) goto L28;
        x3 = correction;
        y2 = y;
        x2 = x1;
        goto L33
    L28:
        y1 = y;
        y2 = y3;
        x3 = x4;
        x2 = correction;
        goto L33
    L21:
        setResult(correction, i);
        return this.result;
    L17:
        setResult(correction, i);
        return this.result;
    L13:
        setResult(x4, i);
        return this.result;
    L35:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }
}
