package V9;

import java.nio.ByteBuffer;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class q implements h {

    /* renamed from: a, reason: collision with root package name */
    public final u f1424a;
    public final g b;
    public boolean c;

    public q(u sink) {
        kotlin.jvm.internal.k.f(sink, "sink");
        this.f1424a = sink;
        this.b = new g();
    }

    @Override // V9.h
    public final h A(ByteString byteString) {
        kotlin.jvm.internal.k.f(byteString, "byteString");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.K(byteString);
        b();
        return this;
    }

    @Override // V9.h
    public final long B(w wVar) {
        long j5 = 0;
        while (true) {
            long jE = ((c) wVar).e(this.b, 8192L);
            if (jE == -1) {
                return j5;
            }
            j5 += jE;
            b();
        }
    }

    @Override // V9.h
    public final g a() {
        return this.b;
    }

    public final h b() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        g gVar = this.b;
        long jF = gVar.f();
        if (jF > 0) {
            this.f1424a.write(gVar, jF);
        }
        return this;
    }

    @Override // V9.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        u uVar = this.f1424a;
        if (this.c) {
            return;
        }
        try {
            g gVar = this.b;
            long j5 = gVar.b;
            if (j5 > 0) {
                uVar.write(gVar, j5);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            uVar.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // V9.h, V9.u, java.io.Flushable
    public final void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        g gVar = this.b;
        long j5 = gVar.b;
        u uVar = this.f1424a;
        if (j5 > 0) {
            uVar.write(gVar, j5);
        }
        uVar.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // V9.h
    public final h m(String string) {
        kotlin.jvm.internal.k.f(string, "string");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.R(string);
        b();
        return this;
    }

    @Override // V9.u
    public final y timeout() {
        return this.f1424a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f1424a + ')';
    }

    @Override // V9.h
    public final h u(long j5) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.M(j5);
        b();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.k.f(source, "source");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.b.write(source);
        b();
        return iWrite;
    }

    @Override // V9.h
    public final h writeByte(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.L(i);
        b();
        return this;
    }

    @Override // V9.h
    public final h writeInt(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.O(i);
        b();
        return this;
    }

    @Override // V9.h
    public final h writeShort(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.P(i);
        b();
        return this;
    }

    @Override // V9.h
    public final h y(long j5) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.N(j5);
        b();
        return this;
    }

    @Override // V9.u
    public final void write(g source, long j5) {
        kotlin.jvm.internal.k.f(source, "source");
        if (!this.c) {
            this.b.write(source, j5);
            b();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // V9.h
    public final h write(byte[] source) {
        kotlin.jvm.internal.k.f(source, "source");
        if (!this.c) {
            this.b.m1write(source, 0, source.length);
            b();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // V9.h
    public final h write(byte[] source, int i, int i6) {
        kotlin.jvm.internal.k.f(source, "source");
        if (!this.c) {
            this.b.m1write(source, i, i6);
            b();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
