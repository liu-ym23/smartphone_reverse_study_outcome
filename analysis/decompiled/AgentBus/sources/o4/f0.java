package o4;

/* loaded from: classes.dex */
public final class f0 extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7343f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(int i2, g7.d dVar, int i10) {
        super(i2, dVar);
        this.f7343f = i10;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        switch (this.f7343f) {
            case 0:
                return new f0(1, dVar, 0);
            case 1:
                return new f0(1, dVar, 1);
            default:
                return new f0(1, dVar, 2);
        }
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g7.d dVar = (g7.d) obj;
        switch (this.f7343f) {
            case 0:
                ((f0) create(dVar)).invokeSuspend(c7.r.f1986a);
                return null;
            case 1:
                ((f0) create(dVar)).invokeSuspend(c7.r.f1986a);
                return null;
            default:
                ((f0) create(dVar)).invokeSuspend(c7.r.f1986a);
                return d7.a0.f2944f;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7343f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                return null;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                return null;
            default:
                h7.a aVar3 = h7.a.f4212f;
                w7.e0.N(obj);
                return d7.a0.f2944f;
        }
    }
}
