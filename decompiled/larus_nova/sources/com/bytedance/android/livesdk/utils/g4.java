package com.bytedance.android.livesdk.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g4 {
    public static String c() {
        return f("action_type");
    }

    public static String e() {
        return f("enter_method");
    }

    public static String a() {
        com.bytedance.android.livesdk.log.filter.o r100 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r100 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L8;
        com.bytedance.android.livesdk.log.filter.t r101 = (com.bytedance.android.livesdk.log.filter.t) r100;
        if (r101.getMap().containsKey("video_id") == true) goto L7;
        return "";
    L7:
        return r101.getMap().get("video_id");
    L8:
        return "";
    }

    public static String b() {
        if (TextUtils.isEmpty(com.bytedance.android.livesdk.log.l0.a("is_other_channel", com.bytedance.android.livesdk.log.j0.l().c(am2.n.class))) == true) goto L7;
        return com.bytedance.android.livesdk.log.l0.a("is_other_channel", com.bytedance.android.livesdk.log.j0.l().c(am2.n.class));
    L7:
        return f("is_other_channel");
    }

    public static String d() {
        com.bytedance.android.livesdk.log.filter.o r100 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r100 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L24;
        com.bytedance.android.livesdk.log.filter.t r101 = (com.bytedance.android.livesdk.log.filter.t) r100;
        if (r101.getMap().containsKey("enter_from") == false) goto L8;
        String r102 = r101.getMap().get("enter_from");
    L8:
        if (r101.getMap().containsKey("source") == false) goto L10;
        String r103 = r101.getMap().get("source");
    L10:
        Map<String, String> r104 = r101.getMap();
        Map<String, String> r105 = com.bytedance.android.livesdk.log.e0.f153286a;
        if (tb1.c.f545229a == false) goto L19;
        if (r104.containsKey("enter_from_ad_type") == false) goto L19;
        if (TextUtils.isEmpty(r104.get("enter_from_ad_type")) == true) goto L19;
        return r104.get("enter_from_ad_type");
    L19:
        if (r104.containsKey("enter_from_merge") == true) goto L21;
        return "";
    L21:
        if (TextUtils.isEmpty(r104.get("enter_from_merge")) == false) goto L23;
        return "";
    L23:
        return r104.get("enter_from_merge");
    L24:
        return "";
    }

    public static String f(String r100) {
        return com.bytedance.android.livesdk.log.l0.a(r100, com.bytedance.android.livesdk.log.j0.l().c(am2.x.class));
    }

    public static Map<String, String> g(long r100) {
        com.bytedance.android.livesdk.log.filter.o r101 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        com.bytedance.android.livesdk.log.filter.o r102 = com.bytedance.android.livesdk.log.j0.l().c(am2.t.class);
        HashMap r103 = new HashMap(2);
        if ((r101 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L11;
        com.bytedance.android.livesdk.log.filter.t r104 = (com.bytedance.android.livesdk.log.filter.t) r101;
        if (r104.getMap().containsKey("search_id") == false) goto L8;
        r103.put("search_id", r104.getMap().get("search_id"));
    L8:
        if (r104.getMap().containsKey("search_type") == false) goto L11;
        r103.put("search_type", r104.getMap().get("search_type"));
    L11:
        if ((r102 instanceof com.bytedance.android.livesdk.log.filter.s) == false) goto L22;
        com.bytedance.android.livesdk.log.filter.s r105 = (com.bytedance.android.livesdk.log.filter.s) r102;
        if (r105.getData() == null) goto L18;
        if (r105.getData().f4344f == null) goto L18;
        r103.put("search_params", r105.getData().f4344f);
    L18:
        if (r105.getData() == null) goto L22;
        if (r105.getData().f4342d.containsKey(Long.valueOf(r100)) == false) goto L22;
        r103.put("search_params", r105.getData().f4342d.get(Long.valueOf(r100)));
    L22:
        return r103;
    }

    public static void h(JSONObject r100) {
        r100.put("action_type", c());     // Catch: JSONException -> L4
        r100.put("enter_method", e());     // Catch: JSONException -> L4
        r100.put("enter_from_merge", d());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
