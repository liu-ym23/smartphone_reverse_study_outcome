package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25801a = "ap_req";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25802b = "ap_args";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25803c = "ap_resp";

    public static com.alipay.sdk.m.g.a a() {
        return com.alipay.sdk.m.h.a.a("NP", System.currentTimeMillis(), new com.alipay.sdk.m.h.c(com.alipay.sdk.m.s.b.d().c()), (short) com.alipay.sdk.m.k.a.c.a(com.alipay.sdk.m.s.b.d().b()), new com.alipay.sdk.m.h.f());
    L5:
        return com.alipay.sdk.m.h.a.c();
    L7:
        return null;
    }

    public a() {
    }

    public static HashMap<String, String> a(com.alipay.sdk.m.s.a r110) {
        HashMap<String, String> r100 = new HashMap();
        com.alipay.sdk.m.g.a r101 = a();     // Catch: Exception -> L36
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L36
        if (r110 == null) goto L6;
        Context r103 = r110.a();     // Catch: Exception -> L36
    L7:
        if (r103 != null) goto L9;
        r103 = com.alipay.sdk.m.s.b.d().b().getApplicationContext();     // Catch: Exception -> L36
    L9:
        String r104 = n.a(r110, r103);     // Catch: Exception -> L36
        String r105 = com.alipay.sdk.m.w.b.b(r110, r103);     // Catch: Exception -> L36
        String r106 = "";
        if (r101 == null) goto L13;
        String r107 = r101.a();     // Catch: Exception -> L36
    L14:
        r102.put("ap_q", r107);     // Catch: Exception -> L36
        if (r110 == null) goto L18;
        String r108 = r110.f25772d;     // Catch: Exception -> L36
    L19:
        r102.put(com.alipay.sdk.m.s.a.f25768z, r108);     // Catch: Exception -> L36
        r102.put("u_pd", String.valueOf(n.g()));     // Catch: Exception -> L36
        r102.put("u_lk", String.valueOf(n.e(n.b())));     // Catch: Exception -> L36
        if (r110 == null) goto L28;
        String r109 = r110.f25775g;     // Catch: Exception -> L36
    L29:
        r102.put("u_pi", String.valueOf(r109));     // Catch: Exception -> L36
        r102.put("u_fu", r104);     // Catch: Exception -> L36
        r102.put("u_oi", r105);     // Catch: Exception -> L36
        r100.put(f25801a, r102.toString());     // Catch: Exception -> L36
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L36
        if (r101 == null) goto L34;
        r106 = r101.a();     // Catch: Exception -> L36
    L34:
        r111.append(r106);     // Catch: Exception -> L36
        r111.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Exception -> L36
        r111.append(r104);     // Catch: Exception -> L36
        com.alipay.sdk.m.k.a.a(r110, "biz", "ap_q", r111.toString());     // Catch: Exception -> L36
    L38:
        return r100;
    L28:
        r109 = "_";
        goto L29
    L18:
        r108 = "";
        goto L19
    L13:
        r107 = "";
        goto L14
    L6:
        r103 = null;
    L36:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r110, "biz", "APMEx1", e);
        goto L38
    }

    public static JSONObject a(com.alipay.sdk.m.s.a r100, JSONObject r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.optString(f25803c);
    L11:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", "APMEx2", e);
        return null;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return new JSONObject(r102);
    L10:
        return null;
    }

    public static void a(com.alipay.sdk.m.s.a r100, HashMap<String, String> r101) {
        JSONObject r102 = com.alipay.sdk.m.m.a.D().a();
        if (r101 == null) goto L8;
        if (r102 == null) goto L9;
        com.alipay.sdk.m.k.a.a(r100, "biz", "ap_r", r102.optString("ap_r"));
        r101.putAll(n.a(r102));
        return;
    L9:
        return;
    }

    public static void a(com.alipay.sdk.m.s.a r100, JSONObject r101, JSONObject r102) {
        if (r101 == null) goto L12;
        if (r102 == null) goto L13;
        r101.putOpt(f25802b, r102);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", "APMEx2", e);
        return;
    L13:
        return;
    }
}
