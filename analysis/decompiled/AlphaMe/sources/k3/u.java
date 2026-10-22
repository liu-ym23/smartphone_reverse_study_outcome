package k3;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class u implements InterfaceC0695j {

    /* renamed from: a, reason: collision with root package name */
    public final z f13379a;

    /* renamed from: b, reason: collision with root package name */
    public final C0694i f13380b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13381c;

    public u(z sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f13379a = sink;
        this.f13380b = new C0694i();
    }

    @Override // k3.InterfaceC0695j
    public final long A(InterfaceC0680B source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j4 = 0;
        while (true) {
            long j5 = ((C0689d) source).read(this.f13380b, 8192L);
            if (j5 == -1) {
                return j4;
            }
            j4 += j5;
            x();
        }
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j B(int i4, int i5, byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.S(i4, i5, source);
        x();
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j G(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.d0(string);
        x();
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j H(long j4) {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.W(j4);
        x();
        return this;
    }

    @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        z zVar = this.f13379a;
        if (this.f13381c) {
            return;
        }
        try {
            C0694i c0694i = this.f13380b;
            long j4 = c0694i.f13357b;
            if (j4 > 0) {
                zVar.write(c0694i, j4);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            zVar.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f13381c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // k3.InterfaceC0695j
    public final C0694i f() {
        return this.f13380b;
    }

    @Override // k3.InterfaceC0695j, k3.z, java.io.Flushable
    public final void flush() {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        C0694i c0694i = this.f13380b;
        long j4 = c0694i.f13357b;
        z zVar = this.f13379a;
        if (j4 > 0) {
            zVar.write(c0694i, j4);
        }
        zVar.flush();
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j g(long j4) {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.X(j4);
        x();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f13381c;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j k() {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        C0694i c0694i = this.f13380b;
        long j4 = c0694i.f13357b;
        if (j4 > 0) {
            this.f13379a.write(c0694i, j4);
        }
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j p(int i4) {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.a0(i4);
        x();
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j q(int i4) {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.Y(i4);
        x();
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j r(l byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.T(byteString);
        x();
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j t(int i4) {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.V(i4);
        x();
        return this;
    }

    @Override // k3.z
    public final C0683E timeout() {
        return this.f13379a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f13379a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j v(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13380b.U(source);
        x();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f13380b.write(source);
        x();
        return iWrite;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j x() {
        if (!(!this.f13381c)) {
            throw new IllegalStateException("closed".toString());
        }
        C0694i c0694i = this.f13380b;
        long jD = c0694i.d();
        if (jD > 0) {
            this.f13379a.write(c0694i, jD);
        }
        return this;
    }

    @Override // k3.z
    public final void write(C0694i source, long j4) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f13381c) {
            this.f13380b.write(source, j4);
            x();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }
}
