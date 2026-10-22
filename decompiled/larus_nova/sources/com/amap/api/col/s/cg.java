package com.amap.api.col.s;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public final class cg extends cd implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ExecutorService f26402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Set<Integer> f26403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakReference<Context> f26404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadFactory f26405h = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f26406d;

    static {
        f26403f = Collections.synchronizedSet(new HashSet());
        f26405h = new AnonymousClass2();
    }

    public static void b() {
        WeakReference<Context> r100 = f26404g;
        if (r100 != null) goto L5;
    L8:
        cd r101 = cd.f26383a;
        if (r101 == null) goto L12;
        r101.a();
        return;
    L12:
        return;
    L5:
        if (r100.get() == null) goto L8;
        ce.a(f26404g.get());
    }

    public static synchronized ExecutorService c() {
        monitor-enter(cg.class);
        ExecutorService r100 = f26402e;     // Catch: Throwable -> L15
        if (r100 != null) goto L7;
    L8:
        f26402e = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f26405h);     // Catch: Throwable -> L15
        goto L18
    L7:
        if (r100.isShutdown() == true) goto L8;
    L18:
        ExecutorService r101 = f26402e;     // Catch: Throwable -> L12
        monitor-exit(cg.class);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized cg d() {
        monitor-enter(cg.class);
        cg r100 = (cg) cd.f26383a;     // Catch: Throwable -> L7
        monitor-exit(cg.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.amap.api.col.s.cd
    public final void a() {
        ce.a(this.f26406d);
    }

    private cg(Context r100) {
        this.f26406d = r100;
        Thread.UncaughtExceptionHandler r101 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        this.f26384b = r101;     // Catch: Throwable -> L17
        if (r101 != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f26385c = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r102 = r101.toString();     // Catch: Throwable -> L17
        if (r102.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f26385c = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r102.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.f26385c = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r102.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ Context a(cg r100) {
        return r100.f26406d;
    }

    public static synchronized cg a(Context r100, br r101) throws bh {
        monitor-enter(cg.class);
        if (r101 == null) goto L30;
        if (r101.b() == null) goto L26;
        if ("".equals(r101.b()) == true) goto L26;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
    L22:
        cg r102 = (cg) cd.f26383a;     // Catch: Throwable -> L27
        monitor-exit(cg.class);
        return r102;
    L10:
        if (f26403f.add(Integer.valueOf(r101.hashCode())) == true) goto L14;
        cg r103 = (cg) cd.f26383a;     // Catch: Throwable -> L20
        monitor-exit(cg.class);
        return r103;
    L14:
        cd r104 = cd.f26383a;     // Catch: Throwable -> L20
        if (r104 != null) goto L17;
        cd.f26383a = new cg(r100);     // Catch: Throwable -> L20
    L18:
        cd r105 = cd.f26383a;     // Catch: Throwable -> L20
        r105.a(r101, r105.f26385c);     // Catch: Throwable -> L20
        goto L22
    L17:
        r104.f26385c = false;     // Catch: Throwable -> L20
    L26:
        throw new bh("sdk name is invalid");     // Catch: Throwable -> L27
    L30:
        throw new bh("sdk info is null");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r100, Throwable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        a(r101, 0, null, null);
        Thread.UncaughtExceptionHandler r102 = this.f26384b;
        if (r102 == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(r102);     // Catch: Throwable -> L9
    L7:
        this.f26384b.uncaughtException(r100, r101);
        return;
    }

    @Override // com.amap.api.col.s.cd
    public final void a(final br r100, final boolean r101) {
        ExecutorService r102 = c();     // Catch: Throwable -> L9 RejectedExecutionException -> L12
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isShutdown() == true) goto L16;
        r102.submit(new AnonymousClass1(this, r100, r101));     // Catch: Throwable -> L9 RejectedExecutionException -> L12
        return;
        goto L17
    L16:
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void a(br r100, String r101, bh r102) {
        a(r100, r101, r102.c(), r102.d(), r102.e(), r102.b());
    }

    public static void c(Throwable r100, String r101, String r102) {
        cd r103 = cd.f26383a;     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        r103.a(r100, 1, r101, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public final void b(Throwable r100, String r101, String r102) {
        if (r100 != null) goto L10;
        return;
    L10:
        a(r100, 1, r101, r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void b(br r100, String r101, String r102) {
        cd r103 = cd.f26383a;     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        r103.a(r100, r101, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // com.amap.api.col.s.cd
    public final void a(br r100, String r101, String r102) {
        ch.a(r100, this.f26406d, r102, r101);
    }

    @Override // com.amap.api.col.s.cd
    public final void a(Throwable r100, int r101, String r102, String r103) {
        ch.a(this.f26406d, r100, r101, r102, r103);
    }

    public static void a(br r100, String r101, String r102, String r103, String r110) {
        a(r100, r101, r102, r103, "", r110);
    }

    public static void a(br r100, String r101, String r102, String r103, String r104, String r105) {
        if (cd.f26383a == null) goto L9;
        cd.f26383a.a(r100, "path:" + r101 + ",type:" + r102 + ",gsid:" + r103 + ",csid:" + r104 + ",code:" + r105, "networkError");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }
}
