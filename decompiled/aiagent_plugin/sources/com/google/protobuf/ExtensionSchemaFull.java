package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    private static final long EXTENSION_FIELD_OFFSET = 0;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaFull$1, reason: invalid class name */
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

    ExtensionSchemaFull() {
    }

    static {
        EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();
    }

    private static <T> long getExtensionsFieldOffset() {
        return UnsafeUtil.objectFieldOffset(GeneratedMessage.ExtendableMessage.class.getDeclaredField("extensions"));
    L4:
        th = move-exception;
        throw new IllegalStateException("Unable to lookup extension field offset", th);
    }

    @Override // com.google.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite r2) {
        return ZeusTransformUtils.instanceOf((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.aiagent.plugin"), GeneratedMessage.ExtendableMessage.class);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object r3) {
        return (FieldSet) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r3, EXTENSION_FIELD_OFFSET), FieldSet.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.ExtensionSchema
    void setExtensions(Object r3, FieldSet<Descriptors.FieldDescriptor> r4) {
        UnsafeUtil.putObject(r3, EXTENSION_FIELD_OFFSET, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object r3) {
        FieldSet<Descriptors.FieldDescriptor> r0 = getExtensions(r3);
        if (r0.isImmutable() == false) goto L6;
        FieldSet r1 = r0.clone();
        setExtensions(r3, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void makeImmutable(Object r1) {
        getExtensions(r1).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r4, Reader r5, Object r6, ExtensionRegistryLite r7, FieldSet<Descriptors.FieldDescriptor> r8, UB r9, UnknownFieldSchema<UT, UB> r10) {
        Reader r3 = (Reader) ZeusTransformUtils.wrapperContextForParams(r5, Reader.class, "com.obric.aiagent.plugin");
        ExtensionRegistry.ExtensionInfo r11 = (ExtensionRegistry.ExtensionInfo) ZeusTransformUtils.preCheckCast(r6, ExtensionRegistry.ExtensionInfo.class, "com.obric.aiagent.plugin");
        int r12 = r11.descriptor.getNumber();
        if (r11.descriptor.isRepeated() == true) goto L5;
    L32:
        Object r0 = null;
        if (r11.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L39;
        int r13 = r3.readInt32();
        r0 = r11.descriptor.getEnumType().findValueByNumber(r13);
        if (r0 != null) goto L61;
        return (UB) SchemaUtil.storeUnknownEnum(r4, r12, r13, r9, r10);
    L61:
        if (r11.descriptor.isRepeated() == false) goto L63;
        r8.addRepeatedField(r11.descriptor, r0);
    L72:
        return r9;
    L63:
        int r14 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.descriptor.getLiteType().ordinal()];
        if (r14 != 17) goto L66;
    L68:
        Object r15 = r8.getField(r11.descriptor);
        if (r15 == null) goto L71;
        r0 = Internal.mergeMessage(r15, r0);
    L71:
        r8.setField(r11.descriptor, r0);
        goto L72
    L66:
        if (r14 == 18) goto L68;
    L39:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.descriptor.getLiteType().ordinal()]) {
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            case 7: goto L53;
            case 8: goto L52;
            case 9: goto L51;
            case 10: goto L50;
            case 11: goto L49;
            case 12: goto L48;
            case 13: goto L47;
            case 14: goto L46;
            case 15: goto L44;
            case 16: goto L43;
            case 17: goto L42;
            case 18: goto L41;
            default: goto L61;
        };
    L41:
        r0 = r3.readMessage(r11.defaultInstance.getClass(), r7);
        goto L61
    L42:
        r0 = r3.readGroup(r11.defaultInstance.getClass(), r7);
        goto L61
    L43:
        r0 = r3.readString();
        goto L61
    L44:
        r0 = r3.readBytes();
        goto L61
    L47:
        r0 = Long.valueOf(r3.readSInt64());
        goto L61
    L48:
        r0 = Integer.valueOf(r3.readSInt32());
        goto L61
    L49:
        r0 = Long.valueOf(r3.readSFixed64());
        goto L61
    L50:
        r0 = Integer.valueOf(r3.readSFixed32());
        goto L61
    L51:
        r0 = Integer.valueOf(r3.readUInt32());
        goto L61
    L52:
        r0 = Boolean.valueOf(r3.readBool());
        goto L61
    L53:
        r0 = Integer.valueOf(r3.readFixed32());
        goto L61
    L54:
        r0 = Long.valueOf(r3.readFixed64());
        goto L61
    L55:
        r0 = Integer.valueOf(r3.readInt32());
        goto L61
    L56:
        r0 = Long.valueOf(r3.readUInt64());
        goto L61
    L57:
        r0 = Long.valueOf(r3.readInt64());
        goto L61
    L58:
        r0 = Float.valueOf(r3.readFloat());
        goto L61
    L59:
        r0 = Double.valueOf(r3.readDouble());
        goto L61
    L46:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r11.descriptor.isPacked() == false) goto L32;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.descriptor.getLiteType().ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ArrayList r16 = new ArrayList();
        r3.readEnumList(r16);
        ArrayList r17 = new ArrayList();
        Iterator<Integer> r18 = r16.iterator();
    L12:
        if (r18.hasNext() == false) goto L31;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r18.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        Descriptors.EnumValueDescriptor r2 = r11.descriptor.getEnumType().findValueByNumber(r1);
        if (r2 != null) goto L15;
        r9 = (UB) SchemaUtil.storeUnknownEnum(r4, r12, r1, r9, r10);
        goto L12
    L15:
        r17.add(r2);
    L31:
        r8.setField(r11.descriptor, r17);
        goto L72
    L17:
        ArrayList r19 = new ArrayList();
        r3.readSInt64List(r19);
    L30:
        r17 = r19;
        goto L31
    L18:
        r19 = new ArrayList();
        r3.readSInt32List(r19);
        goto L30
    L19:
        r19 = new ArrayList();
        r3.readSFixed64List(r19);
        goto L30
    L20:
        r19 = new ArrayList();
        r3.readSFixed32List(r19);
        goto L30
    L21:
        r19 = new ArrayList();
        r3.readUInt32List(r19);
        goto L30
    L22:
        r19 = new ArrayList();
        r3.readBoolList(r19);
        goto L30
    L23:
        r19 = new ArrayList();
        r3.readFixed32List(r19);
        goto L30
    L24:
        r19 = new ArrayList();
        r3.readFixed64List(r19);
        goto L30
    L25:
        r19 = new ArrayList();
        r3.readInt32List(r19);
        goto L30
    L26:
        r19 = new ArrayList();
        r3.readUInt64List(r19);
        goto L30
    L27:
        r19 = new ArrayList();
        r3.readInt64List(r19);
        goto L30
    L28:
        r19 = new ArrayList();
        r3.readFloatList(r19);
        goto L30
    L29:
        r19 = new ArrayList();
        r3.readDoubleList(r19);
        goto L30
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r11.descriptor.getLiteType());
    }

    @Override // com.google.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry<?, ?> r2) {
        return ((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin")).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    void serializeExtension(Writer r5, Map.Entry<?, ?> r6) {
        Writer r4 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.aiagent.plugin");
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.aiagent.plugin");
        Descriptors.FieldDescriptor r8 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r7.getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
        if (r8.isRepeated() == false) goto L30;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.getLiteType().ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L87;
        };
    L7:
        SchemaUtil.writeMessageList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4);
        return;
    L8:
        SchemaUtil.writeGroupList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4);
        return;
    L9:
        SchemaUtil.writeStringList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4);
        return;
    L10:
        SchemaUtil.writeBytesList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4);
        return;
    L11:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin");
        ArrayList r1 = new ArrayList();
        Iterator r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        r1.add(Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r10.next(), Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getNumber()));
        goto L13
    L15:
        SchemaUtil.writeInt32List(r8.getNumber(), r1, r4, r8.isPacked());
        return;
    L16:
        SchemaUtil.writeSInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L17:
        SchemaUtil.writeSInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L18:
        SchemaUtil.writeSFixed64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L19:
        SchemaUtil.writeSFixed32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L20:
        SchemaUtil.writeUInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L21:
        SchemaUtil.writeBoolList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L22:
        SchemaUtil.writeFixed32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L23:
        SchemaUtil.writeFixed64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L24:
        SchemaUtil.writeInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L25:
        SchemaUtil.writeUInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L26:
        SchemaUtil.writeInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L27:
        SchemaUtil.writeFloatList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L28:
        SchemaUtil.writeDoubleList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin"), r4, r8.isPacked());
        return;
    L87:
        return;
    L30:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.getLiteType().ordinal()]) {
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            case 4: goto L46;
            case 5: goto L45;
            case 6: goto L44;
            case 7: goto L43;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L40;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L33;
            case 18: goto L32;
            default: goto L88;
        };
    L32:
        r4.writeMessage(r8.getNumber(), r7.getValue());
        return;
    L33:
        r4.writeGroup(r8.getNumber(), r7.getValue());
        return;
    L34:
        r4.writeString(r8.getNumber(), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.aiagent.plugin"));
        return;
    L35:
        r4.writeBytes(r8.getNumber(), (ByteString) ZeusTransformUtils.preCheckCast(r7.getValue(), ByteString.class, "com.obric.aiagent.plugin"));
        return;
    L36:
        r4.writeInt32(r8.getNumber(), ((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r7.getValue(), Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getNumber());
        return;
    L37:
        r4.writeSInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L38:
        r4.writeSInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L39:
        r4.writeSFixed64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L40:
        r4.writeSFixed32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L41:
        r4.writeUInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L42:
        r4.writeBool(r8.getNumber(), ((Boolean) ZeusTransformUtils.preCheckCast(r7.getValue(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L43:
        r4.writeFixed32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L44:
        r4.writeFixed64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L45:
        r4.writeInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L46:
        r4.writeUInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L47:
        r4.writeInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L48:
        r4.writeFloat(r8.getNumber(), ((Float) ZeusTransformUtils.preCheckCast(r7.getValue(), Float.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L49:
        r4.writeDouble(r8.getNumber(), ((Double) ZeusTransformUtils.preCheckCast(r7.getValue(), Double.class, "com.obric.aiagent.plugin")).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite r2, MessageLite r3, int r4) {
        MessageLite r1 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.aiagent.plugin");
        return ((ExtensionRegistry) ZeusTransformUtils.preCheckCast(r2, ExtensionRegistry.class, "com.obric.aiagent.plugin")).findImmutableExtensionByNumber(((Message) ZeusTransformUtils.preCheckCast(r1, Message.class, "com.obric.aiagent.plugin")).getDescriptorForType(), r4);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader r2, Object r3, ExtensionRegistryLite r4, FieldSet<Descriptors.FieldDescriptor> r5) {
        Reader r1 = (Reader) ZeusTransformUtils.wrapperContextForParams(r2, Reader.class, "com.obric.aiagent.plugin");
        ExtensionRegistry.ExtensionInfo r6 = (ExtensionRegistry.ExtensionInfo) ZeusTransformUtils.preCheckCast(r3, ExtensionRegistry.ExtensionInfo.class, "com.obric.aiagent.plugin");
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L5;
        Object r7 = r1.readMessage(r6.defaultInstance.getClass(), r4);
        r5.setField(r6.descriptor, r7);
        return;
    L5:
        r5.setField(r6.descriptor, new LazyField(r6.defaultInstance, r4, r1.readBytes()));
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString r2, Object r3, ExtensionRegistryLite r4, FieldSet<Descriptors.FieldDescriptor> r5) {
        ExtensionRegistry.ExtensionInfo r1 = (ExtensionRegistry.ExtensionInfo) ZeusTransformUtils.preCheckCast(r3, ExtensionRegistry.ExtensionInfo.class, "com.obric.aiagent.plugin");
        Message r6 = r1.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L9;
        BinaryReader r7 = BinaryReader.newInstance(ByteBuffer.wrap(r2.toByteArray()), true);
        Protobuf.getInstance().mergeFrom(r6, r7, r4);
        r5.setField(r1.descriptor, r6);
        if (r7.getFieldNumber() != Integer.MAX_VALUE) goto L8;
        return;
    L8:
        throw InvalidProtocolBufferException.invalidEndTag();
    L9:
        r5.setField(r1.descriptor, new LazyField(r1.defaultInstance, r4, r2));
    }
}
