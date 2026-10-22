package d8;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f1941f;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f1941f = uVar.b(16);
    }

    @Override // d8.w2
    public final String k() throws UnknownHostException {
        try {
            InetAddress byAddress = InetAddress.getByAddress(null, this.f1941f);
            if (byAddress.getAddress().length != 4) {
                return byAddress.getHostAddress();
            }
            return "::ffff:" + byAddress.getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.h(this.f1941f);
    }
}
