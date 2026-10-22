package com.stepos.common.widget;

import android.animation.Animator;

/* renamed from: com.stepos.common.widget.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1103h implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3804a;
    public final /* synthetic */ C1104i b;

    public /* synthetic */ C1103h(C1104i c1104i, int i) {
        this.f3804a = i;
        this.b = c1104i;
    }

    private final void a(Animator animator) {
    }

    private final void b(Animator animator) {
    }

    private final void c(Animator animator) {
    }

    private final void d(Animator animator) {
    }

    private final void e(Animator animator) {
    }

    private final void f(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.f3804a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f3804a) {
            case 0:
                InterfaceC1105j interfaceC1105j = this.b.f3805a;
                if (interfaceC1105j != null) {
                    interfaceC1105j.onAnimationEnd();
                    break;
                }
                break;
            default:
                InterfaceC1105j interfaceC1105j2 = this.b.f3805a;
                if (interfaceC1105j2 != null) {
                    interfaceC1105j2.onAnimationEnd();
                    break;
                }
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i = this.f3804a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i = this.f3804a;
    }
}
