package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface IntegerDistribution extends DiscreteDistribution {
    double cumulativeProbability(int r1) throws MathException;

    double cumulativeProbability(int r1, int r2) throws MathException;

    int inverseCumulativeProbability(double r1) throws MathException;

    double probability(int r1);
}
