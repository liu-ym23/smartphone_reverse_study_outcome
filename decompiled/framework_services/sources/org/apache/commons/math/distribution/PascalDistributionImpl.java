package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Beta;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class PascalDistributionImpl extends AbstractIntegerDistribution implements PascalDistribution, Serializable {
    private static final long serialVersionUID = 6751309484392813623L;
    private int numberOfSuccesses;
    private double probabilityOfSuccess;

    public PascalDistributionImpl(int r, double p) {
        setNumberOfSuccessesInternal(r);
        setProbabilityOfSuccessInternal(p);
    }

    @Override // org.apache.commons.math.distribution.PascalDistribution
    public int getNumberOfSuccesses() {
        return this.numberOfSuccesses;
    }

    @Override // org.apache.commons.math.distribution.PascalDistribution
    public double getProbabilityOfSuccess() {
        return this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math.distribution.PascalDistribution
    @Deprecated
    public void setNumberOfSuccesses(int successes) {
        setNumberOfSuccessesInternal(successes);
    }

    private void setNumberOfSuccessesInternal(int successes) {
        if (successes < 0) goto L6;
        this.numberOfSuccesses = successes;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_NUMBER_OF_SUCCESSES, new Object[]{Integer.valueOf(successes)});
    }

    @Override // org.apache.commons.math.distribution.PascalDistribution
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
        return 2147483646;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public double cumulativeProbability(int x) throws MathException {
        if (x >= 0) goto L4;
        return 0.0d;
    L4:
        double ret = Beta.regularizedBeta(this.probabilityOfSuccess, this.numberOfSuccesses, x + 1);
        return ret;
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public double probability(int x) {
        if (x >= 0) goto L4;
        return 0.0d;
    L4:
        double ret = (MathUtils.binomialCoefficientDouble((this.numberOfSuccesses + x) - 1, this.numberOfSuccesses - 1) * FastMath.pow(this.probabilityOfSuccess, this.numberOfSuccesses)) * FastMath.pow(1.0d - this.probabilityOfSuccess, x);
        return ret;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public int inverseCumulativeProbability(double p) throws MathException {
        if (p != 0.0d) goto L6;
        return -1;
    L6:
        if (p != 1.0d) goto L8;
        return Integer.MAX_VALUE;
    L8:
        int ret = super.inverseCumulativeProbability(p);
        return ret;
    }

    public int getSupportLowerBound() {
        return 0;
    }

    public int getSupportUpperBound() {
        return Integer.MAX_VALUE;
    }

    public double getNumericalMean() {
        double p = getProbabilityOfSuccess();
        double r = getNumberOfSuccesses();
        return (r * p) / (1.0d - p);
    }

    public double getNumericalVariance() {
        double p = getProbabilityOfSuccess();
        double r = getNumberOfSuccesses();
        double pInv = 1.0d - p;
        return (r * p) / (pInv * pInv);
    }
}
