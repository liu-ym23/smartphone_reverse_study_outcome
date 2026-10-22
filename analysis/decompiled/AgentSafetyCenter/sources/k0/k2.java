package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k2 extends u0.x {

    /* renamed from: c, reason: collision with root package name */
    public int f6967c;

    public k2(int i, long j10) {
        super(j10);
        this.f6967c = i;
    }

    @Override // u0.x
    public final void a(u0.x xVar) {
        xVar.getClass();
        this.f6967c = ((k2) xVar).f6967c;
    }

    @Override // u0.x
    public final u0.x b(long j10) {
        return new k2(this.f6967c, j10);
    }
}
