package J3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class n extends x3.f<Long> {

    /* renamed from: b, reason: collision with root package name */
    final x3.p f3385b;

    /* renamed from: c, reason: collision with root package name */
    final long f3386c;

    /* renamed from: d, reason: collision with root package name */
    final long f3387d;

    /* renamed from: e, reason: collision with root package name */
    final TimeUnit f3388e;

    static final class a extends AtomicLong implements Q4.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super Long> f3389a;

        /* renamed from: b, reason: collision with root package name */
        long f3390b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<A3.c> f3391c = new AtomicReference<>();

        a(Q4.b<? super Long> bVar) {
            this.f3389a = bVar;
        }

        public void a(A3.c cVar) {
            E3.b.j(this.f3391c, cVar);
        }

        @Override // Q4.c
        public void cancel() {
            E3.b.b(this.f3391c);
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this, j5);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3391c.get() != E3.b.DISPOSED) {
                if (get() != 0) {
                    Q4.b<? super Long> bVar = this.f3389a;
                    long j5 = this.f3390b;
                    this.f3390b = j5 + 1;
                    bVar.d(Long.valueOf(j5));
                    R3.c.d(this, 1L);
                    return;
                }
                this.f3389a.onError(new B3.c("Can't deliver value " + this.f3390b + " due to lack of requests"));
                E3.b.b(this.f3391c);
            }
        }
    }

    public n(long j5, long j6, TimeUnit timeUnit, x3.p pVar) {
        this.f3386c = j5;
        this.f3387d = j6;
        this.f3388e = timeUnit;
        this.f3385b = pVar;
    }

    @Override // x3.f
    public void W(Q4.b<? super Long> bVar) {
        a aVar = new a(bVar);
        bVar.e(aVar);
        x3.p pVar = this.f3385b;
        if (!(pVar instanceof O3.p)) {
            aVar.a(pVar.d(aVar, this.f3386c, this.f3387d, this.f3388e));
            return;
        }
        p.c cVarA = pVar.a();
        aVar.a(cVarA);
        cVarA.d(aVar, this.f3386c, this.f3387d, this.f3388e);
    }
}
