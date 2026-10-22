package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f72327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f72328b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f72327a.f72330b.clearAnimation();
        this.f72327a.f72331c.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f72327a.f72329a.setText(String.valueOf(this.f72328b));
    }

    public o(p r100, int r101) {
        this.f72327a = r100;
        this.f72328b = r101;
    }
}
