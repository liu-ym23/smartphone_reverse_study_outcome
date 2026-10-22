package j9;

import y.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6666c;

    /* renamed from: f, reason: collision with root package name */
    public int f6667f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6668g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6669h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Object obj, int i, nb.c cVar, int i3) {
        super(2, cVar);
        this.f6666c = i3;
        this.f6669h = obj;
        this.f6668g = i;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f6666c) {
            case 0:
                return new h((x.r) this.f6669h, this.f6668g, cVar, 0);
            default:
                return new h((i0) this.f6669h, this.f6668g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f6666c) {
        }
        return ((h) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6666c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f6667f;
                if (i == 0) {
                    id.c.I(obj);
                    x.r rVar = (x.r) this.f6669h;
                    this.f6667f = 1;
                    if (x.r.k(rVar, this.f6668g, this) == aVar) {
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
                int i3 = this.f6667f;
                jb.v vVar = jb.v.f6774a;
                if (i3 == 0) {
                    id.c.I(obj);
                    x.c cVar = ((i0) this.f6669h).f15753t;
                    this.f6667f = 1;
                    Object objK = x.r.k(cVar.f15403a, this.f6668g, this);
                    if (objK != aVar2) {
                        objK = vVar;
                    }
                    if (objK == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i3 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return vVar;
        }
    }
}
