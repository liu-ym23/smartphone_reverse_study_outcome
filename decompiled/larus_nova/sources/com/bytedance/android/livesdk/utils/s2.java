package com.bytedance.android.livesdk.utils;

import com.bytedance.android.ec.slice.SliceInitService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class s2 {
    public static final JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJsonObject");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100 = SliceInitService.DEFAULT_SWITCH;
    L9:
        return new JSONObject(r100);
    L5:
        r101 = false;
        goto L6
    }
}
