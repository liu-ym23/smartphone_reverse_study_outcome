package q5;

import w7.e0;

/* loaded from: classes.dex */
public final class k extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8710f;

    /* renamed from: g, reason: collision with root package name */
    public int f8711g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q f8712h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(q qVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f8710f = i2;
        this.f8712h = qVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8710f) {
            case 0:
                return new k(this.f8712h, dVar, 0);
            default:
                return new k(this.f8712h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f8710f) {
        }
        return ((k) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        k kVar;
        switch (this.f8710f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f8711g;
                q qVar = this.f8712h;
                if (i2 == 0) {
                    e0.N(obj);
                    p5.c cVar = qVar.f8766t;
                    d5.m mVar = d5.m.CHANNEL;
                    long j2 = qVar.f8767u;
                    this.f8711g = 1;
                    obj = cVar.f8423b.a(mVar, j2, true, new p5.m(null), this);
                    kVar = this;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e0.N(obj);
                        return c7.r.f1986a;
                    }
                    e0.N(obj);
                    kVar = this;
                }
                if (((d5.e) obj) == null) {
                    nb.f fVar = qVar.f8765s;
                    d5.m mVar2 = d5.m.CHANNEL;
                    long j4 = qVar.f8767u;
                    kVar.f8711g = 2;
                    obj = nb.f.n(fVar, mVar2, j4, true, null, kVar, 18);
                    if (obj == aVar) {
                        return aVar;
                    }
                }
                return c7.r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f8711g;
                if (i10 == 0) {
                    e0.N(obj);
                    q qVar2 = this.f8712h;
                    la.e0 e0Var = qVar2.f8747a.f2890d;
                    a6.q qVar3 = new a6.q(7, qVar2);
                    this.f8711g = 1;
                    if (e0Var.f5914f.x(qVar3, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
        }
    }
}
