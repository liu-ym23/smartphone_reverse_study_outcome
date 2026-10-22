package com.bytedance.applog.priority;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventPriorityLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5950a = null;

    static {
        f5950a = Collections.singletonList("EventPriorityLoader");
    }

    public static void a(com.bytedance.applog.c r8, com.bytedance.applog.j.b r9, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("priority_list");
        if (r11 != null) goto L16;
        return;
    L16:
        a r5 = new a();     // Catch: Throwable -> L13
        boolean r7 = true;
        if (r11.optInt("prefer_batch_event_interval", 0) == 1) goto L9;
        r7 = false;
    L9:
        r5.f5844e = r7;     // Catch: Throwable -> L13
        r5.f5840a = r11.optInt("priority_version", 0);     // Catch: Throwable -> L13
        r5.f5841b = r11.optInt("base_interval", 5);     // Catch: Throwable -> L13
        JSONArray r12 = r11.optJSONArray("priorities");     // Catch: Throwable -> L13
        a(r8, r9, r5, r12);     // Catch: Throwable -> L13
        if (r5.d() == false) goto L19;
        r9.a(r5);     // Catch: Throwable -> L13
        SharedPreferences.Editor r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(a(r8), 0).edit();     // Catch: Throwable -> L13
        r13.putInt("priority_version", r5.f5840a);     // Catch: Throwable -> L13
        r13.putInt("base_interval", r5.f5841b);     // Catch: Throwable -> L13
        r13.putString("priorities", r12.toString());     // Catch: Throwable -> L13
        r13.apply();     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        r8.Z().a(f5950a, "parseEventPriorityFromServer", th, new Object[0]);
    }

    public static a a(com.bytedance.applog.c r6, com.bytedance.applog.j.b r7) {
        SharedPreferences r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(a(r6), 0);
        int r1 = r0.getInt("priority_version", -1);
        if (r1 != (-1)) goto L5;
        return null;
    L5:
        a r3 = new a();
        r3.f5840a = r1;
        r3.f5841b = r0.getInt("base_interval", 5);
        String r2 = r0.getString("priorities", null);
        if (TextUtils.isEmpty(r2) == false) goto L12;
    L11:
        return r3;
    L12:
        a(r6, r7, r3, new JSONArray(r2));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        r6.Z().a(f5950a, "parseEventPriorityFromLocal failed", e, new Object[0]);
        goto L11
    }

    private static void a(com.bytedance.applog.c r19, com.bytedance.applog.j.b r20, a r21, JSONArray r22) {
        JSONArray r1 = r22;
        HashMap r2 = new HashMap();
        r21.f5843d = new HashMap();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r22.length() <= 0) goto L147;
        r21.a(r22);
        int r4 = 0;
    L112:
        if (r4 >= r22.length()) goto L98;
        JSONObject r5 = r1.optJSONObject(r4);     // Catch: Throwable -> L106
        if (r5 == null) goto L97;
        b r7 = new b();     // Catch: Throwable -> L106
        r7.f5945a = r5.optInt("priority");     // Catch: Throwable -> L106
        if (r7.f5945a <= r21.f5842c) goto L15;
        r21.f5842c = r7.f5945a;     // Catch: Throwable -> L106
    L15:
        r7.f5947c = r21.f5840a;     // Catch: Throwable -> L106
        r7.f5948d = r5.optInt("interval_multiple");     // Catch: Throwable -> L106
        if (r7.f5948d > 0) goto L18;
        r7.f5948d = 1;     // Catch: Throwable -> L106
    L18:
        r7.f5949e = ((long) (r21.f5841b * r7.f5948d)) * 1000;     // Catch: Throwable -> L106
        r7.l = new com.bytedance.applog.m.a(r19, r20, r7.f5949e);     // Catch: Throwable -> L104
        r7.h = r5.optString("report_host");     // Catch: Throwable -> L104
        r7.i = r5.optString("report_path");     // Catch: Throwable -> L104
        JSONArray r8 = r5.optJSONArray("events");     // Catch: Throwable -> L104
        if (r8 != null) goto L23;
    L31:
        JSONObject r9 = r5.optJSONObject("param_keys");     // Catch: Throwable -> L104
        if (r9 == null) goto L63;
        r7.f = new HashMap();     // Catch: Throwable -> L104
        Iterator<String> r10 = r9.keys();     // Catch: Throwable -> L104
    L35:
        if (r10.hasNext() == false) goto L63;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r11) == true) goto L35;
        JSONArray r13 = r9.optJSONArray(r11);     // Catch: Throwable -> L104
        if (r13 != null) goto L42;
    L61:
        JSONObject r16 = r9;
        Iterator<String> r17 = r10;
    L62:
        r9 = r16;
        r10 = r17;
        goto L35
    L42:
        if (r13.length() <= 0) goto L61;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L104
        int r15 = 0;
    L45:
        if (r15 >= r13.length()) goto L60;
        JSONArray r3 = r13.optJSONArray(r15);     // Catch: Throwable -> L104
        if (r3 == null) goto L59;
        if (r3.length() <= 0) goto L59;
        HashSet r6 = new HashSet();     // Catch: Throwable -> L104
        int r12 = 0;
    L52:
        if (r12 >= r3.length()) goto L57;
        String r18 = r3.optString(r12);     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r18) == true) goto L56;
        r6.add(r18);     // Catch: Throwable -> L104
    L56:
        r12 = r12 + 1;     // Catch: Throwable -> L104
        goto L52
    L57:
        r14.add(r6);     // Catch: Throwable -> L104
    L59:
        r15 = r15 + 1;     // Catch: Throwable -> L104
        r9 = r9;
        r10 = r10;
        goto L45
    L60:
        r16 = r9;
        r17 = r10;
        r7.f.put(r11, r14);     // Catch: Throwable -> L104
    L63:
        JSONObject r23 = r5.optJSONObject("param_key_values");     // Catch: Throwable -> L104
        if (r23 == null) goto L95;
        r7.g = new HashMap();     // Catch: Throwable -> L104
        Iterator<String> r24 = r23.keys();     // Catch: Throwable -> L104
    L67:
        if (r24.hasNext() == false) goto L95;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r25) == true) goto L67;
        JSONArray r26 = r23.optJSONArray(r25);     // Catch: Throwable -> L104
        if (r26 != null) goto L74;
    L93:
        JSONObject r110 = r23;
        Iterator<String> r111 = r24;
    L94:
        r23 = r110;
        r24 = r111;
        goto L67
    L74:
        if (r26.length() <= 0) goto L93;
        ArrayList r27 = new ArrayList();     // Catch: Throwable -> L104
        int r112 = 0;
    L77:
        if (r112 >= r26.length()) goto L92;
        JSONObject r113 = r26.optJSONObject(r112);     // Catch: Throwable -> L104
        if (r113 == null) goto L90;
        HashMap r114 = new HashMap();     // Catch: Throwable -> L104
        Iterator<String> r115 = r113.keys();     // Catch: Throwable -> L104
    L82:
        if (r115.hasNext() == false) goto L89;
        JSONObject r116 = r23;
        Iterator<String> r117 = r24;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r115.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r28) == true) goto L88;
        Object r29 = r113.opt(r28);     // Catch: Throwable -> L104
        if (r29 == null) goto L88;
        r114.put(r28, r29);     // Catch: Throwable -> L104
    L88:
        r23 = r116;
        r24 = r117;
        goto L82
    L89:
        JSONObject r118 = r23;
        Iterator<String> r119 = r24;
        r27.add(r114);     // Catch: Throwable -> L104
    L91:
        r112 = r112 + 1;     // Catch: Throwable -> L104
        r23 = r118;
        r24 = r119;
        goto L77
    L90:
        r118 = r23;
        r119 = r24;
        goto L91
    L92:
        r110 = r23;
        r111 = r24;
        r7.g.put(r25, r27);     // Catch: Throwable -> L104
    L95:
        r2.put(Integer.valueOf(r7.f5945a), r7);     // Catch: Throwable -> L104
        goto L97
    L23:
        if (r8.length() <= 0) goto L31;
        int r30 = 0;
    L26:
        if (r30 >= r8.length()) goto L31;
        String r120 = r8.optString(r30);     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r120) == true) goto L30;
        r21.f5843d.put(r120, Integer.valueOf(r7.f5945a));     // Catch: Throwable -> L104
    L30:
        r30 = r30 + 1;     // Catch: Throwable -> L104
    L104:
        th = th;
    L108:
        r19.Z().a(f5950a, "parsePriorityMapFromJsonArray failed", th, new Object[0]);
        return;
    L97:
        r4 = r4 + 1;     // Catch: Throwable -> L104
        r1 = r22;
        goto L112
    L98:
        Iterator<b> r31 = r2.values().iterator();     // Catch: Throwable -> L104
    L100:
        if (r31.hasNext() == false) goto L102;
        b r32 = (b) ZeusTransformUtils.preCheckCast(r31.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L104
        r32.f5946b = r21.f5842c;     // Catch: Throwable -> L104
        goto L100
    L102:
        r21.a(r2);     // Catch: Throwable -> L104
        return;
    L106:
        th = th;
        goto L108
    }

    public static void a(JSONObject r6, a r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        JSONArray r8 = r6.optJSONArray("priority_request_config");
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.length() <= 0) goto L22;
        int r0 = 0;
    L10:
        if (r0 >= r8.length()) goto L23;
        JSONObject r1 = r8.optJSONObject(r0);
        if (r1 == null) goto L16;
        b r2 = r7.a(r1.optInt("priority"));
        if (r2 == null) goto L16;
        r2.l.a(r1, r2.c(), r2);
    L16:
        r0 = r0 + 1;
        goto L10
    L23:
        return;
    }

    private static String a(com.bytedance.applog.c r1) {
        return com.bytedance.applog.b.a(r1, "priority_list");
    }
}
