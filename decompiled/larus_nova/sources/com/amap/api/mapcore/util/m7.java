package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public final class m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f27622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static byte[] f27623b;

    private static byte[] a(Context r100) {
        if (r100 == null) goto L4;
        byte[] r101 = f27622a;
        if (r101 != null) goto L8;
    L10:
        byte[] r102 = l5.e(r100).getBytes();
        f27622a = r102;
        return r102;
    L8:
        if (r101.length <= 0) goto L10;
        return r101;
    L4:
        return new byte[0];
    }

    private static byte[] b(Context r100) {
        byte[] r101 = f27623b;
        if (r101 != null) goto L5;
    L7:
        byte[] r102 = Arrays.copyOfRange(a(r100), 0, a(r100).length / 2);
        f27623b = r102;
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
        p6.a(th, CloudControlInf.SP, "cm");
    }

    public static SharedPreferences.Editor a(Context r100, String r101) {
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        th = move-exception;
        p6.a(th, CloudControlInf.SP, "ge");
        goto L11
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return r100.getSharedPreferences(r101, 0).edit();
    }

    public static byte[] b(Context r100, byte[] r101) {
        return q5.b(a(r100), r101, b(r100));
    L5:
        return new byte[0];
    }

    public static byte[] a(Context r100, byte[] r101) {
        return q5.c(a(r100), r101, b(r100));
    L5:
        return new byte[0];
    }

    public static String a(Context r100, String r101, String r102) {
        byte[] r103 = x5.c(r100.getSharedPreferences(r101, 0).getString(r102, ""));     // Catch: Throwable -> L9
        byte[] r104 = q5.b(a(r100), r103, b(r100));     // Catch: Exception -> L6 Throwable -> L9
    L7:
        return x5.c(r104);
    L6:
        r104 = new byte[0];     // Catch: Throwable -> L9
    L14:
        return "";
    }

    public static void a(SharedPreferences.Editor r100, String r101, String r102) {
        if (r100 == null) goto L15;
    L10:
        th = move-exception;
        p6.a(th, CloudControlInf.SP, "ps");
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

    public static void a(SharedPreferences.Editor r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.putLong(r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        t6.a(th, "csp", "plv");
        return;
    }

    public static void a(SharedPreferences.Editor r100, String r101, int r102) {
        r100.putInt(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t6.a(th, "csp", "putPrefsInt");
    }

    public static void a(SharedPreferences.Editor r100, String r101, boolean r102) {
        r100.putBoolean(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t6.a(th, "csp", "setPrefsStr");
    }

    public static void a(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        return;
    L16:
        SharedPreferences.Editor r104 = r100.getSharedPreferences(r101, 0).edit();     // Catch: Throwable -> L15
        byte[] r105 = x5.e(r103);     // Catch: Throwable -> L15
        byte[] r106 = q5.c(a(r100), r105, b(r100));     // Catch: Throwable -> L12
    L13:
        r104.putString(r102, x5.b(r106));     // Catch: Throwable -> L15
        a(r104);     // Catch: Throwable -> L15
        return;
    L12:
        r106 = new byte[0];     // Catch: Throwable -> L15
    }

    public static String b(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L11;
        return null;
    L11:
        return r100.getSharedPreferences(r101, 0).getString(r102, r103);
    L8:
        th = move-exception;
        t6.a(th, "csp", "gsv");
        return r103;
    }

    public static int a(Context r100, String r101, String r102, int r103) {
        return r100.getSharedPreferences(r101, 0).getInt(r102, r103);
    L5:
        th = move-exception;
        t6.a(th, "csp", "giv");
        return r103;
    }

    public static boolean a(Context r100, String r101, String r102, boolean r103) {
        return r100.getSharedPreferences(r101, 0).getBoolean(r102, r103);
    L5:
        th = move-exception;
        t6.a(th, "csp", "gbv");
        return r103;
    }
}
