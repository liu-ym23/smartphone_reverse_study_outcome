package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.contacts.common.compat.DirectorySdkCompat;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = null;
    static final int REPLACEMENT_CHARACTER = 65533;

    @Nullable
    Segment head;
    long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end;
        public long offset;
        public boolean readWrite;
        private Segment segment;
        public int start;

        public UnsafeCursor() {
            this.offset = -1;
            this.start = -1;
            this.end = -1;
        }

        public final int next() {
            if (this.offset == this.buffer.size) goto L11;
            long r0 = this.offset;
            if (r0 != (-1)) goto L9;
            return seek(0);
        L9:
            return seek(r0 + ((long) (this.end - this.start)));
        L11:
            throw new IllegalStateException();
        }

        public final int seek(long r12) {
            if (r12 < (-1)) goto L38;
            if (r12 > this.buffer.size) goto L38;
            if (r12 != (-1)) goto L8;
        L35:
            this.segment = null;
            this.offset = r12;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return -1;
        L8:
            if (r12 == this.buffer.size) goto L35;
            long r0 = this.buffer.size;
            Segment r2 = this.buffer.head;
            Segment r3 = this.buffer.head;
            Segment r4 = this.segment;
            long r5 = 0;
            if (r4 == null) goto L17;
            long r7 = this.offset - ((long) (this.start - r4.pos));
            if (r7 <= r12) goto L15;
            r3 = this.segment;
            r0 = r7;
            goto L17
        L15:
            r2 = this.segment;
            r5 = r7;
        L17:
            if ((r0 - r12) <= (r12 - r5)) goto L22;
        L19:
            if (r12 < (((long) (r2.limit - r2.pos)) + r5)) goto L26;
            r5 = r5 + ((long) (r2.limit - r2.pos));
            r2 = r2.next;
        L26:
            if (this.readWrite == true) goto L28;
        L33:
            this.segment = r2;
            this.offset = r12;
            this.data = r2.data;
            this.start = r2.pos + ((int) (r12 - r5));
            int r13 = r2.limit;
            this.end = r13;
            return r13 - this.start;
        L28:
            if (r2.shared == false) goto L33;
            Segment r1 = r2.unsharedCopy();
            if (this.buffer.head != r2) goto L32;
            this.buffer.head = r1;
        L32:
            r2 = r2.push(r1);
            r2.prev.pop();
        L22:
            if (r0 <= r12) goto L24;
            r3 = r3.prev;
            r0 = r0 - ((long) (r3.limit - r3.pos));
            goto L22
        L24:
            r5 = r0;
            r2 = r3;
        L38:
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(r12), Long.valueOf(this.buffer.size)}));
        }

        public final long resizeBuffer(long r13) {
            Buffer r0 = this.buffer;
            if (r0 == null) goto L32;
            if (this.readWrite == false) goto L30;
            long r1 = r0.size;
            if (r13 <= r1) goto L9;
            if (r13 <= r1) goto L27;
            long r5 = r13 - r1;
            boolean r7 = true;
        L23:
            if (r5 <= 0) goto L27;
            Segment r8 = this.buffer.writableSegment(1);
            int r9 = (int) Math.min(r5, 8192 - r8.limit);
            r8.limit += r9;
            r5 = r5 - ((long) r9);
            if (r7 == false) goto L23;
            this.segment = r8;
            this.offset = r1;
            this.data = r8.data;
            this.start = r8.limit - r9;
            this.end = r8.limit;
            r7 = false;
        L27:
            this.buffer.size = r13;
            return r1;
        L9:
            if (r13 < 0) goto L19;
            long r6 = r1 - r13;
        L12:
            if (r6 <= 0) goto L17;
            Segment r2 = this.buffer.head.prev;
            long r10 = r2.limit - r2.pos;
            if (r10 > r6) goto L16;
            this.buffer.head = r2.pop();
            SegmentPool.recycle(r2);
            r6 = r6 - r10;
            goto L12
        L16:
            r2.limit = (int) (((long) r2.limit) - r6);
        L17:
            this.segment = null;
            this.offset = r13;
            this.data = null;
            this.start = -1;
            this.end = -1;
            goto L27
        L19:
            throw new IllegalArgumentException("newSize < 0: " + r13);
        L30:
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        L32:
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int r10) {
            if (r10 <= 0) goto L18;
            if (r10 > 8192) goto L16;
            Buffer r1 = this.buffer;
            if (r1 == null) goto L14;
            if (this.readWrite == false) goto L12;
            long r2 = r1.size;
            Segment r11 = this.buffer.writableSegment(r10);
            int r3 = 8192 - r11.limit;
            r11.limit = 8192;
            long r5 = r3;
            this.buffer.size = r2 + r5;
            this.segment = r11;
            this.offset = r2;
            this.data = r11.data;
            this.start = 8192 - r3;
            this.end = 8192;
            return r5;
        L12:
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        L14:
            throw new IllegalStateException("not attached to a buffer");
        L16:
            throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + r10);
        L18:
            throw new IllegalArgumentException("minByteCount <= 0: " + r10);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) goto L7;
            this.buffer = null;
            this.segment = null;
            this.offset = -1;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return;
        L7:
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m2398clone();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emitCompleteSegments() throws IOException {
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1) throws IOException {
        return write(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1) throws IOException {
        return write(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1, int r2, int r3) throws IOException {
        return write(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int r1) throws IOException {
        return writeByte(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long r1) throws IOException {
        return writeDecimalLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r1) throws IOException {
        return writeHexadecimalUnsignedLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int r1) throws IOException {
        return writeInt(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeIntLe(int r1) throws IOException {
        return writeIntLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLong(long r1) throws IOException {
        return writeLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLongLe(long r1) throws IOException {
        return writeLongLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int r1) throws IOException {
        return writeShort(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShortLe(int r1) throws IOException {
        return writeShortLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, int r2, int r3, Charset r4) throws IOException {
        return writeString(r1, r2, r3, r4);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, Charset r2) throws IOException {
        return writeString(r1, r2);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1) throws IOException {
        return writeUtf8(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1, int r2, int r3) throws IOException {
        return writeUtf8(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8CodePoint(int r1) throws IOException {
        return writeUtf8CodePoint(r1);
    }

    static {
        DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    public Buffer() {
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new AnonymousClass1(this);
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r3) throws EOFException {
        if (this.size < r3) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public boolean request(long r3) {
        if (this.size < r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new AnonymousClass2(this);
    }

    public final Buffer copyTo(OutputStream r7) throws IOException {
        return copyTo(r7, 0, this.size);
    }

    public final Buffer copyTo(OutputStream r7, long r8, long r10) throws IOException {
        if (r7 == null) goto L15;
        Util.checkOffsetAndCount(this.size, r8, r10);
        if (r10 != 0) goto L6;
        return this;
    L6:
        Segment r2 = this.head;
    L8:
        if (r8 < (r2.limit - r2.pos)) goto L11;
        r8 = r8 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L11:
        if (r10 <= 0) goto L13;
        int r9 = (int) (((long) r2.pos) + r8);
        int r11 = (int) Math.min(r2.limit - r9, r10);
        r7.write(r2.data, r9, r11);
        r10 = r10 - ((long) r11);
        r2 = r2.next;
        r8 = 0;
        goto L11
    L13:
        return this;
    L15:
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer copyTo(Buffer r7, long r8, long r10) {
        if (r7 == null) goto L19;
        Util.checkOffsetAndCount(this.size, r8, r10);
        if (r10 != 0) goto L6;
        return this;
    L6:
        r7.size += r10;
        Segment r2 = this.head;
    L8:
        if (r8 < (r2.limit - r2.pos)) goto L11;
        r8 = r8 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L11:
        if (r10 <= 0) goto L17;
        Segment r3 = r2.sharedCopy();
        r3.pos = (int) (((long) r3.pos) + r8);
        r3.limit = Math.min(r3.pos + ((int) r10), r3.limit);
        Segment r9 = r7.head;
        if (r9 != null) goto L15;
        r3.prev = r3;
        r3.next = r3;
        r7.head = r3;
    L16:
        r10 = r10 - ((long) (r3.limit - r3.pos));
        r2 = r2.next;
        r8 = 0;
        goto L11
    L15:
        r9.prev.push(r3);
        goto L16
    L17:
        return this;
    L19:
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer writeTo(OutputStream r3) throws IOException {
        return writeTo(r3, this.size);
    }

    public final Buffer writeTo(OutputStream r7, long r8) throws IOException {
        if (r7 == null) goto L11;
        Util.checkOffsetAndCount(this.size, 0, r8);
        Segment r0 = this.head;
    L5:
        if (r8 <= 0) goto L9;
        int r1 = (int) Math.min(r8, r0.limit - r0.pos);
        r7.write(r0.data, r0.pos, r1);
        r0.pos += r1;
        long r4 = r1;
        this.size -= r4;
        r8 = r8 - r4;
        if (r0.pos != r0.limit) goto L5;
        Segment r2 = r0.pop();
        this.head = r2;
        SegmentPool.recycle(r0);
        r0 = r2;
        goto L5
    L9:
        return this;
    L11:
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer readFrom(InputStream r4) throws IOException {
        readFrom(r4, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream r3, long r4) throws IOException {
        if (r4 < 0) goto L7;
        readFrom(r3, r4, false);
        return this;
    L7:
        throw new IllegalArgumentException("byteCount < 0: " + r4);
    }

    private void readFrom(InputStream r5, long r6, boolean r8) throws IOException {
        if (r5 == null) goto L19;
    L4:
        if (r6 > 0) goto L8;
        if (r8 == true) goto L8;
        return;
    L8:
        Segment r0 = writableSegment(1);
        int r1 = r5.read(r0.data, r0.limit, (int) Math.min(r6, 8192 - r0.limit));
        if (r1 == (-1)) goto L11;
        r0.limit += r1;
        long r2 = r1;
        this.size += r2;
        r6 = r6 - r2;
        goto L4
    L11:
        if (r0.pos != r0.limit) goto L13;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L13:
        if (r8 == false) goto L16;
        return;
    L16:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException("in == null");
    }

    public final long completeSegmentByteCount() {
        long r0 = this.size;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        Segment r5 = this.head.prev;
        if (r5.limit < 8192) goto L8;
        return r0;
    L8:
        if (r5.owner == true) goto L10;
        return r0;
    L10:
        return r0 - ((long) (r5.limit - r5.pos));
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (this.size == 0) goto L10;
        Segment r0 = this.head;
        int r1 = r0.pos;
        int r2 = r0.limit;
        int r4 = r1 + 1;
        byte r3 = r0.data[r1];
        this.size--;
        if (r4 != r2) goto L7;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        return r3;
    L7:
        r0.pos = r4;
        goto L8
    L10:
        throw new IllegalStateException("size == 0");
    }

    public final byte getByte(long r7) {
        Util.checkOffsetAndCount(this.size, r7, 1);
        long r0 = this.size;
        if ((r0 - r7) <= r7) goto L10;
        Segment r6 = this.head;
    L5:
        long r1 = r6.limit - r6.pos;
        if (r7 < r1) goto L8;
        r7 = r7 - r1;
        r6 = r6.next;
        goto L5
    L8:
        return r6.data[r6.pos + ((int) r7)];
    L10:
        long r8 = r7 - r0;
        Segment r9 = this.head;
    L11:
        r9 = r9.prev;
        r8 = r8 + ((long) (r9.limit - r9.pos));
        if (r8 < 0) goto L11;
        return r9.data[r9.pos + ((int) r8)];
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (this.size < 2) goto L15;
        Segment r0 = this.head;
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 2) goto L7;
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 8) | (r5[r6] & 255);
        this.size -= 2;
        if (r7 != r4) goto L11;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L13:
        return (short) r2;
    L11:
        r0.pos = r7;
        goto L13
    L7:
        return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
    L15:
        throw new IllegalStateException("size < 2: " + this.size);
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (this.size < 4) goto L14;
        Segment r0 = this.head;
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 4) goto L7;
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 24) | ((r5[r6] & 255) << 16);
        int r8 = r7 + 1;
        int r3 = r2 | ((r5[r7] & 255) << 8);
        int r9 = r8 + 1;
        int r10 = r3 | (r5[r8] & 255);
        this.size -= 4;
        if (r9 != r4) goto L11;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r10;
    L11:
        r0.pos = r9;
        goto L12
    L7:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L14:
        throw new IllegalStateException("size < 4: " + this.size);
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (this.size < 8) goto L14;
        Segment r0 = this.head;
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 8) goto L7;
        byte[] r5 = r0.data;
        int r8 = r1 + 1;
        long r9 = (((long) r5[r1]) & 255) << 56;
        int r2 = r8 + 1;
        int r10 = r2 + 1;
        long r11 = (r9 | ((((long) r5[r8]) & 255) << 48)) | ((((long) r5[r2]) & 255) << 40);
        int r3 = r10 + 1;
        int r6 = r3 + 1;
        long r12 = (r11 | ((((long) r5[r10]) & 255) << 32)) | ((((long) r5[r3]) & 255) << 24);
        int r7 = r6 + 1;
        long r13 = r12 | ((((long) r5[r6]) & 255) << 16);
        int r14 = r7 + 1;
        long r15 = r13 | ((((long) r5[r7]) & 255) << 8);
        int r16 = r14 + 1;
        long r17 = (((long) r5[r14]) & 255) | r15;
        this.size -= 8;
        if (r16 != r4) goto L11;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r17;
    L11:
        r0.pos = r16;
        goto L12
    L7:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L14:
        throw new IllegalStateException("size < 8: " + this.size);
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        if (this.size == 0) goto L44;
        int r0 = 0;
        boolean r1 = false;
        long r5 = -7;
        long r3 = 0;
        boolean r2 = false;
    L5:
        Segment r7 = this.head;
        byte[] r8 = r7.data;
        int r9 = r7.pos;
        int r10 = r7.limit;
    L6:
        if (r9 >= r10) goto L32;
        byte r11 = r8[r9];
        if (r11 < 48) goto L24;
        if (r11 > 57) goto L24;
        int r12 = 48 - r11;
        if (r3 < (-922337203685477580L)) goto L18;
        if (r3 == (-922337203685477580L)) goto L15;
    L17:
        r3 = (r3 * 10) + ((long) r12);
    L27:
        r9 = r9 + 1;
        r0 = r0 + 1;
        goto L6
    L15:
        if (r12 >= r5) goto L17;
    L18:
        Buffer r15 = new Buffer().writeDecimalLong(r3).writeByte(r11);
        if (r1 == true) goto L22;
        r15.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r15.readUtf8());
    L24:
        if (r11 != 45) goto L28;
        if (r0 != 0) goto L28;
        r5 = r5 - 1;
        r1 = true;
    L28:
        if (r0 == 0) goto L31;
        r2 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(r11));
    L32:
        if (r9 != r10) goto L34;
        this.head = r7.pop();
        SegmentPool.recycle(r7);
    L35:
        if (r2 == true) goto L38;
        if (this.head != null) goto L5;
    L38:
        this.size -= (long) r0;
        if (r1 == false) goto L42;
        return r3;
    L42:
        return -r3;
    L34:
        r7.pos = r9;
        goto L35
    L44:
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        if (this.size == 0) goto L41;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        Segment r6 = this.head;
        byte[] r7 = r6.data;
        int r8 = r6.pos;
        int r9 = r6.limit;
    L6:
        if (r8 >= r9) goto L32;
        byte r10 = r7[r8];
        if (r10 < 48) goto L13;
        if (r10 > 57) goto L13;
        int r11 = r10 - 48;
    L24:
        if (((-1152921504606846976L) & r4) != 0) goto L27;
        r4 = (r4 << 4) | ((long) r11);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r4).writeByte(r10).readUtf8());
    L13:
        if (r10 < 97) goto L19;
        if (r10 > 102) goto L19;
        int r12 = r10 - 97;
    L17:
        r11 = r12 + 10;
    L19:
        if (r10 < 65) goto L28;
        if (r10 > 70) goto L28;
        r12 = r10 - 65;
    L28:
        if (r0 == 0) goto L31;
        r1 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(r10));
    L32:
        if (r8 != r9) goto L34;
        this.head = r6.pop();
        SegmentPool.recycle(r6);
    L35:
        if (r1 == true) goto L38;
        if (this.head != null) goto L5;
    L38:
        this.size -= (long) r0;
        return r4;
    L34:
        r6.pos = r8;
        goto L35
    L41:
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r2) throws EOFException {
        return new ByteString(readByteArray(r2));
    }

    @Override // okio.BufferedSource
    public int select(Options r4) {
        int r0 = selectPrefix(r4, false);
        if (r0 != (-1)) goto L10;
        return -1;
    L10:
        skip(r4.byteStrings[r0].size());     // Catch: EOFException -> L8
        return r0;
    L9:
        throw new AssertionError();
    }

    int selectPrefix(Options r18, boolean r19) {
        Segment r1 = this.head;
        if (r1 != null) goto L8;
        if (r19 == false) goto L7;
        return -2;
    L7:
        return r18.indexOf(ByteString.EMPTY);
    L8:
        byte[] r3 = r1.data;
        int r4 = r1.pos;
        int r5 = r1.limit;
        int[] r0 = r18.trie;
        Segment r9 = r1;
        int r8 = 0;
        int r10 = -1;
    L9:
        int r11 = r8 + 1;
        int r12 = r0[r8];
        int r13 = r11 + 1;
        int r14 = r0[r11];
        if (r14 == (-1)) goto L12;
        r10 = r14;
    L12:
        if (r9 == null) goto L27;
        if (r12 >= 0) goto L36;
        int r15 = r13 + (r12 * (-1));
    L17:
        int r16 = r4 + 1;
        int r17 = r13 + 1;
        if ((r3[r4] & 255) != r0[r13]) goto L19;
        if (r17 != r15) goto L22;
        boolean r6 = true;
    L23:
        if (r16 != r5) goto L32;
        Segment r7 = r9.next;
        int r20 = r7.pos;
        byte[] r21 = r7.data;
        int r22 = r7.limit;
        if (r7 != r1) goto L31;
        if (r6 == false) goto L27;
        r3 = r21;
        Segment r23 = null;
    L33:
        if (r6 == true) goto L34;
        r4 = r20;
        r5 = r22;
        r13 = r17;
        r9 = r23;
        goto L17
    L34:
        int r24 = r0[r17];
        int r110 = r20;
        r5 = r22;
        r9 = r23;
    L46:
        if (r24 >= 0) goto L47;
        r8 = -r24;
        r4 = r110;
        goto L9
    L47:
        return r24;
    L31:
        r23 = r7;
        r3 = r21;
        goto L33
    L32:
        Segment r111 = r9;
        r22 = r5;
        r20 = r16;
        r23 = r111;
        goto L33
    L22:
        r6 = false;
        goto L23
    L19:
        return r10;
    L36:
        r110 = r4 + 1;
        int r25 = r3[r4] & 255;
        int r112 = r13 + r12;
    L37:
        if (r13 == r112) goto L38;
        if (r25 == r0[r13]) goto L41;
        r13 = r13 + 1;
        goto L37
    L41:
        r24 = r0[r13 + r12];
        if (r110 != r5) goto L46;
        r9 = r9.next;
        int r26 = r9.pos;
        r110 = r26;
        r3 = r9.data;
        r5 = r9.limit;
        if (r9 != r1) goto L46;
        r9 = null;
        goto L46
    L38:
        return r10;
    L27:
        if (r19 == false) goto L29;
        return -2;
    L29:
        return r10;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r4, long r5) throws EOFException {
        long r0 = this.size;
        if (r0 < r5) goto L6;
        r4.write(this, r5);
        return;
    L6:
        r4.write(this, r0);
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r5) throws IOException {
        long r0 = this.size;
        if (r0 <= 0) goto L5;
        r5.write(this, r0);
    L5:
        return r0;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Util.UTF_8);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r2) throws EOFException {
        return readString(r2, Util.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) {
        return readString(this.size, r3);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okio.BufferedSource
    public String readString(long r7, Charset r9) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, r7);
        if (r9 == null) goto L21;
        if (r7 > 2147483647L) goto L19;
        if (r7 != 0) goto L10;
        return "";
    L10:
        Segment r0 = this.head;
        if ((((long) r0.pos) + r7) > r0.limit) goto L13;
        String r1 = new String(r0.data, r0.pos, (int) r7, r9);
        r0.pos = (int) (((long) r0.pos) + r7);
        this.size -= r7;
        if (r0.pos != r0.limit) goto L17;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L17:
        return r1;
    L13:
        return new String(readByteArray(r7), r9);
    L19:
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + r7);
    L21:
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L10;
        long r1 = this.size;
        if (r1 != 0) goto L11;
        return null;
    L11:
        return readUtf8(r1);
    L10:
        return readUtf8Line(r0);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r12) throws EOFException {
        if (r12 < 0) goto L23;
        long r0 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L8;
        r0 = r12 + 1;
    L8:
        long r5 = indexOf((byte) 10, 0, r0);
        if (r5 == (-1)) goto L13;
        return readUtf8Line(r5);
    L13:
        if (r0 < size()) goto L15;
    L20:
        Buffer r6 = new Buffer();
        copyTo(r6, 0, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), r12) + " content=" + r6.readByteString().hex() + 8230);
    L15:
        if (getByte(r0 - 1) != 13) goto L20;
        if (getByte(r0) != 10) goto L20;
        return readUtf8Line(r0);
    L23:
        throw new IllegalArgumentException("limit < 0: " + r12);
    }

    String readUtf8Line(long r7) throws EOFException {
        if (r7 <= 0) goto L8;
        long r3 = r7 - 1;
        if (getByte(r3) != 13) goto L8;
        String r8 = readUtf8(r3);
        skip(2);
        return r8;
    L8:
        String r9 = readUtf8(r7);
        skip(1);
        return r9;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        if (this.size == 0) goto L40;
        byte r0 = getByte(0);
        int r2 = 1;
        if ((r0 & 128) != 0) goto L8;
        int r1 = r0 & 127;
        int r6 = 0;
        int r5 = 1;
    L16:
        long r9 = r5;
        if (this.size < r9) goto L36;
    L18:
        if (r2 >= r5) goto L24;
        long r7 = r2;
        byte r3 = getByte(r7);
        if ((r3 & 192) != 128) goto L22;
        r1 = (r1 << 6) | (r3 & 63);
        r2 = r2 + 1;
        goto L18
    L22:
        skip(r7);
        return REPLACEMENT_CHARACTER;
    L24:
        skip(r9);
        if (r1 <= 1114111) goto L28;
        return REPLACEMENT_CHARACTER;
    L28:
        if (r1 >= 55296) goto L30;
    L32:
        if (r1 >= r6) goto L34;
        return REPLACEMENT_CHARACTER;
    L34:
        return r1;
    L30:
        if (r1 > 57343) goto L32;
        return REPLACEMENT_CHARACTER;
    L36:
        throw new EOFException("size < " + r5 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(r0) + ")");
    L8:
        if ((r0 & 224) != 192) goto L11;
        r1 = r0 & Ascii.US;
        r5 = 2;
        r6 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r1 = r0 & Ascii.SI;
        r5 = 3;
        r6 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L37;
        r1 = r0 & 7;
        r5 = 4;
        r6 = 65536;
        goto L16
    L37:
        skip(1);
        return REPLACEMENT_CHARACTER;
    L40:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(this.size);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r7) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, r7);
        if (r7 > 2147483647L) goto L7;
        byte[] r8 = new byte[(int) r7];
        readFully(r8);
        return r8;
    L7:
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + r7);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r4) throws EOFException {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int read(byte[] r8, int r9, int r10) {
        Util.checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = this.head;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r11 = Math.min(r10, r0.limit - r0.pos);
        System.arraycopy(r0.data, r0.pos, r8, r9, r11);
        r0.pos += r11;
        this.size -= (long) r11;
        if (r0.pos != r0.limit) goto L9;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L9:
        return r11;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r7) throws IOException {
        Segment r0 = this.head;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = Math.min(r7.remaining(), r0.limit - r0.pos);
        r7.put(r0.data, r0.pos, r1);
        r0.pos += r1;
        this.size -= (long) r1;
        if (r0.pos != r0.limit) goto L9;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L9:
        return r1;
    }

    public final void clear() {
        skip(this.size);     // Catch: EOFException -> L4
        return;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okio.BufferedSource
    public void skip(long r6) throws EOFException {
    L3:
        if (r6 <= 0) goto L11;
        Segment r0 = this.head;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r6, r0.limit - this.head.pos);
        long r3 = r1;
        this.size -= r3;
        r6 = r6 - r3;
        this.head.pos += r1;
        if (this.head.pos != this.head.limit) goto L3;
        Segment r2 = this.head;
        this.head = r2.pop();
        SegmentPool.recycle(r2);
        goto L3
    L10:
        throw new EOFException();
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r1) {
        if (r1 == null) goto L6;
        r1.write(this);
        return this;
    L6:
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r3) {
        return writeUtf8(r3, 0, r3.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r8, int r9, int r10) {
        if (r8 == null) goto L47;
        if (r9 < 0) goto L45;
        if (r10 < r9) goto L43;
        if (r10 > r8.length()) goto L41;
    L7:
        if (r9 >= r10) goto L39;
        char r0 = r8.charAt(r9);
        if (r0 < 128) goto L10;
        if (r0 < 2048) goto L19;
        if (r0 < 55296) goto L38;
        if (r0 > 57343) goto L38;
        int r4 = r9 + 1;
        if (r4 >= r10) goto L29;
        char r5 = r8.charAt(r4);
    L31:
        if (r0 > 56319) goto L37;
        if (r5 < 56320) goto L37;
        if (r5 > 57343) goto L37;
        int r1 = (((r0 & 10239) << 10) | (9215 & r5)) + 65536;
        writeByte((r1 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        writeByte(((r1 >> 12) & 63) | 128);
        writeByte(((r1 >> 6) & 63) | 128);
        writeByte((r1 & 63) | 128);
        r9 = r9 + 2;
    L37:
        writeByte(63);
        r9 = r4;
        goto L7
    L29:
        r5 = 0;
    L38:
        writeByte((r0 >> '\f') | 224);
        writeByte(((r0 >> 6) & 63) | 128);
        writeByte((r0 & '?') | 128);
    L20:
        r9 = r9 + 1;
        goto L7
    L19:
        writeByte((r0 >> 6) | 192);
        writeByte((r0 & '?') | 128);
        goto L20
    L10:
        Segment r2 = writableSegment(1);
        byte[] r3 = r2.data;
        int r6 = r2.limit - r9;
        int r7 = Math.min(r10, 8192 - r6);
        int r11 = r9 + 1;
        r3[r9 + r6] = (byte) r0;
    L11:
        if (r11 >= r7) goto L16;
        char r12 = r8.charAt(r11);
        if (r12 >= 128) goto L16;
        r3[r11 + r6] = (byte) r12;
        r11 = r11 + 1;
    L16:
        int r13 = (r6 + r11) - r2.limit;
        r2.limit += r13;
        this.size += (long) r13;
        r9 = r11;
        goto L7
    L39:
        return this;
    L41:
        throw new IllegalArgumentException("endIndex > string.length: " + r10 + " > " + r8.length());
    L43:
        throw new IllegalArgumentException("endIndex < beginIndex: " + r10 + " < " + r9);
    L45:
        throw new IllegalArgumentException("beginIndex < 0: " + r9);
    L47:
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int r4) {
        if (r4 >= 128) goto L6;
        writeByte(r4);
    L19:
        return this;
    L6:
        if (r4 >= 2048) goto L9;
        writeByte((r4 >> 6) | 192);
        writeByte((r4 & 63) | 128);
        goto L19
    L9:
        if (r4 >= 65536) goto L17;
        if (r4 >= 55296) goto L13;
    L15:
        writeByte((r4 >> 12) | 224);
        writeByte(((r4 >> 6) & 63) | 128);
        writeByte((r4 & 63) | 128);
        goto L19
    L13:
        if (r4 > 57343) goto L15;
        writeByte(63);
        goto L19
    L17:
        if (r4 > 1114111) goto L21;
        writeByte((r4 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        writeByte(((r4 >> 12) & 63) | 128);
        writeByte(((r4 >> 6) & 63) | 128);
        writeByte((r4 & 63) | 128);
        goto L19
    L21:
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(r4));
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r3, Charset r4) {
        return writeString(r3, 0, r3.length(), r4);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r2, int r3, int r4, Charset r5) {
        if (r2 == null) goto L23;
        if (r3 < 0) goto L21;
        if (r4 < r3) goto L19;
        if (r4 > r2.length()) goto L17;
        if (r5 == null) goto L15;
        if (r5.equals(Util.UTF_8) == true) goto L11;
        byte[] r6 = r2.substring(r3, r4).getBytes(r5);
        return write(r6, 0, r6.length);
    L11:
        return writeUtf8(r2, r3, r4);
    L15:
        throw new IllegalArgumentException("charset == null");
    L17:
        throw new IllegalArgumentException("endIndex > string.length: " + r4 + " > " + r2.length());
    L19:
        throw new IllegalArgumentException("endIndex < beginIndex: " + r4 + " < " + r3);
    L21:
        throw new IllegalAccessError("beginIndex < 0: " + r3);
    L23:
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r3) {
        if (r3 == null) goto L6;
        return write(r3, 0, r3.length);
    L6:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r10, int r11, int r12) {
        if (r10 == null) goto L9;
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        int r13 = r12 + r11;
    L4:
        if (r11 >= r13) goto L6;
        Segment r0 = writableSegment(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.limit);
        System.arraycopy(r10, r11, r0.data, r0.limit, r1);
        r11 = r11 + r1;
        r0.limit += r1;
        goto L4
    L6:
        this.size += r7;
        return this;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r7) throws IOException {
        if (r7 == null) goto L9;
        int r0 = r7.remaining();
        int r1 = r0;
    L4:
        if (r1 <= 0) goto L6;
        Segment r2 = writableSegment(1);
        int r3 = Math.min(r1, 8192 - r2.limit);
        r7.get(r2.data, r2.limit, r3);
        r1 = r1 - r3;
        r2.limit += r3;
        goto L4
    L6:
        this.size += (long) r0;
        return r0;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r7) throws IOException {
        if (r7 == null) goto L9;
        long r0 = 0;
    L4:
        long r2 = r7.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r2 == (-1)) goto L7;
        r0 = r0 + r2;
        goto L4
    L7:
        return r0;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source r5, long r6) throws IOException {
    L3:
        if (r6 <= 0) goto L9;
        long r0 = r5.read(this, r6);
        if (r0 == (-1)) goto L8;
        r6 = r6 - r0;
        goto L3
    L8:
        throw new EOFException();
    L9:
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int r5) {
        Segment r0 = writableSegment(1);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        r0.limit = r2 + 1;
        r1[r2] = (byte) r5;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int r6) {
        Segment r0 = writableSegment(2);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & 255);
        r1[r3] = (byte) (r6 & 255);
        r0.limit = r3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int r1) {
        return writeShort(Util.reverseBytesShort((short) r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int r6) {
        Segment r0 = writableSegment(4);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & 255);
        int r5 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & 255);
        r1[r5] = (byte) (r6 & 255);
        r0.limit = r5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int r1) {
        return writeInt(Util.reverseBytesInt(r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long r10) {
        Segment r1 = writableSegment(8);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r9 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r11 = r9 + 1;
        r2[r9] = (byte) ((r10 >>> 8) & 255);
        r2[r11] = (byte) (r10 & 255);
        r1.limit = r11 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long r1) {
        return writeLong(Util.reverseBytesLong(r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long r12) {
        if (r12 == 0) goto L5;
        int r3 = 1;
        if (r12 >= 0) goto L13;
        r12 = -r12;
        if (r12 < 0) goto L11;
        boolean r2 = true;
    L15:
        if (r12 >= 100000000) goto L39;
        if (r12 >= 10000) goto L29;
        if (r12 >= 100) goto L25;
        if (r12 < 10) goto L69;
        r3 = 2;
    L69:
        if (r2 == false) goto L71;
        r3 = r3 + 1;
    L71:
        Segment r4 = writableSegment(r3);
        byte[] r7 = r4.data;
        int r8 = r4.limit + r3;
    L73:
        if (r12 == 0) goto L75;
        r8 = r8 - 1;
        r7[r8] = DIGITS[(int) (r12 % 10)];
        r12 = r12 / 10;
        goto L73
    L75:
        if (r2 == false) goto L77;
        r7[r8 - 1] = 45;
    L77:
        r4.limit += r3;
        this.size += (long) r3;
        return this;
    L25:
        if (r12 >= 1000) goto L27;
        r3 = 3;
        goto L69
    L27:
        r3 = 4;
        goto L69
    L29:
        if (r12 >= 1000000) goto L35;
        if (r12 >= 100000) goto L33;
        r3 = 5;
        goto L69
    L33:
        r3 = 6;
        goto L69
    L35:
        if (r12 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L37;
        r3 = 7;
        goto L69
    L37:
        r3 = 8;
        goto L69
    L39:
        if (r12 >= 1000000000000L) goto L51;
        if (r12 >= 10000000000L) goto L47;
        if (r12 >= DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT) goto L45;
        r3 = 9;
        goto L69
    L45:
        r3 = 10;
        goto L69
    L47:
        if (r12 >= 100000000000L) goto L49;
        r3 = 11;
        goto L69
    L49:
        r3 = 12;
        goto L69
    L51:
        if (r12 >= 1000000000000000L) goto L60;
        if (r12 >= 10000000000000L) goto L56;
        r3 = 13;
        goto L69
    L56:
        if (r12 >= 100000000000000L) goto L58;
        r3 = 14;
        goto L69
    L58:
        r3 = 15;
        goto L69
    L60:
        if (r12 >= 100000000000000000L) goto L66;
        if (r12 >= 10000000000000000L) goto L64;
        r3 = 16;
        goto L69
    L64:
        r3 = 17;
        goto L69
    L66:
        if (r12 >= 1000000000000000000L) goto L68;
        r3 = 18;
        goto L69
    L68:
        r3 = 19;
        goto L69
    L11:
        return writeUtf8("-9223372036854775808");
    L13:
        r2 = false;
        goto L15
    L5:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long r10) {
        if (r10 == 0) goto L5;
        int r0 = (Long.numberOfTrailingZeros(Long.highestOneBit(r10)) / 4) + 1;
        Segment r2 = writableSegment(r0);
        byte[] r3 = r2.data;
        int r4 = (r2.limit + r0) - 1;
        int r5 = r2.limit;
    L7:
        if (r4 < r5) goto L9;
        r3[r4] = DIGITS[(int) (15 & r10)];
        r10 = r10 >>> 4;
        r4 = r4 - 1;
        goto L7
    L9:
        r2.limit += r0;
        this.size += (long) r0;
        return this;
    L5:
        return writeByte(48);
    }

    Segment writableSegment(int r3) {
        if (r3 < 1) goto L17;
        if (r3 > 8192) goto L17;
        Segment r1 = this.head;
        if (r1 != null) goto L10;
        Segment r4 = SegmentPool.take();
        this.head = r4;
        r4.prev = r4;
        r4.next = r4;
        return r4;
    L10:
        Segment r2 = r1.prev;
        if ((r2.limit + r3) > 8192) goto L15;
        if (r2.owner == false) goto L15;
        return r2;
    L15:
        return r2.push(SegmentPool.take());
    L17:
        throw new IllegalArgumentException();
    }

    @Override // okio.Sink
    public void write(Buffer r7, long r8) {
        if (r7 == null) goto L34;
        if (r7 == this) goto L32;
        Util.checkOffsetAndCount(r7.size, 0, r8);
    L6:
        if (r8 <= 0) goto L30;
        if (r8 >= (r7.head.limit - r7.head.pos)) goto L25;
        Segment r0 = this.head;
        if (r0 == null) goto L12;
        Segment r1 = r0.prev;
    L13:
        if (r1 != null) goto L15;
    L24:
        r7.head = r7.head.split((int) r8);
        goto L25
    L15:
        if (r1.owner == false) goto L24;
        long r2 = ((long) r1.limit) + r8;
        if (r1.shared == false) goto L19;
        int r3 = 0;
    L21:
        if ((r2 - ((long) r3)) > PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L24;
        r7.head.writeTo(r1, (int) r8);
        r7.size -= r8;
        this.size += r8;
        return;
    L19:
        r3 = r1.pos;
        goto L21
    L12:
        r1 = null;
    L25:
        Segment r4 = r7.head;
        long r5 = r4.limit - r4.pos;
        r7.head = r4.pop();
        Segment r6 = this.head;
        if (r6 != null) goto L28;
        this.head = r4;
        r4.prev = r4;
        r4.next = r4;
    L29:
        r7.size -= r5;
        this.size += r5;
        r8 = r8 - r5;
        goto L6
    L28:
        r6.prev.push(r4).compact();
        goto L29
    L30:
        return;
    L32:
        throw new IllegalArgumentException("source == this");
    L34:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.Source
    public long read(Buffer r5, long r6) {
        if (r5 == null) goto L17;
        if (r6 < 0) goto L15;
        long r2 = this.size;
        if (r2 != 0) goto L10;
        return -1;
    L10:
        if (r6 <= r2) goto L12;
        r6 = r2;
    L12:
        r5.write(this, r6);
        return r6;
    L15:
        throw new IllegalArgumentException("byteCount < 0: " + r6);
    L17:
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r15, long r16, long r18) {
        long r1 = 0;
        if (r16 < 0) goto L38;
        if (r18 < r16) goto L38;
        long r3 = this.size;
        if (r18 <= r3) goto L9;
        long r5 = r3;
    L11:
        if (r16 != r5) goto L13;
        return -1;
    L13:
        Segment r0 = this.head;
        if (r0 != null) goto L17;
        return -1;
    L17:
        if ((r3 - r16) < r16) goto L19;
    L21:
        long r4 = ((long) (r0.limit - r0.pos)) + r1;
        if (r4 >= r16) goto L24;
        r0 = r0.next;
        r1 = r4;
        goto L21
    L24:
        r3 = r1;
    L25:
        Segment r2 = r0;
        long r6 = r16;
    L27:
        if (r3 >= r5) goto L36;
        byte[] r7 = r2.data;
        int r10 = (int) Math.min(r2.limit, (((long) r2.pos) + r5) - r3);
        int r8 = (int) ((((long) r2.pos) + r6) - r3);
    L29:
        if (r8 >= r10) goto L35;
        if (r7[r8] == r15) goto L33;
        r8 = r8 + 1;
        goto L29
    L33:
        return ((long) (r8 - r2.pos)) + r3;
    L35:
        r3 = r3 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        r6 = r3;
        goto L27
    L36:
        return -1;
    L19:
        if (r3 <= r16) goto L25;
        r0 = r0.prev;
        r3 = r3 - ((long) (r0.limit - r0.pos));
        goto L19
    L9:
        r5 = r18;
    L38:
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(r16), Long.valueOf(r18)}));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) throws IOException {
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r19, long r20) throws IOException {
        if (r19.size() == 0) goto L37;
        long r0 = 0;
        if (r20 < 0) goto L35;
        Segment r2 = this.head;
        long r7 = -1;
        if (r2 != null) goto L9;
        return -1;
    L9:
        long r3 = this.size;
        if ((r3 - r20) < r20) goto L12;
    L14:
        long r4 = ((long) (r2.limit - r2.pos)) + r0;
        if (r4 >= r20) goto L17;
        r2 = r2.next;
        r0 = r4;
        goto L14
    L17:
        r3 = r0;
    L18:
        byte r10 = r19.getByte(0);
        int r11 = r19.size();
        long r12 = 1 + (this.size - ((long) r11));
        long r1 = r20;
        Segment r14 = r2;
        long r15 = r3;
    L20:
        if (r15 >= r12) goto L33;
        byte[] r5 = r14.data;
        int r8 = (int) Math.min(r14.limit, (((long) r14.pos) + r12) - r15);
        int r9 = (int) ((((long) r14.pos) + r1) - r15);
    L22:
        if (r9 >= r8) goto L31;
        if (r5[r9] != r10) goto L30;
        if (rangeEquals(r14, r9 + 1, r19, 1, r11) == false) goto L30;
        return ((long) (r9 - r14.pos)) + r15;
    L30:
        r9 = r9 + 1;
        r5 = r5;
        goto L22
    L31:
        r15 = r15 + ((long) (r14.limit - r14.pos));
        r14 = r14.next;
        r1 = r15;
        r7 = -1;
        goto L20
    L33:
        return r7;
    L12:
        if (r3 <= r20) goto L18;
        r2 = r2.prev;
        r3 = r3 - ((long) (r2.limit - r2.pos));
        goto L12
    L35:
        throw new IllegalArgumentException("fromIndex < 0");
    L37:
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) {
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r12, long r13) {
        long r0 = 0;
        if (r13 < 0) goto L47;
        Segment r2 = this.head;
        if (r2 != null) goto L7;
        return -1;
    L7:
        long r5 = this.size;
        if ((r5 - r13) < r13) goto L10;
    L12:
        long r6 = ((long) (r2.limit - r2.pos)) + r0;
        if (r6 >= r13) goto L15;
        r2 = r2.next;
        r0 = r6;
        goto L12
    L15:
        r5 = r0;
    L17:
        if (r12.size() != 2) goto L32;
        byte r1 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L20:
        if (r5 >= this.size) goto L45;
        byte[] r3 = r2.data;
        int r15 = (int) ((((long) r2.pos) + r13) - r5);
        int r16 = r2.limit;
    L22:
        if (r15 >= r16) goto L31;
        byte r7 = r3[r15];
        if (r7 == r1) goto L28;
        if (r7 == r14) goto L28;
        r15 = r15 + 1;
    L28:
        int r11 = r2.pos;
    L30:
        return ((long) (r15 - r11)) + r5;
    L31:
        r5 = r5 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        r13 = r5;
    L45:
        return -1;
    L32:
        byte[] r17 = r12.internalArray();
    L34:
        if (r5 >= this.size) goto L45;
        byte[] r4 = r2.data;
        r15 = (int) ((((long) r2.pos) + r13) - r5);
        int r18 = r2.limit;
    L36:
        if (r15 >= r18) goto L44;
        byte r8 = r4[r15];
        int r9 = r17.length;
        int r10 = 0;
    L38:
        if (r10 >= r9) goto L43;
        if (r8 == r17[r10]) goto L41;
        r10 = r10 + 1;
        goto L38
    L41:
        r11 = r2.pos;
        goto L30
    L43:
        r15 = r15 + 1;
        goto L36
    L44:
        r5 = r5 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        r13 = r5;
    L10:
        if (r5 <= r13) goto L17;
        r2 = r2.prev;
        r5 = r5 - ((long) (r2.limit - r2.pos));
        goto L10
    L47:
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9) {
        return rangeEquals(r7, r9, 0, r9.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9, int r10, int r11) {
        if (r7 < 0) goto L19;
        if (r10 < 0) goto L19;
        if (r11 < 0) goto L19;
        if ((this.size - r7) < r11) goto L19;
        if ((r9.size() - r10) < r11) goto L19;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (getByte(((long) r0) + r7) != r9.getByte(r10 + r0)) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    private boolean rangeEquals(Segment r5, int r6, ByteString r7, int r8, int r9) {
        int r4 = r5.limit;
        byte[] r0 = r5.data;
    L3:
        if (r8 >= r9) goto L11;
        if (r6 != r4) goto L7;
        Segment r10 = r5.next;
        byte[] r11 = r10.data;
        r6 = r10.pos;
        r5 = r10;
        r4 = r10.limit;
        r0 = r11;
    L7:
        if (r0[r6] != r7.getByte(r8)) goto L8;
        r6 = r6 + 1;
        r8 = r8 + 1;
        goto L3
    L8:
        return false;
    L11:
        return true;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    List<Integer> segmentSizes() {
        if (this.head == null) goto L5;
        ArrayList r0 = new ArrayList();
        r0.add(Integer.valueOf(this.head.limit - this.head.pos));
        Segment r1 = this.head;
    L7:
        r1 = r1.next;
        if (r1 == this.head) goto L10;
        r0.add(Integer.valueOf(r1.limit - r1.pos));
        goto L7
    L10:
        return r0;
    L5:
        return Collections.emptyList();
    }

    public final ByteString md5() {
        return digest(StringEncryptUtils.MD5);
    }

    public final ByteString sha1() {
        return digest(StringEncryptUtils.SHA_1);
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String r6) {
        MessageDigest r7 = MessageDigest.getInstance(r6);     // Catch: NoSuchAlgorithmException -> L10
        Segment r0 = this.head;     // Catch: NoSuchAlgorithmException -> L10
        if (r0 == null) goto L8;
        r7.update(r0.data, this.head.pos, this.head.limit - this.head.pos);     // Catch: NoSuchAlgorithmException -> L10
        Segment r1 = this.head;     // Catch: NoSuchAlgorithmException -> L10
    L5:
        r1 = r1.next;     // Catch: NoSuchAlgorithmException -> L10
        if (r1 == this.head) goto L8;
        r7.update(r1.data, r1.pos, r1.limit - r1.pos);     // Catch: NoSuchAlgorithmException -> L10
    L8:
        return ByteString.of(r7.digest());
    L11:
        throw new AssertionError();
    }

    public final ByteString hmacSha1(ByteString r2) {
        return hmac("HmacSHA1", r2);
    }

    public final ByteString hmacSha256(ByteString r2) {
        return hmac("HmacSHA256", r2);
    }

    public final ByteString hmacSha512(ByteString r2) {
        return hmac("HmacSHA512", r2);
    }

    private ByteString hmac(String r5, ByteString r6) {
        Mac r0 = Mac.getInstance(r5);     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
        r0.init(new SecretKeySpec(r6.toByteArray(), r5));     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
        Segment r7 = this.head;     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
        if (r7 == null) goto L8;
        r0.update(r7.data, this.head.pos, this.head.limit - this.head.pos);     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
        Segment r8 = this.head;     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
    L5:
        r8 = r8.next;     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
        if (r8 == this.head) goto L8;
        r0.update(r8.data, r8.pos, r8.limit - r8.pos);     // Catch: InvalidKeyException -> L10 NoSuchAlgorithmException -> L13
    L8:
        return ByteString.of(r0.doFinal());
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L14:
        throw new AssertionError();
    }

    public boolean equals(Object r14) {
        if (this != r14) goto L6;
        return true;
    L6:
        if ((r14 instanceof Buffer) == true) goto L8;
        return false;
    L8:
        Buffer r15 = (Buffer) r14;
        long r3 = this.size;
        if (r3 == r15.size) goto L11;
        return false;
    L11:
        long r5 = 0;
        if (r3 != 0) goto L14;
        return true;
    L14:
        Segment r1 = this.head;
        Segment r16 = r15.head;
        int r4 = r1.pos;
        int r6 = r16.pos;
    L16:
        if (r5 >= this.size) goto L31;
        long r7 = Math.min(r1.limit - r4, r16.limit - r6);
        int r9 = 0;
    L19:
        if (r9 >= r7) goto L25;
        int r11 = r4 + 1;
        int r12 = r6 + 1;
        if (r1.data[r4] != r16.data[r6]) goto L22;
        r9 = r9 + 1;
        r4 = r11;
        r6 = r12;
        goto L19
    L22:
        return false;
    L25:
        if (r4 != r1.limit) goto L28;
        r1 = r1.next;
        r4 = r1.pos;
    L28:
        if (r6 != r16.limit) goto L30;
        r16 = r16.next;
        r6 = r16.pos;
    L30:
        r5 = r5 + r7;
        goto L16
    L31:
        return true;
    }

    public int hashCode() {
        Segment r0 = this.head;
        if (r0 != null) goto L6;
        return 0;
    L6:
        int r1 = 1;
    L7:
        int r2 = r0.pos;
        int r3 = r0.limit;
    L8:
        if (r2 >= r3) goto L10;
        r1 = (r1 * 31) + r0.data[r2];
        r2 = r2 + 1;
        goto L8
    L10:
        r0 = r0.next;
        if (r0 != this.head) goto L7;
        return r1;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Buffer m2398clone() {
        Buffer r0 = new Buffer();
        if (this.size != 0) goto L5;
        return r0;
    L5:
        Segment r1 = this.head.sharedCopy();
        r0.head = r1;
        r1.prev = r1;
        r1.next = r1;
        Segment r2 = this.head;
    L6:
        r2 = r2.next;
        if (r2 == this.head) goto L9;
        r0.head.prev.push(r2.sharedCopy());
        goto L6
    L9:
        r0.size = this.size;
        return r0;
    }

    public final ByteString snapshot() {
        long r0 = this.size;
        if (r0 > 2147483647L) goto L7;
        return snapshot((int) r0);
    L7:
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int r2) {
        if (r2 != 0) goto L6;
        return ByteString.EMPTY;
    L6:
        return new SegmentedByteString(this, r2);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor r2) {
        if (r2.buffer != null) goto L7;
        r2.buffer = this;
        r2.readWrite = false;
        return r2;
    L7:
        throw new IllegalStateException("already attached to a buffer");
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor r2) {
        if (r2.buffer != null) goto L7;
        r2.buffer = this;
        r2.readWrite = true;
        return r2;
    L7:
        throw new IllegalStateException("already attached to a buffer");
    }
}
