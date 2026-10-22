package com.bytedance.android.btm.api.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f42056b;

    public h(j r100) {
        String r101 = r100.a();
        if (r101 != null) goto L6;
        r101 = "null";
    L6:
        this.f42055a = r101;
        this.f42056b = r100.f42064h;
    }
}
