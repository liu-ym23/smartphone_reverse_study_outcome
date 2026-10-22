package com.bytedance.android.monitorV2.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l {
    public static List<String> b(JSONArray r100) {
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L12
        if (r100 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r100.length() <= 0) goto L11;
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L11;
        r101.add(r100.optString(r102));     // Catch: Throwable -> L12
        r102 = r102 + 1;
    L12:
        th = move-exception;
        f.b(th);
        return new ArrayList();
    }

    public static JSONObject r(String r100) {
    L8:
        e = move-exception;
        f.b(e);
        return new JSONObject();
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return new JSONObject();
    L7:
        return new JSONObject(r100);
    }

    public static void a(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L18;
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L10
    L7:
        if (r102.hasNext() == false) goto L19;
        String r103 = r102.next();     // Catch: Exception -> L10
        p(r100, r103, k(r101, r103));     // Catch: Exception -> L10
        goto L7
    L19:
        return;
    L10:
        e = move-exception;
        f.b(e);
        return;
    L18:
        return;
    }

    public static JSONObject c(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L4;
        if (r101 != null) goto L9;
        return r100;
    L9:
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L5
    L11:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Throwable -> L5
        Object r104 = r101.opt(r103);     // Catch: Throwable -> L5
        if ((r104 instanceof JSONObject) == true) goto L14;
        p(r100, r103, r104);     // Catch: Throwable -> L5
        goto L11
    L14:
        p(r100, r103, c(r100.optJSONObject(r103), r101.optJSONObject(r103)));     // Catch: Throwable -> L5
    L18:
        return r100;
    L4:
        return c(new JSONObject(), r101);
    L5:
        th = move-exception;
        f.b(th);
        goto L18
    }

    public static int g(JSONObject r100, String r101) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.optInt(r101, 0);
    }

    public static JSONArray h(JSONObject r100, String r101) {
        if (r100 != null) goto L5;
        return new JSONArray();
    L5:
        return r100.optJSONArray(r101);
    }

    public static JSONObject i(JSONObject r100, String r101) {
        if (r100 != null) goto L5;
        return new JSONObject();
    L5:
        return r100.optJSONObject(r101);
    }

    public static long j(JSONObject r100, String r101) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.optLong(r101, 0);
    }

    public static Object k(JSONObject r100, String r101) {
        if (r100 != null) goto L5;
        return new Object();
    L5:
        return r100.opt(r101);
    }

    public static String l(JSONObject r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.optString(r101, "");
    }

    public static void d(JSONObject r100, String r101, String r102) {
    L6:
        e = move-exception;
        f.b(e);
        return;
    L3:
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r100.put(r101, r102);     // Catch: Exception -> L6
        return;
    }

    public static void e(JSONObject r100, String r101, Object r102) {
        if (r102 == null) goto L10;
        r100.put(r101, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        f.b(e);
        return;
    }

    public static boolean f(JSONObject r100, JSONObject r101, String... r102) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        String r105 = r102[r104];
        if (l(r100, r105).equals(l(r101, r105)) == false) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public static String m(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L9;
        return r102;
    L9:
        return r100.optString(r101, r102);
    L6:
        th = move-exception;
        f.b(th);
        return r102;
    }

    public static void n(JSONObject r100, String r101, int r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f.b(e);
    }

    public static void o(JSONObject r100, String r101, long r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f.b(e);
    }

    public static void p(JSONObject r100, String r101, Object r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f.b(e);
    }

    public static void q(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f.b(e);
    }
}
