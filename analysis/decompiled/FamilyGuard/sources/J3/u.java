package J3;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class u<T> extends AbstractC0350a<T, T> {

    static final class a<T> extends AtomicLong implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3444a;

        /* renamed from: b, reason: collision with root package name */
        Q4.c f3445b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3446c;

        a(Q4.b<? super T> bVar) {
            this.f3444a = bVar;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3446c) {
                return;
            }
            this.f3446c = true;
            this.f3444a.a();
        }

        @Override // Q4.c
        public void cancel() {
            this.f3445b.cancel();
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3446c) {
                return;
            }
            if (get() == 0) {
                onError(new B3.c("could not emit value due to lack of requests"));
            } else {
                this.f3444a.d(t5);
                R3.c.d(this, 1L);
            }
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3445b, cVar)) {
                this.f3445b = cVar;
                this.f3444a.e(this);
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
            if (this.f3446c) {
                S3.a.r(th);
            } else {
                this.f3446c = true;
                this.f3444a.onError(th);
            }
        }
    }

    public u(x3.f<T> fVar) {
        super(fVar);
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(bVar));
    }
}
