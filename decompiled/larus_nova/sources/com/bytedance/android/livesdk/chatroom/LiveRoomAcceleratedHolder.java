package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.livesdk.config.ms;
import com.bytedance.android.livesdk.config.wq;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveRoomAcceleratedHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f105054a = 0;

    public static void a() {
        if (ms.f120779a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (wq.f121545a.getValue().a() == false) goto L9;
        com.bytedance.android.livesdk.summer.a.f158439b.attachToRoom("PublicScreenABHelper", LiveRoomAcceleratedHolder$obtainSingleton$1.INSTANCE);
        return;
    }

    static {
    }
}
