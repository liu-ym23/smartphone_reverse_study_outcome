package com.amap.api.col.jmsl;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class O1 implements ThreadFactory {

    /* renamed from: j, reason: collision with root package name */
    public static final int f16229j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f16230k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f16231l;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f16232a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f16233b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f16234c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16235d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f16236e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16237f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16238g;

    /* renamed from: h, reason: collision with root package name */
    public final BlockingQueue<Runnable> f16239h;

    /* renamed from: i, reason: collision with root package name */
    public final int f16240i;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Thread.UncaughtExceptionHandler f16241a;

        /* renamed from: b, reason: collision with root package name */
        public String f16242b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f16243c;

        /* renamed from: d, reason: collision with root package name */
        public int f16244d = O1.f16230k;

        /* renamed from: e, reason: collision with root package name */
        public int f16245e;

        public a() {
            int unused = O1.f16231l;
            this.f16245e = 30;
        }

        public static /* synthetic */ ThreadFactory e(a aVar) {
            aVar.getClass();
            return null;
        }

        public static /* synthetic */ BlockingQueue i(a aVar) {
            aVar.getClass();
            return null;
        }

        public static /* synthetic */ Boolean l(a aVar) {
            aVar.getClass();
            return null;
        }

        public a a(int i10) {
            if (i10 <= 0) {
                throw new NullPointerException("corePoolSize  must > 0!");
            }
            this.f16244d = i10;
            return this;
        }

        public a b(String str) {
            this.f16242b = str;
            return this;
        }

        public a c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler == null) {
                throw new NullPointerException("Uncaught exception handler must not be null!");
            }
            this.f16241a = uncaughtExceptionHandler;
            return this;
        }

        public O1 d() {
            O1 o12 = new O1(this, (byte) 0);
            this.f16241a = null;
            this.f16242b = null;
            this.f16243c = null;
            return o12;
        }

        public a g(int i10) {
            this.f16243c = Integer.valueOf(i10);
            return this;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f16229j = iAvailableProcessors;
        f16230k = Math.max(2, Math.min(iAvailableProcessors, 4));
        f16231l = Math.min(iAvailableProcessors * 2, Math.max(8, iAvailableProcessors * 4));
    }

    public /* synthetic */ O1(a aVar, byte b10) {
        this(aVar);
    }

    public int c() {
        return this.f16237f;
    }

    public int d() {
        return this.f16240i;
    }

    public int e() {
        return this.f16238g;
    }

    public final String f() {
        return this.f16235d;
    }

    public BlockingQueue<Runnable> g() {
        return this.f16239h;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f16233b.newThread(runnable);
        if (this.f16235d != null) {
            threadNewThread.setName(String.format(this.f16235d + "-%d", Long.valueOf(this.f16232a.incrementAndGet())));
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16234c;
        if (uncaughtExceptionHandler != null) {
            threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        Integer num = this.f16236e;
        if (num != null) {
            threadNewThread.setPriority(num.intValue());
        }
        return threadNewThread;
    }

    public O1(a aVar) {
        a.e(aVar);
        this.f16233b = Executors.defaultThreadFactory();
        int i10 = aVar.f16244d;
        this.f16237f = i10;
        int i11 = f16231l;
        this.f16238g = i11;
        if (i11 < i10) {
            throw new NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.f16240i = aVar.f16245e;
        a.i(aVar);
        this.f16239h = new BlockingQueueC1616v2();
        if (TextUtils.isEmpty(aVar.f16242b)) {
            this.f16235d = "amap-threadpool";
        } else {
            this.f16235d = aVar.f16242b;
        }
        this.f16236e = aVar.f16243c;
        a.l(aVar);
        this.f16234c = aVar.f16241a;
        this.f16232a = new AtomicLong();
    }
}
