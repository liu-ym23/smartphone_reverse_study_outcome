package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final int GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = null;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private Animatable2Compat.AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    final Paint paint;
    private ValueAnimator showAnimator;
    private int totalAlpha;

    static {
        final Class<Float> r10 = Float.class;
        final String r11 = "growFraction";
        GROW_FRACTION = new AnonymousClass3(r10, r11);
    }

    public DrawableWithAnimatedVisibilityChange(@NonNull Context r10, @NonNull BaseProgressIndicatorSpec r11) {
        this.paint = new Paint();
        this.context = r10;
        this.baseSpec = r11;
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        setAlpha(PrivateKeyType.INVALID);
    }

    public static /* synthetic */ void access$000(DrawableWithAnimatedVisibilityChange r10) {
        r10.dispatchAnimationStart();
    }

    public static /* synthetic */ boolean access$101(DrawableWithAnimatedVisibilityChange r10, boolean r11, boolean r12) {
        return super.setVisible(r11, r12);
    }

    public static /* synthetic */ void access$200(DrawableWithAnimatedVisibilityChange r10) {
        r10.dispatchAnimationEnd();
    }

    private void dispatchAnimationEnd() {
        Animatable2Compat.AnimationCallback r10 = this.internalAnimationCallback;
        if (r10 == null) goto L5;
        r10.onAnimationEnd(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        r12.next().onAnimationEnd(this);
        goto L11
    L16:
        return;
    }

    private void dispatchAnimationStart() {
        Animatable2Compat.AnimationCallback r10 = this.internalAnimationCallback;
        if (r10 == null) goto L5;
        r10.onAnimationStart(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        r12.next().onAnimationStart(this);
        goto L11
    L16:
        return;
    }

    private void endAnimatorWithoutCallbacks(@NonNull ValueAnimator... r10) {
        boolean r11 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10[r13].end();
        r13 = r13 + 1;
        goto L3
    L5:
        this.ignoreCallbacks = r11;
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
        this.showAnimator = r10;
        r10.setDuration(500);
        this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setShowAnimator(this.showAnimator);
    L6:
        if (this.hideAnimator != null) goto L9;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
        this.hideAnimator = r11;
        r11.setDuration(500);
        this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setHideAnimator(this.hideAnimator);
        return;
    }

    private void setHideAnimator(@NonNull ValueAnimator r10) {
        ValueAnimator r11 = this.hideAnimator;
        if (r11 != null) goto L5;
    L9:
        this.hideAnimator = r10;
        r10.addListener(new AnonymousClass2(this));
        return;
    L5:
        if (r11.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void setShowAnimator(@NonNull ValueAnimator r10) {
        ValueAnimator r11 = this.showAnimator;
        if (r11 != null) goto L5;
    L9:
        this.showAnimator = r10;
        r10.addListener(new AnonymousClass1(this));
        return;
    L5:
        if (r11.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.totalAlpha;
    }

    public float getGrowFraction() {
        if (this.baseSpec.isShowAnimationEnabled() == true) goto L9;
        if (this.baseSpec.isHideAnimationEnabled() == true) goto L9;
        return 1.0f;
    L9:
        if (this.mockHideAnimationRunning == true) goto L16;
        if (this.mockShowAnimationRunning == true) goto L16;
        return this.growFraction;
    L16:
        return this.mockGrowFraction;
    }

    @NonNull
    public ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean isHiding() {
        ValueAnimator r10 = this.hideAnimator;
        if (r10 == null) goto L7;
        if (r10.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockHideAnimationRunning == true) goto L8;
        return false;
    }

    public boolean isRunning() {
        if (isShowing() == false) goto L5;
    L8:
        return true;
    L5:
        if (isHiding() == true) goto L8;
        return false;
    }

    public boolean isShowing() {
        ValueAnimator r10 = this.showAnimator;
        if (r10 == null) goto L7;
        if (r10.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockShowAnimationRunning == true) goto L8;
        return false;
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        if (this.animationCallbacks != null) goto L6;
        this.animationCallbacks = new ArrayList();
    L6:
        if (this.animationCallbacks.contains(r10) == true) goto L9;
        this.animationCallbacks.add(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.totalAlpha = r10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.paint.setColorFilter(r10);
        invalidateSelf();
    }

    public void setGrowFraction(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        if (this.growFraction == r10) goto L6;
        this.growFraction = r10;
        invalidateSelf();
        return;
    }

    public void setInternalAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        this.internalAnimationCallback = r10;
    }

    @VisibleForTesting
    public void setMockHideAnimationRunning(boolean r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        this.mockHideAnimationRunning = r10;
        this.mockGrowFraction = r11;
    }

    @VisibleForTesting
    public void setMockShowAnimationRunning(boolean r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        this.mockShowAnimationRunning = r10;
        this.mockGrowFraction = r11;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        return setVisible(r10, r11, true);
    }

    public boolean setVisibleInternal(boolean r10, boolean r11, boolean r12) {
        maybeInitializeAnimators();
        boolean r13 = false;
        if (isVisible() == true) goto L6;
        if (r10 == true) goto L6;
        return false;
    L6:
        if (r10 == false) goto L8;
        ValueAnimator r14 = this.showAnimator;
    L9:
        if (r12 == false) goto L11;
        if (r12 == true) goto L18;
    L20:
        if (r10 == true) goto L22;
    L23:
        r13 = true;
    L24:
        if (r10 == false) goto L26;
        boolean r15 = this.baseSpec.isShowAnimationEnabled();
    L27:
        if (r15 == true) goto L30;
        endAnimatorWithoutCallbacks(new ValueAnimator[]{r14});
        return r13;
    L30:
        if (r11 == false) goto L32;
    L35:
        r14.start();
    L36:
        return r13;
    L32:
        if (r14.isPaused() == false) goto L35;
        r14.resume();
        goto L36
    L26:
        r15 = this.baseSpec.isHideAnimationEnabled();
        goto L27
    L22:
        if (super.setVisible(r10, false) == false) goto L24;
    L18:
        if (r14.isRunning() == false) goto L20;
        return false;
    L11:
        if (r14.isRunning() == false) goto L13;
        r14.end();
    L15:
        return super.setVisible(r10, false);
    L13:
        endAnimatorWithoutCallbacks(new ValueAnimator[]{r14});
        goto L15
    L8:
        r14 = this.hideAnimator;
        goto L9
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.contains(r10) == false) goto L14;
        this.animationCallbacks.remove(r10);
        if (this.animationCallbacks.isEmpty() == false) goto L13;
        this.animationCallbacks = null;
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    public boolean setVisible(boolean r10, boolean r11, boolean r12) {
        float r13 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r12 == true) goto L5;
    L7:
        boolean r14 = false;
    L9:
        return setVisibleInternal(r10, r11, r14);
    L5:
        if (r13 <= 0.0f) goto L7;
        r14 = true;
        goto L9
    }
}
