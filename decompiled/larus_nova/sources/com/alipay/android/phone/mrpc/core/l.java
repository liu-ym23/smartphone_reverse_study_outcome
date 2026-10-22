package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public final class l implements ab {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static l f25027b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadFactory f25028i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25029a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f25030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f25031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f25033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f25034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25035h;

    static {
        f25028i = new n();
    }

    public l(Context r110) {
        this.f25029a = r110;
        this.f25031d = b.a("android");
        PThreadPoolExecutor r111 = new PThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f25028i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f25030c = r111;
        r111.allowCoreThreadTimeOut(true);     // Catch: Exception -> L6
    L4:
        CookieSyncManager.createInstance(this.f25029a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context r100) {
        l r101 = f25027b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return b(r100);
    }

    public static final synchronized l b(Context r100) {
        monitor-enter(l.class);
        l r101 = f25027b;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        monitor-exit(l.class);
        return r101;
    L8:
        l r102 = new l(r100);     // Catch: Throwable -> L11
        f25027b = r102;     // Catch: Throwable -> L11
        monitor-exit(l.class);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public final b a() {
        return this.f25031d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t r110) {
        if (s.a(this.f25029a) == false) goto L13;
        String r100 = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
        Object[] r101 = new Object[9];
        r101[0] = Integer.valueOf(this.f25030c.getActiveCount());
        r101[1] = Long.valueOf(this.f25030c.getCompletedTaskCount());
        r101[2] = Long.valueOf(this.f25030c.getTaskCount());
        long r102 = this.f25034g;
        long r103 = 0;
        if (r102 != 0) goto L7;
        long r104 = 0;
    L8:
        r101[3] = Long.valueOf(r104);
        int r105 = this.f25035h;
        if (r105 == 0) goto L12;
        r103 = this.f25033f / ((long) r105);
    L12:
        r101[4] = Long.valueOf(r103);
        r101[5] = Long.valueOf(this.f25032e);
        r101[6] = Long.valueOf(this.f25033f);
        r101[7] = Long.valueOf(this.f25034g);
        r101[8] = Integer.valueOf(this.f25035h);
        String.format(r100, r101);
        goto L13
    L7:
        r104 = ((this.f25032e * 1000) / r102) >> 10;
    L13:
        q r106 = new q(this, (o) r110);
        m r111 = new m(this, r106, r106);
        this.f25030c.execute(r111);
        return r111;
    }

    public final void a(long r100) {
        this.f25032e += r100;
    }

    public final void b(long r100) {
        this.f25033f += r100;
        this.f25035h++;
    }

    public final void c(long r100) {
        this.f25034g += r100;
    }
}
