package eb;

import ab.q;
import ab.t;
import ab.z;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a implements q {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3242a = new a();

    @Override // ab.q
    public final z a(fb.g gVar) throws IOException {
        i iVar = gVar.f3649a;
        synchronized (iVar) {
            try {
                if (!iVar.f3285s) {
                    throw new IllegalStateException("released");
                }
                if (iVar.f3284r) {
                    throw new IllegalStateException("Check failed.");
                }
                if (iVar.f3283q) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar = iVar.f3279m;
        q7.k.b(eVar);
        t tVar = iVar.f3272f;
        try {
            fb.e eVarJ = eVar.a(gVar.f3654f, gVar.f3655g, gVar.f3656h, tVar.D, tVar.f632k, !q7.k.a(gVar.f3653e.f662b, "GET")).j(tVar, gVar);
            q7.k.e(eVar, "finder");
            c1.o oVar = new c1.o();
            oVar.f1834b = iVar;
            oVar.f1835c = eVar;
            oVar.f1836d = eVarJ;
            oVar.f1837e = eVarJ.g();
            iVar.f3282p = oVar;
            iVar.f3287u = oVar;
            synchronized (iVar) {
                iVar.f3283q = true;
                iVar.f3284r = true;
            }
            if (iVar.f3286t) {
                throw new IOException("Canceled");
            }
            return fb.g.a(gVar, 0, oVar, null, 61).b(gVar.f3653e);
        } catch (o e10) {
            eVar.c(e10.f3317g);
            throw e10;
        } catch (IOException e11) {
            eVar.c(e11);
            throw new o(e11);
        }
    }
}
