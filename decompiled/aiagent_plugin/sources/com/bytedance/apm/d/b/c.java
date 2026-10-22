package com.bytedance.apm.d.b;

import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventData.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f4551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f4552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f4553e;
    public JSONObject f;
    public boolean g;

    @Override // com.bytedance.apm.d.b
    public String b() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return true;
    }

    public c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f4549a = r1;
        this.f4550b = r2;
        this.f4551c = r3;
        this.f4552d = r4;
        this.f4553e = r5;
        this.f = r6;
    }

    public c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6, boolean r7) {
        this.f4549a = r1;
        this.f4550b = r2;
        this.f4551c = r3;
        this.f4552d = r4;
        this.f4553e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
        if (this.f != null) goto L18;
        this.f = new JSONObject();
    L18:
        this.f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f.put(WsConstants.KEY_SERVICE, this.f4549a);     // Catch: JSONException -> L16
        this.f.put("status", this.f4550b);     // Catch: JSONException -> L16
        JSONObject r0 = this.f4551c;     // Catch: JSONException -> L16
        if (r0 == null) goto L8;
        this.f.put("value", r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = this.f4552d;     // Catch: JSONException -> L16
        if (r1 == null) goto L11;
        this.f.put("category", r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = this.f4553e;     // Catch: JSONException -> L16
        if (r2 == null) goto L14;
        this.f.put("metric", r2);     // Catch: JSONException -> L16
    L14:
        return this.f;
    L16:
        return null;
    }

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r1) {
        return com.bytedance.apm.m.c.b(this.f4549a);
    }
}
