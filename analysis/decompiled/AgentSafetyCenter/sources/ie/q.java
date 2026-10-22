package ie;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class q extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6064c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f6065f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(c cVar, int i) {
        super(1);
        this.f6064c = i;
        this.f6065f = cVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f6064c) {
            case 0:
                this.f6065f.cancel();
                break;
            default:
                this.f6065f.cancel();
                break;
        }
        return jb.v.f6774a;
    }
}
