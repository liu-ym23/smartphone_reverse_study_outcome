package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(defaultInstance);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        return new MessageSetSchema(unknownFieldSchema, extensionSchema, defaultInstance);
    }

    @Override // com.bytedance.location.protobuf.Schema
    public T newInstance() {
        if ((this.defaultInstance instanceof GeneratedMessageLite) == false) goto L7;
        return (T) ((GeneratedMessageLite) this.defaultInstance).newMutableInstance();
    L7:
        return (T) this.defaultInstance.newBuilderForType().buildPartial();
    }

    @Override // com.bytedance.location.protobuf.Schema
    public boolean equals(T message, T other) {
        Object messageUnknown = this.unknownFieldSchema.getFromMessage(message);
        Object otherUnknown = this.unknownFieldSchema.getFromMessage(other);
        if (messageUnknown.equals(otherUnknown) == true) goto L7;
        return false;
    L7:
        if (this.hasExtensions == true) goto L9;
        return true;
    L9:
        return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
    }

    @Override // com.bytedance.location.protobuf.Schema
    public int hashCode(T message) {
        int hashCode = this.unknownFieldSchema.getFromMessage(message).hashCode();
        if (this.hasExtensions == true) goto L5;
        return hashCode;
    L5:
        return (hashCode * 53) + this.extensionSchema.getExtensions(message).hashCode();
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void mergeFrom(T message, T other) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions == false) goto L6;
        SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        return;
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        Iterator<?> iterator = this.extensionSchema.getExtensions(message).iterator();
    L4:
        if (iterator.hasNext() == false) goto L18;
        Map.Entry<?, ?> extension = (Map.Entry) iterator.next();
        FieldSet.FieldDescriptorLite<?> fd = (FieldSet.FieldDescriptorLite) extension.getKey();
        if (fd.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L17;
        if (fd.isRepeated() == true) goto L17;
        if (fd.isPacked() == true) goto L17;
        if ((extension instanceof LazyField.LazyEntry) == true) goto L13;
        writer.writeMessageSetItem(fd.getNumber(), extension.getValue());
        goto L4
    L13:
        writer.writeMessageSetItem(fd.getNumber(), ((LazyField.LazyEntry) extension).getField().toByteString());
    L17:
        throw new IllegalStateException("Found invalid MessageSet item.");
    L18:
        writeUnknownFieldsHelper(this.unknownFieldSchema, message, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, T message, Writer writer) throws IOException {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(message), writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.location.protobuf.Schema
    public void mergeFrom(T r18, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        UnknownFieldSetLite unknownFields = ((GeneratedMessageLite) r18).unknownFields;
        if (unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L5;
        UnknownFieldSetLite unknownFields2 = UnknownFieldSetLite.newInstance();
        ((GeneratedMessageLite) r18).unknownFields = unknownFields2;
        UnknownFieldSetLite unknownFields3 = unknownFields2;
    L6:
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = ((GeneratedMessageLite.ExtendableMessage) r18).ensureExtensionsAreMutable();
        GeneratedMessageLite.GeneratedExtension<?, ?> extension = null;
        int position2 = position;
    L7:
        if (position2 >= limit) goto L40;
        GeneratedMessageLite.GeneratedExtension<?, ?> extension2 = extension;
        int position3 = ArrayDecoders.decodeVarint32(data, position2, registers);
        int startTag = registers.int1;
        if (startTag != WireFormat.MESSAGE_SET_ITEM_TAG) goto L11;
        int typeId = 0;
        ByteString rawBytes = null;
    L18:
        if (position3 >= limit) goto L35;
        int position4 = ArrayDecoders.decodeVarint32(data, position3, registers);
        int tag = registers.int1;
        int number = WireFormat.getTagFieldNumber(tag);
        int wireType = WireFormat.getTagWireType(tag);
        switch(number) {
            case 2: goto L28;
            case 3: goto L22;
            default: goto L32;
        };
    L32:
        if (tag == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L33;
        position3 = ArrayDecoders.skipField(tag, data, position4, limit, registers);
        startTag = startTag;
        goto L18
    L33:
        position2 = position4;
    L36:
        if (rawBytes == null) goto L38;
        unknownFields3.storeField(WireFormat.makeTag(typeId, 2), rawBytes);
    L38:
        extension = extension2;
        goto L7
    L28:
        if (wireType != 0) goto L32;
        position3 = ArrayDecoders.decodeVarint32(data, position4, registers);
        typeId = registers.int1;
        extension2 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, typeId);
        startTag = startTag;
        goto L18
    L22:
        if (extension2 == null) goto L25;
        position3 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(extension2.getMessageDefaultInstance().getClass()), data, position4, limit, registers);
        extensions.setField(extension2.descriptor, registers.object1);
        goto L18
    L25:
        if (wireType != 2) goto L32;
        position3 = ArrayDecoders.decodeBytes(data, position4, registers);
        rawBytes = (ByteString) registers.object1;
        goto L18
    L35:
        position2 = position3;
        goto L36
    L11:
        if (WireFormat.getTagWireType(startTag) == 2) goto L12;
        position2 = ArrayDecoders.skipField(startTag, data, position3, limit, registers);
        extension = extension2;
        goto L7
    L12:
        GeneratedMessageLite.GeneratedExtension<?, ?> extension3 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(startTag));
        if (extension3 != null) goto L14;
        position2 = ArrayDecoders.decodeUnknownField(startTag, data, position3, limit, unknownFields3, registers);
        extension = extension3;
        goto L7
    L14:
        int position5 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(extension3.getMessageDefaultInstance().getClass()), data, position3, limit, registers);
        extensions.setField(extension3.descriptor, registers.object1);
        position2 = position5;
        extension = extension3;
        goto L7
    L40:
        if (position2 != limit) goto L43;
        return;
    L43:
        throw InvalidProtocolBufferException.parseFailure();
    L5:
        unknownFields3 = unknownFields;
        goto L6
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        UB unknownFields = unknownFieldSchema.getBuilderFromMessage(message);
        Object r5 = extensionSchema.getMutableExtensions(message);
    L22:
        int number = reader.getFieldNumber();     // Catch: Throwable -> L16
        if (number == Integer.MAX_VALUE) goto L6;
        UnknownFieldSchema<UT, UB> unknownFieldSchema2 = unknownFieldSchema;
        ExtensionSchema<ET> extensionSchema2 = extensionSchema;
        Reader reader2 = reader;
        ExtensionRegistryLite extensionRegistry2 = extensionRegistry;
        if (parseMessageSetItemOrUnknownField(reader2, extensionRegistry2, extensionSchema2, r5, unknownFieldSchema2, unknownFields) == false) goto L12;
        reader = reader2;
        extensionRegistry = extensionRegistry2;
        extensionSchema = extensionSchema2;
        unknownFieldSchema = unknownFieldSchema2;
        goto L22
    L12:
        unknownFieldSchema2.setBuilderToMessage(message, unknownFields);
        return;
    L14:
        th = move-exception;
        Throwable r9 = th;
    L18:
        unknownFieldSchema2.setBuilderToMessage(message, unknownFields);
        throw r9;
    L6:
        unknownFieldSchema.setBuilderToMessage(message, unknownFields);
        return;
    L16:
        th = move-exception;
        unknownFieldSchema2 = unknownFieldSchema;
        r9 = th;
        goto L18
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void makeImmutable(T message) {
        this.unknownFieldSchema.makeImmutable(message);
        this.extensionSchema.makeImmutable(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistry, ExtensionSchema<ET> extensionSchema, FieldSet<ET> r12, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB unknownFields) throws IOException {
        int startTag = reader.getTag();
        if (startTag != WireFormat.MESSAGE_SET_ITEM_TAG) goto L5;
        int typeId = 0;
        ByteString rawBytes = null;
        Object extension = null;
    L15:
        int number = reader.getFieldNumber();
        if (number == Integer.MAX_VALUE) goto L28;
        int tag = reader.getTag();
        if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L20;
        if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L23;
        if (reader.skipField() == true) goto L15;
    L23:
        if (extension != null) goto L24;
        rawBytes = reader.readBytes();
        goto L15
    L24:
        extensionSchema.parseLengthPrefixedMessageSetItem(reader, extension, extensionRegistry, r12);
        goto L15
    L20:
        typeId = reader.readUInt32();
        extension = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, typeId);
    L28:
        int number2 = reader.getTag();
        if (number2 != WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L36;
        if (rawBytes == null) goto L34;
        if (extension == null) goto L33;
        extensionSchema.parseMessageSetItem(rawBytes, extension, extensionRegistry, r12);
        goto L34
    L33:
        unknownFieldSchema.addLengthDelimited(unknownFields, typeId, rawBytes);
    L34:
        return true;
    L36:
        throw InvalidProtocolBufferException.invalidEndTag();
    L5:
        if (WireFormat.getTagWireType(startTag) != 2) goto L13;
        Object extension2 = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(startTag));
        if (extension2 == null) goto L11;
        extensionSchema.parseLengthPrefixedMessageSetItem(reader, extension2, extensionRegistry, r12);
        return true;
    L11:
        return unknownFieldSchema.mergeOneFieldFrom(unknownFields, reader);
    L13:
        return reader.skipField();
    }

    @Override // com.bytedance.location.protobuf.Schema
    public final boolean isInitialized(T message) {
        return this.extensionSchema.getExtensions(message).isInitialized();
    }

    @Override // com.bytedance.location.protobuf.Schema
    public int getSerializedSize(T message) {
        int size = 0 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        if (this.hasExtensions == true) goto L5;
        return size;
    L5:
        return size + this.extensionSchema.getExtensions(message).getMessageSetSerializedSize();
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        UT unknowns = schema.getFromMessage(message);
        return schema.getSerializedSizeAsMessageSet(unknowns);
    }
}
