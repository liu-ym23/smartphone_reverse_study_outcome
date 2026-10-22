package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EcomEnterTrayView;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends s72.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f136684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f136685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f136686c;

    @Override // s72.c
    public final void a() {
        this.f136684a.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f136685b.removeView(this.f136686c);
        ((v72.c.a) this.f136684a).a();
    }

    @Override // s72.c, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        a r101 = this.f136684a;
        if (r101 == null) goto L6;
        ((v72.c.a) r101).b();
        return;
    }

    public h(a r100, ViewGroup r101, EcomEnterTrayView r102) {
        this.f136684a = r100;
        this.f136685b = r101;
        this.f136686c = r102;
    }
}
