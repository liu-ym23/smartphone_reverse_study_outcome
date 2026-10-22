package o5;

import a4.u;
import c7.r;
import ia.b0;
import la.u0;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class d extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7738f;

    /* renamed from: g, reason: collision with root package name */
    public int f7739g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u0 f7740h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f7741i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(u0 u0Var, e eVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7738f = i2;
        this.f7740h = u0Var;
        this.f7741i = eVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7738f) {
            case 0:
                return new d(this.f7740h, this.f7741i, dVar, 0);
            default:
                return new d(this.f7740h, this.f7741i, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7738f) {
            case 0:
                ((d) create(b0Var, dVar)).invokeSuspend(r.f1986a);
                break;
            default:
                ((d) create(b0Var, dVar)).invokeSuspend(r.f1986a);
                break;
        }
        return h7.a.f4212f;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f7738f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7739g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    throw new u();
                }
                e0.N(obj);
                c cVar = new c(this.f7741i, 0);
                this.f7739g = 1;
                this.f7740h.x(cVar, this);
                return aVar;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f7739g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    throw new u();
                }
                e0.N(obj);
                c cVar2 = new c(this.f7741i, 1);
                this.f7739g = 1;
                this.f7740h.x(cVar2, this);
                return aVar2;
        }
    }
}
