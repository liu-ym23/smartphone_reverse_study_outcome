package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
public final class CodedInputStream {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    public interface RefillCallback {
        void onRefill();
    }

    public class SkippedDataSink implements RefillCallback {
        private ByteArrayOutputStream byteArrayStream;
        private int lastPos;
        final /* synthetic */ CodedInputStream this$0;

        private SkippedDataSink(CodedInputStream r10) {
            this.this$0 = r10;
            this.lastPos = CodedInputStream.access$000(r10);
        }

        public ByteBuffer getSkippedData() {
            ByteArrayOutputStream r10 = this.byteArrayStream;
            if (r10 == null) goto L5;
            r10.write(CodedInputStream.access$100(this.this$0), this.lastPos, CodedInputStream.access$000(this.this$0));
            return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
        L5:
            return ByteBuffer.wrap(CodedInputStream.access$100(this.this$0), this.lastPos, CodedInputStream.access$000(this.this$0) - this.lastPos);
        }

        @Override // com.google.protobuf.CodedInputStream.RefillCallback
        public void onRefill() {
            if (this.byteArrayStream != null) goto L5;
            this.byteArrayStream = new ByteArrayOutputStream();
        L5:
            this.byteArrayStream.write(CodedInputStream.access$100(this.this$0), this.lastPos, CodedInputStream.access$000(this.this$0) - this.lastPos);
            this.lastPos = 0;
        }
    }

    private CodedInputStream(byte[] r10, int r11, int r12, boolean r13) {
        this.enableAliasing = false;
        this.currentLimit = Channel.UNLIMITED;
        this.recursionLimit = 100;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.refillCallback = null;
        this.buffer = r10;
        this.bufferSize = r12 + r11;
        this.bufferPos = r11;
        this.totalBytesRetired = -r11;
        this.input = null;
        this.bufferIsImmutable = r13;
    }

    public static /* synthetic */ int access$000(CodedInputStream r10) {
        return r10.bufferPos;
    }

    public static /* synthetic */ byte[] access$100(CodedInputStream r10) {
        return r10.buffer;
    }

    public static int decodeZigZag32(int r10) {
        int r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    public static long decodeZigZag64(long r10) {
        long r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    public static CodedInputStream newInstance(InputStream r10) {
        return new CodedInputStream(r10, 4096);
    }

    private byte[] readRawBytesSlowPath(int r13) throws IOException {
        if (r13 > 0) goto L8;
        if (r13 != 0) goto L7;
        return Internal.EMPTY_BYTE_ARRAY;
    L7:
        throw InvalidProtocolBufferException.negativeSize();
    L8:
        int r10 = this.totalBytesRetired;
        int r11 = this.bufferPos;
        int r12 = (r10 + r11) + r13;
        if (r12 > this.sizeLimit) goto L47;
        int r14 = this.currentLimit;
        if (r12 > r14) goto L44;
        InputStream r15 = this.input;
        if (r15 == null) goto L43;
        int r16 = this.bufferSize;
        int r17 = r16 - r11;
        this.totalBytesRetired = r10 + r16;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int r18 = r13 - r17;
        if (r18 >= 4096) goto L17;
    L34:
        byte[] r19 = new byte[r13];
        System.arraycopy(this.buffer, r11, r19, 0, r17);
    L35:
        if (r17 >= r13) goto L41;
        int r20 = this.input.read(r19, r17, r13 - r17);
        if (r20 == (-1)) goto L40;
        this.totalBytesRetired += r20;
        r17 = r17 + r20;
        goto L35
    L40:
        throw InvalidProtocolBufferException.truncatedMessage();
    L41:
        return r19;
    L17:
        if (r18 <= r15.available()) goto L34;
        ArrayList r21 = new ArrayList();
    L20:
        if (r18 <= 0) goto L29;
        int r22 = Math.min(r18, 4096);
        byte[] r23 = new byte[r22];
        int r24 = 0;
    L22:
        if (r24 >= r22) goto L28;
        int r110 = this.input.read(r23, r24, r22 - r24);
        if (r110 == (-1)) goto L27;
        this.totalBytesRetired += r110;
        r24 = r24 + r110;
        goto L22
    L27:
        throw InvalidProtocolBufferException.truncatedMessage();
    L28:
        r18 = r18 - r22;
        r21.add(r23);
        goto L20
    L29:
        byte[] r111 = new byte[r13];
        System.arraycopy(this.buffer, r11, r111, 0, r17);
        Iterator r112 = r21.iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        byte[] r25 = (byte[]) r112.next();
        System.arraycopy(r25, 0, r111, r17, r25.length);
        r17 = r17 + r25.length;
        goto L31
    L33:
        return r111;
    L43:
        throw InvalidProtocolBufferException.truncatedMessage();
    L44:
        skipRawBytes((r14 - r10) - r11);
        throw InvalidProtocolBufferException.truncatedMessage();
    L47:
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    }

    private void recomputeBufferSizeAfterLimit() {
        int r10 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = r10;
        int r11 = this.totalBytesRetired + r10;
        int r12 = this.currentLimit;
        if (r11 <= r12) goto L5;
        int r13 = r11 - r12;
        this.bufferSizeAfterLimit = r13;
        this.bufferSize = r10 - r13;
        return;
    L5:
        this.bufferSizeAfterLimit = 0;
    }

    private void refillBuffer(int r10) throws IOException {
        if (tryRefillBuffer(r10) == false) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void skipRawBytesSlowPath(int r10) throws IOException {
        if (r10 < 0) goto L14;
        int r11 = this.totalBytesRetired;
        int r12 = this.bufferPos;
        int r13 = (r11 + r12) + r10;
        int r14 = this.currentLimit;
        if (r13 > r14) goto L11;
        int r15 = this.bufferSize;
        int r16 = r15 - r12;
        this.bufferPos = r15;
        refillBuffer(1);
    L6:
        int r17 = r10 - r16;
        int r18 = this.bufferSize;
        if (r17 <= r18) goto L9;
        r16 = r16 + r18;
        this.bufferPos = r18;
        refillBuffer(1);
        goto L6
    L9:
        this.bufferPos = r17;
        return;
    L11:
        skipRawBytes((r14 - r11) - r12);
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    private void skipRawVarint() throws IOException {
        int r10 = this.bufferSize;
        int r11 = this.bufferPos;
        if ((r10 - r11) < 10) goto L11;
        byte[] r12 = this.buffer;
        int r13 = 0;
    L5:
        if (r13 >= 10) goto L11;
        int r14 = r11 + 1;
        if (r12[r11] >= 0) goto L8;
        r13 = r13 + 1;
        r11 = r14;
        goto L5
    L8:
        this.bufferPos = r14;
        return;
    L11:
        skipRawVarintSlowPath();
    }

    private void skipRawVarintSlowPath() throws IOException {
        int r10 = 0;
    L4:
        if (r10 >= 10) goto L10;
        if (readRawByte() >= 0) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return;
    L10:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private boolean tryRefillBuffer(int r10) throws IOException {
        int r11 = this.bufferPos;
        if ((r11 + r10) <= this.bufferSize) goto L38;
        if (((this.totalBytesRetired + r11) + r10) <= this.currentLimit) goto L7;
        return false;
    L7:
        RefillCallback r12 = this.refillCallback;
        if (r12 == null) goto L11;
        r12.onRefill();
    L11:
        if (this.input == null) goto L36;
        int r13 = this.bufferPos;
        if (r13 <= 0) goto L18;
        int r14 = this.bufferSize;
        if (r14 <= r13) goto L17;
        byte[] r15 = this.buffer;
        System.arraycopy(r15, r13, r15, 0, r14 - r13);
    L17:
        this.totalBytesRetired += r13;
        this.bufferSize -= r13;
        this.bufferPos = 0;
    L18:
        InputStream r16 = this.input;
        byte[] r17 = this.buffer;
        int r18 = this.bufferSize;
        int r19 = r16.read(r17, r18, r17.length - r18);
        if (r19 == 0) goto L35;
        if (r19 < (-1)) goto L35;
        if (r19 > this.buffer.length) goto L35;
        if (r19 <= 0) goto L36;
        this.bufferSize += r19;
        if (((this.totalBytesRetired + r10) - this.sizeLimit) > 0) goto L33;
        recomputeBufferSizeAfterLimit();
        if (this.bufferSize < r10) goto L31;
        return true;
    L31:
        return tryRefillBuffer(r10);
    L33:
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    L35:
        throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + r19 + "\nThe InputStream implementation is buggy.");
    L36:
        return false;
    L38:
        throw new IllegalStateException("refillBuffer() called when " + r10 + " bytes were already available in buffer");
    }

    public void checkLastTagWas(int r10) throws InvalidProtocolBufferException {
        if (this.lastTag != r10) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public void enableAliasing(boolean r10) {
        this.enableAliasing = r10;
    }

    public int getBytesUntilLimit() {
        int r10 = this.currentLimit;
        if (r10 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r10 - (this.totalBytesRetired + this.bufferPos);
    }

    public int getLastTag() {
        return this.lastTag;
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    public boolean isAtEnd() throws IOException {
        if (this.bufferPos == this.bufferSize) goto L5;
    L7:
        return false;
    L5:
        if (tryRefillBuffer(1) == true) goto L7;
        return true;
    }

    public void popLimit(int r10) {
        this.currentLimit = r10;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int r10) throws InvalidProtocolBufferException {
        if (r10 < 0) goto L10;
        int r11 = r10 + (this.totalBytesRetired + this.bufferPos);
        int r12 = this.currentLimit;
        if (r11 > r12) goto L8;
        this.currentLimit = r11;
        recomputeBufferSizeAfterLimit();
        return r12;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() throws IOException {
        if (readRawVarint64() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte[] readByteArray() throws IOException {
        int r10 = readRawVarint32();
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L8;
        if (r10 <= 0) goto L8;
        byte[] r13 = Arrays.copyOfRange(this.buffer, r12, r12 + r10);
        this.bufferPos += r10;
        return r13;
    L8:
        return readRawBytesSlowPath(r10);
    }

    public ByteBuffer readByteBuffer() throws IOException {
        int r10 = readRawVarint32();
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L15;
        if (r10 <= 0) goto L15;
        if (this.input == null) goto L8;
    L12:
        ByteBuffer r13 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r12, r12 + r10));
    L13:
        this.bufferPos += r10;
        return r13;
    L8:
        if (this.bufferIsImmutable == true) goto L12;
        if (this.enableAliasing == false) goto L12;
        r13 = ByteBuffer.wrap(this.buffer, r12, r10).slice();
    L15:
        if (r10 != 0) goto L19;
        return Internal.EMPTY_BYTE_BUFFER;
    L19:
        return ByteBuffer.wrap(readRawBytesSlowPath(r10));
    }

    public ByteString readBytes() throws IOException {
        int r10 = readRawVarint32();
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L13;
        if (r10 <= 0) goto L13;
        if (this.bufferIsImmutable == true) goto L8;
    L10:
        ByteString r13 = ByteString.copyFrom(this.buffer, r12, r10);
    L11:
        this.bufferPos += r10;
        return r13;
    L8:
        if (this.enableAliasing == false) goto L10;
        r13 = ByteString.wrap(this.buffer, r12, r10);
    L13:
        if (r10 != 0) goto L17;
        return ByteString.EMPTY;
    L17:
        return ByteString.wrap(readRawBytesSlowPath(r10));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12) throws IOException {
        int r13 = this.recursionDepth;
        if (r13 >= this.recursionLimit) goto L7;
        this.recursionDepth = r13 + 1;
        r11.mergeFrom(this, r12);
        checkLastTagWas(WireFormat.makeTag(r10, 4));
        this.recursionDepth--;
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11) throws IOException {
        int r12 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r13 = pushLimit(r12);
        this.recursionDepth++;
        r10.mergeFrom(this, r11);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r13);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos != this.bufferSize) goto L5;
        refillBuffer(1);
    L5:
        byte[] r10 = this.buffer;
        int r11 = this.bufferPos;
        this.bufferPos = r11 + 1;
        return r10[r11];
    }

    public byte[] readRawBytes(int r10) throws IOException {
        int r11 = this.bufferPos;
        if (r10 > (this.bufferSize - r11)) goto L8;
        if (r10 <= 0) goto L8;
        int r12 = r10 + r11;
        this.bufferPos = r12;
        return Arrays.copyOfRange(this.buffer, r11, r12);
    L8:
        return readRawBytesSlowPath(r10);
    }

    public int readRawLittleEndian32() throws IOException {
        int r10 = this.bufferPos;
        if ((this.bufferSize - r10) >= 4) goto L5;
        refillBuffer(4);
        r10 = this.bufferPos;
    L5:
        byte[] r11 = this.buffer;
        this.bufferPos = r10 + 4;
        return (((r11[r10] & UnsignedBytes.MAX_VALUE) | ((r11[r10 + 1] & UnsignedBytes.MAX_VALUE) << 8)) | ((r11[r10 + 2] & UnsignedBytes.MAX_VALUE) << 16)) | ((r11[r10 + 3] & UnsignedBytes.MAX_VALUE) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
        int r10 = this.bufferPos;
        if ((this.bufferSize - r10) >= 8) goto L5;
        refillBuffer(8);
        r10 = this.bufferPos;
    L5:
        byte[] r11 = this.buffer;
        this.bufferPos = r10 + 8;
        long r12 = ((((((((long) r11[r10]) & 255) | ((((long) r11[r10 + 1]) & 255) << 8)) | ((((long) r11[r10 + 2]) & 255) << 16)) | ((((long) r11[r10 + 3]) & 255) << 24)) | ((((long) r11[r10 + 4]) & 255) << 32)) | ((((long) r11[r10 + 5]) & 255) << 40)) | ((((long) r11[r10 + 6]) & 255) << 48);
        return ((((long) r11[r10 + 7]) & 255) << 56) | r12;
    }

    public int readRawVarint32() throws IOException {
        int r10 = this.bufferPos;
        int r11 = this.bufferSize;
        if (r11 == r10) goto L36;
        byte[] r12 = this.buffer;
        int r13 = r10 + 1;
        byte r14 = r12[r10];
        if (r14 < 0) goto L10;
        this.bufferPos = r13;
        return r14;
    L10:
        if ((r11 - r13) < 9) goto L36;
        int r15 = r10 + 2;
        int r16 = (r12[r13] << 7) ^ r14;
        if (r16 >= 0) goto L15;
        int r17 = r16 ^ (-128);
    L40:
        this.bufferPos = r15;
        return r17;
    L15:
        int r18 = r10 + 3;
        int r19 = (r12[r15] << Ascii.SO) ^ r16;
        if (r19 < 0) goto L19;
        r17 = r19 ^ 16256;
    L18:
        r15 = r18;
        goto L40
    L19:
        int r20 = r10 + 4;
        int r21 = r19 ^ (r12[r18] << Ascii.NAK);
        if (r21 >= 0) goto L23;
        r17 = (-2080896) ^ r21;
    L22:
        r15 = r20;
        goto L40
    L23:
        r18 = r10 + 5;
        byte r22 = r12[r20];
        int r23 = (r21 ^ (r22 << Ascii.FS)) ^ 266354560;
        if (r22 >= 0) goto L38;
        r20 = r10 + 6;
        if (r12[r18] >= 0) goto L39;
        r18 = r10 + 7;
        if (r12[r20] >= 0) goto L38;
        r20 = r10 + 8;
        if (r12[r18] >= 0) goto L39;
        r18 = r10 + 9;
        if (r12[r20] >= 0) goto L38;
        int r24 = r10 + 10;
        if (r12[r18] < 0) goto L36;
        r15 = r24;
        r17 = r23;
    L39:
        r17 = r23;
    L38:
        r17 = r23;
    L36:
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() throws IOException {
        int r10 = this.bufferPos;
        int r11 = this.bufferSize;
        if (r11 == r10) goto L40;
        byte[] r12 = this.buffer;
        int r13 = r10 + 1;
        byte r14 = r12[r10];
        if (r14 < 0) goto L10;
        this.bufferPos = r13;
        return r14;
    L10:
        if ((r11 - r13) < 9) goto L40;
        int r15 = r10 + 2;
        int r16 = (r12[r13] << 7) ^ r14;
        if (r16 >= 0) goto L15;
        long r17 = r16 ^ (-128);
    L43:
        this.bufferPos = r15;
        return r17;
    L15:
        int r18 = r10 + 3;
        int r19 = (r12[r15] << Ascii.SO) ^ r16;
        if (r19 < 0) goto L18;
        r17 = r19 ^ 16256;
        r15 = r18;
        goto L43
    L18:
        int r20 = r10 + 4;
        int r21 = r19 ^ (r12[r18] << Ascii.NAK);
        if (r21 >= 0) goto L21;
        long r22 = (-2080896) ^ r21;
        r15 = r20;
        r17 = r22;
        goto L43
    L21:
        long r23 = r21;
        r15 = r10 + 5;
        long r24 = r23 ^ (((long) r12[r20]) << 28);
        if (r24 < 0) goto L25;
        long r25 = 266354560;
    L24:
        r17 = r24 ^ r25;
        goto L43
    L25:
        int r26 = r10 + 6;
        long r27 = r24 ^ (((long) r12[r15]) << 35);
        if (r27 >= 0) goto L29;
        long r28 = -34093383808L;
    L28:
        r17 = r27 ^ r28;
        r15 = r26;
        goto L43
    L29:
        r15 = r10 + 7;
        r24 = r27 ^ (((long) r12[r26]) << 42);
        if (r24 < 0) goto L32;
        r25 = 4363953127296L;
        goto L24
    L32:
        r26 = r10 + 8;
        r27 = r24 ^ (((long) r12[r15]) << 49);
        if (r27 >= 0) goto L35;
        r28 = -558586000294016L;
        goto L28
    L35:
        r15 = r10 + 9;
        long r29 = (r27 ^ (((long) r12[r26]) << 56)) ^ 71499008037633920L;
        if (r29 >= 0) goto L42;
        int r30 = r10 + 10;
        if (r12[r15] < 0) goto L40;
        r15 = r30;
    L42:
        r17 = r29;
    L40:
        return readRawVarint64SlowPath();
    }

    public long readRawVarint64SlowPath() throws IOException {
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= 64) goto L10;
        byte r12 = readRawByte();
        r10 = r10 | (((long) (r12 & Ascii.DEL)) << r11);
        if ((r12 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) goto L7;
        r11 = r11 + 7;
        goto L4
    L7:
        return r10;
    L10:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int r10 = readRawVarint32();
        int r11 = this.bufferSize;
        if (r10 > (r11 - this.bufferPos)) goto L7;
        if (r10 <= 0) goto L7;
        String r12 = new String(this.buffer, this.bufferPos, r10, Internal.UTF_8);
        this.bufferPos += r10;
        return r12;
    L7:
        if (r10 != 0) goto L10;
        return "";
    L10:
        if (r10 > r11) goto L14;
        refillBuffer(r10);
        String r13 = new String(this.buffer, this.bufferPos, r10, Internal.UTF_8);
        this.bufferPos += r10;
        return r13;
    L14:
        return new String(readRawBytesSlowPath(r10), Internal.UTF_8);
    }

    public String readStringRequireUtf8() throws IOException {
        int r10 = readRawVarint32();
        int r11 = this.bufferPos;
        int r12 = this.bufferSize;
        if (r10 > (r12 - r11)) goto L6;
        if (r10 <= 0) goto L6;
        byte[] r13 = this.buffer;
        this.bufferPos = r11 + r10;
    L14:
        if (Utf8.isValidUtf8(r13, r11, r11 + r10) == false) goto L18;
        return new String(r13, r11, r10, Internal.UTF_8);
    L18:
        throw InvalidProtocolBufferException.invalidUtf8();
    L6:
        if (r10 != 0) goto L9;
        return "";
    L9:
        r11 = 0;
        if (r10 > r12) goto L12;
        refillBuffer(r10);
        r13 = this.buffer;
        this.bufferPos = r10;
        goto L14
    L12:
        r13 = readRawBytesSlowPath(r10);
        goto L14
    }

    public int readTag() throws IOException {
        if (isAtEnd() == false) goto L6;
        this.lastTag = 0;
        return 0;
    L6:
        int r10 = readRawVarint32();
        this.lastTag = r10;
        if (WireFormat.getTagFieldNumber(r10) == 0) goto L11;
        return this.lastTag;
    L11:
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    @Deprecated
    public void readUnknownGroup(int r10, MessageLite.Builder r11) throws IOException {
        readGroup(r10, r11, null);
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }

    public int setRecursionLimit(int r10) {
        if (r10 < 0) goto L6;
        int r11 = this.recursionLimit;
        this.recursionLimit = r10;
        return r11;
    L6:
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + r10);
    }

    public int setSizeLimit(int r10) {
        if (r10 < 0) goto L6;
        int r11 = this.sizeLimit;
        this.sizeLimit = r10;
        return r11;
    L6:
        throw new IllegalArgumentException("Size limit cannot be negative: " + r10);
    }

    public boolean skipField(int r10) throws IOException {
        int r11 = WireFormat.getTagWireType(r10);
        if (r11 == 0) goto L24;
        if (r11 != 1) goto L6;
        skipRawBytes(8);
        return true;
    L6:
        if (r11 != 2) goto L8;
        skipRawBytes(readRawVarint32());
        return true;
    L8:
        if (r11 == 3) goto L18;
        if (r11 != 4) goto L11;
        return false;
    L11:
        if (r11 != 5) goto L15;
        skipRawBytes(4);
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        skipMessage();
        checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4));
        return true;
    L24:
        skipRawVarint();
        return true;
    }

    public void skipMessage() throws IOException {
    L2:
        int r10 = readTag();
        if (r10 == 0) goto L6;
        if (skipField(r10) == true) goto L2;
        return;
    }

    public void skipRawBytes(int r10) throws IOException {
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L6;
        if (r10 < 0) goto L6;
        this.bufferPos = r12 + r10;
        return;
    L6:
        skipRawBytesSlowPath(r10);
    }

    public static CodedInputStream newInstance(InputStream r10, int r11) {
        return new CodedInputStream(r10, r11);
    }

    public static CodedInputStream newInstance(byte[] r10) {
        return newInstance(r10, 0, r10.length);
    }

    public void skipMessage(CodedOutputStream r10) throws IOException {
    L2:
        int r11 = readTag();
        if (r11 == 0) goto L6;
        if (skipField(r11, r10) == true) goto L2;
        return;
    }

    public static CodedInputStream newInstance(byte[] r10, int r11, int r12) {
        return newInstance(r10, r11, r12, false);
    }

    public static CodedInputStream newInstance(byte[] r10, int r11, int r12, boolean r13) {
        CodedInputStream r14 = new CodedInputStream(r10, r11, r12, r13);
        r14.pushLimit(r12);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static CodedInputStream newInstance(ByteBuffer r10) {
        if (r10.hasArray() == true) goto L5;
        ByteBuffer r11 = r10.duplicate();
        byte[] r12 = new byte[r11.remaining()];
        r11.get(r12);
        return newInstance(r12);
    L5:
        return newInstance(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());
    }

    public <T extends MessageLite> T readGroup(int r10, Parser<T> r11, ExtensionRegistryLite r12) throws IOException {
        int r13 = this.recursionDepth;
        if (r13 >= this.recursionLimit) goto L7;
        this.recursionDepth = r13 + 1;
        T r14 = r11.parsePartialFrom(this, r12);
        checkLastTagWas(WireFormat.makeTag(r10, 4));
        this.recursionDepth--;
        return r14;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11) throws IOException {
        int r12 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r13 = pushLimit(r12);
        this.recursionDepth++;
        T r14 = r10.parsePartialFrom(this, r11);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r13);
        return r14;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public boolean skipField(int r10, CodedOutputStream r11) throws IOException {
        int r12 = WireFormat.getTagWireType(r10);
        if (r12 == 0) goto L24;
        if (r12 != 1) goto L6;
        long r13 = readRawLittleEndian64();
        r11.writeRawVarint32(r10);
        r11.writeFixed64NoTag(r13);
        return true;
    L6:
        if (r12 != 2) goto L8;
        ByteString r14 = readBytes();
        r11.writeRawVarint32(r10);
        r11.writeBytesNoTag(r14);
        return true;
    L8:
        if (r12 == 3) goto L18;
        if (r12 != 4) goto L11;
        return false;
    L11:
        if (r12 != 5) goto L15;
        int r15 = readRawLittleEndian32();
        r11.writeRawVarint32(r10);
        r11.writeFixed32NoTag(r15);
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        r11.writeRawVarint32(r10);
        skipMessage(r11);
        int r16 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4);
        checkLastTagWas(r16);
        r11.writeRawVarint32(r16);
        return true;
    L24:
        long r17 = readInt64();
        r11.writeRawVarint32(r10);
        r11.writeUInt64NoTag(r17);
        return true;
    }

    private CodedInputStream(InputStream r10, int r11) {
        this.enableAliasing = false;
        this.currentLimit = Channel.UNLIMITED;
        this.recursionLimit = 100;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.refillCallback = null;
        this.buffer = new byte[r11];
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = r10;
        this.bufferIsImmutable = false;
    }

    public static int readRawVarint32(InputStream r10) throws IOException {
        int r11 = r10.read();
        if (r11 == (-1)) goto L7;
        return readRawVarint32(r11, r10);
    L7:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int readRawVarint32(int r10, InputStream r11) throws IOException {
        if ((r10 & 128) != 0) goto L5;
        return r10;
    L5:
        int r12 = r10 & 127;
        int r13 = 7;
    L7:
        if (r13 >= 32) goto L17;
        int r14 = r11.read();
        if (r14 == (-1)) goto L15;
        r12 = r12 | ((r14 & 127) << r13);
        if ((r14 & 128) == 0) goto L12;
        r13 = r13 + 7;
        goto L7
    L12:
        return r12;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r13 >= 64) goto L27;
        int r15 = r11.read();
        if (r15 == (-1)) goto L25;
        if ((r15 & 128) == 0) goto L22;
        r13 = r13 + 7;
        goto L17
    L22:
        return r12;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }
}
