package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.Error;
import com.zyql.protobuf.agent.ExecuteToolTask;
import com.zyql.protobuf.agent.GetAgentInfoRequest;
import com.zyql.protobuf.agent.GetStoreResponse;
import com.zyql.protobuf.agent.InvokeHookTask;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class RuntimeMessage extends GeneratedMessageLite<RuntimeMessage, Builder> implements RuntimeMessageOrBuilder {
    private static final RuntimeMessage DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 60;
    public static final int EXECUTE_TOOL_TASK_FIELD_NUMBER = 20;
    public static final int GET_AGENT_INFO_REQUEST_FIELD_NUMBER = 10;
    public static final int GET_STORE_RESPONSE_FIELD_NUMBER = 50;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INVOKE_HOOK_TASK_FIELD_NUMBER = 21;
    private static volatile Parser<RuntimeMessage> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private Object request_;
    private Object response_;
    private long timestamp_;
    private int requestCase_ = 0;
    private int responseCase_ = 0;
    private String id_ = "";

    /* renamed from: com.zyql.protobuf.agent.RuntimeMessage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RuntimeMessage, Builder> implements RuntimeMessageOrBuilder {
        public Builder clearError() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearError();
            return this;
        }

        public Builder clearExecuteToolTask() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearExecuteToolTask();
            return this;
        }

        public Builder clearGetAgentInfoRequest() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearGetAgentInfoRequest();
            return this;
        }

        public Builder clearGetStoreResponse() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearGetStoreResponse();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearId();
            return this;
        }

        public Builder clearInvokeHookTask() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearInvokeHookTask();
            return this;
        }

        public Builder clearRequest() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearRequest();
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearResponse();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((RuntimeMessage) this.instance).clearTimestamp();
            return this;
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public Error getError() {
            return ((RuntimeMessage) this.instance).getError();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public ExecuteToolTask getExecuteToolTask() {
            return ((RuntimeMessage) this.instance).getExecuteToolTask();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public GetAgentInfoRequest getGetAgentInfoRequest() {
            return ((RuntimeMessage) this.instance).getGetAgentInfoRequest();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public GetStoreResponse getGetStoreResponse() {
            return ((RuntimeMessage) this.instance).getGetStoreResponse();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public String getId() {
            return ((RuntimeMessage) this.instance).getId();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public ByteString getIdBytes() {
            return ((RuntimeMessage) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public InvokeHookTask getInvokeHookTask() {
            return ((RuntimeMessage) this.instance).getInvokeHookTask();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public RequestCase getRequestCase() {
            return ((RuntimeMessage) this.instance).getRequestCase();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public ResponseCase getResponseCase() {
            return ((RuntimeMessage) this.instance).getResponseCase();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public long getTimestamp() {
            return ((RuntimeMessage) this.instance).getTimestamp();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public boolean hasError() {
            return ((RuntimeMessage) this.instance).hasError();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public boolean hasExecuteToolTask() {
            return ((RuntimeMessage) this.instance).hasExecuteToolTask();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public boolean hasGetAgentInfoRequest() {
            return ((RuntimeMessage) this.instance).hasGetAgentInfoRequest();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public boolean hasGetStoreResponse() {
            return ((RuntimeMessage) this.instance).hasGetStoreResponse();
        }

        @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
        public boolean hasInvokeHookTask() {
            return ((RuntimeMessage) this.instance).hasInvokeHookTask();
        }

        public Builder mergeError(Error error) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).mergeError(error);
            return this;
        }

        public Builder mergeExecuteToolTask(ExecuteToolTask executeToolTask) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).mergeExecuteToolTask(executeToolTask);
            return this;
        }

        public Builder mergeGetAgentInfoRequest(GetAgentInfoRequest getAgentInfoRequest) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).mergeGetAgentInfoRequest(getAgentInfoRequest);
            return this;
        }

        public Builder mergeGetStoreResponse(GetStoreResponse getStoreResponse) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).mergeGetStoreResponse(getStoreResponse);
            return this;
        }

        public Builder mergeInvokeHookTask(InvokeHookTask invokeHookTask) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).mergeInvokeHookTask(invokeHookTask);
            return this;
        }

        public Builder setError(Error error) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setError(error);
            return this;
        }

        public Builder setExecuteToolTask(ExecuteToolTask executeToolTask) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setExecuteToolTask(executeToolTask);
            return this;
        }

        public Builder setGetAgentInfoRequest(GetAgentInfoRequest getAgentInfoRequest) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setGetAgentInfoRequest(getAgentInfoRequest);
            return this;
        }

        public Builder setGetStoreResponse(GetStoreResponse getStoreResponse) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setGetStoreResponse(getStoreResponse);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setInvokeHookTask(InvokeHookTask invokeHookTask) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setInvokeHookTask(invokeHookTask);
            return this;
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setTimestamp(j10);
            return this;
        }

        private Builder() {
            super(RuntimeMessage.DEFAULT_INSTANCE);
        }

        public Builder setError(Error.Builder builder) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setError(builder.build());
            return this;
        }

        public Builder setExecuteToolTask(ExecuteToolTask.Builder builder) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setExecuteToolTask(builder.build());
            return this;
        }

        public Builder setGetAgentInfoRequest(GetAgentInfoRequest.Builder builder) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setGetAgentInfoRequest(builder.build());
            return this;
        }

        public Builder setGetStoreResponse(GetStoreResponse.Builder builder) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setGetStoreResponse(builder.build());
            return this;
        }

        public Builder setInvokeHookTask(InvokeHookTask.Builder builder) {
            copyOnWrite();
            ((RuntimeMessage) this.instance).setInvokeHookTask(builder.build());
            return this;
        }
    }

    public enum RequestCase {
        GET_AGENT_INFO_REQUEST(10),
        EXECUTE_TOOL_TASK(20),
        INVOKE_HOOK_TASK(21),
        REQUEST_NOT_SET(0);

        private final int value;

        RequestCase(int i10) {
            this.value = i10;
        }

        public static RequestCase forNumber(int i10) {
            if (i10 == 0) {
                return REQUEST_NOT_SET;
            }
            if (i10 == 10) {
                return GET_AGENT_INFO_REQUEST;
            }
            if (i10 == 20) {
                return EXECUTE_TOOL_TASK;
            }
            if (i10 != 21) {
                return null;
            }
            return INVOKE_HOOK_TASK;
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
        GET_STORE_RESPONSE(50),
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
            if (i10 == 50) {
                return GET_STORE_RESPONSE;
            }
            if (i10 != 60) {
                return null;
            }
            return ERROR;
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
        RuntimeMessage runtimeMessage = new RuntimeMessage();
        DEFAULT_INSTANCE = runtimeMessage;
        GeneratedMessageLite.registerDefaultInstance(RuntimeMessage.class, runtimeMessage);
    }

    private RuntimeMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        if (this.responseCase_ == 60) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExecuteToolTask() {
        if (this.requestCase_ == 20) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGetAgentInfoRequest() {
        if (this.requestCase_ == 10) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGetStoreResponse() {
        if (this.responseCase_ == 50) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInvokeHookTask() {
        if (this.requestCase_ == 21) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
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

    public static RuntimeMessage getDefaultInstance() {
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
    public void mergeExecuteToolTask(ExecuteToolTask executeToolTask) {
        executeToolTask.getClass();
        if (this.requestCase_ != 20 || this.request_ == ExecuteToolTask.getDefaultInstance()) {
            this.request_ = executeToolTask;
        } else {
            this.request_ = ExecuteToolTask.newBuilder((ExecuteToolTask) this.request_).mergeFrom((ExecuteToolTask.Builder) executeToolTask).buildPartial();
        }
        this.requestCase_ = 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGetAgentInfoRequest(GetAgentInfoRequest getAgentInfoRequest) {
        getAgentInfoRequest.getClass();
        if (this.requestCase_ != 10 || this.request_ == GetAgentInfoRequest.getDefaultInstance()) {
            this.request_ = getAgentInfoRequest;
        } else {
            this.request_ = GetAgentInfoRequest.newBuilder((GetAgentInfoRequest) this.request_).mergeFrom((GetAgentInfoRequest.Builder) getAgentInfoRequest).buildPartial();
        }
        this.requestCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGetStoreResponse(GetStoreResponse getStoreResponse) {
        getStoreResponse.getClass();
        if (this.responseCase_ != 50 || this.response_ == GetStoreResponse.getDefaultInstance()) {
            this.response_ = getStoreResponse;
        } else {
            this.response_ = GetStoreResponse.newBuilder((GetStoreResponse) this.response_).mergeFrom((GetStoreResponse.Builder) getStoreResponse).buildPartial();
        }
        this.responseCase_ = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInvokeHookTask(InvokeHookTask invokeHookTask) {
        invokeHookTask.getClass();
        if (this.requestCase_ != 21 || this.request_ == InvokeHookTask.getDefaultInstance()) {
            this.request_ = invokeHookTask;
        } else {
            this.request_ = InvokeHookTask.newBuilder((InvokeHookTask) this.request_).mergeFrom((InvokeHookTask.Builder) invokeHookTask).buildPartial();
        }
        this.requestCase_ = 21;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RuntimeMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RuntimeMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RuntimeMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RuntimeMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(Error error) {
        error.getClass();
        this.response_ = error;
        this.responseCase_ = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExecuteToolTask(ExecuteToolTask executeToolTask) {
        executeToolTask.getClass();
        this.request_ = executeToolTask;
        this.requestCase_ = 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetAgentInfoRequest(GetAgentInfoRequest getAgentInfoRequest) {
        getAgentInfoRequest.getClass();
        this.request_ = getAgentInfoRequest;
        this.requestCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetStoreResponse(GetStoreResponse getStoreResponse) {
        getStoreResponse.getClass();
        this.response_ = getStoreResponse;
        this.responseCase_ = 50;
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
    public void setInvokeHookTask(InvokeHookTask invokeHookTask) {
        invokeHookTask.getClass();
        this.request_ = invokeHookTask;
        this.requestCase_ = 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j10) {
        this.timestamp_ = j10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new RuntimeMessage();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0000\u0001<\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\n<\u0000\u0014<\u0000\u0015<\u00002<\u0001<<\u0001", new Object[]{"request_", "requestCase_", "response_", "responseCase_", "id_", "timestamp_", GetAgentInfoRequest.class, ExecuteToolTask.class, InvokeHookTask.class, GetStoreResponse.class, Error.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RuntimeMessage> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RuntimeMessage.class) {
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

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public Error getError() {
        return this.responseCase_ == 60 ? (Error) this.response_ : Error.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public ExecuteToolTask getExecuteToolTask() {
        return this.requestCase_ == 20 ? (ExecuteToolTask) this.request_ : ExecuteToolTask.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public GetAgentInfoRequest getGetAgentInfoRequest() {
        return this.requestCase_ == 10 ? (GetAgentInfoRequest) this.request_ : GetAgentInfoRequest.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public GetStoreResponse getGetStoreResponse() {
        return this.responseCase_ == 50 ? (GetStoreResponse) this.response_ : GetStoreResponse.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public InvokeHookTask getInvokeHookTask() {
        return this.requestCase_ == 21 ? (InvokeHookTask) this.request_ : InvokeHookTask.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public RequestCase getRequestCase() {
        return RequestCase.forNumber(this.requestCase_);
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public ResponseCase getResponseCase() {
        return ResponseCase.forNumber(this.responseCase_);
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public boolean hasError() {
        return this.responseCase_ == 60;
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public boolean hasExecuteToolTask() {
        return this.requestCase_ == 20;
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public boolean hasGetAgentInfoRequest() {
        return this.requestCase_ == 10;
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public boolean hasGetStoreResponse() {
        return this.responseCase_ == 50;
    }

    @Override // com.zyql.protobuf.agent.RuntimeMessageOrBuilder
    public boolean hasInvokeHookTask() {
        return this.requestCase_ == 21;
    }

    public static Builder newBuilder(RuntimeMessage runtimeMessage) {
        return DEFAULT_INSTANCE.createBuilder(runtimeMessage);
    }

    public static RuntimeMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RuntimeMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RuntimeMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RuntimeMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RuntimeMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RuntimeMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RuntimeMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RuntimeMessage parseFrom(InputStream inputStream) throws IOException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RuntimeMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RuntimeMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RuntimeMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RuntimeMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
