package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class k1 {
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
        return com.bytedance.android.livesdk.log.l0.a("action_type", com.bytedance.android.livesdk.log.j0.l().c(am2.x.class));
    }

    public static String c() {
        com.bytedance.android.livesdk.log.filter.o r100 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r100 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L32;
        com.bytedance.android.livesdk.log.filter.t r101 = (com.bytedance.android.livesdk.log.filter.t) r100;
        if (r101.getMap().containsKey("enter_from") == true) goto L7;
    L9:
        String r102 = "";
    L11:
        if (r101.getMap().containsKey("source") == true) goto L13;
    L15:
        String r103 = "";
    L16:
        Map<String, String> r104 = r101.getMap();
        com.bytedance.android.livesdk.chatroom.r r105 = z51.a.c(null, 0);
        if (r105 == null) goto L21;
        if (r102 == null) goto L21;
        r105.dataMapping(r102, r103, r104);
    L21:
        if (r104.containsKey("enter_from_ad_type") == false) goto L27;
        if (TextUtils.isEmpty(r104.get("enter_from_ad_type")) == true) goto L27;
        return r104.get("enter_from_ad_type");
    L27:
        if (r104.containsKey("enter_from_merge") == false) goto L32;
        if (TextUtils.isEmpty(r104.get("enter_from_merge")) == true) goto L32;
        return r104.get("enter_from_merge");
    L13:
        if (r101.getMap().get("source") == null) goto L15;
        r103 = r101.getMap().get("source");
        goto L16
    L7:
        if (r101.getMap().get("enter_from") == null) goto L9;
        r102 = r101.getMap().get("enter_from");
    L32:
        return "";
    }

    public static String d() {
        return com.bytedance.android.livesdk.log.l0.a("enter_method", com.bytedance.android.livesdk.log.j0.l().c(am2.x.class));
    }

    public static Map<String, String> e(long r100) {
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

    public static void f(JSONObject r100) {
        r100.put("action_type", b());     // Catch: JSONException -> L4
        r100.put("enter_method", d());     // Catch: JSONException -> L4
        r100.put("enter_from_merge", c());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
