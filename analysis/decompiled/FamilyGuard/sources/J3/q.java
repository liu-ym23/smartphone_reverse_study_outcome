package J3;

/* loaded from: classes.dex */
public final class q<T, U> extends AbstractC0350a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final D3.h<? super T, ? extends U> f3403c;

    static final class a<T, U> extends P3.a<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final D3.h<? super T, ? extends U> f3404f;

        a(G3.a<? super U> aVar, D3.h<? super T, ? extends U> hVar) {
            super(aVar);
            this.f3404f = hVar;
        }

        @Override // G3.b
        public int b(int i5) {
            return j(i5);
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f4833d) {
                return;
            }
            if (this.f4834e != 0) {
                this.f4830a.d(null);
                return;
            }
            try {
                this.f4830a.d(F3.b.d(this.f3404f.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                i(th);
            }
        }

        @Override // G3.a
        public boolean f(T t5) {
            if (this.f4833d) {
                return false;
            }
            try {
                return this.f4830a.f(F3.b.d(this.f3404f.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                i(th);
                return true;
            }
        }

        @Override // G3.f
        public U poll() {
            T tPoll = this.f4832c.poll();
            if (tPoll != null) {
                return (U) F3.b.d(this.f3404f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    static final class b<T, U> extends P3.b<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final D3.h<? super T, ? extends U> f3405f;

        b(Q4.b<? super U> bVar, D3.h<? super T, ? extends U> hVar) {
            super(bVar);
            this.f3405f = hVar;
        }

        @Override // G3.b
        public int b(int i5) {
            return j(i5);
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f4838d) {
                return;
            }
            if (this.f4839e != 0) {
                this.f4835a.d(null);
                return;
            }
            try {
                this.f4835a.d(F3.b.d(this.f3405f.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                i(th);
            }
        }

        @Override // G3.f
        public U poll() {
            T tPoll = this.f4837c.poll();
            if (tPoll != null) {
                return (U) F3.b.d(this.f3405f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public q(x3.f<T> fVar, D3.h<? super T, ? extends U> hVar) {
        super(fVar);
        this.f3403c = hVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super U> bVar) {
        if (bVar instanceof G3.a) {
            this.f3267b.V(new a((G3.a) bVar, this.f3403c));
        } else {
            this.f3267b.V(new b(bVar, this.f3403c));
        }
    }
}
