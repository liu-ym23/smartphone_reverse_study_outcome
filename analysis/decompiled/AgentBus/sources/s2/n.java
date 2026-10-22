package s2;

/* loaded from: classes.dex */
public final class n extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9403f;

    /* renamed from: g, reason: collision with root package name */
    public int f9404g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f9405h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(z zVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f9403f = i2;
        this.f9405h = zVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f9403f) {
            case 0:
                return new n(this.f9405h, dVar, 0);
            case 1:
                return new n(this.f9405h, dVar, 1);
            default:
                return new n(this.f9405h, dVar, 2);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f9403f) {
            case 0:
                ((n) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
                return h7.a.f4212f;
            case 1:
                return ((n) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((n) create((la.k) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f9403f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f9404g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    la.e0 e0Var = this.f9405h.f9467i;
                    this.f9404g = 1;
                    if (e0Var.f5914f.x(m.f9402f, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                throw new a4.u();
            case 1:
                z zVar = this.f9405h;
                o4.d0 d0Var = zVar.f9470l;
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f9404g;
                try {
                    if (i10 == 0) {
                        w7.e0.N(obj);
                        if (d0Var.J() instanceof a0) {
                            return d0Var.J();
                        }
                        this.f9404g = 1;
                        if (zVar.e(this) == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            w7.e0.N(obj);
                            return (h0) obj;
                        }
                        w7.e0.N(obj);
                    }
                    this.f9404g = 2;
                    obj = z.b(zVar, false, this);
                    if (obj == aVar2) {
                        return aVar2;
                    }
                    return (h0) obj;
                } catch (Throwable th) {
                    return new c0(-1, th);
                }
            default:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f9404g;
                c7.r rVar = c7.r.f1986a;
                z zVar2 = this.f9405h;
                if (i11 == 0) {
                    w7.e0.N(obj);
                    i5.f fVar = zVar2.f9471m;
                    this.f9404g = 1;
                    Object objA = ((ia.s) fVar.f4654h).A(this);
                    if (objA != aVar3) {
                        objA = rVar;
                    }
                    if (objA == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        w7.e0.N(obj);
                        return rVar;
                    }
                    w7.e0.N(obj);
                }
                la.j jVarF = la.k0.f(zVar2.d().f9370c, -1);
                a6.q qVar = new a6.q(9, zVar2);
                this.f9404g = 2;
                if (jVarF.x(qVar, this) == aVar3) {
                    return aVar3;
                }
                return rVar;
        }
    }
}
