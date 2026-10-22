package org.apache.commons.math.stat.descriptive;

import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NotPositiveException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractUnivariateStatistic implements UnivariateStatistic {
    private double[] storedData;

    @Override // org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public abstract UnivariateStatistic copy();

    @Override // org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public abstract double evaluate(double[] r1, int r2, int r3);

    public AbstractUnivariateStatistic() {
    }

    public void setData(double[] values) {
        if (values != null) goto L4;
        double[] r0 = null;
    L5:
        this.storedData = r0;
        return;
    L4:
        r0 = (double[]) values.clone();
        goto L5
    }

    public double[] getData() {
        if (this.storedData != null) goto L6;
        return null;
    L6:
        return (double[]) this.storedData.clone();
    }

    protected double[] getDataRef() {
        return this.storedData;
    }

    public void setData(double[] values, int begin, int length) {
        this.storedData = new double[length];
        System.arraycopy(values, begin, this.storedData, 0, length);
    }

    public double evaluate() {
        return evaluate(this.storedData);
    }

    @Override // org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values) {
        test(values, 0, 0);
        return evaluate(values, 0, values.length);
    }

    protected boolean test(double[] values, int begin, int length) {
        if (values == null) goto L18;
        if (begin < 0) goto L16;
        if (length < 0) goto L14;
        if ((begin + length) > values.length) goto L12;
        if (length != 0) goto L9;
        return false;
    L9:
        return true;
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, new Object[0]);
    L14:
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(length));
    L16:
        throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(begin));
    L18:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    protected boolean test(double[] values, double[] weights, int begin, int length) {
        if (weights == null) goto L34;
        if (weights.length != values.length) goto L32;
        boolean containsPositiveWeight = false;
        int i = begin;
    L7:
        if (i >= (begin + length)) goto L26;
        if (Double.isNaN(weights[i]) == true) goto L24;
        if (Double.isInfinite(weights[i]) == true) goto L22;
        if (weights[i] < 0.0d) goto L20;
        if (containsPositiveWeight == true) goto L18;
        if (weights[i] <= 0.0d) goto L18;
        containsPositiveWeight = true;
    L18:
        i = i + 1;
        goto L7
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(i), Double.valueOf(weights[i])});
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, new Object[]{Double.valueOf(weights[i]), Integer.valueOf(i)});
    L24:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NAN_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(i)});
    L26:
        if (containsPositiveWeight == false) goto L30;
        return test(values, begin, length);
    L30:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO, new Object[0]);
    L32:
        throw new DimensionMismatchException(weights.length, values.length);
    L34:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }
}
