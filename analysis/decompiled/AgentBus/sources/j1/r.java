package j1;

/* loaded from: classes.dex */
public final class r extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final r f5305h;

    /* renamed from: i, reason: collision with root package name */
    public static final r f5306i;

    /* renamed from: j, reason: collision with root package name */
    public static final r f5307j;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5308g;

    static {
        int i2 = 1;
        f5305h = new r(i2, 0);
        f5306i = new r(i2, 1);
        f5307j = new r(i2, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i2, int i10) {
        super(i2);
        this.f5308g = i10;
    }

    @Override // p7.k
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f5308g) {
            case 0:
                return c7.r.f1986a;
            case 1:
                return Boolean.TRUE;
            default:
                return Boolean.FALSE;
        }
    }
}
