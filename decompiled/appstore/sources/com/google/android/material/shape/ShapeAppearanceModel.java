package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeAppearanceModel {
    public static final CornerSize PILL = null;
    EdgeTreatment bottomEdge;
    CornerTreatment bottomLeftCorner;
    CornerSize bottomLeftCornerSize;
    CornerTreatment bottomRightCorner;
    CornerSize bottomRightCornerSize;
    EdgeTreatment leftEdge;
    EdgeTreatment rightEdge;
    EdgeTreatment topEdge;
    CornerTreatment topLeftCorner;
    CornerSize topLeftCornerSize;
    CornerTreatment topRightCorner;
    CornerSize topRightCornerSize;

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapeAppearanceModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @NonNull
        private EdgeTreatment bottomEdge;

        @NonNull
        private CornerTreatment bottomLeftCorner;

        @NonNull
        private CornerSize bottomLeftCornerSize;

        @NonNull
        private CornerTreatment bottomRightCorner;

        @NonNull
        private CornerSize bottomRightCornerSize;

        @NonNull
        private EdgeTreatment leftEdge;

        @NonNull
        private EdgeTreatment rightEdge;

        @NonNull
        private EdgeTreatment topEdge;

        @NonNull
        private CornerTreatment topLeftCorner;

        @NonNull
        private CornerSize topLeftCornerSize;

        @NonNull
        private CornerTreatment topRightCorner;

        @NonNull
        private CornerSize topRightCornerSize;

        public Builder() {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public static /* synthetic */ CornerTreatment access$100(Builder r10) {
            return r10.topLeftCorner;
        }

        public static /* synthetic */ EdgeTreatment access$1000(Builder r10) {
            return r10.rightEdge;
        }

        public static /* synthetic */ EdgeTreatment access$1100(Builder r10) {
            return r10.bottomEdge;
        }

        public static /* synthetic */ EdgeTreatment access$1200(Builder r10) {
            return r10.leftEdge;
        }

        public static /* synthetic */ CornerTreatment access$200(Builder r10) {
            return r10.topRightCorner;
        }

        public static /* synthetic */ CornerTreatment access$300(Builder r10) {
            return r10.bottomRightCorner;
        }

        public static /* synthetic */ CornerTreatment access$400(Builder r10) {
            return r10.bottomLeftCorner;
        }

        public static /* synthetic */ CornerSize access$500(Builder r10) {
            return r10.topLeftCornerSize;
        }

        public static /* synthetic */ CornerSize access$600(Builder r10) {
            return r10.topRightCornerSize;
        }

        public static /* synthetic */ CornerSize access$700(Builder r10) {
            return r10.bottomRightCornerSize;
        }

        public static /* synthetic */ CornerSize access$800(Builder r10) {
            return r10.bottomLeftCornerSize;
        }

        public static /* synthetic */ EdgeTreatment access$900(Builder r10) {
            return r10.topEdge;
        }

        private static float compatCornerTreatmentSize(CornerTreatment r10) {
            if ((r10 instanceof RoundedCornerTreatment) == false) goto L7;
            return ((RoundedCornerTreatment) r10).radius;
        L7:
            if ((r10 instanceof CutCornerTreatment) == true) goto L9;
            return -1.0f;
        L9:
            return ((CutCornerTreatment) r10).size;
        }

        @NonNull
        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }

        @NonNull
        public Builder setAllCornerSizes(@NonNull CornerSize r10) {
            return setTopLeftCornerSize(r10).setTopRightCornerSize(r10).setBottomRightCornerSize(r10).setBottomLeftCornerSize(r10);
        }

        @NonNull
        public Builder setAllCorners(int r10, @Dimension float r11) {
            return setAllCorners(MaterialShapeUtils.createCornerTreatment(r10)).setAllCornerSizes(r11);
        }

        @NonNull
        public Builder setAllEdges(@NonNull EdgeTreatment r10) {
            return setLeftEdge(r10).setTopEdge(r10).setRightEdge(r10).setBottomEdge(r10);
        }

        @NonNull
        public Builder setBottomEdge(@NonNull EdgeTreatment r10) {
            this.bottomEdge = r10;
            return this;
        }

        @NonNull
        public Builder setBottomLeftCorner(int r10, @Dimension float r11) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(r10)).setBottomLeftCornerSize(r11);
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@Dimension float r10) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(r10);
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(int r10, @Dimension float r11) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(r10)).setBottomRightCornerSize(r11);
        }

        @NonNull
        public Builder setBottomRightCornerSize(@Dimension float r10) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(r10);
            return this;
        }

        @NonNull
        public Builder setLeftEdge(@NonNull EdgeTreatment r10) {
            this.leftEdge = r10;
            return this;
        }

        @NonNull
        public Builder setRightEdge(@NonNull EdgeTreatment r10) {
            this.rightEdge = r10;
            return this;
        }

        @NonNull
        public Builder setTopEdge(@NonNull EdgeTreatment r10) {
            this.topEdge = r10;
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(int r10, @Dimension float r11) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(r10)).setTopLeftCornerSize(r11);
        }

        @NonNull
        public Builder setTopLeftCornerSize(@Dimension float r10) {
            this.topLeftCornerSize = new AbsoluteCornerSize(r10);
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(int r10, @Dimension float r11) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(r10)).setTopRightCornerSize(r11);
        }

        @NonNull
        public Builder setTopRightCornerSize(@Dimension float r10) {
            this.topRightCornerSize = new AbsoluteCornerSize(r10);
            return this;
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@NonNull CornerSize r10) {
            this.bottomLeftCornerSize = r10;
            return this;
        }

        @NonNull
        public Builder setBottomRightCornerSize(@NonNull CornerSize r10) {
            this.bottomRightCornerSize = r10;
            return this;
        }

        @NonNull
        public Builder setTopLeftCornerSize(@NonNull CornerSize r10) {
            this.topLeftCornerSize = r10;
            return this;
        }

        @NonNull
        public Builder setTopRightCornerSize(@NonNull CornerSize r10) {
            this.topRightCornerSize = r10;
            return this;
        }

        @NonNull
        public Builder setAllCorners(@NonNull CornerTreatment r10) {
            return setTopLeftCorner(r10).setTopRightCorner(r10).setBottomRightCorner(r10).setBottomLeftCorner(r10);
        }

        @NonNull
        public Builder setBottomLeftCorner(int r10, @NonNull CornerSize r11) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(r10)).setBottomLeftCornerSize(r11);
        }

        @NonNull
        public Builder setBottomRightCorner(int r10, @NonNull CornerSize r11) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(r10)).setBottomRightCornerSize(r11);
        }

        @NonNull
        public Builder setTopLeftCorner(int r10, @NonNull CornerSize r11) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(r10)).setTopLeftCornerSize(r11);
        }

        @NonNull
        public Builder setTopRightCorner(int r10, @NonNull CornerSize r11) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(r10)).setTopRightCornerSize(r11);
        }

        @NonNull
        public Builder setAllCornerSizes(@Dimension float r10) {
            return setTopLeftCornerSize(r10).setTopRightCornerSize(r10).setBottomRightCornerSize(r10).setBottomLeftCornerSize(r10);
        }

        @NonNull
        public Builder setBottomLeftCorner(@NonNull CornerTreatment r10) {
            this.bottomLeftCorner = r10;
            float r11 = compatCornerTreatmentSize(r10);
            if (r11 == (-1.0f)) goto L5;
            setBottomLeftCornerSize(r11);
        L5:
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(@NonNull CornerTreatment r10) {
            this.bottomRightCorner = r10;
            float r11 = compatCornerTreatmentSize(r10);
            if (r11 == (-1.0f)) goto L5;
            setBottomRightCornerSize(r11);
        L5:
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(@NonNull CornerTreatment r10) {
            this.topLeftCorner = r10;
            float r11 = compatCornerTreatmentSize(r10);
            if (r11 == (-1.0f)) goto L5;
            setTopLeftCornerSize(r11);
        L5:
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(@NonNull CornerTreatment r10) {
            this.topRightCorner = r10;
            float r11 = compatCornerTreatmentSize(r10);
            if (r11 == (-1.0f)) goto L5;
            setTopRightCornerSize(r11);
        L5:
            return this;
        }

        public Builder(@NonNull ShapeAppearanceModel r10) {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = r10.topLeftCorner;
            this.topRightCorner = r10.topRightCorner;
            this.bottomRightCorner = r10.bottomRightCorner;
            this.bottomLeftCorner = r10.bottomLeftCorner;
            this.topLeftCornerSize = r10.topLeftCornerSize;
            this.topRightCornerSize = r10.topRightCornerSize;
            this.bottomRightCornerSize = r10.bottomRightCornerSize;
            this.bottomLeftCornerSize = r10.bottomLeftCornerSize;
            this.topEdge = r10.topEdge;
            this.rightEdge = r10.rightEdge;
            this.bottomEdge = r10.bottomEdge;
            this.leftEdge = r10.leftEdge;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize r10);
    }

    static {
        PILL = new RelativeCornerSize(0.5f);
    }

    public /* synthetic */ ShapeAppearanceModel(Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    private static CornerSize getCornerSize(TypedArray r10, int r11, @NonNull CornerSize r12) {
        TypedValue r13 = r10.peekValue(r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        int r14 = r13.type;
        if (r14 != 5) goto L10;
        return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(r13.data, r10.getResources().getDisplayMetrics()));
    L10:
        if (r14 == 6) goto L12;
        return r12;
    L12:
        return new RelativeCornerSize(r13.getFraction(1.0f, 1.0f));
    }

    @NonNull
    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    @NonNull
    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    @NonNull
    public CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    @NonNull
    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    @NonNull
    public CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    @NonNull
    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    @NonNull
    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    @NonNull
    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    @NonNull
    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    @NonNull
    public CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    @NonNull
    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    @NonNull
    public CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@NonNull RectF r10) {
        if (this.leftEdge.getClass().equals(EdgeTreatment.class) == true) goto L5;
    L11:
        boolean r11 = false;
    L12:
        float r12 = this.topLeftCornerSize.getCornerSize(r10);
        if (this.topRightCornerSize.getCornerSize(r10) == r12) goto L15;
    L19:
        boolean r13 = false;
    L21:
        if ((this.topRightCorner instanceof RoundedCornerTreatment) == true) goto L23;
    L29:
        boolean r14 = false;
    L30:
        if (r11 == false) goto L35;
        if (r13 == false) goto L36;
        if (r14 == true) goto L34;
        return false;
    L34:
        return true;
    L36:
        return false;
    L35:
        return false;
    L23:
        if ((this.topLeftCorner instanceof RoundedCornerTreatment) == false) goto L29;
        if ((this.bottomRightCorner instanceof RoundedCornerTreatment) == false) goto L29;
        if ((this.bottomLeftCorner instanceof RoundedCornerTreatment) == false) goto L29;
        r14 = true;
        goto L30
    L15:
        if (this.bottomLeftCornerSize.getCornerSize(r10) != r12) goto L19;
        if (this.bottomRightCornerSize.getCornerSize(r10) != r12) goto L19;
        r13 = true;
        goto L21
    L5:
        if (this.rightEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        if (this.topEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        if (this.bottomEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        r11 = true;
        goto L12
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(float r10) {
        return toBuilder().setAllCornerSizes(r10).build();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator r10) {
        return toBuilder().setTopLeftCornerSize(r10.apply(getTopLeftCornerSize())).setTopRightCornerSize(r10.apply(getTopRightCornerSize())).setBottomLeftCornerSize(r10.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(r10.apply(getBottomRightCornerSize())).build();
    }

    private ShapeAppearanceModel(@NonNull Builder r10) {
        this.topLeftCorner = Builder.access$100(r10);
        this.topRightCorner = Builder.access$200(r10);
        this.bottomRightCorner = Builder.access$300(r10);
        this.bottomLeftCorner = Builder.access$400(r10);
        this.topLeftCornerSize = Builder.access$500(r10);
        this.topRightCornerSize = Builder.access$600(r10);
        this.bottomRightCornerSize = Builder.access$700(r10);
        this.bottomLeftCornerSize = Builder.access$800(r10);
        this.topEdge = Builder.access$900(r10);
        this.rightEdge = Builder.access$1000(r10);
        this.bottomEdge = Builder.access$1100(r10);
        this.leftEdge = Builder.access$1200(r10);
    }

    @NonNull
    public static Builder builder(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        return builder(r10, r11, r12, r13, 0);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(@NonNull CornerSize r10) {
        return toBuilder().setAllCornerSizes(r10).build();
    }

    @NonNull
    public static Builder builder(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13, int r14) {
        return builder(r10, r11, r12, r13, new AbsoluteCornerSize(r14));
    }

    @NonNull
    public static Builder builder(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13, @NonNull CornerSize r14) {
        TypedArray r15 = r10.obtainStyledAttributes(r11, R.styleable.MaterialShape, r12, r13);
        int r16 = r15.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int r17 = r15.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        r15.recycle();
        return builder(r10, r16, r17, r14);
    }

    @NonNull
    public static Builder builder(Context r10, @StyleRes int r11, @StyleRes int r12) {
        return builder(r10, r11, r12, 0);
    }

    @NonNull
    private static Builder builder(Context r10, @StyleRes int r11, @StyleRes int r12, int r13) {
        return builder(r10, r11, r12, new AbsoluteCornerSize(r13));
    }

    @NonNull
    private static Builder builder(Context r10, @StyleRes int r11, @StyleRes int r12, @NonNull CornerSize r13) {
        if (r12 == 0) goto L4;
        ContextThemeWrapper r14 = new ContextThemeWrapper(r10, r11);
        r11 = r12;
        r10 = r14;
    L4:
        TypedArray r15 = r10.obtainStyledAttributes(r11, R.styleable.ShapeAppearance);
        int r16 = r15.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);     // Catch: Throwable -> L8
        int r17 = r15.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, r16);     // Catch: Throwable -> L8
        int r18 = r15.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, r16);     // Catch: Throwable -> L8
        int r19 = r15.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, r16);     // Catch: Throwable -> L8
        int r20 = r15.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, r16);     // Catch: Throwable -> L8
        CornerSize r21 = getCornerSize(r15, R.styleable.ShapeAppearance_cornerSize, r13);     // Catch: Throwable -> L8
        CornerSize r22 = getCornerSize(r15, R.styleable.ShapeAppearance_cornerSizeTopLeft, r21);     // Catch: Throwable -> L8
        CornerSize r23 = getCornerSize(r15, R.styleable.ShapeAppearance_cornerSizeTopRight, r21);     // Catch: Throwable -> L8
        CornerSize r24 = getCornerSize(r15, R.styleable.ShapeAppearance_cornerSizeBottomRight, r21);     // Catch: Throwable -> L8
        CornerSize r25 = getCornerSize(r15, R.styleable.ShapeAppearance_cornerSizeBottomLeft, r21);     // Catch: Throwable -> L8
        Builder r26 = new Builder().setTopLeftCorner(r17, r22).setTopRightCorner(r18, r23).setBottomRightCorner(r19, r24).setBottomLeftCorner(r20, r25);     // Catch: Throwable -> L8
        r15.recycle();
        return r26;
    L8:
        th = move-exception;
        r15.recycle();
        throw th;
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }
}
