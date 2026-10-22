package j9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6706c;

    /* renamed from: f, reason: collision with root package name */
    public int f6707f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i9.b0 f6708g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(i9.b0 b0Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f6706c = i;
        this.f6708g = b0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f6706c) {
            case 0:
                return new q(this.f6708g, cVar, 0);
            case 1:
                return new q(this.f6708g, cVar, 1);
            case 2:
                return new q(this.f6708g, cVar, 2);
            default:
                return new q(this.f6708g, cVar, 3);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f6706c) {
        }
        return ((q) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6706c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f6707f;
                if (i == 0) {
                    id.c.I(obj);
                    this.f6707f = 1;
                    if (this.f6708g.k(this) == aVar) {
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
                int i3 = this.f6707f;
                if (i3 == 0) {
                    id.c.I(obj);
                    i9.b bVar = i9.b.f5834g;
                    this.f6707f = 1;
                    if (this.f6708g.o(bVar, this) == aVar2) {
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f6707f;
                if (i10 == 0) {
                    id.c.I(obj);
                    i9.b bVar2 = i9.b.f5835h;
                    this.f6707f = 1;
                    if (this.f6708g.o(bVar2, this) == aVar3) {
                    }
                } else if (i10 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            default:
                ob.a aVar4 = ob.a.f9351c;
                int i11 = this.f6707f;
                if (i11 == 0) {
                    id.c.I(obj);
                    i9.b bVar3 = i9.b.i;
                    this.f6707f = 1;
                    if (this.f6708g.o(bVar3, this) == aVar4) {
                    }
                } else if (i11 != 1) {
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
