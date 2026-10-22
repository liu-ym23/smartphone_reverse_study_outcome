package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Beta;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BinomialDistributionImpl extends AbstractIntegerDistribution implements BinomialDistribution, Serializable {
    private static final long serialVersionUID = 6751309484392813623L;
    private int numberOfTrials;
    private double probabilityOfSuccess;

    public BinomialDistributionImpl(int trials, double p) {
        setNumberOfTrialsInternal(trials);
        setProbabilityOfSuccessInternal(p);
    }

    @Override // org.apache.commons.math.distribution.BinomialDistribution
    public int getNumberOfTrials() {
        return this.numberOfTrials;
    }

    @Override // org.apache.commons.math.distribution.BinomialDistribution
    public double getProbabilityOfSuccess() {
        return this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math.distribution.BinomialDistribution
    @Deprecated
    public void setNumberOfTrials(int trials) {
        setNumberOfTrialsInternal(trials);
    }

    private void setNumberOfTrialsInternal(int trials) {
        if (trials < 0) goto L6;
        this.numberOfTrials = trials;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_NUMBER_OF_TRIALS, new Object[]{Integer.valueOf(trials)});
    }

    @Override // org.apache.commons.math.distribution.BinomialDistribution
    @Deprecated
    public void setProbabilityOfSuccess(double p) {
        setProbabilityOfSuccessInternal(p);
    }

    private void setProbabilityOfSuccessInternal(double p) {
        if (p < 0.0d) goto L9;
        if (p > 1.0d) goto L9;
        this.probabilityOfSuccess = p;
        return;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(p), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainLowerBound(double p) {
        return -1;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainUpperBound(double p) {
        return this.numberOfTrials;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public double cumulativeProbability(int x) throws MathException {
        if (x >= 0) goto L5;
        return 0.0d;
    L5:
        if (x < this.numberOfTrials) goto L7;
        return 1.0d;
    L7:
        double ret = 1.0d - Beta.regularizedBeta(getProbabilityOfSuccess(), ((double) x) + 1.0d, this.numberOfTrials - x);
        return ret;
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public double probability(int x) {
        if (x < 0) goto L8;
        if (x > this.numberOfTrials) goto L8;
        double ret = FastMath.exp(SaddlePointExpansion.logBinomialProbability(x, this.numberOfTrials, this.probabilityOfSuccess, 1.0d - this.probabilityOfSuccess));
        return ret;
    L8:
        return 0.0d;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public int inverseCumulativeProbability(double p) throws MathException {
        if (p != 0.0d) goto L7;
        return -1;
    L7:
        if (p != 1.0d) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return super.inverseCumulativeProbability(p);
    }

    public int getSupportLowerBound() {
        return 0;
    }

    public int getSupportUpperBound() {
        return getNumberOfTrials();
    }

    public double getNumericalMean() {
        return ((double) getNumberOfTrials()) * getProbabilityOfSuccess();
    }

    public double getNumericalVariance() {
        double p = getProbabilityOfSuccess();
        return (((double) getNumberOfTrials()) * p) * (1.0d - p);
    }
}
