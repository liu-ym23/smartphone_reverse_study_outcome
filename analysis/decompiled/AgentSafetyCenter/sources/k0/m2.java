package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m2 extends u0.x {

    /* renamed from: c, reason: collision with root package name */
    public Object f6979c;

    public m2(Object obj, long j10) {
        super(j10);
        this.f6979c = obj;
    }

    @Override // u0.x
    public final void a(u0.x xVar) {
        xVar.getClass();
        this.f6979c = ((m2) xVar).f6979c;
    }

    @Override // u0.x
    public final u0.x b(long j10) {
        return new m2(this.f6979c, u0.m.k().g());
    }
}
