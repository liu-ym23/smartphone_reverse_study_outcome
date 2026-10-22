package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13559c;

    /* renamed from: f, reason: collision with root package name */
    public int f13560f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t0 f13561g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ long f13562h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(t0 t0Var, long j10, nb.c cVar, int i) {
        super(2, cVar);
        this.f13559c = i;
        this.f13561g = t0Var;
        this.f13562h = j10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13559c) {
            case 0:
                return new r0(this.f13561g, this.f13562h, cVar, 0);
            case 1:
                return new r0(this.f13561g, this.f13562h, cVar, 1);
            case 2:
                return new r0(this.f13561g, this.f13562h, cVar, 2);
            default:
                r0 r0Var = new r0(this.f13561g, cVar);
                r0Var.f13562h = ((c1.b) obj).f2165a;
                return r0Var;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f13559c) {
            case 0:
                return ((r0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 1:
                return ((r0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 2:
                return ((r0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((r0) create(c1.b.a(((c1.b) obj).f2165a), (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Object objInvoke;
        switch (this.f13559c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f13560f;
                jb.v vVar = jb.v.f6774a;
                if (i == 0) {
                    id.c.I(obj);
                    z0 z0Var = this.f13561g.H;
                    long j10 = this.f13562h;
                    this.f13560f = 1;
                    long jB = z0Var.f13627d == f0.f13454f ? o2.p.b(j10, 0.0f, 0.0f, 1) : o2.p.b(j10, 0.0f, 0.0f, 2);
                    m8.h hVar = new m8.h(z0Var, null);
                    t.b1 b1Var = z0Var.f13625b;
                    if (b1Var == null || (!z0Var.f13624a.d() && !z0Var.f13624a.b()) ? (objInvoke = hVar.invoke(o2.p.a(jB), this)) != aVar : (objInvoke = b1Var.a(jB, hVar, this)) != aVar) {
                        objInvoke = vVar;
                    }
                    if (objInvoke == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return vVar;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f13560f;
                if (i3 == 0) {
                    id.c.I(obj);
                    z0 z0Var2 = this.f13561g.H;
                    i9.n nVar = new i9.n(this.f13562h, null, 3);
                    this.f13560f = 1;
                    if (z0Var2.e(t.u0.f13069f, nVar, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i3 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return jb.v.f6774a;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f13560f;
                if (i10 == 0) {
                    id.c.I(obj);
                    z0 z0Var3 = this.f13561g.H;
                    i9.n nVar2 = new i9.n(this.f13562h, null, 4);
                    this.f13560f = 1;
                    if (z0Var3.e(t.u0.f13069f, nVar2, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i10 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return jb.v.f6774a;
            default:
                ob.a aVar4 = ob.a.f9351c;
                int i11 = this.f13560f;
                if (i11 != 0) {
                    if (i11 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                long j11 = this.f13562h;
                z0 z0Var4 = this.f13561g.H;
                this.f13560f = 1;
                Object objA = androidx.compose.foundation.gestures.a.a(z0Var4, j11, this);
                return objA == aVar4 ? aVar4 : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(t0 t0Var, nb.c cVar) {
        super(2, cVar);
        this.f13559c = 3;
        this.f13561g = t0Var;
    }
}
