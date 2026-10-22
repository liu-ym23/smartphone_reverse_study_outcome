package org.apache.commons.math.transform;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface RealTransformer {
    double[] inversetransform(UnivariateRealFunction r1, double r2, double r4, int r6) throws FunctionEvaluationException, IllegalArgumentException;

    double[] inversetransform(double[] r1) throws IllegalArgumentException;

    double[] transform(UnivariateRealFunction r1, double r2, double r4, int r6) throws FunctionEvaluationException, IllegalArgumentException;

    double[] transform(double[] r1) throws IllegalArgumentException;
}
