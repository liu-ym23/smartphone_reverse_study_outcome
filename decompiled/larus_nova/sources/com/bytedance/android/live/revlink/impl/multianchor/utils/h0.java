package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class h0 {
    public h0() {
    }

    public static JSONObject a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "seiJson");
        if (r100.has("app_data") == false) goto L7;
        String r101 = JSONObjectProtectorUtils.getString(r100, "app_data");     // Catch: Throwable -> L9
        return new JSONObject(new Regex("\\\\").replace(r101, ""));
    L7:
        return null;
    L12:
        return null;
    }

    public static JSONObject b(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 != true) goto L25;
        JSONObject r102 = LiveSeiUtil.a(r100);     // Catch: Throwable -> L19
        if (r102.has("info") == true) goto L12;
        return r102;
    L12:
        if (r102.has("source") == true) goto L14;
        return r102;
    L14:
        if (Intrinsics.areEqual(r102.optString("source"), "zego") == false) goto L24;
        return JSONObjectProtectorUtils.getJSONObject(r102, "info");
    L24:
        return r102;
    L26:
        return null;
    L25:
        return null;
    L7:
        r101 = false;
        goto L8
    }
}
