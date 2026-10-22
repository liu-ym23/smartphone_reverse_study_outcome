package c0;

import b0.s2;
import i1.a1;

/* loaded from: classes.dex */
public final class i extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final i f1740d = new i(0, 2, 1);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        int i2;
        j0.e eVar = (j0.e) kVar.c(0);
        int iC = s2Var.c((b0.a) kVar.c(1));
        if (s2Var.f1365t >= iC) {
            b0.s.c("Check failed");
        }
        w7.e0.J(s2Var, cVar, iC);
        int i10 = s2Var.f1365t;
        int iB = s2Var.f1367v;
        while (iB >= 0 && !s2Var.w(iB)) {
            iB = s2Var.B(iB, s2Var.f1347b);
        }
        int iS = iB + 1;
        int I = 0;
        while (iS < i10) {
            if (s2Var.t(i10, iS)) {
                if (s2Var.w(iS)) {
                    I = 0;
                }
                iS++;
            } else {
                I += s2Var.w(iS) ? 1 : s2Var.f1347b[(s2Var.q(iS) * 5) + 1] & 67108863;
                iS += s2Var.s(iS);
            }
        }
        while (true) {
            i2 = s2Var.f1365t;
            if (i2 >= iC) {
                break;
            }
            if (s2Var.t(iC, i2)) {
                int i11 = s2Var.f1365t;
                if (i11 < s2Var.f1366u && (s2Var.f1347b[(s2Var.q(i11) * 5) + 1] & 1073741824) != 0) {
                    cVar.c(s2Var.A(s2Var.f1365t));
                    I = 0;
                }
                s2Var.M();
            } else {
                I += s2Var.I();
            }
        }
        if (i2 != iC) {
            b0.s.c("Check failed");
        }
        eVar.f5076a = I;
    }
}
