package P3;

import Q3.g;
import R3.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.i;

/* loaded from: classes.dex */
public class d<T> extends AtomicInteger implements i<T>, Q4.c {

    /* renamed from: a, reason: collision with root package name */
    final Q4.b<? super T> f4844a;

    /* renamed from: b, reason: collision with root package name */
    final R3.b f4845b = new R3.b();

    /* renamed from: c, reason: collision with root package name */
    final AtomicLong f4846c = new AtomicLong();

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference<Q4.c> f4847d = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    final AtomicBoolean f4848e = new AtomicBoolean();

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f4849f;

    public d(Q4.b<? super T> bVar) {
        this.f4844a = bVar;
    }

    @Override // Q4.b
    public void a() {
        this.f4849f = true;
        f.a(this.f4844a, this, this.f4845b);
    }

    @Override // Q4.c
    public void cancel() {
        if (this.f4849f) {
            return;
        }
        g.b(this.f4847d);
    }

    @Override // Q4.b
    public void d(T t5) {
        f.c(this.f4844a, t5, this, this.f4845b);
    }

    @Override // x3.i, Q4.b
    public void e(Q4.c cVar) {
        if (this.f4848e.compareAndSet(false, true)) {
            this.f4844a.e(this);
            g.e(this.f4847d, this.f4846c, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // Q4.c
    public void h(long j5) {
        if (j5 > 0) {
            g.d(this.f4847d, this.f4846c, j5);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j5));
    }

    @Override // Q4.b
    public void onError(Throwable th) {
        this.f4849f = true;
        f.b(this.f4844a, th, this, this.f4845b);
    }
}
