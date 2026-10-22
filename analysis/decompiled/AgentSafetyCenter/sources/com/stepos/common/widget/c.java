package com.stepos.common.widget;

import android.animation.Animator;
import android.content.res.Resources;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2664a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ d f2665b;

    public /* synthetic */ c(int i) {
        this.f2664a = i;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.f2664a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
        switch (this.f2664a) {
            case 0:
                a aVar = this.f2665b.f2666a;
                if (aVar != null) {
                    aVar.a();
                    break;
                }
                break;
            default:
                a aVar2 = this.f2665b.f2666a;
                if (aVar2 != null) {
                    aVar2.a();
                    break;
                }
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i = this.f2664a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i = this.f2664a;
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
}
