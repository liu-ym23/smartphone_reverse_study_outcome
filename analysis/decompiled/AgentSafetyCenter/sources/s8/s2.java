package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class s2 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11959c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ a3 f11960f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f11961g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ xb.a f11962h;
    public /* synthetic */ xb.l i;

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f11959c) {
            case 0:
                a3 a3Var = this.f11960f;
                boolean z10 = this.f11961g;
                xb.a aVar = this.f11962h;
                xb.l lVar = this.i;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x2.h(a3Var, z10, aVar, lVar, sVar, 0);
                } else {
                    sVar.S();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                x2.h(this.f11960f, this.f11961g, this.f11962h, this.i, (k0.s) obj, k0.z.D(1));
                break;
        }
        return jb.v.f6774a;
    }
}
