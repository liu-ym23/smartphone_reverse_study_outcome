package G4;

import C4.D;
import C4.E;
import C4.F;
import C4.m;
import C4.n;
import C4.x;
import C4.y;
import L4.l;
import L4.o;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements x {

    /* renamed from: a, reason: collision with root package name */
    private final n f1915a;

    public a(n nVar) {
        this.f1915a = nVar;
    }

    private String b(List<m> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                sb.append("; ");
            }
            m mVar = list.get(i5);
            sb.append(mVar.c());
            sb.append('=');
            sb.append(mVar.k());
        }
        return sb.toString();
    }

    @Override // C4.x
    public F a(x.a aVar) {
        D dA = aVar.a();
        D.a aVarG = dA.g();
        E eA = dA.a();
        if (eA != null) {
            y yVarB = eA.b();
            if (yVarB != null) {
                aVarG.c("Content-Type", yVarB.toString());
            }
            long jA = eA.a();
            if (jA != -1) {
                aVarG.c("Content-Length", Long.toString(jA));
                aVarG.f("Transfer-Encoding");
            } else {
                aVarG.c("Transfer-Encoding", "chunked");
                aVarG.f("Content-Length");
            }
        }
        boolean z5 = false;
        if (dA.c("Host") == null) {
            aVarG.c("Host", D4.e.s(dA.i(), false));
        }
        if (dA.c("Connection") == null) {
            aVarG.c("Connection", "Keep-Alive");
        }
        if (dA.c("Accept-Encoding") == null && dA.c("Range") == null) {
            aVarG.c("Accept-Encoding", "gzip");
            z5 = true;
        }
        List<m> listB = this.f1915a.b(dA.i());
        if (!listB.isEmpty()) {
            aVarG.c("Cookie", b(listB));
        }
        if (dA.c("User-Agent") == null) {
            aVarG.c("User-Agent", D4.f.a());
        }
        F fB = aVar.b(aVarG.b());
        e.e(this.f1915a, dA.i(), fB.v());
        F.a aVarQ = fB.C().q(dA);
        if (z5 && "gzip".equalsIgnoreCase(fB.r("Content-Encoding")) && e.c(fB)) {
            l lVar = new l(fB.a().w());
            aVarQ.j(fB.v().f().f("Content-Encoding").f("Content-Length").e());
            aVarQ.b(new h(fB.r("Content-Type"), -1L, o.b(lVar)));
        }
        return aVarQ.c();
    }
}
