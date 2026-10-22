package S4;

import R4.t;
import x3.m;
import x3.o;

/* loaded from: classes.dex */
final class b<T> extends m<t<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final R4.b<T> f5261a;

    private static final class a<T> implements A3.c, R4.d<T> {

        /* renamed from: a, reason: collision with root package name */
        private final R4.b<?> f5262a;

        /* renamed from: b, reason: collision with root package name */
        private final o<? super t<T>> f5263b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f5264c;

        /* renamed from: d, reason: collision with root package name */
        boolean f5265d = false;

        a(R4.b<?> bVar, o<? super t<T>> oVar) {
            this.f5262a = bVar;
            this.f5263b = oVar;
        }

        @Override // R4.d
        public void a(R4.b<T> bVar, t<T> tVar) {
            if (this.f5264c) {
                return;
            }
            try {
                this.f5263b.d(tVar);
                if (this.f5264c) {
                    return;
                }
                this.f5265d = true;
                this.f5263b.a();
            } catch (Throwable th) {
                B3.b.b(th);
                if (this.f5265d) {
                    S3.a.r(th);
                    return;
                }
                if (this.f5264c) {
                    return;
                }
                try {
                    this.f5263b.onError(th);
                } catch (Throwable th2) {
                    B3.b.b(th2);
                    S3.a.r(new B3.a(th, th2));
                }
            }
        }

        @Override // R4.d
        public void b(R4.b<T> bVar, Throwable th) {
            if (bVar.c()) {
                return;
            }
            try {
                this.f5263b.onError(th);
            } catch (Throwable th2) {
                B3.b.b(th2);
                S3.a.r(new B3.a(th, th2));
            }
        }

        @Override // A3.c
        public void dispose() {
            this.f5264c = true;
            this.f5262a.cancel();
        }

        @Override // A3.c
        public boolean g() {
            return this.f5264c;
        }
    }

    b(R4.b<T> bVar) {
        this.f5261a = bVar;
    }

    @Override // x3.m
    protected void e(o<? super t<T>> oVar) {
        R4.b<T> bVarM0clone = this.f5261a.m0clone();
        a aVar = new a(bVarM0clone, oVar);
        oVar.b(aVar);
        if (aVar.g()) {
            return;
        }
        bVarM0clone.o(aVar);
    }
}
