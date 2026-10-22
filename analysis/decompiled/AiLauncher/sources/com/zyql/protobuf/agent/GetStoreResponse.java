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
public final class GetStoreResponse extends GeneratedMessageLite<GetStoreResponse, Builder> implements GetStoreResponseOrBuilder {
    private static final GetStoreResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 5;
    public static final int KEY_FIELD_NUMBER = 3;
    private static volatile Parser<GetStoreResponse> PARSER = null;
    public static final int STORE_ID_FIELD_NUMBER = 2;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 4;
    private boolean success_;
    private String storeId_ = "";
    private String key_ = "";
    private ByteString value_ = ByteString.EMPTY;
    private String error_ = "";

    /* renamed from: com.zyql.protobuf.agent.GetStoreResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetStoreResponse, Builder> implements GetStoreResponseOrBuilder {
        public Builder clearError() {
            copyOnWrite();
            ((GetStoreResponse) this.instance).clearError();
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((GetStoreResponse) this.instance).clearKey();
            return this;
        }

        public Builder clearStoreId() {
            copyOnWrite();
            ((GetStoreResponse) this.instance).clearStoreId();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((GetStoreResponse) this.instance).clearSuccess();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((GetStoreResponse) this.instance).clearValue();
            return this;
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public String getError() {
            return ((GetStoreResponse) this.instance).getError();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public ByteString getErrorBytes() {
            return ((GetStoreResponse) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public String getKey() {
            return ((GetStoreResponse) this.instance).getKey();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public ByteString getKeyBytes() {
            return ((GetStoreResponse) this.instance).getKeyBytes();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public String getStoreId() {
            return ((GetStoreResponse) this.instance).getStoreId();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public ByteString getStoreIdBytes() {
            return ((GetStoreResponse) this.instance).getStoreIdBytes();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public boolean getSuccess() {
            return ((GetStoreResponse) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
        public ByteString getValue() {
            return ((GetStoreResponse) this.instance).getValue();
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setKey(String str) {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setKey(str);
            return this;
        }

        public Builder setKeyBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setKeyBytes(byteString);
            return this;
        }

        public Builder setStoreId(String str) {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setStoreId(str);
            return this;
        }

        public Builder setStoreIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setStoreIdBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setValue(ByteString byteString) {
            copyOnWrite();
            ((GetStoreResponse) this.instance).setValue(byteString);
            return this;
        }

        private Builder() {
            super(GetStoreResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        GetStoreResponse getStoreResponse = new GetStoreResponse();
        DEFAULT_INSTANCE = getStoreResponse;
        GeneratedMessageLite.registerDefaultInstance(GetStoreResponse.class, getStoreResponse);
    }

    private GetStoreResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoreId() {
        this.storeId_ = getDefaultInstance().getStoreId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static GetStoreResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetStoreResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GetStoreResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetStoreResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetStoreResponse> parser() {
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
    public void setKey(String str) {
        str.getClass();
        this.key_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.key_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreId(String str) {
        str.getClass();
        this.storeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.storeId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(ByteString byteString) {
        byteString.getClass();
        this.value_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new GetStoreResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003Ȉ\u0004\n\u0005Ȉ", new Object[]{"success_", "storeId_", "key_", "value_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetStoreResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetStoreResponse.class) {
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

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public String getKey() {
        return this.key_;
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public ByteString getKeyBytes() {
        return ByteString.copyFromUtf8(this.key_);
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public String getStoreId() {
        return this.storeId_;
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public ByteString getStoreIdBytes() {
        return ByteString.copyFromUtf8(this.storeId_);
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.agent.GetStoreResponseOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    public static Builder newBuilder(GetStoreResponse getStoreResponse) {
        return DEFAULT_INSTANCE.createBuilder(getStoreResponse);
    }

    public static GetStoreResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetStoreResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetStoreResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetStoreResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GetStoreResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetStoreResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetStoreResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetStoreResponse parseFrom(InputStream inputStream) throws IOException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetStoreResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetStoreResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetStoreResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetStoreResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
