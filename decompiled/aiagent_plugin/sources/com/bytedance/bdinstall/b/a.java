package com.bytedance.bdinstall.b;

import com.bytedance.apm.battery.dao.DBHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivateMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.bdinstall.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6181e;
    private int f;
    private boolean g;

    public a() {
        this.f6177a = 0;
        this.f6178b = 0;
        this.f6179c = 0;
        this.f6180d = false;
        this.f6181e = 0;
        this.f = 0;
        this.g = false;
    }

    public boolean c() {
        return this.g;
    }

    public void setResult(boolean r1) {
        this.g = r1;
    }

    public void a(int r1) {
        this.f = r1;
    }

    public int d() {
        return this.f;
    }

    public void b(int r1) {
        this.f6181e = r1;
    }

    public int e() {
        return this.f6181e;
    }

    public boolean f() {
        return this.f6180d;
    }

    public void a(boolean r1) {
        this.f6180d = r1;
    }

    public void g() {
        if (this.f6177a <= 0) goto L5;
        return;
    L5:
        this.f6177a = System.currentTimeMillis();
    }

    public void h() {
        if (this.f6178b <= 0) goto L5;
        return;
    L5:
        this.f6178b = System.currentTimeMillis();
    }

    public long i() {
        return this.f6178b - this.f6177a;
    }

    public long j() {
        return this.f6179c;
    }

    public void a(long r1) {
        this.f6179c = r1;
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public void b() {
        this.f6177a = 0;
        this.f6178b = 0;
        this.f6179c = 0;
        this.f6180d = false;
        this.g = false;
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r0.put("duration", i());     // Catch: JSONException -> L5
        r0.put("retry_count", j());     // Catch: JSONException -> L5
        r0.put("is_first", f());     // Catch: JSONException -> L5
        r0.put("is_new_user_mode", e());     // Catch: JSONException -> L5
        r0.put(DBHelper.BATTERY_COL_SCENE, d());     // Catch: JSONException -> L5
        r0.put("result", c());     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
