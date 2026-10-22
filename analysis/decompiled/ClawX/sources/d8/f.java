package d8;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f1988f;

    public static byte[] p(int i8) {
        return new byte[]{(byte) ((i8 >>> 24) & 255), (byte) ((i8 >>> 16) & 255), (byte) ((i8 >>> 8) & 255), (byte) (i8 & 255)};
    }

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        byte[] bArrB = uVar.b(4);
        this.f1988f = (bArrB[3] & 255) | ((bArrB[0] & 255) << 24) | ((bArrB[1] & 255) << 16) | ((bArrB[2] & 255) << 8);
    }

    @Override // d8.w2
    public final String k() {
        return a.a.e0(p(this.f1988f));
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.l(this.f1988f & 4294967295L);
    }

    public final InetAddress o() {
        try {
            x1 x1Var = this.f2195a;
            return x1Var == null ? InetAddress.getByAddress(p(this.f1988f)) : InetAddress.getByAddress(x1Var.toString(), p(this.f1988f));
        } catch (UnknownHostException unused) {
            return null;
        }
    }
}
