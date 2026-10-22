package E4;

import C4.B;
import C4.D;
import C4.F;
import C4.v;
import C4.x;
import D4.e;
import E4.b;
import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class a implements x {
    public a(@Nullable c cVar) {
    }

    private static v b(v vVar, v vVar2) {
        v.a aVar = new v.a();
        int iH = vVar.h();
        for (int i5 = 0; i5 < iH; i5++) {
            String strE = vVar.e(i5);
            String strI = vVar.i(i5);
            if ((!"Warning".equalsIgnoreCase(strE) || !strI.startsWith("1")) && (c(strE) || !d(strE) || vVar2.c(strE) == null)) {
                D4.a.f1202a.b(aVar, strE, strI);
            }
        }
        int iH2 = vVar2.h();
        for (int i6 = 0; i6 < iH2; i6++) {
            String strE2 = vVar2.e(i6);
            if (!c(strE2) && d(strE2)) {
                D4.a.f1202a.b(aVar, strE2, vVar2.i(i6));
            }
        }
        return aVar.e();
    }

    static boolean c(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean d(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static F e(F f5) {
        return (f5 == null || f5.a() == null) ? f5 : f5.C().b(null).c();
    }

    @Override // C4.x
    public F a(x.a aVar) throws IOException {
        b bVarC = new b.a(System.currentTimeMillis(), aVar.a(), null).c();
        D d6 = bVarC.f1604a;
        F f5 = bVarC.f1605b;
        if (d6 == null && f5 == null) {
            return new F.a().q(aVar.a()).o(B.HTTP_1_1).g(504).l("Unsatisfiable Request (only-if-cached)").b(e.f1209d).r(-1L).p(System.currentTimeMillis()).c();
        }
        if (d6 == null) {
            return f5.C().d(e(f5)).c();
        }
        F fB = aVar.b(d6);
        if (f5 != null) {
            if (fB.m() == 304) {
                f5.C().j(b(f5.v(), fB.v())).r(fB.L()).p(fB.G()).d(e(f5)).m(e(fB)).c();
                fB.a().close();
                throw null;
            }
            e.g(f5.a());
        }
        return fB.C().d(e(f5)).m(e(fB)).c();
    }
}
