package s0;

/* loaded from: classes.dex */
public final class j extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final j f9174h;

    /* renamed from: i, reason: collision with root package name */
    public static final j f9175i;

    /* renamed from: j, reason: collision with root package name */
    public static final j f9176j;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9177g;

    static {
        int i2 = 1;
        f9174h = new j(i2, 0);
        f9175i = new j(i2, 1);
        f9176j = new j(i2, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i2, int i10) {
        super(i2);
        this.f9177g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f9177g) {
            case 0:
                return c7.r.f1986a;
            case 1:
                return c7.r.f1986a;
            default:
                return Boolean.valueOf(((q) obj).p0(7));
        }
    }
}
