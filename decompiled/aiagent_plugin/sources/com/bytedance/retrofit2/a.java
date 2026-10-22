package com.bytedance.retrofit2;

/* JADX INFO: compiled from: AppActivityResumeSuspendRecorder.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f9376a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f9377b = false;

    static {
    }

    public static void a() {
        if (f9377b == true) goto L6;
        f9377b = true;
        f9376a++;
        return;
    }

    public static void b() {
        if (f9377b == false) goto L6;
        f9377b = false;
        f9376a++;
        return;
    }

    public static long c() {
        return f9376a;
    }
}
