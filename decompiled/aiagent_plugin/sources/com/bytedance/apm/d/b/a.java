package com.bytedance.apm.d.b;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApiData.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4545e;
    public String f;
    public int g;
    public JSONObject h;

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.apm.d.b
    public String b() {
        return null;
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return null;
    }

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return true;
    }

    public a(String r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
        this.f4541a = r1;
        this.f4542b = r2;
        this.f4543c = r4;
        this.f4544d = r6;
        this.f4545e = r7;
        this.f = r8;
        this.g = r9;
        if (r10 != null) goto L5;
        this.h = new JSONObject();
        return;
    L5:
        this.h = r10;
    }

    public void a(boolean r3) {
        if (this.h.isNull(DBHelper.COL_FRONT) == false) goto L6;
        this.h.put(DBHelper.COL_FRONT, r3 ? 1 : 0);
        return;
    }

    public void a(String r3) {
        if (this.h.isNull("net_consume_type") == false) goto L6;
        this.h.put("net_consume_type", r3);
        return;
    }

    public void e() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("trace_base", com.bytedance.apm.c.u());     // Catch: JSONException -> L4
        this.h.put("relate_start_trace", r0);     // Catch: JSONException -> L4
        return;
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
        if (TextUtils.isEmpty(this.f4541a) == false) goto L18;
        return null;
    L18:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L17
        r0.put("log_type", this.f4541a);     // Catch: Exception -> L17
        r0.put("duration", this.f4542b);     // Catch: Exception -> L17
        r0.put("uri", Uri.parse(this.f4544d));     // Catch: Exception -> L17
        long r2 = this.f4543c;     // Catch: Exception -> L17
        if (r2 <= 0) goto L8;
        r0.put(DBHelper.COL_TIME, r2);     // Catch: Exception -> L17
    L8:
        r0.put("status", this.g);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(this.f4545e) == true) goto L13;
        r0.put("ip", this.f4545e);     // Catch: Exception -> L17
    L13:
        if (TextUtils.isEmpty(this.f) == true) goto L15;
        r0.put("trace_code", this.f);     // Catch: Exception -> L17
    L16:
        return r0;
    L15:
        r0.put("trace_code", "");     // Catch: Exception -> L17
    L17:
        return null;
    }
}
