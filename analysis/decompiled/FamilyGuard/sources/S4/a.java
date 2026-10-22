package S4;

import R4.t;
import x3.m;
import x3.o;

/* loaded from: classes.dex */
final class a<T> extends m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<t<T>> f5258a;

    /* renamed from: S4.a$a, reason: collision with other inner class name */
    private static class C0080a<R> implements o<t<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final o<? super R> f5259a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5260b;

        C0080a(o<? super R> oVar) {
            this.f5259a = oVar;
        }

        @Override // x3.o
        public void a() {
            if (this.f5260b) {
                return;
            }
            this.f5259a.a();
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            this.f5259a.b(cVar);
        }

        @Override // x3.o
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(t<R> tVar) {
            if (tVar.e()) {
                this.f5259a.d(tVar.a());
                return;
            }
            this.f5260b = true;
            d dVar = new d(tVar);
            try {
                this.f5259a.onError(dVar);
            } catch (Throwable th) {
                B3.b.b(th);
                S3.a.r(new B3.a(dVar, th));
            }
        }

        @Override // x3.o
        public void onError(Throwable th) {
            if (!this.f5260b) {
                this.f5259a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            S3.a.r(assertionError);
        }
    }

    a(m<t<T>> mVar) {
        this.f5258a = mVar;
    }

    @Override // x3.m
    protected void e(o<? super T> oVar) {
        this.f5258a.a(new C0080a(oVar));
    }
}
