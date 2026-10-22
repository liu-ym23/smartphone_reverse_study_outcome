package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.random.RandomDataImpl;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractContinuousDistribution extends AbstractDistribution implements ContinuousDistribution, Serializable {
    private static final long serialVersionUID = -38038050983108802L;
    protected final RandomDataImpl randomData;
    private double solverAbsoluteAccuracy;

    protected abstract double getDomainLowerBound(double r1);

    protected abstract double getDomainUpperBound(double r1);

    protected abstract double getInitialDomain(double r1);

    protected AbstractContinuousDistribution() {
        this.randomData = new RandomDataImpl();
        this.solverAbsoluteAccuracy = 1.0E-6d;
    }

    public double density(double x) throws MathRuntimeException {
        throw new MathRuntimeException(new UnsupportedOperationException(), LocalizedFormats.NO_DENSITY_FOR_THIS_DISTRIBUTION, new Object[0]);
    }

    @Override // org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(final double p) throws MathException {
        if (p < 0.0d) goto L20;
        if (p > 1.0d) goto L20;
        UnivariateRealFunction rootFindingFunction = new AnonymousClass1(this, p);
        double lowerBound = getDomainLowerBound(p);
        double upperBound = getDomainUpperBound(p);
        double[] bracket = UnivariateRealSolverUtils.bracket(rootFindingFunction, getInitialDomain(p), lowerBound, upperBound);     // Catch: ConvergenceException -> L10
        double root = UnivariateRealSolverUtils.solve(rootFindingFunction, bracket[0], bracket[1], getSolverAbsoluteAccuracy());
        return root;
    L10:
        ex = move-exception;
        if (FastMath.abs(rootFindingFunction.value(lowerBound)) >= getSolverAbsoluteAccuracy()) goto L15;
        return lowerBound;
    L15:
        if (FastMath.abs(rootFindingFunction.value(upperBound)) >= getSolverAbsoluteAccuracy()) goto L18;
        return upperBound;
    L18:
        throw new MathException(ex);
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(p), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    public void reseedRandomGenerator(long seed) {
        this.randomData.reSeed(seed);
    }

    public double sample() throws MathException {
        return this.randomData.nextInversionDeviate(this);
    }

    public double[] sample(int sampleSize) throws MathException {
        if (sampleSize > 0) goto L4;
        MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_SAMPLE_SIZE, new Object[]{Integer.valueOf(sampleSize)});
    L4:
        double[] out = new double[sampleSize];
        int i = 0;
    L5:
        if (i >= sampleSize) goto L8;
        out[i] = sample();
        i = i + 1;
        goto L5
    L8:
        return out;
    }

    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }
}
