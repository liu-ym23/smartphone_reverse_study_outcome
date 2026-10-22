package sd;

import java.nio.ByteBuffer;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class y implements g {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f11983a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11984b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11985c;

    public y(c0 sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        this.f11983a = sink;
        this.f11984b = new e();
    }

    @Override // sd.g
    public final g D(String string) {
        kotlin.jvm.internal.g.f(string, "string");
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.U0(string);
        a();
        return this;
    }

    public final g a() {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f11984b;
        long jC = eVar.C();
        if (jC > 0) {
            this.f11983a.j0(eVar, jC);
        }
        return this;
    }

    @Override // sd.g
    public final e c() {
        return this.f11984b;
    }

    @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c0 c0Var = this.f11983a;
        if (this.f11985c) {
            return;
        }
        try {
            e eVar = this.f11984b;
            long j10 = eVar.f11926b;
            if (j10 > 0) {
                c0Var.j0(eVar, j10);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            c0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f11985c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sd.g, sd.c0, java.io.Flushable
    public final void flush() {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f11984b;
        long j10 = eVar.f11926b;
        c0 c0Var = this.f11983a;
        if (j10 > 0) {
            c0Var.j0(eVar, j10);
        }
        c0Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f11985c;
    }

    @Override // sd.c0
    public final void j0(e source, long j10) {
        kotlin.jvm.internal.g.f(source, "source");
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.j0(source, j10);
        a();
    }

    @Override // sd.g
    public final g p() {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f11984b;
        long j10 = eVar.f11926b;
        if (j10 > 0) {
            this.f11983a.j0(eVar, j10);
        }
        return this;
    }

    @Override // sd.g
    public final g s0(long j10) {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.Q0(j10);
        a();
        return this;
    }

    @Override // sd.c0
    public final f0 timeout() {
        return this.f11983a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f11983a + ')';
    }

    @Override // sd.g
    public final long u(e0 source) {
        kotlin.jvm.internal.g.f(source, "source");
        long j10 = 0;
        while (true) {
            long j11 = source.read(this.f11984b, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            a();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.g.f(source, "source");
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f11984b.write(source);
        a();
        return iWrite;
    }

    @Override // sd.g
    public final g writeByte(int i10) {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.O0(i10);
        a();
        return this;
    }

    @Override // sd.g
    public final g writeInt(int i10) {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.R0(i10);
        a();
        return this;
    }

    @Override // sd.g
    public final g writeShort(int i10) {
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.S0(i10);
        a();
        return this;
    }

    @Override // sd.g
    public final g z0(ByteString byteString) {
        kotlin.jvm.internal.g.f(byteString, "byteString");
        if (this.f11985c) {
            throw new IllegalStateException("closed");
        }
        this.f11984b.N0(byteString);
        a();
        return this;
    }

    @Override // sd.g
    public final g write(byte[] source) {
        kotlin.jvm.internal.g.f(source, "source");
        if (!this.f11985c) {
            this.f11984b.m176write(source);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // sd.g
    public final g write(byte[] source, int i10, int i11) {
        kotlin.jvm.internal.g.f(source, "source");
        if (!this.f11985c) {
            this.f11984b.m177write(source, i10, i11);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
