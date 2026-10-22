package org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Skewness extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 7101857578996691352L;
    protected boolean incMoment;
    protected ThirdMoment moment;

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ StorelessUnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    public Skewness() {
        this.moment = null;
        this.incMoment = true;
        this.moment = new ThirdMoment();
    }

    public Skewness(ThirdMoment m3) {
        this.moment = null;
        this.incMoment = false;
        this.moment = m3;
    }

    public Skewness(Skewness original) {
        this.moment = null;
        copy(original, this);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment == false) goto L6;
        this.moment.increment(d);
        return;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (this.moment.n >= 3) goto L6;
        return Double.NaN;
    L6:
        double variance = this.moment.m2 / (this.moment.n - 1);
        if (variance >= 1.0E-19d) goto L10;
        return 0.0d;
    L10:
        double n0 = this.moment.getN();
        return (this.moment.m3 * n0) / ((((n0 - 1.0d) * (n0 - 2.0d)) * FastMath.sqrt(variance)) * variance);
    }

    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment == false) goto L6;
        this.moment.clear();
        return;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values, int begin, int length) {
        if (test(values, begin, length) == true) goto L5;
        return Double.NaN;
    L5:
        if (length <= 2) goto L19;
        Mean mean = new Mean();
        double m = mean.evaluate(values, begin, length);
        double accum = 0.0d;
        double accum2 = 0.0d;
        int i = begin;
    L8:
        if (i >= (begin + length)) goto L10;
        double d = values[i] - m;
        accum = accum + (d * d);
        accum2 = accum2 + d;
        i = i + 1;
        goto L8
    L10:
        double variance = (accum - ((accum2 * accum2) / ((double) length))) / ((double) (length - 1));
        double accum3 = 0.0d;
        int i2 = begin;
    L12:
        if (i2 >= (begin + length)) goto L14;
        double d2 = values[i2] - m;
        accum3 = accum3 + ((d2 * d2) * d2);
        i2 = i2 + 1;
        goto L12
    L14:
        double n0 = length;
        double skew = (n0 / ((n0 - 1.0d) * (n0 - 2.0d))) * (accum3 / (FastMath.sqrt(variance) * variance));
        return skew;
    L19:
        return Double.NaN;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public Skewness copy() {
        Skewness result = new Skewness();
        copy(this, result);
        return result;
    }

    public static void copy(Skewness source, Skewness dest) {
        dest.setData(source.getDataRef());
        dest.moment = new ThirdMoment(source.moment.copy());
        dest.incMoment = source.incMoment;
    }
}
