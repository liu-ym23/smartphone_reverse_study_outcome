package p;

/* loaded from: classes.dex */
public final class a0 extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8052f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(int i2, g7.d dVar, int i10) {
        super(i2, dVar);
        this.f8052f = i10;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f8052f;
        c7.r rVar = c7.r.f1986a;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                break;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                break;
            default:
                h7.a aVar3 = h7.a.f4212f;
                w7.e0.N(obj);
                break;
        }
        return rVar;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        switch (this.f8052f) {
            case 0:
                long j2 = ((t0.b) obj2).f9654a;
                a0 a0Var = new a0(3, (g7.d) obj3, 0);
                c7.r rVar = c7.r.f1986a;
                a0Var.invokeSuspend(rVar);
                return rVar;
            case 1:
                ((Number) obj2).floatValue();
                a0 a0Var2 = new a0(3, (g7.d) obj3, 1);
                c7.r rVar2 = c7.r.f1986a;
                a0Var2.invokeSuspend(rVar2);
                return rVar2;
            default:
                long j4 = ((t0.b) obj2).f9654a;
                a0 a0Var3 = new a0(3, (g7.d) obj3, 2);
                c7.r rVar3 = c7.r.f1986a;
                a0Var3.invokeSuspend(rVar3);
                return rVar3;
        }
    }
}
