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
public final class StoreEntry extends GeneratedMessageLite<StoreEntry, Builder> implements StoreEntryOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 6;
    public static final int CREATED_AT_FIELD_NUMBER = 7;
    private static final StoreEntry DEFAULT_INSTANCE;
    public static final int EXPIRES_AT_FIELD_NUMBER = 9;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<StoreEntry> PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int TTL_SECONDS_FIELD_NUMBER = 10;
    public static final int UPDATED_AT_FIELD_NUMBER = 8;
    public static final int USER_ID_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 3;
    private long createdAt_;
    private long expiresAt_;
    private int scope_;
    private long ttlSeconds_;
    private long updatedAt_;
    private String key_ = "";
    private String value_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreEntry$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreEntry, Builder> implements StoreEntryOrBuilder {
        public Builder clearAppId() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearAppId();
            return this;
        }

        public Builder clearCreatedAt() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearCreatedAt();
            return this;
        }

        public Builder clearExpiresAt() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearExpiresAt();
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearKey();
            return this;
        }

        public Builder clearScope() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearScope();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearSessionId();
            return this;
        }

        public Builder clearTtlSeconds() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearTtlSeconds();
            return this;
        }

        public Builder clearUpdatedAt() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearUpdatedAt();
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearUserId();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((StoreEntry) this.instance).clearValue();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public String getAppId() {
            return ((StoreEntry) this.instance).getAppId();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public ByteString getAppIdBytes() {
            return ((StoreEntry) this.instance).getAppIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public long getCreatedAt() {
            return ((StoreEntry) this.instance).getCreatedAt();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public long getExpiresAt() {
            return ((StoreEntry) this.instance).getExpiresAt();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public String getKey() {
            return ((StoreEntry) this.instance).getKey();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public ByteString getKeyBytes() {
            return ((StoreEntry) this.instance).getKeyBytes();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public StoreScope getScope() {
            return ((StoreEntry) this.instance).getScope();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public int getScopeValue() {
            return ((StoreEntry) this.instance).getScopeValue();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public String getSessionId() {
            return ((StoreEntry) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public ByteString getSessionIdBytes() {
            return ((StoreEntry) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public long getTtlSeconds() {
            return ((StoreEntry) this.instance).getTtlSeconds();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public long getUpdatedAt() {
            return ((StoreEntry) this.instance).getUpdatedAt();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public String getUserId() {
            return ((StoreEntry) this.instance).getUserId();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public ByteString getUserIdBytes() {
            return ((StoreEntry) this.instance).getUserIdBytes();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public String getValue() {
            return ((StoreEntry) this.instance).getValue();
        }

        @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
        public ByteString getValueBytes() {
            return ((StoreEntry) this.instance).getValueBytes();
        }

        public Builder setAppId(String str) {
            copyOnWrite();
            ((StoreEntry) this.instance).setAppId(str);
            return this;
        }

        public Builder setAppIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreEntry) this.instance).setAppIdBytes(byteString);
            return this;
        }

        public Builder setCreatedAt(long j10) {
            copyOnWrite();
            ((StoreEntry) this.instance).setCreatedAt(j10);
            return this;
        }

        public Builder setExpiresAt(long j10) {
            copyOnWrite();
            ((StoreEntry) this.instance).setExpiresAt(j10);
            return this;
        }

        public Builder setKey(String str) {
            copyOnWrite();
            ((StoreEntry) this.instance).setKey(str);
            return this;
        }

        public Builder setKeyBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreEntry) this.instance).setKeyBytes(byteString);
            return this;
        }

        public Builder setScope(StoreScope storeScope) {
            copyOnWrite();
            ((StoreEntry) this.instance).setScope(storeScope);
            return this;
        }

        public Builder setScopeValue(int i10) {
            copyOnWrite();
            ((StoreEntry) this.instance).setScopeValue(i10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((StoreEntry) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreEntry) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setTtlSeconds(long j10) {
            copyOnWrite();
            ((StoreEntry) this.instance).setTtlSeconds(j10);
            return this;
        }

        public Builder setUpdatedAt(long j10) {
            copyOnWrite();
            ((StoreEntry) this.instance).setUpdatedAt(j10);
            return this;
        }

        public Builder setUserId(String str) {
            copyOnWrite();
            ((StoreEntry) this.instance).setUserId(str);
            return this;
        }

        public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreEntry) this.instance).setUserIdBytes(byteString);
            return this;
        }

        public Builder setValue(String str) {
            copyOnWrite();
            ((StoreEntry) this.instance).setValue(str);
            return this;
        }

        public Builder setValueBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreEntry) this.instance).setValueBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreEntry.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreEntry storeEntry = new StoreEntry();
        DEFAULT_INSTANCE = storeEntry;
        GeneratedMessageLite.registerDefaultInstance(StoreEntry.class, storeEntry);
    }

    private StoreEntry() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppId() {
        this.appId_ = getDefaultInstance().getAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExpiresAt() {
        this.expiresAt_ = 0L;
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
    public void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserId() {
        this.userId_ = getDefaultInstance().getUserId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static StoreEntry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreEntry parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreEntry) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreEntry parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreEntry> parser() {
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
    public void setCreatedAt(long j10) {
        this.createdAt_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpiresAt(long j10) {
        this.expiresAt_ = j10;
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
    public void setUpdatedAt(long j10) {
        this.updatedAt_ = j10;
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
                return new StoreEntry();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0002\t\u0002\n\u0002", new Object[]{"scope_", "key_", "value_", "userId_", "sessionId_", "appId_", "createdAt_", "updatedAt_", "expiresAt_", "ttlSeconds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreEntry> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreEntry.class) {
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

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public String getAppId() {
        return this.appId_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public ByteString getAppIdBytes() {
        return ByteString.copyFromUtf8(this.appId_);
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public long getCreatedAt() {
        return this.createdAt_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public long getExpiresAt() {
        return this.expiresAt_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public String getKey() {
        return this.key_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public ByteString getKeyBytes() {
        return ByteString.copyFromUtf8(this.key_);
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public StoreScope getScope() {
        StoreScope storeScopeForNumber = StoreScope.forNumber(this.scope_);
        return storeScopeForNumber == null ? StoreScope.UNRECOGNIZED : storeScopeForNumber;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public int getScopeValue() {
        return this.scope_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public long getTtlSeconds() {
        return this.ttlSeconds_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public String getUserId() {
        return this.userId_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public ByteString getUserIdBytes() {
        return ByteString.copyFromUtf8(this.userId_);
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public String getValue() {
        return this.value_;
    }

    @Override // com.zyql.protobuf.common.StoreEntryOrBuilder
    public ByteString getValueBytes() {
        return ByteString.copyFromUtf8(this.value_);
    }

    public static Builder newBuilder(StoreEntry storeEntry) {
        return DEFAULT_INSTANCE.createBuilder(storeEntry);
    }

    public static StoreEntry parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreEntry) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreEntry parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreEntry parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreEntry parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreEntry parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreEntry parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreEntry parseFrom(InputStream inputStream) throws IOException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreEntry parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreEntry parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreEntry parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
