package com.obric.common.oea.foundation.animation.style;

import android.animation.Animator;
import android.view.View;
import com.obric.common.oea.foundation.animation.e.c;
import d.h.b.o;

/* JADX INFO: compiled from: CommonStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonStyleKt$windowBottomHide$1 implements Animator.AnimatorListener {
    final /* synthetic */ c $spring;
    final /* synthetic */ View $this_windowBottomHide;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    CommonStyleKt$windowBottomHide$1(View r1, c r2) {
        this.$this_windowBottomHide = r1;
        this.$spring = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r2) {
        o.e(r2, "animation");
        this.$spring.a();
        b.b(this.$this_windowBottomHide);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        o.e(r2, "animation");
        this.$spring.b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        o.e(r2, "animation");
        this.$spring.b();
    }
}
