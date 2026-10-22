package com.google.protobuf;

import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    private static final long ARRAY_BASE_OFFSET = 0;
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final int MAX_VARINT_SIZE = 10;
    private static final Logger logger = null;
    private boolean serializationDeterministic;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int r10) {
            super(null);
            if (r10 < 0) goto L7;
            byte[] r11 = new byte[Math.max(r10, 20)];
            this.buffer = r11;
            this.limit = r11.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void buffer(byte r10) {
            byte[] r11 = this.buffer;
            int r12 = this.position;
            this.position = r12 + 1;
            r11[r12] = r10;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.position;
            int r13 = r12 + 1;
            this.position = r13;
            r11[r12] = (byte) (r10 & PrivateKeyType.INVALID);
            int r14 = r12 + 2;
            this.position = r14;
            r11[r13] = (byte) ((r10 >> 8) & PrivateKeyType.INVALID);
            int r15 = r12 + 3;
            this.position = r15;
            r11[r14] = (byte) ((r10 >> 16) & PrivateKeyType.INVALID);
            this.position = r12 + 4;
            r11[r15] = (byte) ((r10 >> 24) & PrivateKeyType.INVALID);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.position;
            int r13 = r12 + 1;
            this.position = r13;
            r11[r12] = (byte) (r10 & 255);
            int r14 = r12 + 2;
            this.position = r14;
            r11[r13] = (byte) ((r10 >> 8) & 255);
            int r15 = r12 + 3;
            this.position = r15;
            r11[r14] = (byte) ((r10 >> 16) & 255);
            int r16 = r12 + 4;
            this.position = r16;
            r11[r15] = (byte) (255 & (r10 >> 24));
            int r17 = r12 + 5;
            this.position = r17;
            r11[r16] = (byte) (((int) (r10 >> 32)) & PrivateKeyType.INVALID);
            int r18 = r12 + 6;
            this.position = r18;
            r11[r17] = (byte) (((int) (r10 >> 40)) & PrivateKeyType.INVALID);
            int r19 = r12 + 7;
            this.position = r19;
            r11[r18] = (byte) (((int) (r10 >> 48)) & PrivateKeyType.INVALID);
            this.position = r12 + 8;
            r11[r19] = (byte) (((int) (r10 >> 56)) & PrivateKeyType.INVALID);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int r10) {
            if (r10 < 0) goto L4;
            bufferUInt32NoTag(r10);
            return;
        L4:
            bufferUInt64NoTag(r10);
        }

        public final void bufferTag(int r10, int r11) {
            bufferUInt32NoTag(WireFormat.makeTag(r10, r11));
        }

        public final void bufferUInt32NoTag(int r10) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r11 = CodedOutputStream.access$200() + ((long) this.position);
            long r12 = r11;
        L6:
            if ((r10 & (-128)) == 0) goto L7;
            UnsafeUtil.putByte(this.buffer, r12, (byte) ((r10 & 127) | 128));
            r10 = r10 >>> 7;
            r12 = 1 + r12;
            goto L6
        L7:
            UnsafeUtil.putByte(this.buffer, r12, (byte) r10);
            int r13 = (int) ((1 + r12) - r11);
            this.position += r13;
            this.totalBytesWritten += r13;
            return;
        L11:
            if ((r10 & (-128)) == 0) goto L12;
            byte[] r14 = this.buffer;
            int r15 = this.position;
            this.position = r15 + 1;
            r14[r15] = (byte) ((r10 & 127) | 128);
            this.totalBytesWritten++;
            r10 = r10 >>> 7;
            goto L11
        L12:
            byte[] r16 = this.buffer;
            int r17 = this.position;
            this.position = r17 + 1;
            r16[r17] = (byte) r10;
            this.totalBytesWritten++;
        }

        public final void bufferUInt64NoTag(long r14) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r10 = CodedOutputStream.access$200() + ((long) this.position);
            long r11 = r10;
        L6:
            if ((r14 & (-128)) == 0) goto L7;
            UnsafeUtil.putByte(this.buffer, r11, (byte) ((((int) r14) & 127) | 128));
            r14 = r14 >>> 7;
            r11 = 1 + r11;
            goto L6
        L7:
            UnsafeUtil.putByte(this.buffer, r11, (byte) r14);
            int r15 = (int) ((1 + r11) - r10);
            this.position += r15;
            this.totalBytesWritten += r15;
            return;
        L11:
            if ((r14 & (-128)) == 0) goto L12;
            byte[] r12 = this.buffer;
            int r13 = this.position;
            this.position = r13 + 1;
            r12[r13] = (byte) ((((int) r14) & 127) | 128);
            this.totalBytesWritten++;
            r14 = r14 >>> 7;
            goto L11
        L12:
            byte[] r16 = this.buffer;
            int r17 = this.position;
            this.position = r17 + 1;
            r16[r17] = (byte) r14;
            this.totalBytesWritten++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] r10, int r11, int r12) {
            super(null);
            if (r10 == null) goto L11;
            int r13 = r11 + r12;
            if (((r11 | r12) | (r10.length - r13)) < 0) goto L9;
            this.buffer = r10;
            this.offset = r11;
            this.position = r11;
            this.limit = r13;
            return;
        L9:
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r11), Integer.valueOf(r12)}));
        L11:
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte r10) throws IOException {
            byte[] r11 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r12 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r12 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r11[r12] = r10;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int r10, boolean r11) throws IOException {
            writeTag(r10, 0);
            write(r11 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r10, byte[] r11) throws IOException {
            writeByteArray(r10, r11, 0, r11.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] r10, int r11, int r12) throws IOException {
            writeUInt32NoTag(r12);
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int r10, ByteBuffer r11) throws IOException {
            writeTag(r10, 2);
            writeUInt32NoTag(r11.capacity());
            writeRawBytes(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int r10, ByteString r11) throws IOException {
            writeTag(r10, 2);
            writeBytesNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString r10) throws IOException {
            writeUInt32NoTag(r10.size());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int r10, int r11) throws IOException {
            writeTag(r10, 5);
            writeFixed32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int r10) throws IOException {
            byte[] r11 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r12 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            int r13 = r12 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r13;     // Catch: IndexOutOfBoundsException -> L4
            r11[r12] = (byte) (r10 & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r14 = r12 + 2;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r14;     // Catch: IndexOutOfBoundsException -> L4
            r11[r13] = (byte) ((r10 >> 8) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r15 = r12 + 3;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r15;     // Catch: IndexOutOfBoundsException -> L4
            r11[r14] = (byte) ((r10 >> 16) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            this.position = r12 + 4;     // Catch: IndexOutOfBoundsException -> L4
            r11[r15] = (byte) ((r10 >> 24) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int r10, long r11) throws IOException {
            writeTag(r10, 1);
            writeFixed64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long r10) throws IOException {
            byte[] r11 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r12 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            int r13 = r12 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r13;     // Catch: IndexOutOfBoundsException -> L4
            r11[r12] = (byte) (((int) r10) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r14 = r12 + 2;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r14;     // Catch: IndexOutOfBoundsException -> L4
            r11[r13] = (byte) (((int) (r10 >> 8)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r15 = r12 + 3;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r15;     // Catch: IndexOutOfBoundsException -> L4
            r11[r14] = (byte) (((int) (r10 >> 16)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r16 = r12 + 4;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r16;     // Catch: IndexOutOfBoundsException -> L4
            r11[r15] = (byte) (((int) (r10 >> 24)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r17 = r12 + 5;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r17;     // Catch: IndexOutOfBoundsException -> L4
            r11[r16] = (byte) (((int) (r10 >> 32)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r18 = r12 + 6;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r18;     // Catch: IndexOutOfBoundsException -> L4
            r11[r17] = (byte) (((int) (r10 >> 40)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            int r19 = r12 + 7;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r19;     // Catch: IndexOutOfBoundsException -> L4
            r11[r18] = (byte) (((int) (r10 >> 48)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            this.position = r12 + 8;     // Catch: IndexOutOfBoundsException -> L4
            r11[r19] = (byte) (((int) (r10 >> 56)) & PrivateKeyType.INVALID);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int r10, int r11) throws IOException {
            writeTag(r10, 0);
            writeInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int r10) throws IOException {
            if (r10 < 0) goto L4;
            writeUInt32NoTag(r10);
            return;
        L4:
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] r10, int r11, int r12) throws IOException {
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int r10, MessageLite r11) throws IOException {
            writeTag(r10, 2);
            writeMessageNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite r10) throws IOException {
            writeUInt32NoTag(r10.getSerializedSize());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int r10, MessageLite r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeMessage(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer r10) throws IOException {
            if (r10.hasArray() == false) goto L5;
            write(r10.array(), r10.arrayOffset(), r10.capacity());
            return;
        L5:
            ByteBuffer r11 = r10.duplicate();
            r11.clear();
            write(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int r10, ByteString r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeBytes(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int r10, String r11) throws IOException {
            writeTag(r10, 2);
            writeStringNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String r10) throws IOException {
            int r11 = this.position;
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r10.length() * 3);     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            int r13 = CodedOutputStream.computeUInt32SizeNoTag(r10.length());     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            if (r13 != r12) goto L10;
            int r14 = r11 + r13;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = r14;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            int r15 = Utf8.encode(r10, this.buffer, r14, spaceLeft());     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = r11;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            writeUInt32NoTag((r15 - r11) - r13);     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = r15;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
        L16:
            return;
        L10:
            writeUInt32NoTag(Utf8.encodedLength(r10));     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = Utf8.encode(r10, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
        L8:
            e = move-exception;
            this.position = r11;
            inefficientWriteStringNoTag(r10, e);
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int r10, int r11) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int r10, int r11) throws IOException {
            writeTag(r10, 0);
            writeUInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int r10) throws IOException {
            if (CodedOutputStream.access$100() == false) goto L13;
            if (spaceLeft() < 10) goto L13;
            long r11 = CodedOutputStream.access$200() + ((long) this.position);
        L8:
            if ((r10 & (-128)) == 0) goto L9;
            UnsafeUtil.putByte(this.buffer, r11, (byte) ((r10 & 127) | 128));
            this.position++;
            r10 = r10 >>> 7;
            r11 = 1 + r11;
            goto L8
        L9:
            UnsafeUtil.putByte(this.buffer, r11, (byte) r10);
            this.position++;
            return;
        L13:
            if ((r10 & (-128)) == 0) goto L14;
            byte[] r12 = this.buffer;     // Catch: IndexOutOfBoundsException -> L16
            int r13 = this.position;     // Catch: IndexOutOfBoundsException -> L16
            this.position = r13 + 1;     // Catch: IndexOutOfBoundsException -> L16
            r12[r13] = (byte) ((r10 & 127) | 128);     // Catch: IndexOutOfBoundsException -> L16
            r10 = r10 >>> 7;
        L16:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L14:
            byte[] r14 = this.buffer;     // Catch: IndexOutOfBoundsException -> L16
            int r15 = this.position;     // Catch: IndexOutOfBoundsException -> L16
            this.position = r15 + 1;     // Catch: IndexOutOfBoundsException -> L16
            r14[r15] = (byte) r10;     // Catch: IndexOutOfBoundsException -> L16
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int r10, long r11) throws IOException {
            writeTag(r10, 0);
            writeUInt64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long r13) throws IOException {
            if (CodedOutputStream.access$100() == false) goto L13;
            if (spaceLeft() < 10) goto L13;
            long r10 = CodedOutputStream.access$200() + ((long) this.position);
        L8:
            if ((r13 & (-128)) == 0) goto L9;
            UnsafeUtil.putByte(this.buffer, r10, (byte) ((((int) r13) & 127) | 128));
            this.position++;
            r13 = r13 >>> 7;
            r10 = 1 + r10;
            goto L8
        L9:
            UnsafeUtil.putByte(this.buffer, r10, (byte) r13);
            this.position++;
            return;
        L13:
            if ((r13 & (-128)) == 0) goto L14;
            byte[] r11 = this.buffer;     // Catch: IndexOutOfBoundsException -> L16
            int r12 = this.position;     // Catch: IndexOutOfBoundsException -> L16
            this.position = r12 + 1;     // Catch: IndexOutOfBoundsException -> L16
            r11[r12] = (byte) ((((int) r13) & 127) | 128);     // Catch: IndexOutOfBoundsException -> L16
            r13 = r13 >>> 7;
        L16:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L14:
            byte[] r14 = this.buffer;     // Catch: IndexOutOfBoundsException -> L16
            int r15 = this.position;     // Catch: IndexOutOfBoundsException -> L16
            this.position = r15 + 1;     // Catch: IndexOutOfBoundsException -> L16
            r14[r15] = (byte) r13;     // Catch: IndexOutOfBoundsException -> L16
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r10, byte[] r11, int r12, int r13) throws IOException {
            writeTag(r10, 2);
            writeByteArrayNoTag(r11, r12, r13);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer r10) throws IOException {
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] r10, int r11, int r12) throws IOException {
            System.arraycopy(r10, r11, this.buffer, this.position, r12);     // Catch: IndexOutOfBoundsException -> L4
            this.position += r12;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(r12)}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer r10) throws IOException {
            int r11 = r10.remaining();
            r10.get(this.buffer, this.position, r11);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r11;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(r11)}), e);
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        public ByteOutputEncoder(ByteOutput r10, int r11) {
            super(r11);
            if (r10 == null) goto L7;
            this.out = r10;
            return;
        L7:
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int r10) throws IOException {
            if ((this.limit - this.position) >= r10) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r10) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r10, boolean r11) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r10, 0);
            buffer(r11 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r10, byte[] r11) throws IOException {
            writeByteArray(r10, r11, 0, r11.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r10, int r11, int r12) throws IOException {
            writeUInt32NoTag(r12);
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r10, ByteBuffer r11) throws IOException {
            writeTag(r10, 2);
            writeUInt32NoTag(r11.capacity());
            writeRawBytes(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r10, ByteString r11) throws IOException {
            writeTag(r10, 2);
            writeBytesNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r10) throws IOException {
            writeUInt32NoTag(r10.size());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r10, int r11) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(r10, 5);
            bufferFixed32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r10) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r10, long r11) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(r10, 1);
            bufferFixed64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r10) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r10, int r11) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r10, 0);
            bufferInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r10) throws IOException {
            if (r10 < 0) goto L4;
            writeUInt32NoTag(r10);
            return;
        L4:
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) throws IOException {
            flush();
            this.out.writeLazy(r10, r11, r12);
            this.totalBytesWritten += r12;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r10, MessageLite r11) throws IOException {
            writeTag(r10, 2);
            writeMessageNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r10) throws IOException {
            writeUInt32NoTag(r10.getSerializedSize());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r10, MessageLite r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeMessage(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r10) throws IOException {
            if (r10.hasArray() == false) goto L5;
            write(r10.array(), r10.arrayOffset(), r10.capacity());
            return;
        L5:
            ByteBuffer r11 = r10.duplicate();
            r11.clear();
            write(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r10, ByteString r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeBytes(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r10, String r11) throws IOException {
            writeTag(r10, 2);
            writeStringNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r10) throws IOException {
            int r11 = r10.length() * 3;
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r11);
            int r13 = r12 + r11;
            int r14 = this.limit;
            if (r13 <= r14) goto L7;
            byte[] r15 = new byte[r11];
            int r16 = Utf8.encode(r10, r15, 0, r11);
            writeUInt32NoTag(r16);
            writeLazy(r15, 0, r16);
            return;
        L7:
            if (r13 <= (r14 - this.position)) goto L9;
            doFlush();
        L9:
            int r17 = this.position;
            int r18 = CodedOutputStream.computeUInt32SizeNoTag(r10.length());     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            if (r18 != r12) goto L17;
            int r19 = r17 + r18;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = r19;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            int r20 = Utf8.encode(r10, this.buffer, r19, this.limit - r19);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = r17;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            int r21 = (r20 - r17) - r18;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            bufferUInt32NoTag(r21);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = r20;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.totalBytesWritten += r21;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
        L23:
            return;
        L17:
            int r22 = Utf8.encodedLength(r10);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            bufferUInt32NoTag(r22);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = Utf8.encode(r10, this.buffer, this.position, r22);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.totalBytesWritten += r22;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
        L15:
            e = move-exception;
            this.totalBytesWritten -= this.position - r17;
            this.position = r17;
            inefficientWriteStringNoTag(r10, e);
            return;
        L13:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r10, int r11) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r10, int r11) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r10, 0);
            bufferUInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r10) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r10, long r11) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r10, 0);
            bufferUInt64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r10) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r10, byte[] r11, int r12, int r13) throws IOException {
            writeTag(r10, 2);
            writeByteArrayNoTag(r11, r12, r13);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) throws IOException {
            flush();
            this.out.write(r10, r11, r12);
            this.totalBytesWritten += r12;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) throws IOException {
            flush();
            int r11 = r10.remaining();
            this.out.writeLazy(r10);
            this.totalBytesWritten += r11;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) throws IOException {
            flush();
            int r11 = r10.remaining();
            this.out.write(r10);
            this.totalBytesWritten += r11;
        }
    }

    public static final class NioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public NioEncoder(ByteBuffer r10) {
            super(null);
            this.originalBuffer = r10;
            this.buffer = r10.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = r10.position();
        }

        private void encode(String r10) throws IOException {
            Utf8.encodeUtf8(r10, this.buffer);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r10) throws IOException {
            this.buffer.put(r10);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r10, boolean r11) throws IOException {
            writeTag(r10, 0);
            write(r11 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r10, byte[] r11) throws IOException {
            writeByteArray(r10, r11, 0, r11.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r10, int r11, int r12) throws IOException {
            writeUInt32NoTag(r12);
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r10, ByteBuffer r11) throws IOException {
            writeTag(r10, 2);
            writeUInt32NoTag(r11.capacity());
            writeRawBytes(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r10, ByteString r11) throws IOException {
            writeTag(r10, 2);
            writeBytesNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r10) throws IOException {
            writeUInt32NoTag(r10.size());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r10, int r11) throws IOException {
            writeTag(r10, 5);
            writeFixed32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r10) throws IOException {
            this.buffer.putInt(r10);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r10, long r11) throws IOException {
            writeTag(r10, 1);
            writeFixed64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r10) throws IOException {
            this.buffer.putLong(r10);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r10, int r11) throws IOException {
            writeTag(r10, 0);
            writeInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r10) throws IOException {
            if (r10 < 0) goto L4;
            writeUInt32NoTag(r10);
            return;
        L4:
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) throws IOException {
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r10, MessageLite r11) throws IOException {
            writeTag(r10, 2);
            writeMessageNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r10) throws IOException {
            writeUInt32NoTag(r10.getSerializedSize());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r10, MessageLite r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeMessage(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r10) throws IOException {
            if (r10.hasArray() == false) goto L5;
            write(r10.array(), r10.arrayOffset(), r10.capacity());
            return;
        L5:
            ByteBuffer r11 = r10.duplicate();
            r11.clear();
            write(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r10, ByteString r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeBytes(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r10, String r11) throws IOException {
            writeTag(r10, 2);
            writeStringNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r10) throws IOException {
            int r11 = this.buffer.position();
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r10.length() * 3);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            int r13 = CodedOutputStream.computeUInt32SizeNoTag(r10.length());     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            if (r13 != r12) goto L10;
            int r14 = this.buffer.position() + r13;     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.buffer.position(r14);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            encode(r10);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            int r15 = this.buffer.position();     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.buffer.position(r11);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            writeUInt32NoTag(r15 - r14);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.buffer.position(r15);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
        L16:
            return;
        L10:
            writeUInt32NoTag(Utf8.encodedLength(r10));     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            encode(r10);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
        L8:
            e = move-exception;
            this.buffer.position(r11);
            inefficientWriteStringNoTag(r10, e);
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r10, int r11) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r10, int r11) throws IOException {
            writeTag(r10, 0);
            writeUInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r10) throws IOException {
        L3:
            if ((r10 & (-128)) == 0) goto L4;
            this.buffer.put((byte) ((r10 & 127) | 128));     // Catch: BufferOverflowException -> L6
            r10 = r10 >>> 7;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r10);     // Catch: BufferOverflowException -> L6
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r10, long r11) throws IOException {
            writeTag(r10, 0);
            writeUInt64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r10) throws IOException {
        L3:
            if (((-128) & r10) == 0) goto L4;
            this.buffer.put((byte) ((((int) r10) & 127) | 128));     // Catch: BufferOverflowException -> L6
            r10 = r10 >>> 7;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r10);     // Catch: BufferOverflowException -> L6
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r10, byte[] r11, int r12, int r13) throws IOException {
            writeTag(r10, 2);
            writeByteArrayNoTag(r11, r12, r13);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) throws IOException {
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) throws IOException {
            this.buffer.put(r10, r11, r12);     // Catch: BufferOverflowException -> L4 IndexOutOfBoundsException -> L6
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) throws IOException {
            this.buffer.put(r10);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }
    }

    public static final class NioHeapEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public NioHeapEncoder(ByteBuffer r10) {
            super(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());
            this.byteBuffer = r10;
            this.initialPosition = r10.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(Throwable r10) {
            super(MESSAGE, r10);
        }

        public OutOfSpaceException(String r10, Throwable r11) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r10, r11);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream r10, int r11) {
            super(r11);
            if (r10 == null) goto L7;
            this.out = r10;
            return;
        L7:
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int r10) throws IOException {
            if ((this.limit - this.position) >= r10) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r10) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r10, boolean r11) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r10, 0);
            buffer(r11 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r10, byte[] r11) throws IOException {
            writeByteArray(r10, r11, 0, r11.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r10, int r11, int r12) throws IOException {
            writeUInt32NoTag(r12);
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r10, ByteBuffer r11) throws IOException {
            writeTag(r10, 2);
            writeUInt32NoTag(r11.capacity());
            writeRawBytes(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r10, ByteString r11) throws IOException {
            writeTag(r10, 2);
            writeBytesNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r10) throws IOException {
            writeUInt32NoTag(r10.size());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r10, int r11) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(r10, 5);
            bufferFixed32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r10) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r10, long r11) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(r10, 1);
            bufferFixed64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r10) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r10, int r11) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r10, 0);
            bufferInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r10) throws IOException {
            if (r10 < 0) goto L4;
            writeUInt32NoTag(r10);
            return;
        L4:
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) throws IOException {
            write(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r10, MessageLite r11) throws IOException {
            writeTag(r10, 2);
            writeMessageNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r10) throws IOException {
            writeUInt32NoTag(r10.getSerializedSize());
            r10.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r10, MessageLite r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeMessage(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r10) throws IOException {
            if (r10.hasArray() == false) goto L5;
            write(r10.array(), r10.arrayOffset(), r10.capacity());
            return;
        L5:
            ByteBuffer r11 = r10.duplicate();
            r11.clear();
            write(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r10, ByteString r11) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r10);
            writeBytes(3, r11);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r10, String r11) throws IOException {
            writeTag(r10, 2);
            writeStringNoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r10) throws IOException {
            int r11 = r10.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L6
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r11);     // Catch: Utf8.UnpairedSurrogateException -> L6
            int r13 = r12 + r11;     // Catch: Utf8.UnpairedSurrogateException -> L6
            int r14 = this.limit;     // Catch: Utf8.UnpairedSurrogateException -> L6
            if (r13 <= r14) goto L9;
            byte[] r15 = new byte[r11];     // Catch: Utf8.UnpairedSurrogateException -> L6
            int r16 = Utf8.encode(r10, r15, 0, r11);     // Catch: Utf8.UnpairedSurrogateException -> L6
            writeUInt32NoTag(r16);     // Catch: Utf8.UnpairedSurrogateException -> L6
            writeLazy(r15, 0, r16);     // Catch: Utf8.UnpairedSurrogateException -> L6
            return;
        L9:
            if (r13 <= (r14 - this.position)) goto L11;
            doFlush();     // Catch: Utf8.UnpairedSurrogateException -> L6
        L11:
            int r17 = CodedOutputStream.computeUInt32SizeNoTag(r10.length());     // Catch: Utf8.UnpairedSurrogateException -> L6
            int r18 = this.position;     // Catch: Utf8.UnpairedSurrogateException -> L6
            if (r17 != r12) goto L19;
            int r19 = r18 + r17;
            this.position = r19;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            int r20 = Utf8.encode(r10, this.buffer, r19, this.limit - r19);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            this.position = r18;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            int r21 = (r20 - r18) - r17;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            bufferUInt32NoTag(r21);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            this.position = r20;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
        L20:
            this.totalBytesWritten += r21;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
        L31:
            return;
        L19:
            r21 = Utf8.encodedLength(r10);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            bufferUInt32NoTag(r21);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            this.position = Utf8.encode(r10, this.buffer, this.position, r21);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
        L17:
            e = move-exception;
            this.totalBytesWritten -= this.position - r18;     // Catch: Utf8.UnpairedSurrogateException -> L6
            this.position = r18;     // Catch: Utf8.UnpairedSurrogateException -> L6
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L6
        L15:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L6
        L6:
            e = move-exception;
            inefficientWriteStringNoTag(r10, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r10, int r11) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r10, int r11) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r10, 0);
            bufferUInt32NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r10) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r10, long r11) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r10, 0);
            bufferUInt64NoTag(r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r10) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r10, byte[] r11, int r12, int r13) throws IOException {
            writeTag(r10, 2);
            writeByteArrayNoTag(r11, r12, r13);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) throws IOException {
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) throws IOException {
            int r13 = this.limit;
            int r14 = this.position;
            if ((r13 - r14) < r12) goto L5;
            System.arraycopy(r10, r11, this.buffer, r14, r12);
            this.position += r12;
            this.totalBytesWritten += r12;
            return;
        L5:
            int r15 = r13 - r14;
            System.arraycopy(r10, r11, this.buffer, r14, r15);
            int r16 = r11 + r15;
            int r17 = r12 - r15;
            this.position = this.limit;
            this.totalBytesWritten += r15;
            doFlush();
            if (r17 > this.limit) goto L8;
            System.arraycopy(r10, r16, this.buffer, 0, r17);
            this.position = r17;
        L9:
            this.totalBytesWritten += r17;
            return;
        L8:
            this.out.write(r10, r16, r17);
            goto L9
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) throws IOException {
            int r11 = r10.remaining();
            int r12 = this.limit;
            int r13 = this.position;
            if ((r12 - r13) < r11) goto L5;
            r10.get(this.buffer, r13, r11);
            this.position += r11;
            this.totalBytesWritten += r11;
            return;
        L5:
            int r14 = r12 - r13;
            r10.get(this.buffer, r13, r14);
            int r15 = r11 - r14;
            this.position = this.limit;
            this.totalBytesWritten += r14;
            doFlush();
        L6:
            int r16 = this.limit;
            if (r15 <= r16) goto L9;
            r10.get(this.buffer, 0, r16);
            this.out.write(this.buffer, 0, this.limit);
            int r17 = this.limit;
            r15 = r15 - r17;
            this.totalBytesWritten += r17;
            goto L6
        L9:
            r10.get(this.buffer, 0, r15);
            this.position = r15;
            this.totalBytesWritten += r15;
        }
    }

    static {
        logger = Logger.getLogger(CodedOutputStream.class.getName());
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
        ARRAY_BASE_OFFSET = UnsafeUtil.getArrayBaseOffset();
    }

    public /* synthetic */ CodedOutputStream(AnonymousClass1 r10) {
        this();
    }

    public static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static /* synthetic */ long access$200() {
        return ARRAY_BASE_OFFSET;
    }

    public static int computeBoolSize(int r10, boolean r11) {
        return computeTagSize(r10) + computeBoolSizeNoTag(r11);
    }

    public static int computeBoolSizeNoTag(boolean r10) {
        return 1;
    }

    public static int computeByteArraySize(int r10, byte[] r11) {
        return computeTagSize(r10) + computeByteArraySizeNoTag(r11);
    }

    public static int computeByteArraySizeNoTag(byte[] r10) {
        return computeLengthDelimitedFieldSize(r10.length);
    }

    public static int computeByteBufferSize(int r10, ByteBuffer r11) {
        return computeTagSize(r10) + computeByteBufferSizeNoTag(r11);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer r10) {
        return computeLengthDelimitedFieldSize(r10.capacity());
    }

    public static int computeBytesSize(int r10, ByteString r11) {
        return computeTagSize(r10) + computeBytesSizeNoTag(r11);
    }

    public static int computeBytesSizeNoTag(ByteString r10) {
        return computeLengthDelimitedFieldSize(r10.size());
    }

    public static int computeDoubleSize(int r10, double r11) {
        return computeTagSize(r10) + computeDoubleSizeNoTag(r11);
    }

    public static int computeDoubleSizeNoTag(double r10) {
        return 8;
    }

    public static int computeEnumSize(int r10, int r11) {
        return computeTagSize(r10) + computeEnumSizeNoTag(r11);
    }

    public static int computeEnumSizeNoTag(int r10) {
        return computeInt32SizeNoTag(r10);
    }

    public static int computeFixed32Size(int r10, int r11) {
        return computeTagSize(r10) + computeFixed32SizeNoTag(r11);
    }

    public static int computeFixed32SizeNoTag(int r10) {
        return 4;
    }

    public static int computeFixed64Size(int r10, long r11) {
        return computeTagSize(r10) + computeFixed64SizeNoTag(r11);
    }

    public static int computeFixed64SizeNoTag(long r10) {
        return 8;
    }

    public static int computeFloatSize(int r10, float r11) {
        return computeTagSize(r10) + computeFloatSizeNoTag(r11);
    }

    public static int computeFloatSizeNoTag(float r10) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int r10, MessageLite r11) {
        return (computeTagSize(r10) * 2) + computeGroupSizeNoTag(r11);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite r10) {
        return r10.getSerializedSize();
    }

    public static int computeInt32Size(int r10, int r11) {
        return computeTagSize(r10) + computeInt32SizeNoTag(r11);
    }

    public static int computeInt32SizeNoTag(int r10) {
        if (r10 >= 0) goto L4;
        return 10;
    L4:
        return computeUInt32SizeNoTag(r10);
    }

    public static int computeInt64Size(int r10, long r11) {
        return computeTagSize(r10) + computeInt64SizeNoTag(r11);
    }

    public static int computeInt64SizeNoTag(long r10) {
        return computeUInt64SizeNoTag(r10);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int r10, LazyFieldLite r11) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r10)) + computeLazyFieldSize(3, r11);
    }

    public static int computeLazyFieldSize(int r10, LazyFieldLite r11) {
        return computeTagSize(r10) + computeLazyFieldSizeNoTag(r11);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r10) {
        return computeLengthDelimitedFieldSize(r10.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int r10) {
        return computeUInt32SizeNoTag(r10) + r10;
    }

    public static int computeMessageSetExtensionSize(int r10, MessageLite r11) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r10)) + computeMessageSize(3, r11);
    }

    public static int computeMessageSize(int r10, MessageLite r11) {
        return computeTagSize(r10) + computeMessageSizeNoTag(r11);
    }

    public static int computeMessageSizeNoTag(MessageLite r10) {
        return computeLengthDelimitedFieldSize(r10.getSerializedSize());
    }

    public static int computePreferredBufferSize(int r10) {
        if (r10 <= 4096) goto L5;
        return 4096;
    L5:
        return r10;
    }

    public static int computeRawMessageSetExtensionSize(int r10, ByteString r11) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r10)) + computeBytesSize(3, r11);
    }

    @Deprecated
    public static int computeRawVarint32Size(int r10) {
        return computeUInt32SizeNoTag(r10);
    }

    @Deprecated
    public static int computeRawVarint64Size(long r10) {
        return computeUInt64SizeNoTag(r10);
    }

    public static int computeSFixed32Size(int r10, int r11) {
        return computeTagSize(r10) + computeSFixed32SizeNoTag(r11);
    }

    public static int computeSFixed32SizeNoTag(int r10) {
        return 4;
    }

    public static int computeSFixed64Size(int r10, long r11) {
        return computeTagSize(r10) + computeSFixed64SizeNoTag(r11);
    }

    public static int computeSFixed64SizeNoTag(long r10) {
        return 8;
    }

    public static int computeSInt32Size(int r10, int r11) {
        return computeTagSize(r10) + computeSInt32SizeNoTag(r11);
    }

    public static int computeSInt32SizeNoTag(int r10) {
        return computeUInt32SizeNoTag(encodeZigZag32(r10));
    }

    public static int computeSInt64Size(int r10, long r11) {
        return computeTagSize(r10) + computeSInt64SizeNoTag(r11);
    }

    public static int computeSInt64SizeNoTag(long r10) {
        return computeUInt64SizeNoTag(encodeZigZag64(r10));
    }

    public static int computeStringSize(int r10, String r11) {
        return computeTagSize(r10) + computeStringSizeNoTag(r11);
    }

    public static int computeStringSizeNoTag(String r10) {
        int r11 = Utf8.encodedLength(r10);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L6:
        return computeLengthDelimitedFieldSize(r11);
    L4:
        r11 = r10.getBytes(Internal.UTF_8).length;
        goto L6
    }

    public static int computeTagSize(int r10) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(r10, 0));
    }

    public static int computeUInt32Size(int r10, int r11) {
        return computeTagSize(r10) + computeUInt32SizeNoTag(r11);
    }

    public static int computeUInt32SizeNoTag(int r10) {
        if ((r10 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r10 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r10) != 0) goto L15;
        return 3;
    L15:
        if ((r10 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeUInt64Size(int r10, long r11) {
        return computeTagSize(r10) + computeUInt64SizeNoTag(r11);
    }

    public static int computeUInt64SizeNoTag(long r10) {
        if (((-128) & r10) != 0) goto L7;
        return 1;
    L7:
        if (r10 >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & r10) == 0) goto L13;
        r10 = r10 >>> 28;
        int r11 = 6;
    L15:
        if (((-2097152) & r10) == 0) goto L18;
        r11 = r11 + 2;
        r10 = r10 >>> 14;
    L18:
        if ((r10 & (-16384)) != 0) goto L20;
        return r11;
    L20:
        return r11 + 1;
    L13:
        r11 = 2;
        goto L15
    }

    public static int encodeZigZag32(int r10) {
        int r11 = r10 << 1;
        return (r10 >> 31) ^ r11;
    }

    public static long encodeZigZag64(long r10) {
        long r11 = r10 << 1;
        return (r10 >> 63) ^ r11;
    }

    public static CodedOutputStream newInstance(OutputStream r10) {
        return newInstance(r10, 4096);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String r10, Utf8.UnpairedSurrogateException r11) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", r11);
        byte[] r12 = r10.getBytes(Internal.UTF_8);
        writeUInt32NoTag(r12.length);     // Catch: OutOfSpaceException -> L5 IndexOutOfBoundsException -> L7
        writeLazy(r12, 0, r12.length);     // Catch: OutOfSpaceException -> L5 IndexOutOfBoundsException -> L7
        return;
    L5:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte r10) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer r10) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] r10, int r11, int r12) throws IOException;

    public abstract void writeBool(int r10, boolean r11) throws IOException;

    public final void writeBoolNoTag(boolean r10) throws IOException {
        write(r10 ? 1 : 0);
    }

    public abstract void writeByteArray(int r10, byte[] r11) throws IOException;

    public abstract void writeByteArray(int r10, byte[] r11, int r12, int r13) throws IOException;

    public final void writeByteArrayNoTag(byte[] r10) throws IOException {
        writeByteArrayNoTag(r10, 0, r10.length);
    }

    public abstract void writeByteArrayNoTag(byte[] r10, int r11, int r12) throws IOException;

    public abstract void writeByteBuffer(int r10, ByteBuffer r11) throws IOException;

    public abstract void writeBytes(int r10, ByteString r11) throws IOException;

    public abstract void writeBytesNoTag(ByteString r10) throws IOException;

    public final void writeDouble(int r10, double r11) throws IOException {
        writeFixed64(r10, Double.doubleToRawLongBits(r11));
    }

    public final void writeDoubleNoTag(double r10) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(r10));
    }

    public final void writeEnum(int r10, int r11) throws IOException {
        writeInt32(r10, r11);
    }

    public final void writeEnumNoTag(int r10) throws IOException {
        writeInt32NoTag(r10);
    }

    public abstract void writeFixed32(int r10, int r11) throws IOException;

    public abstract void writeFixed32NoTag(int r10) throws IOException;

    public abstract void writeFixed64(int r10, long r11) throws IOException;

    public abstract void writeFixed64NoTag(long r10) throws IOException;

    public final void writeFloat(int r10, float r11) throws IOException {
        writeFixed32(r10, Float.floatToRawIntBits(r11));
    }

    public final void writeFloatNoTag(float r10) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(r10));
    }

    @Deprecated
    public final void writeGroup(int r10, MessageLite r11) throws IOException {
        writeTag(r10, 3);
        writeGroupNoTag(r11);
        writeTag(r10, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite r10) throws IOException {
        r10.writeTo(this);
    }

    public abstract void writeInt32(int r10, int r11) throws IOException;

    public abstract void writeInt32NoTag(int r10) throws IOException;

    public final void writeInt64(int r10, long r11) throws IOException {
        writeUInt64(r10, r11);
    }

    public final void writeInt64NoTag(long r10) throws IOException {
        writeUInt64NoTag(r10);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer r10) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] r10, int r11, int r12) throws IOException;

    public abstract void writeMessage(int r10, MessageLite r11) throws IOException;

    public abstract void writeMessageNoTag(MessageLite r10) throws IOException;

    public abstract void writeMessageSetExtension(int r10, MessageLite r11) throws IOException;

    public final void writeRawByte(byte r10) throws IOException {
        write(r10);
    }

    public abstract void writeRawBytes(ByteBuffer r10) throws IOException;

    public final void writeRawBytes(byte[] r10) throws IOException {
        write(r10, 0, r10.length);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int r10) throws IOException {
        writeFixed32NoTag(r10);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long r10) throws IOException {
        writeFixed64NoTag(r10);
    }

    public abstract void writeRawMessageSetExtension(int r10, ByteString r11) throws IOException;

    @Deprecated
    public final void writeRawVarint32(int r10) throws IOException {
        writeUInt32NoTag(r10);
    }

    @Deprecated
    public final void writeRawVarint64(long r10) throws IOException {
        writeUInt64NoTag(r10);
    }

    public final void writeSFixed32(int r10, int r11) throws IOException {
        writeFixed32(r10, r11);
    }

    public final void writeSFixed32NoTag(int r10) throws IOException {
        writeFixed32NoTag(r10);
    }

    public final void writeSFixed64(int r10, long r11) throws IOException {
        writeFixed64(r10, r11);
    }

    public final void writeSFixed64NoTag(long r10) throws IOException {
        writeFixed64NoTag(r10);
    }

    public final void writeSInt32(int r10, int r11) throws IOException {
        writeUInt32(r10, encodeZigZag32(r11));
    }

    public final void writeSInt32NoTag(int r10) throws IOException {
        writeUInt32NoTag(encodeZigZag32(r10));
    }

    public final void writeSInt64(int r10, long r11) throws IOException {
        writeUInt64(r10, encodeZigZag64(r11));
    }

    public final void writeSInt64NoTag(long r10) throws IOException {
        writeUInt64NoTag(encodeZigZag64(r10));
    }

    public abstract void writeString(int r10, String r11) throws IOException;

    public abstract void writeStringNoTag(String r10) throws IOException;

    public abstract void writeTag(int r10, int r11) throws IOException;

    public abstract void writeUInt32(int r10, int r11) throws IOException;

    public abstract void writeUInt32NoTag(int r10) throws IOException;

    public abstract void writeUInt64(int r10, long r11) throws IOException;

    public abstract void writeUInt64NoTag(long r10) throws IOException;

    private CodedOutputStream() {
    }

    public static CodedOutputStream newInstance(OutputStream r10, int r11) {
        return new OutputStreamEncoder(r10, r11);
    }

    public final void writeRawByte(int r10) throws IOException {
        write((byte) r10);
    }

    public final void writeRawBytes(byte[] r10, int r11, int r12) throws IOException {
        write(r10, r11, r12);
    }

    public static CodedOutputStream newInstance(byte[] r10) {
        return newInstance(r10, 0, r10.length);
    }

    public final void writeRawBytes(ByteString r10) throws IOException {
        r10.writeTo(this);
    }

    public static CodedOutputStream newInstance(byte[] r10, int r11, int r12) {
        return new ArrayEncoder(r10, r11, r12);
    }

    public static CodedOutputStream newInstance(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L7;
        return new NioHeapEncoder(r10);
    L7:
        return new NioEncoder(r10);
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer r10, int r11) {
        return newInstance(r10);
    }

    public static CodedOutputStream newInstance(ByteOutput r10, int r11) {
        if (r11 < 0) goto L6;
        return new ByteOutputEncoder(r10, r11);
    L6:
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
