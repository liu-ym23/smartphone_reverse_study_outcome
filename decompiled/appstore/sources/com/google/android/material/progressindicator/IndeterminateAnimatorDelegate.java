package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes3.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    public IndeterminateAnimatorDelegate(int r10) {
        this.segmentPositions = new float[r10 * 2];
        this.segmentColors = new int[r10];
    }

    public abstract void cancelAnimatorImmediately();

    public float getFractionInRange(int r10, int r11, int r12) {
        return (r10 - r11) / r12;
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback r10);

    public void registerDrawable(@NonNull IndeterminateDrawable r10) {
        this.drawable = r10;
    }

    public abstract void requestCancelAnimatorAfterCurrentCycle();

    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
