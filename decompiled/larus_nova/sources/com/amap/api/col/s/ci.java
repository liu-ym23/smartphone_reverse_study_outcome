package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f26424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static byte[] f26425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26426c;

    public ci(String r100) {
        if (TextUtils.isDigitsOnly(r100) == false) goto L5;
        r100 = "SPUtil";
    L5:
        this.f26426c = bq.a(r100);
    }

    private static byte[] a(Context r100) {
        if (r100 == null) goto L4;
        byte[] r101 = f26424a;
        if (r101 != null) goto L8;
    L10:
        byte[] r102 = bi.f(r100).getBytes();
        f26424a = r102;
        return r102;
    L8:
        if (r101.length <= 0) goto L10;
        return r101;
    L4:
        return new byte[0];
    }

    private static byte[] b(Context r100) {
        byte[] r101 = f26425b;
        if (r101 != null) goto L5;
    L7:
        byte[] r102 = Arrays.copyOfRange(a(r100), 0, a(r100).length / 2);
        f26425b = r102;
        return r102;
    L5:
        if (r101.length <= 0) goto L7;
        return r101;
    }

    public static void a(SharedPreferences.Editor r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.apply();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        cd.a(th, CloudControlInf.SP, "cm");
    }

    public static void a(SharedPreferences.Editor r100, String r101) {
        if (r100 == null) goto L13;
    L8:
        th = move-exception;
        cd.a(th, CloudControlInf.SP, "rk");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.remove(r101);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    public static SharedPreferences.Editor b(Context r100, String r101) {
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        th = move-exception;
        cd.a(th, CloudControlInf.SP, "ge");
        goto L11
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return r100.getSharedPreferences(r101, 0).edit();
    }

    private static byte[] a(Context r100, byte[] r101) {
        return bn.b(a(r100), r101, b(r100));
    L5:
        return new byte[0];
    }

    private static byte[] b(Context r100, byte[] r101) {
        return bn.a(a(r100), r101, b(r100));
    L5:
        return new byte[0];
    }

    public final String a(Context r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return b(r100, this.f26426c, r101);
    }

    public static void a(SharedPreferences.Editor r100, String r101, String r102) {
        if (r100 == null) goto L15;
    L10:
        th = move-exception;
        cd.a(th, CloudControlInf.SP, "ps");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        r100.putString(r101, r102);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    public static String b(Context r100, String r101, String r102) {
        if (r100 != null) goto L9;
        return "";
    L9:
        return bs.a(b(r100, bs.d(r100.getSharedPreferences(r101, 0).getString(r102, ""))));
    L11:
        return "";
    }

    public static long c(Context r100, String r101, String r102) {
        return r100.getSharedPreferences(r101, 0).getLong(r102, 0);
    L5:
        th = move-exception;
        cg.c(th, "csp", "glv");
        return 0;
    }

    public static void a(SharedPreferences.Editor r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.putLong(r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        cg.c(th, "csp", "plv");
        return;
    }

    public final void a(Context r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        a(r100, this.f26426c, r101, r102);
        return;
    }

    public static void a(SharedPreferences.Editor r100, String r101, int r102) {
        r100.putInt(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        cg.c(th, "csp", "putPrefsInt");
    }

    public static void a(SharedPreferences.Editor r100, String r101, boolean r102) {
        r100.putBoolean(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        cg.c(th, "csp", "setPrefsStr");
    }

    public static void a(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L12;
        return;
    L12:
        SharedPreferences.Editor r104 = r100.getSharedPreferences(r101, 0).edit();     // Catch: Throwable -> L11
        r104.putString(r102, bs.g(a(r100, bs.a(r103))));     // Catch: Throwable -> L11
        a(r104);     // Catch: Throwable -> L11
        return;
    }

    public static String b(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L11;
        return null;
    L11:
        return r100.getSharedPreferences(r101, 0).getString(r102, r103);
    L8:
        th = move-exception;
        cg.c(th, "csp", "gsv");
        return r103;
    }

    public static int a(Context r100, String r101, String r102, int r103) {
        return r100.getSharedPreferences(r101, 0).getInt(r102, r103);
    L5:
        th = move-exception;
        cg.c(th, "csp", "giv");
        return r103;
    }

    public static boolean a(Context r100, String r101, String r102, boolean r103) {
        return r100.getSharedPreferences(r101, 0).getBoolean(r102, r103);
    L5:
        th = move-exception;
        cg.c(th, "csp", "gbv");
        return r103;
    }
}
