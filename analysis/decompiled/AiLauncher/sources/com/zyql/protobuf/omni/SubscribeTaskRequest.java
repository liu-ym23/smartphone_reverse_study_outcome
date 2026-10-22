package com.zyql.protobuf.omni;

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
public final class SubscribeTaskRequest extends GeneratedMessageLite<SubscribeTaskRequest, Builder> implements SubscribeTaskRequestOrBuilder {
    private static final SubscribeTaskRequest DEFAULT_INSTANCE;
    public static final int NEED_TTS_FIELD_NUMBER = 3;
    private static volatile Parser<SubscribeTaskRequest> PARSER = null;
    public static final int TASK_EVENT_ID_FIELD_NUMBER = 2;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private boolean needTts_;
    private String taskId_ = "";
    private String taskEventId_ = "";

    /* renamed from: com.zyql.protobuf.omni.SubscribeTaskRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SubscribeTaskRequest, Builder> implements SubscribeTaskRequestOrBuilder {
        public Builder clearNeedTts() {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).clearNeedTts();
            return this;
        }

        public Builder clearTaskEventId() {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).clearTaskEventId();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).clearTaskId();
            return this;
        }

        @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
        public boolean getNeedTts() {
            return ((SubscribeTaskRequest) this.instance).getNeedTts();
        }

        @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
        public String getTaskEventId() {
            return ((SubscribeTaskRequest) this.instance).getTaskEventId();
        }

        @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
        public ByteString getTaskEventIdBytes() {
            return ((SubscribeTaskRequest) this.instance).getTaskEventIdBytes();
        }

        @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
        public String getTaskId() {
            return ((SubscribeTaskRequest) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
        public ByteString getTaskIdBytes() {
            return ((SubscribeTaskRequest) this.instance).getTaskIdBytes();
        }

        public Builder setNeedTts(boolean z10) {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).setNeedTts(z10);
            return this;
        }

        public Builder setTaskEventId(String str) {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).setTaskEventId(str);
            return this;
        }

        public Builder setTaskEventIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).setTaskEventIdBytes(byteString);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SubscribeTaskRequest) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(SubscribeTaskRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        SubscribeTaskRequest subscribeTaskRequest = new SubscribeTaskRequest();
        DEFAULT_INSTANCE = subscribeTaskRequest;
        GeneratedMessageLite.registerDefaultInstance(SubscribeTaskRequest.class, subscribeTaskRequest);
    }

    private SubscribeTaskRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNeedTts() {
        this.needTts_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskEventId() {
        this.taskEventId_ = getDefaultInstance().getTaskEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    public static SubscribeTaskRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SubscribeTaskRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscribeTaskRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SubscribeTaskRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNeedTts(boolean z10) {
        this.needTts_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskEventId(String str) {
        str.getClass();
        this.taskEventId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskEventIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.taskEventId_ = byteString.toStringUtf8();
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
                return new SubscribeTaskRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"taskId_", "taskEventId_", "needTts_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SubscribeTaskRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SubscribeTaskRequest.class) {
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

    @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
    public boolean getNeedTts() {
        return this.needTts_;
    }

    @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
    public String getTaskEventId() {
        return this.taskEventId_;
    }

    @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
    public ByteString getTaskEventIdBytes() {
        return ByteString.copyFromUtf8(this.taskEventId_);
    }

    @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.omni.SubscribeTaskRequestOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    public static Builder newBuilder(SubscribeTaskRequest subscribeTaskRequest) {
        return DEFAULT_INSTANCE.createBuilder(subscribeTaskRequest);
    }

    public static SubscribeTaskRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscribeTaskRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SubscribeTaskRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SubscribeTaskRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SubscribeTaskRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SubscribeTaskRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SubscribeTaskRequest parseFrom(InputStream inputStream) throws IOException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscribeTaskRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscribeTaskRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SubscribeTaskRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscribeTaskRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
