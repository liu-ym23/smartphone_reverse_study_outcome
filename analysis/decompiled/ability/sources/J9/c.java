package J9;

import V9.u;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes4.dex */
public final class c extends V9.j {

    /* renamed from: a, reason: collision with root package name */
    public final long f892a;
    public boolean b;
    public long c;
    public boolean d;
    public final /* synthetic */ G6.c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(G6.c cVar, u delegate, long j5) {
        super(delegate);
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.e = cVar;
        this.f892a = j5;
    }

    public final IOException b(IOException iOException) {
        if (this.b) {
            return iOException;
        }
        this.b = true;
        return this.e.a(this.c, false, true, iOException);
    }

    @Override // V9.j, V9.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        long j5 = this.f892a;
        if (j5 != -1 && this.c != j5) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            b(null);
        } catch (IOException e) {
            throw b(e);
        }
    }

    @Override // V9.j, V9.u, java.io.Flushable
    public final void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e) {
            throw b(e);
        }
    }

    @Override // V9.j, V9.u
    public final void write(V9.g source, long j5) throws IOException {
        kotlin.jvm.internal.k.f(source, "source");
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        long j6 = this.f892a;
        if (j6 == -1 || this.c + j5 <= j6) {
            try {
                super.write(source, j5);
                this.c += j5;
                return;
            } catch (IOException e) {
                throw b(e);
            }
        }
        throw new ProtocolException("expected " + j6 + " bytes but received " + (this.c + j5));
    }
}
