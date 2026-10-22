package com.ss.android.common.applog;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventVerify.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f37181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.applog.util.i f37182b;

    private g() {
        if (a.a() == false) goto L5;
        this.f37182b = new h();
        return;
    L5:
        this.f37182b = new i();
    }

    public static g a() {
        if (f37181a != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37181a != null) goto L9;
        f37181a = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f37181a;
    }

    public void a(String r1, JSONArray r2) {
        this.f37182b.putEvent(r1, r2);
    }

    public void a(String r18, String r19, String r20, long r21, long r23, long r25, long r27, JSONObject r29) {
        if (b() == true) goto L5;
        return;
    L5:
        JSONObject r10 = null;
        if (r29 != null) goto L45;
    L10:
        if (r10 != null) goto L13;
        r10 = new JSONObject();
    L13:
        if ("event_v3".equals(r18) == false) goto L15;
        JSONObject r12 = new JSONObject();
        String r14 = "event_v3";
    L47:
        if ("event_v3".equals(r18) == true) goto L19;
        r12.put("category", r18);     // Catch: JSONException -> L44
        r12.put("tag", r19);     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(r20) == true) goto L29;
        r12.put("label", r20);     // Catch: JSONException -> L44
    L29:
        if (r21 == 0) goto L32;
        r12.put("value", r21);     // Catch: JSONException -> L44
    L32:
        if (r23 == 0) goto L35;
        r12.put("ext_value", r23);     // Catch: JSONException -> L44
    L35:
        if (r25 <= 0) goto L37;
        r12.put("user_id", r25);     // Catch: JSONException -> L44
    L37:
        String r0 = a.E();     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(r0) == true) goto L40;
        r12.put("user_unique_id", r0);     // Catch: JSONException -> L44
    L40:
        r12.put("session_id", a.q());     // Catch: JSONException -> L44
        r12.put("datetime", a.a(r27));     // Catch: JSONException -> L44
        goto L41
    L19:
        if (r10.has("nt") == false) goto L21;
        r12.put("nt", r10.optInt("nt"));     // Catch: JSONException -> L44
    L21:
        r10.remove("nt");     // Catch: JSONException -> L44
        r10.remove("_event_v3");     // Catch: JSONException -> L44
        if (r10.has("ab_sdk_version") == false) goto L24;
        r12.put("ab_sdk_version", r10.optString("ab_sdk_version"));     // Catch: JSONException -> L44
        r10.remove("ab_sdk_version");     // Catch: JSONException -> L44
    L24:
        r12.put("event", r19);     // Catch: JSONException -> L44
        r12.put("params", r10);     // Catch: JSONException -> L44
        r12.put("local_time_ms", r27);     // Catch: JSONException -> L44
    L41:
        JSONArray r1 = new JSONArray();
        r1.put(r12);
        a(r14, r1);
        return;
    L15:
        r12 = r10;
        r14 = "event";
        goto L47
    L45:
        r10 = new JSONObject(r29.toString());     // Catch: JSONException -> L43
        goto L10
    }

    public boolean b() {
        return this.f37182b.isEnable();
    }
}
