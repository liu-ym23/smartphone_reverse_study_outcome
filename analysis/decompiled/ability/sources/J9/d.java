package J9;

import F9.t;
import V9.w;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes4.dex */
public final class d extends V9.k {
    public final long b;
    public long c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final /* synthetic */ G6.c g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(G6.c cVar, w delegate, long j5) {
        super(delegate);
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.g = cVar;
        this.b = j5;
        this.d = true;
        if (j5 == 0) {
            b(null);
        }
    }

    public final IOException b(IOException iOException) {
        if (this.e) {
            return iOException;
        }
        this.e = true;
        G6.c cVar = this.g;
        if (iOException == null && this.d) {
            this.d = false;
            ((t) cVar.d).s((i) cVar.c);
        }
        return cVar.a(this.c, true, false, iOException);
    }

    @Override // V9.k, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f) {
            return;
        }
        this.f = true;
        try {
            super.close();
            b(null);
        } catch (IOException e) {
            throw b(e);
        }
    }

    @Override // V9.w
    public final long e(V9.g sink, long j5) throws IOException {
        kotlin.jvm.internal.k.f(sink, "sink");
        if (this.f) {
            throw new IllegalStateException("closed");
        }
        try {
            long jE = this.f1419a.e(sink, 8192L);
            if (this.d) {
                this.d = false;
                G6.c cVar = this.g;
                ((t) cVar.d).s((i) cVar.c);
            }
            if (jE == -1) {
                b(null);
                return -1L;
            }
            long j6 = this.c + jE;
            long j10 = this.b;
            if (j10 == -1 || j6 <= j10) {
                this.c = j6;
                if (j6 == j10) {
                    b(null);
                }
                return jE;
            }
            throw new ProtocolException("expected " + j10 + " bytes but received " + j6);
        } catch (IOException e) {
            throw b(e);
        }
    }
}
