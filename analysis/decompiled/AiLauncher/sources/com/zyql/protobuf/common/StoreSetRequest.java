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
public final class StoreSetRequest extends GeneratedMessageLite<StoreSetRequest, Builder> implements StoreSetRequestOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 6;
    private static final StoreSetRequest DEFAULT_INSTANCE;
    public static final int IF_EXISTS_FIELD_NUMBER = 9;
    public static final int IF_NOT_EXISTS_FIELD_NUMBER = 8;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<StoreSetRequest> PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int TTL_SECONDS_FIELD_NUMBER = 7;
    public static final int USER_ID_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 3;
    private boolean ifExists_;
    private boolean ifNotExists_;
    private int scope_;
    private long ttlSeconds_;
    private String key_ = "";
    private String value_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreSetRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreSetRequest, Builder> implements StoreSetRequestOrBuilder {
        public Builder clearAppId() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearAppId();
            return this;
        }

        public Builder clearIfExists() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearIfExists();
            return this;
        }

        public Builder clearIfNotExists() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearIfNotExists();
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearKey();
            return this;
        }

        public Builder clearScope() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearScope();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearSessionId();
            return this;
        }

        public Builder clearTtlSeconds() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearTtlSeconds();
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearUserId();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((StoreSetRequest) this.instance).clearValue();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public String getAppId() {
            return ((StoreSetRequest) this.instance).getAppId();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public ByteString getAppIdBytes() {
            return ((StoreSetRequest) this.instance).getAppIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public boolean getIfExists() {
            return ((StoreSetRequest) this.instance).getIfExists();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public boolean getIfNotExists() {
            return ((StoreSetRequest) this.instance).getIfNotExists();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public String getKey() {
            return ((StoreSetRequest) this.instance).getKey();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public ByteString getKeyBytes() {
            return ((StoreSetRequest) this.instance).getKeyBytes();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public StoreScope getScope() {
            return ((StoreSetRequest) this.instance).getScope();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public int getScopeValue() {
            return ((StoreSetRequest) this.instance).getScopeValue();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public String getSessionId() {
            return ((StoreSetRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((StoreSetRequest) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public long getTtlSeconds() {
            return ((StoreSetRequest) this.instance).getTtlSeconds();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public String getUserId() {
            return ((StoreSetRequest) this.instance).getUserId();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public ByteString getUserIdBytes() {
            return ((StoreSetRequest) this.instance).getUserIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public String getValue() {
            return ((StoreSetRequest) this.instance).getValue();
        }

        @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
        public ByteString getValueBytes() {
            return ((StoreSetRequest) this.instance).getValueBytes();
        }

        public Builder setAppId(String str) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setAppId(str);
            return this;
        }

        public Builder setAppIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setAppIdBytes(byteString);
            return this;
        }

        public Builder setIfExists(boolean z10) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setIfExists(z10);
            return this;
        }

        public Builder setIfNotExists(boolean z10) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setIfNotExists(z10);
            return this;
        }

        public Builder setKey(String str) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setKey(str);
            return this;
        }

        public Builder setKeyBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setKeyBytes(byteString);
            return this;
        }

        public Builder setScope(StoreScope storeScope) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setScope(storeScope);
            return this;
        }

        public Builder setScopeValue(int i10) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setScopeValue(i10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setTtlSeconds(long j10) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setTtlSeconds(j10);
            return this;
        }

        public Builder setUserId(String str) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setUserId(str);
            return this;
        }

        public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setUserIdBytes(byteString);
            return this;
        }

        public Builder setValue(String str) {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setValue(str);
            return this;
        }

        public Builder setValueBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreSetRequest) this.instance).setValueBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreSetRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreSetRequest storeSetRequest = new StoreSetRequest();
        DEFAULT_INSTANCE = storeSetRequest;
        GeneratedMessageLite.registerDefaultInstance(StoreSetRequest.class, storeSetRequest);
    }

    private StoreSetRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppId() {
        this.appId_ = getDefaultInstance().getAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIfExists() {
        this.ifExists_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIfNotExists() {
        this.ifNotExists_ = false;
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
    public void clearTtlSeconds() {
        this.ttlSeconds_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserId() {
        this.userId_ = getDefaultInstance().getUserId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static StoreSetRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreSetRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreSetRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreSetRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreSetRequest> parser() {
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
    public void setIfExists(boolean z10) {
        this.ifExists_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIfNotExists(boolean z10) {
        this.ifNotExists_ = z10;
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
    public void setTtlSeconds(long j10) {
        this.ttlSeconds_ = j10;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.value_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StoreSetRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0007\t\u0007", new Object[]{"scope_", "key_", "value_", "userId_", "sessionId_", "appId_", "ttlSeconds_", "ifNotExists_", "ifExists_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreSetRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreSetRequest.class) {
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

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public String getAppId() {
        return this.appId_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public ByteString getAppIdBytes() {
        return ByteString.copyFromUtf8(this.appId_);
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public boolean getIfExists() {
        return this.ifExists_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public boolean getIfNotExists() {
        return this.ifNotExists_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public String getKey() {
        return this.key_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public ByteString getKeyBytes() {
        return ByteString.copyFromUtf8(this.key_);
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public StoreScope getScope() {
        StoreScope storeScopeForNumber = StoreScope.forNumber(this.scope_);
        return storeScopeForNumber == null ? StoreScope.UNRECOGNIZED : storeScopeForNumber;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public int getScopeValue() {
        return this.scope_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public long getTtlSeconds() {
        return this.ttlSeconds_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public String getUserId() {
        return this.userId_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public ByteString getUserIdBytes() {
        return ByteString.copyFromUtf8(this.userId_);
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public String getValue() {
        return this.value_;
    }

    @Override // com.zyql.protobuf.common.StoreSetRequestOrBuilder
    public ByteString getValueBytes() {
        return ByteString.copyFromUtf8(this.value_);
    }

    public static Builder newBuilder(StoreSetRequest storeSetRequest) {
        return DEFAULT_INSTANCE.createBuilder(storeSetRequest);
    }

    public static StoreSetRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreSetRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreSetRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreSetRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreSetRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreSetRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreSetRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreSetRequest parseFrom(InputStream inputStream) throws IOException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreSetRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreSetRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreSetRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreSetRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
