package org.apache.commons.math.analysis;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public interface TrivariateRealFunction {
    double value(double r1, double r3, double r5) throws FunctionEvaluationException;
}
