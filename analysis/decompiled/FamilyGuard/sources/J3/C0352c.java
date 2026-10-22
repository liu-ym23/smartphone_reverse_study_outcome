package J3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* renamed from: J3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0352c<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f3281c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f3282d;

    /* renamed from: e, reason: collision with root package name */
    final x3.p f3283e;

    /* renamed from: J3.c$a */
    static final class a<T> extends AtomicReference<A3.c> implements Runnable, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final T f3284a;

        /* renamed from: b, reason: collision with root package name */
        final long f3285b;

        /* renamed from: c, reason: collision with root package name */
        final b<T> f3286c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f3287d = new AtomicBoolean();

        a(T t5, long j5, b<T> bVar) {
            this.f3284a = t5;
            this.f3285b = j5;
            this.f3286c = bVar;
        }

        void a() {
            if (this.f3287d.compareAndSet(false, true)) {
                this.f3286c.b(this.f3285b, this.f3284a, this);
            }
        }

        public void b(A3.c cVar) {
            E3.b.e(this, cVar);
        }

        @Override // A3.c
        public void dispose() {
            E3.b.b(this);
        }

        @Override // A3.c
        public boolean g() {
            return get() == E3.b.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* renamed from: J3.c$b */
    static final class b<T> extends AtomicLong implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3288a;

        /* renamed from: b, reason: collision with root package name */
        final long f3289b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f3290c;

        /* renamed from: d, reason: collision with root package name */
        final p.c f3291d;

        /* renamed from: e, reason: collision with root package name */
        Q4.c f3292e;

        /* renamed from: f, reason: collision with root package name */
        A3.c f3293f;

        /* renamed from: g, reason: collision with root package name */
        volatile long f3294g;

        /* renamed from: h, reason: collision with root package name */
        boolean f3295h;

        b(Q4.b<? super T> bVar, long j5, TimeUnit timeUnit, p.c cVar) {
            this.f3288a = bVar;
            this.f3289b = j5;
            this.f3290c = timeUnit;
            this.f3291d = cVar;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3295h) {
                return;
            }
            this.f3295h = true;
            A3.c cVar = this.f3293f;
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = (a) cVar;
            if (aVar != null) {
                aVar.a();
            }
            this.f3288a.a();
            this.f3291d.dispose();
        }

        void b(long j5, T t5, a<T> aVar) {
            if (j5 == this.f3294g) {
                if (get() == 0) {
                    cancel();
                    this.f3288a.onError(new B3.c("Could not deliver value due to lack of requests"));
                } else {
                    this.f3288a.d(t5);
                    R3.c.d(this, 1L);
                    aVar.dispose();
                }
            }
        }

        @Override // Q4.c
        public void cancel() {
            this.f3292e.cancel();
            this.f3291d.dispose();
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3295h) {
                return;
            }
            long j5 = this.f3294g + 1;
            this.f3294g = j5;
            A3.c cVar = this.f3293f;
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = new a(t5, j5, this);
            this.f3293f = aVar;
            aVar.b(this.f3291d.c(aVar, this.f3289b, this.f3290c));
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3292e, cVar)) {
                this.f3292e = cVar;
                this.f3288a.e(this);
                cVar.h(Long.MAX_VALUE);
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this, j5);
            }
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3295h) {
                S3.a.r(th);
                return;
            }
            this.f3295h = true;
            A3.c cVar = this.f3293f;
            if (cVar != null) {
                cVar.dispose();
            }
            this.f3288a.onError(th);
            this.f3291d.dispose();
        }
    }

    public C0352c(x3.f<T> fVar, long j5, TimeUnit timeUnit, x3.p pVar) {
        super(fVar);
        this.f3281c = j5;
        this.f3282d = timeUnit;
        this.f3283e = pVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new b(new U3.a(bVar), this.f3281c, this.f3282d, this.f3283e.a()));
    }
}
