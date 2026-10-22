package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Enum extends GeneratedMessage implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 6;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private List<EnumValue> enumvalue_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EnumOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> enumvalueBuilder_;
        private List<EnumValue> enumvalue_;
        private Object name_;
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
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L6;
            internalGetEnumvalueFieldBuilder();
            internalGetOptionsFieldBuilder();
            internalGetSourceContextFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r2 = this.enumvalueBuilder_;
            if (r2 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;
            if (r3 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -5;
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
            this.enumvalue_ = null;
            r2.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Enum getDefaultInstanceForType() {
            return Enum.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum build() {
            Enum r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum buildPartial() {
            Enum r0 = new Enum(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        private void buildPartialRepeatedFields(Enum r2) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 == null) goto L5;
            Enum.access$302(r2, r0.build());
        L9:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r1 = this.optionsBuilder_;
            if (r1 == null) goto L12;
            Enum.access$402(r2, r1.build());
            return;
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            Enum.access$402(r2, this.options_);
            return;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            this.bitField0_ &= -3;
        L7:
            Enum.access$302(r2, this.enumvalue_);
            goto L9
        }

        private void buildPartial0(Enum r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            Enum.access$502(r5, this.name_);
        L5:
            int r1 = 0;
            if ((r0 & 8) == 0) goto L13;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r2 = this.sourceContextBuilder_;
            if (r2 != null) goto L10;
            SourceContext r3 = this.sourceContext_;
        L11:
            Enum.access$602(r5, r3);
            r1 = 1;
            goto L13
        L10:
            r3 = (SourceContext) ZeusTransformUtils.preCheckCast(r2.build(), SourceContext.class, "com.obric.aiagent.plugin");
        L13:
            if ((r0 & 16) == 0) goto L16;
            Enum.access$702(r5, this.syntax_);
        L16:
            if ((r0 & 32) == 0) goto L18;
            Enum.access$802(r5, this.edition_);
        L18:
            Enum.access$976(r5, r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Enum.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Enum) ZeusTransformUtils.preCheckCast(r4, Enum.class, "com.obric.aiagent.plugin"));
        }

        public Builder mergeFrom(Enum r4) {
            if (r4 != Enum.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r4.getName().isEmpty() == true) goto L8;
            this.name_ = Enum.access$500(r4);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r1 = null;
            if (this.enumvalueBuilder_ != null) goto L18;
            if (Enum.access$300(r4).isEmpty() == true) goto L28;
            if (this.enumvalue_.isEmpty() == false) goto L15;
            this.enumvalue_ = Enum.access$300(r4);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureEnumvalueIsMutable();
            this.enumvalue_.addAll(Enum.access$300(r4));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Enum.access$400(r4).isEmpty() == true) goto L46;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Enum.access$400(r4);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L46
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Enum.access$400(r4));
        L46:
            if (r4.hasSourceContext() == false) goto L49;
            mergeSourceContext(r4.getSourceContext());
        L49:
            if (Enum.access$700(r4) == 0) goto L52;
            setSyntaxValue(r4.getSyntaxValue());
        L52:
            if (r4.getEdition().isEmpty() == true) goto L54;
            this.edition_ = Enum.access$800(r4);
            this.bitField0_ |= 32;
            onChanged();
        L54:
            mergeUnknownFields(r4.getUnknownFields());
            onChanged();
            return this;
        L37:
            if (Enum.access$400(r4).isEmpty() == true) goto L46;
            if (this.optionsBuilder_.isEmpty() == false) goto L44;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Enum.access$400(r4);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L43;
            r1 = internalGetOptionsFieldBuilder();
        L43:
            this.optionsBuilder_ = r1;
            goto L46
        L44:
            this.optionsBuilder_.addAllMessages(Enum.access$400(r4));
            goto L46
        L18:
            if (Enum.access$300(r4).isEmpty() == true) goto L28;
            if (this.enumvalueBuilder_.isEmpty() == false) goto L26;
            this.enumvalueBuilder_.dispose();
            this.enumvalueBuilder_ = null;
            this.enumvalue_ = Enum.access$300(r4);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = internalGetEnumvalueFieldBuilder();
        L25:
            this.enumvalueBuilder_ = r0;
            goto L28
        L24:
            r0 = null;
            goto L25
        L26:
            this.enumvalueBuilder_.addAllMessages(Enum.access$300(r4));
            goto L28
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            Objects.requireNonNull(r7);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L43;
            int r1 = r6.readTag();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L6:
            if (r1 == 0) goto L35;
            if (r1 != 10) goto L10;
            this.name_ = r6.readStringRequireUtf8();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L10:
            if (r1 != 18) goto L12;
            EnumValue r2 = (EnumValue) ZeusTransformUtils.preCheckCast(r6.readMessage(EnumValue.parser(), r7), EnumValue.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r3 = this.enumvalueBuilder_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r3 == null) goto L31;
            r3.addMessage(r2);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L31:
            ensureEnumvalueIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.enumvalue_.add(r2);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L12:
            if (r1 != 26) goto L14;
            Option r4 = (Option) ZeusTransformUtils.preCheckCast(r6.readMessage(Option.parser(), r7), Option.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r5 = this.optionsBuilder_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r5 == null) goto L27;
            r5.addMessage(r4);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L27:
            ensureOptionsIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.options_.add(r4);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L14:
            if (r1 != 34) goto L16;
            r6.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r7);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L16:
            if (r1 != 40) goto L18;
            this.syntax_ = r6.readEnum();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L18:
            if (r1 != 50) goto L20;
            this.edition_ = r6.readStringRequireUtf8();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L3
        L20:
            if (super.parseUnknownField(r6, r7, r1) == true) goto L3;
        L35:
            r0 = true;
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L43:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.EnumOrBuilder
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
            this.name_ = Enum.getDefaultInstance().getName();
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

        private void ensureEnumvalueIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.enumvalue_ = new ArrayList(this.enumvalue_);
            this.bitField0_ |= 2;
            return;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.enumvalue_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L7;
            return this.enumvalue_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int r3) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L7;
            return (EnumValue) ZeusTransformUtils.preCheckCast(this.enumvalue_.get(r3), EnumValue.class, "com.obric.aiagent.plugin");
        L7:
            return (EnumValue) ZeusTransformUtils.preCheckCast(r0.getMessage(r3), EnumValue.class, "com.obric.aiagent.plugin");
        }

        public Builder setEnumvalue(int r2, EnumValue r3) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setEnumvalue(int r2, EnumValue.Builder r3) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder addEnumvalue(EnumValue r2) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Builder addEnumvalue(int r2, EnumValue r3) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addEnumvalue(EnumValue.Builder r2) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addEnumvalue(int r2, EnumValue.Builder r3) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            ensureEnumvalueIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.enumvalue_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder clearEnumvalue() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder removeEnumvalue(int r2) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public EnumValue.Builder getEnumvalueBuilder(int r2) {
            return (EnumValue.Builder) ZeusTransformUtils.preCheckCast(internalGetEnumvalueFieldBuilder().getBuilder(r2), EnumValue.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValueOrBuilder getEnumvalueOrBuilder(int r3) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 != null) goto L7;
            return (EnumValueOrBuilder) ZeusTransformUtils.preCheckCast(this.enumvalue_.get(r3), EnumValueOrBuilder.class, "com.obric.aiagent.plugin");
        L7:
            return (EnumValueOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), EnumValueOrBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r0 = this.enumvalueBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.enumvalue_);
        }

        public EnumValue.Builder addEnumvalueBuilder() {
            return (EnumValue.Builder) ZeusTransformUtils.preCheckCast(internalGetEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance()), EnumValue.Builder.class, "com.obric.aiagent.plugin");
        }

        public EnumValue.Builder addEnumvalueBuilder(int r2) {
            return (EnumValue.Builder) ZeusTransformUtils.preCheckCast(internalGetEnumvalueFieldBuilder().addBuilder(r2, EnumValue.getDefaultInstance()), EnumValue.Builder.class, "com.obric.aiagent.plugin");
        }

        public List<EnumValue.Builder> getEnumvalueBuilderList() {
            return internalGetEnumvalueFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> internalGetEnumvalueFieldBuilder() {
            if (this.enumvalueBuilder_ != null) goto L10;
            List<EnumValue> r1 = this.enumvalue_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.enumvalueBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.enumvalue_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.enumvalueBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return this.options_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
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
            this.bitField0_ &= -5;
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

        @Override // com.google.protobuf.EnumOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r3), OptionOrBuilder.class, "com.obric.aiagent.plugin");
        L7:
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), OptionOrBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.EnumOrBuilder
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
            if ((this.bitField0_ & 4) == 0) goto L7;
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

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.EnumOrBuilder
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
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            SourceContext r1 = this.sourceContext_;
            if (r1 == null) goto L11;
            if (r1 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r3);
        L11:
            this.sourceContext_ = r3;
            goto L14
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -9;
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
            this.bitField0_ |= 8;
            onChanged();
            return (SourceContext.Builder) ZeusTransformUtils.preCheckCast(internalGetSourceContextFieldBuilder().getBuilder(), SourceContext.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.EnumOrBuilder
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

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public Builder setSyntaxValue(int r1) {
            this.syntax_ = r1;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            Syntax r0 = Syntax.forNumber(this.syntax_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        public Builder setSyntax(Syntax r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 16;
            this.syntax_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getEdition() {
            Object r0 = this.edition_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
            this.edition_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.EnumOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearEdition() {
            this.edition_ = Enum.getDefaultInstance().getEdition();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setEditionBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.edition_ = r1;
            this.bitField0_ |= 32;
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

    /* synthetic */ Enum(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ List access$300(Enum r0) {
        return r0.enumvalue_;
    }

    static /* synthetic */ List access$302(Enum r2, List r3) {
        List<EnumValue> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.enumvalue_ = r4;
        return r4;
    }

    static /* synthetic */ List access$400(Enum r0) {
        return r0.options_;
    }

    static /* synthetic */ List access$402(Enum r2, List r3) {
        List<Option> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.options_ = r4;
        return r4;
    }

    static /* synthetic */ Object access$500(Enum r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$502(Enum r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ SourceContext access$602(Enum r0, SourceContext r1) {
        r0.sourceContext_ = r1;
        return r1;
    }

    static /* synthetic */ int access$700(Enum r0) {
        return r0.syntax_;
    }

    static /* synthetic */ int access$702(Enum r0, int r1) {
        r0.syntax_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$800(Enum r0) {
        return r0.edition_;
    }

    static /* synthetic */ Object access$802(Enum r0, Object r1) {
        r0.edition_ = r1;
        return r1;
    }

    static /* synthetic */ int access$976(Enum r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Enum.class.getName());
        DEFAULT_INSTANCE = new Enum();
        PARSER = new AnonymousClass1();
    }

    private Enum(GeneratedMessage.Builder<?> r2) {
        super(r2);
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    private Enum() {
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(this.enumvalue_.get(r2), EnumValue.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValueOrBuilder getEnumvalueOrBuilder(int r2) {
        return (EnumValueOrBuilder) ZeusTransformUtils.preCheckCast(this.enumvalue_.get(r2), EnumValueOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int r2) {
        return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r2), Option.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r2) {
        return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r2), OptionOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax r0 = Syntax.forNumber(this.syntax_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getEdition() {
        Object r0 = this.edition_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin")).toStringUtf8();
        this.edition_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.EnumOrBuilder
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
        if (r2 >= this.enumvalue_.size()) goto L10;
        r8.writeMessage(2, (MessageLite) ZeusTransformUtils.preCheckCast(this.enumvalue_.get(r2), MessageLite.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
    L10:
        if (r0 >= this.options_.size()) goto L13;
        r8.writeMessage(3, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r0), MessageLite.class, "com.obric.aiagent.plugin"));
        r0 = r0 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 1) == 0) goto L16;
        r8.writeMessage(4, getSourceContext());
    L16:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L19;
        r8.writeEnum(5, this.syntax_);
    L19:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L21;
        GeneratedMessage.writeString(r8, 6, this.edition_);
    L21:
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
        if (r3 >= this.enumvalue_.size()) goto L14;
        r2 = r2 + CodedOutputStream.computeMessageSize(2, (MessageLite) ZeusTransformUtils.preCheckCast(this.enumvalue_.get(r3), MessageLite.class, "com.obric.aiagent.plugin"));
        r3 = r3 + 1;
    L14:
        if (r1 >= this.options_.size()) goto L17;
        r2 = r2 + CodedOutputStream.computeMessageSize(3, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r1), MessageLite.class, "com.obric.aiagent.plugin"));
        r1 = r1 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) == 0) goto L20;
        r2 = r2 + CodedOutputStream.computeMessageSize(4, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L23;
        r2 = r2 + CodedOutputStream.computeEnumSize(5, this.syntax_);
    L23:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L25;
        r2 = r2 + GeneratedMessage.computeStringSize(6, this.edition_);
    L25:
        int r4 = r2 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r4;
        return r4;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Enum.class) == false) goto L8;
        Enum r6 = (Enum) ZeusTransformUtils.preCheckCast(r5, Enum.class, "com.obric.aiagent.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (getEnumvalueList().equals(r6.getEnumvalueList()) == true) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r6.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (hasSourceContext() == r6.hasSourceContext()) goto L22;
        return false;
    L22:
        if (hasSourceContext() == false) goto L27;
        if (getSourceContext().equals(r6.getSourceContext()) == true) goto L27;
        return false;
    L27:
        if (this.syntax_ == r6.syntax_) goto L30;
        return false;
    L30:
        if (getEdition().equals(r6.getEdition()) == true) goto L33;
        return false;
    L33:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L35;
        return false;
    L35:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getEnumvalueCount() <= 0) goto L10;
        r0 = (((r0 * 37) + 2) * 53) + getEnumvalueList().hashCode();
    L10:
        if (getOptionsCount() <= 0) goto L13;
        r0 = (((r0 * 37) + 3) * 53) + getOptionsList().hashCode();
    L13:
        if (hasSourceContext() == false) goto L15;
        r0 = (((r0 * 37) + 4) * 53) + getSourceContext().hashCode();
    L15:
        int r1 = (((((((((r0 * 37) + 5) * 53) + this.syntax_) * 37) + 6) * 53) + getEdition().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    public static Enum parseFrom(ByteBuffer r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(ByteString r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(byte[] r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(InputStream r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseDelimitedFrom(InputStream r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(CodedInputStream r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    public static Enum parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Enum) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Enum.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Enum r1) {
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

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Enum> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
