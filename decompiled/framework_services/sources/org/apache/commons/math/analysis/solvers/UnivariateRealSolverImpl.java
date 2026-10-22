package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.ConvergingAlgorithmImpl;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class UnivariateRealSolverImpl extends ConvergingAlgorithmImpl implements UnivariateRealSolver {
    protected double defaultFunctionValueAccuracy;

    @Deprecated
    protected UnivariateRealFunction f;
    protected double functionValue;
    protected double functionValueAccuracy;
    protected double result;
    protected boolean resultComputed;

    @Deprecated
    protected UnivariateRealSolverImpl(UnivariateRealFunction f, int defaultMaximalIterationCount, double defaultAbsoluteAccuracy) {
        super(defaultMaximalIterationCount, defaultAbsoluteAccuracy);
        this.resultComputed = false;
        if (f == null) goto L7;
        this.f = f;
        this.defaultFunctionValueAccuracy = 1.0E-15d;
        this.functionValueAccuracy = this.defaultFunctionValueAccuracy;
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.FUNCTION);
    }

    protected UnivariateRealSolverImpl(int defaultMaximalIterationCount, double defaultAbsoluteAccuracy) {
        super(defaultMaximalIterationCount, defaultAbsoluteAccuracy);
        this.resultComputed = false;
        this.defaultFunctionValueAccuracy = 1.0E-15d;
        this.functionValueAccuracy = this.defaultFunctionValueAccuracy;
    }

    protected void checkResultComputed() throws IllegalStateException {
        if (this.resultComputed == false) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.NO_RESULT_AVAILABLE, new Object[0]);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    public double getResult() {
        checkResultComputed();
        return this.result;
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    public double getFunctionValue() {
        checkResultComputed();
        return this.functionValue;
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    public void setFunctionValueAccuracy(double accuracy) {
        this.functionValueAccuracy = accuracy;
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    public double getFunctionValueAccuracy() {
        return this.functionValueAccuracy;
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    public void resetFunctionValueAccuracy() {
        this.functionValueAccuracy = this.defaultFunctionValueAccuracy;
    }

    public double solve(int maxEval, UnivariateRealFunction function, double min, double max) throws ConvergenceException, FunctionEvaluationException {
        throw MathRuntimeException.createUnsupportedOperationException(LocalizedFormats.NOT_OVERRIDEN, new Object[0]);
    }

    public double solve(int maxEval, UnivariateRealFunction function, double min, double max, double startValue) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException {
        throw MathRuntimeException.createUnsupportedOperationException(LocalizedFormats.NOT_OVERRIDEN, new Object[0]);
    }

    protected final void setResult(double newResult, int iterationCount) {
        this.result = newResult;
        this.iterationCount = iterationCount;
        this.resultComputed = true;
    }

    protected final void setResult(double x, double fx, int iterationCount) {
        this.result = x;
        this.functionValue = fx;
        this.iterationCount = iterationCount;
        this.resultComputed = true;
    }

    protected final void clearResult() {
        this.iterationCount = 0;
        this.resultComputed = false;
    }

    protected boolean isBracketing(double lower, double upper, UnivariateRealFunction function) throws FunctionEvaluationException {
        double f1 = function.value(lower);
        double f2 = function.value(upper);
        if (f1 <= 0.0d) goto L7;
        if (f2 >= 0.0d) goto L7;
    L10:
        return true;
    L7:
        if (f1 < 0.0d) goto L9;
    L11:
        return false;
    L9:
        if (f2 <= 0.0d) goto L11;
        goto L10
    }

    protected boolean isSequence(double start, double mid, double end) {
        if (start < mid) goto L5;
    L7:
        return false;
    L5:
        if (mid >= end) goto L7;
        return true;
    }

    protected void verifyInterval(double lower, double upper) {
        if (lower >= upper) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, new Object[]{Double.valueOf(lower), Double.valueOf(upper)});
    }

    protected void verifySequence(double lower, double initial, double upper) {
        if (isSequence(lower, initial, upper) == false) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_INTERVAL_INITIAL_VALUE_PARAMETERS, new Object[]{Double.valueOf(lower), Double.valueOf(initial), Double.valueOf(upper)});
    }

    protected void verifyBracketing(double lower, double upper, UnivariateRealFunction function) throws FunctionEvaluationException {
        verifyInterval(lower, upper);
        if (isBracketing(lower, upper, function) == false) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, new Object[]{Double.valueOf(lower), Double.valueOf(upper), Double.valueOf(function.value(lower)), Double.valueOf(function.value(upper))});
    }
}
