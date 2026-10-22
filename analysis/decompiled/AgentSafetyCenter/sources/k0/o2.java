package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o2 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6993c;

    /* renamed from: f, reason: collision with root package name */
    public int f6994f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6995g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ xb.p f6996h;
    public final /* synthetic */ c1 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o2(xb.p pVar, c1 c1Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f6993c = i;
        this.f6996h = pVar;
        this.i = c1Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f6993c) {
            case 0:
                o2 o2Var = new o2(this.f6996h, this.i, cVar, 0);
                o2Var.f6995g = obj;
                return o2Var;
            case 1:
                o2 o2Var2 = new o2(this.f6996h, this.i, cVar, 1);
                o2Var2.f6995g = obj;
                return o2Var2;
            default:
                o2 o2Var3 = new o2(this.f6996h, this.i, cVar, 2);
                o2Var3.f6995g = obj;
                return o2Var3;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f6993c) {
        }
        return ((o2) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6993c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f6994f;
                if (i == 0) {
                    id.c.I(obj);
                    r1 r1Var = new r1(this.i, ((kc.t) this.f6995g).n());
                    this.f6994f = 1;
                    if (this.f6996h.invoke(r1Var, this) == aVar) {
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
                int i3 = this.f6994f;
                if (i3 == 0) {
                    id.c.I(obj);
                    r1 r1Var2 = new r1(this.i, ((kc.t) this.f6995g).n());
                    this.f6994f = 1;
                    if (this.f6996h.invoke(r1Var2, this) == aVar2) {
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
                int i10 = this.f6994f;
                if (i10 == 0) {
                    id.c.I(obj);
                    r1 r1Var3 = new r1(this.i, ((kc.t) this.f6995g).n());
                    this.f6994f = 1;
                    if (this.f6996h.invoke(r1Var3, this) == aVar3) {
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
