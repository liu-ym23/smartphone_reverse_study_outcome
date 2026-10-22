package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j4 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2039f;

    /* renamed from: g, reason: collision with root package name */
    public int f2040g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f2041h;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2039f = uVar.d();
        this.f2040g = uVar.d();
        this.f2041h = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        return this.f2039f + " " + this.f2040g + " " + w2.a(this.f2041h, true);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2039f);
        jVar.j(this.f2040g);
        jVar.h(this.f2041h);
    }
}
