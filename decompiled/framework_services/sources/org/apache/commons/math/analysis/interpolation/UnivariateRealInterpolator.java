package org.apache.commons.math.analysis.interpolation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface UnivariateRealInterpolator {
    UnivariateRealFunction interpolate(double[] r1, double[] r2) throws MathException;
}
