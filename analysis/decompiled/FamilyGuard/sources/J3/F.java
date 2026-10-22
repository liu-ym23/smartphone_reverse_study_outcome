package J3;

/* loaded from: classes.dex */
public final class F<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final D3.j<? super T> f3257c;

    static final class a<T> implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3258a;

        /* renamed from: b, reason: collision with root package name */
        final D3.j<? super T> f3259b;

        /* renamed from: c, reason: collision with root package name */
        Q4.c f3260c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3261d;

        a(Q4.b<? super T> bVar, D3.j<? super T> jVar) {
            this.f3258a = bVar;
            this.f3259b = jVar;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3261d) {
                return;
            }
            this.f3261d = true;
            this.f3258a.a();
        }

        @Override // Q4.c
        public void cancel() {
            this.f3260c.cancel();
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3261d) {
                return;
            }
            try {
                if (this.f3259b.test(t5)) {
                    this.f3258a.d(t5);
                    return;
                }
                this.f3261d = true;
                this.f3260c.cancel();
                this.f3258a.a();
            } catch (Throwable th) {
                B3.b.b(th);
                this.f3260c.cancel();
                onError(th);
            }
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3260c, cVar)) {
                this.f3260c = cVar;
                this.f3258a.e(this);
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            this.f3260c.h(j5);
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3261d) {
                S3.a.r(th);
            } else {
                this.f3261d = true;
                this.f3258a.onError(th);
            }
        }
    }

    public F(x3.f<T> fVar, D3.j<? super T> jVar) {
        super(fVar);
        this.f3257c = jVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(bVar, this.f3257c));
    }
}
