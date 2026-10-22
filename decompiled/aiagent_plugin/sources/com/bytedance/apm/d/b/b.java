package com.bytedance.apm.d.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonLogData.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f4547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4548c;

    @Override // com.bytedance.apm.d.b
    public String b() {
        return "common_log";
    }

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return true;
    }

    public b(String r1, JSONObject r2, boolean r3) {
        this.f4546a = r1;
        this.f4547b = r2;
        this.f4548c = r3;
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
        JSONObject r0 = this.f4547b;
        if (r0 != null) goto L10;
        return null;
    L10:
        r0.put("log_type", this.f4546a);     // Catch: JSONException -> L9
    L6:
        return this.f4547b;
    }

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r1) {
        return com.bytedance.apm.m.c.a(this.f4546a);
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return this.f4546a;
    }
}
