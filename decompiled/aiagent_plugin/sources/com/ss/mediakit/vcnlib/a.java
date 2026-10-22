package com.ss.mediakit.vcnlib;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: VcnlibloadWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f37575a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f37576b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f37577c = false;

    static {
    }

    public a() {
    }

    public static boolean a() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f37575a == false) goto L18;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return true;
    L18:
        System.loadLibrary("vcn");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        f37575a = r2;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r2;
    L10:
        e = move-exception;
        a("vcn", "Can't load vcn library: " + e);     // Catch: Throwable -> L15
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean b() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f37576b == false) goto L24;
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return true;
    L24:
        System.loadLibrary("vcnverify");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L21
        boolean r3 = true;
    L13:
        f37576b = r3;     // Catch: Throwable -> L21
        if (r3 == false) goto L16;
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return r2;
    L16:
        if (c() == true) goto L19;
        r2 = false;
        goto L19
    L11:
        e = move-exception;
        a("vcn", "Can't load vcnverify library: " + e);     // Catch: Throwable -> L21
        r3 = false;
    L21:
        th = move-exception;
        throw th;
    }

    public static boolean c() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f37577c == false) goto L18;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return true;
    L18:
        System.loadLibrary("vcnverifylite");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
        a("vcn", "load vcnverifylite suc");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
        CustomVerify.a();     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        f37577c = r2;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r2;
    L10:
        e = move-exception;
        a("vcn", "Can't load vcnverifylite library: " + e);     // Catch: Throwable -> L15
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
