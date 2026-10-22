package G4;

import C4.D;
import C4.F;
import C4.x;
import L4.o;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class b implements x {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1916a;

    public b(boolean z5) {
        this.f1916a = z5;
    }

    @Override // C4.x
    public F a(x.a aVar) throws IOException {
        boolean z5;
        g gVar = (g) aVar;
        F4.c cVarF = gVar.f();
        D dA = gVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarF.p(dA);
        F.a aVarL = null;
        if (!f.a(dA.f()) || dA.a() == null) {
            cVarF.j();
            z5 = false;
        } else {
            if ("100-continue".equalsIgnoreCase(dA.c("Expect"))) {
                cVarF.g();
                cVarF.n();
                aVarL = cVarF.l(true);
                z5 = true;
            } else {
                z5 = false;
            }
            if (aVarL != null) {
                cVarF.j();
                if (!cVarF.c().n()) {
                    cVarF.i();
                }
            } else if (dA.a().f()) {
                cVarF.g();
                dA.a().h(o.a(cVarF.d(dA, true)));
            } else {
                L4.f fVarA = o.a(cVarF.d(dA, false));
                dA.a().h(fVarA);
                fVarA.close();
            }
        }
        if (dA.a() == null || !dA.a().f()) {
            cVarF.f();
        }
        if (!z5) {
            cVarF.n();
        }
        if (aVarL == null) {
            aVarL = cVarF.l(false);
        }
        F fC = aVarL.q(dA).h(cVarF.c().k()).r(jCurrentTimeMillis).p(System.currentTimeMillis()).c();
        int iM = fC.m();
        if (iM == 100) {
            fC = cVarF.l(false).q(dA).h(cVarF.c().k()).r(jCurrentTimeMillis).p(System.currentTimeMillis()).c();
            iM = fC.m();
        }
        cVarF.m(fC);
        F fC2 = (this.f1916a && iM == 101) ? fC.C().b(D4.e.f1209d).c() : fC.C().b(cVarF.k(fC)).c();
        if ("close".equalsIgnoreCase(fC2.I().c("Connection")) || "close".equalsIgnoreCase(fC2.r("Connection"))) {
            cVarF.i();
        }
        if ((iM != 204 && iM != 205) || fC2.a().o() <= 0) {
            return fC2;
        }
        throw new ProtocolException("HTTP " + iM + " had non-zero Content-Length: " + fC2.a().o());
    }
}
