package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class z extends a {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f7503h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(nb.g gVar, boolean z10, int i) {
        super(gVar, z10);
        this.f7503h = i;
    }

    @Override // kc.e1
    public boolean I(Throwable th) {
        switch (this.f7503h) {
            case 1:
                w.p(this.f7414g, th);
                return true;
            default:
                return super.I(th);
        }
    }
}
