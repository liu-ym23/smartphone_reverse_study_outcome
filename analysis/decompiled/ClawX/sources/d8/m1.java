package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m1 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2082f;

    /* renamed from: g, reason: collision with root package name */
    public int f2083g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f2084h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2085j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f2086k;

    /* renamed from: l, reason: collision with root package name */
    public x1 f2087l;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2082f = uVar.d();
        this.f2083g = uVar.d();
        this.f2084h = uVar.c();
        this.f2085j = uVar.c();
        this.f2086k = uVar.c();
        this.f2087l = new x1(uVar);
    }

    @Override // d8.w2
    public final String k() {
        return this.f2082f + " " + this.f2083g + " " + w2.a(this.f2084h, true) + " " + w2.a(this.f2085j, true) + " " + w2.a(this.f2086k, true) + " " + this.f2087l;
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2082f);
        jVar.j(this.f2083g);
        jVar.i(this.f2084h);
        jVar.i(this.f2085j);
        jVar.i(this.f2086k);
        this.f2087l.j(jVar, null, z);
    }
}
