package com.bytedance.crash;

import java.util.List;

/* JADX INFO: compiled from: NpthAlogApi.java */
/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Runnable f7835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f7836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f7837c;

    /* JADX INFO: compiled from: NpthAlogApi.java */
    interface a {
        List<String> a(long r1, String r3);
    }

    /* JADX INFO: compiled from: NpthAlogApi.java */
    interface b {
        boolean a();
    }

    public static boolean a() {
        if (f7835a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b() {
        Runnable r0 = f7835a;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public static boolean c() {
        if (f7836b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d() {
        b r0 = f7837c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() == false) goto L7;
        return true;
    }

    public static List<String> a(long r1, String r3) {
        a r0 = f7836b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r1, r3);
    }
}
