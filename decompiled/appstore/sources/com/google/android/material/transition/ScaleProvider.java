package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    private static Animator createScaleAnimator(final View r10, float r11, float r12) {
        final float r13 = r10.getScaleX();
        final float r14 = r10.getScaleY();
        ObjectAnimator r15 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r13 * r11, r13 * r12}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r11 * r14, r12 * r14})});
        r15.addListener(new AnonymousClass1(r10, r13, r14));
        return r15;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r10, @NonNull View r11) {
        if (this.growing == false) goto L7;
        return createScaleAnimator(r11, this.incomingStartScale, this.incomingEndScale);
    L7:
        return createScaleAnimator(r11, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r10, @NonNull View r11) {
        if (this.scaleOnDisappear == true) goto L7;
        return null;
    L7:
        if (this.growing == false) goto L11;
        return createScaleAnimator(r11, this.outgoingStartScale, this.outgoingEndScale);
    L11:
        return createScaleAnimator(r11, this.incomingEndScale, this.incomingStartScale);
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean r10) {
        this.growing = r10;
    }

    public void setIncomingEndScale(float r10) {
        this.incomingEndScale = r10;
    }

    public void setIncomingStartScale(float r10) {
        this.incomingStartScale = r10;
    }

    public void setOutgoingEndScale(float r10) {
        this.outgoingEndScale = r10;
    }

    public void setOutgoingStartScale(float r10) {
        this.outgoingStartScale = r10;
    }

    public void setScaleOnDisappear(boolean r10) {
        this.scaleOnDisappear = r10;
    }

    public ScaleProvider(boolean r10) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = r10;
    }
}
