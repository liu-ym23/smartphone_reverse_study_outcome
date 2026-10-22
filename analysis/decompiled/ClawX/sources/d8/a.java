package d8;

import java.net.InetAddress;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f1936f;

    /* renamed from: g, reason: collision with root package name */
    public InetAddress f1937g;

    /* renamed from: h, reason: collision with root package name */
    public x1 f1938h;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        int iF = uVar.f();
        this.f1936f = iF;
        int i8 = (135 - iF) / 8;
        if (iF < 128) {
            byte[] bArr = new byte[16];
            uVar.g(i8);
            uVar.f2171a.get(bArr, 16 - i8, i8);
            this.f1937g = InetAddress.getByAddress(bArr);
        }
        if (this.f1936f > 0) {
            this.f1938h = new x1(uVar);
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1936f);
        if (this.f1937g != null) {
            sb.append(" ");
            sb.append(this.f1937g.getHostAddress());
        }
        if (this.f1938h != null) {
            sb.append(" ");
            sb.append(this.f1938h);
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f1936f);
        InetAddress inetAddress = this.f1937g;
        if (inetAddress != null) {
            int i8 = (135 - this.f1936f) / 8;
            jVar.g(16 - i8, i8, inetAddress.getAddress());
        }
        x1 x1Var = this.f1938h;
        if (x1Var != null) {
            x1Var.j(jVar, null, z);
        }
    }
}
