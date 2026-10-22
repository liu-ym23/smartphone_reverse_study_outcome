package com.bytedance.bdturing.b;

import com.bytedance.bdturing.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsCallParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f6520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f6521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f6522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f6523e;
    b f;

    c(b r2, String r3) {
        this.f6520b = null;
        this.f6521c = null;
        this.f6522d = null;
        this.f6523e = null;
        this.f = r2;
        a(r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        g.a(e);
    }

    private void a(String r2) {
        JSONObject r0 = new JSONObject(r2);
        this.f6519a = r0.getInt("JSSDK");
        this.f6520b = r0.getString("func");
        this.f6521c = r0.getString("params");
        this.f6522d = r0.getString("__msg_type");
        this.f6523e = r0.getString("__callback_id");
    }

    public void a(int r3, JSONObject r4) {
        b r0 = this.f;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.a(a(r3, "callback", r4, this).toString());     // Catch: JSONException -> L7
        return;
    }

    public static JSONObject a(int r2, String r3, JSONObject r4, c r5) {
        JSONObject r0 = new JSONObject();
        r0.put(MonitorConstants.CODE, r2);
        r0.put("func", r5.f6520b);
        r0.put("__msg_type", r3);
        Object r6 = r4;
        if (r4 != null) goto L5;
        r6 = "{}";
    L5:
        r0.put("data", r6);
        JSONObject r7 = new JSONObject();
        r7.put("__params", r0);
        r7.put("__callback_id", r5.f6523e);
        return r7;
    }

    public static String a(int r2, String r3, String r4, JSONObject r5, String r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(MonitorConstants.CODE, r2);     // Catch: JSONException -> L4
        r0.put("func", r3);     // Catch: JSONException -> L4
        r0.put("__msg_type", r4);     // Catch: JSONException -> L4
        r0.put("data", r5);     // Catch: JSONException -> L4
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L4
        r7.put("__params", r0);     // Catch: JSONException -> L4
        r7.put("__callback_id", r6);     // Catch: JSONException -> L4
        return r7.toString();
    L4:
        e = move-exception;
        g.a(e);
        return null;
    }
}
