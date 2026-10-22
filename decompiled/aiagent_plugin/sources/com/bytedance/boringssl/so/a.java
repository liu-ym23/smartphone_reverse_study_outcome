package com.bytedance.boringssl.so;

import android.util.Log;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BoringsslLoaderWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "BoringsslLoaderWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f6669a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f6670b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f6671c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f6672d = "ttboringssl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f6673e = "ttcrypto";
    private static Lock f;

    static {
        f = new ReentrantLock();
    }

    public static boolean a() {
        f.lock();     // Catch: Throwable -> L15 Error -> L17
        if (f6671c == null) goto L9;
        boolean r0 = f6671c.a();     // Catch: Throwable -> L15 Error -> L17
        f.unlock();
        return r0;
    L9:
        if (f6670b == true) goto L12;
        System.loadLibrary(f6673e);     // Catch: Throwable -> L15 Error -> L17
        f6670b = true;     // Catch: Throwable -> L15 Error -> L17
    L12:
        if (f6669a == true) goto L14;
        System.loadLibrary(f6672d);     // Catch: Throwable -> L15 Error -> L17
        f6669a = true;     // Catch: Throwable -> L15 Error -> L17
    L14:
        f.unlock();
        if (f6669a == true) goto L23;
    L25:
        return false;
    L23:
        if (f6670b == false) goto L25;
        return true;
    L15:
        th = move-exception;
        f.unlock();
        throw th;
    L17:
        e = move-exception;
        a(TAG, "load boringssl:" + f6669a + " load crypto:" + f6670b + "  err:" + e.toString());     // Catch: Throwable -> L15
        goto L14
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
