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
public final class ChatMessage extends GeneratedMessageLite<ChatMessage, Builder> implements ChatMessageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final ChatMessage DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile Parser<ChatMessage> PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String role_ = "";
    private String content_ = "";
    private String name_ = "";

    /* renamed from: com.zyql.protobuf.agent.ChatMessage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ChatMessage, Builder> implements ChatMessageOrBuilder {
        public Builder clearContent() {
            copyOnWrite();
            ((ChatMessage) this.instance).clearContent();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((ChatMessage) this.instance).clearName();
            return this;
        }

        public Builder clearRole() {
            copyOnWrite();
            ((ChatMessage) this.instance).clearRole();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public String getContent() {
            return ((ChatMessage) this.instance).getContent();
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public ByteString getContentBytes() {
            return ((ChatMessage) this.instance).getContentBytes();
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public String getName() {
            return ((ChatMessage) this.instance).getName();
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public ByteString getNameBytes() {
            return ((ChatMessage) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public String getRole() {
            return ((ChatMessage) this.instance).getRole();
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public ByteString getRoleBytes() {
            return ((ChatMessage) this.instance).getRoleBytes();
        }

        @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
        public boolean hasName() {
            return ((ChatMessage) this.instance).hasName();
        }

        public Builder setContent(String str) {
            copyOnWrite();
            ((ChatMessage) this.instance).setContent(str);
            return this;
        }

        public Builder setContentBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatMessage) this.instance).setContentBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((ChatMessage) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatMessage) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setRole(String str) {
            copyOnWrite();
            ((ChatMessage) this.instance).setRole(str);
            return this;
        }

        public Builder setRoleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ChatMessage) this.instance).setRoleBytes(byteString);
            return this;
        }

        private Builder() {
            super(ChatMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        ChatMessage chatMessage = new ChatMessage();
        DEFAULT_INSTANCE = chatMessage;
        GeneratedMessageLite.registerDefaultInstance(ChatMessage.class, chatMessage);
    }

    private ChatMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRole() {
        this.role_ = getDefaultInstance().getRole();
    }

    public static ChatMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ChatMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChatMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ChatMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContent(String str) {
        str.getClass();
        this.content_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.content_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRole(String str) {
        str.getClass();
        this.role_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.role_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ChatMessage();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000", new Object[]{"bitField0_", "role_", "content_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChatMessage> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ChatMessage.class) {
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

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public String getContent() {
        return this.content_;
    }

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public String getRole() {
        return this.role_;
    }

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public ByteString getRoleBytes() {
        return ByteString.copyFromUtf8(this.role_);
    }

    @Override // com.zyql.protobuf.agent.ChatMessageOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ChatMessage chatMessage) {
        return DEFAULT_INSTANCE.createBuilder(chatMessage);
    }

    public static ChatMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ChatMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ChatMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ChatMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ChatMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ChatMessage parseFrom(InputStream inputStream) throws IOException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChatMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChatMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ChatMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
