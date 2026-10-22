package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        super.registerAnimationCallback(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r1) {
        super.setAlpha(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter r1) {
        super.setColorFilter(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r1, boolean r2) {
        return super.setVisible(r1, r2);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r1, boolean r2, boolean r3) {
        return super.setVisible(r1, r2, r3);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        return super.unregisterAnimationCallback(r1);
    }

    IndeterminateDrawable(Context r1, BaseProgressIndicatorSpec r2, DrawingDelegate<S> r3, IndeterminateAnimatorDelegate<ObjectAnimator> r4) {
        super(r1, r2);
        setDrawingDelegate(r3);
        setAnimatorDelegate(r4);
    }

    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context r3, LinearProgressIndicatorSpec r4) {
        LinearDrawingDelegate r1 = new LinearDrawingDelegate(r4);
        if (r4.indeterminateAnimationType != 0) goto L5;
        IndeterminateAnimatorDelegate r2 = new LinearIndeterminateContiguousAnimatorDelegate(r4);
    L7:
        return new IndeterminateDrawable(r3, r4, r1, r2);
    L5:
        r2 = new LinearIndeterminateDisjointAnimatorDelegate(r3, r4);
        goto L7
    }

    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context r3, CircularProgressIndicatorSpec r4) {
        return new IndeterminateDrawable(r3, r4, new CircularDrawingDelegate(r4), new CircularIndeterminateAnimatorDelegate(r4));
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean setVisibleInternal(boolean r3, boolean r4, boolean r5) {
        boolean r6 = super.setVisibleInternal(r3, r4, r5);
        if (isRunning() == true) goto L5;
        this.animatorDelegate.cancelAnimatorImmediately();
    L5:
        this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r3 == false) goto L10;
        if (r5 == false) goto L10;
        this.animatorDelegate.startAnimator();
    L10:
        return r6;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        Rect r0 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r9.getClipBounds(r0) == false) goto L18;
        r9.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r9, getBounds(), getGrowFraction());
        this.drawingDelegate.fillTrack(r9, this.paint);
        int r1 = 0;
    L11:
        if (r1 >= this.animatorDelegate.segmentColors.length) goto L13;
        int r3 = r1 * 2;
        this.drawingDelegate.fillIndicator(r9, this.paint, this.animatorDelegate.segmentPositions[r3], this.animatorDelegate.segmentPositions[r3 + 1], this.animatorDelegate.segmentColors[r1]);
        r1 = r1 + 1;
        goto L11
    L13:
        r9.restore();
        return;
    }

    IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    void setAnimatorDelegate(IndeterminateAnimatorDelegate<ObjectAnimator> r1) {
        this.animatorDelegate = r1;
        r1.registerDrawable(this);
    }

    DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    void setDrawingDelegate(DrawingDelegate<S> r1) {
        this.drawingDelegate = r1;
        r1.registerDrawable(this);
    }
}
