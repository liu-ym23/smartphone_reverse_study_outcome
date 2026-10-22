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
public final class MessageDelta extends GeneratedMessageLite<MessageDelta, Builder> implements MessageDeltaOrBuilder {
    private static final MessageDelta DEFAULT_INSTANCE;
    public static final int IS_END_FIELD_NUMBER = 2;
    public static final int MESSAGE_ID_FIELD_NUMBER = 4;
    private static volatile Parser<MessageDelta> PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 1;
    private boolean isEnd_;
    private String text_ = "";
    private String role_ = "";
    private String messageId_ = "";

    /* renamed from: com.zyql.protobuf.omni.MessageDelta$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MessageDelta, Builder> implements MessageDeltaOrBuilder {
        public Builder clearIsEnd() {
            copyOnWrite();
            ((MessageDelta) this.instance).clearIsEnd();
            return this;
        }

        public Builder clearMessageId() {
            copyOnWrite();
            ((MessageDelta) this.instance).clearMessageId();
            return this;
        }

        public Builder clearRole() {
            copyOnWrite();
            ((MessageDelta) this.instance).clearRole();
            return this;
        }

        public Builder clearText() {
            copyOnWrite();
            ((MessageDelta) this.instance).clearText();
            return this;
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public boolean getIsEnd() {
            return ((MessageDelta) this.instance).getIsEnd();
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public String getMessageId() {
            return ((MessageDelta) this.instance).getMessageId();
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public ByteString getMessageIdBytes() {
            return ((MessageDelta) this.instance).getMessageIdBytes();
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public String getRole() {
            return ((MessageDelta) this.instance).getRole();
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public ByteString getRoleBytes() {
            return ((MessageDelta) this.instance).getRoleBytes();
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public String getText() {
            return ((MessageDelta) this.instance).getText();
        }

        @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
        public ByteString getTextBytes() {
            return ((MessageDelta) this.instance).getTextBytes();
        }

        public Builder setIsEnd(boolean z10) {
            copyOnWrite();
            ((MessageDelta) this.instance).setIsEnd(z10);
            return this;
        }

        public Builder setMessageId(String str) {
            copyOnWrite();
            ((MessageDelta) this.instance).setMessageId(str);
            return this;
        }

        public Builder setMessageIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessageDelta) this.instance).setMessageIdBytes(byteString);
            return this;
        }

        public Builder setRole(String str) {
            copyOnWrite();
            ((MessageDelta) this.instance).setRole(str);
            return this;
        }

        public Builder setRoleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessageDelta) this.instance).setRoleBytes(byteString);
            return this;
        }

        public Builder setText(String str) {
            copyOnWrite();
            ((MessageDelta) this.instance).setText(str);
            return this;
        }

        public Builder setTextBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessageDelta) this.instance).setTextBytes(byteString);
            return this;
        }

        private Builder() {
            super(MessageDelta.DEFAULT_INSTANCE);
        }
    }

    static {
        MessageDelta messageDelta = new MessageDelta();
        DEFAULT_INSTANCE = messageDelta;
        GeneratedMessageLite.registerDefaultInstance(MessageDelta.class, messageDelta);
    }

    private MessageDelta() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsEnd() {
        this.isEnd_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessageId() {
        this.messageId_ = getDefaultInstance().getMessageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRole() {
        this.role_ = getDefaultInstance().getRole();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static MessageDelta getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MessageDelta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MessageDelta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessageDelta parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MessageDelta> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsEnd(boolean z10) {
        this.isEnd_ = z10;
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
    public void setRole(String str) {
        str.getClass();
        this.role_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.role_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.text_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new MessageDelta();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0007\u0003Ȉ\u0004Ȉ", new Object[]{"text_", "isEnd_", "role_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessageDelta> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MessageDelta.class) {
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

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public boolean getIsEnd() {
        return this.isEnd_;
    }

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public String getMessageId() {
        return this.messageId_;
    }

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public ByteString getMessageIdBytes() {
        return ByteString.copyFromUtf8(this.messageId_);
    }

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public String getRole() {
        return this.role_;
    }

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public ByteString getRoleBytes() {
        return ByteString.copyFromUtf8(this.role_);
    }

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public String getText() {
        return this.text_;
    }

    @Override // com.zyql.protobuf.omni.MessageDeltaOrBuilder
    public ByteString getTextBytes() {
        return ByteString.copyFromUtf8(this.text_);
    }

    public static Builder newBuilder(MessageDelta messageDelta) {
        return DEFAULT_INSTANCE.createBuilder(messageDelta);
    }

    public static MessageDelta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MessageDelta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MessageDelta parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MessageDelta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MessageDelta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MessageDelta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessageDelta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MessageDelta parseFrom(InputStream inputStream) throws IOException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessageDelta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MessageDelta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MessageDelta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MessageDelta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
