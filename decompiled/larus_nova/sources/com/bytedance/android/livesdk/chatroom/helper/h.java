package com.bytedance.android.livesdk.chatroom.helper;

import com.bytedance.android.livesdk.log.j0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class h {
    static {
    }

    public static void a(int r100) {
        HashMap r101 = new HashMap();
        r101.put("error_type", String.valueOf(r100));
        j0.l().sendLog("livesdk_client_network_error", r101, new Object[0]);
    }
}
