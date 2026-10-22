package com.stepos.common.widget;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.common.drawble.StrokeGradientDrawable;

/* renamed from: com.stepos.common.widget.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1104i {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1105j f3805a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f3806j;
    public int k;
    public int l;
    public float m;
    public final CircularProgressButton n;
    public final StrokeGradientDrawable o;
    public AnimatorSet p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f3807q;

    public C1104i(CircularProgressButton circularProgressButton, CircularProgressButton circularProgressButton2, StrokeGradientDrawable strokeGradientDrawable) {
        this.f3807q = circularProgressButton;
        this.n = circularProgressButton2;
        this.o = strokeGradientDrawable;
    }

    public final void a() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.c, this.d);
        StrokeGradientDrawable strokeGradientDrawable = this.o;
        GradientDrawable gradientDrawable = strokeGradientDrawable.getGradientDrawable();
        valueAnimatorOfInt.addUpdateListener(new com.google.android.material.appbar.i(1, this, gradientDrawable));
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(gradientDrawable, TypedValues.Custom.S_COLOR, this.e, this.f);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeColor", this.g, this.h);
        objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.i, this.f3806j);
        ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeWidth", this.k, this.l);
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.setInterpolator(this.f3807q.getInterpolator());
        this.p.setDuration(this.b);
        this.p.playTogether(valueAnimatorOfInt, objectAnimatorOfInt, objectAnimatorOfInt2, objectAnimatorOfFloat, objectAnimatorOfInt3);
        this.p.addListener(new C1103h(this, 0));
        this.p.start();
    }
}
