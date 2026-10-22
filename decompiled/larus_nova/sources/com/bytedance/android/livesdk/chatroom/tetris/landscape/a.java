package com.bytedance.android.livesdk.chatroom.tetris.landscape;

import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomTopRightBannerEvent f111716b;

    public a(LandscapeTopRightActivityBannerTetris r100, RoomTopRightBannerEvent r101) {
        this.f111715a = r100;
        this.f111716b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomTopRightBannerEvent r100 = this.f111716b;     // Catch: Throwable -> L4
        i3.e((d) this.f111715a.f111706u.getValue(), (g) this.f111715a.f111705t.getValue(), r100, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
