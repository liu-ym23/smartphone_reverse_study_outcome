package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r0 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r0;
            r0[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields;

        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType r1);

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
            return clone();
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        protected Builder() {
            this.unknownFields = ByteString.EMPTY;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public final BuilderType setUnknownFields(ByteString r1) {
            this.unknownFields = r1;
            return this;
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions;
        private boolean extensionsIsMutable;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        static /* synthetic */ FieldSet access$000(ExtendableBuilder r0) {
            return r0.buildExtensions();
        }

        protected ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensionsIsMutable == true) goto L6;
            this.extensions = this.extensions.m2082clone();
            this.extensionsIsMutable = true;
            return;
        }

        private FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected final void mergeExtensionFields(MessageType r1) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$200(r1));
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            /* synthetic */ ExtensionWriter(ExtendableMessage r1, boolean r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            private ExtensionWriter(ExtendableMessage r2, boolean r3) {
                this.this$0 = r2;
                Iterator<Map.Entry<ExtensionDescriptor, Object>> r4 = ExtendableMessage.access$200(r2).iterator();
                this.iter = r4;
                if (r4.hasNext() == false) goto L5;
                this.next = r4.next();
            L5:
                this.messageSetWireFormat = r3;
            }

            public void writeUntil(int r4, CodedOutputStream r5) throws IOException {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r0 = this.next;
                if (r0 == null) goto L18;
                if (r0.getKey().getNumber() >= r4) goto L26;
                ExtensionDescriptor r1 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r1, this.next.getValue(), r5);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L2
            L16:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r1.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r1.isRepeated() == true) goto L13;
                r5.writeMessageSetExtension(r1.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L26:
                return;
            }
        }

        static /* synthetic */ FieldSet access$200(ExtendableMessage r0) {
            return r0.extensions;
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> r1) {
            this.extensions = ExtendableBuilder.access$000(r1);
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r1) {
            if (r1.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r1) {
            verifyExtensionContainingType(r1);
            return this.extensions.hasField(r1.descriptor);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r1) {
            verifyExtensionContainingType(r1);
            return this.extensions.getRepeatedFieldCount(r1.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r2) {
            verifyExtensionContainingType(r2);
            Object r1 = this.extensions.getField(r2.descriptor);
            if (r1 != null) goto L7;
            return r2.defaultValue;
        L7:
            return (Type) r2.fromFieldSetType(r1);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r2, int r3) {
            verifyExtensionContainingType(r2);
            return (Type) r2.singularFromFieldSetType(this.extensions.getRepeatedField(r2.descriptor, r3));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        protected boolean parseUnknownField(CodedInputStream r7, CodedOutputStream r8, ExtensionRegistryLite r9, int r10) throws IOException {
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r7, r8, r9, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        protected void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r1) {
            return compareTo((ExtensionDescriptor) r1);
        }

        ExtensionDescriptor(Internal.EnumLiteMap<?> r1, int r2, WireFormat.FieldType r3, boolean r4, boolean r5) {
            this.enumTypeMap = r1;
            this.number = r2;
            this.type = r3;
            this.isRepeated = r4;
            this.isPacked = r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r1, MessageLite r2) {
            return ((Builder) r1).mergeFrom((GeneratedMessageLite) r2);
        }

        public int compareTo(ExtensionDescriptor r1) {
            return this.number - r1.number;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        GeneratedExtension(ContainingType r3, Type r4, MessageLite r5, ExtensionDescriptor r6, Class r7) {
            if (r3 == null) goto L16;
            if (r6.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r5 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r3;
            this.defaultValue = r4;
            this.messageDefaultInstance = r5;
            this.descriptor = r6;
            this.singularType = r7;
            if (Internal.EnumLite.class.isAssignableFrom(r7) == false) goto L13;
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(r7, "valueOf", new Class[]{Integer.TYPE});
            return;
        L13:
            this.enumValueOf = null;
            return;
        L16:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        Object fromFieldSetType(Object r3) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r0 = new ArrayList();
            Iterator r4 = ((List) r3).iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            r0.add(singularFromFieldSetType(r4.next()));
            goto L8
        L10:
            return r0;
        L11:
            return r3;
        L13:
            return singularFromFieldSetType(r3);
        }

        Object singularFromFieldSetType(Object r3) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r3;
        L5:
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[]{(Integer) r3});
        }

        Object singularToFieldSetType(Object r2) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r2;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r2).getNumber());
        }
    }

    protected void makeExtensionsImmutable() {
    }

    static /* synthetic */ boolean access$100(FieldSet r0, MessageLite r1, CodedInputStream r2, CodedOutputStream r3, ExtensionRegistryLite r4, int r5) throws IOException {
        return parseUnknownField(r0, r1, r2, r3, r4, r5);
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(Builder r1) {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean parseUnknownField(CodedInputStream r1, CodedOutputStream r2, ExtensionRegistryLite r3, int r4) throws IOException {
        return r1.skipField(r4, r2);
    }

    private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> r4, MessageType r5, CodedInputStream r6, CodedOutputStream r7, ExtensionRegistryLite r8, int r9) throws IOException {
        int r0 = WireFormat.getTagWireType(r9);
        GeneratedExtension r10 = r8.findLiteExtensionByNumber(r5, WireFormat.getTagFieldNumber(r9));
        if (r10 != null) goto L6;
    L4:
        boolean r1 = true;
        boolean r3 = false;
    L15:
        if (r1 == true) goto L17;
        if (r3 == false) goto L31;
        int r11 = r6.pushLimit(r6.readRawVarint32());
        if (r10.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
    L22:
        if (r6.getBytesUntilLimit() <= 0) goto L30;
        Internal.EnumLite r12 = r10.descriptor.getEnumType().findValueByNumber(r6.readEnum());
        if (r12 == null) goto L25;
        r4.addRepeatedField(r10.descriptor, r10.singularToFieldSetType(r12));
        goto L22
    L25:
        return true;
    L30:
        r6.popLimit(r11);
    L58:
        return true;
    L28:
        if (r6.getBytesUntilLimit() <= 0) goto L30;
        r4.addRepeatedField(r10.descriptor, FieldSet.readPrimitiveField(r6, r10.descriptor.getLiteType(), false));
        goto L28
    L31:
        int r2 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r10.descriptor.getLiteJavaType().ordinal()];
        if (r2 == 1) goto L42;
        if (r2 == 2) goto L36;
        Object r13 = FieldSet.readPrimitiveField(r6, r10.descriptor.getLiteType(), false);
    L55:
        if (r10.descriptor.isRepeated() == false) goto L57;
        r4.addRepeatedField(r10.descriptor, r10.singularToFieldSetType(r13));
        goto L58
    L57:
        r4.setField(r10.descriptor, r10.singularToFieldSetType(r13));
        goto L58
    L36:
        int r14 = r6.readEnum();
        Internal.EnumLite r15 = r10.descriptor.getEnumType().findValueByNumber(r14);
        if (r15 != null) goto L40;
        r7.writeRawVarint32(r9);
        r7.writeUInt32NoTag(r14);
        return true;
    L40:
        r13 = r15;
        goto L55
    L42:
        if (r10.descriptor.isRepeated() == true) goto L46;
        MessageLite r16 = (MessageLite) r4.getField(r10.descriptor);
        if (r16 == null) goto L46;
        MessageLite.Builder r17 = r16.toBuilder();
    L47:
        if (r17 != null) goto L50;
        r17 = r10.getMessageDefaultInstance().newBuilderForType();
    L50:
        if (r10.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L52;
        r6.readGroup(r10.getNumber(), r17, r8);
    L53:
        r13 = r17.build();
        goto L55
    L52:
        r6.readMessage(r17, r8);
    L46:
        r17 = null;
        goto L47
    L17:
        return r6.skipField(r9, r7);
    L6:
        if (r0 != FieldSet.getWireFormatForFieldType(r10.descriptor.getLiteType(), false)) goto L9;
        r1 = false;
        r3 = false;
        goto L15
    L9:
        if (r10.descriptor.isRepeated == false) goto L4;
        if (r10.descriptor.type.isPackable() == false) goto L4;
        if (r0 != FieldSet.getWireFormatForFieldType(r10.descriptor.getLiteType(), true)) goto L4;
        r3 = true;
        r1 = false;
        goto L15
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r8, Type r9, MessageLite r10, Internal.EnumLiteMap<?> r11, int r12, WireFormat.FieldType r13, Class r14) {
        return new GeneratedExtension(r8, r9, r10, new ExtensionDescriptor(r11, r12, r13, false, false), r14);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, Collections.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    static Method getMethodOrDie(Class r4, String r5, Class... r6) {
        return r4.getMethod(r5, r6);
    L4:
        e = move-exception;
        String r7 = String.valueOf(String.valueOf(r4.getName()));
        String r8 = String.valueOf(String.valueOf(r5));
        throw new RuntimeException(new StringBuilder((r7.length() + 45) + r8.length()).append("Generated message class \"").append(r7).append("\" missing method \"").append(r8).append("\".").toString(), e);
    }

    static Object invokeOrDie(Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r3 = e.getCause();
        if ((r3 instanceof RuntimeException) == true) goto L14;
        if ((r3 instanceof Error) == false) goto L12;
        throw ((Error) r3);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r3);
    L14:
        throw ((RuntimeException) r3);
    }
}
