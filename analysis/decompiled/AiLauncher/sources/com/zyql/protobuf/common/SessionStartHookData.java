package com.zyql.protobuf.common;

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
public final class SessionStartHookData extends GeneratedMessageLite<SessionStartHookData, Builder> implements SessionStartHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 4;
    public static final int APP_ID_FIELD_NUMBER = 2;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final SessionStartHookData DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile Parser<SessionStartHookData> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private long createdAt_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String sessionId_ = "";
    private String appId_ = "";
    private String userId_ = "";
    private String agentId_ = "";

    /* renamed from: com.zyql.protobuf.common.SessionStartHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SessionStartHookData, Builder> implements SessionStartHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((SessionStartHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearAppId() {
            copyOnWrite();
            ((SessionStartHookData) this.instance).clearAppId();
            return this;
        }

        public Builder clearCreatedAt() {
            copyOnWrite();
            ((SessionStartHookData) this.instance).clearCreatedAt();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((SessionStartHookData) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((SessionStartHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            ((SessionStartHookData) this.instance).clearUserId();
            return this;
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((SessionStartHookData) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public String getAgentId() {
            return ((SessionStartHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((SessionStartHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public String getAppId() {
            return ((SessionStartHookData) this.instance).getAppId();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public ByteString getAppIdBytes() {
            return ((SessionStartHookData) this.instance).getAppIdBytes();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public long getCreatedAt() {
            return ((SessionStartHookData) this.instance).getCreatedAt();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public int getMetadataCount() {
            return ((SessionStartHookData) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((SessionStartHookData) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((SessionStartHookData) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((SessionStartHookData) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public String getSessionId() {
            return ((SessionStartHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((SessionStartHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public String getUserId() {
            return ((SessionStartHookData) this.instance).getUserId();
        }

        @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
        public ByteString getUserIdBytes() {
            return ((SessionStartHookData) this.instance).getUserIdBytes();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((SessionStartHookData) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((SessionStartHookData) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((SessionStartHookData) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setAppId(String str) {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setAppId(str);
            return this;
        }

        public Builder setAppIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setAppIdBytes(byteString);
            return this;
        }

        public Builder setCreatedAt(long j10) {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setCreatedAt(j10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setUserId(String str) {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setUserId(str);
            return this;
        }

        public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SessionStartHookData) this.instance).setUserIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(SessionStartHookData.DEFAULT_INSTANCE);
        }
    }

    public static final class MetadataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetadataDefaultEntryHolder() {
        }
    }

    static {
        SessionStartHookData sessionStartHookData = new SessionStartHookData();
        DEFAULT_INSTANCE = sessionStartHookData;
        GeneratedMessageLite.registerDefaultInstance(SessionStartHookData.class, sessionStartHookData);
    }

    private SessionStartHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
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
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserId() {
        this.userId_ = getDefaultInstance().getUserId();
    }

    public static SessionStartHookData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SessionStartHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SessionStartHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SessionStartHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SessionStartHookData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentId(String str) {
        str.getClass();
        this.agentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentId_ = byteString.toStringUtf8();
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

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new SessionStartHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0002\u00062", new Object[]{"sessionId_", "appId_", "userId_", "agentId_", "createdAt_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SessionStartHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SessionStartHookData.class) {
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

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public String getAppId() {
        return this.appId_;
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public ByteString getAppIdBytes() {
        return ByteString.copyFromUtf8(this.appId_);
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public long getCreatedAt() {
        return this.createdAt_;
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public String getUserId() {
        return this.userId_;
    }

    @Override // com.zyql.protobuf.common.SessionStartHookDataOrBuilder
    public ByteString getUserIdBytes() {
        return ByteString.copyFromUtf8(this.userId_);
    }

    public static Builder newBuilder(SessionStartHookData sessionStartHookData) {
        return DEFAULT_INSTANCE.createBuilder(sessionStartHookData);
    }

    public static SessionStartHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SessionStartHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SessionStartHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SessionStartHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SessionStartHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SessionStartHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SessionStartHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SessionStartHookData parseFrom(InputStream inputStream) throws IOException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SessionStartHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SessionStartHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SessionStartHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SessionStartHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
