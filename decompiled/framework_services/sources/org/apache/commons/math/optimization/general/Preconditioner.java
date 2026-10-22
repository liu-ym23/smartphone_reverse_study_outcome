package org.apache.commons.math.optimization.general;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public interface Preconditioner {
    double[] precondition(double[] r1, double[] r2) throws FunctionEvaluationException, IllegalArgumentException;
}
