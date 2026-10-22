package y;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final e f11378h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f11379i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f11380j;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11381g;

    static {
        int i2 = 1;
        f11378h = new e(i2, 0);
        f11379i = new e(i2, 1);
        f11380j = new e(i2, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, int i10) {
        super(i2);
        this.f11381g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        int i2 = this.f11381g;
        c7.r rVar = c7.r.f1986a;
        switch (i2) {
            case 0:
                p1.u.a((p1.i) obj);
                break;
            case 1:
                break;
            default:
                w7.t[] tVarArr = p1.u.f8372a;
                p1.v vVar = p1.s.f8355l;
                w7.t tVar = p1.u.f8372a[5];
                vVar.a((p1.i) obj, Boolean.TRUE);
                break;
        }
        return rVar;
    }
}
