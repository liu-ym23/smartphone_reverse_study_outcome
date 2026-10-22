package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g2 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11619c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ u8.k f11620f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f11621g;

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f11619c) {
            case 0:
                u8.k kVar = this.f11620f;
                String str = this.f11621g;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    int iOrdinal = kVar.f14224f.ordinal();
                    if (iOrdinal == 3 || iOrdinal == 4) {
                        sVar.X(1549059718);
                        i2.b(kVar, str, sVar, 0);
                        sVar.q(false);
                    } else {
                        sVar.X(1549173767);
                        i2.d(kVar, str, sVar, 0);
                        sVar.q(false);
                    }
                } else {
                    sVar.S();
                }
                return jb.v.f6774a;
            case 1:
                ((Integer) obj2).getClass();
                i2.b(this.f11620f, this.f11621g, (k0.s) obj, k0.z.D(1));
                break;
            default:
                ((Integer) obj2).getClass();
                i2.d(this.f11620f, this.f11621g, (k0.s) obj, k0.z.D(1));
                break;
        }
        return jb.v.f6774a;
    }
}
