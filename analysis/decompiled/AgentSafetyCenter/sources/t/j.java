package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final j f13013f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f13014g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f13015h;
    public static final j i;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13016c;

    static {
        int i3 = 1;
        f13013f = new j(i3, 0);
        f13014g = new j(i3, 1);
        f13015h = new j(i3, 2);
        i = new j(i3, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i3, int i10) {
        super(i3);
        this.f13016c = i10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i3 = this.f13016c;
        jb.v vVar = jb.v.f6774a;
        switch (i3) {
            case 0:
                ((u1.i0) obj).b();
                return vVar;
            case 1:
                return vVar;
            case 2:
                a2.f fVar = a2.f.f43b;
                fc.c[] cVarArr = a2.w.f144a;
                a2.x xVar = a2.u.f119c;
                fc.c cVar = a2.w.f144a[1];
                ((a2.k) obj).d(xVar, fVar);
                return vVar;
            default:
                return new h1(((Number) obj).intValue());
        }
    }
}
