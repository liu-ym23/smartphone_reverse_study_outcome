package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13054c;

    /* renamed from: f, reason: collision with root package name */
    public int f13055f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ u.i0 f13056g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ long f13057h;
    public final /* synthetic */ d i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(d dVar, nb.c cVar, int i) {
        super(3, cVar);
        this.f13054c = i;
        this.i = dVar;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        u.i0 i0Var = (u.i0) obj;
        c1.b bVar = (c1.b) obj2;
        switch (this.f13054c) {
            case 0:
                long j10 = bVar.f2165a;
                q qVar = new q((r) this.i, (nb.c) obj3, 0);
                qVar.f13056g = i0Var;
                qVar.f13057h = j10;
                return qVar.invokeSuspend(jb.v.f6774a);
            default:
                long j11 = bVar.f2165a;
                q qVar2 = new q((v) this.i, (nb.c) obj3, 1);
                qVar2.f13056g = i0Var;
                qVar2.f13057h = j11;
                return qVar2.invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Object objF;
        Object objF2;
        switch (this.f13054c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f13055f;
                jb.v vVar = jb.v.f6774a;
                if (i == 0) {
                    id.c.I(obj);
                    u.i0 i0Var = this.f13056g;
                    long j10 = this.f13057h;
                    r rVar = (r) this.i;
                    if (rVar.f12954y) {
                        this.f13055f = 1;
                        v.k kVar = rVar.f12950u;
                        if (kVar == null || (objF = kc.w.f(new a(i0Var, j10, kVar, rVar, null), this)) != aVar) {
                            objF = vVar;
                        }
                        if (objF == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return vVar;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f13055f;
                jb.v vVar2 = jb.v.f6774a;
                if (i3 == 0) {
                    id.c.I(obj);
                    u.i0 i0Var2 = this.f13056g;
                    long j11 = this.f13057h;
                    v vVar3 = (v) this.i;
                    if (vVar3.f12954y) {
                        this.f13055f = 1;
                        v.k kVar2 = vVar3.f12950u;
                        if (kVar2 == null || (objF2 = kc.w.f(new a(i0Var2, j11, kVar2, vVar3, null), this)) != aVar2) {
                            objF2 = vVar2;
                        }
                        if (objF2 == aVar2) {
                            return aVar2;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return vVar2;
        }
    }
}
