package org.apache.commons.math.analysis.interpolation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.TrivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface TrivariateRealGridInterpolator {
    TrivariateRealFunction interpolate(double[] r1, double[] r2, double[] r3, double[][][] r4) throws MathException;
}
