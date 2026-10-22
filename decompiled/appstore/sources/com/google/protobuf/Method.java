package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
public final class Method extends GeneratedMessageV3 implements MethodOrBuilder {
    private static final Method DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static final Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private boolean requestStreaming_;
    private volatile Object requestTypeUrl_;
    private boolean responseStreaming_;
    private volatile Object responseTypeUrl_;
    private int syntax_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MethodOrBuilder {
        private int bitField0_;
        private Object name_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private boolean requestStreaming_;
        private Object requestTypeUrl_;
        private boolean responseStreaming_;
        private Object responseTypeUrl_;
        private int syntax_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 32) == 32) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 32;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Method_descriptor;
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 32) != 32) goto L7;
            boolean r11 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.optionsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L6;
            getOptionsFieldBuilder();
            return;
        }

        public Builder addAllOptions(Iterable<? extends Option> r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addOptions(Option r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r10);
            goto L9
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
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

        public Builder clearName() {
            this.name_ = Method.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        public Builder clearOptions() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearRequestStreaming() {
            this.requestStreaming_ = false;
            onChanged();
            return this;
        }

        public Builder clearRequestTypeUrl() {
            this.requestTypeUrl_ = Method.getDefaultInstance().getRequestTypeUrl();
            onChanged();
            return this;
        }

        public Builder clearResponseStreaming() {
            this.responseStreaming_ = false;
            onChanged();
            return this;
        }

        public Builder clearResponseTypeUrl() {
            this.responseTypeUrl_ = Method.getDefaultInstance().getResponseTypeUrl();
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.syntax_ = 0;
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
            return ApiProto.internal_static_google_protobuf_Method_descriptor;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Option getOptions(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (Option) r11.getMessage(r10);
        }

        public Option.Builder getOptionsBuilder(int r10) {
            return (Option.Builder) getOptionsFieldBuilder().getBuilder(r10);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (OptionOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getRequestStreaming() {
            return this.requestStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getRequestTypeUrl() {
            Object r10 = this.requestTypeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.requestTypeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getRequestTypeUrlBytes() {
            Object r10 = this.requestTypeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.requestTypeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getResponseStreaming() {
            return this.responseStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getResponseTypeUrl() {
            Object r10 = this.responseTypeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.responseTypeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getResponseTypeUrlBytes() {
            Object r10 = this.responseTypeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.responseTypeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.valueOf(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
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

        public Builder removeOptions(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        public Builder setName(String r10) {
            if (r10 == null) goto L6;
            this.name_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNameBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.name_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setOptions(int r10, Option r11) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.set(r10, r11);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r12.setMessage(r10, r11);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        public Builder setRequestStreaming(boolean r10) {
            this.requestStreaming_ = r10;
            onChanged();
            return this;
        }

        public Builder setRequestTypeUrl(String r10) {
            if (r10 == null) goto L6;
            this.requestTypeUrl_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRequestTypeUrlBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.requestTypeUrl_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setResponseStreaming(boolean r10) {
            this.responseStreaming_ = r10;
            onChanged();
            return this;
        }

        public Builder setResponseTypeUrl(String r10) {
            if (r10 == null) goto L6;
            this.responseTypeUrl_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setResponseTypeUrlBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.responseTypeUrl_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSyntax(Syntax r10) {
            if (r10 == null) goto L6;
            this.syntax_ = r10.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSyntaxValue(int r10) {
            this.syntax_ = r10;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r10) {
            return this;
        }

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
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
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.responseTypeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Method build() {
            Method r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Method buildPartial() {
            Method r10 = new Method(this, null);
            Method.access$302(r10, this.name_);
            Method.access$402(r10, this.requestTypeUrl_);
            Method.access$502(r10, this.requestStreaming_);
            Method.access$602(r10, this.responseTypeUrl_);
            Method.access$702(r10, this.responseStreaming_);
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 == null) goto L5;
            Method.access$802(r10, r11.build());
        L9:
            Method.access$902(r10, this.syntax_);
            Method.access$1002(r10, 0);
            onBuilt();
            return r10;
        L5:
            if ((this.bitField0_ & 32) != 32) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -33;
        L7:
            Method.access$802(r10, this.options_);
            goto L9
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
        public Method getDefaultInstanceForType() {
            return Method.getDefaultInstance();
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

        public Option.Builder addOptionsBuilder(int r10) {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(r10, Option.getDefaultInstance());
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
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.requestStreaming_ = false;
            this.responseTypeUrl_ = "";
            this.responseStreaming_ = false;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
        L6:
            this.syntax_ = 0;
            return this;
        L5:
            r10.clear();
            goto L6
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

        public Builder addOptions(int r10, Option r11) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r10, r11);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r12.addMessage(r10, r11);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Method) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Method) r10);
        }

        public Builder setOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.responseTypeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(Method r10) {
            if (r10 != Method.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L9;
            this.name_ = Method.access$300(r10);
            onChanged();
        L9:
            if (r10.getRequestTypeUrl().isEmpty() == true) goto L12;
            this.requestTypeUrl_ = Method.access$400(r10);
            onChanged();
        L12:
            if (r10.getRequestStreaming() == false) goto L15;
            setRequestStreaming(r10.getRequestStreaming());
        L15:
            if (r10.getResponseTypeUrl().isEmpty() == true) goto L18;
            this.responseTypeUrl_ = Method.access$600(r10);
            onChanged();
        L18:
            if (r10.getResponseStreaming() == false) goto L21;
            setResponseStreaming(r10.getResponseStreaming());
        L21:
            if (this.optionsBuilder_ != null) goto L30;
            if (Method.access$800(r10).isEmpty() == true) goto L39;
            if (this.options_.isEmpty() == false) goto L27;
            this.options_ = Method.access$800(r10);
            this.bitField0_ &= -33;
        L28:
            onChanged();
            goto L39
        L27:
            ensureOptionsIsMutable();
            this.options_.addAll(Method.access$800(r10));
        L39:
            if (Method.access$900(r10) == 0) goto L41;
            setSyntaxValue(r10.getSyntaxValue());
        L41:
            onChanged();
            return this;
        L30:
            if (Method.access$800(r10).isEmpty() == true) goto L39;
            if (this.optionsBuilder_.isEmpty() == false) goto L37;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = null;
            this.optionsBuilder_ = null;
            this.options_ = Method.access$800(r10);
            this.bitField0_ &= -33;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L36;
            r11 = getOptionsFieldBuilder();
        L36:
            this.optionsBuilder_ = r11;
            goto L39
        L37:
            this.optionsBuilder_.addAllMessages(Method.access$800(r10));
            goto L39
        }

        public Builder addOptions(Option.Builder r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            Method r12 = null;
            Method r13 = (Method) Method.access$1100().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Method r14 = (Method) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    static {
        DEFAULT_INSTANCE = new Method();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Method(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ int access$1002(Method r10, int r11) {
        r10.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$1100() {
        return PARSER;
    }

    public static /* synthetic */ Object access$300(Method r10) {
        return r10.name_;
    }

    public static /* synthetic */ Object access$302(Method r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$400(Method r10) {
        return r10.requestTypeUrl_;
    }

    public static /* synthetic */ Object access$402(Method r10, Object r11) {
        r10.requestTypeUrl_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$502(Method r10, boolean r11) {
        r10.requestStreaming_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$600(Method r10) {
        return r10.responseTypeUrl_;
    }

    public static /* synthetic */ Object access$602(Method r10, Object r11) {
        r10.responseTypeUrl_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$702(Method r10, boolean r11) {
        r10.responseStreaming_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$800(Method r10) {
        return r10.options_;
    }

    public static /* synthetic */ List access$802(Method r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$900(Method r10) {
        return r10.syntax_;
    }

    public static /* synthetic */ int access$902(Method r10, int r11) {
        r10.syntax_ = r11;
        return r11;
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Method parseDelimitedFrom(InputStream r10) throws IOException {
        return (Method) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Method parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Method> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Method) == false) goto L8;
        Method r11 = (Method) r10;
        if (getName().equals(r11.getName()) == true) goto L12;
    L24:
        return false;
    L12:
        if (getRequestTypeUrl().equals(r11.getRequestTypeUrl()) == false) goto L24;
        if (getRequestStreaming() != r11.getRequestStreaming()) goto L24;
        if (getResponseTypeUrl().equals(r11.getResponseTypeUrl()) == false) goto L24;
        if (getResponseStreaming() != r11.getResponseStreaming()) goto L24;
        if (getOptionsList().equals(r11.getOptionsList()) == false) goto L24;
        if (this.syntax_ != r11.syntax_) goto L24;
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Method> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getRequestTypeUrl() {
        Object r10 = this.requestTypeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.requestTypeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getRequestTypeUrlBytes() {
        Object r10 = this.requestTypeUrl_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.requestTypeUrl_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        Object r10 = this.responseTypeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.responseTypeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getResponseTypeUrlBytes() {
        Object r10 = this.responseTypeUrl_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.responseTypeUrl_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (getNameBytes().isEmpty() == true) goto L8;
        int r12 = GeneratedMessageV3.computeStringSize(1, this.name_);
    L10:
        if (getRequestTypeUrlBytes().isEmpty() == true) goto L12;
        r12 = r12 + GeneratedMessageV3.computeStringSize(2, this.requestTypeUrl_);
    L12:
        boolean r13 = this.requestStreaming_;
        if (r13 == false) goto L16;
        r12 = r12 + CodedOutputStream.computeBoolSize(3, r13);
    L16:
        if (getResponseTypeUrlBytes().isEmpty() == true) goto L18;
        r12 = r12 + GeneratedMessageV3.computeStringSize(4, this.responseTypeUrl_);
    L18:
        boolean r14 = this.responseStreaming_;
        if (r14 == false) goto L22;
        r12 = r12 + CodedOutputStream.computeBoolSize(5, r14);
    L22:
        if (r11 >= this.options_.size()) goto L25;
        r12 = r12 + CodedOutputStream.computeMessageSize(6, this.options_.get(r11));
        r11 = r11 + 1;
        goto L22
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L27;
        r12 = r12 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L27:
        this.memoizedSize = r12;
        return r12;
    L8:
        r12 = 0;
        goto L10
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.valueOf(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRequestTypeUrl().hashCode()) * 37) + 3) * 53) + Internal.hashBoolean(getRequestStreaming())) * 37) + 4) * 53) + getResponseTypeUrl().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getResponseStreaming());
        if (getOptionsCount() <= 0) goto L8;
        r11 = (((r11 * 37) + 6) * 53) + getOptionsList().hashCode();
    L8:
        int r12 = (((((r11 * 37) + 7) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
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

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) throws IOException {
        if (getNameBytes().isEmpty() == true) goto L6;
        GeneratedMessageV3.writeString(r10, 1, this.name_);
    L6:
        if (getRequestTypeUrlBytes().isEmpty() == true) goto L8;
        GeneratedMessageV3.writeString(r10, 2, this.requestTypeUrl_);
    L8:
        boolean r11 = this.requestStreaming_;
        if (r11 == false) goto L12;
        r10.writeBool(3, r11);
    L12:
        if (getResponseTypeUrlBytes().isEmpty() == true) goto L14;
        GeneratedMessageV3.writeString(r10, 4, this.responseTypeUrl_);
    L14:
        boolean r12 = this.responseStreaming_;
        if (r12 == false) goto L17;
        r10.writeBool(5, r12);
    L17:
        int r13 = 0;
    L19:
        if (r13 >= this.options_.size()) goto L22;
        r10.writeMessage(6, this.options_.get(r13));
        r13 = r13 + 1;
        goto L19
    L22:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L26;
        r10.writeEnum(7, this.syntax_);
        return;
    }

    public /* synthetic */ Method(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Method r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Method parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

    private Method(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static Method parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Method) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Method parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Method getDefaultInstanceForType() {
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

    public static Method parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Method() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Method parseFrom(InputStream r10) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static Method parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    public static Method parseFrom(CodedInputStream r10) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    public static Method parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    private Method(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
        char r13 = 0;
    L4:
        if (r12 == true) goto L51;
        int r14 = r10.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r14 == 0) goto L23;
        if (r14 != 10) goto L10;
        this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L10:
        if (r14 != 18) goto L12;
        this.requestTypeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L12:
        if (r14 != 24) goto L14;
        this.requestStreaming_ = r10.readBool();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L14:
        if (r14 != 34) goto L16;
        this.responseTypeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L16:
        if (r14 != 40) goto L18;
        this.responseStreaming_ = r10.readBool();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L18:
        if (r14 != 50) goto L20;
        if ((r13 & TokenParser.SP) == 32) goto L34;
        this.options_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r13 = ' ';
    L34:
        this.options_.add((Option) r10.readMessage(Option.parser(), r11));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L20:
        if (r14 != 56) goto L22;
        this.syntax_ = r10.readEnum();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L22:
        if (r10.skipField(r14) == true) goto L4;
    L23:
        r12 = true;
        goto L4
    L24:
        th = move-exception;
        if ((r13 & TokenParser.SP) != 32) goto L48;
        this.options_ = Collections.unmodifiableList(this.options_);
    L48:
        makeExtensionsImmutable();
        throw th;
    L28:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L26:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L51:
        if ((r13 & TokenParser.SP) != 32) goto L53;
        this.options_ = Collections.unmodifiableList(this.options_);
    L53:
        makeExtensionsImmutable();
    }
}
