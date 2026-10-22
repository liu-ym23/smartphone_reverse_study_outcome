package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Field extends GeneratedMessageV3 implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static final Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cardinality_;
    private volatile Object defaultValue_;
    private volatile Object jsonName_;
    private int kind_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private int oneofIndex_;
    private List<Option> options_;
    private boolean packed_;
    private volatile Object typeUrl_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldOrBuilder {
        private int bitField0_;
        private int cardinality_;
        private Object defaultValue_;
        private Object jsonName_;
        private int kind_;
        private Object name_;
        private int number_;
        private int oneofIndex_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private boolean packed_;
        private Object typeUrl_;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 128) == 128) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 128;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 128) != 128) goto L7;
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

        public Builder clearCardinality() {
            this.cardinality_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDefaultValue() {
            this.defaultValue_ = Field.getDefaultInstance().getDefaultValue();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        public Builder clearJsonName() {
            this.jsonName_ = Field.getDefaultInstance().getJsonName();
            onChanged();
            return this;
        }

        public Builder clearKind() {
            this.kind_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Field.getDefaultInstance().getName();
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

        public Builder clearOneofIndex() {
            this.oneofIndex_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearPacked() {
            this.packed_ = false;
            onChanged();
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            Cardinality r10 = Cardinality.valueOf(this.cardinality_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Cardinality.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return this.cardinality_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            Object r10 = this.defaultValue_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.defaultValue_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            Object r10 = this.defaultValue_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.defaultValue_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            Object r10 = this.jsonName_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.jsonName_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            Object r10 = this.jsonName_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.jsonName_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            Kind r10 = Kind.valueOf(this.kind_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Kind.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
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

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (OptionOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            Object r10 = this.typeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.typeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r10 = this.typeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.typeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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

        public Builder setCardinality(Cardinality r10) {
            if (r10 == null) goto L6;
            this.cardinality_ = r10.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCardinalityValue(int r10) {
            this.cardinality_ = r10;
            onChanged();
            return this;
        }

        public Builder setDefaultValue(String r10) {
            if (r10 == null) goto L6;
            this.defaultValue_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDefaultValueBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.defaultValue_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        public Builder setJsonName(String r10) {
            if (r10 == null) goto L6;
            this.jsonName_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setJsonNameBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.jsonName_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setKind(Kind r10) {
            if (r10 == null) goto L6;
            this.kind_ = r10.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setKindValue(int r10) {
            this.kind_ = r10;
            onChanged();
            return this;
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

        public Builder setOneofIndex(int r10) {
            this.oneofIndex_ = r10;
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

        public Builder setPacked(boolean r10) {
            this.packed_ = r10;
            onChanged();
            return this;
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
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field build() {
            Field r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field buildPartial() {
            Field r10 = new Field(this, null);
            Field.access$302(r10, this.kind_);
            Field.access$402(r10, this.cardinality_);
            Field.access$502(r10, this.number_);
            Field.access$602(r10, this.name_);
            Field.access$702(r10, this.typeUrl_);
            Field.access$802(r10, this.oneofIndex_);
            Field.access$902(r10, this.packed_);
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 == null) goto L5;
            Field.access$1002(r10, r11.build());
        L9:
            Field.access$1102(r10, this.jsonName_);
            Field.access$1202(r10, this.defaultValue_);
            Field.access$1302(r10, 0);
            onBuilt();
            return r10;
        L5:
            if ((this.bitField0_ & 128) != 128) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -129;
        L7:
            Field.access$1002(r10, this.options_);
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
        public Field getDefaultInstanceForType() {
            return Field.getDefaultInstance();
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
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
        L6:
            this.jsonName_ = "";
            this.defaultValue_ = "";
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
            if ((r10 instanceof Field) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Field) r10);
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

        public Builder mergeFrom(Field r10) {
            if (r10 != Field.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (Field.access$300(r10) == 0) goto L9;
            setKindValue(r10.getKindValue());
        L9:
            if (Field.access$400(r10) == 0) goto L12;
            setCardinalityValue(r10.getCardinalityValue());
        L12:
            if (r10.getNumber() == 0) goto L15;
            setNumber(r10.getNumber());
        L15:
            if (r10.getName().isEmpty() == true) goto L18;
            this.name_ = Field.access$600(r10);
            onChanged();
        L18:
            if (r10.getTypeUrl().isEmpty() == true) goto L21;
            this.typeUrl_ = Field.access$700(r10);
            onChanged();
        L21:
            if (r10.getOneofIndex() == 0) goto L24;
            setOneofIndex(r10.getOneofIndex());
        L24:
            if (r10.getPacked() == false) goto L27;
            setPacked(r10.getPacked());
        L27:
            if (this.optionsBuilder_ != null) goto L36;
            if (Field.access$1000(r10).isEmpty() == true) goto L45;
            if (this.options_.isEmpty() == false) goto L33;
            this.options_ = Field.access$1000(r10);
            this.bitField0_ &= -129;
        L34:
            onChanged();
            goto L45
        L33:
            ensureOptionsIsMutable();
            this.options_.addAll(Field.access$1000(r10));
        L45:
            if (r10.getJsonName().isEmpty() == true) goto L48;
            this.jsonName_ = Field.access$1100(r10);
            onChanged();
        L48:
            if (r10.getDefaultValue().isEmpty() == true) goto L50;
            this.defaultValue_ = Field.access$1200(r10);
            onChanged();
        L50:
            onChanged();
            return this;
        L36:
            if (Field.access$1000(r10).isEmpty() == true) goto L45;
            if (this.optionsBuilder_.isEmpty() == false) goto L43;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = null;
            this.optionsBuilder_ = null;
            this.options_ = Field.access$1000(r10);
            this.bitField0_ &= -129;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L42;
            r11 = getOptionsFieldBuilder();
        L42:
            this.optionsBuilder_ = r11;
            goto L45
        L43:
            this.optionsBuilder_.addAllMessages(Field.access$1000(r10));
            goto L45
        }

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
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
            Field r12 = null;
            Field r13 = (Field) Field.access$1400().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Field r14 = (Field) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    public static final enum Cardinality extends java.lang.Enum<Cardinality> implements ProtocolMessageEnum {
        private static final /* synthetic */ Cardinality[] $VALUES = null;
        public static final Cardinality CARDINALITY_OPTIONAL = null;
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final Cardinality CARDINALITY_REPEATED = null;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final Cardinality CARDINALITY_REQUIRED = null;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final Cardinality CARDINALITY_UNKNOWN = null;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        public static final Cardinality UNRECOGNIZED = null;
        private static final Cardinality[] VALUES = null;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = null;
        private final int value;

        static {
            Cardinality r10 = new Cardinality("CARDINALITY_UNKNOWN", 0, 0);
            CARDINALITY_UNKNOWN = r10;
            Cardinality r11 = new Cardinality("CARDINALITY_OPTIONAL", 1, 1);
            CARDINALITY_OPTIONAL = r11;
            Cardinality r12 = new Cardinality("CARDINALITY_REQUIRED", 2, 2);
            CARDINALITY_REQUIRED = r12;
            Cardinality r13 = new Cardinality("CARDINALITY_REPEATED", 3, 3);
            CARDINALITY_REPEATED = r13;
            Cardinality r14 = new Cardinality("UNRECOGNIZED", 4, -1);
            UNRECOGNIZED = r14;
            $VALUES = new Cardinality[]{r10, r11, r12, r13, r14};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        private Cardinality(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Cardinality forNumber(int r10) {
            if (r10 == 0) goto L18;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L12;
            return null;
        L12:
            return CARDINALITY_REPEATED;
        L14:
            return CARDINALITY_REQUIRED;
        L16:
            return CARDINALITY_OPTIONAL;
        L18:
            return CARDINALITY_UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return Field.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public static Cardinality valueOf(String r10) {
            return (Cardinality) java.lang.Enum.valueOf(Cardinality.class, r10);
        }

        public static Cardinality[] values() {
            return (Cardinality[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static Cardinality valueOf(int r10) {
            return forNumber(r10);
        }

        public static Cardinality valueOf(Descriptors.EnumValueDescriptor r10) {
            if (r10.getType() != getDescriptor()) goto L11;
            if (r10.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r10.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    public static final enum Kind extends java.lang.Enum<Kind> implements ProtocolMessageEnum {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind TYPE_BOOL = null;
        public static final int TYPE_BOOL_VALUE = 8;
        public static final Kind TYPE_BYTES = null;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final Kind TYPE_DOUBLE = null;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final Kind TYPE_ENUM = null;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final Kind TYPE_FIXED32 = null;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final Kind TYPE_FIXED64 = null;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final Kind TYPE_FLOAT = null;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final Kind TYPE_GROUP = null;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final Kind TYPE_INT32 = null;
        public static final int TYPE_INT32_VALUE = 5;
        public static final Kind TYPE_INT64 = null;
        public static final int TYPE_INT64_VALUE = 3;
        public static final Kind TYPE_MESSAGE = null;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final Kind TYPE_SFIXED32 = null;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final Kind TYPE_SFIXED64 = null;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final Kind TYPE_SINT32 = null;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final Kind TYPE_SINT64 = null;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final Kind TYPE_STRING = null;
        public static final int TYPE_STRING_VALUE = 9;
        public static final Kind TYPE_UINT32 = null;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final Kind TYPE_UINT64 = null;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final Kind TYPE_UNKNOWN = null;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        public static final Kind UNRECOGNIZED = null;
        private static final Kind[] VALUES = null;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = null;
        private final int value;

        static {
            Kind r10 = new Kind("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r10;
            Kind r11 = new Kind("TYPE_DOUBLE", 1, 1);
            TYPE_DOUBLE = r11;
            Kind r12 = new Kind("TYPE_FLOAT", 2, 2);
            TYPE_FLOAT = r12;
            Kind r13 = new Kind("TYPE_INT64", 3, 3);
            TYPE_INT64 = r13;
            Kind r14 = new Kind("TYPE_UINT64", 4, 4);
            TYPE_UINT64 = r14;
            Kind r15 = new Kind("TYPE_INT32", 5, 5);
            TYPE_INT32 = r15;
            Kind r16 = new Kind("TYPE_FIXED64", 6, 6);
            TYPE_FIXED64 = r16;
            Kind r17 = new Kind("TYPE_FIXED32", 7, 7);
            TYPE_FIXED32 = r17;
            Kind r18 = new Kind("TYPE_BOOL", 8, 8);
            TYPE_BOOL = r18;
            Kind r19 = new Kind("TYPE_STRING", 9, 9);
            TYPE_STRING = r19;
            Kind r110 = new Kind("TYPE_GROUP", 10, 10);
            TYPE_GROUP = r110;
            Kind r111 = new Kind("TYPE_MESSAGE", 11, 11);
            TYPE_MESSAGE = r111;
            Kind r112 = new Kind("TYPE_BYTES", 12, 12);
            TYPE_BYTES = r112;
            Kind r113 = new Kind("TYPE_UINT32", 13, 13);
            TYPE_UINT32 = r113;
            Kind r20 = new Kind("TYPE_ENUM", 14, 14);
            TYPE_ENUM = r20;
            Kind r21 = new Kind("TYPE_SFIXED32", 15, 15);
            TYPE_SFIXED32 = r21;
            Kind r22 = new Kind("TYPE_SFIXED64", 16, 16);
            TYPE_SFIXED64 = r22;
            Kind r23 = new Kind("TYPE_SINT32", 17, 17);
            TYPE_SINT32 = r23;
            Kind r24 = new Kind("TYPE_SINT64", 18, 18);
            TYPE_SINT64 = r24;
            Kind r25 = new Kind("UNRECOGNIZED", 19, -1);
            UNRECOGNIZED = r25;
            $VALUES = new Kind[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23, r24, r25};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        private Kind(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Kind forNumber(int r10) {
            switch(r10) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                case 16: goto L10;
                case 17: goto L8;
                case 18: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return TYPE_SINT64;
        L8:
            return TYPE_SINT32;
        L10:
            return TYPE_SFIXED64;
        L12:
            return TYPE_SFIXED32;
        L14:
            return TYPE_ENUM;
        L16:
            return TYPE_UINT32;
        L18:
            return TYPE_BYTES;
        L20:
            return TYPE_MESSAGE;
        L22:
            return TYPE_GROUP;
        L24:
            return TYPE_STRING;
        L26:
            return TYPE_BOOL;
        L28:
            return TYPE_FIXED32;
        L30:
            return TYPE_FIXED64;
        L32:
            return TYPE_INT32;
        L34:
            return TYPE_UINT64;
        L36:
            return TYPE_INT64;
        L38:
            return TYPE_FLOAT;
        L40:
            return TYPE_DOUBLE;
        L42:
            return TYPE_UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return Field.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Kind valueOf(String r10) {
            return (Kind) java.lang.Enum.valueOf(Kind.class, r10);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static Kind valueOf(int r10) {
            return forNumber(r10);
        }

        public static Kind valueOf(Descriptors.EnumValueDescriptor r10) {
            if (r10.getType() != getDescriptor()) goto L11;
            if (r10.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r10.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        DEFAULT_INSTANCE = new Field();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Field(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ List access$1000(Field r10) {
        return r10.options_;
    }

    public static /* synthetic */ List access$1002(Field r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$1100(Field r10) {
        return r10.jsonName_;
    }

    public static /* synthetic */ Object access$1102(Field r10, Object r11) {
        r10.jsonName_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$1200(Field r10) {
        return r10.defaultValue_;
    }

    public static /* synthetic */ Object access$1202(Field r10, Object r11) {
        r10.defaultValue_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$1302(Field r10, int r11) {
        r10.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$1400() {
        return PARSER;
    }

    public static /* synthetic */ int access$300(Field r10) {
        return r10.kind_;
    }

    public static /* synthetic */ int access$302(Field r10, int r11) {
        r10.kind_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$400(Field r10) {
        return r10.cardinality_;
    }

    public static /* synthetic */ int access$402(Field r10, int r11) {
        r10.cardinality_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$502(Field r10, int r11) {
        r10.number_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$600(Field r10) {
        return r10.name_;
    }

    public static /* synthetic */ Object access$602(Field r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$700(Field r10) {
        return r10.typeUrl_;
    }

    public static /* synthetic */ Object access$702(Field r10, Object r11) {
        r10.typeUrl_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$802(Field r10, int r11) {
        r10.oneofIndex_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$902(Field r10, boolean r11) {
        r10.packed_ = r11;
        return r11;
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Field parseDelimitedFrom(InputStream r10) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Field parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Field) == false) goto L8;
        Field r11 = (Field) r10;
        if (this.kind_ == r11.kind_) goto L12;
    L30:
        return false;
    L12:
        if (this.cardinality_ != r11.cardinality_) goto L30;
        if (getNumber() != r11.getNumber()) goto L30;
        if (getName().equals(r11.getName()) == false) goto L30;
        if (getTypeUrl().equals(r11.getTypeUrl()) == false) goto L30;
        if (getOneofIndex() != r11.getOneofIndex()) goto L30;
        if (getPacked() != r11.getPacked()) goto L30;
        if (getOptionsList().equals(r11.getOptionsList()) == false) goto L30;
        if (getJsonName().equals(r11.getJsonName()) == false) goto L30;
        if (getDefaultValue().equals(r11.getDefaultValue()) == false) goto L30;
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality r10 = Cardinality.valueOf(this.cardinality_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Cardinality.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        Object r10 = this.defaultValue_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.defaultValue_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        Object r10 = this.defaultValue_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.defaultValue_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        Object r10 = this.jsonName_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.jsonName_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        Object r10 = this.jsonName_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.jsonName_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind r10 = Kind.valueOf(this.kind_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Kind.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Field> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L8;
        int r12 = CodedOutputStream.computeEnumSize(1, this.kind_);
    L10:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L12;
        r12 = r12 + CodedOutputStream.computeEnumSize(2, this.cardinality_);
    L12:
        int r13 = this.number_;
        if (r13 == 0) goto L16;
        r12 = r12 + CodedOutputStream.computeInt32Size(3, r13);
    L16:
        if (getNameBytes().isEmpty() == true) goto L19;
        r12 = r12 + GeneratedMessageV3.computeStringSize(4, this.name_);
    L19:
        if (getTypeUrlBytes().isEmpty() == true) goto L21;
        r12 = r12 + GeneratedMessageV3.computeStringSize(6, this.typeUrl_);
    L21:
        int r14 = this.oneofIndex_;
        if (r14 == 0) goto L24;
        r12 = r12 + CodedOutputStream.computeInt32Size(7, r14);
    L24:
        boolean r15 = this.packed_;
        if (r15 == false) goto L28;
        r12 = r12 + CodedOutputStream.computeBoolSize(8, r15);
    L28:
        if (r11 >= this.options_.size()) goto L31;
        r12 = r12 + CodedOutputStream.computeMessageSize(9, this.options_.get(r11));
        r11 = r11 + 1;
        goto L28
    L31:
        if (getJsonNameBytes().isEmpty() == true) goto L34;
        r12 = r12 + GeneratedMessageV3.computeStringSize(10, this.jsonName_);
    L34:
        if (getDefaultValueBytes().isEmpty() == true) goto L36;
        r12 = r12 + GeneratedMessageV3.computeStringSize(11, this.defaultValue_);
    L36:
        this.memoizedSize = r12;
        return r12;
    L8:
        r12 = 0;
        goto L10
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        Object r10 = this.typeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.typeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
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

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53) + getNumber()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 6) * 53) + getTypeUrl().hashCode()) * 37) + 7) * 53) + getOneofIndex()) * 37) + 8) * 53) + Internal.hashBoolean(getPacked());
        if (getOptionsCount() <= 0) goto L8;
        r11 = (((r11 * 37) + 9) * 53) + getOptionsList().hashCode();
    L8:
        int r12 = (((((((((r11 * 37) + 10) * 53) + getJsonName().hashCode()) * 37) + 11) * 53) + getDefaultValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L6;
        r10.writeEnum(1, this.kind_);
    L6:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L8;
        r10.writeEnum(2, this.cardinality_);
    L8:
        int r11 = this.number_;
        if (r11 == 0) goto L12;
        r10.writeInt32(3, r11);
    L12:
        if (getNameBytes().isEmpty() == true) goto L15;
        GeneratedMessageV3.writeString(r10, 4, this.name_);
    L15:
        if (getTypeUrlBytes().isEmpty() == true) goto L17;
        GeneratedMessageV3.writeString(r10, 6, this.typeUrl_);
    L17:
        int r12 = this.oneofIndex_;
        if (r12 == 0) goto L20;
        r10.writeInt32(7, r12);
    L20:
        boolean r13 = this.packed_;
        if (r13 == false) goto L23;
        r10.writeBool(8, r13);
    L23:
        int r14 = 0;
    L25:
        if (r14 >= this.options_.size()) goto L28;
        r10.writeMessage(9, this.options_.get(r14));
        r14 = r14 + 1;
        goto L25
    L28:
        if (getJsonNameBytes().isEmpty() == true) goto L31;
        GeneratedMessageV3.writeString(r10, 10, this.jsonName_);
    L31:
        if (getDefaultValueBytes().isEmpty() == true) goto L35;
        GeneratedMessageV3.writeString(r10, 11, this.defaultValue_);
        return;
    }

    public /* synthetic */ Field(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Field r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Field parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

    private Field(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static Field parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Field parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Field getDefaultInstanceForType() {
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

    public static Field parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Field() {
        this.memoizedIsInitialized = -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.options_ = Collections.emptyList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    public static Field parseFrom(InputStream r10) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static Field parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    public static Field parseFrom(CodedInputStream r10) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    public static Field parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    private Field(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
        char r13 = 0;
    L4:
        if (r12 == true) goto L40;
        int r14 = r10.readTag();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        switch(r14) {
            case 0: goto L9;
            case 8: goto L28;
            case 16: goto L27;
            case 24: goto L26;
            case 34: goto L25;
            case 50: goto L24;
            case 56: goto L23;
            case 64: goto L22;
            case 74: goto L19;
            case 82: goto L17;
            case 90: goto L16;
            default: goto L8;
        };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L9:
        r12 = true;
        goto L4
    L16:
        this.defaultValue_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L17:
        this.jsonName_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L19:
        if ((r13 & 128) == 128) goto L21;
        this.options_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r13 = 128;
    L21:
        this.options_.add((Option) r10.readMessage(Option.parser(), r11));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L22:
        this.packed_ = r10.readBool();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L23:
        this.oneofIndex_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L24:
        this.typeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L25:
        this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L26:
        this.number_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L27:
        this.cardinality_ = r10.readEnum();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L28:
        this.kind_ = r10.readEnum();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L8:
        if (r10.skipField(r14) == true) goto L4;
    L10:
        th = move-exception;
        if ((r13 & 128) != 128) goto L37;
        this.options_ = Collections.unmodifiableList(this.options_);
    L37:
        makeExtensionsImmutable();
        throw th;
    L14:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L40:
        if ((r13 & 128) != 128) goto L42;
        this.options_ = Collections.unmodifiableList(this.options_);
    L42:
        makeExtensionsImmutable();
    }
}
