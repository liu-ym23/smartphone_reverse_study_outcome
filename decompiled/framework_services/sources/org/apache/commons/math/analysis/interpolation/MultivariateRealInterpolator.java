package org.apache.commons.math.analysis.interpolation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.MultivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface MultivariateRealInterpolator {
    MultivariateRealFunction interpolate(double[][] r1, double[] r2) throws MathException, IllegalArgumentException;
}
