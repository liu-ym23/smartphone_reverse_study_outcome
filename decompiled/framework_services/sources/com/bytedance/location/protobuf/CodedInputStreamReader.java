package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class CodedInputStreamReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;
    private final CodedInputStream input;
    private int nextTag;
    private int tag;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.CodedInputStreamReader$1, reason: invalid class name */
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

    public static CodedInputStreamReader forCodedInput(CodedInputStream input) {
        if (input.wrapper == null) goto L7;
        return input.wrapper;
    L7:
        return new CodedInputStreamReader(input);
    }

    private CodedInputStreamReader(CodedInputStream input) {
        this.nextTag = 0;
        this.input = (CodedInputStream) Internal.checkNotNull(input, "input");
        this.input.wrapper = this;
    }

    @Override // com.bytedance.location.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int getFieldNumber() throws IOException {
        if (this.nextTag == 0) goto L5;
        this.tag = this.nextTag;
        this.nextTag = 0;
    L7:
        if (this.tag != 0) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (this.tag != this.endGroupTag) goto L12;
        return Integer.MAX_VALUE;
    L12:
        return WireFormat.getTagFieldNumber(this.tag);
    L5:
        this.tag = this.input.readTag();
        goto L7
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // com.bytedance.location.protobuf.Reader
    public boolean skipField() throws IOException {
        if (this.input.isAtEnd() == false) goto L5;
        return false;
    L5:
        if (this.tag != this.endGroupTag) goto L8;
        return false;
    L8:
        return this.input.skipField(this.tag);
    }

    private void requireWireType(int requiredWireType) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != requiredWireType) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public double readDouble() throws IOException {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public float readFloat() throws IOException {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public long readUInt64() throws IOException {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public long readInt64() throws IOException {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int readInt32() throws IOException {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public long readFixed64() throws IOException {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int readFixed32() throws IOException {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public boolean readBool() throws IOException {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public String readString() throws IOException {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public String readStringRequireUtf8() throws IOException {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
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

    @Override // com.bytedance.location.protobuf.Reader
    public <T> void mergeMessageField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        requireWireType(2);
        mergeMessageFieldInternal(target, schema, extensionRegistry);
    }

    private <T> void mergeMessageFieldInternal(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        int size = this.input.readUInt32();
        if (this.input.recursionDepth >= this.input.recursionLimit) goto L7;
        int prevLimit = this.input.pushLimit(size);
        this.input.recursionDepth++;
        schema.mergeFrom(target, this, extensionRegistry);
        this.input.checkLastTagWas(0);
        this.input.recursionDepth--;
        this.input.popLimit(prevLimit);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        T newInstance = schema.newInstance();
        mergeMessageFieldInternal(newInstance, schema, extensionRegistry);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    @Override // com.bytedance.location.protobuf.Reader
    public <T> void mergeGroupField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        requireWireType(3);
        mergeGroupFieldInternal(target, schema, extensionRegistry);
    }

    private <T> void mergeGroupFieldInternal(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
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

    private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        T newInstance = schema.newInstance();
        mergeGroupFieldInternal(newInstance, schema, extensionRegistry);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    @Override // com.bytedance.location.protobuf.Reader
    public ByteString readBytes() throws IOException {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int readUInt32() throws IOException {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int readEnum() throws IOException {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int readSFixed32() throws IOException {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public long readSFixed64() throws IOException {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public int readSInt32() throws IOException {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public long readSInt64() throws IOException {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readDoubleList(List<Double> target) throws IOException {
        if ((target instanceof DoubleArrayList) == false) goto L21;
        DoubleArrayList plist = (DoubleArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 1: goto L12;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        verifyPackedFixed64Length(bytes);
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addDouble(this.input.readDouble());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        return;
    L12:
        plist.addDouble(this.input.readDouble());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 1: goto L28;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        verifyPackedFixed64Length(bytes2);
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Double.valueOf(this.input.readDouble()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        return;
    L28:
        target.add(Double.valueOf(this.input.readDouble()));
        if (this.input.isAtEnd() == true) goto L30;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L28;
        this.nextTag = nextTag2;
        return;
    L30:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readFloatList(List<Float> target) throws IOException {
        if ((target instanceof FloatArrayList) == false) goto L21;
        FloatArrayList plist = (FloatArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 2: goto L16;
            case 5: goto L8;
            default: goto L7;
        };
    L8:
        plist.addFloat(this.input.readFloat());
        if (this.input.isAtEnd() == true) goto L10;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L8;
        this.nextTag = nextTag;
        return;
    L10:
        return;
    L16:
        int bytes = this.input.readUInt32();
        verifyPackedFixed32Length(bytes);
        int endPos = this.input.getTotalBytesRead() + bytes;
    L17:
        plist.addFloat(this.input.readFloat());
        if (this.input.getTotalBytesRead() < endPos) goto L17;
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 2: goto L32;
            case 5: goto L24;
            default: goto L23;
        };
    L24:
        target.add(Float.valueOf(this.input.readFloat()));
        if (this.input.isAtEnd() == true) goto L26;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L24;
        this.nextTag = nextTag2;
        return;
    L26:
        return;
    L32:
        int bytes2 = this.input.readUInt32();
        verifyPackedFixed32Length(bytes2);
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L33:
        target.add(Float.valueOf(this.input.readFloat()));
        if (this.input.getTotalBytesRead() < endPos2) goto L33;
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readUInt64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L21;
        LongArrayList plist = (LongArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addLong(this.input.readUInt64());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addLong(this.input.readUInt64());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readInt64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L21;
        LongArrayList plist = (LongArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addLong(this.input.readInt64());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addLong(this.input.readInt64());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Long.valueOf(this.input.readInt64()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Long.valueOf(this.input.readInt64()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readInt32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L21;
        IntArrayList plist = (IntArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addInt(this.input.readInt32());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addInt(this.input.readInt32());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readFixed64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L21;
        LongArrayList plist = (LongArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 1: goto L12;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        verifyPackedFixed64Length(bytes);
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addLong(this.input.readFixed64());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        return;
    L12:
        plist.addLong(this.input.readFixed64());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 1: goto L28;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        verifyPackedFixed64Length(bytes2);
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        return;
    L28:
        target.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.isAtEnd() == true) goto L30;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L28;
        this.nextTag = nextTag2;
        return;
    L30:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readFixed32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L21;
        IntArrayList plist = (IntArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 2: goto L16;
            case 5: goto L8;
            default: goto L7;
        };
    L8:
        plist.addInt(this.input.readFixed32());
        if (this.input.isAtEnd() == true) goto L10;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L8;
        this.nextTag = nextTag;
        return;
    L10:
        return;
    L16:
        int bytes = this.input.readUInt32();
        verifyPackedFixed32Length(bytes);
        int endPos = this.input.getTotalBytesRead() + bytes;
    L17:
        plist.addInt(this.input.readFixed32());
        if (this.input.getTotalBytesRead() < endPos) goto L17;
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 2: goto L32;
            case 5: goto L24;
            default: goto L23;
        };
    L24:
        target.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.isAtEnd() == true) goto L26;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L24;
        this.nextTag = nextTag2;
        return;
    L26:
        return;
    L32:
        int bytes2 = this.input.readUInt32();
        verifyPackedFixed32Length(bytes2);
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L33:
        target.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.getTotalBytesRead() < endPos2) goto L33;
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readBoolList(List<Boolean> target) throws IOException {
        if ((target instanceof BooleanArrayList) == false) goto L21;
        BooleanArrayList plist = (BooleanArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addBoolean(this.input.readBool());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addBoolean(this.input.readBool());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
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
        if (WireFormat.getTagWireType(this.tag) != 2) goto L28;
        if ((target instanceof LazyStringList) == false) goto L16;
        if (requireUtf8 == true) goto L16;
        LazyStringList lazyList = (LazyStringList) target;
    L8:
        lazyList.add(readBytes());
        if (this.input.isAtEnd() == true) goto L10;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L8;
        this.nextTag = nextTag;
        return;
    L10:
        return;
    L16:
        if (requireUtf8 == false) goto L18;
        String r0 = readStringRequireUtf8();
    L19:
        target.add(r0);
        if (this.input.isAtEnd() == true) goto L21;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L16;
        this.nextTag = nextTag2;
        return;
    L21:
        return;
    L18:
        r0 = readString();
        goto L19
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public <T> void readMessageList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
        Schema<T> schema = Protobuf.getInstance().schemaFor(targetType);
        readMessageList(target, schema, extensionRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.location.protobuf.Reader
    public <T> void readMessageList(List<T> r3, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L17;
        int listTag = this.tag;
    L5:
        r3.add(readMessage(schema, extensionRegistry));
        if (this.input.isAtEnd() == true) goto L15;
        if (this.nextTag != 0) goto L22;
        int nextTag = this.input.readTag();
        if (nextTag == listTag) goto L5;
        this.nextTag = nextTag;
        return;
    L22:
        return;
    L15:
        return;
    L17:
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
    public <T> void readGroupList(List<T> r3, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 3) goto L17;
        int listTag = this.tag;
    L5:
        r3.add(readGroup(schema, extensionRegistry));
        if (this.input.isAtEnd() == true) goto L15;
        if (this.nextTag != 0) goto L22;
        int nextTag = this.input.readTag();
        if (nextTag == listTag) goto L5;
        this.nextTag = nextTag;
        return;
    L22:
        return;
    L15:
        return;
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readBytesList(List<ByteString> target) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L13;
    L4:
        target.add(readBytes());
        if (this.input.isAtEnd() == true) goto L6;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L4;
        this.nextTag = nextTag;
        return;
    L6:
        return;
    L13:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readUInt32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L21;
        IntArrayList plist = (IntArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addInt(this.input.readUInt32());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addInt(this.input.readUInt32());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readEnumList(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L21;
        IntArrayList plist = (IntArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addInt(this.input.readEnum());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addInt(this.input.readEnum());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readSFixed32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L21;
        IntArrayList plist = (IntArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 2: goto L16;
            case 5: goto L8;
            default: goto L7;
        };
    L8:
        plist.addInt(this.input.readSFixed32());
        if (this.input.isAtEnd() == true) goto L10;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L8;
        this.nextTag = nextTag;
        return;
    L10:
        return;
    L16:
        int bytes = this.input.readUInt32();
        verifyPackedFixed32Length(bytes);
        int endPos = this.input.getTotalBytesRead() + bytes;
    L17:
        plist.addInt(this.input.readSFixed32());
        if (this.input.getTotalBytesRead() < endPos) goto L17;
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 2: goto L32;
            case 5: goto L24;
            default: goto L23;
        };
    L24:
        target.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.isAtEnd() == true) goto L26;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L24;
        this.nextTag = nextTag2;
        return;
    L26:
        return;
    L32:
        int bytes2 = this.input.readUInt32();
        verifyPackedFixed32Length(bytes2);
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L33:
        target.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.getTotalBytesRead() < endPos2) goto L33;
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readSFixed64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L21;
        LongArrayList plist = (LongArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 1: goto L12;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        verifyPackedFixed64Length(bytes);
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addLong(this.input.readSFixed64());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        return;
    L12:
        plist.addLong(this.input.readSFixed64());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 1: goto L28;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        verifyPackedFixed64Length(bytes2);
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        return;
    L28:
        target.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.isAtEnd() == true) goto L30;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L28;
        this.nextTag = nextTag2;
        return;
    L30:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readSInt32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L21;
        IntArrayList plist = (IntArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addInt(this.input.readSInt32());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addInt(this.input.readSInt32());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.bytedance.location.protobuf.Reader
    public void readSInt64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L21;
        LongArrayList plist = (LongArrayList) target;
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L12;
            case 1: goto L7;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        int bytes = this.input.readUInt32();
        int endPos = this.input.getTotalBytesRead() + bytes;
    L9:
        plist.addLong(this.input.readSInt64());
        if (this.input.getTotalBytesRead() < endPos) goto L9;
        requirePosition(endPos);
        return;
    L12:
        plist.addLong(this.input.readSInt64());
        if (this.input.isAtEnd() == true) goto L14;
        int nextTag = this.input.readTag();
        if (nextTag == this.tag) goto L12;
        this.nextTag = nextTag;
        return;
    L14:
        return;
    L7:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        switch(WireFormat.getTagWireType(this.tag)) {
            case 0: goto L29;
            case 1: goto L23;
            case 2: goto L24;
            default: goto L23;
        };
    L24:
        int bytes2 = this.input.readUInt32();
        int endPos2 = this.input.getTotalBytesRead() + bytes2;
    L25:
        target.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.getTotalBytesRead() < endPos2) goto L25;
        requirePosition(endPos2);
        return;
    L29:
        target.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.isAtEnd() == true) goto L31;
        int nextTag2 = this.input.readTag();
        if (nextTag2 == this.tag) goto L29;
        this.nextTag = nextTag2;
        return;
    L31:
        return;
    L23:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    private void verifyPackedFixed64Length(int bytes) throws IOException {
        if ((bytes & 7) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.location.protobuf.Reader
    public <K, V> void readMap(Map<K, V> r9, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
        requireWireType(2);
        int size = this.input.readUInt32();
        int prevLimit = this.input.pushLimit(size);
        Object r2 = metadata.defaultKey;
        Object r3 = metadata.defaultValue;
    L36:
        int number = getFieldNumber();     // Catch: Throwable -> L15
        if (number == Integer.MAX_VALUE) goto L29;
        if (this.input.isAtEnd() == true) goto L29;
        switch(number) {
            case 1: goto L21;
            case 2: goto L19;
            default: goto L34;
        };
    L19:
        r3 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);     // Catch: Throwable -> L15 InvalidProtocolBufferException.InvalidWireTypeException -> L17
        goto L36
    L34:
        if (skipField() == true) goto L36;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: Throwable -> L15 InvalidProtocolBufferException.InvalidWireTypeException -> L17
    L25:
        if (skipField() == true) goto L36;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: Throwable -> L15
    L21:
        r2 = readField(metadata.keyType, null, null);     // Catch: Throwable -> L15 InvalidProtocolBufferException.InvalidWireTypeException -> L17
    L29:
        r9.put(r2, r3);     // Catch: Throwable -> L15
        this.input.popLimit(prevLimit);
        return;
    L15:
        th = move-exception;
        this.input.popLimit(prevLimit);
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
        throw new IllegalArgumentException("unsupported field type.");
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

    private void verifyPackedFixed32Length(int bytes) throws IOException {
        if ((bytes & 3) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void requirePosition(int expectedPosition) throws IOException {
        if (this.input.getTotalBytesRead() != expectedPosition) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
