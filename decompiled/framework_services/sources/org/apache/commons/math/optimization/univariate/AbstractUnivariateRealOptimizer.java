package org.apache.commons.math.optimization.univariate;

import org.apache.commons.math.ConvergingAlgorithmImpl;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxEvaluationsExceededException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.MathUnsupportedOperationException;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.UnivariateRealOptimizer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractUnivariateRealOptimizer extends ConvergingAlgorithmImpl implements UnivariateRealOptimizer {
    private int evaluations;
    private UnivariateRealFunction function;
    protected double functionValue;
    private int maxEvaluations;
    private GoalType optimizationGoal;
    protected double result;
    protected boolean resultComputed;
    private double searchMax;
    private double searchMin;
    private double searchStart;

    @Deprecated
    protected AbstractUnivariateRealOptimizer(int defaultMaximalIterationCount, double defaultAbsoluteAccuracy) {
        super(defaultMaximalIterationCount, defaultAbsoluteAccuracy);
        this.resultComputed = false;
        setMaxEvaluations(Integer.MAX_VALUE);
    }

    protected AbstractUnivariateRealOptimizer() {
    }

    @Deprecated
    protected void checkResultComputed() {
        if (this.resultComputed == false) goto L6;
        return;
    L6:
        throw new NoDataException();
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double getResult() {
        if (this.resultComputed == false) goto L7;
        return this.result;
    L7:
        throw new NoDataException();
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double getFunctionValue() throws FunctionEvaluationException {
        if (Double.isNaN(this.functionValue) == false) goto L5;
        double opt = getResult();
        this.functionValue = this.function.value(opt);
    L5:
        double opt2 = this.functionValue;
        return opt2;
    }

    @Deprecated
    protected final void setResult(double x, double fx, int iterationCount) {
        this.result = x;
        this.functionValue = fx;
        this.iterationCount = iterationCount;
        this.resultComputed = true;
    }

    @Deprecated
    protected final void clearResult() {
        this.resultComputed = false;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public void setMaxEvaluations(int maxEvaluations) {
        this.maxEvaluations = maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public int getEvaluations() {
        return this.evaluations;
    }

    public GoalType getGoalType() {
        return this.optimizationGoal;
    }

    public double getMin() {
        return this.searchMin;
    }

    public double getMax() {
        return this.searchMax;
    }

    public double getStartValue() {
        return this.searchStart;
    }

    @Deprecated
    protected double computeObjectiveValue(UnivariateRealFunction f, double point) throws FunctionEvaluationException {
        int r0 = this.evaluations + 1;
        this.evaluations = r0;
        if (r0 > this.maxEvaluations) goto L7;
        return f.value(point);
    L7:
        throw new FunctionEvaluationException(new MaxEvaluationsExceededException(this.maxEvaluations), point);
    }

    protected double computeObjectiveValue(double point) throws FunctionEvaluationException {
        int r0 = this.evaluations + 1;
        this.evaluations = r0;
        if (r0 <= this.maxEvaluations) goto L5;
        this.resultComputed = false;
        throw new FunctionEvaluationException(new MaxEvaluationsExceededException(this.maxEvaluations), point);
    L5:
        return this.function.value(point);
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double optimize(UnivariateRealFunction f, GoalType goal, double min, double max, double startValue) throws MaxIterationsExceededException, FunctionEvaluationException {
        this.searchMin = min;
        this.searchMax = max;
        this.searchStart = startValue;
        this.optimizationGoal = goal;
        this.function = f;
        this.functionValue = Double.NaN;
        this.evaluations = 0;
        resetIterationsCounter();
        this.result = doOptimize();
        this.resultComputed = true;
        return this.result;
    }

    protected void setFunctionValue(double functionValue) {
        this.functionValue = functionValue;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double optimize(UnivariateRealFunction f, GoalType goal, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        return optimize(f, goal, min, max, min + ((max - min) * 0.5d));
    }

    protected double doOptimize() throws MaxIterationsExceededException, FunctionEvaluationException {
        throw new MathUnsupportedOperationException(LocalizedFormats.NOT_OVERRIDEN, new Object[0]);
    }
}
