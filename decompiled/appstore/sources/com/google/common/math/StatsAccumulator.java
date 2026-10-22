package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class StatsAccumulator {
    private long count;
    private double max;
    private double mean;
    private double min;
    private double sumOfSquaresOfDeltas;

    public StatsAccumulator() {
        this.count = 0;
        this.mean = 0.0d;
        this.sumOfSquaresOfDeltas = 0.0d;
        this.min = Double.NaN;
        this.max = Double.NaN;
    }

    public static double calculateNewMeanNonFinite(double r10, double r11) {
        if (Doubles.isFinite(r10) == false) goto L6;
        return r11;
    L6:
        if (Doubles.isFinite(r11) == false) goto L8;
        return r10;
    L8:
        if (r10 == r11) goto L13;
        return Double.NaN;
    L13:
        return r10;
    }

    public void add(double r10) {
        long r11 = this.count;
        if (r11 != 0) goto L7;
        this.count = 1;
        this.mean = r10;
        this.min = r10;
        this.max = r10;
        if (Doubles.isFinite(r10) == true) goto L15;
        this.sumOfSquaresOfDeltas = Double.NaN;
        return;
    L15:
        return;
    L7:
        this.count = r11 + 1;
        if (Doubles.isFinite(r10) == true) goto L10;
    L12:
        this.mean = calculateNewMeanNonFinite(this.mean, r10);
        this.sumOfSquaresOfDeltas = Double.NaN;
    L13:
        this.min = Math.min(this.min, r10);
        this.max = Math.max(this.max, r10);
        return;
    L10:
        if (Doubles.isFinite(this.mean) == false) goto L12;
        double r12 = this.mean;
        double r13 = r10 - r12;
        double r14 = r12 + (r13 / this.count);
        this.mean = r14;
        this.sumOfSquaresOfDeltas += r13 * (r10 - r14);
        goto L13
    }

    public void addAll(Iterable<? extends Number> r10) {
        Iterator<? extends Number> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        add(r11.next().doubleValue());
        goto L4
    }

    public long count() {
        return this.count;
    }

    public double max() {
        if (this.count == 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        return this.max;
    L5:
        r10 = false;
        goto L6
    }

    public double mean() {
        if (this.count == 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        return this.mean;
    L5:
        r10 = false;
        goto L6
    }

    public double min() {
        if (this.count == 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        return this.min;
    L5:
        r10 = false;
        goto L6
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        if (this.count == 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        if (this.count != 1) goto L15;
        return 0.0d;
    L15:
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count;
    L5:
        r10 = false;
        goto L6
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        if (this.count <= 1) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1);
    L5:
        r10 = false;
        goto L6
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> r10) {
    L3:
        if (r10.hasNext() == false) goto L5;
        add(r10.next().doubleValue());
        goto L3
    }

    public void addAll(double... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        add(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }

    public void addAll(int... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        add(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }

    public void addAll(long... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        add(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }

    public void addAll(Stats r11) {
        if (r11.count() != 0) goto L5;
        return;
    L5:
        long r10 = this.count;
        if (r10 != 0) goto L8;
        this.count = r11.count();
        this.mean = r11.mean();
        this.sumOfSquaresOfDeltas = r11.sumOfSquaresOfDeltas();
        this.min = r11.min();
        this.max = r11.max();
        return;
    L8:
        this.count = r10 + r11.count();
        if (Doubles.isFinite(this.mean) == true) goto L11;
    L13:
        this.mean = calculateNewMeanNonFinite(this.mean, r11.mean());
        this.sumOfSquaresOfDeltas = Double.NaN;
    L14:
        this.min = Math.min(this.min, r11.min());
        this.max = Math.max(this.max, r11.max());
        return;
    L11:
        if (Doubles.isFinite(r11.mean()) == false) goto L13;
        double r12 = r11.mean();
        double r13 = this.mean;
        double r14 = r12 - r13;
        this.mean = r13 + ((r11.count() * r14) / this.count);
        this.sumOfSquaresOfDeltas += r11.sumOfSquaresOfDeltas() + ((r14 * (r11.mean() - this.mean)) * r11.count());
        goto L14
    }
}
