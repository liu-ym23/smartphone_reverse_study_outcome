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
public final class ToolCallErrorHookData extends GeneratedMessageLite<ToolCallErrorHookData, Builder> implements ToolCallErrorHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 8;
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 3;
    public static final int CONTEXT_FIELD_NUMBER = 9;
    private static final ToolCallErrorHookData DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 6;
    public static final int ERROR_CODE_FIELD_NUMBER = 5;
    public static final int ERROR_FIELD_NUMBER = 4;
    private static volatile Parser<ToolCallErrorHookData> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 7;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 1;
    public static final int TOOL_NAME_FIELD_NUMBER = 2;
    private long durationMs_;
    private MapFieldLite<String, String> context_ = MapFieldLite.emptyMapField();
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";
    private String error_ = "";
    private String errorCode_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    /* renamed from: com.zyql.protobuf.common.ToolCallErrorHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolCallErrorHookData, Builder> implements ToolCallErrorHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearArgumentsJson() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearArgumentsJson();
            return this;
        }

        public Builder clearContext() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).getMutableContextMap().clear();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearError();
            return this;
        }

        public Builder clearErrorCode() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearErrorCode();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearToolCallId() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearToolCallId();
            return this;
        }

        public Builder clearToolName() {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).clearToolName();
            return this;
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public boolean containsContext(String str) {
            str.getClass();
            return ((ToolCallErrorHookData) this.instance).getContextMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getAgentId() {
            return ((ToolCallErrorHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((ToolCallErrorHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getArgumentsJson() {
            return ((ToolCallErrorHookData) this.instance).getArgumentsJson();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getArgumentsJsonBytes() {
            return ((ToolCallErrorHookData) this.instance).getArgumentsJsonBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        @Deprecated
        public Map<String, String> getContext() {
            return getContextMap();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public int getContextCount() {
            return ((ToolCallErrorHookData) this.instance).getContextMap().size();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public Map<String, String> getContextMap() {
            return Collections.unmodifiableMap(((ToolCallErrorHookData) this.instance).getContextMap());
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getContextOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> contextMap = ((ToolCallErrorHookData) this.instance).getContextMap();
            return contextMap.containsKey(str) ? contextMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getContextOrThrow(String str) {
            str.getClass();
            Map<String, String> contextMap = ((ToolCallErrorHookData) this.instance).getContextMap();
            if (contextMap.containsKey(str)) {
                return contextMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public long getDurationMs() {
            return ((ToolCallErrorHookData) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getError() {
            return ((ToolCallErrorHookData) this.instance).getError();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getErrorBytes() {
            return ((ToolCallErrorHookData) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getErrorCode() {
            return ((ToolCallErrorHookData) this.instance).getErrorCode();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getErrorCodeBytes() {
            return ((ToolCallErrorHookData) this.instance).getErrorCodeBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getSessionId() {
            return ((ToolCallErrorHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ToolCallErrorHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getToolCallId() {
            return ((ToolCallErrorHookData) this.instance).getToolCallId();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getToolCallIdBytes() {
            return ((ToolCallErrorHookData) this.instance).getToolCallIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public String getToolName() {
            return ((ToolCallErrorHookData) this.instance).getToolName();
        }

        @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
        public ByteString getToolNameBytes() {
            return ((ToolCallErrorHookData) this.instance).getToolNameBytes();
        }

        public Builder putAllContext(Map<String, String> map) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).getMutableContextMap().putAll(map);
            return this;
        }

        public Builder putContext(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).getMutableContextMap().put(str, str2);
            return this;
        }

        public Builder removeContext(String str) {
            str.getClass();
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).getMutableContextMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setArgumentsJson(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setArgumentsJson(str);
            return this;
        }

        public Builder setArgumentsJsonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setArgumentsJsonBytes(byteString);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setErrorCode(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setErrorCode(str);
            return this;
        }

        public Builder setErrorCodeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setErrorCodeBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setToolCallId(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setToolCallId(str);
            return this;
        }

        public Builder setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setToolCallIdBytes(byteString);
            return this;
        }

        public Builder setToolName(String str) {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setToolName(str);
            return this;
        }

        public Builder setToolNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallErrorHookData) this.instance).setToolNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(ToolCallErrorHookData.DEFAULT_INSTANCE);
        }
    }

    public static final class ContextDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ContextDefaultEntryHolder() {
        }
    }

    static {
        ToolCallErrorHookData toolCallErrorHookData = new ToolCallErrorHookData();
        DEFAULT_INSTANCE = toolCallErrorHookData;
        GeneratedMessageLite.registerDefaultInstance(ToolCallErrorHookData.class, toolCallErrorHookData);
    }

    private ToolCallErrorHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArgumentsJson() {
        this.argumentsJson_ = getDefaultInstance().getArgumentsJson();
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
    public void clearErrorCode() {
        this.errorCode_ = getDefaultInstance().getErrorCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallId() {
        this.toolCallId_ = getDefaultInstance().getToolCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolName() {
        this.toolName_ = getDefaultInstance().getToolName();
    }

    public static ToolCallErrorHookData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableContextMap() {
        return internalGetMutableContext();
    }

    private MapFieldLite<String, String> internalGetContext() {
        return this.context_;
    }

    private MapFieldLite<String, String> internalGetMutableContext() {
        if (!this.context_.isMutable()) {
            this.context_ = this.context_.mutableCopy();
        }
        return this.context_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ToolCallErrorHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallErrorHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolCallErrorHookData> parser() {
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
    public void setArgumentsJson(String str) {
        str.getClass();
        this.argumentsJson_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArgumentsJsonBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.argumentsJson_ = byteString.toStringUtf8();
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
    public void setErrorCode(String str) {
        str.getClass();
        this.errorCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCodeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.errorCode_ = byteString.toStringUtf8();
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
    public void setToolCallId(String str) {
        str.getClass();
        this.toolCallId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.toolCallId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolName(String str) {
        str.getClass();
        this.toolName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.toolName_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public boolean containsContext(String str) {
        str.getClass();
        return internalGetContext().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ToolCallErrorHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0002\u0007Ȉ\bȈ\t2", new Object[]{"toolCallId_", "toolName_", "argumentsJson_", "error_", "errorCode_", "durationMs_", "sessionId_", "agentId_", "context_", ContextDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolCallErrorHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolCallErrorHookData.class) {
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

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getArgumentsJson() {
        return this.argumentsJson_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getArgumentsJsonBytes() {
        return ByteString.copyFromUtf8(this.argumentsJson_);
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public int getContextCount() {
        return internalGetContext().size();
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(internalGetContext());
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        return mapFieldLiteInternalGetContext.containsKey(str) ? mapFieldLiteInternalGetContext.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getContextOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        if (mapFieldLiteInternalGetContext.containsKey(str)) {
            return mapFieldLiteInternalGetContext.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getErrorCode() {
        return this.errorCode_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getErrorCodeBytes() {
        return ByteString.copyFromUtf8(this.errorCode_);
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getToolCallId() {
        return this.toolCallId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getToolCallIdBytes() {
        return ByteString.copyFromUtf8(this.toolCallId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public String getToolName() {
        return this.toolName_;
    }

    @Override // com.zyql.protobuf.common.ToolCallErrorHookDataOrBuilder
    public ByteString getToolNameBytes() {
        return ByteString.copyFromUtf8(this.toolName_);
    }

    public static Builder newBuilder(ToolCallErrorHookData toolCallErrorHookData) {
        return DEFAULT_INSTANCE.createBuilder(toolCallErrorHookData);
    }

    public static ToolCallErrorHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallErrorHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolCallErrorHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolCallErrorHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolCallErrorHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolCallErrorHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolCallErrorHookData parseFrom(InputStream inputStream) throws IOException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallErrorHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallErrorHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolCallErrorHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallErrorHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
