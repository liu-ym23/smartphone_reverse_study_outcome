package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends m0 {

    /* renamed from: g, reason: collision with root package name */
    public final g f7447g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o0 f7448h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(o0 o0Var, long j10, g gVar) {
        super(j10);
        this.f7448h = o0Var;
        this.f7447g = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7447g.B(this.f7448h);
    }

    @Override // kc.m0
    public final String toString() {
        return super.toString() + this.f7447g;
    }
}
