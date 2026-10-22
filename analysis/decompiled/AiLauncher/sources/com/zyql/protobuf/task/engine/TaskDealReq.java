package com.zyql.protobuf.task.engine;

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
public final class TaskDealReq extends GeneratedMessageLite<TaskDealReq, Builder> implements TaskDealReqOrBuilder {
    public static final int COMMOND_FIELD_NUMBER = 2;
    private static final TaskDealReq DEFAULT_INSTANCE;
    private static volatile Parser<TaskDealReq> PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    private String taskId_ = "";
    private String commond_ = "";

    /* renamed from: com.zyql.protobuf.task.engine.TaskDealReq$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TaskDealReq, Builder> implements TaskDealReqOrBuilder {
        public Builder clearCommond() {
            copyOnWrite();
            ((TaskDealReq) this.instance).clearCommond();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((TaskDealReq) this.instance).clearTaskId();
            return this;
        }

        @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
        public String getCommond() {
            return ((TaskDealReq) this.instance).getCommond();
        }

        @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
        public ByteString getCommondBytes() {
            return ((TaskDealReq) this.instance).getCommondBytes();
        }

        @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
        public String getTaskId() {
            return ((TaskDealReq) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
        public ByteString getTaskIdBytes() {
            return ((TaskDealReq) this.instance).getTaskIdBytes();
        }

        public Builder setCommond(String str) {
            copyOnWrite();
            ((TaskDealReq) this.instance).setCommond(str);
            return this;
        }

        public Builder setCommondBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((TaskDealReq) this.instance).setCommondBytes(byteString);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((TaskDealReq) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((TaskDealReq) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(TaskDealReq.DEFAULT_INSTANCE);
        }
    }

    static {
        TaskDealReq taskDealReq = new TaskDealReq();
        DEFAULT_INSTANCE = taskDealReq;
        GeneratedMessageLite.registerDefaultInstance(TaskDealReq.class, taskDealReq);
    }

    private TaskDealReq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommond() {
        this.commond_ = getDefaultInstance().getCommond();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    public static TaskDealReq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TaskDealReq parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TaskDealReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskDealReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TaskDealReq> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommond(String str) {
        str.getClass();
        this.commond_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommondBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.commond_ = byteString.toStringUtf8();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new TaskDealReq();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"taskId_", "commond_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TaskDealReq> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TaskDealReq.class) {
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

    @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
    public String getCommond() {
        return this.commond_;
    }

    @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
    public ByteString getCommondBytes() {
        return ByteString.copyFromUtf8(this.commond_);
    }

    @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.task.engine.TaskDealReqOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    public static Builder newBuilder(TaskDealReq taskDealReq) {
        return DEFAULT_INSTANCE.createBuilder(taskDealReq);
    }

    public static TaskDealReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskDealReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskDealReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TaskDealReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TaskDealReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TaskDealReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TaskDealReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TaskDealReq parseFrom(InputStream inputStream) throws IOException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskDealReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskDealReq parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TaskDealReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskDealReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
