package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.a;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = null;
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = null;
    private static final int TOTAL_DURATION_IN_MS = 1800;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private boolean animatorCompleteEndRequested;
    private final BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private int indicatorColorIndex;
    private final Interpolator[] interpolatorArray;

    static {
        DURATION_TO_MOVE_SEGMENT_ENDS = new int[]{533, 567, 850, 750};
        DELAY_TO_MOVE_SEGMENT_ENDS = new int[]{1267, 1000, 333, 0};
        final Class<Float> r10 = Float.class;
        final String r11 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass2(r10, r11);
    }

    public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context r10, @NonNull LinearProgressIndicatorSpec r11) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = r11;
        this.interpolatorArray = new Interpolator[]{a.a(r10, R.animator.linear_indeterminate_line1_head_interpolator), a.a(r10, R.animator.linear_indeterminate_line1_tail_interpolator), a.a(r10, R.animator.linear_indeterminate_line2_head_interpolator), a.a(r10, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    public static /* synthetic */ int access$000(LinearIndeterminateDisjointAnimatorDelegate r10) {
        return r10.indicatorColorIndex;
    }

    public static /* synthetic */ int access$002(LinearIndeterminateDisjointAnimatorDelegate r10, int r11) {
        r10.indicatorColorIndex = r11;
        return r11;
    }

    public static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateDisjointAnimatorDelegate r10) {
        return r10.baseSpec;
    }

    public static /* synthetic */ boolean access$202(LinearIndeterminateDisjointAnimatorDelegate r10, boolean r11) {
        r10.dirtyColors = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$300(LinearIndeterminateDisjointAnimatorDelegate r10) {
        return r10.animatorCompleteEndRequested;
    }

    public static /* synthetic */ boolean access$302(LinearIndeterminateDisjointAnimatorDelegate r10, boolean r11) {
        r10.animatorCompleteEndRequested = r11;
        return r11;
    }

    public static /* synthetic */ ObjectAnimator access$400(LinearIndeterminateDisjointAnimatorDelegate r10) {
        return r10.animator;
    }

    public static /* synthetic */ float access$500(LinearIndeterminateDisjointAnimatorDelegate r10) {
        return r10.getAnimationFraction();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r10;
        r10.setDuration(1800);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
        return;
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == false) goto L6;
        Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.indicatorColorIndex], this.drawable.getAlpha()));
        this.dirtyColors = false;
        return;
    }

    private void updateSegmentPositions(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= 4) goto L6;
        float r12 = getFractionInRange(r10, DELAY_TO_MOVE_SEGMENT_ENDS[r11], DURATION_TO_MOVE_SEGMENT_ENDS[r11]);
        float r13 = this.interpolatorArray[r11].getInterpolation(r12);
        this.segmentPositions[r11] = Math.max(0.0f, Math.min(1.0f, r13));
        r11 = r11 + 1;
        goto L4
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
        if (this.drawable.isVisible() == false) goto L5;
        this.animatorCompleteEndRequested = true;
        this.animator.setRepeatCount(0);
        return;
    L5:
        cancelAnimatorImmediately();
    }

    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        int r10 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        int[] r11 = this.segmentColors;
        r11[0] = r10;
        r11[1] = r10;
    }

    @VisibleForTesting
    public void setAnimationFraction(float r10) {
        this.animationFraction = r10;
        updateSegmentPositions((int) (r10 * 1800.0f));
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
        this.animatorCompleteCallback = null;
    }
}
