package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2154f;

    /* renamed from: g, reason: collision with root package name */
    public int f2155g;

    /* renamed from: h, reason: collision with root package name */
    public int f2156h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2157j;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2154f = uVar.d();
        this.f2155g = uVar.f();
        this.f2156h = uVar.f();
        this.f2157j = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2154f);
        sb.append(" ");
        sb.append(this.f2155g);
        sb.append(" ");
        sb.append(this.f2156h);
        if (this.f2157j != null) {
            sb.append(" ");
            sb.append(b8.h.O(this.f2157j));
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2154f);
        jVar.m(this.f2155g);
        jVar.m(this.f2156h);
        byte[] bArr = this.f2157j;
        if (bArr != null) {
            jVar.g(0, bArr.length, bArr);
        }
    }
}
