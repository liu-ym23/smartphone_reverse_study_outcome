package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5311v {
    public static AbstractC5284h a(String str, Y0 y02, float f10) throws SymbolMappingNotFoundException {
        float f11;
        Z0 z0N = y02.n();
        int iM = y02.m();
        C5292l c5292lJ = z0N.j(str, iM);
        C5281f0 c5281f0H = c5292lJ.h();
        float fB = c5281f0H.b();
        float fA = c5281f0H.a();
        while (true) {
            f11 = fB + fA;
            if (f11 >= f10 || !z0N.C(c5292lJ)) {
                break;
            }
            c5292lJ = z0N.K(c5292lJ, iM);
            C5281f0 c5281f0H2 = c5292lJ.h();
            fB = c5281f0H2.b();
            fA = c5281f0H2.a();
        }
        if (f11 < f10 && z0N.E(c5292lJ)) {
            q1 q1Var = new q1();
            C5319z c5319zQ = z0N.q(c5292lJ, iM);
            if (c5319zQ.g()) {
                q1Var.b(new C5296n(c5319zQ.d()));
            }
            boolean zF = c5319zQ.f();
            if (zF) {
                q1Var.b(new C5296n(c5319zQ.b()));
            }
            if (c5319zQ.e()) {
                q1Var.b(new C5296n(c5319zQ.a()));
            }
            C5296n c5296n = new C5296n(c5319zQ.c());
            while (q1Var.h() + q1Var.g() <= f10) {
                if (c5319zQ.g() && c5319zQ.e()) {
                    q1Var.a(1, c5296n);
                    if (zF) {
                        q1Var.a(q1Var.s() - 1, c5296n);
                    }
                } else if (c5319zQ.e()) {
                    q1Var.a(0, c5296n);
                } else {
                    q1Var.b(c5296n);
                }
            }
            return q1Var;
        }
        return new C5296n(c5292lJ);
    }

    public static AbstractC5284h b(W0 w02, Y0 y02, int i10) throws SymbolMappingNotFoundException {
        if (i10 > 4) {
            return w02.f(y02);
        }
        Z0 z0N = y02.n();
        int iM = y02.m();
        C5292l c5292lJ = z0N.j(w02.q(), iM);
        int i11 = 1;
        while (i11 <= i10 && z0N.C(c5292lJ)) {
            c5292lJ = z0N.K(c5292lJ, iM);
            i11++;
        }
        if (i11 > i10 || z0N.C(c5292lJ)) {
            return new C5296n(c5292lJ);
        }
        C5296n c5296n = new C5296n(z0N.F('A', "mathnormal", iM));
        return a(w02.q(), y02, i10 * (c5296n.h() + c5296n.g()));
    }
}
