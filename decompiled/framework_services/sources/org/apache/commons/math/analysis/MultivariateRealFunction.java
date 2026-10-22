package org.apache.commons.math.analysis;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public interface MultivariateRealFunction {
    double value(double[] r1) throws FunctionEvaluationException, IllegalArgumentException;
}
