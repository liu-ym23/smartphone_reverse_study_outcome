package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f79616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QuickInteractTask f79617b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f79616a.f79622c.clearAnimation();
        this.f79616a.f79623d.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f79616a.f79621b.setVisibility(0);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r101 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a();
        if (r101 == null) goto L6;
        r101.Xb(this.f79617b);
        return;
    }

    public l(n r100, QuickInteractTask r101) {
        this.f79616a = r100;
        this.f79617b = r101;
    }
}
