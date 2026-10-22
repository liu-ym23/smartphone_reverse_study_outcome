package com.bytedance.vmsdk.a.a;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.bytedance.vmsdk.a.a.a.h;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LocalSocketServer.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String TAG = "LocalSocketServer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocalServerSocket f11715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f11716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f11717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.vmsdk.a.b f11718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.vmsdk.a.a.a.b f11719e;

    /* JADX INFO: compiled from: LocalSocketServer.java */
    private class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f11720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LocalSocket f11721b;

        public a(c r1, LocalSocket r2) {
            this.f11720a = r1;
            this.f11721b = r2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b r0 = new b(this.f11721b.getInputStream(), 1024);     // Catch: Exception -> L4
            d r1 = new d(this.f11721b, r0);     // Catch: Exception -> L4
            c.a(this.f11720a).a(r1);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            a(c.TAG, e.getMessage());
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    /* JADX INFO: renamed from: lambda$xcJ814Clr-GAyHJtEMgkR9QqqkE, reason: not valid java name */
    public static /* synthetic */ void m45lambda$xcJ814ClrGAyHJtEMgkR9QqqkE(c r0) {
        r0.c();
    }

    static /* synthetic */ h a(c r0) {
        return r0.f11717c;
    }

    public c() {
        this.f11716b = new AtomicInteger();
        this.f11719e = new com.bytedance.vmsdk.a.a.a.b();
        this.f11718d = new com.bytedance.vmsdk.a.b();
    }

    public void a(com.bytedance.vmsdk.a.d r2) {
        this.f11718d.a(r2);
        this.f11719e.a(r2.c(), r2.d());
    }

    public void b(com.bytedance.vmsdk.a.d r2) {
        this.f11718d.b(r2);
        this.f11719e.b(r2.c(), r2.d());
    }

    private h b() {
        this.f11718d.a(this.f11719e);
        return new h(this.f11719e);
    }

    public void a() {
        new Thread(new $$Lambda$c$xcJ814ClrGAyHJtEMgkR9QqqkE(this)).start();
    }

    private /* synthetic */ void c() {
        this.f11715a = new LocalServerSocket("JsEngine_" + com.bytedance.vmsdk.d.a.a() + "_devtools_remote");     // Catch: IOException -> L7
        this.f11717c = b();     // Catch: IOException -> L7
    L4:
        if (Thread.interrupted() == true) goto L14;
        a r1 = new a(this, this.f11715a.accept());     // Catch: IOException -> L7
        r1.setName("LocalSocketServer_WorkerThread_" + this.f11716b.incrementAndGet());     // Catch: IOException -> L7
        r1.setDaemon(true);     // Catch: IOException -> L7
        r1.start();     // Catch: IOException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(TAG, e.getMessage());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
