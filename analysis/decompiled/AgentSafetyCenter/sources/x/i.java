package x;

import y.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends yb.l implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f15416c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f15417f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f15418g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f15419h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(x xVar, long j10, int i, int i3) {
        super(3);
        this.f15416c = xVar;
        this.f15417f = j10;
        this.f15418g = i;
        this.f15419h = i3;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int i = iIntValue + this.f15418g;
        long j10 = this.f15417f;
        int iF = o2.b.f(i, j10);
        int iE = o2.b.e(iIntValue2 + this.f15419h, j10);
        kb.t tVar = kb.t.f7405c;
        return this.f15416c.f15834f.Y(iF, iE, tVar, (xb.l) obj3);
    }
}
