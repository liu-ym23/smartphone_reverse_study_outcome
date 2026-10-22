package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o0 f13867c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f13868f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f13869g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r1 f13870h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(o0 o0Var, long j10, long j11, r1 r1Var) {
        super(0);
        this.f13867c = o0Var;
        this.f13868f = j10;
        this.f13869g = j11;
        this.f13870h = r1Var;
    }

    @Override // xb.a
    public final Object invoke() {
        o0 o0Var = this.f13867c;
        o0Var.s0().f13861c = false;
        o0Var.s0().f13862f = this.f13868f;
        o0Var.s0().f13863g = this.f13869g;
        xb.l lVarF = this.f13870h.f13912c.f();
        if (lVarF != null) {
            lVarF.invoke(o0Var.s0());
        }
        return jb.v.f6774a;
    }
}
