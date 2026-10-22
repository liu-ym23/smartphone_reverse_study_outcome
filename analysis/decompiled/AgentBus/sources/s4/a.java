package s4;

import a4.u;
import a6.q;
import c7.r;
import g7.d;
import i7.i;
import ia.b0;
import la.u0;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class a extends i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9483f;

    /* renamed from: g, reason: collision with root package name */
    public int f9484g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f9485h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, d dVar, int i2) {
        super(2, dVar);
        this.f9483f = i2;
        this.f9485h = bVar;
    }

    @Override // i7.a
    public final d create(Object obj, d dVar) {
        switch (this.f9483f) {
            case 0:
                return new a(this.f9485h, dVar, 0);
            default:
                return new a(this.f9485h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        b0 b0Var = (b0) obj;
        d dVar = (d) obj2;
        switch (this.f9483f) {
            case 0:
                ((a) create(b0Var, dVar)).invokeSuspend(r.f1986a);
                return h7.a.f4212f;
            default:
                return ((a) create(b0Var, dVar)).invokeSuspend(r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f9483f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f9484g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    throw new u();
                }
                e0.N(obj);
                b bVar = this.f9485h;
                u0 u0Var = bVar.f9496k.f9743g;
                q qVar = new q(10, bVar);
                this.f9484g = 1;
                u0Var.x(qVar, this);
                return aVar;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f9484g;
                r rVar = r.f1986a;
                if (i10 == 0) {
                    e0.N(obj);
                    this.f9484g = 1;
                    this.f9485h.b(this);
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
        }
    }
}
