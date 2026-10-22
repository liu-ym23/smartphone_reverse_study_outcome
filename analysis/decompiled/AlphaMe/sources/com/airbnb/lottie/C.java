package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import h.RunnableC0583a;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: g, reason: collision with root package name */
    public static final ExecutorService f4523g = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    public B f4524a;

    /* renamed from: e, reason: collision with root package name */
    public final FutureTask f4528e;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f4525b = new LinkedHashSet(1);

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f4526c = new LinkedHashSet(1);

    /* renamed from: d, reason: collision with root package name */
    public final Handler f4527d = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    public volatile A f4529f = null;

    public C(Callable callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.f4528e = futureTask;
        f4523g.execute(futureTask);
        d();
    }

    public final synchronized void a(x xVar) {
        try {
            if (this.f4529f != null && this.f4529f.f4520b != null) {
                xVar.a(this.f4529f.f4520b);
            }
            this.f4526c.add(xVar);
            d();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(x xVar) {
        try {
            if (this.f4529f != null && this.f4529f.f4519a != null) {
                xVar.a(this.f4529f.f4519a);
            }
            this.f4525b.add(xVar);
            d();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(A a4) {
        if (this.f4529f != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f4529f = a4;
        this.f4527d.post(new RunnableC0583a(9, this));
    }

    public final synchronized void d() {
        B b4 = this.f4524a;
        if ((b4 == null || !b4.isAlive()) && this.f4529f == null) {
            B b5 = new B(this);
            this.f4524a = b5;
            b5.start();
            HashSet hashSet = AbstractC0398c.f4541a;
        }
    }

    public final synchronized void e() {
        try {
            B b4 = this.f4524a;
            if (b4 == null || !b4.isAlive()) {
                return;
            }
            if (this.f4525b.isEmpty() || this.f4529f != null) {
                this.f4524a.interrupt();
                this.f4524a = null;
                HashSet hashSet = AbstractC0398c.f4541a;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
