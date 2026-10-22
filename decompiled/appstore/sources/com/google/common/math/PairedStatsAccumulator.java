package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class PairedStatsAccumulator {
    private double sumOfProductsOfDeltas;
    private final StatsAccumulator xStats;
    private final StatsAccumulator yStats;

    public PairedStatsAccumulator() {
        this.xStats = new StatsAccumulator();
        this.yStats = new StatsAccumulator();
        this.sumOfProductsOfDeltas = 0.0d;
    }

    private static double ensureInUnitRange(double r10) {
        if (r10 < 1.0d) goto L6;
        return 1.0d;
    L6:
        if (r10 > (-1.0d)) goto L8;
        return -1.0d;
    L8:
        return r10;
    }

    private double ensurePositive(double r10) {
        if (r10 <= 0.0d) goto L5;
        return r10;
    L5:
        return Double.MIN_VALUE;
    }

    public void add(double r10, double r11) {
        this.xStats.add(r10);
        if (Doubles.isFinite(r10) == true) goto L5;
    L9:
        this.sumOfProductsOfDeltas = Double.NaN;
    L10:
        this.yStats.add(r11);
        return;
    L5:
        if (Doubles.isFinite(r11) == false) goto L9;
        if (this.xStats.count() <= 1) goto L10;
        this.sumOfProductsOfDeltas += (r10 - this.xStats.mean()) * (r11 - this.yStats.mean());
        goto L10
    }

    public void addAll(PairedStats r11) {
        if (r11.count() != 0) goto L5;
        return;
    L5:
        this.xStats.addAll(r11.xStats());
        if (this.yStats.count() != 0) goto L8;
        this.sumOfProductsOfDeltas = r11.sumOfProductsOfDeltas();
    L9:
        this.yStats.addAll(r11.yStats());
        return;
    L8:
        this.sumOfProductsOfDeltas += r11.sumOfProductsOfDeltas() + (((r11.xStats().mean() - this.xStats.mean()) * (r11.yStats().mean() - this.yStats.mean())) * r11.count());
        goto L9
    }

    public long count() {
        return this.xStats.count();
    }

    public final LinearTransformation leastSquaresFit() {
        boolean r10 = false;
        if (count() <= 1) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == true) goto L9;
        double r12 = this.xStats.sumOfSquaresOfDeltas();
        if (r12 <= 0.0d) goto L19;
        if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) goto L17;
        return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / r12);
    L17:
        return LinearTransformation.horizontal(this.yStats.mean());
    L19:
        if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) goto L21;
        r10 = true;
    L21:
        Preconditions.checkState(r10);
        return LinearTransformation.vertical(this.xStats.mean());
    L9:
        return LinearTransformation.forNaN();
    L5:
        r11 = false;
        goto L6
    }

    public final double pearsonsCorrelationCoefficient() {
        boolean r10 = false;
        if (count() <= 1) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r12 = this.xStats.sumOfSquaresOfDeltas();
        double r13 = this.yStats.sumOfSquaresOfDeltas();
        if (r12 <= 0.0d) goto L13;
        boolean r14 = true;
    L14:
        Preconditions.checkState(r14);
        if (r13 <= 0.0d) goto L17;
        r10 = true;
    L17:
        Preconditions.checkState(r10);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(r12 * r13)));
    L13:
        r14 = false;
        goto L14
    L5:
        r11 = false;
        goto L6
    }

    public double populationCovariance() {
        if (count() == 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        return this.sumOfProductsOfDeltas / count();
    L5:
        r10 = false;
        goto L6
    }

    public final double sampleCovariance() {
        if (count() <= 1) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        return this.sumOfProductsOfDeltas / (count() - 1);
    L5:
        r10 = false;
        goto L6
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }
}
