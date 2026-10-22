package com.bytedance.apm6.hub;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements qu3.a<nt3.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f190823a;

    @Override // qu3.a
    public final nt3.b create() {
        this.f190823a.getClass();
        com.bytedance.apm.f r100 = com.bytedance.apm.d.f();
        if (r100 == null) goto L8;
        JSONObject r101 = r100.f190556i;
        if (r101 == null) goto L8;
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L11
        r102.put("max_size_mb_today", r101.optInt("max_size_mb_today", -1));     // Catch: JSONException -> L11
    L10:
        return new gu3.j(r102);
    L8:
        r102 = null;
        goto L10
    }

    public s(a0 r100) {
        this.f190823a = r100;
    }
}
