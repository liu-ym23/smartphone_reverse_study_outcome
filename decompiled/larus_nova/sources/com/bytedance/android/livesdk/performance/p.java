package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdk.config.p7;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p7 f154756a = null;

    static {
        f154756a = com.bytedance.android.livesdk.j.f142012a.getValue();
    }

    public static boolean a() {
        p7 r100 = f154756a;
        if (r100.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.liveRoomUserInfoWidgetEnable == false) goto L7;
        return true;
    }

    public static boolean b() {
        p7 r100 = f154756a;
        if (r100.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.newLiveDrawerEntranceWidgetEnable == false) goto L7;
        return true;
    }
}
