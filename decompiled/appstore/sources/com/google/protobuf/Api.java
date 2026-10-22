package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Api extends GeneratedMessageV3 implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE = null;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private List<Method> methods_;
    private List<Mixin> mixins_;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private volatile Object version_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApiOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> methodsBuilder_;
        private List<Method> methods_;
        private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> mixinsBuilder_;
        private List<Mixin> mixins_;
        private Object name_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;
        private Object version_;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void ensureMethodsIsMutable() {
            if ((this.bitField0_ & 2) == 2) goto L6;
            this.methods_ = new ArrayList(this.methods_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureMixinsIsMutable() {
            if ((this.bitField0_ & 32) == 32) goto L6;
            this.mixins_ = new ArrayList(this.mixins_);
            this.bitField0_ |= 32;
            return;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 4) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> getMethodsFieldBuilder() {
            if (this.methodsBuilder_ != null) goto L10;
            List<Method> r10 = this.methods_;
            if ((this.bitField0_ & 2) != 2) goto L7;
            boolean r11 = true;
        L8:
            this.methodsBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
            this.methods_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.methodsBuilder_;
        }

        private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> getMixinsFieldBuilder() {
            if (this.mixinsBuilder_ != null) goto L10;
            List<Mixin> r10 = this.mixins_;
            if ((this.bitField0_ & 32) != 32) goto L7;
            boolean r11 = true;
        L8:
            this.mixinsBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
            this.mixins_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.mixinsBuilder_;
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
            getMethodsFieldBuilder();
            getOptionsFieldBuilder();
            getMixinsFieldBuilder();
            return;
        }

        public Builder addAllMethods(Iterable<? extends Method> r10) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.methods_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllMixins(Iterable<? extends Mixin> r10) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.mixins_);
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

        public Builder addMethods(Method r10) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMethodsIsMutable();
            this.methods_.add(r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r10);
            goto L9
        }

        public Method.Builder addMethodsBuilder() {
            return (Method.Builder) getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
        }

        public Builder addMixins(Mixin r10) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMixinsIsMutable();
            this.mixins_.add(r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r10);
            goto L9
        }

        public Mixin.Builder addMixinsBuilder() {
            return (Mixin.Builder) getMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance());
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

        public Builder clearMethods() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearMixins() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L5;
            this.mixins_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Api.getDefaultInstance().getName();
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

        public Builder clearVersion() {
            this.version_ = Api.getDefaultInstance().getVersion();
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
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Method getMethods(int r10) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L7;
            return this.methods_.get(r10);
        L7:
            return (Method) r11.getMessage(r10);
        }

        public Method.Builder getMethodsBuilder(int r10) {
            return (Method.Builder) getMethodsFieldBuilder().getBuilder(r10);
        }

        public List<Method.Builder> getMethodsBuilderList() {
            return getMethodsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L7;
            return this.methods_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.methods_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MethodOrBuilder getMethodsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L7;
            return this.methods_.get(r10);
        L7:
            return (MethodOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.methods_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int r10) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L7;
            return this.mixins_.get(r10);
        L7:
            return (Mixin) r11.getMessage(r10);
        }

        public Mixin.Builder getMixinsBuilder(int r10) {
            return (Mixin.Builder) getMixinsFieldBuilder().getBuilder(r10);
        }

        public List<Mixin.Builder> getMixinsBuilderList() {
            return getMixinsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L7;
            return this.mixins_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.mixins_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MixinOrBuilder getMixinsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L7;
            return this.mixins_.get(r10);
        L7:
            return (MixinOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.mixins_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
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

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            return this.options_.get(r10);
        L7:
            return (OptionOrBuilder) r11.getMessageOrBuilder(r10);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
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

        @Override // com.google.protobuf.ApiOrBuilder
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

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.valueOf(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            Object r10 = this.version_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.version_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object r10 = this.version_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.version_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
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
            return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
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

        public Builder removeMethods(int r10) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder removeMixins(int r10) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.remove(r10);
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

        public Builder setMethods(int r10, Method r11) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureMethodsIsMutable();
            this.methods_.set(r10, r11);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r12.setMessage(r10, r11);
            goto L9
        }

        public Builder setMixins(int r10, Mixin r11) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureMixinsIsMutable();
            this.mixins_.set(r10, r11);
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

        public Builder setVersion(String r10) {
            if (r10 == null) goto L6;
            this.version_ = r10;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setVersionBytes(ByteString r10) {
            if (r10 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.version_ = r10;
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
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.sourceContext_ = null;
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return (Builder) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api build() {
            Api r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api buildPartial() {
            Api r10 = new Api(this, null);
            Api.access$302(r10, this.name_);
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 == null) goto L5;
            Api.access$402(r10, r11.build());
        L9:
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 == null) goto L12;
            Api.access$502(r10, r12.build());
        L16:
            Api.access$602(r10, this.version_);
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r13 = this.sourceContextBuilder_;
            if (r13 != null) goto L19;
            Api.access$702(r10, this.sourceContext_);
        L20:
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r14 = this.mixinsBuilder_;
            if (r14 == null) goto L23;
            Api.access$802(r10, r14.build());
        L27:
            Api.access$902(r10, this.syntax_);
            Api.access$1002(r10, 0);
            onBuilt();
            return r10;
        L23:
            if ((this.bitField0_ & 32) != 32) goto L25;
            this.mixins_ = Collections.unmodifiableList(this.mixins_);
            this.bitField0_ &= -33;
        L25:
            Api.access$802(r10, this.mixins_);
            goto L27
        L19:
            Api.access$702(r10, (SourceContext) r13.build());
            goto L20
        L12:
            if ((this.bitField0_ & 4) != 4) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            Api.access$502(r10, this.options_);
            goto L16
        L5:
            if ((this.bitField0_ & 2) != 2) goto L7;
            this.methods_ = Collections.unmodifiableList(this.methods_);
            this.bitField0_ &= -3;
        L7:
            Api.access$402(r10, this.methods_);
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
        public Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
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

        public Method.Builder addMethodsBuilder(int r10) {
            return (Method.Builder) getMethodsFieldBuilder().addBuilder(r10, Method.getDefaultInstance());
        }

        public Mixin.Builder addMixinsBuilder(int r10) {
            return (Mixin.Builder) getMixinsFieldBuilder().addBuilder(r10, Mixin.getDefaultInstance());
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
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
        L6:
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L9;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
        L10:
            this.version_ = "";
            if (this.sourceContextBuilder_ != null) goto L13;
            this.sourceContext_ = null;
        L14:
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L17;
            this.mixins_ = Collections.emptyList();
            this.bitField0_ &= -33;
        L18:
            this.syntax_ = 0;
            return this;
        L17:
            r12.clear();
            goto L18
        L13:
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
            goto L14
        L9:
            r11.clear();
            goto L10
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

        public Builder addMethods(int r10, Method r11) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureMethodsIsMutable();
            this.methods_.add(r10, r11);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r12.addMessage(r10, r11);
            goto L9
        }

        public Builder addMixins(int r10, Mixin r11) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L8;
            if (r11 == null) goto L7;
            ensureMixinsIsMutable();
            this.mixins_.add(r10, r11);
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
            if ((r10 instanceof Api) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Api) r10);
        }

        public Builder setMethods(int r10, Method.Builder r11) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setMixins(int r10, Mixin.Builder r11) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.set(r10, r11.build());
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

        public Builder mergeFrom(Api r10) {
            if (r10 != Api.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L8;
            this.name_ = Api.access$300(r10);
            onChanged();
        L8:
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = null;
            if (this.methodsBuilder_ != null) goto L18;
            if (Api.access$400(r10).isEmpty() == true) goto L28;
            if (this.methods_.isEmpty() == false) goto L15;
            this.methods_ = Api.access$400(r10);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureMethodsIsMutable();
            this.methods_.addAll(Api.access$400(r10));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Api.access$500(r10).isEmpty() == true) goto L47;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Api.access$500(r10);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L47
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Api.access$500(r10));
        L47:
            if (r10.getVersion().isEmpty() == true) goto L50;
            this.version_ = Api.access$600(r10);
            onChanged();
        L50:
            if (r10.hasSourceContext() == false) goto L53;
            mergeSourceContext(r10.getSourceContext());
        L53:
            if (this.mixinsBuilder_ != null) goto L62;
            if (Api.access$800(r10).isEmpty() == true) goto L71;
            if (this.mixins_.isEmpty() == false) goto L59;
            this.mixins_ = Api.access$800(r10);
            this.bitField0_ &= -33;
        L60:
            onChanged();
            goto L71
        L59:
            ensureMixinsIsMutable();
            this.mixins_.addAll(Api.access$800(r10));
        L71:
            if (Api.access$900(r10) == 0) goto L73;
            setSyntaxValue(r10.getSyntaxValue());
        L73:
            onChanged();
            return this;
        L62:
            if (Api.access$800(r10).isEmpty() == true) goto L71;
            if (this.mixinsBuilder_.isEmpty() == false) goto L69;
            this.mixinsBuilder_.dispose();
            this.mixinsBuilder_ = null;
            this.mixins_ = Api.access$800(r10);
            this.bitField0_ &= -33;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L68;
            r11 = getMixinsFieldBuilder();
        L68:
            this.mixinsBuilder_ = r11;
            goto L71
        L69:
            this.mixinsBuilder_.addAllMessages(Api.access$800(r10));
            goto L71
        L37:
            if (Api.access$500(r10).isEmpty() == true) goto L47;
            if (this.optionsBuilder_.isEmpty() == false) goto L45;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Api.access$500(r10);
            this.bitField0_ &= -5;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L43;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r12 = getOptionsFieldBuilder();
        L44:
            this.optionsBuilder_ = r12;
            goto L47
        L43:
            r12 = null;
            goto L44
        L45:
            this.optionsBuilder_.addAllMessages(Api.access$500(r10));
            goto L47
        L18:
            if (Api.access$400(r10).isEmpty() == true) goto L28;
            if (this.methodsBuilder_.isEmpty() == false) goto L26;
            this.methodsBuilder_.dispose();
            this.methodsBuilder_ = null;
            this.methods_ = Api.access$400(r10);
            this.bitField0_ &= -3;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r13 = getMethodsFieldBuilder();
        L25:
            this.methodsBuilder_ = r13;
            goto L28
        L24:
            r13 = null;
            goto L25
        L26:
            this.methodsBuilder_.addAllMessages(Api.access$400(r10));
            goto L28
        }

        private Builder(GeneratedMessageV3.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.sourceContext_ = null;
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        public Builder addMethods(Method.Builder r10) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addMixins(Mixin.Builder r10) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r10.build());
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

        public Builder addMethods(int r10, Method.Builder r11) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addMixins(int r10, Mixin.Builder r11) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r10, r11.build());
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
            Api r12 = null;
            Api r13 = (Api) Api.access$1100().parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Api r14 = (Api) e.getUnfinishedMessage();     // Catch: Throwable -> L7
        L13:
            th = th;
            r12 = r14;
            goto L15
        L12:
            throw e.unwrapIOException();     // Catch: Throwable -> L13
        }
    }

    static {
        DEFAULT_INSTANCE = new Api();
        PARSER = new AnonymousClass1();
    }

    public /* synthetic */ Api(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
        this(r10, r11);
    }

    public static /* synthetic */ int access$1002(Api r10, int r11) {
        r10.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Parser access$1100() {
        return PARSER;
    }

    public static /* synthetic */ Object access$300(Api r10) {
        return r10.name_;
    }

    public static /* synthetic */ Object access$302(Api r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$400(Api r10) {
        return r10.methods_;
    }

    public static /* synthetic */ List access$402(Api r10, List r11) {
        r10.methods_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$500(Api r10) {
        return r10.options_;
    }

    public static /* synthetic */ List access$502(Api r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$600(Api r10) {
        return r10.version_;
    }

    public static /* synthetic */ Object access$602(Api r10, Object r11) {
        r10.version_ = r11;
        return r11;
    }

    public static /* synthetic */ SourceContext access$702(Api r10, SourceContext r11) {
        r10.sourceContext_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$800(Api r10) {
        return r10.mixins_;
    }

    public static /* synthetic */ List access$802(Api r10, List r11) {
        r10.mixins_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$900(Api r10) {
        return r10.syntax_;
    }

    public static /* synthetic */ int access$902(Api r10, int r11) {
        r10.syntax_ = r11;
        return r11;
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Api parseDelimitedFrom(InputStream r10) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Api parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    public static Parser<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Api) == false) goto L8;
        Api r11 = (Api) r10;
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
        if (r12 == true) goto L30;
    L32:
        boolean r13 = false;
    L33:
        if (r13 == false) goto L38;
        if (this.syntax_ != r11.syntax_) goto L38;
        return true;
    L38:
        return false;
    L30:
        if (getMixinsList().equals(r11.getMixinsList()) == false) goto L32;
        r13 = true;
        goto L33
    L12:
        if (getMethodsList().equals(r11.getMethodsList()) == false) goto L20;
        if (getOptionsList().equals(r11.getOptionsList()) == false) goto L20;
        if (getVersion().equals(r11.getVersion()) == false) goto L20;
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

    @Override // com.google.protobuf.ApiOrBuilder
    public Method getMethods(int r10) {
        return this.methods_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Method> getMethodsList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MethodOrBuilder getMethodsOrBuilder(int r10) {
        return this.methods_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int r10) {
        return this.mixins_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MixinOrBuilder getMixinsOrBuilder(int r10) {
        return this.mixins_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Api> getParserForType() {
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
        if (r13 >= this.methods_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.methods_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
    L15:
        if (r14 >= this.options_.size()) goto L18;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.options_.get(r14));
        r14 = r14 + 1;
        goto L15
    L18:
        if (getVersionBytes().isEmpty() == true) goto L21;
        r12 = r12 + GeneratedMessageV3.computeStringSize(4, this.version_);
    L21:
        if (this.sourceContext_ == null) goto L24;
        r12 = r12 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L24:
        if (r11 >= this.mixins_.size()) goto L27;
        r12 = r12 + CodedOutputStream.computeMessageSize(6, this.mixins_.get(r11));
        r11 = r11 + 1;
        goto L24
    L27:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L29;
        r12 = r12 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L29:
        this.memoizedSize = r12;
        return r12;
    L8:
        r12 = 0;
        goto L9
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.valueOf(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        Object r10 = this.version_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.version_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        Object r10 = this.version_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.version_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
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
        if (getMethodsCount() <= 0) goto L9;
        r11 = (((r11 * 37) + 2) * 53) + getMethodsList().hashCode();
    L9:
        if (getOptionsCount() <= 0) goto L11;
        r11 = (((r11 * 37) + 3) * 53) + getOptionsList().hashCode();
    L11:
        int r12 = (((r11 * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext() == false) goto L15;
        r12 = (((r12 * 37) + 5) * 53) + getSourceContext().hashCode();
    L15:
        if (getMixinsCount() <= 0) goto L17;
        r12 = (((r12 * 37) + 6) * 53) + getMixinsList().hashCode();
    L17:
        int r13 = (((((r12 * 37) + 7) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r13;
        return r13;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
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
        if (r12 >= this.methods_.size()) goto L9;
        r10.writeMessage(2, this.methods_.get(r12));
        r12 = r12 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.options_.size()) goto L14;
        r10.writeMessage(3, this.options_.get(r13));
        r13 = r13 + 1;
        goto L11
    L14:
        if (getVersionBytes().isEmpty() == true) goto L17;
        GeneratedMessageV3.writeString(r10, 4, this.version_);
    L17:
        if (this.sourceContext_ == null) goto L20;
        r10.writeMessage(5, getSourceContext());
    L20:
        if (r11 >= this.mixins_.size()) goto L23;
        r10.writeMessage(6, this.mixins_.get(r11));
        r11 = r11 + 1;
        goto L20
    L23:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L30;
        r10.writeEnum(7, this.syntax_);
        return;
    }

    public /* synthetic */ Api(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static Builder newBuilder(Api r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Api parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

    private Api(GeneratedMessageV3.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    public static Api parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Api parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Api getDefaultInstanceForType() {
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

    public static Api parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Api() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Api parseFrom(InputStream r10) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
        return new Builder(r10, null);
    }

    public static Api parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    public static Api parseFrom(CodedInputStream r10) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, r10);
    }

    public static Api parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
    }

    private Api(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this();
        boolean r12 = false;
        int r13 = 0;
    L4:
        if (r12 == true) goto L69;
        int r14 = r10.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r14 == 0) goto L23;
        if (r14 != 10) goto L10;
        this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L10:
        if (r14 != 18) goto L12;
        if ((r13 & 2) == 2) goto L50;
        this.methods_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r13 = r13 | 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L50:
        this.methods_.add((Method) r10.readMessage(Method.parser(), r11));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L12:
        if (r14 != 26) goto L14;
        if ((r13 & 4) == 4) goto L46;
        this.options_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r13 = r13 | 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L46:
        this.options_.add((Option) r10.readMessage(Option.parser(), r11));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L14:
        if (r14 != 34) goto L16;
        this.version_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L16:
        if (r14 != 42) goto L18;
        SourceContext r15 = this.sourceContext_;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r15 == null) goto L38;
        SourceContext.Builder r16 = r15.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L39:
        SourceContext r17 = (SourceContext) r10.readMessage(SourceContext.parser(), r11);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.sourceContext_ = r17;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r16 == null) goto L4;
        r16.mergeFrom(r17);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.sourceContext_ = r16.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L38:
        r16 = null;
        goto L39
    L18:
        if (r14 != 50) goto L20;
        if ((r13 & 32) == 32) goto L34;
        this.mixins_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r13 = r13 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L34:
        this.mixins_.add((Mixin) r10.readMessage(Mixin.parser(), r11));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
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
        if ((r13 & 2) != 2) goto L61;
        this.methods_ = Collections.unmodifiableList(this.methods_);
    L61:
        if ((r13 & 4) != 4) goto L64;
        this.options_ = Collections.unmodifiableList(this.options_);
    L64:
        if ((r13 & 32) != 32) goto L66;
        this.mixins_ = Collections.unmodifiableList(this.mixins_);
    L66:
        makeExtensionsImmutable();
        throw th;
    L28:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L26:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L69:
        if ((r13 & 2) != 2) goto L72;
        this.methods_ = Collections.unmodifiableList(this.methods_);
    L72:
        if ((r13 & 4) != 4) goto L75;
        this.options_ = Collections.unmodifiableList(this.options_);
    L75:
        if ((r13 & 32) != 32) goto L77;
        this.mixins_ = Collections.unmodifiableList(this.mixins_);
    L77:
        makeExtensionsImmutable();
    }
}
