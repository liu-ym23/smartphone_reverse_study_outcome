package Mb;

import La.C0951a;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020)H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020)2\u0006\u00102\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u0010+J\u000f\u00104\u001a\u00020\u001eH\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u000206H\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\u001eH\u0016¢\u0006\u0004\b:\u00105J\u000f\u0010;\u001a\u00020\u001eH\u0016¢\u0006\u0004\b;\u00105J\u000f\u0010<\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\nH\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b?\u0010\u0013J\u0017\u0010@\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0016H\u0016¢\u0006\u0004\b@\u0010AJ'\u0010D\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0019H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\nH\u0016¢\u0006\u0004\bI\u0010JJ'\u0010K\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0019H\u0016¢\u0006\u0004\bN\u0010HJ\u001f\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\nH\u0016¢\u0006\u0004\bO\u0010JJ\u001f\u0010Q\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0019H\u0016¢\u0006\u0004\bQ\u0010RJ/\u0010T\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u001eH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0001H\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u000eH\u0016¢\u0006\u0004\b[\u0010\u0010J\u000f\u0010\\\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020)H\u0016¢\u0006\u0004\ba\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010dR\u0016\u0010g\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b_\u0010fR\u001b\u0010i\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\bh\u0010]\u001a\u0004\bb\u0010\b¨\u0006j"}, d2 = {"LMb/D;", "LMb/f;", "LMb/I;", "source", "<init>", "(LMb/I;)V", "LMb/d;", "u", "()LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "", "k", "()Z", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "request", "(J)Z", "", "readByte", "()B", "Lokio/ByteString;", "z0", "(J)Lokio/ByteString;", "LMb/x;", "options", "", "p0", "(LMb/x;)I", "Ljava/nio/ByteBuffer;", "read", "(Ljava/nio/ByteBuffer;)I", "O0", "(LMb/d;J)V", "LMb/G;", "c1", "(LMb/G;)J", "", "x0", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "S0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "h0", "()Ljava/lang/String;", "limit", "I", "U0", "()I", "", "readShort", "()S", "l0", "readInt", "e1", "o0", "()J", "p1", "skip", Const.INTENT_KEY_PKGNAME, "(B)J", "fromIndex", "toIndex", ExifInterface.LONGITUDE_EAST, "(BJJ)J", SingleFileBundle.KEY_BYTES, "C", "(Lokio/ByteString;)J", "e", "(Lokio/ByteString;J)J", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lokio/ByteString;JJ)J", "targetBytes", "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "offset", "P", "(JLokio/ByteString;)Z", "bytesOffset", "l", "(JLokio/ByteString;II)Z", "peek", "()LMb/f;", "Ljava/io/InputStream;", "r1", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "LMb/J;", "c", "()LMb/J;", "toString", Const.INTENT_KEY_APIKEY, "LMb/I;", "LMb/d;", "bufferField", "Z", AlipayXuiIsland.REASON_CLOSED, "getBuffer$annotations", "buffer", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.D, reason: from toString */
/* loaded from: classes5.dex */
public final class buffer implements InterfaceC0968f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final I source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C0966d bufferField;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    public buffer(I source) {
        kotlin.jvm.internal.p.i(source, "source");
        this.source = source;
        this.bufferField = new C0966d();
    }

    @Override // Mb.InterfaceC0968f
    public long C(ByteString bytes) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return e(bytes, 0L);
    }

    @Override // Mb.InterfaceC0968f
    public long E(byte b10, long fromIndex, long toIndex) {
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        long jMax = fromIndex;
        while (jMax < toIndex) {
            byte b11 = b10;
            long j10 = toIndex;
            long jE = this.bufferField.E(b11, jMax, j10);
            if (jE != -1) {
                return jE;
            }
            long size = this.bufferField.getSize();
            if (size >= j10 || this.source.u0(this.bufferField, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b10 = b11;
            toIndex = j10;
        }
        return -1L;
    }

    @Override // Mb.InterfaceC0968f
    public long F(ByteString targetBytes) {
        kotlin.jvm.internal.p.i(targetBytes, "targetBytes");
        return i(targetBytes, 0L);
    }

    @Override // Mb.InterfaceC0968f
    public String I(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j10 = limit == Long.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long jE = E((byte) 10, 0L, j10);
        if (jE != -1) {
            return Nb.a.g(this.bufferField, jE);
        }
        if (j10 < Long.MAX_VALUE && request(j10) && this.bufferField.Y(j10 - 1) == 13 && request(j10 + 1) && this.bufferField.Y(j10) == 10) {
            return Nb.a.g(this.bufferField, j10);
        }
        C0966d c0966d = new C0966d();
        C0966d c0966d2 = this.bufferField;
        c0966d2.V(c0966d, 0L, Math.min(32, c0966d2.getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.getSize(), limit) + " content=" + c0966d.N0().t() + (char) 8230);
    }

    @Override // Mb.InterfaceC0968f
    public void O0(C0966d sink, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        try {
            j(byteCount);
            this.bufferField.O0(sink, byteCount);
        } catch (EOFException e10) {
            sink.V0(this.bufferField);
            throw e10;
        }
    }

    @Override // Mb.InterfaceC0968f
    public boolean P(long offset, ByteString bytes) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return l(offset, bytes, 0, bytes.K());
    }

    @Override // Mb.InterfaceC0968f
    public String S0(Charset charset) throws IOException {
        kotlin.jvm.internal.p.i(charset, "charset");
        this.bufferField.V0(this.source);
        return this.bufferField.S0(charset);
    }

    @Override // Mb.InterfaceC0968f
    public int U0() {
        j(1L);
        byte bY = this.bufferField.Y(0L);
        if ((bY & 224) == 192) {
            j(2L);
        } else if ((bY & 240) == 224) {
            j(3L);
        } else if ((bY & 248) == 240) {
            j(4L);
        }
        return this.bufferField.U0();
    }

    @Override // Mb.InterfaceC0968f
    /* renamed from: a, reason: from getter */
    public C0966d getBufferField() {
        return this.bufferField;
    }

    public long b(byte b10) {
        return E(b10, 0L, Long.MAX_VALUE);
    }

    @Override // Mb.I
    /* renamed from: c */
    public J getTimeout() {
        return this.source.getTimeout();
    }

    @Override // Mb.InterfaceC0968f
    public long c1(G sink) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        long j10 = 0;
        while (this.source.u0(this.bufferField, 8192L) != -1) {
            long jN = this.bufferField.n();
            if (jN > 0) {
                j10 += jN;
                sink.K(this.bufferField, jN);
            }
        }
        if (this.bufferField.getSize() <= 0) {
            return j10;
        }
        long size = j10 + this.bufferField.getSize();
        C0966d c0966d = this.bufferField;
        sink.K(c0966d, c0966d.getSize());
        return size;
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.g();
    }

    public long e(ByteString bytes, long fromIndex) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return g(bytes, fromIndex, Long.MAX_VALUE);
    }

    @Override // Mb.InterfaceC0968f
    public int e1() {
        j(4L);
        return this.bufferField.e1();
    }

    public long g(ByteString bytes, long fromIndex, long toIndex) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return Nb.f.b(this, bytes, 0, 0, fromIndex, toIndex, 6, null);
    }

    @Override // Mb.InterfaceC0968f
    public String h0() {
        return I(Long.MAX_VALUE);
    }

    public long i(ByteString targetBytes, long fromIndex) {
        kotlin.jvm.internal.p.i(targetBytes, "targetBytes");
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        while (true) {
            long jK0 = this.bufferField.k0(targetBytes, fromIndex);
            if (jK0 != -1) {
                return jK0;
            }
            long size = this.bufferField.getSize();
            if (this.source.u0(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // Mb.InterfaceC0968f
    public void j(long byteCount) {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // Mb.InterfaceC0968f
    public boolean k() {
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        return this.bufferField.k() && this.source.u0(this.bufferField, 8192L) == -1;
    }

    public boolean l(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        return byteCount >= 0 && offset >= 0 && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.K() && (byteCount == 0 || Nb.f.a(this, bytes, bytesOffset, byteCount, offset, offset + 1) != -1);
    }

    @Override // Mb.InterfaceC0968f
    public short l0() {
        j(2L);
        return this.bufferField.l0();
    }

    @Override // Mb.InterfaceC0968f
    public long o0() {
        j(8L);
        return this.bufferField.o0();
    }

    @Override // Mb.InterfaceC0968f
    public int p0(x options) throws EOFException {
        kotlin.jvm.internal.p.i(options, "options");
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        do {
            int iH = Nb.a.h(this.bufferField, options, true);
            if (iH != -2) {
                if (iH == -1) {
                    return -1;
                }
                this.bufferField.skip(options.getByteStrings()[iH].K());
                return iH;
            }
        } while (this.source.u0(this.bufferField, 8192L) != -1);
        return -1;
    }

    @Override // Mb.InterfaceC0968f
    public long p1() {
        byte bY;
        j(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!request(i11)) {
                break;
            }
            bY = this.bufferField.Y(i10);
            if ((bY < 48 || bY > 57) && ((bY < 97 || bY > 102) && (bY < 65 || bY > 70))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bY, C0951a.a(16));
            kotlin.jvm.internal.p.h(string, "toString(...)");
            sb2.append(string);
            throw new NumberFormatException(sb2.toString());
        }
        return this.bufferField.p1();
    }

    @Override // Mb.InterfaceC0968f
    public InterfaceC0968f peek() {
        return u.c(new A(this));
    }

    @Override // Mb.InterfaceC0968f
    public InputStream r1() {
        return new a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (this.bufferField.getSize() == 0 && this.source.u0(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    @Override // Mb.InterfaceC0968f
    public byte readByte() {
        j(1L);
        return this.bufferField.readByte();
    }

    @Override // Mb.InterfaceC0968f
    public int readInt() {
        j(4L);
        return this.bufferField.readInt();
    }

    @Override // Mb.InterfaceC0968f
    public short readShort() {
        j(2L);
        return this.bufferField.readShort();
    }

    @Override // Mb.InterfaceC0968f
    public boolean request(long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        while (this.bufferField.getSize() < byteCount) {
            if (this.source.u0(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // Mb.InterfaceC0968f
    public void skip(long byteCount) {
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        while (byteCount > 0) {
            if (this.bufferField.getSize() == 0 && this.source.u0(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(byteCount, this.bufferField.getSize());
            this.bufferField.skip(jMin);
            byteCount -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // Mb.InterfaceC0968f
    public C0966d u() {
        return this.bufferField;
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        if (this.bufferField.getSize() == 0) {
            if (byteCount == 0) {
                return 0L;
            }
            if (this.source.u0(this.bufferField, 8192L) == -1) {
                return -1L;
            }
        }
        return this.bufferField.u0(sink, Math.min(byteCount, this.bufferField.getSize()));
    }

    @Override // Mb.InterfaceC0968f
    public String x0(long byteCount) {
        j(byteCount);
        return this.bufferField.x0(byteCount);
    }

    @Override // Mb.InterfaceC0968f
    public ByteString z0(long byteCount) {
        j(byteCount);
        return this.bufferField.z0(byteCount);
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Mb/D$a", "Ljava/io/InputStream;", "", "read", "()I", "", "data", "offset", "byteCount", "([BII)I", "available", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/io/OutputStream;", "out", "", "transferTo", "(Ljava/io/OutputStream;)J", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.D$a */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            buffer bufferVar = buffer.this;
            if (bufferVar.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            return (int) Math.min(bufferVar.bufferField.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            buffer.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            buffer bufferVar = buffer.this;
            if (bufferVar.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            if (bufferVar.bufferField.getSize() == 0) {
                buffer bufferVar2 = buffer.this;
                if (bufferVar2.source.u0(bufferVar2.bufferField, 8192L) == -1) {
                    return -1;
                }
            }
            return buffer.this.bufferField.readByte() & 255;
        }

        public String toString() {
            return buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public long transferTo(OutputStream out) throws IOException {
            kotlin.jvm.internal.p.i(out, "out");
            if (buffer.this.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            long size = 0;
            while (true) {
                if (buffer.this.bufferField.getSize() == 0) {
                    buffer bufferVar = buffer.this;
                    if (bufferVar.source.u0(bufferVar.bufferField, 8192L) == -1) {
                        return size;
                    }
                }
                size += buffer.this.bufferField.getSize();
                C0966d.z1(buffer.this.bufferField, out, 0L, 2, null);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int offset, int byteCount) throws IOException {
            kotlin.jvm.internal.p.i(data, "data");
            if (!buffer.this.closed) {
                C0963a.b(data.length, offset, byteCount);
                if (buffer.this.bufferField.getSize() == 0) {
                    buffer bufferVar = buffer.this;
                    if (bufferVar.source.u0(bufferVar.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return buffer.this.bufferField.read(data, offset, byteCount);
            }
            throw new IOException(AlipayXuiIsland.REASON_CLOSED);
        }
    }
}
