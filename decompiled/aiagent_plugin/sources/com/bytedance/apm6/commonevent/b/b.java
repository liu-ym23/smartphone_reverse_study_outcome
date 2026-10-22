package com.bytedance.apm6.commonevent.b;

import android.text.TextUtils;
import com.bytedance.apm6.util.e;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bytedance.apm6.monitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f5050b;

    public b(String r1, JSONObject r2) {
        this.f5049a = r1;
        this.f5050b = r2;
    }

    @Override // com.bytedance.apm6.monitor.b
    public String g() {
        return this.f5049a;
    }

    public JSONObject a() {
        return this.f5050b;
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return !TextUtils.isEmpty(this.f5049a);
    }

    @Override // com.bytedance.apm6.monitor.b
    public JSONObject i() {
        JSONObject r0 = a();     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        r0 = new JSONObject();     // Catch: Exception -> L7
    L5:
        r0.put("log_type", g());     // Catch: Exception -> L7
        return r0;
    L7:
        e = move-exception;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L15;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "toJsonObject Error.", e);
        return null;
    L15:
        return null;
    }

    public void b() {
        this.f5050b = e.b(this.f5050b);
    }

    public String toString() {
        return "CommonLog{logType='" + this.f5049a + "'}";
    }
}
