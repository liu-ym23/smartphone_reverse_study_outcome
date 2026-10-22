package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class x3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2214f;

    /* renamed from: g, reason: collision with root package name */
    public int f2215g;

    /* renamed from: h, reason: collision with root package name */
    public int f2216h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2217j;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2214f = uVar.f();
        this.f2215g = uVar.f();
        this.f2216h = uVar.f();
        byte[] bArrA = uVar.a();
        this.f2217j = bArrA;
        if (bArrA.length == 0) {
            throw new l4("end of input");
        }
    }

    @Override // d8.w2
    public final String k() {
        return this.f2214f + " " + this.f2215g + " " + this.f2216h + " " + b8.h.O(this.f2217j);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f2214f);
        jVar.m(this.f2215g);
        jVar.m(this.f2216h);
        jVar.h(this.f2217j);
    }
}
