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
public final class StoreClearRequest extends GeneratedMessageLite<StoreClearRequest, Builder> implements StoreClearRequestOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 4;
    private static final StoreClearRequest DEFAULT_INSTANCE;
    private static volatile Parser<StoreClearRequest> PARSER = null;
    public static final int PREFIX_FIELD_NUMBER = 5;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int scope_;
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";
    private String prefix_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreClearRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreClearRequest, Builder> implements StoreClearRequestOrBuilder {
        public Builder clearAppId() {
            copyOnWrite();
            ((StoreClearRequest) this.instance).clearAppId();
            return this;
        }

        public Builder clearPrefix() {
            copyOnWrite();
            ((StoreClearRequest) this.instance).clearPrefix();
            return this;
        }

        public Builder clearScope() {
            copyOnWrite();
            ((StoreClearRequest) this.instance).clearScope();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((StoreClearRequest) this.instance).clearSessionId();
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            ((StoreClearRequest) this.instance).clearUserId();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public String getAppId() {
            return ((StoreClearRequest) this.instance).getAppId();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public ByteString getAppIdBytes() {
            return ((StoreClearRequest) this.instance).getAppIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public String getPrefix() {
            return ((StoreClearRequest) this.instance).getPrefix();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public ByteString getPrefixBytes() {
            return ((StoreClearRequest) this.instance).getPrefixBytes();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public StoreScope getScope() {
            return ((StoreClearRequest) this.instance).getScope();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public int getScopeValue() {
            return ((StoreClearRequest) this.instance).getScopeValue();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public String getSessionId() {
            return ((StoreClearRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((StoreClearRequest) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public String getUserId() {
            return ((StoreClearRequest) this.instance).getUserId();
        }

        @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
        public ByteString getUserIdBytes() {
            return ((StoreClearRequest) this.instance).getUserIdBytes();
        }

        public Builder setAppId(String str) {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setAppId(str);
            return this;
        }

        public Builder setAppIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setAppIdBytes(byteString);
            return this;
        }

        public Builder setPrefix(String str) {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setPrefix(str);
            return this;
        }

        public Builder setPrefixBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setPrefixBytes(byteString);
            return this;
        }

        public Builder setScope(StoreScope storeScope) {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setScope(storeScope);
            return this;
        }

        public Builder setScopeValue(int i10) {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setScopeValue(i10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setUserId(String str) {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setUserId(str);
            return this;
        }

        public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreClearRequest) this.instance).setUserIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreClearRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreClearRequest storeClearRequest = new StoreClearRequest();
        DEFAULT_INSTANCE = storeClearRequest;
        GeneratedMessageLite.registerDefaultInstance(StoreClearRequest.class, storeClearRequest);
    }

    private StoreClearRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppId() {
        this.appId_ = getDefaultInstance().getAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrefix() {
        this.prefix_ = getDefaultInstance().getPrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScope() {
        this.scope_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserId() {
        this.userId_ = getDefaultInstance().getUserId();
    }

    public static StoreClearRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreClearRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreClearRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreClearRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreClearRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppId(String str) {
        str.getClass();
        this.appId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.appId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrefix(String str) {
        str.getClass();
        this.prefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrefixBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.prefix_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScope(StoreScope storeScope) {
        this.scope_ = storeScope.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScopeValue(int i10) {
        this.scope_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(String str) {
        str.getClass();
        this.userId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.userId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StoreClearRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"scope_", "userId_", "sessionId_", "appId_", "prefix_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreClearRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreClearRequest.class) {
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

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public String getAppId() {
        return this.appId_;
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public ByteString getAppIdBytes() {
        return ByteString.copyFromUtf8(this.appId_);
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public String getPrefix() {
        return this.prefix_;
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public ByteString getPrefixBytes() {
        return ByteString.copyFromUtf8(this.prefix_);
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public StoreScope getScope() {
        StoreScope storeScopeForNumber = StoreScope.forNumber(this.scope_);
        return storeScopeForNumber == null ? StoreScope.UNRECOGNIZED : storeScopeForNumber;
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public int getScopeValue() {
        return this.scope_;
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public String getUserId() {
        return this.userId_;
    }

    @Override // com.zyql.protobuf.common.StoreClearRequestOrBuilder
    public ByteString getUserIdBytes() {
        return ByteString.copyFromUtf8(this.userId_);
    }

    public static Builder newBuilder(StoreClearRequest storeClearRequest) {
        return DEFAULT_INSTANCE.createBuilder(storeClearRequest);
    }

    public static StoreClearRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreClearRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreClearRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreClearRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreClearRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreClearRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreClearRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreClearRequest parseFrom(InputStream inputStream) throws IOException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreClearRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreClearRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreClearRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreClearRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
