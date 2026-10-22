package d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements u {

    /* renamed from: a, reason: collision with root package name */
    public v1.t f2961a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2962b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2963c;

    /* renamed from: d, reason: collision with root package name */
    public c f2964d;

    @Override // d1.u
    public final void a(g1.b bVar) {
        synchronized (this.f2962b) {
            if (!bVar.f4218s) {
                bVar.f4218s = true;
                bVar.b();
            }
        }
    }

    @Override // d1.u
    public final g1.b b() {
        g1.b bVar;
        synchronized (this.f2962b) {
            this.f2961a.getUniqueDrawingId();
            bVar = new g1.b(new g1.c());
        }
        return bVar;
    }
}
