package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class ZipfDistributionImpl extends AbstractIntegerDistribution implements ZipfDistribution, Serializable {
    private static final long serialVersionUID = -140627372283420404L;
    private double exponent;
    private int numberOfElements;

    public ZipfDistributionImpl(int numberOfElements, double exponent) throws IllegalArgumentException {
        setNumberOfElementsInternal(numberOfElements);
        setExponentInternal(exponent);
    }

    @Override // org.apache.commons.math.distribution.ZipfDistribution
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    @Override // org.apache.commons.math.distribution.ZipfDistribution
    @Deprecated
    public void setNumberOfElements(int n) {
        setNumberOfElementsInternal(n);
    }

    private void setNumberOfElementsInternal(int n) throws IllegalArgumentException {
        if (n <= 0) goto L6;
        this.numberOfElements = n;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(n), 0});
    }

    @Override // org.apache.commons.math.distribution.ZipfDistribution
    public double getExponent() {
        return this.exponent;
    }

    @Override // org.apache.commons.math.distribution.ZipfDistribution
    @Deprecated
    public void setExponent(double s) {
        setExponentInternal(s);
    }

    private void setExponentInternal(double s) throws IllegalArgumentException {
        if (s <= 0.0d) goto L7;
        this.exponent = s;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_EXPONENT, new Object[]{Double.valueOf(s)});
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public double probability(int x) {
        if (x > 0) goto L4;
        return 0.0d;
    L4:
        if (x <= this.numberOfElements) goto L7;
        return 0.0d;
    L7:
        return (1.0d / FastMath.pow(x, this.exponent)) / generalizedHarmonic(this.numberOfElements, this.exponent);
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public double cumulativeProbability(int x) {
        if (x > 0) goto L6;
        return 0.0d;
    L6:
        if (x < this.numberOfElements) goto L10;
        return 1.0d;
    L10:
        return generalizedHarmonic(x, this.exponent) / generalizedHarmonic(this.numberOfElements, this.exponent);
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainLowerBound(double p) {
        return 0;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainUpperBound(double p) {
        return this.numberOfElements;
    }

    private double generalizedHarmonic(int n, double m) {
        double value = 0.0d;
        int k = n;
    L3:
        if (k <= 0) goto L6;
        value = value + (1.0d / FastMath.pow(k, m));
        k = k - 1;
        goto L3
    L6:
        return value;
    }

    public int getSupportLowerBound() {
        return 1;
    }

    public int getSupportUpperBound() {
        return getNumberOfElements();
    }

    protected double getNumericalMean() {
        int N = getNumberOfElements();
        double s = getExponent();
        double Hs1 = generalizedHarmonic(N, s - 1.0d);
        double Hs = generalizedHarmonic(N, s);
        return Hs1 / Hs;
    }

    protected double getNumericalVariance() {
        int N = getNumberOfElements();
        double s = getExponent();
        double Hs2 = generalizedHarmonic(N, s - 2.0d);
        double Hs1 = generalizedHarmonic(N, s - 1.0d);
        double Hs = generalizedHarmonic(N, s);
        return (Hs2 / Hs) - ((Hs1 * Hs1) / (Hs * Hs));
    }
}
