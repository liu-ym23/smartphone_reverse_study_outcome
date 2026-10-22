package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.zyql.protobuf.common.FunctionCall;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ModelCallPreHookData extends GeneratedMessageLite<ModelCallPreHookData, Builder> implements ModelCallPreHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 5;
    private static final ModelCallPreHookData DEFAULT_INSTANCE;
    public static final int MODEL_NAME_FIELD_NUMBER = 1;
    private static volatile Parser<ModelCallPreHookData> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 2;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int SETTINGS_FIELD_NUMBER = 6;
    public static final int TOOL_CALLS_FIELD_NUMBER = 3;
    private MapFieldLite<String, String> settings_ = MapFieldLite.emptyMapField();
    private String modelName_ = "";
    private String provider_ = "";
    private Internal.ProtobufList<FunctionCall> toolCalls_ = GeneratedMessageLite.emptyProtobufList();
    private String sessionId_ = "";
    private String agentId_ = "";

    /* renamed from: com.zyql.protobuf.common.ModelCallPreHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ModelCallPreHookData, Builder> implements ModelCallPreHookDataOrBuilder {
        public Builder addAllToolCalls(Iterable<? extends FunctionCall> iterable) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).addAllToolCalls(iterable);
            return this;
        }

        public Builder addToolCalls(FunctionCall functionCall) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).addToolCalls(functionCall);
            return this;
        }

        public Builder clearAgentId() {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearModelName() {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).clearModelName();
            return this;
        }

        public Builder clearProvider() {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).clearProvider();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearSettings() {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).getMutableSettingsMap().clear();
            return this;
        }

        public Builder clearToolCalls() {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).clearToolCalls();
            return this;
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public boolean containsSettings(String str) {
            str.getClass();
            return ((ModelCallPreHookData) this.instance).getSettingsMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public String getAgentId() {
            return ((ModelCallPreHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((ModelCallPreHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public String getModelName() {
            return ((ModelCallPreHookData) this.instance).getModelName();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public ByteString getModelNameBytes() {
            return ((ModelCallPreHookData) this.instance).getModelNameBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public String getProvider() {
            return ((ModelCallPreHookData) this.instance).getProvider();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public ByteString getProviderBytes() {
            return ((ModelCallPreHookData) this.instance).getProviderBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public String getSessionId() {
            return ((ModelCallPreHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ModelCallPreHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        @Deprecated
        public Map<String, String> getSettings() {
            return getSettingsMap();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public int getSettingsCount() {
            return ((ModelCallPreHookData) this.instance).getSettingsMap().size();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public Map<String, String> getSettingsMap() {
            return Collections.unmodifiableMap(((ModelCallPreHookData) this.instance).getSettingsMap());
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public String getSettingsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> settingsMap = ((ModelCallPreHookData) this.instance).getSettingsMap();
            return settingsMap.containsKey(str) ? settingsMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public String getSettingsOrThrow(String str) {
            str.getClass();
            Map<String, String> settingsMap = ((ModelCallPreHookData) this.instance).getSettingsMap();
            if (settingsMap.containsKey(str)) {
                return settingsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public FunctionCall getToolCalls(int i10) {
            return ((ModelCallPreHookData) this.instance).getToolCalls(i10);
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public int getToolCallsCount() {
            return ((ModelCallPreHookData) this.instance).getToolCallsCount();
        }

        @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
        public List<FunctionCall> getToolCallsList() {
            return Collections.unmodifiableList(((ModelCallPreHookData) this.instance).getToolCallsList());
        }

        public Builder putAllSettings(Map<String, String> map) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).getMutableSettingsMap().putAll(map);
            return this;
        }

        public Builder putSettings(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).getMutableSettingsMap().put(str, str2);
            return this;
        }

        public Builder removeSettings(String str) {
            str.getClass();
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).getMutableSettingsMap().remove(str);
            return this;
        }

        public Builder removeToolCalls(int i10) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).removeToolCalls(i10);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setModelName(String str) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setModelName(str);
            return this;
        }

        public Builder setModelNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setModelNameBytes(byteString);
            return this;
        }

        public Builder setProvider(String str) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setProvider(str);
            return this;
        }

        public Builder setProviderBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setProviderBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setToolCalls(int i10, FunctionCall functionCall) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setToolCalls(i10, functionCall);
            return this;
        }

        private Builder() {
            super(ModelCallPreHookData.DEFAULT_INSTANCE);
        }

        public Builder addToolCalls(int i10, FunctionCall functionCall) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).addToolCalls(i10, functionCall);
            return this;
        }

        public Builder setToolCalls(int i10, FunctionCall.Builder builder) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).setToolCalls(i10, builder.build());
            return this;
        }

        public Builder addToolCalls(FunctionCall.Builder builder) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).addToolCalls(builder.build());
            return this;
        }

        public Builder addToolCalls(int i10, FunctionCall.Builder builder) {
            copyOnWrite();
            ((ModelCallPreHookData) this.instance).addToolCalls(i10, builder.build());
            return this;
        }
    }

    public static final class SettingsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private SettingsDefaultEntryHolder() {
        }
    }

    static {
        ModelCallPreHookData modelCallPreHookData = new ModelCallPreHookData();
        DEFAULT_INSTANCE = modelCallPreHookData;
        GeneratedMessageLite.registerDefaultInstance(ModelCallPreHookData.class, modelCallPreHookData);
    }

    private ModelCallPreHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllToolCalls(Iterable<? extends FunctionCall> iterable) {
        ensureToolCallsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.toolCalls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToolCalls(FunctionCall functionCall) {
        functionCall.getClass();
        ensureToolCallsIsMutable();
        this.toolCalls_.add(functionCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModelName() {
        this.modelName_ = getDefaultInstance().getModelName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProvider() {
        this.provider_ = getDefaultInstance().getProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCalls() {
        this.toolCalls_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureToolCallsIsMutable() {
        Internal.ProtobufList<FunctionCall> protobufList = this.toolCalls_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.toolCalls_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ModelCallPreHookData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableSettingsMap() {
        return internalGetMutableSettings();
    }

    private MapFieldLite<String, String> internalGetMutableSettings() {
        if (!this.settings_.isMutable()) {
            this.settings_ = this.settings_.mutableCopy();
        }
        return this.settings_;
    }

    private MapFieldLite<String, String> internalGetSettings() {
        return this.settings_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ModelCallPreHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ModelCallPreHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ModelCallPreHookData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeToolCalls(int i10) {
        ensureToolCallsIsMutable();
        this.toolCalls_.remove(i10);
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
    public void setToolCalls(int i10, FunctionCall functionCall) {
        functionCall.getClass();
        ensureToolCallsIsMutable();
        this.toolCalls_.set(i10, functionCall);
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public boolean containsSettings(String str) {
        str.getClass();
        return internalGetSettings().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ModelCallPreHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"modelName_", "provider_", "toolCalls_", FunctionCall.class, "sessionId_", "agentId_", "settings_", SettingsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ModelCallPreHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ModelCallPreHookData.class) {
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

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public String getModelName() {
        return this.modelName_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public ByteString getModelNameBytes() {
        return ByteString.copyFromUtf8(this.modelName_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public String getProvider() {
        return this.provider_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public ByteString getProviderBytes() {
        return ByteString.copyFromUtf8(this.provider_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    @Deprecated
    public Map<String, String> getSettings() {
        return getSettingsMap();
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public int getSettingsCount() {
        return internalGetSettings().size();
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public Map<String, String> getSettingsMap() {
        return Collections.unmodifiableMap(internalGetSettings());
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public String getSettingsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetSettings = internalGetSettings();
        return mapFieldLiteInternalGetSettings.containsKey(str) ? mapFieldLiteInternalGetSettings.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public String getSettingsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetSettings = internalGetSettings();
        if (mapFieldLiteInternalGetSettings.containsKey(str)) {
            return mapFieldLiteInternalGetSettings.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public FunctionCall getToolCalls(int i10) {
        return this.toolCalls_.get(i10);
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public int getToolCallsCount() {
        return this.toolCalls_.size();
    }

    @Override // com.zyql.protobuf.common.ModelCallPreHookDataOrBuilder
    public List<FunctionCall> getToolCallsList() {
        return this.toolCalls_;
    }

    public FunctionCallOrBuilder getToolCallsOrBuilder(int i10) {
        return this.toolCalls_.get(i10);
    }

    public List<? extends FunctionCallOrBuilder> getToolCallsOrBuilderList() {
        return this.toolCalls_;
    }

    public static Builder newBuilder(ModelCallPreHookData modelCallPreHookData) {
        return DEFAULT_INSTANCE.createBuilder(modelCallPreHookData);
    }

    public static ModelCallPreHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ModelCallPreHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ModelCallPreHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToolCalls(int i10, FunctionCall functionCall) {
        functionCall.getClass();
        ensureToolCallsIsMutable();
        this.toolCalls_.add(i10, functionCall);
    }

    public static ModelCallPreHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ModelCallPreHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ModelCallPreHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ModelCallPreHookData parseFrom(InputStream inputStream) throws IOException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ModelCallPreHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ModelCallPreHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ModelCallPreHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
