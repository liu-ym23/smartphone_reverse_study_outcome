package com.bytedance.android.livesdk.utils;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c3 {
    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r102.put("log_extra", r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r102.put("creativeID", r101);
    L9:
        return r102.toString();
    }
}
