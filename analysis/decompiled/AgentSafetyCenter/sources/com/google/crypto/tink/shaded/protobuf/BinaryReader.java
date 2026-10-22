package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import g5.f;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@CheckReturnValue
/* loaded from: classes.dex */
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.shaded.protobuf.BinaryReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public /* synthetic */ BinaryReader(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z10);
        }
        f.s("Direct buffers not yet supported");
        return null;
    }

    public abstract int getTotalBytesRead();

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    private BinaryReader() {
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z10) {
            super(null);
            this.bufferIsImmutable = z10;
            this.buffer = byteBuffer.array();
            int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
            this.pos = iPosition;
            this.initialPos = iPosition;
            this.limit = byteBuffer.limit() + byteBuffer.arrayOffset();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        private byte readByte() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (i == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    od.f.o("unsupported field type.");
                    return null;
            }
        }

        private int readLittleEndian32() throws InvalidProtocolBufferException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
        }

        private long readLittleEndian64() throws InvalidProtocolBufferException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        private int readVarint32() throws InvalidProtocolBufferException {
            int i;
            int i3 = this.pos;
            int i10 = this.limit;
            if (i10 == i3) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i11 = i3 + 1;
            byte b10 = bArr[i3];
            if (b10 >= 0) {
                this.pos = i11;
                return b10;
            }
            if (i10 - i11 < 9) {
                return (int) readVarint64SlowPath();
            }
            int i12 = i3 + 2;
            int i13 = (bArr[i11] << 7) ^ b10;
            if (i13 < 0) {
                i = i13 ^ (-128);
            } else {
                int i14 = i3 + 3;
                int i15 = (bArr[i12] << 14) ^ i13;
                if (i15 >= 0) {
                    i = i15 ^ 16256;
                } else {
                    int i16 = i3 + 4;
                    int i17 = i15 ^ (bArr[i14] << 21);
                    if (i17 < 0) {
                        i = (-2080896) ^ i17;
                    } else {
                        i14 = i3 + 5;
                        byte b11 = bArr[i16];
                        int i18 = (i17 ^ (b11 << 28)) ^ 266354560;
                        if (b11 < 0) {
                            i16 = i3 + 6;
                            if (bArr[i14] < 0) {
                                i14 = i3 + 7;
                                if (bArr[i16] < 0) {
                                    i16 = i3 + 8;
                                    if (bArr[i14] < 0) {
                                        i14 = i3 + 9;
                                        if (bArr[i16] < 0) {
                                            int i19 = i3 + 10;
                                            if (bArr[i14] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i12 = i19;
                                            i = i18;
                                        }
                                    }
                                }
                            }
                            i = i18;
                        }
                        i = i18;
                    }
                    i12 = i16;
                }
                i12 = i14;
            }
            this.pos = i12;
            return i;
        }

        private long readVarint64SlowPath() throws InvalidProtocolBufferException {
            long j10 = 0;
            for (int i = 0; i < 64; i += 7) {
                j10 |= (r3 & 127) << i;
                if ((readByte() & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int i) throws InvalidProtocolBufferException {
            if (i < 0 || i > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requirePosition(int i) throws InvalidProtocolBufferException {
            if (this.pos != i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (WireFormat.getTagWireType(this.tag) != i) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void skipBytes(int i) throws InvalidProtocolBufferException {
            requireBytes(i);
            this.pos += i;
        }

        private void skipGroup() throws InvalidProtocolBufferException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = i;
        }

        private void skipVarint() throws InvalidProtocolBufferException {
            int i = this.limit;
            int i3 = this.pos;
            if (i - i3 >= 10) {
                byte[] bArr = this.buffer;
                int i10 = 0;
                while (i10 < 10) {
                    int i11 = i3 + 1;
                    if (bArr[i3] >= 0) {
                        this.pos = i11;
                        return;
                    } else {
                        i10++;
                        i3 = i11;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int i) throws InvalidProtocolBufferException {
            requireBytes(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed64Length(int i) throws InvalidProtocolBufferException {
            requireBytes(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int getFieldNumber() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                return Reader.READ_DONE;
            }
            int varint32 = readVarint32();
            this.tag = varint32;
            return varint32 == this.endGroupTag ? Reader.READ_DONE : WireFormat.getTagFieldNumber(varint32);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void mergeGroupField(T t10, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(t10, this, extensionRegistryLite);
                if (this.tag == this.endGroupTag) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void mergeMessageField(T t10, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int varint32 = readVarint32();
            requireBytes(varint32);
            int i = this.limit;
            int i3 = this.pos + varint32;
            this.limit = i3;
            try {
                schema.mergeFrom(t10, this, extensionRegistryLite);
                if (this.pos == i3) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = i;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public boolean readBool() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readBoolList(List<Boolean> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof BooleanArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.pos + readVarint32();
                    while (this.pos < varint32) {
                        list.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(varint32);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(readBool()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.pos + readVarint32();
                while (this.pos < varint322) {
                    booleanArrayList.addBoolean(readVarint32() != 0);
                }
                requirePosition(varint322);
                return;
            }
            do {
                booleanArrayList.addBoolean(readBool());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public ByteString readBytes() throws InvalidProtocolBufferException {
            requireWireType(2);
            int varint32 = readVarint32();
            if (varint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(varint32);
            boolean z10 = this.bufferIsImmutable;
            byte[] bArr = this.buffer;
            ByteString byteStringWrap = z10 ? ByteString.wrap(bArr, this.pos, varint32) : ByteString.copyFrom(bArr, this.pos, varint32);
            this.pos += varint32;
            return byteStringWrap;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readBytesList(List<ByteString> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readDoubleList(List<Double> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof DoubleArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = readVarint32();
                verifyPackedFixed64Length(varint32);
                int i11 = this.pos + varint32;
                while (this.pos < i11) {
                    list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                }
                return;
            }
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 1) {
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = readVarint32();
            verifyPackedFixed64Length(varint322);
            int i12 = this.pos + varint322;
            while (this.pos < i12) {
                doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readEnum() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readEnumList(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.pos + readVarint32();
                    while (this.pos < varint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readEnum()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.pos + readVarint32();
                while (this.pos < varint322) {
                    intArrayList.addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.addInt(readEnum());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readFixed32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 2) {
                    int varint32 = readVarint32();
                    verifyPackedFixed32Length(varint32);
                    int i11 = this.pos + varint32;
                    while (this.pos < i11) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readFixed32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 2) {
                int varint322 = readVarint32();
                verifyPackedFixed32Length(varint322);
                int i12 = this.pos + varint322;
                while (this.pos < i12) {
                    intArrayList.addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(readFixed32());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readFixed64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = readVarint32();
                verifyPackedFixed64Length(varint32);
                int i11 = this.pos + varint32;
                while (this.pos < i11) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.addLong(readFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = readVarint32();
            verifyPackedFixed64Length(varint322);
            int i12 = this.pos + varint322;
            while (this.pos < i12) {
                longArrayList.addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readFloatList(List<Float> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof FloatArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 2) {
                    int varint32 = readVarint32();
                    verifyPackedFixed32Length(varint32);
                    int i11 = this.pos + varint32;
                    while (this.pos < i11) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 2) {
                int varint322 = readVarint32();
                verifyPackedFixed32Length(varint322);
                int i12 = this.pos + varint322;
                while (this.pos < i12) {
                    floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                floatArrayList.addFloat(readFloat());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i3 = this.tag;
            do {
                list.add(readGroup(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == i3);
            this.pos = i;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readInt32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = this.pos + readVarint32();
                while (this.pos < varint32) {
                    list.add(Integer.valueOf(readVarint32()));
                }
                requirePosition(varint32);
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 0) {
                do {
                    intArrayList.addInt(readInt32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = this.pos + readVarint32();
            while (this.pos < varint322) {
                intArrayList.addInt(readVarint32());
            }
            requirePosition(varint322);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readInt64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = this.pos + readVarint32();
                while (this.pos < varint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
                requirePosition(varint32);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 0) {
                do {
                    longArrayList.addLong(readInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = this.pos + readVarint32();
            while (this.pos < varint322) {
                longArrayList.addLong(readVarint64());
            }
            requirePosition(varint322);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            requireWireType(2);
            int varint32 = readVarint32();
            requireBytes(varint32);
            int i = this.limit;
            this.limit = this.pos + varint32;
            try {
                Object field = metadata.defaultKey;
                Object field2 = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(field, field2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        field = readField(metadata.keyType, null, null);
                    } else if (fieldNumber != 2) {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        field2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                    }
                }
            } finally {
                this.limit = i;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i3 = this.tag;
            do {
                list.add(readMessage(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == i3);
            this.pos = i;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readSFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSFixed32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 2) {
                    int varint32 = readVarint32();
                    verifyPackedFixed32Length(varint32);
                    int i11 = this.pos + varint32;
                    while (this.pos < i11) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readSFixed32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 2) {
                int varint322 = readVarint32();
                verifyPackedFixed32Length(varint322);
                int i12 = this.pos + varint322;
                while (this.pos < i12) {
                    intArrayList.addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(readSFixed32());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readSFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSFixed64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = readVarint32();
                verifyPackedFixed64Length(varint32);
                int i11 = this.pos + varint32;
                while (this.pos < i11) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.addLong(readSFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = readVarint32();
            verifyPackedFixed64Length(varint322);
            int i12 = this.pos + varint322;
            while (this.pos < i12) {
                longArrayList.addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readSInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSInt32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.pos + readVarint32();
                    while (this.pos < varint32) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readSInt32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.pos + readVarint32();
                while (this.pos < varint322) {
                    intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                }
                return;
            }
            do {
                intArrayList.addInt(readSInt32());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readSInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSInt64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.pos + readVarint32();
                    while (this.pos < varint32) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(readSInt64()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.pos + readVarint32();
                while (this.pos < varint322) {
                    longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                }
                return;
            }
            do {
                longArrayList.addLong(readSInt64());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public String readString() {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z10) throws InvalidProtocolBufferException {
            requireWireType(2);
            int varint32 = readVarint32();
            if (varint32 == 0) {
                return "";
            }
            requireBytes(varint32);
            if (z10) {
                byte[] bArr = this.buffer;
                int i = this.pos;
                if (!Utf8.isValidUtf8(bArr, i, i + varint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, varint32, Internal.UTF_8);
            this.pos += varint32;
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readStringList(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z10) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            int i3;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if (!(list instanceof LazyStringList) || z10) {
                do {
                    list.add(readStringInternal(z10));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readStringListRequireUtf8(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readStringListInternal(list, true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public String readStringRequireUtf8() {
            return readStringInternal(true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readUInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readUInt32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.pos + readVarint32();
                    while (this.pos < varint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readUInt32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.pos + readVarint32();
                while (this.pos < varint322) {
                    intArrayList.addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.addInt(readUInt32());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readUInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readUInt64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i3;
            boolean z10 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z10) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = this.pos + readVarint32();
                while (this.pos < varint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
                requirePosition(varint32);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 0) {
                do {
                    longArrayList.addLong(readUInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = this.pos + readVarint32();
            while (this.pos < varint322) {
                longArrayList.addLong(readVarint64());
            }
            requirePosition(varint322);
        }

        public long readVarint64() throws InvalidProtocolBufferException {
            long j10;
            long j11;
            long j12;
            int i = this.pos;
            int i3 = this.limit;
            if (i3 == i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i10 = i + 1;
            byte b10 = bArr[i];
            if (b10 >= 0) {
                this.pos = i10;
                return b10;
            }
            if (i3 - i10 < 9) {
                return readVarint64SlowPath();
            }
            int i11 = i + 2;
            int i12 = (bArr[i10] << 7) ^ b10;
            if (i12 < 0) {
                j10 = i12 ^ (-128);
            } else {
                int i13 = i + 3;
                int i14 = (bArr[i11] << 14) ^ i12;
                if (i14 >= 0) {
                    j10 = i14 ^ 16256;
                    i11 = i13;
                } else {
                    int i15 = i + 4;
                    int i16 = i14 ^ (bArr[i13] << 21);
                    if (i16 < 0) {
                        long j13 = (-2080896) ^ i16;
                        i11 = i15;
                        j10 = j13;
                    } else {
                        long j14 = i16;
                        i11 = i + 5;
                        long j15 = j14 ^ (bArr[i15] << 28);
                        if (j15 >= 0) {
                            j12 = 266354560;
                        } else {
                            int i17 = i + 6;
                            long j16 = j15 ^ (bArr[i11] << 35);
                            if (j16 < 0) {
                                j11 = -34093383808L;
                            } else {
                                i11 = i + 7;
                                j15 = j16 ^ (bArr[i17] << 42);
                                if (j15 >= 0) {
                                    j12 = 4363953127296L;
                                } else {
                                    i17 = i + 8;
                                    j16 = j15 ^ (bArr[i11] << 49);
                                    if (j16 < 0) {
                                        j11 = -558586000294016L;
                                    } else {
                                        i11 = i + 9;
                                        long j17 = (j16 ^ (bArr[i17] << 56)) ^ 71499008037633920L;
                                        if (j17 < 0) {
                                            int i18 = i + 10;
                                            if (bArr[i11] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i11 = i18;
                                        }
                                        j10 = j17;
                                    }
                                }
                            }
                            j10 = j16 ^ j11;
                            i11 = i17;
                        }
                        j10 = j15 ^ j12;
                    }
                }
            }
            this.pos = i11;
            return j10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public boolean skipField() throws InvalidProtocolBufferException {
            int i;
            if (isAtEnd() || (i = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipGroup();
                return true;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipBytes(4);
            return true;
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            T tNewInstance = schema.newInstance();
            mergeGroupField(tNewInstance, schema, extensionRegistryLite);
            schema.makeImmutable(tNewInstance);
            return tNewInstance;
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            T tNewInstance = schema.newInstance();
            mergeMessageField(tNewInstance, schema, extensionRegistryLite);
            schema.makeImmutable(tNewInstance);
            return tNewInstance;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }
    }
}
