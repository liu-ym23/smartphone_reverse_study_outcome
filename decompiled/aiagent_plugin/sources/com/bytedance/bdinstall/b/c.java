package com.bytedance.bdinstall.b;

import com.bytedance.apm.battery.dao.DBHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RegisterMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.bdinstall.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6190e;
    private int f;
    private int g;
    private boolean h;

    public c() {
        this.f6186a = 0;
        this.f6187b = 0;
        this.f6188c = 0;
        this.f6189d = false;
        this.f6190e = false;
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    public boolean c() {
        return this.h;
    }

    public void setResult(boolean r1) {
        this.h = r1;
    }

    public void a(int r1) {
        this.g = r1;
    }

    public int d() {
        return this.g;
    }

    public void b(int r1) {
        this.f = r1;
    }

    public int e() {
        return this.f;
    }

    public boolean f() {
        return this.f6190e;
    }

    public void a(boolean r1) {
        this.f6190e = r1;
    }

    public boolean g() {
        return this.f6189d;
    }

    public void b(boolean r1) {
        this.f6189d = r1;
    }

    public long h() {
        return this.f6188c;
    }

    public long i() {
        return this.f6187b - this.f6186a;
    }

    public void c(int r1) {
        this.f6188c = r1;
    }

    public void j() {
        if (this.f6186a <= 0) goto L5;
        return;
    L5:
        this.f6186a = System.currentTimeMillis();
    }

    public void k() {
        if (this.f6187b <= 0) goto L5;
        return;
    L5:
        this.f6187b = System.currentTimeMillis();
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public void b() {
        this.f6186a = 0;
        this.f6187b = 0;
        this.f6188c = 0;
        this.f6189d = false;
        this.f6190e = false;
        this.h = false;
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r0.put("duration", i());     // Catch: JSONException -> L5
        r0.put("retry_count", h());     // Catch: JSONException -> L5
        r0.put("is_first", f());     // Catch: JSONException -> L5
        r0.put("did_change", g());     // Catch: JSONException -> L5
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
