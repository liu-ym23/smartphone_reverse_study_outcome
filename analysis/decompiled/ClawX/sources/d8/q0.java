package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q0 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2119f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f2120g;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2119f = uVar.c();
        this.f2120g = uVar.c();
    }

    @Override // d8.w2
    public final String k() {
        return w2.a(this.f2119f, true) + " " + w2.a(this.f2120g, true);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.i(this.f2119f);
        jVar.i(this.f2120g);
    }
}
