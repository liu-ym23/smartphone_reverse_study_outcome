package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final FloatPropertyCompat<DeterminateDrawable> INDICATOR_LENGTH_IN_LEVEL = null;
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private DrawingDelegate<S> drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange;
    private final SpringAnimation springAnimation;
    private final SpringForce springForce;

    static /* synthetic */ float access$000(DeterminateDrawable r0) {
        return r0.getIndicatorFraction();
    }

    static /* synthetic */ void access$100(DeterminateDrawable r0, float r1) {
        r0.setIndicatorFraction(r1);
    }

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

    DeterminateDrawable(Context r2, BaseProgressIndicatorSpec r3, DrawingDelegate<S> r4) {
        super(r2, r3);
        this.skipAnimationOnLevelChange = false;
        setDrawingDelegate(r4);
        SpringForce r5 = new SpringForce();
        this.springForce = r5;
        r5.setDampingRatio(1.0f);
        r5.setStiffness(50.0f);
        SpringAnimation r6 = new SpringAnimation(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = r6;
        r6.setSpring(r5);
        setGrowFraction(1.0f);
    }

    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context r2, LinearProgressIndicatorSpec r3) {
        return new DeterminateDrawable(r2, r3, new LinearDrawingDelegate(r3));
    }

    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context r2, CircularProgressIndicatorSpec r3) {
        return new DeterminateDrawable(r2, r3, new CircularDrawingDelegate(r3));
    }

    public void addSpringAnimationEndListener(DynamicAnimation.OnAnimationEndListener r1) {
        this.springAnimation.addEndListener(r1);
    }

    public void removeSpringAnimationEndListener(DynamicAnimation.OnAnimationEndListener r1) {
        this.springAnimation.removeEndListener(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean setVisibleInternal(boolean r1, boolean r2, boolean r3) {
        boolean r4 = super.setVisibleInternal(r1, r2, r3);
        float r5 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r5 != 0.0f) goto L5;
        this.skipAnimationOnLevelChange = true;
    L6:
        return r4;
    L5:
        this.skipAnimationOnLevelChange = false;
        this.springForce.setStiffness(50.0f / r5);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        setIndicatorFraction(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r4) {
        if (this.skipAnimationOnLevelChange == false) goto L5;
        this.springAnimation.skipToEnd();
        setIndicatorFraction(r4 / 10000.0f);
        return true;
    L5:
        this.springAnimation.setStartValue(getIndicatorFraction() * 10000.0f);
        this.springAnimation.animateToFinalPosition(r4);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    void setLevelByFraction(float r2) {
        setLevel((int) (r2 * 10000.0f));
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
        if (r9.getClipBounds(r0) == false) goto L13;
        r9.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r9, getBounds(), getGrowFraction());
        this.drawingDelegate.fillTrack(r9, this.paint);
        int r7 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], getAlpha());
        this.drawingDelegate.fillIndicator(r9, this.paint, 0.0f, getIndicatorFraction(), r7);
        r9.restore();
        return;
    }

    private float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    private void setIndicatorFraction(float r1) {
        this.indicatorFraction = r1;
        invalidateSelf();
    }

    DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    void setDrawingDelegate(DrawingDelegate<S> r1) {
        this.drawingDelegate = r1;
        r1.registerDrawable(this);
    }

    static {
        final String r1 = "indicatorLevel";
        INDICATOR_LENGTH_IN_LEVEL = new AnonymousClass1(r1);
    }
}
