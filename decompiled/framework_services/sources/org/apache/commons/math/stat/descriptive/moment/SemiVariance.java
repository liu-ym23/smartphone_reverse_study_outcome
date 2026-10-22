package org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math.stat.descriptive.UnivariateStatistic;

/* JADX INFO: loaded from: classes3.dex */
public class SemiVariance extends AbstractUnivariateStatistic implements Serializable {
    public static final Direction DOWNSIDE_VARIANCE = null;
    public static final Direction UPSIDE_VARIANCE = null;
    private static final long serialVersionUID = -2653430366886024994L;
    private boolean biasCorrected;
    private Direction varianceDirection;

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction DOWNSIDE = null;
        public static final Direction UPSIDE = null;
        private boolean direction;

        private static /* synthetic */ Direction[] $values() {
            return new Direction[]{UPSIDE, DOWNSIDE};
        }

        public static Direction valueOf(String name) {
            return (Direction) Enum.valueOf(Direction.class, name);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        static {
            UPSIDE = new Direction("UPSIDE", 0, true);
            DOWNSIDE = new Direction("DOWNSIDE", 1, false);
            $VALUES = $values();
        }

        private Direction(String r1, int r2, boolean b) {
            super(r1, r2);
            this.direction = b;
        }

        boolean getDirection() {
            return this.direction;
        }
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    static {
        UPSIDE_VARIANCE = Direction.UPSIDE;
        DOWNSIDE_VARIANCE = Direction.DOWNSIDE;
    }

    public SemiVariance() {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
    }

    public SemiVariance(boolean biasCorrected) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.biasCorrected = biasCorrected;
    }

    public SemiVariance(Direction direction) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.varianceDirection = direction;
    }

    public SemiVariance(boolean corrected, Direction direction) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.biasCorrected = corrected;
        this.varianceDirection = direction;
    }

    public SemiVariance(SemiVariance original) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        copy(original, this);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    public SemiVariance copy() {
        SemiVariance result = new SemiVariance();
        copy(this, result);
        return result;
    }

    public static void copy(SemiVariance source, SemiVariance dest) {
        dest.setData(source.getDataRef());
        dest.biasCorrected = source.biasCorrected;
        dest.varianceDirection = source.varianceDirection;
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values) {
        if (values == null) goto L6;
        return evaluate(values, 0, values.length);
    L6:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    @Override // org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] values, int start, int length) {
        double m = new Mean().evaluate(values, start, length);
        return evaluate(values, m, this.varianceDirection, this.biasCorrected, 0, values.length);
    }

    public double evaluate(double[] values, Direction direction) {
        double m = new Mean().evaluate(values);
        return evaluate(values, m, direction, this.biasCorrected, 0, values.length);
    }

    public double evaluate(double[] values, double cutoff) {
        return evaluate(values, cutoff, this.varianceDirection, this.biasCorrected, 0, values.length);
    }

    public double evaluate(double[] values, double cutoff, Direction direction) {
        return evaluate(values, cutoff, direction, this.biasCorrected, 0, values.length);
    }

    public double evaluate(double[] values, double cutoff, Direction direction, boolean corrected, int start, int length) {
        test(values, start, length);
        if (values.length != 0) goto L7;
        return Double.NaN;
    L7:
        if (values.length != 1) goto L10;
        return 0.0d;
    L10:
        boolean booleanDirection = direction.getDirection();
        double sumsq = 0.0d;
        int i = start;
    L11:
        if (i >= length) goto L20;
        if (values[i] <= cutoff) goto L15;
        boolean r9 = true;
    L16:
        if (r9 != booleanDirection) goto L18;
        double dev = values[i] - cutoff;
        sumsq = sumsq + (dev * dev);
    L18:
        i = i + 1;
        goto L11
    L15:
        r9 = false;
        goto L16
    L20:
        if (corrected == false) goto L24;
        return sumsq / (((double) length) - 1.0d);
    L24:
        return sumsq / ((double) length);
    }

    public boolean isBiasCorrected() {
        return this.biasCorrected;
    }

    public void setBiasCorrected(boolean biasCorrected) {
        this.biasCorrected = biasCorrected;
    }

    public Direction getVarianceDirection() {
        return this.varianceDirection;
    }

    public void setVarianceDirection(Direction varianceDirection) {
        this.varianceDirection = varianceDirection;
    }
}
