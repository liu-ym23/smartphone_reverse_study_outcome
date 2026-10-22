package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes28.dex */
public class y8 implements ThreadFactory {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28470j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28471k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f28472l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f28473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadFactory f28474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f28475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f28477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f28479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BlockingQueue<Runnable> f28480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f28481i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f28482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f28483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f28484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f28485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f28486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f28487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private BlockingQueue<Runnable> f28488g;

        public y8 a() {
            y8 r100 = new y8(this, 0);
            this.f28482a = null;
            this.f28483b = null;
            this.f28484c = null;
            return r100;
        }

        public a() {
            this.f28485d = y8.a();
            this.f28486e = y8.b();
            this.f28487f = 30;
        }

        public static /* synthetic */ int d(a r100) {
            return r100.f28487f;
        }

        public static /* synthetic */ BlockingQueue e(a r100) {
            return r100.f28488g;
        }

        public static /* synthetic */ String f(a r100) {
            return r100.f28483b;
        }

        public static /* synthetic */ Integer g(a r100) {
            return r100.f28484c;
        }

        public static /* synthetic */ Boolean h(a r100) {
            r100.getClass();
            return null;
        }

        public static /* synthetic */ Thread.UncaughtExceptionHandler i(a r100) {
            return r100.f28482a;
        }

        public a a(int r100) {
            if (r100 <= 0) goto L6;
            this.f28485d = r100;
            return this;
        L6:
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public a b(int r100) {
            if (r100 <= 0) goto L6;
            this.f28486e = r100;
            return this;
        L6:
            throw new NullPointerException("maxPoolSize  must > 0!");
        }

        public a c(int r100) {
            this.f28484c = Integer.valueOf(r100);
            return this;
        }

        public static /* synthetic */ int b(a r100) {
            return r100.f28485d;
        }

        public static /* synthetic */ int c(a r100) {
            return r100.f28486e;
        }

        public a a(String r100) {
            if (r100 == null) goto L6;
            this.f28483b = r100;
            return this;
        L6:
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public a a(Thread.UncaughtExceptionHandler r100) {
            if (r100 == null) goto L6;
            this.f28482a = r100;
            return this;
        L6:
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        public static /* synthetic */ ThreadFactory a(a r100) {
            r100.getClass();
            return null;
        }

        public a a(BlockingQueue<Runnable> r100) {
            this.f28488g = r100;
            return this;
        }
    }

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        f28470j = r100;
        f28471k = Math.max(2, Math.min(r100, 4));
        f28472l = Math.min(r100 * 2, Math.max(8, r100 * 4));
    }

    public static /* synthetic */ int a() {
        return f28471k;
    }

    public static /* synthetic */ int b() {
        return f28472l;
    }

    public int c() {
        return this.f28478f;
    }

    public int d() {
        return this.f28481i;
    }

    public int e() {
        return this.f28479g;
    }

    public final String f() {
        return this.f28476d;
    }

    public BlockingQueue<Runnable> g() {
        return this.f28480h;
    }

    private y8(a r100) {
        a.a(r100);
        this.f28474b = Executors.defaultThreadFactory();
        int r101 = a.b(r100);
        this.f28478f = r101;
        int r102 = a.c(r100);
        this.f28479g = r102;
        if (r102 < r101) goto L15;
        this.f28481i = a.d(r100);
        if (a.e(r100) != null) goto L7;
        this.f28480h = new b9();
    L9:
        if (TextUtils.isEmpty(a.f(r100)) == false) goto L11;
        this.f28476d = "amap-threadpool";
    L12:
        this.f28477e = a.g(r100);
        a.h(r100);
        this.f28475c = a.i(r100);
        this.f28473a = new AtomicLong();
        return;
    L11:
        this.f28476d = a.f(r100);
        goto L12
    L7:
        this.f28480h = a.e(r100);
        goto L9
    L15:
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        Thread r101 = this.f28474b.newThread(r100);
        if (this.f28476d == null) goto L5;
        ThreadMethodProxy.setName(r101, String.format(this.f28476d + "-%d", new Object[]{Long.valueOf(this.f28473a.incrementAndGet())}));
    L5:
        Thread.UncaughtExceptionHandler r102 = this.f28475c;
        if (r102 == null) goto L8;
        r101.setUncaughtExceptionHandler(r102);
    L8:
        Integer r103 = this.f28477e;
        if (r103 == null) goto L11;
        ThreadMethodProxy.setPriority(r101, r103.intValue());
    L11:
        return r101;
    }

    public /* synthetic */ y8(a r100, byte r101) {
        this(r100);
    }
}
