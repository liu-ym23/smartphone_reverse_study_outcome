package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g1 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public x1 f2000f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f2001g;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2000f = new x1(uVar);
        this.f2001g = new x1(uVar);
    }

    @Override // d8.w2
    public final String k() {
        return this.f2000f + " " + this.f2001g;
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        this.f2000f.j(jVar, null, z);
        this.f2001g.j(jVar, null, z);
    }
}
