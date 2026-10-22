package org.apache.commons.math.analysis;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public interface BivariateRealFunction {
    double value(double r1, double r3) throws FunctionEvaluationException;
}
