package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ScaleProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f13771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13773e;
    private boolean f;

    public j() {
        this(true);
    }

    public j(boolean r3) {
        this.f13769a = 1.0f;
        this.f13770b = 1.1f;
        this.f13771c = 0.8f;
        this.f13772d = 1.0f;
        this.f = true;
        this.f13773e = r3;
    }

    public void a(boolean r1) {
        this.f = r1;
    }

    public void a(float r1) {
        this.f13770b = r1;
    }

    public void b(float r1) {
        this.f13771c = r1;
    }

    @Override // com.google.android.material.transition.platform.m
    public Animator a(ViewGroup r1, View r2) {
        if (this.f13773e == false) goto L7;
        return a(r2, this.f13771c, this.f13772d);
    L7:
        return a(r2, this.f13770b, this.f13769a);
    }

    @Override // com.google.android.material.transition.platform.m
    public Animator b(ViewGroup r1, View r2) {
        if (this.f == true) goto L7;
        return null;
    L7:
        if (this.f13773e == false) goto L11;
        return a(r2, this.f13769a, this.f13770b);
    L11:
        return a(r2, this.f13772d, this.f13771c);
    }

    private static Animator a(final View r9, float r10, float r11) {
        final float r0 = r9.getScaleX();
        final float r1 = r9.getScaleY();
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r0 * r10, r0 * r11}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r10 * r1, r11 * r1})});
        r12.addListener(new ScaleProvider$1(r9, r0, r1));
        return r12;
    }
}
