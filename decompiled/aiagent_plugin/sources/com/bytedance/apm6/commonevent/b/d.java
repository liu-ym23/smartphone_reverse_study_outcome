package com.bytedance.apm6.commonevent.b;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TracingData.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm6.monitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONArray f5053a;

    @Override // com.bytedance.apm6.monitor.b
    public String g() {
        return "tracing";
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return true;
    }

    public d(JSONArray r1) {
        this.f5053a = r1;
    }

    public d(JSONObject r2) {
        JSONArray r0 = new JSONArray();
        r0.put(r2);
        this.f5053a = r0;
    }

    @Override // com.bytedance.apm6.monitor.b
    public final JSONObject i() {
        return com.bytedance.apm6.util.b.a(g(), this.f5053a);
    }
}
