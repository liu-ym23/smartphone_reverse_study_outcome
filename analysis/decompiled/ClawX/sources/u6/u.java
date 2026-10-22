package u6;

import java.io.IOException;
import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u extends c7.d {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v f5759n;

    public u(v vVar) {
        this.f5759n = vVar;
    }

    @Override // c7.d
    public final IOException k(IOException iOException) {
        return new SocketTimeoutException("timeout");
    }

    @Override // c7.d
    public final void l() {
        this.f5759n.g(b.f5675h);
        n nVar = this.f5759n.f5761b;
        synchronized (nVar) {
            long j4 = nVar.f5727p;
            long j8 = nVar.f5726o;
            if (j4 < j8) {
                return;
            }
            nVar.f5726o = j8 + 1;
            nVar.f5728q = System.nanoTime() + 1000000000;
            q6.c.b(nVar.f5720h, m0.f.f(new StringBuilder(), nVar.f5716c, " ping"), 0L, new b7.c(21, nVar), 6);
        }
    }

    public final void m() {
        if (j()) {
            throw k(null);
        }
    }
}
