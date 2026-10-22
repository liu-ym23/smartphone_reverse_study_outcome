package gd;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import od.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: h, reason: collision with root package name */
    public long f4721h;
    public final /* synthetic */ g i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, long j10) {
        super(gVar);
        this.i = gVar;
        this.f4721h = j10;
        if (j10 == 0) {
            d();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.f4713f) {
            return;
        }
        if (this.f4721h != 0) {
            byte[] bArr = bd.b.f2074a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zU = bd.b.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                this.i.f4727b.j();
                d();
            }
        }
        this.f4713f = true;
    }

    @Override // gd.a, od.i0
    public final long l(i iVar, long j10) throws IOException {
        iVar.getClass();
        if (j10 < 0) {
            od.f.c(k0.a.m("byteCount < 0: ", j10));
            return 0L;
        }
        if (this.f4713f) {
            od.f.e("closed");
            return 0L;
        }
        long j11 = this.f4721h;
        if (j11 == 0) {
            return -1L;
        }
        long jL = super.l(iVar, Math.min(j11, j10));
        if (jL == -1) {
            this.i.f4727b.j();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            d();
            throw protocolException;
        }
        long j12 = this.f4721h - jL;
        this.f4721h = j12;
        if (j12 == 0) {
            d();
        }
        return jL;
    }
}
