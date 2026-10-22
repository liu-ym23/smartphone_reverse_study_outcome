package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class EnumValue extends GeneratedMessageV3 implements EnumValueOrBuilder {
    private static final EnumValue DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<EnumValue> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private List<Option> options_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumValueOrBuilder {
        private int bitField0_;
        private Object name_;
        private int number_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 4) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 4) != 4) goto L7;
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
            this.name_ = EnumValue.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearNumber() {
            this.number_ = 0;
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
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
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
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
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

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (OptionOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
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

        public Builder setNumber(int r10) {
            this.number_ = r10;
            onChanged();
            return this;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r10) {
            return this;
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
            this.name_ = "";
            this.options_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue build() {
            EnumValue r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue buildPartial() {
            EnumValue r10 = new EnumValue(this, null);
            EnumValue.access$302(r10, this.name_);
            EnumValue.access$402(r10, this.number_);
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 == null) goto L5;
            EnumValue.access$502(r10, r11.build());
        L9:
            EnumValue.access$602(r10, 0);
            onBuilt();
            return r10;
        L5:
            if ((this.bitField0_ & 4) != 4) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L7:
            EnumValue.access$502(r10, this.options_);
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
        public EnumValue getDefaultInstanceForType() {
            return EnumValue.getDefaultInstance();
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
            this.number_ = 0;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
        L6:
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

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.options_ = Collections.emptyList();
            maybeForceBuilderInitialization();
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
            if ((r10 instanceof EnumValue) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((EnumValue) r10);
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

        public Builder mergeFrom(EnumValue r10) {
            if (r10 != EnumValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L9;
            this.name_ = EnumValue.access$300(r10);
            onChanged();
        L9:
            if (r10.getNumber() == 0) goto L12;
            setNumber(r10.getNumber());
        L12:
            if (this.optionsBuilder_ != null) goto L21;
            if (EnumValue.access$500(r10).isEmpty() == false) goto L16;
        L29:
            onChanged();
            return this;
        L16:
            if (this.options_.isEmpty() == false) goto L18;
            this.options_ = EnumValue.access$500(r10);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L29
        L18:
            ensureOptionsIsMutable();
            this.options_.addAll(EnumValue.access$500(r10));
            goto L19
        L21:
            if (EnumValue.access$500(r10).isEmpty() == true) goto L29;
            if (this.optionsBuilder_.isEmpty() == false) goto L28;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = null;
            this.optionsBuilder_ = null;
            this.options_ = EnumValue.access$500(r10);
            this.bitField0_ &= -5;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L27;
            r11 = getOptionsFieldBuilder();
        L27:
            this.optionsBuilder_ = r11;
            goto L29
        L28:
            this.optionsBuilder_.addAllMessages(EnumValue.access$500(r10));
            goto L29
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
            EnumValue r12 = null;
            EnumValue r13 = (EnumValue) EnumValue.access$700().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            EnumValue r14 = (EnumValue) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    static {
        DEFAULT_INSTANCE = new EnumValue();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ EnumValue(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ Object access$300(EnumValue r10) {
        return r10.name_;
    }

    public static /* synthetic */ Object access$302(EnumValue r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$402(EnumValue r10, int r11) {
        r10.number_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$500(EnumValue r10) {
        return r10.options_;
    }

    public static /* synthetic */ List access$502(EnumValue r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$602(EnumValue r10, int r11) {
        r10.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$700() {
        return PARSER;
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static EnumValue parseDelimitedFrom(InputStream r10) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static EnumValue parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<EnumValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof EnumValue) == false) goto L8;
        EnumValue r11 = (EnumValue) r10;
        if (getName().equals(r11.getName()) == true) goto L12;
    L16:
        return false;
    L12:
        if (getNumber() != r11.getNumber()) goto L16;
        if (getOptionsList().equals(r11.getOptionsList()) == false) goto L16;
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EnumValue> getParserForType() {
        return PARSER;
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
    L9:
        int r13 = this.number_;
        if (r13 == 0) goto L13;
        r12 = r12 + CodedOutputStream.computeInt32Size(2, r13);
    L13:
        if (r11 >= this.options_.size()) goto L15;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.options_.get(r11));
        r11 = r11 + 1;
        goto L13
    L15:
        this.memoizedSize = r12;
        return r12;
    L8:
        r12 = 0;
        goto L9
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
        int r11 = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getNumber();
        if (getOptionsCount() <= 0) goto L8;
        r11 = (((r11 * 37) + 3) * 53) + getOptionsList().hashCode();
    L8:
        int r12 = (r11 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
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
        if (getNameBytes().isEmpty() == true) goto L5;
        GeneratedMessageV3.writeString(r10, 1, this.name_);
    L5:
        int r11 = this.number_;
        if (r11 == 0) goto L8;
        r10.writeInt32(2, r11);
    L8:
        int r12 = 0;
    L10:
        if (r12 >= this.options_.size()) goto L12;
        r10.writeMessage(3, this.options_.get(r12));
        r12 = r12 + 1;
        goto L10
    }

    public /* synthetic */ EnumValue(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(EnumValue r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static EnumValue parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

    private EnumValue(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static EnumValue parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static EnumValue parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EnumValue getDefaultInstanceForType() {
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

    public static EnumValue parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private EnumValue() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.number_ = 0;
        this.options_ = Collections.emptyList();
    }

    public static EnumValue parseFrom(InputStream r10) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static EnumValue parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    public static EnumValue parseFrom(CodedInputStream r10) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    private EnumValue(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
        char r13 = 0;
    L4:
        if (r12 == true) goto L39;
        int r14 = r10.readTag();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        if (r14 == 0) goto L15;
        if (r14 != 10) goto L10;
        this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L4
    L10:
        if (r14 != 16) goto L12;
        this.number_ = r10.readInt32();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L4
    L12:
        if (r14 != 26) goto L14;
        if ((r13 & 4) == 4) goto L25;
        this.options_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        r13 = 4;
    L25:
        this.options_.add((Option) r10.readMessage(Option.parser(), r11));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L4
    L14:
        if (r10.skipField(r14) == true) goto L4;
    L15:
        r12 = true;
        goto L4
    L16:
        th = move-exception;
        if ((r13 & 4) != 4) goto L36;
        this.options_ = Collections.unmodifiableList(this.options_);
    L36:
        makeExtensionsImmutable();
        throw th;
    L20:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L16
    L18:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L16
    L39:
        if ((r13 & 4) != 4) goto L41;
        this.options_ = Collections.unmodifiableList(this.options_);
    L41:
        makeExtensionsImmutable();
    }

    public static EnumValue parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }
}
