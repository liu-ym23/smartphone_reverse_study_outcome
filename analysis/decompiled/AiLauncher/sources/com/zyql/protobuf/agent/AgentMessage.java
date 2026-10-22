package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.Error;
import com.zyql.protobuf.agent.GetAgentInfoResponse;
import com.zyql.protobuf.agent.GetStoreRequest;
import com.zyql.protobuf.agent.HookExecutionResult;
import com.zyql.protobuf.agent.ToolExecutionResult;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class AgentMessage extends GeneratedMessageLite<AgentMessage, Builder> implements AgentMessageOrBuilder {
    private static final AgentMessage DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 60;
    public static final int GET_AGENT_INFO_RESPONSE_FIELD_NUMBER = 10;
    public static final int GET_STORE_REQUEST_FIELD_NUMBER = 50;
    public static final int HOOK_EXECUTION_RESULT_FIELD_NUMBER = 31;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<AgentMessage> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int TOOL_EXECUTION_RESULT_FIELD_NUMBER = 30;
    private Object request_;
    private Object response_;
    private long timestamp_;
    private int responseCase_ = 0;
    private int requestCase_ = 0;
    private String id_ = "";

    /* renamed from: com.zyql.protobuf.agent.AgentMessage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AgentMessage, Builder> implements AgentMessageOrBuilder {
        public Builder clearError() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearError();
            return this;
        }

        public Builder clearGetAgentInfoResponse() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearGetAgentInfoResponse();
            return this;
        }

        public Builder clearGetStoreRequest() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearGetStoreRequest();
            return this;
        }

        public Builder clearHookExecutionResult() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearHookExecutionResult();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearId();
            return this;
        }

        public Builder clearRequest() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearRequest();
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearResponse();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearTimestamp();
            return this;
        }

        public Builder clearToolExecutionResult() {
            copyOnWrite();
            ((AgentMessage) this.instance).clearToolExecutionResult();
            return this;
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public Error getError() {
            return ((AgentMessage) this.instance).getError();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public GetAgentInfoResponse getGetAgentInfoResponse() {
            return ((AgentMessage) this.instance).getGetAgentInfoResponse();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public GetStoreRequest getGetStoreRequest() {
            return ((AgentMessage) this.instance).getGetStoreRequest();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public HookExecutionResult getHookExecutionResult() {
            return ((AgentMessage) this.instance).getHookExecutionResult();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public String getId() {
            return ((AgentMessage) this.instance).getId();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public ByteString getIdBytes() {
            return ((AgentMessage) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public RequestCase getRequestCase() {
            return ((AgentMessage) this.instance).getRequestCase();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public ResponseCase getResponseCase() {
            return ((AgentMessage) this.instance).getResponseCase();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public long getTimestamp() {
            return ((AgentMessage) this.instance).getTimestamp();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public ToolExecutionResult getToolExecutionResult() {
            return ((AgentMessage) this.instance).getToolExecutionResult();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public boolean hasError() {
            return ((AgentMessage) this.instance).hasError();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public boolean hasGetAgentInfoResponse() {
            return ((AgentMessage) this.instance).hasGetAgentInfoResponse();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public boolean hasGetStoreRequest() {
            return ((AgentMessage) this.instance).hasGetStoreRequest();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public boolean hasHookExecutionResult() {
            return ((AgentMessage) this.instance).hasHookExecutionResult();
        }

        @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
        public boolean hasToolExecutionResult() {
            return ((AgentMessage) this.instance).hasToolExecutionResult();
        }

        public Builder mergeError(Error error) {
            copyOnWrite();
            ((AgentMessage) this.instance).mergeError(error);
            return this;
        }

        public Builder mergeGetAgentInfoResponse(GetAgentInfoResponse getAgentInfoResponse) {
            copyOnWrite();
            ((AgentMessage) this.instance).mergeGetAgentInfoResponse(getAgentInfoResponse);
            return this;
        }

        public Builder mergeGetStoreRequest(GetStoreRequest getStoreRequest) {
            copyOnWrite();
            ((AgentMessage) this.instance).mergeGetStoreRequest(getStoreRequest);
            return this;
        }

        public Builder mergeHookExecutionResult(HookExecutionResult hookExecutionResult) {
            copyOnWrite();
            ((AgentMessage) this.instance).mergeHookExecutionResult(hookExecutionResult);
            return this;
        }

        public Builder mergeToolExecutionResult(ToolExecutionResult toolExecutionResult) {
            copyOnWrite();
            ((AgentMessage) this.instance).mergeToolExecutionResult(toolExecutionResult);
            return this;
        }

        public Builder setError(Error error) {
            copyOnWrite();
            ((AgentMessage) this.instance).setError(error);
            return this;
        }

        public Builder setGetAgentInfoResponse(GetAgentInfoResponse getAgentInfoResponse) {
            copyOnWrite();
            ((AgentMessage) this.instance).setGetAgentInfoResponse(getAgentInfoResponse);
            return this;
        }

        public Builder setGetStoreRequest(GetStoreRequest getStoreRequest) {
            copyOnWrite();
            ((AgentMessage) this.instance).setGetStoreRequest(getStoreRequest);
            return this;
        }

        public Builder setHookExecutionResult(HookExecutionResult hookExecutionResult) {
            copyOnWrite();
            ((AgentMessage) this.instance).setHookExecutionResult(hookExecutionResult);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((AgentMessage) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentMessage) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((AgentMessage) this.instance).setTimestamp(j10);
            return this;
        }

        public Builder setToolExecutionResult(ToolExecutionResult toolExecutionResult) {
            copyOnWrite();
            ((AgentMessage) this.instance).setToolExecutionResult(toolExecutionResult);
            return this;
        }

        private Builder() {
            super(AgentMessage.DEFAULT_INSTANCE);
        }

        public Builder setError(Error.Builder builder) {
            copyOnWrite();
            ((AgentMessage) this.instance).setError(builder.build());
            return this;
        }

        public Builder setGetAgentInfoResponse(GetAgentInfoResponse.Builder builder) {
            copyOnWrite();
            ((AgentMessage) this.instance).setGetAgentInfoResponse(builder.build());
            return this;
        }

        public Builder setGetStoreRequest(GetStoreRequest.Builder builder) {
            copyOnWrite();
            ((AgentMessage) this.instance).setGetStoreRequest(builder.build());
            return this;
        }

        public Builder setHookExecutionResult(HookExecutionResult.Builder builder) {
            copyOnWrite();
            ((AgentMessage) this.instance).setHookExecutionResult(builder.build());
            return this;
        }

        public Builder setToolExecutionResult(ToolExecutionResult.Builder builder) {
            copyOnWrite();
            ((AgentMessage) this.instance).setToolExecutionResult(builder.build());
            return this;
        }
    }

    public enum RequestCase {
        GET_STORE_REQUEST(50),
        REQUEST_NOT_SET(0);

        private final int value;

        RequestCase(int i10) {
            this.value = i10;
        }

        public static RequestCase forNumber(int i10) {
            if (i10 == 0) {
                return REQUEST_NOT_SET;
            }
            if (i10 != 50) {
                return null;
            }
            return GET_STORE_REQUEST;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static RequestCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public enum ResponseCase {
        GET_AGENT_INFO_RESPONSE(10),
        TOOL_EXECUTION_RESULT(30),
        HOOK_EXECUTION_RESULT(31),
        ERROR(60),
        RESPONSE_NOT_SET(0);

        private final int value;

        ResponseCase(int i10) {
            this.value = i10;
        }

        public static ResponseCase forNumber(int i10) {
            if (i10 == 0) {
                return RESPONSE_NOT_SET;
            }
            if (i10 == 10) {
                return GET_AGENT_INFO_RESPONSE;
            }
            if (i10 == 60) {
                return ERROR;
            }
            if (i10 == 30) {
                return TOOL_EXECUTION_RESULT;
            }
            if (i10 != 31) {
                return null;
            }
            return HOOK_EXECUTION_RESULT;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ResponseCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        AgentMessage agentMessage = new AgentMessage();
        DEFAULT_INSTANCE = agentMessage;
        GeneratedMessageLite.registerDefaultInstance(AgentMessage.class, agentMessage);
    }

    private AgentMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        if (this.responseCase_ == 60) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGetAgentInfoResponse() {
        if (this.responseCase_ == 10) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGetStoreRequest() {
        if (this.requestCase_ == 50) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookExecutionResult() {
        if (this.responseCase_ == 31) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        this.responseCase_ = 0;
        this.response_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolExecutionResult() {
        if (this.responseCase_ == 30) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    public static AgentMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeError(Error error) {
        error.getClass();
        if (this.responseCase_ != 60 || this.response_ == Error.getDefaultInstance()) {
            this.response_ = error;
        } else {
            this.response_ = Error.newBuilder((Error) this.response_).mergeFrom((Error.Builder) error).buildPartial();
        }
        this.responseCase_ = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGetAgentInfoResponse(GetAgentInfoResponse getAgentInfoResponse) {
        getAgentInfoResponse.getClass();
        if (this.responseCase_ != 10 || this.response_ == GetAgentInfoResponse.getDefaultInstance()) {
            this.response_ = getAgentInfoResponse;
        } else {
            this.response_ = GetAgentInfoResponse.newBuilder((GetAgentInfoResponse) this.response_).mergeFrom((GetAgentInfoResponse.Builder) getAgentInfoResponse).buildPartial();
        }
        this.responseCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGetStoreRequest(GetStoreRequest getStoreRequest) {
        getStoreRequest.getClass();
        if (this.requestCase_ != 50 || this.request_ == GetStoreRequest.getDefaultInstance()) {
            this.request_ = getStoreRequest;
        } else {
            this.request_ = GetStoreRequest.newBuilder((GetStoreRequest) this.request_).mergeFrom((GetStoreRequest.Builder) getStoreRequest).buildPartial();
        }
        this.requestCase_ = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHookExecutionResult(HookExecutionResult hookExecutionResult) {
        hookExecutionResult.getClass();
        if (this.responseCase_ != 31 || this.response_ == HookExecutionResult.getDefaultInstance()) {
            this.response_ = hookExecutionResult;
        } else {
            this.response_ = HookExecutionResult.newBuilder((HookExecutionResult) this.response_).mergeFrom((HookExecutionResult.Builder) hookExecutionResult).buildPartial();
        }
        this.responseCase_ = 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToolExecutionResult(ToolExecutionResult toolExecutionResult) {
        toolExecutionResult.getClass();
        if (this.responseCase_ != 30 || this.response_ == ToolExecutionResult.getDefaultInstance()) {
            this.response_ = toolExecutionResult;
        } else {
            this.response_ = ToolExecutionResult.newBuilder((ToolExecutionResult) this.response_).mergeFrom((ToolExecutionResult.Builder) toolExecutionResult).buildPartial();
        }
        this.responseCase_ = 30;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AgentMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgentMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AgentMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(Error error) {
        error.getClass();
        this.response_ = error;
        this.responseCase_ = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetAgentInfoResponse(GetAgentInfoResponse getAgentInfoResponse) {
        getAgentInfoResponse.getClass();
        this.response_ = getAgentInfoResponse;
        this.responseCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetStoreRequest(GetStoreRequest getStoreRequest) {
        getStoreRequest.getClass();
        this.request_ = getStoreRequest;
        this.requestCase_ = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookExecutionResult(HookExecutionResult hookExecutionResult) {
        hookExecutionResult.getClass();
        this.response_ = hookExecutionResult;
        this.responseCase_ = 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j10) {
        this.timestamp_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolExecutionResult(ToolExecutionResult toolExecutionResult) {
        toolExecutionResult.getClass();
        this.response_ = toolExecutionResult;
        this.responseCase_ = 30;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AgentMessage();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0000\u0001<\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\n<\u0000\u001e<\u0000\u001f<\u00002<\u0001<<\u0000", new Object[]{"response_", "responseCase_", "request_", "requestCase_", "id_", "timestamp_", GetAgentInfoResponse.class, ToolExecutionResult.class, HookExecutionResult.class, GetStoreRequest.class, Error.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AgentMessage> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AgentMessage.class) {
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

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public Error getError() {
        return this.responseCase_ == 60 ? (Error) this.response_ : Error.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public GetAgentInfoResponse getGetAgentInfoResponse() {
        return this.responseCase_ == 10 ? (GetAgentInfoResponse) this.response_ : GetAgentInfoResponse.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public GetStoreRequest getGetStoreRequest() {
        return this.requestCase_ == 50 ? (GetStoreRequest) this.request_ : GetStoreRequest.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public HookExecutionResult getHookExecutionResult() {
        return this.responseCase_ == 31 ? (HookExecutionResult) this.response_ : HookExecutionResult.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public RequestCase getRequestCase() {
        return RequestCase.forNumber(this.requestCase_);
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public ResponseCase getResponseCase() {
        return ResponseCase.forNumber(this.responseCase_);
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public ToolExecutionResult getToolExecutionResult() {
        return this.responseCase_ == 30 ? (ToolExecutionResult) this.response_ : ToolExecutionResult.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public boolean hasError() {
        return this.responseCase_ == 60;
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public boolean hasGetAgentInfoResponse() {
        return this.responseCase_ == 10;
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public boolean hasGetStoreRequest() {
        return this.requestCase_ == 50;
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public boolean hasHookExecutionResult() {
        return this.responseCase_ == 31;
    }

    @Override // com.zyql.protobuf.agent.AgentMessageOrBuilder
    public boolean hasToolExecutionResult() {
        return this.responseCase_ == 30;
    }

    public static Builder newBuilder(AgentMessage agentMessage) {
        return DEFAULT_INSTANCE.createBuilder(agentMessage);
    }

    public static AgentMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AgentMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AgentMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AgentMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AgentMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AgentMessage parseFrom(InputStream inputStream) throws IOException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AgentMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
