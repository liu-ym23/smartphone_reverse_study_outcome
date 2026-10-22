package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12938c;

    /* renamed from: f, reason: collision with root package name */
    public int f12939f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d f12940g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v.m f12941h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, v.m mVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f12938c = i;
        this.f12940g = dVar;
        this.f12941h = mVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f12938c) {
            case 0:
                return new b(this.f12940g, this.f12941h, cVar, 0);
            default:
                return new b(this.f12940g, this.f12941h, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f12938c) {
        }
        return ((b) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12938c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f12939f;
                if (i == 0) {
                    id.c.I(obj);
                    v.k kVar = this.f12940g.f12950u;
                    if (kVar != null) {
                        this.f12939f = 1;
                        if (kVar.a(this.f12941h, this) == aVar) {
                        }
                    }
                } else if (i != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f12939f;
                if (i3 == 0) {
                    id.c.I(obj);
                    v.k kVar2 = this.f12940g.f12950u;
                    if (kVar2 != null) {
                        v.n nVar = new v.n(this.f12941h);
                        this.f12939f = 1;
                        if (kVar2.a(nVar, this) == aVar2) {
                        }
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
        }
        return jb.v.f6774a;
    }
}
