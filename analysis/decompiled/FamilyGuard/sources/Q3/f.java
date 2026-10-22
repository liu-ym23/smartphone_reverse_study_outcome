package Q3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class f extends AtomicInteger implements Q4.c {

    /* renamed from: a, reason: collision with root package name */
    Q4.c f4925a;

    /* renamed from: b, reason: collision with root package name */
    long f4926b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<Q4.c> f4927c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    final AtomicLong f4928d = new AtomicLong();

    /* renamed from: e, reason: collision with root package name */
    final AtomicLong f4929e = new AtomicLong();

    /* renamed from: f, reason: collision with root package name */
    final boolean f4930f;

    /* renamed from: g, reason: collision with root package name */
    volatile boolean f4931g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f4932h;

    public f(boolean z5) {
        this.f4930f = z5;
    }

    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        b();
    }

    final void b() {
        int iAddAndGet = 1;
        long jC = 0;
        Q4.c cVar = null;
        do {
            Q4.c andSet = this.f4927c.get();
            if (andSet != null) {
                andSet = this.f4927c.getAndSet(null);
            }
            long andSet2 = this.f4928d.get();
            if (andSet2 != 0) {
                andSet2 = this.f4928d.getAndSet(0L);
            }
            long andSet3 = this.f4929e.get();
            if (andSet3 != 0) {
                andSet3 = this.f4929e.getAndSet(0L);
            }
            Q4.c cVar2 = this.f4925a;
            if (this.f4931g) {
                if (cVar2 != null) {
                    cVar2.cancel();
                    this.f4925a = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
            } else {
                long jC2 = this.f4926b;
                if (jC2 != Long.MAX_VALUE) {
                    jC2 = R3.c.c(jC2, andSet2);
                    if (jC2 != Long.MAX_VALUE) {
                        jC2 -= andSet3;
                        if (jC2 < 0) {
                            g.g(jC2);
                            jC2 = 0;
                        }
                    }
                    this.f4926b = jC2;
                }
                if (andSet != null) {
                    if (cVar2 != null && this.f4930f) {
                        cVar2.cancel();
                    }
                    this.f4925a = andSet;
                    if (jC2 != 0) {
                        jC = R3.c.c(jC, jC2);
                        cVar = andSet;
                    }
                } else if (cVar2 != null && andSet2 != 0) {
                    jC = R3.c.c(jC, andSet2);
                    cVar = cVar2;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jC != 0) {
            cVar.h(jC);
        }
    }

    public final boolean c() {
        return this.f4931g;
    }

    @Override // Q4.c
    public void cancel() {
        if (this.f4931g) {
            return;
        }
        this.f4931g = true;
        a();
    }

    public final void d(long j5) {
        if (this.f4932h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            R3.c.a(this.f4929e, j5);
            a();
            return;
        }
        long j6 = this.f4926b;
        if (j6 != Long.MAX_VALUE) {
            long j7 = j6 - j5;
            if (j7 < 0) {
                g.g(j7);
                j7 = 0;
            }
            this.f4926b = j7;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        b();
    }

    public final void e(Q4.c cVar) {
        if (this.f4931g) {
            cVar.cancel();
            return;
        }
        F3.b.d(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Q4.c andSet = this.f4927c.getAndSet(cVar);
            if (andSet != null && this.f4930f) {
                andSet.cancel();
            }
            a();
            return;
        }
        Q4.c cVar2 = this.f4925a;
        if (cVar2 != null && this.f4930f) {
            cVar2.cancel();
        }
        this.f4925a = cVar;
        long j5 = this.f4926b;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j5 != 0) {
            cVar.h(j5);
        }
    }

    @Override // Q4.c
    public final void h(long j5) {
        if (!g.k(j5) || this.f4932h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            R3.c.a(this.f4928d, j5);
            a();
            return;
        }
        long j6 = this.f4926b;
        if (j6 != Long.MAX_VALUE) {
            long jC = R3.c.c(j6, j5);
            this.f4926b = jC;
            if (jC == Long.MAX_VALUE) {
                this.f4932h = true;
            }
        }
        Q4.c cVar = this.f4925a;
        if (decrementAndGet() != 0) {
            b();
        }
        if (cVar != null) {
            cVar.h(j5);
        }
    }
}
