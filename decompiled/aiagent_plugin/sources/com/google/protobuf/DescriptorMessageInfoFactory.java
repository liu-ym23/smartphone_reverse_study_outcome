package com.google.protobuf;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class DescriptorMessageInfoFactory implements MessageInfoFactory {
    private static final String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";
    private static final DescriptorMessageInfoFactory instance = null;
    private static IsInitializedCheckAnalyzer isInitializedCheckAnalyzer;
    private static final Set<String> specialFieldNames = null;

    /* JADX INFO: renamed from: com.google.protobuf.DescriptorMessageInfoFactory$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        static {
            int[] r0 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0;
            r0[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L90:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L106:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L114:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
        L118:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L47
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L48
        L80:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L49
        L98:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L50
        L100:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L51
        L120:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L52
        L124:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L53
        L82:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L54
        L88:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L55
        L104:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L56
        L110:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L57
        L128:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L58
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 17;     // Catch: NoSuchFieldError -> L59
        L92:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 18;     // Catch: NoSuchFieldError -> L60
        L29:
            int[] r9 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = r9;
            r9[JavaType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L61
        L112:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.BYTE_STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L62
        L116:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L63
        L126:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L64
        L84:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.ENUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L65
        L94:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.INT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L66
        L96:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L67
        L102:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L68
        L122:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L69
        L39:
            int[] r2 = new int[DescriptorProtos.Edition.values().length];
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = r2;
            r2[DescriptorProtos.Edition.EDITION_PROTO2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L70
        L78:
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition[DescriptorProtos.Edition.EDITION_PROTO3.ordinal()] = 2;     // Catch: NoSuchFieldError -> L71
            return;
        }
    }

    static class IsInitializedCheckAnalyzer {
        private int index;
        private final Map<Descriptors.Descriptor, Node> nodeCache;
        private final Map<Descriptors.Descriptor, Boolean> resultCache;
        private final Stack<Node> stack;

        private static class Node {
            StronglyConnectedComponent component;
            final Descriptors.Descriptor descriptor;
            final int index;
            int lowLink;

            Node(Descriptors.Descriptor r1, int r2) {
                this.descriptor = r1;
                this.index = r2;
                this.lowLink = r2;
                this.component = null;
            }
        }

        private static class StronglyConnectedComponent {
            final List<Descriptors.Descriptor> messages;
            boolean needsIsInitializedCheck;

            private StronglyConnectedComponent() {
                this.messages = new ArrayList();
                this.needsIsInitializedCheck = false;
            }

            /* synthetic */ StronglyConnectedComponent(AnonymousClass1 r1) {
                this();
            }
        }

        IsInitializedCheckAnalyzer() {
            this.resultCache = new ConcurrentHashMap();
            this.index = 0;
            this.stack = new Stack();
            this.nodeCache = new HashMap();
        }

        public boolean needsIsInitializedCheck(Descriptors.Descriptor r4) {
            Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(this.resultCache.get(r4), Boolean.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            monitor-enter(this);
            Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(this.resultCache.get(r4), Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            if (r1 == null) goto L12;
            boolean r5 = r1.booleanValue();     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r5;
        L12:
            boolean r6 = dfs(r4).component.needsIsInitializedCheck;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r6;
        L15:
            th = move-exception;
            throw th;
        L5:
            return r0.booleanValue();
        }

        private Node dfs(Descriptors.Descriptor r6) {
            int r1 = this.index;
            this.index = r1 + 1;
            Node r0 = new Node(r6, r1);
            this.stack.push(r0);
            this.nodeCache.put(r6, r0);
            Iterator<Descriptors.FieldDescriptor> r7 = r6.getFields().iterator();
        L4:
            if (r7.hasNext() == false) goto L14;
            Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r7.next(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
            if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            Node r3 = (Node) ZeusTransformUtils.preCheckCast(this.nodeCache.get(r2.getMessageType()), Node.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L9;
            if (r3.component != null) goto L4;
            r0.lowLink = Math.min(r0.lowLink, r3.lowLink);
            goto L4
        L9:
            Node r4 = dfs(r2.getMessageType());
            r0.lowLink = Math.min(r0.lowLink, r4.lowLink);
            goto L4
        L14:
            if (r0.index != r0.lowLink) goto L19;
            StronglyConnectedComponent r8 = new StronglyConnectedComponent(null);
        L16:
            Node r5 = (Node) ZeusTransformUtils.preCheckCast(this.stack.pop(), Node.class, "com.obric.aiagent.plugin");
            r5.component = r8;
            r8.messages.add(r5.descriptor);
            if (r5 != r0) goto L16;
            analyze(r8);
        L19:
            return r0;
        }

        private void analyze(StronglyConnectedComponent r8) {
            Iterator<Descriptors.Descriptor> r0 = r8.messages.iterator();
        L3:
            boolean r2 = true;
            if (r0.hasNext() == false) goto L21;
            Descriptors.Descriptor r1 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
            if (r1.isExtendable() == true) goto L22;
            Iterator<Descriptors.FieldDescriptor> r3 = r1.getFields().iterator();
        L10:
            if (r3.hasNext() == false) goto L3;
            Descriptors.FieldDescriptor r4 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r3.next(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
            if (r4.isRequired() == true) goto L22;
            if (r4.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L10;
            Node r5 = (Node) ZeusTransformUtils.preCheckCast(this.nodeCache.get(r4.getMessageType()), Node.class, "com.obric.aiagent.plugin");
            if (r5.component == r8) goto L10;
            if (r5.component.needsIsInitializedCheck == false) goto L10;
        L22:
            r8.needsIsInitializedCheck = r2;
            Iterator<Descriptors.Descriptor> r6 = r8.messages.iterator();
        L24:
            if (r6.hasNext() == false) goto L26;
            Descriptors.Descriptor r7 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r6.next(), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
            this.resultCache.put(r7, Boolean.valueOf(r8.needsIsInitializedCheck));
            goto L24
        L26:
            return;
        L21:
            r2 = false;
            goto L22
        }
    }

    private static final class OneofState {
        private OneofInfo[] oneofs;

        private OneofState() {
            this.oneofs = new OneofInfo[2];
        }

        /* synthetic */ OneofState(AnonymousClass1 r1) {
            this();
        }

        OneofInfo getOneof(Class<?> r5, Descriptors.OneofDescriptor r6) {
            int r0 = r6.getIndex();
            OneofInfo[] r1 = this.oneofs;
            if (r0 < r1.length) goto L5;
            this.oneofs = (OneofInfo[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r0 * 2), OneofInfo[].class, "com.obric.aiagent.plugin");
        L5:
            OneofInfo r2 = this.oneofs[r0];
            if (r2 != null) goto L9;
            OneofInfo r3 = newInfo(r5, r6);
            this.oneofs[r0] = r3;
            return r3;
        L9:
            return r2;
        }

        private static OneofInfo newInfo(Class<?> r3, Descriptors.OneofDescriptor r4) {
            String r0 = DescriptorMessageInfoFactory.access$200(r4.getName());
            String r1 = r0 + "_";
            return new OneofInfo(r4.getIndex(), DescriptorMessageInfoFactory.access$300(r3, r0 + "Case_"), DescriptorMessageInfoFactory.access$300(r3, r1));
        }
    }

    static /* synthetic */ String access$200(String r0) {
        return snakeCaseToLowerCamelCase(r0);
    }

    static /* synthetic */ java.lang.reflect.Field access$300(Class r0, String r1) {
        return field(r0, r1);
    }

    static {
        instance = new DescriptorMessageInfoFactory();
        specialFieldNames = new HashSet(Arrays.asList(new String[]{"Class", "DefaultInstanceForType", "ParserForType", "SerializedSize", "AllFields", "DescriptorForType", "InitializationErrorString", "UnknownFields", "CachedSize"}));
        isInitializedCheckAnalyzer = new IsInitializedCheckAnalyzer();
    }

    private DescriptorMessageInfoFactory() {
    }

    public static DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> r1) {
        return GeneratedMessage.class.isAssignableFrom(r1);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> r3) {
        if (GeneratedMessage.class.isAssignableFrom(r3) == false) goto L7;
        return convert(r3, descriptorForType(r3));
    L7:
        throw new IllegalArgumentException("Unsupported message type: " + r3.getName());
    }

    private static Message getDefaultInstance(Class<?> r4) {
        return (Message) ZeusTransformUtils.preCheckCast(r4.getDeclaredMethod(GET_DEFAULT_INSTANCE_METHOD_NAME, new Class[0]).invoke(null, new Object[0]), Message.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Unable to get default instance for message class " + r4.getName(), e);
    }

    private static Descriptors.Descriptor descriptorForType(Class<?> r0) {
        return getDefaultInstance(r0).getDescriptorForType();
    }

    private static ProtoSyntax convertSyntax(DescriptorProtos.Edition r1) {
        int r2 = AnonymousClass3.$SwitchMap$com$google$protobuf$DescriptorProtos$Edition[r1.ordinal()];
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        return ProtoSyntax.EDITIONS;
    L9:
        return ProtoSyntax.PROTO3;
    L11:
        return ProtoSyntax.PROTO2;
    }

    private static MessageInfo convert(Class<?> r18, Descriptors.Descriptor r19) {
        List<Descriptors.FieldDescriptor> r1 = r19.getFields();
        StructuralMessageInfo.Builder r2 = StructuralMessageInfo.newBuilder(r1.size());
        r2.withDefaultInstance(getDefaultInstance(r18));
        r2.withSyntax(convertSyntax(r19.getFile().getEdition()));
        r2.withMessageSetWireFormat(r19.getOptions().getMessageSetWireFormat());
        AnonymousClass1 r4 = null;
        OneofState r3 = new OneofState(r4);
        java.lang.reflect.Field r8 = null;
        int r17 = 1;
        int r7 = 0;
        int r9 = 0;
    L4:
        if (r7 >= r1.size()) goto L48;
        final Descriptors.FieldDescriptor r10 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.get(r7), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
        boolean r15 = r10.needsUtf8Check();
        if (r10.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L8;
    L10:
        Internal.EnumVerifier r14 = r4;
    L12:
        if (r10.getRealContainingOneof() == null) goto L14;
        r2.withField(buildOneofMember(r18, r10, r3, r15, r14));
    L47:
        r7 = r7 + 1;
        r4 = null;
        goto L4
    L14:
        java.lang.reflect.Field r11 = field(r18, r10);
        int r12 = r10.getNumber();
        FieldType r13 = getFieldType(r10);
        if (r10.hasPresence() == false) goto L17;
        if (r8 != null) goto L41;
        r8 = bitField(r18, r9);
    L41:
        if (r10.isRequired() == false) goto L43;
        FieldInfo r5 = FieldInfo.forLegacyRequiredField(r11, r12, r13, r8, r17, r15, r14);
    L44:
        r2.withField(r5);
        r17 = r17 << 1;
        if (r17 != 0) goto L47;
        r9 = r9 + 1;
        r17 = 1;
        r8 = null;
        goto L47
    L43:
        r5 = FieldInfo.forExplicitPresenceField(r11, r12, r13, r8, r17, r15, r14);
        goto L44
    L17:
        if (r10.isMapField() == false) goto L25;
        final Descriptors.FieldDescriptor r16 = r10.getMessageType().findFieldByNumber(2);
        if (r16.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L21;
    L23:
        FieldInfo r6 = FieldInfo.forMapField(r11, r12, SchemaUtil.getMapDefaultEntry(r18, r10.getName()), r14);
    L37:
        r2.withField(r6);
        goto L47
    L21:
        if (r16.legacyEnumFieldTreatedAsClosed() == false) goto L23;
        r14 = new AnonymousClass2(r16);
        goto L23
    L25:
        if (r10.isRepeated() == false) goto L30;
        if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L30;
        r6 = FieldInfo.forRepeatedMessageField(r11, r12, r13, getTypeForRepeatedMessageField(r18, r10));
    L30:
        if (r10.isPacked() == false) goto L34;
        if (r14 == null) goto L33;
        r6 = FieldInfo.forPackedFieldWithEnumVerifier(r11, r12, r13, r14, cachedSizeField(r18, r10));
        goto L37
    L33:
        r6 = FieldInfo.forPackedField(r11, r12, r13, cachedSizeField(r18, r10));
        goto L37
    L34:
        if (r14 == null) goto L36;
        r6 = FieldInfo.forFieldWithEnumVerifier(r11, r12, r13, r14);
        goto L37
    L36:
        r6 = FieldInfo.forField(r11, r12, r13, r15);
        goto L37
    L8:
        if (r10.legacyEnumFieldTreatedAsClosed() == false) goto L10;
        r14 = new AnonymousClass1(r10);
        goto L12
    L48:
        ArrayList r0 = new ArrayList();
        int r20 = 0;
    L50:
        if (r20 >= r1.size()) goto L59;
        Descriptors.FieldDescriptor r21 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.get(r20), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
        if (r21.isRequired() == false) goto L54;
    L57:
        r0.add(Integer.valueOf(r21.getNumber()));
    L58:
        r20 = r20 + 1;
        goto L50
    L54:
        if (r21.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L58;
        if (needsIsInitializedCheck(r21.getMessageType()) == false) goto L58;
    L59:
        int r22 = r0.size();
        int[] r23 = new int[r22];
        int r24 = 0;
    L61:
        if (r24 >= r0.size()) goto L63;
        r23[r24] = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r24), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r24 = r24 + 1;
        goto L61
    L63:
        if (r22 <= 0) goto L66;
        r2.withCheckInitialized(r23);
    L66:
        return r2.build();
    }

    private static boolean needsIsInitializedCheck(Descriptors.Descriptor r1) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(r1);
    }

    private static FieldInfo buildOneofMember(Class<?> r6, Descriptors.FieldDescriptor r7, OneofState r8, boolean r9, Internal.EnumVerifier r10) {
        Internal.EnumVerifier r5 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r10, Internal.EnumVerifier.class, "com.obric.aiagent.plugin");
        OneofInfo r2 = r8.getOneof(r6, r7.getContainingOneof());
        FieldType r1 = getFieldType(r7);
        Class<?> r3 = getOneofStoredType(r6, r7, r1);
        return FieldInfo.forOneofMemberField(r7.getNumber(), r1, r2, r3, r9, r5);
    }

    private static Class<?> getOneofStoredType(Class<?> r2, Descriptors.FieldDescriptor r3, FieldType r4) {
        switch(AnonymousClass3.$SwitchMap$com$google$protobuf$JavaType[r4.getJavaType().ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L5;
        };
    L8:
        return String.class;
    L10:
        return Long.class;
    L12:
        return Integer.class;
    L14:
        return Float.class;
    L16:
        return Double.class;
    L18:
        return ByteString.class;
    L20:
        return Boolean.class;
    L5:
        throw new IllegalArgumentException("Invalid type for oneof: " + r4);
    L7:
        return getOneofStoredTypeForMessage(r2, r3);
    }

    private static FieldType getFieldType(Descriptors.FieldDescriptor r3) {
        switch(AnonymousClass3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r3.getType().ordinal()]) {
            case 1: goto L148;
            case 2: goto L143;
            case 3: goto L134;
            case 4: goto L125;
            case 5: goto L116;
            case 6: goto L107;
            case 7: goto L98;
            case 8: goto L93;
            case 9: goto L84;
            case 10: goto L75;
            case 11: goto L66;
            case 12: goto L57;
            case 13: goto L48;
            case 14: goto L39;
            case 15: goto L30;
            case 16: goto L25;
            case 17: goto L16;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Unsupported field type: " + r3.getType());
    L7:
        if (r3.isRepeated() == true) goto L11;
        return FieldType.UINT64;
    L11:
        if (r3.isPacked() == false) goto L14;
        return FieldType.UINT64_LIST_PACKED;
    L14:
        return FieldType.UINT64_LIST;
    L16:
        if (r3.isRepeated() == true) goto L20;
        return FieldType.UINT32;
    L20:
        if (r3.isPacked() == false) goto L23;
        return FieldType.UINT32_LIST_PACKED;
    L23:
        return FieldType.UINT32_LIST;
    L25:
        if (r3.isRepeated() == false) goto L28;
        return FieldType.STRING_LIST;
    L28:
        return FieldType.STRING;
    L30:
        if (r3.isRepeated() == true) goto L34;
        return FieldType.SINT64;
    L34:
        if (r3.isPacked() == false) goto L37;
        return FieldType.SINT64_LIST_PACKED;
    L37:
        return FieldType.SINT64_LIST;
    L39:
        if (r3.isRepeated() == true) goto L43;
        return FieldType.SINT32;
    L43:
        if (r3.isPacked() == false) goto L46;
        return FieldType.SINT32_LIST_PACKED;
    L46:
        return FieldType.SINT32_LIST;
    L48:
        if (r3.isRepeated() == true) goto L52;
        return FieldType.SFIXED64;
    L52:
        if (r3.isPacked() == false) goto L55;
        return FieldType.SFIXED64_LIST_PACKED;
    L55:
        return FieldType.SFIXED64_LIST;
    L57:
        if (r3.isRepeated() == true) goto L61;
        return FieldType.SFIXED32;
    L61:
        if (r3.isPacked() == false) goto L64;
        return FieldType.SFIXED32_LIST_PACKED;
    L64:
        return FieldType.SFIXED32_LIST;
    L66:
        if (r3.isMapField() == false) goto L70;
        return FieldType.MAP;
    L70:
        if (r3.isRepeated() == false) goto L73;
        return FieldType.MESSAGE_LIST;
    L73:
        return FieldType.MESSAGE;
    L75:
        if (r3.isRepeated() == true) goto L79;
        return FieldType.INT64;
    L79:
        if (r3.isPacked() == false) goto L82;
        return FieldType.INT64_LIST_PACKED;
    L82:
        return FieldType.INT64_LIST;
    L84:
        if (r3.isRepeated() == true) goto L88;
        return FieldType.INT32;
    L88:
        if (r3.isPacked() == false) goto L91;
        return FieldType.INT32_LIST_PACKED;
    L91:
        return FieldType.INT32_LIST;
    L93:
        if (r3.isRepeated() == false) goto L96;
        return FieldType.GROUP_LIST;
    L96:
        return FieldType.GROUP;
    L98:
        if (r3.isRepeated() == true) goto L102;
        return FieldType.FLOAT;
    L102:
        if (r3.isPacked() == false) goto L105;
        return FieldType.FLOAT_LIST_PACKED;
    L105:
        return FieldType.FLOAT_LIST;
    L107:
        if (r3.isRepeated() == true) goto L111;
        return FieldType.FIXED64;
    L111:
        if (r3.isPacked() == false) goto L114;
        return FieldType.FIXED64_LIST_PACKED;
    L114:
        return FieldType.FIXED64_LIST;
    L116:
        if (r3.isRepeated() == true) goto L120;
        return FieldType.FIXED32;
    L120:
        if (r3.isPacked() == false) goto L123;
        return FieldType.FIXED32_LIST_PACKED;
    L123:
        return FieldType.FIXED32_LIST;
    L125:
        if (r3.isRepeated() == true) goto L129;
        return FieldType.ENUM;
    L129:
        if (r3.isPacked() == false) goto L132;
        return FieldType.ENUM_LIST_PACKED;
    L132:
        return FieldType.ENUM_LIST;
    L134:
        if (r3.isRepeated() == true) goto L138;
        return FieldType.DOUBLE;
    L138:
        if (r3.isPacked() == false) goto L141;
        return FieldType.DOUBLE_LIST_PACKED;
    L141:
        return FieldType.DOUBLE_LIST;
    L143:
        if (r3.isRepeated() == false) goto L146;
        return FieldType.BYTES_LIST;
    L146:
        return FieldType.BYTES;
    L148:
        if (r3.isRepeated() == true) goto L152;
        return FieldType.BOOL;
    L152:
        if (r3.isPacked() == false) goto L155;
        return FieldType.BOOL_LIST_PACKED;
    L155:
        return FieldType.BOOL_LIST;
    }

    private static java.lang.reflect.Field bitField(Class<?> r2, int r3) {
        return field(r2, "bitField" + r3 + "_");
    }

    private static java.lang.reflect.Field field(Class<?> r0, Descriptors.FieldDescriptor r1) {
        return field(r0, getFieldName(r1));
    }

    private static java.lang.reflect.Field cachedSizeField(Class<?> r0, Descriptors.FieldDescriptor r1) {
        return field(r0, getCachedSizeFieldName(r1));
    }

    private static java.lang.reflect.Field field(Class<?> r4, String r5) {
        return r4.getDeclaredField(r5);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find field " + r5 + " in message class " + r4.getName(), e);
    }

    static String getFieldName(Descriptors.FieldDescriptor r2) {
        if (r2.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r3 = r2.getMessageType().getName();
    L7:
        if (specialFieldNames.contains(snakeCaseToUpperCamelCase(r3)) == false) goto L9;
        String r0 = "__";
    L11:
        return snakeCaseToLowerCamelCase(r3) + r0;
    L9:
        r0 = "_";
        goto L11
    L5:
        r3 = r2.getName();
        goto L7
    }

    private static String getCachedSizeFieldName(Descriptors.FieldDescriptor r1) {
        return snakeCaseToLowerCamelCase(r1.getName()) + "MemoizedSerializedSize";
    }

    private static String snakeCaseToLowerCamelCase(String r1) {
        return snakeCaseToCamelCase(r1, false);
    }

    private static String snakeCaseToUpperCamelCase(String r1) {
        return snakeCaseToCamelCase(r1, true);
    }

    private static String snakeCaseToCamelCase(String r6, boolean r7) {
        StringBuilder r0 = new StringBuilder(r6.length() + 1);
        int r3 = 0;
    L4:
        if (r3 >= r6.length()) goto L18;
        char r4 = r6.charAt(r3);
        if (r4 != '_') goto L9;
    L7:
        r7 = true;
    L16:
        r3 = r3 + 1;
        goto L4
    L9:
        if (Character.isDigit(r4) == false) goto L11;
        r0.append(r4);
        goto L7
    L11:
        if (r7 == false) goto L13;
        r0.append(Character.toUpperCase(r4));
        r7 = false;
        goto L16
    L13:
        if (r3 != 0) goto L15;
        r0.append(Character.toLowerCase(r4));
        goto L16
    L15:
        r0.append(r4);
        goto L16
    L18:
        return r0.toString();
    }

    private static Class<?> getOneofStoredTypeForMessage(Class<?> r2, Descriptors.FieldDescriptor r3) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (r3.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r4 = r3.getMessageType().getName();     // Catch: Exception -> L8
    L6:
        return r2.getDeclaredMethod(getterForField(r4), new Class[0]).getReturnType();
    L5:
        r4 = r3.getName();     // Catch: Exception -> L8
        goto L6
    }

    private static Class<?> getTypeForRepeatedMessageField(Class<?> r3, Descriptors.FieldDescriptor r4) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (r4.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r5 = r4.getMessageType().getName();     // Catch: Exception -> L8
    L6:
        return r3.getDeclaredMethod(getterForField(r5), new Class[]{Integer.TYPE}).getReturnType();
    L5:
        r5 = r4.getName();     // Catch: Exception -> L8
        goto L6
    }

    private static String getterForField(String r3) {
        String r4 = snakeCaseToLowerCamelCase(r3);
        return MonitorConstants.CONNECT_TYPE_GET + Character.toUpperCase(r4.charAt(0)) + r4.substring(1, r4.length());
    }
}
