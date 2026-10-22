package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f1996f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f1997g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f1998h;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f1996f = uVar.f();
        this.f1997g = uVar.c();
        this.f1998h = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        return this.f1996f + " " + w2.a(this.f1997g, false) + " " + w2.a(this.f1998h, true);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f1996f);
        jVar.i(this.f1997g);
        jVar.h(this.f1998h);
    }
}
