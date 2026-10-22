package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.common.applog.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DrHelperWithRegion.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    static void a(Context r7, com.ss.android.deviceregister.a.d r8, JSONObject r9, boolean r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (r11 == true) goto L84;
        SharedPreferences r13 = b.a(r12);
        if (com.ss.android.deviceregister.g.t() == null) goto L7;
        String r2 = com.ss.android.deviceregister.g.t().a();
    L8:
        int r3 = 0;
        String r4 = r13.getString(SensitiveType.MAC, null);     // Catch: JSONException -> L29
        boolean r6 = true;
        if (com.bytedance.common.utility.j.a(r4) == false) goto L15;
        if (com.bytedance.common.utility.j.a(r2) == false) goto L22;
    L20:
        r6 = false;
    L22:
        if (com.bytedance.common.utility.j.a(r2) == false) goto L24;
    L26:
        if (r6 == false) goto L31;
        SharedPreferences.Editor r14 = r13.edit();     // Catch: JSONException -> L29
        r14.putString(SensitiveType.MAC, r2);     // Catch: JSONException -> L29
        r14.commit();     // Catch: JSONException -> L29
    L31:
        if (r8 == null) goto L58;
        String r15 = r8.a();     // Catch: JSONException -> L55
        if (com.bytedance.common.utility.j.a(r15) == true) goto L35;
        r9.put("udid", r15);     // Catch: JSONException -> L55
    L35:
        JSONArray r16 = r8.b();     // Catch: JSONException -> L55
        if (com.ss.android.deviceregister.c.c.a(r16) == false) goto L38;
        r9.put("udid_list", r16);     // Catch: JSONException -> L55
    L38:
        String r17 = r8.d();     // Catch: JSONException -> L55
        if (com.bytedance.common.utility.j.a(r17) == true) goto L41;
        r9.put("serial_number", r17);     // Catch: JSONException -> L55
    L41:
        if (r10 == false) goto L58;
        String[] r18 = r8.c();     // Catch: JSONException -> L55
        if (r18 == null) goto L58;
        JSONArray r19 = new JSONArray();     // Catch: JSONException -> L55
        int r110 = r18.length;     // Catch: JSONException -> L55
    L46:
        if (r3 >= r110) goto L53;
        r19.put(new JSONObject().put("sim_serial_number", r18[r3]));     // Catch: JSONException -> L50
    L52:
        r3 = r3 + 1;     // Catch: JSONException -> L55
    L50:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L55
        goto L52
    L53:
        r9.put("sim_serial_number", r19);     // Catch: JSONException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L58:
        if (com.ss.android.deviceregister.g.b(r12) == true) goto L84;
        String r20 = com.ss.android.deviceregister.c.c.a(r12);     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r20) == true) goto L84;
        r9.put("build_serial", r20);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        e.printStackTrace();
        goto L84
    L24:
        if (com.ss.android.deviceregister.g.b(r12) == true) goto L26;
        r9.put("mc", r2);     // Catch: JSONException -> L29
        goto L26
    L15:
        if (com.bytedance.common.utility.j.a(r2) == false) goto L18;
        r6 = false;
        r2 = r4;
        goto L22
    L18:
        if (r4.equals(r2) == true) goto L20;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L7:
        r2 = com.ss.android.deviceregister.c.c.j(r12);
    L84:
    L69:
        e = move-exception;
        e.printStackTrace();
    L82:
        Map<String, String> r21 = n.a(r12).a(com.ss.android.deviceregister.g.q().a());     // Catch: Throwable -> L75
        a("ARegistrationHeader", "getOaid: returned=" + r21);     // Catch: Throwable -> L75
        if (r21 == null) goto L90;
        r9.put("oaid", new JSONObject(r21));     // Catch: Throwable -> L75
    L90:
        boolean r22 = n.a(r12).b();     // Catch: Throwable -> L79
        a("ARegistrationHeader", "maySupport: returned=" + r22);     // Catch: Throwable -> L79
        r9.put("oaid_may_support", r22);     // Catch: Throwable -> L79
        return;
    L79:
        th = move-exception;
        th.printStackTrace();
        return;
    L75:
        th = move-exception;
        th.printStackTrace();
        goto L90
    L66:
        if (com.bytedance.common.utility.j.a(y.a()) == true) goto L82;
        r9.put("aliyun_uuid", y.a());     // Catch: Exception -> L69
        goto L82
    }

    static String a(Bundle r1) {
        return r1.getString("UMENG_CHANNEL");
    }

    public static void a(JSONObject r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (v.f() == true) goto L13;
        r1.remove("sim_serial_number");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void a(Context r2) {
        t.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).a();
    }

    public static void a(Context r2, com.ss.android.common.a r3, Map<String, String> r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.ss.android.common.a r7 = (com.ss.android.common.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.common.a.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5 == true) goto L9;
        if (com.ss.android.deviceregister.g.q().b() == false) goto L23;
        t.a(r6).a();
        return;
    L23:
        return;
    L9:
        if (com.ss.android.deviceregister.g.f() == true) goto L13;
        String r9 = r7.f();
        if (y.a(r9) == true) goto L13;
        r8.put("uuid", r9);
    L13:
        if (r5 == false) goto L24;
        String r10 = n.a(r6).a();     // Catch: Throwable -> L18
        if (r10 == null) goto L25;
        r8.put("oaid", r10);     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void a(Context r5, StringBuilder r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (com.ss.android.deviceregister.g.f() == false) goto L5;
        return;
    L5:
        String[] r0 = com.ss.android.deviceregister.c.c.b(r7);
        if (r0 != null) goto L8;
    L14:
        a(r6, "build_serial", com.ss.android.deviceregister.c.c.a(r7), true);
        return;
    L8:
        if (r0.length <= 0) goto L14;
        String r2 = r0[0];
        int r3 = 1;
    L11:
        if (r3 >= r0.length) goto L13;
        r2 = r2 + "," + r0[r3];
        r3 = r3 + 1;
        goto L11
    L13:
        a(r6, "sim_serial_number", r2, true);
        goto L14
    }

    private static void a(StringBuilder r2, String r3, String r4, boolean r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        r2.append("?");
    L12:
        StringBuilder r6 = r2.append(r3).append("=");
        if (r5 == false) goto L15;
        r4 = Uri.encode(r4);
    L15:
        r6.append(r4);
        return;
    L11:
        r2.append("&");
        goto L12
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
