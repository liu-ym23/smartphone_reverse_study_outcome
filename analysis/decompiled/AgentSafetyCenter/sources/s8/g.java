package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11607c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f11608f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f11609g;

    public /* synthetic */ g(int i) {
        this.f11607c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f11607c) {
            case 0:
                String str = (String) this.f11609g;
                int i = this.f11608f;
                ((Integer) obj2).getClass();
                s.c(str, (k0.s) obj, k0.z.D(1), i);
                break;
            case 1:
                xb.a aVar = (xb.a) this.f11609g;
                int i3 = this.f11608f;
                ((Integer) obj2).intValue();
                g1.b(aVar, (k0.s) obj, k0.z.D(i3 | 1));
                break;
            default:
                u8.k kVar = (u8.k) this.f11609g;
                int i10 = this.f11608f;
                ((Integer) obj2).intValue();
                i2.c(kVar, (k0.s) obj, k0.z.D(i10 | 1));
                break;
        }
        return jb.v.f6774a;
    }
}
