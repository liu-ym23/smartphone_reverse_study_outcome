package com.alipay.sdk.m.u;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25859a;

    public j() {
    }

    public static String a(Context r100) {
        if (TextUtils.isEmpty(f25859a) == false) goto L10;
        String r101 = r100.getApplicationContext().getPackageName();     // Catch: Throwable -> L6
    L8:
        f25859a = (r101 + "0000000000000000000000000000").substring(0, 24);
    L6:
        th = move-exception;
        e.a(th);
        r101 = "";
    L10:
        return f25859a;
    }

    public static synchronized boolean a(Context r100, String r101) {
        monitor-enter(j.class);
        boolean r102 = PreferenceManager.getDefaultSharedPreferences(r100).contains(r101);     // Catch: Throwable -> L6
    L9:
        monitor-exit(j.class);
        return r102;
    L6:
        th = move-exception;
        e.a(th);     // Catch: Throwable -> L11
        r102 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(Context r100, String r101) {
        monitor-enter(j.class);
        PreferenceManager.getDefaultSharedPreferences(r100).edit().remove(r101).apply();     // Catch: Throwable -> L6
    L8:
        monitor-exit(j.class);
        return;
    L6:
        th = move-exception;
        e.a(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized String a(com.alipay.sdk.m.s.a r100, Context r101, String r102, String r103) {
        monitor-enter(j.class);
        String r104 = null;
        String r105 = PreferenceManager.getDefaultSharedPreferences(r101).getString(r102, r103);     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r105) == true) goto L9;
        r104 = com.alipay.sdk.m.n.e.a(a(r101), r105, r102);     // Catch: Throwable -> L16 Exception -> L18
    L9:
        if (TextUtils.isEmpty(r105) == false) goto L11;
    L20:
        monitor-exit(j.class);
        return r104;
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L20;
        com.alipay.sdk.m.k.a.b(r100, "cp", com.alipay.sdk.m.k.b.F, String.format("%s,%s", new Object[]{r102, r105}));     // Catch: Throwable -> L16 Exception -> L18
    L18:
        e = move-exception;
        e.a(e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(com.alipay.sdk.m.s.a r100, Context r101, String r102, String r103) {
        monitor-enter(j.class);
        String r104 = com.alipay.sdk.m.n.e.b(a(r101), r103, r102);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r103) == false) goto L7;
    L11:
        PreferenceManager.getDefaultSharedPreferences(r101).edit().putString(r102, r104).apply();     // Catch: Throwable -> L13
    L15:
        monitor-exit(j.class);
        return;
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L11;
        com.alipay.sdk.m.k.a.b(r100, "cp", com.alipay.sdk.m.k.b.G, String.format("%s,%s", new Object[]{r102, r103}));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        e.a(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
