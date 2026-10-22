package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ExecuteToolTask extends GeneratedMessageLite<ExecuteToolTask, Builder> implements ExecuteToolTaskOrBuilder {
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 4;
    private static final ExecuteToolTask DEFAULT_INSTANCE;
    private static volatile Parser<ExecuteToolTask> PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TIMEOUT_SECONDS_FIELD_NUMBER = 5;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 2;
    public static final int TOOL_NAME_FIELD_NUMBER = 3;
    private int timeoutSeconds_;
    private String taskId_ = "";
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";

    /* renamed from: com.zyql.protobuf.agent.ExecuteToolTask$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ExecuteToolTask, Builder> implements ExecuteToolTaskOrBuilder {
        public Builder clearArgumentsJson() {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).clearArgumentsJson();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).clearTaskId();
            return this;
        }

        public Builder clearTimeoutSeconds() {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).clearTimeoutSeconds();
            return this;
        }

        public Builder clearToolCallId() {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).clearToolCallId();
            return this;
        }

        public Builder clearToolName() {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).clearToolName();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public String getArgumentsJson() {
            return ((ExecuteToolTask) this.instance).getArgumentsJson();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public ByteString getArgumentsJsonBytes() {
            return ((ExecuteToolTask) this.instance).getArgumentsJsonBytes();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public String getTaskId() {
            return ((ExecuteToolTask) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public ByteString getTaskIdBytes() {
            return ((ExecuteToolTask) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public int getTimeoutSeconds() {
            return ((ExecuteToolTask) this.instance).getTimeoutSeconds();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public String getToolCallId() {
            return ((ExecuteToolTask) this.instance).getToolCallId();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public ByteString getToolCallIdBytes() {
            return ((ExecuteToolTask) this.instance).getToolCallIdBytes();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public String getToolName() {
            return ((ExecuteToolTask) this.instance).getToolName();
        }

        @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
        public ByteString getToolNameBytes() {
            return ((ExecuteToolTask) this.instance).getToolNameBytes();
        }

        public Builder setArgumentsJson(String str) {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setArgumentsJson(str);
            return this;
        }

        public Builder setArgumentsJsonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setArgumentsJsonBytes(byteString);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        public Builder setTimeoutSeconds(int i10) {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setTimeoutSeconds(i10);
            return this;
        }

        public Builder setToolCallId(String str) {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setToolCallId(str);
            return this;
        }

        public Builder setToolCallIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setToolCallIdBytes(byteString);
            return this;
        }

        public Builder setToolName(String str) {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setToolName(str);
            return this;
        }

        public Builder setToolNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ExecuteToolTask) this.instance).setToolNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(ExecuteToolTask.DEFAULT_INSTANCE);
        }
    }

    static {
        ExecuteToolTask executeToolTask = new ExecuteToolTask();
        DEFAULT_INSTANCE = executeToolTask;
        GeneratedMessageLite.registerDefaultInstance(ExecuteToolTask.class, executeToolTask);
    }

    private ExecuteToolTask() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArgumentsJson() {
        this.argumentsJson_ = getDefaultInstance().getArgumentsJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeoutSeconds() {
        this.timeoutSeconds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallId() {
        this.toolCallId_ = getDefaultInstance().getToolCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolName() {
        this.toolName_ = getDefaultInstance().getToolName();
    }

    public static ExecuteToolTask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ExecuteToolTask parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ExecuteToolTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExecuteToolTask parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ExecuteToolTask> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setTaskId(String str) {
        str.getClass();
        this.taskId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.taskId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeoutSeconds(int i10) {
        this.timeoutSeconds_ = i10;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ExecuteToolTask();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0004", new Object[]{"taskId_", "toolCallId_", "toolName_", "argumentsJson_", "timeoutSeconds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExecuteToolTask> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ExecuteToolTask.class) {
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

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public String getArgumentsJson() {
        return this.argumentsJson_;
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public ByteString getArgumentsJsonBytes() {
        return ByteString.copyFromUtf8(this.argumentsJson_);
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public int getTimeoutSeconds() {
        return this.timeoutSeconds_;
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public String getToolCallId() {
        return this.toolCallId_;
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public ByteString getToolCallIdBytes() {
        return ByteString.copyFromUtf8(this.toolCallId_);
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public String getToolName() {
        return this.toolName_;
    }

    @Override // com.zyql.protobuf.agent.ExecuteToolTaskOrBuilder
    public ByteString getToolNameBytes() {
        return ByteString.copyFromUtf8(this.toolName_);
    }

    public static Builder newBuilder(ExecuteToolTask executeToolTask) {
        return DEFAULT_INSTANCE.createBuilder(executeToolTask);
    }

    public static ExecuteToolTask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExecuteToolTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExecuteToolTask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ExecuteToolTask parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ExecuteToolTask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ExecuteToolTask parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExecuteToolTask parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ExecuteToolTask parseFrom(InputStream inputStream) throws IOException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExecuteToolTask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExecuteToolTask parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ExecuteToolTask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExecuteToolTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
