package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.random.RandomDataImpl;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractIntegerDistribution extends AbstractDistribution implements IntegerDistribution, Serializable {
    private static final long serialVersionUID = -1146319659338487221L;
    protected final RandomDataImpl randomData;

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public abstract double cumulativeProbability(int r1) throws MathException;

    protected abstract int getDomainLowerBound(double r1);

    protected abstract int getDomainUpperBound(double r1);

    protected AbstractIntegerDistribution() {
        this.randomData = new RandomDataImpl();
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        return cumulativeProbability((int) FastMath.floor(x));
    }

    @Override // org.apache.commons.math.distribution.AbstractDistribution, org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x0, double x1) throws MathException {
        if (x0 > x1) goto L11;
        if (FastMath.floor(x0) >= x0) goto L9;
        return cumulativeProbability(((int) FastMath.floor(x0)) + 1, (int) FastMath.floor(x1));
    L9:
        return cumulativeProbability((int) FastMath.floor(x0), (int) FastMath.floor(x1));
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, new Object[]{Double.valueOf(x0), Double.valueOf(x1)});
    }

    @Override // org.apache.commons.math.distribution.DiscreteDistribution
    public double probability(double x) {
        double fl = FastMath.floor(x);
        if (fl == x) goto L5;
        return 0.0d;
    L5:
        return probability((int) x);
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public double cumulativeProbability(int x0, int x1) throws MathException {
        if (x0 > x1) goto L6;
        return cumulativeProbability(x1) - cumulativeProbability(x0 - 1);
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, new Object[]{Integer.valueOf(x0), Integer.valueOf(x1)});
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public int inverseCumulativeProbability(double p) throws MathException {
        if (p < 0.0d) goto L23;
        if (p > 1.0d) goto L23;
        int x0 = getDomainLowerBound(p);
        int x1 = getDomainUpperBound(p);
    L7:
        if (x0 >= x1) goto L17;
        int xm = ((x1 - x0) / 2) + x0;
        double pm = checkedCumulativeProbability(xm);
        if (pm > p) goto L10;
        if (xm == x0) goto L14;
        x0 = xm;
        goto L7
    L14:
        x0 = x0 + 1;
        goto L7
    L10:
        if (xm == x1) goto L11;
        x1 = xm;
        goto L7
    L11:
        x1 = x1 - 1;
        goto L7
    L17:
        double pm2 = checkedCumulativeProbability(x0);
    L19:
        if (pm2 <= p) goto L21;
        x0 = x0 - 1;
        pm2 = checkedCumulativeProbability(x0);
        goto L19
    L21:
        return x0;
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(p), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    public void reseedRandomGenerator(long seed) {
        this.randomData.reSeed(seed);
    }

    public int sample() throws MathException {
        return this.randomData.nextInversionDeviate(this);
    }

    public int[] sample(int sampleSize) throws MathException {
        if (sampleSize > 0) goto L4;
        MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_SAMPLE_SIZE, new Object[]{Integer.valueOf(sampleSize)});
    L4:
        int[] out = new int[sampleSize];
        int i = 0;
    L5:
        if (i >= sampleSize) goto L8;
        out[i] = sample();
        i = i + 1;
        goto L5
    L8:
        return out;
    }

    private double checkedCumulativeProbability(int argument) throws MathException {
        double result = cumulativeProbability(argument);
        if (Double.isNaN(result) == true) goto L6;
        return result;
    L6:
        throw new MathException(LocalizedFormats.DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN, new Object[]{Integer.valueOf(argument)});
    }

    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    public boolean isSupportUpperBoundInclusive() {
        return true;
    }
}
