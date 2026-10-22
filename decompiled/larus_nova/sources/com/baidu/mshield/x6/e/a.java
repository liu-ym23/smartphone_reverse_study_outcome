package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static int a(Context r100) {
        int r101 = new com.baidu.mshield.x6.b.b(r100).o();     // Catch: Throwable -> L7
        if (r101 > 0) goto L5;
        r101 = 60;
    L5:
        return r101 / 60;
    L7:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        return 1;
    }

    public static boolean a(Context r100, String r101) {
        return b(r100, r101, true);
    }

    public static JSONObject b(Context r100, String r101) {
        return new JSONObject(new com.baidu.mshield.x6.b.b(r100).a(r101)).optJSONObject("2");
    L4:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        return new JSONObject();
    }

    public static boolean a(Context r100, String r101, boolean r102) {
        String r103 = new com.baidu.mshield.x6.b.b(r100).a(r101);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r103) == false) goto L5;
        return r102;
    L5:
        if (new JSONObject(r103).getInt("1") != 0) goto L9;
        return false;
    L9:
        return true;
    L11:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        return r102;
    }

    public static boolean b(Context r100, String r101, boolean r102) {
        return a(r100, r101, r102);
    L4:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        return r102;
    }

    public static boolean a(Context r100, String r101, String r102, boolean r103) {
        JSONObject r104 = b(r100, r101);     // Catch: Throwable -> L10
        if (r104.has(r102) == false) goto L12;
        if (r104.optInt(r102, r103 ? 1 : 0) == 1) goto L15;
        return false;
    L15:
        return true;
    L12:
        return r103;
    L10:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        goto L12
    }
}
