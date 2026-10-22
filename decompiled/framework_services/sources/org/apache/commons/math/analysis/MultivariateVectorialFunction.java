package org.apache.commons.math.analysis;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public interface MultivariateVectorialFunction {
    double[] value(double[] r1) throws FunctionEvaluationException, IllegalArgumentException;
}
