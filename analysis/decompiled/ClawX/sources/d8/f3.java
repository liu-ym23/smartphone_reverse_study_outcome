package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f1992f;

    /* renamed from: g, reason: collision with root package name */
    public int f1993g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f1994h;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f1992f = uVar.f();
        this.f1993g = uVar.f();
        this.f1994h = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        return this.f1992f + " " + this.f1993g + " " + b8.h.O(this.f1994h);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f1992f);
        jVar.m(this.f1993g);
        jVar.h(this.f1994h);
    }
}
