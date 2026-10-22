package com.zyql.protobuf.runtime;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.runtime.RequestAck;
import com.zyql.protobuf.runtime.Task;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ChatResponse extends GeneratedMessageLite<ChatResponse, Builder> implements ChatResponseOrBuilder {
    public static final int ACK_FIELD_NUMBER = 1;
    private static final ChatResponse DEFAULT_INSTANCE;
    private static volatile Parser<ChatResponse> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 10;
    public static final int TASK_FIELD_NUMBER = 2;
    private int bitField0_;
    private Object content_;
    private int contentCase_ = 0;
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.runtime.ChatResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ChatResponse, Builder> implements ChatResponseOrBuilder {
        public Builder clearAck() {
            copyOnWrite();
            ((ChatResponse) this.instance).clearAck();
            return this;
        }

        public Builder clearContent() {
            copyOnWrite();
            ((ChatResponse) this.instance).clearContent();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ChatResponse) this.instance).clearSessionId();
            return this;
        }

        public Builder clearTask() {
            copyOnWrite();
            ((ChatResponse) this.instance).clearTask();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public RequestAck getAck() {
            return ((ChatResponse) this.instance).getAck();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public ContentCase getContentCase() {
            return ((ChatResponse) this.instance).getContentCase();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public String getSessionId() {
            return ((ChatResponse) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ChatResponse) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public Task getTask() {
            return ((ChatResponse) this.instance).getTask();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public boolean hasAck() {
            return ((ChatResponse) this.instance).hasAck();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public boolean hasSessionId() {
            return ((ChatResponse) this.instance).hasSessionId();
        }

        @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
        public boolean hasTask() {
            return ((ChatResponse) this.instance).hasTask();
        }

        public Builder mergeAck(RequestAck requestAck) {
            copyOnWrite();
            ((ChatResponse) this.instance).mergeAck(requestAck);
            return this;
        }

        public Builder mergeTask(Task task) {
            copyOnWrite();
            ((ChatResponse) this.instance).mergeTask(task);
            return this;
        }

        public Builder setAck(RequestAck requestAck) {
            copyOnWrite();
            ((ChatResponse) this.instance).setAck(requestAck);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ChatResponse) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatResponse) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setTask(Task task) {
            copyOnWrite();
            ((ChatResponse) this.instance).setTask(task);
            return this;
        }

        private Builder() {
            super(ChatResponse.DEFAULT_INSTANCE);
        }

        public Builder setAck(RequestAck.Builder builder) {
            copyOnWrite();
            ((ChatResponse) this.instance).setAck(builder.build());
            return this;
        }

        public Builder setTask(Task.Builder builder) {
            copyOnWrite();
            ((ChatResponse) this.instance).setTask(builder.build());
            return this;
        }
    }

    public enum ContentCase {
        ACK(1),
        TASK(2),
        CONTENT_NOT_SET(0);

        private final int value;

        ContentCase(int i10) {
            this.value = i10;
        }

        public static ContentCase forNumber(int i10) {
            if (i10 == 0) {
                return CONTENT_NOT_SET;
            }
            if (i10 == 1) {
                return ACK;
            }
            if (i10 != 2) {
                return null;
            }
            return TASK;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ContentCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        ChatResponse chatResponse = new ChatResponse();
        DEFAULT_INSTANCE = chatResponse;
        GeneratedMessageLite.registerDefaultInstance(ChatResponse.class, chatResponse);
    }

    private ChatResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAck() {
        if (this.contentCase_ == 1) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.contentCase_ = 0;
        this.content_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTask() {
        if (this.contentCase_ == 2) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    public static ChatResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAck(RequestAck requestAck) {
        requestAck.getClass();
        if (this.contentCase_ != 1 || this.content_ == RequestAck.getDefaultInstance()) {
            this.content_ = requestAck;
        } else {
            this.content_ = RequestAck.newBuilder((RequestAck) this.content_).mergeFrom((RequestAck.Builder) requestAck).buildPartial();
        }
        this.contentCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTask(Task task) {
        task.getClass();
        if (this.contentCase_ != 2 || this.content_ == Task.getDefaultInstance()) {
            this.content_ = task;
        } else {
            this.content_ = Task.newBuilder((Task) this.content_).mergeFrom((Task.Builder) task).buildPartial();
        }
        this.contentCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ChatResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChatResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ChatResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAck(RequestAck requestAck) {
        requestAck.getClass();
        this.content_ = requestAck;
        this.contentCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTask(Task task) {
        task.getClass();
        this.content_ = task;
        this.contentCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ChatResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0001\u0001\n\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\nለ\u0000", new Object[]{"content_", "contentCase_", "bitField0_", RequestAck.class, Task.class, "sessionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChatResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ChatResponse.class) {
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

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public RequestAck getAck() {
        return this.contentCase_ == 1 ? (RequestAck) this.content_ : RequestAck.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public ContentCase getContentCase() {
        return ContentCase.forNumber(this.contentCase_);
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public Task getTask() {
        return this.contentCase_ == 2 ? (Task) this.content_ : Task.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public boolean hasAck() {
        return this.contentCase_ == 1;
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.runtime.ChatResponseOrBuilder
    public boolean hasTask() {
        return this.contentCase_ == 2;
    }

    public static Builder newBuilder(ChatResponse chatResponse) {
        return DEFAULT_INSTANCE.createBuilder(chatResponse);
    }

    public static ChatResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ChatResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ChatResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ChatResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ChatResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ChatResponse parseFrom(InputStream inputStream) throws IOException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ChatResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
