package v4;

import i5.u;
import ia.b0;
import ia.d0;
import w7.e0;

/* loaded from: classes.dex */
public final class i extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10412f;

    /* renamed from: g, reason: collision with root package name */
    public int f10413g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f10414h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(k kVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10412f = i2;
        this.f10414h = kVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10412f) {
            case 0:
                return new i(this.f10414h, dVar, 0);
            case 1:
                return new i(this.f10414h, dVar, 1);
            case 2:
                return new i(this.f10414h, dVar, 2);
            case 3:
                return new i(this.f10414h, dVar, 3);
            case 4:
                return new i(this.f10414h, dVar, 4);
            default:
                return new i(this.f10414h, dVar, 5);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10412f) {
        }
        return ((i) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f10412f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f10413g;
                if (i2 == 0) {
                    e0.N(obj);
                    h4.n nVar = this.f10414h.A;
                    this.f10413g = 1;
                    nVar.getClass();
                    if (Boolean.TRUE == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f10413g;
                c7.r rVar = c7.r.f1986a;
                if (i10 == 0) {
                    e0.N(obj);
                    b6.a aVar3 = this.f10414h.H;
                    this.f10413g = 1;
                    aVar3.start();
                    if (rVar == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return rVar;
            case 2:
                h7.a aVar4 = h7.a.f4212f;
                int i11 = this.f10413g;
                c7.r rVar2 = c7.r.f1986a;
                if (i11 == 0) {
                    e0.N(obj);
                    h4.n nVar2 = this.f10414h.A;
                    this.f10413g = 1;
                    nVar2.getClass();
                    if (rVar2 == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return rVar2;
            case 3:
                h7.a aVar5 = h7.a.f4212f;
                int i12 = this.f10413g;
                c7.r rVar3 = c7.r.f1986a;
                if (i12 == 0) {
                    e0.N(obj);
                    b6.a aVar6 = this.f10414h.H;
                    this.f10413g = 1;
                    aVar6.a();
                    if (rVar3 == aVar5) {
                        return aVar5;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return rVar3;
            case 4:
                h7.a aVar7 = h7.a.f4212f;
                int i13 = this.f10413g;
                if (i13 != 0) {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                u uVar = this.f10414h.f10451q;
                this.f10413g = 1;
                Object objB = d0.B(uVar.f4724d.f5619d, new i5.q(0, null, uVar, "GATEWAY"), this);
                return objB == aVar7 ? aVar7 : objB;
            default:
                h7.a aVar8 = h7.a.f4212f;
                int i14 = this.f10413g;
                if (i14 != 0) {
                    if (i14 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f10413g = 1;
                Object objB2 = w5.m.b(this.f10414h, this);
                return objB2 == aVar8 ? aVar8 : objB2;
        }
    }
}
