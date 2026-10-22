package v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e2 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14412c;

    /* renamed from: f, reason: collision with root package name */
    public int f14413f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g2 f14414g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e2(g2 g2Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f14412c = i;
        this.f14414g = g2Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14412c) {
            case 0:
                return new e2(this.f14414g, cVar, 0);
            default:
                return new e2(this.f14414g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f14412c) {
        }
        return ((e2) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f14412c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f14413f;
                jb.v vVar = jb.v.f6774a;
                if (i == 0) {
                    id.c.I(obj);
                    t tVar = this.f14414g.f14428c;
                    this.f14413f = 1;
                    Object objC = tVar.f14571w.c(this);
                    if (objC != aVar) {
                        objC = vVar;
                    }
                    if (objC == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return vVar;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f14413f;
                jb.v vVar2 = jb.v.f6774a;
                if (i3 == 0) {
                    id.c.I(obj);
                    t tVar2 = this.f14414g.f14428c;
                    this.f14413f = 1;
                    Object objA = tVar2.f14573x.a(this);
                    if (objA != aVar2) {
                        objA = vVar2;
                    }
                    if (objA == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i3 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return vVar2;
        }
    }
}
