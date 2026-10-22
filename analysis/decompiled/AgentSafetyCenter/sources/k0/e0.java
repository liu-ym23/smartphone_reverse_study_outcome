package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends s1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6879b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6880c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(int i, xb.a aVar) {
        super(aVar);
        this.f6879b = i;
    }

    @Override // k0.s1
    public final t1 a(Object obj) {
        switch (this.f6879b) {
            case 0:
                return new t1(this, obj, obj == null, null, true);
            default:
                return new t1(this, obj, obj == null, (y0) this.f6880c, true);
        }
    }

    @Override // k0.s1
    public u2 b() {
        switch (this.f6879b) {
            case 0:
                return (f0) this.f6880c;
            default:
                return super.b();
        }
    }
}
