package com.bytedance.apm.d.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UIActionData.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f4565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f4566d;

    @Override // com.bytedance.apm.d.b
    public String b() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return true;
    }

    public f(String r1, String r2, JSONObject r3, JSONObject r4) {
        this.f4563a = r1;
        this.f4564b = r2;
        this.f4565c = r3;
        this.f4566d = r4;
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
    L7:
        return null;
    L3:
        if (this.f4566d != null) goto L5;
        this.f4566d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.f4566d.put("log_type", "ui_action");     // Catch: JSONException -> L7
        this.f4566d.put("action", this.f4563a);     // Catch: JSONException -> L7
        this.f4566d.put("page", this.f4564b);     // Catch: JSONException -> L7
        this.f4566d.put("context", this.f4565c);     // Catch: JSONException -> L7
        return this.f4566d;
    }

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r1) {
        return com.bytedance.apm.m.c.d("ui");
    }
}
