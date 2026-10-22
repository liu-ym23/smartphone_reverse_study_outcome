package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends yb.l implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public static final d0 f4941f;

    /* renamed from: g, reason: collision with root package name */
    public static final d0 f4942g;

    /* renamed from: h, reason: collision with root package name */
    public static final d0 f4943h;
    public static final d0 i;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4944c;

    static {
        int i3 = 2;
        f4941f = new d0(i3, 0);
        f4942g = new d0(i3, 1);
        f4943h = new d0(i3, 2);
        i = new d0(i3, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(int i3, int i10) {
        super(i3);
        this.f4944c = i10;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4944c) {
            case 0:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
                    sVar.S();
                }
                break;
            case 1:
                k0.s sVar2 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar2.B()) {
                    sVar2.S();
                }
                break;
            case 2:
                k0.s sVar3 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar3.B()) {
                    sVar3.S();
                }
                break;
            default:
                k0.s sVar4 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar4.B()) {
                    sVar4.S();
                }
                break;
        }
        return jb.v.f6774a;
    }
}
