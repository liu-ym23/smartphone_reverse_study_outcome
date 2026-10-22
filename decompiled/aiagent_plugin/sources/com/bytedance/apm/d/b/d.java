package com.bytedance.apm.d.b;

import com.bytedance.apm.battery.dao.DBHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExceptionLogData.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f4555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4557d;

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return true;
    }

    public d(String r3, JSONObject r4) {
        this(r3, r4, System.currentTimeMillis());
    }

    public d(String r1, JSONObject r2, long r3) {
        this.f4554a = r1;
        this.f4555b = r2;
        this.f4557d = r3;
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
        JSONObject r0 = this.f4555b;
        if (r0 != null) goto L17;
        return null;
    L17:
        r0.put(DBHelper.COL_TIME, this.f4557d);     // Catch: JSONException -> L15
        this.f4555b.put("crash_time", this.f4557d);     // Catch: JSONException -> L15
        this.f4555b.put("is_main_process", com.bytedance.apm.c.d());     // Catch: JSONException -> L15
        this.f4555b.put("process_name", com.bytedance.apm.c.c());     // Catch: JSONException -> L15
        this.f4555b.put("log_type", this.f4554a);     // Catch: JSONException -> L15
        if (com.bytedance.apm.c.u() <= com.bytedance.apm.c.g()) goto L8;
    L10:
        this.f4555b.put("app_launch_start_time", com.bytedance.apm.c.g());     // Catch: JSONException -> L15
    L16:
        goto L12
    L8:
        if (com.bytedance.apm.c.u() == 0) goto L10;
        this.f4555b.put("app_launch_start_time", com.bytedance.apm.c.u());     // Catch: JSONException -> L15
    L12:
        return this.f4555b;
    }

    public void e() {
        this.f4556c = true;
    }

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r1) {
        if (this.f4556c == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.apm.m.c.e(this.f4554a) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.apm.d.b
    public String b() {
        return this.f4554a;
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return this.f4554a;
    }

    public long f() {
        return this.f4557d;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.f4554a + "', logJson=" + this.f4555b + ", forceSampled=" + this.f4556c + ", time=" + this.f4557d + '}';
    }
}
