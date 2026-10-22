package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Option extends GeneratedMessage implements OptionOrBuilder {
    private static final Option DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser<Option> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private Any value_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements OptionOrBuilder {
        private int bitField0_;
        private Object name_;
        private SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> valueBuilder_;
        private Any value_;

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
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L6;
            internalGetValueFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r1 = this.valueBuilder_;
            if (r1 == null) goto L5;
            r1.dispose();
            this.valueBuilder_ = null;
        L5:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Option getDefaultInstanceForType() {
            return Option.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Option build() {
            Option r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Option buildPartial() {
            Option r0 = new Option(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        private void buildPartial0(Option r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            Option.access$302(r3, this.name_);
        L5:
            int r1 = 0;
            if ((r0 & 2) == 0) goto L12;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r2 = this.valueBuilder_;
            if (r2 != null) goto L10;
            Any r4 = this.value_;
        L11:
            Option.access$402(r3, r4);
            r1 = 1;
            goto L12
        L10:
            r4 = (Any) ZeusTransformUtils.preCheckCast(r2.build(), Any.class, "com.obric.aiagent.plugin");
        L12:
            Option.access$576(r3, r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Option.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Option) ZeusTransformUtils.preCheckCast(r4, Option.class, "com.obric.aiagent.plugin"));
        }

        public Builder mergeFrom(Option r2) {
            if (r2 != Option.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.getName().isEmpty() == true) goto L9;
            this.name_ = Option.access$300(r2);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r2.hasValue() == false) goto L11;
            mergeValue(r2.getValue());
        L11:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L24;
            int r1 = r5.readTag();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r1 == 0) goto L16;
            if (r1 != 10) goto L9;
            this.name_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (r1 != 18) goto L11;
            r5.readMessage(internalGetValueFieldBuilder().getBuilder(), r6);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L11:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L16:
            r0 = true;
            goto L3
        L19:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            onChanged();
            throw th;
        L24:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public ByteString getNameBytes() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
            this.name_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
        }

        public Builder setName(String r1) {
            Objects.requireNonNull(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Option.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public boolean hasValue() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public Any getValue() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r0 = this.valueBuilder_;
            if (r0 != null) goto L9;
            Any r2 = this.value_;
            if (r2 == null) goto L7;
            return r2;
        L7:
            return Any.getDefaultInstance();
        L9:
            return (Any) ZeusTransformUtils.preCheckCast(r0.getMessage(), Any.class, "com.obric.aiagent.plugin");
        }

        public Builder setValue(Any r2) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r0 = this.valueBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            this.value_ = r2;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r0.setMessage(r2);
            goto L6
        }

        public Builder setValue(Any.Builder r2) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r0 = this.valueBuilder_;
            if (r0 != null) goto L5;
            this.value_ = r2.build();
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r0.setMessage(r2.build());
            goto L6
        }

        public Builder mergeValue(Any r3) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r0 = this.valueBuilder_;
            if (r0 == null) goto L5;
            r0.mergeFrom(r3);
        L14:
            if (this.value_ == null) goto L16;
            this.bitField0_ |= 2;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            Any r1 = this.value_;
            if (r1 == null) goto L11;
            if (r1 == Any.getDefaultInstance()) goto L11;
            getValueBuilder().mergeFrom(r3);
        L11:
            this.value_ = r3;
            goto L14
        }

        public Builder clearValue() {
            this.bitField0_ &= -3;
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r1 = this.valueBuilder_;
            if (r1 == null) goto L5;
            r1.dispose();
            this.valueBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Any.Builder getValueBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Any.Builder) ZeusTransformUtils.preCheckCast(internalGetValueFieldBuilder().getBuilder(), Any.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public AnyOrBuilder getValueOrBuilder() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r0 = this.valueBuilder_;
            if (r0 != null) goto L5;
            Any r2 = this.value_;
            if (r2 == null) goto L9;
            return r2;
        L9:
            return Any.getDefaultInstance();
        L5:
            return (AnyOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(), AnyOrBuilder.class, "com.obric.aiagent.plugin");
        }

        private SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> internalGetValueFieldBuilder() {
            if (this.valueBuilder_ != null) goto L6;
            this.valueBuilder_ = new SingleFieldBuilder(getValue(), getParentForChildren(), isClean());
            this.value_ = null;
        L6:
            return this.valueBuilder_;
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

    /* synthetic */ Option(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Object access$300(Option r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$302(Option r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ Any access$402(Option r0, Any r1) {
        r0.value_ = r1;
        return r1;
    }

    static /* synthetic */ int access$576(Option r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Option.class.getName());
        DEFAULT_INSTANCE = new Option();
        PARSER = new AnonymousClass1();
    }

    private Option(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.name_ = "";
        this.memoizedIsInitialized = -1;
    }

    private Option() {
        this.name_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public boolean hasValue() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public Any getValue() {
        Any r0 = this.value_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Any.getDefaultInstance();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public AnyOrBuilder getValueOrBuilder() {
        Any r0 = this.value_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Any.getDefaultInstance();
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
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L6;
        GeneratedMessage.writeString(r3, 1, this.name_);
    L6:
        if ((this.bitField0_ & 1) == 0) goto L8;
        r3.writeMessage(2, getValue());
    L8:
        getUnknownFields().writeTo(r3);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L9;
        r1 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
    L9:
        if ((this.bitField0_ & 1) == 0) goto L11;
        r1 = r1 + CodedOutputStream.computeMessageSize(2, getValue());
    L11:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Option.class) == false) goto L8;
        Option r6 = (Option) ZeusTransformUtils.preCheckCast(r5, Option.class, "com.obric.aiagent.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (hasValue() == r6.hasValue()) goto L16;
        return false;
    L16:
        if (hasValue() == false) goto L21;
        if (getValue().equals(r6.getValue()) == true) goto L21;
        return false;
    L21:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L23;
        return false;
    L23:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasValue() == false) goto L9;
        r0 = (((r0 * 37) + 2) * 53) + getValue().hashCode();
    L9:
        int r1 = (r0 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    public static Option parseFrom(ByteBuffer r2) {
        return (Option) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Option) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(ByteString r2) {
        return (Option) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Option) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(byte[] r2) {
        return (Option) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Option) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(InputStream r2) {
        return (Option) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Option) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseDelimitedFrom(InputStream r2) {
        return (Option) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Option) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(CodedInputStream r2) {
        return (Option) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Option.class, "com.obric.aiagent.plugin");
    }

    public static Option parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Option) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Option.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Option r1) {
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

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Option> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Option> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
