package com.bytedance.bdinstall.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ParamsMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.bdinstall.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6185d;

    public b() {
        this.f6182a = 0;
        this.f6183b = 0;
        this.f6184c = 0;
        this.f6185d = 0;
    }

    public int getType() {
        return this.f6182a;
    }

    public void a(int r1) {
        this.f6182a = r1;
    }

    public int c() {
        return this.f6183b;
    }

    public void b(int r1) {
        this.f6183b = r1;
    }

    public int d() {
        return this.f6184c;
    }

    public void c(int r1) {
        this.f6184c = r1;
    }

    public void a(long r1) {
        this.f6185d = r1;
    }

    public long e() {
        return this.f6185d;
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public void b() {
        this.f6182a = 0;
        this.f6183b = 0;
        this.f6184c = 0;
        this.f6185d = 0;
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r0.put("duration", e());     // Catch: JSONException -> L5
        r0.put("type", getType());     // Catch: JSONException -> L5
        r0.put("state", c());     // Catch: JSONException -> L5
        r0.put("flag", d());     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
