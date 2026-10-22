package v9;

import java.util.List;

/* loaded from: classes.dex */
public final class x extends v {

    /* renamed from: g, reason: collision with root package name */
    public final u9.n f10601g;

    /* renamed from: h, reason: collision with root package name */
    public final q7.m f10602h;

    /* renamed from: i, reason: collision with root package name */
    public final u9.i f10603i;

    /* JADX WARN: Multi-variable type inference failed */
    public x(u9.n nVar, p7.a aVar) {
        q7.k.e(nVar, "storageManager");
        this.f10601g = nVar;
        this.f10602h = (q7.m) aVar;
        this.f10603i = new u9.i((u9.k) nVar, aVar);
    }

    @Override // v9.v
    public final List C0() {
        return I0().C0();
    }

    @Override // v9.v
    public final i0 D0() {
        return I0().D0();
    }

    @Override // v9.v
    public final m0 E0() {
        return I0().E0();
    }

    @Override // v9.v
    public final boolean F0() {
        return I0().F0();
    }

    @Override // v9.v
    public final v G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        return new x(this.f10601g, new a8.e(21, gVar, this));
    }

    @Override // v9.v
    public final z0 H0() {
        v vVarI0 = I0();
        while (vVarI0 instanceof x) {
            vVarI0 = ((x) vVarI0).I0();
        }
        q7.k.c(vVarI0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (z0) vVarI0;
    }

    public final v I0() {
        return (v) this.f10603i.c();
    }

    public final String toString() {
        u9.i iVar = this.f10603i;
        return (iVar.f10201h == u9.j.f10202f || iVar.f10201h == u9.j.f10203g) ? "<Not computed yet>" : I0().toString();
    }

    @Override // v9.v
    public final o9.n v0() {
        return I0().v0();
    }
}
