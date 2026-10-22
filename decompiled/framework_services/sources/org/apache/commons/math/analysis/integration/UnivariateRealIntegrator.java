package org.apache.commons.math.analysis.integration;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.ConvergingAlgorithm;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface UnivariateRealIntegrator extends ConvergingAlgorithm {
    int getMinimalIterationCount();

    double getResult() throws IllegalStateException;

    @Deprecated
    double integrate(double r1, double r3) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;

    double integrate(UnivariateRealFunction r1, double r2, double r4) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;

    void resetMinimalIterationCount();

    void setMinimalIterationCount(int r1);
}
