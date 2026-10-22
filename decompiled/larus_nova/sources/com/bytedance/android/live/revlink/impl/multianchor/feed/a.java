package com.bytedance.android.live.revlink.impl.multianchor.feed;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public a() {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default(r100, "app_data", false, 2, null) == false) goto L8;
    L13:
        return true;
    L8:
        if (StringsKt.contains$default(r100, "TTLiveSDK_Android", false, 2, null) == true) goto L13;
        if (StringsKt.contains$default(r100, "TTLiveSDK_IOS", false, 2, null) == true) goto L13;
        if (StringsKt.contains$default(r100, "TTLiveSDK_Windows", false, 2, null) == true) goto L13;
        return false;
    }
}
