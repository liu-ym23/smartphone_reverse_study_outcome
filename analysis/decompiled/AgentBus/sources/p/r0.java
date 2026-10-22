package p;

/* loaded from: classes.dex */
public final class r0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f8172f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s0 f8173g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f8174h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ float f8175i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(s0 s0Var, float f10, float f11, g7.d dVar) {
        super(2, dVar);
        this.f8173g = s0Var;
        this.f8174h = f10;
        this.f8175i = f11;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new r0(this.f8173g, this.f8174h, this.f8175i, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((r0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f8172f;
        if (i2 == 0) {
            w7.e0.N(obj);
            y0 y0Var = this.f8173g.H;
            long jB = n7.b.b(this.f8174h, this.f8175i);
            this.f8172f = 1;
            if (androidx.compose.foundation.gestures.a.a(y0Var, jB, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            w7.e0.N(obj);
        }
        return c7.r.f1986a;
    }
}
