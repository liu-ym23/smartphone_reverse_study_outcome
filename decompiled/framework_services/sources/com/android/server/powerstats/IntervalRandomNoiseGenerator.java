package com.android.server.powerstats;

import java.util.Arrays;
import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.AbstractContinuousDistribution;
import org.apache.commons.math.distribution.BetaDistributionImpl;

/* JADX INFO: loaded from: classes3.dex */
public class IntervalRandomNoiseGenerator {
    private static final int DISTRIBUTION_SAMPLE_SIZE = 17;
    private static final double UNINITIALIZED = -1.0d;
    private final AbstractContinuousDistribution mDistribution;
    private final double[] mSamples;

    IntervalRandomNoiseGenerator(double alpha) {
        this.mSamples = new double[17];
        if (alpha <= 1.0d) goto L7;
        this.mDistribution = new BetaDistributionImpl(alpha, 1.0d);
        refresh();
        return;
    L7:
        throw new IllegalArgumentException("alpha should be > 1");
    }

    void reseed(long seed) {
        this.mDistribution.reseedRandomGenerator(seed);
    }

    long addNoise(long lowProbabilityBound, long highProbabilityBound, int stickyKey) {
        double sample = this.mSamples[stickyKey % 17];
        if (sample >= 0.0d) goto L10;
        sample = this.mDistribution.sample();     // Catch: MathException -> L6
        this.mSamples[stickyKey % 17] = sample;
    L6:
        e = move-exception;
        throw new IllegalStateException(e);
    L10:
        return ((long) ((highProbabilityBound - lowProbabilityBound) * sample)) + lowProbabilityBound;
    }

    void refresh() {
        Arrays.fill(this.mSamples, UNINITIALIZED);
    }
}
