package d5;

import w7.e0;

/* loaded from: classes.dex */
public final class y extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2924f;

    /* renamed from: g, reason: collision with root package name */
    public int f2925g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f2926h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(z zVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f2924f = i2;
        this.f2926h = zVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f2924f) {
            case 0:
                return new y(this.f2926h, dVar, 0);
            default:
                return new y(this.f2926h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f2924f) {
        }
        return ((y) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2924f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f2925g;
                if (i2 == 0) {
                    e0.N(obj);
                    this.f2925g = 1;
                    if (z.j(this.f2926h, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f2925g;
                if (i10 == 0) {
                    e0.N(obj);
                    this.f2925g = 1;
                    if (this.f2926h.b(this) == aVar2) {
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
