package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.CodedInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        /* synthetic */ ArrayDecoder(byte[] x0, int x1, int x2, boolean x3, AnonymousClass1 x4) {
            this(x0, x1, x2, x3);
        }

        private ArrayDecoder(byte[] buffer, int offset, int len, boolean immutable) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.limit = offset + len;
            this.pos = offset;
            this.startPos = this.pos;
            this.immutable = immutable;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            skipRawBytes(4);
            return true;
        L8:
            return false;
        L10:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L12:
            skipRawBytes(readRawVarint32());
            return true;
        L14:
            skipRawBytes(8);
            return true;
        L16:
            skipRawVarint();
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            int value = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(value);
            return true;
        L8:
            return false;
        L10:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(endtag);
            output.writeUInt32NoTag(endtag);
            return true;
        L12:
            ByteString value2 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(value2);
            return true;
        L14:
            long value3 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(value3);
            return true;
        L16:
            long value4 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(value4);
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag, output) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size != 0) goto L11;
            return "";
        L11:
            if (size >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (size > (this.limit - this.pos)) goto L8;
            String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
            this.pos += size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size != 0) goto L11;
            return "";
        L11:
            if (size > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (size > (this.limit - this.pos)) goto L8;
            String result = Utf8.decodeUtf8(this.buffer, this.pos, size);
            this.pos += size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return result;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L14:
            if (size != 0) goto L18;
            return ByteString.EMPTY;
        L18:
            return ByteString.wrap(readRawBytes(size));
        L5:
            if (size > (this.limit - this.pos)) goto L14;
            if (this.immutable == true) goto L9;
        L11:
            ByteString result = ByteString.copyFrom(this.buffer, this.pos, size);
        L12:
            this.pos += size;
            return result;
        L9:
            if (this.enableAliasing == false) goto L11;
            result = ByteString.wrap(this.buffer, this.pos, size);
            goto L12
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int size = readRawVarint32();
            return readRawBytes(size);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L14:
            if (size == 0) goto L16;
            if (size >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        L5:
            if (size > (this.limit - this.pos)) goto L14;
            if (this.immutable == false) goto L9;
        L11:
            ByteBuffer result = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.pos, this.pos + size));
        L12:
            this.pos += size;
            return result;
        L9:
            if (this.enableAliasing == false) goto L11;
            result = ByteBuffer.wrap(this.buffer, this.pos, size).slice();
            goto L12
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int tempPos = this.pos;
            if (this.limit == tempPos) goto L34;
            byte[] buffer = this.buffer;
            int tempPos2 = tempPos + 1;
            int x = buffer[tempPos];
            if (x < 0) goto L10;
            this.pos = tempPos2;
            return x;
        L10:
            if ((this.limit - tempPos2) < 9) goto L34;
            int tempPos3 = tempPos2 + 1;
            int x2 = (buffer[tempPos2] << 7) ^ x;
            if (x2 >= 0) goto L15;
            int tempPos4 = x2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L37:
            this.pos = tempPos3;
            return tempPos4;
        L15:
            int x3 = tempPos3 + 1;
            int x4 = (buffer[tempPos3] << 14) ^ x2;
            if (x4 < 0) goto L18;
            tempPos4 = x4 ^ 16256;
            tempPos3 = x3;
            goto L37
        L18:
            tempPos3 = x3 + 1;
            int x5 = (buffer[x3] << 21) ^ x4;
            if (x5 >= 0) goto L21;
            tempPos4 = (-2080896) ^ x5;
            goto L37
        L21:
            int tempPos5 = tempPos3 + 1;
            int y = buffer[tempPos3];
            int x6 = (x5 ^ (y << 28)) ^ 266354560;
            if (y >= 0) goto L36;
            int tempPos6 = tempPos5 + 1;
            if (buffer[tempPos5] >= 0) goto L35;
            tempPos5 = tempPos6 + 1;
            if (buffer[tempPos6] >= 0) goto L36;
            tempPos6 = tempPos5 + 1;
            if (buffer[tempPos5] >= 0) goto L35;
            tempPos5 = tempPos6 + 1;
            if (buffer[tempPos6] >= 0) goto L36;
            tempPos6 = tempPos5 + 1;
            if (buffer[tempPos5] < 0) goto L34;
        L35:
            tempPos4 = x6;
            tempPos3 = tempPos6;
        L36:
            tempPos3 = tempPos5;
            tempPos4 = x6;
        L34:
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if ((this.limit - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            byte[] r1 = this.buffer;
            int r2 = this.pos;
            this.pos = r2 + 1;
            if (r1[r2] >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            int tempPos = this.pos;
            if (this.limit == tempPos) goto L38;
            byte[] buffer = this.buffer;
            int tempPos2 = tempPos + 1;
            int y = buffer[tempPos];
            if (y < 0) goto L10;
            this.pos = tempPos2;
            return y;
        L10:
            if ((this.limit - tempPos2) < 9) goto L38;
            int tempPos3 = tempPos2 + 1;
            int y2 = (buffer[tempPos2] << 7) ^ y;
            if (y2 >= 0) goto L15;
            long x = y2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L40:
            this.pos = tempPos3;
            return x;
        L15:
            int tempPos4 = tempPos3 + 1;
            int y3 = (buffer[tempPos3] << 14) ^ y2;
            if (y3 < 0) goto L18;
            x = y3 ^ 16256;
            tempPos3 = tempPos4;
            goto L40
        L18:
            tempPos3 = tempPos4 + 1;
            int y4 = (buffer[tempPos4] << 21) ^ y3;
            if (y4 >= 0) goto L21;
            x = (-2080896) ^ y4;
            goto L40
        L21:
            long x2 = y4;
            int tempPos5 = tempPos3 + 1;
            long x3 = x2 ^ (((long) buffer[tempPos3]) << 28);
            if (x3 < 0) goto L24;
            x = 266354560 ^ x3;
            tempPos3 = tempPos5;
            goto L40
        L24:
            tempPos3 = tempPos5 + 1;
            long x4 = (((long) buffer[tempPos5]) << 35) ^ x3;
            if (x4 >= 0) goto L27;
            x = (-34093383808L) ^ x4;
            goto L40
        L27:
            int tempPos6 = tempPos3 + 1;
            long x5 = (((long) buffer[tempPos3]) << 42) ^ x4;
            if (x5 < 0) goto L30;
            x = 4363953127296L ^ x5;
            tempPos3 = tempPos6;
            goto L40
        L30:
            tempPos3 = tempPos6 + 1;
            long x6 = (((long) buffer[tempPos6]) << 49) ^ x5;
            if (x6 >= 0) goto L33;
            x = (-558586000294016L) ^ x6;
            goto L40
        L33:
            int tempPos7 = tempPos3 + 1;
            x = ((((long) buffer[tempPos3]) << 56) ^ x6) ^ 71499008037633920L;
            if (x >= 0) goto L39;
            tempPos3 = tempPos7 + 1;
            if (buffer[tempPos7] >= 0) goto L40;
        L39:
            tempPos3 = tempPos7;
        L38:
            return readRawVarint64SlowPath();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            int shift = 0;
        L4:
            if (shift >= 64) goto L10;
            byte b = readRawByte();
            result = result | (((long) (b & 127)) << shift);
            if ((b & 128) == 0) goto L7;
            shift = shift + 7;
            goto L4
        L7:
            return result;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int tempPos = this.pos;
            if ((this.limit - tempPos) < 4) goto L7;
            byte[] buffer = this.buffer;
            this.pos = tempPos + 4;
            return (((buffer[tempPos] & CecDeviceType.INACTIVE) | ((buffer[tempPos + 1] & CecDeviceType.INACTIVE) << 8)) | ((buffer[tempPos + 2] & CecDeviceType.INACTIVE) << 16)) | ((buffer[tempPos + 3] & CecDeviceType.INACTIVE) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int tempPos = this.pos;
            if ((this.limit - tempPos) < 8) goto L7;
            byte[] buffer = this.buffer;
            this.pos = tempPos + 8;
            return (((((((((long) buffer[tempPos]) & 255) | ((((long) buffer[tempPos + 1]) & 255) << 8)) | ((((long) buffer[tempPos + 2]) & 255) << 16)) | ((((long) buffer[tempPos + 3]) & 255) << 24)) | ((((long) buffer[tempPos + 4]) & 255) << 32)) | ((((long) buffer[tempPos + 5]) & 255) << 40)) | ((((long) buffer[tempPos + 6]) & 255) << 48)) | ((((long) buffer[tempPos + 7]) & 255) << 56);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L14;
            int byteLimit2 = byteLimit + getTotalBytesRead();
            if (byteLimit2 < 0) goto L12;
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) goto L10;
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += this.bufferSizeAfterLimit;
            int bufferEnd = this.limit - this.startPos;
            if (bufferEnd <= this.currentLimit) goto L5;
            this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
            this.limit -= this.bufferSizeAfterLimit;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return this.currentLimit - getTotalBytesRead();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.limit) goto L7;
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 + 1;
            return r0[r1];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length > 0) goto L4;
        L7:
            if (length > 0) goto L14;
            if (length != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > (this.limit - this.pos)) goto L7;
            int tempPos = this.pos;
            this.pos += length;
            return Arrays.copyOfRange(this.buffer, tempPos, this.pos);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0) goto L4;
        L7:
            if (length >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > (this.limit - this.pos)) goto L7;
            this.pos += length;
        }
    }

    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        /* synthetic */ IterableDirectByteBufferDecoder(Iterable x0, int x1, boolean x2, AnonymousClass1 x3) {
            this(x0, x1, x2);
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> inputBufs, int size, boolean immutableFlag) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = size;
            this.input = inputBufs;
            this.iterator = this.input.iterator();
            this.immutable = immutableFlag;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (size != 0) goto L5;
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0;
            this.currentByteBufferStartPos = 0;
            this.currentByteBufferLimit = 0;
            this.currentAddress = 0;
            return;
        L5:
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (this.iterator.hasNext() == false) goto L7;
            tryGetNextByteBuffer();
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void tryGetNextByteBuffer() {
            this.currentByteBuffer = this.iterator.next();
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            this.currentByteBufferPos = this.currentByteBuffer.position();
            this.currentByteBufferStartPos = this.currentByteBufferPos;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentByteBufferPos += this.currentAddress;
            this.currentByteBufferStartPos += this.currentAddress;
            this.currentByteBufferLimit += this.currentAddress;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            skipRawBytes(4);
            return true;
        L8:
            return false;
        L10:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L12:
            skipRawBytes(readRawVarint32());
            return true;
        L14:
            skipRawBytes(8);
            return true;
        L16:
            skipRawVarint();
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            int value = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(value);
            return true;
        L8:
            return false;
        L10:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(endtag);
            output.writeUInt32NoTag(endtag);
            return true;
        L12:
            ByteString value2 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(value2);
            return true;
        L14:
            long value3 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(value3);
            return true;
        L16:
            long value4 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(value4);
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag, output) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size > 0) goto L10;
        L13:
            if (size != 0) goto L16;
            return "";
        L16:
            if (size >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (size > remaining()) goto L13;
            byte[] bytes = new byte[size];
            readRawBytesTo(bytes, 0, size);
            String result = new String(bytes, Internal.UTF_8);
            return result;
        L5:
            if (size > (this.currentByteBufferLimit - this.currentByteBufferPos)) goto L8;
            byte[] bytes2 = new byte[size];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes2, 0, size);
            String result2 = new String(bytes2, Internal.UTF_8);
            this.currentByteBufferPos += (long) size;
            return result2;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size >= 0) goto L10;
        L13:
            if (size != 0) goto L16;
            return "";
        L16:
            if (size > 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (size > remaining()) goto L13;
            byte[] bytes = new byte[size];
            readRawBytesTo(bytes, 0, size);
            return Utf8.decodeUtf8(bytes, 0, size);
        L5:
            if (size > (this.currentByteBufferLimit - this.currentByteBufferPos)) goto L8;
            int bufferPos = (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            String result = Utf8.decodeUtf8(this.currentByteBuffer, bufferPos, size);
            this.currentByteBufferPos += (long) size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return result;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L14:
            if (size > 0) goto L16;
        L31:
            if (size == 0) goto L33;
            if (size >= 0) goto L38;
            throw InvalidProtocolBufferException.negativeSize();
        L38:
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            return ByteString.EMPTY;
        L16:
            if (size > remaining()) goto L31;
            if (this.immutable == true) goto L20;
        L29:
            byte[] temp = new byte[size];
            readRawBytesTo(temp, 0, size);
            return ByteString.wrap(temp);
        L20:
            if (this.enableAliasing == false) goto L29;
            ArrayList<ByteString> byteStrings = new ArrayList();
            int l = size;
        L22:
            if (l <= 0) goto L28;
            if (currentRemaining() != 0) goto L26;
            getNextByteBuffer();
        L26:
            int bytesToCopy = Math.min(l, (int) currentRemaining());
            int idx = (int) (this.currentByteBufferPos - this.currentAddress);
            byteStrings.add(ByteString.wrap(slice(idx, idx + bytesToCopy)));
            l = l - bytesToCopy;
            this.currentByteBufferPos += (long) bytesToCopy;
            goto L22
        L28:
            return ByteString.copyFrom(byteStrings);
        L5:
            if (size > (this.currentByteBufferLimit - this.currentByteBufferPos)) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] bytes = new byte[size];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0, size);
            this.currentByteBufferPos += (long) size;
            return ByteString.wrap(bytes);
        L9:
            if (this.enableAliasing == false) goto L12;
            int idx2 = (int) (this.currentByteBufferPos - this.currentAddress);
            ByteString result = ByteString.wrap(slice(idx2, idx2 + size));
            this.currentByteBufferPos += (long) size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L14:
            if (size > 0) goto L16;
        L19:
            if (size == 0) goto L21;
            if (size >= 0) goto L26;
            throw InvalidProtocolBufferException.negativeSize();
        L26:
            throw InvalidProtocolBufferException.truncatedMessage();
        L21:
            return Internal.EMPTY_BYTE_BUFFER;
        L16:
            if (size > remaining()) goto L19;
            byte[] temp = new byte[size];
            readRawBytesTo(temp, 0, size);
            return ByteBuffer.wrap(temp);
        L5:
            if (size > currentRemaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] bytes = new byte[size];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0, size);
            this.currentByteBufferPos += (long) size;
            return ByteBuffer.wrap(bytes);
        L9:
            if (this.enableAliasing == false) goto L12;
            this.currentByteBufferPos += (long) size;
            return slice((int) ((this.currentByteBufferPos - this.currentAddress) - ((long) size)), (int) (this.currentByteBufferPos - this.currentAddress));
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            long tempPos = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == this.currentByteBufferPos) goto L34;
            long tempPos2 = tempPos + 1;
            int x = UnsafeUtil.getByte(tempPos);
            if (x < 0) goto L10;
            this.currentByteBufferPos++;
            return x;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L34;
            long tempPos3 = tempPos2 + 1;
            int x2 = (UnsafeUtil.getByte(tempPos2) << 7) ^ x;
            if (x2 >= 0) goto L15;
            int y = x2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L41:
            this.currentByteBufferPos = tempPos3;
            return y;
        L15:
            long tempPos4 = tempPos3 + 1;
            int x3 = (UnsafeUtil.getByte(tempPos3) << 14) ^ x2;
            if (x3 < 0) goto L18;
            y = x3 ^ 16256;
            tempPos3 = tempPos4;
            goto L41
        L18:
            tempPos3 = tempPos4 + 1;
            int x4 = (UnsafeUtil.getByte(tempPos4) << ParameterName.BLUE_STRETCH) ^ x3;
            if (x4 >= 0) goto L21;
            y = (-2080896) ^ x4;
            goto L41
        L21:
            long tempPos5 = tempPos3 + 1;
            int y2 = UnsafeUtil.getByte(tempPos3);
            int x5 = (x4 ^ (y2 << 28)) ^ 266354560;
            if (y2 >= 0) goto L40;
            tempPos3 = tempPos5 + 1;
            if (UnsafeUtil.getByte(tempPos5) >= 0) goto L39;
            long tempPos6 = tempPos3 + 1;
            if (UnsafeUtil.getByte(tempPos3) >= 0) goto L38;
            tempPos3 = tempPos6 + 1;
            if (UnsafeUtil.getByte(tempPos6) >= 0) goto L37;
            long tempPos7 = tempPos3 + 1;
            if (UnsafeUtil.getByte(tempPos3) >= 0) goto L36;
            tempPos3 = tempPos7 + 1;
            if (UnsafeUtil.getByte(tempPos7) < 0) goto L34;
            y = x5;
            goto L41
        L36:
            y = x5;
            tempPos3 = tempPos7;
            goto L41
        L37:
            y = x5;
            goto L41
        L38:
            y = x5;
            tempPos3 = tempPos6;
            goto L41
        L39:
            y = x5;
            goto L41
        L40:
            y = x5;
            tempPos3 = tempPos5;
        L34:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long tempPos = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == this.currentByteBufferPos) goto L38;
            long tempPos2 = tempPos + 1;
            int y = UnsafeUtil.getByte(tempPos);
            if (y < 0) goto L10;
            this.currentByteBufferPos++;
            return y;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L38;
            long tempPos3 = tempPos2 + 1;
            int y2 = (UnsafeUtil.getByte(tempPos2) << 7) ^ y;
            if (y2 >= 0) goto L15;
            long x = y2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L41:
            this.currentByteBufferPos = tempPos3;
            return x;
        L15:
            long tempPos4 = tempPos3 + 1;
            int y3 = (UnsafeUtil.getByte(tempPos3) << 14) ^ y2;
            if (y3 < 0) goto L18;
            x = y3 ^ 16256;
            tempPos3 = tempPos4;
            goto L41
        L18:
            tempPos3 = tempPos4 + 1;
            int y4 = (UnsafeUtil.getByte(tempPos4) << ParameterName.BLUE_STRETCH) ^ y3;
            if (y4 >= 0) goto L21;
            x = (-2080896) ^ y4;
            goto L41
        L21:
            long tempPos5 = tempPos3 + 1;
            long x2 = ((long) y4) ^ (((long) UnsafeUtil.getByte(tempPos3)) << 28);
            if (x2 < 0) goto L24;
            x = 266354560 ^ x2;
            tempPos3 = tempPos5;
            goto L41
        L24:
            long tempPos6 = tempPos5 + 1;
            long x3 = (((long) UnsafeUtil.getByte(tempPos5)) << 35) ^ x2;
            if (x3 >= 0) goto L27;
            x = (-34093383808L) ^ x3;
            tempPos3 = tempPos6;
            goto L41
        L27:
            long tempPos7 = tempPos6 + 1;
            long x4 = (((long) UnsafeUtil.getByte(tempPos6)) << 42) ^ x3;
            if (x4 < 0) goto L30;
            x = 4363953127296L ^ x4;
            tempPos3 = tempPos7;
            goto L41
        L30:
            long tempPos8 = tempPos7 + 1;
            long x5 = (((long) UnsafeUtil.getByte(tempPos7)) << 49) ^ x4;
            if (x5 >= 0) goto L33;
            x = (-558586000294016L) ^ x5;
            tempPos3 = tempPos8;
            goto L41
        L33:
            long tempPos9 = tempPos8 + 1;
            long x6 = ((((long) UnsafeUtil.getByte(tempPos8)) << 56) ^ x5) ^ 71499008037633920L;
            if (x6 >= 0) goto L40;
            tempPos3 = tempPos9 + 1;
            if (UnsafeUtil.getByte(tempPos9) < 0) goto L38;
            x = x6;
            goto L41
        L40:
            x = x6;
            tempPos3 = tempPos9;
        L38:
            return readRawVarint64SlowPath();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            int shift = 0;
        L4:
            if (shift >= 64) goto L10;
            byte b = readRawByte();
            result = result | (((long) (b & 127)) << shift);
            if ((b & 128) == 0) goto L7;
            shift = shift + 7;
            goto L4
        L7:
            return result;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) goto L7;
            long tempPos = this.currentByteBufferPos;
            this.currentByteBufferPos += 4;
            return (((UnsafeUtil.getByte(tempPos) & CecDeviceType.INACTIVE) | ((UnsafeUtil.getByte(1 + tempPos) & CecDeviceType.INACTIVE) << 8)) | ((UnsafeUtil.getByte(2 + tempPos) & CecDeviceType.INACTIVE) << 16)) | ((UnsafeUtil.getByte(3 + tempPos) & CecDeviceType.INACTIVE) << 24);
        L7:
            return (((readRawByte() & CecDeviceType.INACTIVE) | ((readRawByte() & CecDeviceType.INACTIVE) << 8)) | ((readRawByte() & CecDeviceType.INACTIVE) << 16)) | ((readRawByte() & CecDeviceType.INACTIVE) << 24);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (currentRemaining() < 8) goto L7;
            long tempPos = this.currentByteBufferPos;
            this.currentByteBufferPos += 8;
            return (((((((((long) UnsafeUtil.getByte(tempPos)) & 255) | ((((long) UnsafeUtil.getByte(1 + tempPos)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + tempPos)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + tempPos)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + tempPos)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + tempPos)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + tempPos)) & 255) << 48)) | ((((long) UnsafeUtil.getByte(7 + tempPos)) & 255) << 56);
        L7:
            return (((((((((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8)) | ((((long) readRawByte()) & 255) << 16)) | ((((long) readRawByte()) & 255) << 24)) | ((((long) readRawByte()) & 255) << 32)) | ((((long) readRawByte()) & 255) << 40)) | ((((long) readRawByte()) & 255) << 48)) | ((((long) readRawByte()) & 255) << 56);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L10;
            int byteLimit2 = byteLimit + getTotalBytesRead();
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) goto L8;
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            this.totalBufferSize += this.bufferSizeAfterCurrentLimit;
            int bufferEnd = this.totalBufferSize - this.startOffset;
            if (bufferEnd <= this.currentLimit) goto L5;
            this.bufferSizeAfterCurrentLimit = bufferEnd - this.currentLimit;
            this.totalBufferSize -= this.bufferSizeAfterCurrentLimit;
            return;
        L5:
            this.bufferSizeAfterCurrentLimit = 0;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return this.currentLimit - getTotalBytesRead();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos) != this.totalBufferSize) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (currentRemaining() != 0) goto L5;
            getNextByteBuffer();
        L5:
            long r0 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + r0;
            return UnsafeUtil.getByte(r0);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length >= 0) goto L4;
        L7:
            if (length >= 0) goto L9;
        L12:
            if (length > 0) goto L19;
            if (length != 0) goto L17;
            return Internal.EMPTY_BYTE_ARRAY;
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        L9:
            if (length > remaining()) goto L12;
            byte[] bytes = new byte[length];
            readRawBytesTo(bytes, 0, length);
            return bytes;
        L4:
            if (length > currentRemaining()) goto L7;
            byte[] bytes2 = new byte[length];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes2, 0, length);
            this.currentByteBufferPos += (long) length;
            return bytes2;
        }

        private void readRawBytesTo(byte[] bytes, int offset, int length) throws IOException {
            if (length < 0) goto L13;
            if (length > remaining()) goto L13;
            int l = length;
        L6:
            if (l <= 0) goto L11;
            if (currentRemaining() != 0) goto L10;
            getNextByteBuffer();
        L10:
            int bytesToCopy = Math.min(l, (int) currentRemaining());
            UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, (length - l) + offset, bytesToCopy);
            l = l - bytesToCopy;
            this.currentByteBufferPos += (long) bytesToCopy;
            goto L6
        L11:
            return;
        L13:
            if (length > 0) goto L19;
            if (length != 0) goto L17;
            return;
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0) goto L4;
        L12:
            if (length >= 0) goto L16;
            throw InvalidProtocolBufferException.negativeSize();
        L16:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos)) goto L12;
            int l = length;
        L6:
            if (l <= 0) goto L11;
            if (currentRemaining() != 0) goto L10;
            getNextByteBuffer();
        L10:
            int rl = Math.min(l, (int) currentRemaining());
            l = l - rl;
            this.currentByteBufferPos += (long) rl;
            goto L6
        }

        private void skipRawVarint() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private ByteBuffer slice(int begin, int end) throws IOException {
            int prevPos = this.currentByteBuffer.position();
            int prevLimit = this.currentByteBuffer.limit();
            Buffer asBuffer = this.currentByteBuffer;
            asBuffer.position(begin);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            asBuffer.limit(end);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r3 = this.currentByteBuffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            asBuffer.position(prevPos);
            asBuffer.limit(prevLimit);
            return r3;
        L6:
            th = move-exception;
            asBuffer.position(prevPos);
            asBuffer.limit(prevLimit);
            throw th;
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }
    }

    private static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        private interface RefillCallback {
            void onRefill();
        }

        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;
            final /* synthetic */ StreamDecoder this$0;

            private SkippedDataSink(StreamDecoder r1) {
                this.this$0 = r1;
                this.lastPos = StreamDecoder.access$500(this.this$0);
            }

            @Override // com.bytedance.location.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream != null) goto L5;
                this.byteArrayStream = new ByteArrayOutputStream();
            L5:
                this.byteArrayStream.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
                this.lastPos = 0;
            }

            ByteBuffer getSkippedData() {
                if (this.byteArrayStream == null) goto L5;
                this.byteArrayStream.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0));
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            L5:
                return ByteBuffer.wrap(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
            }
        }

        /* synthetic */ StreamDecoder(InputStream x0, int x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        static /* synthetic */ int access$500(StreamDecoder x0) {
            return x0.pos;
        }

        static /* synthetic */ byte[] access$600(StreamDecoder x0) {
            return x0.buffer;
        }

        private StreamDecoder(InputStream input, int bufferSize) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(input, "input");
            this.input = input;
            this.buffer = new byte[bufferSize];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int read(InputStream input, byte[] data, int offset, int length) throws IOException {
            return input.read(data, offset, length);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static long skip(InputStream input, long length) throws IOException {
            return input.skip(length);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static int available(InputStream input) throws IOException {
            return input.available();
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            skipRawBytes(4);
            return true;
        L8:
            return false;
        L10:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L12:
            skipRawBytes(readRawVarint32());
            return true;
        L14:
            skipRawBytes(8);
            return true;
        L16:
            skipRawVarint();
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            int value = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(value);
            return true;
        L8:
            return false;
        L10:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(endtag);
            output.writeUInt32NoTag(endtag);
            return true;
        L12:
            ByteString value2 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(value2);
            return true;
        L14:
            long value3 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(value3);
            return true;
        L16:
            long value4 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(value4);
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag, output) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size != 0) goto L12;
            return "";
        L12:
            if (size > this.bufferSize) goto L16;
            refillBuffer(size);
            String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
            this.pos += size;
            return result;
        L16:
            return new String(readRawBytesSlowPath(size, false), Internal.UTF_8);
        L5:
            if (size > (this.bufferSize - this.pos)) goto L8;
            String result2 = new String(this.buffer, this.pos, size, Internal.UTF_8);
            this.pos += size;
            return result2;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            int oldPos = this.pos;
            if (size > (this.bufferSize - oldPos)) goto L6;
            if (size <= 0) goto L6;
            byte[] bytes = this.buffer;
            this.pos = oldPos + size;
            int tempPos = oldPos;
        L14:
            return Utf8.decodeUtf8(bytes, tempPos, size);
        L6:
            if (size != 0) goto L10;
            return "";
        L10:
            if (size > this.bufferSize) goto L12;
            refillBuffer(size);
            bytes = this.buffer;
            tempPos = 0;
            this.pos = 0 + size;
            goto L14
        L12:
            bytes = readRawBytesSlowPath(size, false);
            tempPos = 0;
            goto L14
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return result;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size > (this.bufferSize - this.pos)) goto L7;
            if (size <= 0) goto L7;
            ByteString result = ByteString.copyFrom(this.buffer, this.pos, size);
            this.pos += size;
            return result;
        L7:
            if (size != 0) goto L11;
            return ByteString.EMPTY;
        L11:
            return readBytesSlowPath(size);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int size = readRawVarint32();
            if (size > (this.bufferSize - this.pos)) goto L8;
            if (size <= 0) goto L8;
            byte[] result = Arrays.copyOfRange(this.buffer, this.pos, this.pos + size);
            this.pos += size;
            return result;
        L8:
            return readRawBytesSlowPath(size, false);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size > (this.bufferSize - this.pos)) goto L7;
            if (size <= 0) goto L7;
            ByteBuffer result = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.pos, this.pos + size));
            this.pos += size;
            return result;
        L7:
            if (size != 0) goto L11;
            return Internal.EMPTY_BYTE_BUFFER;
        L11:
            return ByteBuffer.wrap(readRawBytesSlowPath(size, true));
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int tempPos = this.pos;
            if (this.bufferSize == tempPos) goto L34;
            byte[] buffer = this.buffer;
            int tempPos2 = tempPos + 1;
            int x = buffer[tempPos];
            if (x < 0) goto L10;
            this.pos = tempPos2;
            return x;
        L10:
            if ((this.bufferSize - tempPos2) < 9) goto L34;
            int tempPos3 = tempPos2 + 1;
            int x2 = (buffer[tempPos2] << 7) ^ x;
            if (x2 >= 0) goto L15;
            int tempPos4 = x2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L37:
            this.pos = tempPos3;
            return tempPos4;
        L15:
            int x3 = tempPos3 + 1;
            int x4 = (buffer[tempPos3] << 14) ^ x2;
            if (x4 < 0) goto L18;
            tempPos4 = x4 ^ 16256;
            tempPos3 = x3;
            goto L37
        L18:
            tempPos3 = x3 + 1;
            int x5 = (buffer[x3] << 21) ^ x4;
            if (x5 >= 0) goto L21;
            tempPos4 = (-2080896) ^ x5;
            goto L37
        L21:
            int tempPos5 = tempPos3 + 1;
            int y = buffer[tempPos3];
            int x6 = (x5 ^ (y << 28)) ^ 266354560;
            if (y >= 0) goto L36;
            int tempPos6 = tempPos5 + 1;
            if (buffer[tempPos5] >= 0) goto L35;
            tempPos5 = tempPos6 + 1;
            if (buffer[tempPos6] >= 0) goto L36;
            tempPos6 = tempPos5 + 1;
            if (buffer[tempPos5] >= 0) goto L35;
            tempPos5 = tempPos6 + 1;
            if (buffer[tempPos6] >= 0) goto L36;
            tempPos6 = tempPos5 + 1;
            if (buffer[tempPos5] < 0) goto L34;
        L35:
            tempPos4 = x6;
            tempPos3 = tempPos6;
        L36:
            tempPos3 = tempPos5;
            tempPos4 = x6;
        L34:
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if ((this.bufferSize - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            byte[] r1 = this.buffer;
            int r2 = this.pos;
            this.pos = r2 + 1;
            if (r1[r2] >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            int tempPos = this.pos;
            if (this.bufferSize == tempPos) goto L38;
            byte[] buffer = this.buffer;
            int tempPos2 = tempPos + 1;
            int y = buffer[tempPos];
            if (y < 0) goto L10;
            this.pos = tempPos2;
            return y;
        L10:
            if ((this.bufferSize - tempPos2) < 9) goto L38;
            int tempPos3 = tempPos2 + 1;
            int y2 = (buffer[tempPos2] << 7) ^ y;
            if (y2 >= 0) goto L15;
            long x = y2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L40:
            this.pos = tempPos3;
            return x;
        L15:
            int tempPos4 = tempPos3 + 1;
            int y3 = (buffer[tempPos3] << 14) ^ y2;
            if (y3 < 0) goto L18;
            x = y3 ^ 16256;
            tempPos3 = tempPos4;
            goto L40
        L18:
            tempPos3 = tempPos4 + 1;
            int y4 = (buffer[tempPos4] << 21) ^ y3;
            if (y4 >= 0) goto L21;
            x = (-2080896) ^ y4;
            goto L40
        L21:
            long x2 = y4;
            int tempPos5 = tempPos3 + 1;
            long x3 = x2 ^ (((long) buffer[tempPos3]) << 28);
            if (x3 < 0) goto L24;
            x = 266354560 ^ x3;
            tempPos3 = tempPos5;
            goto L40
        L24:
            tempPos3 = tempPos5 + 1;
            long x4 = (((long) buffer[tempPos5]) << 35) ^ x3;
            if (x4 >= 0) goto L27;
            x = (-34093383808L) ^ x4;
            goto L40
        L27:
            int tempPos6 = tempPos3 + 1;
            long x5 = (((long) buffer[tempPos3]) << 42) ^ x4;
            if (x5 < 0) goto L30;
            x = 4363953127296L ^ x5;
            tempPos3 = tempPos6;
            goto L40
        L30:
            tempPos3 = tempPos6 + 1;
            long x6 = (((long) buffer[tempPos6]) << 49) ^ x5;
            if (x6 >= 0) goto L33;
            x = (-558586000294016L) ^ x6;
            goto L40
        L33:
            int tempPos7 = tempPos3 + 1;
            x = ((((long) buffer[tempPos3]) << 56) ^ x6) ^ 71499008037633920L;
            if (x >= 0) goto L39;
            tempPos3 = tempPos7 + 1;
            if (buffer[tempPos7] >= 0) goto L40;
        L39:
            tempPos3 = tempPos7;
        L38:
            return readRawVarint64SlowPath();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            int shift = 0;
        L4:
            if (shift >= 64) goto L10;
            byte b = readRawByte();
            result = result | (((long) (b & 127)) << shift);
            if ((b & 128) == 0) goto L7;
            shift = shift + 7;
            goto L4
        L7:
            return result;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int tempPos = this.pos;
            if ((this.bufferSize - tempPos) >= 4) goto L5;
            refillBuffer(4);
            tempPos = this.pos;
        L5:
            byte[] buffer = this.buffer;
            this.pos = tempPos + 4;
            return (((buffer[tempPos] & CecDeviceType.INACTIVE) | ((buffer[tempPos + 1] & CecDeviceType.INACTIVE) << 8)) | ((buffer[tempPos + 2] & CecDeviceType.INACTIVE) << 16)) | ((buffer[tempPos + 3] & CecDeviceType.INACTIVE) << 24);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int tempPos = this.pos;
            if ((this.bufferSize - tempPos) >= 8) goto L5;
            refillBuffer(8);
            tempPos = this.pos;
        L5:
            byte[] buffer = this.buffer;
            this.pos = tempPos + 8;
            return (((((((((long) buffer[tempPos]) & 255) | ((((long) buffer[tempPos + 1]) & 255) << 8)) | ((((long) buffer[tempPos + 2]) & 255) << 16)) | ((((long) buffer[tempPos + 3]) & 255) << 24)) | ((((long) buffer[tempPos + 4]) & 255) << 32)) | ((((long) buffer[tempPos + 5]) & 255) << 40)) | ((((long) buffer[tempPos + 6]) & 255) << 48)) | ((((long) buffer[tempPos + 7]) & 255) << 56);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L10;
            int byteLimit2 = byteLimit + (this.totalBytesRetired + this.pos);
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) goto L8;
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            this.bufferSize += this.bufferSizeAfterLimit;
            int bufferEnd = this.totalBytesRetired + this.bufferSize;
            if (bufferEnd <= this.currentLimit) goto L5;
            this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit != Integer.MAX_VALUE) goto L6;
            return -1;
        L6:
            int currentAbsolutePosition = this.totalBytesRetired + this.pos;
            return this.currentLimit - currentAbsolutePosition;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos == this.bufferSize) goto L5;
        L7:
            return false;
        L5:
            if (tryRefillBuffer(1) == true) goto L7;
            return true;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int n) throws IOException {
            if (tryRefillBuffer(n) == false) goto L5;
            return;
        L5:
            if (n <= ((this.sizeLimit - this.totalBytesRetired) - this.pos)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean tryRefillBuffer(int n) throws IOException {
            if ((this.pos + n) <= this.bufferSize) goto L35;
            if (n <= ((this.sizeLimit - this.totalBytesRetired) - this.pos)) goto L8;
            return false;
        L8:
            if (((this.totalBytesRetired + this.pos) + n) <= this.currentLimit) goto L11;
            return false;
        L11:
            if (this.refillCallback == null) goto L13;
            this.refillCallback.onRefill();
        L13:
            int tempPos = this.pos;
            if (tempPos > 0) goto L16;
        L19:
            int bytesRead = read(this.input, this.buffer, this.bufferSize, Math.min(this.buffer.length - this.bufferSize, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
            if (bytesRead == 0) goto L33;
            if (bytesRead < (-1)) goto L33;
            if (bytesRead > this.buffer.length) goto L33;
            if (bytesRead <= 0) goto L31;
            this.bufferSize += bytesRead;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize < n) goto L30;
            return true;
        L30:
            return tryRefillBuffer(n);
        L31:
            return false;
        L33:
            throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + bytesRead + "\nThe InputStream implementation is buggy.");
        L16:
            if (this.bufferSize <= tempPos) goto L18;
            System.arraycopy(this.buffer, tempPos, this.buffer, 0, this.bufferSize - tempPos);
        L18:
            this.totalBytesRetired += tempPos;
            this.bufferSize -= tempPos;
            this.pos = 0;
            goto L19
        L35:
            throw new IllegalStateException("refillBuffer() called when " + n + " bytes were already available in buffer");
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos != this.bufferSize) goto L5;
            refillBuffer(1);
        L5:
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 + 1;
            return r0[r1];
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readRawBytes(int size) throws IOException {
            int tempPos = this.pos;
            if (size > (this.bufferSize - tempPos)) goto L8;
            if (size <= 0) goto L8;
            this.pos = tempPos + size;
            return Arrays.copyOfRange(this.buffer, tempPos, tempPos + size);
        L8:
            return readRawBytesSlowPath(size, false);
        }

        private byte[] readRawBytesSlowPath(int size, boolean ensureNoLeakedReferences) throws IOException {
            byte[] result = readRawBytesSlowPathOneChunk(size);
            if (result == null) goto L8;
            if (ensureNoLeakedReferences == false) goto L7;
            return (byte[]) result.clone();
        L7:
            return result;
        L8:
            int originalBufferPos = this.pos;
            int bufferedBytes = this.bufferSize - this.pos;
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            int sizeLeft = size - bufferedBytes;
            List<byte[]> chunks = readRawBytesSlowPathRemainingChunks(sizeLeft);
            byte[] bytes = new byte[size];
            System.arraycopy(this.buffer, originalBufferPos, bytes, 0, bufferedBytes);
            int tempPos = bufferedBytes;
            Iterator<byte[]> r8 = chunks.iterator();
        L10:
            if (r8.hasNext() == false) goto L12;
            byte[] chunk = r8.next();
            System.arraycopy(chunk, 0, bytes, tempPos, chunk.length);
            tempPos = tempPos + chunk.length;
            goto L10
        L12:
            return bytes;
        }

        private byte[] readRawBytesSlowPathOneChunk(int size) throws IOException {
            if (size == 0) goto L4;
            if (size < 0) goto L31;
            int currentMessageSize = (this.totalBytesRetired + this.pos) + size;
            if ((currentMessageSize - this.sizeLimit) > 0) goto L29;
            if (currentMessageSize > this.currentLimit) goto L26;
            int bufferedBytes = this.bufferSize - this.pos;
            int sizeLeft = size - bufferedBytes;
            if (sizeLeft >= 4096) goto L13;
        L17:
            byte[] bytes = new byte[size];
            System.arraycopy(this.buffer, this.pos, bytes, 0, bufferedBytes);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            int tempPos = bufferedBytes;
        L19:
            if (tempPos >= bytes.length) goto L25;
            int n = read(this.input, bytes, tempPos, size - tempPos);
            if (n == (-1)) goto L24;
            this.totalBytesRetired += n;
            tempPos = tempPos + n;
            goto L19
        L24:
            throw InvalidProtocolBufferException.truncatedMessage();
        L25:
            return bytes;
        L13:
            if (sizeLeft <= available(this.input)) goto L17;
            return null;
        L26:
            skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.pos);
            throw InvalidProtocolBufferException.truncatedMessage();
        L29:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L31:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return Internal.EMPTY_BYTE_ARRAY;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int sizeLeft) throws IOException {
            List<byte[]> chunks = new ArrayList();
        L3:
            if (sizeLeft <= 0) goto L13;
            byte[] chunk = new byte[Math.min(sizeLeft, 4096)];
            int tempPos = 0;
        L6:
            if (tempPos >= chunk.length) goto L12;
            int n = this.input.read(chunk, tempPos, chunk.length - tempPos);
            if (n == (-1)) goto L11;
            this.totalBytesRetired += n;
            tempPos = tempPos + n;
            goto L6
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L12:
            sizeLeft = sizeLeft - chunk.length;
            chunks.add(chunk);
            goto L3
        L13:
            return chunks;
        }

        private ByteString readBytesSlowPath(int size) throws IOException {
            byte[] result = readRawBytesSlowPathOneChunk(size);
            if (result != null) goto L5;
            int originalBufferPos = this.pos;
            int bufferedBytes = this.bufferSize - this.pos;
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            int sizeLeft = size - bufferedBytes;
            List<byte[]> chunks = readRawBytesSlowPathRemainingChunks(sizeLeft);
            byte[] bytes = new byte[size];
            System.arraycopy(this.buffer, originalBufferPos, bytes, 0, bufferedBytes);
            int tempPos = bufferedBytes;
            Iterator<byte[]> r8 = chunks.iterator();
        L8:
            if (r8.hasNext() == false) goto L11;
            byte[] chunk = r8.next();
            System.arraycopy(chunk, 0, bytes, tempPos, chunk.length);
            tempPos = tempPos + chunk.length;
            goto L8
        L11:
            return ByteString.wrap(bytes);
        L5:
            return ByteString.copyFrom(result);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipRawBytes(int size) throws IOException {
            if (size > (this.bufferSize - this.pos)) goto L6;
            if (size < 0) goto L6;
            this.pos += size;
            return;
        L6:
            skipRawBytesSlowPath(size);
        }

        private void skipRawBytesSlowPath(int size) throws IOException {
            if (size < 0) goto L34;
            if (((this.totalBytesRetired + this.pos) + size) > this.currentLimit) goto L31;
            int totalSkipped = 0;
            if (this.refillCallback != null) goto L24;
            this.totalBytesRetired += this.pos;
            int totalSkipped2 = this.bufferSize - this.pos;
            this.bufferSize = 0;
            this.pos = 0;
            totalSkipped = totalSkipped2;
        L8:
            if (totalSkipped >= size) goto L23;
            int toSkip = size - totalSkipped;
            long skipped = skip(this.input, toSkip);     // Catch: Throwable -> L20
            if (skipped < 0) goto L19;
            if (skipped > toSkip) goto L19;
            if (skipped == 0) goto L23;
            totalSkipped = totalSkipped + ((int) skipped);     // Catch: Throwable -> L20
        L19:
            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skipped + "\nThe InputStream implementation is buggy.");     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            this.totalBytesRetired += totalSkipped;
            recomputeBufferSizeAfterLimit();
            throw th;
        L23:
            this.totalBytesRetired += totalSkipped;
            recomputeBufferSizeAfterLimit();
        L24:
            if (totalSkipped >= size) goto L42;
            int tempPos = this.bufferSize - this.pos;
            this.pos = this.bufferSize;
            refillBuffer(1);
        L27:
            if ((size - tempPos) <= this.bufferSize) goto L29;
            tempPos = tempPos + this.bufferSize;
            this.pos = this.bufferSize;
            refillBuffer(1);
            goto L27
        L29:
            this.pos = size - tempPos;
            return;
        L42:
            return;
        L31:
            int totalSkipped3 = this.currentLimit;
            skipRawBytes((totalSkipped3 - this.totalBytesRetired) - this.pos);
            throw InvalidProtocolBufferException.truncatedMessage();
        L34:
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        /* synthetic */ UnsafeDirectNioDecoder(ByteBuffer x0, boolean x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(ByteBuffer buffer, boolean immutable) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.address = UnsafeUtil.addressOffset(buffer);
            this.limit = this.address + ((long) buffer.limit());
            this.pos = this.address + ((long) buffer.position());
            this.startPos = this.pos;
            this.immutable = immutable;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            skipRawBytes(4);
            return true;
        L8:
            return false;
        L10:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L12:
            skipRawBytes(readRawVarint32());
            return true;
        L14:
            skipRawBytes(8);
            return true;
        L16:
            skipRawVarint();
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch(WireFormat.getTagWireType(tag)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            int value = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(value);
            return true;
        L8:
            return false;
        L10:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(endtag);
            output.writeUInt32NoTag(endtag);
            return true;
        L12:
            ByteString value2 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(value2);
            return true;
        L14:
            long value3 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(value3);
            return true;
        L16:
            long value4 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(value4);
            return true;
        L5:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int tag = readTag();
            if (tag == 0) goto L8;
            if (skipField(tag, output) == true) goto L2;
            return;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size != 0) goto L11;
            return "";
        L11:
            if (size >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (size > remaining()) goto L8;
            byte[] bytes = new byte[size];
            UnsafeUtil.copyMemory(this.pos, bytes, 0, size);
            String result = new String(bytes, Internal.UTF_8);
            this.pos += (long) size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L8:
            if (size != 0) goto L11;
            return "";
        L11:
            if (size > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (size > remaining()) goto L8;
            int bufferPos = bufferPos(this.pos);
            String result = Utf8.decodeUtf8(this.buffer, bufferPos, size);
            this.pos += (long) size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(oldLimit);
            return result;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L14:
            if (size == 0) goto L16;
            if (size >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return ByteString.EMPTY;
        L5:
            if (size > remaining()) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] bytes = new byte[size];
            UnsafeUtil.copyMemory(this.pos, bytes, 0, size);
            this.pos += (long) size;
            return ByteString.wrap(bytes);
        L9:
            if (this.enableAliasing == false) goto L12;
            ByteBuffer result = slice(this.pos, this.pos + ((long) size));
            this.pos += (long) size;
            return ByteString.wrap(result);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size > 0) goto L5;
        L14:
            if (size == 0) goto L16;
            if (size >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        L5:
            if (size > remaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] bytes = new byte[size];
            UnsafeUtil.copyMemory(this.pos, bytes, 0, size);
            this.pos += (long) size;
            return ByteBuffer.wrap(bytes);
        L9:
            if (this.enableAliasing == false) goto L12;
            ByteBuffer result = slice(this.pos, this.pos + ((long) size));
            this.pos += (long) size;
            return result;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            long tempPos = this.pos;
            if (this.limit == tempPos) goto L34;
            long tempPos2 = tempPos + 1;
            int x = UnsafeUtil.getByte(tempPos);
            if (x < 0) goto L10;
            this.pos = tempPos2;
            return x;
        L10:
            if ((this.limit - tempPos2) < 9) goto L34;
            long tempPos3 = tempPos2 + 1;
            int x2 = (UnsafeUtil.getByte(tempPos2) << 7) ^ x;
            if (x2 >= 0) goto L15;
            int y = x2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L41:
            this.pos = tempPos3;
            return y;
        L15:
            long tempPos4 = tempPos3 + 1;
            int x3 = (UnsafeUtil.getByte(tempPos3) << 14) ^ x2;
            if (x3 < 0) goto L18;
            y = x3 ^ 16256;
            tempPos3 = tempPos4;
            goto L41
        L18:
            tempPos3 = tempPos4 + 1;
            int x4 = (UnsafeUtil.getByte(tempPos4) << ParameterName.BLUE_STRETCH) ^ x3;
            if (x4 >= 0) goto L21;
            y = (-2080896) ^ x4;
            goto L41
        L21:
            long tempPos5 = tempPos3 + 1;
            int y2 = UnsafeUtil.getByte(tempPos3);
            int x5 = (x4 ^ (y2 << 28)) ^ 266354560;
            if (y2 >= 0) goto L40;
            tempPos3 = tempPos5 + 1;
            if (UnsafeUtil.getByte(tempPos5) >= 0) goto L39;
            long tempPos6 = tempPos3 + 1;
            if (UnsafeUtil.getByte(tempPos3) >= 0) goto L38;
            tempPos3 = tempPos6 + 1;
            if (UnsafeUtil.getByte(tempPos6) >= 0) goto L37;
            long tempPos7 = tempPos3 + 1;
            if (UnsafeUtil.getByte(tempPos3) >= 0) goto L36;
            tempPos3 = tempPos7 + 1;
            if (UnsafeUtil.getByte(tempPos7) < 0) goto L34;
            y = x5;
            goto L41
        L36:
            y = x5;
            tempPos3 = tempPos7;
            goto L41
        L37:
            y = x5;
            goto L41
        L38:
            y = x5;
            tempPos3 = tempPos6;
            goto L41
        L39:
            y = x5;
            goto L41
        L40:
            y = x5;
            tempPos3 = tempPos5;
        L34:
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (remaining() < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            long r1 = this.pos;
            this.pos = 1 + r1;
            if (UnsafeUtil.getByte(r1) >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long tempPos = this.pos;
            if (this.limit == tempPos) goto L38;
            long tempPos2 = tempPos + 1;
            int y = UnsafeUtil.getByte(tempPos);
            if (y < 0) goto L10;
            this.pos = tempPos2;
            return y;
        L10:
            if ((this.limit - tempPos2) < 9) goto L38;
            long tempPos3 = tempPos2 + 1;
            int y2 = (UnsafeUtil.getByte(tempPos2) << 7) ^ y;
            if (y2 >= 0) goto L15;
            long x = y2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L41:
            this.pos = tempPos3;
            return x;
        L15:
            long tempPos4 = tempPos3 + 1;
            int y3 = (UnsafeUtil.getByte(tempPos3) << 14) ^ y2;
            if (y3 < 0) goto L18;
            x = y3 ^ 16256;
            tempPos3 = tempPos4;
            goto L41
        L18:
            tempPos3 = tempPos4 + 1;
            int y4 = (UnsafeUtil.getByte(tempPos4) << ParameterName.BLUE_STRETCH) ^ y3;
            if (y4 >= 0) goto L21;
            x = (-2080896) ^ y4;
            goto L41
        L21:
            long tempPos5 = tempPos3 + 1;
            long x2 = ((long) y4) ^ (((long) UnsafeUtil.getByte(tempPos3)) << 28);
            if (x2 < 0) goto L24;
            x = 266354560 ^ x2;
            tempPos3 = tempPos5;
            goto L41
        L24:
            long tempPos6 = tempPos5 + 1;
            long x3 = (((long) UnsafeUtil.getByte(tempPos5)) << 35) ^ x2;
            if (x3 >= 0) goto L27;
            x = (-34093383808L) ^ x3;
            tempPos3 = tempPos6;
            goto L41
        L27:
            long tempPos7 = tempPos6 + 1;
            long x4 = (((long) UnsafeUtil.getByte(tempPos6)) << 42) ^ x3;
            if (x4 < 0) goto L30;
            x = 4363953127296L ^ x4;
            tempPos3 = tempPos7;
            goto L41
        L30:
            long tempPos8 = tempPos7 + 1;
            long x5 = (((long) UnsafeUtil.getByte(tempPos7)) << 49) ^ x4;
            if (x5 >= 0) goto L33;
            x = (-558586000294016L) ^ x5;
            tempPos3 = tempPos8;
            goto L41
        L33:
            long tempPos9 = tempPos8 + 1;
            long x6 = ((((long) UnsafeUtil.getByte(tempPos8)) << 56) ^ x5) ^ 71499008037633920L;
            if (x6 >= 0) goto L40;
            tempPos3 = tempPos9 + 1;
            if (UnsafeUtil.getByte(tempPos9) < 0) goto L38;
            x = x6;
            goto L41
        L40:
            x = x6;
            tempPos3 = tempPos9;
        L38:
            return readRawVarint64SlowPath();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            int shift = 0;
        L4:
            if (shift >= 64) goto L10;
            byte b = readRawByte();
            result = result | (((long) (b & 127)) << shift);
            if ((b & 128) == 0) goto L7;
            shift = shift + 7;
            goto L4
        L7:
            return result;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long tempPos = this.pos;
            if ((this.limit - tempPos) < 4) goto L7;
            this.pos = 4 + tempPos;
            return (((UnsafeUtil.getByte(tempPos) & CecDeviceType.INACTIVE) | ((UnsafeUtil.getByte(1 + tempPos) & CecDeviceType.INACTIVE) << 8)) | ((UnsafeUtil.getByte(2 + tempPos) & CecDeviceType.INACTIVE) << 16)) | ((UnsafeUtil.getByte(3 + tempPos) & CecDeviceType.INACTIVE) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long tempPos = this.pos;
            if ((this.limit - tempPos) < 8) goto L7;
            this.pos = 8 + tempPos;
            return (((((((((long) UnsafeUtil.getByte(tempPos)) & 255) | ((((long) UnsafeUtil.getByte(1 + tempPos)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + tempPos)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + tempPos)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + tempPos)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + tempPos)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + tempPos)) & 255) << 48)) | ((255 & ((long) UnsafeUtil.getByte(7 + tempPos))) << 56);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L10;
            int byteLimit2 = byteLimit + getTotalBytesRead();
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) goto L8;
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return this.currentLimit - getTotalBytesRead();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.limit) goto L7;
            long r0 = this.pos;
            this.pos = 1 + r0;
            return UnsafeUtil.getByte(r0);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length >= 0) goto L4;
        L7:
            if (length > 0) goto L14;
            if (length != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > remaining()) goto L7;
            byte[] bytes = new byte[length];
            slice(this.pos, this.pos + ((long) length)).get(bytes);
            this.pos += (long) length;
            return bytes;
        }

        @Override // com.bytedance.location.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0) goto L4;
        L7:
            if (length >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > remaining()) goto L7;
            this.pos += (long) length;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += (long) this.bufferSizeAfterLimit;
            int bufferEnd = (int) (this.limit - this.startPos);
            if (bufferEnd <= this.currentLimit) goto L5;
            this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
            this.limit -= (long) this.bufferSizeAfterLimit;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }

        private ByteBuffer slice(long begin, long end) throws IOException {
            int prevPos = this.buffer.position();
            int prevLimit = this.buffer.limit();
            Buffer asBuffer = this.buffer;
            asBuffer.position(bufferPos(begin));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            asBuffer.limit(bufferPos(end));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r3 = this.buffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            asBuffer.position(prevPos);
            asBuffer.limit(prevLimit);
            return r3;
        L8:
            e = move-exception;
            InvalidProtocolBufferException ex = InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
            ex.initCause(e);     // Catch: Throwable -> L6
            throw ex;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            asBuffer.position(prevPos);
            asBuffer.limit(prevLimit);
            throw th;
        }
    }

    public abstract void checkLastTagWas(int r1) throws InvalidProtocolBufferException;

    public abstract void enableAliasing(boolean r1);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int r1);

    public abstract int pushLimit(int r1) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int r1, Parser<T> r2, ExtensionRegistryLite r3) throws IOException;

    public abstract void readGroup(int r1, MessageLite.Builder r2, ExtensionRegistryLite r3) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> r1, ExtensionRegistryLite r2) throws IOException;

    public abstract void readMessage(MessageLite.Builder r1, ExtensionRegistryLite r2) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int r1) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int r1, MessageLite.Builder r2) throws IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(int r1) throws IOException;

    @Deprecated
    public abstract boolean skipField(int r1, CodedOutputStream r2) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream r1) throws IOException;

    public abstract void skipRawBytes(int r1) throws IOException;

    /* synthetic */ CodedInputStream(AnonymousClass1 x0) {
        this();
    }

    static {
        defaultRecursionLimit = 100;
    }

    public static CodedInputStream newInstance(InputStream input) {
        return newInstance(input, 4096);
    }

    public static CodedInputStream newInstance(InputStream input, int bufferSize) {
        if (bufferSize <= 0) goto L9;
        if (input != null) goto L7;
        return newInstance(Internal.EMPTY_BYTE_ARRAY);
    L7:
        return new StreamDecoder(input, bufferSize, null);
    L9:
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> input) {
        if (UnsafeDirectNioDecoder.isSupported() == true) goto L7;
        return newInstance(new IterableByteBufferInputStream(input));
    L7:
        return newInstance(input, false);
    }

    static CodedInputStream newInstance(Iterable<ByteBuffer> bufs, boolean bufferIsImmutable) {
        int flag = 0;
        int totalSize = 0;
        Iterator<ByteBuffer> r2 = bufs.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        ByteBuffer buf = r2.next();
        totalSize = totalSize + buf.remaining();
        if (buf.hasArray() == true) goto L7;
        if (buf.isDirect() == true) goto L10;
        flag = flag | 4;
        goto L4
    L10:
        flag = flag | 2;
        goto L4
    L7:
        flag = flag | 1;
        goto L4
    L14:
        if (flag != 2) goto L18;
        return new IterableDirectByteBufferDecoder(bufs, totalSize, bufferIsImmutable, null);
    L18:
        return newInstance(new IterableByteBufferInputStream(bufs));
    }

    public static CodedInputStream newInstance(byte[] buf) {
        return newInstance(buf, 0, buf.length);
    }

    public static CodedInputStream newInstance(byte[] buf, int off, int len) {
        return newInstance(buf, off, len, false);
    }

    static CodedInputStream newInstance(byte[] buf, int off, int len, boolean bufferIsImmutable) {
        ArrayDecoder result = new ArrayDecoder(buf, off, len, bufferIsImmutable, null);
        result.pushLimit(len);     // Catch: InvalidProtocolBufferException -> L5
        return result;
    L5:
        ex = move-exception;
        throw new IllegalArgumentException(ex);
    }

    public static CodedInputStream newInstance(ByteBuffer buf) {
        return newInstance(buf, false);
    }

    static CodedInputStream newInstance(ByteBuffer buf, boolean bufferIsImmutable) {
        if (buf.hasArray() == false) goto L7;
        return newInstance(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining(), bufferIsImmutable);
    L7:
        if (buf.isDirect() == true) goto L9;
    L12:
        byte[] buffer = new byte[buf.remaining()];
        buf.duplicate().get(buffer);
        return newInstance(buffer, 0, buffer.length, true);
    L9:
        if (UnsafeDirectNioDecoder.isSupported() == false) goto L12;
        return new UnsafeDirectNioDecoder(buf, bufferIsImmutable, null);
    }

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public final int setRecursionLimit(int limit) {
        if (limit < 0) goto L6;
        int oldLimit = this.recursionLimit;
        this.recursionLimit = limit;
        return oldLimit;
    L6:
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
    }

    public final int setSizeLimit(int limit) {
        if (limit < 0) goto L6;
        int oldLimit = this.sizeLimit;
        this.sizeLimit = limit;
        return oldLimit;
    L6:
        throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int decodeZigZag32(int n) {
        return (n >>> 1) ^ (-(n & 1));
    }

    public static long decodeZigZag64(long n) {
        return (n >>> 1) ^ (-(1 & n));
    }

    public static int readRawVarint32(int firstByte, InputStream input) throws IOException {
        if ((firstByte & 128) != 0) goto L5;
        return firstByte;
    L5:
        int result = firstByte & 127;
        int offset = 7;
    L7:
        if (offset >= 32) goto L17;
        int b = input.read();
        if (b == (-1)) goto L15;
        result = result | ((b & 127) << offset);
        if ((b & 128) == 0) goto L12;
        offset = offset + 7;
        goto L7
    L12:
        return result;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (offset >= 64) goto L27;
        int b2 = input.read();
        if (b2 == (-1)) goto L25;
        if ((b2 & 128) == 0) goto L22;
        offset = offset + 7;
        goto L17
    L22:
        return result;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream input) throws IOException {
        int firstByte = input.read();
        if (firstByte == (-1)) goto L7;
        return readRawVarint32(firstByte, input);
    L7:
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
