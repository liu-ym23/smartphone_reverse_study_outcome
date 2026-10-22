package com.zyql.protobuf.runtime;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.runtime.CancelAck;
import com.zyql.protobuf.runtime.SendInputAck;
import com.zyql.protobuf.runtime.StartAgentAck;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class RequestAck extends GeneratedMessageLite<RequestAck, Builder> implements RequestAckOrBuilder {
    public static final int CANCEL_ACK_FIELD_NUMBER = 6;
    private static final RequestAck DEFAULT_INSTANCE;
    public static final int ERROR_CODE_FIELD_NUMBER = 2;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 3;
    private static volatile Parser<RequestAck> PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int SEND_INPUT_ACK_FIELD_NUMBER = 5;
    public static final int START_AGENT_ACK_FIELD_NUMBER = 4;
    private Object ackType_;
    private int bitField0_;
    private int errorCode_;
    private long requestId_;
    private int ackTypeCase_ = 0;
    private String errorMessage_ = "";

    /* renamed from: com.zyql.protobuf.runtime.RequestAck$1, reason: invalid class name */
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

    public enum AckTypeCase {
        START_AGENT_ACK(4),
        SEND_INPUT_ACK(5),
        CANCEL_ACK(6),
        ACKTYPE_NOT_SET(0);

        private final int value;

        AckTypeCase(int i10) {
            this.value = i10;
        }

        public static AckTypeCase forNumber(int i10) {
            if (i10 == 0) {
                return ACKTYPE_NOT_SET;
            }
            if (i10 == 4) {
                return START_AGENT_ACK;
            }
            if (i10 == 5) {
                return SEND_INPUT_ACK;
            }
            if (i10 != 6) {
                return null;
            }
            return CANCEL_ACK;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static AckTypeCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RequestAck, Builder> implements RequestAckOrBuilder {
        public Builder clearAckType() {
            copyOnWrite();
            ((RequestAck) this.instance).clearAckType();
            return this;
        }

        public Builder clearCancelAck() {
            copyOnWrite();
            ((RequestAck) this.instance).clearCancelAck();
            return this;
        }

        public Builder clearErrorCode() {
            copyOnWrite();
            ((RequestAck) this.instance).clearErrorCode();
            return this;
        }

        public Builder clearErrorMessage() {
            copyOnWrite();
            ((RequestAck) this.instance).clearErrorMessage();
            return this;
        }

        public Builder clearRequestId() {
            copyOnWrite();
            ((RequestAck) this.instance).clearRequestId();
            return this;
        }

        public Builder clearSendInputAck() {
            copyOnWrite();
            ((RequestAck) this.instance).clearSendInputAck();
            return this;
        }

        public Builder clearStartAgentAck() {
            copyOnWrite();
            ((RequestAck) this.instance).clearStartAgentAck();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public AckTypeCase getAckTypeCase() {
            return ((RequestAck) this.instance).getAckTypeCase();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public CancelAck getCancelAck() {
            return ((RequestAck) this.instance).getCancelAck();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public int getErrorCode() {
            return ((RequestAck) this.instance).getErrorCode();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public String getErrorMessage() {
            return ((RequestAck) this.instance).getErrorMessage();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public ByteString getErrorMessageBytes() {
            return ((RequestAck) this.instance).getErrorMessageBytes();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public long getRequestId() {
            return ((RequestAck) this.instance).getRequestId();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public SendInputAck getSendInputAck() {
            return ((RequestAck) this.instance).getSendInputAck();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public StartAgentAck getStartAgentAck() {
            return ((RequestAck) this.instance).getStartAgentAck();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public boolean hasCancelAck() {
            return ((RequestAck) this.instance).hasCancelAck();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public boolean hasErrorCode() {
            return ((RequestAck) this.instance).hasErrorCode();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public boolean hasErrorMessage() {
            return ((RequestAck) this.instance).hasErrorMessage();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public boolean hasSendInputAck() {
            return ((RequestAck) this.instance).hasSendInputAck();
        }

        @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
        public boolean hasStartAgentAck() {
            return ((RequestAck) this.instance).hasStartAgentAck();
        }

        public Builder mergeCancelAck(CancelAck cancelAck) {
            copyOnWrite();
            ((RequestAck) this.instance).mergeCancelAck(cancelAck);
            return this;
        }

        public Builder mergeSendInputAck(SendInputAck sendInputAck) {
            copyOnWrite();
            ((RequestAck) this.instance).mergeSendInputAck(sendInputAck);
            return this;
        }

        public Builder mergeStartAgentAck(StartAgentAck startAgentAck) {
            copyOnWrite();
            ((RequestAck) this.instance).mergeStartAgentAck(startAgentAck);
            return this;
        }

        public Builder setCancelAck(CancelAck cancelAck) {
            copyOnWrite();
            ((RequestAck) this.instance).setCancelAck(cancelAck);
            return this;
        }

        public Builder setErrorCode(int i10) {
            copyOnWrite();
            ((RequestAck) this.instance).setErrorCode(i10);
            return this;
        }

        public Builder setErrorMessage(String str) {
            copyOnWrite();
            ((RequestAck) this.instance).setErrorMessage(str);
            return this;
        }

        public Builder setErrorMessageBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((RequestAck) this.instance).setErrorMessageBytes(byteString);
            return this;
        }

        public Builder setRequestId(long j10) {
            copyOnWrite();
            ((RequestAck) this.instance).setRequestId(j10);
            return this;
        }

        public Builder setSendInputAck(SendInputAck sendInputAck) {
            copyOnWrite();
            ((RequestAck) this.instance).setSendInputAck(sendInputAck);
            return this;
        }

        public Builder setStartAgentAck(StartAgentAck startAgentAck) {
            copyOnWrite();
            ((RequestAck) this.instance).setStartAgentAck(startAgentAck);
            return this;
        }

        private Builder() {
            super(RequestAck.DEFAULT_INSTANCE);
        }

        public Builder setCancelAck(CancelAck.Builder builder) {
            copyOnWrite();
            ((RequestAck) this.instance).setCancelAck(builder.build());
            return this;
        }

        public Builder setSendInputAck(SendInputAck.Builder builder) {
            copyOnWrite();
            ((RequestAck) this.instance).setSendInputAck(builder.build());
            return this;
        }

        public Builder setStartAgentAck(StartAgentAck.Builder builder) {
            copyOnWrite();
            ((RequestAck) this.instance).setStartAgentAck(builder.build());
            return this;
        }
    }

    static {
        RequestAck requestAck = new RequestAck();
        DEFAULT_INSTANCE = requestAck;
        GeneratedMessageLite.registerDefaultInstance(RequestAck.class, requestAck);
    }

    private RequestAck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAckType() {
        this.ackTypeCase_ = 0;
        this.ackType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCancelAck() {
        if (this.ackTypeCase_ == 6) {
            this.ackTypeCase_ = 0;
            this.ackType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorCode() {
        this.bitField0_ &= -2;
        this.errorCode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorMessage() {
        this.bitField0_ &= -3;
        this.errorMessage_ = getDefaultInstance().getErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSendInputAck() {
        if (this.ackTypeCase_ == 5) {
            this.ackTypeCase_ = 0;
            this.ackType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartAgentAck() {
        if (this.ackTypeCase_ == 4) {
            this.ackTypeCase_ = 0;
            this.ackType_ = null;
        }
    }

    public static RequestAck getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCancelAck(CancelAck cancelAck) {
        cancelAck.getClass();
        if (this.ackTypeCase_ != 6 || this.ackType_ == CancelAck.getDefaultInstance()) {
            this.ackType_ = cancelAck;
        } else {
            this.ackType_ = CancelAck.newBuilder((CancelAck) this.ackType_).mergeFrom((CancelAck.Builder) cancelAck).buildPartial();
        }
        this.ackTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSendInputAck(SendInputAck sendInputAck) {
        sendInputAck.getClass();
        if (this.ackTypeCase_ != 5 || this.ackType_ == SendInputAck.getDefaultInstance()) {
            this.ackType_ = sendInputAck;
        } else {
            this.ackType_ = SendInputAck.newBuilder((SendInputAck) this.ackType_).mergeFrom((SendInputAck.Builder) sendInputAck).buildPartial();
        }
        this.ackTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStartAgentAck(StartAgentAck startAgentAck) {
        startAgentAck.getClass();
        if (this.ackTypeCase_ != 4 || this.ackType_ == StartAgentAck.getDefaultInstance()) {
            this.ackType_ = startAgentAck;
        } else {
            this.ackType_ = StartAgentAck.newBuilder((StartAgentAck) this.ackType_).mergeFrom((StartAgentAck.Builder) startAgentAck).buildPartial();
        }
        this.ackTypeCase_ = 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RequestAck parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RequestAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestAck parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RequestAck> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCancelAck(CancelAck cancelAck) {
        cancelAck.getClass();
        this.ackType_ = cancelAck;
        this.ackTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCode(int i10) {
        this.bitField0_ |= 1;
        this.errorCode_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMessage(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.errorMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMessageBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.errorMessage_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(long j10) {
        this.requestId_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendInputAck(SendInputAck sendInputAck) {
        sendInputAck.getClass();
        this.ackType_ = sendInputAck;
        this.ackTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAgentAck(StartAgentAck startAgentAck) {
        startAgentAck.getClass();
        this.ackType_ = startAgentAck;
        this.ackTypeCase_ = 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new RequestAck();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0003\u0002င\u0000\u0003ለ\u0001\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"ackType_", "ackTypeCase_", "bitField0_", "requestId_", "errorCode_", "errorMessage_", StartAgentAck.class, SendInputAck.class, CancelAck.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RequestAck> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RequestAck.class) {
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

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public AckTypeCase getAckTypeCase() {
        return AckTypeCase.forNumber(this.ackTypeCase_);
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public CancelAck getCancelAck() {
        return this.ackTypeCase_ == 6 ? (CancelAck) this.ackType_ : CancelAck.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public int getErrorCode() {
        return this.errorCode_;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public String getErrorMessage() {
        return this.errorMessage_;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public ByteString getErrorMessageBytes() {
        return ByteString.copyFromUtf8(this.errorMessage_);
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public long getRequestId() {
        return this.requestId_;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public SendInputAck getSendInputAck() {
        return this.ackTypeCase_ == 5 ? (SendInputAck) this.ackType_ : SendInputAck.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public StartAgentAck getStartAgentAck() {
        return this.ackTypeCase_ == 4 ? (StartAgentAck) this.ackType_ : StartAgentAck.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public boolean hasCancelAck() {
        return this.ackTypeCase_ == 6;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public boolean hasErrorCode() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public boolean hasErrorMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public boolean hasSendInputAck() {
        return this.ackTypeCase_ == 5;
    }

    @Override // com.zyql.protobuf.runtime.RequestAckOrBuilder
    public boolean hasStartAgentAck() {
        return this.ackTypeCase_ == 4;
    }

    public static Builder newBuilder(RequestAck requestAck) {
        return DEFAULT_INSTANCE.createBuilder(requestAck);
    }

    public static RequestAck parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestAck parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RequestAck parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RequestAck parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RequestAck parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RequestAck parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RequestAck parseFrom(InputStream inputStream) throws IOException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestAck parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestAck parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RequestAck parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
