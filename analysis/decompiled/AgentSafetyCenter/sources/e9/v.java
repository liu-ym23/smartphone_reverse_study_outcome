package e9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3727c;

    /* renamed from: f, reason: collision with root package name */
    public int f3728f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f3729g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f3730h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Object obj, boolean z10, nb.c cVar, int i) {
        super(2, cVar);
        this.f3727c = i;
        this.f3730h = obj;
        this.f3729g = z10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f3727c) {
            case 0:
                return new v((h) this.f3730h, this.f3729g, cVar, 0);
            default:
                return new v((i9.b0) this.f3730h, this.f3729g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f3727c) {
        }
        return ((v) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.f3727c;
        jb.v vVar = jb.v.f6774a;
        boolean z10 = this.f3729g;
        Object obj2 = this.f3730h;
        nb.c cVar = null;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i3 = this.f3728f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                this.f3728f = 1;
                rc.e eVar = kc.e0.f7430a;
                Object objE = kc.w.E(rc.d.f10552f, new g((h) obj2, z10, cVar, 0), this);
                if (objE != aVar) {
                    objE = vVar;
                }
                return objE == aVar ? aVar : vVar;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i10 = this.f3728f;
                if (i10 == 0) {
                    id.c.I(obj);
                    this.f3728f = 1;
                    return ((i9.b0) obj2).p(z10, this) == aVar2 ? aVar2 : vVar;
                }
                if (i10 == 1) {
                    id.c.I(obj);
                    return vVar;
                }
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
