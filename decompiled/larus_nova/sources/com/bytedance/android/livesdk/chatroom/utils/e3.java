package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class e3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomTopRightBannerEvent f114450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f114451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f114452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g f114453d;

    public /* synthetic */ e3(RoomTopRightBannerEvent r100, View r101, boolean r102, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r103) {
        this.f114450a = r100;
        this.f114451b = r101;
        this.f114452c = r102;
        this.f114453d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomTopRightBannerEvent r100 = this.f114450a;
        View r101 = this.f114451b;
        boolean r102 = this.f114452c;
        com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r103 = this.f114453d;
        AnimatorSet r104 = new AnimatorSet();
        r104.setDuration(r100.getAnimationTime());
        int r105 = r100.getStatus();
        if (r105 != 0) goto L5;
        int r106 = com.bytedance.android.live.core.utils.s1.f(109.0f);
    L9:
        int r107 = r106;
    L10:
        Animator r108 = i3.f(r101, r100, r107, r102, r100.getAnimationTime());
        if (r108 == null) goto L14;
        r103.Yb(8);
        r104.play(r108);
        r104.setDuration(r100.getAnimationTime());
        r104.setInterpolator(new AccelerateInterpolator());
        r104.addListener(new g3(r100, r103));
        r104.start();
        return;
    L14:
        return;
    L5:
        if (r105 == 1) goto L7;
        r107 = 0;
        goto L10
    L7:
        r106 = -com.bytedance.android.live.core.utils.s1.f(109.0f);
        goto L9
    }
}
