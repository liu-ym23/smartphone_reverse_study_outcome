package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes3.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;

    public IndeterminateDrawable(@NonNull Context r10, @NonNull BaseProgressIndicatorSpec r11, @NonNull DrawingDelegate<S> r12, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> r13) {
        super(r10, r11);
        setDrawingDelegate(r12);
        setAnimatorDelegate(r13);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r10, @NonNull CircularProgressIndicatorSpec r11) {
        return new IndeterminateDrawable(r10, r11, new CircularDrawingDelegate(r11), new CircularIndeterminateAnimatorDelegate(r11));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r10, @NonNull LinearProgressIndicatorSpec r11) {
        LinearDrawingDelegate r12 = new LinearDrawingDelegate(r11);
        if (r11.indeterminateAnimationType != 0) goto L5;
        IndeterminateAnimatorDelegate r13 = new LinearIndeterminateContiguousAnimatorDelegate(r11);
    L7:
        return new IndeterminateDrawable(r10, r11, r12, r13);
    L5:
        r13 = new LinearIndeterminateDisjointAnimatorDelegate(r10, r11);
        goto L7
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r11) {
        Rect r10 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r11.getClipBounds(r10) == false) goto L18;
        r11.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r11, getGrowFraction());
        this.drawingDelegate.fillTrack(r11, this.paint);
        int r12 = 0;
    L10:
        IndeterminateAnimatorDelegate<ObjectAnimator> r13 = this.animatorDelegate;
        int[] r14 = r13.segmentColors;
        if (r12 >= r14.length) goto L13;
        DrawingDelegate<S> r15 = this.drawingDelegate;
        Paint r16 = this.paint;
        float[] r17 = r13.segmentPositions;
        int r18 = r12 * 2;
        r15.fillIndicator(r11, r16, r17[r18], r17[r18 + 1], r14[r12]);
        r12 = r12 + 1;
        goto L10
    L13:
        r11.restore();
        return;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @NonNull
    public IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    @NonNull
    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
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
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        super.registerAnimationCallback(r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r10) {
        super.setAlpha(r10);
    }

    public void setAnimatorDelegate(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> r10) {
        this.animatorDelegate = r10;
        r10.registerDrawable(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter r10) {
        super.setColorFilter(r10);
    }

    public void setDrawingDelegate(@NonNull DrawingDelegate<S> r10) {
        this.drawingDelegate = r10;
        r10.registerDrawable(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r10, boolean r11) {
        return super.setVisible(r10, r11);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public boolean setVisibleInternal(boolean r10, boolean r11, boolean r12) {
        boolean r13 = super.setVisibleInternal(r10, r11, r12);
        if (isRunning() == true) goto L5;
        this.animatorDelegate.cancelAnimatorImmediately();
    L5:
        this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r10 == false) goto L10;
        if (r12 == false) goto L10;
        this.animatorDelegate.startAnimator();
    L10:
        return r13;
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
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        return super.unregisterAnimationCallback(r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r10, boolean r11, boolean r12) {
        return super.setVisible(r10, r11, r12);
    }
}
