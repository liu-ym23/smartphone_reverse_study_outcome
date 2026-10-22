package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ToolExecutionResult extends GeneratedMessageLite<ToolExecutionResult, Builder> implements ToolExecutionResultOrBuilder {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 6;
    private static final ToolExecutionResult DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 5;
    public static final int METADATA_FIELD_NUMBER = 7;
    public static final int OUTPUT_FIELD_NUMBER = 4;
    private static volatile Parser<ToolExecutionResult> PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 2;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String taskId_ = "";
    private String toolCallId_ = "";
    private String output_ = "";
    private String error_ = "";
    private String contentType_ = "";

    /* renamed from: com.zyql.protobuf.agent.ToolExecutionResult$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ToolExecutionResult, Builder> implements ToolExecutionResultOrBuilder {
        public Builder clearContentType() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).clearContentType();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).clearError();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearOutput() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).clearOutput();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).clearSuccess();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).clearTaskId();
            return this;
        }

        public Builder clearToolCallId() {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).clearToolCallId();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((ToolExecutionResult) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getContentType() {
            return ((ToolExecutionResult) this.instance).getContentType();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public ByteString getContentTypeBytes() {
            return ((ToolExecutionResult) this.instance).getContentTypeBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getError() {
            return ((ToolExecutionResult) this.instance).getError();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public ByteString getErrorBytes() {
            return ((ToolExecutionResult) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public int getMetadataCount() {
            return ((ToolExecutionResult) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((ToolExecutionResult) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((ToolExecutionResult) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((ToolExecutionResult) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getOutput() {
            return ((ToolExecutionResult) this.instance).getOutput();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public ByteString getOutputBytes() {
            return ((ToolExecutionResult) this.instance).getOutputBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public boolean getSuccess() {
            return ((ToolExecutionResult) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getTaskId() {
            return ((ToolExecutionResult) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public ByteString getTaskIdBytes() {
            return ((ToolExecutionResult) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public String getToolCallId() {
            return ((ToolExecutionResult) this.instance).getToolCallId();
        }

        @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
        public ByteString getToolCallIdBytes() {
            return ((ToolExecutionResult) this.instance).getToolCallIdBytes();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ToolExecutionResult) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((ToolExecutionResult) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setContentType(String str) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setContentType(str);
            return this;
        }

        public Builder setContentTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setContentTypeBytes(byteString);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setOutput(String str) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setOutput(str);
            return this;
        }

        public Builder setOutputBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setOutputBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        public Builder setToolCallId(String str) {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setToolCallId(str);
            return this;
        }

        public Builder setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolExecutionResult) this.instance).setToolCallIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(ToolExecutionResult.DEFAULT_INSTANCE);
        }
    }

    public static final class MetadataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetadataDefaultEntryHolder() {
        }
    }

    static {
        ToolExecutionResult toolExecutionResult = new ToolExecutionResult();
        DEFAULT_INSTANCE = toolExecutionResult;
        GeneratedMessageLite.registerDefaultInstance(ToolExecutionResult.class, toolExecutionResult);
    }

    private ToolExecutionResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContentType() {
        this.contentType_ = getDefaultInstance().getContentType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.output_ = getDefaultInstance().getOutput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallId() {
        this.toolCallId_ = getDefaultInstance().getToolCallId();
    }

    public static ToolExecutionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ToolExecutionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolExecutionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolExecutionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolExecutionResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentType(String str) {
        str.getClass();
        this.contentType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.contentType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutput(String str) {
        str.getClass();
        this.output_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.output_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskId(String str) {
        str.getClass();
        this.taskId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.taskId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCallId(String str) {
        str.getClass();
        this.toolCallId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.toolCallId_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ToolExecutionResult();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005Ȉ\u0006Ȉ\u00072", new Object[]{"taskId_", "toolCallId_", "success_", "output_", "error_", "contentType_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolExecutionResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolExecutionResult.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getContentType() {
        return this.contentType_;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public ByteString getContentTypeBytes() {
        return ByteString.copyFromUtf8(this.contentType_);
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getOutput() {
        return this.output_;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public ByteString getOutputBytes() {
        return ByteString.copyFromUtf8(this.output_);
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public String getToolCallId() {
        return this.toolCallId_;
    }

    @Override // com.zyql.protobuf.agent.ToolExecutionResultOrBuilder
    public ByteString getToolCallIdBytes() {
        return ByteString.copyFromUtf8(this.toolCallId_);
    }

    public static Builder newBuilder(ToolExecutionResult toolExecutionResult) {
        return DEFAULT_INSTANCE.createBuilder(toolExecutionResult);
    }

    public static ToolExecutionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolExecutionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolExecutionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolExecutionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolExecutionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolExecutionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolExecutionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolExecutionResult parseFrom(InputStream inputStream) throws IOException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolExecutionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolExecutionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolExecutionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
