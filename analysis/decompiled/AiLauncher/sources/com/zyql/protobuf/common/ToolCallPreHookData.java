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
public final class ToolCallPreHookData extends GeneratedMessageLite<ToolCallPreHookData, Builder> implements ToolCallPreHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 5;
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 3;
    public static final int CONTEXT_FIELD_NUMBER = 6;
    private static final ToolCallPreHookData DEFAULT_INSTANCE;
    private static volatile Parser<ToolCallPreHookData> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 1;
    public static final int TOOL_NAME_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> context_ = MapFieldLite.emptyMapField();
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    /* renamed from: com.zyql.protobuf.common.ToolCallPreHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolCallPreHookData, Builder> implements ToolCallPreHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearArgumentsJson() {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).clearArgumentsJson();
            return this;
        }

        public Builder clearContext() {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).getMutableContextMap().clear();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearToolCallId() {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).clearToolCallId();
            return this;
        }

        public Builder clearToolName() {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).clearToolName();
            return this;
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public boolean containsContext(String str) {
            str.getClass();
            return ((ToolCallPreHookData) this.instance).getContextMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getAgentId() {
            return ((ToolCallPreHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((ToolCallPreHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getArgumentsJson() {
            return ((ToolCallPreHookData) this.instance).getArgumentsJson();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public ByteString getArgumentsJsonBytes() {
            return ((ToolCallPreHookData) this.instance).getArgumentsJsonBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        @Deprecated
        public Map<String, String> getContext() {
            return getContextMap();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public int getContextCount() {
            return ((ToolCallPreHookData) this.instance).getContextMap().size();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public Map<String, String> getContextMap() {
            return Collections.unmodifiableMap(((ToolCallPreHookData) this.instance).getContextMap());
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getContextOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> contextMap = ((ToolCallPreHookData) this.instance).getContextMap();
            return contextMap.containsKey(str) ? contextMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getContextOrThrow(String str) {
            str.getClass();
            Map<String, String> contextMap = ((ToolCallPreHookData) this.instance).getContextMap();
            if (contextMap.containsKey(str)) {
                return contextMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getSessionId() {
            return ((ToolCallPreHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ToolCallPreHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getToolCallId() {
            return ((ToolCallPreHookData) this.instance).getToolCallId();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public ByteString getToolCallIdBytes() {
            return ((ToolCallPreHookData) this.instance).getToolCallIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public String getToolName() {
            return ((ToolCallPreHookData) this.instance).getToolName();
        }

        @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
        public ByteString getToolNameBytes() {
            return ((ToolCallPreHookData) this.instance).getToolNameBytes();
        }

        public Builder putAllContext(Map<String, String> map) {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).getMutableContextMap().putAll(map);
            return this;
        }

        public Builder putContext(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).getMutableContextMap().put(str, str2);
            return this;
        }

        public Builder removeContext(String str) {
            str.getClass();
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).getMutableContextMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setArgumentsJson(String str) {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setArgumentsJson(str);
            return this;
        }

        public Builder setArgumentsJsonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setArgumentsJsonBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setToolCallId(String str) {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setToolCallId(str);
            return this;
        }

        public Builder setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setToolCallIdBytes(byteString);
            return this;
        }

        public Builder setToolName(String str) {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setToolName(str);
            return this;
        }

        public Builder setToolNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPreHookData) this.instance).setToolNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(ToolCallPreHookData.DEFAULT_INSTANCE);
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
        ToolCallPreHookData toolCallPreHookData = new ToolCallPreHookData();
        DEFAULT_INSTANCE = toolCallPreHookData;
        GeneratedMessageLite.registerDefaultInstance(ToolCallPreHookData.class, toolCallPreHookData);
    }

    private ToolCallPreHookData() {
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

    public static ToolCallPreHookData getDefaultInstance() {
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

    public static ToolCallPreHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallPreHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolCallPreHookData> parser() {
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

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
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
                return new ToolCallPreHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"toolCallId_", "toolName_", "argumentsJson_", "sessionId_", "agentId_", "context_", ContextDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolCallPreHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolCallPreHookData.class) {
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

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getArgumentsJson() {
        return this.argumentsJson_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public ByteString getArgumentsJsonBytes() {
        return ByteString.copyFromUtf8(this.argumentsJson_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public int getContextCount() {
        return internalGetContext().size();
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(internalGetContext());
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        return mapFieldLiteInternalGetContext.containsKey(str) ? mapFieldLiteInternalGetContext.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getContextOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        if (mapFieldLiteInternalGetContext.containsKey(str)) {
            return mapFieldLiteInternalGetContext.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getToolCallId() {
        return this.toolCallId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public ByteString getToolCallIdBytes() {
        return ByteString.copyFromUtf8(this.toolCallId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public String getToolName() {
        return this.toolName_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPreHookDataOrBuilder
    public ByteString getToolNameBytes() {
        return ByteString.copyFromUtf8(this.toolName_);
    }

    public static Builder newBuilder(ToolCallPreHookData toolCallPreHookData) {
        return DEFAULT_INSTANCE.createBuilder(toolCallPreHookData);
    }

    public static ToolCallPreHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallPreHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolCallPreHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolCallPreHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolCallPreHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolCallPreHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolCallPreHookData parseFrom(InputStream inputStream) throws IOException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallPreHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallPreHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolCallPreHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
