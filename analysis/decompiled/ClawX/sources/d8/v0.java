package d8;

import java.io.Serializable;
import java.net.InetAddress;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v0 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2179f;

    /* renamed from: g, reason: collision with root package name */
    public int f2180g;

    /* renamed from: h, reason: collision with root package name */
    public int f2181h;

    /* renamed from: j, reason: collision with root package name */
    public Serializable f2182j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f2183k;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2179f = uVar.f();
        this.f2180g = uVar.f();
        this.f2181h = uVar.f();
        int i8 = this.f2180g;
        if (i8 == 0) {
            this.f2182j = null;
        } else if (i8 == 1) {
            this.f2182j = InetAddress.getByAddress(uVar.b(4));
        } else if (i8 == 2) {
            this.f2182j = InetAddress.getByAddress(uVar.b(16));
        } else {
            if (i8 != 3) {
                throw new l4("invalid gateway type");
            }
            this.f2182j = new x1(uVar);
        }
        if (uVar.f2171a.remaining() > 0) {
            this.f2183k = uVar.a();
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2179f);
        sb.append(" ");
        sb.append(this.f2180g);
        sb.append(" ");
        sb.append(this.f2181h);
        sb.append(" ");
        int i8 = this.f2180g;
        if (i8 == 0) {
            sb.append(".");
        } else if (i8 == 1 || i8 == 2) {
            sb.append(((InetAddress) this.f2182j).getHostAddress());
        } else if (i8 == 3) {
            sb.append(this.f2182j);
        }
        if (this.f2183k != null) {
            sb.append(" ");
            sb.append(a.a.f0(this.f2183k));
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f2179f);
        jVar.m(this.f2180g);
        jVar.m(this.f2181h);
        int i8 = this.f2180g;
        if (i8 == 1 || i8 == 2) {
            jVar.h(((InetAddress) this.f2182j).getAddress());
        } else if (i8 == 3) {
            ((x1) this.f2182j).j(jVar, null, z);
        }
        byte[] bArr = this.f2183k;
        if (bArr != null) {
            jVar.g(0, bArr.length, bArr);
        }
    }
}
