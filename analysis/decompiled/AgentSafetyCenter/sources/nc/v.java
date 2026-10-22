package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8935c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f8936f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ h f8937g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8938h;
    public final /* synthetic */ pb.i i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v(xb.p pVar, nb.c cVar) {
        super(3, cVar);
        this.i = (pb.i) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [pb.i, xb.p] */
    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        h hVar = (h) obj;
        switch (this.f8935c) {
            case 0:
                v vVar = new v((xb.p) this.i, (nb.c) obj3);
                vVar.f8937g = hVar;
                vVar.f8938h = obj2;
                return vVar.invokeSuspend(jb.v.f6774a);
            default:
                v vVar2 = new v((i9.z) this.i, (nb.c) obj3);
                vVar2.f8937g = hVar;
                vVar2.f8938h = (Object[]) obj2;
                return vVar2.invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [pb.i, xb.p] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        h hVar;
        h hVar2;
        switch (this.f8935c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f8936f;
                if (i == 0) {
                    id.c.I(obj);
                    hVar = this.f8937g;
                    Object obj2 = this.f8938h;
                    this.f8937g = hVar;
                    this.f8936f = 1;
                    obj = this.i.invoke(obj2, this);
                    if (obj == aVar) {
                    }
                } else if (i == 1) {
                    hVar = this.f8937g;
                    id.c.I(obj);
                } else if (i != 2) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                    break;
                }
                this.f8937g = null;
                this.f8936f = 2;
                if (hVar.emit(obj, this) == aVar) {
                }
                break;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f8936f;
                if (i3 == 0) {
                    id.c.I(obj);
                    hVar2 = this.f8937g;
                    Object[] objArr = (Object[]) this.f8938h;
                    i9.z zVar = (i9.z) this.i;
                    Object obj3 = objArr[0];
                    Object obj4 = objArr[1];
                    this.f8937g = hVar2;
                    this.f8936f = 1;
                    obj = zVar.invoke(obj3, obj4, this);
                    if (obj == aVar2) {
                    }
                } else if (i3 == 1) {
                    hVar2 = this.f8937g;
                    id.c.I(obj);
                } else if (i3 != 2) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                    break;
                }
                this.f8937g = null;
                this.f8936f = 2;
                if (hVar2.emit(obj, this) == aVar2) {
                }
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i9.z zVar, nb.c cVar) {
        super(3, cVar);
        this.i = zVar;
    }
}
