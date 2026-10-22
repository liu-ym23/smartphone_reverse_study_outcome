package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    protected int memoizedSize;

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo47clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r1) {
            return internalMergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        public Builder() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r1) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearOneof(Descriptors.OneofDescriptor r1) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r0 = getAllFields().entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            clearField((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin"));
            goto L4
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public List<String> findInitializationErrors() {
            return MessageReflection.findMissingFields(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public String getInitializationErrorString() {
            return MessageReflection.delimitWithCommas(findInitializationErrors());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(AbstractMessageLite r3) {
            return (BuilderType) mergeFrom((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        public BuilderType mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            return (BuilderType) mergeFrom(r4, r4.getAllFields());
        }

        BuilderType mergeFrom(Message r6, Map<Descriptors.FieldDescriptor, Object> r7) {
            Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.aiagent.plugin");
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            if (r8.getDescriptorForType() != getDescriptorForType()) goto L23;
            Iterator r10 = r9.entrySet().iterator();
        L6:
            if (r10.hasNext() == false) goto L20;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
            if (r2.isRepeated() == true) goto L9;
            if (r2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            setField(r2, r0.getValue());
            goto L6
        L15:
            Message r3 = (Message) ZeusTransformUtils.preCheckCast(getField(r2), Message.class, "com.obric.aiagent.plugin");
            if (r3 == r3.getDefaultInstanceForType()) goto L17;
            setField(r2, r3.newBuilderForType().mergeFrom(r3).mergeFrom((Message) ZeusTransformUtils.preCheckCast(r0.getValue(), Message.class, "com.obric.aiagent.plugin")).build());
            goto L6
        L17:
            setField(r2, r0.getValue());
            goto L6
        L9:
            Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(r0.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
        L11:
            if (r1.hasNext() == false) goto L6;
            addRepeatedField(r2, r1.next());
            goto L11
        L20:
            mergeUnknownFields(r8.getUnknownFields());
            return this;
        L23:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r2) {
            return (BuilderType) mergeFrom(r2, ExtensionRegistry.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r2, ExtensionRegistryLite r3) {
            if (r2.shouldDiscardUnknownFields() == false) goto L5;
            UnknownFieldSet.Builder r0 = null;
        L6:
            MessageReflection.mergeMessageFrom(this, r0, r2, r3);
            if (r0 == null) goto L9;
            setUnknownFieldSetBuilder(r0);
        L9:
            return this;
        L5:
            r0 = getUnknownFieldSetBuilder();
            goto L6
        }

        public UnknownFieldSet.Builder getUnknownFieldSetBuilder() {
            return UnknownFieldSet.newBuilder(getUnknownFields());
        }

        public void setUnknownFieldSetBuilder(UnknownFieldSet.Builder r1) {
            setUnknownFields(r1.build());
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet r2) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(r2).build());
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r1) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r1, int r2) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        public String toString() {
            if (ProtobufToStringOutput.shouldOutputDebugFormat() == false) goto L5;
            TextFormat.Printer r0 = TextFormat.debugFormatPrinter();
        L7:
            return r0.printToString(this, TextFormat.Printer.FieldReporterLevel.ABSTRACT_BUILDER_TO_STRING);
        L5:
            r0 = TextFormat.printer();
            goto L7
        }

        public static UninitializedMessageException newUninitializedMessageException(Message r2) {
            return new UninitializedMessageException(MessageReflection.findMissingFields((Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.aiagent.plugin")));
        }

        void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r2) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r1, r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r2) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r1, int r2, int r3) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r1, r2, r3), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r1, r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r1, r2, r3, r4), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r2) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (BuilderType) ZeusTransformUtils.preCheckCast(super.mergeFrom(r1, r2), Builder.class, "com.obric.aiagent.plugin");
        }
    }

    protected interface BuilderParent {
        void markDirty();
    }

    public AbstractMessage() {
        this.memoizedSize = -1;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    public Message.Builder newBuilderForType(BuilderParent r2) {
        BuilderParent r1 = (BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, BuilderParent.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public List<String> findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(findInitializationErrors());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r1) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // com.google.protobuf.Message
    public final String toString() {
        if (ProtobufToStringOutput.shouldOutputDebugFormat() == false) goto L5;
        TextFormat.Printer r0 = TextFormat.debugFormatPrinter();
    L7:
        return r0.printToString(this, TextFormat.Printer.FieldReporterLevel.ABSTRACT_TO_STRING);
    L5:
        r0 = TextFormat.printer();
        goto L7
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r3) {
        MessageReflection.writeMessageTo(this, getAllFields(), r3, false);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int r1) {
        this.memoizedSize = r1;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = MessageReflection.getSerializedSize(this, getAllFields());
        this.memoizedSize = r1;
        return r1;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Message.class) == true) goto L8;
        return false;
    L8:
        Message r6 = (Message) ZeusTransformUtils.preCheckCast(r5, Message.class, "com.obric.aiagent.plugin");
        if (getDescriptorForType() == r6.getDescriptorForType()) goto L12;
        return false;
    L12:
        if (compareFields(getAllFields(), r6.getAllFields()) == false) goto L17;
        if (getUnknownFields().equals(r6.getUnknownFields()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public int hashCode() {
        int r0 = this.memoizedHashCode;
        if (r0 != 0) goto L6;
        int r1 = (hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L6:
        return r0;
    }

    private static ByteString toByteString(Object r2) {
        if ((r2 instanceof byte[]) == false) goto L7;
        return ByteString.copyFrom((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.aiagent.plugin"));
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.aiagent.plugin");
    }

    private static boolean compareBytes(Object r2, Object r3) {
        if ((r2 instanceof byte[]) == false) goto L9;
        if ((r3 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.aiagent.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"));
    L9:
        return toByteString(r2).equals(toByteString(r3));
    }

    private static Map convertMapEntryListToMap(List r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r8.isEmpty() == true) goto L5;
        HashMap r0 = new HashMap();
        Iterator r9 = r8.iterator();
        Message r2 = (Message) ZeusTransformUtils.preCheckCast(r9.next(), Message.class, "com.obric.aiagent.plugin");
        Descriptors.Descriptor r3 = r2.getDescriptorForType();
        Descriptors.FieldDescriptor r4 = r3.findFieldByName("key");
        Descriptors.FieldDescriptor r5 = r3.findFieldByName("value");
        Object r6 = r2.getField(r5);
        if (ZeusTransformUtils.instanceOf(r6, Descriptors.EnumValueDescriptor.class) == false) goto L9;
        r6 = Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r6, Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getNumber());
    L9:
        r0.put(r2.getField(r4), r6);
    L11:
        if (r9.hasNext() == false) goto L16;
        Message r10 = (Message) ZeusTransformUtils.preCheckCast(r9.next(), Message.class, "com.obric.aiagent.plugin");
        Object r11 = r10.getField(r5);
        if (ZeusTransformUtils.instanceOf(r11, Descriptors.EnumValueDescriptor.class) == false) goto L15;
        r11 = Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r11, Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getNumber());
    L15:
        r0.put(r10.getField(r4), r11);
        goto L11
    L16:
        return r0;
    L5:
        return Collections.emptyMap();
    }

    private static boolean compareMapField(Object r2, Object r3) {
        return MapFieldLite.equals(convertMapEntryListToMap((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")), convertMapEntryListToMap((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")));
    }

    static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> r8, Map<Descriptors.FieldDescriptor, Object> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        Iterator r0 = r10.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L36;
        Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
        if (r11.containsKey(r2) == false) goto L10;
        Object r4 = r10.get(r2);
        Object r5 = r11.get(r2);
        if (r2.getType() == Descriptors.FieldDescriptor.Type.BYTES) goto L14;
        if (r2.isMapField() == true) goto L31;
        if (r4.equals(r5) == true) goto L7;
        return false;
    L31:
        if (compareMapField(r4, r5) == true) goto L7;
        return false;
    L14:
        if (r2.isRepeated() == true) goto L15;
        if (compareBytes(r4, r5) == true) goto L7;
        return false;
    L15:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        if (r3.size() != r6.size()) goto L17;
        int r7 = 0;
    L20:
        if (r7 >= r3.size()) goto L7;
        if (compareBytes(r3.get(r7), r6.get(r7)) == false) goto L23;
        r7 = r7 + 1;
        goto L20
    L23:
        return false;
    L17:
        return false;
    L10:
        return false;
    L36:
        return true;
    }

    private static int hashMapField(Object r2) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")));
    }

    public static int hashFields(int r5, Map<Descriptors.FieldDescriptor, Object> r6) {
        Iterator r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
        Object r1 = r0.getValue();
        int r8 = (r5 * 37) + r2.getNumber();
        if (r2.isMapField() == false) goto L10;
        int r9 = r8 * 53;
        int r3 = hashMapField(r1);
    L8:
        r5 = r9 + r3;
        goto L4
    L10:
        if (r2.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L13;
        r9 = r8 * 53;
        r3 = r1.hashCode();
        goto L8
    L13:
        if (r2.isRepeated() == false) goto L15;
        r9 = r8 * 53;
        r3 = Internal.hashEnumList((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"));
        goto L8
    L15:
        r9 = r8 * 53;
        r3 = Internal.hashEnum((Internal.EnumLite) ZeusTransformUtils.preCheckCast(r1, Internal.EnumLite.class, "com.obric.aiagent.plugin"));
        goto L8
    L16:
        return r5;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    UninitializedMessageException newUninitializedMessageException() {
        return Builder.newUninitializedMessageException(this);
    }
}
