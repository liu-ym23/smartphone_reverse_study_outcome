package com.google.crypto.tink.shaded.protobuf;

import b8.z;
import com.google.crypto.tink.shaded.protobuf.Utf8;
import g5.f;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int i) {
            super();
            if (i < 0) {
                f.s("bufferSize must be >= 0");
                throw null;
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        public final void buffer(byte b10) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b10;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i) {
            byte[] bArr = this.buffer;
            int i3 = this.position;
            int i10 = i3 + 1;
            this.position = i10;
            bArr[i3] = (byte) (i & 255);
            int i11 = i3 + 2;
            this.position = i11;
            bArr[i10] = (byte) ((i >> 8) & 255);
            int i12 = i3 + 3;
            this.position = i12;
            bArr[i11] = (byte) ((i >> 16) & 255);
            this.position = i3 + 4;
            bArr[i12] = (byte) ((i >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j10) {
            byte[] bArr = this.buffer;
            int i = this.position;
            int i3 = i + 1;
            this.position = i3;
            bArr[i] = (byte) (j10 & 255);
            int i10 = i + 2;
            this.position = i10;
            bArr[i3] = (byte) ((j10 >> 8) & 255);
            int i11 = i + 3;
            this.position = i11;
            bArr[i10] = (byte) ((j10 >> 16) & 255);
            int i12 = i + 4;
            this.position = i12;
            bArr[i11] = (byte) (255 & (j10 >> 24));
            int i13 = i + 5;
            this.position = i13;
            bArr[i12] = (byte) (((int) (j10 >> 32)) & 255);
            int i14 = i + 6;
            this.position = i14;
            bArr[i13] = (byte) (((int) (j10 >> 40)) & 255);
            int i15 = i + 7;
            this.position = i15;
            bArr[i14] = (byte) (((int) (j10 >> 48)) & 255);
            this.position = i + 8;
            bArr[i15] = (byte) (((int) (j10 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i) {
            if (i >= 0) {
                bufferUInt32NoTag(i);
            } else {
                bufferUInt64NoTag(i);
            }
        }

        public final void bufferTag(int i, int i3) {
            bufferUInt32NoTag(WireFormat.makeTag(i, i3));
        }

        public final void bufferUInt32NoTag(int i) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j10 = this.position;
                while (true) {
                    int i3 = i & (-128);
                    byte[] bArr = this.buffer;
                    if (i3 == 0) {
                        int i10 = this.position;
                        this.position = i10 + 1;
                        UnsafeUtil.putByte(bArr, i10, (byte) i);
                        this.totalBytesWritten += (int) (this.position - j10);
                        return;
                    }
                    int i11 = this.position;
                    this.position = i11 + 1;
                    UnsafeUtil.putByte(bArr, i11, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            } else {
                while (true) {
                    int i12 = i & (-128);
                    byte[] bArr2 = this.buffer;
                    if (i12 == 0) {
                        int i13 = this.position;
                        this.position = i13 + 1;
                        bArr2[i13] = (byte) i;
                        this.totalBytesWritten++;
                        return;
                    }
                    int i14 = this.position;
                    this.position = i14 + 1;
                    bArr2[i14] = (byte) ((i & 127) | 128);
                    this.totalBytesWritten++;
                    i >>>= 7;
                }
            }
        }

        public final void bufferUInt64NoTag(long j10) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j11 = this.position;
                while (true) {
                    long j12 = j10 & (-128);
                    byte[] bArr = this.buffer;
                    if (j12 == 0) {
                        int i = this.position;
                        this.position = i + 1;
                        UnsafeUtil.putByte(bArr, i, (byte) j10);
                        this.totalBytesWritten += (int) (this.position - j11);
                        return;
                    }
                    int i3 = this.position;
                    this.position = i3 + 1;
                    UnsafeUtil.putByte(bArr, i3, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
            } else {
                while (true) {
                    long j13 = j10 & (-128);
                    byte[] bArr2 = this.buffer;
                    if (j13 == 0) {
                        int i10 = this.position;
                        this.position = i10 + 1;
                        bArr2[i10] = (byte) j10;
                        this.totalBytesWritten++;
                        return;
                    }
                    int i11 = this.position;
                    this.position = i11 + 1;
                    bArr2[i11] = (byte) ((((int) j10) & 127) | 128);
                    this.totalBytesWritten++;
                    j10 >>>= 7;
                }
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream.ArrayEncoder, com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static int computeBoolSize(int i, boolean z10) {
        return computeBoolSizeNoTag(z10) + computeTagSize(i);
    }

    public static int computeBoolSizeNoTag(boolean z10) {
        return 1;
    }

    public static int computeByteArraySize(int i, byte[] bArr) {
        return computeByteArraySizeNoTag(bArr) + computeTagSize(i);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i, ByteBuffer byteBuffer) {
        return computeByteBufferSizeNoTag(byteBuffer) + computeTagSize(i);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        return computeBytesSizeNoTag(byteString) + computeTagSize(i);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i, double d7) {
        return computeDoubleSizeNoTag(d7) + computeTagSize(i);
    }

    public static int computeDoubleSizeNoTag(double d7) {
        return 8;
    }

    public static int computeEnumSize(int i, int i3) {
        return computeEnumSizeNoTag(i3) + computeTagSize(i);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32Size(int i, int i3) {
        return computeFixed32SizeNoTag(i3) + computeTagSize(i);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j10) {
        return computeFixed64SizeNoTag(j10) + computeTagSize(i);
    }

    public static int computeFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeFloatSize(int i, float f5) {
        return computeFloatSizeNoTag(f5) + computeTagSize(i);
    }

    public static int computeFloatSizeNoTag(float f5) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite) {
        return messageLite.getSerializedSize() + (computeTagSize(i) * 2);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int computeInt32Size(int i, int i3) {
        return computeInt32SizeNoTag(i3) + computeTagSize(i);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeUInt32SizeNoTag(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j10) {
        return computeInt64SizeNoTag(j10) + computeTagSize(i);
    }

    public static int computeInt64SizeNoTag(long j10) {
        return computeUInt64SizeNoTag(j10);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSize(3, lazyFieldLite) + computeUInt32Size(2, i) + (computeTagSize(1) * 2);
    }

    public static int computeLazyFieldSize(int i, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSizeNoTag(lazyFieldLite) + computeTagSize(i);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i) {
        return computeUInt32SizeNoTag(i) + i;
    }

    public static int computeMessageSetExtensionSize(int i, MessageLite messageLite) {
        return computeMessageSize(3, messageLite) + computeUInt32Size(2, i) + (computeTagSize(1) * 2);
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        return computeMessageSizeNoTag(messageLite) + computeTagSize(i);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static int computePreferredBufferSize(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int computeRawMessageSetExtensionSize(int i, ByteString byteString) {
        return computeBytesSize(3, byteString) + computeUInt32Size(2, i) + (computeTagSize(1) * 2);
    }

    @InlineMe(imports = {"com.google.crypto.tink.shaded.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i) {
        return computeUInt32SizeNoTag(i);
    }

    @InlineMe(imports = {"com.google.crypto.tink.shaded.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j10) {
        return computeUInt64SizeNoTag(j10);
    }

    public static int computeSFixed32Size(int i, int i3) {
        return computeSFixed32SizeNoTag(i3) + computeTagSize(i);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j10) {
        return computeSFixed64SizeNoTag(j10) + computeTagSize(i);
    }

    public static int computeSFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i3) {
        return computeSInt32SizeNoTag(i3) + computeTagSize(i);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j10) {
        return computeSInt64SizeNoTag(j10) + computeTagSize(i);
    }

    public static int computeSInt64SizeNoTag(long j10) {
        return computeUInt64SizeNoTag(encodeZigZag64(j10));
    }

    public static int computeStringSize(int i, String str) {
        return computeStringSizeNoTag(str) + computeTagSize(i);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i, 0));
    }

    public static int computeUInt32Size(int i, int i3) {
        return computeUInt32SizeNoTag(i3) + computeTagSize(i);
    }

    public static int computeUInt32SizeNoTag(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i, long j10) {
        return computeUInt64SizeNoTag(j10) + computeTagSize(i);
    }

    public static int computeUInt64SizeNoTag(long j10) {
        int i;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j10) != 0) {
            i += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i + 1 : i;
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return UnsafeDirectNioEncoder.isSupported() ? newUnsafeInstance(byteBuffer) : newSafeInstance(byteBuffer);
        }
        f.s("ByteBuffer is read-only");
        return null;
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
            return;
        }
        od.f.e("Did not write as much data as expected.");
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws OutOfSpaceException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new OutOfSpaceException(e10);
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(byte b10);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i, int i3);

    public abstract void writeBool(int i, boolean z10);

    public final void writeBoolNoTag(boolean z10) {
        write(z10 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i, byte[] bArr);

    public abstract void writeByteArray(int i, byte[] bArr, int i3, int i10);

    public final void writeByteArrayNoTag(byte[] bArr) {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i, int i3);

    public abstract void writeByteBuffer(int i, ByteBuffer byteBuffer);

    public abstract void writeBytes(int i, ByteString byteString);

    public abstract void writeBytesNoTag(ByteString byteString);

    public final void writeDouble(int i, double d7) {
        writeFixed64(i, Double.doubleToRawLongBits(d7));
    }

    public final void writeDoubleNoTag(double d7) {
        writeFixed64NoTag(Double.doubleToRawLongBits(d7));
    }

    public final void writeEnum(int i, int i3) {
        writeInt32(i, i3);
    }

    public final void writeEnumNoTag(int i) {
        writeInt32NoTag(i);
    }

    public abstract void writeFixed32(int i, int i3);

    public abstract void writeFixed32NoTag(int i);

    public abstract void writeFixed64(int i, long j10);

    public abstract void writeFixed64NoTag(long j10);

    public final void writeFloat(int i, float f5) {
        writeFixed32(i, Float.floatToRawIntBits(f5));
    }

    public final void writeFloatNoTag(float f5) {
        writeFixed32NoTag(Float.floatToRawIntBits(f5));
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite) {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) {
        schema.writeTo(messageLite, this.wrapper);
    }

    public abstract void writeInt32(int i, int i3);

    public abstract void writeInt32NoTag(int i);

    public final void writeInt64(int i, long j10) {
        writeUInt64(i, j10);
    }

    public final void writeInt64NoTag(long j10) {
        writeUInt64NoTag(j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i, int i3);

    public abstract void writeMessage(int i, MessageLite messageLite);

    public abstract void writeMessage(int i, MessageLite messageLite, Schema schema);

    public abstract void writeMessageNoTag(MessageLite messageLite);

    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema);

    public abstract void writeMessageSetExtension(int i, MessageLite messageLite);

    public final void writeRawByte(int i) {
        write((byte) i);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer);

    public final void writeRawBytes(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i) {
        writeFixed32NoTag(i);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j10) {
        writeFixed64NoTag(j10);
    }

    public abstract void writeRawMessageSetExtension(int i, ByteString byteString);

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i) {
        writeUInt32NoTag(i);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j10) {
        writeUInt64NoTag(j10);
    }

    public final void writeSFixed32(int i, int i3) {
        writeFixed32(i, i3);
    }

    public final void writeSFixed32NoTag(int i) {
        writeFixed32NoTag(i);
    }

    public final void writeSFixed64(int i, long j10) {
        writeFixed64(i, j10);
    }

    public final void writeSFixed64NoTag(long j10) {
        writeFixed64NoTag(j10);
    }

    public final void writeSInt32(int i, int i3) {
        writeUInt32(i, encodeZigZag32(i3));
    }

    public final void writeSInt32NoTag(int i) {
        writeUInt32NoTag(encodeZigZag32(i));
    }

    public final void writeSInt64(int i, long j10) {
        writeUInt64(i, encodeZigZag64(j10));
    }

    public final void writeSInt64NoTag(long j10) {
        writeUInt64NoTag(encodeZigZag64(j10));
    }

    public abstract void writeString(int i, String str);

    public abstract void writeStringNoTag(String str);

    public abstract void writeTag(int i, int i3);

    public abstract void writeUInt32(int i, int i3);

    public abstract void writeUInt32NoTag(int i);

    public abstract void writeUInt64(int i, long j10);

    public abstract void writeUInt64NoTag(long j10);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] bArr, int i, int i3) {
            super();
            if (bArr == null) {
                f.g("buffer");
                throw null;
            }
            int i10 = i + i3;
            if ((i | i3 | (bArr.length - i10)) < 0) {
                z.u("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i3)});
                throw null;
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws OutOfSpaceException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(iRemaining)), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBool(int i, boolean z10) throws OutOfSpaceException {
            writeTag(i, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr, int i3, int i10) throws OutOfSpaceException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i3, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            writeUInt32NoTag(i3);
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i, ByteBuffer byteBuffer) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytes(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws OutOfSpaceException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 5);
            writeFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i) throws OutOfSpaceException {
            try {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                int i10 = i3 + 1;
                this.position = i10;
                bArr[i3] = (byte) (i & 255);
                int i11 = i3 + 2;
                this.position = i11;
                bArr[i10] = (byte) ((i >> 8) & 255);
                int i12 = i3 + 3;
                this.position = i12;
                bArr[i11] = (byte) ((i >> 16) & 255);
                this.position = i3 + 4;
                bArr[i12] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64(int i, long j10) throws OutOfSpaceException {
            writeTag(i, 1);
            writeFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j10) throws OutOfSpaceException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i3 = i + 1;
                this.position = i3;
                bArr[i] = (byte) (((int) j10) & 255);
                int i10 = i + 2;
                this.position = i10;
                bArr[i3] = (byte) (((int) (j10 >> 8)) & 255);
                int i11 = i + 3;
                this.position = i11;
                bArr[i10] = (byte) (((int) (j10 >> 16)) & 255);
                int i12 = i + 4;
                this.position = i12;
                bArr[i11] = (byte) (((int) (j10 >> 24)) & 255);
                int i13 = i + 5;
                this.position = i13;
                bArr[i12] = (byte) (((int) (j10 >> 32)) & 255);
                int i14 = i + 6;
                this.position = i14;
                bArr[i13] = (byte) (((int) (j10 >> 40)) & 255);
                int i15 = i + 7;
                this.position = i15;
                bArr[i14] = (byte) (((int) (j10 >> 48)) & 255);
                this.position = i + 8;
                bArr[i15] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 0);
            writeInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i) throws OutOfSpaceException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws OutOfSpaceException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws OutOfSpaceException {
            int i = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                    return;
                }
                int i3 = i + iComputeUInt32SizeNoTag2;
                this.position = i3;
                int iEncode = Utf8.encode(str, this.buffer, i3, spaceLeft());
                this.position = i;
                writeUInt32NoTag((iEncode - i) - iComputeUInt32SizeNoTag2);
                this.position = iEncode;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.position = i;
                inefficientWriteStringNoTag(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeTag(int i, int i3) throws OutOfSpaceException {
            writeUInt32NoTag(WireFormat.makeTag(i, i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i) throws OutOfSpaceException {
            while (true) {
                int i3 = i & (-128);
                byte[] bArr = this.buffer;
                if (i3 == 0) {
                    int i10 = this.position;
                    this.position = i10 + 1;
                    bArr[i10] = (byte) i;
                    return;
                } else {
                    try {
                        int i11 = this.position;
                        this.position = i11 + 1;
                        bArr[i11] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                    }
                }
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64(int i, long j10) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j10) throws OutOfSpaceException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || spaceLeft() < 10) {
                while (true) {
                    long j11 = j10 & (-128);
                    byte[] bArr = this.buffer;
                    if (j11 == 0) {
                        int i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) j10;
                        return;
                    } else {
                        try {
                            int i3 = this.position;
                            this.position = i3 + 1;
                            bArr[i3] = (byte) ((((int) j10) & 127) | 128);
                            j10 >>>= 7;
                        } catch (IndexOutOfBoundsException e10) {
                            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                        }
                    }
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                }
            }
            while (true) {
                long j12 = j10 & (-128);
                byte[] bArr2 = this.buffer;
                if (j12 == 0) {
                    int i10 = this.position;
                    this.position = i10 + 1;
                    UnsafeUtil.putByte(bArr2, i10, (byte) j10);
                    return;
                } else {
                    int i11 = this.position;
                    this.position = i11 + 1;
                    UnsafeUtil.putByte(bArr2, i11, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws OutOfSpaceException {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr) throws OutOfSpaceException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws OutOfSpaceException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i3);
                this.position += i3;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i3)), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(byte b10) throws OutOfSpaceException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.out = outputStream;
            } else {
                f.g("out");
                throw null;
            }
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i = this.limit;
            int i3 = this.position;
            int i10 = i - i3;
            byte[] bArr = this.buffer;
            if (i10 >= iRemaining) {
                byteBuffer.get(bArr, i3, iRemaining);
                this.position += iRemaining;
                this.totalBytesWritten += iRemaining;
                return;
            }
            int i11 = i - i3;
            byteBuffer.get(bArr, i3, i11);
            int i12 = iRemaining - i11;
            this.position = this.limit;
            this.totalBytesWritten += i11;
            doFlush();
            while (true) {
                int i13 = this.limit;
                byte[] bArr2 = this.buffer;
                if (i12 <= i13) {
                    byteBuffer.get(bArr2, 0, i12);
                    this.position = i12;
                    this.totalBytesWritten += i12;
                    return;
                } else {
                    byteBuffer.get(bArr2, 0, i13);
                    this.out.write(this.buffer, 0, this.limit);
                    int i14 = this.limit;
                    i12 -= i14;
                    this.totalBytesWritten += i14;
                }
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z10) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            buffer(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i3, int i10) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i3, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i3) throws IOException {
            writeUInt32NoTag(i3);
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i3) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j10) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i3) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i3) throws IOException {
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iEncodedLength;
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i = iComputeUInt32SizeNoTag + length;
                int i3 = this.limit;
                if (i > i3) {
                    byte[] bArr = new byte[length];
                    int iEncode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(iEncode);
                    writeLazy(bArr, 0, iEncode);
                    return;
                }
                if (i > i3 - this.position) {
                    doFlush();
                }
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i10 = this.position;
                try {
                    if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                        int i11 = i10 + iComputeUInt32SizeNoTag2;
                        this.position = i11;
                        int iEncode2 = Utf8.encode(str, this.buffer, i11, this.limit - i11);
                        this.position = i10;
                        iEncodedLength = (iEncode2 - i10) - iComputeUInt32SizeNoTag2;
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = iEncode2;
                    } else {
                        iEncodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    }
                    this.totalBytesWritten += iEncodedLength;
                } catch (Utf8.UnpairedSurrogateException e10) {
                    this.totalBytesWritten -= this.position - i10;
                    this.position = i10;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(e11);
                }
            } catch (Utf8.UnpairedSurrogateException e12) {
                inefficientWriteStringNoTag(str, e12);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i3) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i, i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i3) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j10) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i3) throws IOException {
            int i10 = this.limit;
            int i11 = this.position;
            int i12 = i10 - i11;
            byte[] bArr2 = this.buffer;
            if (i12 >= i3) {
                System.arraycopy(bArr, i, bArr2, i11, i3);
                this.position += i3;
                this.totalBytesWritten += i3;
                return;
            }
            int i13 = i10 - i11;
            System.arraycopy(bArr, i, bArr2, i11, i13);
            int i14 = i + i13;
            int i15 = i3 - i13;
            this.position = this.limit;
            this.totalBytesWritten += i13;
            doFlush();
            if (i15 <= this.limit) {
                System.arraycopy(bArr, i14, this.buffer, 0, i15);
                this.position = i15;
            } else {
                this.out.write(bArr, i14, i15);
            }
            this.totalBytesWritten += i15;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b10) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws OutOfSpaceException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            try {
                this.buffer.put(bArr, i, i3);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z10) throws OutOfSpaceException {
            writeTag(i, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i3, int i10) throws OutOfSpaceException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i3, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            writeUInt32NoTag(i3);
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws OutOfSpaceException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 5);
            writeFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws OutOfSpaceException {
            try {
                this.buffer.putInt(i);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j10) throws OutOfSpaceException {
            writeTag(i, 1);
            writeFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) throws OutOfSpaceException {
            try {
                this.buffer.putLong(j10);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 0);
            writeInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws OutOfSpaceException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws OutOfSpaceException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws OutOfSpaceException {
            int iPosition = this.buffer.position();
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode(str);
                    return;
                }
                int iPosition2 = this.buffer.position() + iComputeUInt32SizeNoTag2;
                this.buffer.position(iPosition2);
                encode(str);
                int iPosition3 = this.buffer.position();
                this.buffer.position(iPosition);
                writeUInt32NoTag(iPosition3 - iPosition2);
                this.buffer.position(iPosition3);
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.buffer.position(iPosition);
                inefficientWriteStringNoTag(str, e10);
            } catch (IllegalArgumentException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i3) throws OutOfSpaceException {
            writeUInt32NoTag(WireFormat.makeTag(i, i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws OutOfSpaceException {
            while (true) {
                int i3 = i & (-128);
                ByteBuffer byteBuffer = this.buffer;
                if (i3 == 0) {
                    byteBuffer.put((byte) i);
                    return;
                }
                try {
                    byteBuffer.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e10) {
                    throw new OutOfSpaceException(e10);
                }
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j10) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) throws OutOfSpaceException {
            while (true) {
                long j11 = (-128) & j10;
                ByteBuffer byteBuffer = this.buffer;
                if (j11 == 0) {
                    byteBuffer.put((byte) j10);
                    return;
                }
                try {
                    byteBuffer.put((byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                } catch (BufferOverflowException e10) {
                    throw new OutOfSpaceException(e10);
                }
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws OutOfSpaceException {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws OutOfSpaceException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws OutOfSpaceException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b10) throws OutOfSpaceException {
            try {
                this.buffer.put(b10);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = jAddressOffset;
            long jPosition = byteBuffer.position() + jAddressOffset;
            this.initialPosition = jPosition;
            long jLimit = jAddressOffset + byteBuffer.limit();
            this.limit = jLimit;
            this.oneVarintLimit = jLimit - 10;
            this.position = jPosition;
        }

        private int bufferPos(long j10) {
            return (int) (j10 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j10) {
            this.buffer.position(bufferPos(j10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            if (bArr != null && i >= 0 && i3 >= 0 && bArr.length - i3 >= i) {
                long j10 = i3;
                long j11 = this.limit - j10;
                long j12 = this.position;
                if (j11 >= j12) {
                    UnsafeUtil.copyMemory(bArr, i, j12, j10);
                    this.position += j10;
                    return;
                }
            }
            if (bArr != null) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i3)));
            }
            f.g("value");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z10) throws OutOfSpaceException {
            writeTag(i, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i3, int i10) throws OutOfSpaceException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i3, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            writeUInt32NoTag(i3);
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws OutOfSpaceException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 5);
            writeFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) {
            this.buffer.putInt(bufferPos(this.position), i);
            this.position += 4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j10) throws OutOfSpaceException {
            writeTag(i, 1);
            writeFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) {
            this.buffer.putLong(bufferPos(this.position), j10);
            this.position += 8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 0);
            writeInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws OutOfSpaceException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i3) throws OutOfSpaceException {
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws OutOfSpaceException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws OutOfSpaceException {
            long j10 = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    int iEncodedLength = Utf8.encodedLength(str);
                    writeUInt32NoTag(iEncodedLength);
                    repositionBuffer(this.position);
                    Utf8.encodeUtf8(str, this.buffer);
                    this.position += iEncodedLength;
                    return;
                }
                int iBufferPos = bufferPos(this.position) + iComputeUInt32SizeNoTag2;
                this.buffer.position(iBufferPos);
                Utf8.encodeUtf8(str, this.buffer);
                int iPosition = this.buffer.position() - iBufferPos;
                writeUInt32NoTag(iPosition);
                this.position += iPosition;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.position = j10;
                repositionBuffer(j10);
                inefficientWriteStringNoTag(str, e10);
            } catch (IllegalArgumentException e11) {
                throw new OutOfSpaceException(e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException(e12);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i3) throws OutOfSpaceException {
            writeUInt32NoTag(WireFormat.makeTag(i, i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i3) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws OutOfSpaceException {
            if (this.position <= this.oneVarintLimit) {
                while (true) {
                    int i3 = i & (-128);
                    long j10 = this.position;
                    if (i3 == 0) {
                        this.position = 1 + j10;
                        UnsafeUtil.putByte(j10, (byte) i);
                        return;
                    } else {
                        this.position = j10 + 1;
                        UnsafeUtil.putByte(j10, (byte) ((i & 127) | 128));
                        i >>>= 7;
                    }
                }
            } else {
                while (true) {
                    long j11 = this.position;
                    if (j11 >= this.limit) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j11), Long.valueOf(this.limit), 1));
                    }
                    if ((i & (-128)) == 0) {
                        this.position = 1 + j11;
                        UnsafeUtil.putByte(j11, (byte) i);
                        return;
                    } else {
                        this.position = j11 + 1;
                        UnsafeUtil.putByte(j11, (byte) ((i & 127) | 128));
                        i >>>= 7;
                    }
                }
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j10) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) throws OutOfSpaceException {
            if (this.position <= this.oneVarintLimit) {
                while (true) {
                    long j11 = j10 & (-128);
                    long j12 = this.position;
                    if (j11 == 0) {
                        this.position = 1 + j12;
                        UnsafeUtil.putByte(j12, (byte) j10);
                        return;
                    } else {
                        this.position = j12 + 1;
                        UnsafeUtil.putByte(j12, (byte) ((((int) j10) & 127) | 128));
                        j10 >>>= 7;
                    }
                }
            } else {
                while (true) {
                    long j13 = this.position;
                    if (j13 >= this.limit) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j13), Long.valueOf(this.limit), 1));
                    }
                    if ((j10 & (-128)) == 0) {
                        this.position = 1 + j13;
                        UnsafeUtil.putByte(j13, (byte) j10);
                        return;
                    } else {
                        this.position = j13 + 1;
                        UnsafeUtil.putByte(j13, (byte) ((((int) j10) & 127) | 128));
                        j10 >>>= 7;
                    }
                }
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws OutOfSpaceException {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws OutOfSpaceException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws OutOfSpaceException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b10) throws OutOfSpaceException {
            long j10 = this.position;
            if (j10 < this.limit) {
                this.position = 1 + j10;
                UnsafeUtil.putByte(j10, b10);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j10), Long.valueOf(this.limit), 1));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                int iRemaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += iRemaining;
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }
    }

    private CodedOutputStream() {
    }

    public final void writeRawByte(byte b10) {
        write(b10);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    public final void writeRawBytes(byte[] bArr, int i, int i3) {
        write(bArr, i, i3);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        public ByteOutputEncoder(ByteOutput byteOutput, int i) {
            super(i);
            if (byteOutput != null) {
                this.out = byteOutput;
            } else {
                f.g("out");
                throw null;
            }
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i) {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z10) {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            buffer(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i3, int i10) {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i3, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i3) {
            writeUInt32NoTag(i3);
            write(bArr, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i3) {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j10) {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i3) {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws OutOfSpaceException {
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i = iComputeUInt32SizeNoTag + length;
            int i3 = this.limit;
            if (i > i3) {
                byte[] bArr = new byte[length];
                int iEncode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(iEncode);
                writeLazy(bArr, 0, iEncode);
                return;
            }
            if (i > i3 - this.position) {
                doFlush();
            }
            int i10 = this.position;
            try {
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    int iEncodedLength = Utf8.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    this.totalBytesWritten += iEncodedLength;
                    return;
                }
                int i11 = i10 + iComputeUInt32SizeNoTag2;
                this.position = i11;
                int iEncode2 = Utf8.encode(str, this.buffer, i11, this.limit - i11);
                this.position = i10;
                int i12 = (iEncode2 - i10) - iComputeUInt32SizeNoTag2;
                bufferUInt32NoTag(i12);
                this.position = iEncode2;
                this.totalBytesWritten += i12;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.totalBytesWritten -= this.position - i10;
                this.position = i10;
                inefficientWriteStringNoTag(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i3) {
            writeUInt32NoTag(WireFormat.makeTag(i, i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i3) {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j10) {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i3) {
            flush();
            this.out.write(bArr, i, i3);
            this.totalBytesWritten += i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i3) {
            flush();
            this.out.writeLazy(bArr, i, i3);
            this.totalBytesWritten += i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b10) {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b10);
        }
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public final void writeRawBytes(ByteString byteString) {
        byteString.writeTo(this);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException(String str) {
            super(c.b("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str));
        }

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super(c.b("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }
    }

    public static int computeMessageSize(int i, MessageLite messageLite, Schema schema) {
        return computeMessageSizeNoTag(messageLite, schema) + computeTagSize(i);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite, Schema schema) {
        return computeGroupSizeNoTag(messageLite, schema) + (computeTagSize(i) * 2);
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite, Schema schema) {
        writeTag(i, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i, 4);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new OutputStreamEncoder(outputStream, i);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i3) {
        return new ArrayEncoder(bArr, i, i3);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i) {
        if (i >= 0) {
            return new ByteOutputEncoder(byteOutput, i);
        }
        f.s("bufferSize must be positive");
        return null;
    }
}
