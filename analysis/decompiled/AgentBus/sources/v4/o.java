package v4;

import ia.b0;
import ia.s;
import w7.e0;

/* loaded from: classes.dex */
public final class o extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10482f;

    /* renamed from: g, reason: collision with root package name */
    public int f10483g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c6.h f10484h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p f10485i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(c6.h hVar, p pVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10482f = i2;
        this.f10484h = hVar;
        this.f10485i = pVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10482f) {
            case 0:
                return new o(this.f10484h, this.f10485i, dVar, 0);
            default:
                return new o(this.f10484h, this.f10485i, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10482f) {
        }
        return ((o) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10482f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f10483g;
                c7.r rVar = c7.r.f1986a;
                p pVar = this.f10485i;
                try {
                    if (i2 == 0) {
                        e0.N(obj);
                        s sVar = this.f10484h.f1947i;
                        this.f10483g = 1;
                        if (sVar.A(this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e0.N(obj);
                    }
                    pVar.f10502p.X(rVar);
                } catch (Throwable th) {
                    pVar.f10502p.l0(th);
                }
                return rVar;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f10483g;
                p pVar2 = this.f10485i;
                try {
                    if (i10 == 0) {
                        e0.N(obj);
                        la.c cVar = new la.c(new a5.b(this.f10484h, null, 5), g7.m.f3866f, -2, ka.a.f5661f);
                        a6.q qVar = new a6.q(12, pVar2);
                        this.f10483g = 1;
                        if (cVar.x(qVar, this) == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e0.N(obj);
                    }
                } catch (Throwable th2) {
                    ((k5.g) pVar2.f10493g).a("LocalSocketAcceptor", a1.a.w("LocalSocketServer listen failed: ", th2.getMessage()), th2);
                }
                return c7.r.f1986a;
        }
    }
}
