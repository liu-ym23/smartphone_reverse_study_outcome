package com.zyql.protobuf.skull;

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
    public static final int DELTA_FIELD_NUMBER = 1;
    private static volatile Parser<MessageDelta> PARSER;
    private String delta_ = "";

    /* renamed from: com.zyql.protobuf.skull.MessageDelta$1, reason: invalid class name */
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
        public Builder clearDelta() {
            copyOnWrite();
            ((MessageDelta) this.instance).clearDelta();
            return this;
        }

        @Override // com.zyql.protobuf.skull.MessageDeltaOrBuilder
        public String getDelta() {
            return ((MessageDelta) this.instance).getDelta();
        }

        @Override // com.zyql.protobuf.skull.MessageDeltaOrBuilder
        public ByteString getDeltaBytes() {
            return ((MessageDelta) this.instance).getDeltaBytes();
        }

        public Builder setDelta(String str) {
            copyOnWrite();
            ((MessageDelta) this.instance).setDelta(str);
            return this;
        }

        public Builder setDeltaBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessageDelta) this.instance).setDeltaBytes(byteString);
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
    public void clearDelta() {
        this.delta_ = getDefaultInstance().getDelta();
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
    public void setDelta(String str) {
        str.getClass();
        this.delta_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeltaBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.delta_ = byteString.toStringUtf8();
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
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"delta_"});
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

    @Override // com.zyql.protobuf.skull.MessageDeltaOrBuilder
    public String getDelta() {
        return this.delta_;
    }

    @Override // com.zyql.protobuf.skull.MessageDeltaOrBuilder
    public ByteString getDeltaBytes() {
        return ByteString.copyFromUtf8(this.delta_);
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
