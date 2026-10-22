package com.stepos.common.widget;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.stepos.common.drawble.StrokeGradientDrawable;

/* renamed from: com.stepos.common.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0490f {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0491g f11894a;

    /* renamed from: b, reason: collision with root package name */
    public int f11895b;

    /* renamed from: c, reason: collision with root package name */
    public int f11896c;

    /* renamed from: d, reason: collision with root package name */
    public int f11897d;

    /* renamed from: e, reason: collision with root package name */
    public int f11898e;

    /* renamed from: f, reason: collision with root package name */
    public int f11899f;

    /* renamed from: g, reason: collision with root package name */
    public int f11900g;

    /* renamed from: h, reason: collision with root package name */
    public int f11901h;

    /* renamed from: i, reason: collision with root package name */
    public float f11902i;

    /* renamed from: j, reason: collision with root package name */
    public float f11903j;

    /* renamed from: k, reason: collision with root package name */
    public int f11904k;

    /* renamed from: l, reason: collision with root package name */
    public int f11905l;

    /* renamed from: m, reason: collision with root package name */
    public float f11906m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f11907n;

    /* renamed from: o, reason: collision with root package name */
    public final StrokeGradientDrawable f11908o;

    /* renamed from: p, reason: collision with root package name */
    public AnimatorSet f11909p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f11910q;

    public C0490f(CircularProgressButton circularProgressButton, TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
        this.f11910q = circularProgressButton;
        this.f11907n = textView;
        this.f11908o = strokeGradientDrawable;
    }

    public final void a() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f11896c, this.f11897d);
        StrokeGradientDrawable strokeGradientDrawable = this.f11908o;
        GradientDrawable gradientDrawable = strokeGradientDrawable.getGradientDrawable();
        valueAnimatorOfInt.addUpdateListener(new com.google.android.material.appbar.k(2, this, gradientDrawable));
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(gradientDrawable, "color", this.f11898e, this.f11899f);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeColor", this.f11900g, this.f11901h);
        objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.f11902i, this.f11903j);
        ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeWidth", this.f11904k, this.f11905l);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f11909p = animatorSet;
        animatorSet.setInterpolator(this.f11910q.getInterpolator());
        this.f11909p.setDuration(this.f11895b);
        this.f11909p.playTogether(valueAnimatorOfInt, objectAnimatorOfInt, objectAnimatorOfInt2, objectAnimatorOfFloat, objectAnimatorOfInt3);
        this.f11909p.addListener(new C0489e(this, 0));
        this.f11909p.start();
    }
}
