package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.nu;
import com.bytedance.android.livesdk.config.q21;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class j3 {
    public static void a(long r100, long r101, String r102) {
    L10:
        th = move-exception;
        ALogger.e("enterRoom", "error report " + th.toString());
        return;
    L3:
        if (q21.a() == false) goto L5;
        return;
    L5:
        long r103 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L10
        HashMap r104 = new HashMap();     // Catch: Throwable -> L10
        r104.put("api_time_cost", String.valueOf(r103));     // Catch: Throwable -> L10
        r104.put("api_status", r102);     // Catch: Throwable -> L10
        r104.put("room_id", String.valueOf(r100));     // Catch: Throwable -> L10
        r104.put("business_type", "room_enter");     // Catch: Throwable -> L10
        String r105 = "old";
        if (nu.f120860a.getValue().booleanValue() == false) goto L8;
        r105 = "new";
    L8:
        r104.put("api_version", r105);     // Catch: Throwable -> L10
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_interface_request_duration", r104, new Object[0]);     // Catch: Throwable -> L10
    }
}
