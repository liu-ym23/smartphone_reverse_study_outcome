package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final c f10248f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f10249g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f10250h;
    public static final c i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f10251j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f10252k;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10253c;

    static {
        int i3 = 1;
        f10248f = new c(i3, 0);
        f10249g = new c(i3, 1);
        f10250h = new c(i3, 2);
        i = new c(i3, 3);
        f10251j = new c(i3, 4);
        f10252k = new c(i3, 5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i3, int i10) {
        super(i3);
        this.f10253c = i10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f10253c) {
            case 0:
                return obj;
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 2:
                long j10 = ((d1.m0) obj).f3017a;
                return new s.k(Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L)));
            case 3:
                s.k kVar = (s.k) obj;
                float f5 = kVar.f11036a;
                float f10 = kVar.f11037b;
                return d1.m0.a((Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
            case 4:
                return s.d.m(7, null);
            default:
                return c0.f10256c;
        }
    }
}
