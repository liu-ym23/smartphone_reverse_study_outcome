package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L90:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L78:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L92:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L82:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L84:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L86:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L76:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L88:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
        L80:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L56
            return;
        }
    }

    ExtensionSchemaLite() {
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite prototype) {
        return prototype instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object message) {
        return ((GeneratedMessageLite.ExtendableMessage) message).extensions;
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    void setExtensions(Object message, FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) {
        ((GeneratedMessageLite.ExtendableMessage) message).extensions = extensions;
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object message) {
        return ((GeneratedMessageLite.ExtendableMessage) message).ensureExtensionsAreMutable();
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    void makeImmutable(Object message) {
        getExtensions(message).makeImmutable();
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r9, Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r13, UB r14, UnknownFieldSchema<UT, UB> r15) throws IOException {
        GeneratedMessageLite.GeneratedExtension r0 = (GeneratedMessageLite.GeneratedExtension) r11;
        int r2 = r0.getNumber();
        if (r0.descriptor.isRepeated() == true) goto L5;
    L25:
        Object r16 = null;
        if (r0.getLiteType() != WireFormat.FieldType.ENUM) goto L33;
        int r17 = r10.readInt32();
        if (r0.descriptor.getEnumType().findValueByNumber(r17) == null) goto L30;
        r16 = Integer.valueOf(r17);
    L73:
        if (r0.isRepeated() == false) goto L76;
        r13.addRepeatedField(r0.descriptor, r16);
    L83:
        return r14;
    L76:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r0.getLiteType().ordinal()]) {
            case 17: goto L78;
            case 18: goto L78;
            default: goto L81;
        };
    L78:
        Object r18 = r13.getField(r0.descriptor);
        if (r18 == null) goto L81;
        r16 = Internal.mergeMessage(r18, r16);
    L81:
        r13.setField(r0.descriptor, r16);
        goto L83
    L30:
        return (UB) SchemaUtil.storeUnknownEnum(r9, r2, r17, r14, r15);
    L33:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r0.getLiteType().ordinal()]) {
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L67;
            case 6: goto L66;
            case 7: goto L65;
            case 8: goto L64;
            case 9: goto L63;
            case 10: goto L62;
            case 11: goto L61;
            case 12: goto L60;
            case 13: goto L59;
            case 14: goto L58;
            case 15: goto L56;
            case 16: goto L55;
            case 17: goto L46;
            case 18: goto L36;
            default: goto L73;
        };
    L55:
        r16 = r10.readString();
        goto L73
    L56:
        r16 = r10.readBytes();
        goto L73
    L59:
        r16 = Long.valueOf(r10.readSInt64());
        goto L73
    L60:
        r16 = Integer.valueOf(r10.readSInt32());
        goto L73
    L61:
        r16 = Long.valueOf(r10.readSFixed64());
        goto L73
    L62:
        r16 = Integer.valueOf(r10.readSFixed32());
        goto L73
    L63:
        r16 = Integer.valueOf(r10.readUInt32());
        goto L73
    L64:
        r16 = Boolean.valueOf(r10.readBool());
        goto L73
    L65:
        r16 = Integer.valueOf(r10.readFixed32());
        goto L73
    L66:
        r16 = Long.valueOf(r10.readFixed64());
        goto L73
    L67:
        r16 = Integer.valueOf(r10.readInt32());
        goto L73
    L68:
        r16 = Long.valueOf(r10.readUInt64());
        goto L73
    L69:
        r16 = Long.valueOf(r10.readInt64());
        goto L73
    L70:
        r16 = Float.valueOf(r10.readFloat());
        goto L73
    L71:
        r16 = Double.valueOf(r10.readDouble());
        goto L73
    L36:
        if (r0.isRepeated() == true) goto L44;
        Object r19 = r13.getField(r0.descriptor);
        if ((r19 instanceof GeneratedMessageLite) == false) goto L44;
        Schema r110 = Protobuf.getInstance().schemaFor(r19);
        if (((GeneratedMessageLite) r19).isMutable() == true) goto L42;
        Object r3 = r110.newInstance();
        r110.mergeFrom(r3, r19);
        r13.setField(r0.descriptor, r3);
        r19 = r3;
    L42:
        r10.mergeMessageField(r19, r110, r12);
        return r14;
    L44:
        r16 = r10.readMessage(r0.getMessageDefaultInstance().getClass(), r12);
        goto L73
    L46:
        if (r0.isRepeated() == true) goto L54;
        Object r111 = r13.getField(r0.descriptor);
        if ((r111 instanceof GeneratedMessageLite) == false) goto L54;
        Schema r112 = Protobuf.getInstance().schemaFor(r111);
        if (((GeneratedMessageLite) r111).isMutable() == true) goto L52;
        Object r4 = r112.newInstance();
        r112.mergeFrom(r4, r111);
        r13.setField(r0.descriptor, r4);
        r111 = r4;
    L52:
        r10.mergeGroupField(r111, r112, r12);
        return r14;
    L54:
        r16 = r10.readGroup(r0.getMessageDefaultInstance().getClass(), r12);
        goto L73
    L58:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r0.descriptor.isPacked() == false) goto L25;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r0.getLiteType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ArrayList r5 = new ArrayList();
        r10.readEnumList(r5);
        UB r113 = (UB) SchemaUtil.filterUnknownEnumList(r9, r2, r5, r0.descriptor.getEnumType(), r14, r15);
        ArrayList r20 = r5;
    L24:
        r13.setField(r0.descriptor, r20);
        return r113;
    L11:
        r20 = new ArrayList();
        r10.readSInt64List(r20);
        r113 = r14;
        goto L24
    L12:
        r20 = new ArrayList();
        r10.readSInt32List(r20);
        r113 = r14;
        goto L24
    L13:
        r20 = new ArrayList();
        r10.readSFixed64List(r20);
        r113 = r14;
        goto L24
    L14:
        r20 = new ArrayList();
        r10.readSFixed32List(r20);
        r113 = r14;
        goto L24
    L15:
        r20 = new ArrayList();
        r10.readUInt32List(r20);
        r113 = r14;
        goto L24
    L16:
        r20 = new ArrayList();
        r10.readBoolList(r20);
        r113 = r14;
        goto L24
    L17:
        r20 = new ArrayList();
        r10.readFixed32List(r20);
        r113 = r14;
        goto L24
    L18:
        r20 = new ArrayList();
        r10.readFixed64List(r20);
        r113 = r14;
        goto L24
    L19:
        r20 = new ArrayList();
        r10.readInt32List(r20);
        r113 = r14;
        goto L24
    L20:
        r20 = new ArrayList();
        r10.readUInt64List(r20);
        r113 = r14;
        goto L24
    L21:
        r20 = new ArrayList();
        r10.readInt64List(r20);
        r113 = r14;
        goto L24
    L22:
        r20 = new ArrayList();
        r10.readFloatList(r20);
        r113 = r14;
        goto L24
    L23:
        r20 = new ArrayList();
        r10.readDoubleList(r20);
        r113 = r14;
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r0.descriptor.getLiteType());
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry<?, ?> extension) {
        GeneratedMessageLite.ExtensionDescriptor descriptor = (GeneratedMessageLite.ExtensionDescriptor) extension.getKey();
        return descriptor.getNumber();
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    void serializeExtension(Writer writer, Map.Entry<?, ?> extension) throws IOException {
        GeneratedMessageLite.ExtensionDescriptor descriptor = (GeneratedMessageLite.ExtensionDescriptor) extension.getKey();
        if (descriptor.isRepeated() == false) goto L36;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[descriptor.getLiteType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L24;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L12;
            case 18: goto L7;
            default: goto L93;
        };
    L7:
        List<?> data = (List) extension.getValue();
        if (data != null) goto L10;
        return;
    L10:
        if (data.isEmpty() == true) goto L76;
        SchemaUtil.writeMessageList(descriptor.getNumber(), (List) extension.getValue(), writer, Protobuf.getInstance().schemaFor(data.get(0).getClass()));
        return;
    L76:
        return;
    L12:
        List<?> data2 = (List) extension.getValue();
        if (data2 != null) goto L15;
        return;
    L15:
        if (data2.isEmpty() == true) goto L96;
        SchemaUtil.writeGroupList(descriptor.getNumber(), (List) extension.getValue(), writer, Protobuf.getInstance().schemaFor(data2.get(0).getClass()));
        return;
    L96:
        return;
    L18:
        SchemaUtil.writeStringList(descriptor.getNumber(), (List) extension.getValue(), writer);
        return;
    L19:
        SchemaUtil.writeBytesList(descriptor.getNumber(), (List) extension.getValue(), writer);
        return;
    L20:
        SchemaUtil.writeInt32List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L21:
        SchemaUtil.writeSInt64List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L22:
        SchemaUtil.writeSInt32List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L23:
        SchemaUtil.writeSFixed64List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L24:
        SchemaUtil.writeSFixed32List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L25:
        SchemaUtil.writeUInt32List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L26:
        SchemaUtil.writeBoolList(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L27:
        SchemaUtil.writeFixed32List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L28:
        SchemaUtil.writeFixed64List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L29:
        SchemaUtil.writeInt32List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L30:
        SchemaUtil.writeUInt64List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L31:
        SchemaUtil.writeInt64List(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L32:
        SchemaUtil.writeFloatList(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L33:
        SchemaUtil.writeDoubleList(descriptor.getNumber(), (List) extension.getValue(), writer, descriptor.isPacked());
        return;
    L93:
        return;
    L36:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[descriptor.getLiteType().ordinal()]) {
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            case 10: goto L46;
            case 11: goto L45;
            case 12: goto L44;
            case 13: goto L43;
            case 14: goto L42;
            case 15: goto L41;
            case 16: goto L40;
            case 17: goto L39;
            case 18: goto L38;
            default: goto L97;
        };
    L38:
        writer.writeMessage(descriptor.getNumber(), extension.getValue(), Protobuf.getInstance().schemaFor(extension.getValue().getClass()));
        return;
    L39:
        writer.writeGroup(descriptor.getNumber(), extension.getValue(), Protobuf.getInstance().schemaFor(extension.getValue().getClass()));
        return;
    L40:
        writer.writeString(descriptor.getNumber(), (String) extension.getValue());
        return;
    L41:
        writer.writeBytes(descriptor.getNumber(), (ByteString) extension.getValue());
        return;
    L42:
        writer.writeInt32(descriptor.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L43:
        writer.writeSInt64(descriptor.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L44:
        writer.writeSInt32(descriptor.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L45:
        writer.writeSFixed64(descriptor.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L46:
        writer.writeSFixed32(descriptor.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L47:
        writer.writeUInt32(descriptor.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L48:
        writer.writeBool(descriptor.getNumber(), ((Boolean) extension.getValue()).booleanValue());
        return;
    L49:
        writer.writeFixed32(descriptor.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L50:
        writer.writeFixed64(descriptor.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L51:
        writer.writeInt32(descriptor.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L52:
        writer.writeUInt64(descriptor.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L53:
        writer.writeInt64(descriptor.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L54:
        writer.writeFloat(descriptor.getNumber(), ((Float) extension.getValue()).floatValue());
        return;
    L55:
        writer.writeDouble(descriptor.getNumber(), ((Double) extension.getValue()).doubleValue());
        return;
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite extensionRegistry, MessageLite defaultInstance, int number) {
        return extensionRegistry.findLiteExtensionByNumber(defaultInstance, number);
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader reader, Object extensionObject, ExtensionRegistryLite extensionRegistry, FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) throws IOException {
        GeneratedMessageLite.GeneratedExtension<?, ?> extension = (GeneratedMessageLite.GeneratedExtension) extensionObject;
        Object value = reader.readMessage(extension.getMessageDefaultInstance().getClass(), extensionRegistry);
        extensions.setField(extension.descriptor, value);
    }

    @Override // com.bytedance.location.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString data, Object extensionObject, ExtensionRegistryLite extensionRegistry, FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) throws IOException {
        GeneratedMessageLite.GeneratedExtension<?, ?> extension = (GeneratedMessageLite.GeneratedExtension) extensionObject;
        MessageLite.Builder builder = extension.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream input = data.newCodedInput();
        builder.mergeFrom(input, extensionRegistry);
        extensions.setField(extension.descriptor, builder.buildPartial());
        input.checkLastTagWas(0);
    }
}
