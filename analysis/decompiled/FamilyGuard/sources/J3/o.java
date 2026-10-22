package J3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class o extends x3.f<Long> {

    /* renamed from: b, reason: collision with root package name */
    final x3.p f3392b;

    /* renamed from: c, reason: collision with root package name */
    final long f3393c;

    /* renamed from: d, reason: collision with root package name */
    final long f3394d;

    /* renamed from: e, reason: collision with root package name */
    final long f3395e;

    /* renamed from: f, reason: collision with root package name */
    final long f3396f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f3397g;

    static final class a extends AtomicLong implements Q4.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super Long> f3398a;

        /* renamed from: b, reason: collision with root package name */
        final long f3399b;

        /* renamed from: c, reason: collision with root package name */
        long f3400c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<A3.c> f3401d = new AtomicReference<>();

        a(Q4.b<? super Long> bVar, long j5, long j6) {
            this.f3398a = bVar;
            this.f3400c = j5;
            this.f3399b = j6;
        }

        public void a(A3.c cVar) {
            E3.b.j(this.f3401d, cVar);
        }

        @Override // Q4.c
        public void cancel() {
            E3.b.b(this.f3401d);
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this, j5);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            A3.c cVar = this.f3401d.get();
            E3.b bVar = E3.b.DISPOSED;
            if (cVar != bVar) {
                long j5 = get();
                if (j5 == 0) {
                    this.f3398a.onError(new B3.c("Can't deliver value " + this.f3400c + " due to lack of requests"));
                    E3.b.b(this.f3401d);
                    return;
                }
                long j6 = this.f3400c;
                this.f3398a.d(Long.valueOf(j6));
                if (j6 == this.f3399b) {
                    if (this.f3401d.get() != bVar) {
                        this.f3398a.a();
                    }
                    E3.b.b(this.f3401d);
                } else {
                    this.f3400c = j6 + 1;
                    if (j5 != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }
    }

    public o(long j5, long j6, long j7, long j8, TimeUnit timeUnit, x3.p pVar) {
        this.f3395e = j7;
        this.f3396f = j8;
        this.f3397g = timeUnit;
        this.f3392b = pVar;
        this.f3393c = j5;
        this.f3394d = j6;
    }

    @Override // x3.f
    public void W(Q4.b<? super Long> bVar) {
        a aVar = new a(bVar, this.f3393c, this.f3394d);
        bVar.e(aVar);
        x3.p pVar = this.f3392b;
        if (!(pVar instanceof O3.p)) {
            aVar.a(pVar.d(aVar, this.f3395e, this.f3396f, this.f3397g));
            return;
        }
        p.c cVarA = pVar.a();
        aVar.a(cVarA);
        cVarA.d(aVar, this.f3395e, this.f3396f, this.f3397g);
    }
}
