package org.apache.commons.math.optimization;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.ConvergingAlgorithm;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface UnivariateRealOptimizer extends ConvergingAlgorithm {
    int getEvaluations();

    double getFunctionValue() throws FunctionEvaluationException;

    int getMaxEvaluations();

    double getResult();

    double optimize(UnivariateRealFunction r1, GoalType r2, double r3, double r5) throws ConvergenceException, FunctionEvaluationException;

    double optimize(UnivariateRealFunction r1, GoalType r2, double r3, double r5, double r7) throws ConvergenceException, FunctionEvaluationException;

    void setMaxEvaluations(int r1);
}
