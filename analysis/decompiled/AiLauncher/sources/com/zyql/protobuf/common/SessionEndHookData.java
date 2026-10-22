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
public final class SessionEndHookData extends GeneratedMessageLite<SessionEndHookData, Builder> implements SessionEndHookDataOrBuilder {
    private static final SessionEndHookData DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 4;
    public static final int MESSAGE_COUNT_FIELD_NUMBER = 3;
    public static final int METADATA_FIELD_NUMBER = 5;
    private static volatile Parser<SessionEndHookData> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private long durationMs_;
    private int messageCount_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String sessionId_ = "";
    private String reason_ = "";

    /* renamed from: com.zyql.protobuf.common.SessionEndHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SessionEndHookData, Builder> implements SessionEndHookDataOrBuilder {
        public Builder clearDurationMs() {
            copyOnWrite();
            ((SessionEndHookData) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearMessageCount() {
            copyOnWrite();
            ((SessionEndHookData) this.instance).clearMessageCount();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((SessionEndHookData) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearReason() {
            copyOnWrite();
            ((SessionEndHookData) this.instance).clearReason();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((SessionEndHookData) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((SessionEndHookData) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public long getDurationMs() {
            return ((SessionEndHookData) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public int getMessageCount() {
            return ((SessionEndHookData) this.instance).getMessageCount();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public int getMetadataCount() {
            return ((SessionEndHookData) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((SessionEndHookData) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((SessionEndHookData) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((SessionEndHookData) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public String getReason() {
            return ((SessionEndHookData) this.instance).getReason();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public ByteString getReasonBytes() {
            return ((SessionEndHookData) this.instance).getReasonBytes();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public String getSessionId() {
            return ((SessionEndHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((SessionEndHookData) this.instance).getSessionIdBytes();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((SessionEndHookData) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((SessionEndHookData) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((SessionEndHookData) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((SessionEndHookData) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setMessageCount(int i10) {
            copyOnWrite();
            ((SessionEndHookData) this.instance).setMessageCount(i10);
            return this;
        }

        public Builder setReason(String str) {
            copyOnWrite();
            ((SessionEndHookData) this.instance).setReason(str);
            return this;
        }

        public Builder setReasonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SessionEndHookData) this.instance).setReasonBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((SessionEndHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SessionEndHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(SessionEndHookData.DEFAULT_INSTANCE);
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
        SessionEndHookData sessionEndHookData = new SessionEndHookData();
        DEFAULT_INSTANCE = sessionEndHookData;
        GeneratedMessageLite.registerDefaultInstance(SessionEndHookData.class, sessionEndHookData);
    }

    private SessionEndHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessageCount() {
        this.messageCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static SessionEndHookData getDefaultInstance() {
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

    public static SessionEndHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SessionEndHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SessionEndHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SessionEndHookData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageCount(int i10) {
        this.messageCount_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.reason_ = byteString.toStringUtf8();
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

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
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
                return new SessionEndHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004\u0002\u00052", new Object[]{"sessionId_", "reason_", "messageCount_", "durationMs_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SessionEndHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SessionEndHookData.class) {
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

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public int getMessageCount() {
        return this.messageCount_;
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public String getReason() {
        return this.reason_;
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public ByteString getReasonBytes() {
        return ByteString.copyFromUtf8(this.reason_);
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.SessionEndHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(SessionEndHookData sessionEndHookData) {
        return DEFAULT_INSTANCE.createBuilder(sessionEndHookData);
    }

    public static SessionEndHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SessionEndHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SessionEndHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SessionEndHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SessionEndHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SessionEndHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SessionEndHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SessionEndHookData parseFrom(InputStream inputStream) throws IOException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SessionEndHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SessionEndHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SessionEndHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SessionEndHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
