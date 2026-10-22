package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4662a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4663b;

    public /* synthetic */ c(BottomAppBar bottomAppBar, int i10) {
        this.f4662a = i10;
        this.f4663b = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f4662a) {
            case 0:
                int i10 = BottomAppBar.f4643i0;
                this.f4663b.W = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4662a) {
            case 0:
                return;
            default:
                this.f4663b.getClass();
                throw null;
        }
    }

    private final void a(Animator animator) {
    }
}
