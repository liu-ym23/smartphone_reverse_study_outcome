package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    ExtensionSchemaLite() {
    }

    @Override // com.google.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite r2) {
        return ZeusTransformUtils.instanceOf((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.aiagent.plugin"), GeneratedMessageLite.ExtendableMessage.class);
    }

    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object r2) {
        return ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.aiagent.plugin")).extensions;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void setExtensions(Object r2, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r3) {
        ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.aiagent.plugin")).extensions = r3;
    }

    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object r2) {
        return ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.aiagent.plugin")).ensureExtensionsAreMutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    void makeImmutable(Object r1) {
        getExtensions(r1).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r8, Reader r9, Object r10, ExtensionRegistryLite r11, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r12, UB r13, UnknownFieldSchema<UT, UB> r14) {
        Reader r7 = (Reader) ZeusTransformUtils.wrapperContextForParams(r9, Reader.class, "com.obric.aiagent.plugin");
        GeneratedMessageLite.GeneratedExtension r15 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r10, GeneratedMessageLite.GeneratedExtension.class, "com.obric.aiagent.plugin");
        int r2 = r15.getNumber();
        if (r15.descriptor.isRepeated() == true) goto L5;
    L25:
        Object r16 = null;
        if (r15.getLiteType() != WireFormat.FieldType.ENUM) goto L33;
        int r17 = r7.readInt32();
        if (r15.descriptor.getEnumType().findValueByNumber(r17) == null) goto L30;
        r16 = Integer.valueOf(r17);
    L73:
        if (r15.isRepeated() == false) goto L75;
        r12.addRepeatedField(r15.descriptor, r16);
    L84:
        return r13;
    L75:
        int r18 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()];
        if (r18 != 17) goto L78;
    L80:
        Object r19 = r12.getField(r15.descriptor);
        if (r19 == null) goto L83;
        r16 = Internal.mergeMessage(r19, r16);
    L83:
        r12.setField(r15.descriptor, r16);
        goto L84
    L78:
        if (r18 == 18) goto L80;
    L30:
        return (UB) SchemaUtil.storeUnknownEnum(r8, r2, r17, r13, r14);
    L33:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()]) {
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
        r16 = r7.readString();
        goto L73
    L56:
        r16 = r7.readBytes();
        goto L73
    L59:
        r16 = Long.valueOf(r7.readSInt64());
        goto L73
    L60:
        r16 = Integer.valueOf(r7.readSInt32());
        goto L73
    L61:
        r16 = Long.valueOf(r7.readSFixed64());
        goto L73
    L62:
        r16 = Integer.valueOf(r7.readSFixed32());
        goto L73
    L63:
        r16 = Integer.valueOf(r7.readUInt32());
        goto L73
    L64:
        r16 = Boolean.valueOf(r7.readBool());
        goto L73
    L65:
        r16 = Integer.valueOf(r7.readFixed32());
        goto L73
    L66:
        r16 = Long.valueOf(r7.readFixed64());
        goto L73
    L67:
        r16 = Integer.valueOf(r7.readInt32());
        goto L73
    L68:
        r16 = Long.valueOf(r7.readUInt64());
        goto L73
    L69:
        r16 = Long.valueOf(r7.readInt64());
        goto L73
    L70:
        r16 = Float.valueOf(r7.readFloat());
        goto L73
    L71:
        r16 = Double.valueOf(r7.readDouble());
        goto L73
    L36:
        if (r15.isRepeated() == true) goto L44;
        Object r20 = r12.getField(r15.descriptor);
        if (ZeusTransformUtils.instanceOf(r20, GeneratedMessageLite.class) == false) goto L44;
        Schema r110 = Protobuf.getInstance().schemaFor(r20);
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r20, GeneratedMessageLite.class, "com.obric.aiagent.plugin")).isMutable() == true) goto L42;
        Object r111 = r110.newInstance();
        r110.mergeFrom(r111, r20);
        r12.setField(r15.descriptor, r111);
        r20 = r111;
    L42:
        r7.mergeMessageField(r20, r110, r11);
        return r13;
    L44:
        r16 = r7.readMessage(r15.getMessageDefaultInstance().getClass(), r11);
        goto L73
    L46:
        if (r15.isRepeated() == true) goto L54;
        Object r21 = r12.getField(r15.descriptor);
        if (ZeusTransformUtils.instanceOf(r21, GeneratedMessageLite.class) == false) goto L54;
        Schema r112 = Protobuf.getInstance().schemaFor(r21);
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r21, GeneratedMessageLite.class, "com.obric.aiagent.plugin")).isMutable() == true) goto L52;
        Object r113 = r112.newInstance();
        r112.mergeFrom(r113, r21);
        r12.setField(r15.descriptor, r113);
        r21 = r113;
    L52:
        r7.mergeGroupField(r21, r112, r11);
        return r13;
    L54:
        r16 = r7.readGroup(r15.getMessageDefaultInstance().getClass(), r11);
        goto L73
    L58:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r15.descriptor.isPacked() == false) goto L25;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()]) {
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
        ArrayList r114 = new ArrayList();
        r7.readEnumList(r114);
        r13 = (UB) SchemaUtil.filterUnknownEnumList(r8, r2, r114, r15.descriptor.getEnumType(), r13, r14);
    L24:
        r12.setField(r15.descriptor, r114);
        goto L84
    L11:
        r114 = new ArrayList();
        r7.readSInt64List(r114);
        goto L24
    L12:
        r114 = new ArrayList();
        r7.readSInt32List(r114);
        goto L24
    L13:
        r114 = new ArrayList();
        r7.readSFixed64List(r114);
        goto L24
    L14:
        r114 = new ArrayList();
        r7.readSFixed32List(r114);
        goto L24
    L15:
        r114 = new ArrayList();
        r7.readUInt32List(r114);
        goto L24
    L16:
        r114 = new ArrayList();
        r7.readBoolList(r114);
        goto L24
    L17:
        r114 = new ArrayList();
        r7.readFixed32List(r114);
        goto L24
    L18:
        r114 = new ArrayList();
        r7.readFixed64List(r114);
        goto L24
    L19:
        r114 = new ArrayList();
        r7.readInt32List(r114);
        goto L24
    L20:
        r114 = new ArrayList();
        r7.readUInt64List(r114);
        goto L24
    L21:
        r114 = new ArrayList();
        r7.readInt64List(r114);
        goto L24
    L22:
        r114 = new ArrayList();
        r7.readFloatList(r114);
        goto L24
    L23:
        r114 = new ArrayList();
        r7.readDoubleList(r114);
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r15.descriptor.getLiteType());
    }

    @Override // com.google.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry<?, ?> r2) {
        return ((GeneratedMessageLite.ExtensionDescriptor) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), GeneratedMessageLite.ExtensionDescriptor.class, "com.obric.aiagent.plugin")).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    void serializeExtension(Writer r5, Map.Entry<?, ?> r6) {
        Writer r4 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.aiagent.plugin");
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.aiagent.plugin");
        GeneratedMessageLite.ExtensionDescriptor r8 = (GeneratedMessageLite.ExtensionDescriptor) ZeusTransformUtils.preCheckCast(r7.getKey(), GeneratedMessageLite.ExtensionDescriptor.class, "com.obric.aiagent.plugin");
        if (r8.isRepeated() == false) goto L34;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.getLiteType().ordinal()]) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L12;
            case 18: goto L7;
            default: goto L94;
        };
    L7:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isEmpty() == true) goto L56;
        SchemaUtil.writeMessageList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, Protobuf.getInstance().schemaFor(r1.get(0).getClass()));
        return;
    L56:
        return;
    L12:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isEmpty() == true) goto L59;
        SchemaUtil.writeGroupList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, Protobuf.getInstance().schemaFor(r2.get(0).getClass()));
        return;
    L59:
        return;
    L17:
        SchemaUtil.writeStringList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4);
        return;
    L18:
        SchemaUtil.writeBytesList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4);
        return;
    L19:
        SchemaUtil.writeInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L20:
        SchemaUtil.writeSInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L21:
        SchemaUtil.writeSInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L22:
        SchemaUtil.writeSFixed64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L23:
        SchemaUtil.writeSFixed32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L24:
        SchemaUtil.writeUInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L25:
        SchemaUtil.writeBoolList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L26:
        SchemaUtil.writeFixed32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L27:
        SchemaUtil.writeFixed64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L28:
        SchemaUtil.writeInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L29:
        SchemaUtil.writeUInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L30:
        SchemaUtil.writeInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L31:
        SchemaUtil.writeFloatList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L32:
        SchemaUtil.writeDoubleList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L94:
        return;
    L34:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.getLiteType().ordinal()]) {
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L47;
            case 8: goto L46;
            case 9: goto L45;
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L42;
            case 13: goto L41;
            case 14: goto L40;
            case 15: goto L39;
            case 16: goto L38;
            case 17: goto L37;
            case 18: goto L36;
            default: goto L95;
        };
    L36:
        r4.writeMessage(r8.getNumber(), r7.getValue(), Protobuf.getInstance().schemaFor(r7.getValue().getClass()));
        return;
    L37:
        r4.writeGroup(r8.getNumber(), r7.getValue(), Protobuf.getInstance().schemaFor(r7.getValue().getClass()));
        return;
    L38:
        r4.writeString(r8.getNumber(), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.aiagent.plugin"));
        return;
    L39:
        r4.writeBytes(r8.getNumber(), (ByteString) ZeusTransformUtils.preCheckCast(r7.getValue(), ByteString.class, "com.obric.aiagent.plugin"));
        return;
    L40:
        r4.writeInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L41:
        r4.writeSInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L42:
        r4.writeSInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L43:
        r4.writeSFixed64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L44:
        r4.writeSFixed32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L45:
        r4.writeUInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L46:
        r4.writeBool(r8.getNumber(), ((Boolean) ZeusTransformUtils.preCheckCast(r7.getValue(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L47:
        r4.writeFixed32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L48:
        r4.writeFixed64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L49:
        r4.writeInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L50:
        r4.writeUInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L51:
        r4.writeInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L52:
        r4.writeFloat(r8.getNumber(), ((Float) ZeusTransformUtils.preCheckCast(r7.getValue(), Float.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L53:
        r4.writeDouble(r8.getNumber(), ((Double) ZeusTransformUtils.preCheckCast(r7.getValue(), Double.class, "com.obric.aiagent.plugin")).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite r2, MessageLite r3, int r4) {
        return r2.findLiteExtensionByNumber((MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader r2, Object r3, ExtensionRegistryLite r4, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r5) {
        Reader r1 = (Reader) ZeusTransformUtils.wrapperContextForParams(r2, Reader.class, "com.obric.aiagent.plugin");
        GeneratedMessageLite.GeneratedExtension r6 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.GeneratedExtension.class, "com.obric.aiagent.plugin");
        Object r7 = r1.readMessage(r6.getMessageDefaultInstance().getClass(), r4);
        r5.setField(r6.descriptor, r7);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString r2, Object r3, ExtensionRegistryLite r4, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r5) {
        GeneratedMessageLite.GeneratedExtension r1 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.GeneratedExtension.class, "com.obric.aiagent.plugin");
        MessageLite.Builder r6 = r1.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream r7 = r2.newCodedInput();
        r6.mergeFrom(r7, r4);
        r5.setField(r1.descriptor, r6.buildPartial());
        r7.checkLastTagWas(0);
    }
}
