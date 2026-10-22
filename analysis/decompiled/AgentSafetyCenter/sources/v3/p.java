package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.i implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14698c;

    /* renamed from: f, reason: collision with root package name */
    public int f14699f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f14700g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, nb.c cVar, int i) {
        super(1, cVar);
        this.f14698c = i;
        this.f14700g = obj;
    }

    @Override // pb.a
    public final nb.c create(nb.c cVar) {
        switch (this.f14698c) {
            case 0:
                return new p((x) this.f14700g, cVar, 0);
            default:
                return new p((p5.m) this.f14700g, cVar, 1);
        }
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        nb.c cVar = (nb.c) obj;
        switch (this.f14698c) {
        }
        return ((p) create(cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f14698c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f14699f;
                if (i != 0) {
                    if (i == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                x xVar = (x) this.f14700g;
                this.f14699f = 1;
                Object objInvoke = xVar.invoke(this);
                return objInvoke == aVar ? aVar : objInvoke;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f14699f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                p5.m mVar = (p5.m) this.f14700g;
                this.f14699f = 1;
                Object objT = mVar.T(this);
                return objT == aVar2 ? aVar2 : objT;
        }
    }
}
