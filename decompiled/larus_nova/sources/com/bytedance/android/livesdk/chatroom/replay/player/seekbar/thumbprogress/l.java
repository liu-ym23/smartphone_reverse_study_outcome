package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f109826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f109827b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        f.b(this.f109826a).setText(this.f109827b);
        UtilityKotlinExtentionsKt.h(f.b(this.f109826a));
        View r101 = f.a(this.f109826a);
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.h(r101);
    L5:
        super.onAnimationEnd(r100);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        UtilityKotlinExtentionsKt.j(f.b(this.f109826a));
    }

    public l(f r100, String r101) {
        this.f109826a = r100;
        this.f109827b = r101;
    }
}
