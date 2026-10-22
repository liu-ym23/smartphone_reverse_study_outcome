package com.obric.oui.push;

import android.animation.Animator;
import d.h.b.o;

/* JADX INFO: compiled from: OPush.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPush$dismiss$1$2 implements Animator.AnimatorListener {
    final /* synthetic */ a this$0;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
        o.e(r1, "animation");
    }

    OPush$dismiss$1$2(a r1) {
        this.this$0 = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        o.e(r2, "animation");
        this.this$0.a();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        o.e(r2, "animation");
        this.this$0.a();
    }
}
