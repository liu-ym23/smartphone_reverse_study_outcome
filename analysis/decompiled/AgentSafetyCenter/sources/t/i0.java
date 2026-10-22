package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13010c;

    /* renamed from: f, reason: collision with root package name */
    public int f13011f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j0 f13012g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(j0 j0Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f13010c = i;
        this.f13012g = j0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13010c) {
            case 0:
                return new i0(this.f13012g, cVar, 0);
            default:
                return new i0(this.f13012g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f13010c) {
        }
        return ((i0) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13010c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f13011f;
                if (i == 0) {
                    id.c.I(obj);
                    this.f13011f = 1;
                    if (j0.B0(this.f13012g, this) == aVar) {
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
                int i3 = this.f13011f;
                if (i3 == 0) {
                    id.c.I(obj);
                    this.f13011f = 1;
                    if (j0.C0(this.f13012g, this) == aVar2) {
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
