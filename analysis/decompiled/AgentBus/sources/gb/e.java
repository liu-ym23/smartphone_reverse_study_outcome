package gb;

import eb.m;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import q7.k;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: i, reason: collision with root package name */
    public long f4044i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h f4045j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, long j2) {
        super(hVar);
        this.f4045j = hVar;
        this.f4044i = j2;
        if (j2 == 0) {
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.f4035g) {
            return;
        }
        if (this.f4044i != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            byte[] bArr = bb.b.f1659a;
            k.e(timeUnit, "timeUnit");
            try {
                zU = bb.b.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                ((m) this.f4045j.f4054d).k();
                a();
            }
        }
        this.f4035g = true;
    }

    @Override // gb.b, ob.k0
    public final long read(ob.h hVar, long j2) throws IOException {
        k.e(hVar, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        if (this.f4035g) {
            throw new IllegalStateException("closed");
        }
        long j4 = this.f4044i;
        if (j4 == 0) {
            return -1L;
        }
        long j10 = super.read(hVar, Math.min(j4, j2));
        if (j10 == -1) {
            ((m) this.f4045j.f4054d).k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j11 = this.f4044i - j10;
        this.f4044i = j11;
        if (j11 == 0) {
            a();
        }
        return j10;
    }
}
