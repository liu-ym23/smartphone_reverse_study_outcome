package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class i1 {
    public i1() {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default(r100, "app_data", false, 2, null) == false) goto L8;
    L15:
        return true;
    L8:
        if (StringsKt.contains$default(r100, "TTLiveSDK_Android", false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r100, "TTLiveSDK_IOS", false, 2, null) == true) goto L15;
        LiveSeiUtil.f71508i.getClass();
        if (LiveSeiUtil.d(r100) == true) goto L15;
        if (StringsKt.contains$default(r100, "TTLiveSDK_Windows", false, 2, null) == true) goto L15;
        return false;
    }
}
