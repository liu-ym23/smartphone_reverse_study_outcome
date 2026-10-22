package org.apache.commons.math.analysis.interpolation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.BivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface BivariateRealGridInterpolator {
    BivariateRealFunction interpolate(double[] r1, double[] r2, double[][] r3) throws MathException;
}
