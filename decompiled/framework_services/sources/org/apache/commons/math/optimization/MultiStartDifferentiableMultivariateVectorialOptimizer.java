package org.apache.commons.math.optimization;

import java.util.Arrays;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes3.dex */
public class MultiStartDifferentiableMultivariateVectorialOptimizer implements DifferentiableMultivariateVectorialOptimizer {
    private static final long serialVersionUID = 9206382258980561530L;
    private RandomVectorGenerator generator;
    private int maxEvaluations;
    private int maxIterations;
    private VectorialPointValuePair[] optima;
    private final DifferentiableMultivariateVectorialOptimizer optimizer;
    private int starts;
    private int totalEvaluations;
    private int totalIterations;
    private int totalJacobianEvaluations;

    public MultiStartDifferentiableMultivariateVectorialOptimizer(DifferentiableMultivariateVectorialOptimizer optimizer, int starts, RandomVectorGenerator generator) {
        this.optimizer = optimizer;
        this.totalIterations = 0;
        this.totalEvaluations = 0;
        this.totalJacobianEvaluations = 0;
        this.starts = starts;
        this.generator = generator;
        this.optima = null;
        setMaxIterations(Integer.MAX_VALUE);
        setMaxEvaluations(Integer.MAX_VALUE);
    }

    public VectorialPointValuePair[] getOptima() throws IllegalStateException {
        if (this.optima == null) goto L7;
        return (VectorialPointValuePair[]) this.optima.clone();
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getMaxIterations() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getIterations() {
        return this.totalIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public void setMaxEvaluations(int maxEvaluations) {
        this.maxEvaluations = maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getJacobianEvaluations() {
        return this.totalJacobianEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public void setConvergenceChecker(VectorialConvergenceChecker checker) {
        this.optimizer.setConvergenceChecker(checker);
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public VectorialConvergenceChecker getConvergenceChecker() {
        return this.optimizer.getConvergenceChecker();
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public VectorialPointValuePair optimize(DifferentiableMultivariateVectorialFunction f, final double[] target, final double[] weights, double[] startPoint) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        this.optima = new VectorialPointValuePair[this.starts];
        this.totalIterations = 0;
        this.totalEvaluations = 0;
        this.totalJacobianEvaluations = 0;
        int i = 0;
    L4:
        if (i >= this.starts) goto L19;
        this.optimizer.setMaxIterations(this.maxIterations - this.totalIterations);     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        this.optimizer.setMaxEvaluations(this.maxEvaluations - this.totalEvaluations);     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        VectorialPointValuePair[] r3 = this.optima;     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        DifferentiableMultivariateVectorialOptimizer r4 = this.optimizer;     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
        if (i != 0) goto L9;
        double[] r5 = startPoint;
    L10:
        r3[i] = r4.optimize(f, target, weights, r5);     // Catch: OptimizationException -> L12 FunctionEvaluationException -> L14
    L18:
        this.totalIterations += this.optimizer.getIterations();
        this.totalEvaluations += this.optimizer.getEvaluations();
        this.totalJacobianEvaluations += this.optimizer.getJacobianEvaluations();
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
        Arrays.sort(this.optima, new AnonymousClass1(this, target, weights));
        if (this.optima[0] == null) goto L24;
        return this.optima[0];
    L24:
        throw new OptimizationException(LocalizedFormats.NO_CONVERGENCE_WITH_ANY_START_POINT, new Object[]{Integer.valueOf(this.starts)});
    }
}
