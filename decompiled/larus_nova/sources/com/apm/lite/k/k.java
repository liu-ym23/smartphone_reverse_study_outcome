package com.apm.lite.k;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class k {
    public static int a(JSONObject r100, int r101, String... r102) {
        JSONObject r103 = f(r100, r102);
        if (r103 != null) goto L5;
        return r101;
    L5:
        int r104 = r103.optInt(r102[r102.length - 1], r101);
        p.b("normal get jsonInt: " + r102[r102.length - 1] + " : " + r104);
        return r104;
    }

    public static JSONArray b(JSONArray r100) {
        if (r100.length() > 384) goto L5;
        return r100;
    L5:
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L6:
        int r103 = 256;
        if (r102 >= 256) goto L9;
        r101.put(r100.opt(r102));
        r102 = r102 + 1;
    L9:
        if (r103 >= 384) goto L11;
        r101.put(r100.opt(r100.length() - (384 - r103)));
        r103 = r103 + 1;
        goto L9
    L11:
        return r101;
    }

    public static boolean c(JSONArray r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static String e(JSONObject r100, String... r101) {
        JSONObject r102 = f(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        String r103 = r102.optString(r101[r101.length - 1]);
        p.b("normal get configArray: " + r101[r101.length - 1] + " : " + r103);
        return r103;
    }

    public static boolean d(JSONObject r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return true;
    L11:
        if (c(r100.optJSONArray("logcat")) == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static JSONObject f(JSONObject r100, String... r101) {
        if (r100 != null) goto L8;
        new RuntimeException();
        if (com.apm.lite.e.f29913e.isDebugMode() == true) goto L7;
    L7:
        return null;
    L8:
        int r102 = 0;
    L10:
        if (r102 >= (r101.length - 1)) goto L16;
        r100 = r100.optJSONObject(r101[r102]);
        if (r100 == null) goto L13;
        r102 = r102 + 1;
        goto L10
    L13:
        p.b("err get json: not found node:" + r101[r102]);
        return null;
    L16:
        return r100;
    }
}
