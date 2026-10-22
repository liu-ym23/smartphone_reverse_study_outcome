package S4;

import R4.t;
import x3.m;
import x3.o;

/* loaded from: classes.dex */
final class f<T> extends m<e<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final m<t<T>> f5271a;

    private static class a<R> implements o<t<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final o<? super e<R>> f5272a;

        a(o<? super e<R>> oVar) {
            this.f5272a = oVar;
        }

        @Override // x3.o
        public void a() {
            this.f5272a.a();
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            this.f5272a.b(cVar);
        }

        @Override // x3.o
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(t<R> tVar) {
            this.f5272a.d(e.b(tVar));
        }

        @Override // x3.o
        public void onError(Throwable th) {
            try {
                this.f5272a.d(e.a(th));
                this.f5272a.a();
            } catch (Throwable th2) {
                try {
                    this.f5272a.onError(th2);
                } catch (Throwable th3) {
                    B3.b.b(th3);
                    S3.a.r(new B3.a(th2, th3));
                }
            }
        }
    }

    f(m<t<T>> mVar) {
        this.f5271a = mVar;
    }

    @Override // x3.m
    protected void e(o<? super e<T>> oVar) {
        this.f5271a.a(new a(oVar));
    }
}
