package d5;

import w7.e0;

/* loaded from: classes.dex */
public final class b0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2854f;

    /* renamed from: g, reason: collision with root package name */
    public int f2855g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f2856h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(d0 d0Var, g7.d dVar, int i2) {
        super(2, dVar);
        this.f2854f = i2;
        this.f2856h = d0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f2854f) {
            case 0:
                return new b0(this.f2856h, dVar, 0);
            default:
                return new b0(this.f2856h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f2854f) {
        }
        return ((b0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2854f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f2855g;
                if (i2 == 0) {
                    e0.N(obj);
                    d0 d0Var = this.f2856h;
                    la.j jVarA = d0Var.f2866d.a();
                    a0 a0Var = new a0(d0Var, 0);
                    this.f2855g = 1;
                    if (jVarA.x(a0Var, this) == aVar) {
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
                int i10 = this.f2855g;
                if (i10 == 0) {
                    e0.N(obj);
                    d0 d0Var2 = this.f2856h;
                    la.e0 e0VarD = d0Var2.f2866d.d();
                    a0 a0Var2 = new a0(d0Var2, 1);
                    this.f2855g = 1;
                    if (e0VarD.f5914f.x(a0Var2, this) == aVar2) {
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
