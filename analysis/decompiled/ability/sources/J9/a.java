package J9;

import F9.A;
import F9.F;
import F9.M;
import F9.z;
import java.io.IOException;
import okhttp3.internal.connection.RouteException;

/* loaded from: classes4.dex */
public final class a implements A {

    /* renamed from: a, reason: collision with root package name */
    public static final a f890a = new a();

    @Override // F9.A
    public final M intercept(z zVar) throws IOException {
        K9.g gVar = (K9.g) zVar;
        i iVar = gVar.f915a;
        synchronized (iVar) {
            try {
                if (!iVar.n) {
                    throw new IllegalStateException("released");
                }
                if (iVar.m) {
                    throw new IllegalStateException("Check failed.");
                }
                if (iVar.l) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar = iVar.h;
        kotlin.jvm.internal.k.c(eVar);
        F f = iVar.f897a;
        try {
            G6.c cVar = new G6.c(iVar, iVar.d, eVar, eVar.c(gVar.f, gVar.g, gVar.h, f.f, !kotlin.jvm.internal.k.b(gVar.e.b, "GET")).j(f, gVar));
            iVar.k = cVar;
            iVar.p = cVar;
            synchronized (iVar) {
                iVar.l = true;
                iVar.m = true;
            }
            if (iVar.o) {
                throw new IOException("Canceled");
            }
            return K9.g.a(gVar, 0, cVar, null, 61).b(gVar.e);
        } catch (IOException e) {
            eVar.e(e);
            throw new RouteException(e);
        } catch (RouteException e6) {
            eVar.e(e6.b);
            throw e6;
        }
    }
}
