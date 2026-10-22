package com.bytedance.apm6.commonevent.b;

import android.text.TextUtils;
import com.bytedance.apm6.util.e;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonEvent.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements com.bytedance.apm6.monitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f5046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f5047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f5048e;
    private JSONObject f;

    @Override // com.bytedance.apm6.monitor.b
    public String g() {
        return "service_monitor";
    }

    public a(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f5044a = r1;
        this.f5045b = r2;
        this.f5046c = r3;
        this.f5047d = r4;
        this.f5048e = r5;
        this.f = r6;
    }

    public String a() {
        return this.f5044a;
    }

    public int b() {
        return this.f5045b;
    }

    public JSONObject c() {
        return this.f5046c;
    }

    public JSONObject d() {
        return this.f5047d;
    }

    public JSONObject e() {
        return this.f5048e;
    }

    public JSONObject f() {
        return this.f;
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return !TextUtils.isEmpty(this.f5044a);
    }

    @Override // com.bytedance.apm6.monitor.b
    public JSONObject i() {
        JSONObject r0 = f();     // Catch: Exception -> L15
        if (r0 != null) goto L5;
        r0 = new JSONObject();     // Catch: Exception -> L15
    L5:
        r0.put("log_type", "service_monitor");     // Catch: Exception -> L15
        r0.put(WsConstants.KEY_SERVICE, a());     // Catch: Exception -> L15
        r0.put("status", b());     // Catch: Exception -> L15
        if (c() == null) goto L9;
        r0.put("value", c());     // Catch: Exception -> L15
    L9:
        if (d() == null) goto L12;
        r0.put("category", d());     // Catch: Exception -> L15
    L12:
        if (e() == null) goto L14;
        r0.put("metric", e());     // Catch: Exception -> L15
    L14:
        return r0;
    L15:
        e = move-exception;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L23;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "toJsonObject Error.", e);
        return null;
    L23:
        return null;
    }

    public void j() {
        this.f5046c = e.b(this.f5046c);
        this.f5047d = e.b(this.f5047d);
        this.f5048e = e.b(this.f5048e);
        this.f = e.b(this.f);
    }

    public String toString() {
        return "CommonEvent{serviceName='" + this.f5044a + "'}";
    }
}
