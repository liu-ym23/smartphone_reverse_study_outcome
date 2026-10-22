package g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4153c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4154f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f4155g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(k kVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f4153c = i;
        this.f4155g = kVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4153c) {
            case 0:
                j jVar = new j(this.f4155g, cVar, 0);
                jVar.f4154f = obj;
                return jVar;
            default:
                j jVar2 = new j(this.f4155g, cVar, 1);
                jVar2.f4154f = obj;
                return jVar2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f4153c) {
        }
        return ((j) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f4153c;
        k kVar = this.f4155g;
        nb.c cVar = null;
        int i3 = 3;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                kc.t tVar = (kc.t) this.f4154f;
                kc.w.u(tVar, null, null, new i(kVar, cVar, 0), 3);
                kc.w.u(tVar, null, null, new i(kVar, cVar, 1), 3);
                return kc.w.u(tVar, null, null, new i(kVar, cVar, 2), 3);
            default:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                return kc.w.u((kc.t) this.f4154f, null, null, new i(kVar, cVar, i3), 3);
        }
    }
}
