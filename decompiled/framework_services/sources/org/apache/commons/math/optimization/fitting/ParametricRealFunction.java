package org.apache.commons.math.optimization.fitting;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public interface ParametricRealFunction {
    double[] gradient(double r1, double[] r3) throws FunctionEvaluationException;

    double value(double r1, double[] r3) throws FunctionEvaluationException;
}
