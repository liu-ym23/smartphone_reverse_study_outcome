package u5;

import ia.b0;
import w7.e0;

/* loaded from: classes.dex */
public final class r extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10161f;

    /* renamed from: g, reason: collision with root package name */
    public int f10162g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t f10163h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(t tVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10161f = i2;
        this.f10163h = tVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10161f) {
            case 0:
                return new r(this.f10163h, dVar, 0);
            default:
                return new r(this.f10163h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10161f) {
        }
        return ((r) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f10161f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f10162g;
                c7.r rVar = c7.r.f1986a;
                if (i2 == 0) {
                    e0.N(obj);
                    this.f10162g = 1;
                    this.f10163h.b(this);
                    if (rVar == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return rVar;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f10162g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                ka.g gVar = this.f10163h.f10187j;
                this.f10162g = 1;
                Object objC = gVar.c(this);
                return objC == aVar2 ? aVar2 : objC;
        }
    }
}
