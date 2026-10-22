package com.ss.bduploader.net;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: IPCache.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f37543a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f37544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static k f37545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f37546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Lock f37547e;

    static {
    }

    public static k a() {
        if (f37545c != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37545c != null) goto L9;
        f37545c = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f37545c;
    }

    private k() {
        this.f37546d = new ConcurrentHashMap();
        this.f37547e = new ReentrantLock();
    }

    public void a(String r2, b r3) {
        this.f37547e.lock();
        ConcurrentHashMap<String, b> r0 = this.f37546d;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.put(r2, r3);     // Catch: Throwable -> L8
    L6:
        this.f37547e.unlock();
        return;
    L8:
        th = move-exception;
        this.f37547e.unlock();
        throw th;
    }
}
