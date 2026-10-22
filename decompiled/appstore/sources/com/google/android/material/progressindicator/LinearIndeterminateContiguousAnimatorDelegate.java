package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;
import x.b;

/* JADX INFO: loaded from: classes3.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final int DURATION_PER_CYCLE_IN_MS = 333;
    private static final int TOTAL_DURATION_IN_MS = 667;
    private float animationFraction;
    private ObjectAnimator animator;
    private final BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private b interpolator;
    private int newIndicatorColorIndex;

    static {
        final Class<Float> r10 = Float.class;
        final String r11 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass2(r10, r11);
    }

    public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec r10) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = r10;
        this.interpolator = new b();
    }

    public static /* synthetic */ int access$000(LinearIndeterminateContiguousAnimatorDelegate r10) {
        return r10.newIndicatorColorIndex;
    }

    public static /* synthetic */ int access$002(LinearIndeterminateContiguousAnimatorDelegate r10, int r11) {
        r10.newIndicatorColorIndex = r11;
        return r11;
    }

    public static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateContiguousAnimatorDelegate r10) {
        return r10.baseSpec;
    }

    public static /* synthetic */ boolean access$202(LinearIndeterminateContiguousAnimatorDelegate r10, boolean r11) {
        r10.dirtyColors = r11;
        return r11;
    }

    public static /* synthetic */ float access$300(LinearIndeterminateContiguousAnimatorDelegate r10) {
        return r10.getAnimationFraction();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r10;
        r10.setDuration(333);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
        return;
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == true) goto L5;
        return;
    L5:
        if (this.segmentPositions[3] >= 1.0f) goto L9;
        int[] r10 = this.segmentColors;
        r10[2] = r10[1];
        r10[1] = r10[0];
        r10[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.newIndicatorColorIndex], this.drawable.getAlpha());
        this.dirtyColors = false;
        return;
    }

    private void updateSegmentPositions(int r10) {
        this.segmentPositions[0] = 0.0f;
        float r11 = getFractionInRange(r10, 0, TOTAL_DURATION_IN_MS);
        float[] r12 = this.segmentPositions;
        float r13 = this.interpolator.getInterpolation(r11);
        r12[2] = r13;
        r12[1] = r13;
        float[] r14 = this.segmentPositions;
        b r15 = this.interpolator;
        float r16 = r15.getInterpolation(r11 + 0.49925038f);
        r14[4] = r16;
        r14[3] = r16;
        this.segmentPositions[5] = 1.0f;
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
    public void registerAnimatorsCompleteCallback(@Nullable Animatable2Compat.AnimationCallback r10) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha()));
    }

    @VisibleForTesting
    public void setAnimationFraction(float r10) {
        this.animationFraction = r10;
        updateSegmentPositions((int) (r10 * 333.0f));
        maybeUpdateSegmentColors();
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
    }
}
