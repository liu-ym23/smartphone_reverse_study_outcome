package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;
import x.b;

/* JADX INFO: loaded from: classes3.dex */
final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> COMPLETE_END_FRACTION = null;
    private static final int CONSTANT_ROTATION_DEGREES = 1520;
    private static final int[] DELAY_TO_COLLAPSE_IN_MS = null;
    private static final int[] DELAY_TO_EXPAND_IN_MS = null;
    private static final int[] DELAY_TO_FADE_IN_MS = null;
    private static final int DURATION_TO_COLLAPSE_IN_MS = 667;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 333;
    private static final int DURATION_TO_EXPAND_IN_MS = 667;
    private static final int DURATION_TO_FADE_IN_MS = 333;
    private static final int EXTRA_DEGREES_PER_CYCLE = 250;
    private static final int TAIL_DEGREES_OFFSET = -20;
    private static final int TOTAL_CYCLES = 4;
    private static final int TOTAL_DURATION_IN_MS = 5400;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    private int indicatorColorIndexOffset;
    private final b interpolator;

    static {
        DELAY_TO_EXPAND_IN_MS = new int[]{0, 1350, 2700, 4050};
        DELAY_TO_COLLAPSE_IN_MS = new int[]{667, 2017, 3367, 4717};
        DELAY_TO_FADE_IN_MS = new int[]{1000, 2350, 3700, 5050};
        final String r10 = "animationFraction";
        final Class<Float> r11 = Float.class;
        ANIMATION_FRACTION = new AnonymousClass3(r11, r10);
        final String r12 = "completeEndFraction";
        COMPLETE_END_FRACTION = new AnonymousClass4(r11, r12);
    }

    public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec r10) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = r10;
        this.interpolator = new b();
    }

    public static /* synthetic */ int access$000(CircularIndeterminateAnimatorDelegate r10) {
        return r10.indicatorColorIndexOffset;
    }

    public static /* synthetic */ int access$002(CircularIndeterminateAnimatorDelegate r10, int r11) {
        r10.indicatorColorIndexOffset = r11;
        return r11;
    }

    public static /* synthetic */ BaseProgressIndicatorSpec access$100(CircularIndeterminateAnimatorDelegate r10) {
        return r10.baseSpec;
    }

    public static /* synthetic */ float access$200(CircularIndeterminateAnimatorDelegate r10) {
        return r10.getAnimationFraction();
    }

    public static /* synthetic */ float access$300(CircularIndeterminateAnimatorDelegate r10) {
        return r10.getCompleteEndFraction();
    }

    public static /* synthetic */ void access$400(CircularIndeterminateAnimatorDelegate r10, float r11) {
        r10.setCompleteEndFraction(r11);
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r10;
        r10.setDuration(5400);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
    L6:
        if (this.completeEndAnimator != null) goto L9;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, new float[]{0.0f, 1.0f});
        this.completeEndAnimator = r11;
        r11.setDuration(333);
        this.completeEndAnimator.setInterpolator(this.interpolator);
        this.completeEndAnimator.addListener(new AnonymousClass2(this));
        return;
    }

    private void maybeUpdateSegmentColors(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= 4) goto L16;
        float r12 = getFractionInRange(r10, DELAY_TO_FADE_IN_MS[r11], 333);
        if (r12 < 0.0f) goto L10;
        if (r12 > 1.0f) goto L10;
        int r13 = r11 + this.indicatorColorIndexOffset;
        int[] r14 = this.baseSpec.indicatorColors;
        int r15 = r13 % r14.length;
        int r16 = (r15 + 1) % r14.length;
        int r17 = MaterialColors.compositeARGBWithAlpha(r14[r15], this.drawable.getAlpha());
        int r18 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[r16], this.drawable.getAlpha());
        this.segmentColors[0] = ArgbEvaluatorCompat.getInstance().evaluate2(this.interpolator.getInterpolation(r12), Integer.valueOf(r17), Integer.valueOf(r18)).intValue();
        return;
    L10:
        r11 = r11 + 1;
        goto L4
    }

    private void setCompleteEndFraction(float r10) {
        this.completeEndFraction = r10;
    }

    private void updateSegmentPositions(int r10) {
        float[] r11 = this.segmentPositions;
        float r12 = this.animationFraction;
        r11[0] = (r12 * 1520.0f) - 20.0f;
        r11[1] = r12 * 1520.0f;
        int r13 = 0;
    L4:
        if (r13 >= 4) goto L6;
        float r14 = getFractionInRange(r10, DELAY_TO_EXPAND_IN_MS[r13], 667);
        float[] r15 = this.segmentPositions;
        r15[1] = r15[1] + (this.interpolator.getInterpolation(r14) * 250.0f);
        float r16 = getFractionInRange(r10, DELAY_TO_COLLAPSE_IN_MS[r13], 667);
        float[] r17 = this.segmentPositions;
        r17[0] = r17[0] + (this.interpolator.getInterpolation(r16) * 250.0f);
        r13 = r13 + 1;
        goto L4
    L6:
        float[] r18 = this.segmentPositions;
        float r19 = r18[0];
        float r20 = r18[1];
        float r21 = r19 + ((r20 - r19) * this.completeEndFraction);
        r18[0] = r21;
        r18[0] = r21 / 360.0f;
        r18[1] = r20 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
        ObjectAnimator r10 = this.animator;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        this.animatorCompleteCallback = r10;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
        if (this.completeEndAnimator.isRunning() == false) goto L6;
        return;
    L6:
        if (this.drawable.isVisible() == false) goto L8;
        this.completeEndAnimator.start();
        return;
    L8:
        cancelAnimatorImmediately();
    }

    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.completeEndFraction = 0.0f;
    }

    @VisibleForTesting
    public void setAnimationFraction(float r10) {
        this.animationFraction = r10;
        int r11 = (int) (r10 * 5400.0f);
        updateSegmentPositions(r11);
        maybeUpdateSegmentColors(r11);
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
