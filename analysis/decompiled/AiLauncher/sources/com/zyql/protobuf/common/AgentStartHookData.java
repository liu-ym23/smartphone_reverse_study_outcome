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
public final class AgentStartHookData extends GeneratedMessageLite<AgentStartHookData, Builder> implements AgentStartHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    public static final int CONTEXT_FIELD_NUMBER = 6;
    private static final AgentStartHookData DEFAULT_INSTANCE;
    public static final int INPUT_TEXT_FIELD_NUMBER = 5;
    private static volatile Parser<AgentStartHookData> PARSER = null;
    public static final int RUN_ID_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    private MapFieldLite<String, String> context_ = MapFieldLite.emptyMapField();
    private String agentId_ = "";
    private String agentName_ = "";
    private String sessionId_ = "";
    private String runId_ = "";
    private String inputText_ = "";

    /* renamed from: com.zyql.protobuf.common.AgentStartHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AgentStartHookData, Builder> implements AgentStartHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((AgentStartHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearAgentName() {
            copyOnWrite();
            ((AgentStartHookData) this.instance).clearAgentName();
            return this;
        }

        public Builder clearContext() {
            copyOnWrite();
            ((AgentStartHookData) this.instance).getMutableContextMap().clear();
            return this;
        }

        public Builder clearInputText() {
            copyOnWrite();
            ((AgentStartHookData) this.instance).clearInputText();
            return this;
        }

        public Builder clearRunId() {
            copyOnWrite();
            ((AgentStartHookData) this.instance).clearRunId();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((AgentStartHookData) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public boolean containsContext(String str) {
            str.getClass();
            return ((AgentStartHookData) this.instance).getContextMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getAgentId() {
            return ((AgentStartHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((AgentStartHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getAgentName() {
            return ((AgentStartHookData) this.instance).getAgentName();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public ByteString getAgentNameBytes() {
            return ((AgentStartHookData) this.instance).getAgentNameBytes();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        @Deprecated
        public Map<String, String> getContext() {
            return getContextMap();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public int getContextCount() {
            return ((AgentStartHookData) this.instance).getContextMap().size();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public Map<String, String> getContextMap() {
            return Collections.unmodifiableMap(((AgentStartHookData) this.instance).getContextMap());
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getContextOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> contextMap = ((AgentStartHookData) this.instance).getContextMap();
            return contextMap.containsKey(str) ? contextMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getContextOrThrow(String str) {
            str.getClass();
            Map<String, String> contextMap = ((AgentStartHookData) this.instance).getContextMap();
            if (contextMap.containsKey(str)) {
                return contextMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getInputText() {
            return ((AgentStartHookData) this.instance).getInputText();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public ByteString getInputTextBytes() {
            return ((AgentStartHookData) this.instance).getInputTextBytes();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getRunId() {
            return ((AgentStartHookData) this.instance).getRunId();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public ByteString getRunIdBytes() {
            return ((AgentStartHookData) this.instance).getRunIdBytes();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public String getSessionId() {
            return ((AgentStartHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((AgentStartHookData) this.instance).getSessionIdBytes();
        }

        public Builder putAllContext(Map<String, String> map) {
            copyOnWrite();
            ((AgentStartHookData) this.instance).getMutableContextMap().putAll(map);
            return this;
        }

        public Builder putContext(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((AgentStartHookData) this.instance).getMutableContextMap().put(str, str2);
            return this;
        }

        public Builder removeContext(String str) {
            str.getClass();
            copyOnWrite();
            ((AgentStartHookData) this.instance).getMutableContextMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setAgentName(String str) {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setAgentName(str);
            return this;
        }

        public Builder setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setAgentNameBytes(byteString);
            return this;
        }

        public Builder setInputText(String str) {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setInputText(str);
            return this;
        }

        public Builder setInputTextBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setInputTextBytes(byteString);
            return this;
        }

        public Builder setRunId(String str) {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setRunId(str);
            return this;
        }

        public Builder setRunIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setRunIdBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentStartHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(AgentStartHookData.DEFAULT_INSTANCE);
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
        AgentStartHookData agentStartHookData = new AgentStartHookData();
        DEFAULT_INSTANCE = agentStartHookData;
        GeneratedMessageLite.registerDefaultInstance(AgentStartHookData.class, agentStartHookData);
    }

    private AgentStartHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputText() {
        this.inputText_ = getDefaultInstance().getInputText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRunId() {
        this.runId_ = getDefaultInstance().getRunId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static AgentStartHookData getDefaultInstance() {
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

    public static AgentStartHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgentStartHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentStartHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AgentStartHookData> parser() {
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
    public void setAgentName(String str) {
        str.getClass();
        this.agentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputText(String str) {
        str.getClass();
        this.inputText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputTextBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.inputText_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRunId(String str) {
        str.getClass();
        this.runId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRunIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.runId_ = byteString.toStringUtf8();
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

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
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
                return new AgentStartHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"agentId_", "agentName_", "sessionId_", "runId_", "inputText_", "context_", ContextDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AgentStartHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AgentStartHookData.class) {
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

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getAgentName() {
        return this.agentName_;
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public ByteString getAgentNameBytes() {
        return ByteString.copyFromUtf8(this.agentName_);
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public int getContextCount() {
        return internalGetContext().size();
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(internalGetContext());
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        return mapFieldLiteInternalGetContext.containsKey(str) ? mapFieldLiteInternalGetContext.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getContextOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        if (mapFieldLiteInternalGetContext.containsKey(str)) {
            return mapFieldLiteInternalGetContext.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getInputText() {
        return this.inputText_;
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public ByteString getInputTextBytes() {
        return ByteString.copyFromUtf8(this.inputText_);
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getRunId() {
        return this.runId_;
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public ByteString getRunIdBytes() {
        return ByteString.copyFromUtf8(this.runId_);
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.AgentStartHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(AgentStartHookData agentStartHookData) {
        return DEFAULT_INSTANCE.createBuilder(agentStartHookData);
    }

    public static AgentStartHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentStartHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentStartHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AgentStartHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AgentStartHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AgentStartHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AgentStartHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AgentStartHookData parseFrom(InputStream inputStream) throws IOException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentStartHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentStartHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AgentStartHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
