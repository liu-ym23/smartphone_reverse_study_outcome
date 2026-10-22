package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l2 extends u0.x {

    /* renamed from: c, reason: collision with root package name */
    public long f6973c;

    public l2(long j10, long j11) {
        super(j10);
        this.f6973c = j11;
    }

    @Override // u0.x
    public final void a(u0.x xVar) {
        xVar.getClass();
        this.f6973c = ((l2) xVar).f6973c;
    }

    @Override // u0.x
    public final u0.x b(long j10) {
        return new l2(j10, this.f6973c);
    }
}
