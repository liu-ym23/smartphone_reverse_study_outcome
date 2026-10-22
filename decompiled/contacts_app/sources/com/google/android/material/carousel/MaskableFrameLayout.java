package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes2.dex */
public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {
    private final RectF maskRect;
    private float maskXPercentage;
    private final MaskableDelegate maskableDelegate;
    private OnMaskChangedListener onMaskChangedListener;
    private Boolean savedForceCompatClippingEnabled;
    private ShapeAppearanceModel shapeAppearanceModel;

    /* JADX INFO: renamed from: com.google.android.material.carousel.MaskableFrameLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class MaskableDelegate {
        boolean forceCompatClippingEnabled;
        RectF maskBounds;
        ShapeAppearanceModel shapeAppearanceModel;
        final Path shapePath;

        abstract void invalidateClippingMethod(View r1);

        abstract boolean shouldUseCompatClipping();

        private MaskableDelegate() {
            this.forceCompatClippingEnabled = false;
            this.maskBounds = new RectF();
            this.shapePath = new Path();
        }

        /* synthetic */ MaskableDelegate(AnonymousClass1 r1) {
            this();
        }

        boolean isForceCompatClippingEnabled() {
            return this.forceCompatClippingEnabled;
        }

        void setForceCompatClippingEnabled(View r2, boolean r3) {
            if (r3 == this.forceCompatClippingEnabled) goto L6;
            this.forceCompatClippingEnabled = r3;
            invalidateClippingMethod(r2);
            return;
        }

        void onShapeAppearanceChanged(View r1, ShapeAppearanceModel r2) {
            this.shapeAppearanceModel = r2;
            updateShapePath();
            invalidateClippingMethod(r1);
        }

        void onMaskChanged(View r1, RectF r2) {
            this.maskBounds = r2;
            updateShapePath();
            invalidateClippingMethod(r1);
        }

        private void updateShapePath() {
            if (this.maskBounds.isEmpty() == false) goto L5;
            return;
        L5:
            if (this.shapeAppearanceModel == null) goto L9;
            ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1.0f, this.maskBounds, this.shapePath);
            return;
        }

        void maybeClip(Canvas r2, CanvasCompat.CanvasOperation r3) {
            if (shouldUseCompatClipping() == true) goto L5;
        L7:
            r3.run(r2);
            return;
        L5:
            if (this.shapePath.isEmpty() == true) goto L7;
            r2.save();
            r2.clipPath(this.shapePath);
            r3.run(r2);
            r2.restore();
        }
    }

    private static class MaskableDelegateV14 extends MaskableDelegate {
        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        boolean shouldUseCompatClipping() {
            return true;
        }

        private MaskableDelegateV14() {
            super(null);
        }

        /* synthetic */ MaskableDelegateV14(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        void invalidateClippingMethod(View r2) {
            if (this.shapeAppearanceModel != null) goto L5;
            return;
        L5:
            if (this.maskBounds.isEmpty() == false) goto L8;
            return;
        L8:
            if (shouldUseCompatClipping() == false) goto L12;
            r2.invalidate();
            return;
        }
    }

    private static class MaskableDelegateV22 extends MaskableDelegate {
        private boolean isShapeRoundRect;

        static /* synthetic */ float access$200(MaskableDelegateV22 r0, ShapeAppearanceModel r1, RectF r2) {
            return r0.getCornerRadiusFromShapeAppearance(r1, r2);
        }

        MaskableDelegateV22(View r2) {
            super(null);
            this.isShapeRoundRect = false;
            initMaskOutlineProvider(r2);
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public boolean shouldUseCompatClipping() {
            if (this.isShapeRoundRect == true) goto L5;
        L8:
            return true;
        L5:
            if (this.forceCompatClippingEnabled == true) goto L8;
            return false;
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        void invalidateClippingMethod(View r2) {
            updateIsShapeRoundRect();
            r2.setClipToOutline(!shouldUseCompatClipping());
            if (shouldUseCompatClipping() == false) goto L5;
            r2.invalidate();
            return;
        L5:
            r2.invalidateOutline();
        }

        private void updateIsShapeRoundRect() {
            if (this.maskBounds.isEmpty() == false) goto L5;
            return;
        L5:
            if (this.shapeAppearanceModel == null) goto L9;
            this.isShapeRoundRect = this.shapeAppearanceModel.isRoundRect(this.maskBounds);
            return;
        }

        private float getCornerRadiusFromShapeAppearance(ShapeAppearanceModel r1, RectF r2) {
            return r1.getTopRightCornerSize().getCornerSize(r2);
        }

        private void initMaskOutlineProvider(View r2) {
            r2.setOutlineProvider(new AnonymousClass1(this));
        }
    }

    private static class MaskableDelegateV33 extends MaskableDelegate {
        MaskableDelegateV33(View r2) {
            super(null);
            initMaskOutlineProvider(r2);
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public boolean shouldUseCompatClipping() {
            return this.forceCompatClippingEnabled;
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        void invalidateClippingMethod(View r2) {
            r2.setClipToOutline(!shouldUseCompatClipping());
            if (shouldUseCompatClipping() == false) goto L5;
            r2.invalidate();
            return;
        L5:
            r2.invalidateOutline();
        }

        private void initMaskOutlineProvider(View r2) {
            r2.setOutlineProvider(new AnonymousClass1(this));
        }
    }

    public MaskableFrameLayout(Context r2) {
        this(r2, null);
    }

    public MaskableFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public MaskableFrameLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.maskXPercentage = 0.0f;
        this.maskRect = new RectF();
        this.maskableDelegate = createMaskableDelegate();
        this.savedForceCompatClippingEnabled = null;
        setShapeAppearanceModel(ShapeAppearanceModel.builder(r2, r3, r4, 0, 0).build());
    }

    private MaskableDelegate createMaskableDelegate() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return new MaskableDelegateV33(this);
    L7:
        return new MaskableDelegateV22(this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        onMaskChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean r0 = this.savedForceCompatClippingEnabled;
        if (r0 == null) goto L6;
        this.maskableDelegate.setForceCompatClippingEnabled(this, r0.booleanValue());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.savedForceCompatClippingEnabled = Boolean.valueOf(this.maskableDelegate.isForceCompatClippingEnabled());
        this.maskableDelegate.setForceCompatClippingEnabled(this, true);
        super.onDetachedFromWindow();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel r2) {
        ShapeAppearanceModel r3 = r2.withTransformedCornerSizes(new MaskableFrameLayout$$ExternalSyntheticLambda1());
        this.shapeAppearanceModel = r3;
        this.maskableDelegate.onShapeAppearanceChanged(this, r3);
    }

    static /* synthetic */ CornerSize lambda$setShapeAppearanceModel$0(CornerSize r1) {
        if ((r1 instanceof AbsoluteCornerSize) == true) goto L5;
        return r1;
    L5:
        return ClampedCornerSize.createFromCornerSize((AbsoluteCornerSize) r1);
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setMaskXPercentage(float r3) {
        float r4 = MathUtils.clamp(r3, 0.0f, 1.0f);
        if (this.maskXPercentage == r4) goto L6;
        this.maskXPercentage = r4;
        onMaskChanged();
        return;
    }

    @Override // com.google.android.material.carousel.Maskable
    public float getMaskXPercentage() {
        return this.maskXPercentage;
    }

    @Override // com.google.android.material.carousel.Maskable
    public RectF getMaskRectF() {
        return this.maskRect;
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setOnMaskChangedListener(OnMaskChangedListener r1) {
        this.onMaskChangedListener = r1;
    }

    private void onMaskChanged() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        float r0 = AnimationUtils.lerp(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.maskXPercentage);
        this.maskRect.set(r0, 0.0f, getWidth() - r0, getHeight());
        this.maskableDelegate.onMaskChanged(this, this.maskRect);
        OnMaskChangedListener r1 = this.onMaskChangedListener;
        if (r1 == null) goto L9;
        r1.onMaskChanged(this.maskRect);
        return;
    }

    public void setForceCompatClipping(boolean r2) {
        this.maskableDelegate.setForceCompatClippingEnabled(this, r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (this.maskRect.isEmpty() == true) goto L11;
        if (r4.getAction() != 0) goto L11;
        float r0 = r4.getX();
        float r1 = r4.getY();
        if (this.maskRect.contains(r0, r1) == true) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r3) {
        this.maskableDelegate.maybeClip(r3, new MaskableFrameLayout$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$dispatchDraw$1$com-google-android-material-carousel-MaskableFrameLayout, reason: not valid java name */
    /* synthetic */ void m244x418c47c0(Canvas r1) {
        super.dispatchDraw(r1);
    }
}
