package com.amap.api.col.jmsl;

import android.content.Context;
import java.lang.Thread;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.amap.api.col.jmsl.c2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1541c2 extends C1611u1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: e, reason: collision with root package name */
    public static Set<Integer> f16546e = Collections.synchronizedSet(new HashSet());

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f16547f = new a();

    /* renamed from: d, reason: collision with root package name */
    public Context f16548d;

    /* renamed from: com.amap.api.col.jmsl.c2$a */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f16549a = new AtomicInteger(1);

        /* renamed from: com.amap.api.col.jmsl.c2$a$a, reason: collision with other inner class name */
        public class C0204a extends Thread {
            public C0204a(a aVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new C0204a(this, runnable, "pama#" + this.f16549a.getAndIncrement());
        }
    }

    public C1541c2(Context context) {
        this.f16548d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f16969a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f16970b = true;
                return;
            }
            String string = defaultUncaughtExceptionHandler.toString();
            if (!string.startsWith("com.amap.apis.utils.core.dynamiccore") && (string.indexOf("com.amap.api") != -1 || string.indexOf("com.loc") != -1)) {
                this.f16970b = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f16970b = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Throwable th, String str, String str2) {
        try {
            C1611u1 c1611u1 = C1611u1.f16968c;
            if (c1611u1 != null) {
                c1611u1.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized C1541c2 d() {
        return (C1541c2) C1611u1.f16968c;
    }

    public static synchronized C1541c2 e(Context context, C1569j2 c1569j2) throws g5 {
        if (c1569j2 == null) {
            throw new g5("sdk info is null");
        }
        if (c1569j2.g() == null || "".equals(c1569j2.g())) {
            throw new g5("sdk name is invalid");
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!f16546e.add(Integer.valueOf(c1569j2.hashCode()))) {
            return (C1541c2) C1611u1.f16968c;
        }
        C1611u1 c1611u1 = C1611u1.f16968c;
        if (c1611u1 == null) {
            C1611u1.f16968c = new C1541c2(context);
        } else {
            c1611u1.f16970b = false;
        }
        C1611u1 c1611u12 = C1611u1.f16968c;
        boolean z10 = c1611u12.f16970b;
        try {
            V1.h().f(new T1((C1541c2) c1611u12, c1569j2, z10));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return (C1541c2) C1611u1.f16968c;
    }

    public static void f(C1569j2 c1569j2, String str, String str2) {
        try {
            C1611u1 c1611u1 = C1611u1.f16968c;
            if (c1611u1 != null) {
                C1573k2.f(c1569j2, ((C1541c2) c1611u1).f16548d, str2, str);
            }
        } catch (Throwable unused) {
        }
    }

    public static void g(C1569j2 c1569j2, String str, String str2, String str3, String str4, String str5) {
        try {
            if (C1611u1.f16968c != null) {
                C1573k2.f(c1569j2, ((C1541c2) C1611u1.f16968c).f16548d, "networkError", "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i() {
        C1611u1 c1611u1 = C1611u1.f16968c;
        if (c1611u1 != null) {
            D1.c(((C1541c2) c1611u1).f16548d);
        }
    }

    @Override // com.amap.api.col.jmsl.C1611u1
    public final void a(Throwable th, int i10, String str, String str2) {
        C1573k2.e(this.f16548d, th, i10, str, str2);
    }

    public void h(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            C1573k2.e(this.f16548d, th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        C1573k2.e(this.f16548d, th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16969a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f16969a.uncaughtException(thread, th);
        }
    }
}
