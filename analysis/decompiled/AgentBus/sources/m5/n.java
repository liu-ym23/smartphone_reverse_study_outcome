package m5;

/* loaded from: classes.dex */
public final class n extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6439f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6440g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h4.a f6441h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(h4.a aVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6439f = i2;
        this.f6441h = aVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6439f) {
            case 0:
                n nVar = new n(this.f6441h, dVar, 0);
                nVar.f6440g = obj;
                return nVar;
            case 1:
                n nVar2 = new n(this.f6441h, dVar, 1);
                nVar2.f6440g = obj;
                return nVar2;
            case 2:
                n nVar3 = new n(this.f6441h, dVar, 2);
                nVar3.f6440g = obj;
                return nVar3;
            default:
                n nVar4 = new n(this.f6441h, dVar, 3);
                nVar4.f6440g = obj;
                return nVar4;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f6439f) {
            case 0:
                n nVar = (n) create((k5.i) obj, (g7.d) obj2);
                c7.r rVar = c7.r.f1986a;
                nVar.invokeSuspend(rVar);
                return rVar;
            case 1:
                n nVar2 = (n) create((k5.p) obj, (g7.d) obj2);
                c7.r rVar2 = c7.r.f1986a;
                nVar2.invokeSuspend(rVar2);
                return rVar2;
            case 2:
                n nVar3 = (n) create((k5.o) obj, (g7.d) obj2);
                c7.r rVar3 = c7.r.f1986a;
                nVar3.invokeSuspend(rVar3);
                return rVar3;
            default:
                n nVar4 = (n) create((k5.m) obj, (g7.d) obj2);
                c7.r rVar4 = c7.r.f1986a;
                nVar4.invokeSuspend(rVar4);
                return rVar4;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015e  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
