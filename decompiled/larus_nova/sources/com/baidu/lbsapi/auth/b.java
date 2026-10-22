package com.baidu.lbsapi.auth;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes39.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f30442a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f30443b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement r100 = new Throwable().getStackTrace()[2];
        return r100.getFileName() + "[" + r100.getLineNumber() + "]";
    }

    public static void a(String r100) {
        if (f30442a == true) goto L5;
        return;
    L5:
        if (ThreadMethodProxy.currentThread().getStackTrace().length != 0) goto L7;
        return;
    L7:
        a();
    }

    public static void b(String r100) {
        int r101 = ThreadMethodProxy.currentThread().getStackTrace().length;
    }

    public static void c(String r100) {
        if (f30442a == true) goto L5;
        return;
    L5:
        if (ThreadMethodProxy.currentThread().getStackTrace().length != 0) goto L7;
        return;
    L7:
        a();
    }
}
