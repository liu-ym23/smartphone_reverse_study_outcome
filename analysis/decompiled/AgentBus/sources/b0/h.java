package b0;

/* loaded from: classes.dex */
public final class h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public static final h f1163g = new h(0);

    /* renamed from: h, reason: collision with root package name */
    public static final h f1164h = new h(1);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1165f;

    public /* synthetic */ h(int i2) {
        this.f1165f = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1165f) {
            case 0:
                p pVar = (p) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!pVar.L(iIntValue & 1, (iIntValue & 3) != 2)) {
                    pVar.O();
                }
                break;
            default:
                p pVar2 = (p) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!pVar2.L(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    pVar2.O();
                }
                break;
        }
        return c7.r.f1986a;
    }
}
