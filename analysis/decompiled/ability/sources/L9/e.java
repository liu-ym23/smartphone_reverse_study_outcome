package L9;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class e extends b {
    public long d;
    public final /* synthetic */ A8.a e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(A8.a aVar, long j5) {
        super(aVar);
        this.e = aVar;
        this.d = j5;
        if (j5 == 0) {
            b();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zT;
        if (this.b) {
            return;
        }
        if (this.d != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            byte[] bArr = G9.b.f704a;
            k.f(timeUnit, "timeUnit");
            try {
                zT = G9.b.t(this, 100);
            } catch (IOException unused) {
                zT = false;
            }
            if (!zT) {
                ((okhttp3.internal.connection.a) this.e.d).k();
                b();
            }
        }
        this.b = true;
    }

    @Override // L9.b, V9.w
    public final long e(V9.g sink, long j5) throws IOException {
        k.f(sink, "sink");
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        long j6 = this.d;
        if (j6 == 0) {
            return -1L;
        }
        long jE = super.e(sink, Math.min(j6, 8192L));
        if (jE == -1) {
            ((okhttp3.internal.connection.a) this.e.d).k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b();
            throw protocolException;
        }
        long j10 = this.d - jE;
        this.d = j10;
        if (j10 == 0) {
            b();
        }
        return jE;
    }
}
