package J3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class G extends x3.f<Long> {

    /* renamed from: b, reason: collision with root package name */
    final x3.p f3262b;

    /* renamed from: c, reason: collision with root package name */
    final long f3263c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f3264d;

    static final class a extends AtomicReference<A3.c> implements Q4.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super Long> f3265a;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f3266b;

        a(Q4.b<? super Long> bVar) {
            this.f3265a = bVar;
        }

        public void a(A3.c cVar) {
            E3.b.k(this, cVar);
        }

        @Override // Q4.c
        public void cancel() {
            E3.b.b(this);
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                this.f3266b = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != E3.b.DISPOSED) {
                if (!this.f3266b) {
                    lazySet(E3.c.INSTANCE);
                    this.f3265a.onError(new B3.c("Can't deliver value due to lack of requests"));
                } else {
                    this.f3265a.d(0L);
                    lazySet(E3.c.INSTANCE);
                    this.f3265a.a();
                }
            }
        }
    }

    public G(long j5, TimeUnit timeUnit, x3.p pVar) {
        this.f3263c = j5;
        this.f3264d = timeUnit;
        this.f3262b = pVar;
    }

    @Override // x3.f
    public void W(Q4.b<? super Long> bVar) {
        a aVar = new a(bVar);
        bVar.e(aVar);
        aVar.a(this.f3262b.c(aVar, this.f3263c, this.f3264d));
    }
}
