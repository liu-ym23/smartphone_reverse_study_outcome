package org.apache.commons.math.optimization;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface DifferentiableMultivariateVectorialOptimizer {
    VectorialConvergenceChecker getConvergenceChecker();

    int getEvaluations();

    int getIterations();

    int getJacobianEvaluations();

    int getMaxEvaluations();

    int getMaxIterations();

    VectorialPointValuePair optimize(DifferentiableMultivariateVectorialFunction r1, double[] r2, double[] r3, double[] r4) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;

    void setConvergenceChecker(VectorialConvergenceChecker r1);

    void setMaxEvaluations(int r1);

    void setMaxIterations(int r1);
}
