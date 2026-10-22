package com.bytedance.crash.crash;

import java.io.File;

/* JADX INFO: compiled from: CustomJavaHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String TAG = "CustomJavaHandler";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7320c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f7321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f7322b;

    c(File r2) {
        this.f7322b = 0;
        this.f7321a = r2;
    }

    public static void a(boolean r0) {
        f7320c = r0;
    }
}
