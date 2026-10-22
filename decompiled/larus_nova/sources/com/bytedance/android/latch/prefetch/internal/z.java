package com.bytedance.android.latch.prefetch.internal;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class z {
    public static final String a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (g0.c(r100) == false) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return JSONObjectProtectorUtils.getString(r100, "__callback_id");
    L5:
        JSONObject r102 = r100.optJSONObject(r101);
        if (r102 != null) goto L11;
        return null;
    L11:
        return a(r102, r101);
    }
}
