package fg;

import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.channels.Channel;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements BufferedSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Buffer f19711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Source f19713c;

    public static final class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f19714a;

        public a(o r10) {
            this.f19714a = r10;
        }

        @Override // java.io.InputStream
        public int available() {
            o r10 = this.f19714a;
            if (r10.f19712b == true) goto L7;
            return (int) Math.min(r10.f19711a.size(), Channel.UNLIMITED);
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f19714a.close();
        }

        @Override // java.io.InputStream
        public int read() {
            o r10 = this.f19714a;
            if (r10.f19712b == true) goto L13;
            if (r10.f19711a.size() != 0) goto L11;
            o r11 = this.f19714a;
            if (r11.f19713c.read(r11.f19711a, 8192) != (-1)) goto L11;
            return -1;
        L11:
            return this.f19714a.f19711a.readByte() & UnsignedBytes.MAX_VALUE;
        L13:
            throw new IOException("closed");
        }

        public String toString() {
            return this.f19714a + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] r10, int r11, int r12) {
            kotlin.jvm.internal.q.h(r10, "data");
            if (this.f19714a.f19712b == true) goto L13;
            c.b(r10.length, r11, r12);
            if (this.f19714a.f19711a.size() != 0) goto L11;
            o r13 = this.f19714a;
            if (r13.f19713c.read(r13.f19711a, 8192) != (-1)) goto L11;
            return -1;
        L11:
            return this.f19714a.f19711a.read(r10, r11, r12);
        L13:
            throw new IOException("closed");
        }
    }

    public o(Source r10) {
        kotlin.jvm.internal.q.h(r10, "source");
        this.f19713c = r10;
        this.f19711a = new Buffer();
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this.f19711a;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19712b == false) goto L5;
        return;
    L5:
        this.f19712b = true;
        this.f19713c.close();
        this.f19711a.a();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.f19712b == true) goto L12;
        if (this.f19711a.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this.f19711a;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10) {
        return indexOf(r10, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r10) {
        kotlin.jvm.internal.q.h(r10, "targetBytes");
        return indexOfElement(r10, 0);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new a(this);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f19712b;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return j.d(new m(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r10, ByteString r11) {
        kotlin.jvm.internal.q.h(r11, DownloadInfoColumns.COLUMN_BYTES);
        return rangeEquals(r10, r11, 0, r11.size());
    }

    @Override // okio.Source
    public long read(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "sink");
        if (r11 < 0) goto L16;
        if (this.f19712b == true) goto L14;
        if (this.f19711a.size() != 0) goto L12;
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L12;
        return -1;
    L12:
        return this.f19711a.read(r10, Math.min(r11, this.f19711a.size()));
    L14:
        throw new IllegalStateException("closed");
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r10) {
        kotlin.jvm.internal.q.h(r10, "sink");
        long r11 = 0;
    L4:
        if (this.f19713c.read(this.f19711a, 8192) == (-1)) goto L9;
        long r12 = this.f19711a.c();
        if (r12 <= 0) goto L4;
        r11 = r11 + r12;
        r10.write(this.f19711a, r12);
        goto L4
    L9:
        if (this.f19711a.size() <= 0) goto L17;
        long r13 = r11 + this.f19711a.size();
        Buffer r14 = this.f19711a;
        r10.write(r14, r14.size());
        return r13;
    L17:
        return r11;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1);
        return this.f19711a.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r10) {
        require(r10);
        return this.f19711a.readByteArray(r10);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r10) {
        require(r10);
        return this.f19711a.readByteString(r10);
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        require(1);
        long r10 = 0;
    L3:
        long r11 = r10 + 1;
        if (request(r11) == false) goto L20;
        byte r12 = this.f19711a.g(r10);
        if (r12 < ((byte) 48)) goto L10;
        if (r12 > ((byte) 57)) goto L10;
    L14:
        r10 = r11;
    L10:
        if (r10 != 0) goto L15;
        if (r12 == ((byte) 45)) goto L14;
    L15:
        if (r10 != 0) goto L20;
        x r13 = x.f21192a;
        String r14 = String.format("Expected leading [0-9] or '-' character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(r12)}, 1));
        kotlin.jvm.internal.q.c(r14, "java.lang.String.format(format, *args)");
        throw new NumberFormatException(r14);
    L20:
        return this.f19711a.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r10) {
        kotlin.jvm.internal.q.h(r10, "sink");
        require(r10.length);     // Catch: EOFException -> L6
        this.f19711a.readFully(r10);
        return;
    L6:
        e = move-exception;
        int r11 = 0;
    L9:
        if (this.f19711a.size() <= 0) goto L15;
        Buffer r12 = this.f19711a;
        int r13 = r12.read(r10, r11, (int) r12.size());
        if (r13 == (-1)) goto L14;
        r11 = r11 + r13;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        require(1);
        int r10 = 0;
    L3:
        int r11 = r10 + 1;
        if (request(r11) == false) goto L24;
        byte r12 = this.f19711a.g(r10);
        if (r12 < ((byte) 48)) goto L10;
        if (r12 > ((byte) 57)) goto L10;
    L18:
        r10 = r11;
    L10:
        if (r12 < ((byte) 97)) goto L14;
        if (r12 <= ((byte) 102)) goto L18;
    L14:
        if (r12 < ((byte) 65)) goto L19;
        if (r12 <= ((byte) 70)) goto L18;
    L19:
        if (r10 != 0) goto L24;
        x r13 = x.f21192a;
        String r14 = String.format("Expected leading [0-9a-fA-F] character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(r12)}, 1));
        kotlin.jvm.internal.q.c(r14, "java.lang.String.format(format, *args)");
        throw new NumberFormatException(r14);
    L24:
        return this.f19711a.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4);
        return this.f19711a.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4);
        return this.f19711a.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8);
        return this.f19711a.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8);
        return this.f19711a.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2);
        return this.f19711a.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2);
        return this.f19711a.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(long r10, Charset r11) {
        kotlin.jvm.internal.q.h(r11, "charset");
        require(r10);
        return this.f19711a.readString(r10, r11);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r10) {
        require(r10);
        return this.f19711a.readUtf8(r10);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1);
        byte r10 = this.f19711a.g(0);
        if ((r10 & 224) != 192) goto L6;
        require(2);
    L12:
        return this.f19711a.readUtf8CodePoint();
    L6:
        if ((r10 & 240) != 224) goto L9;
        require(3);
        goto L12
    L9:
        if ((r10 & 248) != 240) goto L12;
        require(4);
        goto L12
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long r10 = indexOf((byte) 10);
        if (r10 != (-1)) goto L9;
        if (this.f19711a.size() != 0) goto L10;
        return null;
    L10:
        return readUtf8(this.f19711a.size());
    L9:
        return this.f19711a.j(r10);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long r10) {
        if (r10 < 0) goto L17;
        if (this.f19712b == true) goto L15;
    L7:
        if (this.f19711a.size() >= r10) goto L12;
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L7;
        return false;
    L12:
        return true;
    L15:
        throw new IllegalStateException("closed");
    L17:
        throw new IllegalArgumentException(("byteCount < 0: " + r10).toString());
    }

    @Override // okio.BufferedSource
    public void require(long r10) {
        if (request(r10) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(k r10) {
        kotlin.jvm.internal.q.h(r10, "options");
        if (this.f19712b == true) goto L14;
    L4:
        int r11 = this.f19711a.k(r10, true);
        if (r11 != (-2)) goto L6;
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L4;
        return -1;
    L6:
        if (r11 != (-1)) goto L9;
        return -1;
    L9:
        throw null;
    L14:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public void skip(long r10) {
        if (this.f19712b == true) goto L16;
    L5:
        if (r10 <= 0) goto L14;
        if (this.f19711a.size() != 0) goto L13;
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r11 = Math.min(r10, this.f19711a.size());
        this.f19711a.skip(r11);
        r10 = r10 - r11;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f19713c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f19713c + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11) {
        return indexOf(r10, r11, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "targetBytes");
        if (this.f19712b == true) goto L12;
    L4:
        long r12 = this.f19711a.indexOfElement(r10, r11);
        if (r12 != (-1)) goto L6;
        long r13 = this.f19711a.size();
        if (this.f19713c.read(this.f19711a, 8192) == (-1)) goto L9;
        r11 = Math.max(r11, r13);
        goto L4
    L9:
        return -1;
    L6:
        return r12;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r14) {
        if (r14 < 0) goto L27;
        if (r14 != Long.MAX_VALUE) goto L7;
        long r10 = Long.MAX_VALUE;
    L8:
        byte r11 = (byte) 10;
        long r12 = indexOf(r11, 0, r10);
        if (r12 == (-1)) goto L13;
        return this.f19711a.j(r12);
    L13:
        if (r10 < Long.MAX_VALUE) goto L15;
    L24:
        Buffer r13 = new Buffer();
        Buffer r15 = this.f19711a;
        r15.d(r13, 0, Math.min(32, r15.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f19711a.size(), r14) + " content=" + r13.readByteString().hex() + "…");
    L15:
        if (request(r10) == false) goto L24;
        if (this.f19711a.g(r10 - 1) != ((byte) 13)) goto L24;
        if (request(1 + r10) == false) goto L24;
        if (this.f19711a.g(r10) != r11) goto L24;
        return this.f19711a.j(r10);
    L7:
        r10 = r14 + 1;
        goto L8
    L27:
        throw new IllegalArgumentException(("limit < 0: " + r14).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11, long r13) {
        if (this.f19712b == true) goto L23;
        if (0 > r11) goto L21;
        if (r13 < r11) goto L21;
    L9:
        if (r11 >= r13) goto L19;
        long r12 = this.f19711a.indexOf(r10, r11, r13);
        if (r12 != (-1)) goto L12;
        long r14 = this.f19711a.size();
        if (r14 >= r13) goto L19;
        if (this.f19713c.read(this.f19711a, 8192) == (-1)) goto L19;
        r11 = Math.max(r11, r14);
        goto L9
    L12:
        return r12;
    L19:
        return -1;
    L21:
        throw new IllegalArgumentException(("fromIndex=" + r11 + " toIndex=" + r13).toString());
    L23:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r10, ByteString r11, int r12, int r13) {
        kotlin.jvm.internal.q.h(r11, DownloadInfoColumns.COLUMN_BYTES);
        if (this.f19712b == true) goto L24;
        if (r10 < 0) goto L22;
        if (r12 < 0) goto L22;
        if (r13 < 0) goto L22;
        if ((r11.size() - r12) < r13) goto L22;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L20;
        long r15 = ((long) r14) + r10;
        if (request(1 + r15) == false) goto L15;
        if (this.f19711a.g(r15) != r11.getByte(r12 + r14)) goto L18;
        r14 = r14 + 1;
        goto L12
    L18:
        return false;
    L15:
        return false;
    L20:
        return true;
    L22:
        return false;
    L24:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        this.f19711a.writeAll(this.f19713c);
        return this.f19711a.readByteArray();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        this.f19711a.writeAll(this.f19713c);
        return this.f19711a.readByteString();
    }

    @Override // okio.BufferedSource
    public String readString(Charset r10) {
        kotlin.jvm.internal.q.h(r10, "charset");
        this.f19711a.writeAll(this.f19713c);
        return this.f19711a.readString(r10);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        this.f19711a.writeAll(this.f19713c);
        return this.f19711a.readUtf8();
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "sink");
        require(r11);     // Catch: EOFException -> L6
        this.f19711a.readFully(r10, r11);
        return;
    L6:
        e = move-exception;
        r10.writeAll(this.f19711a);
        throw e;
    }

    @Override // okio.BufferedSource
    public int read(byte[] r10) {
        kotlin.jvm.internal.q.h(r10, "sink");
        return read(r10, 0, r10.length);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r10) {
        kotlin.jvm.internal.q.h(r10, DownloadInfoColumns.COLUMN_BYTES);
        return indexOf(r10, 0);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r10, int r11, int r12) {
        kotlin.jvm.internal.q.h(r10, "sink");
        long r13 = r12;
        c.b(r10.length, r11, r13);
        if (this.f19711a.size() != 0) goto L9;
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.f19711a.read(r10, r11, (int) Math.min(r13, this.f19711a.size()));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r10, long r11) {
        kotlin.jvm.internal.q.h(r10, DownloadInfoColumns.COLUMN_BYTES);
        if (this.f19712b == true) goto L12;
    L4:
        long r12 = this.f19711a.indexOf(r10, r11);
        if (r12 != (-1)) goto L6;
        long r13 = this.f19711a.size();
        if (this.f19713c.read(this.f19711a, 8192) == (-1)) goto L9;
        r11 = Math.max(r11, (r13 - ((long) r10.size())) + 1);
        goto L4
    L9:
        return -1;
    L6:
        return r12;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r10) {
        kotlin.jvm.internal.q.h(r10, "sink");
        if (this.f19711a.size() != 0) goto L9;
        if (this.f19713c.read(this.f19711a, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.f19711a.read(r10);
    }
}
