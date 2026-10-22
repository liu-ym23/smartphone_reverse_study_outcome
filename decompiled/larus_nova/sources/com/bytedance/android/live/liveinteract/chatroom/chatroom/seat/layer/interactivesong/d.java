package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f72309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f72310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f72311c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        c r101 = this.f72309a;
        r101.f72307b = null;
        r101.f72308c = 0;
        this.f72310b.invoke(Integer.valueOf(this.f72311c));
    }

    public d(c r100, Function1 r101, int r102) {
        this.f72309a = r100;
        this.f72310b = r101;
        this.f72311c = r102;
    }
}
