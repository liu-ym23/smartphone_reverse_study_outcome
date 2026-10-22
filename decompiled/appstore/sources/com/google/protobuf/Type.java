package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Type extends GeneratedMessageV3 implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE = null;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static final Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<Field> fields_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private LazyStringList oneofs_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TypeOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> fieldsBuilder_;
        private List<Field> fields_;
        private Object name_;
        private LazyStringList oneofs_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void ensureFieldsIsMutable() {
            if ((this.bitField0_ & 2) == 2) goto L6;
            this.fields_ = new ArrayList(this.fields_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureOneofsIsMutable() {
            if ((this.bitField0_ & 4) == 4) goto L6;
            this.oneofs_ = new LazyStringArrayList(this.oneofs_);
            this.bitField0_ |= 4;
            return;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 8) == 8) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        private RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> getFieldsFieldBuilder() {
            if (this.fieldsBuilder_ != null) goto L10;
            List<Field> r10 = this.fields_;
            if ((this.bitField0_ & 2) != 2) goto L7;
            boolean r11 = true;
        L8:
            this.fieldsBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
            this.fields_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.fieldsBuilder_;
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 8) != 8) goto L7;
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
            getFieldsFieldBuilder();
            getOptionsFieldBuilder();
            return;
        }

        public Builder addAllFields(Iterable<? extends Field> r10) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.fields_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllOneofs(Iterable<String> r10) {
            ensureOneofsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.oneofs_);
            onChanged();
            return this;
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

        public Builder addFields(Field r10) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureFieldsIsMutable();
            this.fields_.add(r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r10);
            goto L9
        }

        public Field.Builder addFieldsBuilder() {
            return (Field.Builder) getFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
        }

        public Builder addOneofs(String r10) {
            if (r10 == null) goto L6;
            ensureOneofsIsMutable();
            this.oneofs_.add(r10);
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder addOneofsBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            ensureOneofsIsMutable();
            this.oneofs_.add(r10);
            onChanged();
            return this;
        L6:
            throw null;
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

        public Builder clearFields() {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Type.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        public Builder clearOneofs() {
            this.oneofs_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
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
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int r10) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L7;
            return this.fields_.get(r10);
        L7:
            return (Field) r11.getMessage(r10);
        }

        public Field.Builder getFieldsBuilder(int r10) {
            return (Field.Builder) getFieldsFieldBuilder().getBuilder(r10);
        }

        public List<Field.Builder> getFieldsBuilderList() {
            return getFieldsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L7;
            return this.fields_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.fields_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public FieldOrBuilder getFieldsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L7;
            return this.fields_.get(r10);
        L7:
            return (FieldOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.fields_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int r10) {
            return this.oneofs_.get(r10);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int r10) {
            return this.oneofs_.getByteString(r10);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return this.oneofs_.size();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public /* bridge */ /* synthetic */ List getOneofsList() {
            return getOneofsList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (OptionOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.valueOf(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
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
            return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
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

        public Builder removeFields(int r10) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.remove(r10);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        public Builder setFields(int r10, Field r11) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureFieldsIsMutable();
            this.fields_.set(r10, r11);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r12.setMessage(r10, r11);
            goto L9
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

        public Builder setOneofs(int r10, String r11) {
            if (r11 == null) goto L6;
            ensureOneofsIsMutable();
            this.oneofs_.set(r10, r11);
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

        @Override // com.google.protobuf.TypeOrBuilder
        public ProtocolStringList getOneofsList() {
            return this.oneofs_.getUnmodifiableView();
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
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.EMPTY;
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
        public Type build() {
            Type r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type buildPartial() {
            Type r10 = new Type(this, null);
            Type.access$302(r10, this.name_);
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 == null) goto L5;
            Type.access$402(r10, r11.build());
        L10:
            if ((this.bitField0_ & 4) != 4) goto L12;
            this.oneofs_ = this.oneofs_.getUnmodifiableView();
            this.bitField0_ &= -5;
        L12:
            Type.access$502(r10, this.oneofs_);
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 == null) goto L15;
            Type.access$602(r10, r12.build());
        L19:
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r13 = this.sourceContextBuilder_;
            if (r13 != null) goto L22;
            Type.access$702(r10, this.sourceContext_);
        L23:
            Type.access$802(r10, this.syntax_);
            Type.access$902(r10, 0);
            onBuilt();
            return r10;
        L22:
            Type.access$702(r10, (SourceContext) r13.build());
            goto L23
        L15:
            if ((this.bitField0_ & 8) != 8) goto L17;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -9;
        L17:
            Type.access$602(r10, this.options_);
            goto L19
        L5:
            if ((this.bitField0_ & 2) != 2) goto L7;
            this.fields_ = Collections.unmodifiableList(this.fields_);
            this.bitField0_ &= -3;
        L7:
            Type.access$402(r10, this.fields_);
            goto L10
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
        public Type getDefaultInstanceForType() {
            return Type.getDefaultInstance();
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

        public Field.Builder addFieldsBuilder(int r10) {
            return (Field.Builder) getFieldsFieldBuilder().addBuilder(r10, Field.getDefaultInstance());
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
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
        L6:
            this.oneofs_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L9;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
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

        public Builder addFields(int r10, Field r11) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureFieldsIsMutable();
            this.fields_.add(r10, r11);
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
            if ((r10 instanceof Type) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Type) r10);
        }

        public Builder setFields(int r10, Field.Builder r11) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.set(r10, r11.build());
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

        public Builder mergeFrom(Type r10) {
            if (r10 != Type.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L8;
            this.name_ = Type.access$300(r10);
            onChanged();
        L8:
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = null;
            if (this.fieldsBuilder_ != null) goto L18;
            if (Type.access$400(r10).isEmpty() == true) goto L28;
            if (this.fields_.isEmpty() == false) goto L15;
            this.fields_ = Type.access$400(r10);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureFieldsIsMutable();
            this.fields_.addAll(Type.access$400(r10));
        L28:
            if (Type.access$500(r10).isEmpty() == true) goto L35;
            if (this.oneofs_.isEmpty() == false) goto L32;
            this.oneofs_ = Type.access$500(r10);
            this.bitField0_ &= -5;
        L33:
            onChanged();
            goto L35
        L32:
            ensureOneofsIsMutable();
            this.oneofs_.addAll(Type.access$500(r10));
        L35:
            if (this.optionsBuilder_ != null) goto L44;
            if (Type.access$600(r10).isEmpty() == true) goto L53;
            if (this.options_.isEmpty() == false) goto L41;
            this.options_ = Type.access$600(r10);
            this.bitField0_ &= -9;
        L42:
            onChanged();
            goto L53
        L41:
            ensureOptionsIsMutable();
            this.options_.addAll(Type.access$600(r10));
        L53:
            if (r10.hasSourceContext() == false) goto L56;
            mergeSourceContext(r10.getSourceContext());
        L56:
            if (Type.access$800(r10) == 0) goto L58;
            setSyntaxValue(r10.getSyntaxValue());
        L58:
            onChanged();
            return this;
        L44:
            if (Type.access$600(r10).isEmpty() == true) goto L53;
            if (this.optionsBuilder_.isEmpty() == false) goto L51;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Type.access$600(r10);
            this.bitField0_ &= -9;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L50;
            r11 = getOptionsFieldBuilder();
        L50:
            this.optionsBuilder_ = r11;
            goto L53
        L51:
            this.optionsBuilder_.addAllMessages(Type.access$600(r10));
            goto L53
        L18:
            if (Type.access$400(r10).isEmpty() == true) goto L28;
            if (this.fieldsBuilder_.isEmpty() == false) goto L26;
            this.fieldsBuilder_.dispose();
            this.fieldsBuilder_ = null;
            this.fields_ = Type.access$400(r10);
            this.bitField0_ &= -3;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r12 = getFieldsFieldBuilder();
        L25:
            this.fieldsBuilder_ = r12;
            goto L28
        L24:
            r12 = null;
            goto L25
        L26:
            this.fieldsBuilder_.addAllMessages(Type.access$400(r10));
            goto L28
        }

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.EMPTY;
            this.options_ = Collections.emptyList();
            this.sourceContext_ = null;
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        public Builder addFields(Field.Builder r10) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r10.build());
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

        public Builder addFields(int r10, Field.Builder r11) {
            RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r10, r11.build());
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
            Type r12 = null;
            Type r13 = (Type) Type.access$1000().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Type r14 = (Type) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    static {
        DEFAULT_INSTANCE = new Type();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Type(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ Parser access$1000() {
        return PARSER;
    }

    public static /* synthetic */ Object access$300(Type r10) {
        return r10.name_;
    }

    public static /* synthetic */ Object access$302(Type r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$400(Type r10) {
        return r10.fields_;
    }

    public static /* synthetic */ List access$402(Type r10, List r11) {
        r10.fields_ = r11;
        return r11;
    }

    public static /* synthetic */ LazyStringList access$500(Type r10) {
        return r10.oneofs_;
    }

    public static /* synthetic */ LazyStringList access$502(Type r10, LazyStringList r11) {
        r10.oneofs_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$600(Type r10) {
        return r10.options_;
    }

    public static /* synthetic */ List access$602(Type r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    public static /* synthetic */ SourceContext access$702(Type r10, SourceContext r11) {
        r10.sourceContext_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$800(Type r10) {
        return r10.syntax_;
    }

    public static /* synthetic */ int access$802(Type r10, int r11) {
        r10.syntax_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$902(Type r10, int r11) {
        r10.bitField0_ = r11;
        return r11;
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Type parseDelimitedFrom(InputStream r10) throws IOException {
        return (Type) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Type parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Type) == false) goto L8;
        Type r11 = (Type) r10;
        if (getName().equals(r11.getName()) == true) goto L12;
    L20:
        boolean r12 = false;
    L22:
        if (hasSourceContext() == false) goto L28;
        if (r12 == true) goto L25;
    L27:
        r12 = false;
        goto L28
    L25:
        if (getSourceContext().equals(r11.getSourceContext()) == false) goto L27;
        r12 = true;
    L28:
        if (r12 == false) goto L33;
        if (this.syntax_ != r11.syntax_) goto L33;
        return true;
    L33:
        return false;
    L12:
        if (getFieldsList().equals(r11.getFieldsList()) == false) goto L20;
        if (getOneofsList().equals(r11.getOneofsList()) == false) goto L20;
        if (getOptionsList().equals(r11.getOptionsList()) == false) goto L20;
        if (hasSourceContext() != r11.hasSourceContext()) goto L20;
        r12 = true;
        goto L22
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int r10) {
        return this.fields_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public FieldOrBuilder getFieldsOrBuilder(int r10) {
        return this.fields_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int r10) {
        return this.oneofs_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int r10) {
        return this.oneofs_.getByteString(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public /* bridge */ /* synthetic */ List getOneofsList() {
        return getOneofsList();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Type> getParserForType() {
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
        if (r13 >= this.fields_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.fields_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
        int r15 = 0;
    L15:
        if (r14 >= this.oneofs_.size()) goto L17;
        r15 = r15 + GeneratedMessageV3.computeStringSizeNoTag(this.oneofs_.getRaw(r14));
        r14 = r14 + 1;
        goto L15
    L17:
        int r16 = (r12 + r15) + getOneofsList().size();
    L19:
        if (r11 >= this.options_.size()) goto L22;
        r16 = r16 + CodedOutputStream.computeMessageSize(4, this.options_.get(r11));
        r11 = r11 + 1;
        goto L19
    L22:
        if (this.sourceContext_ == null) goto L25;
        r16 = r16 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L27;
        r16 = r16 + CodedOutputStream.computeEnumSize(6, this.syntax_);
    L27:
        this.memoizedSize = r16;
        return r16;
    L8:
        r12 = 0;
        goto L9
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.valueOf(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
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
        if (getFieldsCount() <= 0) goto L9;
        r11 = (((r11 * 37) + 2) * 53) + getFieldsList().hashCode();
    L9:
        if (getOneofsCount() <= 0) goto L12;
        r11 = (((r11 * 37) + 3) * 53) + getOneofsList().hashCode();
    L12:
        if (getOptionsCount() <= 0) goto L15;
        r11 = (((r11 * 37) + 4) * 53) + getOptionsList().hashCode();
    L15:
        if (hasSourceContext() == false) goto L17;
        r11 = (((r11 * 37) + 5) * 53) + getSourceContext().hashCode();
    L17:
        int r12 = (((((r11 * 37) + 6) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
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
        if (r12 >= this.fields_.size()) goto L9;
        r10.writeMessage(2, this.fields_.get(r12));
        r12 = r12 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.oneofs_.size()) goto L14;
        GeneratedMessageV3.writeString(r10, 3, this.oneofs_.getRaw(r13));
        r13 = r13 + 1;
    L14:
        if (r11 >= this.options_.size()) goto L17;
        r10.writeMessage(4, this.options_.get(r11));
        r11 = r11 + 1;
        goto L14
    L17:
        if (this.sourceContext_ == null) goto L20;
        r10.writeMessage(5, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L26;
        r10.writeEnum(6, this.syntax_);
        return;
    }

    public /* synthetic */ Type(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Type r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Type parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return newBuilderForType(r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    private Type(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static Type parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Type) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Type parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Type getDefaultInstanceForType() {
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

    public static Type parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Type() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Type parseFrom(InputStream r10) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static Type parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    public static Type parseFrom(CodedInputStream r10) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    public static Type parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    private Type(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
        int r13 = 0;
    L4:
        if (r12 == true) goto L66;
        int r14 = r10.readTag();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if (r14 == 0) goto L21;
        if (r14 != 10) goto L10;
        this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L10:
        if (r14 != 18) goto L12;
        if ((r13 & 2) == 2) goto L47;
        this.fields_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r13 = r13 | 2;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L47:
        this.fields_.add((Field) r10.readMessage(Field.parser(), r11));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L12:
        if (r14 != 26) goto L14;
        String r15 = r10.readStringRequireUtf8();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if ((r13 & 4) == 4) goto L43;
        this.oneofs_ = new LazyStringArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r13 = r13 | 4;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L43:
        this.oneofs_.add(r15);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L14:
        if (r14 != 34) goto L16;
        if ((r13 & 8) == 8) goto L39;
        this.options_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r13 = r13 | 8;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L39:
        this.options_.add((Option) r10.readMessage(Option.parser(), r11));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L16:
        if (r14 != 42) goto L18;
        SourceContext r16 = this.sourceContext_;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if (r16 == null) goto L32;
        SourceContext.Builder r17 = r16.toBuilder();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L33:
        SourceContext r18 = (SourceContext) r10.readMessage(SourceContext.parser(), r11);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        this.sourceContext_ = r18;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if (r17 == null) goto L4;
        r17.mergeFrom(r18);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        this.sourceContext_ = r17.buildPartial();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L32:
        r17 = null;
        goto L33
    L18:
        if (r14 != 48) goto L20;
        this.syntax_ = r10.readEnum();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L20:
        if (r10.skipField(r14) == true) goto L4;
    L21:
        r12 = true;
        goto L4
    L22:
        th = move-exception;
        if ((r13 & 2) != 2) goto L58;
        this.fields_ = Collections.unmodifiableList(this.fields_);
    L58:
        if ((r13 & 4) != 4) goto L61;
        this.oneofs_ = this.oneofs_.getUnmodifiableView();
    L61:
        if ((r13 & 8) != 8) goto L63;
        this.options_ = Collections.unmodifiableList(this.options_);
    L63:
        makeExtensionsImmutable();
        throw th;
    L26:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L22
    L66:
        if ((r13 & 2) != 2) goto L69;
        this.fields_ = Collections.unmodifiableList(this.fields_);
    L69:
        if ((r13 & 4) != 4) goto L72;
        this.oneofs_ = this.oneofs_.getUnmodifiableView();
    L72:
        if ((r13 & 8) != 8) goto L74;
        this.options_ = Collections.unmodifiableList(this.options_);
    L74:
        makeExtensionsImmutable();
    }
}
