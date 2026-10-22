package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15006c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f15007f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f15008g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i, int i3, Object obj) {
        super(2);
        this.f15006c = i3;
        this.f15008g = obj;
        this.f15007f = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f15006c) {
            case 0:
                ((Number) obj2).intValue();
                p.a((w0.m) this.f15008g, (k0.s) obj, k0.z.D(this.f15007f | 1));
                break;
            default:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
                    sVar.S();
                } else {
                    x.h hVar = (x.h) this.f15008g;
                    b2.a aVar = hVar.f15413b.f15407a;
                    int i = this.f15007f;
                    y.h hVarG = aVar.g(i);
                    ((s0.c) hVarG.f15747c.f9743h).c(hVar.f15414c, Integer.valueOf(i - hVarG.f15745a), sVar, 0);
                }
                break;
        }
        return jb.v.f6774a;
    }
}
