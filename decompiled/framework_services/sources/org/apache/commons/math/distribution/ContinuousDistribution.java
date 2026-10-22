package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface ContinuousDistribution extends Distribution {
    double inverseCumulativeProbability(double r1) throws MathException;
}
