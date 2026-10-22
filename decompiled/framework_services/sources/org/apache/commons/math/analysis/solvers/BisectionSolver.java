package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BisectionSolver extends UnivariateRealSolverImpl {
    @Deprecated
    public BisectionSolver(UnivariateRealFunction f) {
        super(f, 100, 1.0E-6d);
    }

    public BisectionSolver() {
        super(100, 1.0E-6d);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(maxEval, f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        clearResult();
        double min2 = min;
        double max2 = max;
        verifyInterval(min2, max2);
        int i = 0;
    L4:
        if (i >= this.maximalIterationCount) goto L15;
        double m = UnivariateRealSolverUtils.midpoint(min2, max2);
        double fmin = f.value(min2);
        double fm = f.value(m);
        if ((fm * fmin) <= 0.0d) goto L8;
        min2 = m;
    L10:
        if (FastMath.abs(max2 - min2) <= this.absoluteAccuracy) goto L11;
        i = i + 1;
        goto L4
    L11:
        double m2 = UnivariateRealSolverUtils.midpoint(min2, max2);
        setResult(m2, i);
        return m2;
    L8:
        max2 = m;
        goto L10
    L15:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }
}
