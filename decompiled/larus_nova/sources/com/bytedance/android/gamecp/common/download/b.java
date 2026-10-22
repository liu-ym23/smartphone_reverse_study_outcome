package com.bytedance.android.gamecp.common.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    static {
    }

    public static boolean a(JSONObject r100) {
        if (r100 == null) goto L6;
        JSONObject r101 = r100.optJSONObject("download_info");
        if (r101 == null) goto L6;
        JSONObject r102 = r101.optJSONObject("ad_info");
    L7:
        if (r102 == null) goto L9;
        return true;
    L9:
        return false;
    L6:
        r102 = null;
        goto L7
    }
}
