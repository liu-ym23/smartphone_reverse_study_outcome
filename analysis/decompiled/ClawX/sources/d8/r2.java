package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r2 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2136f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f2137g;

    /* renamed from: h, reason: collision with root package name */
    public x1 f2138h;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2136f = uVar.d();
        this.f2137g = new x1(uVar);
        this.f2138h = new x1(uVar);
    }

    @Override // d8.w2
    public final String k() {
        return this.f2136f + " " + this.f2137g + " " + this.f2138h;
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2136f);
        this.f2137g.j(jVar, null, z);
        this.f2138h.j(jVar, null, z);
    }
}
