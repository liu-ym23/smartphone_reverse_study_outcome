package com.zyql.protobuf.internetplatform;

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
public final class CallBackReq extends GeneratedMessageLite<CallBackReq, Builder> implements CallBackReqOrBuilder {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final CallBackReq DEFAULT_INSTANCE;
    private static volatile Parser<CallBackReq> PARSER = null;
    public static final int REQUESTID_FIELD_NUMBER = 1;
    private String requestId_ = "";
    private String body_ = "";

    /* renamed from: com.zyql.protobuf.internetplatform.CallBackReq$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CallBackReq, Builder> implements CallBackReqOrBuilder {
        public Builder clearBody() {
            copyOnWrite();
            ((CallBackReq) this.instance).clearBody();
            return this;
        }

        public Builder clearRequestId() {
            copyOnWrite();
            ((CallBackReq) this.instance).clearRequestId();
            return this;
        }

        @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
        public String getBody() {
            return ((CallBackReq) this.instance).getBody();
        }

        @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
        public ByteString getBodyBytes() {
            return ((CallBackReq) this.instance).getBodyBytes();
        }

        @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
        public String getRequestId() {
            return ((CallBackReq) this.instance).getRequestId();
        }

        @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
        public ByteString getRequestIdBytes() {
            return ((CallBackReq) this.instance).getRequestIdBytes();
        }

        public Builder setBody(String str) {
            copyOnWrite();
            ((CallBackReq) this.instance).setBody(str);
            return this;
        }

        public Builder setBodyBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((CallBackReq) this.instance).setBodyBytes(byteString);
            return this;
        }

        public Builder setRequestId(String str) {
            copyOnWrite();
            ((CallBackReq) this.instance).setRequestId(str);
            return this;
        }

        public Builder setRequestIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((CallBackReq) this.instance).setRequestIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(CallBackReq.DEFAULT_INSTANCE);
        }
    }

    static {
        CallBackReq callBackReq = new CallBackReq();
        DEFAULT_INSTANCE = callBackReq;
        GeneratedMessageLite.registerDefaultInstance(CallBackReq.class, callBackReq);
    }

    private CallBackReq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    public static CallBackReq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CallBackReq parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CallBackReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CallBackReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CallBackReq> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBody(String str) {
        str.getClass();
        this.body_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBodyBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.body_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(String str) {
        str.getClass();
        this.requestId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.requestId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new CallBackReq();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"requestId_", "body_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CallBackReq> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CallBackReq.class) {
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

    @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
    public String getBody() {
        return this.body_;
    }

    @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
    public ByteString getBodyBytes() {
        return ByteString.copyFromUtf8(this.body_);
    }

    @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
    public String getRequestId() {
        return this.requestId_;
    }

    @Override // com.zyql.protobuf.internetplatform.CallBackReqOrBuilder
    public ByteString getRequestIdBytes() {
        return ByteString.copyFromUtf8(this.requestId_);
    }

    public static Builder newBuilder(CallBackReq callBackReq) {
        return DEFAULT_INSTANCE.createBuilder(callBackReq);
    }

    public static CallBackReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CallBackReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CallBackReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CallBackReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CallBackReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CallBackReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CallBackReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CallBackReq parseFrom(InputStream inputStream) throws IOException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CallBackReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CallBackReq parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CallBackReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CallBackReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
