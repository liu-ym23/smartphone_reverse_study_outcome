package l0;

import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final j f7686c = new j(0, 2, 1);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        int i;
        s0.d dVar2 = (s0.d) jVar.e(0);
        int iC = i2Var.c((k0.b) jVar.e(1));
        if (i2Var.f6956t >= iC) {
            k0.t.c("Check failed");
        }
        id.c.D(i2Var, dVar, iC);
        int i3 = i2Var.f6956t;
        int iD = i2Var.f6958v;
        while (iD >= 0 && !i2Var.x(iD)) {
            iD = i2Var.D(i2Var.f6939b, iD);
        }
        int iT = iD + 1;
        int iK = 0;
        while (iT < i3) {
            if (i2Var.u(i3, iT)) {
                if (i2Var.x(iT)) {
                    iK = 0;
                }
                iT++;
            } else {
                iK += i2Var.x(iT) ? 1 : i2Var.f6939b[(i2Var.r(iT) * 5) + 1] & 67108863;
                iT += i2Var.t(iT);
            }
        }
        while (true) {
            i = i2Var.f6956t;
            if (i >= iC) {
                break;
            }
            if (i2Var.u(iC, i)) {
                int i10 = i2Var.f6956t;
                if (i10 < i2Var.f6957u && (i2Var.f6939b[(i2Var.r(i10) * 5) + 1] & 1073741824) != 0) {
                    dVar.d(i2Var.C(i2Var.f6956t));
                    iK = 0;
                }
                i2Var.O();
            } else {
                iK += i2Var.K();
            }
        }
        if (i != iC) {
            k0.t.c("Check failed");
        }
        dVar2.f11175a = iK;
    }
}
