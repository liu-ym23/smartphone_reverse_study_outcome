package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13441c;

    /* renamed from: f, reason: collision with root package name */
    public int f13442f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i0 f13443g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(i0 i0Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f13441c = i;
        this.f13443g = i0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13441c) {
            case 0:
                return new d1(this.f13443g, cVar, 0);
            case 1:
                return new d1(this.f13443g, cVar, 1);
            default:
                return new d1(this.f13443g, cVar, 2);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f13441c) {
        }
        return ((d1) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13441c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f13442f;
                if (i == 0) {
                    id.c.I(obj);
                    this.f13442f = 1;
                    if (this.f13443g.b(this) == aVar) {
                    }
                } else if (i != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f13442f;
                if (i3 == 0) {
                    id.c.I(obj);
                    this.f13442f = 1;
                    if (this.f13443g.b(this) == aVar2) {
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            default:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f13442f;
                if (i10 == 0) {
                    id.c.I(obj);
                    this.f13442f = 1;
                    if (this.f13443g.b(this) == aVar3) {
                    }
                } else if (i10 != 1) {
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
