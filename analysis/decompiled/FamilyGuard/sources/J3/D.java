package J3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class D<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final x3.p f3241c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f3242d;

    static final class a<T> extends AtomicReference<Thread> implements x3.i<T>, Q4.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3243a;

        /* renamed from: b, reason: collision with root package name */
        final p.c f3244b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<Q4.c> f3245c = new AtomicReference<>();

        /* renamed from: d, reason: collision with root package name */
        final AtomicLong f3246d = new AtomicLong();

        /* renamed from: e, reason: collision with root package name */
        final boolean f3247e;

        /* renamed from: f, reason: collision with root package name */
        Q4.a<T> f3248f;

        /* renamed from: J3.D$a$a, reason: collision with other inner class name */
        static final class RunnableC0045a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final Q4.c f3249a;

            /* renamed from: b, reason: collision with root package name */
            final long f3250b;

            RunnableC0045a(Q4.c cVar, long j5) {
                this.f3249a = cVar;
                this.f3250b = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3249a.h(this.f3250b);
            }
        }

        a(Q4.b<? super T> bVar, p.c cVar, Q4.a<T> aVar, boolean z5) {
            this.f3243a = bVar;
            this.f3244b = cVar;
            this.f3248f = aVar;
            this.f3247e = !z5;
        }

        @Override // Q4.b
        public void a() {
            this.f3243a.a();
            this.f3244b.dispose();
        }

        void b(long j5, Q4.c cVar) {
            if (this.f3247e || Thread.currentThread() == get()) {
                cVar.h(j5);
            } else {
                this.f3244b.b(new RunnableC0045a(cVar, j5));
            }
        }

        @Override // Q4.c
        public void cancel() {
            Q3.g.b(this.f3245c);
            this.f3244b.dispose();
        }

        @Override // Q4.b
        public void d(T t5) {
            this.f3243a.d(t5);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.j(this.f3245c, cVar)) {
                long andSet = this.f3246d.getAndSet(0L);
                if (andSet != 0) {
                    b(andSet, cVar);
                }
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                Q4.c cVar = this.f3245c.get();
                if (cVar != null) {
                    b(j5, cVar);
                    return;
                }
                R3.c.a(this.f3246d, j5);
                Q4.c cVar2 = this.f3245c.get();
                if (cVar2 != null) {
                    long andSet = this.f3246d.getAndSet(0L);
                    if (andSet != 0) {
                        b(andSet, cVar2);
                    }
                }
            }
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            this.f3243a.onError(th);
            this.f3244b.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Q4.a<T> aVar = this.f3248f;
            this.f3248f = null;
            aVar.c(this);
        }
    }

    public D(x3.f<T> fVar, x3.p pVar, boolean z5) {
        super(fVar);
        this.f3241c = pVar;
        this.f3242d = z5;
    }

    @Override // x3.f
    public void W(Q4.b<? super T> bVar) {
        p.c cVarA = this.f3241c.a();
        a aVar = new a(bVar, cVarA, this.f3267b, this.f3242d);
        bVar.e(aVar);
        cVarA.b(aVar);
    }
}
