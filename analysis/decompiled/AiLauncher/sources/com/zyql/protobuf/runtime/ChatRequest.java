package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.runtime.CancelRequest;
import com.zyql.protobuf.runtime.SendInputRequest;
import com.zyql.protobuf.runtime.StartAgentRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ChatRequest extends GeneratedMessageLite<ChatRequest, Builder> implements ChatRequestOrBuilder {
    public static final int CANCEL_REQUEST_FIELD_NUMBER = 4;
    private static final ChatRequest DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<ChatRequest> PARSER = null;
    public static final int SEND_INPUT_REQUEST_FIELD_NUMBER = 3;
    public static final int START_AGENT_REQUEST_FIELD_NUMBER = 2;
    private long id_;
    private int payloadCase_ = 0;
    private Object payload_;

    /* renamed from: com.zyql.protobuf.runtime.ChatRequest$1, reason: invalid class name */
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
        public Builder clearCancelRequest() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearCancelRequest();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearId();
            return this;
        }

        public Builder clearPayload() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearPayload();
            return this;
        }

        public Builder clearSendInputRequest() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearSendInputRequest();
            return this;
        }

        public Builder clearStartAgentRequest() {
            copyOnWrite();
            ((ChatRequest) this.instance).clearStartAgentRequest();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public CancelRequest getCancelRequest() {
            return ((ChatRequest) this.instance).getCancelRequest();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public long getId() {
            return ((ChatRequest) this.instance).getId();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public PayloadCase getPayloadCase() {
            return ((ChatRequest) this.instance).getPayloadCase();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public SendInputRequest getSendInputRequest() {
            return ((ChatRequest) this.instance).getSendInputRequest();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public StartAgentRequest getStartAgentRequest() {
            return ((ChatRequest) this.instance).getStartAgentRequest();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public boolean hasCancelRequest() {
            return ((ChatRequest) this.instance).hasCancelRequest();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public boolean hasSendInputRequest() {
            return ((ChatRequest) this.instance).hasSendInputRequest();
        }

        @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
        public boolean hasStartAgentRequest() {
            return ((ChatRequest) this.instance).hasStartAgentRequest();
        }

        public Builder mergeCancelRequest(CancelRequest cancelRequest) {
            copyOnWrite();
            ((ChatRequest) this.instance).mergeCancelRequest(cancelRequest);
            return this;
        }

        public Builder mergeSendInputRequest(SendInputRequest sendInputRequest) {
            copyOnWrite();
            ((ChatRequest) this.instance).mergeSendInputRequest(sendInputRequest);
            return this;
        }

        public Builder mergeStartAgentRequest(StartAgentRequest startAgentRequest) {
            copyOnWrite();
            ((ChatRequest) this.instance).mergeStartAgentRequest(startAgentRequest);
            return this;
        }

        public Builder setCancelRequest(CancelRequest cancelRequest) {
            copyOnWrite();
            ((ChatRequest) this.instance).setCancelRequest(cancelRequest);
            return this;
        }

        public Builder setId(long j10) {
            copyOnWrite();
            ((ChatRequest) this.instance).setId(j10);
            return this;
        }

        public Builder setSendInputRequest(SendInputRequest sendInputRequest) {
            copyOnWrite();
            ((ChatRequest) this.instance).setSendInputRequest(sendInputRequest);
            return this;
        }

        public Builder setStartAgentRequest(StartAgentRequest startAgentRequest) {
            copyOnWrite();
            ((ChatRequest) this.instance).setStartAgentRequest(startAgentRequest);
            return this;
        }

        private Builder() {
            super(ChatRequest.DEFAULT_INSTANCE);
        }

        public Builder setCancelRequest(CancelRequest.Builder builder) {
            copyOnWrite();
            ((ChatRequest) this.instance).setCancelRequest(builder.build());
            return this;
        }

        public Builder setSendInputRequest(SendInputRequest.Builder builder) {
            copyOnWrite();
            ((ChatRequest) this.instance).setSendInputRequest(builder.build());
            return this;
        }

        public Builder setStartAgentRequest(StartAgentRequest.Builder builder) {
            copyOnWrite();
            ((ChatRequest) this.instance).setStartAgentRequest(builder.build());
            return this;
        }
    }

    public enum PayloadCase {
        START_AGENT_REQUEST(2),
        SEND_INPUT_REQUEST(3),
        CANCEL_REQUEST(4),
        PAYLOAD_NOT_SET(0);

        private final int value;

        PayloadCase(int i10) {
            this.value = i10;
        }

        public static PayloadCase forNumber(int i10) {
            if (i10 == 0) {
                return PAYLOAD_NOT_SET;
            }
            if (i10 == 2) {
                return START_AGENT_REQUEST;
            }
            if (i10 == 3) {
                return SEND_INPUT_REQUEST;
            }
            if (i10 != 4) {
                return null;
            }
            return CANCEL_REQUEST;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static PayloadCase valueOf(int i10) {
            return forNumber(i10);
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
    public void clearCancelRequest() {
        if (this.payloadCase_ == 4) {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPayload() {
        this.payloadCase_ = 0;
        this.payload_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSendInputRequest() {
        if (this.payloadCase_ == 3) {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartAgentRequest() {
        if (this.payloadCase_ == 2) {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }
    }

    public static ChatRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCancelRequest(CancelRequest cancelRequest) {
        cancelRequest.getClass();
        if (this.payloadCase_ != 4 || this.payload_ == CancelRequest.getDefaultInstance()) {
            this.payload_ = cancelRequest;
        } else {
            this.payload_ = CancelRequest.newBuilder((CancelRequest) this.payload_).mergeFrom((CancelRequest.Builder) cancelRequest).buildPartial();
        }
        this.payloadCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSendInputRequest(SendInputRequest sendInputRequest) {
        sendInputRequest.getClass();
        if (this.payloadCase_ != 3 || this.payload_ == SendInputRequest.getDefaultInstance()) {
            this.payload_ = sendInputRequest;
        } else {
            this.payload_ = SendInputRequest.newBuilder((SendInputRequest) this.payload_).mergeFrom((SendInputRequest.Builder) sendInputRequest).buildPartial();
        }
        this.payloadCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStartAgentRequest(StartAgentRequest startAgentRequest) {
        startAgentRequest.getClass();
        if (this.payloadCase_ != 2 || this.payload_ == StartAgentRequest.getDefaultInstance()) {
            this.payload_ = startAgentRequest;
        } else {
            this.payload_ = StartAgentRequest.newBuilder((StartAgentRequest) this.payload_).mergeFrom((StartAgentRequest.Builder) startAgentRequest).buildPartial();
        }
        this.payloadCase_ = 2;
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
    public void setCancelRequest(CancelRequest cancelRequest) {
        cancelRequest.getClass();
        this.payload_ = cancelRequest;
        this.payloadCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(long j10) {
        this.id_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendInputRequest(SendInputRequest sendInputRequest) {
        sendInputRequest.getClass();
        this.payload_ = sendInputRequest;
        this.payloadCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAgentRequest(StartAgentRequest startAgentRequest) {
        startAgentRequest.getClass();
        this.payload_ = startAgentRequest;
        this.payloadCase_ = 2;
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
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"payload_", "payloadCase_", "id_", StartAgentRequest.class, SendInputRequest.class, CancelRequest.class});
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

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public CancelRequest getCancelRequest() {
        return this.payloadCase_ == 4 ? (CancelRequest) this.payload_ : CancelRequest.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public PayloadCase getPayloadCase() {
        return PayloadCase.forNumber(this.payloadCase_);
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public SendInputRequest getSendInputRequest() {
        return this.payloadCase_ == 3 ? (SendInputRequest) this.payload_ : SendInputRequest.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public StartAgentRequest getStartAgentRequest() {
        return this.payloadCase_ == 2 ? (StartAgentRequest) this.payload_ : StartAgentRequest.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public boolean hasCancelRequest() {
        return this.payloadCase_ == 4;
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public boolean hasSendInputRequest() {
        return this.payloadCase_ == 3;
    }

    @Override // com.zyql.protobuf.runtime.ChatRequestOrBuilder
    public boolean hasStartAgentRequest() {
        return this.payloadCase_ == 2;
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
