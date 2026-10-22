package com.zyql.protobuf.runtime;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.LogNotification;
import com.zyql.protobuf.runtime.AgentTaskStateNotification;
import com.zyql.protobuf.runtime.InputMessageStateNotification;
import com.zyql.protobuf.runtime.LLMResponse;
import com.zyql.protobuf.runtime.TaskError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class Task extends GeneratedMessageLite<Task, Builder> implements TaskOrBuilder {
    public static final int AGENT_TASK_STATE_FIELD_NUMBER = 6;
    private static final Task DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INPUT_MESSAGE_STATE_FIELD_NUMBER = 7;
    public static final int LLM_RESPONSE_FIELD_NUMBER = 5;
    public static final int LOG_NOTIFICATION_FIELD_NUMBER = 9;
    private static volatile Parser<Task> PARSER = null;
    public static final int TASK_ERROR_FIELD_NUMBER = 8;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private Object output_;
    private long timestamp_;
    private int outputCase_ = 0;
    private String id_ = "";

    /* renamed from: com.zyql.protobuf.runtime.Task$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Task, Builder> implements TaskOrBuilder {
        public Builder clearAgentTaskState() {
            copyOnWrite();
            ((Task) this.instance).clearAgentTaskState();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((Task) this.instance).clearId();
            return this;
        }

        public Builder clearInputMessageState() {
            copyOnWrite();
            ((Task) this.instance).clearInputMessageState();
            return this;
        }

        public Builder clearLlmResponse() {
            copyOnWrite();
            ((Task) this.instance).clearLlmResponse();
            return this;
        }

        public Builder clearLogNotification() {
            copyOnWrite();
            ((Task) this.instance).clearLogNotification();
            return this;
        }

        public Builder clearOutput() {
            copyOnWrite();
            ((Task) this.instance).clearOutput();
            return this;
        }

        public Builder clearTaskError() {
            copyOnWrite();
            ((Task) this.instance).clearTaskError();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((Task) this.instance).clearTimestamp();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public AgentTaskStateNotification getAgentTaskState() {
            return ((Task) this.instance).getAgentTaskState();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public String getId() {
            return ((Task) this.instance).getId();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public ByteString getIdBytes() {
            return ((Task) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public InputMessageStateNotification getInputMessageState() {
            return ((Task) this.instance).getInputMessageState();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public LLMResponse getLlmResponse() {
            return ((Task) this.instance).getLlmResponse();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public LogNotification getLogNotification() {
            return ((Task) this.instance).getLogNotification();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public OutputCase getOutputCase() {
            return ((Task) this.instance).getOutputCase();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public TaskError getTaskError() {
            return ((Task) this.instance).getTaskError();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public long getTimestamp() {
            return ((Task) this.instance).getTimestamp();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public boolean hasAgentTaskState() {
            return ((Task) this.instance).hasAgentTaskState();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public boolean hasInputMessageState() {
            return ((Task) this.instance).hasInputMessageState();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public boolean hasLlmResponse() {
            return ((Task) this.instance).hasLlmResponse();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public boolean hasLogNotification() {
            return ((Task) this.instance).hasLogNotification();
        }

        @Override // com.zyql.protobuf.runtime.TaskOrBuilder
        public boolean hasTaskError() {
            return ((Task) this.instance).hasTaskError();
        }

        public Builder mergeAgentTaskState(AgentTaskStateNotification agentTaskStateNotification) {
            copyOnWrite();
            ((Task) this.instance).mergeAgentTaskState(agentTaskStateNotification);
            return this;
        }

        public Builder mergeInputMessageState(InputMessageStateNotification inputMessageStateNotification) {
            copyOnWrite();
            ((Task) this.instance).mergeInputMessageState(inputMessageStateNotification);
            return this;
        }

        public Builder mergeLlmResponse(LLMResponse lLMResponse) {
            copyOnWrite();
            ((Task) this.instance).mergeLlmResponse(lLMResponse);
            return this;
        }

        public Builder mergeLogNotification(LogNotification logNotification) {
            copyOnWrite();
            ((Task) this.instance).mergeLogNotification(logNotification);
            return this;
        }

        public Builder mergeTaskError(TaskError taskError) {
            copyOnWrite();
            ((Task) this.instance).mergeTaskError(taskError);
            return this;
        }

        public Builder setAgentTaskState(AgentTaskStateNotification agentTaskStateNotification) {
            copyOnWrite();
            ((Task) this.instance).setAgentTaskState(agentTaskStateNotification);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((Task) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setInputMessageState(InputMessageStateNotification inputMessageStateNotification) {
            copyOnWrite();
            ((Task) this.instance).setInputMessageState(inputMessageStateNotification);
            return this;
        }

        public Builder setLlmResponse(LLMResponse lLMResponse) {
            copyOnWrite();
            ((Task) this.instance).setLlmResponse(lLMResponse);
            return this;
        }

        public Builder setLogNotification(LogNotification logNotification) {
            copyOnWrite();
            ((Task) this.instance).setLogNotification(logNotification);
            return this;
        }

        public Builder setTaskError(TaskError taskError) {
            copyOnWrite();
            ((Task) this.instance).setTaskError(taskError);
            return this;
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((Task) this.instance).setTimestamp(j10);
            return this;
        }

        private Builder() {
            super(Task.DEFAULT_INSTANCE);
        }

        public Builder setAgentTaskState(AgentTaskStateNotification.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setAgentTaskState(builder.build());
            return this;
        }

        public Builder setInputMessageState(InputMessageStateNotification.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setInputMessageState(builder.build());
            return this;
        }

        public Builder setLlmResponse(LLMResponse.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setLlmResponse(builder.build());
            return this;
        }

        public Builder setLogNotification(LogNotification.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setLogNotification(builder.build());
            return this;
        }

        public Builder setTaskError(TaskError.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setTaskError(builder.build());
            return this;
        }
    }

    public enum OutputCase {
        LLM_RESPONSE(5),
        AGENT_TASK_STATE(6),
        INPUT_MESSAGE_STATE(7),
        TASK_ERROR(8),
        LOG_NOTIFICATION(9),
        OUTPUT_NOT_SET(0);

        private final int value;

        OutputCase(int i10) {
            this.value = i10;
        }

        public static OutputCase forNumber(int i10) {
            if (i10 == 0) {
                return OUTPUT_NOT_SET;
            }
            switch (i10) {
                case 5:
                    return LLM_RESPONSE;
                case 6:
                    return AGENT_TASK_STATE;
                case 7:
                    return INPUT_MESSAGE_STATE;
                case 8:
                    return TASK_ERROR;
                case 9:
                    return LOG_NOTIFICATION;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static OutputCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        Task task = new Task();
        DEFAULT_INSTANCE = task;
        GeneratedMessageLite.registerDefaultInstance(Task.class, task);
    }

    private Task() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentTaskState() {
        if (this.outputCase_ == 6) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputMessageState() {
        if (this.outputCase_ == 7) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLlmResponse() {
        if (this.outputCase_ == 5) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogNotification() {
        if (this.outputCase_ == 9) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.outputCase_ = 0;
        this.output_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskError() {
        if (this.outputCase_ == 8) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static Task getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAgentTaskState(AgentTaskStateNotification agentTaskStateNotification) {
        agentTaskStateNotification.getClass();
        if (this.outputCase_ != 6 || this.output_ == AgentTaskStateNotification.getDefaultInstance()) {
            this.output_ = agentTaskStateNotification;
        } else {
            this.output_ = AgentTaskStateNotification.newBuilder((AgentTaskStateNotification) this.output_).mergeFrom((AgentTaskStateNotification.Builder) agentTaskStateNotification).buildPartial();
        }
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInputMessageState(InputMessageStateNotification inputMessageStateNotification) {
        inputMessageStateNotification.getClass();
        if (this.outputCase_ != 7 || this.output_ == InputMessageStateNotification.getDefaultInstance()) {
            this.output_ = inputMessageStateNotification;
        } else {
            this.output_ = InputMessageStateNotification.newBuilder((InputMessageStateNotification) this.output_).mergeFrom((InputMessageStateNotification.Builder) inputMessageStateNotification).buildPartial();
        }
        this.outputCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLlmResponse(LLMResponse lLMResponse) {
        lLMResponse.getClass();
        if (this.outputCase_ != 5 || this.output_ == LLMResponse.getDefaultInstance()) {
            this.output_ = lLMResponse;
        } else {
            this.output_ = LLMResponse.newBuilder((LLMResponse) this.output_).mergeFrom((LLMResponse.Builder) lLMResponse).buildPartial();
        }
        this.outputCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLogNotification(LogNotification logNotification) {
        logNotification.getClass();
        if (this.outputCase_ != 9 || this.output_ == LogNotification.getDefaultInstance()) {
            this.output_ = logNotification;
        } else {
            this.output_ = LogNotification.newBuilder((LogNotification) this.output_).mergeFrom((LogNotification.Builder) logNotification).buildPartial();
        }
        this.outputCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTaskError(TaskError taskError) {
        taskError.getClass();
        if (this.outputCase_ != 8 || this.output_ == TaskError.getDefaultInstance()) {
            this.output_ = taskError;
        } else {
            this.output_ = TaskError.newBuilder((TaskError) this.output_).mergeFrom((TaskError.Builder) taskError).buildPartial();
        }
        this.outputCase_ = 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Task parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Task) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Task parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Task> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentTaskState(AgentTaskStateNotification agentTaskStateNotification) {
        agentTaskStateNotification.getClass();
        this.output_ = agentTaskStateNotification;
        this.outputCase_ = 6;
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
    public void setInputMessageState(InputMessageStateNotification inputMessageStateNotification) {
        inputMessageStateNotification.getClass();
        this.output_ = inputMessageStateNotification;
        this.outputCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLlmResponse(LLMResponse lLMResponse) {
        lLMResponse.getClass();
        this.output_ = lLMResponse;
        this.outputCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogNotification(LogNotification logNotification) {
        logNotification.getClass();
        this.output_ = logNotification;
        this.outputCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskError(TaskError taskError) {
        taskError.getClass();
        this.output_ = taskError;
        this.outputCase_ = 8;
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
                return new Task();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\t\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0003\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000", new Object[]{"output_", "outputCase_", "id_", "timestamp_", LLMResponse.class, AgentTaskStateNotification.class, InputMessageStateNotification.class, TaskError.class, LogNotification.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Task> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Task.class) {
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

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public AgentTaskStateNotification getAgentTaskState() {
        return this.outputCase_ == 6 ? (AgentTaskStateNotification) this.output_ : AgentTaskStateNotification.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public InputMessageStateNotification getInputMessageState() {
        return this.outputCase_ == 7 ? (InputMessageStateNotification) this.output_ : InputMessageStateNotification.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public LLMResponse getLlmResponse() {
        return this.outputCase_ == 5 ? (LLMResponse) this.output_ : LLMResponse.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public LogNotification getLogNotification() {
        return this.outputCase_ == 9 ? (LogNotification) this.output_ : LogNotification.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public OutputCase getOutputCase() {
        return OutputCase.forNumber(this.outputCase_);
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public TaskError getTaskError() {
        return this.outputCase_ == 8 ? (TaskError) this.output_ : TaskError.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public boolean hasAgentTaskState() {
        return this.outputCase_ == 6;
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public boolean hasInputMessageState() {
        return this.outputCase_ == 7;
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public boolean hasLlmResponse() {
        return this.outputCase_ == 5;
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public boolean hasLogNotification() {
        return this.outputCase_ == 9;
    }

    @Override // com.zyql.protobuf.runtime.TaskOrBuilder
    public boolean hasTaskError() {
        return this.outputCase_ == 8;
    }

    public static Builder newBuilder(Task task) {
        return DEFAULT_INSTANCE.createBuilder(task);
    }

    public static Task parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Task) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Task parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Task parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Task parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Task parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Task parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Task parseFrom(InputStream inputStream) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Task parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Task parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Task parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
