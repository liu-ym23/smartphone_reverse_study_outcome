package com.obric.oui.animation.style;

import android.animation.Animator;
import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: CommonStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonStyleKt$windowBottomHide$1 implements Animator.AnimatorListener {
    final /* synthetic */ com.obric.oui.animation.a.b<View> $spring;
    final /* synthetic */ View $this_windowBottomHide;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    CommonStyleKt$windowBottomHide$1(com.obric.oui.animation.a.b<View> r1, View r2) {
        this.$spring = r1;
        this.$this_windowBottomHide = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r2) {
        o.e(r2, "animation");
        this.$spring.b();
        b.b(this.$this_windowBottomHide);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        o.e(r2, "animation");
        this.$spring.d();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        o.e(r2, "animation");
        this.$spring.d();
    }
}
