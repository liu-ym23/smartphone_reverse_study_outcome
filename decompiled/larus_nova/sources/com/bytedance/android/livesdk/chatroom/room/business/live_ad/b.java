package com.bytedance.android.livesdk.chatroom.room.business.live_ad;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final void a(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$putIfNotEmpty");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L15;
        r100.put(r101, r102);
        return;
    L15:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
