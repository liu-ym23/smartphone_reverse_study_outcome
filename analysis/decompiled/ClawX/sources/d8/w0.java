package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w0 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2190f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f2191g;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2190f = uVar.c();
        if (uVar.f2171a.remaining() > 0) {
            this.f2191g = uVar.c();
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(w2.a(this.f2190f, true));
        if (this.f2191g != null) {
            sb.append(" ");
            sb.append(w2.a(this.f2191g, true));
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.i(this.f2190f);
        byte[] bArr = this.f2191g;
        if (bArr != null) {
            jVar.i(bArr);
        }
    }
}
