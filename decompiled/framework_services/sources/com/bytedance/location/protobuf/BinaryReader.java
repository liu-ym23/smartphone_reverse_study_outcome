package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.BinaryReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L59:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L63:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L77:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L55:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L61:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L57:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
            return;
        }
    }

    private static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer bytebuf, boolean bufferIsImmutable) {
            super(null);
            this.bufferIsImmutable = bufferIsImmutable;
            this.buffer = bytebuf.array();
            int r0 = bytebuf.arrayOffset() + bytebuf.position();
            this.pos = r0;
            this.initialPos = r0;
            this.limit = bytebuf.arrayOffset() + bytebuf.limit();
        }

        private boolean isAtEnd() {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.location.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int getFieldNumber() throws IOException {
            if (isAtEnd() == false) goto L5;
            return Integer.MAX_VALUE;
        L5:
            this.tag = readVarint32();
            if (this.tag != this.endGroupTag) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return WireFormat.getTagFieldNumber(this.tag);
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public boolean skipField() throws IOException {
            if (isAtEnd() == false) goto L5;
            return false;
        L5:
            if (this.tag != this.endGroupTag) goto L8;
            return false;
        L8:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L10;
                case 5: goto L11;
                default: goto L10;
            };
        L11:
            skipBytes(4);
            return true;
        L13:
            skipGroup();
            return true;
        L15:
            skipBytes(readVarint32());
            return true;
        L17:
            skipBytes(8);
            return true;
        L19:
            skipVarint();
            return true;
        L10:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.bytedance.location.protobuf.Reader
        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.bytedance.location.protobuf.Reader
        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public boolean readBool() throws IOException {
            requireWireType(0);
            if (readVarint32() == 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public String readString() throws IOException {
            return readStringInternal(false);
        }

        @Override // com.bytedance.location.protobuf.Reader
        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public String readStringInternal(boolean requireUtf8) throws IOException {
            requireWireType(2);
            int size = readVarint32();
            if (size != 0) goto L6;
            return "";
        L6:
            requireBytes(size);
            if (requireUtf8 == true) goto L9;
        L13:
            String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
            this.pos += size;
            return result;
        L9:
            if (Utf8.isValidUtf8(this.buffer, this.pos, this.pos + size) == true) goto L13;
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public <T> T readMessage(Class<T> r2, ExtensionRegistryLite r3) throws IOException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor(r2), r3);
        }

        @Override // com.bytedance.location.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> r2, ExtensionRegistryLite r3) throws IOException {
            requireWireType(2);
            return (T) readMessage(r2, r3);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistry);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public <T> void mergeMessageField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int size = readVarint32();
            requireBytes(size);
            int prevLimit = this.limit;
            int newLimit = this.pos + size;
            this.limit = newLimit;
            schema.mergeFrom(target, this, extensionRegistry);     // Catch: Throwable -> L9
            if (this.pos != newLimit) goto L8;
            this.limit = prevLimit;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.limit = prevLimit;
            throw th;
        }

        @Override // com.bytedance.location.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> r2, ExtensionRegistryLite r3) throws IOException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor(r2), r3);
        }

        @Override // com.bytedance.location.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> r2, ExtensionRegistryLite r3) throws IOException {
            requireWireType(3);
            return (T) readGroup(r2, r3);
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistry);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public <T> void mergeGroupField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevEndGroupTag = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            schema.mergeFrom(target, this, extensionRegistry);     // Catch: Throwable -> L9
            if (this.tag != this.endGroupTag) goto L8;
            this.endGroupTag = prevEndGroupTag;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.endGroupTag = prevEndGroupTag;
            throw th;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public ByteString readBytes() throws IOException {
            requireWireType(2);
            int size = readVarint32();
            if (size == 0) goto L5;
            requireBytes(size);
            if (this.bufferIsImmutable == false) goto L9;
            ByteString bytes = ByteString.wrap(this.buffer, this.pos, size);
        L10:
            this.pos += size;
            return bytes;
        L9:
            bytes = ByteString.copyFrom(this.buffer, this.pos, size);
            goto L10
        L5:
            return ByteString.EMPTY;
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.bytedance.location.protobuf.Reader
        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readDoubleList(List<Double> target) throws IOException {
            if ((target instanceof DoubleArrayList) == false) goto L22;
            DoubleArrayList plist = (DoubleArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 1: goto L13;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            verifyPackedFixed64Length(bytes);
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            goto L10
        L29:
            return;
        L13:
            plist.addDouble(readDouble());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 1: goto L30;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            verifyPackedFixed64Length(bytes2);
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
            goto L27
        L46:
            return;
        L30:
            target.add(Double.valueOf(readDouble()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readFloatList(List<Float> target) throws IOException {
            if ((target instanceof FloatArrayList) == false) goto L22;
            FloatArrayList plist = (FloatArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 2: goto L16;
                case 5: goto L8;
                default: goto L7;
            };
        L8:
            plist.addFloat(readFloat());
            if (isAtEnd() == true) goto L10;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L8;
            this.pos = prevPos;
            return;
        L10:
            return;
        L16:
            int bytes = readVarint32();
            verifyPackedFixed32Length(bytes);
            int fieldEndPos = this.pos + bytes;
        L18:
            if (this.pos >= fieldEndPos) goto L37;
            plist.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
            goto L18
        L37:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 2: goto L33;
                case 5: goto L25;
                default: goto L24;
            };
        L25:
            target.add(Float.valueOf(readFloat()));
            if (isAtEnd() == true) goto L27;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L25;
            this.pos = prevPos2;
            return;
        L27:
            return;
        L33:
            int bytes2 = readVarint32();
            verifyPackedFixed32Length(bytes2);
            int fieldEndPos2 = this.pos + bytes2;
        L35:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
            goto L35
        L46:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readUInt64List(List<Long> target) throws IOException {
            if ((target instanceof LongArrayList) == false) goto L22;
            LongArrayList plist = (LongArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L12;
            plist.addLong(readVarint64());
            goto L10
        L12:
            requirePosition(fieldEndPos);
            return;
        L13:
            plist.addLong(readUInt64());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L31;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L29;
            target.add(Long.valueOf(readVarint64()));
            goto L27
        L29:
            requirePosition(fieldEndPos2);
            return;
        L31:
            target.add(Long.valueOf(readUInt64()));
            if (isAtEnd() == true) goto L33;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L31;
            this.pos = prevPos2;
            return;
        L33:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readInt64List(List<Long> target) throws IOException {
            if ((target instanceof LongArrayList) == false) goto L22;
            LongArrayList plist = (LongArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L12;
            plist.addLong(readVarint64());
            goto L10
        L12:
            requirePosition(fieldEndPos);
            return;
        L13:
            plist.addLong(readInt64());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L31;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L29;
            target.add(Long.valueOf(readVarint64()));
            goto L27
        L29:
            requirePosition(fieldEndPos2);
            return;
        L31:
            target.add(Long.valueOf(readInt64()));
            if (isAtEnd() == true) goto L33;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L31;
            this.pos = prevPos2;
            return;
        L33:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readInt32List(List<Integer> target) throws IOException {
            if ((target instanceof IntArrayList) == false) goto L22;
            IntArrayList plist = (IntArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L12;
            plist.addInt(readVarint32());
            goto L10
        L12:
            requirePosition(fieldEndPos);
            return;
        L13:
            plist.addInt(readInt32());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L31;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L29;
            target.add(Integer.valueOf(readVarint32()));
            goto L27
        L29:
            requirePosition(fieldEndPos2);
            return;
        L31:
            target.add(Integer.valueOf(readInt32()));
            if (isAtEnd() == true) goto L33;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L31;
            this.pos = prevPos2;
            return;
        L33:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readFixed64List(List<Long> target) throws IOException {
            if ((target instanceof LongArrayList) == false) goto L22;
            LongArrayList plist = (LongArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 1: goto L13;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            verifyPackedFixed64Length(bytes);
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addLong(readLittleEndian64_NoCheck());
            goto L10
        L29:
            return;
        L13:
            plist.addLong(readFixed64());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 1: goto L30;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            verifyPackedFixed64Length(bytes2);
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L27
        L46:
            return;
        L30:
            target.add(Long.valueOf(readFixed64()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readFixed32List(List<Integer> target) throws IOException {
            if ((target instanceof IntArrayList) == false) goto L22;
            IntArrayList plist = (IntArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 2: goto L16;
                case 5: goto L8;
                default: goto L7;
            };
        L8:
            plist.addInt(readFixed32());
            if (isAtEnd() == true) goto L10;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L8;
            this.pos = prevPos;
            return;
        L10:
            return;
        L16:
            int bytes = readVarint32();
            verifyPackedFixed32Length(bytes);
            int fieldEndPos = this.pos + bytes;
        L18:
            if (this.pos >= fieldEndPos) goto L37;
            plist.addInt(readLittleEndian32_NoCheck());
            goto L18
        L37:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 2: goto L33;
                case 5: goto L25;
                default: goto L24;
            };
        L25:
            target.add(Integer.valueOf(readFixed32()));
            if (isAtEnd() == true) goto L27;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L25;
            this.pos = prevPos2;
            return;
        L27:
            return;
        L33:
            int bytes2 = readVarint32();
            verifyPackedFixed32Length(bytes2);
            int fieldEndPos2 = this.pos + bytes2;
        L35:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L35
        L46:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readBoolList(List<Boolean> target) throws IOException {
            if ((target instanceof BooleanArrayList) == false) goto L26;
            BooleanArrayList plist = (BooleanArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L17;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L16;
            if (readVarint32() == 0) goto L14;
            boolean r5 = true;
        L15:
            plist.addBoolean(r5);
            goto L10
        L14:
            r5 = false;
            goto L15
        L16:
            requirePosition(fieldEndPos);
            return;
        L17:
            plist.addBoolean(readBool());
            if (isAtEnd() == true) goto L19;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L17;
            this.pos = prevPos;
            return;
        L19:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L26:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L39;
                case 1: goto L28;
                case 2: goto L29;
                default: goto L28;
            };
        L29:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L31:
            if (this.pos >= fieldEndPos2) goto L37;
            if (readVarint32() == 0) goto L35;
            boolean r4 = true;
        L36:
            target.add(Boolean.valueOf(r4));
            goto L31
        L35:
            r4 = false;
            goto L36
        L37:
            requirePosition(fieldEndPos2);
            return;
        L39:
            target.add(Boolean.valueOf(readBool()));
            if (isAtEnd() == true) goto L41;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L39;
            this.pos = prevPos2;
            return;
        L41:
            return;
        L28:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readStringList(List<String> target) throws IOException {
            readStringListInternal(target, false);
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readStringListRequireUtf8(List<String> target) throws IOException {
            readStringListInternal(target, true);
        }

        public void readStringListInternal(List<String> target, boolean requireUtf8) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L25;
            if ((target instanceof LazyStringList) == false) goto L16;
            if (requireUtf8 == true) goto L16;
            LazyStringList lazyList = (LazyStringList) target;
        L8:
            lazyList.add(readBytes());
            if (isAtEnd() == true) goto L10;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L8;
            this.pos = prevPos;
            return;
        L10:
            return;
        L16:
            target.add(readStringInternal(requireUtf8));
            if (isAtEnd() == true) goto L18;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L16;
            this.pos = prevPos2;
            return;
        L18:
            return;
        L25:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public <T> void readMessageList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            Schema<T> schema = Protobuf.getInstance().schemaFor(targetType);
            readMessageList(target, schema, extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.location.protobuf.Reader
        public <T> void readMessageList(List<T> r4, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L14;
            int listTag = this.tag;
        L5:
            r4.add(readMessage(schema, extensionRegistry));
            if (isAtEnd() == true) goto L7;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == listTag) goto L5;
            this.pos = prevPos;
            return;
        L7:
            return;
        L14:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            Schema<T> schema = Protobuf.getInstance().schemaFor(targetType);
            readGroupList(target, schema, extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.location.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r4, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != 3) goto L14;
            int listTag = this.tag;
        L5:
            r4.add(readGroup(schema, extensionRegistry));
            if (isAtEnd() == true) goto L7;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == listTag) goto L5;
            this.pos = prevPos;
            return;
        L7:
            return;
        L14:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readBytesList(List<ByteString> target) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L13;
        L4:
            target.add(readBytes());
            if (isAtEnd() == true) goto L6;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L4;
            this.pos = prevPos;
            return;
        L6:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readUInt32List(List<Integer> target) throws IOException {
            if ((target instanceof IntArrayList) == false) goto L22;
            IntArrayList plist = (IntArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addInt(readVarint32());
            goto L10
        L29:
            return;
        L13:
            plist.addInt(readUInt32());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L30;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Integer.valueOf(readVarint32()));
            goto L27
        L46:
            return;
        L30:
            target.add(Integer.valueOf(readUInt32()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readEnumList(List<Integer> target) throws IOException {
            if ((target instanceof IntArrayList) == false) goto L22;
            IntArrayList plist = (IntArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addInt(readVarint32());
            goto L10
        L29:
            return;
        L13:
            plist.addInt(readEnum());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L30;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Integer.valueOf(readVarint32()));
            goto L27
        L46:
            return;
        L30:
            target.add(Integer.valueOf(readEnum()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readSFixed32List(List<Integer> target) throws IOException {
            if ((target instanceof IntArrayList) == false) goto L22;
            IntArrayList plist = (IntArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 2: goto L16;
                case 5: goto L8;
                default: goto L7;
            };
        L8:
            plist.addInt(readSFixed32());
            if (isAtEnd() == true) goto L10;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L8;
            this.pos = prevPos;
            return;
        L10:
            return;
        L16:
            int bytes = readVarint32();
            verifyPackedFixed32Length(bytes);
            int fieldEndPos = this.pos + bytes;
        L18:
            if (this.pos >= fieldEndPos) goto L37;
            plist.addInt(readLittleEndian32_NoCheck());
            goto L18
        L37:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 2: goto L33;
                case 5: goto L25;
                default: goto L24;
            };
        L25:
            target.add(Integer.valueOf(readSFixed32()));
            if (isAtEnd() == true) goto L27;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L25;
            this.pos = prevPos2;
            return;
        L27:
            return;
        L33:
            int bytes2 = readVarint32();
            verifyPackedFixed32Length(bytes2);
            int fieldEndPos2 = this.pos + bytes2;
        L35:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L35
        L46:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readSFixed64List(List<Long> target) throws IOException {
            if ((target instanceof LongArrayList) == false) goto L22;
            LongArrayList plist = (LongArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 1: goto L13;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            verifyPackedFixed64Length(bytes);
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addLong(readLittleEndian64_NoCheck());
            goto L10
        L29:
            return;
        L13:
            plist.addLong(readSFixed64());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 1: goto L30;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            verifyPackedFixed64Length(bytes2);
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L27
        L46:
            return;
        L30:
            target.add(Long.valueOf(readSFixed64()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readSInt32List(List<Integer> target) throws IOException {
            if ((target instanceof IntArrayList) == false) goto L22;
            IntArrayList plist = (IntArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
            goto L10
        L29:
            return;
        L13:
            plist.addInt(readSInt32());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L30;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
            goto L27
        L46:
            return;
        L30:
            target.add(Integer.valueOf(readSInt32()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.bytedance.location.protobuf.Reader
        public void readSInt64List(List<Long> target) throws IOException {
            if ((target instanceof LongArrayList) == false) goto L22;
            LongArrayList plist = (LongArrayList) target;
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L13;
                case 1: goto L7;
                case 2: goto L8;
                default: goto L7;
            };
        L8:
            int bytes = readVarint32();
            int fieldEndPos = this.pos + bytes;
        L10:
            if (this.pos >= fieldEndPos) goto L29;
            plist.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
            goto L10
        L29:
            return;
        L13:
            plist.addLong(readSInt64());
            if (isAtEnd() == true) goto L15;
            int prevPos = this.pos;
            int nextTag = readVarint32();
            if (nextTag == this.tag) goto L13;
            this.pos = prevPos;
            return;
        L15:
            return;
        L7:
            throw InvalidProtocolBufferException.invalidWireType();
        L22:
            switch(WireFormat.getTagWireType(this.tag)) {
                case 0: goto L30;
                case 1: goto L24;
                case 2: goto L25;
                default: goto L24;
            };
        L25:
            int bytes2 = readVarint32();
            int fieldEndPos2 = this.pos + bytes2;
        L27:
            if (this.pos >= fieldEndPos2) goto L46;
            target.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
            goto L27
        L46:
            return;
        L30:
            target.add(Long.valueOf(readSInt64()));
            if (isAtEnd() == true) goto L32;
            int prevPos2 = this.pos;
            int nextTag2 = readVarint32();
            if (nextTag2 == this.tag) goto L30;
            this.pos = prevPos2;
            return;
        L32:
            return;
        L24:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.location.protobuf.Reader
        public <K, V> void readMap(Map<K, V> r10, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(2);
            int size = readVarint32();
            requireBytes(size);
            int prevLimit = this.limit;
            int newLimit = this.pos + size;
            this.limit = newLimit;
            Object r3 = metadata.defaultKey;     // Catch: Throwable -> L9
            Object r4 = metadata.defaultValue;     // Catch: Throwable -> L9
        L4:
            int number = getFieldNumber();     // Catch: Throwable -> L9
            if (number == Integer.MAX_VALUE) goto L6;
            switch(number) {
                case 1: goto L22;
                case 2: goto L20;
                default: goto L32;
            };
        L20:
            r4 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);     // Catch: Throwable -> L9 InvalidProtocolBufferException.InvalidWireTypeException -> L18
            goto L4
        L32:
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: Throwable -> L9 InvalidProtocolBufferException.InvalidWireTypeException -> L18
        L26:
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: Throwable -> L9
        L22:
            r3 = readField(metadata.keyType, null, null);     // Catch: Throwable -> L9 InvalidProtocolBufferException.InvalidWireTypeException -> L18
            goto L4
        L6:
            r10.put(r3, r4);     // Catch: Throwable -> L9
            this.limit = prevLimit;
            return;
        L9:
            th = move-exception;
            this.limit = prevLimit;
            throw th;
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> messageType, ExtensionRegistryLite extensionRegistry) throws IOException {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1: goto L39;
                case 2: goto L37;
                case 3: goto L35;
                case 4: goto L33;
                case 5: goto L31;
                case 6: goto L29;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L23;
                case 10: goto L21;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L11;
                case 16: goto L9;
                case 17: goto L7;
                default: goto L5;
            };
        L5:
            throw new RuntimeException("unsupported field type.");
        L7:
            return Long.valueOf(readUInt64());
        L9:
            return Integer.valueOf(readUInt32());
        L11:
            return readStringRequireUtf8();
        L13:
            return Long.valueOf(readSInt64());
        L15:
            return Integer.valueOf(readSInt32());
        L17:
            return Long.valueOf(readSFixed64());
        L19:
            return Integer.valueOf(readSFixed32());
        L21:
            return readMessage(messageType, extensionRegistry);
        L23:
            return Long.valueOf(readInt64());
        L25:
            return Integer.valueOf(readInt32());
        L27:
            return Float.valueOf(readFloat());
        L29:
            return Long.valueOf(readFixed64());
        L31:
            return Integer.valueOf(readFixed32());
        L33:
            return Integer.valueOf(readEnum());
        L35:
            return Double.valueOf(readDouble());
        L37:
            return readBytes();
        L39:
            return Boolean.valueOf(readBool());
        }

        private int readVarint32() throws IOException {
            int i = this.pos;
            if (this.limit == this.pos) goto L41;
            int i2 = i + 1;
            int x = this.buffer[i];
            if (x < 0) goto L9;
            this.pos = i2;
            return x;
        L9:
            if ((this.limit - i2) < 9) goto L11;
            int i3 = i2 + 1;
            int x2 = (this.buffer[i2] << 7) ^ x;
            if (x2 >= 0) goto L15;
            int y = x2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L38:
            this.pos = i3;
            return y;
        L15:
            int i4 = i3 + 1;
            int x3 = (this.buffer[i3] << 14) ^ x2;
            if (x3 < 0) goto L18;
            y = x3 ^ 16256;
            i3 = i4;
            goto L38
        L18:
            i3 = i4 + 1;
            int x4 = (this.buffer[i4] << ParameterName.BLUE_STRETCH) ^ x3;
            if (x4 >= 0) goto L21;
            y = (-2080896) ^ x4;
            goto L38
        L21:
            int i5 = i3 + 1;
            int y2 = this.buffer[i3];
            int x5 = (x4 ^ (y2 << 28)) ^ 266354560;
            if (y2 >= 0) goto L37;
            int i6 = i5 + 1;
            if (this.buffer[i5] >= 0) goto L33;
            i3 = i6 + 1;
            if (this.buffer[i6] >= 0) goto L36;
            i6 = i3 + 1;
            if (this.buffer[i3] >= 0) goto L33;
            i3 = i6 + 1;
            if (this.buffer[i6] >= 0) goto L36;
            i6 = i3 + 1;
            if (this.buffer[i3] >= 0) goto L33;
            throw InvalidProtocolBufferException.malformedVarint();
        L36:
            y = x5;
        L33:
            y = x5;
            i3 = i6;
            goto L38
        L37:
            y = x5;
            i3 = i5;
            goto L38
        L11:
            return (int) readVarint64SlowPath();
        L41:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long readVarint64() throws IOException {
            int i = this.pos;
            if (this.limit == i) goto L44;
            byte[] buffer = this.buffer;
            int i2 = i + 1;
            int y = buffer[i];
            if (y < 0) goto L9;
            this.pos = i2;
            return y;
        L9:
            if ((this.limit - i2) < 9) goto L11;
            int i3 = i2 + 1;
            int y2 = (buffer[i2] << 7) ^ y;
            if (y2 >= 0) goto L15;
            long x = y2 ^ UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION;
        L41:
            this.pos = i3;
            return x;
        L15:
            int i4 = i3 + 1;
            int y3 = (buffer[i3] << 14) ^ y2;
            if (y3 < 0) goto L18;
            x = y3 ^ 16256;
            i3 = i4;
            goto L41
        L18:
            i3 = i4 + 1;
            int y4 = (buffer[i4] << 21) ^ y3;
            if (y4 >= 0) goto L21;
            x = (-2080896) ^ y4;
            goto L41
        L21:
            long x2 = y4;
            int i5 = i3 + 1;
            long x3 = x2 ^ (((long) buffer[i3]) << 28);
            if (x3 < 0) goto L24;
            x = 266354560 ^ x3;
            i3 = i5;
            goto L41
        L24:
            i3 = i5 + 1;
            long x4 = (((long) buffer[i5]) << 35) ^ x3;
            if (x4 >= 0) goto L27;
            x = (-34093383808L) ^ x4;
            goto L41
        L27:
            int i6 = i3 + 1;
            long x5 = (((long) buffer[i3]) << 42) ^ x4;
            if (x5 < 0) goto L30;
            x = 4363953127296L ^ x5;
            i3 = i6;
            goto L41
        L30:
            i3 = i6 + 1;
            long x6 = (((long) buffer[i6]) << 49) ^ x5;
            if (x6 >= 0) goto L33;
            x = (-558586000294016L) ^ x6;
            goto L41
        L33:
            int i7 = i3 + 1;
            x = ((((long) buffer[i3]) << 56) ^ x6) ^ 71499008037633920L;
            if (x >= 0) goto L40;
            i3 = i7 + 1;
            if (buffer[i7] >= 0) goto L41;
            throw InvalidProtocolBufferException.malformedVarint();
        L40:
            i3 = i7;
            goto L41
        L11:
            return readVarint64SlowPath();
        L44:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private long readVarint64SlowPath() throws IOException {
            long result = 0;
            int shift = 0;
        L4:
            if (shift >= 64) goto L10;
            byte b = readByte();
            result = result | (((long) (b & 127)) << shift);
            if ((b & 128) == 0) goto L7;
            shift = shift + 7;
            goto L4
        L7:
            return result;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private byte readByte() throws IOException {
            if (this.pos == this.limit) goto L7;
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 + 1;
            return r0[r1];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int p = this.pos;
            byte[] buffer = this.buffer;
            this.pos = p + 4;
            return (((buffer[p] & CecDeviceType.INACTIVE) | ((buffer[p + 1] & CecDeviceType.INACTIVE) << 8)) | ((buffer[p + 2] & CecDeviceType.INACTIVE) << 16)) | ((buffer[p + 3] & CecDeviceType.INACTIVE) << 24);
        }

        private long readLittleEndian64_NoCheck() {
            int p = this.pos;
            byte[] buffer = this.buffer;
            this.pos = p + 8;
            return (((((((((long) buffer[p]) & 255) | ((((long) buffer[p + 1]) & 255) << 8)) | ((((long) buffer[p + 2]) & 255) << 16)) | ((((long) buffer[p + 3]) & 255) << 24)) | ((((long) buffer[p + 4]) & 255) << 32)) | ((((long) buffer[p + 5]) & 255) << 40)) | ((((long) buffer[p + 6]) & 255) << 48)) | ((255 & ((long) buffer[p + 7])) << 56);
        }

        private void skipVarint() throws IOException {
            if ((this.limit - this.pos) < 10) goto L11;
            byte[] buffer = this.buffer;
            int p = this.pos;
            int i = 0;
        L5:
            if (i >= 10) goto L11;
            int p2 = p + 1;
            if (buffer[p] >= 0) goto L8;
            i = i + 1;
            p = p2;
            goto L5
        L8:
            this.pos = p2;
            return;
        L11:
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            int i = 0;
        L4:
            if (i >= 10) goto L10;
            if (readByte() >= 0) goto L7;
            i = i + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipBytes(int size) throws IOException {
            requireBytes(size);
            this.pos += size;
        }

        private void skipGroup() throws IOException {
            int prevEndGroupTag = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        L4:
            if (getFieldNumber() == Integer.MAX_VALUE) goto L8;
            if (skipField() == true) goto L4;
        L8:
            if (this.tag != this.endGroupTag) goto L12;
            this.endGroupTag = prevEndGroupTag;
            return;
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void requireBytes(int size) throws IOException {
            if (size < 0) goto L7;
            if (size > (this.limit - this.pos)) goto L7;
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requireWireType(int requiredWireType) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != requiredWireType) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        private void verifyPackedFixed64Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 7) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void verifyPackedFixed32Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 3) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void requirePosition(int expectedPosition) throws IOException {
            if (this.pos != expectedPosition) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public abstract int getTotalBytesRead();

    /* synthetic */ BinaryReader(AnonymousClass1 x0) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer buffer, boolean bufferIsImmutable) {
        if (buffer.hasArray() == false) goto L7;
        return new SafeHeapReader(buffer, bufferIsImmutable);
    L7:
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private BinaryReader() {
    }

    @Override // com.bytedance.location.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }
}
