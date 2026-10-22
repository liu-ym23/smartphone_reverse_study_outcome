package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h4 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2017f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f2018g;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2017f = uVar.d();
        this.f2018g = new x1(uVar);
    }

    @Override // d8.w2
    public final String k() {
        return this.f2017f + " " + this.f2018g;
    }

    @Override // d8.w2
    public void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2017f);
        this.f2018g.j(jVar, null, z);
    }
}
