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
public final class HookExecutionResult extends GeneratedMessageLite<HookExecutionResult, Builder> implements HookExecutionResultOrBuilder {
    public static final int CONTINUE_EXECUTION_FIELD_NUMBER = 3;
    private static final HookExecutionResult DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 8;
    public static final int MODIFIED_DATA_FIELD_NUMBER = 5;
    public static final int MODIFIED_FIELD_NUMBER = 6;
    private static volatile Parser<HookExecutionResult> PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 2;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private boolean continueExecution_;
    private long durationMs_;
    private boolean modified_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String taskId_ = "";
    private String error_ = "";
    private ByteString modifiedData_ = ByteString.EMPTY;

    /* renamed from: com.zyql.protobuf.agent.HookExecutionResult$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HookExecutionResult, Builder> implements HookExecutionResultOrBuilder {
        public Builder clearContinueExecution() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearContinueExecution();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearError();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearModified() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearModified();
            return this;
        }

        public Builder clearModifiedData() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearModifiedData();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearSuccess();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((HookExecutionResult) this.instance).clearTaskId();
            return this;
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((HookExecutionResult) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public boolean getContinueExecution() {
            return ((HookExecutionResult) this.instance).getContinueExecution();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public long getDurationMs() {
            return ((HookExecutionResult) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public String getError() {
            return ((HookExecutionResult) this.instance).getError();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public ByteString getErrorBytes() {
            return ((HookExecutionResult) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public int getMetadataCount() {
            return ((HookExecutionResult) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((HookExecutionResult) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((HookExecutionResult) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((HookExecutionResult) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public boolean getModified() {
            return ((HookExecutionResult) this.instance).getModified();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public ByteString getModifiedData() {
            return ((HookExecutionResult) this.instance).getModifiedData();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public boolean getSuccess() {
            return ((HookExecutionResult) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public String getTaskId() {
            return ((HookExecutionResult) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
        public ByteString getTaskIdBytes() {
            return ((HookExecutionResult) this.instance).getTaskIdBytes();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((HookExecutionResult) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((HookExecutionResult) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setContinueExecution(boolean z10) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setContinueExecution(z10);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setModified(boolean z10) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setModified(z10);
            return this;
        }

        public Builder setModifiedData(ByteString byteString) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setModifiedData(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookExecutionResult) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(HookExecutionResult.DEFAULT_INSTANCE);
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
        HookExecutionResult hookExecutionResult = new HookExecutionResult();
        DEFAULT_INSTANCE = hookExecutionResult;
        GeneratedMessageLite.registerDefaultInstance(HookExecutionResult.class, hookExecutionResult);
    }

    private HookExecutionResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContinueExecution() {
        this.continueExecution_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModified() {
        this.modified_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModifiedData() {
        this.modifiedData_ = getDefaultInstance().getModifiedData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    public static HookExecutionResult getDefaultInstance() {
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

    public static HookExecutionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HookExecutionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookExecutionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HookExecutionResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContinueExecution(boolean z10) {
        this.continueExecution_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
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
    public void setModified(boolean z10) {
        this.modified_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModifiedData(ByteString byteString) {
        byteString.getClass();
        this.modifiedData_ = byteString;
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

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
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
                return new HookExecutionResult();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001Ȉ\u0002\u0007\u0003\u0007\u0004Ȉ\u0005\n\u0006\u0007\u0007\u0002\b2", new Object[]{"taskId_", "success_", "continueExecution_", "error_", "modifiedData_", "modified_", "durationMs_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HookExecutionResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HookExecutionResult.class) {
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

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public boolean getContinueExecution() {
        return this.continueExecution_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public boolean getModified() {
        return this.modified_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public ByteString getModifiedData() {
        return this.modifiedData_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.agent.HookExecutionResultOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    public static Builder newBuilder(HookExecutionResult hookExecutionResult) {
        return DEFAULT_INSTANCE.createBuilder(hookExecutionResult);
    }

    public static HookExecutionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookExecutionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookExecutionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HookExecutionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HookExecutionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HookExecutionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HookExecutionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HookExecutionResult parseFrom(InputStream inputStream) throws IOException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookExecutionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookExecutionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HookExecutionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookExecutionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
