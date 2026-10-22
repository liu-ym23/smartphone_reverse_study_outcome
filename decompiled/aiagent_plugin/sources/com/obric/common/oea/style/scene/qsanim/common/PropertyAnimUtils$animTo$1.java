package com.obric.common.oea.style.scene.qsanim.common;

import android.animation.Animator;
import d.h.b.o;

/* JADX INFO: compiled from: PropertyAnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PropertyAnimUtils$animTo$1 implements Animator.AnimatorListener {
    final /* synthetic */ String $key;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
        o.e(r1, "animation");
    }

    PropertyAnimUtils$animTo$1(String r1) {
        this.$key = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        o.e(r2, "animation");
        c.a(c.f32564a).remove(this.$key);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        o.e(r2, "animation");
        c.a(c.f32564a).remove(this.$key);
    }
}
