package com.bytedance.dataplatform.a;

import com.bytedance.dataplatform.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f7899a;

    public static void a(String r0, String r1) {
    }

    static /* synthetic */ c a() {
        return f7899a;
    }

    static {
        f7899a = new b();
    }

    public static void a(final String r1, final JSONObject r2) {
        m.a(new AnonymousClass1(r1, r2));
    }

    public static void a(String r3, Integer r4) {
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "abtest_ab_sdk");     // Catch: JSONException -> L5
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L5
        r1.put(r3, r4);     // Catch: JSONException -> L5
        r0.put("client_layer_info", r1);     // Catch: JSONException -> L5
    L7:
        a("local_strategy", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
