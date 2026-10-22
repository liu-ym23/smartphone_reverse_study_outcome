package o;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final k f7072h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f7073i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f7074j;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7075g;

    static {
        int i2 = 1;
        f7072h = new k(i2, 0);
        f7073i = new k(i2, 1);
        f7074j = new k(i2, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i2, int i10) {
        super(i2);
        this.f7075g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        int i2 = this.f7075g;
        c7.r rVar = c7.r.f1986a;
        switch (i2) {
            case 0:
                ((i1.h0) obj).a();
                return rVar;
            case 1:
                p1.e eVar = p1.e.f8274b;
                w7.t[] tVarArr = p1.u.f8372a;
                p1.v vVar = p1.s.f8346c;
                w7.t tVar = p1.u.f8372a[1];
                vVar.a((p1.i) obj, eVar);
                return rVar;
            default:
                return new y0(((Number) obj).intValue());
        }
    }
}
