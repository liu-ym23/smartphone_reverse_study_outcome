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
public final class Error extends GeneratedMessageLite<Error, Builder> implements ErrorOrBuilder {
    private static final Error DEFAULT_INSTANCE;
    public static final int ERROR_CODE_FIELD_NUMBER = 1;
    public static final int ERROR_MSG_FIELD_NUMBER = 2;
    private static volatile Parser<Error> PARSER;
    private long errorCode_;
    private String errorMsg_ = "";

    /* renamed from: com.zyql.protobuf.omni.Error$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Error, Builder> implements ErrorOrBuilder {
        public Builder clearErrorCode() {
            copyOnWrite();
            ((Error) this.instance).clearErrorCode();
            return this;
        }

        public Builder clearErrorMsg() {
            copyOnWrite();
            ((Error) this.instance).clearErrorMsg();
            return this;
        }

        @Override // com.zyql.protobuf.omni.ErrorOrBuilder
        public long getErrorCode() {
            return ((Error) this.instance).getErrorCode();
        }

        @Override // com.zyql.protobuf.omni.ErrorOrBuilder
        public String getErrorMsg() {
            return ((Error) this.instance).getErrorMsg();
        }

        @Override // com.zyql.protobuf.omni.ErrorOrBuilder
        public ByteString getErrorMsgBytes() {
            return ((Error) this.instance).getErrorMsgBytes();
        }

        public Builder setErrorCode(long j10) {
            copyOnWrite();
            ((Error) this.instance).setErrorCode(j10);
            return this;
        }

        public Builder setErrorMsg(String str) {
            copyOnWrite();
            ((Error) this.instance).setErrorMsg(str);
            return this;
        }

        public Builder setErrorMsgBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Error) this.instance).setErrorMsgBytes(byteString);
            return this;
        }

        private Builder() {
            super(Error.DEFAULT_INSTANCE);
        }
    }

    static {
        Error error = new Error();
        DEFAULT_INSTANCE = error;
        GeneratedMessageLite.registerDefaultInstance(Error.class, error);
    }

    private Error() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorCode() {
        this.errorCode_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorMsg() {
        this.errorMsg_ = getDefaultInstance().getErrorMsg();
    }

    public static Error getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Error parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Error) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Error parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Error> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCode(long j10) {
        this.errorCode_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMsg(String str) {
        str.getClass();
        this.errorMsg_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMsgBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.errorMsg_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Error();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"errorCode_", "errorMsg_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Error> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Error.class) {
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

    @Override // com.zyql.protobuf.omni.ErrorOrBuilder
    public long getErrorCode() {
        return this.errorCode_;
    }

    @Override // com.zyql.protobuf.omni.ErrorOrBuilder
    public String getErrorMsg() {
        return this.errorMsg_;
    }

    @Override // com.zyql.protobuf.omni.ErrorOrBuilder
    public ByteString getErrorMsgBytes() {
        return ByteString.copyFromUtf8(this.errorMsg_);
    }

    public static Builder newBuilder(Error error) {
        return DEFAULT_INSTANCE.createBuilder(error);
    }

    public static Error parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Error) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Error parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Error parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Error parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Error parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Error parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Error parseFrom(InputStream inputStream) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Error parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Error parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Error parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
