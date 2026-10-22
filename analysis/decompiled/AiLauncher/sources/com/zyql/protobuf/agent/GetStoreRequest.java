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
public final class GetStoreRequest extends GeneratedMessageLite<GetStoreRequest, Builder> implements GetStoreRequestOrBuilder {
    private static final GetStoreRequest DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<GetStoreRequest> PARSER = null;
    public static final int STORE_ID_FIELD_NUMBER = 1;
    private String storeId_ = "";
    private String key_ = "";

    /* renamed from: com.zyql.protobuf.agent.GetStoreRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetStoreRequest, Builder> implements GetStoreRequestOrBuilder {
        public Builder clearKey() {
            copyOnWrite();
            ((GetStoreRequest) this.instance).clearKey();
            return this;
        }

        public Builder clearStoreId() {
            copyOnWrite();
            ((GetStoreRequest) this.instance).clearStoreId();
            return this;
        }

        @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
        public String getKey() {
            return ((GetStoreRequest) this.instance).getKey();
        }

        @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
        public ByteString getKeyBytes() {
            return ((GetStoreRequest) this.instance).getKeyBytes();
        }

        @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
        public String getStoreId() {
            return ((GetStoreRequest) this.instance).getStoreId();
        }

        @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
        public ByteString getStoreIdBytes() {
            return ((GetStoreRequest) this.instance).getStoreIdBytes();
        }

        public Builder setKey(String str) {
            copyOnWrite();
            ((GetStoreRequest) this.instance).setKey(str);
            return this;
        }

        public Builder setKeyBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetStoreRequest) this.instance).setKeyBytes(byteString);
            return this;
        }

        public Builder setStoreId(String str) {
            copyOnWrite();
            ((GetStoreRequest) this.instance).setStoreId(str);
            return this;
        }

        public Builder setStoreIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetStoreRequest) this.instance).setStoreIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(GetStoreRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        GetStoreRequest getStoreRequest = new GetStoreRequest();
        DEFAULT_INSTANCE = getStoreRequest;
        GeneratedMessageLite.registerDefaultInstance(GetStoreRequest.class, getStoreRequest);
    }

    private GetStoreRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoreId() {
        this.storeId_ = getDefaultInstance().getStoreId();
    }

    public static GetStoreRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetStoreRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GetStoreRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetStoreRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetStoreRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new GetStoreRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"storeId_", "key_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetStoreRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetStoreRequest.class) {
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

    @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
    public String getKey() {
        return this.key_;
    }

    @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
    public ByteString getKeyBytes() {
        return ByteString.copyFromUtf8(this.key_);
    }

    @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
    public String getStoreId() {
        return this.storeId_;
    }

    @Override // com.zyql.protobuf.agent.GetStoreRequestOrBuilder
    public ByteString getStoreIdBytes() {
        return ByteString.copyFromUtf8(this.storeId_);
    }

    public static Builder newBuilder(GetStoreRequest getStoreRequest) {
        return DEFAULT_INSTANCE.createBuilder(getStoreRequest);
    }

    public static GetStoreRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetStoreRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetStoreRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetStoreRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GetStoreRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetStoreRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetStoreRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetStoreRequest parseFrom(InputStream inputStream) throws IOException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetStoreRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetStoreRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetStoreRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetStoreRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
