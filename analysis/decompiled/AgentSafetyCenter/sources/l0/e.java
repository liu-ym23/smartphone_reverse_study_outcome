package l0;

import k0.b2;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final e f7675c = new e(0, 2, 1);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        k0.b bVar = (k0.b) jVar.e(0);
        Object objE = jVar.e(1);
        if (objE instanceof b2) {
            b2 b2Var = (b2) objE;
            iVar.f11188e.b(b2Var);
            iVar.f11187d.a(b2Var);
        }
        if (i2Var.f6950n != 0) {
            k0.t.c("Can only append a slot if not current inserting");
        }
        int i = i2Var.i;
        int i3 = i2Var.f6946j;
        int iC = i2Var.c(bVar);
        int iG = i2Var.g(i2Var.f6939b, i2Var.r(iC + 1));
        i2Var.i = iG;
        i2Var.f6946j = iG;
        i2Var.w(1, iC);
        if (i >= iG) {
            i++;
            i3++;
        }
        i2Var.f6940c[iG] = objE;
        i2Var.i = i;
        i2Var.f6946j = i3;
    }
}
