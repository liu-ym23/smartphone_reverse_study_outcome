package com.bytedance.android.live.schema.helper;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static String a(Map<String, String> r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        return (String) ((HashMap) r100).get(r101);
    L8:
        th = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        return null;
    L15:
        return null;
    }

    public static int b(String r100, int r101) {
        return Color.parseColor(r100);
    L4:
        th = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        return r101;
    }
}
