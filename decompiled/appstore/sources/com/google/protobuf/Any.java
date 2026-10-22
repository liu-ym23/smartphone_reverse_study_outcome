package com.google.protobuf;

import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class Any extends GeneratedMessageV3 implements AnyOrBuilder {
    private static final Any DEFAULT_INSTANCE = null;
    private static final Parser<Any> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Message cachedUnpackValue;
    private byte memoizedIsInitialized;
    private volatile Object typeUrl_;
    private ByteString value_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnyOrBuilder {
        private Object typeUrl_;
        private ByteString value_;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean r10 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.value_ = Any.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public String getTypeUrl() {
            Object r10 = this.typeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.typeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r10 = this.typeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.typeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r10) {
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        public Builder setTypeUrl(String r10) {
            if (r10 == null) goto L6;
            this.typeUrl_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTypeUrlBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.typeUrl_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r10) {
            return this;
        }

        public Builder setValue(ByteString r10) {
            if (r10 == null) goto L6;
            this.value_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }

        private Builder() {
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any build() {
            Any r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any buildPartial() {
            Any r10 = new Any(this, null);
            Any.access$302(r10, this.typeUrl_);
            Any.access$402(r10, this.value_);
            onBuilt();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r10) {
            return (Builder) super.clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Any getDefaultInstanceForType() {
            return Any.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return (Builder) super.setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return (Builder) super.clearOneof(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Any) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Any) r10);
        }

        public Builder mergeFrom(Any r10) {
            if (r10 != Any.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getTypeUrl().isEmpty() == true) goto L9;
            this.typeUrl_ = Any.access$300(r10);
            onChanged();
        L9:
            if (r10.getValue() == ByteString.EMPTY) goto L11;
            setValue(r10.getValue());
        L11:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            Any r12 = null;
            Any r13 = (Any) Any.access$500().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
            if (r13 == null) goto L6;
            mergeFrom(r13);
        L6:
            return this;
        L7:
            th = th;
        L15:
            if (r12 == null) goto L17;
            mergeFrom(r12);
        L17:
            throw th;
        L9:
            e = move-exception;
            Any r14 = (Any) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    static {
        DEFAULT_INSTANCE = new Any();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Any(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ Object access$300(Any r10) {
        return r10.typeUrl_;
    }

    public static /* synthetic */ Object access$302(Any r10, Object r11) {
        r10.typeUrl_ = r11;
        return r11;
    }

    public static /* synthetic */ ByteString access$402(Any r10, ByteString r11) {
        r10.value_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    private static String getTypeNameFromTypeUrl(String r10) {
        int r11 = r10.lastIndexOf(47);
        if (r11 != (-1)) goto L6;
        return "";
    L6:
        return r10.substring(r11 + 1);
    }

    private static String getTypeUrl(String r10, Descriptors.Descriptor r11) {
        if (r10.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L6;
        return r10 + r11.getFullName();
    L6:
        return r10 + LibrarianImpl.Constants.SEPARATOR + r11.getFullName();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static <T extends Message> Any pack(T r10) {
        return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", r10.getDescriptorForType())).setValue(r10.toByteString()).build();
    }

    public static Any parseDelimitedFrom(InputStream r10) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Any parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Any) == false) goto L8;
        Any r11 = (Any) r10;
        if (getTypeUrl().equals(r11.getTypeUrl()) == true) goto L12;
    L14:
        return false;
    L12:
        if (getValue().equals(r11.getValue()) == false) goto L14;
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if (getTypeUrlBytes().isEmpty() == true) goto L8;
        int r11 = GeneratedMessageV3.computeStringSize(1, this.typeUrl_);
    L10:
        if (this.value_.isEmpty() == true) goto L12;
        r11 = r11 + CodedOutputStream.computeBytesSize(2, this.value_);
    L12:
        this.memoizedSize = r11;
        return r11;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getTypeUrlBytes() {
        Object r10 = this.typeUrl_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.typeUrl_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getTypeUrl().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
    }

    public <T extends Message> boolean is(Class<T> r10) {
        Message r11 = (Message) Internal.getDefaultInstance(r10);
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(r11.getDescriptorForType().getFullName());
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r10 = this.memoizedIsInitialized;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public <T extends Message> T unpack(Class<T> r10) throws InvalidProtocolBufferException {
        if (is(r10) == false) goto L11;
        if (this.cachedUnpackValue != null) goto L7;
        T r11 = (T) ((Message) Internal.getDefaultInstance(r10)).getParserForType().parseFrom(getValue());
        this.cachedUnpackValue = r11;
        return r11;
    L7:
        return (T) this.cachedUnpackValue;
    L11:
        throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) throws IOException {
        if (getTypeUrlBytes().isEmpty() == true) goto L6;
        GeneratedMessageV3.writeString(r10, 1, this.typeUrl_);
    L6:
        if (this.value_.isEmpty() == true) goto L9;
        r10.writeBytes(2, this.value_);
        return;
    }

    public /* synthetic */ Any(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Any r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Any parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return newBuilderForType(r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    private Any(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static Any parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Any parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r10 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r10);
    L6:
        return new Builder(r10).mergeFrom(this);
    }

    public static Any parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public String getTypeUrl() {
        Object r10 = this.typeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.typeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Any() {
        this.memoizedIsInitialized = -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    public static Any parseFrom(InputStream r10) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static <T extends Message> Any pack(T r10, String r11) {
        return newBuilder().setTypeUrl(getTypeUrl(r11, r10.getDescriptorForType())).setValue(r10.toByteString()).build();
    }

    public static Any parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    private Any(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
    L3:
        if (r12 == true) goto L28;
        int r13 = r10.readTag();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        if (r13 == 0) goto L12;
        if (r13 != 10) goto L9;
        this.typeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        goto L3
    L9:
        if (r13 != 18) goto L11;
        this.value_ = r10.readBytes();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        goto L3
    L11:
        if (r10.skipField(r13) == true) goto L3;
    L12:
        r12 = true;
        goto L3
    L13:
        th = move-exception;
        makeExtensionsImmutable();
        throw th;
    L17:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
    L15:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L13
    L28:
        makeExtensionsImmutable();
    }

    public static Any parseFrom(CodedInputStream r10) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    public static Any parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }
}
