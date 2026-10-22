package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12944c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f12945f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(d dVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f12944c = i;
        this.f12945f = dVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f12944c) {
            case 0:
                return new c(this.f12945f, cVar, 0);
            default:
                return new c(this.f12945f, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f12944c) {
            case 0:
                c cVar2 = (c) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                cVar2.invokeSuspend(vVar);
                return vVar;
            default:
                c cVar3 = (c) create(tVar, cVar);
                jb.v vVar2 = jb.v.f6774a;
                cVar3.invokeSuspend(vVar2);
                return vVar2;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f12944c;
        jb.v vVar = jb.v.f6774a;
        nb.c cVar = null;
        d dVar = this.f12945f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                if (dVar.F == null) {
                    v.h hVar = new v.h();
                    v.k kVar = dVar.f12950u;
                    if (kVar != null) {
                        kc.w.u(dVar.p0(), null, null, new androidx.lifecycle.h0(kVar, hVar, cVar, 26), 3);
                    }
                    dVar.F = hVar;
                    break;
                }
                break;
            default:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                v.h hVar2 = dVar.F;
                if (hVar2 != null) {
                    v.i iVar = new v.i(hVar2);
                    v.k kVar2 = dVar.f12950u;
                    if (kVar2 != null) {
                        kc.w.u(dVar.p0(), null, null, new androidx.lifecycle.h0(kVar2, iVar, cVar, 27), 3);
                    }
                    dVar.F = null;
                    break;
                }
                break;
        }
        return vVar;
    }
}
