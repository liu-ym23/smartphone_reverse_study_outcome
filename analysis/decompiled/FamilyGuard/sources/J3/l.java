package J3;

/* loaded from: classes.dex */
public final class l<T> extends x3.f<T> {

    /* renamed from: b, reason: collision with root package name */
    private final x3.m<T> f3380b;

    static final class a<T> implements x3.o<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3381a;

        /* renamed from: b, reason: collision with root package name */
        A3.c f3382b;

        a(Q4.b<? super T> bVar) {
            this.f3381a = bVar;
        }

        @Override // x3.o
        public void a() {
            this.f3381a.a();
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            this.f3382b = cVar;
            this.f3381a.e(this);
        }

        @Override // Q4.c
        public void cancel() {
            this.f3382b.dispose();
        }

        @Override // x3.o
        public void d(T t5) {
            this.f3381a.d(t5);
        }

        @Override // Q4.c
        public void h(long j5) {
        }

        @Override // x3.o
        public void onError(Throwable th) {
            this.f3381a.onError(th);
        }
    }

    public l(x3.m<T> mVar) {
        this.f3380b = mVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3380b.a(new a(bVar));
    }
}
