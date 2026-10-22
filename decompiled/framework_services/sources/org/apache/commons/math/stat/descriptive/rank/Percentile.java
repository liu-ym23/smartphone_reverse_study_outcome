package org.apache.commons.math.stat.descriptive.rank;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Percentile extends AbstractUnivariateStatistic implements Serializable {
    private static final int MAX_CACHED_LEVELS = 10;
    private static final int MIN_SELECT_SIZE = 15;
    private static final long serialVersionUID = -8091216485095130416L;
    private int[] cachedPivots;
    private double quantile;

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    public Percentile() {
        this(50.0d);
    }

    public Percentile(double p) {
        this.quantile = 0.0d;
        setQuantile(p);
        this.cachedPivots = null;
    }

    public Percentile(Percentile original) {
        this.quantile = 0.0d;
        copy(original, this);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic
    public void setData(double[] values) {
        if (values != null) goto L4;
        this.cachedPivots = null;
    L5:
        super.setData(values);
        return;
    L4:
        this.cachedPivots = new int[1023];
        Arrays.fill(this.cachedPivots, -1);
        goto L5
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic
    public void setData(double[] values, int begin, int length) {
        if (values != null) goto L4;
        this.cachedPivots = null;
    L5:
        super.setData(values, begin, length);
        return;
    L4:
        this.cachedPivots = new int[1023];
        Arrays.fill(this.cachedPivots, -1);
        goto L5
    }

    public double evaluate(double p) {
        return evaluate(getDataRef(), p);
    }

    public double evaluate(double[] values, double p) {
        test(values, 0, 0);
        return evaluate(values, 0, values.length, p);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values, int start, int length) {
        return evaluate(values, start, length, this.quantile);
    }

    public double evaluate(double[] values, int begin, int length, double p) {
        test(values, begin, length);
        if (p > 100.0d) goto L28;
        if (p <= 0.0d) goto L28;
        if (length != 0) goto L10;
        return Double.NaN;
    L10:
        if (length == 1) goto L12;
        double n = length;
        double pos = ((n + 1.0d) * p) / 100.0d;
        double fpos = FastMath.floor(pos);
        int intPos = (int) fpos;
        double dif = pos - fpos;
        if (values != getDataRef()) goto L16;
        double[] work = getDataRef();
        int[] pivotsHeap = this.cachedPivots;
    L18:
        if (pos >= 1.0d) goto L22;
        return select(work, pivotsHeap, 0);
    L22:
        if (pos >= n) goto L24;
        double lower = select(work, pivotsHeap, intPos - 1);
        double upper = select(work, pivotsHeap, intPos);
        return lower + ((upper - lower) * dif);
    L24:
        return select(work, pivotsHeap, length - 1);
    L16:
        work = new double[length];
        System.arraycopy(values, begin, work, 0, length);
        pivotsHeap = new int[1023];
        Arrays.fill(pivotsHeap, -1);
        goto L18
    L12:
        return values[begin];
    L28:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, new Object[]{Double.valueOf(p)});
    }

    private double select(double[] work, int[] pivotsHeap, int k) {
        int begin = 0;
        int end = work.length;
        int node = 0;
    L4:
        if ((end - begin) <= 15) goto L20;
        if (node < pivotsHeap.length) goto L8;
    L10:
        int pivot = partition(work, begin, end, medianOf3(work, begin, end));
        if (node >= pivotsHeap.length) goto L13;
        pivotsHeap[node] = pivot;
    L13:
        if (k == pivot) goto L15;
        if (k < pivot) goto L17;
        begin = pivot + 1;
        node = Math.min((node * 2) + 2, pivotsHeap.length);
        goto L4
    L17:
        end = pivot;
        node = Math.min((node * 2) + 1, pivotsHeap.length);
        goto L4
    L15:
        return work[k];
    L8:
        if (pivotsHeap[node] < 0) goto L10;
        pivot = pivotsHeap[node];
        goto L13
    L20:
        insertionSort(work, begin, end);
        return work[k];
    }

    int medianOf3(double[] work, int begin, int end) {
        int inclusiveEnd = end - 1;
        int middle = ((inclusiveEnd - begin) / 2) + begin;
        double wBegin = work[begin];
        double wMiddle = work[middle];
        double wEnd = work[inclusiveEnd];
        if (wBegin >= wMiddle) goto L13;
        if (wMiddle >= wEnd) goto L8;
        return middle;
    L8:
        if (wBegin >= wEnd) goto L11;
        return inclusiveEnd;
    L11:
        return begin;
    L13:
        if (wBegin >= wEnd) goto L16;
        return begin;
    L16:
        if (wMiddle >= wEnd) goto L19;
        return inclusiveEnd;
    L19:
        return middle;
    }

    private int partition(double[] work, int begin, int end, int pivot) {
        double value = work[pivot];
        work[pivot] = work[begin];
        int i = begin + 1;
        int j = end - 1;
    L3:
        if (i >= j) goto L14;
    L4:
        if (i >= j) goto L8;
        if (work[j] < value) goto L8;
        j = j - 1;
    L8:
        if (i >= j) goto L12;
        if (work[i] > value) goto L12;
        i = i + 1;
    L12:
        if (i >= j) goto L3;
        double tmp = work[i];
        work[i] = work[j];
        work[j] = tmp;
        j = j - 1;
        i = i + 1;
        goto L3
    L14:
        if (i < end) goto L16;
    L17:
        i = i - 1;
    L18:
        work[begin] = work[i];
        work[i] = value;
        return i;
    L16:
        if (work[i] <= value) goto L18;
        goto L17
    }

    private void insertionSort(double[] work, int begin, int end) {
        int j = begin + 1;
    L3:
        if (j >= end) goto L11;
        double saved = work[j];
        int i = j - 1;
    L5:
        if (i < begin) goto L9;
        if (saved >= work[i]) goto L9;
        work[i + 1] = work[i];
        i = i - 1;
    L9:
        work[i + 1] = saved;
        j = j + 1;
        goto L3
    }

    public double getQuantile() {
        return this.quantile;
    }

    public void setQuantile(double p) {
        if (p <= 0.0d) goto L9;
        if (p > 100.0d) goto L9;
        this.quantile = p;
        return;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, new Object[]{Double.valueOf(p)});
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public Percentile copy() {
        Percentile result = new Percentile();
        copy(this, result);
        return result;
    }

    public static void copy(Percentile source, Percentile dest) {
        dest.setData(source.getDataRef());
        if (source.cachedPivots == null) goto L5;
        System.arraycopy(source.cachedPivots, 0, dest.cachedPivots, 0, source.cachedPivots.length);
    L5:
        dest.quantile = source.quantile;
    }
}
