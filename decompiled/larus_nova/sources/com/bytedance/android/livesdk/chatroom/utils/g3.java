package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;

/* JADX INFO: loaded from: classes8.dex */
public final class g3 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomTopRightBannerEvent f114479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g f114480b;

    public g3(RoomTopRightBannerEvent r100, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r101) {
        this.f114479a = r100;
        this.f114480b = r101;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100, boolean r101) {
        if (this.f114479a.getStatus() != 1) goto L5;
        this.f114480b.Yb(8);
        return;
    L5:
        this.f114480b.Yb(0);
    }
}
