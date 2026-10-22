package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13467c;

    /* renamed from: f, reason: collision with root package name */
    public int f13468f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ xb.q f13469g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i0 f13470h;
    public final /* synthetic */ o1.s i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(xb.q qVar, i0 i0Var, o1.s sVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f13467c = i;
        this.f13469g = qVar;
        this.f13470h = i0Var;
        this.i = sVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13467c) {
            case 0:
                return new g1(this.f13469g, this.f13470h, this.i, cVar, 0);
            default:
                return new g1(this.f13469g, this.f13470h, this.i, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f13467c) {
        }
        return ((g1) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13467c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f13468f;
                if (i == 0) {
                    id.c.I(obj);
                    c1.b bVarA = c1.b.a(this.i.f9073c);
                    this.f13468f = 1;
                    if (this.f13469g.invoke(this.f13470h, bVarA, this) == aVar) {
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
                int i3 = this.f13468f;
                if (i3 == 0) {
                    id.c.I(obj);
                    c1.b bVarA2 = c1.b.a(this.i.f9073c);
                    this.f13468f = 1;
                    if (this.f13469g.invoke(this.f13470h, bVarA2, this) == aVar2) {
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
