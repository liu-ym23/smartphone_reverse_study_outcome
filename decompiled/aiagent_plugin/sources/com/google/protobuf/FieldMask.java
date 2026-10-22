package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class FieldMask extends GeneratedMessage implements FieldMaskOrBuilder {
    private static final FieldMask DEFAULT_INSTANCE = null;
    private static final Parser<FieldMask> PARSER = null;
    public static final int PATHS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private LazyStringArrayList paths_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements FieldMaskOrBuilder {
        private int bitField0_;
        private LazyStringArrayList paths_;

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

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public /* bridge */ /* synthetic */ List getPathsList() {
            return getPathsList();
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
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, Builder.class);
        }

        private Builder() {
            this.paths_ = LazyStringArrayList.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
            this.paths_ = LazyStringArrayList.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.paths_ = LazyStringArrayList.emptyList();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FieldMask getDefaultInstanceForType() {
            return FieldMask.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FieldMask build() {
            FieldMask r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FieldMask buildPartial() {
            FieldMask r0 = new FieldMask(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        private void buildPartial0(FieldMask r2) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            this.paths_.makeImmutable();
            FieldMask.access$302(r2, this.paths_);
            return;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, FieldMask.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((FieldMask) ZeusTransformUtils.preCheckCast(r4, FieldMask.class, "com.obric.aiagent.plugin"));
        }

        public Builder mergeFrom(FieldMask r3) {
            if (r3 != FieldMask.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (FieldMask.access$300(r3).isEmpty() == false) goto L8;
        L12:
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        L8:
            if (this.paths_.isEmpty() == false) goto L10;
            this.paths_ = FieldMask.access$300(r3);
            this.bitField0_ |= 1;
        L11:
            onChanged();
            goto L12
        L10:
            ensurePathsIsMutable();
            this.paths_.addAll(FieldMask.access$300(r3));
            goto L11
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L21;
            int r1 = r5.readTag();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            if (r1 == 0) goto L13;
            if (r1 != 10) goto L9;
            String r2 = r5.readStringRequireUtf8();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            ensurePathsIsMutable();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            this.paths_.add(r2);     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            goto L3
        L9:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L13:
            r0 = true;
            goto L3
        L14:
            th = move-exception;
            onChanged();
            throw th;
        L16:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L14
        L21:
            onChanged();
            return this;
        }

        private void ensurePathsIsMutable() {
            if (this.paths_.isModifiable() == true) goto L5;
            this.paths_ = new LazyStringArrayList(this.paths_);
        L5:
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public ProtocolStringList getPathsList() {
            this.paths_.makeImmutable();
            return this.paths_;
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public int getPathsCount() {
            return this.paths_.size();
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public String getPaths(int r1) {
            return this.paths_.get(r1);
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public ByteString getPathsBytes(int r1) {
            return this.paths_.getByteString(r1);
        }

        public Builder setPaths(int r2, String r3) {
            Objects.requireNonNull(r3);
            ensurePathsIsMutable();
            this.paths_.set(r2, r3);
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder addPaths(String r2) {
            Objects.requireNonNull(r2);
            ensurePathsIsMutable();
            this.paths_.add(r2);
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder addAllPaths(Iterable<String> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            ensurePathsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.paths_);
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearPaths() {
            this.paths_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder addPathsBytes(ByteString r2) {
            Objects.requireNonNull(r2);
            AbstractMessageLite.checkByteStringIsUtf8(r2);
            ensurePathsIsMutable();
            this.paths_.add(r2);
            this.bitField0_ |= 1;
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

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public /* bridge */ /* synthetic */ List getPathsList() {
        return getPathsList();
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

    /* synthetic */ FieldMask(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ LazyStringArrayList access$300(FieldMask r0) {
        return r0.paths_;
    }

    static /* synthetic */ LazyStringArrayList access$302(FieldMask r0, LazyStringArrayList r1) {
        r0.paths_ = r1;
        return r1;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", FieldMask.class.getName());
        DEFAULT_INSTANCE = new FieldMask();
        PARSER = new AnonymousClass1();
    }

    private FieldMask(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.paths_ = LazyStringArrayList.emptyList();
        this.memoizedIsInitialized = -1;
    }

    private FieldMask() {
        this.paths_ = LazyStringArrayList.emptyList();
        this.memoizedIsInitialized = -1;
        this.paths_ = LazyStringArrayList.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, Builder.class);
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public ProtocolStringList getPathsList() {
        return this.paths_;
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public int getPathsCount() {
        return this.paths_.size();
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public String getPaths(int r1) {
        return this.paths_.get(r1);
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public ByteString getPathsBytes(int r1) {
        return this.paths_.getByteString(r1);
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
    public void writeTo(CodedOutputStream r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.paths_.size()) goto L6;
        GeneratedMessage.writeString(r4, 1, this.paths_.getRaw(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        getUnknownFields().writeTo(r4);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.paths_.size()) goto L9;
        r2 = r2 + computeStringSizeNoTag(this.paths_.getRaw(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = ((0 + r2) + (getPathsList().size() * 1)) + getUnknownFields().getSerializedSize();
        this.memoizedSize = r3;
        return r3;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, FieldMask.class) == false) goto L8;
        FieldMask r5 = (FieldMask) ZeusTransformUtils.preCheckCast(r4, FieldMask.class, "com.obric.aiagent.plugin");
        if (getPathsList().equals(r5.getPathsList()) == true) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r5.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r4);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = 779 + getDescriptor().hashCode();
        if (getPathsCount() <= 0) goto L9;
        r0 = (((r0 * 37) + 1) * 53) + getPathsList().hashCode();
    L9:
        int r1 = (r0 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    public static FieldMask parseFrom(ByteBuffer r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(ByteString r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(byte[] r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(InputStream r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseDelimitedFrom(InputStream r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(CodedInputStream r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    public static FieldMask parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (FieldMask) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), FieldMask.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FieldMask r1) {
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

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FieldMask> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<FieldMask> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
