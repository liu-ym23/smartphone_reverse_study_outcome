package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final r f5119f;

    /* renamed from: g, reason: collision with root package name */
    public static final r f5120g;

    /* renamed from: h, reason: collision with root package name */
    public static final r f5121h;
    public static final r i;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5122c;

    static {
        int i3 = 1;
        f5119f = new r(i3, 0);
        f5120g = new r(i3, 1);
        f5121h = new r(i3, 2);
        i = new r(i3, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i3, int i10) {
        super(i3);
        this.f5122c = i10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i3 = this.f5122c;
        jb.v vVar = jb.v.f6774a;
        switch (i3) {
            case 0:
                a2.w.a((a2.k) obj, 0);
                break;
            case 1:
                break;
            case 2:
                fc.c[] cVarArr = a2.w.f144a;
                a2.x xVar = a2.u.f127l;
                fc.c cVar = a2.w.f144a[5];
                ((a2.k) obj).d(xVar, Boolean.TRUE);
                break;
            default:
                break;
        }
        return vVar;
    }
}
