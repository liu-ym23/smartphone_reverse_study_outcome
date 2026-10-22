package hd;

import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends od.d {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v f5565m;

    public u(v vVar) {
        this.f5565m = vVar;
    }

    @Override // od.d
    public final void j() {
        this.f5565m.e(9);
        o oVar = this.f5565m.f5567b;
        synchronized (oVar) {
            long j10 = oVar.f5530r;
            long j11 = oVar.f5529q;
            if (j10 < j11) {
                return;
            }
            oVar.f5529q = j11 + 1;
            oVar.f5531s = System.nanoTime() + 1000000000;
            oVar.f5524l.c(new dd.b(androidx.activity.b.n(new StringBuilder(), oVar.f5520g, " ping"), 2, oVar), 0L);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
