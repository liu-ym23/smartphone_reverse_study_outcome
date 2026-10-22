package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J'\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0002\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010#R\u0018\u0010'\u001a\u00060$j\u0002`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u00060,j\u0002`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010.¨\u00060"}, d2 = {"LMb/n;", "LMb/I;", "source", "<init>", "(LMb/I;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "buffer", "offset", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LMb/d;JJ)V", "", "name", "", "expected", "actual", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;II)V", "", Const.INTENT_KEY_APIKEY, "B", "section", "LMb/D;", "LMb/D;", "Ljava/util/zip/Inflater;", "Lokio/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "LMb/o;", Const.INTENT_KEY_UMID, "LMb/o;", "inflaterSource", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "Ljava/util/zip/CRC32;", "crc", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n implements I {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public byte section;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final buffer source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Inflater inflater;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final o inflaterSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final CRC32 crc;

    public n(I source) {
        kotlin.jvm.internal.p.i(source, "source");
        buffer d10 = new buffer(source);
        this.source = d10;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new o((InterfaceC0968f) d10, inflater);
        this.crc = new CRC32();
    }

    public final void b(String name, int expected, int actual) throws IOException {
        if (actual == expected) {
            return;
        }
        throw new IOException(name + ": actual 0x" + La.H.J0(C0963a.g(actual), 8, '0') + " != expected 0x" + La.H.J0(C0963a.g(expected), 8, '0'));
    }

    @Override // Mb.I
    /* renamed from: c */
    public J getTimeout() {
        return this.source.getTimeout();
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void e() throws IOException {
        this.source.j(10L);
        byte bY = this.source.bufferField.Y(3L);
        boolean z10 = ((bY >> 1) & 1) == 1;
        if (z10) {
            i(this.source.bufferField, 0L, 10L);
        }
        b("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((bY >> 2) & 1) == 1) {
            this.source.j(2L);
            if (z10) {
                i(this.source.bufferField, 0L, 2L);
            }
            long jL0 = this.source.bufferField.l0() & 65535;
            this.source.j(jL0);
            if (z10) {
                i(this.source.bufferField, 0L, jL0);
            }
            this.source.skip(jL0);
        }
        if (((bY >> 3) & 1) == 1) {
            long jB = this.source.b((byte) 0);
            if (jB == -1) {
                throw new EOFException();
            }
            if (z10) {
                i(this.source.bufferField, 0L, jB + 1);
            }
            this.source.skip(jB + 1);
        }
        if (((bY >> 4) & 1) == 1) {
            long jB2 = this.source.b((byte) 0);
            if (jB2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                i(this.source.bufferField, 0L, jB2 + 1);
            }
            this.source.skip(jB2 + 1);
        }
        if (z10) {
            b("FHCRC", this.source.l0(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    public final void g() throws IOException {
        b("CRC", this.source.e1(), (int) this.crc.getValue());
        b("ISIZE", this.source.e1(), (int) this.inflater.getBytesWritten());
    }

    public final void i(C0966d buffer, long offset, long byteCount) {
        E e10 = buffer.head;
        kotlin.jvm.internal.p.f(e10);
        while (true) {
            int i10 = e10.limit;
            int i11 = e10.pos;
            if (offset < i10 - i11) {
                break;
            }
            offset -= i10 - i11;
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
        }
        while (byteCount > 0) {
            int iMin = (int) Math.min(e10.limit - r6, byteCount);
            this.crc.update(e10.data, (int) (e10.pos + offset), iMin);
            byteCount -= iMin;
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
            offset = 0;
        }
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) throws IOException {
        n nVar;
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (this.section == 0) {
            e();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.getSize();
            long jU0 = this.inflaterSource.u0(sink, byteCount);
            if (jU0 != -1) {
                i(sink, size, jU0);
                return jU0;
            }
            nVar = this;
            nVar.section = (byte) 2;
        } else {
            nVar = this;
        }
        if (nVar.section == 2) {
            nVar.g();
            nVar.section = (byte) 3;
            if (!nVar.source.k()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
