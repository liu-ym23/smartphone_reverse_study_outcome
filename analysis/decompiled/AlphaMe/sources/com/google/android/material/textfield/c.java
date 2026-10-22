package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11000a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11001b;

    public /* synthetic */ c(d dVar, int i4) {
        this.f11000a = i4;
        this.f11001b = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f11000a) {
            case 1:
                this.f11001b.f11058b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f11000a) {
            case 0:
                this.f11001b.f11058b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
