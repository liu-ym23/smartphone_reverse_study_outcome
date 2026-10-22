package com.bytedance.anniex.bd.foundation.impl;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class o {
    public static JSONObject c() {
        int r100 = or3.a.f524932a;
        return new JSONObject();
    }

    public static String a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        int r101 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        String r102 = r100.toString();
        if (r102 != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        return r102;
    }

    public static String b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonMap");
        int r101 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonMap");
        Intrinsics.checkNotNullParameter(r100, "jsonMap");
        JSONObject r102 = new JSONObject(MapsKt.toMap(r100));     // Catch: Exception -> L5
    L6:
        String r103 = r102.toString();
        if (r103 != null) goto L12;
        return SliceInitService.DEFAULT_SWITCH;
    L12:
        return r103;
    L5:
        r102 = new JSONObject();
        goto L6
    }

    public static JSONObject d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        int r101 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        return new JSONObject(r100);
    L6:
        return new JSONObject();
    }

    public static JSONObject e(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonMap");
        int r101 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonMap");
        return new JSONObject(MapsKt.toMap(r100));
    L6:
        return new JSONObject();
    }

    public static int h(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonArr");
        int r101 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonArr");
        return r100.length();
    }

    public static ArrayList k(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Iterator<String> r101 = r100.keys();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L5
        return new ArrayList(SequencesKt.toList(SequencesKt.asSequence(r101)));
    L6:
        return com.bytedance.rts.foundation.j.k(new String[0]);
    }

    public static boolean q(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        int r101 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return r100 instanceof JSONObject;
    }

    public static JSONObject i(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.optJSONObject(r101);
    }

    public static Object m(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.opt(r101);
    }

    public static String o(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.optString(r101);
    }

    public static String p(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        int r102 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        return r100.optString(r101, "");
    }

    public static int f(JSONObject r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r103 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r104 = r100.opt(r101);
        if ((r104 instanceof Boolean) == false) goto L11;
        Integer r105 = Integer.valueOf(((Boolean) r104).booleanValue() ? 1 : 0);
    L8:
        if (r105 != null) goto L10;
        return r102;
    L10:
        return r105.intValue();
    L11:
        r105 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r100, r101));     // Catch: Exception -> L7
    L7:
        r105 = null;
        goto L8
    }

    public static JSONArray g(JSONObject r100, String r101, JSONArray r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        int r103 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        JSONArray r104 = r100.optJSONArray(r101);
        if (r104 != null) goto L6;
        return r102;
    L6:
        return r104;
    }

    public static JSONObject j(JSONObject r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        int r103 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        JSONObject r104 = r100.optJSONObject(r101);
        if (r104 != null) goto L6;
        return r102;
    L6:
        return r104;
    }

    public static long l(JSONObject r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r103 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Long r104 = or3.a.c(r100, r101);
        if (r104 != null) goto L5;
        return r102;
    L5:
        return r104.longValue();
    }

    public static Object n(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        int r103 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        Object r104 = r100.opt(r101);
        if (r104 != null) goto L6;
        return r102;
    L6:
        return r104;
    }

    public static void r(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        int r103 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.put(r101, r102);
    }
}
