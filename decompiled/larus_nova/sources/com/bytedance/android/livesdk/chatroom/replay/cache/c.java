package com.bytedance.android.livesdk.chatroom.replay.cache;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static String a(int r100) {
        if (r100 != 1) goto L5;
        return "download_ing";
    L5:
        if (r100 != 2) goto L7;
        return "download_pause";
    L7:
        if (r100 != 3) goto L9;
        return "network_linking";
    L9:
        if (r100 != 5) goto L11;
        return "download_done";
    L11:
        if (r100 == 6) goto L14;
        return "not_download";
    L14:
        return BuyNowCloseMethod.NETWORK_ERROR;
    }

    public static void c(String r100, Map<String, String> r101) {
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.f118008b.d(r100, r101, new Object[0]);
    }

    public static void b(DataCenter r100, String r101, Map<String, String> r102) {
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r100).d(r101, r102, new Object[0]);
        return;
    }
}
