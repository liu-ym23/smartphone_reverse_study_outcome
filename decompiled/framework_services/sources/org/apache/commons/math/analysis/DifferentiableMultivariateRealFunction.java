package org.apache.commons.math.analysis;

/* JADX INFO: loaded from: classes3.dex */
public interface DifferentiableMultivariateRealFunction extends MultivariateRealFunction {
    MultivariateVectorialFunction gradient();

    MultivariateRealFunction partialDerivative(int r1);
}
