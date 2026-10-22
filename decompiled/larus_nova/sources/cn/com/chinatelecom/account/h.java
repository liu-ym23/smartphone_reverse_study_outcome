package cn.com.chinatelecom.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static int a(Context r100, String r101, int r102) {
        if (r100 != null) goto L4;
    L9:
        return r102;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return b(r100).getInt(r101, r102);
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static long a(Context r100, String r101, long r102) {
        if (r100 != null) goto L4;
    L9:
        return r102;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return b(r100).getLong(r101, r102);
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private static String a(Context r100) {
        return "ct_account_api_sdk";
    }

    public static String a(Context r100, String r101, String r102) {
        if (r100 != null) goto L4;
    L9:
        return r102;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return b(r100).getString(r101, r102);
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private static SharedPreferences b(Context r100) {
        return r100.getSharedPreferences(a(r100), 0);
    }

    public static void b(Context r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        b(r100).edit().putInt(r101, r102).commit();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void b(Context r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        b(r100).edit().putString(r101, r102).commit();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static boolean b(Context r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return b(r100).edit().putLong(r101, r102).commit();
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    L14:
        return false;
    }
}
