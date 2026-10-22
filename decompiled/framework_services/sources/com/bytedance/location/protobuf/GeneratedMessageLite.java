package com.bytedance.location.protobuf;

import com.bytedance.location.protobuf.GeneratedMessageLite;
import com.bytedance.location.protobuf.GeneratedMessageLite.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap;
    private int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L12:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo10504clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.bytedance.location.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder
        protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r1) {
            return internalMergeFrom((GeneratedMessageLite) r1);
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2, r3, r4);
        }

        protected Builder(MessageType r3) {
            this.defaultInstance = r3;
            if (r3.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        protected final void copyOnWrite() {
            if (this.instance.isMutable() == true) goto L6;
            copyOnWriteInternal();
            return;
        }

        protected void copyOnWriteInternal() {
            MessageType r0 = (MessageType) newMutableInstance();
            mergeFromInstance(r0, this.instance);
            this.instance = r0;
        }

        @Override // com.bytedance.location.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public final BuilderType clear() {
            if (this.defaultInstance.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return this;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType clone() {
            BuilderType r0 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r0.instance = (MessageType) buildPartial();
            return r0;
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (this.instance.isMutable() == false) goto L5;
            this.instance.makeImmutable();
            return this.instance;
        L5:
            return this.instance;
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType r0 = (MessageType) buildPartial();
            if (r0.isInitialized() == false) goto L6;
            return r0;
        L6:
            throw AbstractMessageLite.Builder.newUninitializedMessageException(r0);
        }

        protected BuilderType internalMergeFrom(MessageType r2) {
            return (BuilderType) mergeFrom(r2);
        }

        public BuilderType mergeFrom(MessageType message) {
            if (getDefaultInstanceForType().equals(message) == false) goto L5;
            return this;
        L5:
            copyOnWrite();
            mergeFromInstance(this.instance, message);
            return this;
        }

        private static <MessageType> void mergeFromInstance(MessageType dest, MessageType src) {
            Protobuf.getInstance().schemaFor(dest).mergeFrom(dest, src);
        }

        @Override // com.bytedance.location.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            copyOnWrite();
            goto L22
        L27:
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, input, offset, offset + length, new ArrayDecoders.Registers(extensionRegistry));     // Catch: IOException -> L7 IndexOutOfBoundsException -> L9 InvalidProtocolBufferException -> L11
            return this;
        L11:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            IOException e = e;
        L20:
            throw new RuntimeException("Reading from byte array should not throw IOException.", e);
        L17:
            e = move-exception;
            throw e;
        L13:
            e = move-exception;
            e = e;
        L22:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r2, int r3, int r4) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r2, r3, r4, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.AbstractMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(input), extensionRegistry);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if ((e.getCause() instanceof IOException) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) e.getCause());
        }
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        @Override // com.bytedance.location.protobuf.AbstractParser, com.bytedance.location.protobuf.Parser
        public /* bridge */ /* synthetic */ MessageLite parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return parsePartialFrom(r1, r2, r3, r4);
        }

        @Override // com.bytedance.location.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return parsePartialFrom(r1, r2);
        }

        @Override // com.bytedance.location.protobuf.AbstractParser, com.bytedance.location.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return parsePartialFrom(r1, r2, r3, r4);
        }

        public DefaultInstanceBasedParser(T defaultInstance) {
            this.defaultInstance = defaultInstance;
        }

        @Override // com.bytedance.location.protobuf.Parser
        public T parsePartialFrom(CodedInputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, r2, r3);
        }

        @Override // com.bytedance.location.protobuf.AbstractParser, com.bytedance.location.protobuf.Parser
        public T parsePartialFrom(byte[] r2, int r3, int r4, ExtensionRegistryLite r5) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.access$200(this.defaultInstance, r2, r3, r4, r5);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        protected ExtendableBuilder(MessageType defaultInstance) {
            super(defaultInstance);
        }

        void internalSetExtensionSet(FieldSet<ExtensionDescriptor> extensions) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = extensions;
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.Builder
        protected void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) this.instance).extensions == FieldSet.emptySet()) goto L6;
            ExtendableMessage r0 = (ExtendableMessage) this.instance;
            r0.extensions = ((ExtendableMessage) this.instance).extensions.clone();
            return;
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> extensions = ((ExtendableMessage) this.instance).extensions;
            if (extensions.isImmutable() == false) goto L6;
            FieldSet r0 = extensions.clone();
            ((ExtendableMessage) this.instance).extensions = r0;
            return r0;
        L6:
            return extensions;
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.Builder, com.bytedance.location.protobuf.MessageLite.Builder
        public final MessageType buildPartial() {
            if (((ExtendableMessage) this.instance).isMutable() == false) goto L5;
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (MessageType) super.buildPartial();
        L5:
            return (MessageType) this.instance;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extension) {
            return ((ExtendableMessage) this.instance).hasExtension(extension);
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extension) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extension);
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r2) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r2);
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r2, int r3) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r2, r3);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extension, Type value) {
            GeneratedExtension<MessageType, ?> r0 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r0);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(r0.descriptor, r0.toFieldSetType(value));
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extension, int index, Type value) {
            GeneratedExtension<MessageType, List<Type>> extensionLite = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(extensionLite);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(extensionLite.descriptor, index, extensionLite.singularToFieldSetType(value));
            return this;
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extension, Type value) {
            GeneratedExtension<MessageType, List<Type>> extensionLite = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(extensionLite);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(extensionLite.descriptor, extensionLite.singularToFieldSetType(value));
            return this;
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> extension) {
            GeneratedExtension<MessageType, ?> extensionLite = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(extensionLite);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(extensionLite.descriptor);
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            /* synthetic */ ExtensionWriter(ExtendableMessage x0, boolean x1, AnonymousClass1 x2) {
                this(x0, x1);
            }

            private ExtensionWriter(ExtendableMessage this$0, boolean messageSetWireFormat) {
                this.this$0 = this$0;
                this.iter = this.this$0.extensions.iterator();
                if (this.iter.hasNext() == false) goto L5;
                this.next = this.iter.next();
            L5:
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(int end, CodedOutputStream output) throws IOException {
            L3:
                if (this.next == null) goto L19;
                if (this.next.getKey().getNumber() >= end) goto L27;
                ExtensionDescriptor extension = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(extension, this.next.getValue(), output);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L3
            L16:
                this.next = this.iter.next();
                goto L3
            L9:
                if (extension.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (extension.isRepeated() == true) goto L13;
                output.writeMessageSetExtension(extension.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L27:
                return;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.emptySet();
        }

        protected final void mergeExtensionFields(MessageType other) {
            if (this.extensions.isImmutable() == false) goto L5;
            this.extensions = this.extensions.clone();
        L5:
            this.extensions.mergeFrom(other.extensions);
        }

        protected <MessageType extends MessageLite> boolean parseUnknownField(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            int fieldNumber = WireFormat.getTagFieldNumber(tag);
            return parseExtension(input, extensionRegistry, extensionRegistry.findLiteExtensionByNumber(defaultInstance, fieldNumber), tag, fieldNumber);
        }

        private boolean parseExtension(CodedInputStream input, ExtensionRegistryLite extensionRegistry, GeneratedExtension<?, ?> extension, int tag, int fieldNumber) throws IOException {
            int wireType = WireFormat.getTagWireType(tag);
            boolean unknown = false;
            boolean packed = false;
            boolean r8 = true;
            if (extension != null) goto L6;
            unknown = true;
        L16:
            if (unknown == true) goto L18;
            ensureExtensionsAreMutable();
            if (packed == false) goto L35;
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (extension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) goto L24;
            boolean r16 = true;
        L32:
            if (input.getBytesUntilLimit() <= 0) goto L34;
            Object value = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false);
            this.extensions.addRepeatedField(extension.descriptor, value);
        L34:
            input.popLimit(limit);
        L59:
            return r16;
        L24:
            if (input.getBytesUntilLimit() <= 0) goto L29;
            Object value2 = extension.descriptor.getEnumType().findValueByNumber(input.readEnum());
            if (value2 == null) goto L27;
            this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value2));
            r8 = r8;
            goto L24
        L27:
            return r8;
        L29:
            r16 = r8;
            goto L34
        L35:
            r16 = true;
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[extension.descriptor.getLiteJavaType().ordinal()]) {
                case 1: goto L43;
                case 2: goto L38;
                default: goto L37;
            };
        L37:
            Object value3 = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false);
        L56:
            if (extension.descriptor.isRepeated() == false) goto L58;
            this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value3));
            goto L59
        L58:
            this.extensions.setField(extension.descriptor, extension.singularToFieldSetType(value3));
            goto L59
        L38:
            int rawValue = input.readEnum();
            Object value4 = extension.descriptor.getEnumType().findValueByNumber(rawValue);
            if (value4 != null) goto L42;
            mergeVarintField(fieldNumber, rawValue);
            return true;
        L42:
            value3 = value4;
            goto L56
        L43:
            MessageLite.Builder subBuilder = null;
            if (extension.descriptor.isRepeated() == true) goto L48;
            MessageLite existingValue = (MessageLite) this.extensions.getField(extension.descriptor);
            if (existingValue == null) goto L48;
            subBuilder = existingValue.toBuilder();
        L48:
            if (subBuilder != null) goto L51;
            subBuilder = extension.getMessageDefaultInstance().newBuilderForType();
        L51:
            if (extension.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L53;
            input.readGroup(extension.getNumber(), subBuilder, extensionRegistry);
        L54:
            Object value5 = subBuilder.build();
            value3 = value5;
            goto L56
        L53:
            input.readMessage(subBuilder, extensionRegistry);
            goto L54
        L18:
            return parseUnknownField(tag, input);
        L6:
            if (wireType != FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), false)) goto L9;
            packed = false;
            goto L16
        L9:
            if (extension.descriptor.isRepeated == true) goto L11;
        L15:
            unknown = true;
            goto L16
        L11:
            if (extension.descriptor.type.isPackable() == false) goto L15;
            if (wireType != FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), true)) goto L15;
            packed = true;
            goto L16
        }

        protected <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            if (tag != WireFormat.MESSAGE_SET_ITEM_TAG) goto L6;
            mergeMessageSetExtensionFromCodedStream(defaultInstance, input, extensionRegistry);
            return true;
        L6:
            int wireType = WireFormat.getTagWireType(tag);
            if (wireType != 2) goto L11;
            return parseUnknownField(defaultInstance, input, extensionRegistry, tag);
        L11:
            return input.skipField(tag);
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            int typeId = 0;
            ByteString rawBytes = null;
            GeneratedExtension<?, ?> extension = null;
        L3:
            int tag = input.readTag();
            if (tag == 0) goto L19;
            if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
            if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L13;
            if (input.skipField(tag) == true) goto L3;
        L13:
            if (typeId == 0) goto L16;
            if (extension == null) goto L16;
            eagerlyMergeMessageSetExtension(input, extension, extensionRegistry, typeId);
            rawBytes = null;
        L16:
            rawBytes = input.readBytes();
            goto L3
        L8:
            typeId = input.readUInt32();
            if (typeId == 0) goto L3;
            extension = extensionRegistry.findLiteExtensionByNumber(defaultInstance, typeId);
        L19:
            input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (rawBytes == null) goto L43;
            if (typeId == 0) goto L44;
            if (extension == null) goto L24;
            mergeMessageSetExtensionFromBytes(rawBytes, extensionRegistry, extension);
            return;
        L24:
            mergeLengthDelimitedField(typeId, rawBytes);
            return;
        L44:
            return;
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream input, GeneratedExtension<?, ?> extension, ExtensionRegistryLite extensionRegistry, int typeId) throws IOException {
            int tag = WireFormat.makeTag(typeId, 2);
            parseExtension(input, extensionRegistry, extension, tag, typeId);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistryLite extensionRegistry, GeneratedExtension<?, ?> extension) throws IOException {
            MessageLite.Builder subBuilder = null;
            MessageLite existingValue = (MessageLite) this.extensions.getField(extension.descriptor);
            if (existingValue == null) goto L5;
            subBuilder = existingValue.toBuilder();
        L5:
            if (subBuilder != null) goto L7;
            subBuilder = extension.getMessageDefaultInstance().newBuilderForType();
        L7:
            subBuilder.mergeFrom(rawBytes, extensionRegistry);
            MessageLite value = subBuilder.build();
            ensureExtensionsAreMutable().setField(extension.descriptor, extension.singularToFieldSetType(value));
        }

        FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable() == false) goto L6;
            this.extensions = this.extensions.clone();
        L6:
            return this.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extension) {
            GeneratedExtension<MessageType, ?> r0 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r0);
            return this.extensions.hasField(r0.descriptor);
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extension) {
            GeneratedExtension<MessageType, List<Type>> extensionLite = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(extensionLite);
            return this.extensions.getRepeatedFieldCount(extensionLite.descriptor);
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r4) {
            GeneratedExtension<MessageType, ?> r0 = GeneratedMessageLite.access$000(r4);
            verifyExtensionContainingType(r0);
            Object r1 = this.extensions.getField(r0.descriptor);
            if (r1 != null) goto L7;
            return r0.defaultValue;
        L7:
            return (Type) r0.fromFieldSetType(r1);
        }

        @Override // com.bytedance.location.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r4, int r5) {
            GeneratedExtension<MessageType, ?> r0 = GeneratedMessageLite.access$000(r4);
            verifyExtensionContainingType(r0);
            return (Type) r0.singularFromFieldSetType(this.extensions.getRepeatedField(r0.descriptor, r5));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> r1);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r1, int r2);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r1);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r1);
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

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, boolean isRepeated, boolean isPacked) {
            this.enumTypeMap = enumTypeMap;
            this.number = number;
            this.type = type;
            this.isRepeated = isRepeated;
            this.isPacked = isPacked;
        }

        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Builder) to).mergeFrom((GeneratedMessageLite) from);
        }

        public int compareTo(ExtensionDescriptor other) {
            return this.number - other.number;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, ExtensionDescriptor descriptor, Class singularType) {
            if (containingTypeDefaultInstance == null) goto L13;
            if (descriptor.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (messageDefaultInstance != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = containingTypeDefaultInstance;
            this.defaultValue = defaultValue;
            this.messageDefaultInstance = messageDefaultInstance;
            this.descriptor = descriptor;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        @Override // com.bytedance.location.protobuf.ExtensionLite
        public int getNumber() {
            return this.descriptor.getNumber();
        }

        @Override // com.bytedance.location.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        Object fromFieldSetType(Object value) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            List result = new ArrayList();
            Iterator r1 = ((List) value).iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            Object element = r1.next();
            result.add(singularFromFieldSetType(element));
            goto L8
        L10:
            return result;
        L11:
            return value;
        L13:
            return singularFromFieldSetType(value);
        }

        Object singularFromFieldSetType(Object value) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return value;
        L5:
            return this.descriptor.enumTypeMap.findValueByNumber(((Integer) value).intValue());
        }

        Object toFieldSetType(Object value) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            List result = new ArrayList();
            Iterator r1 = ((List) value).iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            Object element = r1.next();
            result.add(singularToFieldSetType(element));
            goto L8
        L10:
            return result;
        L11:
            return value;
        L13:
            return singularToFieldSetType(value);
        }

        Object singularToFieldSetType(Object value) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return value;
        L5:
            return Integer.valueOf(((Internal.EnumLite) value).getNumber());
        }

        @Override // com.bytedance.location.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        @Override // com.bytedance.location.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        @Override // com.bytedance.location.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.defaultValue;
        }
    }

    public static final enum MethodToInvoke extends Enum<MethodToInvoke> {
        private static final /* synthetic */ MethodToInvoke[] $VALUES = null;
        public static final MethodToInvoke BUILD_MESSAGE_INFO = null;
        public static final MethodToInvoke GET_DEFAULT_INSTANCE = null;
        public static final MethodToInvoke GET_MEMOIZED_IS_INITIALIZED = null;
        public static final MethodToInvoke GET_PARSER = null;
        public static final MethodToInvoke NEW_BUILDER = null;
        public static final MethodToInvoke NEW_MUTABLE_INSTANCE = null;
        public static final MethodToInvoke SET_MEMOIZED_IS_INITIALIZED = null;

        private static /* synthetic */ MethodToInvoke[] $values() {
            return new MethodToInvoke[]{GET_MEMOIZED_IS_INITIALIZED, SET_MEMOIZED_IS_INITIALIZED, BUILD_MESSAGE_INFO, NEW_MUTABLE_INSTANCE, NEW_BUILDER, GET_DEFAULT_INSTANCE, GET_PARSER};
        }

        private MethodToInvoke(String r1, int r2) {
            super(r1, r2);
        }

        public static MethodToInvoke valueOf(String name) {
            return (MethodToInvoke) Enum.valueOf(MethodToInvoke.class, name);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) $VALUES.clone();
        }

        static {
            GET_MEMOIZED_IS_INITIALIZED = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            SET_MEMOIZED_IS_INITIALIZED = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            BUILD_MESSAGE_INFO = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            NEW_MUTABLE_INSTANCE = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            NEW_BUILDER = new MethodToInvoke("NEW_BUILDER", 4);
            GET_DEFAULT_INSTANCE = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            GET_PARSER = new MethodToInvoke("GET_PARSER", 6);
            $VALUES = $values();
        }
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public static SerializedForm of(MessageLite message) {
            return new SerializedForm(message);
        }

        SerializedForm(MessageLite regularForm) {
            this.messageClass = regularForm.getClass();
            this.messageClassName = this.messageClass.getName();
            this.asBytes = regularForm.toByteArray();
        }

        protected Object readResolve() throws ObjectStreamException {
            Class<?> messageClass = resolveMessageClass();     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            Field defaultInstanceField = messageClass.getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            defaultInstanceField.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            MessageLite defaultInstance = (MessageLite) defaultInstanceField.get(null);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            return defaultInstance.newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L12:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e);
        L21:
            return readResolveFallback();
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            Class<?> messageClass = resolveMessageClass();     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            Field defaultInstanceField = messageClass.getDeclaredField("defaultInstance");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            defaultInstanceField.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            MessageLite defaultInstance = (MessageLite) defaultInstanceField.get(null);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            return defaultInstance.newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L12:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e);
        L8:
            e = move-exception;
            throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e);
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            if (this.messageClass == null) goto L6;
            return this.messageClass;
        L6:
            return Class.forName(this.messageClassName);
        }
    }

    protected abstract Object dynamicMethod(MethodToInvoke r1, Object r2, Object r3);

    public GeneratedMessageLite() {
        this.memoizedSerializedSize = -1;
        this.unknownFields = UnknownFieldSetLite.getDefaultInstance();
    }

    static /* synthetic */ GeneratedExtension access$000(ExtensionLite x0) {
        return checkIsLite(x0);
    }

    static /* synthetic */ GeneratedMessageLite access$200(GeneratedMessageLite x0, byte[] x1, int x2, int x3, ExtensionRegistryLite x4) throws InvalidProtocolBufferException {
        return parsePartialFrom(x0, x1, x2, x3, x4);
    }

    @Override // com.bytedance.location.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    boolean isMutable() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    void setMemoizedHashCode(int value) {
        this.memoizedHashCode = value;
    }

    void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    boolean hashCodeIsNotMemoized() {
        if (getMemoizedHashCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // com.bytedance.location.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public int hashCode() {
        if (isMutable() == false) goto L7;
        return computeHashCode();
    L7:
        if (hashCodeIsNotMemoized() == false) goto L10;
        setMemoizedHashCode(computeHashCode());
    L10:
        return getMemoizedHashCode();
    }

    int computeHashCode() {
        return Protobuf.getInstance().schemaFor(this).hashCode(this);
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if (getClass() == other.getClass()) goto L12;
        return false;
    L12:
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) other);
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        this.unknownFields = UnknownFieldSetLite.newInstance();
        return;
    }

    protected boolean parseUnknownField(int tag, CodedInputStream input) throws IOException {
        if (WireFormat.getTagWireType(tag) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(tag, input);
    }

    protected void mergeVarintField(int tag, int value) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(tag, value);
    }

    protected void mergeLengthDelimitedField(int fieldNumber, ByteString value) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(fieldNumber, value);
    }

    protected void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    protected final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    protected final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType r2) {
        return (BuilderType) createBuilder().mergeFrom(r2);
    }

    @Override // com.bytedance.location.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom(this);
    }

    protected Object dynamicMethod(MethodToInvoke method, Object arg0) {
        return dynamicMethod(method, arg0, null);
    }

    protected Object dynamicMethod(MethodToInvoke method) {
        return dynamicMethod(method, null, null);
    }

    void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    @Override // com.bytedance.location.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.bytedance.location.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int size) {
        if (size < 0) goto L6;
        this.memoizedSerializedSize = (this.memoizedSerializedSize & Integer.MIN_VALUE) | (Integer.MAX_VALUE & size);
        return;
    L6:
        throw new IllegalStateException("serialized size must be non-negative, was " + size);
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(output));
    }

    @Override // com.bytedance.location.protobuf.AbstractMessageLite
    int getSerializedSize(Schema schema) {
        if (isMutable() == false) goto L10;
        int size = computeSerializedSize(schema);
        if (size < 0) goto L8;
        return size;
    L8:
        throw new IllegalStateException("serialized size must be non-negative, was " + size);
    L10:
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) goto L12;
        int size2 = computeSerializedSize(schema);
        setMemoizedSerializedSize(size2);
        return size2;
    L12:
        return getMemoizedSerializedSize();
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    private int computeSerializedSize(Schema<?> nullableSchema) {
        if (nullableSchema != null) goto L6;
        return Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
    L6:
        return nullableSchema.getSerializedSize(this);
    }

    Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    static {
        defaultInstanceMap = new ConcurrentHashMap();
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> r4) {
        GeneratedMessageLite<?, ?> r0 = defaultInstanceMap.get(r4);
        if (r0 == null) goto L16;
    L9:
        if (r0 != null) goto L15;
        r0 = (T) ((GeneratedMessageLite) UnsafeUtil.allocateInstance(r4)).getDefaultInstanceForType();
        if (r0 == null) goto L14;
        defaultInstanceMap.put(r4, r0);
        goto L15
    L14:
        throw new IllegalStateException();
    L15:
        return (T) r0;
    L16:
        Class.forName(r4.getName(), true, r4.getClassLoader());     // Catch: ClassNotFoundException -> L6
        r0 = defaultInstanceMap.get(r4);
    L6:
        e = move-exception;
        throw new IllegalStateException("Class initialization cannot fail.", e);
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> clazz, T defaultInstance) {
        defaultInstance.markImmutable();
        defaultInstanceMap.put(clazz, defaultInstance);
    }

    protected static Object newMessageInfo(MessageLite defaultInstance, String info, Object[] objects) {
        return new RawMessageInfo(defaultInstance, info, objects);
    }

    protected final void mergeUnknownFields(UnknownFieldSetLite unknownFields) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFields);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, Class singularType) {
        return new GeneratedExtension(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, false, false), singularType);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingTypeDefaultInstance, MessageLite messageDefaultInstance, Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, boolean isPacked, Class singularType) {
        return new GeneratedExtension(containingTypeDefaultInstance, Collections.emptyList(), messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, true, isPacked), singularType);
    }

    static Method getMethodOrDie(Class clazz, String name, Class... params) {
        return clazz.getMethod(name, params);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
    }

    static Object invokeOrDie(Method method, Object object, Object... params) {
        return method.invoke(object, params);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable cause = e.getCause();
        if ((cause instanceof RuntimeException) == true) goto L14;
        if ((cause instanceof Error) == false) goto L12;
        throw ((Error) cause);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
    L14:
        throw ((RuntimeException) cause);
    }

    private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extension) {
        if (extension.isLite() == false) goto L7;
        return (GeneratedExtension) extension;
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T r4, boolean shouldMemoize) {
        byte memoizedIsInitialized = ((Byte) r4.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (memoizedIsInitialized != 1) goto L5;
        return true;
    L5:
        if (memoizedIsInitialized != 0) goto L8;
        return false;
    L8:
        boolean isInitialized = Protobuf.getInstance().schemaFor(r4).isInitialized(r4);
        if (shouldMemoize == false) goto L15;
        MethodToInvoke r2 = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
        if (isInitialized == false) goto L13;
        Object r3 = r4;
    L14:
        r4.dynamicMethod(r2, r3);
        goto L15
    L13:
        r3 = null;
    L15:
        return isInitialized;
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.location.protobuf.Internal$IntList] */
    protected static Internal.IntList mutableCopy(Internal.IntList list) {
        int size = list.size();
        if (size != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = size * 2;
        goto L7
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.location.protobuf.Internal$LongList] */
    protected static Internal.LongList mutableCopy(Internal.LongList list) {
        int size = list.size();
        if (size != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = size * 2;
        goto L7
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.location.protobuf.Internal$FloatList] */
    protected static Internal.FloatList mutableCopy(Internal.FloatList list) {
        int size = list.size();
        if (size != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = size * 2;
        goto L7
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.location.protobuf.Internal$DoubleList] */
    protected static Internal.DoubleList mutableCopy(Internal.DoubleList list) {
        int size = list.size();
        if (size != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = size * 2;
        goto L7
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.location.protobuf.Internal$BooleanList] */
    protected static Internal.BooleanList mutableCopy(Internal.BooleanList list) {
        int size = list.size();
        if (size != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = size * 2;
        goto L7
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> list) {
        int size = list.size();
        if (size != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = size * 2;
        goto L7
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r3, CodedInputStream r4, ExtensionRegistryLite r5) throws InvalidProtocolBufferException {
        T r0 = (T) r3.newMutableInstance();
        Schema r1 = Protobuf.getInstance().schemaFor(r0);     // Catch: RuntimeException -> L5 IOException -> L7 UninitializedMessageException -> L9 InvalidProtocolBufferException -> L11
        r1.mergeFrom(r0, CodedInputStreamReader.forCodedInput(r4), r5);     // Catch: RuntimeException -> L5 IOException -> L7 UninitializedMessageException -> L9 InvalidProtocolBufferException -> L11
        r1.makeImmutable(r0);     // Catch: RuntimeException -> L5 IOException -> L7 UninitializedMessageException -> L9 InvalidProtocolBufferException -> L11
        return r0;
    L11:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L30;
        e = new InvalidProtocolBufferException(e);
    L30:
        throw e.setUnfinishedMessage(r0);
    L9:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r0);
    L7:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L23;
        throw ((InvalidProtocolBufferException) e.getCause());
    L23:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r0);
    L5:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == true) goto L16;
        throw e;
    L16:
        throw ((InvalidProtocolBufferException) e.getCause());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r6, byte[] r7, int r8, int r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        T r1 = (T) r6.newMutableInstance();
        Schema r0 = Protobuf.getInstance().schemaFor(r1);     // Catch: IndexOutOfBoundsException -> L15 IOException -> L17 UninitializedMessageException -> L19 InvalidProtocolBufferException -> L21
        goto L24
    L40:
        r0.mergeFrom(r1, r7, r8, r8 + r9, new ArrayDecoders.Registers(r10));     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L11 InvalidProtocolBufferException -> L13
        r0.makeImmutable(r1);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L11 InvalidProtocolBufferException -> L13
        return r1;
    L13:
        e = move-exception;
        InvalidProtocolBufferException r11 = e;
    L34:
        if (r11.getThrownFromInputStream() == false) goto L37;
        r11 = new InvalidProtocolBufferException(r11);
    L37:
        throw r11.setUnfinishedMessage(r1);
    L11:
        e = move-exception;
        UninitializedMessageException r12 = e;
    L32:
        throw r12.asInvalidProtocolBufferException().setUnfinishedMessage(r1);
    L9:
        e = move-exception;
        IOException r13 = e;
    L26:
        if ((r13.getCause() instanceof InvalidProtocolBufferException) == false) goto L30;
        throw ((InvalidProtocolBufferException) r13.getCause());
    L30:
        throw new InvalidProtocolBufferException(r13).setUnfinishedMessage(r1);
    L21:
        e = move-exception;
        r11 = e;
    L19:
        e = move-exception;
        r12 = e;
    L17:
        e = move-exception;
        r13 = e;
    L24:
        throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(r1);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r1, CodedInputStream r2) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T message) throws InvalidProtocolBufferException {
        if (message != null) goto L4;
    L8:
        return message;
    L4:
        if (message.isInitialized() == true) goto L8;
        throw message.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(message);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteBuffer r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(r1, CodedInputStream.newInstance(r2), r3));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteBuffer r2) throws InvalidProtocolBufferException {
        return (T) parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteString r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteString r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r1, r2, r3));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r4, ByteString r5, ExtensionRegistryLite r6) throws InvalidProtocolBufferException {
        CodedInputStream r0 = r5.newCodedInput();
        T r1 = (T) parsePartialFrom(r4, r0, r6);
        r0.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r1;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r1);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r3, byte[] r4) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r3, r4, 0, r4.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r2, byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r2, r3, 0, r3.length, r4));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r2, InputStream r3) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r2, CodedInputStream.newInstance(r3), ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, InputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r1, CodedInputStream.newInstance(r2), r3));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, CodedInputStream r2) throws InvalidProtocolBufferException {
        return (T) parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, CodedInputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r1, r2, r3));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r1, InputStream r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r1, InputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2, r3));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r6, InputStream r7, ExtensionRegistryLite r8) throws InvalidProtocolBufferException {
        int r0 = r7.read();     // Catch: IOException -> L13 InvalidProtocolBufferException -> L15
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        CodedInputStream r2 = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(r7, CodedInputStream.readRawVarint32(r0, r7)));
        T r3 = (T) parsePartialFrom(r6, r2, r8);
        r2.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L10
        return r3;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r3);
    L15:
        e = move-exception;
        if (e.getThrownFromInputStream() == true) goto L22;
        throw e;
    L22:
        throw new InvalidProtocolBufferException(e);
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }
}
