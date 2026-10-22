package com.bytedance.android.btm.api.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42068a;

    public n() {
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("reuse", this.f42068a);     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }
}
