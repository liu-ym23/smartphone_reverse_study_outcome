package J3;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class t<T> extends AbstractC0350a<T, T> implements D3.c<T> {

    /* renamed from: c, reason: collision with root package name */
    final D3.c<? super T> f3439c;

    static final class a<T> extends AtomicLong implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3440a;

        /* renamed from: b, reason: collision with root package name */
        final D3.c<? super T> f3441b;

        /* renamed from: c, reason: collision with root package name */
        Q4.c f3442c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3443d;

        a(Q4.b<? super T> bVar, D3.c<? super T> cVar) {
            this.f3440a = bVar;
            this.f3441b = cVar;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3443d) {
                return;
            }
            this.f3443d = true;
            this.f3440a.a();
        }

        @Override // Q4.c
        public void cancel() {
            this.f3442c.cancel();
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3443d) {
                return;
            }
            if (get() != 0) {
                this.f3440a.d(t5);
                R3.c.d(this, 1L);
                return;
            }
            try {
                this.f3441b.accept(t5);
            } catch (Throwable th) {
                B3.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3442c, cVar)) {
                this.f3442c = cVar;
                this.f3440a.e(this);
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
            if (this.f3443d) {
                S3.a.r(th);
            } else {
                this.f3443d = true;
                this.f3440a.onError(th);
            }
        }
    }

    public t(x3.f<T> fVar) {
        super(fVar);
        this.f3439c = this;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(bVar, this.f3439c));
    }

    @Override // D3.c
    public void accept(T t5) {
    }
}
