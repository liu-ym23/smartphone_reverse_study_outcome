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
public final class UnregisterHookResponse extends GeneratedMessageLite<UnregisterHookResponse, Builder> implements UnregisterHookResponseOrBuilder {
    private static final UnregisterHookResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    private static volatile Parser<UnregisterHookResponse> PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private String error_ = "";
    private boolean success_;

    /* renamed from: com.zyql.protobuf.common.UnregisterHookResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<UnregisterHookResponse, Builder> implements UnregisterHookResponseOrBuilder {
        public Builder clearError() {
            copyOnWrite();
            ((UnregisterHookResponse) this.instance).clearError();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((UnregisterHookResponse) this.instance).clearSuccess();
            return this;
        }

        @Override // com.zyql.protobuf.common.UnregisterHookResponseOrBuilder
        public String getError() {
            return ((UnregisterHookResponse) this.instance).getError();
        }

        @Override // com.zyql.protobuf.common.UnregisterHookResponseOrBuilder
        public ByteString getErrorBytes() {
            return ((UnregisterHookResponse) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.common.UnregisterHookResponseOrBuilder
        public boolean getSuccess() {
            return ((UnregisterHookResponse) this.instance).getSuccess();
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((UnregisterHookResponse) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((UnregisterHookResponse) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((UnregisterHookResponse) this.instance).setSuccess(z10);
            return this;
        }

        private Builder() {
            super(UnregisterHookResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        UnregisterHookResponse unregisterHookResponse = new UnregisterHookResponse();
        DEFAULT_INSTANCE = unregisterHookResponse;
        GeneratedMessageLite.registerDefaultInstance(UnregisterHookResponse.class, unregisterHookResponse);
    }

    private UnregisterHookResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static UnregisterHookResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UnregisterHookResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UnregisterHookResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UnregisterHookResponse> parser() {
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
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new UnregisterHookResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"success_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UnregisterHookResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UnregisterHookResponse.class) {
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

    @Override // com.zyql.protobuf.common.UnregisterHookResponseOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.common.UnregisterHookResponseOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.common.UnregisterHookResponseOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    public static Builder newBuilder(UnregisterHookResponse unregisterHookResponse) {
        return DEFAULT_INSTANCE.createBuilder(unregisterHookResponse);
    }

    public static UnregisterHookResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UnregisterHookResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UnregisterHookResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UnregisterHookResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UnregisterHookResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UnregisterHookResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UnregisterHookResponse parseFrom(InputStream inputStream) throws IOException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UnregisterHookResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UnregisterHookResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UnregisterHookResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UnregisterHookResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
