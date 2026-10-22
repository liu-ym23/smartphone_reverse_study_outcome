package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j2 extends u0.x {

    /* renamed from: c, reason: collision with root package name */
    public float f6964c;

    public j2(float f5, long j10) {
        super(j10);
        this.f6964c = f5;
    }

    @Override // u0.x
    public final void a(u0.x xVar) {
        xVar.getClass();
        this.f6964c = ((j2) xVar).f6964c;
    }

    @Override // u0.x
    public final u0.x b(long j10) {
        return new j2(this.f6964c, j10);
    }
}
