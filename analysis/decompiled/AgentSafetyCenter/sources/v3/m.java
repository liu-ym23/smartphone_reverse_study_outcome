package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14676c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f14677f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14678g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(z zVar, nb.c cVar) {
        super(3, cVar);
        this.f14678g = zVar;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f14676c) {
            case 0:
                return new m((z) this.f14678g, (nb.c) obj3).invokeSuspend(jb.v.f6774a);
            default:
                ((Boolean) obj2).getClass();
                m mVar = new m(3, (nb.c) obj3);
                mVar.f14678g = (b0) obj;
                return mVar.invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f14676c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f14677f;
                if (i == 0) {
                    id.c.I(obj);
                    z zVar = (z) this.f14678g;
                    this.f14677f = 1;
                    if (z.a(zVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return jb.v.f6774a;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f14677f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                b0 b0Var = (b0) this.f14678g;
                this.f14677f = 1;
                b0Var.getClass();
                Object objA = b0.a(b0Var, this);
                return objA == aVar2 ? aVar2 : objA;
        }
    }

    public /* synthetic */ m(int i, nb.c cVar) {
        super(i, cVar);
    }
}
