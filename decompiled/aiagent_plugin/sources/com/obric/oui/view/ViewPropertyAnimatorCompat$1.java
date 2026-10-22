package com.obric.oui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class ViewPropertyAnimatorCompat$1 extends AnimatorListenerAdapter {
    final /* synthetic */ d this$0;
    final /* synthetic */ af val$listener;
    final /* synthetic */ View val$view;

    ViewPropertyAnimatorCompat$1(d r3, af r4, View r5) {
        af r6 = (af) ZeusTransformUtils.wrapperContextForParams(r4, af.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.val$listener = r6;
        this.val$view = r5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r1) {
        this.val$listener.c(this.val$view);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r1) {
        this.val$listener.b(this.val$view);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
        this.val$listener.a(this.val$view);
    }
}
