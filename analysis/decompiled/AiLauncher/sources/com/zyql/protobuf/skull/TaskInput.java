package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Message;
import com.zyql.protobuf.skull.TaskContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class TaskInput extends GeneratedMessageLite<TaskInput, Builder> implements TaskInputOrBuilder {
    public static final int CONTEXT_FIELD_NUMBER = 1;
    private static final TaskInput DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<TaskInput> PARSER;
    private int bitField0_;
    private TaskContext context_;
    private Message message_;

    /* renamed from: com.zyql.protobuf.skull.TaskInput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TaskInput, Builder> implements TaskInputOrBuilder {
        public Builder clearContext() {
            copyOnWrite();
            ((TaskInput) this.instance).clearContext();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((TaskInput) this.instance).clearMessage();
            return this;
        }

        @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
        public TaskContext getContext() {
            return ((TaskInput) this.instance).getContext();
        }

        @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
        public Message getMessage() {
            return ((TaskInput) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
        public boolean hasContext() {
            return ((TaskInput) this.instance).hasContext();
        }

        @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
        public boolean hasMessage() {
            return ((TaskInput) this.instance).hasMessage();
        }

        public Builder mergeContext(TaskContext taskContext) {
            copyOnWrite();
            ((TaskInput) this.instance).mergeContext(taskContext);
            return this;
        }

        public Builder mergeMessage(Message message) {
            copyOnWrite();
            ((TaskInput) this.instance).mergeMessage(message);
            return this;
        }

        public Builder setContext(TaskContext taskContext) {
            copyOnWrite();
            ((TaskInput) this.instance).setContext(taskContext);
            return this;
        }

        public Builder setMessage(Message message) {
            copyOnWrite();
            ((TaskInput) this.instance).setMessage(message);
            return this;
        }

        private Builder() {
            super(TaskInput.DEFAULT_INSTANCE);
        }

        public Builder setContext(TaskContext.Builder builder) {
            copyOnWrite();
            ((TaskInput) this.instance).setContext(builder.build());
            return this;
        }

        public Builder setMessage(Message.Builder builder) {
            copyOnWrite();
            ((TaskInput) this.instance).setMessage(builder.build());
            return this;
        }
    }

    static {
        TaskInput taskInput = new TaskInput();
        DEFAULT_INSTANCE = taskInput;
        GeneratedMessageLite.registerDefaultInstance(TaskInput.class, taskInput);
    }

    private TaskInput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContext() {
        this.context_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    public static TaskInput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeContext(TaskContext taskContext) {
        taskContext.getClass();
        TaskContext taskContext2 = this.context_;
        if (taskContext2 == null || taskContext2 == TaskContext.getDefaultInstance()) {
            this.context_ = taskContext;
        } else {
            this.context_ = TaskContext.newBuilder(this.context_).mergeFrom((TaskContext.Builder) taskContext).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessage(Message message) {
        message.getClass();
        Message message2 = this.message_;
        if (message2 == null || message2 == Message.getDefaultInstance()) {
            this.message_ = message;
        } else {
            this.message_ = Message.newBuilder(this.message_).mergeFrom((Message.Builder) message).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TaskInput parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TaskInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskInput parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TaskInput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContext(TaskContext taskContext) {
        taskContext.getClass();
        this.context_ = taskContext;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(Message message) {
        message.getClass();
        this.message_ = message;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new TaskInput();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "context_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TaskInput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TaskInput.class) {
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

    @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
    public TaskContext getContext() {
        TaskContext taskContext = this.context_;
        return taskContext == null ? TaskContext.getDefaultInstance() : taskContext;
    }

    @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
    public Message getMessage() {
        Message message = this.message_;
        return message == null ? Message.getDefaultInstance() : message;
    }

    @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
    public boolean hasContext() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.skull.TaskInputOrBuilder
    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(TaskInput taskInput) {
        return DEFAULT_INSTANCE.createBuilder(taskInput);
    }

    public static TaskInput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskInput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TaskInput parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TaskInput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TaskInput parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TaskInput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TaskInput parseFrom(InputStream inputStream) throws IOException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskInput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskInput parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TaskInput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
