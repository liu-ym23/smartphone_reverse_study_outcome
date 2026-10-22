package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = null;
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    static {
        DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite first, UnknownFieldSetLite second) {
        int count = first.count + second.count;
        int[] tags = Arrays.copyOf(first.tags, count);
        System.arraycopy(second.tags, 0, tags, first.count, second.count);
        Object[] objects = Arrays.copyOf(first.objects, count);
        System.arraycopy(second.objects, 0, objects, first.count, second.count);
        return new UnknownFieldSetLite(count, tags, objects, true);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private UnknownFieldSetLite(int count, int[] tags, Object[] objects, boolean isMutable) {
        this.memoizedSerializedSize = -1;
        this.count = count;
        this.tags = tags;
        this.objects = objects;
        this.isMutable = isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = 0;
    L4:
        if (i >= this.count) goto L16;
        int tag = this.tags[i];
        int fieldNumber = WireFormat.getTagFieldNumber(tag);
        switch(WireFormat.getTagWireType(tag)) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L9;
            default: goto L8;
        };
    L9:
        output.writeFixed32(fieldNumber, ((Integer) this.objects[i]).intValue());
    L14:
        i = i + 1;
        goto L4
    L10:
        output.writeTag(fieldNumber, 3);
        ((UnknownFieldSetLite) this.objects[i]).writeTo(output);
        output.writeTag(fieldNumber, 4);
        goto L14
    L11:
        output.writeBytes(fieldNumber, (ByteString) this.objects[i]);
        goto L14
    L12:
        output.writeFixed64(fieldNumber, ((Long) this.objects[i]).longValue());
        goto L14
    L13:
        output.writeUInt64(fieldNumber, ((Long) this.objects[i]).longValue());
        goto L14
    L8:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void writeAsMessageSetTo(CodedOutputStream output) throws IOException {
        int i = 0;
    L4:
        if (i >= this.count) goto L7;
        int fieldNumber = WireFormat.getTagFieldNumber(this.tags[i]);
        output.writeRawMessageSetExtension(fieldNumber, (ByteString) this.objects[i]);
        i = i + 1;
        goto L4
    }

    void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L8;
        int i = this.count - 1;
    L5:
        if (i < 0) goto L12;
        int fieldNumber = WireFormat.getTagFieldNumber(this.tags[i]);
        writer.writeMessageSetItem(fieldNumber, this.objects[i]);
        i = i - 1;
        goto L5
    L12:
        return;
    L8:
        int i2 = 0;
    L10:
        if (i2 >= this.count) goto L15;
        int fieldNumber2 = WireFormat.getTagFieldNumber(this.tags[i2]);
        writer.writeMessageSetItem(fieldNumber2, this.objects[i2]);
        i2 = i2 + 1;
        goto L10
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.count != 0) goto L6;
        return;
    L6:
        if (writer.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L12;
        int i = 0;
    L9:
        if (i >= this.count) goto L15;
        writeField(this.tags[i], this.objects[i], writer);
        i = i + 1;
        goto L9
    L15:
        return;
    L12:
        int i2 = this.count - 1;
    L13:
        if (i2 < 0) goto L18;
        writeField(this.tags[i2], this.objects[i2], writer);
        i2 = i2 - 1;
        goto L13
    }

    private static void writeField(int tag, Object object, Writer writer) throws IOException {
        int fieldNumber = WireFormat.getTagFieldNumber(tag);
        switch(WireFormat.getTagWireType(tag)) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L8;
            case 4: goto L5;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        writer.writeFixed32(fieldNumber, ((Integer) object).intValue());
        return;
    L11:
        writer.writeBytes(fieldNumber, (ByteString) object);
        return;
    L12:
        writer.writeFixed64(fieldNumber, ((Long) object).longValue());
        return;
    L13:
        writer.writeInt64(fieldNumber, ((Long) object).longValue());
        return;
    L5:
        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
    L8:
        if (writer.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L10;
        writer.writeStartGroup(fieldNumber);
        ((UnknownFieldSetLite) object).writeTo(writer);
        writer.writeEndGroup(fieldNumber);
        return;
    L10:
        writer.writeEndGroup(fieldNumber);
        ((UnknownFieldSetLite) object).writeTo(writer);
        writer.writeStartGroup(fieldNumber);
    }

    public int getSerializedSizeAsMessageSet() {
        int size = this.memoizedSerializedSize;
        if (size == (-1)) goto L5;
        return size;
    L5:
        int size2 = 0;
        int i = 0;
    L7:
        if (i >= this.count) goto L9;
        int tag = this.tags[i];
        int fieldNumber = WireFormat.getTagFieldNumber(tag);
        size2 = size2 + CodedOutputStream.computeRawMessageSetExtensionSize(fieldNumber, (ByteString) this.objects[i]);
        i = i + 1;
        goto L7
    L9:
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size == (-1)) goto L5;
        return size;
    L5:
        int size2 = 0;
        int i = 0;
    L7:
        if (i >= this.count) goto L18;
        int tag = this.tags[i];
        int fieldNumber = WireFormat.getTagFieldNumber(tag);
        switch(WireFormat.getTagWireType(tag)) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L12;
            default: goto L11;
        };
    L12:
        int r4 = CodedOutputStream.computeFixed32Size(fieldNumber, ((Integer) this.objects[i]).intValue());
    L17:
        size2 = size2 + r4;
        i = i + 1;
        goto L7
    L13:
        r4 = (CodedOutputStream.computeTagSize(fieldNumber) * 2) + ((UnknownFieldSetLite) this.objects[i]).getSerializedSize();
        goto L17
    L14:
        r4 = CodedOutputStream.computeBytesSize(fieldNumber, (ByteString) this.objects[i]);
        goto L17
    L15:
        r4 = CodedOutputStream.computeFixed64Size(fieldNumber, ((Long) this.objects[i]).longValue());
        goto L17
    L16:
        r4 = CodedOutputStream.computeUInt64Size(fieldNumber, ((Long) this.objects[i]).longValue());
        goto L17
    L11:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L18:
        this.memoizedSerializedSize = size2;
        return size2;
    }

    private static boolean tagsEquals(int[] tags1, int[] tags2, int count) {
        int i = 0;
    L3:
        if (i >= count) goto L9;
        if (tags1[i] != tags2[i]) goto L6;
        i = i + 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    private static boolean objectsEquals(Object[] objects1, Object[] objects2, int count) {
        int i = 0;
    L3:
        if (i >= count) goto L9;
        if (objects1[i].equals(objects2[i]) == false) goto L6;
        i = i + 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L9;
        return false;
    L9:
        if ((obj instanceof UnknownFieldSetLite) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite other = (UnknownFieldSetLite) obj;
        if (this.count == other.count) goto L14;
    L19:
        return false;
    L14:
        if (tagsEquals(this.tags, other.tags, this.count) == false) goto L19;
        if (objectsEquals(this.objects, other.objects, this.count) == false) goto L19;
        return true;
    }

    private static int hashCode(int[] tags, int count) {
        int hashCode = 17;
        int i = 0;
    L3:
        if (i >= count) goto L6;
        hashCode = (hashCode * 31) + tags[i];
        i = i + 1;
        goto L3
    L6:
        return hashCode;
    }

    private static int hashCode(Object[] objects, int count) {
        int hashCode = 17;
        int i = 0;
    L3:
        if (i >= count) goto L6;
        hashCode = (hashCode * 31) + objects[i].hashCode();
        i = i + 1;
        goto L3
    L6:
        return hashCode;
    }

    public int hashCode() {
        int hashCode = (17 * 31) + this.count;
        return (((hashCode * 31) + hashCode(this.tags, this.count)) * 31) + hashCode(this.objects, this.count);
    }

    final void printWithIndent(StringBuilder buffer, int indent) {
        int i = 0;
    L4:
        if (i >= this.count) goto L7;
        int fieldNumber = WireFormat.getTagFieldNumber(this.tags[i]);
        MessageLiteToString.printField(buffer, indent, String.valueOf(fieldNumber), this.objects[i]);
        i = i + 1;
        goto L4
    }

    void storeField(int tag, Object value) {
        checkMutable();
        ensureCapacity(this.count + 1);
        this.tags[this.count] = tag;
        this.objects[this.count] = value;
        this.count++;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= this.tags.length) goto L12;
        int newCapacity = this.count + (this.count / 2);
        if (newCapacity >= minCapacity) goto L8;
        newCapacity = minCapacity;
    L8:
        if (newCapacity >= 8) goto L10;
        newCapacity = 8;
    L10:
        this.tags = Arrays.copyOf(this.tags, newCapacity);
        this.objects = Arrays.copyOf(this.objects, newCapacity);
        return;
    }

    boolean mergeFieldFrom(int tag, CodedInputStream input) throws IOException {
        checkMutable();
        int fieldNumber = WireFormat.getTagFieldNumber(tag);
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
        storeField(tag, Integer.valueOf(input.readFixed32()));
        return true;
    L8:
        return false;
    L10:
        UnknownFieldSetLite subFieldSet = new UnknownFieldSetLite();
        subFieldSet.mergeFrom(input);
        input.checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
        storeField(tag, subFieldSet);
        return true;
    L12:
        storeField(tag, input.readBytes());
        return true;
    L14:
        storeField(tag, Long.valueOf(input.readFixed64()));
        return true;
    L16:
        storeField(tag, Long.valueOf(input.readInt64()));
        return true;
    L5:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    UnknownFieldSetLite mergeVarintField(int fieldNumber, int value) {
        checkMutable();
        if (fieldNumber == 0) goto L7;
        storeField(WireFormat.makeTag(fieldNumber, 0), Long.valueOf(value));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    UnknownFieldSetLite mergeLengthDelimitedField(int fieldNumber, ByteString value) {
        checkMutable();
        if (fieldNumber == 0) goto L7;
        storeField(WireFormat.makeTag(fieldNumber, 2), value);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream input) throws IOException {
    L2:
        int tag = input.readTag();
        if (tag == 0) goto L8;
        if (mergeFieldFrom(tag, input) == true) goto L2;
    L8:
        return this;
    }

    UnknownFieldSetLite mergeFrom(UnknownFieldSetLite other) {
        if (other.equals(getDefaultInstance()) == false) goto L5;
        return this;
    L5:
        checkMutable();
        int newCount = this.count + other.count;
        ensureCapacity(newCount);
        System.arraycopy(other.tags, 0, this.tags, this.count, other.count);
        System.arraycopy(other.objects, 0, this.objects, this.count, other.count);
        this.count = newCount;
        return this;
    }
}
