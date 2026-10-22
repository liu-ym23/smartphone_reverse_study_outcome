package ed;

import java.io.IOException;
import java.net.ProtocolException;
import od.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends p {

    /* renamed from: f, reason: collision with root package name */
    public long f3774f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3775g;

    /* renamed from: h, reason: collision with root package name */
    public long f3776h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ e f3777j;

    @Override // od.p, od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.i) {
            return;
        }
        this.i = true;
        long j10 = this.f3774f;
        if (j10 != -1 && this.f3776h != j10) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            d(null);
        } catch (IOException e10) {
            throw d(e10);
        }
    }

    public final IOException d(IOException iOException) {
        if (this.f3775g) {
            return iOException;
        }
        this.f3775g = true;
        return this.f3777j.a(false, true, iOException);
    }

    @Override // od.p, od.g0
    public final void f(od.i iVar, long j10) throws IOException {
        long j11 = this.f3774f;
        iVar.getClass();
        if (this.i) {
            od.f.e("closed");
            return;
        }
        if (j11 == -1 || this.f3776h + j10 <= j11) {
            try {
                this.f9479c.f(iVar, j10);
                this.f3776h += j10;
                return;
            } catch (IOException e10) {
                throw d(e10);
            }
        }
        throw new ProtocolException("expected " + j11 + " bytes but received " + (this.f3776h + j10));
    }

    @Override // od.p, od.g0, java.io.Flushable
    public final void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e10) {
            throw d(e10);
        }
    }
}
