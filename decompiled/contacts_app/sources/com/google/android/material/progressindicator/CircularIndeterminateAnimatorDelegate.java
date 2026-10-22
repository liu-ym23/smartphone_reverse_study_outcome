package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
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
    private final FastOutSlowInInterpolator interpolator;

    static /* synthetic */ int access$000(CircularIndeterminateAnimatorDelegate r0) {
        return r0.indicatorColorIndexOffset;
    }

    static /* synthetic */ int access$002(CircularIndeterminateAnimatorDelegate r0, int r1) {
        r0.indicatorColorIndexOffset = r1;
        return r1;
    }

    static /* synthetic */ BaseProgressIndicatorSpec access$100(CircularIndeterminateAnimatorDelegate r0) {
        return r0.baseSpec;
    }

    static /* synthetic */ float access$200(CircularIndeterminateAnimatorDelegate r0) {
        return r0.getAnimationFraction();
    }

    static /* synthetic */ float access$300(CircularIndeterminateAnimatorDelegate r0) {
        return r0.getCompleteEndFraction();
    }

    static /* synthetic */ void access$400(CircularIndeterminateAnimatorDelegate r0, float r1) {
        r0.setCompleteEndFraction(r1);
    }

    static {
        DELAY_TO_EXPAND_IN_MS = new int[]{0, 1350, 2700, 4050};
        DELAY_TO_COLLAPSE_IN_MS = new int[]{667, 2017, 3367, 4717};
        DELAY_TO_FADE_IN_MS = new int[]{1000, 2350, 3700, 5050};
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass3(r1, r2);
        final Class<Float> r3 = Float.class;
        final String r4 = "completeEndFraction";
        COMPLETE_END_FRACTION = new AnonymousClass4(r3, r4);
    }

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec r2) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = r2;
        this.interpolator = new FastOutSlowInInterpolator();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r0;
        r0.setDuration(5400);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
    L6:
        if (this.completeEndAnimator != null) goto L9;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, new float[]{0.0f, 1.0f});
        this.completeEndAnimator = r1;
        r1.setDuration(333);
        this.completeEndAnimator.setInterpolator(this.interpolator);
        this.completeEndAnimator.addListener(new AnonymousClass2(this));
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void cancelAnimatorImmediately() {
        ObjectAnimator r0 = this.animator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator r0 = this.completeEndAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L8;
        return;
    L8:
        if (this.drawable.isVisible() == false) goto L10;
        this.completeEndAnimator.start();
        return;
    L10:
        cancelAnimatorImmediately();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(Animatable2Compat.AnimationCallback r1) {
        this.animatorCompleteCallback = r1;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }

    private void updateSegmentPositions(int r9) {
        this.segmentPositions[0] = (this.animationFraction * 1520.0f) - 20.0f;
        this.segmentPositions[1] = this.animationFraction * 1520.0f;
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L6;
        float r1 = getFractionInRange(r9, DELAY_TO_EXPAND_IN_MS[r0], 667);
        float[] r5 = this.segmentPositions;
        r5[1] = r5[1] + (this.interpolator.getInterpolation(r1) * 250.0f);
        float r2 = getFractionInRange(r9, DELAY_TO_COLLAPSE_IN_MS[r0], 667);
        float[] r4 = this.segmentPositions;
        r4[0] = r4[0] + (this.interpolator.getInterpolation(r2) * 250.0f);
        r0 = r0 + 1;
        goto L4
    L6:
        float[] r10 = this.segmentPositions;
        r10[0] = r10[0] + ((this.segmentPositions[1] - this.segmentPositions[0]) * this.completeEndFraction);
        float[] r11 = this.segmentPositions;
        r11[0] = r11[0] / 360.0f;
        float[] r8 = this.segmentPositions;
        r8[1] = r8[1] / 360.0f;
    }

    private void maybeUpdateSegmentColors(int r5) {
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L16;
        float r2 = getFractionInRange(r5, DELAY_TO_FADE_IN_MS[r1], 333);
        if (r2 < 0.0f) goto L10;
        if (r2 > 1.0f) goto L10;
        int r3 = (r1 + this.indicatorColorIndexOffset) % this.baseSpec.indicatorColors.length;
        int r6 = (r3 + 1) % this.baseSpec.indicatorColors.length;
        int r4 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[r3], this.drawable.getAlpha());
        int r7 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[r6], this.drawable.getAlpha());
        this.segmentColors[0] = ArgbEvaluatorCompat.getInstance().evaluate2(this.interpolator.getInterpolation(r2), Integer.valueOf(r4), Integer.valueOf(r7)).intValue();
        return;
    L10:
        r1 = r1 + 1;
        goto L4
    }

    void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.completeEndFraction = 0.0f;
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    void setAnimationFraction(float r2) {
        this.animationFraction = r2;
        int r3 = (int) (r2 * 5400.0f);
        updateSegmentPositions(r3);
        maybeUpdateSegmentColors(r3);
        this.drawable.invalidateSelf();
    }

    private float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void setCompleteEndFraction(float r1) {
        this.completeEndFraction = r1;
    }
}
