package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface Distribution {
    double cumulativeProbability(double r1) throws MathException;

    double cumulativeProbability(double r1, double r3) throws MathException;
}
