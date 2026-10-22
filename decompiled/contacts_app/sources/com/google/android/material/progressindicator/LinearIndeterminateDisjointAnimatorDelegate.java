package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = null;
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = null;
    private static final int TOTAL_DURATION_IN_MS = 1800;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private boolean dirtyColors;
    private int indicatorColorIndex;
    private final Interpolator[] interpolatorArray;

    static /* synthetic */ int access$000(LinearIndeterminateDisjointAnimatorDelegate r0) {
        return r0.indicatorColorIndex;
    }

    static /* synthetic */ int access$002(LinearIndeterminateDisjointAnimatorDelegate r0, int r1) {
        r0.indicatorColorIndex = r1;
        return r1;
    }

    static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateDisjointAnimatorDelegate r0) {
        return r0.baseSpec;
    }

    static /* synthetic */ boolean access$202(LinearIndeterminateDisjointAnimatorDelegate r0, boolean r1) {
        r0.dirtyColors = r1;
        return r1;
    }

    static /* synthetic */ float access$300(LinearIndeterminateDisjointAnimatorDelegate r0) {
        return r0.getAnimationFraction();
    }

    static {
        DURATION_TO_MOVE_SEGMENT_ENDS = new int[]{533, 567, 850, 750};
        DELAY_TO_MOVE_SEGMENT_ENDS = new int[]{1267, 1000, 333, 0};
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass3(r1, r2);
    }

    public LinearIndeterminateDisjointAnimatorDelegate(Context r4, LinearProgressIndicatorSpec r5) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = r5;
        this.interpolatorArray = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(r4, R.anim.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(r4, R.anim.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(r4, R.anim.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(r4, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r0;
        r0.setDuration(MonitorConstants.STOP_MORE_CHANNEL_INTERVAL);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
    L6:
        if (this.completeEndAnimator != null) goto L9;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{1.0f});
        this.completeEndAnimator = r1;
        r1.setDuration(MonitorConstants.STOP_MORE_CHANNEL_INTERVAL);
        this.completeEndAnimator.setInterpolator(null);
        this.completeEndAnimator.addListener(new AnonymousClass2(this));
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
        ObjectAnimator r0 = this.animator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator r0 = this.completeEndAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == true) goto L13;
        cancelAnimatorImmediately();
        if (this.drawable.isVisible() == false) goto L12;
        this.completeEndAnimator.setFloatValues(new float[]{this.animationFraction, 1.0f});
        this.completeEndAnimator.setDuration((long) ((1.0f - this.animationFraction) * 1800.0f));
        this.completeEndAnimator.start();
        return;
    L12:
        return;
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

    private void updateSegmentPositions(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L6;
        float r1 = getFractionInRange(r5, DELAY_TO_MOVE_SEGMENT_ENDS[r0], DURATION_TO_MOVE_SEGMENT_ENDS[r0]);
        float r2 = this.interpolatorArray[r0].getInterpolation(r1);
        this.segmentPositions[r0] = Math.max(0.0f, Math.min(1.0f, r2));
        r0 = r0 + 1;
        goto L4
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == false) goto L6;
        Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.indicatorColorIndex], this.drawable.getAlpha()));
        this.dirtyColors = false;
        return;
    }

    void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        int r1 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.segmentColors[0] = r1;
        this.segmentColors[1] = r1;
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    void setAnimationFraction(float r2) {
        this.animationFraction = r2;
        updateSegmentPositions((int) (r2 * 1800.0f));
        maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }
}
