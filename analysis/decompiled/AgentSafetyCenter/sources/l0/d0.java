package l0;

import k0.b2;
import k0.i2;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f7674c = new d0(1, 0, 2);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        int iD = jVar.d(0);
        int i = i2Var.f6958v;
        int iM = i2Var.M(i2Var.f6939b, i2Var.r(i));
        int iG = i2Var.g(i2Var.f6939b, i2Var.r(i + 1));
        for (int iMax = Math.max(iM, iG - iD); iMax < iG; iMax++) {
            Object obj = i2Var.f6940c[i2Var.h(iMax)];
            if (obj instanceof b2) {
                iVar.d((b2) obj);
            } else if (obj instanceof v1) {
                ((v1) obj).c();
            }
        }
        if (iD <= 0) {
            k0.t.c("Check failed");
        }
        int i3 = i2Var.f6958v;
        int iM2 = i2Var.M(i2Var.f6939b, i2Var.r(i3));
        int iG2 = i2Var.g(i2Var.f6939b, i2Var.r(i3 + 1)) - iD;
        if (iG2 < iM2) {
            k0.t.c("Check failed");
        }
        i2Var.I(iG2, iD, i3);
        int i10 = i2Var.i;
        if (i10 >= iM2) {
            i2Var.i = i10 - iD;
        }
    }
}
