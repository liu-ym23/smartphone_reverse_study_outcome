package org.apache.commons.math.optimization;

import java.util.Arrays;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.DifferentiableMultivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes3.dex */
public class MultiStartDifferentiableMultivariateRealOptimizer implements DifferentiableMultivariateRealOptimizer {
    private RandomVectorGenerator generator;
    private int maxEvaluations;
    private int maxIterations;
    private RealPointValuePair[] optima;
    private final DifferentiableMultivariateRealOptimizer optimizer;
    private int starts;
    private int totalEvaluations;
    private int totalGradientEvaluations;
    private int totalIterations;

    public MultiStartDifferentiableMultivariateRealOptimizer(DifferentiableMultivariateRealOptimizer optimizer, int starts, RandomVectorGenerator generator) {
        this.optimizer = optimizer;
        this.totalIterations = 0;
        this.totalEvaluations = 0;
        this.totalGradientEvaluations = 0;
        this.starts = starts;
        this.generator = generator;
        this.optima = null;
        setMaxIterations(Integer.MAX_VALUE);
        setMaxEvaluations(Integer.MAX_VALUE);
    }

    public RealPointValuePair[] getOptima() throws IllegalStateException {
        if (this.optima == null) goto L7;
        return (RealPointValuePair[]) this.optima.clone();
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public int getMaxIterations() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public int getIterations() {
        return this.totalIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public void setMaxEvaluations(int maxEvaluations) {
        this.maxEvaluations = maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public int getGradientEvaluations() {
        return this.totalGradientEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public void setConvergenceChecker(RealConvergenceChecker checker) {
        this.optimizer.setConvergenceChecker(checker);
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public RealConvergenceChecker getConvergenceChecker() {
        return this.optimizer.getConvergenceChecker();
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
    public RealPointValuePair optimize(DifferentiableMultivariateRealFunction f, final GoalType goalType, double[] startPoint) throws FunctionEvaluationException, OptimizationException, FunctionEvaluationException {
        this.optima = new RealPointValuePair[this.starts];
        this.totalIterations = 0;
        this.totalEvaluations = 0;
        this.totalGradientEvaluations = 0;
        int i = 0;
    L4:
        if (i >= this.starts) goto L19;
        this.optimizer.setMaxIterations(this.maxIterations - this.totalIterations);     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        this.optimizer.setMaxEvaluations(this.maxEvaluations - this.totalEvaluations);     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        RealPointValuePair[] r3 = this.optima;     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        DifferentiableMultivariateRealOptimizer r4 = this.optimizer;     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        if (i != 0) goto L9;
        double[] r5 = startPoint;
    L10:
        r3[i] = r4.optimize(f, goalType, r5);     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
    L18:
        this.totalIterations += this.optimizer.getIterations();
        this.totalEvaluations += this.optimizer.getEvaluations();
        this.totalGradientEvaluations += this.optimizer.getGradientEvaluations();
        i = i + 1;
        goto L4
    L9:
        r5 = this.generator.nextVector();     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        goto L10
    L17:
        this.optima[i] = null;
    L16:
        this.optima[i] = null;
        goto L18
    L19:
        Arrays.sort(this.optima, new AnonymousClass1(this, goalType));
        if (this.optima[0] == null) goto L24;
        return this.optima[0];
    L24:
        throw new OptimizationException(LocalizedFormats.NO_CONVERGENCE_WITH_ANY_START_POINT, new Object[]{Integer.valueOf(this.starts)});
    }
}
