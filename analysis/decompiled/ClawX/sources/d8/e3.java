package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f1983f;

    /* renamed from: g, reason: collision with root package name */
    public int f1984g;

    /* renamed from: h, reason: collision with root package name */
    public int f1985h;

    /* renamed from: j, reason: collision with root package name */
    public x1 f1986j;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f1983f = uVar.d();
        this.f1984g = uVar.d();
        this.f1985h = uVar.d();
        this.f1986j = new x1(uVar);
    }

    @Override // d8.w2
    public final String k() {
        return this.f1983f + " " + this.f1984g + " " + this.f1985h + " " + this.f1986j;
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f1983f);
        jVar.j(this.f1984g);
        jVar.j(this.f1985h);
        this.f1986j.j(jVar, null, z);
    }
}
