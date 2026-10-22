package k3;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import l3.AbstractC0765a;

/* loaded from: classes2.dex */
public final class v implements InterfaceC0696k {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0680B f13382a;

    /* renamed from: b, reason: collision with root package name */
    public final C0694i f13383b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13384c;

    public v(InterfaceC0680B source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f13382a = source;
        this.f13383b = new C0694i();
    }

    @Override // k3.InterfaceC0696k
    public final void E(long j4) throws EOFException {
        if (!c(j4)) {
            throw new EOFException();
        }
    }

    @Override // k3.InterfaceC0696k
    public final void F(C0694i sink, long j4) throws EOFException {
        C0694i c0694i = this.f13383b;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            E(j4);
            c0694i.F(sink, j4);
        } catch (EOFException e4) {
            sink.A(c0694i);
            throw e4;
        }
    }

    @Override // k3.InterfaceC0696k
    public final long J() throws EOFException {
        C0694i c0694i;
        byte bL;
        E(1L);
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            boolean zC = c(i5);
            c0694i = this.f13383b;
            if (!zC) {
                break;
            }
            bL = c0694i.l(i4);
            if ((bL < ((byte) 48) || bL > ((byte) 57)) && ((bL < ((byte) 97) || bL > ((byte) 102)) && (bL < ((byte) 65) || bL > ((byte) 70)))) {
                break;
            }
            i4 = i5;
        }
        if (i4 == 0) {
            StringBuilder sb = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bL, CharsKt.checkRadix(CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return c0694i.J();
    }

    @Override // k3.InterfaceC0696k
    public final String K(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        InterfaceC0680B interfaceC0680B = this.f13382a;
        C0694i c0694i = this.f13383b;
        c0694i.A(interfaceC0680B);
        return c0694i.K(charset);
    }

    @Override // k3.InterfaceC0696k
    public final long L(C0694i sink) {
        C0694i c0694i;
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j4 = 0;
        while (true) {
            InterfaceC0680B interfaceC0680B = this.f13382a;
            c0694i = this.f13383b;
            if (interfaceC0680B.read(c0694i, 8192L) == -1) {
                break;
            }
            long jD = c0694i.d();
            if (jD > 0) {
                j4 += jD;
                sink.write(c0694i, jD);
            }
        }
        long j5 = c0694i.f13357b;
        if (j5 <= 0) {
            return j4;
        }
        long j6 = j4 + j5;
        sink.write(c0694i, j5);
        return j6;
    }

    @Override // k3.InterfaceC0696k
    public final C0693h M() {
        return new C0693h(this, 1);
    }

    public final long a(byte b4, long j4, long j5) {
        if (!(!this.f13384c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        if (0 > j5) {
            throw new IllegalArgumentException(AbstractC0351g.n("fromIndex=0 toIndex=", j5).toString());
        }
        while (jMax < j5) {
            long jM = this.f13383b.m(b4, jMax, j5);
            if (jM != -1) {
                return jM;
            }
            C0694i c0694i = this.f13383b;
            long j6 = c0694i.f13357b;
            if (j6 >= j5 || this.f13382a.read(c0694i, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j6);
        }
        return -1L;
    }

    public final long b() {
        C0694i c0694i;
        byte bL;
        E(1L);
        long j4 = 0;
        while (true) {
            long j5 = j4 + 1;
            boolean zC = c(j5);
            c0694i = this.f13383b;
            if (!zC) {
                break;
            }
            bL = c0694i.l(j4);
            if ((bL < ((byte) 48) || bL > ((byte) 57)) && !(j4 == 0 && bL == ((byte) 45))) {
                break;
            }
            j4 = j5;
        }
        if (j4 == 0) {
            StringBuilder sb = new StringBuilder("Expected a digit or '-' but was 0x");
            String string = Integer.toString(bL, CharsKt.checkRadix(CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return c0694i.I();
    }

    @Override // k3.InterfaceC0696k
    public final boolean c(long j4) {
        C0694i c0694i;
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("byteCount < 0: ", j4).toString());
        }
        if (!(!this.f13384c)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            c0694i = this.f13383b;
            if (c0694i.f13357b >= j4) {
                return true;
            }
        } while (this.f13382a.read(c0694i, 8192L) != -1);
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f13384c) {
            return;
        }
        this.f13384c = true;
        this.f13382a.close();
        this.f13383b.a();
    }

    public final int d() throws EOFException {
        E(4L);
        int i4 = this.f13383b.readInt();
        return ((i4 & 255) << 24) | (((-16777216) & i4) >>> 24) | ((16711680 & i4) >>> 8) | ((65280 & i4) << 8);
    }

    @Override // k3.InterfaceC0696k, k3.InterfaceC0695j
    public final C0694i f() {
        return this.f13383b;
    }

    @Override // k3.InterfaceC0696k
    public final l h() {
        InterfaceC0680B interfaceC0680B = this.f13382a;
        C0694i c0694i = this.f13383b;
        c0694i.A(interfaceC0680B);
        return c0694i.i(c0694i.f13357b);
    }

    @Override // k3.InterfaceC0696k
    public final l i(long j4) throws EOFException {
        E(j4);
        return this.f13383b.i(j4);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f13384c;
    }

    @Override // k3.InterfaceC0696k
    public final void j(long j4) throws EOFException {
        if (!(!this.f13384c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j4 > 0) {
            C0694i c0694i = this.f13383b;
            if (c0694i.f13357b == 0 && this.f13382a.read(c0694i, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j4, c0694i.f13357b);
            c0694i.j(jMin);
            j4 -= jMin;
        }
    }

    @Override // k3.InterfaceC0696k
    public final String n() {
        return y(LongCompanionObject.MAX_VALUE);
    }

    @Override // k3.InterfaceC0696k
    public final byte[] o() {
        InterfaceC0680B interfaceC0680B = this.f13382a;
        C0694i c0694i = this.f13383b;
        c0694i.A(interfaceC0680B);
        return c0694i.D(c0694i.f13357b);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        C0694i c0694i = this.f13383b;
        if (c0694i.f13357b == 0 && this.f13382a.read(c0694i, 8192L) == -1) {
            return -1;
        }
        return c0694i.read(sink);
    }

    @Override // k3.InterfaceC0696k
    public final byte readByte() throws EOFException {
        E(1L);
        return this.f13383b.readByte();
    }

    @Override // k3.InterfaceC0696k
    public final void readFully(byte[] sink) throws EOFException {
        C0694i c0694i = this.f13383b;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            E(sink.length);
            c0694i.readFully(sink);
        } catch (EOFException e4) {
            int i4 = 0;
            while (true) {
                long j4 = c0694i.f13357b;
                if (j4 <= 0) {
                    throw e4;
                }
                int iW = c0694i.w(sink, i4, (int) j4);
                if (iW == -1) {
                    throw new AssertionError();
                }
                i4 += iW;
            }
        }
    }

    @Override // k3.InterfaceC0696k
    public final int readInt() throws EOFException {
        E(4L);
        return this.f13383b.readInt();
    }

    @Override // k3.InterfaceC0696k
    public final long readLong() throws EOFException {
        E(8L);
        return this.f13383b.readLong();
    }

    @Override // k3.InterfaceC0696k
    public final short readShort() throws EOFException {
        E(2L);
        return this.f13383b.readShort();
    }

    @Override // k3.InterfaceC0696k
    public final boolean s() {
        if (!(!this.f13384c)) {
            throw new IllegalStateException("closed".toString());
        }
        C0694i c0694i = this.f13383b;
        return c0694i.s() && this.f13382a.read(c0694i, 8192L) == -1;
    }

    @Override // k3.InterfaceC0680B
    public final C0683E timeout() {
        return this.f13382a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f13382a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Override // k3.InterfaceC0696k
    public final String y(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("limit < 0: ", j4).toString());
        }
        long j5 = j4 == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
        byte b4 = (byte) 10;
        long jA = a(b4, 0L, j5);
        C0694i c0694i = this.f13383b;
        if (jA != -1) {
            return AbstractC0765a.a(c0694i, jA);
        }
        if (j5 < LongCompanionObject.MAX_VALUE && c(j5) && c0694i.l(j5 - 1) == ((byte) 13) && c(1 + j5) && c0694i.l(j5) == b4) {
            return AbstractC0765a.a(c0694i, j5);
        }
        C0694i c0694i2 = new C0694i();
        c0694i.e(0L, c0694i2, Math.min(32, c0694i.f13357b));
        throw new EOFException("\\n not found: limit=" + Math.min(c0694i.f13357b, j4) + " content=" + c0694i2.i(c0694i2.f13357b).d() + Typography.ellipsis);
    }

    @Override // k3.InterfaceC0696k
    public final int z(t options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!this.f13384c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            C0694i c0694i = this.f13383b;
            int iB = AbstractC0765a.b(c0694i, options, true);
            if (iB != -2) {
                if (iB != -1) {
                    c0694i.j(options.f13377a[iB].c());
                    return iB;
                }
            } else if (this.f13382a.read(c0694i, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // k3.InterfaceC0680B
    public final long read(C0694i sink, long j4) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j4 >= 0) {
            if (!this.f13384c) {
                C0694i c0694i = this.f13383b;
                if (c0694i.f13357b == 0 && this.f13382a.read(c0694i, 8192L) == -1) {
                    return -1L;
                }
                return c0694i.read(sink, Math.min(j4, c0694i.f13357b));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(AbstractC0351g.n("byteCount < 0: ", j4).toString());
    }
}
