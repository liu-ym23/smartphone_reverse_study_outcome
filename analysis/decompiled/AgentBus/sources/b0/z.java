package b0;

/* loaded from: classes.dex */
public final /* synthetic */ class z implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1436f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1437g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1438h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1439i;

    public /* synthetic */ z(int i2, int i10, Object obj, Object obj2) {
        this.f1436f = i10;
        this.f1438h = obj;
        this.f1439i = obj2;
        this.f1437g = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1436f) {
            case 0:
                ((Integer) obj2).intValue();
                b.b((x1[]) this.f1438h, (p7.n) this.f1439i, (p) obj, b.s(this.f1437g | 1));
                break;
            default:
                ((Integer) obj2).intValue();
                int iS = b.s(this.f1437g) | 1;
                ((j0.d) this.f1438h).d(this.f1439i, (p) obj, iS);
                break;
        }
        return c7.r.f1986a;
    }
}
