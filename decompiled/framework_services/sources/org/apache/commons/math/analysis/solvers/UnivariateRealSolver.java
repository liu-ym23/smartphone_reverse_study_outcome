package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.ConvergingAlgorithm;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface UnivariateRealSolver extends ConvergingAlgorithm {
    double getFunctionValue();

    double getFunctionValueAccuracy();

    double getResult();

    void resetFunctionValueAccuracy();

    void setFunctionValueAccuracy(double r1);

    @Deprecated
    double solve(double r1, double r3) throws ConvergenceException, FunctionEvaluationException;

    @Deprecated
    double solve(double r1, double r3, double r5) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;

    @Deprecated
    double solve(UnivariateRealFunction r1, double r2, double r4) throws ConvergenceException, FunctionEvaluationException;

    @Deprecated
    double solve(UnivariateRealFunction r1, double r2, double r4, double r6) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;
}
