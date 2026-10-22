package x9;

import f8.n;
import f8.n0;
import f8.s;
import f8.t;
import i8.l0;
import i8.u;
import java.util.Collection;
import m.x;
import o4.d0;
import q7.k;

/* loaded from: classes.dex */
public final class b extends l0 {
    @Override // i8.u
    /* renamed from: H0 */
    public final l0 Y(f8.j jVar, int i2, n nVar) {
        k.e(jVar, "newOwner");
        x.t(i2, "modality");
        k.e(nVar, "visibility");
        x.t(2, "kind");
        return this;
    }

    @Override // i8.l0, i8.u
    public final u I0(int i2, e9.f fVar, f8.j jVar, t tVar, n0 n0Var, g8.j jVar2) {
        k.e(jVar, "newOwner");
        x.t(i2, "kind");
        k.e(jVar2, "annotations");
        return this;
    }

    @Override // i8.u, f8.c
    public final /* bridge */ /* synthetic */ f8.c Y(f8.e eVar, int i2, n nVar) {
        Y(eVar, i2, nVar);
        return this;
    }

    @Override // i8.u, f8.c
    public final void d0(Collection collection) {
        k.e(collection, "overriddenDescriptors");
    }

    @Override // i8.u, f8.t
    public final boolean o() {
        return false;
    }

    @Override // i8.l0, i8.u, f8.t
    public final s o0() {
        return new d0(20, this);
    }

    @Override // i8.u, f8.b
    public final Object x(f8.a aVar) {
        return null;
    }
}
