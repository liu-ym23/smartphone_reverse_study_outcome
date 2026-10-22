package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class NewtonSolver extends UnivariateRealSolverImpl {
    @Deprecated
    public NewtonSolver(DifferentiableUnivariateRealFunction f) {
        super(f, 100, 1.0E-6d);
    }

    @Deprecated
    public NewtonSolver() {
        super(100, 1.0E-6d);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max, double startValue) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(this.f, min, max, startValue);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(f, min, max, UnivariateRealSolverUtils.midpoint(min, max));
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max, double startValue) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max, startValue);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max, double startValue) throws MaxIterationsExceededException, FunctionEvaluationException {
        UnivariateRealFunction derivative = ((DifferentiableUnivariateRealFunction) f).derivative();     // Catch: ClassCastException -> L9
        clearResult();     // Catch: ClassCastException -> L9
        verifySequence(min, startValue, max);     // Catch: ClassCastException -> L9
        double x0 = startValue;
        int i = 0;
    L4:
        if (i >= this.maximalIterationCount) goto L13;
        double x1 = x0 - (f.value(x0) / derivative.value(x0));     // Catch: ClassCastException -> L9
        if (FastMath.abs(x1 - x0) <= this.absoluteAccuracy) goto L7;
        x0 = x1;
        i = i + 1;     // Catch: ClassCastException -> L9
        goto L4
    L7:
        setResult(x1, i);     // Catch: ClassCastException -> L9
        return x1;
    L13:
        throw new MaxIterationsExceededException(this.maximalIterationCount);     // Catch: ClassCastException -> L9
    L15:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FUNCTION_NOT_DIFFERENTIABLE, new Object[0]);
    }
}
