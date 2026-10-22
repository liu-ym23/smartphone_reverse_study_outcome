package p;

/* loaded from: classes.dex */
public final class p0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8149f;

    /* renamed from: g, reason: collision with root package name */
    public int f8150g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0 f8151h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ long f8152i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(s0 s0Var, long j2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f8149f = i2;
        this.f8151h = s0Var;
        this.f8152i = j2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8149f) {
            case 0:
                return new p0(this.f8151h, this.f8152i, dVar, 0);
            case 1:
                return new p0(this.f8151h, this.f8152i, dVar, 1);
            case 2:
                return new p0(this.f8151h, this.f8152i, dVar, 2);
            default:
                p0 p0Var = new p0(this.f8151h, dVar);
                p0Var.f8152i = ((t0.b) obj).f9654a;
                return p0Var;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8149f) {
            case 0:
                return ((p0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 1:
                return ((p0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 2:
                return ((p0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                long j2 = ((t0.b) obj).f9654a;
                p0 p0Var = new p0(this.f8151h, (g7.d) obj2);
                p0Var.f8152i = j2;
                return p0Var.invokeSuspend(c7.r.f1986a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.p0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(s0 s0Var, g7.d dVar) {
        super(2, dVar);
        this.f8149f = 3;
        this.f8151h = s0Var;
    }
}
