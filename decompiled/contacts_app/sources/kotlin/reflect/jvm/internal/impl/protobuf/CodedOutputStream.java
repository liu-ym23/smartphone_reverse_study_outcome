package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;
    private int totalBytesWritten;

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public static int computeBoolSizeNoTag(boolean r0) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(double r0) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(int r0) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long r0) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float r0) {
        return 4;
    }

    static int computePreferredBufferSize(int r1) {
        if (r1 <= 4096) goto L5;
        return 4096;
    L5:
        return r1;
    }

    public static int computeRawVarint32Size(int r1) {
        if ((r1 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r1 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r1) != 0) goto L15;
        return 3;
    L15:
        if ((r1 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeRawVarint64Size(long r4) {
        if (((-128) & r4) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r4) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r4) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r4) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r4) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r4) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r4) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r4) != 0) goto L35;
        return 8;
    L35:
        if ((r4 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int computeSFixed32SizeNoTag(int r0) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long r0) {
        return 8;
    }

    public static int encodeZigZag32(int r1) {
        int r0 = r1 << 1;
        return (r1 >> 31) ^ r0;
    }

    public static long encodeZigZag64(long r3) {
        long r0 = r3 << 1;
        return (r3 >> 63) ^ r0;
    }

    private CodedOutputStream(OutputStream r2, byte[] r3) {
        this.totalBytesWritten = 0;
        this.output = r2;
        this.buffer = r3;
        this.position = 0;
        this.limit = r3.length;
    }

    public static CodedOutputStream newInstance(OutputStream r1, int r2) {
        return new CodedOutputStream(r1, new byte[r2]);
    }

    public void writeDouble(int r2, double r3) throws IOException {
        writeTag(r2, 1);
        writeDoubleNoTag(r3);
    }

    public void writeFloat(int r2, float r3) throws IOException {
        writeTag(r2, 5);
        writeFloatNoTag(r3);
    }

    public void writeInt32(int r2, int r3) throws IOException {
        writeTag(r2, 0);
        writeInt32NoTag(r3);
    }

    public void writeBool(int r2, boolean r3) throws IOException {
        writeTag(r2, 0);
        writeBoolNoTag(r3);
    }

    public void writeGroup(int r2, MessageLite r3) throws IOException {
        writeTag(r2, 3);
        writeGroupNoTag(r3);
        writeTag(r2, 4);
    }

    public void writeMessage(int r2, MessageLite r3) throws IOException {
        writeTag(r2, 2);
        writeMessageNoTag(r3);
    }

    public void writeBytes(int r2, ByteString r3) throws IOException {
        writeTag(r2, 2);
        writeBytesNoTag(r3);
    }

    public void writeUInt32(int r2, int r3) throws IOException {
        writeTag(r2, 0);
        writeUInt32NoTag(r3);
    }

    public void writeEnum(int r2, int r3) throws IOException {
        writeTag(r2, 0);
        writeEnumNoTag(r3);
    }

    public void writeSInt64(int r2, long r3) throws IOException {
        writeTag(r2, 0);
        writeSInt64NoTag(r3);
    }

    public void writeMessageSetExtension(int r4, MessageLite r5) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, r4);
        writeMessage(3, r5);
        writeTag(1, 4);
    }

    public void writeDoubleNoTag(double r1) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(r1));
    }

    public void writeFloatNoTag(float r1) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(r1));
    }

    public void writeUInt64NoTag(long r1) throws IOException {
        writeRawVarint64(r1);
    }

    public void writeInt64NoTag(long r1) throws IOException {
        writeRawVarint64(r1);
    }

    public void writeInt32NoTag(int r3) throws IOException {
        if (r3 < 0) goto L4;
        writeRawVarint32(r3);
        return;
    L4:
        writeRawVarint64(r3);
    }

    public void writeFixed64NoTag(long r1) throws IOException {
        writeRawLittleEndian64(r1);
    }

    public void writeFixed32NoTag(int r1) throws IOException {
        writeRawLittleEndian32(r1);
    }

    public void writeBoolNoTag(boolean r1) throws IOException {
        writeRawByte(r1 ? 1 : 0);
    }

    public void writeStringNoTag(String r2) throws IOException {
        byte[] r3 = r2.getBytes("UTF-8");
        writeRawVarint32(r3.length);
        writeRawBytes(r3);
    }

    public void writeGroupNoTag(MessageLite r1) throws IOException {
        r1.writeTo(this);
    }

    public void writeMessageNoTag(MessageLite r2) throws IOException {
        writeRawVarint32(r2.getSerializedSize());
        r2.writeTo(this);
    }

    public void writeBytesNoTag(ByteString r2) throws IOException {
        writeRawVarint32(r2.size());
        writeRawBytes(r2);
    }

    public void writeByteArrayNoTag(byte[] r2) throws IOException {
        writeRawVarint32(r2.length);
        writeRawBytes(r2);
    }

    public void writeUInt32NoTag(int r1) throws IOException {
        writeRawVarint32(r1);
    }

    public void writeEnumNoTag(int r1) throws IOException {
        writeInt32NoTag(r1);
    }

    public void writeSFixed32NoTag(int r1) throws IOException {
        writeRawLittleEndian32(r1);
    }

    public void writeSFixed64NoTag(long r1) throws IOException {
        writeRawLittleEndian64(r1);
    }

    public void writeSInt32NoTag(int r1) throws IOException {
        writeRawVarint32(encodeZigZag32(r1));
    }

    public void writeSInt64NoTag(long r1) throws IOException {
        writeRawVarint64(encodeZigZag64(r1));
    }

    public static int computeDoubleSize(int r0, double r1) {
        return computeTagSize(r0) + computeDoubleSizeNoTag(r1);
    }

    public static int computeFloatSize(int r0, float r1) {
        return computeTagSize(r0) + computeFloatSizeNoTag(r1);
    }

    public static int computeInt32Size(int r0, int r1) {
        return computeTagSize(r0) + computeInt32SizeNoTag(r1);
    }

    public static int computeBoolSize(int r0, boolean r1) {
        return computeTagSize(r0) + computeBoolSizeNoTag(r1);
    }

    public static int computeMessageSize(int r0, MessageLite r1) {
        return computeTagSize(r0) + computeMessageSizeNoTag(r1);
    }

    public static int computeBytesSize(int r0, ByteString r1) {
        return computeTagSize(r0) + computeBytesSizeNoTag(r1);
    }

    public static int computeEnumSize(int r0, int r1) {
        return computeTagSize(r0) + computeEnumSizeNoTag(r1);
    }

    public static int computeSInt64Size(int r0, long r1) {
        return computeTagSize(r0) + computeSInt64SizeNoTag(r1);
    }

    public static int computeUInt64SizeNoTag(long r0) {
        return computeRawVarint64Size(r0);
    }

    public static int computeInt64SizeNoTag(long r0) {
        return computeRawVarint64Size(r0);
    }

    public static int computeInt32SizeNoTag(int r0) {
        if (r0 >= 0) goto L4;
        return 10;
    L4:
        return computeRawVarint32Size(r0);
    }

    public static int computeStringSizeNoTag(String r2) {
        byte[] r3 = r2.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
        return computeRawVarint32Size(r3.length) + r3.length;
    L5:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported.", e);
    }

    public static int computeGroupSizeNoTag(MessageLite r0) {
        return r0.getSerializedSize();
    }

    public static int computeMessageSizeNoTag(MessageLite r1) {
        int r2 = r1.getSerializedSize();
        return computeRawVarint32Size(r2) + r2;
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r1) {
        int r2 = r1.getSerializedSize();
        return computeRawVarint32Size(r2) + r2;
    }

    public static int computeBytesSizeNoTag(ByteString r1) {
        return computeRawVarint32Size(r1.size()) + r1.size();
    }

    public static int computeByteArraySizeNoTag(byte[] r1) {
        return computeRawVarint32Size(r1.length) + r1.length;
    }

    public static int computeUInt32SizeNoTag(int r0) {
        return computeRawVarint32Size(r0);
    }

    public static int computeEnumSizeNoTag(int r0) {
        return computeInt32SizeNoTag(r0);
    }

    public static int computeSInt32SizeNoTag(int r0) {
        return computeRawVarint32Size(encodeZigZag32(r0));
    }

    public static int computeSInt64SizeNoTag(long r0) {
        return computeRawVarint64Size(encodeZigZag64(r0));
    }

    private void refreshBuffer() throws IOException {
        OutputStream r0 = this.output;
        if (r0 == null) goto L7;
        r0.write(this.buffer, 0, this.position);
        this.position = 0;
        return;
    L7:
        throw new OutOfSpaceException();
    }

    public void flush() throws IOException {
        if (this.output == null) goto L6;
        refreshBuffer();
        return;
    }

    public void writeRawByte(byte r4) throws IOException {
        if (this.position != this.limit) goto L5;
        refreshBuffer();
    L5:
        byte[] r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0[r1] = r4;
        this.totalBytesWritten++;
    }

    public void writeRawByte(int r1) throws IOException {
        writeRawByte((byte) r1);
    }

    public void writeRawBytes(ByteString r3) throws IOException {
        writeRawBytes(r3, 0, r3.size());
    }

    public void writeRawBytes(byte[] r3) throws IOException {
        writeRawBytes(r3, 0, r3.length);
    }

    public void writeRawBytes(byte[] r4, int r5, int r6) throws IOException {
        int r0 = this.limit;
        int r1 = this.position;
        if ((r0 - r1) < r6) goto L5;
        System.arraycopy(r4, r5, this.buffer, r1, r6);
        this.position += r6;
        this.totalBytesWritten += r6;
        return;
    L5:
        int r2 = r0 - r1;
        System.arraycopy(r4, r5, this.buffer, r1, r2);
        int r7 = r5 + r2;
        int r8 = r6 - r2;
        this.position = this.limit;
        this.totalBytesWritten += r2;
        refreshBuffer();
        if (r8 > this.limit) goto L8;
        System.arraycopy(r4, r7, this.buffer, 0, r8);
        this.position = r8;
    L9:
        this.totalBytesWritten += r8;
        return;
    L8:
        this.output.write(r4, r7, r8);
        goto L9
    }

    public void writeRawBytes(ByteString r4, int r5, int r6) throws IOException {
        int r0 = this.limit;
        int r1 = this.position;
        if ((r0 - r1) < r6) goto L5;
        r4.copyTo(this.buffer, r5, r1, r6);
        this.position += r6;
        this.totalBytesWritten += r6;
        return;
    L5:
        int r2 = r0 - r1;
        r4.copyTo(this.buffer, r5, r1, r2);
        int r7 = r5 + r2;
        int r8 = r6 - r2;
        this.position = this.limit;
        this.totalBytesWritten += r2;
        refreshBuffer();
        if (r8 > this.limit) goto L8;
        r4.copyTo(this.buffer, r7, 0, r8);
        this.position = r8;
    L9:
        this.totalBytesWritten += r8;
        return;
    L8:
        r4.writeTo(this.output, r7, r8);
        goto L9
    }

    public void writeTag(int r1, int r2) throws IOException {
        writeRawVarint32(WireFormat.makeTag(r1, r2));
    }

    public static int computeTagSize(int r1) {
        return computeRawVarint32Size(WireFormat.makeTag(r1, 0));
    }

    public void writeRawVarint32(int r2) throws IOException {
    L3:
        if ((r2 & (-128)) == 0) goto L4;
        writeRawByte((r2 & WorkQueueKt.MASK) | 128);
        r2 = r2 >>> 7;
        goto L3
    L4:
        writeRawByte(r2);
    }

    public void writeRawVarint64(long r5) throws IOException {
    L3:
        if (((-128) & r5) == 0) goto L4;
        writeRawByte((((int) r5) & WorkQueueKt.MASK) | 128);
        r5 = r5 >>> 7;
        goto L3
    L4:
        writeRawByte((int) r5);
    }

    public void writeRawLittleEndian32(int r2) throws IOException {
        writeRawByte(r2 & 255);
        writeRawByte((r2 >> 8) & 255);
        writeRawByte((r2 >> 16) & 255);
        writeRawByte((r2 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long r3) throws IOException {
        writeRawByte(((int) r3) & 255);
        writeRawByte(((int) (r3 >> 8)) & 255);
        writeRawByte(((int) (r3 >> 16)) & 255);
        writeRawByte(((int) (r3 >> 24)) & 255);
        writeRawByte(((int) (r3 >> 32)) & 255);
        writeRawByte(((int) (r3 >> 40)) & 255);
        writeRawByte(((int) (r3 >> 48)) & 255);
        writeRawByte(((int) (r3 >> 56)) & 255);
    }
}
