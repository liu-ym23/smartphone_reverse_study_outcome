package J3;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class E<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f3251c;

    static final class a<T> extends AtomicBoolean implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3252a;

        /* renamed from: b, reason: collision with root package name */
        final long f3253b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3254c;

        /* renamed from: d, reason: collision with root package name */
        Q4.c f3255d;

        /* renamed from: e, reason: collision with root package name */
        long f3256e;

        a(Q4.b<? super T> bVar, long j5) {
            this.f3252a = bVar;
            this.f3253b = j5;
            this.f3256e = j5;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3254c) {
                return;
            }
            this.f3254c = true;
            this.f3252a.a();
        }

        @Override // Q4.c
        public void cancel() {
            this.f3255d.cancel();
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3254c) {
                return;
            }
            long j5 = this.f3256e;
            long j6 = j5 - 1;
            this.f3256e = j6;
            if (j5 > 0) {
                boolean z5 = j6 == 0;
                this.f3252a.d(t5);
                if (z5) {
                    this.f3255d.cancel();
                    a();
                }
            }
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3255d, cVar)) {
                this.f3255d = cVar;
                if (this.f3253b != 0) {
                    this.f3252a.e(this);
                    return;
                }
                cVar.cancel();
                this.f3254c = true;
                Q3.d.d(this.f3252a);
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                if (get() || !compareAndSet(false, true) || j5 < this.f3253b) {
                    this.f3255d.h(j5);
                } else {
                    this.f3255d.h(Long.MAX_VALUE);
                }
            }
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3254c) {
                S3.a.r(th);
                return;
            }
            this.f3254c = true;
            this.f3255d.cancel();
            this.f3252a.onError(th);
        }
    }

    public E(x3.f<T> fVar, long j5) {
        super(fVar);
        this.f3251c = j5;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(bVar, this.f3251c));
    }
}
