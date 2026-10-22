package K0;

import C0.v;
import K0.h;
import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class p implements z0.i<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final h f3562a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.b f3563b;

    static class a implements h.b {

        /* renamed from: a, reason: collision with root package name */
        private final n f3564a;

        /* renamed from: b, reason: collision with root package name */
        private final X0.d f3565b;

        a(n nVar, X0.d dVar) {
            this.f3564a = nVar;
            this.f3565b = dVar;
        }

        @Override // K0.h.b
        public void a(D0.d dVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.f3565b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                dVar.c(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // K0.h.b
        public void b() {
            this.f3564a.c();
        }
    }

    public p(h hVar, D0.b bVar) {
        this.f3562a = hVar;
        this.f3563b = bVar;
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Bitmap> a(InputStream inputStream, int i5, int i6, C1342h c1342h) {
        boolean z5;
        n nVar;
        if (inputStream instanceof n) {
            nVar = (n) inputStream;
            z5 = false;
        } else {
            z5 = true;
            nVar = new n(inputStream, this.f3563b);
        }
        X0.d dVarC = X0.d.c(nVar);
        try {
            v<Bitmap> vVarE = this.f3562a.e(new X0.h(dVarC), i5, i6, c1342h, new a(nVar, dVarC));
            dVarC.f();
            if (z5) {
                nVar.f();
            }
            return vVarE;
        } finally {
        }
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, C1342h c1342h) {
        return this.f3562a.m(inputStream);
    }
}
