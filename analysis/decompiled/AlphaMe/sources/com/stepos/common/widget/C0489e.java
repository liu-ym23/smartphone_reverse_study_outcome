package com.stepos.common.widget;

import android.animation.Animator;
import android.content.res.Resources;

/* renamed from: com.stepos.common.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0489e implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11892a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0490f f11893b;

    public /* synthetic */ C0489e(C0490f c0490f, int i4) {
        this.f11892a = i4;
        this.f11893b = c0490f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
        int i4 = this.f11892a;
        C0490f c0490f = this.f11893b;
        switch (i4) {
            case 0:
                InterfaceC0491g interfaceC0491g = c0490f.f11894a;
                if (interfaceC0491g != null) {
                    ((C0488d) interfaceC0491g).a();
                    break;
                }
                break;
            default:
                InterfaceC0491g interfaceC0491g2 = c0490f.f11894a;
                if (interfaceC0491g2 != null) {
                    ((C0488d) interfaceC0491g2).a();
                    break;
                }
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
