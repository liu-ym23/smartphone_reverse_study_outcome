package com.bytedance.location.protobuf;

import com.android.internal.util.FrameworkStatsLog;
import com.android.server.SystemService;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.BinaryWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L59:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L63:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L77:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L55:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L61:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L57:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
            return;
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newDirectBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer() == false) goto L11;
            ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
            if (nioBuffer.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = nioBuffer;
            this.buffer.limit(this.buffer.capacity());
            this.buffer.position(0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            this.limitMinusOne = this.buffer.limit() - 1;
            this.pos = this.limitMinusOne;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            this.buffer.position(this.pos + 1);
            this.buffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeString(int fieldNumber, String value) {
            int prevBytes = getTotalBytesWritten();
            writeString(value);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int prevBytes = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int prevBytes = getTotalBytesWritten();
            schema.writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        @Deprecated
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeBool(boolean r2) {
            write(r2 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) value);
        }

        private void writeVarint32TwoBytes(int value) {
            this.pos -= 2;
            this.buffer.putShort(this.pos + 1, (short) (((value & 16256) << 1) | ((value & 127) | 128)));
        }

        private void writeVarint32ThreeBytes(int value) {
            this.pos -= 3;
            this.buffer.putInt(this.pos, (((2080768 & value) << 10) | (((value & 16256) | 16384) << 9)) | (((value & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int value) {
            this.pos -= 4;
            this.buffer.putInt(this.pos + 1, ((((266338304 & value) << 3) | (((2080768 & value) | 2097152) << 2)) | (((value & 16256) | 16384) << 1)) | ((value & 127) | 128));
        }

        private void writeVarint32FiveBytes(int value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (value >>> 28));
            this.pos -= 4;
            this.buffer.putInt(this.pos + 1, ((((((value >>> 21) & 127) | 128) << 24) | ((((value >>> 14) & 127) | 128) << 16)) | ((((value >>> 7) & 127) | 128) << 8)) | ((value & 127) | 128));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            writeVarint32OneByte((int) value);
        }

        private void writeVarint64TwoBytes(long value) {
            writeVarint32TwoBytes((int) value);
        }

        private void writeVarint64ThreeBytes(long value) {
            writeVarint32ThreeBytes((int) value);
        }

        private void writeVarint64FourBytes(long value) {
            writeVarint32FourBytes((int) value);
        }

        private void writeVarint64FiveBytes(long value) {
            this.pos -= 5;
            this.buffer.putLong(this.pos - 2, (((((34091302912L & value) << 28) | (((266338304 & value) | 268435456) << 27)) | (((2080768 & value) | 2097152) << 26)) | (((16256 & value) | 16384) << 25)) | (((127 & value) | 128) << 24));
        }

        private void writeVarint64SixBytes(long value) {
            this.pos -= 6;
            this.buffer.putLong(this.pos - 1, ((((((4363686772736L & value) << 21) | (((34091302912L & value) | 34359738368L) << 20)) | (((266338304 & value) | 268435456) << 19)) | (((2080768 & value) | 2097152) << 18)) | (((16256 & value) | 16384) << 17)) | (((127 & value) | 128) << 16));
        }

        private void writeVarint64SevenBytes(long value) {
            this.pos -= 7;
            this.buffer.putLong(this.pos, (((((((558551906910208L & value) << 14) | (((4363686772736L & value) | 4398046511104L) << 13)) | (((34091302912L & value) | 34359738368L) << 12)) | (((266338304 & value) | 268435456) << 11)) | (((2080768 & value) | 2097152) << 10)) | (((16256 & value) | 16384) << 9)) | (((127 & value) | 128) << 8));
        }

        private void writeVarint64EightBytes(long value) {
            this.pos -= 8;
            this.buffer.putLong(this.pos + 1, ((((((((71494644084506624L & value) << 7) | (((558551906910208L & value) | 562949953421312L) << 6)) | (((4363686772736L & value) | 4398046511104L) << 5)) | (((34091302912L & value) | 34359738368L) << 4)) | (((266338304 & value) | 268435456) << 3)) | (((2080768 & value) | 2097152) << 2)) | (((16256 & value) | 16384) << 1)) | ((127 & value) | 128));
        }

        private void writeVarint64EightBytesWithSign(long value) {
            this.pos -= 8;
            this.buffer.putLong(this.pos + 1, (((((((((71494644084506624L & value) | 72057594037927936L) << 7) | (((558551906910208L & value) | 562949953421312L) << 6)) | (((4363686772736L & value) | 4398046511104L) << 5)) | (((34091302912L & value) | 34359738368L) << 4)) | (((266338304 & value) | 268435456) << 3)) | (((2080768 & value) | 2097152) << 2)) | (((16256 & value) | 16384) << 1)) | ((127 & value) | 128));
        }

        private void writeVarint64NineBytes(long value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (value >>> 56));
            writeVarint64EightBytesWithSign(72057594037927935L & value);
        }

        private void writeVarint64TenBytes(long value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (value >>> 63));
            ByteBuffer r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2.put(r3, (byte) (((value >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(72057594037927935L & value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed32(int value) {
            this.pos -= 4;
            this.buffer.putInt(this.pos + 1, value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed64(long value) {
            this.pos -= 8;
            this.buffer.putLong(this.pos + 1, value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int i = in.length() - 1;
            this.pos -= i;
        L4:
            if (i < 0) goto L9;
            char c = in.charAt(i);
            if (c >= 128) goto L9;
            this.buffer.put(this.pos + i, (byte) c);
            i = i - 1;
        L9:
            if (i != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += i;
        L13:
            if (i < 0) goto L42;
            char c2 = in.charAt(i);
            if (c2 >= 128) goto L20;
            if (this.pos < 0) goto L20;
            ByteBuffer r5 = this.buffer;
            int r6 = this.pos;
            this.pos = r6 - 1;
            r5.put(r6, (byte) c2);
        L41:
            i = i - 1;
        L20:
            if (c2 >= 2048) goto L25;
            if (this.pos <= 0) goto L25;
            ByteBuffer r7 = this.buffer;
            int r8 = this.pos;
            this.pos = r8 - 1;
            r7.put(r8, (byte) ((c2 & '?') | 128));
            ByteBuffer r9 = this.buffer;
            int r10 = this.pos;
            this.pos = r10 - 1;
            r9.put(r10, (byte) ((c2 >>> 6) | 960));
        L25:
            if (c2 < 55296) goto L29;
            if (57343 < c2) goto L29;
        L32:
            if (this.pos > 2) goto L34;
            requireSpace(i);
            i = i + 1;
            goto L41
        L34:
            if (i == 0) goto L39;
            char high = in.charAt(i - 1);
            if (Character.isSurrogatePair(high, c2) == false) goto L39;
            i = i - 1;
            int codePoint = Character.toCodePoint(high, c2);
            ByteBuffer r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11.put(r12, (byte) ((codePoint & 63) | 128));
            ByteBuffer r13 = this.buffer;
            int r14 = this.pos;
            this.pos = r14 - 1;
            r13.put(r14, (byte) (((codePoint >>> 6) & 63) | 128));
            ByteBuffer r15 = this.buffer;
            int r16 = this.pos;
            this.pos = r16 - 1;
            r15.put(r16, (byte) (((codePoint >>> 12) & 63) | 128));
            ByteBuffer r17 = this.buffer;
            int r18 = this.pos;
            this.pos = r18 - 1;
            r17.put(r18, (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));
        L39:
            throw new Utf8.UnpairedSurrogateException(i - 1, i);
        L29:
            if (this.pos <= 1) goto L32;
            ByteBuffer r19 = this.buffer;
            int r20 = this.pos;
            this.pos = r20 - 1;
            r19.put(r20, (byte) ((c2 & '?') | 128));
            ByteBuffer r21 = this.buffer;
            int r22 = this.pos;
            this.pos = r22 - 1;
            r21.put(r22, (byte) (((c2 >>> 6) & 63) | 128));
            ByteBuffer r23 = this.buffer;
            int r24 = this.pos;
            this.pos = r24 - 1;
            r23.put(r24, (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY));
            goto L41
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, value);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= length;
            this.buffer.position(this.pos + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L6:
            this.pos -= length;
            this.buffer.position(this.pos + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= length;
            this.buffer.position(this.pos + 1);
            this.buffer.put(value);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
            return;
        L6:
            this.pos -= length;
            this.buffer.position(this.pos + 1);
            this.buffer.put(value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            this.allocatedBuffer.position((this.pos - this.allocatedBuffer.arrayOffset()) + 1);
            this.allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newHeapBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            int arrayOffset = allocatedBuffer.arrayOffset();
            this.limit = allocatedBuffer.limit() + arrayOffset;
            this.offset = allocatedBuffer.position() + arrayOffset;
            this.offsetMinusOne = this.offset - 1;
            this.limitMinusOne = this.limit - 1;
            this.pos = this.limitMinusOne;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) throws IOException {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) throws IOException {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) throws IOException {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBool(int r2, boolean r3) throws IOException {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeString(int fieldNumber, String value) throws IOException {
            int prevBytes = getTotalBytesWritten();
            writeString(value);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int prevBytes = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int prevBytes = getTotalBytesWritten();
            schema.writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        @Deprecated
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeBool(boolean r2) {
            write(r2 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) value;
        }

        private void writeVarint32TwoBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 7);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) ((value & 127) | 128);
        }

        private void writeVarint32ThreeBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 14);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) ((value & 127) | 128);
        }

        private void writeVarint32FourBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 21);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) ((value & 127) | 128);
        }

        private void writeVarint32FiveBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 28);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) ((value & 127) | 128);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) value;
        }

        private void writeVarint64TwoBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 7);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) ((((int) value) & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (((int) value) >>> 14);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64FourBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 21);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64FiveBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 28);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64SixBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 35);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 28) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64SevenBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 42);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 35) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 28) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12[r13] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64EightBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 49);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 42) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 35) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 28) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12[r13] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r14 = this.buffer;
            int r15 = this.pos;
            this.pos = r15 - 1;
            r14[r15] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64NineBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 56);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 49) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 42) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 35) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) (((value >>> 28) & 127) | 128);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12[r13] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r14 = this.buffer;
            int r15 = this.pos;
            this.pos = r15 - 1;
            r14[r15] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r16 = this.buffer;
            int r17 = this.pos;
            this.pos = r17 - 1;
            r16[r17] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64TenBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (value >>> 63);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((value >>> 56) & 127) | 128);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((value >>> 49) & 127) | 128);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((value >>> 42) & 127) | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) (((value >>> 35) & 127) | 128);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) (((value >>> 28) & 127) | 128);
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12[r13] = (byte) (((value >>> 21) & 127) | 128);
            byte[] r14 = this.buffer;
            int r15 = this.pos;
            this.pos = r15 - 1;
            r14[r15] = (byte) (((value >>> 14) & 127) | 128);
            byte[] r16 = this.buffer;
            int r17 = this.pos;
            this.pos = r17 - 1;
            r16[r17] = (byte) (((value >>> 7) & 127) | 128);
            byte[] r18 = this.buffer;
            int r19 = this.pos;
            this.pos = r19 - 1;
            r18[r19] = (byte) ((value & 127) | 128);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed32(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) ((value >> 24) & 255);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) ((value >> 16) & 255);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) ((value >> 8) & 255);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (value & 255);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed64(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) (((int) (value >> 56)) & 255);
            byte[] r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2[r3] = (byte) (((int) (value >> 48)) & 255);
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) (((int) (value >> 40)) & 255);
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) (((int) (value >> 32)) & 255);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) (((int) (value >> 24)) & 255);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) (((int) (value >> 16)) & 255);
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12[r13] = (byte) (((int) (value >> 8)) & 255);
            byte[] r14 = this.buffer;
            int r15 = this.pos;
            this.pos = r15 - 1;
            r14[r15] = (byte) (((int) value) & 255);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int i = in.length() - 1;
            this.pos -= i;
        L4:
            if (i < 0) goto L9;
            char c = in.charAt(i);
            if (c >= 128) goto L9;
            this.buffer[this.pos + i] = (byte) c;
            i = i - 1;
        L9:
            if (i != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += i;
        L13:
            if (i < 0) goto L42;
            char c2 = in.charAt(i);
            if (c2 >= 128) goto L20;
            if (this.pos <= this.offsetMinusOne) goto L20;
            byte[] r4 = this.buffer;
            int r5 = this.pos;
            this.pos = r5 - 1;
            r4[r5] = (byte) c2;
        L41:
            i = i - 1;
        L20:
            if (c2 >= 2048) goto L25;
            if (this.pos <= this.offset) goto L25;
            byte[] r6 = this.buffer;
            int r7 = this.pos;
            this.pos = r7 - 1;
            r6[r7] = (byte) ((c2 & '?') | 128);
            byte[] r8 = this.buffer;
            int r9 = this.pos;
            this.pos = r9 - 1;
            r8[r9] = (byte) ((c2 >>> 6) | 960);
        L25:
            if (c2 < 55296) goto L29;
            if (57343 < c2) goto L29;
        L32:
            if (this.pos > (this.offset + 2)) goto L34;
            requireSpace(i);
            i = i + 1;
            goto L41
        L34:
            if (i == 0) goto L39;
            char high = in.charAt(i - 1);
            if (Character.isSurrogatePair(high, c2) == false) goto L39;
            i = i - 1;
            int codePoint = Character.toCodePoint(high, c2);
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) ((codePoint & 63) | 128);
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12[r13] = (byte) (((codePoint >>> 6) & 63) | 128);
            byte[] r14 = this.buffer;
            int r15 = this.pos;
            this.pos = r15 - 1;
            r14[r15] = (byte) (((codePoint >>> 12) & 63) | 128);
            byte[] r16 = this.buffer;
            int r17 = this.pos;
            this.pos = r17 - 1;
            r16[r17] = (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED);
        L39:
            throw new Utf8.UnpairedSurrogateException(i - 1, i);
        L29:
            if (this.pos <= (this.offset + 1)) goto L32;
            byte[] r18 = this.buffer;
            int r19 = this.pos;
            this.pos = r19 - 1;
            r18[r19] = (byte) ((c2 & '?') | 128);
            byte[] r20 = this.buffer;
            int r21 = this.pos;
            this.pos = r21 - 1;
            r20[r21] = (byte) (((c2 >>> 6) & 63) | 128);
            byte[] r22 = this.buffer;
            int r23 = this.pos;
            this.pos = r23 - 1;
            r22[r23] = (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY);
            goto L41
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = value;
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= length;
            System.arraycopy(value, offset, this.buffer, this.pos + 1, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L6:
            this.pos -= length;
            System.arraycopy(value, offset, this.buffer, this.pos + 1, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= length;
            value.get(this.buffer, this.pos + 1, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L5;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
        L5:
            this.pos -= length;
            value.get(this.buffer, this.pos + 1, length);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        static /* synthetic */ boolean access$000() {
            return isSupported();
        }

        UnsafeDirectWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        private static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newDirectBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer() == false) goto L11;
            ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
            if (nioBuffer.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = nioBuffer;
            this.buffer.limit(this.buffer.capacity());
            this.buffer.position(0);
            this.bufferOffset = UnsafeUtil.addressOffset(this.buffer);
            this.limitMinusOne = this.bufferOffset + ((long) (this.buffer.limit() - 1));
            this.pos = this.limitMinusOne;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            this.buffer.position(bufferPos() + 1);
            this.buffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeString(int fieldNumber, String value) {
            int prevBytes = getTotalBytesWritten();
            writeString(value);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int prevBytes = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int prevBytes = getTotalBytesWritten();
            schema.writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeBool(boolean r2) {
            write(r2 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) value);
        }

        private void writeVarint32TwoBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 7));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((value & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 14));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 7) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FourBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 21));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 14) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 7) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FiveBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 28));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 21) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 14) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 7) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) ((value & 127) | 128));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) value);
        }

        private void writeVarint64TwoBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 7));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((((int) value) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (((int) value) >>> 14));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 7) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FourBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 21));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 14) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 7) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FiveBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 28));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 21) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 14) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 7) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SixBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 35));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 28) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 21) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 14) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 7) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SevenBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 42));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 35) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 28) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 21) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 14) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 7) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) ((value & 127) | 128));
        }

        private void writeVarint64EightBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 49));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 42) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 35) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 28) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 21) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 14) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((value >>> 7) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) ((value & 127) | 128));
        }

        private void writeVarint64NineBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 56));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 49) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 42) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 35) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 28) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 21) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((value >>> 14) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((value >>> 7) & 127) | 128));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) ((value & 127) | 128));
        }

        private void writeVarint64TenBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 63));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 56) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 49) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 42) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 35) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 28) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((value >>> 21) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((value >>> 14) & 127) | 128));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (((value >>> 7) & 127) | 128));
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r9, (byte) ((value & 127) | 128));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed32(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) ((value >> 24) & 255));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((value >> 16) & 255));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((value >> 8) & 255));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (value & 255));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed64(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (((int) (value >> 56)) & 255));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((int) (value >> 48)) & 255));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((int) (value >> 40)) & 255));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((int) (value >> 32)) & 255));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((int) (value >> 24)) & 255));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((int) (value >> 16)) & 255));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((int) (value >> 8)) & 255));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((int) value) & 255));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int i = in.length();
        L3:
            i = i - 1;
            if (i < 0) goto L9;
            char c = in.charAt(i);
            if (c >= 128) goto L9;
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) c);
        L9:
            if (i != (-1)) goto L11;
            return;
        L11:
            if (i < 0) goto L39;
            char c2 = in.charAt(i);
            if (c2 >= 128) goto L18;
            if (this.pos < this.bufferOffset) goto L18;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) c2);
        L38:
            i = i - 1;
        L18:
            if (c2 >= 2048) goto L23;
            if (this.pos <= this.bufferOffset) goto L23;
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) ((c2 & '?') | 128));
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r9, (byte) ((c2 >>> 6) | 960));
        L23:
            if (c2 < 55296) goto L27;
            if (57343 < c2) goto L27;
        L30:
            if (this.pos <= (this.bufferOffset + 2)) goto L37;
            if (i == 0) goto L36;
            char high = in.charAt(i - 1);
            if (Character.isSurrogatePair(high, c2) == false) goto L36;
            i = i - 1;
            int codePoint = Character.toCodePoint(high, c2);
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) ((codePoint & 63) | 128));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (((codePoint >>> 6) & 63) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((codePoint >>> 12) & 63) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));
        L36:
            throw new Utf8.UnpairedSurrogateException(i - 1, i);
        L37:
            requireSpace(i);
            i = i + 1;
        L27:
            if (this.pos <= (this.bufferOffset + 1)) goto L30;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) ((c2 & '?') | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (((c2 >>> 6) & 63) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY));
            goto L38
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, value);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= (long) length;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) length;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= (long) length;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(value);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) length;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
            this.allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newHeapBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            int arrayOffset = allocatedBuffer.arrayOffset();
            this.limit = ((long) arrayOffset) + ((long) allocatedBuffer.limit());
            this.offset = ((long) arrayOffset) + ((long) allocatedBuffer.position());
            this.offsetMinusOne = this.offset - 1;
            this.limitMinusOne = this.limit - 1;
            this.pos = this.limitMinusOne;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeString(int fieldNumber, String value) {
            int prevBytes = getTotalBytesWritten();
            writeString(value);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int prevBytes = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int prevBytes = getTotalBytesWritten();
            schema.writeTo(value, this);
            int length = getTotalBytesWritten() - prevBytes;
            requireSpace(10);
            writeVarint32(length);
            writeTag(fieldNumber, 2);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.bytedance.location.protobuf.Writer
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeBool(boolean r2) {
            write(r2 ? 1 : 0);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) value);
        }

        private void writeVarint32TwoBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 7));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((value & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 14));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 7) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FourBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 21));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 14) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 7) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FiveBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 28));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 21) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 14) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 7) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) ((value & 127) | 128));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) value);
        }

        private void writeVarint64TwoBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 7));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((((int) value) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (((int) value) >>> 14));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 7) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FourBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 21));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 14) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 7) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FiveBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 28));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 21) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 14) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 7) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SixBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 35));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 28) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 21) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 14) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 7) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SevenBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 42));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 35) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 28) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 21) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 14) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 7) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) ((value & 127) | 128));
        }

        private void writeVarint64EightBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 49));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 42) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 35) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 28) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 21) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 14) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((value >>> 7) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) ((value & 127) | 128));
        }

        private void writeVarint64NineBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 56));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 49) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 42) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 35) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 28) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 21) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((value >>> 14) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((value >>> 7) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) ((value & 127) | 128));
        }

        private void writeVarint64TenBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 63));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 56) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 49) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 42) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 35) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 28) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((value >>> 21) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((value >>> 14) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((value >>> 7) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) ((value & 127) | 128));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed32(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) ((value >> 24) & 255));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((value >> 16) & 255));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((value >> 8) & 255));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (value & 255));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeFixed64(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (((int) (value >> 56)) & 255));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((int) (value >> 48)) & 255));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((int) (value >> 40)) & 255));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((int) (value >> 32)) & 255));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((int) (value >> 24)) & 255));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((int) (value >> 16)) & 255));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((int) (value >> 8)) & 255));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((int) value) & 255));
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int i = in.length();
        L3:
            i = i - 1;
            if (i < 0) goto L9;
            char c = in.charAt(i);
            if (c >= 128) goto L9;
            byte[] r1 = this.buffer;
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r1, r6, (byte) c);
        L9:
            if (i != (-1)) goto L11;
            return;
        L11:
            if (i < 0) goto L39;
            char c2 = in.charAt(i);
            if (c2 >= 128) goto L18;
            if (this.pos <= this.offsetMinusOne) goto L18;
            byte[] r7 = this.buffer;
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r7, r8, (byte) c2);
        L38:
            i = i - 1;
        L18:
            if (c2 >= 2048) goto L23;
            if (this.pos <= this.offset) goto L23;
            byte[] r9 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r9, r10, (byte) ((c2 & '?') | 128));
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) ((c2 >>> 6) | 960));
        L23:
            if (c2 < 55296) goto L27;
            if (57343 < c2) goto L27;
        L30:
            if (this.pos <= (this.offset + 2)) goto L37;
            if (i == 0) goto L36;
            char high = in.charAt(i - 1);
            if (Character.isSurrogatePair(high, c2) == false) goto L36;
            i = i - 1;
            int codePoint = Character.toCodePoint(high, c2);
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) ((codePoint & 63) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((codePoint >>> 6) & 63) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((codePoint >>> 12) & 63) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));
        L36:
            throw new Utf8.UnpairedSurrogateException(i - 1, i);
        L37:
            requireSpace(i);
            i = i + 1;
        L27:
            if (this.pos <= (this.offset + 1)) goto L30;
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) ((c2 & '?') | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (((c2 >>> 6) & 63) | 128));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY));
            goto L38
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, value);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (offset < 0) goto L8;
            if ((offset + length) > value.length) goto L8;
            requireSpace(length);
            this.pos -= (long) length;
            System.arraycopy(value, offset, this.buffer, arrayPos() + 1, length);
            return;
        L8:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(value.length), Integer.valueOf(offset), Integer.valueOf(length)}));
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (offset < 0) goto L12;
            if ((offset + length) > value.length) goto L12;
            if (spaceLeft() >= length) goto L9;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L9:
            this.pos -= (long) length;
            System.arraycopy(value, offset, this.buffer, arrayPos() + 1, length);
            return;
        L12:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(value.length), Integer.valueOf(offset), Integer.valueOf(length)}));
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int length = value.remaining();
            requireSpace(length);
            this.pos -= (long) length;
            value.get(this.buffer, arrayPos() + 1, length);
        }

        @Override // com.bytedance.location.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int length = value.remaining();
            if (spaceLeft() >= length) goto L5;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
        L5:
            this.pos -= (long) length;
            value.get(this.buffer, arrayPos() + 1, length);
        }

        @Override // com.bytedance.location.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    abstract void requireSpace(int r1);

    abstract void writeBool(boolean r1);

    abstract void writeFixed32(int r1);

    abstract void writeFixed64(long r1);

    abstract void writeInt32(int r1);

    abstract void writeSInt32(int r1);

    abstract void writeSInt64(long r1);

    abstract void writeString(String r1);

    abstract void writeTag(int r1, int r2);

    abstract void writeVarint32(int r1);

    abstract void writeVarint64(long r1);

    /* synthetic */ BinaryWriter(BufferAllocator x0, int x1, AnonymousClass1 x2) {
        this(x0, x1);
    }

    static /* synthetic */ byte access$200(long x0) {
        return computeUInt64SizeNoTag(x0);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator alloc) {
        return newHeapInstance(alloc, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeHeapSupported() == false) goto L6;
        return newUnsafeHeapInstance(alloc, chunkSize);
    L6:
        return newSafeHeapInstance(alloc, chunkSize);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator alloc) {
        return newDirectInstance(alloc, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeDirectSupported() == false) goto L6;
        return newUnsafeDirectInstance(alloc, chunkSize);
    L6:
        return newSafeDirectInstance(alloc, chunkSize);
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.access$000();
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator alloc, int chunkSize) {
        return new SafeHeapWriter(alloc, chunkSize);
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeHeapSupported() == false) goto L7;
        return new UnsafeHeapWriter(alloc, chunkSize);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator alloc, int chunkSize) {
        return new SafeDirectWriter(alloc, chunkSize);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeDirectSupported() == false) goto L7;
        return new UnsafeDirectWriter(alloc, chunkSize);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private BinaryWriter(BufferAllocator alloc, int chunkSize) {
        this.buffers = new ArrayDeque(4);
        if (chunkSize <= 0) goto L7;
        this.alloc = (BufferAllocator) Internal.checkNotNull(alloc, "alloc");
        this.chunkSize = chunkSize;
        return;
    L7:
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeSFixed32(int fieldNumber, int value) throws IOException {
        writeFixed32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeInt64(int fieldNumber, long value) throws IOException {
        writeUInt64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeSFixed64(int fieldNumber, long value) throws IOException {
        writeFixed64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeFloat(int fieldNumber, float value) throws IOException {
        writeFixed32(fieldNumber, Float.floatToRawIntBits(value));
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeDouble(int fieldNumber, double value) throws IOException {
        writeFixed64(fieldNumber, Double.doubleToRawLongBits(value));
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeEnum(int fieldNumber, int value) throws IOException {
        writeInt32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeInt32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeInt32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeInt32List_Internal(fieldNumber, list, packed);
    }

    private final void writeInt32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeInt32(list.get(i).intValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeInt32(fieldNumber, list.get(i3).intValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeInt32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeInt32(list.getInt(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeInt32(fieldNumber, list.getInt(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeFixed32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeFixed32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeFixed32List_Internal(fieldNumber, list, packed);
    }

    private final void writeFixed32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed32(list.get(i).intValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeFixed32(fieldNumber, list.get(i3).intValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeFixed32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed32(list.getInt(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeFixed32(fieldNumber, list.getInt(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeInt64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        writeUInt64List(fieldNumber, list, packed);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeUInt64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if ((list instanceof LongArrayList) == false) goto L5;
        writeUInt64List_Internal(fieldNumber, (LongArrayList) list, packed);
        return;
    L5:
        writeUInt64List_Internal(fieldNumber, list, packed);
    }

    private final void writeUInt64List_Internal(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeVarint64(list.get(i).longValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeUInt64(fieldNumber, list.get(i3).longValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeUInt64List_Internal(int fieldNumber, LongArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeVarint64(list.getLong(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeUInt64(fieldNumber, list.getLong(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeFixed64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if ((list instanceof LongArrayList) == false) goto L5;
        writeFixed64List_Internal(fieldNumber, (LongArrayList) list, packed);
        return;
    L5:
        writeFixed64List_Internal(fieldNumber, list, packed);
    }

    private final void writeFixed64List_Internal(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed64(list.get(i).longValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeFixed64(fieldNumber, list.get(i3).longValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeFixed64List_Internal(int fieldNumber, LongArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed64(list.getLong(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeFixed64(fieldNumber, list.getLong(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeFloatList(int fieldNumber, List<Float> list, boolean packed) throws IOException {
        if ((list instanceof FloatArrayList) == false) goto L5;
        writeFloatList_Internal(fieldNumber, (FloatArrayList) list, packed);
        return;
    L5:
        writeFloatList_Internal(fieldNumber, list, packed);
    }

    private final void writeFloatList_Internal(int fieldNumber, List<Float> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(list.get(i).floatValue()));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeFloat(fieldNumber, list.get(i3).floatValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeFloatList_Internal(int fieldNumber, FloatArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(list.getFloat(i)));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeFloat(fieldNumber, list.getFloat(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeDoubleList(int fieldNumber, List<Double> list, boolean packed) throws IOException {
        if ((list instanceof DoubleArrayList) == false) goto L5;
        writeDoubleList_Internal(fieldNumber, (DoubleArrayList) list, packed);
        return;
    L5:
        writeDoubleList_Internal(fieldNumber, list, packed);
    }

    private final void writeDoubleList_Internal(int fieldNumber, List<Double> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(list.get(i).doubleValue()));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeDouble(fieldNumber, list.get(i3).doubleValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeDoubleList_Internal(int fieldNumber, DoubleArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(list.getDouble(i)));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeDouble(fieldNumber, list.getDouble(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeEnumList(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        writeInt32List(fieldNumber, list, packed);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeBoolList(int fieldNumber, List<Boolean> list, boolean packed) throws IOException {
        if ((list instanceof BooleanArrayList) == false) goto L5;
        writeBoolList_Internal(fieldNumber, (BooleanArrayList) list, packed);
        return;
    L5:
        writeBoolList_Internal(fieldNumber, list, packed);
    }

    private final void writeBoolList_Internal(int fieldNumber, List<Boolean> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace(list.size() + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeBool(list.get(i).booleanValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeBool(fieldNumber, list.get(i3).booleanValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeBoolList_Internal(int fieldNumber, BooleanArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace(list.size() + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeBool(list.getBoolean(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeBool(fieldNumber, list.getBoolean(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeStringList(int fieldNumber, List<String> list) throws IOException {
        if ((list instanceof LazyStringList) == false) goto L8;
        LazyStringList lazyList = (LazyStringList) list;
        int i = list.size() - 1;
    L5:
        if (i < 0) goto L11;
        writeLazyString(fieldNumber, lazyList.getRaw(i));
        i = i - 1;
        goto L5
    L11:
        return;
    L8:
        int i2 = list.size() - 1;
    L9:
        if (i2 < 0) goto L14;
        writeString(fieldNumber, list.get(i2));
        i2 = i2 - 1;
        goto L9
    }

    private void writeLazyString(int fieldNumber, Object value) throws IOException {
        if ((value instanceof String) == false) goto L5;
        writeString(fieldNumber, (String) value);
        return;
    L5:
        writeBytes(fieldNumber, (ByteString) value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeBytesList(int fieldNumber, List<ByteString> list) throws IOException {
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L6;
        writeBytes(fieldNumber, list.get(i));
        i = i - 1;
        goto L3
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeUInt32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeUInt32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeUInt32List_Internal(fieldNumber, list, packed);
    }

    private final void writeUInt32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeVarint32(list.get(i).intValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeUInt32(fieldNumber, list.get(i3).intValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeUInt32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeVarint32(list.getInt(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeUInt32(fieldNumber, list.getInt(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeSFixed32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        writeFixed32List(fieldNumber, list, packed);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeSFixed64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        writeFixed64List(fieldNumber, list, packed);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeSInt32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeSInt32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeSInt32List_Internal(fieldNumber, list, packed);
    }

    private final void writeSInt32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeSInt32(list.get(i).intValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeSInt32(fieldNumber, list.get(i3).intValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeSInt32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeSInt32(list.getInt(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeSInt32(fieldNumber, list.getInt(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeSInt64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if ((list instanceof LongArrayList) == false) goto L5;
        writeSInt64List_Internal(fieldNumber, (LongArrayList) list, packed);
        return;
    L5:
        writeSInt64List_Internal(fieldNumber, list, packed);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public <K, V> void writeMap(int fieldNumber, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        Iterator<Map.Entry<K, V>> r0 = map.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<K, V> entry = r0.next();
        int prevBytes = getTotalBytesWritten();
        writeMapEntryField(this, 2, metadata.valueType, entry.getValue());
        writeMapEntryField(this, 1, metadata.keyType, entry.getKey());
        int length = getTotalBytesWritten() - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        goto L4
    }

    static final void writeMapEntryField(Writer writer, int fieldNumber, WireFormat.FieldType fieldType, Object object) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L7;
            default: goto L5;
        };
    L14:
        writer.writeBytes(fieldNumber, (ByteString) object);
        return;
    L15:
        writer.writeMessage(fieldNumber, object);
        return;
    L16:
        writer.writeDouble(fieldNumber, ((Double) object).doubleValue());
        return;
    L17:
        writer.writeFloat(fieldNumber, ((Float) object).floatValue());
        return;
    L18:
        writer.writeUInt64(fieldNumber, ((Long) object).longValue());
        return;
    L19:
        writer.writeUInt32(fieldNumber, ((Integer) object).intValue());
        return;
    L20:
        writer.writeString(fieldNumber, (String) object);
        return;
    L21:
        writer.writeSInt64(fieldNumber, ((Long) object).longValue());
        return;
    L22:
        writer.writeSInt32(fieldNumber, ((Integer) object).intValue());
        return;
    L23:
        writer.writeSFixed64(fieldNumber, ((Long) object).longValue());
        return;
    L24:
        writer.writeSFixed32(fieldNumber, ((Integer) object).intValue());
        return;
    L25:
        writer.writeInt64(fieldNumber, ((Long) object).longValue());
        return;
    L26:
        writer.writeInt32(fieldNumber, ((Integer) object).intValue());
        return;
    L27:
        writer.writeFixed64(fieldNumber, ((Long) object).longValue());
        return;
    L28:
        writer.writeFixed32(fieldNumber, ((Integer) object).intValue());
        return;
    L29:
        writer.writeBool(fieldNumber, ((Boolean) object).booleanValue());
        return;
    L5:
        throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
    L7:
        if ((object instanceof Internal.EnumLite) == false) goto L10;
        writer.writeEnum(fieldNumber, ((Internal.EnumLite) object).getNumber());
        return;
    L10:
        if ((object instanceof Integer) == false) goto L13;
        writer.writeEnum(fieldNumber, ((Integer) object).intValue());
        return;
    L13:
        throw new IllegalArgumentException("Unexpected type for enum in map.");
    }

    private final void writeSInt64List_Internal(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeSInt64(list.get(i).longValue());
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeSInt64(fieldNumber, list.get(i3).longValue());
        i3 = i3 - 1;
        goto L8
    }

    private final void writeSInt64List_Internal(int fieldNumber, LongArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int prevBytes = getTotalBytesWritten();
        int i = list.size() - 1;
    L4:
        if (i < 0) goto L6;
        writeSInt64(list.getLong(i));
        i = i - 1;
        goto L4
    L6:
        int i2 = getTotalBytesWritten();
        int length = i2 - prevBytes;
        writeVarint32(length);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int i3 = list.size() - 1;
    L8:
        if (i3 < 0) goto L13;
        writeSInt64(fieldNumber, list.getLong(i3));
        i3 = i3 - 1;
        goto L8
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeMessageList(int fieldNumber, List<?> list) throws IOException {
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L6;
        writeMessage(fieldNumber, list.get(i));
        i = i - 1;
        goto L3
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeMessageList(int fieldNumber, List<?> list, Schema schema) throws IOException {
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L6;
        writeMessage(fieldNumber, list.get(i), schema);
        i = i - 1;
        goto L3
    }

    @Override // com.bytedance.location.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int fieldNumber, List<?> list) throws IOException {
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L6;
        writeGroup(fieldNumber, list.get(i));
        i = i - 1;
        goto L3
    }

    @Override // com.bytedance.location.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int fieldNumber, List<?> list, Schema schema) throws IOException {
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L6;
        writeGroup(fieldNumber, list.get(i), schema);
        i = i - 1;
        goto L3
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeMessageSetItem(int fieldNumber, Object value) throws IOException {
        writeTag(1, 4);
        if ((value instanceof ByteString) == false) goto L5;
        writeBytes(3, (ByteString) value);
    L6:
        writeUInt32(2, fieldNumber);
        writeTag(1, 3);
        return;
    L5:
        writeMessage(3, value);
        goto L6
    }

    final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    final AllocatedBuffer newHeapBuffer(int capacity) {
        return this.alloc.allocateHeapBuffer(Math.max(capacity, this.chunkSize));
    }

    final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    final AllocatedBuffer newDirectBuffer(int capacity) {
        return this.alloc.allocateDirectBuffer(Math.max(capacity, this.chunkSize));
    }

    private static byte computeUInt64SizeNoTag(long value) {
        if (((-128) & value) != 0) goto L7;
        return 1;
    L7:
        if (value >= 0) goto L10;
        return 10;
    L10:
        byte n = 2;
        if (((-34359738368L) & value) == 0) goto L14;
        n = (byte) (2 + 4);
        value = value >>> 28;
    L14:
        if (((-2097152) & value) == 0) goto L17;
        n = (byte) (n + 2);
        value = value >>> 14;
    L17:
        if (((-16384) & value) != 0) goto L19;
        return n;
    L19:
        return (byte) (n + 1);
    }
}
