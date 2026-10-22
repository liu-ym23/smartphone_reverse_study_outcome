package com.baidu.sec.privacy.b;

import android.content.Context;
import com.baidu.sec.privacy.c;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f33492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f33493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.baidu.sec.privacy.a f33494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f33495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f33496e;

    public static Context a() {
        return f33492a;
    }

    public static com.baidu.sec.privacy.a b() {
        return f33494c;
    }

    public static c c() {
        return f33495d;
    }

    public static boolean d() {
        return f33496e;
    }

    public static void a(boolean r100) {
        com.baidu.sec.privacy.f.c.a(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
    }

    public static a a(Context r100) {
        return com.baidu.sec.privacy.e.a.a(r100);
    }

    public static void a(Context r100, String r101) {
        if (f33493b == false) goto L11;
        return;
    L11:
        f33496e = false;     // Catch: Throwable -> L8
        a(r100, r101, false, null);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
    }

    public static void a(Context r100, String r101, com.baidu.sec.privacy.a r102) {
        f33494c = r102;
        a(r100, r101);
    }

    public static void a(Context r100, String r101, boolean r102, c r103) {
        if (f33493b == false) goto L11;
        return;
    L11:
        f33493b = true;     // Catch: Throwable -> L8
        f33492a = r100.getApplicationContext();     // Catch: Throwable -> L8
        f33495d = r103;     // Catch: Throwable -> L8
        f33496e = r102;     // Catch: Throwable -> L8
        com.baidu.sec.privacy.d.b.a(r101, r102, r103);     // Catch: Throwable -> L8
        com.baidu.sec.privacy.d.a.b(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
    }
}
