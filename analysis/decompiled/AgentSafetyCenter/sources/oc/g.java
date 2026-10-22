package oc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends f {
    public g(nc.g gVar, nb.g gVar2, int i, mc.a aVar, int i3) {
        super(gVar, (i3 & 2) != 0 ? nb.h.f8811c : gVar2, (i3 & 4) != 0 ? -3 : i, (i3 & 8) != 0 ? mc.a.f8550c : aVar);
    }

    @Override // oc.e
    public final e c(nb.g gVar, int i, mc.a aVar) {
        return new g(this.f9372h, gVar, i, aVar);
    }

    @Override // oc.e
    public final nc.g d() {
        return this.f9372h;
    }

    @Override // oc.f
    public final Object e(nc.h hVar, nb.c cVar) {
        Object objCollect = this.f9372h.collect(hVar, cVar);
        return objCollect == ob.a.f9351c ? objCollect : jb.v.f6774a;
    }
}
