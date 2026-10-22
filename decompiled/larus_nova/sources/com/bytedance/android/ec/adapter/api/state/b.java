package com.bytedance.android.ec.adapter.api.state;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final JSONObject a(a r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        r101.put("roomID", r100.f42691f);
        r101.put("roomAnchorID", r100.f42692g);
        r101.put("roomAnchorSecID", r100.f42693h);
        r101.put("isAnchor", r100.f42688c);
        r101.put("isFollowed", r100.f42694i);
        r101.put("ecomLiveParams", new JSONObject(r100.f42701p));
        r101.put("reportParams", new JSONObject(r100.f42698m));
    L5:
        return r101;
    }
}
