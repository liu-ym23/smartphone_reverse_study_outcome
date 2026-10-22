package ed;

import java.io.IOException;
import java.net.ProtocolException;
import od.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: f, reason: collision with root package name */
    public long f3778f;

    /* renamed from: g, reason: collision with root package name */
    public long f3779g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3780h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3781j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ e f3782k;

    @Override // od.q, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f3781j) {
            return;
        }
        this.f3781j = true;
        try {
            super.close();
            d(null);
        } catch (IOException e10) {
            throw d(e10);
        }
    }

    public final IOException d(IOException iOException) {
        e eVar = this.f3782k;
        if (this.i) {
            return iOException;
        }
        this.i = true;
        if (iOException == null && this.f3780h) {
            this.f3780h = false;
            eVar.getClass();
        }
        return eVar.a(true, false, iOException);
    }

    @Override // od.q, od.i0
    public final long l(od.i iVar, long j10) throws IOException {
        long j11 = this.f3778f;
        iVar.getClass();
        if (this.f3781j) {
            od.f.e("closed");
            return 0L;
        }
        try {
            long jL = this.f9480c.l(iVar, j10);
            if (this.f3780h) {
                this.f3780h = false;
                this.f3782k.getClass();
            }
            if (jL == -1) {
                d(null);
                return -1L;
            }
            long j12 = this.f3779g + jL;
            if (j11 != -1 && j12 > j11) {
                throw new ProtocolException("expected " + j11 + " bytes but received " + j12);
            }
            this.f3779g = j12;
            if (j12 == j11) {
                d(null);
            }
            return jL;
        } catch (IOException e10) {
            throw d(e10);
        }
    }
}
