package com.zyql.protobuf.omni;

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
import com.zyql.protobuf.omni.Audio;
import com.zyql.protobuf.skull.Message;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ChatRequest extends GeneratedMessageLite<ChatRequest, Builder> implements ChatRequestOrBuilder {
    public static final int AUDIO_FIELD_NUMBER = 3;
    public static final int CHAT_ID_FIELD_NUMBER = 1;
    private static final ChatRequest DEFAULT_INSTANCE;
    public static final int EVENT_ID_FIELD_NUMBER = 6;
    public static final int ISMOCK_FIELD_NUMBER = 100;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    public static final int META_FIELD_NUMBER = 102;
    public static final int NEEDTTS_FIELD_NUMBER = 101;
    private static volatile Parser<ChatRequest> PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 4;
    private Audio audio_;
    private int bitField0_;
    private boolean isMock_;
    private Message message_;
    private boolean needTts_;
    private MapFieldLite<String, String> meta_ = MapFieldLite.emptyMapField();
    private String chatId_ = "";
    private String taskId_ = "";
    private String eventId_ = "";

    /* renamed from: com.zyql.protobuf.omni.ChatRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ChatRequest, Builder> implements ChatRequestOrBuilder {
        public Builder clearAudio() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearAudio();
            return this;
        }

        public Builder clearChatId() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearChatId();
            return this;
        }

        public Builder clearEventId() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearEventId();
            return this;
        }

        public Builder clearIsMock() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearIsMock();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearMessage();
            return this;
        }

        public Builder clearMeta() {
            copyOnWrite();
            ((ChatRequest) this.instance).getMutableMetaMap().clear();
            return this;
        }

        public Builder clearNeedTts() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearNeedTts();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearTaskId();
            return this;
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public boolean containsMeta(String str) {
            str.getClass();
            return ((ChatRequest) this.instance).getMetaMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public Audio getAudio() {
            return ((ChatRequest) this.instance).getAudio();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public String getChatId() {
            return ((ChatRequest) this.instance).getChatId();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public ByteString getChatIdBytes() {
            return ((ChatRequest) this.instance).getChatIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public String getEventId() {
            return ((ChatRequest) this.instance).getEventId();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public ByteString getEventIdBytes() {
            return ((ChatRequest) this.instance).getEventIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public boolean getIsMock() {
            return ((ChatRequest) this.instance).getIsMock();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public Message getMessage() {
            return ((ChatRequest) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        @Deprecated
        public Map<String, String> getMeta() {
            return getMetaMap();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public int getMetaCount() {
            return ((ChatRequest) this.instance).getMetaMap().size();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public Map<String, String> getMetaMap() {
            return Collections.unmodifiableMap(((ChatRequest) this.instance).getMetaMap());
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public String getMetaOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metaMap = ((ChatRequest) this.instance).getMetaMap();
            return metaMap.containsKey(str) ? metaMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public String getMetaOrThrow(String str) {
            str.getClass();
            Map<String, String> metaMap = ((ChatRequest) this.instance).getMetaMap();
            if (metaMap.containsKey(str)) {
                return metaMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public boolean getNeedTts() {
            return ((ChatRequest) this.instance).getNeedTts();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public String getTaskId() {
            return ((ChatRequest) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public ByteString getTaskIdBytes() {
            return ((ChatRequest) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public boolean hasAudio() {
            return ((ChatRequest) this.instance).hasAudio();
        }

        @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
        public boolean hasMessage() {
            return ((ChatRequest) this.instance).hasMessage();
        }

        public Builder mergeAudio(Audio audio) {
            copyOnWrite();
            ((ChatRequest) this.instance).mergeAudio(audio);
            return this;
        }

        public Builder mergeMessage(Message message) {
            copyOnWrite();
            ((ChatRequest) this.instance).mergeMessage(message);
            return this;
        }

        public Builder putAllMeta(Map<String, String> map) {
            copyOnWrite();
            ((ChatRequest) this.instance).getMutableMetaMap().putAll(map);
            return this;
        }

        public Builder putMeta(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ChatRequest) this.instance).getMutableMetaMap().put(str, str2);
            return this;
        }

        public Builder removeMeta(String str) {
            str.getClass();
            copyOnWrite();
            ((ChatRequest) this.instance).getMutableMetaMap().remove(str);
            return this;
        }

        public Builder setAudio(Audio audio) {
            copyOnWrite();
            ((ChatRequest) this.instance).setAudio(audio);
            return this;
        }

        public Builder setChatId(String str) {
            copyOnWrite();
            ((ChatRequest) this.instance).setChatId(str);
            return this;
        }

        public Builder setChatIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatRequest) this.instance).setChatIdBytes(byteString);
            return this;
        }

        public Builder setEventId(String str) {
            copyOnWrite();
            ((ChatRequest) this.instance).setEventId(str);
            return this;
        }

        public Builder setEventIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatRequest) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public Builder setIsMock(boolean z10) {
            copyOnWrite();
            ((ChatRequest) this.instance).setIsMock(z10);
            return this;
        }

        public Builder setMessage(Message message) {
            copyOnWrite();
            ((ChatRequest) this.instance).setMessage(message);
            return this;
        }

        public Builder setNeedTts(boolean z10) {
            copyOnWrite();
            ((ChatRequest) this.instance).setNeedTts(z10);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((ChatRequest) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatRequest) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(ChatRequest.DEFAULT_INSTANCE);
        }

        public Builder setAudio(Audio.Builder builder) {
            copyOnWrite();
            ((ChatRequest) this.instance).setAudio(builder.build());
            return this;
        }

        public Builder setMessage(Message.Builder builder) {
            copyOnWrite();
            ((ChatRequest) this.instance).setMessage(builder.build());
            return this;
        }
    }

    public static final class MetaDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetaDefaultEntryHolder() {
        }
    }

    static {
        ChatRequest chatRequest = new ChatRequest();
        DEFAULT_INSTANCE = chatRequest;
        GeneratedMessageLite.registerDefaultInstance(ChatRequest.class, chatRequest);
    }

    private ChatRequest() {
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
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsMock() {
        this.isMock_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNeedTts() {
        this.needTts_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    public static ChatRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetaMap() {
        return internalGetMutableMeta();
    }

    private MapFieldLite<String, String> internalGetMeta() {
        return this.meta_;
    }

    private MapFieldLite<String, String> internalGetMutableMeta() {
        if (!this.meta_.isMutable()) {
            this.meta_ = this.meta_.mutableCopy();
        }
        return this.meta_;
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

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ChatRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChatRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ChatRequest> parser() {
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
    public void setIsMock(boolean z10) {
        this.isMock_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(Message message) {
        message.getClass();
        this.message_ = message;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNeedTts(boolean z10) {
        this.needTts_ = z10;
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

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public boolean containsMeta(String str) {
        str.getClass();
        return internalGetMeta().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ChatRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001f\b\u0001\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004Ȉ\u0006Ȉd\u0007e\u0007f2", new Object[]{"bitField0_", "chatId_", "message_", "audio_", "taskId_", "eventId_", "isMock_", "needTts_", "meta_", MetaDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChatRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ChatRequest.class) {
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

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public Audio getAudio() {
        Audio audio = this.audio_;
        return audio == null ? Audio.getDefaultInstance() : audio;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public String getChatId() {
        return this.chatId_;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public ByteString getChatIdBytes() {
        return ByteString.copyFromUtf8(this.chatId_);
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public boolean getIsMock() {
        return this.isMock_;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public Message getMessage() {
        Message message = this.message_;
        return message == null ? Message.getDefaultInstance() : message;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    @Deprecated
    public Map<String, String> getMeta() {
        return getMetaMap();
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public int getMetaCount() {
        return internalGetMeta().size();
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(internalGetMeta());
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMeta = internalGetMeta();
        return mapFieldLiteInternalGetMeta.containsKey(str) ? mapFieldLiteInternalGetMeta.get(str) : str2;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public String getMetaOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMeta = internalGetMeta();
        if (mapFieldLiteInternalGetMeta.containsKey(str)) {
            return mapFieldLiteInternalGetMeta.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public boolean getNeedTts() {
        return this.needTts_;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public boolean hasAudio() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.omni.ChatRequestOrBuilder
    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ChatRequest chatRequest) {
        return DEFAULT_INSTANCE.createBuilder(chatRequest);
    }

    public static ChatRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ChatRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ChatRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ChatRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ChatRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ChatRequest parseFrom(InputStream inputStream) throws IOException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ChatRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
