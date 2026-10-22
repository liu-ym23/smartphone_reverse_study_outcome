package com.zyql.protobuf.common;

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
public final class RegisterHookResponse extends GeneratedMessageLite<RegisterHookResponse, Builder> implements RegisterHookResponseOrBuilder {
    private static final RegisterHookResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 3;
    public static final int HOOK_ID_FIELD_NUMBER = 2;
    private static volatile Parser<RegisterHookResponse> PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private boolean success_;
    private String hookId_ = "";
    private String error_ = "";

    /* renamed from: com.zyql.protobuf.common.RegisterHookResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RegisterHookResponse, Builder> implements RegisterHookResponseOrBuilder {
        public Builder clearError() {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).clearError();
            return this;
        }

        public Builder clearHookId() {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).clearHookId();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).clearSuccess();
            return this;
        }

        @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
        public String getError() {
            return ((RegisterHookResponse) this.instance).getError();
        }

        @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
        public ByteString getErrorBytes() {
            return ((RegisterHookResponse) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
        public String getHookId() {
            return ((RegisterHookResponse) this.instance).getHookId();
        }

        @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
        public ByteString getHookIdBytes() {
            return ((RegisterHookResponse) this.instance).getHookIdBytes();
        }

        @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
        public boolean getSuccess() {
            return ((RegisterHookResponse) this.instance).getSuccess();
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setHookId(String str) {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).setHookId(str);
            return this;
        }

        public Builder setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).setHookIdBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((RegisterHookResponse) this.instance).setSuccess(z10);
            return this;
        }

        private Builder() {
            super(RegisterHookResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        RegisterHookResponse registerHookResponse = new RegisterHookResponse();
        DEFAULT_INSTANCE = registerHookResponse;
        GeneratedMessageLite.registerDefaultInstance(RegisterHookResponse.class, registerHookResponse);
    }

    private RegisterHookResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookId() {
        this.hookId_ = getDefaultInstance().getHookId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static RegisterHookResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RegisterHookResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RegisterHookResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RegisterHookResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RegisterHookResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookId(String str) {
        str.getClass();
        this.hookId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.hookId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new RegisterHookResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003Ȉ", new Object[]{"success_", "hookId_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RegisterHookResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RegisterHookResponse.class) {
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

    @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
    public String getHookId() {
        return this.hookId_;
    }

    @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
    public ByteString getHookIdBytes() {
        return ByteString.copyFromUtf8(this.hookId_);
    }

    @Override // com.zyql.protobuf.common.RegisterHookResponseOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    public static Builder newBuilder(RegisterHookResponse registerHookResponse) {
        return DEFAULT_INSTANCE.createBuilder(registerHookResponse);
    }

    public static RegisterHookResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegisterHookResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RegisterHookResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RegisterHookResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RegisterHookResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RegisterHookResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RegisterHookResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RegisterHookResponse parseFrom(InputStream inputStream) throws IOException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RegisterHookResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RegisterHookResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RegisterHookResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
