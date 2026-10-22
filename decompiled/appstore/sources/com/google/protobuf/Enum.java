package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Enum extends GeneratedMessageV3 implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE = null;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<EnumValue> enumvalue_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> enumvalueBuilder_;
        private List<EnumValue> enumvalue_;
        private Object name_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void ensureEnumvalueIsMutable() {
            if ((this.bitField0_ & 2) == 2) goto L6;
            this.enumvalue_ = new ArrayList(this.enumvalue_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 4) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        private RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> getEnumvalueFieldBuilder() {
            if (this.enumvalueBuilder_ != null) goto L10;
            List<EnumValue> r10 = this.enumvalue_;
            if ((this.bitField0_ & 2) != 2) goto L7;
            boolean r11 = true;
        L8:
            this.enumvalueBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
            this.enumvalue_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.enumvalueBuilder_;
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

        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> getSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ != null) goto L6;
            this.sourceContextBuilder_ = new SingleFieldBuilderV3(getSourceContext(), getParentForChildren(), isClean());
            this.sourceContext_ = null;
        L6:
            return this.sourceContextBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L6;
            getEnumvalueFieldBuilder();
            getOptionsFieldBuilder();
            return;
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> r10) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.enumvalue_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
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

        public Builder addEnumvalue(EnumValue r10) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r10);
            goto L9
        }

        public EnumValue.Builder addEnumvalueBuilder() {
            return (EnumValue.Builder) getEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
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

        public Builder clearEnumvalue() {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        public Builder clearName() {
            this.name_ = Enum.getDefaultInstance().getName();
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

        public Builder clearSourceContext() {
            if (this.sourceContextBuilder_ != null) goto L5;
            this.sourceContext_ = null;
            onChanged();
        L6:
            return this;
        L5:
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
            goto L6
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
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int r10) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L7;
            return this.enumvalue_.get(r10);
        L7:
            return (EnumValue) r11.getMessage(r10);
        }

        public EnumValue.Builder getEnumvalueBuilder(int r10) {
            return (EnumValue.Builder) getEnumvalueFieldBuilder().getBuilder(r10);
        }

        public List<EnumValue.Builder> getEnumvalueBuilderList() {
            return getEnumvalueFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L7;
            return this.enumvalue_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.enumvalue_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValueOrBuilder getEnumvalueOrBuilder(int r10) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L7;
            return this.enumvalue_.get(r10);
        L7:
            return (EnumValueOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.enumvalue_);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.EnumOrBuilder
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

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (OptionOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L9;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L7;
            return r11;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) r10.getMessage();
        }

        public SourceContext.Builder getSourceContextBuilder() {
            onChanged();
            return (SourceContext.Builder) getSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L5;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L9;
            return r11;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) r10.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.valueOf(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            if (this.sourceContextBuilder_ == null) goto L5;
        L8:
            return true;
        L5:
            if (this.sourceContext_ != null) goto L8;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        public Builder mergeSourceContext(SourceContext r10) {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L9;
            SourceContext r12 = this.sourceContext_;
            if (r12 == null) goto L7;
            this.sourceContext_ = SourceContext.newBuilder(r12).mergeFrom(r10).buildPartial();
        L8:
            onChanged();
        L10:
            return this;
        L7:
            this.sourceContext_ = r10;
            goto L8
        L9:
            r11.mergeFrom(r10);
            goto L10
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r10) {
            return this;
        }

        public Builder removeEnumvalue(int r10) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
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

        public Builder setEnumvalue(int r10, EnumValue r11) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r10, r11);
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

        public Builder setSourceContext(SourceContext r10) {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            this.sourceContext_ = r10;
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r10);
            goto L9
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
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.sourceContext_ = null;
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum build() {
            Enum r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum buildPartial() {
            Enum r10 = new Enum(this, null);
            Enum.access$302(r10, this.name_);
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 == null) goto L5;
            Enum.access$402(r10, r11.build());
        L9:
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 == null) goto L12;
            Enum.access$502(r10, r12.build());
        L16:
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r13 = this.sourceContextBuilder_;
            if (r13 != null) goto L19;
            Enum.access$602(r10, this.sourceContext_);
        L20:
            Enum.access$702(r10, this.syntax_);
            Enum.access$802(r10, 0);
            onBuilt();
            return r10;
        L19:
            Enum.access$602(r10, (SourceContext) r13.build());
            goto L20
        L12:
            if ((this.bitField0_ & 4) != 4) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            Enum.access$502(r10, this.options_);
            goto L16
        L5:
            if ((this.bitField0_ & 2) != 2) goto L7;
            this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            this.bitField0_ &= -3;
        L7:
            Enum.access$402(r10, this.enumvalue_);
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
        public Enum getDefaultInstanceForType() {
            return Enum.getDefaultInstance();
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

        public EnumValue.Builder addEnumvalueBuilder(int r10) {
            return (EnumValue.Builder) getEnumvalueFieldBuilder().addBuilder(r10, EnumValue.getDefaultInstance());
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
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
        L6:
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L9;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
        L11:
            if (this.sourceContextBuilder_ != null) goto L13;
            this.sourceContext_ = null;
        L14:
            this.syntax_ = 0;
            return this;
        L13:
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
            goto L14
        L9:
            r11.clear();
            goto L11
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

        public Builder setSourceContext(SourceContext.Builder r10) {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L5;
            this.sourceContext_ = r10.build();
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r10.build());
            goto L6
        }

        public Builder addEnumvalue(int r10, EnumValue r11) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10, r11);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r12.addMessage(r10, r11);
            goto L9
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
            if ((r10 instanceof Enum) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Enum) r10);
        }

        public Builder setEnumvalue(int r10, EnumValue.Builder r11) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
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
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.sourceContext_ = null;
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(Enum r10) {
            if (r10 != Enum.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L8;
            this.name_ = Enum.access$300(r10);
            onChanged();
        L8:
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = null;
            if (this.enumvalueBuilder_ != null) goto L18;
            if (Enum.access$400(r10).isEmpty() == true) goto L28;
            if (this.enumvalue_.isEmpty() == false) goto L15;
            this.enumvalue_ = Enum.access$400(r10);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureEnumvalueIsMutable();
            this.enumvalue_.addAll(Enum.access$400(r10));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Enum.access$500(r10).isEmpty() == true) goto L46;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Enum.access$500(r10);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L46
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Enum.access$500(r10));
        L46:
            if (r10.hasSourceContext() == false) goto L49;
            mergeSourceContext(r10.getSourceContext());
        L49:
            if (Enum.access$700(r10) == 0) goto L51;
            setSyntaxValue(r10.getSyntaxValue());
        L51:
            onChanged();
            return this;
        L37:
            if (Enum.access$500(r10).isEmpty() == true) goto L46;
            if (this.optionsBuilder_.isEmpty() == false) goto L44;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Enum.access$500(r10);
            this.bitField0_ &= -5;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L43;
            r11 = getOptionsFieldBuilder();
        L43:
            this.optionsBuilder_ = r11;
            goto L46
        L44:
            this.optionsBuilder_.addAllMessages(Enum.access$500(r10));
            goto L46
        L18:
            if (Enum.access$400(r10).isEmpty() == true) goto L28;
            if (this.enumvalueBuilder_.isEmpty() == false) goto L26;
            this.enumvalueBuilder_.dispose();
            this.enumvalueBuilder_ = null;
            this.enumvalue_ = Enum.access$400(r10);
            this.bitField0_ &= -3;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = getEnumvalueFieldBuilder();
        L25:
            this.enumvalueBuilder_ = r12;
            goto L28
        L24:
            r12 = null;
            goto L25
        L26:
            this.enumvalueBuilder_.addAllMessages(Enum.access$400(r10));
            goto L28
        }

        public Builder addEnumvalue(EnumValue.Builder r10) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
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

        public Builder addEnumvalue(int r10, EnumValue.Builder r11) {
            RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
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
            Enum r12 = null;
            Enum r13 = (Enum) Enum.access$900().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Enum r14 = (Enum) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    static {
        DEFAULT_INSTANCE = new Enum();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Enum(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ Object access$300(Enum r10) {
        return r10.name_;
    }

    public static /* synthetic */ Object access$302(Enum r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$400(Enum r10) {
        return r10.enumvalue_;
    }

    public static /* synthetic */ List access$402(Enum r10, List r11) {
        r10.enumvalue_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$500(Enum r10) {
        return r10.options_;
    }

    public static /* synthetic */ List access$502(Enum r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    public static /* synthetic */ SourceContext access$602(Enum r10, SourceContext r11) {
        r10.sourceContext_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$700(Enum r10) {
        return r10.syntax_;
    }

    public static /* synthetic */ int access$702(Enum r10, int r11) {
        r10.syntax_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$802(Enum r10, int r11) {
        r10.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$900() {
        return PARSER;
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Enum parseDelimitedFrom(InputStream r10) throws IOException {
        return (Enum) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Enum parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Enum) == false) goto L8;
        Enum r11 = (Enum) r10;
        if (getName().equals(r11.getName()) == true) goto L12;
    L18:
        boolean r12 = false;
    L20:
        if (hasSourceContext() == false) goto L26;
        if (r12 == true) goto L23;
    L25:
        r12 = false;
        goto L26
    L23:
        if (getSourceContext().equals(r11.getSourceContext()) == false) goto L25;
        r12 = true;
    L26:
        if (r12 == false) goto L31;
        if (this.syntax_ != r11.syntax_) goto L31;
        return true;
    L31:
        return false;
    L12:
        if (getEnumvalueList().equals(r11.getEnumvalueList()) == false) goto L18;
        if (getOptionsList().equals(r11.getOptionsList()) == false) goto L18;
        if (hasSourceContext() != r11.hasSourceContext()) goto L18;
        r12 = true;
        goto L20
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int r10) {
        return this.enumvalue_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValueOrBuilder getEnumvalueOrBuilder(int r10) {
        return this.enumvalue_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Enum> getParserForType() {
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
        int r13 = 0;
    L11:
        if (r13 >= this.enumvalue_.size()) goto L14;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(r13));
        r13 = r13 + 1;
    L14:
        if (r11 >= this.options_.size()) goto L17;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.options_.get(r11));
        r11 = r11 + 1;
        goto L14
    L17:
        if (this.sourceContext_ == null) goto L20;
        r12 = r12 + CodedOutputStream.computeMessageSize(4, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L22;
        r12 = r12 + CodedOutputStream.computeEnumSize(5, this.syntax_);
    L22:
        this.memoizedSize = r12;
        return r12;
    L8:
        r12 = 0;
        goto L9
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.valueOf(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        if (this.sourceContext_ == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getEnumvalueCount() <= 0) goto L9;
        r11 = (((r11 * 37) + 2) * 53) + getEnumvalueList().hashCode();
    L9:
        if (getOptionsCount() <= 0) goto L12;
        r11 = (((r11 * 37) + 3) * 53) + getOptionsList().hashCode();
    L12:
        if (hasSourceContext() == false) goto L14;
        r11 = (((r11 * 37) + 4) * 53) + getSourceContext().hashCode();
    L14:
        int r12 = (((((r11 * 37) + 5) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
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
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r12 >= this.enumvalue_.size()) goto L10;
        r10.writeMessage(2, this.enumvalue_.get(r12));
        r12 = r12 + 1;
    L10:
        if (r11 >= this.options_.size()) goto L13;
        r10.writeMessage(3, this.options_.get(r11));
        r11 = r11 + 1;
        goto L10
    L13:
        if (this.sourceContext_ == null) goto L16;
        r10.writeMessage(4, getSourceContext());
    L16:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L21;
        r10.writeEnum(5, this.syntax_);
        return;
    }

    public /* synthetic */ Enum(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Enum r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Enum parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

    private Enum(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static Enum parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Enum) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Enum parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Enum getDefaultInstanceForType() {
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

    public static Enum parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Enum() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Enum parseFrom(InputStream r10) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static Enum parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    public static Enum parseFrom(CodedInputStream r10) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    private Enum(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
        int r13 = 0;
    L4:
        if (r12 == true) goto L57;
        int r14 = r10.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        if (r14 == 0) goto L19;
        if (r14 != 10) goto L10;
        this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L10:
        if (r14 != 18) goto L12;
        if ((r13 & 2) == 2) goto L41;
        this.enumvalue_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r13 = r13 | 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L41:
        this.enumvalue_.add((EnumValue) r10.readMessage(EnumValue.parser(), r11));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L12:
        if (r14 != 26) goto L14;
        if ((r13 & 4) == 4) goto L37;
        this.options_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r13 = r13 | 4;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L37:
        this.options_.add((Option) r10.readMessage(Option.parser(), r11));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L14:
        if (r14 != 34) goto L16;
        SourceContext r15 = this.sourceContext_;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        if (r15 == null) goto L30;
        SourceContext.Builder r16 = r15.toBuilder();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L31:
        SourceContext r17 = (SourceContext) r10.readMessage(SourceContext.parser(), r11);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        this.sourceContext_ = r17;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        if (r16 == null) goto L4;
        r16.mergeFrom(r17);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        this.sourceContext_ = r16.buildPartial();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L30:
        r16 = null;
        goto L31
    L16:
        if (r14 != 40) goto L18;
        this.syntax_ = r10.readEnum();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L18:
        if (r10.skipField(r14) == true) goto L4;
    L19:
        r12 = true;
        goto L4
    L20:
        th = move-exception;
        if ((r13 & 2) != 2) goto L52;
        this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
    L52:
        if ((r13 & 4) != 4) goto L54;
        this.options_ = Collections.unmodifiableList(this.options_);
    L54:
        makeExtensionsImmutable();
        throw th;
    L24:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
    L22:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L20
    L57:
        if ((r13 & 2) != 2) goto L60;
        this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
    L60:
        if ((r13 & 4) != 4) goto L62;
        this.options_ = Collections.unmodifiableList(this.options_);
    L62:
        makeExtensionsImmutable();
    }

    public static Enum parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }
}
