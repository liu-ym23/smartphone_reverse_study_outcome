package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long r10, double r11, double r12, double r13, double r14) {
        this.count = r10;
        this.mean = r11;
        this.sumOfSquaresOfDeltas = r12;
        this.min = r13;
        this.max = r14;
    }

    public static Stats fromByteArray(byte[] r10) {
        Preconditions.checkNotNull(r10);
        if (r10.length != 40) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Expected Stats.BYTES = %s remaining , got %s", 40, r10.length);
        return readFrom(ByteBuffer.wrap(r10).order(ByteOrder.LITTLE_ENDIAN));
    L5:
        r11 = false;
        goto L6
    }

    public static double meanOf(Iterable<? extends Number> r10) {
        return meanOf(r10.iterator());
    }

    public static Stats of(Iterable<? extends Number> r10) {
        StatsAccumulator r11 = new StatsAccumulator();
        r11.addAll(r10);
        return r11.snapshot();
    }

    public static Stats readFrom(ByteBuffer r15) {
        Preconditions.checkNotNull(r15);
        if (r15.remaining() < 40) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkArgument(r10, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r15.remaining());
        return new Stats(r15.getLong(), r15.getDouble(), r15.getDouble(), r15.getDouble(), r15.getDouble());
    L5:
        r10 = false;
        goto L6
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (Stats.class == r10.getClass()) goto L8;
        return false;
    L8:
        Stats r11 = (Stats) r10;
        if (this.count == r11.count) goto L11;
        return false;
    L11:
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(r11.mean)) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(r11.sumOfSquaresOfDeltas)) goto L15;
        return false;
    L15:
        if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(r11.min)) goto L17;
        return false;
    L17:
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(r11.max)) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
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

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        if (this.count <= 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        if (this.count != 1) goto L15;
        return 0.0d;
    L15:
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / count();
    L5:
        r10 = false;
        goto L6
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
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

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer r10 = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(r10);
        return r10.array();
    }

    public String toString() {
        if (count() <= 0) goto L7;
        return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
    L7:
        return MoreObjects.toStringHelper(this).add("count", this.count).toString();
    }

    public void writeTo(ByteBuffer r10) {
        Preconditions.checkNotNull(r10);
        if (r10.remaining() < 40) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r10.remaining());
        r10.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static double meanOf(Iterator<? extends Number> r10) {
        Preconditions.checkArgument(r10.hasNext());
        double r11 = r10.next().doubleValue();
        long r12 = 1;
    L4:
        if (r10.hasNext() == false) goto L11;
        double r13 = r10.next().doubleValue();
        r12 = r12 + 1;
        if (Doubles.isFinite(r13) == false) goto L10;
        if (Doubles.isFinite(r11) == false) goto L10;
        r11 = r11 + ((r13 - r11) / r12);
    L10:
        r11 = StatsAccumulator.calculateNewMeanNonFinite(r11, r13);
        goto L4
    L11:
        return r11;
    }

    public static Stats of(Iterator<? extends Number> r10) {
        StatsAccumulator r11 = new StatsAccumulator();
        r11.addAll(r10);
        return r11.snapshot();
    }

    public static Stats of(double... r10) {
        StatsAccumulator r11 = new StatsAccumulator();
        r11.addAll(r10);
        return r11.snapshot();
    }

    public static double meanOf(double... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        double r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L16;
        double r14 = r10[r11];
        if (Doubles.isFinite(r14) == true) goto L12;
    L14:
        r13 = StatsAccumulator.calculateNewMeanNonFinite(r13, r14);
    L15:
        r11 = r11 + 1;
        goto L8
    L12:
        if (Doubles.isFinite(r13) == false) goto L14;
        r13 = r13 + ((r14 - r13) / ((double) (r11 + 1)));
        goto L15
    L16:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static Stats of(int... r10) {
        StatsAccumulator r11 = new StatsAccumulator();
        r11.addAll(r10);
        return r11.snapshot();
    }

    public static Stats of(long... r10) {
        StatsAccumulator r11 = new StatsAccumulator();
        r11.addAll(r10);
        return r11.snapshot();
    }

    public static double meanOf(int... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        double r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L16;
        double r14 = r10[r11];
        if (Doubles.isFinite(r14) == true) goto L12;
    L14:
        r13 = StatsAccumulator.calculateNewMeanNonFinite(r13, r14);
    L15:
        r11 = r11 + 1;
        goto L8
    L12:
        if (Doubles.isFinite(r13) == false) goto L14;
        r13 = r13 + ((r14 - r13) / ((double) (r11 + 1)));
        goto L15
    L16:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static double meanOf(long... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        double r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L16;
        double r14 = r10[r11];
        if (Doubles.isFinite(r14) == true) goto L12;
    L14:
        r13 = StatsAccumulator.calculateNewMeanNonFinite(r13, r14);
    L15:
        r11 = r11 + 1;
        goto L8
    L12:
        if (Doubles.isFinite(r13) == false) goto L14;
        r13 = r13 + ((r14 - r13) / ((double) (r11 + 1)));
        goto L15
    L16:
        return r13;
    L5:
        r12 = false;
        goto L6
    }
}
