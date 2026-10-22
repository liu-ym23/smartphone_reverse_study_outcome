package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c2 extends nb.a implements kc.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v0.b f6870c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d2 f6871f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(v0.b bVar, d2 d2Var) {
        super(kc.q.f7473c);
        this.f6870c = bVar;
        this.f6871f = d2Var;
    }

    @Override // kc.r
    public final void handleException(nb.g gVar, Throwable th) throws Throwable {
        v0.b bVar = this.f6870c;
        d2 d2Var = this.f6871f;
        bVar.a(th, d2Var);
        kc.r rVar = (kc.r) d2Var.f6874c.get(kc.q.f7473c);
        if (rVar == null) {
            throw th;
        }
        rVar.handleException(gVar, th);
    }
}
