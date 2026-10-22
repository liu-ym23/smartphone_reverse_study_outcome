package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends x {

    /* renamed from: c, reason: collision with root package name */
    public o0.c f13709c;

    /* renamed from: d, reason: collision with root package name */
    public int f13710d;

    /* renamed from: e, reason: collision with root package name */
    public int f13711e;

    public u(long j10, o0.c cVar) {
        super(j10);
        this.f13709c = cVar;
    }

    @Override // u0.x
    public final void a(x xVar) {
        synchronized (r.f13688a) {
            xVar.getClass();
            this.f13709c = ((u) xVar).f13709c;
            this.f13710d = ((u) xVar).f13710d;
            this.f13711e = ((u) xVar).f13711e;
        }
    }

    @Override // u0.x
    public final x b(long j10) {
        return new u(j10, this.f13709c);
    }
}
