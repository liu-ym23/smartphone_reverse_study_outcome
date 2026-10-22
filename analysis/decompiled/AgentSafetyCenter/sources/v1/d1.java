package v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f14402c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t4.d f14403f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f14404g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(boolean z10, t4.d dVar, String str) {
        super(0);
        this.f14402c = z10;
        this.f14403f = dVar;
        this.f14404g = str;
    }

    @Override // xb.a
    public final Object invoke() {
        if (this.f14402c) {
            t4.d dVar = this.f14403f;
            String str = this.f14404g;
            v4.b bVar = dVar.f13167a;
            synchronized (bVar.f14766c) {
            }
        }
        return jb.v.f6774a;
    }
}
