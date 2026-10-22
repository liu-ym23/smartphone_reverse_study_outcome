package J3;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class A<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final D3.j<? super Throwable> f3224c;

    /* renamed from: d, reason: collision with root package name */
    final long f3225d;

    static final class a<T> extends AtomicInteger implements x3.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3226a;

        /* renamed from: b, reason: collision with root package name */
        final Q3.f f3227b;

        /* renamed from: c, reason: collision with root package name */
        final Q4.a<? extends T> f3228c;

        /* renamed from: d, reason: collision with root package name */
        final D3.j<? super Throwable> f3229d;

        /* renamed from: e, reason: collision with root package name */
        long f3230e;

        /* renamed from: f, reason: collision with root package name */
        long f3231f;

        a(Q4.b<? super T> bVar, long j5, D3.j<? super Throwable> jVar, Q3.f fVar, Q4.a<? extends T> aVar) {
            this.f3226a = bVar;
            this.f3227b = fVar;
            this.f3228c = aVar;
            this.f3229d = jVar;
            this.f3230e = j5;
        }

        @Override // Q4.b
        public void a() {
            this.f3226a.a();
        }

        void b() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f3227b.c()) {
                    long j5 = this.f3231f;
                    if (j5 != 0) {
                        this.f3231f = 0L;
                        this.f3227b.d(j5);
                    }
                    this.f3228c.c(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // Q4.b
        public void d(T t5) {
            this.f3231f++;
            this.f3226a.d(t5);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            this.f3227b.e(cVar);
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            long j5 = this.f3230e;
            if (j5 != Long.MAX_VALUE) {
                this.f3230e = j5 - 1;
            }
            if (j5 == 0) {
                this.f3226a.onError(th);
                return;
            }
            try {
                if (this.f3229d.test(th)) {
                    b();
                } else {
                    this.f3226a.onError(th);
                }
            } catch (Throwable th2) {
                B3.b.b(th2);
                this.f3226a.onError(new B3.a(th, th2));
            }
        }
    }

    public A(x3.f<T> fVar, long j5, D3.j<? super Throwable> jVar) {
        super(fVar);
        this.f3224c = jVar;
        this.f3225d = j5;
    }

    @Override // x3.f
    public void W(Q4.b<? super T> bVar) {
        Q3.f fVar = new Q3.f(false);
        bVar.e(fVar);
        new a(bVar, this.f3225d, this.f3224c, fVar, this.f3267b).b();
    }
}
