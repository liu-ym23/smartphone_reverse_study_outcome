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
public final class ToolCallPostHookData extends GeneratedMessageLite<ToolCallPostHookData, Builder> implements ToolCallPostHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 9;
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 3;
    public static final int CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int CONTEXT_FIELD_NUMBER = 10;
    private static final ToolCallPostHookData DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int OUTPUT_FIELD_NUMBER = 5;
    private static volatile Parser<ToolCallPostHookData> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 8;
    public static final int SUCCESS_FIELD_NUMBER = 4;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 1;
    public static final int TOOL_NAME_FIELD_NUMBER = 2;
    private long durationMs_;
    private boolean success_;
    private MapFieldLite<String, String> context_ = MapFieldLite.emptyMapField();
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";
    private String output_ = "";
    private String contentType_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    /* renamed from: com.zyql.protobuf.common.ToolCallPostHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolCallPostHookData, Builder> implements ToolCallPostHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearArgumentsJson() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearArgumentsJson();
            return this;
        }

        public Builder clearContentType() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearContentType();
            return this;
        }

        public Builder clearContext() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).getMutableContextMap().clear();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearOutput() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearOutput();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearSuccess();
            return this;
        }

        public Builder clearToolCallId() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearToolCallId();
            return this;
        }

        public Builder clearToolName() {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).clearToolName();
            return this;
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public boolean containsContext(String str) {
            str.getClass();
            return ((ToolCallPostHookData) this.instance).getContextMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getAgentId() {
            return ((ToolCallPostHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((ToolCallPostHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getArgumentsJson() {
            return ((ToolCallPostHookData) this.instance).getArgumentsJson();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getArgumentsJsonBytes() {
            return ((ToolCallPostHookData) this.instance).getArgumentsJsonBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getContentType() {
            return ((ToolCallPostHookData) this.instance).getContentType();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getContentTypeBytes() {
            return ((ToolCallPostHookData) this.instance).getContentTypeBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        @Deprecated
        public Map<String, String> getContext() {
            return getContextMap();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public int getContextCount() {
            return ((ToolCallPostHookData) this.instance).getContextMap().size();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public Map<String, String> getContextMap() {
            return Collections.unmodifiableMap(((ToolCallPostHookData) this.instance).getContextMap());
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getContextOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> contextMap = ((ToolCallPostHookData) this.instance).getContextMap();
            return contextMap.containsKey(str) ? contextMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getContextOrThrow(String str) {
            str.getClass();
            Map<String, String> contextMap = ((ToolCallPostHookData) this.instance).getContextMap();
            if (contextMap.containsKey(str)) {
                return contextMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public long getDurationMs() {
            return ((ToolCallPostHookData) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getOutput() {
            return ((ToolCallPostHookData) this.instance).getOutput();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getOutputBytes() {
            return ((ToolCallPostHookData) this.instance).getOutputBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getSessionId() {
            return ((ToolCallPostHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ToolCallPostHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public boolean getSuccess() {
            return ((ToolCallPostHookData) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getToolCallId() {
            return ((ToolCallPostHookData) this.instance).getToolCallId();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getToolCallIdBytes() {
            return ((ToolCallPostHookData) this.instance).getToolCallIdBytes();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public String getToolName() {
            return ((ToolCallPostHookData) this.instance).getToolName();
        }

        @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
        public ByteString getToolNameBytes() {
            return ((ToolCallPostHookData) this.instance).getToolNameBytes();
        }

        public Builder putAllContext(Map<String, String> map) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).getMutableContextMap().putAll(map);
            return this;
        }

        public Builder putContext(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).getMutableContextMap().put(str, str2);
            return this;
        }

        public Builder removeContext(String str) {
            str.getClass();
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).getMutableContextMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setArgumentsJson(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setArgumentsJson(str);
            return this;
        }

        public Builder setArgumentsJsonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setArgumentsJsonBytes(byteString);
            return this;
        }

        public Builder setContentType(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setContentType(str);
            return this;
        }

        public Builder setContentTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setContentTypeBytes(byteString);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setOutput(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setOutput(str);
            return this;
        }

        public Builder setOutputBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setOutputBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setToolCallId(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setToolCallId(str);
            return this;
        }

        public Builder setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setToolCallIdBytes(byteString);
            return this;
        }

        public Builder setToolName(String str) {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setToolName(str);
            return this;
        }

        public Builder setToolNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallPostHookData) this.instance).setToolNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(ToolCallPostHookData.DEFAULT_INSTANCE);
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
        ToolCallPostHookData toolCallPostHookData = new ToolCallPostHookData();
        DEFAULT_INSTANCE = toolCallPostHookData;
        GeneratedMessageLite.registerDefaultInstance(ToolCallPostHookData.class, toolCallPostHookData);
    }

    private ToolCallPostHookData() {
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
    public void clearContentType() {
        this.contentType_ = getDefaultInstance().getContentType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.output_ = getDefaultInstance().getOutput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallId() {
        this.toolCallId_ = getDefaultInstance().getToolCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolName() {
        this.toolName_ = getDefaultInstance().getToolName();
    }

    public static ToolCallPostHookData getDefaultInstance() {
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

    public static ToolCallPostHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallPostHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolCallPostHookData> parser() {
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
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
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

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
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
                return new ToolCallPostHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007\u0002\bȈ\tȈ\n2", new Object[]{"toolCallId_", "toolName_", "argumentsJson_", "success_", "output_", "contentType_", "durationMs_", "sessionId_", "agentId_", "context_", ContextDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolCallPostHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolCallPostHookData.class) {
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

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getArgumentsJson() {
        return this.argumentsJson_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getArgumentsJsonBytes() {
        return ByteString.copyFromUtf8(this.argumentsJson_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getContentType() {
        return this.contentType_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getContentTypeBytes() {
        return ByteString.copyFromUtf8(this.contentType_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public int getContextCount() {
        return internalGetContext().size();
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(internalGetContext());
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        return mapFieldLiteInternalGetContext.containsKey(str) ? mapFieldLiteInternalGetContext.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getContextOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        if (mapFieldLiteInternalGetContext.containsKey(str)) {
            return mapFieldLiteInternalGetContext.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getOutput() {
        return this.output_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getOutputBytes() {
        return ByteString.copyFromUtf8(this.output_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getToolCallId() {
        return this.toolCallId_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getToolCallIdBytes() {
        return ByteString.copyFromUtf8(this.toolCallId_);
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public String getToolName() {
        return this.toolName_;
    }

    @Override // com.zyql.protobuf.common.ToolCallPostHookDataOrBuilder
    public ByteString getToolNameBytes() {
        return ByteString.copyFromUtf8(this.toolName_);
    }

    public static Builder newBuilder(ToolCallPostHookData toolCallPostHookData) {
        return DEFAULT_INSTANCE.createBuilder(toolCallPostHookData);
    }

    public static ToolCallPostHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallPostHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolCallPostHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolCallPostHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolCallPostHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolCallPostHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolCallPostHookData parseFrom(InputStream inputStream) throws IOException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallPostHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallPostHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolCallPostHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
