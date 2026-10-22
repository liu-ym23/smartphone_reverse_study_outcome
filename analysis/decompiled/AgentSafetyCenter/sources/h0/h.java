package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4989c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.p f4990f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s0.c f4991g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(xb.p pVar, s0.c cVar, int i) {
        super(2);
        this.f4989c = i;
        this.f4990f = pVar;
        this.f4991g = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f4989c;
        jb.v vVar = jb.v.f6774a;
        int i3 = 0;
        s0.c cVar = this.f4991g;
        xb.p pVar = this.f4990f;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar.B()) {
                    sVar.X(1497073862);
                    if (pVar != null) {
                        pVar.invoke(sVar, 0);
                    }
                    sVar.q(false);
                    cVar.invoke(sVar, 0);
                    break;
                } else {
                    sVar.S();
                    break;
                }
            default:
                k0.s sVar2 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar2.B()) {
                    float f5 = m.f5059a;
                    m.b(s0.h.d(1887135077, new h(pVar, cVar, i3), sVar2), sVar2, 438);
                    break;
                } else {
                    sVar2.S();
                    break;
                }
                break;
        }
        return vVar;
    }
}
