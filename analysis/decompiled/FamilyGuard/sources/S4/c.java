package S4;

import R4.t;
import x3.m;
import x3.o;

/* loaded from: classes.dex */
final class c<T> extends m<t<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final R4.b<T> f5266a;

    private static final class a implements A3.c {

        /* renamed from: a, reason: collision with root package name */
        private final R4.b<?> f5267a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f5268b;

        a(R4.b<?> bVar) {
            this.f5267a = bVar;
        }

        @Override // A3.c
        public void dispose() {
            this.f5268b = true;
            this.f5267a.cancel();
        }

        @Override // A3.c
        public boolean g() {
            return this.f5268b;
        }
    }

    c(R4.b<T> bVar) {
        this.f5266a = bVar;
    }

    @Override // x3.m
    protected void e(o<? super t<T>> oVar) {
        R4.b<T> bVarM0clone = this.f5266a.m0clone();
        a aVar = new a(bVarM0clone);
        oVar.b(aVar);
        if (aVar.g()) {
            return;
        }
        boolean z5 = false;
        try {
            t<T> tVarExecute = bVarM0clone.execute();
            if (!aVar.g()) {
                oVar.d(tVarExecute);
            }
            if (aVar.g()) {
                return;
            }
            try {
                oVar.a();
            } catch (Throwable th) {
                th = th;
                z5 = true;
                B3.b.b(th);
                if (z5) {
                    S3.a.r(th);
                    return;
                }
                if (aVar.g()) {
                    return;
                }
                try {
                    oVar.onError(th);
                } catch (Throwable th2) {
                    B3.b.b(th2);
                    S3.a.r(new B3.a(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
