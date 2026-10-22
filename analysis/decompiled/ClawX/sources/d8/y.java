package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class y extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2218f;

    /* renamed from: g, reason: collision with root package name */
    public int f2219g;

    /* renamed from: h, reason: collision with root package name */
    public int f2220h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2221j;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2218f = uVar.d();
        this.f2219g = uVar.f();
        this.f2220h = uVar.f();
        this.f2221j = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2218f);
        sb.append(" ");
        sb.append(this.f2219g);
        sb.append(" ");
        sb.append(this.f2220h);
        if (this.f2221j != null) {
            sb.append(" ");
            sb.append(b8.h.O(this.f2221j));
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2218f);
        jVar.m(this.f2219g);
        jVar.m(this.f2220h);
        byte[] bArr = this.f2221j;
        if (bArr != null) {
            jVar.g(0, bArr.length, bArr);
        }
    }
}
