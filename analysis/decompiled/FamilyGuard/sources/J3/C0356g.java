package J3;

/* renamed from: J3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0356g<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final D3.j<? super T> f3324c;

    /* renamed from: J3.g$a */
    static final class a<T> extends P3.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final D3.j<? super T> f3325f;

        a(G3.a<? super T> aVar, D3.j<? super T> jVar) {
            super(aVar);
            this.f3325f = jVar;
        }

        @Override // G3.b
        public int b(int i5) {
            return j(i5);
        }

        @Override // Q4.b
        public void d(T t5) {
            if (f(t5)) {
                return;
            }
            this.f4831b.h(1L);
        }

        @Override // G3.a
        public boolean f(T t5) {
            if (this.f4833d) {
                return false;
            }
            if (this.f4834e != 0) {
                return this.f4830a.f(null);
            }
            try {
                return this.f3325f.test(t5) && this.f4830a.f(t5);
            } catch (Throwable th) {
                i(th);
                return true;
            }
        }

        @Override // G3.f
        public T poll() {
            G3.c<T> cVar = this.f4832c;
            D3.j<? super T> jVar = this.f3325f;
            while (true) {
                T tPoll = cVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (jVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.f4834e == 2) {
                    cVar.h(1L);
                }
            }
        }
    }

    /* renamed from: J3.g$b */
    static final class b<T> extends P3.b<T, T> implements G3.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final D3.j<? super T> f3326f;

        b(Q4.b<? super T> bVar, D3.j<? super T> jVar) {
            super(bVar);
            this.f3326f = jVar;
        }

        @Override // G3.b
        public int b(int i5) {
            return j(i5);
        }

        @Override // Q4.b
        public void d(T t5) {
            if (f(t5)) {
                return;
            }
            this.f4836b.h(1L);
        }

        @Override // G3.a
        public boolean f(T t5) {
            if (this.f4838d) {
                return false;
            }
            if (this.f4839e != 0) {
                this.f4835a.d(null);
                return true;
            }
            try {
                boolean zTest = this.f3326f.test(t5);
                if (zTest) {
                    this.f4835a.d(t5);
                }
                return zTest;
            } catch (Throwable th) {
                i(th);
                return true;
            }
        }

        @Override // G3.f
        public T poll() {
            G3.c<T> cVar = this.f4837c;
            D3.j<? super T> jVar = this.f3326f;
            while (true) {
                T tPoll = cVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (jVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.f4839e == 2) {
                    cVar.h(1L);
                }
            }
        }
    }

    public C0356g(x3.f<T> fVar, D3.j<? super T> jVar) {
        super(fVar);
        this.f3324c = jVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        if (bVar instanceof G3.a) {
            this.f3267b.V(new a((G3.a) bVar, this.f3324c));
        } else {
            this.f3267b.V(new b(bVar, this.f3324c));
        }
    }
}
