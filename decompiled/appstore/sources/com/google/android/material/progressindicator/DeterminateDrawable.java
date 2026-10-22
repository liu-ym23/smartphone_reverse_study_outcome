package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.a;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.c;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes3.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final a INDICATOR_LENGTH_IN_LEVEL = null;
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private DrawingDelegate<S> drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange;
    private final b springAnimator;
    private final c springForce;

    static {
        final String r10 = "indicatorLevel";
        INDICATOR_LENGTH_IN_LEVEL = new AnonymousClass1(r10);
    }

    public DeterminateDrawable(@NonNull Context r10, @NonNull BaseProgressIndicatorSpec r11, @NonNull DrawingDelegate<S> r12) {
        super(r10, r11);
        this.skipAnimationOnLevelChange = false;
        setDrawingDelegate(r12);
        c r13 = new c();
        this.springForce = r13;
        r13.c(1.0f);
        r13.e(SPRING_FORCE_STIFFNESS);
        b r14 = new b(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimator = r14;
        r14.p(r13);
        setGrowFraction(1.0f);
    }

    public static /* synthetic */ float access$000(DeterminateDrawable r10) {
        return r10.getIndicatorFraction();
    }

    public static /* synthetic */ void access$100(DeterminateDrawable r10, float r11) {
        r10.setIndicatorFraction(r11);
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r10, @NonNull CircularProgressIndicatorSpec r11) {
        return new DeterminateDrawable(r10, r11, new CircularDrawingDelegate(r11));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r10, @NonNull LinearProgressIndicatorSpec r11) {
        return new DeterminateDrawable(r10, r11, new LinearDrawingDelegate(r11));
    }

    private float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    private void setIndicatorFraction(float r10) {
        this.indicatorFraction = r10;
        invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        Rect r11 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r10.getClipBounds(r11) == false) goto L13;
        r10.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r10, getGrowFraction());
        this.drawingDelegate.fillTrack(r10, this.paint);
        int r12 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], getAlpha());
        this.drawingDelegate.fillIndicator(r10, this.paint, 0.0f, getIndicatorFraction(), r12);
        r10.restore();
        return;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
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

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.springAnimator.a();
        setIndicatorFraction(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r10) {
        if (this.skipAnimationOnLevelChange == false) goto L5;
        this.springAnimator.a();
        setIndicatorFraction(r10 / 10000.0f);
        return true;
    L5:
        this.springAnimator.i(getIndicatorFraction() * 10000.0f);
        this.springAnimator.m(r10);
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        super.registerAnimationCallback(r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r10) {
        super.setAlpha(r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter r10) {
        super.setColorFilter(r10);
    }

    public void setDrawingDelegate(@NonNull DrawingDelegate<S> r10) {
        this.drawingDelegate = r10;
        r10.registerDrawable(this);
    }

    public void setLevelByFraction(float r10) {
        setLevel((int) (r10 * 10000.0f));
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r10, boolean r11) {
        return super.setVisible(r10, r11);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public boolean setVisibleInternal(boolean r10, boolean r11, boolean r12) {
        boolean r13 = super.setVisibleInternal(r10, r11, r12);
        float r14 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r14 != 0.0f) goto L5;
        this.skipAnimationOnLevelChange = true;
    L6:
        return r13;
    L5:
        this.skipAnimationOnLevelChange = false;
        this.springForce.e(SPRING_FORCE_STIFFNESS / r14);
        goto L6
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
