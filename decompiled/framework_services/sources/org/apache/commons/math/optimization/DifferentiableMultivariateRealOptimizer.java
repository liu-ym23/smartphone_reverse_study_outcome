package org.apache.commons.math.optimization;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.DifferentiableMultivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface DifferentiableMultivariateRealOptimizer {
    RealConvergenceChecker getConvergenceChecker();

    int getEvaluations();

    int getGradientEvaluations();

    int getIterations();

    int getMaxEvaluations();

    int getMaxIterations();

    RealPointValuePair optimize(DifferentiableMultivariateRealFunction r1, GoalType r2, double[] r3) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;

    void setConvergenceChecker(RealConvergenceChecker r1);

    void setMaxEvaluations(int r1);

    void setMaxIterations(int r1);
}
