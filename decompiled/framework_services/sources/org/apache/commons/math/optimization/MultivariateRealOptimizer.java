package org.apache.commons.math.optimization;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.MultivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface MultivariateRealOptimizer {
    RealConvergenceChecker getConvergenceChecker();

    int getEvaluations();

    int getIterations();

    int getMaxEvaluations();

    int getMaxIterations();

    RealPointValuePair optimize(MultivariateRealFunction r1, GoalType r2, double[] r3) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;

    void setConvergenceChecker(RealConvergenceChecker r1);

    void setMaxEvaluations(int r1);

    void setMaxIterations(int r1);
}
