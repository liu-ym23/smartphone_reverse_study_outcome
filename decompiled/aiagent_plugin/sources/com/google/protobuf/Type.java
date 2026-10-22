package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Type extends GeneratedMessage implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 7;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static final Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private List<Field> fields_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private LazyStringArrayList oneofs_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements TypeOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> fieldsBuilder_;
        private List<Field> fields_;
        private Object name_;
        private LazyStringArrayList oneofs_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

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

        @Override // com.google.protobuf.TypeOrBuilder
        public /* bridge */ /* synthetic */ List getOneofsList() {
            return getOneofsList();
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
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L6;
            internalGetFieldsFieldBuilder();
            internalGetOptionsFieldBuilder();
            internalGetSourceContextFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r2 = this.fieldsBuilder_;
            if (r2 != null) goto L5;
            this.fields_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            this.oneofs_ = LazyStringArrayList.emptyList();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;
            if (r3 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -9;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r4 = this.sourceContextBuilder_;
            if (r4 == null) goto L13;
            r4.dispose();
            this.sourceContextBuilder_ = null;
        L13:
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        L9:
            this.options_ = null;
            r3.clear();
            goto L10
        L5:
            this.fields_ = null;
            r2.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Type getDefaultInstanceForType() {
            return Type.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type build() {
            Type r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type buildPartial() {
            Type r0 = new Type(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        private void buildPartialRepeatedFields(Type r2) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 == null) goto L5;
            Type.access$302(r2, r0.build());
        L9:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r1 = this.optionsBuilder_;
            if (r1 == null) goto L12;
            Type.access$402(r2, r1.build());
            return;
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -9;
        L14:
            Type.access$402(r2, this.options_);
            return;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.fields_ = Collections.unmodifiableList(this.fields_);
            this.bitField0_ &= -3;
        L7:
            Type.access$302(r2, this.fields_);
            goto L9
        }

        private void buildPartial0(Type r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            Type.access$502(r5, this.name_);
        L6:
            if ((r0 & 4) == 0) goto L8;
            this.oneofs_.makeImmutable();
            Type.access$602(r5, this.oneofs_);
        L8:
            int r1 = 0;
            if ((r0 & 16) == 0) goto L16;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r2 = this.sourceContextBuilder_;
            if (r2 != null) goto L13;
            SourceContext r3 = this.sourceContext_;
        L14:
            Type.access$702(r5, r3);
            r1 = 1;
            goto L16
        L13:
            r3 = (SourceContext) ZeusTransformUtils.preCheckCast(r2.build(), SourceContext.class, "com.obric.aiagent.plugin");
        L16:
            if ((r0 & 32) == 0) goto L19;
            Type.access$802(r5, this.syntax_);
        L19:
            if ((r0 & 64) == 0) goto L21;
            Type.access$902(r5, this.edition_);
        L21:
            Type.access$1076(r5, r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Type.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Type) ZeusTransformUtils.preCheckCast(r4, Type.class, "com.obric.aiagent.plugin"));
        }

        public Builder mergeFrom(Type r4) {
            if (r4 != Type.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r4.getName().isEmpty() == true) goto L8;
            this.name_ = Type.access$500(r4);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r1 = null;
            if (this.fieldsBuilder_ != null) goto L18;
            if (Type.access$300(r4).isEmpty() == true) goto L28;
            if (this.fields_.isEmpty() == false) goto L15;
            this.fields_ = Type.access$300(r4);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureFieldsIsMutable();
            this.fields_.addAll(Type.access$300(r4));
        L28:
            if (Type.access$600(r4).isEmpty() == true) goto L35;
            if (this.oneofs_.isEmpty() == false) goto L32;
            this.oneofs_ = Type.access$600(r4);
            this.bitField0_ |= 4;
        L33:
            onChanged();
            goto L35
        L32:
            ensureOneofsIsMutable();
            this.oneofs_.addAll(Type.access$600(r4));
        L35:
            if (this.optionsBuilder_ != null) goto L44;
            if (Type.access$400(r4).isEmpty() == true) goto L53;
            if (this.options_.isEmpty() == false) goto L41;
            this.options_ = Type.access$400(r4);
            this.bitField0_ &= -9;
        L42:
            onChanged();
            goto L53
        L41:
            ensureOptionsIsMutable();
            this.options_.addAll(Type.access$400(r4));
        L53:
            if (r4.hasSourceContext() == false) goto L56;
            mergeSourceContext(r4.getSourceContext());
        L56:
            if (Type.access$800(r4) == 0) goto L59;
            setSyntaxValue(r4.getSyntaxValue());
        L59:
            if (r4.getEdition().isEmpty() == true) goto L61;
            this.edition_ = Type.access$900(r4);
            this.bitField0_ |= 64;
            onChanged();
        L61:
            mergeUnknownFields(r4.getUnknownFields());
            onChanged();
            return this;
        L44:
            if (Type.access$400(r4).isEmpty() == true) goto L53;
            if (this.optionsBuilder_.isEmpty() == false) goto L51;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Type.access$400(r4);
            this.bitField0_ &= -9;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L50;
            r1 = internalGetOptionsFieldBuilder();
        L50:
            this.optionsBuilder_ = r1;
            goto L53
        L51:
            this.optionsBuilder_.addAllMessages(Type.access$400(r4));
            goto L53
        L18:
            if (Type.access$300(r4).isEmpty() == true) goto L28;
            if (this.fieldsBuilder_.isEmpty() == false) goto L26;
            this.fieldsBuilder_.dispose();
            this.fieldsBuilder_ = null;
            this.fields_ = Type.access$300(r4);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = internalGetFieldsFieldBuilder();
        L25:
            this.fieldsBuilder_ = r0;
            goto L28
        L24:
            r0 = null;
            goto L25
        L26:
            this.fieldsBuilder_.addAllMessages(Type.access$300(r4));
            goto L28
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            Objects.requireNonNull(r7);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L46;
            int r1 = r6.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L6:
            if (r1 == 0) goto L38;
            if (r1 != 10) goto L10;
            this.name_ = r6.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L10:
            if (r1 != 18) goto L12;
            Field r2 = (Field) ZeusTransformUtils.preCheckCast(r6.readMessage(Field.parser(), r7), Field.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r3 = this.fieldsBuilder_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r3 == null) goto L34;
            r3.addMessage(r2);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L34:
            ensureFieldsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.fields_.add(r2);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L12:
            if (r1 != 26) goto L14;
            String r4 = r6.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            ensureOneofsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.oneofs_.add(r4);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L14:
            if (r1 != 34) goto L16;
            Option r5 = (Option) ZeusTransformUtils.preCheckCast(r6.readMessage(Option.parser(), r7), Option.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r8 == null) goto L29;
            r8.addMessage(r5);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L29:
            ensureOptionsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.options_.add(r5);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L16:
            if (r1 != 42) goto L18;
            r6.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r7);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L18:
            if (r1 != 48) goto L20;
            this.syntax_ = r6.readEnum();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L20:
            if (r1 != 58) goto L22;
            this.edition_ = r6.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 64;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L22:
            if (super.parseUnknownField(r6, r7, r1) == true) goto L3;
        L38:
            r0 = true;
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L46:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
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
            this.name_ = Type.getDefaultInstance().getName();
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

        private void ensureFieldsIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.fields_ = new ArrayList(this.fields_);
            this.bitField0_ |= 2;
            return;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.fields_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L7;
            return this.fields_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int r3) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L7;
            return (Field) ZeusTransformUtils.preCheckCast(this.fields_.get(r3), Field.class, "com.obric.aiagent.plugin");
        L7:
            return (Field) ZeusTransformUtils.preCheckCast(r0.getMessage(r3), Field.class, "com.obric.aiagent.plugin");
        }

        public Builder setFields(int r2, Field r3) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureFieldsIsMutable();
            this.fields_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setFields(int r2, Field.Builder r3) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder addFields(Field r2) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureFieldsIsMutable();
            this.fields_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Builder addFields(int r2, Field r3) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureFieldsIsMutable();
            this.fields_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addFields(Field.Builder r2) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addFields(int r2, Field.Builder r3) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addAllFields(Iterable<? extends Field> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            ensureFieldsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.fields_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder clearFields() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder removeFields(int r2) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Field.Builder getFieldsBuilder(int r2) {
            return (Field.Builder) ZeusTransformUtils.preCheckCast(internalGetFieldsFieldBuilder().getBuilder(r2), Field.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public FieldOrBuilder getFieldsOrBuilder(int r3) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 != null) goto L7;
            return (FieldOrBuilder) ZeusTransformUtils.preCheckCast(this.fields_.get(r3), FieldOrBuilder.class, "com.obric.aiagent.plugin");
        L7:
            return (FieldOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), FieldOrBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r0 = this.fieldsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.fields_);
        }

        public Field.Builder addFieldsBuilder() {
            return (Field.Builder) ZeusTransformUtils.preCheckCast(internalGetFieldsFieldBuilder().addBuilder(Field.getDefaultInstance()), Field.Builder.class, "com.obric.aiagent.plugin");
        }

        public Field.Builder addFieldsBuilder(int r2) {
            return (Field.Builder) ZeusTransformUtils.preCheckCast(internalGetFieldsFieldBuilder().addBuilder(r2, Field.getDefaultInstance()), Field.Builder.class, "com.obric.aiagent.plugin");
        }

        public List<Field.Builder> getFieldsBuilderList() {
            return internalGetFieldsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> internalGetFieldsFieldBuilder() {
            if (this.fieldsBuilder_ != null) goto L10;
            List<Field> r1 = this.fields_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.fieldsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.fields_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.fieldsBuilder_;
        }

        private void ensureOneofsIsMutable() {
            if (this.oneofs_.isModifiable() == true) goto L5;
            this.oneofs_ = new LazyStringArrayList(this.oneofs_);
        L5:
            this.bitField0_ |= 4;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ProtocolStringList getOneofsList() {
            this.oneofs_.makeImmutable();
            return this.oneofs_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return this.oneofs_.size();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int r1) {
            return this.oneofs_.get(r1);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int r1) {
            return this.oneofs_.getByteString(r1);
        }

        public Builder setOneofs(int r2, String r3) {
            Objects.requireNonNull(r3);
            ensureOneofsIsMutable();
            this.oneofs_.set(r2, r3);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder addOneofs(String r2) {
            Objects.requireNonNull(r2);
            ensureOneofsIsMutable();
            this.oneofs_.add(r2);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder addAllOneofs(Iterable<String> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            ensureOneofsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.oneofs_);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearOneofs() {
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder addOneofsBytes(ByteString r2) {
            Objects.requireNonNull(r2);
            AbstractMessageLite.checkByteStringIsUtf8(r2);
            ensureOneofsIsMutable();
            this.oneofs_.add(r2);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 8;
            return;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return this.options_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Option getOptions(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r3), Option.class, "com.obric.aiagent.plugin");
        L7:
            return (Option) ZeusTransformUtils.preCheckCast(r0.getMessage(r3), Option.class, "com.obric.aiagent.plugin");
        }

        public Builder setOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder addOptions(Option r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureOptionsIsMutable();
            this.options_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Builder addOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addOptions(Option.Builder r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addAllOptions(Iterable<? extends Option> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder removeOptions(int r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().getBuilder(r2), Option.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r3), OptionOrBuilder.class, "com.obric.aiagent.plugin");
        L7:
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), OptionOrBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance()), Option.Builder.class, "com.obric.aiagent.plugin");
        }

        public Option.Builder addOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(r2, Option.getDefaultInstance()), Option.Builder.class, "com.obric.aiagent.plugin");
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r1 = this.options_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L9;
            SourceContext r2 = this.sourceContext_;
            if (r2 == null) goto L7;
            return r2;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) ZeusTransformUtils.preCheckCast(r0.getMessage(), SourceContext.class, "com.obric.aiagent.plugin");
        }

        public Builder setSourceContext(SourceContext r2) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            this.sourceContext_ = r2;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r0.setMessage(r2);
            goto L6
        }

        public Builder setSourceContext(SourceContext.Builder r2) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L5;
            this.sourceContext_ = r2.build();
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r0.setMessage(r2.build());
            goto L6
        }

        public Builder mergeSourceContext(SourceContext r3) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 == null) goto L5;
            r0.mergeFrom(r3);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            SourceContext r1 = this.sourceContext_;
            if (r1 == null) goto L11;
            if (r1 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r3);
        L11:
            this.sourceContext_ = r3;
            goto L14
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r1 = this.sourceContextBuilder_;
            if (r1 == null) goto L5;
            r1.dispose();
            this.sourceContextBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) ZeusTransformUtils.preCheckCast(internalGetSourceContextFieldBuilder().getBuilder(), SourceContext.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L5;
            SourceContext r2 = this.sourceContext_;
            if (r2 == null) goto L9;
            return r2;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(), SourceContextOrBuilder.class, "com.obric.aiagent.plugin");
        }

        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> internalGetSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ != null) goto L6;
            this.sourceContextBuilder_ = new SingleFieldBuilder(getSourceContext(), getParentForChildren(), isClean());
            this.sourceContext_ = null;
        L6:
            return this.sourceContextBuilder_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public Builder setSyntaxValue(int r1) {
            this.syntax_ = r1;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            Syntax r0 = Syntax.forNumber(this.syntax_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        public Builder setSyntax(Syntax r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 32;
            this.syntax_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getEdition() {
            Object r0 = this.edition_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
            this.edition_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getEditionBytes() {
            Object r0 = this.edition_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
            this.edition_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
        }

        public Builder setEdition(String r1) {
            Objects.requireNonNull(r1);
            this.edition_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearEdition() {
            this.edition_ = Type.getDefaultInstance().getEdition();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setEditionBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.edition_ = r1;
            this.bitField0_ |= 64;
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

    @Override // com.google.protobuf.TypeOrBuilder
    public /* bridge */ /* synthetic */ List getOneofsList() {
        return getOneofsList();
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

    /* synthetic */ Type(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ int access$1076(Type r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    static /* synthetic */ List access$300(Type r0) {
        return r0.fields_;
    }

    static /* synthetic */ List access$302(Type r2, List r3) {
        List<Field> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.fields_ = r4;
        return r4;
    }

    static /* synthetic */ List access$400(Type r0) {
        return r0.options_;
    }

    static /* synthetic */ List access$402(Type r2, List r3) {
        List<Option> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.options_ = r4;
        return r4;
    }

    static /* synthetic */ Object access$500(Type r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$502(Type r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ LazyStringArrayList access$600(Type r0) {
        return r0.oneofs_;
    }

    static /* synthetic */ LazyStringArrayList access$602(Type r0, LazyStringArrayList r1) {
        r0.oneofs_ = r1;
        return r1;
    }

    static /* synthetic */ SourceContext access$702(Type r0, SourceContext r1) {
        r0.sourceContext_ = r1;
        return r1;
    }

    static /* synthetic */ int access$800(Type r0) {
        return r0.syntax_;
    }

    static /* synthetic */ int access$802(Type r0, int r1) {
        r0.syntax_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$900(Type r0) {
        return r0.edition_;
    }

    static /* synthetic */ Object access$902(Type r0, Object r1) {
        r0.edition_ = r1;
        return r1;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Type.class.getName());
        DEFAULT_INSTANCE = new Type();
        PARSER = new AnonymousClass1();
    }

    private Type(GeneratedMessage.Builder<?> r2) {
        super(r2);
        this.name_ = "";
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    private Type() {
        this.name_ = "";
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int r2) {
        return (Field) ZeusTransformUtils.preCheckCast(this.fields_.get(r2), Field.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public FieldOrBuilder getFieldsOrBuilder(int r2) {
        return (FieldOrBuilder) ZeusTransformUtils.preCheckCast(this.fields_.get(r2), FieldOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int r1) {
        return this.oneofs_.get(r1);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int r1) {
        return this.oneofs_.getByteString(r1);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int r2) {
        return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r2), Option.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r2) {
        return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r2), OptionOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax r0 = Syntax.forNumber(this.syntax_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getEdition() {
        Object r0 = this.edition_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
        this.edition_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getEditionBytes() {
        Object r0 = this.edition_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
        this.edition_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
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
    public void writeTo(CodedOutputStream r8) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r8, 1, this.name_);
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r2 >= this.fields_.size()) goto L9;
        r8.writeMessage(2, (MessageLite) ZeusTransformUtils.preCheckCast(this.fields_.get(r2), MessageLite.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L7
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.oneofs_.size()) goto L14;
        GeneratedMessage.writeString(r8, 3, this.oneofs_.getRaw(r3));
        r3 = r3 + 1;
    L14:
        if (r0 >= this.options_.size()) goto L17;
        r8.writeMessage(4, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r0), MessageLite.class, "com.obric.aiagent.plugin"));
        r0 = r0 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) == 0) goto L20;
        r8.writeMessage(5, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L23;
        r8.writeEnum(6, this.syntax_);
    L23:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L25;
        GeneratedMessage.writeString(r8, 7, this.edition_);
    L25:
        getUnknownFields().writeTo(r8);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r2 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.fields_.size()) goto L13;
        r2 = r2 + CodedOutputStream.computeMessageSize(2, (MessageLite) ZeusTransformUtils.preCheckCast(this.fields_.get(r3), MessageLite.class, "com.obric.aiagent.plugin"));
        r3 = r3 + 1;
        goto L11
    L13:
        int r4 = 0;
        int r5 = 0;
    L15:
        if (r4 >= this.oneofs_.size()) goto L17;
        r5 = r5 + computeStringSizeNoTag(this.oneofs_.getRaw(r4));
        r4 = r4 + 1;
        goto L15
    L17:
        int r6 = (r2 + r5) + (getOneofsList().size() * 1);
    L19:
        if (r1 >= this.options_.size()) goto L22;
        r6 = r6 + CodedOutputStream.computeMessageSize(4, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r1), MessageLite.class, "com.obric.aiagent.plugin"));
        r1 = r1 + 1;
        goto L19
    L22:
        if ((this.bitField0_ & 1) == 0) goto L25;
        r6 = r6 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L28;
        r6 = r6 + CodedOutputStream.computeEnumSize(6, this.syntax_);
    L28:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L30;
        r6 = r6 + GeneratedMessage.computeStringSize(7, this.edition_);
    L30:
        int r7 = r6 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r7;
        return r7;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Type.class) == false) goto L8;
        Type r6 = (Type) ZeusTransformUtils.preCheckCast(r5, Type.class, "com.obric.aiagent.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (getFieldsList().equals(r6.getFieldsList()) == true) goto L16;
        return false;
    L16:
        if (getOneofsList().equals(r6.getOneofsList()) == true) goto L19;
        return false;
    L19:
        if (getOptionsList().equals(r6.getOptionsList()) == true) goto L22;
        return false;
    L22:
        if (hasSourceContext() == r6.hasSourceContext()) goto L25;
        return false;
    L25:
        if (hasSourceContext() == false) goto L30;
        if (getSourceContext().equals(r6.getSourceContext()) == true) goto L30;
        return false;
    L30:
        if (this.syntax_ == r6.syntax_) goto L33;
        return false;
    L33:
        if (getEdition().equals(r6.getEdition()) == true) goto L36;
        return false;
    L36:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L38;
        return false;
    L38:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getFieldsCount() <= 0) goto L10;
        r0 = (((r0 * 37) + 2) * 53) + getFieldsList().hashCode();
    L10:
        if (getOneofsCount() <= 0) goto L13;
        r0 = (((r0 * 37) + 3) * 53) + getOneofsList().hashCode();
    L13:
        if (getOptionsCount() <= 0) goto L16;
        r0 = (((r0 * 37) + 4) * 53) + getOptionsList().hashCode();
    L16:
        if (hasSourceContext() == false) goto L18;
        r0 = (((r0 * 37) + 5) * 53) + getSourceContext().hashCode();
    L18:
        int r1 = (((((((((r0 * 37) + 6) * 53) + this.syntax_) * 37) + 7) * 53) + getEdition().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    public static Type parseFrom(ByteBuffer r2) {
        return (Type) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Type) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(ByteString r2) {
        return (Type) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Type) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(byte[] r2) {
        return (Type) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Type) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(InputStream r2) {
        return (Type) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Type) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseDelimitedFrom(InputStream r2) {
        return (Type) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Type) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(CodedInputStream r2) {
        return (Type) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Type.class, "com.obric.aiagent.plugin");
    }

    public static Type parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Type) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Type.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Type r1) {
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

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Type> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
