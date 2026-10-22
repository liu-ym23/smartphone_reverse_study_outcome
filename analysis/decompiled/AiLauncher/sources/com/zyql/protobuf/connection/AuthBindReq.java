package com.zyql.protobuf.connection;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class AuthBindReq extends GeneratedMessageLite<AuthBindReq, Builder> implements AuthBindReqOrBuilder {
    public static final int APP_VERSION_FIELD_NUMBER = 7;
    public static final int CHANNEL_FIELD_NUMBER = 8;
    private static final AuthBindReq DEFAULT_INSTANCE;
    public static final int DEVICE_FIELD_NUMBER = 6;
    public static final int DID_FIELD_NUMBER = 9;
    private static volatile Parser<AuthBindReq> PARSER = null;
    public static final int PLATFORM_FIELD_NUMBER = 5;
    public static final int PRODUCT_FIELD_NUMBER = 1;
    public static final int RESERVED_FIELD_NUMBER = 10;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int TOKEN_TYPE_FIELD_NUMBER = 4;
    public static final int UID_FIELD_NUMBER = 2;
    private int platform_;
    private MapFieldLite<String, String> reserved_ = MapFieldLite.emptyMapField();
    private String product_ = "";
    private String uid_ = "";
    private String token_ = "";
    private String tokenType_ = "";
    private String device_ = "";
    private String appVersion_ = "";
    private String channel_ = "";
    private String did_ = "";

    /* renamed from: com.zyql.protobuf.connection.AuthBindReq$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AuthBindReq, Builder> implements AuthBindReqOrBuilder {
        public Builder clearAppVersion() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearAppVersion();
            return this;
        }

        public Builder clearChannel() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearChannel();
            return this;
        }

        public Builder clearDevice() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearDevice();
            return this;
        }

        public Builder clearDid() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearDid();
            return this;
        }

        public Builder clearPlatform() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearPlatform();
            return this;
        }

        public Builder clearProduct() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearProduct();
            return this;
        }

        public Builder clearReserved() {
            copyOnWrite();
            ((AuthBindReq) this.instance).getMutableReservedMap().clear();
            return this;
        }

        public Builder clearToken() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearToken();
            return this;
        }

        public Builder clearTokenType() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearTokenType();
            return this;
        }

        public Builder clearUid() {
            copyOnWrite();
            ((AuthBindReq) this.instance).clearUid();
            return this;
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public boolean containsReserved(String str) {
            str.getClass();
            return ((AuthBindReq) this.instance).getReservedMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getAppVersion() {
            return ((AuthBindReq) this.instance).getAppVersion();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getAppVersionBytes() {
            return ((AuthBindReq) this.instance).getAppVersionBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getChannel() {
            return ((AuthBindReq) this.instance).getChannel();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getChannelBytes() {
            return ((AuthBindReq) this.instance).getChannelBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getDevice() {
            return ((AuthBindReq) this.instance).getDevice();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getDeviceBytes() {
            return ((AuthBindReq) this.instance).getDeviceBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getDid() {
            return ((AuthBindReq) this.instance).getDid();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getDidBytes() {
            return ((AuthBindReq) this.instance).getDidBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public int getPlatform() {
            return ((AuthBindReq) this.instance).getPlatform();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getProduct() {
            return ((AuthBindReq) this.instance).getProduct();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getProductBytes() {
            return ((AuthBindReq) this.instance).getProductBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        @Deprecated
        public Map<String, String> getReserved() {
            return getReservedMap();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public int getReservedCount() {
            return ((AuthBindReq) this.instance).getReservedMap().size();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public Map<String, String> getReservedMap() {
            return Collections.unmodifiableMap(((AuthBindReq) this.instance).getReservedMap());
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getReservedOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> reservedMap = ((AuthBindReq) this.instance).getReservedMap();
            return reservedMap.containsKey(str) ? reservedMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getReservedOrThrow(String str) {
            str.getClass();
            Map<String, String> reservedMap = ((AuthBindReq) this.instance).getReservedMap();
            if (reservedMap.containsKey(str)) {
                return reservedMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getToken() {
            return ((AuthBindReq) this.instance).getToken();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getTokenBytes() {
            return ((AuthBindReq) this.instance).getTokenBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getTokenType() {
            return ((AuthBindReq) this.instance).getTokenType();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getTokenTypeBytes() {
            return ((AuthBindReq) this.instance).getTokenTypeBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public String getUid() {
            return ((AuthBindReq) this.instance).getUid();
        }

        @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
        public ByteString getUidBytes() {
            return ((AuthBindReq) this.instance).getUidBytes();
        }

        public Builder putAllReserved(Map<String, String> map) {
            copyOnWrite();
            ((AuthBindReq) this.instance).getMutableReservedMap().putAll(map);
            return this;
        }

        public Builder putReserved(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((AuthBindReq) this.instance).getMutableReservedMap().put(str, str2);
            return this;
        }

        public Builder removeReserved(String str) {
            str.getClass();
            copyOnWrite();
            ((AuthBindReq) this.instance).getMutableReservedMap().remove(str);
            return this;
        }

        public Builder setAppVersion(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setAppVersion(str);
            return this;
        }

        public Builder setAppVersionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setAppVersionBytes(byteString);
            return this;
        }

        public Builder setChannel(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setChannel(str);
            return this;
        }

        public Builder setChannelBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setChannelBytes(byteString);
            return this;
        }

        public Builder setDevice(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setDevice(str);
            return this;
        }

        public Builder setDeviceBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setDeviceBytes(byteString);
            return this;
        }

        public Builder setDid(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setDid(str);
            return this;
        }

        public Builder setDidBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setDidBytes(byteString);
            return this;
        }

        public Builder setPlatform(int i10) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setPlatform(i10);
            return this;
        }

        public Builder setProduct(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setProduct(str);
            return this;
        }

        public Builder setProductBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setProductBytes(byteString);
            return this;
        }

        public Builder setToken(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setToken(str);
            return this;
        }

        public Builder setTokenBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setTokenBytes(byteString);
            return this;
        }

        public Builder setTokenType(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setTokenType(str);
            return this;
        }

        public Builder setTokenTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setTokenTypeBytes(byteString);
            return this;
        }

        public Builder setUid(String str) {
            copyOnWrite();
            ((AuthBindReq) this.instance).setUid(str);
            return this;
        }

        public Builder setUidBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindReq) this.instance).setUidBytes(byteString);
            return this;
        }

        private Builder() {
            super(AuthBindReq.DEFAULT_INSTANCE);
        }
    }

    public static final class ReservedDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ReservedDefaultEntryHolder() {
        }
    }

    static {
        AuthBindReq authBindReq = new AuthBindReq();
        DEFAULT_INSTANCE = authBindReq;
        GeneratedMessageLite.registerDefaultInstance(AuthBindReq.class, authBindReq);
    }

    private AuthBindReq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppVersion() {
        this.appVersion_ = getDefaultInstance().getAppVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannel() {
        this.channel_ = getDefaultInstance().getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDevice() {
        this.device_ = getDefaultInstance().getDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDid() {
        this.did_ = getDefaultInstance().getDid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlatform() {
        this.platform_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProduct() {
        this.product_ = getDefaultInstance().getProduct();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTokenType() {
        this.tokenType_ = getDefaultInstance().getTokenType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUid() {
        this.uid_ = getDefaultInstance().getUid();
    }

    public static AuthBindReq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableReservedMap() {
        return internalGetMutableReserved();
    }

    private MapFieldLite<String, String> internalGetMutableReserved() {
        if (!this.reserved_.isMutable()) {
            this.reserved_ = this.reserved_.mutableCopy();
        }
        return this.reserved_;
    }

    private MapFieldLite<String, String> internalGetReserved() {
        return this.reserved_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthBindReq parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthBindReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthBindReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AuthBindReq> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppVersion(String str) {
        str.getClass();
        this.appVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppVersionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.appVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(String str) {
        str.getClass();
        this.channel_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.channel_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDevice(String str) {
        str.getClass();
        this.device_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.device_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDid(String str) {
        str.getClass();
        this.did_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDidBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.did_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatform(int i10) {
        this.platform_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProduct(String str) {
        str.getClass();
        this.product_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProductBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.product_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokenBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.token_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokenType(String str) {
        str.getClass();
        this.tokenType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokenTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.tokenType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(String str) {
        str.getClass();
        this.uid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUidBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uid_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public boolean containsReserved(String str) {
        str.getClass();
        return internalGetReserved().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AuthBindReq();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u000b\u0006Ȉ\u0007Ȉ\bȈ\tȈ\n2", new Object[]{"product_", "uid_", "token_", "tokenType_", "platform_", "device_", "appVersion_", "channel_", "did_", "reserved_", ReservedDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthBindReq> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AuthBindReq.class) {
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

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getAppVersion() {
        return this.appVersion_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getAppVersionBytes() {
        return ByteString.copyFromUtf8(this.appVersion_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getChannel() {
        return this.channel_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getChannelBytes() {
        return ByteString.copyFromUtf8(this.channel_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getDevice() {
        return this.device_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getDeviceBytes() {
        return ByteString.copyFromUtf8(this.device_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getDid() {
        return this.did_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getDidBytes() {
        return ByteString.copyFromUtf8(this.did_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public int getPlatform() {
        return this.platform_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getProduct() {
        return this.product_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getProductBytes() {
        return ByteString.copyFromUtf8(this.product_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    @Deprecated
    public Map<String, String> getReserved() {
        return getReservedMap();
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public int getReservedCount() {
        return internalGetReserved().size();
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public Map<String, String> getReservedMap() {
        return Collections.unmodifiableMap(internalGetReserved());
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getReservedOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetReserved = internalGetReserved();
        return mapFieldLiteInternalGetReserved.containsKey(str) ? mapFieldLiteInternalGetReserved.get(str) : str2;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getReservedOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetReserved = internalGetReserved();
        if (mapFieldLiteInternalGetReserved.containsKey(str)) {
            return mapFieldLiteInternalGetReserved.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getToken() {
        return this.token_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getTokenBytes() {
        return ByteString.copyFromUtf8(this.token_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getTokenType() {
        return this.tokenType_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getTokenTypeBytes() {
        return ByteString.copyFromUtf8(this.tokenType_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public String getUid() {
        return this.uid_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindReqOrBuilder
    public ByteString getUidBytes() {
        return ByteString.copyFromUtf8(this.uid_);
    }

    public static Builder newBuilder(AuthBindReq authBindReq) {
        return DEFAULT_INSTANCE.createBuilder(authBindReq);
    }

    public static AuthBindReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthBindReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthBindReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuthBindReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthBindReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthBindReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthBindReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthBindReq parseFrom(InputStream inputStream) throws IOException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthBindReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthBindReq parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthBindReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthBindReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
