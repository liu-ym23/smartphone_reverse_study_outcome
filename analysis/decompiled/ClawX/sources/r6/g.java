package r6;

import java.io.IOException;
import java.net.SocketException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final o f5141a;

    /* renamed from: b, reason: collision with root package name */
    public final h f5142b;

    /* renamed from: c, reason: collision with root package name */
    public final s6.f f5143c;
    public boolean d;

    public g(o oVar, h finder, s6.f fVar) {
        kotlin.jvm.internal.p.e(finder, "finder");
        this.f5141a = oVar;
        this.f5142b = finder;
        this.f5143c = fVar;
    }

    public static IOException a(g gVar, boolean z, IOException iOException, int i8) {
        boolean z2 = (i8 & 4) == 0;
        boolean z8 = (i8 & 8) == 0;
        if (iOException != null) {
            gVar.c(iOException);
        }
        return gVar.f5141a.g(gVar, z8 && !z, z2 && !z, z2 && z, z8 && z, iOException);
    }

    public final p b() {
        s6.e eVarE = this.f5143c.e();
        p pVar = eVarE instanceof p ? (p) eVarE : null;
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    public final void c(IOException iOException) {
        this.d = true;
        this.f5143c.e().b(this.f5141a, iOException);
    }

    public final a4.d d() throws SocketException {
        o oVar = this.f5141a;
        if (oVar.f5164j) {
            throw new IllegalStateException("Check failed.");
        }
        oVar.f5164j = true;
        oVar.d.j();
        synchronized (oVar) {
            if (oVar.f5172r == null) {
                throw new IllegalStateException("Check failed.");
            }
            if (oVar.f5168n || oVar.f5169o) {
                throw new IllegalStateException("Check failed.");
            }
            if (oVar.f5166l) {
                throw new IllegalStateException("Check failed.");
            }
            if (!oVar.f5167m) {
                throw new IllegalStateException("Check failed.");
            }
            oVar.f5167m = false;
            oVar.f5168n = true;
            oVar.f5169o = true;
        }
        s6.e eVarE = this.f5143c.e();
        kotlin.jvm.internal.p.c(eVarE, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        p pVar = (p) eVarE;
        pVar.f5176e.setSoTimeout(0);
        pVar.g();
        return new a4.d(this);
    }
}
