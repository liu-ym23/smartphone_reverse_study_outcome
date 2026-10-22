package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public static final i f6931f = new i(0);

    /* renamed from: g, reason: collision with root package name */
    public static final i f6932g = new i(1);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6933c;

    public /* synthetic */ i(int i) {
        this.f6933c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f6933c) {
            case 0:
                s sVar = (s) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                }
                break;
            default:
                s sVar2 = (s) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    sVar2.S();
                }
                break;
        }
        return jb.v.f6774a;
    }
}
