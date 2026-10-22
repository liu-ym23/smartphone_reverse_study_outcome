package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public PairedStats(Stats r10, Stats r11, double r12) {
        this.xStats = r10;
        this.yStats = r11;
        this.sumOfProductsOfDeltas = r12;
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

    private static double ensurePositive(double r10) {
        if (r10 <= 0.0d) goto L5;
        return r10;
    L5:
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] r10) {
        Preconditions.checkNotNull(r10);
        if (r10.length != 88) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Expected PairedStats.BYTES = %s, got %s", 88, r10.length);
        ByteBuffer r12 = ByteBuffer.wrap(r10).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(r12), Stats.readFrom(r12), r12.getDouble());
    L5:
        r11 = false;
        goto L6
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (PairedStats.class == r10.getClass()) goto L8;
        return false;
    L8:
        PairedStats r11 = (PairedStats) r10;
        if (this.xStats.equals(r11.xStats) == true) goto L11;
        return false;
    L11:
        if (this.yStats.equals(r11.yStats) == true) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(r11.sumOfProductsOfDeltas)) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
    }

    public LinearTransformation leastSquaresFit() {
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

    public double pearsonsCorrelationCoefficient() {
        boolean r10 = false;
        if (count() <= 1) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r12 = xStats().sumOfSquaresOfDeltas();
        double r13 = yStats().sumOfSquaresOfDeltas();
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

    public double sampleCovariance() {
        if (count() <= 1) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        return this.sumOfProductsOfDeltas / (count() - 1);
    L5:
        r10 = false;
        goto L6
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer r10 = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(r10);
        this.yStats.writeTo(r10);
        r10.putDouble(this.sumOfProductsOfDeltas);
        return r10.array();
    }

    public String toString() {
        if (count() <= 0) goto L7;
        return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", populationCovariance()).toString();
    L7:
        return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
