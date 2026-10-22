package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f109832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f109833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f109834c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        f.b(this.f109832a).setText(this.f109834c);
        UtilityKotlinExtentionsKt.j(f.b(this.f109832a));
        View r101 = f.a(this.f109832a);
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.k(r101, this.f109833b);
        return;
    }

    public p(f r100, boolean r101, String r102) {
        this.f109832a = r100;
        this.f109833b = r101;
        this.f109834c = r102;
    }
}
