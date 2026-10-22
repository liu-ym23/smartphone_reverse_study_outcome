package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.enteranim.view.GameDownloadEnterView;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends s72.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f136687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GameDownloadEnterView f136688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f136689c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f136687a.removeView(this.f136688b);
        ((v72.c.a) this.f136689c).a();
    }

    @Override // s72.c, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        a r101 = this.f136689c;
        if (r101 == null) goto L6;
        ((v72.c.a) r101).b();
        return;
    }

    public j(ViewGroup r100, GameDownloadEnterView r101, a r102) {
        this.f136687a = r100;
        this.f136688b = r101;
        this.f136689c = r102;
    }
}
