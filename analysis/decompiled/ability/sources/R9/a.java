package R9;

import F9.B;
import F9.E;
import F9.F;
import F9.G;
import F9.InterfaceC0229g;
import F9.L;
import F9.M;
import F9.P;
import J9.i;
import com.stepos.statsrpk.d;
import java.io.IOException;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a implements U9.a, InterfaceC0229g {

    /* renamed from: a, reason: collision with root package name */
    public i f1160a;
    public final G b;
    public final d c;

    public a(G g, d dVar) {
        this.b = g;
        this.c = dVar;
    }

    public final void a(F f) {
        E eA = f.a();
        eA.e = new G4.a(2);
        i iVar = new i(new F(eA), this.b);
        this.f1160a = iVar;
        iVar.c(this);
    }

    @Override // F9.InterfaceC0229g
    public final void j(i iVar, IOException iOException) {
        this.c.onFailure(this, iOException, null);
    }

    @Override // F9.InterfaceC0229g
    public final void k(i iVar, M m) {
        try {
            boolean zC = m.c();
            d dVar = this.c;
            if (!zC) {
                dVar.onFailure(this, null, m);
                m.close();
                return;
            }
            P p = m.g;
            k.c(p);
            B bC = p.c();
            if (bC == null || !bC.b.equals("text") || !bC.c.equals("event-stream")) {
                dVar.onFailure(this, new IllegalStateException("Invalid content-type: " + p.c()), m);
                m.close();
                return;
            }
            i iVar2 = this.f1160a;
            if (iVar2 == null) {
                k.n("call");
                throw null;
            }
            if (iVar2.f898j) {
                throw new IllegalStateException("Check failed.");
            }
            iVar2.f898j = true;
            iVar2.e.i();
            L lF = m.f();
            lF.g = G9.b.c;
            M mA = lF.a();
            b bVar = new b(p.f(), this);
            try {
                dVar.onOpen(this, mA);
                do {
                } while (bVar.a());
                dVar.onClosed(this);
                m.close();
            } catch (Exception e) {
                dVar.onFailure(this, e, mA);
                m.close();
            }
        } finally {
        }
    }
}
