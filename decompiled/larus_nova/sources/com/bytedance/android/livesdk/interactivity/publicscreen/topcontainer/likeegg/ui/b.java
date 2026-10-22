package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggView f140003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a f140004b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LikeEggView r101 = this.f140003a;
        if (r101.f139993h != 2) goto L5;
        LikeEggView.d(r101, this.f140004b);
    L5:
        super.onAnimationCancel(r100);
    }

    public b(LikeEggView r100, com.bytedance.android.livesdk.chatroom.likeegg.a r101) {
        this.f140003a = r100;
        this.f140004b = r101;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LikeEggView r102 = this.f140003a;
        if (r102.f139993h != 2) goto L5;
        LikeEggView.d(r102, this.f140004b);
    L5:
        super.onAnimationEnd(r100, r101);
    }
}
