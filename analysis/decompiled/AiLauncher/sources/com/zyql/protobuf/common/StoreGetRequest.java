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
public final class StoreGetRequest extends GeneratedMessageLite<StoreGetRequest, Builder> implements StoreGetRequestOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 5;
    private static final StoreGetRequest DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 6;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<StoreGetRequest> PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private int bitField0_;
    private int scope_;
    private String key_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";
    private String defaultValue_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreGetRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreGetRequest, Builder> implements StoreGetRequestOrBuilder {
        public Builder clearAppId() {
            copyOnWrite();
            ((StoreGetRequest) this.instance).clearAppId();
            return this;
        }

        public Builder clearDefaultValue() {
            copyOnWrite();
            ((StoreGetRequest) this.instance).clearDefaultValue();
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((StoreGetRequest) this.instance).clearKey();
            return this;
        }

        public Builder clearScope() {
            copyOnWrite();
            ((StoreGetRequest) this.instance).clearScope();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((StoreGetRequest) this.instance).clearSessionId();
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            ((StoreGetRequest) this.instance).clearUserId();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public String getAppId() {
            return ((StoreGetRequest) this.instance).getAppId();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public ByteString getAppIdBytes() {
            return ((StoreGetRequest) this.instance).getAppIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public String getDefaultValue() {
            return ((StoreGetRequest) this.instance).getDefaultValue();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public ByteString getDefaultValueBytes() {
            return ((StoreGetRequest) this.instance).getDefaultValueBytes();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public String getKey() {
            return ((StoreGetRequest) this.instance).getKey();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public ByteString getKeyBytes() {
            return ((StoreGetRequest) this.instance).getKeyBytes();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public StoreScope getScope() {
            return ((StoreGetRequest) this.instance).getScope();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public int getScopeValue() {
            return ((StoreGetRequest) this.instance).getScopeValue();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public String getSessionId() {
            return ((StoreGetRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((StoreGetRequest) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public String getUserId() {
            return ((StoreGetRequest) this.instance).getUserId();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public ByteString getUserIdBytes() {
            return ((StoreGetRequest) this.instance).getUserIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
        public boolean hasDefaultValue() {
            return ((StoreGetRequest) this.instance).hasDefaultValue();
        }

        public Builder setAppId(String str) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setAppId(str);
            return this;
        }

        public Builder setAppIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setAppIdBytes(byteString);
            return this;
        }

        public Builder setDefaultValue(String str) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setDefaultValue(str);
            return this;
        }

        public Builder setDefaultValueBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setDefaultValueBytes(byteString);
            return this;
        }

        public Builder setKey(String str) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setKey(str);
            return this;
        }

        public Builder setKeyBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setKeyBytes(byteString);
            return this;
        }

        public Builder setScope(StoreScope storeScope) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setScope(storeScope);
            return this;
        }

        public Builder setScopeValue(int i10) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setScopeValue(i10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setUserId(String str) {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setUserId(str);
            return this;
        }

        public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreGetRequest) this.instance).setUserIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreGetRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreGetRequest storeGetRequest = new StoreGetRequest();
        DEFAULT_INSTANCE = storeGetRequest;
        GeneratedMessageLite.registerDefaultInstance(StoreGetRequest.class, storeGetRequest);
    }

    private StoreGetRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppId() {
        this.appId_ = getDefaultInstance().getAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDefaultValue() {
        this.bitField0_ &= -2;
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKey() {
        this.key_ = getDefaultInstance().getKey();
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

    public static StoreGetRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreGetRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreGetRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreGetRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreGetRequest> parser() {
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
    public void setDefaultValue(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.defaultValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValueBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.defaultValue_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
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
                return new StoreGetRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006ለ\u0000", new Object[]{"bitField0_", "scope_", "key_", "userId_", "sessionId_", "appId_", "defaultValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreGetRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreGetRequest.class) {
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

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public String getAppId() {
        return this.appId_;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public ByteString getAppIdBytes() {
        return ByteString.copyFromUtf8(this.appId_);
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public String getKey() {
        return this.key_;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public ByteString getKeyBytes() {
        return ByteString.copyFromUtf8(this.key_);
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public StoreScope getScope() {
        StoreScope storeScopeForNumber = StoreScope.forNumber(this.scope_);
        return storeScopeForNumber == null ? StoreScope.UNRECOGNIZED : storeScopeForNumber;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public int getScopeValue() {
        return this.scope_;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public String getUserId() {
        return this.userId_;
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public ByteString getUserIdBytes() {
        return ByteString.copyFromUtf8(this.userId_);
    }

    @Override // com.zyql.protobuf.common.StoreGetRequestOrBuilder
    public boolean hasDefaultValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StoreGetRequest storeGetRequest) {
        return DEFAULT_INSTANCE.createBuilder(storeGetRequest);
    }

    public static StoreGetRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreGetRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreGetRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreGetRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreGetRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreGetRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreGetRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreGetRequest parseFrom(InputStream inputStream) throws IOException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreGetRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreGetRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreGetRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreGetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
