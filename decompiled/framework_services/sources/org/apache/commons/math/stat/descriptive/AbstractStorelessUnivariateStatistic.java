package org.apache.commons.math.stat.descriptive;

import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractStorelessUnivariateStatistic extends AbstractUnivariateStatistic implements StorelessUnivariateStatistic {
    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public abstract void clear();

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public abstract StorelessUnivariateStatistic copy();

    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public abstract double getResult();

    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public abstract void increment(double r1);

    public AbstractStorelessUnivariateStatistic() {
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values) {
        if (values == null) goto L6;
        return evaluate(values, 0, values.length);
    L6:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values, int begin, int length) {
        if (test(values, begin, length) == false) goto L6;
        clear();
        incrementAll(values, begin, length);
    L6:
        return getResult();
    }

    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public void incrementAll(double[] values) {
        if (values == null) goto L6;
        incrementAll(values, 0, values.length);
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    @Override // org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public void incrementAll(double[] values, int begin, int length) {
        if (test(values, begin, length) == false) goto L7;
        int k = begin + length;
        int i = begin;
    L5:
        if (i >= k) goto L9;
        increment(values[i]);
        i = i + 1;
        goto L5
    L9:
        return;
    }

    public boolean equals(Object object) {
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof AbstractStorelessUnivariateStatistic) == true) goto L8;
        return false;
    L8:
        AbstractStorelessUnivariateStatistic stat = (AbstractStorelessUnivariateStatistic) object;
        if (MathUtils.equalsIncludingNaN(stat.getResult(), getResult()) == false) goto L14;
        if (MathUtils.equalsIncludingNaN(stat.getN(), getN()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return ((MathUtils.hash(getResult()) + 31) * 31) + MathUtils.hash(getN());
    }
}
