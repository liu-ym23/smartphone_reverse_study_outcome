package com.bytedance.android.ecom.bcm.track.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f51076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f51077b;

    public final JSONObject a() {
        int r100 = com.bytedance.android.ecom.bcm.track.impl.util.c.f51160a;
        int r101 = 0;
        JSONObject[] r102 = {this.f51076a, this.f51077b};
        JSONObject r103 = new JSONObject();
    L3:
        if (r101 >= 2) goto L8;
        JSONObject r104 = r102[r101];
        if (r104 == null) goto L7;
        com.bytedance.android.ecom.bcm.track.impl.util.c.a(r104, r103);
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        return r103;
    }

    public c(JSONObject r100, JSONObject r101) {
        this.f51076a = r100;
        this.f51077b = r101;
    }

    public final void b(String r100, Object r101) {
        this.f51077b.putOpt(r100, r101);
    }
}
