package com.bytedanceos.ui.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class FadeTransition extends Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f10234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f10235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f10236c;

    public FadeTransition(float r10, float r11, TimeInterpolator r12) {
        this.f10234a = r10;
        this.f10235b = r11;
        this.f10236c = r12;
    }

    public final void a(TransitionValues r10) {
        r10.values.put("android:faderay:background", r10.view.getBackground());
        r10.values.put("android:faderay:alpha", Float.valueOf(r10.view.getAlpha()));
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues r10) {
        a(r10);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues r10) {
        a(r10);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup r10, TransitionValues r11, TransitionValues r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        View r13 = r12.view;
        float r14 = this.f10234a;
        float r15 = this.f10235b;
        if (r14 == r15) goto L8;
        r13.setAlpha(r15);
    L8:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r13, View.ALPHA, new float[]{this.f10234a, this.f10235b});
        r16.setInterpolator(this.f10236c);
        return r16;
    }

    public FadeTransition(Context r10, AttributeSet r11) {
        super(r10, r11);
    }
}
