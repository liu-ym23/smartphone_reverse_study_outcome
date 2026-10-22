package c0;

import b0.l2;
import b0.s2;
import b0.z1;
import i1.a1;

/* loaded from: classes.dex */
public final class c0 extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final c0 f1730d = new c0(1, 0, 2);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        int iB = kVar.b(0);
        int i2 = s2Var.f1367v;
        int iK = s2Var.K(s2Var.q(i2), s2Var.f1347b);
        int iG = s2Var.g(s2Var.q(i2 + 1), s2Var.f1347b);
        for (int iMax = Math.max(iK, iG - iB); iMax < iG; iMax++) {
            Object obj = s2Var.f1348c[s2Var.h(iMax)];
            if (obj instanceof l2) {
                a1Var.g((l2) obj);
            } else if (obj instanceof z1) {
                ((z1) obj).d();
            }
        }
        if (iB <= 0) {
            b0.s.c("Check failed");
        }
        int i10 = s2Var.f1367v;
        int iK2 = s2Var.K(s2Var.q(i10), s2Var.f1347b);
        int iG2 = s2Var.g(s2Var.q(i10 + 1), s2Var.f1347b) - iB;
        if (iG2 < iK2) {
            b0.s.c("Check failed");
        }
        s2Var.G(iG2, iB, i10);
        int i11 = s2Var.f1354i;
        if (i11 >= iK2) {
            s2Var.f1354i = i11 - iB;
        }
    }
}
