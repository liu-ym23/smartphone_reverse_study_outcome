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
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class PluginProtos {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable = null;

    /* JADX INFO: renamed from: com.google.protobuf.compiler.PluginProtos$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class CodeGeneratorRequest extends GeneratedMessage implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = null;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        private static final Parser<CodeGeneratorRequest> PARSER = null;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        public static final int SOURCE_FILE_DESCRIPTORS_FIELD_NUMBER = 17;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Version compilerVersion_;
        private LazyStringArrayList fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile Object parameter_;
        private List<DescriptorProtos.FileDescriptorProto> protoFile_;
        private List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptors_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> compilerVersionBuilder_;
            private Version compilerVersion_;
            private LazyStringArrayList fileToGenerate_;
            private Object parameter_;
            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> protoFile_;
            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> sourceFileDescriptorsBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptors_;

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

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public /* bridge */ /* synthetic */ List getFileToGenerateList() {
                return getFileToGenerateList();
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
                return PluginProtos.access$1000();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$1100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            private Builder() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(AbstractMessage.BuilderParent r3) {
                super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorRequest.access$1400() == false) goto L6;
                internalGetProtoFileFieldBuilder();
                internalGetSourceFileDescriptorsFieldBuilder();
                internalGetCompilerVersionFieldBuilder();
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
            L6:
                this.bitField0_ &= -5;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r1 = this.sourceFileDescriptorsBuilder_;
                if (r1 != null) goto L9;
                this.sourceFileDescriptors_ = Collections.emptyList();
            L10:
                this.bitField0_ &= -9;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r2 = this.compilerVersionBuilder_;
                if (r2 == null) goto L13;
                r2.dispose();
                this.compilerVersionBuilder_ = null;
            L13:
                return this;
            L9:
                this.sourceFileDescriptors_ = null;
                r1.clear();
                goto L10
            L5:
                this.protoFile_ = null;
                r0.clear();
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$1000();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest r0 = new CodeGeneratorRequest(this, null);
                buildPartialRepeatedFields(r0);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r0);
            L5:
                onBuilt();
                return r0;
            }

            private void buildPartialRepeatedFields(CodeGeneratorRequest r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 == null) goto L5;
                CodeGeneratorRequest.access$1602(r2, r0.build());
            L9:
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r1 = this.sourceFileDescriptorsBuilder_;
                if (r1 == null) goto L12;
                CodeGeneratorRequest.access$1702(r2, r1.build());
                return;
            L12:
                if ((this.bitField0_ & 8) == 0) goto L14;
                this.sourceFileDescriptors_ = Collections.unmodifiableList(this.sourceFileDescriptors_);
                this.bitField0_ &= -9;
            L14:
                CodeGeneratorRequest.access$1702(r2, this.sourceFileDescriptors_);
                return;
            L5:
                if ((this.bitField0_ & 4) == 0) goto L7;
                this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                this.bitField0_ &= -5;
            L7:
                CodeGeneratorRequest.access$1602(r2, this.protoFile_);
                goto L9
            }

            private void buildPartial0(CodeGeneratorRequest r4) {
                int r0 = this.bitField0_;
                if ((r0 & 1) == 0) goto L5;
                this.fileToGenerate_.makeImmutable();
                CodeGeneratorRequest.access$1802(r4, this.fileToGenerate_);
            L5:
                int r1 = 0;
                if ((r0 & 2) == 0) goto L9;
                CodeGeneratorRequest.access$1902(r4, this.parameter_);
                r1 = 1;
            L9:
                if ((r0 & 16) == 0) goto L15;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r2 = this.compilerVersionBuilder_;
                if (r2 != null) goto L13;
                Version r3 = this.compilerVersion_;
            L14:
                CodeGeneratorRequest.access$2002(r4, r3);
                r1 = r1 | 2;
                goto L15
            L13:
                r3 = (Version) ZeusTransformUtils.preCheckCast(r2.build(), Version.class, "com.obric.aiagent.plugin");
            L15:
                CodeGeneratorRequest.access$2176(r4, r1);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r3) {
                Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r4, CodeGeneratorRequest.class) == true) goto L5;
                super.mergeFrom(r4);
                return this;
            L5:
                return mergeFrom((CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(r4, CodeGeneratorRequest.class, "com.obric.aiagent.plugin"));
            }

            public Builder mergeFrom(CodeGeneratorRequest r4) {
                if (r4 != CodeGeneratorRequest.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (CodeGeneratorRequest.access$1800(r4).isEmpty() == true) goto L13;
                if (this.fileToGenerate_.isEmpty() == false) goto L10;
                this.fileToGenerate_ = CodeGeneratorRequest.access$1800(r4);
                this.bitField0_ |= 1;
            L11:
                onChanged();
                goto L13
            L10:
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.addAll(CodeGeneratorRequest.access$1800(r4));
            L13:
                if (r4.hasParameter() == false) goto L15;
                this.parameter_ = CodeGeneratorRequest.access$1900(r4);
                this.bitField0_ |= 2;
                onChanged();
            L15:
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r1 = null;
                if (this.protoFileBuilder_ != null) goto L25;
                if (CodeGeneratorRequest.access$1600(r4).isEmpty() == true) goto L35;
                if (this.protoFile_.isEmpty() == false) goto L22;
                this.protoFile_ = CodeGeneratorRequest.access$1600(r4);
                this.bitField0_ &= -5;
            L23:
                onChanged();
                goto L35
            L22:
                ensureProtoFileIsMutable();
                this.protoFile_.addAll(CodeGeneratorRequest.access$1600(r4));
            L35:
                if (this.sourceFileDescriptorsBuilder_ != null) goto L44;
                if (CodeGeneratorRequest.access$1700(r4).isEmpty() == true) goto L53;
                if (this.sourceFileDescriptors_.isEmpty() == false) goto L41;
                this.sourceFileDescriptors_ = CodeGeneratorRequest.access$1700(r4);
                this.bitField0_ &= -9;
            L42:
                onChanged();
                goto L53
            L41:
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.addAll(CodeGeneratorRequest.access$1700(r4));
            L53:
                if (r4.hasCompilerVersion() == false) goto L55;
                mergeCompilerVersion(r4.getCompilerVersion());
            L55:
                mergeUnknownFields(r4.getUnknownFields());
                onChanged();
                return this;
            L44:
                if (CodeGeneratorRequest.access$1700(r4).isEmpty() == true) goto L53;
                if (this.sourceFileDescriptorsBuilder_.isEmpty() == false) goto L51;
                this.sourceFileDescriptorsBuilder_.dispose();
                this.sourceFileDescriptorsBuilder_ = null;
                this.sourceFileDescriptors_ = CodeGeneratorRequest.access$1700(r4);
                this.bitField0_ &= -9;
                if (CodeGeneratorRequest.access$2300() == false) goto L50;
                r1 = internalGetSourceFileDescriptorsFieldBuilder();
            L50:
                this.sourceFileDescriptorsBuilder_ = r1;
                goto L53
            L51:
                this.sourceFileDescriptorsBuilder_.addAllMessages(CodeGeneratorRequest.access$1700(r4));
                goto L53
            L25:
                if (CodeGeneratorRequest.access$1600(r4).isEmpty() == true) goto L35;
                if (this.protoFileBuilder_.isEmpty() == false) goto L33;
                this.protoFileBuilder_.dispose();
                this.protoFileBuilder_ = null;
                this.protoFile_ = CodeGeneratorRequest.access$1600(r4);
                this.bitField0_ &= -5;
                if (CodeGeneratorRequest.access$2200() == false) goto L31;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = internalGetProtoFileFieldBuilder();
            L32:
                this.protoFileBuilder_ = r0;
                goto L35
            L31:
                r0 = null;
                goto L32
            L33:
                this.protoFileBuilder_.addAllMessages(CodeGeneratorRequest.access$1600(r4));
                goto L35
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getProtoFileCount()) goto L9;
                if (getProtoFile(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r2 = 0;
            L11:
                if (r2 >= getSourceFileDescriptorsCount()) goto L16;
                if (getSourceFileDescriptors(r2).isInitialized() == false) goto L14;
                r2 = r2 + 1;
                goto L11
            L14:
                return false;
            L16:
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
                Objects.requireNonNull(r7);
                boolean r0 = false;
            L3:
                if (r0 == true) goto L40;
                int r1 = r6.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            L6:
                if (r1 == 0) goto L32;
                if (r1 != 10) goto L10;
                ByteString r2 = r6.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                ensureFileToGenerateIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.fileToGenerate_.add(r2);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L10:
                if (r1 != 18) goto L12;
                this.parameter_ = r6.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L12:
                if (r1 != 26) goto L14;
                r6.readMessage(internalGetCompilerVersionFieldBuilder().getBuilder(), r7);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 16;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L14:
                if (r1 != 122) goto L16;
                DescriptorProtos.FileDescriptorProto r3 = (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(r6.readMessage(DescriptorProtos.FileDescriptorProto.parser(), r7), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r4 = this.protoFileBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r4 == null) goto L26;
                r4.addMessage(r3);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L26:
                ensureProtoFileIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.protoFile_.add(r3);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L16:
                if (r1 != 138) goto L18;
                DescriptorProtos.FileDescriptorProto r5 = (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(r6.readMessage(DescriptorProtos.FileDescriptorProto.parser(), r7), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.sourceFileDescriptorsBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r8 == null) goto L22;
                r8.addMessage(r5);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L22:
                ensureSourceFileDescriptorsIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.sourceFileDescriptors_.add(r5);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L18:
                if (super.parseUnknownField(r6, r7, r1) == true) goto L3;
            L32:
                r0 = true;
            L35:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L33
            L33:
                th = move-exception;
                onChanged();
                throw th;
            L40:
                onChanged();
                return this;
            }

            private void ensureFileToGenerateIsMutable() {
                if (this.fileToGenerate_.isModifiable() == true) goto L5;
                this.fileToGenerate_ = new LazyStringArrayList(this.fileToGenerate_);
            L5:
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ProtocolStringList getFileToGenerateList() {
                this.fileToGenerate_.makeImmutable();
                return this.fileToGenerate_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int r1) {
                return this.fileToGenerate_.get(r1);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int r1) {
                return this.fileToGenerate_.getByteString(r1);
            }

            public Builder setFileToGenerate(int r2, String r3) {
                Objects.requireNonNull(r3);
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(r2, r3);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addFileToGenerate(String r2) {
                Objects.requireNonNull(r2);
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r2);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addAllFileToGenerate(Iterable<String> r3) {
                Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll(r4, this.fileToGenerate_);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearFileToGenerate() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString r2) {
                Objects.requireNonNull(r2);
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r2);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getParameter() {
                Object r0 = this.parameter_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
                ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.parameter_ = r2;
            L7:
                return r2;
            L9:
                return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                Object r0 = this.parameter_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                this.parameter_ = r1;
                return r1;
            L7:
                return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            }

            public Builder setParameter(String r1) {
                Objects.requireNonNull(r1);
                this.parameter_ = r1;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearParameter() {
                this.parameter_ = CodeGeneratorRequest.getDefaultInstance().getParameter();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder setParameterBytes(ByteString r1) {
                Objects.requireNonNull(r1);
                this.parameter_ = r1;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) != 0) goto L6;
                this.protoFile_ = new ArrayList(this.protoFile_);
                this.bitField0_ |= 4;
                return;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.protoFile_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L7;
                return this.protoFile_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L7;
                return (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(this.protoFile_.get(r3), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");
            L7:
                return (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(r0.getMessage(r3), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");
            }

            public Builder setProtoFile(int r2, DescriptorProtos.FileDescriptorProto r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r3);
                ensureProtoFileIsMutable();
                this.protoFile_.set(r2, r3);
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3);
                goto L6
            }

            public Builder setProtoFile(int r2, DescriptorProtos.FileDescriptorProto.Builder r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.set(r2, r3.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.build());
                goto L6
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r2);
                ensureProtoFileIsMutable();
                this.protoFile_.add(r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2);
                goto L6
            }

            public Builder addProtoFile(int r2, DescriptorProtos.FileDescriptorProto r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r3);
                ensureProtoFileIsMutable();
                this.protoFile_.add(r2, r3);
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3);
                goto L6
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r2.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.build());
                goto L6
            }

            public Builder addProtoFile(int r2, DescriptorProtos.FileDescriptorProto.Builder r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r2, r3.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.build());
                goto L6
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> r3) {
                Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                ensureProtoFileIsMutable();
                AbstractMessageLite.Builder.addAll(r4, this.protoFile_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r4);
                goto L6
            }

            public Builder clearProtoFile() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder removeProtoFile(int r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.remove(r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int r2) {
                return (DescriptorProtos.FileDescriptorProto.Builder) ZeusTransformUtils.preCheckCast(internalGetProtoFileFieldBuilder().getBuilder(r2), DescriptorProtos.FileDescriptorProto.Builder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 != null) goto L7;
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) ZeusTransformUtils.preCheckCast(this.protoFile_.get(r3), DescriptorProtos.FileDescriptorProtoOrBuilder.class, "com.obric.aiagent.plugin");
            L7:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), DescriptorProtos.FileDescriptorProtoOrBuilder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.protoFileBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.protoFile_);
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) ZeusTransformUtils.preCheckCast(internalGetProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance()), DescriptorProtos.FileDescriptorProto.Builder.class, "com.obric.aiagent.plugin");
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int r2) {
                return (DescriptorProtos.FileDescriptorProto.Builder) ZeusTransformUtils.preCheckCast(internalGetProtoFileFieldBuilder().addBuilder(r2, DescriptorProtos.FileDescriptorProto.getDefaultInstance()), DescriptorProtos.FileDescriptorProto.Builder.class, "com.obric.aiagent.plugin");
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return internalGetProtoFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> internalGetProtoFileFieldBuilder() {
                if (this.protoFileBuilder_ != null) goto L10;
                List<DescriptorProtos.FileDescriptorProto> r1 = this.protoFile_;
                if ((this.bitField0_ & 4) == 0) goto L7;
                boolean r2 = true;
            L8:
                this.protoFileBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
                this.protoFile_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.protoFileBuilder_;
            }

            private void ensureSourceFileDescriptorsIsMutable() {
                if ((this.bitField0_ & 8) != 0) goto L6;
                this.sourceFileDescriptors_ = new ArrayList(this.sourceFileDescriptors_);
                this.bitField0_ |= 8;
                return;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.sourceFileDescriptors_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getSourceFileDescriptorsCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L7;
                return this.sourceFileDescriptors_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L7;
                return (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(this.sourceFileDescriptors_.get(r3), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");
            L7:
                return (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(r0.getMessage(r3), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");
            }

            public Builder setSourceFileDescriptors(int r2, DescriptorProtos.FileDescriptorProto r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r3);
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.set(r2, r3);
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3);
                goto L6
            }

            public Builder setSourceFileDescriptors(int r2, DescriptorProtos.FileDescriptorProto.Builder r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.set(r2, r3.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.build());
                goto L6
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r2);
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2);
                goto L6
            }

            public Builder addSourceFileDescriptors(int r2, DescriptorProtos.FileDescriptorProto r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r3);
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r2, r3);
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3);
                goto L6
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto.Builder r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r2.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.build());
                goto L6
            }

            public Builder addSourceFileDescriptors(int r2, DescriptorProtos.FileDescriptorProto.Builder r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r2, r3.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.build());
                goto L6
            }

            public Builder addAllSourceFileDescriptors(Iterable<? extends DescriptorProtos.FileDescriptorProto> r3) {
                Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                AbstractMessageLite.Builder.addAll(r4, this.sourceFileDescriptors_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r4);
                goto L6
            }

            public Builder clearSourceFileDescriptors() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                this.sourceFileDescriptors_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder removeSourceFileDescriptors(int r2) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.remove(r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder getSourceFileDescriptorsBuilder(int r2) {
                return (DescriptorProtos.FileDescriptorProto.Builder) ZeusTransformUtils.preCheckCast(internalGetSourceFileDescriptorsFieldBuilder().getBuilder(r2), DescriptorProtos.FileDescriptorProto.Builder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r3) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 != null) goto L7;
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) ZeusTransformUtils.preCheckCast(this.sourceFileDescriptors_.get(r3), DescriptorProtos.FileDescriptorProtoOrBuilder.class, "com.obric.aiagent.plugin");
            L7:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), DescriptorProtos.FileDescriptorProtoOrBuilder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r0 = this.sourceFileDescriptorsBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.sourceFileDescriptors_);
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) ZeusTransformUtils.preCheckCast(internalGetSourceFileDescriptorsFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance()), DescriptorProtos.FileDescriptorProto.Builder.class, "com.obric.aiagent.plugin");
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder(int r2) {
                return (DescriptorProtos.FileDescriptorProto.Builder) ZeusTransformUtils.preCheckCast(internalGetSourceFileDescriptorsFieldBuilder().addBuilder(r2, DescriptorProtos.FileDescriptorProto.getDefaultInstance()), DescriptorProtos.FileDescriptorProto.Builder.class, "com.obric.aiagent.plugin");
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getSourceFileDescriptorsBuilderList() {
                return internalGetSourceFileDescriptorsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> internalGetSourceFileDescriptorsFieldBuilder() {
                if (this.sourceFileDescriptorsBuilder_ != null) goto L10;
                List<DescriptorProtos.FileDescriptorProto> r1 = this.sourceFileDescriptors_;
                if ((this.bitField0_ & 8) == 0) goto L7;
                boolean r2 = true;
            L8:
                this.sourceFileDescriptorsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
                this.sourceFileDescriptors_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.sourceFileDescriptorsBuilder_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasCompilerVersion() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public Version getCompilerVersion() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r0 = this.compilerVersionBuilder_;
                if (r0 != null) goto L9;
                Version r2 = this.compilerVersion_;
                if (r2 == null) goto L7;
                return r2;
            L7:
                return Version.getDefaultInstance();
            L9:
                return (Version) ZeusTransformUtils.preCheckCast(r0.getMessage(), Version.class, "com.obric.aiagent.plugin");
            }

            public Builder setCompilerVersion(Version r2) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r0 = this.compilerVersionBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r2);
                this.compilerVersion_ = r2;
            L6:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                r0.setMessage(r2);
                goto L6
            }

            public Builder setCompilerVersion(Version.Builder r2) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r0 = this.compilerVersionBuilder_;
                if (r0 != null) goto L5;
                this.compilerVersion_ = r2.build();
            L6:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                r0.setMessage(r2.build());
                goto L6
            }

            public Builder mergeCompilerVersion(Version r3) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r0 = this.compilerVersionBuilder_;
                if (r0 == null) goto L5;
                r0.mergeFrom(r3);
            L14:
                if (this.compilerVersion_ == null) goto L16;
                this.bitField0_ |= 16;
                onChanged();
            L16:
                return this;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L11;
                Version r1 = this.compilerVersion_;
                if (r1 == null) goto L11;
                if (r1 == Version.getDefaultInstance()) goto L11;
                getCompilerVersionBuilder().mergeFrom(r3);
            L11:
                this.compilerVersion_ = r3;
                goto L14
            }

            public Builder clearCompilerVersion() {
                this.bitField0_ &= -17;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r1 = this.compilerVersionBuilder_;
                if (r1 == null) goto L5;
                r1.dispose();
                this.compilerVersionBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return (Version.Builder) ZeusTransformUtils.preCheckCast(internalGetCompilerVersionFieldBuilder().getBuilder(), Version.Builder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public VersionOrBuilder getCompilerVersionOrBuilder() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r0 = this.compilerVersionBuilder_;
                if (r0 != null) goto L5;
                Version r2 = this.compilerVersion_;
                if (r2 == null) goto L9;
                return r2;
            L9:
                return Version.getDefaultInstance();
            L5:
                return (VersionOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(), VersionOrBuilder.class, "com.obric.aiagent.plugin");
            }

            private SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> internalGetCompilerVersionFieldBuilder() {
                if (this.compilerVersionBuilder_ != null) goto L6;
                this.compilerVersionBuilder_ = new SingleFieldBuilder(getCompilerVersion(), getParentForChildren(), isClean());
                this.compilerVersion_ = null;
            L6:
                return this.compilerVersionBuilder_;
            }
        }

        /* synthetic */ CodeGeneratorRequest(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ boolean access$1400() {
            return alwaysUseFieldBuilders;
        }

        static /* synthetic */ List access$1600(CodeGeneratorRequest r0) {
            return r0.protoFile_;
        }

        static /* synthetic */ List access$1602(CodeGeneratorRequest r2, List r3) {
            List<DescriptorProtos.FileDescriptorProto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            r2.protoFile_ = r4;
            return r4;
        }

        static /* synthetic */ List access$1700(CodeGeneratorRequest r0) {
            return r0.sourceFileDescriptors_;
        }

        static /* synthetic */ List access$1702(CodeGeneratorRequest r2, List r3) {
            List<DescriptorProtos.FileDescriptorProto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            r2.sourceFileDescriptors_ = r4;
            return r4;
        }

        static /* synthetic */ LazyStringArrayList access$1800(CodeGeneratorRequest r0) {
            return r0.fileToGenerate_;
        }

        static /* synthetic */ LazyStringArrayList access$1802(CodeGeneratorRequest r0, LazyStringArrayList r1) {
            r0.fileToGenerate_ = r1;
            return r1;
        }

        static /* synthetic */ Object access$1900(CodeGeneratorRequest r0) {
            return r0.parameter_;
        }

        static /* synthetic */ Object access$1902(CodeGeneratorRequest r0, Object r1) {
            r0.parameter_ = r1;
            return r1;
        }

        static /* synthetic */ Version access$2002(CodeGeneratorRequest r0, Version r1) {
            r0.compilerVersion_ = r1;
            return r1;
        }

        static /* synthetic */ int access$2176(CodeGeneratorRequest r1, int r2) {
            int r3 = r2 | r1.bitField0_;
            r1.bitField0_ = r3;
            return r3;
        }

        static /* synthetic */ boolean access$2200() {
            return alwaysUseFieldBuilders;
        }

        static /* synthetic */ boolean access$2300() {
            return alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public /* bridge */ /* synthetic */ List getFileToGenerateList() {
            return getFileToGenerateList();
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

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CodeGeneratorRequest.class.getName());
            DEFAULT_INSTANCE = new CodeGeneratorRequest();
            PARSER = new AnonymousClass1();
        }

        private CodeGeneratorRequest(GeneratedMessage.Builder<?> r1) {
            super(r1);
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = -1;
        }

        private CodeGeneratorRequest() {
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = -1;
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
            this.sourceFileDescriptors_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$1000();
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$1100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int r1) {
            return this.fileToGenerate_.get(r1);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int r1) {
            return this.fileToGenerate_.getByteString(r1);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getParameter() {
            Object r0 = this.parameter_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
            ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.parameter_ = r2;
        L9:
            return r2;
        L5:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            Object r0 = this.parameter_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
            this.parameter_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int r2) {
            return (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(this.protoFile_.get(r2), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r2) {
            return (DescriptorProtos.FileDescriptorProtoOrBuilder) ZeusTransformUtils.preCheckCast(this.protoFile_.get(r2), DescriptorProtos.FileDescriptorProtoOrBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
            return this.sourceFileDescriptors_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
            return this.sourceFileDescriptors_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getSourceFileDescriptorsCount() {
            return this.sourceFileDescriptors_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r2) {
            return (DescriptorProtos.FileDescriptorProto) ZeusTransformUtils.preCheckCast(this.sourceFileDescriptors_.get(r2), DescriptorProtos.FileDescriptorProto.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r2) {
            return (DescriptorProtos.FileDescriptorProtoOrBuilder) ZeusTransformUtils.preCheckCast(this.sourceFileDescriptors_.get(r2), DescriptorProtos.FileDescriptorProtoOrBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasCompilerVersion() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public Version getCompilerVersion() {
            Version r0 = this.compilerVersion_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Version.getDefaultInstance();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public VersionOrBuilder getCompilerVersionOrBuilder() {
            Version r0 = this.compilerVersion_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Version.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getProtoFileCount()) goto L16;
            if (getProtoFile(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r2 = 0;
        L18:
            if (r2 >= getSourceFileDescriptorsCount()) goto L24;
            if (getSourceFileDescriptors(r2).isInitialized() == false) goto L21;
            r2 = r2 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r7) {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r1 >= this.fileToGenerate_.size()) goto L7;
            GeneratedMessage.writeString(r7, 1, this.fileToGenerate_.getRaw(r1));
            r1 = r1 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) == 0) goto L10;
            GeneratedMessage.writeString(r7, 2, this.parameter_);
        L10:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r7.writeMessage(3, getCompilerVersion());
        L12:
            int r2 = 0;
        L14:
            if (r2 >= this.protoFile_.size()) goto L17;
            r7.writeMessage(15, (MessageLite) ZeusTransformUtils.preCheckCast(this.protoFile_.get(r2), MessageLite.class, "com.obric.aiagent.plugin"));
            r2 = r2 + 1;
        L17:
            if (r0 >= this.sourceFileDescriptors_.size()) goto L19;
            r7.writeMessage(17, (MessageLite) ZeusTransformUtils.preCheckCast(this.sourceFileDescriptors_.get(r0), MessageLite.class, "com.obric.aiagent.plugin"));
            r0 = r0 + 1;
            goto L17
        L19:
            getUnknownFields().writeTo(r7);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
        L7:
            if (r2 >= this.fileToGenerate_.size()) goto L9;
            r3 = r3 + computeStringSizeNoTag(this.fileToGenerate_.getRaw(r2));
            r2 = r2 + 1;
            goto L7
        L9:
            int r4 = (r3 + 0) + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) == 0) goto L13;
            r4 = r4 + GeneratedMessage.computeStringSize(2, this.parameter_);
        L13:
            if ((this.bitField0_ & 2) == 0) goto L15;
            r4 = r4 + CodedOutputStream.computeMessageSize(3, getCompilerVersion());
        L15:
            int r5 = 0;
        L17:
            if (r5 >= this.protoFile_.size()) goto L20;
            r4 = r4 + CodedOutputStream.computeMessageSize(15, (MessageLite) ZeusTransformUtils.preCheckCast(this.protoFile_.get(r5), MessageLite.class, "com.obric.aiagent.plugin"));
            r5 = r5 + 1;
        L20:
            if (r1 >= this.sourceFileDescriptors_.size()) goto L22;
            r4 = r4 + CodedOutputStream.computeMessageSize(17, (MessageLite) ZeusTransformUtils.preCheckCast(this.sourceFileDescriptors_.get(r1), MessageLite.class, "com.obric.aiagent.plugin"));
            r1 = r1 + 1;
            goto L20
        L22:
            int r6 = r4 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r6;
            return r6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CodeGeneratorRequest.class) == false) goto L8;
            CodeGeneratorRequest r6 = (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(r5, CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
            if (getFileToGenerateList().equals(r6.getFileToGenerateList()) == true) goto L13;
            return false;
        L13:
            if (hasParameter() == r6.hasParameter()) goto L16;
            return false;
        L16:
            if (hasParameter() == false) goto L21;
            if (getParameter().equals(r6.getParameter()) == true) goto L21;
            return false;
        L21:
            if (getProtoFileList().equals(r6.getProtoFileList()) == true) goto L24;
            return false;
        L24:
            if (getSourceFileDescriptorsList().equals(r6.getSourceFileDescriptorsList()) == true) goto L27;
            return false;
        L27:
            if (hasCompilerVersion() == r6.hasCompilerVersion()) goto L30;
            return false;
        L30:
            if (hasCompilerVersion() == false) goto L35;
            if (getCompilerVersion().equals(r6.getCompilerVersion()) == true) goto L35;
            return false;
        L35:
            if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L37;
            return false;
        L37:
            return true;
        L8:
            return super.equals(r5);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) goto L5;
            int r0 = 779 + getDescriptor().hashCode();
            if (getFileToGenerateCount() <= 0) goto L10;
            r0 = (((r0 * 37) + 1) * 53) + getFileToGenerateList().hashCode();
        L10:
            if (hasParameter() == false) goto L13;
            r0 = (((r0 * 37) + 2) * 53) + getParameter().hashCode();
        L13:
            if (getProtoFileCount() <= 0) goto L16;
            r0 = (((r0 * 37) + 15) * 53) + getProtoFileList().hashCode();
        L16:
            if (getSourceFileDescriptorsCount() <= 0) goto L19;
            r0 = (((r0 * 37) + 17) * 53) + getSourceFileDescriptorsList().hashCode();
        L19:
            if (hasCompilerVersion() == false) goto L21;
            r0 = (((r0 * 37) + 3) * 53) + getCompilerVersion().hashCode();
        L21:
            int r1 = (r0 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r1;
            return r1;
        L5:
            return this.memoizedHashCode;
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(ByteString r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(ByteString r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(byte[] r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(byte[] r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(InputStream r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorRequest) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CodeGeneratorRequest.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest r1) {
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

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        Version getCompilerVersion();

        VersionOrBuilder getCompilerVersionOrBuilder();

        String getFileToGenerate(int r1);

        ByteString getFileToGenerateBytes(int r1);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int r1);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r1);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r1);

        int getSourceFileDescriptorsCount();

        List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r1);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    public static final class CodeGeneratorResponse extends GeneratedMessage implements CodeGeneratorResponseOrBuilder {
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = null;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        public static final int MAXIMUM_EDITION_FIELD_NUMBER = 4;
        public static final int MINIMUM_EDITION_FIELD_NUMBER = 3;
        private static final Parser<CodeGeneratorResponse> PARSER = null;
        public static final int SUPPORTED_FEATURES_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object error_;
        private List<File> file_;
        private int maximumEdition_;
        private byte memoizedIsInitialized;
        private int minimumEdition_;
        private long supportedFeatures_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private Object error_;
            private RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> fileBuilder_;
            private List<File> file_;
            private int maximumEdition_;
            private int minimumEdition_;
            private long supportedFeatures_;

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
                return PluginProtos.access$2400();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$2500().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
            }

            private Builder() {
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            private Builder(AbstractMessage.BuilderParent r3) {
                super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.error_ = "";
                this.supportedFeatures_ = 0;
                this.minimumEdition_ = 0;
                this.maximumEdition_ = 0;
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                this.file_ = Collections.emptyList();
            L6:
                this.bitField0_ &= -17;
                return this;
            L5:
                this.file_ = null;
                r0.clear();
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$2400();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse r0 = new CodeGeneratorResponse(this, null);
                buildPartialRepeatedFields(r0);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r0);
            L5:
                onBuilt();
                return r0;
            }

            private void buildPartialRepeatedFields(CodeGeneratorResponse r2) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 == null) goto L5;
                CodeGeneratorResponse.access$4002(r2, r0.build());
                return;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L7;
                this.file_ = Collections.unmodifiableList(this.file_);
                this.bitField0_ &= -17;
            L7:
                CodeGeneratorResponse.access$4002(r2, this.file_);
            }

            private void buildPartial0(CodeGeneratorResponse r5) {
                int r0 = this.bitField0_;
                if ((r0 & 1) == 0) goto L5;
                CodeGeneratorResponse.access$4102(r5, this.error_);
                int r1 = 1;
            L7:
                if ((r0 & 2) == 0) goto L10;
                CodeGeneratorResponse.access$4202(r5, this.supportedFeatures_);
                r1 = r1 | 2;
            L10:
                if ((r0 & 4) == 0) goto L13;
                CodeGeneratorResponse.access$4302(r5, this.minimumEdition_);
                r1 = r1 | 4;
            L13:
                if ((r0 & 8) == 0) goto L15;
                CodeGeneratorResponse.access$4402(r5, this.maximumEdition_);
                r1 = r1 | 8;
            L15:
                CodeGeneratorResponse.access$4576(r5, r1);
                return;
            L5:
                r1 = 0;
                goto L7
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r3) {
                Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r4, CodeGeneratorResponse.class) == true) goto L5;
                super.mergeFrom(r4);
                return this;
            L5:
                return mergeFrom((CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(r4, CodeGeneratorResponse.class, "com.obric.aiagent.plugin"));
            }

            public Builder mergeFrom(CodeGeneratorResponse r3) {
                if (r3 != CodeGeneratorResponse.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasError() == false) goto L9;
                this.error_ = CodeGeneratorResponse.access$4100(r3);
                this.bitField0_ |= 1;
                onChanged();
            L9:
                if (r3.hasSupportedFeatures() == false) goto L12;
                setSupportedFeatures(r3.getSupportedFeatures());
            L12:
                if (r3.hasMinimumEdition() == false) goto L15;
                setMinimumEdition(r3.getMinimumEdition());
            L15:
                if (r3.hasMaximumEdition() == false) goto L18;
                setMaximumEdition(r3.getMaximumEdition());
            L18:
                if (this.fileBuilder_ != null) goto L27;
                if (CodeGeneratorResponse.access$4000(r3).isEmpty() == false) goto L22;
            L35:
                mergeUnknownFields(r3.getUnknownFields());
                onChanged();
                return this;
            L22:
                if (this.file_.isEmpty() == false) goto L24;
                this.file_ = CodeGeneratorResponse.access$4000(r3);
                this.bitField0_ &= -17;
            L25:
                onChanged();
                goto L35
            L24:
                ensureFileIsMutable();
                this.file_.addAll(CodeGeneratorResponse.access$4000(r3));
                goto L25
            L27:
                if (CodeGeneratorResponse.access$4000(r3).isEmpty() == true) goto L35;
                if (this.fileBuilder_.isEmpty() == false) goto L34;
                this.fileBuilder_.dispose();
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = null;
                this.fileBuilder_ = null;
                this.file_ = CodeGeneratorResponse.access$4000(r3);
                this.bitField0_ &= -17;
                if (CodeGeneratorResponse.access$4600() == false) goto L33;
                r0 = internalGetFileFieldBuilder();
            L33:
                this.fileBuilder_ = r0;
                goto L35
            L34:
                this.fileBuilder_.addAllMessages(CodeGeneratorResponse.access$4000(r3));
                goto L35
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
                Objects.requireNonNull(r6);
                boolean r0 = false;
            L3:
                if (r0 == true) goto L36;
                int r1 = r5.readTag();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                if (r1 == 0) goto L28;
                if (r1 != 10) goto L9;
                this.error_ = r5.readBytes();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 1;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L9:
                if (r1 != 16) goto L11;
                this.supportedFeatures_ = r5.readUInt64();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 2;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L11:
                if (r1 != 24) goto L13;
                this.minimumEdition_ = r5.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 4;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L13:
                if (r1 != 32) goto L15;
                this.maximumEdition_ = r5.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 8;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L15:
                if (r1 != 122) goto L17;
                File r2 = (File) ZeusTransformUtils.preCheckCast(r5.readMessage(File.parser(), r6), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r3 = this.fileBuilder_;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                if (r3 == null) goto L21;
                r3.addMessage(r2);     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L21:
                ensureFileIsMutable();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.file_.add(r2);     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L17:
                if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
            L28:
                r0 = true;
                goto L3
            L29:
                th = move-exception;
                onChanged();
                throw th;
            L31:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L29
            L36:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                Object r0 = this.error_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
                ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.error_ = r2;
            L7:
                return r2;
            L9:
                return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                Object r0 = this.error_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                this.error_ = r1;
                return r1;
            L7:
                return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            }

            public Builder setError(String r1) {
                Objects.requireNonNull(r1);
                this.error_ = r1;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearError() {
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder setErrorBytes(ByteString r1) {
                Objects.requireNonNull(r1);
                this.error_ = r1;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasSupportedFeatures() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public long getSupportedFeatures() {
                return this.supportedFeatures_;
            }

            public Builder setSupportedFeatures(long r1) {
                this.supportedFeatures_ = r1;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearSupportedFeatures() {
                this.bitField0_ &= -3;
                this.supportedFeatures_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasMinimumEdition() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getMinimumEdition() {
                return this.minimumEdition_;
            }

            public Builder setMinimumEdition(int r1) {
                this.minimumEdition_ = r1;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearMinimumEdition() {
                this.bitField0_ &= -5;
                this.minimumEdition_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasMaximumEdition() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getMaximumEdition() {
                return this.maximumEdition_;
            }

            public Builder setMaximumEdition(int r1) {
                this.maximumEdition_ = r1;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearMaximumEdition() {
                this.bitField0_ &= -9;
                this.maximumEdition_ = 0;
                onChanged();
                return this;
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 16) != 0) goto L6;
                this.file_ = new ArrayList(this.file_);
                this.bitField0_ |= 16;
                return;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.file_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L7;
                return this.file_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int r3) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L7;
                return (File) ZeusTransformUtils.preCheckCast(this.file_.get(r3), File.class, "com.obric.aiagent.plugin");
            L7:
                return (File) ZeusTransformUtils.preCheckCast(r0.getMessage(r3), File.class, "com.obric.aiagent.plugin");
            }

            public Builder setFile(int r2, File r3) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r3);
                ensureFileIsMutable();
                this.file_.set(r2, r3);
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3);
                goto L6
            }

            public Builder setFile(int r2, File.Builder r3) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                ensureFileIsMutable();
                this.file_.set(r2, r3.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.build());
                goto L6
            }

            public Builder addFile(File r2) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r2);
                ensureFileIsMutable();
                this.file_.add(r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2);
                goto L6
            }

            public Builder addFile(int r2, File r3) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                Objects.requireNonNull(r3);
                ensureFileIsMutable();
                this.file_.add(r2, r3);
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3);
                goto L6
            }

            public Builder addFile(File.Builder r2) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r2.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.build());
                goto L6
            }

            public Builder addFile(int r2, File.Builder r3) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r2, r3.build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.build());
                goto L6
            }

            public Builder addAllFile(Iterable<? extends File> r3) {
                Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                ensureFileIsMutable();
                AbstractMessageLite.Builder.addAll(r4, this.file_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r4);
                goto L6
            }

            public Builder clearFile() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                this.file_ = Collections.emptyList();
                this.bitField0_ &= -17;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder removeFile(int r2) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L5;
                ensureFileIsMutable();
                this.file_.remove(r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public File.Builder getFileBuilder(int r2) {
                return (File.Builder) ZeusTransformUtils.preCheckCast(internalGetFileFieldBuilder().getBuilder(r2), File.Builder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public FileOrBuilder getFileOrBuilder(int r3) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 != null) goto L7;
                return (FileOrBuilder) ZeusTransformUtils.preCheckCast(this.file_.get(r3), FileOrBuilder.class, "com.obric.aiagent.plugin");
            L7:
                return (FileOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(r3), FileOrBuilder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r0 = this.fileBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.file_);
            }

            public File.Builder addFileBuilder() {
                return (File.Builder) ZeusTransformUtils.preCheckCast(internalGetFileFieldBuilder().addBuilder(File.getDefaultInstance()), File.Builder.class, "com.obric.aiagent.plugin");
            }

            public File.Builder addFileBuilder(int r2) {
                return (File.Builder) ZeusTransformUtils.preCheckCast(internalGetFileFieldBuilder().addBuilder(r2, File.getDefaultInstance()), File.Builder.class, "com.obric.aiagent.plugin");
            }

            public List<File.Builder> getFileBuilderList() {
                return internalGetFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> internalGetFileFieldBuilder() {
                if (this.fileBuilder_ != null) goto L10;
                List<File> r1 = this.file_;
                if ((this.bitField0_ & 16) == 0) goto L7;
                boolean r2 = true;
            L8:
                this.fileBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
                this.file_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.fileBuilder_;
            }
        }

        public static final enum Feature extends Enum<Feature> implements ProtocolMessageEnum {
            private static final /* synthetic */ Feature[] $VALUES = null;
            public static final Feature FEATURE_NONE = null;
            public static final int FEATURE_NONE_VALUE = 0;
            public static final Feature FEATURE_PROTO3_OPTIONAL = null;
            public static final int FEATURE_PROTO3_OPTIONAL_VALUE = 1;
            public static final Feature FEATURE_SUPPORTS_EDITIONS = null;
            public static final int FEATURE_SUPPORTS_EDITIONS_VALUE = 2;
            private static final Feature[] VALUES = null;
            private static final Internal.EnumLiteMap<Feature> internalValueMap = null;
            private final int value;

            private static /* synthetic */ Feature[] $values() {
                return new Feature[]{FEATURE_NONE, FEATURE_PROTO3_OPTIONAL, FEATURE_SUPPORTS_EDITIONS};
            }

            public static Feature valueOf(String r2) {
                return (Feature) ZeusTransformUtils.preCheckCast(Enum.valueOf(Feature.class, r2), Feature.class, "com.obric.aiagent.plugin");
            }

            public static Feature[] values() {
                return (Feature[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Feature[].class, "com.obric.aiagent.plugin");
            }

            static {
                FEATURE_NONE = new Feature("FEATURE_NONE", 0, 0);
                FEATURE_PROTO3_OPTIONAL = new Feature("FEATURE_PROTO3_OPTIONAL", 1, 1);
                FEATURE_SUPPORTS_EDITIONS = new Feature("FEATURE_SUPPORTS_EDITIONS", 2, 2);
                $VALUES = $values();
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Feature.class.getName());
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Feature valueOf(int r0) {
                return forNumber(r0);
            }

            public static Feature forNumber(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return FEATURE_SUPPORTS_EDITIONS;
            L12:
                return FEATURE_PROTO3_OPTIONAL;
            L14:
                return FEATURE_NONE;
            }

            public static Internal.EnumLiteMap<Feature> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static Descriptors.EnumDescriptor getDescriptor() {
                return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(CodeGeneratorResponse.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.aiagent.plugin");
            }

            public static Feature valueOf(Descriptors.EnumValueDescriptor r2) {
                if (r2.getType() != getDescriptor()) goto L7;
                return VALUES[r2.getIndex()];
            L7:
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private Feature(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class File extends GeneratedMessage implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            private static final File DEFAULT_INSTANCE = null;
            public static final int GENERATED_CODE_INFO_FIELD_NUMBER = 16;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static final Parser<File> PARSER = null;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object content_;
            private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
            private volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile Object name_;

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements FileOrBuilder {
                private int bitField0_;
                private Object content_;
                private SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> generatedCodeInfoBuilder_;
                private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
                private Object insertionPoint_;
                private Object name_;

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
                    return PluginProtos.access$2600();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.access$2700().ensureFieldAccessorsInitialized(File.class, Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(AbstractMessage.BuilderParent r3) {
                    super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (File.access$3000() == false) goto L6;
                    internalGetGeneratedCodeInfoFieldBuilder();
                    return;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.bitField0_ = 0;
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r1 = this.generatedCodeInfoBuilder_;
                    if (r1 == null) goto L5;
                    r1.dispose();
                    this.generatedCodeInfoBuilder_ = null;
                L5:
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.access$2600();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File build() {
                    File r1 = buildPartial();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw newUninitializedMessageException(r1);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File buildPartial() {
                    File r0 = new File(this, null);
                    if (this.bitField0_ == 0) goto L5;
                    buildPartial0(r0);
                L5:
                    onBuilt();
                    return r0;
                }

                private void buildPartial0(File r4) {
                    int r0 = this.bitField0_;
                    if ((r0 & 1) == 0) goto L5;
                    File.access$3202(r4, this.name_);
                    int r1 = 1;
                L7:
                    if ((r0 & 2) == 0) goto L10;
                    File.access$3302(r4, this.insertionPoint_);
                    r1 = r1 | 2;
                L10:
                    if ((r0 & 4) == 0) goto L13;
                    File.access$3402(r4, this.content_);
                    r1 = r1 | 4;
                L13:
                    if ((r0 & 8) == 0) goto L19;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r2 = this.generatedCodeInfoBuilder_;
                    if (r2 != null) goto L17;
                    DescriptorProtos.GeneratedCodeInfo r3 = this.generatedCodeInfo_;
                L18:
                    File.access$3502(r4, r3);
                    r1 = r1 | 8;
                    goto L19
                L17:
                    r3 = (DescriptorProtos.GeneratedCodeInfo) ZeusTransformUtils.preCheckCast(r2.build(), DescriptorProtos.GeneratedCodeInfo.class, "com.obric.aiagent.plugin");
                L19:
                    File.access$3676(r4, r1);
                    return;
                L5:
                    r1 = 0;
                    goto L7
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message r3) {
                    Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r4, File.class) == true) goto L5;
                    super.mergeFrom(r4);
                    return this;
                L5:
                    return mergeFrom((File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.aiagent.plugin"));
                }

                public Builder mergeFrom(File r2) {
                    if (r2 != File.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r2.hasName() == false) goto L9;
                    this.name_ = File.access$3200(r2);
                    this.bitField0_ |= 1;
                    onChanged();
                L9:
                    if (r2.hasInsertionPoint() == false) goto L12;
                    this.insertionPoint_ = File.access$3300(r2);
                    this.bitField0_ |= 2;
                    onChanged();
                L12:
                    if (r2.hasContent() == false) goto L15;
                    this.content_ = File.access$3400(r2);
                    this.bitField0_ |= 4;
                    onChanged();
                L15:
                    if (r2.hasGeneratedCodeInfo() == false) goto L17;
                    mergeGeneratedCodeInfo(r2.getGeneratedCodeInfo());
                L17:
                    mergeUnknownFields(r2.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
                    Objects.requireNonNull(r6);
                    boolean r0 = false;
                L3:
                    if (r0 == true) goto L30;
                    int r1 = r5.readTag();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    if (r1 == 0) goto L22;
                    if (r1 != 10) goto L9;
                    this.name_ = r5.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 1;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L9:
                    if (r1 != 18) goto L11;
                    this.insertionPoint_ = r5.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 2;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L11:
                    if (r1 != 122) goto L13;
                    this.content_ = r5.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 4;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L13:
                    if (r1 != 130) goto L15;
                    r5.readMessage(internalGetGeneratedCodeInfoFieldBuilder().getBuilder(), r6);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 8;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L15:
                    if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
                L22:
                    r0 = true;
                    goto L3
                L25:
                    e = move-exception;
                    throw e.unwrapIOException();     // Catch: Throwable -> L23
                L23:
                    th = move-exception;
                    onChanged();
                    throw th;
                L30:
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    if ((this.bitField0_ & 1) != 0) goto L7;
                    return false;
                L7:
                    return true;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    Object r0 = this.name_;
                    if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
                    ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                    String r2 = r1.toStringUtf8();
                    if (r1.isValidUtf8() == false) goto L7;
                    this.name_ = r2;
                L7:
                    return r2;
                L9:
                    return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
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
                    this.name_ = File.getDefaultInstance().getName();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString r1) {
                    Objects.requireNonNull(r1);
                    this.name_ = r1;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    if ((this.bitField0_ & 2) == 0) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    Object r0 = this.insertionPoint_;
                    if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
                    ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                    String r2 = r1.toStringUtf8();
                    if (r1.isValidUtf8() == false) goto L7;
                    this.insertionPoint_ = r2;
                L7:
                    return r2;
                L9:
                    return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    Object r0 = this.insertionPoint_;
                    if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                    ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                    this.insertionPoint_ = r1;
                    return r1;
                L7:
                    return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                }

                public Builder setInsertionPoint(String r1) {
                    Objects.requireNonNull(r1);
                    this.insertionPoint_ = r1;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                public Builder clearInsertionPoint() {
                    this.insertionPoint_ = File.getDefaultInstance().getInsertionPoint();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString r1) {
                    Objects.requireNonNull(r1);
                    this.insertionPoint_ = r1;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    if ((this.bitField0_ & 4) == 0) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getContent() {
                    Object r0 = this.content_;
                    if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
                    ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                    String r2 = r1.toStringUtf8();
                    if (r1.isValidUtf8() == false) goto L7;
                    this.content_ = r2;
                L7:
                    return r2;
                L9:
                    return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    Object r0 = this.content_;
                    if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                    ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                    this.content_ = r1;
                    return r1;
                L7:
                    return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                }

                public Builder setContent(String r1) {
                    Objects.requireNonNull(r1);
                    this.content_ = r1;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                public Builder clearContent() {
                    this.content_ = File.getDefaultInstance().getContent();
                    this.bitField0_ &= -5;
                    onChanged();
                    return this;
                }

                public Builder setContentBytes(ByteString r1) {
                    Objects.requireNonNull(r1);
                    this.content_ = r1;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasGeneratedCodeInfo() {
                    if ((this.bitField0_ & 8) == 0) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r0 = this.generatedCodeInfoBuilder_;
                    if (r0 != null) goto L9;
                    DescriptorProtos.GeneratedCodeInfo r2 = this.generatedCodeInfo_;
                    if (r2 == null) goto L7;
                    return r2;
                L7:
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                L9:
                    return (DescriptorProtos.GeneratedCodeInfo) ZeusTransformUtils.preCheckCast(r0.getMessage(), DescriptorProtos.GeneratedCodeInfo.class, "com.obric.aiagent.plugin");
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo r2) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r0 = this.generatedCodeInfoBuilder_;
                    if (r0 != null) goto L5;
                    Objects.requireNonNull(r2);
                    this.generatedCodeInfo_ = r2;
                L6:
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                L5:
                    r0.setMessage(r2);
                    goto L6
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo.Builder r2) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r0 = this.generatedCodeInfoBuilder_;
                    if (r0 != null) goto L5;
                    this.generatedCodeInfo_ = r2.build();
                L6:
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                L5:
                    r0.setMessage(r2.build());
                    goto L6
                }

                public Builder mergeGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo r3) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r0 = this.generatedCodeInfoBuilder_;
                    if (r0 == null) goto L5;
                    r0.mergeFrom(r3);
                L14:
                    if (this.generatedCodeInfo_ == null) goto L16;
                    this.bitField0_ |= 8;
                    onChanged();
                L16:
                    return this;
                L5:
                    if ((this.bitField0_ & 8) == 0) goto L11;
                    DescriptorProtos.GeneratedCodeInfo r1 = this.generatedCodeInfo_;
                    if (r1 == null) goto L11;
                    if (r1 == DescriptorProtos.GeneratedCodeInfo.getDefaultInstance()) goto L11;
                    getGeneratedCodeInfoBuilder().mergeFrom(r3);
                L11:
                    this.generatedCodeInfo_ = r3;
                    goto L14
                }

                public Builder clearGeneratedCodeInfo() {
                    this.bitField0_ &= -9;
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r1 = this.generatedCodeInfoBuilder_;
                    if (r1 == null) goto L5;
                    r1.dispose();
                    this.generatedCodeInfoBuilder_ = null;
                L5:
                    onChanged();
                    return this;
                }

                public DescriptorProtos.GeneratedCodeInfo.Builder getGeneratedCodeInfoBuilder() {
                    this.bitField0_ |= 8;
                    onChanged();
                    return (DescriptorProtos.GeneratedCodeInfo.Builder) ZeusTransformUtils.preCheckCast(internalGetGeneratedCodeInfoFieldBuilder().getBuilder(), DescriptorProtos.GeneratedCodeInfo.Builder.class, "com.obric.aiagent.plugin");
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r0 = this.generatedCodeInfoBuilder_;
                    if (r0 != null) goto L5;
                    DescriptorProtos.GeneratedCodeInfo r2 = this.generatedCodeInfo_;
                    if (r2 == null) goto L9;
                    return r2;
                L9:
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                L5:
                    return (DescriptorProtos.GeneratedCodeInfoOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(), DescriptorProtos.GeneratedCodeInfoOrBuilder.class, "com.obric.aiagent.plugin");
                }

                private SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> internalGetGeneratedCodeInfoFieldBuilder() {
                    if (this.generatedCodeInfoBuilder_ != null) goto L6;
                    this.generatedCodeInfoBuilder_ = new SingleFieldBuilder(getGeneratedCodeInfo(), getParentForChildren(), isClean());
                    this.generatedCodeInfo_ = null;
                L6:
                    return this.generatedCodeInfoBuilder_;
                }
            }

            /* synthetic */ File(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ boolean access$3000() {
                return alwaysUseFieldBuilders;
            }

            static /* synthetic */ Object access$3200(File r0) {
                return r0.name_;
            }

            static /* synthetic */ Object access$3202(File r0, Object r1) {
                r0.name_ = r1;
                return r1;
            }

            static /* synthetic */ Object access$3300(File r0) {
                return r0.insertionPoint_;
            }

            static /* synthetic */ Object access$3302(File r0, Object r1) {
                r0.insertionPoint_ = r1;
                return r1;
            }

            static /* synthetic */ Object access$3400(File r0) {
                return r0.content_;
            }

            static /* synthetic */ Object access$3402(File r0, Object r1) {
                r0.content_ = r1;
                return r1;
            }

            static /* synthetic */ DescriptorProtos.GeneratedCodeInfo access$3502(File r0, DescriptorProtos.GeneratedCodeInfo r1) {
                r0.generatedCodeInfo_ = r1;
                return r1;
            }

            static /* synthetic */ int access$3676(File r1, int r2) {
                int r3 = r2 | r1.bitField0_;
                r1.bitField0_ = r3;
                return r3;
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

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", File.class.getName());
                DEFAULT_INSTANCE = new File();
                PARSER = new AnonymousClass1();
            }

            private File(GeneratedMessage.Builder<?> r1) {
                super(r1);
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = -1;
            }

            private File() {
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$2600();
            }

            @Override // com.google.protobuf.GeneratedMessage
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$2700().ensureFieldAccessorsInitialized(File.class, Builder.class);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                Object r0 = this.name_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
                ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L9;
                this.name_ = r2;
            L9:
                return r2;
            L5:
                return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                Object r0 = this.name_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                this.name_ = r1;
                return r1;
            L7:
                return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                Object r0 = this.insertionPoint_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
                ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L9;
                this.insertionPoint_ = r2;
            L9:
                return r2;
            L5:
                return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                Object r0 = this.insertionPoint_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                this.insertionPoint_ = r1;
                return r1;
            L7:
                return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                Object r0 = this.content_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
                ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L9;
                this.content_ = r2;
            L9:
                return r2;
            L5:
                return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                Object r0 = this.content_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                this.content_ = r1;
                return r1;
            L7:
                return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasGeneratedCodeInfo() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                DescriptorProtos.GeneratedCodeInfo r0 = this.generatedCodeInfo_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                DescriptorProtos.GeneratedCodeInfo r0 = this.generatedCodeInfo_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
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
            public void writeTo(CodedOutputStream r3) {
                if ((this.bitField0_ & 1) == 0) goto L6;
                GeneratedMessage.writeString(r3, 1, this.name_);
            L6:
                if ((this.bitField0_ & 2) == 0) goto L9;
                GeneratedMessage.writeString(r3, 2, this.insertionPoint_);
            L9:
                if ((this.bitField0_ & 4) == 0) goto L12;
                GeneratedMessage.writeString(r3, 15, this.content_);
            L12:
                if ((this.bitField0_ & 8) == 0) goto L14;
                r3.writeMessage(16, getGeneratedCodeInfo());
            L14:
                getUnknownFields().writeTo(r3);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int r0 = this.memoizedSize;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r1 = 0;
                if ((this.bitField0_ & 1) == 0) goto L9;
                r1 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
            L9:
                if ((this.bitField0_ & 2) == 0) goto L12;
                r1 = r1 + GeneratedMessage.computeStringSize(2, this.insertionPoint_);
            L12:
                if ((this.bitField0_ & 4) == 0) goto L15;
                r1 = r1 + GeneratedMessage.computeStringSize(15, this.content_);
            L15:
                if ((this.bitField0_ & 8) == 0) goto L17;
                r1 = r1 + CodedOutputStream.computeMessageSize(16, getGeneratedCodeInfo());
            L17:
                int r2 = r1 + getUnknownFields().getSerializedSize();
                this.memoizedSize = r2;
                return r2;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object r5) {
                if (r5 != this) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, File.class) == false) goto L8;
                File r6 = (File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.aiagent.plugin");
                if (hasName() == r6.hasName()) goto L13;
                return false;
            L13:
                if (hasName() == false) goto L18;
                if (getName().equals(r6.getName()) == true) goto L18;
                return false;
            L18:
                if (hasInsertionPoint() == r6.hasInsertionPoint()) goto L21;
                return false;
            L21:
                if (hasInsertionPoint() == false) goto L26;
                if (getInsertionPoint().equals(r6.getInsertionPoint()) == true) goto L26;
                return false;
            L26:
                if (hasContent() == r6.hasContent()) goto L29;
                return false;
            L29:
                if (hasContent() == false) goto L34;
                if (getContent().equals(r6.getContent()) == true) goto L34;
                return false;
            L34:
                if (hasGeneratedCodeInfo() == r6.hasGeneratedCodeInfo()) goto L37;
                return false;
            L37:
                if (hasGeneratedCodeInfo() == false) goto L42;
                if (getGeneratedCodeInfo().equals(r6.getGeneratedCodeInfo()) == true) goto L42;
                return false;
            L42:
                if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L44;
                return false;
            L44:
                return true;
            L8:
                return super.equals(r5);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) goto L5;
                int r0 = 779 + getDescriptor().hashCode();
                if (hasName() == false) goto L10;
                r0 = (((r0 * 37) + 1) * 53) + getName().hashCode();
            L10:
                if (hasInsertionPoint() == false) goto L13;
                r0 = (((r0 * 37) + 2) * 53) + getInsertionPoint().hashCode();
            L13:
                if (hasContent() == false) goto L16;
                r0 = (((r0 * 37) + 15) * 53) + getContent().hashCode();
            L16:
                if (hasGeneratedCodeInfo() == false) goto L18;
                r0 = (((r0 * 37) + 16) * 53) + getGeneratedCodeInfo().hashCode();
            L18:
                int r1 = (r0 * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = r1;
                return r1;
            L5:
                return this.memoizedHashCode;
            }

            public static File parseFrom(ByteBuffer r2) {
                return (File) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
                return (File) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(ByteString r2) {
                return (File) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(ByteString r1, ExtensionRegistryLite r2) {
                return (File) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(byte[] r2) {
                return (File) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(byte[] r1, ExtensionRegistryLite r2) {
                return (File) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(InputStream r2) {
                return (File) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(InputStream r1, ExtensionRegistryLite r2) {
                return (File) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseDelimitedFrom(InputStream r2) {
                return (File) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
                return (File) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(CodedInputStream r2) {
                return (File) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), File.class, "com.obric.aiagent.plugin");
            }

            public static File parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                return (File) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), File.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File r1) {
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

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public interface FileOrBuilder extends MessageOrBuilder {
            String getContent();

            ByteString getContentBytes();

            DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo();

            DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasGeneratedCodeInfo();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        /* synthetic */ CodeGeneratorResponse(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$4000(CodeGeneratorResponse r0) {
            return r0.file_;
        }

        static /* synthetic */ List access$4002(CodeGeneratorResponse r2, List r3) {
            List<File> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            r2.file_ = r4;
            return r4;
        }

        static /* synthetic */ Object access$4100(CodeGeneratorResponse r0) {
            return r0.error_;
        }

        static /* synthetic */ Object access$4102(CodeGeneratorResponse r0, Object r1) {
            r0.error_ = r1;
            return r1;
        }

        static /* synthetic */ long access$4202(CodeGeneratorResponse r0, long r1) {
            r0.supportedFeatures_ = r1;
            return r1;
        }

        static /* synthetic */ int access$4302(CodeGeneratorResponse r0, int r1) {
            r0.minimumEdition_ = r1;
            return r1;
        }

        static /* synthetic */ int access$4402(CodeGeneratorResponse r0, int r1) {
            r0.maximumEdition_ = r1;
            return r1;
        }

        static /* synthetic */ int access$4576(CodeGeneratorResponse r1, int r2) {
            int r3 = r2 | r1.bitField0_;
            r1.bitField0_ = r3;
            return r3;
        }

        static /* synthetic */ boolean access$4600() {
            return alwaysUseFieldBuilders;
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

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CodeGeneratorResponse.class.getName());
            DEFAULT_INSTANCE = new CodeGeneratorResponse();
            PARSER = new AnonymousClass1();
        }

        private CodeGeneratorResponse(GeneratedMessage.Builder<?> r3) {
            super(r3);
            this.error_ = "";
            this.supportedFeatures_ = 0;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private CodeGeneratorResponse() {
            this.error_ = "";
            this.supportedFeatures_ = 0;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$2400();
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$2500().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            Object r0 = this.error_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
            ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.error_ = r2;
        L9:
            return r2;
        L5:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            Object r0 = this.error_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
            this.error_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasSupportedFeatures() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public long getSupportedFeatures() {
            return this.supportedFeatures_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasMinimumEdition() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getMinimumEdition() {
            return this.minimumEdition_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasMaximumEdition() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getMaximumEdition() {
            return this.maximumEdition_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<File> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int r2) {
            return (File) ZeusTransformUtils.preCheckCast(this.file_.get(r2), File.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public FileOrBuilder getFileOrBuilder(int r2) {
            return (FileOrBuilder) ZeusTransformUtils.preCheckCast(this.file_.get(r2), FileOrBuilder.class, "com.obric.aiagent.plugin");
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
        public void writeTo(CodedOutputStream r6) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            GeneratedMessage.writeString(r6, 1, this.error_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r6.writeUInt64(2, this.supportedFeatures_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r6.writeInt32(3, this.minimumEdition_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            r6.writeInt32(4, this.maximumEdition_);
        L14:
            int r0 = 0;
        L16:
            if (r0 >= this.file_.size()) goto L18;
            r6.writeMessage(15, (MessageLite) ZeusTransformUtils.preCheckCast(this.file_.get(r0), MessageLite.class, "com.obric.aiagent.plugin"));
            r0 = r0 + 1;
            goto L16
        L18:
            getUnknownFields().writeTo(r6);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) == 0) goto L8;
            int r1 = GeneratedMessage.computeStringSize(1, this.error_) + 0;
        L10:
            if ((this.bitField0_ & 2) == 0) goto L13;
            r1 = r1 + CodedOutputStream.computeUInt64Size(2, this.supportedFeatures_);
        L13:
            if ((this.bitField0_ & 4) == 0) goto L16;
            r1 = r1 + CodedOutputStream.computeInt32Size(3, this.minimumEdition_);
        L16:
            if ((this.bitField0_ & 8) == 0) goto L19;
            r1 = r1 + CodedOutputStream.computeInt32Size(4, this.maximumEdition_);
        L19:
            if (r2 >= this.file_.size()) goto L21;
            r1 = r1 + CodedOutputStream.computeMessageSize(15, (MessageLite) ZeusTransformUtils.preCheckCast(this.file_.get(r2), MessageLite.class, "com.obric.aiagent.plugin"));
            r2 = r2 + 1;
            goto L19
        L21:
            int r3 = r1 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r3;
            return r3;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r9) {
            if (r9 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, CodeGeneratorResponse.class) == false) goto L8;
            CodeGeneratorResponse r10 = (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(r9, CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
            if (hasError() == r10.hasError()) goto L13;
            return false;
        L13:
            if (hasError() == false) goto L18;
            if (getError().equals(r10.getError()) == true) goto L18;
            return false;
        L18:
            if (hasSupportedFeatures() == r10.hasSupportedFeatures()) goto L21;
            return false;
        L21:
            if (hasSupportedFeatures() == false) goto L26;
            if (getSupportedFeatures() == r10.getSupportedFeatures()) goto L26;
            return false;
        L26:
            if (hasMinimumEdition() == r10.hasMinimumEdition()) goto L29;
            return false;
        L29:
            if (hasMinimumEdition() == false) goto L34;
            if (getMinimumEdition() == r10.getMinimumEdition()) goto L34;
            return false;
        L34:
            if (hasMaximumEdition() == r10.hasMaximumEdition()) goto L37;
            return false;
        L37:
            if (hasMaximumEdition() == false) goto L42;
            if (getMaximumEdition() == r10.getMaximumEdition()) goto L42;
            return false;
        L42:
            if (getFileList().equals(r10.getFileList()) == true) goto L45;
            return false;
        L45:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L47;
            return false;
        L47:
            return true;
        L8:
            return super.equals(r9);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) goto L5;
            int r0 = 779 + getDescriptor().hashCode();
            if (hasError() == false) goto L10;
            r0 = (((r0 * 37) + 1) * 53) + getError().hashCode();
        L10:
            if (hasSupportedFeatures() == false) goto L13;
            r0 = (((r0 * 37) + 2) * 53) + Internal.hashLong(getSupportedFeatures());
        L13:
            if (hasMinimumEdition() == false) goto L16;
            r0 = (((r0 * 37) + 3) * 53) + getMinimumEdition();
        L16:
            if (hasMaximumEdition() == false) goto L19;
            r0 = (((r0 * 37) + 4) * 53) + getMaximumEdition();
        L19:
            if (getFileCount() <= 0) goto L21;
            r0 = (((r0 * 37) + 15) * 53) + getFileList().hashCode();
        L21:
            int r1 = (r0 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r1;
            return r1;
        L5:
            return this.memoizedHashCode;
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(ByteString r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(ByteString r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(byte[] r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(byte[] r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(InputStream r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return (CodeGeneratorResponse) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CodeGeneratorResponse.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse r1) {
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

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int r1);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int r1);

        List<? extends CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        int getMaximumEdition();

        int getMinimumEdition();

        long getSupportedFeatures();

        boolean hasError();

        boolean hasMaximumEdition();

        boolean hasMinimumEdition();

        boolean hasSupportedFeatures();
    }

    public static final class Version extends GeneratedMessage implements VersionOrBuilder {
        private static final Version DEFAULT_INSTANCE = null;
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        private static final Parser<Version> PARSER = null;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int major_;
        private byte memoizedIsInitialized;
        private int minor_;
        private int patch_;
        private volatile Object suffix_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VersionOrBuilder {
            private int bitField0_;
            private int major_;
            private int minor_;
            private int patch_;
            private Object suffix_;

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
                return PluginProtos.access$000();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$100().ensureFieldAccessorsInitialized(Version.class, Builder.class);
            }

            private Builder() {
                this.suffix_ = "";
            }

            private Builder(AbstractMessage.BuilderParent r3) {
                super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
                this.suffix_ = "";
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.major_ = 0;
                this.minor_ = 0;
                this.patch_ = 0;
                this.suffix_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$000();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Version getDefaultInstanceForType() {
                return Version.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version build() {
                Version r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version buildPartial() {
                Version r0 = new Version(this, null);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r0);
            L5:
                onBuilt();
                return r0;
            }

            private void buildPartial0(Version r4) {
                int r0 = this.bitField0_;
                if ((r0 & 1) == 0) goto L5;
                Version.access$502(r4, this.major_);
                int r1 = 1;
            L7:
                if ((r0 & 2) == 0) goto L10;
                Version.access$602(r4, this.minor_);
                r1 = r1 | 2;
            L10:
                if ((r0 & 4) == 0) goto L13;
                Version.access$702(r4, this.patch_);
                r1 = r1 | 4;
            L13:
                if ((r0 & 8) == 0) goto L15;
                Version.access$802(r4, this.suffix_);
                r1 = r1 | 8;
            L15:
                Version.access$976(r4, r1);
                return;
            L5:
                r1 = 0;
                goto L7
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r3) {
                Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r4, Version.class) == true) goto L5;
                super.mergeFrom(r4);
                return this;
            L5:
                return mergeFrom((Version) ZeusTransformUtils.preCheckCast(r4, Version.class, "com.obric.aiagent.plugin"));
            }

            public Builder mergeFrom(Version r2) {
                if (r2 != Version.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasMajor() == false) goto L9;
                setMajor(r2.getMajor());
            L9:
                if (r2.hasMinor() == false) goto L12;
                setMinor(r2.getMinor());
            L12:
                if (r2.hasPatch() == false) goto L15;
                setPatch(r2.getPatch());
            L15:
                if (r2.hasSuffix() == false) goto L17;
                this.suffix_ = Version.access$800(r2);
                this.bitField0_ |= 8;
                onChanged();
            L17:
                mergeUnknownFields(r2.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
                Objects.requireNonNull(r7);
                boolean r0 = false;
            L3:
                if (r0 == true) goto L30;
                int r1 = r6.readTag();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                if (r1 == 0) goto L22;
                if (r1 != 8) goto L9;
                this.major_ = r6.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 1;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L9:
                if (r1 != 16) goto L11;
                this.minor_ = r6.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 2;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L11:
                if (r1 != 24) goto L13;
                this.patch_ = r6.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 4;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L13:
                if (r1 != 34) goto L15;
                this.suffix_ = r6.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 8;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L15:
                if (super.parseUnknownField(r6, r7, r1) == true) goto L3;
            L22:
                r0 = true;
                goto L3
            L23:
                th = move-exception;
                onChanged();
                throw th;
            L25:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L23
            L30:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMajor() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMajor() {
                return this.major_;
            }

            public Builder setMajor(int r1) {
                this.major_ = r1;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearMajor() {
                this.bitField0_ &= -2;
                this.major_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMinor() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMinor() {
                return this.minor_;
            }

            public Builder setMinor(int r1) {
                this.minor_ = r1;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearMinor() {
                this.bitField0_ &= -3;
                this.minor_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasPatch() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getPatch() {
                return this.patch_;
            }

            public Builder setPatch(int r1) {
                this.patch_ = r1;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearPatch() {
                this.bitField0_ &= -5;
                this.patch_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasSuffix() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public String getSuffix() {
                Object r0 = this.suffix_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
                ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.suffix_ = r2;
            L7:
                return r2;
            L9:
                return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public ByteString getSuffixBytes() {
                Object r0 = this.suffix_;
                if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
                this.suffix_ = r1;
                return r1;
            L7:
                return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            }

            public Builder setSuffix(String r1) {
                Objects.requireNonNull(r1);
                this.suffix_ = r1;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearSuffix() {
                this.suffix_ = Version.getDefaultInstance().getSuffix();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder setSuffixBytes(ByteString r1) {
                Objects.requireNonNull(r1);
                this.suffix_ = r1;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }
        }

        /* synthetic */ Version(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$502(Version r0, int r1) {
            r0.major_ = r1;
            return r1;
        }

        static /* synthetic */ int access$602(Version r0, int r1) {
            r0.minor_ = r1;
            return r1;
        }

        static /* synthetic */ int access$702(Version r0, int r1) {
            r0.patch_ = r1;
            return r1;
        }

        static /* synthetic */ Object access$800(Version r0) {
            return r0.suffix_;
        }

        static /* synthetic */ Object access$802(Version r0, Object r1) {
            r0.suffix_ = r1;
            return r1;
        }

        static /* synthetic */ int access$976(Version r1, int r2) {
            int r3 = r2 | r1.bitField0_;
            r1.bitField0_ = r3;
            return r3;
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

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Version.class.getName());
            DEFAULT_INSTANCE = new Version();
            PARSER = new AnonymousClass1();
        }

        private Version(GeneratedMessage.Builder<?> r1) {
            super(r1);
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = -1;
        }

        private Version() {
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = -1;
            this.suffix_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$000();
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$100().ensureFieldAccessorsInitialized(Version.class, Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMajor() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMajor() {
            return this.major_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMinor() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMinor() {
            return this.minor_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasPatch() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getPatch() {
            return this.patch_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasSuffix() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public String getSuffix() {
            Object r0 = this.suffix_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
            ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.aiagent.plugin");
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.suffix_ = r2;
        L9:
            return r2;
        L5:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public ByteString getSuffixBytes() {
            Object r0 = this.suffix_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
            this.suffix_ = r1;
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
        public void writeTo(CodedOutputStream r4) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r4.writeInt32(1, this.major_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r4.writeInt32(2, this.minor_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r4.writeInt32(3, this.patch_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            GeneratedMessage.writeString(r4, 4, this.suffix_);
        L14:
            getUnknownFields().writeTo(r4);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            if ((this.bitField0_ & 1) == 0) goto L9;
            r1 = 0 + CodedOutputStream.computeInt32Size(1, this.major_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r1 = r1 + CodedOutputStream.computeInt32Size(2, this.minor_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r1 = r1 + CodedOutputStream.computeInt32Size(3, this.patch_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L17;
            r1 = r1 + GeneratedMessage.computeStringSize(4, this.suffix_);
        L17:
            int r2 = r1 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r2;
            return r2;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Version.class) == false) goto L8;
            Version r6 = (Version) ZeusTransformUtils.preCheckCast(r5, Version.class, "com.obric.aiagent.plugin");
            if (hasMajor() == r6.hasMajor()) goto L13;
            return false;
        L13:
            if (hasMajor() == false) goto L18;
            if (getMajor() == r6.getMajor()) goto L18;
            return false;
        L18:
            if (hasMinor() == r6.hasMinor()) goto L21;
            return false;
        L21:
            if (hasMinor() == false) goto L26;
            if (getMinor() == r6.getMinor()) goto L26;
            return false;
        L26:
            if (hasPatch() == r6.hasPatch()) goto L29;
            return false;
        L29:
            if (hasPatch() == false) goto L34;
            if (getPatch() == r6.getPatch()) goto L34;
            return false;
        L34:
            if (hasSuffix() == r6.hasSuffix()) goto L37;
            return false;
        L37:
            if (hasSuffix() == false) goto L42;
            if (getSuffix().equals(r6.getSuffix()) == true) goto L42;
            return false;
        L42:
            if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L44;
            return false;
        L44:
            return true;
        L8:
            return super.equals(r5);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) goto L5;
            int r0 = 779 + getDescriptor().hashCode();
            if (hasMajor() == false) goto L10;
            r0 = (((r0 * 37) + 1) * 53) + getMajor();
        L10:
            if (hasMinor() == false) goto L13;
            r0 = (((r0 * 37) + 2) * 53) + getMinor();
        L13:
            if (hasPatch() == false) goto L16;
            r0 = (((r0 * 37) + 3) * 53) + getPatch();
        L16:
            if (hasSuffix() == false) goto L18;
            r0 = (((r0 * 37) + 4) * 53) + getSuffix().hashCode();
        L18:
            int r1 = (r0 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r1;
            return r1;
        L5:
            return this.memoizedHashCode;
        }

        public static Version parseFrom(ByteBuffer r2) {
            return (Version) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
            return (Version) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(ByteString r2) {
            return (Version) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(ByteString r1, ExtensionRegistryLite r2) {
            return (Version) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(byte[] r2) {
            return (Version) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(byte[] r1, ExtensionRegistryLite r2) {
            return (Version) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(InputStream r2) {
            return (Version) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (Version) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseDelimitedFrom(InputStream r2) {
            return (Version) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (Version) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(CodedInputStream r2) {
            return (Version) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Version.class, "com.obric.aiagent.plugin");
        }

        public static Version parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return (Version) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Version.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version r1) {
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

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Version> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Version> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface VersionOrBuilder extends MessageOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    public static void registerAllExtensions(ExtensionRegistryLite r0) {
    }

    static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_google_protobuf_compiler_Version_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$100() {
        return internal_static_google_protobuf_compiler_Version_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$1000() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$1100() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$2400() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$2500() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$2600() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$2700() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    }

    private PluginProtos() {
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", PluginProtos.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"c\n\u0007Version\u0012\u0014\n\u0005major\u0018\u0001 \u0001(\u0005R\u0005major\u0012\u0014\n\u0005minor\u0018\u0002 \u0001(\u0005R\u0005minor\u0012\u0014\n\u0005patch\u0018\u0003 \u0001(\u0005R\u0005patch\u0012\u0016\n\u0006suffix\u0018\u0004 \u0001(\tR\u0006suffix\"Ï\u0002\n\u0014CodeGeneratorRequest\u0012(\n\u0010file_to_generate\u0018\u0001 \u0003(\tR\u000efileToGenerate\u0012\u001c\n\tparameter\u0018\u0002 \u0001(\tR\tparameter\u0012C\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\tprotoFile\u0012\\\n\u0017source_file_descriptors\u0018\u0011 \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\u0015sourceFileDescriptors\u0012L\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.VersionR\u000fcompilerVersion\"\u0085\u0004\n\u0015CodeGeneratorResponse\u0012\u0014\n\u0005error\u0018\u0001 \u0001(\tR\u0005error\u0012-\n\u0012supported_features\u0018\u0002 \u0001(\u0004R\u0011supportedFeatures\u0012'\n\u000fminimum_edition\u0018\u0003 \u0001(\u0005R\u000eminimumEdition\u0012'\n\u000fmaximum_edition\u0018\u0004 \u0001(\u0005R\u000emaximumEdition\u0012H\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.FileR\u0004file\u001a±\u0001\n\u0004File\u0012\u0012\n\u0004name\u0018\u0001 \u0001(\tR\u0004name\u0012'\n\u000finsertion_point\u0018\u0002 \u0001(\tR\u000einsertionPoint\u0012\u0018\n\u0007content\u0018\u000f \u0001(\tR\u0007content\u0012R\n\u0013generated_code_info\u0018\u0010 \u0001(\u000b2\".google.protobuf.GeneratedCodeInfoR\u0011generatedCodeInfo\"W\n\u0007Feature\u0012\u0010\n\fFEATURE_NONE\u0010\u0000\u0012\u001b\n\u0017FEATURE_PROTO3_OPTIONAL\u0010\u0001\u0012\u001d\n\u0019FEATURE_SUPPORTS_EDITIONS\u0010\u0002Br\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ)google.golang.org/protobuf/types/pluginpbª\u0002\u0018Google.Protobuf.Compiler"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor r0 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(0), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_compiler_Version_descriptor = r0;
        internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r0, new String[]{"Major", "Minor", "Patch", "Suffix"});
        Descriptors.Descriptor r1 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(1), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = r1;
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r1, new String[]{"FileToGenerate", "Parameter", "ProtoFile", "SourceFileDescriptors", "CompilerVersion"});
        Descriptors.Descriptor r2 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(2), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = r2;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r2, new String[]{"Error", "SupportedFeatures", "MinimumEdition", "MaximumEdition", "File"});
        Descriptors.Descriptor r3 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r2.getNestedTypes().get(0), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = r3;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r3, new String[]{"Name", "InsertionPoint", "Content", "GeneratedCodeInfo"});
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
