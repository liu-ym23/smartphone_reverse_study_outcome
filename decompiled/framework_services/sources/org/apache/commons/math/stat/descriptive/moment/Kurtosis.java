package org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Kurtosis extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 2784465764798260919L;
    protected boolean incMoment;
    protected FourthMoment moment;

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ StorelessUnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    public Kurtosis() {
        this.incMoment = true;
        this.moment = new FourthMoment();
    }

    public Kurtosis(FourthMoment m4) {
        this.incMoment = false;
        this.moment = m4;
    }

    public Kurtosis(Kurtosis original) {
        copy(original, this);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment == false) goto L7;
        this.moment.increment(d);
        return;
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.CANNOT_INCREMENT_STATISTIC_CONSTRUCTED_FROM_EXTERNAL_MOMENTS, new Object[0]);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (this.moment.getN() <= 3) goto L12;
        double variance = this.moment.m2 / (this.moment.n - 1);
        if (this.moment.n > 3) goto L7;
    L10:
        return 0.0d;
    L7:
        if (variance < 1.0E-19d) goto L10;
        double n = this.moment.n;
        double kurtosis = ((((n + 1.0d) * n) * this.moment.m4) - (((this.moment.m2 * 3.0d) * this.moment.m2) * (n - 1.0d))) / (((((n - 1.0d) * (n - 2.0d)) * (n - 3.0d)) * variance) * variance);
        return kurtosis;
    L12:
        return Double.NaN;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment == false) goto L7;
        this.moment.clear();
        return;
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.CANNOT_CLEAR_STATISTIC_CONSTRUCTED_FROM_EXTERNAL_MOMENTS, new Object[0]);
    }

    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values, int begin, int length) {
        double[] r0 = values;
        int r1 = begin;
        if (test(values, begin, length) == true) goto L5;
        return Double.NaN;
    L5:
        if (length <= 3) goto L14;
        Variance variance = new Variance();
        variance.incrementAll(r0, r1, length);
        double mean = variance.moment.m1;
        double stdDev = FastMath.sqrt(variance.getResult());
        double accum3 = 0.0d;
        int i = begin;
    L8:
        if (i >= (r1 + length)) goto L10;
        accum3 = accum3 + FastMath.pow(r0[i] - mean, 4.0d);
        i = i + 1;
        r0 = values;
        r1 = begin;
        goto L8
    L10:
        double accum4 = accum3 / FastMath.pow(stdDev, 4.0d);
        double n0 = length;
        double coefficientOne = ((n0 + 1.0d) * n0) / (((n0 - 1.0d) * (n0 - 2.0d)) * (n0 - 3.0d));
        double termTwo = (FastMath.pow(n0 - 1.0d, 2.0d) * 3.0d) / ((n0 - 2.0d) * (n0 - 3.0d));
        double kurt = (coefficientOne * accum4) - termTwo;
        return kurt;
    L14:
        return Double.NaN;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public Kurtosis copy() {
        Kurtosis result = new Kurtosis();
        copy(this, result);
        return result;
    }

    public static void copy(Kurtosis source, Kurtosis dest) {
        dest.setData(source.getDataRef());
        dest.moment = source.moment.copy();
        dest.incMoment = source.incMoment;
    }
}
