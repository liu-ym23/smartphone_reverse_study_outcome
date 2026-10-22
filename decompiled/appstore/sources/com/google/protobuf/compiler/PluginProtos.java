package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PluginProtos {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = null;

    public static final class CodeGeneratorRequest extends GeneratedMessageV3 implements CodeGeneratorRequestOrBuilder {
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = null;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;

        @Deprecated
        public static final Parser<CodeGeneratorRequest> PARSER = null;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private LazyStringList fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile Object parameter_;
        private List<DescriptorProtos.FileDescriptorProto> protoFile_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private LazyStringList fileToGenerate_;
            private Object parameter_;
            private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> protoFile_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
                this(r10);
            }

            private void ensureFileToGenerateIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.fileToGenerate_ = new LazyStringArrayList(this.fileToGenerate_);
                this.bitField0_ |= 1;
                return;
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.protoFile_ = new ArrayList(this.protoFile_);
                this.bitField0_ |= 4;
                return;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$000();
            }

            private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
                if (this.protoFileBuilder_ != null) goto L10;
                List<DescriptorProtos.FileDescriptorProto> r10 = this.protoFile_;
                if ((this.bitField0_ & 4) != 4) goto L7;
                boolean r11 = true;
            L8:
                this.protoFileBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
                this.protoFile_ = null;
                goto L10
            L7:
                r11 = false;
            L10:
                return this.protoFileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorRequest.access$400() == false) goto L6;
                getProtoFileFieldBuilder();
                return;
            }

            public Builder addAllFileToGenerate(Iterable<String> r10) {
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.fileToGenerate_);
                onChanged();
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> r10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.protoFile_);
                onChanged();
            L6:
                return this;
            L5:
                r11.addAllMessages(r10);
                goto L6
            }

            public Builder addFileToGenerate(String r10) {
                if (r10 == null) goto L6;
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r10);
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder addFileToGenerateBytes(ByteString r10) {
                if (r10 == null) goto L6;
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r10);
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.addMessage(r10);
                goto L9
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
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

            public Builder clearFileToGenerate() {
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
                return clearOneof(r10);
            }

            public Builder clearParameter() {
                this.bitField0_ &= -3;
                this.parameter_ = CodeGeneratorRequest.getDefaultInstance().getParameter();
                onChanged();
                return this;
            }

            public Builder clearProtoFile() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
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
                return PluginProtos.access$000();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int r10) {
                return this.fileToGenerate_.get(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int r10) {
                return this.fileToGenerate_.getByteString(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public /* bridge */ /* synthetic */ List getFileToGenerateList() {
                return getFileToGenerateList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getParameter() {
                Object r10 = this.parameter_;
                if ((r10 instanceof String) == true) goto L9;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L7;
                this.parameter_ = r12;
            L7:
                return r12;
            L9:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                Object r10 = this.parameter_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.parameter_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int r10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L7;
                return this.protoFile_.get(r10);
            L7:
                return (DescriptorProtos.FileDescriptorProto) r11.getMessage(r10);
            }

            public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int r10) {
                return (DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().getBuilder(r10);
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return getProtoFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L7;
                return this.protoFile_.size();
            L7:
                return r10.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L7;
                return Collections.unmodifiableList(this.protoFile_);
            L7:
                return r10.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L7;
                return this.protoFile_.get(r10);
            L7:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) r11.getMessageOrBuilder(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 == null) goto L7;
                return r10.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.protoFile_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r10 = 0;
            L4:
                if (r10 >= getProtoFileCount()) goto L9;
                if (getProtoFile(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
                return mergeUnknownFields(r10);
            }

            public Builder removeProtoFile(int r10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.remove(r10);
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

            public Builder setFileToGenerate(int r10, String r11) {
                if (r11 == null) goto L6;
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(r10, r11);
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setParameter(String r10) {
                if (r10 == null) goto L6;
                this.bitField0_ |= 2;
                this.parameter_ = r10;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setParameterBytes(ByteString r10) {
                if (r10 == null) goto L6;
                this.bitField0_ |= 2;
                this.parameter_ = r10;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setProtoFile(int r10, DescriptorProtos.FileDescriptorProto r11) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L8;
                if (r11 == null) goto L7;
                ensureProtoFileIsMutable();
                this.protoFile_.set(r10, r11);
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
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r10) {
                return setUnknownFields(r10);
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

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ProtocolStringList getFileToGenerateList() {
                return this.fileToGenerate_.getUnmodifiableView();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r10) {
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
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
                return setUnknownFields(r10);
            }

            private Builder() {
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
                return (Builder) super.addRepeatedField(r10, r11);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r10);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest r10 = new CodeGeneratorRequest(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) != 1) goto L5;
                this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
                this.bitField0_ &= -2;
            L5:
                CodeGeneratorRequest.access$602(r10, this.fileToGenerate_);
                if ((r11 & 2) == 2) goto L9;
                r12 = 0;
            L9:
                CodeGeneratorRequest.access$702(r10, this.parameter_);
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r13 = this.protoFileBuilder_;
                if (r13 == null) goto L12;
                CodeGeneratorRequest.access$802(r10, r13.build());
            L16:
                CodeGeneratorRequest.access$902(r10, r12);
                onBuilt();
                return r10;
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                this.bitField0_ &= -5;
            L14:
                CodeGeneratorRequest.access$802(r10, this.protoFile_);
                goto L16
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
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
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
            public final Builder setUnknownFields(UnknownFieldSet r10) {
                return (Builder) super.setUnknownFields(r10);
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int r10) {
                return (DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().addBuilder(r10, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
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
            public final Builder mergeUnknownFields(UnknownFieldSet r10) {
                return (Builder) super.mergeUnknownFields(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                int r10 = this.bitField0_;
                this.parameter_ = "";
                this.bitField0_ = r10 & (-4);
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
                this.bitField0_ &= -5;
            L6:
                return this;
            L5:
                r11.clear();
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

            public Builder addProtoFile(int r10, DescriptorProtos.FileDescriptorProto r11) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L8;
                if (r11 == null) goto L7;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10, r11);
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
                if ((r10 instanceof CodeGeneratorRequest) == true) goto L5;
                super.mergeFrom(r10);
                return this;
            L5:
                return mergeFrom((CodeGeneratorRequest) r10);
            }

            public Builder setProtoFile(int r10, DescriptorProtos.FileDescriptorProto.Builder r11) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.set(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11.build());
                goto L6
            }

            private Builder(GeneratedMessageV3.BuilderParent r10) {
                super(r10);
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(CodeGeneratorRequest r10) {
                if (r10 != CodeGeneratorRequest.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (CodeGeneratorRequest.access$600(r10).isEmpty() == true) goto L13;
                if (this.fileToGenerate_.isEmpty() == false) goto L10;
                this.fileToGenerate_ = CodeGeneratorRequest.access$600(r10);
                this.bitField0_ &= -2;
            L11:
                onChanged();
                goto L13
            L10:
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.addAll(CodeGeneratorRequest.access$600(r10));
            L13:
                if (r10.hasParameter() == false) goto L16;
                this.bitField0_ |= 2;
                this.parameter_ = CodeGeneratorRequest.access$700(r10);
                onChanged();
            L16:
                if (this.protoFileBuilder_ != null) goto L25;
                if (CodeGeneratorRequest.access$800(r10).isEmpty() == false) goto L20;
            L33:
                mergeUnknownFields(CodeGeneratorRequest.access$1100(r10));
                onChanged();
                return this;
            L20:
                if (this.protoFile_.isEmpty() == false) goto L22;
                this.protoFile_ = CodeGeneratorRequest.access$800(r10);
                this.bitField0_ &= -5;
            L23:
                onChanged();
                goto L33
            L22:
                ensureProtoFileIsMutable();
                this.protoFile_.addAll(CodeGeneratorRequest.access$800(r10));
                goto L23
            L25:
                if (CodeGeneratorRequest.access$800(r10).isEmpty() == true) goto L33;
                if (this.protoFileBuilder_.isEmpty() == false) goto L32;
                this.protoFileBuilder_.dispose();
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = null;
                this.protoFileBuilder_ = null;
                this.protoFile_ = CodeGeneratorRequest.access$800(r10);
                this.bitField0_ &= -5;
                if (CodeGeneratorRequest.access$1000() == false) goto L31;
                r11 = getProtoFileFieldBuilder();
            L31:
                this.protoFileBuilder_ = r11;
                goto L33
            L32:
                this.protoFileBuilder_.addAllMessages(CodeGeneratorRequest.access$800(r10));
                goto L33
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10.build());
                goto L6
            }

            public Builder addProtoFile(int r10, DescriptorProtos.FileDescriptorProto.Builder r11) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11.build());
                goto L6
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                CodeGeneratorRequest r12 = null;
                CodeGeneratorRequest r13 = CodeGeneratorRequest.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                CodeGeneratorRequest r14 = (CodeGeneratorRequest) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r12 = r14;
            L15:
                if (r12 == null) goto L17;
                mergeFrom(r12);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }
        }

        static {
            DEFAULT_INSTANCE = new CodeGeneratorRequest();
            PARSER = new AnonymousClass1();
        }

        public /* synthetic */ CodeGeneratorRequest(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
            this(r10, r11);
        }

        public static /* synthetic */ boolean access$1000() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ UnknownFieldSet access$1100(CodeGeneratorRequest r10) {
            return r10.unknownFields;
        }

        public static /* synthetic */ boolean access$400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ LazyStringList access$600(CodeGeneratorRequest r10) {
            return r10.fileToGenerate_;
        }

        public static /* synthetic */ LazyStringList access$602(CodeGeneratorRequest r10, LazyStringList r11) {
            r10.fileToGenerate_ = r11;
            return r11;
        }

        public static /* synthetic */ Object access$700(CodeGeneratorRequest r10) {
            return r10.parameter_;
        }

        public static /* synthetic */ Object access$702(CodeGeneratorRequest r10, Object r11) {
            r10.parameter_ = r11;
            return r11;
        }

        public static /* synthetic */ List access$800(CodeGeneratorRequest r10) {
            return r10.protoFile_;
        }

        public static /* synthetic */ List access$802(CodeGeneratorRequest r10, List r11) {
            r10.protoFile_ = r11;
            return r11;
        }

        public static /* synthetic */ int access$902(CodeGeneratorRequest r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$000();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r10) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
        }

        public static CodeGeneratorRequest parseFrom(ByteString r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10);
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof CodeGeneratorRequest) == false) goto L8;
            CodeGeneratorRequest r11 = (CodeGeneratorRequest) r10;
            if (getFileToGenerateList().equals(r11.getFileToGenerateList()) == true) goto L12;
        L14:
            boolean r12 = false;
        L16:
            if (hasParameter() == false) goto L22;
            if (r12 == true) goto L19;
        L21:
            r12 = false;
            goto L22
        L19:
            if (getParameter().equals(r11.getParameter()) == false) goto L21;
            r12 = true;
        L22:
            if (r12 == true) goto L24;
        L26:
            boolean r13 = false;
        L27:
            if (r13 == false) goto L32;
            if (this.unknownFields.equals(r11.unknownFields) == false) goto L32;
            return true;
        L32:
            return false;
        L24:
            if (getProtoFileList().equals(r11.getProtoFileList()) == false) goto L26;
            r13 = true;
            goto L27
        L12:
            if (hasParameter() != r11.hasParameter()) goto L14;
            r12 = true;
            goto L16
        L8:
            return super.equals(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int r10) {
            return this.fileToGenerate_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int r10) {
            return this.fileToGenerate_.getByteString(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public /* bridge */ /* synthetic */ List getFileToGenerateList() {
            return getFileToGenerateList();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getParameter() {
            Object r10 = this.parameter_;
            if ((r10 instanceof String) == true) goto L5;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L9;
            this.parameter_ = r12;
        L9:
            return r12;
        L5:
            return (String) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            Object r10 = this.parameter_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.parameter_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int r10) {
            return this.protoFile_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r10) {
            return this.protoFile_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L7:
            if (r12 >= this.fileToGenerate_.size()) goto L9;
            r13 = r13 + GeneratedMessageV3.computeStringSizeNoTag(this.fileToGenerate_.getRaw(r12));
            r12 = r12 + 1;
            goto L7
        L9:
            int r14 = r13 + getFileToGenerateList().size();
            if ((this.bitField0_ & 1) != 1) goto L13;
            r14 = r14 + GeneratedMessageV3.computeStringSize(2, this.parameter_);
        L13:
            if (r11 >= this.protoFile_.size()) goto L15;
            r14 = r14 + CodedOutputStream.computeMessageSize(15, this.protoFile_.get(r11));
            r11 = r11 + 1;
            goto L13
        L15:
            int r15 = r14 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r15;
            return r15;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r10 = this.memoizedHashCode;
            if (r10 == 0) goto L5;
            return r10;
        L5:
            int r11 = 779 + getDescriptorForType().hashCode();
            if (getFileToGenerateCount() <= 0) goto L9;
            r11 = (((r11 * 37) + 1) * 53) + getFileToGenerateList().hashCode();
        L9:
            if (hasParameter() == false) goto L12;
            r11 = (((r11 * 37) + 2) * 53) + getParameter().hashCode();
        L12:
            if (getProtoFileCount() <= 0) goto L14;
            r11 = (((r11 * 37) + 15) * 53) + getProtoFileList().hashCode();
        L14:
            int r12 = (r11 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getProtoFileCount()) goto L16;
            if (getProtoFile(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
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
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r12 >= this.fileToGenerate_.size()) goto L7;
            GeneratedMessageV3.writeString(r10, 1, this.fileToGenerate_.getRaw(r12));
            r12 = r12 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) != 1) goto L10;
            GeneratedMessageV3.writeString(r10, 2, this.parameter_);
        L10:
            if (r11 >= this.protoFile_.size()) goto L12;
            r10.writeMessage(15, this.protoFile_.get(r11));
            r11 = r11 + 1;
            goto L10
        L12:
            this.unknownFields.writeTo(r10);
        }

        public /* synthetic */ CodeGeneratorRequest(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static Builder newBuilder(CodeGeneratorRequest r10) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
        }

        public static CodeGeneratorRequest parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
            return newBuilderForType(r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private CodeGeneratorRequest(GeneratedMessageV3.Builder<?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(byte[] r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorRequest getDefaultInstanceForType() {
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

        public static CodeGeneratorRequest parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private CodeGeneratorRequest() {
            this.memoizedIsInitialized = -1;
            this.fileToGenerate_ = LazyStringArrayList.EMPTY;
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
        }

        public static CodeGeneratorRequest parseFrom(InputStream r10) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
            return new Builder(r10, null);
        }

        public static CodeGeneratorRequest parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r10) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, r10);
        }

        private CodeGeneratorRequest(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder r12 = UnknownFieldSet.newBuilder();
            boolean r13 = false;
            int r14 = 0;
        L4:
            if (r13 == true) goto L45;
            int r15 = r10.readTag();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            if (r15 == 0) goto L15;
            if (r15 != 10) goto L10;
            ByteString r16 = r10.readBytes();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            if ((r14 & 1) == 1) goto L30;
            this.fileToGenerate_ = new LazyStringArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            r14 = r14 | 1;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        L30:
            this.fileToGenerate_.add(r16);     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
            if (r15 != 18) goto L12;
            ByteString r17 = r10.readBytes();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 1;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            this.parameter_ = r17;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L12:
            if (r15 != 122) goto L14;
            if ((r14 & 4) == 4) goto L25;
            this.protoFile_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            r14 = r14 | 4;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        L25:
            this.protoFile_.add((DescriptorProtos.FileDescriptorProto) r10.readMessage(DescriptorProtos.FileDescriptorProto.PARSER, r11));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L14:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
        L15:
            r13 = true;
            goto L4
        L16:
            th = move-exception;
            if ((r14 & 1) != 1) goto L40;
            this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
        L40:
            if ((r14 & 4) != 4) goto L42;
            this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
        L42:
            this.unknownFields = r12.build();
            makeExtensionsImmutable();
            throw th;
        L20:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L16
        L18:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L16
        L45:
            if ((r14 & 1) != 1) goto L48;
            this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
        L48:
            if ((r14 & 4) != 4) goto L50;
            this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
        L50:
            this.unknownFields = r12.build();
            makeExtensionsImmutable();
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
        }
    }

    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        String getFileToGenerate(int r10);

        ByteString getFileToGenerateBytes(int r10);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int r10);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r10);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        boolean hasParameter();
    }

    public static final class CodeGeneratorResponse extends GeneratedMessageV3 implements CodeGeneratorResponseOrBuilder {
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = null;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;

        @Deprecated
        public static final Parser<CodeGeneratorResponse> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object error_;
        private List<File> file_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private Object error_;
            private RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> fileBuilder_;
            private List<File> file_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
                this(r10);
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.file_ = new ArrayList(this.file_);
                this.bitField0_ |= 2;
                return;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$1300();
            }

            private RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> getFileFieldBuilder() {
                if (this.fileBuilder_ != null) goto L10;
                List<File> r10 = this.file_;
                if ((this.bitField0_ & 2) != 2) goto L7;
                boolean r11 = true;
            L8:
                this.fileBuilder_ = new RepeatedFieldBuilderV3(r10, r11, getParentForChildren(), isClean());
                this.file_ = null;
                goto L10
            L7:
                r11 = false;
            L10:
                return this.fileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorResponse.access$2900() == false) goto L6;
                getFileFieldBuilder();
                return;
            }

            public Builder addAllFile(Iterable<? extends File> r10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.file_);
                onChanged();
            L6:
                return this;
            L5:
                r11.addAllMessages(r10);
                goto L6
            }

            public Builder addFile(File r10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureFileIsMutable();
                this.file_.add(r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.addMessage(r10);
                goto L9
            }

            public File.Builder addFileBuilder() {
                return (File.Builder) getFileFieldBuilder().addBuilder(File.getDefaultInstance());
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

            public Builder clearError() {
                this.bitField0_ &= -2;
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r10) {
                return clearField(r10);
            }

            public Builder clearFile() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                this.file_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            L6:
                return this;
            L5:
                r10.clear();
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
                return clearOneof(r10);
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
                return PluginProtos.access$1300();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                Object r10 = this.error_;
                if ((r10 instanceof String) == true) goto L9;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L7;
                this.error_ = r12;
            L7:
                return r12;
            L9:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                Object r10 = this.error_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.error_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int r10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L7;
                return this.file_.get(r10);
            L7:
                return (File) r11.getMessage(r10);
            }

            public File.Builder getFileBuilder(int r10) {
                return (File.Builder) getFileFieldBuilder().getBuilder(r10);
            }

            public List<File.Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L7;
                return this.file_.size();
            L7:
                return r10.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L7;
                return Collections.unmodifiableList(this.file_);
            L7:
                return r10.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public FileOrBuilder getFileOrBuilder(int r10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L7;
                return this.file_.get(r10);
            L7:
                return (FileOrBuilder) r11.getMessageOrBuilder(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 == null) goto L7;
                return r10.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.file_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$1400().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
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
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
                return mergeUnknownFields(r10);
            }

            public Builder removeFile(int r10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                this.file_.remove(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.remove(r10);
                goto L6
            }

            public Builder setError(String r10) {
                if (r10 == null) goto L6;
                this.bitField0_ |= 1;
                this.error_ = r10;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setErrorBytes(ByteString r10) {
                if (r10 == null) goto L6;
                this.bitField0_ |= 1;
                this.error_ = r10;
                onChanged();
                return this;
            L6:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
                return setField(r10, r11);
            }

            public Builder setFile(int r10, File r11) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L8;
                if (r11 == null) goto L7;
                ensureFileIsMutable();
                this.file_.set(r10, r11);
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
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r10) {
                return setUnknownFields(r10);
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
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r10) {
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
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
                return setUnknownFields(r10);
            }

            private Builder() {
                this.error_ = "";
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
                return (Builder) super.addRepeatedField(r10, r11);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r10);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse r10 = new CodeGeneratorResponse(this, null);
                int r11 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r11 = 0;
            L6:
                CodeGeneratorResponse.access$3102(r10, this.error_);
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 == null) goto L9;
                CodeGeneratorResponse.access$3202(r10, r12.build());
            L13:
                CodeGeneratorResponse.access$3302(r10, r11);
                onBuilt();
                return r10;
            L9:
                if ((this.bitField0_ & 2) != 2) goto L11;
                this.file_ = Collections.unmodifiableList(this.file_);
                this.bitField0_ &= -3;
            L11:
                CodeGeneratorResponse.access$3202(r10, this.file_);
                goto L13
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
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
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
            public final Builder setUnknownFields(UnknownFieldSet r10) {
                return (Builder) super.setUnknownFields(r10);
            }

            public File.Builder addFileBuilder(int r10) {
                return (File.Builder) getFileFieldBuilder().addBuilder(r10, File.getDefaultInstance());
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
            public final Builder mergeUnknownFields(UnknownFieldSet r10) {
                return (Builder) super.mergeUnknownFields(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.error_ = "";
                this.bitField0_ &= -2;
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                this.file_ = Collections.emptyList();
                this.bitField0_ &= -3;
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
                this.error_ = "";
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addFile(int r10, File r11) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L8;
                if (r11 == null) goto L7;
                ensureFileIsMutable();
                this.file_.add(r10, r11);
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
                if ((r10 instanceof CodeGeneratorResponse) == true) goto L5;
                super.mergeFrom(r10);
                return this;
            L5:
                return mergeFrom((CodeGeneratorResponse) r10);
            }

            public Builder setFile(int r10, File.Builder r11) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L5;
                ensureFileIsMutable();
                this.file_.set(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11.build());
                goto L6
            }

            public Builder mergeFrom(CodeGeneratorResponse r10) {
                if (r10 != CodeGeneratorResponse.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasError() == false) goto L9;
                this.bitField0_ |= 1;
                this.error_ = CodeGeneratorResponse.access$3100(r10);
                onChanged();
            L9:
                if (this.fileBuilder_ != null) goto L18;
                if (CodeGeneratorResponse.access$3200(r10).isEmpty() == false) goto L13;
            L26:
                mergeUnknownFields(CodeGeneratorResponse.access$3500(r10));
                onChanged();
                return this;
            L13:
                if (this.file_.isEmpty() == false) goto L15;
                this.file_ = CodeGeneratorResponse.access$3200(r10);
                this.bitField0_ &= -3;
            L16:
                onChanged();
                goto L26
            L15:
                ensureFileIsMutable();
                this.file_.addAll(CodeGeneratorResponse.access$3200(r10));
                goto L16
            L18:
                if (CodeGeneratorResponse.access$3200(r10).isEmpty() == true) goto L26;
                if (this.fileBuilder_.isEmpty() == false) goto L25;
                this.fileBuilder_.dispose();
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = null;
                this.fileBuilder_ = null;
                this.file_ = CodeGeneratorResponse.access$3200(r10);
                this.bitField0_ &= -3;
                if (CodeGeneratorResponse.access$3400() == false) goto L24;
                r11 = getFileFieldBuilder();
            L24:
                this.fileBuilder_ = r11;
                goto L26
            L25:
                this.fileBuilder_.addAllMessages(CodeGeneratorResponse.access$3200(r10));
                goto L26
            }

            public Builder addFile(File.Builder r10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10.build());
                goto L6
            }

            public Builder addFile(int r10, File.Builder r11) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11.build());
                goto L6
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                CodeGeneratorResponse r12 = null;
                CodeGeneratorResponse r13 = CodeGeneratorResponse.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                CodeGeneratorResponse r14 = (CodeGeneratorResponse) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r12 = r14;
            L15:
                if (r12 == null) goto L17;
                mergeFrom(r12);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }
        }

        public static final class File extends GeneratedMessageV3 implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            private static final File DEFAULT_INSTANCE = null;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;

            @Deprecated
            public static final Parser<File> PARSER = null;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object content_;
            private volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile Object name_;

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileOrBuilder {
                private int bitField0_;
                private Object content_;
                private Object insertionPoint_;
                private Object name_;

                public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r10, AnonymousClass1 r11) {
                    this(r10);
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return PluginProtos.access$1500();
                }

                private void maybeForceBuilderInitialization() {
                    File.access$1900();
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

                public Builder clearContent() {
                    this.bitField0_ &= -5;
                    this.content_ = File.getDefaultInstance().getContent();
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r10) {
                    return clearField(r10);
                }

                public Builder clearInsertionPoint() {
                    this.bitField0_ &= -3;
                    this.insertionPoint_ = File.getDefaultInstance().getInsertionPoint();
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.bitField0_ &= -2;
                    this.name_ = File.getDefaultInstance().getName();
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
                    return clearOneof(r10);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                    return clone();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getContent() {
                    Object r10 = this.content_;
                    if ((r10 instanceof String) == true) goto L9;
                    ByteString r11 = (ByteString) r10;
                    String r12 = r11.toStringUtf8();
                    if (r11.isValidUtf8() == false) goto L7;
                    this.content_ = r12;
                L7:
                    return r12;
                L9:
                    return (String) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    Object r10 = this.content_;
                    if ((r10 instanceof String) == false) goto L7;
                    ByteString r11 = ByteString.copyFromUtf8((String) r10);
                    this.content_ = r11;
                    return r11;
                L7:
                    return (ByteString) r10;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.access$1500();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    Object r10 = this.insertionPoint_;
                    if ((r10 instanceof String) == true) goto L9;
                    ByteString r11 = (ByteString) r10;
                    String r12 = r11.toStringUtf8();
                    if (r11.isValidUtf8() == false) goto L7;
                    this.insertionPoint_ = r12;
                L7:
                    return r12;
                L9:
                    return (String) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    Object r10 = this.insertionPoint_;
                    if ((r10 instanceof String) == false) goto L7;
                    ByteString r11 = ByteString.copyFromUtf8((String) r10);
                    this.insertionPoint_ = r11;
                    return r11;
                L7:
                    return (ByteString) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    Object r10 = this.name_;
                    if ((r10 instanceof String) == true) goto L9;
                    ByteString r11 = (ByteString) r10;
                    String r12 = r11.toStringUtf8();
                    if (r11.isValidUtf8() == false) goto L7;
                    this.name_ = r12;
                L7:
                    return r12;
                L9:
                    return (String) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getNameBytes() {
                    Object r10 = this.name_;
                    if ((r10 instanceof String) == false) goto L7;
                    ByteString r11 = ByteString.copyFromUtf8((String) r10);
                    this.name_ = r11;
                    return r11;
                L7:
                    return (ByteString) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    if ((this.bitField0_ & 4) != 4) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    if ((this.bitField0_ & 1) == 1) goto L7;
                    return false;
                L7:
                    return true;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.access$1600().ensureFieldAccessorsInitialized(File.class, Builder.class);
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
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
                    return mergeUnknownFields(r10);
                }

                public Builder setContent(String r10) {
                    if (r10 == null) goto L6;
                    this.bitField0_ |= 4;
                    this.content_ = r10;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setContentBytes(ByteString r10) {
                    if (r10 == null) goto L6;
                    this.bitField0_ |= 4;
                    this.content_ = r10;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
                    return setField(r10, r11);
                }

                public Builder setInsertionPoint(String r10) {
                    if (r10 == null) goto L6;
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = r10;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setInsertionPointBytes(ByteString r10) {
                    if (r10 == null) goto L6;
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = r10;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setName(String r10) {
                    if (r10 == null) goto L6;
                    this.bitField0_ |= 1;
                    this.name_ = r10;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setNameBytes(ByteString r10) {
                    if (r10 == null) goto L6;
                    this.bitField0_ |= 1;
                    this.name_ = r10;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
                    return setRepeatedField(r10, r11, r12);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r10) {
                    return setUnknownFields(r10);
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
                public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r10) {
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
                public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
                    return setUnknownFields(r10);
                }

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
                    return (Builder) super.addRepeatedField(r10, r11);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File build() {
                    File r10 = buildPartial();
                    if (r10.isInitialized() == false) goto L6;
                    return r10;
                L6:
                    throw AbstractMessage.Builder.newUninitializedMessageException(r10);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File buildPartial() {
                    File r10 = new File(this, null);
                    int r11 = this.bitField0_;
                    int r12 = 1;
                    if ((r11 & 1) == 1) goto L6;
                    r12 = 0;
                L6:
                    File.access$2102(r10, this.name_);
                    if ((r11 & 2) != 2) goto L9;
                    r12 = r12 | 2;
                L9:
                    File.access$2202(r10, this.insertionPoint_);
                    if ((r11 & 4) != 4) goto L12;
                    r12 = r12 | 4;
                L12:
                    File.access$2302(r10, this.content_);
                    File.access$2402(r10, r12);
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
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                    return mergeFrom(r10, r11);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
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
                public final Builder setUnknownFields(UnknownFieldSet r10) {
                    return (Builder) super.setUnknownFields(r10);
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
                public final Builder mergeUnknownFields(UnknownFieldSet r10) {
                    return (Builder) super.mergeUnknownFields(r10);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.name_ = "";
                    int r10 = this.bitField0_;
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    this.bitField0_ = r10 & (-8);
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

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clone() {
                    return (Builder) super.clone();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message r10) {
                    if ((r10 instanceof File) == true) goto L5;
                    super.mergeFrom(r10);
                    return this;
                L5:
                    return mergeFrom((File) r10);
                }

                private Builder(GeneratedMessageV3.BuilderParent r10) {
                    super(r10);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                public Builder mergeFrom(File r10) {
                    if (r10 != File.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r10.hasName() == false) goto L9;
                    this.bitField0_ |= 1;
                    this.name_ = File.access$2100(r10);
                    onChanged();
                L9:
                    if (r10.hasInsertionPoint() == false) goto L12;
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = File.access$2200(r10);
                    onChanged();
                L12:
                    if (r10.hasContent() == false) goto L14;
                    this.bitField0_ |= 4;
                    this.content_ = File.access$2300(r10);
                    onChanged();
                L14:
                    mergeUnknownFields(File.access$2500(r10));
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                    File r12 = null;
                    File r13 = File.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r13 == null) goto L6;
                    mergeFrom(r13);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    File r14 = (File) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                L13:
                    th = th;
                    r12 = r14;
                L15:
                    if (r12 == null) goto L17;
                    mergeFrom(r12);
                L17:
                    throw th;
                L12:
                    throw e.unwrapIOException();     // Catch: Throwable -> L13
                L7:
                    th = th;
                    goto L15
                }
            }

            static {
                DEFAULT_INSTANCE = new File();
                PARSER = new AnonymousClass1();
            }

            public /* synthetic */ File(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
                this(r10, r11);
            }

            public static /* synthetic */ boolean access$1900() {
                return GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public static /* synthetic */ Object access$2100(File r10) {
                return r10.name_;
            }

            public static /* synthetic */ Object access$2102(File r10, Object r11) {
                r10.name_ = r11;
                return r11;
            }

            public static /* synthetic */ Object access$2200(File r10) {
                return r10.insertionPoint_;
            }

            public static /* synthetic */ Object access$2202(File r10, Object r11) {
                r10.insertionPoint_ = r11;
                return r11;
            }

            public static /* synthetic */ Object access$2300(File r10) {
                return r10.content_;
            }

            public static /* synthetic */ Object access$2302(File r10, Object r11) {
                r10.content_ = r11;
                return r11;
            }

            public static /* synthetic */ int access$2402(File r10, int r11) {
                r10.bitField0_ = r11;
                return r11;
            }

            public static /* synthetic */ UnknownFieldSet access$2500(File r10) {
                return r10.unknownFields;
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$1500();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static File parseDelimitedFrom(InputStream r10) throws IOException {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
            }

            public static File parseFrom(ByteString r10) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(r10);
            }

            public static Parser<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object r10) {
                if (r10 != this) goto L6;
                return true;
            L6:
                if ((r10 instanceof File) == false) goto L8;
                File r11 = (File) r10;
                if (hasName() != r11.hasName()) goto L12;
                boolean r12 = true;
            L14:
                if (hasName() == false) goto L20;
                if (r12 == true) goto L17;
            L19:
                r12 = false;
                goto L20
            L17:
                if (getName().equals(r11.getName()) == false) goto L19;
                r12 = true;
            L20:
                if (r12 == true) goto L22;
            L24:
                boolean r13 = false;
            L26:
                if (hasInsertionPoint() == false) goto L32;
                if (r13 == true) goto L29;
            L31:
                r13 = false;
                goto L32
            L29:
                if (getInsertionPoint().equals(r11.getInsertionPoint()) == false) goto L31;
                r13 = true;
            L32:
                if (r13 == true) goto L34;
            L36:
                boolean r14 = false;
            L38:
                if (hasContent() == false) goto L44;
                if (r14 == true) goto L41;
            L43:
                r14 = false;
                goto L44
            L41:
                if (getContent().equals(r11.getContent()) == false) goto L43;
                r14 = true;
            L44:
                if (r14 == false) goto L49;
                if (this.unknownFields.equals(r11.unknownFields) == false) goto L49;
                return true;
            L49:
                return false;
            L34:
                if (hasContent() != r11.hasContent()) goto L36;
                r14 = true;
                goto L38
            L22:
                if (hasInsertionPoint() != r11.hasInsertionPoint()) goto L24;
                r13 = true;
                goto L26
            L12:
                r12 = false;
                goto L14
            L8:
                return super.equals(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                Object r10 = this.content_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.content_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                Object r10 = this.content_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.content_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                Object r10 = this.insertionPoint_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.insertionPoint_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                Object r10 = this.insertionPoint_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.insertionPoint_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                Object r10 = this.name_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.name_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                Object r10 = this.name_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.name_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int r10 = this.memoizedSize;
                if (r10 == (-1)) goto L6;
                return r10;
            L6:
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r11 = GeneratedMessageV3.computeStringSize(1, this.name_);
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r11 = r11 + GeneratedMessageV3.computeStringSize(2, this.insertionPoint_);
            L13:
                if ((this.bitField0_ & 4) != 4) goto L15;
                r11 = r11 + GeneratedMessageV3.computeStringSize(15, this.content_);
            L15:
                int r12 = r11 + this.unknownFields.getSerializedSize();
                this.memoizedSize = r12;
                return r12;
            L8:
                r11 = 0;
                goto L10
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                int r10 = this.memoizedHashCode;
                if (r10 == 0) goto L5;
                return r10;
            L5:
                int r11 = 779 + getDescriptorForType().hashCode();
                if (hasName() == false) goto L9;
                r11 = (((r11 * 37) + 1) * 53) + getName().hashCode();
            L9:
                if (hasInsertionPoint() == false) goto L12;
                r11 = (((r11 * 37) + 2) * 53) + getInsertionPoint().hashCode();
            L12:
                if (hasContent() == false) goto L14;
                r11 = (((r11 * 37) + 15) * 53) + getContent().hashCode();
            L14:
                int r12 = (r11 * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = r12;
                return r12;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$1600().ensureFieldAccessorsInitialized(File.class, Builder.class);
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
                if ((this.bitField0_ & 1) != 1) goto L6;
                GeneratedMessageV3.writeString(r10, 1, this.name_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                GeneratedMessageV3.writeString(r10, 2, this.insertionPoint_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                GeneratedMessageV3.writeString(r10, 15, this.content_);
            L11:
                this.unknownFields.writeTo(r10);
            }

            public /* synthetic */ File(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            public static Builder newBuilder(File r10) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
            }

            public static File parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

            private File(GeneratedMessageV3.Builder<?> r10) {
                super(r10);
                this.memoizedIsInitialized = -1;
            }

            public static File parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
            }

            public static File parseFrom(byte[] r10) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(r10);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public File getDefaultInstanceForType() {
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

            public static File parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(r10, r11);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            private File() {
                this.memoizedIsInitialized = -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            public static File parseFrom(InputStream r10) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
                return new Builder(r10, null);
            }

            public static File parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
            }

            public static File parseFrom(CodedInputStream r10) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, r10);
            }

            private File(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                this();
                UnknownFieldSet.Builder r12 = UnknownFieldSet.newBuilder();
                boolean r13 = false;
            L3:
                if (r13 == true) goto L31;
                int r14 = r10.readTag();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                if (r14 == 0) goto L14;
                if (r14 != 10) goto L9;
                ByteString r15 = r10.readBytes();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.name_ = r15;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L9:
                if (r14 != 18) goto L11;
                ByteString r16 = r10.readBytes();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.bitField0_ |= 2;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.insertionPoint_ = r16;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L11:
                if (r14 != 122) goto L13;
                ByteString r17 = r10.readBytes();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.bitField0_ |= 4;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.content_ = r17;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L13:
                if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
            L14:
                r13 = true;
                goto L3
            L15:
                th = move-exception;
                this.unknownFields = r12.build();
                makeExtensionsImmutable();
                throw th;
            L19:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L15
            L17:
                e = move-exception;
                throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L15
            L31:
                this.unknownFields = r12.build();
                makeExtensionsImmutable();
            }

            public static File parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
            }
        }

        public interface FileOrBuilder extends MessageOrBuilder {
            String getContent();

            ByteString getContentBytes();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        static {
            DEFAULT_INSTANCE = new CodeGeneratorResponse();
            PARSER = new AnonymousClass1();
        }

        public /* synthetic */ CodeGeneratorResponse(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) throws InvalidProtocolBufferException {
            this(r10, r11);
        }

        public static /* synthetic */ boolean access$2900() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Object access$3100(CodeGeneratorResponse r10) {
            return r10.error_;
        }

        public static /* synthetic */ Object access$3102(CodeGeneratorResponse r10, Object r11) {
            r10.error_ = r11;
            return r11;
        }

        public static /* synthetic */ List access$3200(CodeGeneratorResponse r10) {
            return r10.file_;
        }

        public static /* synthetic */ List access$3202(CodeGeneratorResponse r10, List r11) {
            r10.file_ = r11;
            return r11;
        }

        public static /* synthetic */ int access$3302(CodeGeneratorResponse r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        public static /* synthetic */ boolean access$3400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ UnknownFieldSet access$3500(CodeGeneratorResponse r10) {
            return r10.unknownFields;
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$1300();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r10) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10);
        }

        public static CodeGeneratorResponse parseFrom(ByteString r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10);
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof CodeGeneratorResponse) == false) goto L8;
            CodeGeneratorResponse r11 = (CodeGeneratorResponse) r10;
            if (hasError() != r11.hasError()) goto L12;
            boolean r12 = true;
        L14:
            if (hasError() == false) goto L20;
            if (r12 == true) goto L17;
        L19:
            r12 = false;
            goto L20
        L17:
            if (getError().equals(r11.getError()) == false) goto L19;
            r12 = true;
        L20:
            if (r12 == true) goto L22;
        L24:
            boolean r13 = false;
        L25:
            if (r13 == false) goto L30;
            if (this.unknownFields.equals(r11.unknownFields) == false) goto L30;
            return true;
        L30:
            return false;
        L22:
            if (getFileList().equals(r11.getFileList()) == false) goto L24;
            r13 = true;
            goto L25
        L12:
            r12 = false;
            goto L14
        L8:
            return super.equals(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            Object r10 = this.error_;
            if ((r10 instanceof String) == true) goto L5;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L9;
            this.error_ = r12;
        L9:
            return r12;
        L5:
            return (String) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            Object r10 = this.error_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.error_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int r10) {
            return this.file_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<File> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public FileOrBuilder getFileOrBuilder(int r10) {
            return this.file_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = GeneratedMessageV3.computeStringSize(1, this.error_);
        L10:
            if (r11 >= this.file_.size()) goto L12;
            r12 = r12 + CodedOutputStream.computeMessageSize(15, this.file_.get(r11));
            r11 = r11 + 1;
            goto L10
        L12:
            int r13 = r12 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r13;
            return r13;
        L8:
            r12 = 0;
            goto L10
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r10 = this.memoizedHashCode;
            if (r10 == 0) goto L5;
            return r10;
        L5:
            int r11 = 779 + getDescriptorForType().hashCode();
            if (hasError() == false) goto L9;
            r11 = (((r11 * 37) + 1) * 53) + getError().hashCode();
        L9:
            if (getFileCount() <= 0) goto L11;
            r11 = (((r11 * 37) + 15) * 53) + getFileList().hashCode();
        L11:
            int r12 = (r11 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$1400().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
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
            if ((this.bitField0_ & 1) != 1) goto L5;
            GeneratedMessageV3.writeString(r10, 1, this.error_);
        L5:
            int r11 = 0;
        L7:
            if (r11 >= this.file_.size()) goto L9;
            r10.writeMessage(15, this.file_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            this.unknownFields.writeTo(r10);
        }

        public /* synthetic */ CodeGeneratorResponse(GeneratedMessageV3.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static Builder newBuilder(CodeGeneratorResponse r10) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
        }

        public static CodeGeneratorResponse parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
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

        private CodeGeneratorResponse(GeneratedMessageV3.Builder<?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorResponse parseFrom(byte[] r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorResponse getDefaultInstanceForType() {
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

        public static CodeGeneratorResponse parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private CodeGeneratorResponse() {
            this.memoizedIsInitialized = -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        public static CodeGeneratorResponse parseFrom(InputStream r10) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r10) {
            return new Builder(r10, null);
        }

        public static CodeGeneratorResponse parseFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
        }

        private CodeGeneratorResponse(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder r12 = UnknownFieldSet.newBuilder();
            boolean r13 = false;
            char r14 = 0;
        L4:
            if (r13 == true) goto L36;
            int r15 = r10.readTag();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            if (r15 == 0) goto L13;
            if (r15 != 10) goto L10;
            ByteString r16 = r10.readBytes();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            this.error_ = r16;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            goto L4
        L10:
            if (r15 != 122) goto L12;
            if ((r14 & 2) == 2) goto L23;
            this.file_ = new ArrayList();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            r14 = 2;
        L23:
            this.file_.add((File) r10.readMessage(File.PARSER, r11));     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            goto L4
        L12:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
        L13:
            r13 = true;
            goto L4
        L14:
            th = move-exception;
            if ((r14 & 2) != 2) goto L33;
            this.file_ = Collections.unmodifiableList(this.file_);
        L33:
            this.unknownFields = r12.build();
            makeExtensionsImmutable();
            throw th;
        L18:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L16:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L36:
            if ((r14 & 2) != 2) goto L38;
            this.file_ = Collections.unmodifiableList(this.file_);
        L38:
            this.unknownFields = r12.build();
            makeExtensionsImmutable();
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r10) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, r10);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, r10, r11);
        }
    }

    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int r10);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int r10);

        List<? extends CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        boolean hasError();
    }

    static {
        Descriptors.FileDescriptor.InternalDescriptorAssigner r10 = new AnonymousClass1();
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"}\n\u0014CodeGeneratorRequest\u0012\u0018\n\u0010file_to_generate\u0018\u0001 \u0003(\t\u0012\u0011\n\tparameter\u0018\u0002 \u0001(\t\u00128\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"ª\u0001\n\u0015CodeGeneratorResponse\u0012\r\n\u0005error\u0018\u0001 \u0001(\t\u0012B\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.File\u001a>\n\u0004File\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0017\n\u000finsertion_point\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007content\u0018\u000f \u0001(\tB", "7\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ\tplugin_go"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()}, r10);
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = r11;
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"FileToGenerate", "Parameter", "ProtoFile"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = r12;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"Error", "File"});
        Descriptors.Descriptor r13 = r12.getNestedTypes().get(0);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = r13;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"Name", "InsertionPoint", "Content"});
        DescriptorProtos.getDescriptor();
    }

    private PluginProtos() {
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$100() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$1300() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$1400() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$1500() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$1600() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$3702(Descriptors.FileDescriptor r10) {
        descriptor = r10;
        return r10;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite r10) {
    }

    public static void registerAllExtensions(ExtensionRegistry r10) {
        registerAllExtensions(r10);
    }
}
