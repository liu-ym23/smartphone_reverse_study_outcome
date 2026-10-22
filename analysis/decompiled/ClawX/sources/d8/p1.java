package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p1 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2113f;

    /* renamed from: g, reason: collision with root package name */
    public int f2114g;

    /* renamed from: h, reason: collision with root package name */
    public int f2115h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2116j;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2113f = uVar.f();
        this.f2114g = uVar.f();
        this.f2115h = uVar.d();
        int iF = uVar.f();
        if (iF > 0) {
            this.f2116j = uVar.b(iF);
        } else {
            this.f2116j = null;
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2113f);
        sb.append(' ');
        sb.append(this.f2114g);
        sb.append(' ');
        sb.append(this.f2115h);
        sb.append(' ');
        byte[] bArr = this.f2116j;
        if (bArr == null) {
            sb.append('-');
        } else {
            sb.append(b8.h.O(bArr));
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f2113f);
        jVar.m(this.f2114g);
        jVar.j(this.f2115h);
        byte[] bArr = this.f2116j;
        if (bArr == null) {
            jVar.m(0);
        } else {
            jVar.m(bArr.length);
            jVar.h(this.f2116j);
        }
    }
}
