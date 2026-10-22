package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2026f;

    /* renamed from: g, reason: collision with root package name */
    public int f2027g;

    /* renamed from: h, reason: collision with root package name */
    public int f2028h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2029j;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2026f = uVar.d();
        this.f2027g = uVar.d();
        this.f2028h = uVar.f();
        this.f2029j = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2026f);
        sb.append(" ");
        sb.append(this.f2027g);
        sb.append(" ");
        sb.append(this.f2028h);
        if (this.f2029j != null) {
            if (p2.a()) {
                sb.append(" (\n");
                sb.append(a.a.H(this.f2029j, true));
            } else {
                sb.append(" ");
                sb.append(a.a.f0(this.f2029j));
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2026f);
        jVar.j(this.f2027g);
        jVar.m(this.f2028h);
        jVar.h(this.f2029j);
    }
}
