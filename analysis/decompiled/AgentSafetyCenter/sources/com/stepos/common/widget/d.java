package com.stepos.common.widget;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public a f2666a;

    /* renamed from: b, reason: collision with root package name */
    public int f2667b;

    /* renamed from: c, reason: collision with root package name */
    public int f2668c;

    /* renamed from: d, reason: collision with root package name */
    public int f2669d;

    /* renamed from: e, reason: collision with root package name */
    public int f2670e;

    /* renamed from: f, reason: collision with root package name */
    public int f2671f;

    /* renamed from: g, reason: collision with root package name */
    public int f2672g;

    /* renamed from: h, reason: collision with root package name */
    public int f2673h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f2674j;

    /* renamed from: k, reason: collision with root package name */
    public int f2675k;

    /* renamed from: l, reason: collision with root package name */
    public int f2676l;

    /* renamed from: m, reason: collision with root package name */
    public float f2677m;

    /* renamed from: n, reason: collision with root package name */
    public final CircularProgressButton f2678n;

    /* renamed from: o, reason: collision with root package name */
    public final StrokeGradientDrawable f2679o;

    /* renamed from: p, reason: collision with root package name */
    public AnimatorSet f2680p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f2681q;

    public d(CircularProgressButton circularProgressButton, CircularProgressButton circularProgressButton2, StrokeGradientDrawable strokeGradientDrawable) {
        this.f2681q = circularProgressButton;
        this.f2678n = circularProgressButton2;
        this.f2679o = strokeGradientDrawable;
    }

    public final void a() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f2668c, this.f2669d);
        StrokeGradientDrawable strokeGradientDrawable = this.f2679o;
        GradientDrawable gradientDrawable = strokeGradientDrawable.getGradientDrawable();
        com.google.android.material.appbar.j jVar = new com.google.android.material.appbar.j(1);
        jVar.f2372c = this;
        jVar.f2371b = gradientDrawable;
        VarHandle.storeStoreFence();
        valueAnimatorOfInt.addUpdateListener(jVar);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(gradientDrawable, "color", this.f2670e, this.f2671f);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeColor", this.f2672g, this.f2673h);
        objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.i, this.f2674j);
        ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeWidth", this.f2675k, this.f2676l);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f2680p = animatorSet;
        animatorSet.setInterpolator(this.f2681q.getInterpolator());
        this.f2680p.setDuration(this.f2667b);
        this.f2680p.playTogether(valueAnimatorOfInt, objectAnimatorOfInt, objectAnimatorOfInt2, objectAnimatorOfFloat, objectAnimatorOfInt3);
        AnimatorSet animatorSet2 = this.f2680p;
        c cVar = new c(0);
        cVar.f2665b = this;
        VarHandle.storeStoreFence();
        animatorSet2.addListener(cVar);
        this.f2680p.start();
    }
}
