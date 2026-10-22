package com.bytedance.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: TracingData.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f6069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6072d;

    @Override // com.bytedance.apm.d.b
    public String b() {
        return "tracing";
    }

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return false;
    }

    public d(JSONObject r1, String r2, boolean r3, String r4) {
        this.f6069a = r1;
        this.f6070b = r2;
        this.f6071c = r3;
        this.f6072d = r4;
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
        return this.f6069a;
    }

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r2) {
        if ("app_launch_trace".equals(this.f6070b) == false) goto L7;
        return com.bytedance.apm.m.c.d("start_trace");
    L7:
        if (c.a().a(this.f6071c, this.f6070b) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return this.f6072d;
    }
}
