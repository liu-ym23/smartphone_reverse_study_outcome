package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.connection.Head;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class StreamMsg extends GeneratedMessageLite<StreamMsg, Builder> implements StreamMsgOrBuilder {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final StreamMsg DEFAULT_INSTANCE;
    public static final int HEAD_FIELD_NUMBER = 1;
    private static volatile Parser<StreamMsg> PARSER;
    private int bitField0_;
    private ByteString body_ = ByteString.EMPTY;
    private Head head_;

    /* renamed from: com.zyql.protobuf.connection.StreamMsg$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StreamMsg, Builder> implements StreamMsgOrBuilder {
        public Builder clearBody() {
            copyOnWrite();
            ((StreamMsg) this.instance).clearBody();
            return this;
        }

        public Builder clearHead() {
            copyOnWrite();
            ((StreamMsg) this.instance).clearHead();
            return this;
        }

        @Override // com.zyql.protobuf.connection.StreamMsgOrBuilder
        public ByteString getBody() {
            return ((StreamMsg) this.instance).getBody();
        }

        @Override // com.zyql.protobuf.connection.StreamMsgOrBuilder
        public Head getHead() {
            return ((StreamMsg) this.instance).getHead();
        }

        @Override // com.zyql.protobuf.connection.StreamMsgOrBuilder
        public boolean hasHead() {
            return ((StreamMsg) this.instance).hasHead();
        }

        public Builder mergeHead(Head head) {
            copyOnWrite();
            ((StreamMsg) this.instance).mergeHead(head);
            return this;
        }

        public Builder setBody(ByteString byteString) {
            copyOnWrite();
            ((StreamMsg) this.instance).setBody(byteString);
            return this;
        }

        public Builder setHead(Head head) {
            copyOnWrite();
            ((StreamMsg) this.instance).setHead(head);
            return this;
        }

        private Builder() {
            super(StreamMsg.DEFAULT_INSTANCE);
        }

        public Builder setHead(Head.Builder builder) {
            copyOnWrite();
            ((StreamMsg) this.instance).setHead(builder.build());
            return this;
        }
    }

    static {
        StreamMsg streamMsg = new StreamMsg();
        DEFAULT_INSTANCE = streamMsg;
        GeneratedMessageLite.registerDefaultInstance(StreamMsg.class, streamMsg);
    }

    private StreamMsg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHead() {
        this.head_ = null;
        this.bitField0_ &= -2;
    }

    public static StreamMsg getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHead(Head head) {
        head.getClass();
        Head head2 = this.head_;
        if (head2 == null || head2 == Head.getDefaultInstance()) {
            this.head_ = head;
        } else {
            this.head_ = Head.newBuilder(this.head_).mergeFrom((Head.Builder) head).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StreamMsg parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StreamMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StreamMsg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StreamMsg> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBody(ByteString byteString) {
        byteString.getClass();
        this.body_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHead(Head head) {
        head.getClass();
        this.head_ = head;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StreamMsg();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n", new Object[]{"bitField0_", "head_", "body_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StreamMsg> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StreamMsg.class) {
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

    @Override // com.zyql.protobuf.connection.StreamMsgOrBuilder
    public ByteString getBody() {
        return this.body_;
    }

    @Override // com.zyql.protobuf.connection.StreamMsgOrBuilder
    public Head getHead() {
        Head head = this.head_;
        return head == null ? Head.getDefaultInstance() : head;
    }

    @Override // com.zyql.protobuf.connection.StreamMsgOrBuilder
    public boolean hasHead() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StreamMsg streamMsg) {
        return DEFAULT_INSTANCE.createBuilder(streamMsg);
    }

    public static StreamMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StreamMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StreamMsg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StreamMsg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StreamMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StreamMsg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StreamMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StreamMsg parseFrom(InputStream inputStream) throws IOException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StreamMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StreamMsg parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StreamMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StreamMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
