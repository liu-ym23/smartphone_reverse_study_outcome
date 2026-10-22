package J3;

import java.util.concurrent.TimeUnit;
import x3.p;

/* renamed from: J3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0353d<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f3296c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f3297d;

    /* renamed from: e, reason: collision with root package name */
    final x3.p f3298e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f3299f;

    /* renamed from: J3.d$a */
    static final class a<T> implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3300a;

        /* renamed from: b, reason: collision with root package name */
        final long f3301b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f3302c;

        /* renamed from: d, reason: collision with root package name */
        final p.c f3303d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f3304e;

        /* renamed from: f, reason: collision with root package name */
        Q4.c f3305f;

        /* renamed from: J3.d$a$a, reason: collision with other inner class name */
        final class RunnableC0047a implements Runnable {
            RunnableC0047a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f3300a.a();
                } finally {
                    a.this.f3303d.dispose();
                }
            }
        }

        /* renamed from: J3.d$a$b */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f3307a;

            b(Throwable th) {
                this.f3307a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f3300a.onError(this.f3307a);
                } finally {
                    a.this.f3303d.dispose();
                }
            }
        }

        /* renamed from: J3.d$a$c */
        final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final T f3309a;

            c(T t5) {
                this.f3309a = t5;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f3300a.d(this.f3309a);
            }
        }

        a(Q4.b<? super T> bVar, long j5, TimeUnit timeUnit, p.c cVar, boolean z5) {
            this.f3300a = bVar;
            this.f3301b = j5;
            this.f3302c = timeUnit;
            this.f3303d = cVar;
            this.f3304e = z5;
        }

        @Override // Q4.b
        public void a() {
            this.f3303d.c(new RunnableC0047a(), this.f3301b, this.f3302c);
        }

        @Override // Q4.c
        public void cancel() {
            this.f3305f.cancel();
            this.f3303d.dispose();
        }

        @Override // Q4.b
        public void d(T t5) {
            this.f3303d.c(new c(t5), this.f3301b, this.f3302c);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3305f, cVar)) {
                this.f3305f = cVar;
                this.f3300a.e(this);
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            this.f3305f.h(j5);
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            this.f3303d.c(new b(th), this.f3304e ? this.f3301b : 0L, this.f3302c);
        }
    }

    public C0353d(x3.f<T> fVar, long j5, TimeUnit timeUnit, x3.p pVar, boolean z5) {
        super(fVar);
        this.f3296c = j5;
        this.f3297d = timeUnit;
        this.f3298e = pVar;
        this.f3299f = z5;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(this.f3299f ? bVar : new U3.a(bVar), this.f3296c, this.f3297d, this.f3298e.a(), this.f3299f));
    }
}
