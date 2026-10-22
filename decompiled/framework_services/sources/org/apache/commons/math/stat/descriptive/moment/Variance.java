package org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.stat.descriptive.WeightedEvaluation;

/* JADX INFO: loaded from: classes3.dex */
public class Variance extends AbstractStorelessUnivariateStatistic implements Serializable, WeightedEvaluation {
    private static final long serialVersionUID = -9111962718267217978L;
    protected boolean incMoment;
    private boolean isBiasCorrected;
    protected SecondMoment moment;

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ StorelessUnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    public Variance() {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.moment = new SecondMoment();
    }

    public Variance(SecondMoment m2) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.incMoment = false;
        this.moment = m2;
    }

    public Variance(boolean isBiasCorrected) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.moment = new SecondMoment();
        this.isBiasCorrected = isBiasCorrected;
    }

    public Variance(boolean isBiasCorrected, SecondMoment m2) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.incMoment = false;
        this.moment = m2;
        this.isBiasCorrected = isBiasCorrected;
    }

    public Variance(Variance original) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
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
        if (this.moment.n != 0) goto L7;
        return Double.NaN;
    L7:
        if (this.moment.n != 1) goto L11;
        return 0.0d;
    L11:
        if (this.isBiasCorrected == false) goto L15;
        return this.moment.m2 / (this.moment.n - 1.0d);
    L15:
        return this.moment.m2 / this.moment.n;
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
    public double evaluate(double[] values) {
        if (values == null) goto L6;
        return evaluate(values, 0, values.length);
    L6:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values, int begin, int length) {
        if (test(values, begin, length) == false) goto L11;
        clear();
        if (length == 1) goto L12;
        if (length <= 1) goto L14;
        Mean mean = new Mean();
        double m = mean.evaluate(values, begin, length);
        double var = evaluate(values, m, begin, length);
        return var;
    L14:
        return Double.NaN;
    L12:
        return 0.0d;
    L11:
        return Double.NaN;
    }

    @Override // org.apache.commons.math.stat.descriptive.WeightedEvaluation
    public double evaluate(double[] values, double[] weights, int begin, int length) {
        if (test(values, weights, begin, length) == false) goto L11;
        clear();
        if (length == 1) goto L12;
        if (length <= 1) goto L14;
        Mean mean = new Mean();
        double m = mean.evaluate(values, weights, begin, length);
        double var = evaluate(values, weights, m, begin, length);
        return var;
    L14:
        return Double.NaN;
    L12:
        return 0.0d;
    L11:
        return Double.NaN;
    }

    @Override // org.apache.commons.math.stat.descriptive.WeightedEvaluation
    public double evaluate(double[] values, double[] weights) {
        return evaluate(values, weights, 0, values.length);
    }

    public double evaluate(double[] values, double mean, int begin, int length) {
        if (test(values, begin, length) == true) goto L5;
        return Double.NaN;
    L5:
        if (length != 1) goto L7;
        return 0.0d;
    L7:
        if (length <= 1) goto L20;
        double accum = 0.0d;
        double accum2 = 0.0d;
        int i = begin;
    L10:
        if (i >= (begin + length)) goto L12;
        double dev = values[i] - mean;
        accum = accum + (dev * dev);
        accum2 = accum2 + dev;
        i = i + 1;
        goto L10
    L12:
        double len = length;
        if (this.isBiasCorrected == false) goto L15;
        double var = (accum - ((accum2 * accum2) / len)) / (len - 1.0d);
        return var;
    L15:
        double var2 = (accum - ((accum2 * accum2) / len)) / len;
        return var2;
    L20:
        return Double.NaN;
    }

    public double evaluate(double[] values, double mean) {
        return evaluate(values, mean, 0, values.length);
    }

    public double evaluate(double[] values, double[] weights, double mean, int begin, int length) {
        if (test(values, weights, begin, length) == true) goto L5;
        return Double.NaN;
    L5:
        if (length != 1) goto L7;
        return 0.0d;
    L7:
        if (length <= 1) goto L25;
        double accum = 0.0d;
        double accum2 = 0.0d;
        int i = begin;
    L10:
        if (i >= (begin + length)) goto L12;
        double dev = values[i] - mean;
        accum = accum + (weights[i] * (dev * dev));
        accum2 = accum2 + (weights[i] * dev);
        i = i + 1;
        goto L10
    L12:
        double sumWts = 0.0d;
        int i2 = 0;
    L14:
        if (i2 >= weights.length) goto L17;
        sumWts = sumWts + weights[i2];
        i2 = i2 + 1;
        goto L14
    L17:
        if (this.isBiasCorrected == false) goto L19;
        double var = (accum - ((accum2 * accum2) / sumWts)) / (sumWts - 1.0d);
        return var;
    L19:
        double var2 = (accum - ((accum2 * accum2) / sumWts)) / sumWts;
        return var2;
    L25:
        return Double.NaN;
    }

    public double evaluate(double[] values, double[] weights, double mean) {
        return evaluate(values, weights, mean, 0, values.length);
    }

    public boolean isBiasCorrected() {
        return this.isBiasCorrected;
    }

    public void setBiasCorrected(boolean biasCorrected) {
        this.isBiasCorrected = biasCorrected;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public Variance copy() {
        Variance result = new Variance();
        copy(this, result);
        return result;
    }

    public static void copy(Variance source, Variance dest) {
        if (source == null) goto L7;
        if (dest == null) goto L7;
        dest.setData(source.getDataRef());
        dest.moment = source.moment.copy();
        dest.isBiasCorrected = source.isBiasCorrected;
        dest.incMoment = source.incMoment;
        return;
    L7:
        throw new NullArgumentException();
    }
}
