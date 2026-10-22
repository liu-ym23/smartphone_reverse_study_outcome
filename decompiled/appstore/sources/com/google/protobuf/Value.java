package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class Value extends GeneratedMessageV3 implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = null;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static final Parser<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int kindCase_;
    private Object kind_;
    private byte memoizedIsInitialized;

    /* JADX INFO: renamed from: com.google.protobuf.Value$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Value$KindCase = null;

        static {
            int[] r10 = new int[KindCase.values().length];
            $SwitchMap$com$google$protobuf$Value$KindCase = r10;
            r10[KindCase.NULL_VALUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.NUMBER_VALUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRING_VALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.BOOL_VALUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRUCT_VALUE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.LIST_VALUE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.KIND_NOT_SET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ValueOrBuilder {
        private int kindCase_;
        private Object kind_;
        private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> listValueBuilder_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> structValueBuilder_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> getListValueFieldBuilder() {
            if (this.listValueBuilder_ == null) goto L5;
        L8:
            this.kindCase_ = 6;
            onChanged();
            return this.listValueBuilder_;
        L5:
            if (this.kindCase_ == 6) goto L7;
            this.kind_ = ListValue.getDefaultInstance();
        L7:
            this.listValueBuilder_ = new SingleFieldBuilderV3((ListValue) this.kind_, getParentForChildren(), isClean());
            this.kind_ = null;
            goto L8
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getStructValueFieldBuilder() {
            if (this.structValueBuilder_ == null) goto L5;
        L8:
            this.kindCase_ = 5;
            onChanged();
            return this.structValueBuilder_;
        L5:
            if (this.kindCase_ == 5) goto L7;
            this.kind_ = Struct.getDefaultInstance();
        L7:
            this.structValueBuilder_ = new SingleFieldBuilderV3((Struct) this.kind_, getParentForChildren(), isClean());
            this.kind_ = null;
            goto L8
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

        public Builder clearBoolValue() {
            if (this.kindCase_ != 4) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        public Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        public Builder clearListValue() {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 != null) goto L8;
            if (this.kindCase_ != 6) goto L11;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.kindCase_ != 6) goto L10;
            this.kindCase_ = 0;
            this.kind_ = null;
        L10:
            r10.clear();
            goto L11
        }

        public Builder clearNullValue() {
            if (this.kindCase_ != 1) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearNumberValue() {
            if (this.kindCase_ != 2) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        public Builder clearStringValue() {
            if (this.kindCase_ != 3) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearStructValue() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 != null) goto L8;
            if (this.kindCase_ != 5) goto L11;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.kindCase_ != 5) goto L10;
            this.kindCase_ = 0;
            this.kind_ = null;
        L10:
            r10.clear();
            goto L11
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) goto L5;
            return false;
        L5:
            return ((Boolean) this.kind_).booleanValue();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public KindCase getKindCase() {
            return KindCase.forNumber(this.kindCase_);
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValue getListValue() {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 != null) goto L11;
            if (this.kindCase_ != 6) goto L9;
            return (ListValue) this.kind_;
        L9:
            return ListValue.getDefaultInstance();
        L11:
            if (this.kindCase_ != 6) goto L15;
            return (ListValue) r10.getMessage();
        L15:
            return ListValue.getDefaultInstance();
        }

        public ListValue.Builder getListValueBuilder() {
            return (ListValue.Builder) getListValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValueOrBuilder getListValueOrBuilder() {
            int r10 = this.kindCase_;
            if (r10 != 6) goto L8;
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 == null) goto L8;
            return (ListValueOrBuilder) r11.getMessageOrBuilder();
        L8:
            if (r10 != 6) goto L12;
            return (ListValue) this.kind_;
        L12:
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            if (this.kindCase_ != 1) goto L9;
            NullValue r10 = NullValue.valueOf(((Integer) this.kind_).intValue());
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NullValue.UNRECOGNIZED;
        L9:
            return NullValue.NULL_VALUE;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            if (this.kindCase_ == 1) goto L5;
            return 0;
        L5:
            return ((Integer) this.kind_).intValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public double getNumberValue() {
            if (this.kindCase_ == 2) goto L5;
            return 0.0d;
        L5:
            return ((Double) this.kind_).doubleValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public String getStringValue() {
            if (this.kindCase_ != 3) goto L5;
            Object r10 = this.kind_;
        L7:
            if ((r10 instanceof String) == true) goto L13;
            String r11 = ((ByteString) r10).toStringUtf8();
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r11;
        L11:
            return r11;
        L13:
            return (String) r10;
        L5:
            r10 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            if (this.kindCase_ != 3) goto L5;
            Object r10 = this.kind_;
        L7:
            if ((r10 instanceof String) == false) goto L13;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r11;
        L11:
            return r11;
        L13:
            return (ByteString) r10;
        L5:
            r10 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 != null) goto L11;
            if (this.kindCase_ != 5) goto L9;
            return (Struct) this.kind_;
        L9:
            return Struct.getDefaultInstance();
        L11:
            if (this.kindCase_ != 5) goto L15;
            return (Struct) r10.getMessage();
        L15:
            return Struct.getDefaultInstance();
        }

        public Struct.Builder getStructValueBuilder() {
            return (Struct.Builder) getStructValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public StructOrBuilder getStructValueOrBuilder() {
            int r10 = this.kindCase_;
            if (r10 != 5) goto L8;
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 == null) goto L8;
            return (StructOrBuilder) r11.getMessageOrBuilder();
        L8:
            if (r10 != 5) goto L12;
            return (Struct) this.kind_;
        L12:
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        public Builder mergeListValue(ListValue r10) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 != null) goto L12;
            if (this.kindCase_ == 6) goto L7;
        L9:
            this.kind_ = r10;
        L10:
            onChanged();
        L15:
            this.kindCase_ = 6;
            return this;
        L7:
            if (this.kind_ == ListValue.getDefaultInstance()) goto L9;
            this.kind_ = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(r10).buildPartial();
            goto L10
        L12:
            if (this.kindCase_ != 6) goto L14;
            r11.mergeFrom(r10);
        L14:
            this.listValueBuilder_.setMessage(r10);
            goto L15
        }

        public Builder mergeStructValue(Struct r10) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 != null) goto L12;
            if (this.kindCase_ == 5) goto L7;
        L9:
            this.kind_ = r10;
        L10:
            onChanged();
        L15:
            this.kindCase_ = 5;
            return this;
        L7:
            if (this.kind_ == Struct.getDefaultInstance()) goto L9;
            this.kind_ = Struct.newBuilder((Struct) this.kind_).mergeFrom(r10).buildPartial();
            goto L10
        L12:
            if (this.kindCase_ != 5) goto L14;
            r11.mergeFrom(r10);
        L14:
            this.structValueBuilder_.setMessage(r10);
            goto L15
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r10) {
            return this;
        }

        public Builder setBoolValue(boolean r10) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(r10);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        public Builder setListValue(ListValue r10) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            this.kind_ = r10;
            onChanged();
        L9:
            this.kindCase_ = 6;
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r10);
            goto L9
        }

        public Builder setNullValue(NullValue r10) {
            if (r10 == null) goto L6;
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r10.getNumber());
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNullValueValue(int r10) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r10);
            onChanged();
            return this;
        }

        public Builder setNumberValue(double r10) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(r10);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        public Builder setStringValue(String r10) {
            if (r10 == null) goto L6;
            this.kindCase_ = 3;
            this.kind_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStringValueBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.kindCase_ = 3;
            this.kind_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStructValue(Struct r10) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            this.kind_ = r10;
            onChanged();
        L9:
            this.kindCase_ = 5;
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r10);
            goto L9
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
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value build() {
            Value r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value buildPartial() {
            Value r10 = new Value(this, null);
            if (this.kindCase_ != 1) goto L6;
            Value.access$302(r10, this.kind_);
        L6:
            if (this.kindCase_ != 2) goto L9;
            Value.access$302(r10, this.kind_);
        L9:
            if (this.kindCase_ != 3) goto L12;
            Value.access$302(r10, this.kind_);
        L12:
            if (this.kindCase_ != 4) goto L15;
            Value.access$302(r10, this.kind_);
        L15:
            if (this.kindCase_ != 5) goto L21;
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 != null) goto L19;
            Value.access$302(r10, this.kind_);
            goto L21
        L19:
            Value.access$302(r10, r11.build());
        L21:
            if (this.kindCase_ != 6) goto L26;
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r12 = this.listValueBuilder_;
            if (r12 != null) goto L25;
            Value.access$302(r10, this.kind_);
            goto L26
        L25:
            Value.access$302(r10, r12.build());
        L26:
            Value.access$402(r10, this.kindCase_);
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
        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
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
            this.kindCase_ = 0;
            this.kind_ = null;
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

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Value) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Value) r10);
        }

        public Builder setListValue(ListValue.Builder r10) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 != null) goto L5;
            this.kind_ = r10.build();
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r11.setMessage(r10.build());
            goto L6
        }

        public Builder setStructValue(Struct.Builder r10) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 != null) goto L5;
            this.kind_ = r10.build();
            onChanged();
        L6:
            this.kindCase_ = 5;
            return this;
        L5:
            r11.setMessage(r10.build());
            goto L6
        }

        public Builder mergeFrom(Value r10) {
            if (r10 != Value.getDefaultInstance()) goto L6;
            return this;
        L6:
            switch(AnonymousClass2.$SwitchMap$com$google$protobuf$Value$KindCase[r10.getKindCase().ordinal()]) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                default: goto L14;
            };
        L8:
            mergeListValue(r10.getListValue());
            goto L14
        L9:
            mergeStructValue(r10.getStructValue());
            goto L14
        L10:
            setBoolValue(r10.getBoolValue());
            goto L14
        L11:
            this.kindCase_ = 3;
            this.kind_ = Value.access$300(r10);
            onChanged();
            goto L14
        L12:
            setNumberValue(r10.getNumberValue());
            goto L14
        L13:
            setNullValueValue(r10.getNullValueValue());
        L14:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            Value r12 = null;
            Value r13 = (Value) Value.access$500().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Value r14 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    public static final enum KindCase extends java.lang.Enum<KindCase> implements Internal.EnumLite {
        private static final /* synthetic */ KindCase[] $VALUES = null;
        public static final KindCase BOOL_VALUE = null;
        public static final KindCase KIND_NOT_SET = null;
        public static final KindCase LIST_VALUE = null;
        public static final KindCase NULL_VALUE = null;
        public static final KindCase NUMBER_VALUE = null;
        public static final KindCase STRING_VALUE = null;
        public static final KindCase STRUCT_VALUE = null;
        private final int value;

        static {
            KindCase r10 = new KindCase("NULL_VALUE", 0, 1);
            NULL_VALUE = r10;
            KindCase r11 = new KindCase("NUMBER_VALUE", 1, 2);
            NUMBER_VALUE = r11;
            KindCase r12 = new KindCase("STRING_VALUE", 2, 3);
            STRING_VALUE = r12;
            KindCase r13 = new KindCase("BOOL_VALUE", 3, 4);
            BOOL_VALUE = r13;
            KindCase r14 = new KindCase("STRUCT_VALUE", 4, 5);
            STRUCT_VALUE = r14;
            KindCase r15 = new KindCase("LIST_VALUE", 5, 6);
            LIST_VALUE = r15;
            KindCase r16 = new KindCase("KIND_NOT_SET", 6, 0);
            KIND_NOT_SET = r16;
            $VALUES = new KindCase[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private KindCase(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static KindCase forNumber(int r10) {
            switch(r10) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return LIST_VALUE;
        L8:
            return STRUCT_VALUE;
        L10:
            return BOOL_VALUE;
        L12:
            return STRING_VALUE;
        L14:
            return NUMBER_VALUE;
        L16:
            return NULL_VALUE;
        L18:
            return KIND_NOT_SET;
        }

        public static KindCase valueOf(String r10) {
            return (KindCase) java.lang.Enum.valueOf(KindCase.class, r10);
        }

        public static KindCase[] values() {
            return (KindCase[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static KindCase valueOf(int r10) {
            return forNumber(r10);
        }
    }

    static {
        DEFAULT_INSTANCE = new Value();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Value(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ Object access$300(Value r10) {
        return r10.kind_;
    }

    public static /* synthetic */ Object access$302(Value r10, Object r11) {
        r10.kind_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$402(Value r10, int r11) {
        r10.kindCase_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Value parseDelimitedFrom(InputStream r10) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Value parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        boolean r11 = true;
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Value) == false) goto L8;
        Value r12 = (Value) r10;
        boolean r13 = getKindCase().equals(r12.getKindCase());
        if (r13 == true) goto L13;
        return false;
    L13:
        switch(this.kindCase_) {
            case 1: goto L37;
            case 2: goto L33;
            case 3: goto L29;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L15;
            default: goto L42;
        };
    L15:
        if (r13 == true) goto L17;
    L19:
        r11 = false;
    L41:
        return r11;
    L17:
        if (getListValue().equals(r12.getListValue()) == false) goto L19;
    L21:
        if (r13 == false) goto L19;
        if (getStructValue().equals(r12.getStructValue()) == false) goto L19;
    L25:
        if (r13 == false) goto L19;
        if (getBoolValue() != r12.getBoolValue()) goto L19;
    L29:
        if (r13 == false) goto L19;
        if (getStringValue().equals(r12.getStringValue()) == false) goto L19;
    L33:
        if (r13 == false) goto L19;
        if (Double.doubleToLongBits(getNumberValue()) != Double.doubleToLongBits(r12.getNumberValue())) goto L19;
    L37:
        if (r13 == false) goto L19;
        if (getNullValueValue() != r12.getNullValueValue()) goto L19;
    L42:
        return r13;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) goto L5;
        return false;
    L5:
        return ((Boolean) this.kind_).booleanValue();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValue getListValue() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ != 1) goto L9;
        NullValue r10 = NullValue.valueOf(((Integer) this.kind_).intValue());
        if (r10 == null) goto L7;
        return r10;
    L7:
        return NullValue.UNRECOGNIZED;
    L9:
        return NullValue.NULL_VALUE;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) goto L5;
        return 0;
    L5:
        return ((Integer) this.kind_).intValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) goto L5;
        return 0.0d;
    L5:
        return ((Double) this.kind_).doubleValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if (this.kindCase_ != 1) goto L8;
        int r11 = CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue());
    L10:
        if (this.kindCase_ != 2) goto L13;
        r11 = r11 + CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
    L13:
        if (this.kindCase_ != 3) goto L16;
        r11 = r11 + GeneratedMessageV3.computeStringSize(3, this.kind_);
    L16:
        if (this.kindCase_ != 4) goto L19;
        r11 = r11 + CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
    L19:
        if (this.kindCase_ != 5) goto L22;
        r11 = r11 + CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
    L22:
        if (this.kindCase_ != 6) goto L24;
        r11 = r11 + CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
    L24:
        this.memoizedSize = r11;
        return r11;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        if (this.kindCase_ != 3) goto L5;
        Object r10 = this.kind_;
    L7:
        if ((r10 instanceof String) == true) goto L9;
        String r11 = ((ByteString) r10).toStringUtf8();
        if (this.kindCase_ != 3) goto L13;
        this.kind_ = r11;
    L13:
        return r11;
    L9:
        return (String) r10;
    L5:
        r10 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        if (this.kindCase_ != 3) goto L5;
        Object r10 = this.kind_;
    L7:
        if ((r10 instanceof String) == false) goto L13;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        if (this.kindCase_ != 3) goto L11;
        this.kind_ = r11;
    L11:
        return r11;
    L13:
        return (ByteString) r10;
    L5:
        r10 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public Struct getStructValue() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
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
        int r11 = 779 + getDescriptorForType().hashCode();
        switch(this.kindCase_) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L8;
            default: goto L15;
        };
    L8:
        int r12 = ((r11 * 37) + 6) * 53;
        int r13 = getListValue().hashCode();
    L9:
        r11 = r12 + r13;
        goto L15
    L10:
        r12 = ((r11 * 37) + 5) * 53;
        r13 = getStructValue().hashCode();
        goto L9
    L11:
        r12 = ((r11 * 37) + 4) * 53;
        r13 = Internal.hashBoolean(getBoolValue());
        goto L9
    L12:
        r12 = ((r11 * 37) + 3) * 53;
        r13 = getStringValue().hashCode();
        goto L9
    L13:
        r12 = ((r11 * 37) + 2) * 53;
        r13 = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
        goto L9
    L14:
        r12 = ((r11 * 37) + 1) * 53;
        r13 = getNullValueValue();
    L15:
        int r14 = (r11 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r14;
        return r14;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
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
        if (this.kindCase_ != 1) goto L6;
        r10.writeEnum(1, ((Integer) this.kind_).intValue());
    L6:
        if (this.kindCase_ != 2) goto L9;
        r10.writeDouble(2, ((Double) this.kind_).doubleValue());
    L9:
        if (this.kindCase_ != 3) goto L12;
        GeneratedMessageV3.writeString(r10, 3, this.kind_);
    L12:
        if (this.kindCase_ != 4) goto L15;
        r10.writeBool(4, ((Boolean) this.kind_).booleanValue());
    L15:
        if (this.kindCase_ != 5) goto L18;
        r10.writeMessage(5, (Struct) this.kind_);
    L18:
        if (this.kindCase_ != 6) goto L21;
        r10.writeMessage(6, (ListValue) this.kind_);
        return;
    }

    public /* synthetic */ Value(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Value r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Value parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

    private Value(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Value parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Value parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Value getDefaultInstanceForType() {
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

    public static Value parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Value parseFrom(InputStream r10) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Value parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    private Value(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
    L3:
        if (r12 == true) goto L52;
        int r13 = r10.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r13 == 0) goto L20;
        if (r13 != 8) goto L9;
        int r14 = r10.readEnum();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kindCase_ = 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = Integer.valueOf(r14);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L9:
        if (r13 != 17) goto L11;
        this.kindCase_ = 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = Double.valueOf(r10.readDouble());     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L11:
        if (r13 != 26) goto L13;
        String r15 = r10.readStringRequireUtf8();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kindCase_ = 3;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = r15;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L13:
        if (r13 != 32) goto L14;
        this.kindCase_ = 4;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = Boolean.valueOf(r10.readBool());     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L14:
        ListValue.Builder r16 = null;
        Struct.Builder r17 = null;
        if (r13 != 42) goto L17;
        if (this.kindCase_ != 5) goto L37;
        r17 = ((Struct) this.kind_).toBuilder();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L37:
        MessageLite r18 = r10.readMessage(Struct.parser(), r11);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = r18;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r17 == null) goto L40;
        r17.mergeFrom((Struct) r18);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = r17.buildPartial();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L40:
        this.kindCase_ = 5;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L17:
        if (r13 != 50) goto L19;
        if (this.kindCase_ != 6) goto L30;
        r16 = ((ListValue) this.kind_).toBuilder();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L30:
        MessageLite r19 = r10.readMessage(ListValue.parser(), r11);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = r19;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r16 == null) goto L33;
        r16.mergeFrom((ListValue) r19);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.kind_ = r16.buildPartial();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L33:
        this.kindCase_ = 6;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L19:
        if (r10.skipField(r13) == true) goto L3;
    L20:
        r12 = true;
        goto L3
    L21:
        th = move-exception;
        makeExtensionsImmutable();
        throw th;
    L25:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L23:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L52:
        makeExtensionsImmutable();
    }

    public static Value parseFrom(CodedInputStream r10) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    public static Value parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }
}
