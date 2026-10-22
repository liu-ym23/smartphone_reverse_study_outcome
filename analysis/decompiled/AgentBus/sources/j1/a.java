package j1;

/* loaded from: classes.dex */
public final class a extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5090g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5091h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2, int i10, Object obj) {
        super(2);
        this.f5090g = i10;
        this.f5091h = obj;
    }

    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Object, p7.o, q7.m] */
    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5090g) {
            case 0:
                b0.p pVar = (b0.p) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (pVar.L(iIntValue & 1, (iIntValue & 3) != 2)) {
                    ((b) this.f5091h).a(0, pVar);
                } else {
                    pVar.O();
                }
                return c7.r.f1986a;
            case 1:
                ((Number) obj2).intValue();
                ((f1) this.f5091h).a(b0.b.s(1), (b0.p) obj);
                return c7.r.f1986a;
            case 2:
                ((Number) obj2).intValue();
                ((n.d0) this.f5091h).a(b0.b.s(1), (b0.p) obj);
                return c7.r.f1986a;
            case 3:
                n0.m mVar = (n0.m) obj;
                n0.m mVarU = (n0.k) obj2;
                b0.p pVar2 = (b0.p) this.f5091h;
                if (mVarU instanceof n0.h) {
                    ?? r62 = ((n0.h) mVarU).f6794b;
                    q7.z.c(3, r62);
                    mVarU = a.a.U(pVar2, (n0.m) r62.j(n0.j.f6796a, pVar2, 0));
                }
                return mVar.c(mVarU);
            default:
                ((Number) obj2).intValue();
                r.l.a((n0.m) this.f5091h, (b0.p) obj, b0.b.s(1));
                return c7.r.f1986a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2, Object obj) {
        super(2);
        this.f5090g = i2;
        this.f5091h = obj;
    }
}
