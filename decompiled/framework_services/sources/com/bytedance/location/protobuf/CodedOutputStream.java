package com.bytedance.location.protobuf;

import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = null;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.CodedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int bufferSize) {
            super(null);
            if (bufferSize < 0) goto L7;
            this.buffer = new byte[Math.max(bufferSize, 20)];
            this.limit = this.buffer.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        final void buffer(byte value) {
            byte[] r0 = this.buffer;
            int r1 = this.position;
            this.position = r1 + 1;
            r0[r1] = value;
            this.totalBytesWritten++;
        }

        final void bufferTag(int fieldNumber, int wireType) {
            bufferUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        final void bufferInt32NoTag(int value) {
            if (value < 0) goto L4;
            bufferUInt32NoTag(value);
            return;
        L4:
            bufferUInt64NoTag(value);
        }

        final void bufferUInt32NoTag(int value) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long originalPos = this.position;
        L6:
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) == 0) goto L7;
            byte[] r2 = this.buffer;
            int r3 = this.position;
            this.position = r3 + 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((value & 127) | 128));
            value = value >>> 7;
            goto L6
        L7:
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            UnsafeUtil.putByte(r4, r5, (byte) value);
            int delta = (int) (((long) this.position) - originalPos);
            this.totalBytesWritten += delta;
            return;
        L11:
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) == 0) goto L12;
            byte[] r0 = this.buffer;
            int r1 = this.position;
            this.position = r1 + 1;
            r0[r1] = (byte) ((value & 127) | 128);
            this.totalBytesWritten++;
            value = value >>> 7;
            goto L11
        L12:
            byte[] r6 = this.buffer;
            int r7 = this.position;
            this.position = r7 + 1;
            r6[r7] = (byte) value;
            this.totalBytesWritten++;
        }

        final void bufferUInt64NoTag(long value) {
            if (CodedOutputStream.access$100() == false) goto L10;
            long originalPos = this.position;
        L6:
            if ((value & (-128)) == 0) goto L7;
            byte[] r0 = this.buffer;
            int r8 = this.position;
            this.position = r8 + 1;
            UnsafeUtil.putByte(r0, r8, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L6
        L7:
            byte[] r1 = this.buffer;
            int r2 = this.position;
            this.position = r2 + 1;
            UnsafeUtil.putByte(r1, r2, (byte) value);
            int delta = (int) (((long) this.position) - originalPos);
            this.totalBytesWritten += delta;
            return;
        L10:
            long originalPos2 = value & (-128);
            if (originalPos2 == 0) goto L12;
            byte[] r3 = this.buffer;
            int r6 = this.position;
            this.position = r6 + 1;
            r3[r6] = (byte) ((((int) value) & 127) | 128);
            this.totalBytesWritten++;
            value = value >>> 7;
            goto L10
        L12:
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            r4[r5] = (byte) value;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.position;
            this.position = r1 + 1;
            r0[r1] = (byte) (value & 255);
            byte[] r2 = this.buffer;
            int r3 = this.position;
            this.position = r3 + 1;
            r2[r3] = (byte) ((value >> 8) & 255);
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            r4[r5] = (byte) ((value >> 16) & 255);
            byte[] r6 = this.buffer;
            int r7 = this.position;
            this.position = r7 + 1;
            r6[r7] = (byte) ((value >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.position;
            this.position = r1 + 1;
            r0[r1] = (byte) (value & 255);
            byte[] r2 = this.buffer;
            int r3 = this.position;
            this.position = r3 + 1;
            r2[r3] = (byte) ((value >> 8) & 255);
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            r4[r5] = (byte) ((value >> 16) & 255);
            byte[] r6 = this.buffer;
            int r7 = this.position;
            this.position = r7 + 1;
            r6[r7] = (byte) (255 & (value >> 24));
            byte[] r8 = this.buffer;
            int r9 = this.position;
            this.position = r9 + 1;
            r8[r9] = (byte) (((int) (value >> 32)) & 255);
            byte[] r10 = this.buffer;
            int r11 = this.position;
            this.position = r11 + 1;
            r10[r11] = (byte) (((int) (value >> 40)) & 255);
            byte[] r12 = this.buffer;
            int r13 = this.position;
            this.position = r13 + 1;
            r12[r13] = (byte) (((int) (value >> 48)) & 255);
            byte[] r14 = this.buffer;
            int r15 = this.position;
            this.position = r15 + 1;
            r14[r15] = (byte) (((int) (value >> 56)) & 255);
            this.totalBytesWritten += 8;
        }
    }

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        ArrayEncoder(byte[] buffer, int offset, int length) {
            super(null);
            if (buffer == null) goto L11;
            if (((offset | length) | (buffer.length - (offset + length))) < 0) goto L9;
            this.buffer = buffer;
            this.offset = offset;
            this.position = offset;
            this.limit = offset + length;
            return;
        L9:
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(buffer.length), Integer.valueOf(offset), Integer.valueOf(length)}));
        L11:
            throw new NullPointerException("buffer");
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeTag(int fieldNumber, int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeUInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeFixed32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 5);
            writeFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeUInt64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeFixed64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 1);
            writeFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeBool(int r2, boolean r3) throws IOException {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeString(int fieldNumber, String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeBytes(int fieldNumber, ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeByteArray(int fieldNumber, byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer duplicated = value.duplicate();
            duplicated.clear();
            write(duplicated);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeMessage(int fieldNumber, MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        final void writeMessage(int fieldNumber, MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        final void writeMessageNoTag(MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public final void write(byte value) throws IOException {
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = value;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int value) throws IOException {
        L3:
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) == 0) goto L4;
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L6
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L6
            this.position = r1 + 1;     // Catch: IndexOutOfBoundsException -> L6
            r0[r1] = (byte) ((value & 127) | 128);     // Catch: IndexOutOfBoundsException -> L6
            value = value >>> 7;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L4:
            byte[] r2 = this.buffer;     // Catch: IndexOutOfBoundsException -> L6
            int r3 = this.position;     // Catch: IndexOutOfBoundsException -> L6
            this.position = r3 + 1;     // Catch: IndexOutOfBoundsException -> L6
            r2[r3] = (byte) value;     // Catch: IndexOutOfBoundsException -> L6
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int value) throws IOException {
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = (byte) (value & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r2 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r3 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r3 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r2[r3] = (byte) ((value >> 8) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r4 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r5 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r5 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r4[r5] = (byte) ((value >> 16) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r6 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r7 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r7 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r6[r7] = (byte) ((value >> 24) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long value) throws IOException {
            if (CodedOutputStream.access$100() == false) goto L12;
            if (spaceLeft() < 10) goto L12;
        L7:
            if ((value & (-128)) == 0) goto L8;
            byte[] r0 = this.buffer;
            int r6 = this.position;
            this.position = r6 + 1;
            UnsafeUtil.putByte(r0, r6, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L7
        L8:
            byte[] r1 = this.buffer;
            int r2 = this.position;
            this.position = r2 + 1;
            UnsafeUtil.putByte(r1, r2, (byte) value);
            return;
        L12:
            if ((value & (-128)) == 0) goto L13;
            byte[] r3 = this.buffer;     // Catch: IndexOutOfBoundsException -> L15
            int r7 = this.position;     // Catch: IndexOutOfBoundsException -> L15
            this.position = r7 + 1;     // Catch: IndexOutOfBoundsException -> L15
            r3[r7] = (byte) ((((int) value) & 127) | 128);     // Catch: IndexOutOfBoundsException -> L15
            value = value >>> 7;
        L15:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L13:
            byte[] r4 = this.buffer;     // Catch: IndexOutOfBoundsException -> L15
            int r5 = this.position;     // Catch: IndexOutOfBoundsException -> L15
            this.position = r5 + 1;     // Catch: IndexOutOfBoundsException -> L15
            r4[r5] = (byte) value;     // Catch: IndexOutOfBoundsException -> L15
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long value) throws IOException {
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = (byte) (((int) value) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r2 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r3 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r3 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r2[r3] = (byte) (((int) (value >> 8)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r4 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r5 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r5 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r4[r5] = (byte) (((int) (value >> 16)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r6 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r7 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r7 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r6[r7] = (byte) (((int) (value >> 24)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r8 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r9 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r9 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r8[r9] = (byte) (((int) (value >> 32)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r10 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r11 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r11 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r10[r11] = (byte) (((int) (value >> 40)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r12 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r13 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r13 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r12[r13] = (byte) (((int) (value >> 48)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            byte[] r14 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r15 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r15 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r14[r15] = (byte) (((int) (value >> 56)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public final void write(byte[] value, int offset, int length) throws IOException {
            System.arraycopy(value, offset, this.buffer, this.position, length);     // Catch: IndexOutOfBoundsException -> L4
            this.position += length;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(length)}), e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public final void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public final void write(ByteBuffer value) throws IOException {
            int length = value.remaining();
            value.get(this.buffer, this.position, length);     // Catch: IndexOutOfBoundsException -> L5
            this.position += length;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(length)}), e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final void writeStringNoTag(String value) throws IOException {
            int oldPosition = this.position;
            int maxLength = value.length() * 3;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            int maxLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(maxLength);     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            int minLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(value.length());     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            if (minLengthVarIntSize != maxLengthVarIntSize) goto L10;
            this.position = oldPosition + minLengthVarIntSize;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            int newPosition = Utf8.encode(value, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = oldPosition;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            int length = (newPosition - oldPosition) - minLengthVarIntSize;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            writeUInt32NoTag(length);     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = newPosition;     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
        L16:
            return;
        L10:
            int length2 = Utf8.encodedLength(value);     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            writeUInt32NoTag(length2);     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.position = Utf8.encode(value, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L6 Utf8.UnpairedSurrogateException -> L8
        L8:
            e = move-exception;
            this.position = oldPosition;
            inefficientWriteStringNoTag(value, e);
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput out, int bufferSize) {
            super(bufferSize);
            if (out == null) goto L7;
            this.out = out;
            return;
        L7:
            throw new NullPointerException("out");
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeTag(int fieldNumber, int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32(int fieldNumber, int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(fieldNumber, 5);
            bufferFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(fieldNumber, 1);
            bufferFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r2, 0);
            buffer(r3 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeString(int fieldNumber, String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer duplicated = value.duplicate();
            duplicated.clear();
            write(duplicated);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessage(int fieldNumber, MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessage(int fieldNumber, MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int value) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long value) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            int maxLength = value.length() * 3;
            int maxLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(maxLength);
            if ((maxLengthVarIntSize + maxLength) <= this.limit) goto L7;
            byte[] encodedBytes = new byte[maxLength];
            int actualLength = Utf8.encode(value, encodedBytes, 0, maxLength);
            writeUInt32NoTag(actualLength);
            writeLazy(encodedBytes, 0, actualLength);
            return;
        L7:
            if ((maxLengthVarIntSize + maxLength) <= (this.limit - this.position)) goto L9;
            doFlush();
        L9:
            int oldPosition = this.position;
            int minLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(value.length());     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            if (minLengthVarIntSize != maxLengthVarIntSize) goto L17;
            this.position = oldPosition + minLengthVarIntSize;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            int newPosition = Utf8.encode(value, this.buffer, this.position, this.limit - this.position);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = oldPosition;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            int length = (newPosition - oldPosition) - minLengthVarIntSize;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            bufferUInt32NoTag(length);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = newPosition;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.totalBytesWritten += length;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
        L23:
            return;
        L17:
            int length2 = Utf8.encodedLength(value);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            bufferUInt32NoTag(length2);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.position = Utf8.encode(value, this.buffer, this.position, length2);     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
            this.totalBytesWritten += length2;     // Catch: IndexOutOfBoundsException -> L13 Utf8.UnpairedSurrogateException -> L15
        L15:
            e = move-exception;
            this.totalBytesWritten -= this.position - oldPosition;
            this.position = oldPosition;
            inefficientWriteStringNoTag(value, e);
            return;
        L13:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            flush();
            this.out.write(value, offset, length);
            this.totalBytesWritten += length;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            flush();
            this.out.writeLazy(value, offset, length);
            this.totalBytesWritten += length;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            flush();
            int length = value.remaining();
            this.out.write(value);
            this.totalBytesWritten += length;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            flush();
            int length = value.remaining();
            this.out.writeLazy(value);
            this.totalBytesWritten += length;
        }

        private void flushIfNotAvailable(int requiredSize) throws IOException {
            if ((this.limit - this.position) >= requiredSize) goto L6;
            doFlush();
            return;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream.ArrayEncoder, com.bytedance.location.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String explanationMessage) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + explanationMessage);
        }

        OutOfSpaceException(Throwable cause) {
            super(MESSAGE, cause);
        }

        OutOfSpaceException(String explanationMessage, Throwable cause) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + explanationMessage, cause);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream out, int bufferSize) {
            super(bufferSize);
            if (out == null) goto L7;
            this.out = out;
            return;
        L7:
            throw new NullPointerException("out");
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeTag(int fieldNumber, int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32(int fieldNumber, int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(fieldNumber, 5);
            bufferFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(fieldNumber, 1);
            bufferFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r2, 0);
            buffer(r3 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeString(int fieldNumber, String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer duplicated = value.duplicate();
            duplicated.clear();
            write(duplicated);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessage(int fieldNumber, MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessage(int fieldNumber, MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int value) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long value) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            int maxLength = value.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L6
            int maxLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(maxLength);     // Catch: Utf8.UnpairedSurrogateException -> L6
            if ((maxLengthVarIntSize + maxLength) <= this.limit) goto L9;
            byte[] encodedBytes = new byte[maxLength];     // Catch: Utf8.UnpairedSurrogateException -> L6
            int actualLength = Utf8.encode(value, encodedBytes, 0, maxLength);     // Catch: Utf8.UnpairedSurrogateException -> L6
            writeUInt32NoTag(actualLength);     // Catch: Utf8.UnpairedSurrogateException -> L6
            writeLazy(encodedBytes, 0, actualLength);     // Catch: Utf8.UnpairedSurrogateException -> L6
            return;
        L9:
            if ((maxLengthVarIntSize + maxLength) <= (this.limit - this.position)) goto L11;
            doFlush();     // Catch: Utf8.UnpairedSurrogateException -> L6
        L11:
            int minLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(value.length());     // Catch: Utf8.UnpairedSurrogateException -> L6
            int oldPosition = this.position;     // Catch: Utf8.UnpairedSurrogateException -> L6
            if (minLengthVarIntSize == maxLengthVarIntSize) goto L14;
            int length = Utf8.encodedLength(value);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            bufferUInt32NoTag(length);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            this.position = Utf8.encode(value, this.buffer, this.position, length);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
        L20:
            this.totalBytesWritten += length;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
        L32:
            return;
        L14:
            this.position = oldPosition + minLengthVarIntSize;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            int newPosition = Utf8.encode(value, this.buffer, this.position, this.limit - this.position);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            this.position = oldPosition;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            length = (newPosition - oldPosition) - minLengthVarIntSize;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            bufferUInt32NoTag(length);     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
            this.position = newPosition;     // Catch: ArrayIndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L17
        L17:
            e = move-exception;
            this.totalBytesWritten -= this.position - oldPosition;     // Catch: Utf8.UnpairedSurrogateException -> L6
            this.position = oldPosition;     // Catch: Utf8.UnpairedSurrogateException -> L6
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L6
        L15:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L6
        L6:
            e = move-exception;
            inefficientWriteStringNoTag(value, e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            if ((this.limit - this.position) < length) goto L5;
            System.arraycopy(value, offset, this.buffer, this.position, length);
            this.position += length;
            this.totalBytesWritten += length;
            return;
        L5:
            int bytesWritten = this.limit - this.position;
            System.arraycopy(value, offset, this.buffer, this.position, bytesWritten);
            int offset2 = offset + bytesWritten;
            int length2 = length - bytesWritten;
            this.position = this.limit;
            this.totalBytesWritten += bytesWritten;
            doFlush();
            if (length2 > this.limit) goto L8;
            System.arraycopy(value, offset2, this.buffer, 0, length2);
            this.position = length2;
        L9:
            this.totalBytesWritten += length2;
            return;
        L8:
            this.out.write(value, offset2, length2);
            goto L9
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            int length = value.remaining();
            if ((this.limit - this.position) < length) goto L5;
            value.get(this.buffer, this.position, length);
            this.position += length;
            this.totalBytesWritten += length;
            return;
        L5:
            int bytesWritten = this.limit - this.position;
            value.get(this.buffer, this.position, bytesWritten);
            int length2 = length - bytesWritten;
            this.position = this.limit;
            this.totalBytesWritten += bytesWritten;
            doFlush();
        L7:
            if (length2 <= this.limit) goto L9;
            value.get(this.buffer, 0, this.limit);
            this.out.write(this.buffer, 0, this.limit);
            length2 = length2 - this.limit;
            this.totalBytesWritten += this.limit;
            goto L7
        L9:
            value.get(this.buffer, 0, length2);
            this.position = length2;
            this.totalBytesWritten += length2;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        private void flushIfNotAvailable(int requiredSize) throws IOException {
            if ((this.limit - this.position) >= requiredSize) goto L6;
            doFlush();
            return;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer buffer) {
            super(null);
            this.originalBuffer = buffer;
            this.buffer = buffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = buffer.position();
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeTag(int fieldNumber, int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 5);
            writeFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 1);
            writeFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeString(int fieldNumber, String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessage(int fieldNumber, MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessage(int fieldNumber, MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            this.buffer.put(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer duplicated = value.duplicate();
            duplicated.clear();
            write(duplicated);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
        L3:
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) == 0) goto L4;
            this.buffer.put((byte) ((value & 127) | 128));     // Catch: BufferOverflowException -> L6
            value = value >>> 7;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) value);     // Catch: BufferOverflowException -> L6
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int value) throws IOException {
            this.buffer.putInt(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
        L3:
            if (((-128) & value) == 0) goto L4;
            this.buffer.put((byte) ((((int) value) & 127) | 128));     // Catch: BufferOverflowException -> L6
            value = value >>> 7;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) value);     // Catch: BufferOverflowException -> L6
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long value) throws IOException {
            this.buffer.putLong(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            this.buffer.put(value, offset, length);     // Catch: BufferOverflowException -> L4 IndexOutOfBoundsException -> L6
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            this.buffer.put(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            int startPos = this.buffer.position();
            int maxEncodedSize = value.length() * 3;     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            int maxLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(maxEncodedSize);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            int minLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(value.length());     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            if (minLengthVarIntSize != maxLengthVarIntSize) goto L10;
            int startOfBytes = this.buffer.position() + minLengthVarIntSize;     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.buffer.position(startOfBytes);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            encode(value);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            int endOfBytes = this.buffer.position();     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.buffer.position(startPos);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            writeUInt32NoTag(endOfBytes - startOfBytes);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            this.buffer.position(endOfBytes);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
        L16:
            return;
        L10:
            int length = Utf8.encodedLength(value);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            writeUInt32NoTag(length);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
            encode(value);     // Catch: IllegalArgumentException -> L6 Utf8.UnpairedSurrogateException -> L8
        L8:
            e = move-exception;
            this.buffer.position(startPos);
            inefficientWriteStringNoTag(value, e);
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        private void encode(String value) throws IOException {
            Utf8.encodeUtf8(value, this.buffer);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer buffer) {
            super(null);
            this.originalBuffer = buffer;
            this.buffer = buffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.address = UnsafeUtil.addressOffset(buffer);
            this.initialPosition = this.address + ((long) buffer.position());
            this.limit = this.address + ((long) buffer.limit());
            this.oneVarintLimit = this.limit - 10;
            this.position = this.initialPosition;
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeTag(int fieldNumber, int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 5);
            writeFixed32NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 1);
            writeFixed64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeString(int fieldNumber, String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessage(int fieldNumber, MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessage(int fieldNumber, MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            if (this.position >= this.limit) goto L7;
            long r0 = this.position;
            this.position = 1 + r0;
            UnsafeUtil.putByte(r0, value);
            return;
        L7:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer duplicated = value.duplicate();
            duplicated.clear();
            write(duplicated);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
            if (this.position > this.oneVarintLimit) goto L10;
        L5:
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) == 0) goto L6;
            long r3 = this.position;
            this.position = r3 + 1;
            UnsafeUtil.putByte(r3, (byte) ((value & 127) | 128));
            value = value >>> 7;
            goto L5
        L6:
            long r4 = this.position;
            this.position = 1 + r4;
            UnsafeUtil.putByte(r4, (byte) value);
            return;
        L10:
            if (this.position >= this.limit) goto L17;
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) == 0) goto L13;
            long r5 = this.position;
            this.position = r5 + 1;
            UnsafeUtil.putByte(r5, (byte) ((value & 127) | 128));
            value = value >>> 7;
            goto L10
        L13:
            long r6 = this.position;
            this.position = 1 + r6;
            UnsafeUtil.putByte(r6, (byte) value);
            return;
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int value) throws IOException {
            this.buffer.putInt(bufferPos(this.position), value);
            this.position += 4;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
            if (this.position > this.oneVarintLimit) goto L10;
        L5:
            if ((value & (-128)) == 0) goto L6;
            long r8 = this.position;
            this.position = r8 + 1;
            UnsafeUtil.putByte(r8, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L5
        L6:
            long r0 = this.position;
            this.position = 1 + r0;
            UnsafeUtil.putByte(r0, (byte) value);
            return;
        L10:
            if (this.position >= this.limit) goto L17;
            if ((value & (-128)) == 0) goto L13;
            long r9 = this.position;
            this.position = r9 + 1;
            UnsafeUtil.putByte(r9, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L10
        L13:
            long r1 = this.position;
            this.position = 1 + r1;
            UnsafeUtil.putByte(r1, (byte) value);
            return;
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long value) throws IOException {
            this.buffer.putLong(bufferPos(this.position), value);
            this.position += 8;
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            if (value == null) goto L13;
            if (offset < 0) goto L13;
            if (length < 0) goto L13;
            if ((value.length - length) < offset) goto L13;
            if ((this.limit - ((long) length)) < this.position) goto L13;
            UnsafeUtil.copyMemory(value, offset, this.position, length);
            this.position += (long) length;
            return;
        L13:
            if (value != null) goto L17;
            throw new NullPointerException("value");
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(length)}));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            int length = value.remaining();     // Catch: BufferOverflowException -> L4
            repositionBuffer(this.position);     // Catch: BufferOverflowException -> L4
            this.buffer.put(value);     // Catch: BufferOverflowException -> L4
            this.position += (long) length;     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream, com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            long prevPos = this.position;
            int maxEncodedSize = value.length() * 3;     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            int maxLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(maxEncodedSize);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            int minLengthVarIntSize = CodedOutputStream.computeUInt32SizeNoTag(value.length());     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            if (minLengthVarIntSize != maxLengthVarIntSize) goto L12;
            int stringStart = bufferPos(this.position) + minLengthVarIntSize;     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            this.buffer.position(stringStart);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            Utf8.encodeUtf8(value, this.buffer);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            int length = this.buffer.position() - stringStart;     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            writeUInt32NoTag(length);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            this.position += (long) length;     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
        L20:
            return;
        L12:
            int length2 = Utf8.encodedLength(value);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            writeUInt32NoTag(length2);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            repositionBuffer(this.position);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            Utf8.encodeUtf8(value, this.buffer);     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
            this.position += (long) length2;     // Catch: IndexOutOfBoundsException -> L6 IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L10
        L10:
            e = move-exception;
            this.position = prevPos;
            repositionBuffer(this.position);
            inefficientWriteStringNoTag(value, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L6:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.bytedance.location.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        private void repositionBuffer(long pos) {
            this.buffer.position(bufferPos(pos));
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public abstract int spaceLeft();

    @Override // com.bytedance.location.protobuf.ByteOutput
    public abstract void write(byte r1) throws IOException;

    @Override // com.bytedance.location.protobuf.ByteOutput
    public abstract void write(ByteBuffer r1) throws IOException;

    @Override // com.bytedance.location.protobuf.ByteOutput
    public abstract void write(byte[] r1, int r2, int r3) throws IOException;

    public abstract void writeBool(int r1, boolean r2) throws IOException;

    public abstract void writeByteArray(int r1, byte[] r2) throws IOException;

    public abstract void writeByteArray(int r1, byte[] r2, int r3, int r4) throws IOException;

    abstract void writeByteArrayNoTag(byte[] r1, int r2, int r3) throws IOException;

    public abstract void writeByteBuffer(int r1, ByteBuffer r2) throws IOException;

    public abstract void writeBytes(int r1, ByteString r2) throws IOException;

    public abstract void writeBytesNoTag(ByteString r1) throws IOException;

    public abstract void writeFixed32(int r1, int r2) throws IOException;

    public abstract void writeFixed32NoTag(int r1) throws IOException;

    public abstract void writeFixed64(int r1, long r2) throws IOException;

    public abstract void writeFixed64NoTag(long r1) throws IOException;

    public abstract void writeInt32(int r1, int r2) throws IOException;

    public abstract void writeInt32NoTag(int r1) throws IOException;

    @Override // com.bytedance.location.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer r1) throws IOException;

    @Override // com.bytedance.location.protobuf.ByteOutput
    public abstract void writeLazy(byte[] r1, int r2, int r3) throws IOException;

    public abstract void writeMessage(int r1, MessageLite r2) throws IOException;

    abstract void writeMessage(int r1, MessageLite r2, Schema r3) throws IOException;

    public abstract void writeMessageNoTag(MessageLite r1) throws IOException;

    abstract void writeMessageNoTag(MessageLite r1, Schema r2) throws IOException;

    public abstract void writeMessageSetExtension(int r1, MessageLite r2) throws IOException;

    public abstract void writeRawBytes(ByteBuffer r1) throws IOException;

    public abstract void writeRawMessageSetExtension(int r1, ByteString r2) throws IOException;

    public abstract void writeString(int r1, String r2) throws IOException;

    public abstract void writeStringNoTag(String r1) throws IOException;

    public abstract void writeTag(int r1, int r2) throws IOException;

    public abstract void writeUInt32(int r1, int r2) throws IOException;

    public abstract void writeUInt32NoTag(int r1) throws IOException;

    public abstract void writeUInt64(int r1, long r2) throws IOException;

    public abstract void writeUInt64NoTag(long r1) throws IOException;

    /* synthetic */ CodedOutputStream(AnonymousClass1 x0) {
        this();
    }

    static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static {
        logger = Logger.getLogger(CodedOutputStream.class.getName());
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    }

    static int computePreferredBufferSize(int dataLength) {
        if (dataLength <= 4096) goto L5;
        return 4096;
    L5:
        return dataLength;
    }

    public static CodedOutputStream newInstance(OutputStream output) {
        return newInstance(output, 4096);
    }

    public static CodedOutputStream newInstance(OutputStream output, int bufferSize) {
        return new OutputStreamEncoder(output, bufferSize);
    }

    public static CodedOutputStream newInstance(byte[] flatArray) {
        return newInstance(flatArray, 0, flatArray.length);
    }

    public static CodedOutputStream newInstance(byte[] flatArray, int offset, int length) {
        return new ArrayEncoder(flatArray, offset, length);
    }

    public static CodedOutputStream newInstance(ByteBuffer buffer) {
        if (buffer.hasArray() == false) goto L7;
        return new HeapNioEncoder(buffer);
    L7:
        if (buffer.isDirect() == false) goto L16;
        if (buffer.isReadOnly() == true) goto L16;
        if (UnsafeDirectNioEncoder.isSupported() == false) goto L14;
        return newUnsafeInstance(buffer);
    L14:
        return newSafeInstance(buffer);
    L16:
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer buffer) {
        return new UnsafeDirectNioEncoder(buffer);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer buffer) {
        return new SafeDirectNioEncoder(buffer);
    }

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int unused) {
        return newInstance(byteBuffer);
    }

    static CodedOutputStream newInstance(ByteOutput byteOutput, int bufferSize) {
        if (bufferSize < 0) goto L6;
        return new ByteOutputEncoder(byteOutput, bufferSize);
    L6:
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    private CodedOutputStream() {
    }

    public final void writeSInt32(int fieldNumber, int value) throws IOException {
        writeUInt32(fieldNumber, encodeZigZag32(value));
    }

    public final void writeSFixed32(int fieldNumber, int value) throws IOException {
        writeFixed32(fieldNumber, value);
    }

    public final void writeInt64(int fieldNumber, long value) throws IOException {
        writeUInt64(fieldNumber, value);
    }

    public final void writeSInt64(int fieldNumber, long value) throws IOException {
        writeUInt64(fieldNumber, encodeZigZag64(value));
    }

    public final void writeSFixed64(int fieldNumber, long value) throws IOException {
        writeFixed64(fieldNumber, value);
    }

    public final void writeFloat(int fieldNumber, float value) throws IOException {
        writeFixed32(fieldNumber, Float.floatToRawIntBits(value));
    }

    public final void writeDouble(int fieldNumber, double value) throws IOException {
        writeFixed64(fieldNumber, Double.doubleToRawLongBits(value));
    }

    public final void writeEnum(int fieldNumber, int value) throws IOException {
        writeInt32(fieldNumber, value);
    }

    public final void writeRawByte(byte value) throws IOException {
        write(value);
    }

    public final void writeRawByte(int value) throws IOException {
        write((byte) value);
    }

    public final void writeRawBytes(byte[] value) throws IOException {
        write(value, 0, value.length);
    }

    public final void writeRawBytes(byte[] value, int offset, int length) throws IOException {
        write(value, offset, length);
    }

    public final void writeRawBytes(ByteString value) throws IOException {
        value.writeTo(this);
    }

    public final void writeSInt32NoTag(int value) throws IOException {
        writeUInt32NoTag(encodeZigZag32(value));
    }

    public final void writeSFixed32NoTag(int value) throws IOException {
        writeFixed32NoTag(value);
    }

    public final void writeInt64NoTag(long value) throws IOException {
        writeUInt64NoTag(value);
    }

    public final void writeSInt64NoTag(long value) throws IOException {
        writeUInt64NoTag(encodeZigZag64(value));
    }

    public final void writeSFixed64NoTag(long value) throws IOException {
        writeFixed64NoTag(value);
    }

    public final void writeFloatNoTag(float value) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(value));
    }

    public final void writeDoubleNoTag(double value) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(value));
    }

    public final void writeBoolNoTag(boolean r2) throws IOException {
        write(r2 ? 1 : 0);
    }

    public final void writeEnumNoTag(int value) throws IOException {
        writeInt32NoTag(value);
    }

    public final void writeByteArrayNoTag(byte[] value) throws IOException {
        writeByteArrayNoTag(value, 0, value.length);
    }

    public static int computeInt32Size(int fieldNumber, int value) {
        return computeTagSize(fieldNumber) + computeInt32SizeNoTag(value);
    }

    public static int computeUInt32Size(int fieldNumber, int value) {
        return computeTagSize(fieldNumber) + computeUInt32SizeNoTag(value);
    }

    public static int computeSInt32Size(int fieldNumber, int value) {
        return computeTagSize(fieldNumber) + computeSInt32SizeNoTag(value);
    }

    public static int computeFixed32Size(int fieldNumber, int value) {
        return computeTagSize(fieldNumber) + computeFixed32SizeNoTag(value);
    }

    public static int computeSFixed32Size(int fieldNumber, int value) {
        return computeTagSize(fieldNumber) + computeSFixed32SizeNoTag(value);
    }

    public static int computeInt64Size(int fieldNumber, long value) {
        return computeTagSize(fieldNumber) + computeInt64SizeNoTag(value);
    }

    public static int computeUInt64Size(int fieldNumber, long value) {
        return computeTagSize(fieldNumber) + computeUInt64SizeNoTag(value);
    }

    public static int computeSInt64Size(int fieldNumber, long value) {
        return computeTagSize(fieldNumber) + computeSInt64SizeNoTag(value);
    }

    public static int computeFixed64Size(int fieldNumber, long value) {
        return computeTagSize(fieldNumber) + computeFixed64SizeNoTag(value);
    }

    public static int computeSFixed64Size(int fieldNumber, long value) {
        return computeTagSize(fieldNumber) + computeSFixed64SizeNoTag(value);
    }

    public static int computeFloatSize(int fieldNumber, float value) {
        return computeTagSize(fieldNumber) + computeFloatSizeNoTag(value);
    }

    public static int computeDoubleSize(int fieldNumber, double value) {
        return computeTagSize(fieldNumber) + computeDoubleSizeNoTag(value);
    }

    public static int computeBoolSize(int fieldNumber, boolean value) {
        return computeTagSize(fieldNumber) + computeBoolSizeNoTag(value);
    }

    public static int computeEnumSize(int fieldNumber, int value) {
        return computeTagSize(fieldNumber) + computeEnumSizeNoTag(value);
    }

    public static int computeStringSize(int fieldNumber, String value) {
        return computeTagSize(fieldNumber) + computeStringSizeNoTag(value);
    }

    public static int computeBytesSize(int fieldNumber, ByteString value) {
        return computeTagSize(fieldNumber) + computeBytesSizeNoTag(value);
    }

    public static int computeByteArraySize(int fieldNumber, byte[] value) {
        return computeTagSize(fieldNumber) + computeByteArraySizeNoTag(value);
    }

    public static int computeByteBufferSize(int fieldNumber, ByteBuffer value) {
        return computeTagSize(fieldNumber) + computeByteBufferSizeNoTag(value);
    }

    public static int computeLazyFieldSize(int fieldNumber, LazyFieldLite value) {
        return computeTagSize(fieldNumber) + computeLazyFieldSizeNoTag(value);
    }

    public static int computeMessageSize(int fieldNumber, MessageLite value) {
        return computeTagSize(fieldNumber) + computeMessageSizeNoTag(value);
    }

    static int computeMessageSize(int fieldNumber, MessageLite value, Schema schema) {
        return computeTagSize(fieldNumber) + computeMessageSizeNoTag(value, schema);
    }

    public static int computeMessageSetExtensionSize(int fieldNumber, MessageLite value) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, fieldNumber)) + computeMessageSize(3, value);
    }

    public static int computeRawMessageSetExtensionSize(int fieldNumber, ByteString value) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, fieldNumber)) + computeBytesSize(3, value);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int fieldNumber, LazyFieldLite value) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, fieldNumber)) + computeLazyFieldSize(3, value);
    }

    public static int computeTagSize(int fieldNumber) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(fieldNumber, 0));
    }

    public static int computeInt32SizeNoTag(int value) {
        if (value >= 0) goto L4;
        return 10;
    L4:
        return computeUInt32SizeNoTag(value);
    }

    public static int computeUInt32SizeNoTag(int value) {
        if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) != 0) goto L7;
        return 1;
    L7:
        if ((value & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & value) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & value) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeSInt32SizeNoTag(int value) {
        return computeUInt32SizeNoTag(encodeZigZag32(value));
    }

    public static int computeFixed32SizeNoTag(int unused) {
        return 4;
    }

    public static int computeSFixed32SizeNoTag(int unused) {
        return 4;
    }

    public static int computeInt64SizeNoTag(long value) {
        return computeUInt64SizeNoTag(value);
    }

    public static int computeUInt64SizeNoTag(long value) {
        if (((-128) & value) != 0) goto L7;
        return 1;
    L7:
        if (value >= 0) goto L10;
        return 10;
    L10:
        int n = 2;
        if (((-34359738368L) & value) == 0) goto L14;
        n = 2 + 4;
        value = value >>> 28;
    L14:
        if (((-2097152) & value) == 0) goto L17;
        n = n + 2;
        value = value >>> 14;
    L17:
        if (((-16384) & value) != 0) goto L19;
        return n;
    L19:
        return n + 1;
    }

    public static int computeSInt64SizeNoTag(long value) {
        return computeUInt64SizeNoTag(encodeZigZag64(value));
    }

    public static int computeFixed64SizeNoTag(long unused) {
        return 8;
    }

    public static int computeSFixed64SizeNoTag(long unused) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float unused) {
        return 4;
    }

    public static int computeDoubleSizeNoTag(double unused) {
        return 8;
    }

    public static int computeBoolSizeNoTag(boolean unused) {
        return 1;
    }

    public static int computeEnumSizeNoTag(int value) {
        return computeInt32SizeNoTag(value);
    }

    public static int computeStringSizeNoTag(String value) {
        int length = Utf8.encodedLength(value);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L7:
        return computeLengthDelimitedFieldSize(length);
    L5:
        byte[] bytes = value.getBytes(Internal.UTF_8);
        length = bytes.length;
        goto L7
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite value) {
        return computeLengthDelimitedFieldSize(value.getSerializedSize());
    }

    public static int computeBytesSizeNoTag(ByteString value) {
        return computeLengthDelimitedFieldSize(value.size());
    }

    public static int computeByteArraySizeNoTag(byte[] value) {
        return computeLengthDelimitedFieldSize(value.length);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer value) {
        return computeLengthDelimitedFieldSize(value.capacity());
    }

    public static int computeMessageSizeNoTag(MessageLite value) {
        return computeLengthDelimitedFieldSize(value.getSerializedSize());
    }

    static int computeMessageSizeNoTag(MessageLite value, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) value).getSerializedSize(schema));
    }

    static int computeLengthDelimitedFieldSize(int fieldLength) {
        return computeUInt32SizeNoTag(fieldLength) + fieldLength;
    }

    public static int encodeZigZag32(int n) {
        return (n << 1) ^ (n >> 31);
    }

    public static long encodeZigZag64(long n) {
        return (n << 1) ^ (n >> 63);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    final void inefficientWriteStringNoTag(String value, Utf8.UnpairedSurrogateException cause) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", cause);
        byte[] bytes = value.getBytes(Internal.UTF_8);
        writeUInt32NoTag(bytes.length);     // Catch: IndexOutOfBoundsException -> L5
        writeLazy(bytes, 0, bytes.length);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    @Deprecated
    public final void writeGroup(int fieldNumber, MessageLite value) throws IOException {
        writeTag(fieldNumber, 3);
        writeGroupNoTag(value);
        writeTag(fieldNumber, 4);
    }

    @Deprecated
    final void writeGroup(int fieldNumber, MessageLite value, Schema schema) throws IOException {
        writeTag(fieldNumber, 3);
        writeGroupNoTag(value, schema);
        writeTag(fieldNumber, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite value) throws IOException {
        value.writeTo(this);
    }

    @Deprecated
    final void writeGroupNoTag(MessageLite value, Schema schema) throws IOException {
        schema.writeTo(value, this.wrapper);
    }

    @Deprecated
    public static int computeGroupSize(int fieldNumber, MessageLite value) {
        return (computeTagSize(fieldNumber) * 2) + value.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSize(int fieldNumber, MessageLite value, Schema schema) {
        return (computeTagSize(fieldNumber) * 2) + computeGroupSizeNoTag(value, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite value) {
        return value.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite value, Schema schema) {
        return ((AbstractMessageLite) value).getSerializedSize(schema);
    }

    @Deprecated
    public final void writeRawVarint32(int value) throws IOException {
        writeUInt32NoTag(value);
    }

    @Deprecated
    public final void writeRawVarint64(long value) throws IOException {
        writeUInt64NoTag(value);
    }

    @Deprecated
    public static int computeRawVarint32Size(int value) {
        return computeUInt32SizeNoTag(value);
    }

    @Deprecated
    public static int computeRawVarint64Size(long value) {
        return computeUInt64SizeNoTag(value);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int value) throws IOException {
        writeFixed32NoTag(value);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long value) throws IOException {
        writeFixed64NoTag(value);
    }
}
