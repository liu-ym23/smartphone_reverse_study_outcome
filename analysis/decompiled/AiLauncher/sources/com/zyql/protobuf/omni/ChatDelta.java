package com.zyql.protobuf.omni;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.omni.Audio;
import com.zyql.protobuf.omni.Error;
import com.zyql.protobuf.omni.MessageDelta;
import com.zyql.protobuf.skull.Message;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ChatDelta extends GeneratedMessageLite<ChatDelta, Builder> implements ChatDeltaOrBuilder {
    public static final int AUDIO_FIELD_NUMBER = 5;
    public static final int CHAT_ID_FIELD_NUMBER = 1;
    private static final ChatDelta DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 100;
    public static final int EVENT_ID_FIELD_NUMBER = 8;
    public static final int MESSAGE_DELTA_FIELD_NUMBER = 6;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    public static final int MESSAGE_ID_FIELD_NUMBER = 7;
    private static volatile Parser<ChatDelta> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 2;
    private Audio audio_;
    private int bitField0_;
    private Error error_;
    private MessageDelta messageDelta_;
    private Message message_;
    private int status_;
    private String chatId_ = "";
    private String taskId_ = "";
    private String messageId_ = "";
    private String eventId_ = "";

    /* renamed from: com.zyql.protobuf.omni.ChatDelta$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ChatDelta, Builder> implements ChatDeltaOrBuilder {
        public Builder clearAudio() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearAudio();
            return this;
        }

        public Builder clearChatId() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearChatId();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearError();
            return this;
        }

        public Builder clearEventId() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearEventId();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearMessage();
            return this;
        }

        public Builder clearMessageDelta() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearMessageDelta();
            return this;
        }

        public Builder clearMessageId() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearMessageId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearStatus();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((ChatDelta) this.instance).clearTaskId();
            return this;
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public Audio getAudio() {
            return ((ChatDelta) this.instance).getAudio();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public String getChatId() {
            return ((ChatDelta) this.instance).getChatId();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public ByteString getChatIdBytes() {
            return ((ChatDelta) this.instance).getChatIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public Error getError() {
            return ((ChatDelta) this.instance).getError();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public String getEventId() {
            return ((ChatDelta) this.instance).getEventId();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public ByteString getEventIdBytes() {
            return ((ChatDelta) this.instance).getEventIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public Message getMessage() {
            return ((ChatDelta) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public MessageDelta getMessageDelta() {
            return ((ChatDelta) this.instance).getMessageDelta();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public String getMessageId() {
            return ((ChatDelta) this.instance).getMessageId();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public ByteString getMessageIdBytes() {
            return ((ChatDelta) this.instance).getMessageIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public TaskStatus getStatus() {
            return ((ChatDelta) this.instance).getStatus();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public int getStatusValue() {
            return ((ChatDelta) this.instance).getStatusValue();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public String getTaskId() {
            return ((ChatDelta) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public ByteString getTaskIdBytes() {
            return ((ChatDelta) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public boolean hasAudio() {
            return ((ChatDelta) this.instance).hasAudio();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public boolean hasError() {
            return ((ChatDelta) this.instance).hasError();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public boolean hasMessage() {
            return ((ChatDelta) this.instance).hasMessage();
        }

        @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
        public boolean hasMessageDelta() {
            return ((ChatDelta) this.instance).hasMessageDelta();
        }

        public Builder mergeAudio(Audio audio) {
            copyOnWrite();
            ((ChatDelta) this.instance).mergeAudio(audio);
            return this;
        }

        public Builder mergeError(Error error) {
            copyOnWrite();
            ((ChatDelta) this.instance).mergeError(error);
            return this;
        }

        public Builder mergeMessage(Message message) {
            copyOnWrite();
            ((ChatDelta) this.instance).mergeMessage(message);
            return this;
        }

        public Builder mergeMessageDelta(MessageDelta messageDelta) {
            copyOnWrite();
            ((ChatDelta) this.instance).mergeMessageDelta(messageDelta);
            return this;
        }

        public Builder setAudio(Audio audio) {
            copyOnWrite();
            ((ChatDelta) this.instance).setAudio(audio);
            return this;
        }

        public Builder setChatId(String str) {
            copyOnWrite();
            ((ChatDelta) this.instance).setChatId(str);
            return this;
        }

        public Builder setChatIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatDelta) this.instance).setChatIdBytes(byteString);
            return this;
        }

        public Builder setError(Error error) {
            copyOnWrite();
            ((ChatDelta) this.instance).setError(error);
            return this;
        }

        public Builder setEventId(String str) {
            copyOnWrite();
            ((ChatDelta) this.instance).setEventId(str);
            return this;
        }

        public Builder setEventIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatDelta) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public Builder setMessage(Message message) {
            copyOnWrite();
            ((ChatDelta) this.instance).setMessage(message);
            return this;
        }

        public Builder setMessageDelta(MessageDelta messageDelta) {
            copyOnWrite();
            ((ChatDelta) this.instance).setMessageDelta(messageDelta);
            return this;
        }

        public Builder setMessageId(String str) {
            copyOnWrite();
            ((ChatDelta) this.instance).setMessageId(str);
            return this;
        }

        public Builder setMessageIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatDelta) this.instance).setMessageIdBytes(byteString);
            return this;
        }

        public Builder setStatus(TaskStatus taskStatus) {
            copyOnWrite();
            ((ChatDelta) this.instance).setStatus(taskStatus);
            return this;
        }

        public Builder setStatusValue(int i10) {
            copyOnWrite();
            ((ChatDelta) this.instance).setStatusValue(i10);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((ChatDelta) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatDelta) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(ChatDelta.DEFAULT_INSTANCE);
        }

        public Builder setAudio(Audio.Builder builder) {
            copyOnWrite();
            ((ChatDelta) this.instance).setAudio(builder.build());
            return this;
        }

        public Builder setError(Error.Builder builder) {
            copyOnWrite();
            ((ChatDelta) this.instance).setError(builder.build());
            return this;
        }

        public Builder setMessage(Message.Builder builder) {
            copyOnWrite();
            ((ChatDelta) this.instance).setMessage(builder.build());
            return this;
        }

        public Builder setMessageDelta(MessageDelta.Builder builder) {
            copyOnWrite();
            ((ChatDelta) this.instance).setMessageDelta(builder.build());
            return this;
        }
    }

    static {
        ChatDelta chatDelta = new ChatDelta();
        DEFAULT_INSTANCE = chatDelta;
        GeneratedMessageLite.registerDefaultInstance(ChatDelta.class, chatDelta);
    }

    private ChatDelta() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudio() {
        this.audio_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChatId() {
        this.chatId_ = getDefaultInstance().getChatId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessageDelta() {
        this.messageDelta_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessageId() {
        this.messageId_ = getDefaultInstance().getMessageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    public static ChatDelta getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAudio(Audio audio) {
        audio.getClass();
        Audio audio2 = this.audio_;
        if (audio2 == null || audio2 == Audio.getDefaultInstance()) {
            this.audio_ = audio;
        } else {
            this.audio_ = Audio.newBuilder(this.audio_).mergeFrom((Audio.Builder) audio).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeError(Error error) {
        error.getClass();
        Error error2 = this.error_;
        if (error2 == null || error2 == Error.getDefaultInstance()) {
            this.error_ = error;
        } else {
            this.error_ = Error.newBuilder(this.error_).mergeFrom((Error.Builder) error).buildPartial();
        }
        this.bitField0_ |= 8;
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
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessageDelta(MessageDelta messageDelta) {
        messageDelta.getClass();
        MessageDelta messageDelta2 = this.messageDelta_;
        if (messageDelta2 == null || messageDelta2 == MessageDelta.getDefaultInstance()) {
            this.messageDelta_ = messageDelta;
        } else {
            this.messageDelta_ = MessageDelta.newBuilder(this.messageDelta_).mergeFrom((MessageDelta.Builder) messageDelta).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ChatDelta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChatDelta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatDelta parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ChatDelta> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudio(Audio audio) {
        audio.getClass();
        this.audio_ = audio;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChatId(String str) {
        str.getClass();
        this.chatId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChatIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.chatId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(Error error) {
        error.getClass();
        this.error_ = error;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventId(String str) {
        str.getClass();
        this.eventId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.eventId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(Message message) {
        message.getClass();
        this.message_ = message;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageDelta(MessageDelta messageDelta) {
        messageDelta.getClass();
        this.messageDelta_ = messageDelta;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(String str) {
        str.getClass();
        this.messageId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.messageId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(TaskStatus taskStatus) {
        this.status_ = taskStatus.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i10) {
        this.status_ = i10;
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
                return new ChatDelta();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001d\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002\u0007Ȉ\bȈdဉ\u0003", new Object[]{"bitField0_", "chatId_", "taskId_", "status_", "message_", "audio_", "messageDelta_", "messageId_", "eventId_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChatDelta> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ChatDelta.class) {
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

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public Audio getAudio() {
        Audio audio = this.audio_;
        return audio == null ? Audio.getDefaultInstance() : audio;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public String getChatId() {
        return this.chatId_;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public ByteString getChatIdBytes() {
        return ByteString.copyFromUtf8(this.chatId_);
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public Error getError() {
        Error error = this.error_;
        return error == null ? Error.getDefaultInstance() : error;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public Message getMessage() {
        Message message = this.message_;
        return message == null ? Message.getDefaultInstance() : message;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public MessageDelta getMessageDelta() {
        MessageDelta messageDelta = this.messageDelta_;
        return messageDelta == null ? MessageDelta.getDefaultInstance() : messageDelta;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public String getMessageId() {
        return this.messageId_;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public ByteString getMessageIdBytes() {
        return ByteString.copyFromUtf8(this.messageId_);
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public TaskStatus getStatus() {
        TaskStatus taskStatusForNumber = TaskStatus.forNumber(this.status_);
        return taskStatusForNumber == null ? TaskStatus.UNRECOGNIZED : taskStatusForNumber;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public int getStatusValue() {
        return this.status_;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public boolean hasAudio() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public boolean hasError() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.omni.ChatDeltaOrBuilder
    public boolean hasMessageDelta() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(ChatDelta chatDelta) {
        return DEFAULT_INSTANCE.createBuilder(chatDelta);
    }

    public static ChatDelta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatDelta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatDelta parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ChatDelta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ChatDelta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ChatDelta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ChatDelta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ChatDelta parseFrom(InputStream inputStream) throws IOException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatDelta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatDelta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ChatDelta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
