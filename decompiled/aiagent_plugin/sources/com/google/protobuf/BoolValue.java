package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class BoolValue extends GeneratedMessage implements BoolValueOrBuilder {
    private static final BoolValue DEFAULT_INSTANCE = null;
    private static final Parser<BoolValue> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private boolean value_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements BoolValueOrBuilder {
        private int bitField0_;
        private boolean value_;

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, Builder.class);
        }

        private Builder() {
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.value_ = false;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BoolValue getDefaultInstanceForType() {
            return BoolValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BoolValue build() {
            BoolValue r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BoolValue buildPartial() {
            BoolValue r0 = new BoolValue(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        private void buildPartial0(BoolValue r2) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            BoolValue.access$302(r2, this.value_);
            return;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, BoolValue.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((BoolValue) ZeusTransformUtils.preCheckCast(r4, BoolValue.class, "com.obric.aiagent.plugin"));
        }

        public Builder mergeFrom(BoolValue r2) {
            if (r2 != BoolValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.getValue() == false) goto L8;
            setValue(r2.getValue());
        L8:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L21;
            int r1 = r5.readTag();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            if (r1 == 0) goto L13;
            if (r1 != 8) goto L9;
            this.value_ = r5.readBool();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            goto L3
        L9:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L13:
            r0 = true;
            goto L3
        L16:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            onChanged();
            throw th;
        L21:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.BoolValueOrBuilder
        public boolean getValue() {
            return this.value_;
        }

        public Builder setValue(boolean r1) {
            this.value_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -2;
            this.value_ = false;
            onChanged();
            return this;
        }
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
        return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    /* synthetic */ BoolValue(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ boolean access$302(BoolValue r0, boolean r1) {
        r0.value_ = r1;
        return r1;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", BoolValue.class.getName());
        DEFAULT_INSTANCE = new BoolValue();
        PARSER = new AnonymousClass1();
    }

    private BoolValue(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.value_ = false;
        this.memoizedIsInitialized = -1;
    }

    private BoolValue() {
        this.value_ = false;
        this.memoizedIsInitialized = -1;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, Builder.class);
    }

    @Override // com.google.protobuf.BoolValueOrBuilder
    public boolean getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r3) {
        boolean r0 = this.value_;
        if (r0 == false) goto L5;
        r3.writeBool(1, r0);
    L5:
        getUnknownFields().writeTo(r3);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        boolean r2 = this.value_;
        if (r2 == false) goto L8;
        r1 = 0 + CodedOutputStream.computeBoolSize(1, r2);
    L8:
        int r3 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r3;
        return r3;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BoolValue.class) == false) goto L8;
        BoolValue r6 = (BoolValue) ZeusTransformUtils.preCheckCast(r5, BoolValue.class, "com.obric.aiagent.plugin");
        if (getValue() == r6.getValue()) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getValue())) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r0;
        return r0;
    L5:
        return this.memoizedHashCode;
    }

    public static BoolValue parseFrom(ByteBuffer r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(ByteString r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(byte[] r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(InputStream r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseDelimitedFrom(InputStream r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(CodedInputStream r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    public static BoolValue parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (BoolValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), BoolValue.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BoolValue r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"), null);
    }

    public static BoolValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static BoolValue of(boolean r1) {
        return newBuilder().setValue(r1).build();
    }

    public static Parser<BoolValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BoolValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public BoolValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
