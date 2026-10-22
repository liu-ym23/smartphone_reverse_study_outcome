package com.c.a.c;

import android.text.TextUtils;
import com.bytedance.apm.h.e;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudMessage.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private long f11895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f11897e;
    private String f;

    public a() {
    }

    public String a() {
        return this.f11893a;
    }

    public static a a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return null;
    L15:
        a r0 = new a();     // Catch: Exception -> L10
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L10
        r0.f11896d = r2.optString("command_id");     // Catch: Exception -> L10
        r0.f11894b = r2.optString("type");     // Catch: Exception -> L10
        String r3 = r2.optString("params");     // Catch: Exception -> L10
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r4 = new JSONObject(r3);     // Catch: Exception -> L10
    L8:
        r0.f11893a = r3;     // Catch: Exception -> L10
        r0.f11897e = r4;     // Catch: Exception -> L10
        r0.f = r5;     // Catch: Exception -> L10
        return r0;
    L10:
        e = move-exception;
        if (com.bytedance.apm.c.i() == false) goto L14;
        e.a("cloudmessage", e, new String[]{"Parse CloudMessage Error."});
    L14:
        return null;
    }

    public JSONObject b() {
        return this.f11897e;
    }

    public boolean c() {
        return this.f11897e.optBoolean("wifiOnly");
    }

    public String getType() {
        return this.f11894b;
    }

    public String d() {
        return this.f11896d;
    }

    public String toString() {
        return "CloudMessage{mParams='" + this.f11893a + "', mType=" + this.f11894b + ", send_time=" + this.f11895c + ", command_id='" + this.f11896d + "'}";
    }
}
