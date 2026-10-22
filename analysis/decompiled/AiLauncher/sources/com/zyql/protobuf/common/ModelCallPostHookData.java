package com.zyql.protobuf.common;

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
public final class ModelCallPostHookData extends GeneratedMessageLite<ModelCallPostHookData, Builder> implements ModelCallPostHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 9;
    private static final ModelCallPostHookData DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int INPUT_TOKENS_FIELD_NUMBER = 5;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int MODEL_NAME_FIELD_NUMBER = 1;
    public static final int OUTPUT_TOKENS_FIELD_NUMBER = 6;
    private static volatile Parser<ModelCallPostHookData> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 2;
    public static final int RESPONSE_TEXT_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 8;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    private long durationMs_;
    private int inputTokens_;
    private int outputTokens_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String modelName_ = "";
    private String provider_ = "";
    private String responseText_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    /* renamed from: com.zyql.protobuf.common.ModelCallPostHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ModelCallPostHookData, Builder> implements ModelCallPostHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearInputTokens() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearInputTokens();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearModelName() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearModelName();
            return this;
        }

        public Builder clearOutputTokens() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearOutputTokens();
            return this;
        }

        public Builder clearProvider() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearProvider();
            return this;
        }

        public Builder clearResponseText() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearResponseText();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).clearSuccess();
            return this;
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((ModelCallPostHookData) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getAgentId() {
            return ((ModelCallPostHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((ModelCallPostHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public long getDurationMs() {
            return ((ModelCallPostHookData) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public int getInputTokens() {
            return ((ModelCallPostHookData) this.instance).getInputTokens();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public int getMetadataCount() {
            return ((ModelCallPostHookData) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((ModelCallPostHookData) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((ModelCallPostHookData) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((ModelCallPostHookData) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getModelName() {
            return ((ModelCallPostHookData) this.instance).getModelName();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public ByteString getModelNameBytes() {
            return ((ModelCallPostHookData) this.instance).getModelNameBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public int getOutputTokens() {
            return ((ModelCallPostHookData) this.instance).getOutputTokens();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getProvider() {
            return ((ModelCallPostHookData) this.instance).getProvider();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public ByteString getProviderBytes() {
            return ((ModelCallPostHookData) this.instance).getProviderBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getResponseText() {
            return ((ModelCallPostHookData) this.instance).getResponseText();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public ByteString getResponseTextBytes() {
            return ((ModelCallPostHookData) this.instance).getResponseTextBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public String getSessionId() {
            return ((ModelCallPostHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ModelCallPostHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
        public boolean getSuccess() {
            return ((ModelCallPostHookData) this.instance).getSuccess();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setInputTokens(int i10) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setInputTokens(i10);
            return this;
        }

        public Builder setModelName(String str) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setModelName(str);
            return this;
        }

        public Builder setModelNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setModelNameBytes(byteString);
            return this;
        }

        public Builder setOutputTokens(int i10) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setOutputTokens(i10);
            return this;
        }

        public Builder setProvider(String str) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setProvider(str);
            return this;
        }

        public Builder setProviderBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setProviderBytes(byteString);
            return this;
        }

        public Builder setResponseText(String str) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setResponseText(str);
            return this;
        }

        public Builder setResponseTextBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setResponseTextBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((ModelCallPostHookData) this.instance).setSuccess(z10);
            return this;
        }

        private Builder() {
            super(ModelCallPostHookData.DEFAULT_INSTANCE);
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
        ModelCallPostHookData modelCallPostHookData = new ModelCallPostHookData();
        DEFAULT_INSTANCE = modelCallPostHookData;
        GeneratedMessageLite.registerDefaultInstance(ModelCallPostHookData.class, modelCallPostHookData);
    }

    private ModelCallPostHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputTokens() {
        this.inputTokens_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModelName() {
        this.modelName_ = getDefaultInstance().getModelName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutputTokens() {
        this.outputTokens_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProvider() {
        this.provider_ = getDefaultInstance().getProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseText() {
        this.responseText_ = getDefaultInstance().getResponseText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static ModelCallPostHookData getDefaultInstance() {
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

    public static ModelCallPostHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ModelCallPostHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ModelCallPostHookData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentId(String str) {
        str.getClass();
        this.agentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputTokens(int i10) {
        this.inputTokens_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelName(String str) {
        str.getClass();
        this.modelName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.modelName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputTokens(int i10) {
        this.outputTokens_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProvider(String str) {
        str.getClass();
        this.provider_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviderBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.provider_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseText(String str) {
        str.getClass();
        this.responseText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTextBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.responseText_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
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
                return new ModelCallPostHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0004\u0006\u0004\u0007\u0002\bȈ\tȈ\n2", new Object[]{"modelName_", "provider_", "success_", "responseText_", "inputTokens_", "outputTokens_", "durationMs_", "sessionId_", "agentId_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ModelCallPostHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ModelCallPostHookData.class) {
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

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public int getInputTokens() {
        return this.inputTokens_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getModelName() {
        return this.modelName_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public ByteString getModelNameBytes() {
        return ByteString.copyFromUtf8(this.modelName_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public int getOutputTokens() {
        return this.outputTokens_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getProvider() {
        return this.provider_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public ByteString getProviderBytes() {
        return ByteString.copyFromUtf8(this.provider_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getResponseText() {
        return this.responseText_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public ByteString getResponseTextBytes() {
        return ByteString.copyFromUtf8(this.responseText_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPostHookDataOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    public static Builder newBuilder(ModelCallPostHookData modelCallPostHookData) {
        return DEFAULT_INSTANCE.createBuilder(modelCallPostHookData);
    }

    public static ModelCallPostHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ModelCallPostHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ModelCallPostHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ModelCallPostHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ModelCallPostHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ModelCallPostHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ModelCallPostHookData parseFrom(InputStream inputStream) throws IOException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ModelCallPostHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ModelCallPostHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ModelCallPostHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
