package J3;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class C<T> extends x3.q<T> {

    /* renamed from: a, reason: collision with root package name */
    final x3.f<T> f3234a;

    /* renamed from: b, reason: collision with root package name */
    final T f3235b;

    static final class a<T> implements x3.i<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final x3.s<? super T> f3236a;

        /* renamed from: b, reason: collision with root package name */
        final T f3237b;

        /* renamed from: c, reason: collision with root package name */
        Q4.c f3238c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3239d;

        /* renamed from: e, reason: collision with root package name */
        T f3240e;

        a(x3.s<? super T> sVar, T t5) {
            this.f3236a = sVar;
            this.f3237b = t5;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3239d) {
                return;
            }
            this.f3239d = true;
            this.f3238c = Q3.g.CANCELLED;
            T t5 = this.f3240e;
            this.f3240e = null;
            if (t5 == null) {
                t5 = this.f3237b;
            }
            if (t5 != null) {
                this.f3236a.c(t5);
            } else {
                this.f3236a.onError(new NoSuchElementException());
            }
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3239d) {
                return;
            }
            if (this.f3240e == null) {
                this.f3240e = t5;
                return;
            }
            this.f3239d = true;
            this.f3238c.cancel();
            this.f3238c = Q3.g.CANCELLED;
            this.f3236a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // A3.c
        public void dispose() {
            this.f3238c.cancel();
            this.f3238c = Q3.g.CANCELLED;
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3238c, cVar)) {
                this.f3238c = cVar;
                this.f3236a.b(this);
                cVar.h(Long.MAX_VALUE);
            }
        }

        @Override // A3.c
        public boolean g() {
            return this.f3238c == Q3.g.CANCELLED;
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3239d) {
                S3.a.r(th);
                return;
            }
            this.f3239d = true;
            this.f3238c = Q3.g.CANCELLED;
            this.f3236a.onError(th);
        }
    }

    public C(x3.f<T> fVar, T t5) {
        this.f3234a = fVar;
        this.f3235b = t5;
    }

    @Override // x3.q
    protected void m(x3.s<? super T> sVar) {
        this.f3234a.V(new a(sVar, this.f3235b));
    }
}
