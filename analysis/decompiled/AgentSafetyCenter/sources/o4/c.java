package o4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9156c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ p5.c f9157f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f9158g;

    public /* synthetic */ c(int i) {
        this.f9156c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f9156c) {
            case 0:
                x4.a aVarJ = this.f9157f.j(this.f9158g);
                t0.a.d(aVarJ, "PRAGMA query_only = 1");
                return aVarJ;
            default:
                return this.f9157f.j(this.f9158g);
        }
    }
}
