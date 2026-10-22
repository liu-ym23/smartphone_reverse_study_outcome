package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class LinearTransformation {

    /* JADX INFO: renamed from: com.google.common.math.LinearTransformation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class LinearTransformationBuilder {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final double f10384x1;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final double f10385y1;

        public /* synthetic */ LinearTransformationBuilder(double r10, double r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public LinearTransformation and(double r10, double r11) {
            boolean r12 = false;
            if (DoubleUtils.isFinite(r10) == true) goto L5;
        L7:
            boolean r13 = false;
        L8:
            Preconditions.checkArgument(r13);
            double r14 = this.f10384x1;
            if (r10 != r14) goto L16;
            if (r11 == this.f10385y1) goto L13;
            r12 = true;
        L13:
            Preconditions.checkArgument(r12);
            return new VerticalLinearTransformation(this.f10384x1);
        L16:
            return withSlope((r11 - this.f10385y1) / (r10 - r14));
        L5:
            if (DoubleUtils.isFinite(r11) == false) goto L7;
            r13 = true;
            goto L8
        }

        public LinearTransformation withSlope(double r10) {
            Preconditions.checkArgument(!Double.isNaN(r10));
            if (DoubleUtils.isFinite(r10) == false) goto L7;
            return new RegularLinearTransformation(r10, this.f10385y1 - (this.f10384x1 * r10));
        L7:
            return new VerticalLinearTransformation(this.f10384x1);
        }

        private LinearTransformationBuilder(double r10, double r11) {
            this.f10384x1 = r10;
            this.f10385y1 = r11;
        }
    }

    public static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = null;

        static {
            INSTANCE = new NaNLinearTransformation();
        }

        private NaNLinearTransformation() {
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double r10) {
            return Double.NaN;
        }
    }

    public static final class RegularLinearTransformation extends LinearTransformation {

        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        public RegularLinearTransformation(double r10, double r11) {
            this.slope = r10;
            this.yIntercept = r11;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            double r10 = this.slope;
            if (r10 == 0.0d) goto L7;
            return new RegularLinearTransformation(1.0d / r10, (this.yIntercept * (-1.0d)) / r10, this);
        L7:
            return new VerticalLinearTransformation(this.yIntercept, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation r10 = this.inverse;
            if (r10 != null) goto L6;
            LinearTransformation r11 = createInverse();
            this.inverse = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            if (this.slope != 0.0d) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.slope), Double.valueOf(this.yIntercept)});
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double r10) {
            return (r10 * this.slope) + this.yIntercept;
        }

        public RegularLinearTransformation(double r10, double r11, LinearTransformation r12) {
            this.slope = r10;
            this.yIntercept = r11;
            this.inverse = r12;
        }
    }

    public static final class VerticalLinearTransformation extends LinearTransformation {

        @LazyInit
        LinearTransformation inverse;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final double f10386x;

        public VerticalLinearTransformation(double r10) {
            this.f10386x = r10;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f10386x, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation r10 = this.inverse;
            if (r10 != null) goto L6;
            LinearTransformation r11 = createInverse();
            this.inverse = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.f10386x)});
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double r10) {
            throw new IllegalStateException();
        }

        public VerticalLinearTransformation(double r10, LinearTransformation r11) {
            this.f10386x = r10;
            this.inverse = r11;
        }
    }

    public LinearTransformation() {
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double r10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(r10));
        return new RegularLinearTransformation(0.0d, r10);
    }

    public static LinearTransformationBuilder mapping(double r10, double r11) {
        if (DoubleUtils.isFinite(r10) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Preconditions.checkArgument(r12);
        return new LinearTransformationBuilder(r10, r11, null);
    L5:
        if (DoubleUtils.isFinite(r11) == false) goto L7;
        r12 = true;
        goto L8
    }

    public static LinearTransformation vertical(double r10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(r10));
        return new VerticalLinearTransformation(r10);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double r10);
}
