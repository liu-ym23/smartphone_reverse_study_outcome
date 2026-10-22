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
public final class HandoffPostHookData extends GeneratedMessageLite<HandoffPostHookData, Builder> implements HandoffPostHookDataOrBuilder {
    private static final HandoffPostHookData DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 5;
    public static final int FROM_AGENT_ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile Parser<HandoffPostHookData> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    public static final int TO_AGENT_ID_FIELD_NUMBER = 2;
    private long durationMs_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String fromAgentId_ = "";
    private String toAgentId_ = "";
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.common.HandoffPostHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HandoffPostHookData, Builder> implements HandoffPostHookDataOrBuilder {
        public Builder clearDurationMs() {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearFromAgentId() {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).clearFromAgentId();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).clearSuccess();
            return this;
        }

        public Builder clearToAgentId() {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).clearToAgentId();
            return this;
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((HandoffPostHookData) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public long getDurationMs() {
            return ((HandoffPostHookData) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public String getFromAgentId() {
            return ((HandoffPostHookData) this.instance).getFromAgentId();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public ByteString getFromAgentIdBytes() {
            return ((HandoffPostHookData) this.instance).getFromAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public int getMetadataCount() {
            return ((HandoffPostHookData) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((HandoffPostHookData) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((HandoffPostHookData) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((HandoffPostHookData) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public String getSessionId() {
            return ((HandoffPostHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((HandoffPostHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public boolean getSuccess() {
            return ((HandoffPostHookData) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public String getToAgentId() {
            return ((HandoffPostHookData) this.instance).getToAgentId();
        }

        @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
        public ByteString getToAgentIdBytes() {
            return ((HandoffPostHookData) this.instance).getToAgentIdBytes();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((HandoffPostHookData) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((HandoffPostHookData) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setFromAgentId(String str) {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setFromAgentId(str);
            return this;
        }

        public Builder setFromAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setFromAgentIdBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setToAgentId(String str) {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setToAgentId(str);
            return this;
        }

        public Builder setToAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPostHookData) this.instance).setToAgentIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(HandoffPostHookData.DEFAULT_INSTANCE);
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
        HandoffPostHookData handoffPostHookData = new HandoffPostHookData();
        DEFAULT_INSTANCE = handoffPostHookData;
        GeneratedMessageLite.registerDefaultInstance(HandoffPostHookData.class, handoffPostHookData);
    }

    private HandoffPostHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFromAgentId() {
        this.fromAgentId_ = getDefaultInstance().getFromAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToAgentId() {
        this.toAgentId_ = getDefaultInstance().getToAgentId();
    }

    public static HandoffPostHookData getDefaultInstance() {
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

    public static HandoffPostHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HandoffPostHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HandoffPostHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HandoffPostHookData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFromAgentId(String str) {
        str.getClass();
        this.fromAgentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFromAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.fromAgentId_ = byteString.toStringUtf8();
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
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToAgentId(String str) {
        str.getClass();
        this.toAgentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.toAgentId_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
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
                return new HandoffPostHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0002\u00062", new Object[]{"fromAgentId_", "toAgentId_", "success_", "sessionId_", "durationMs_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HandoffPostHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HandoffPostHookData.class) {
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

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public String getFromAgentId() {
        return this.fromAgentId_;
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public ByteString getFromAgentIdBytes() {
        return ByteString.copyFromUtf8(this.fromAgentId_);
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public String getToAgentId() {
        return this.toAgentId_;
    }

    @Override // com.zyql.protobuf.common.HandoffPostHookDataOrBuilder
    public ByteString getToAgentIdBytes() {
        return ByteString.copyFromUtf8(this.toAgentId_);
    }

    public static Builder newBuilder(HandoffPostHookData handoffPostHookData) {
        return DEFAULT_INSTANCE.createBuilder(handoffPostHookData);
    }

    public static HandoffPostHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HandoffPostHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HandoffPostHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HandoffPostHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HandoffPostHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HandoffPostHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HandoffPostHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HandoffPostHookData parseFrom(InputStream inputStream) throws IOException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HandoffPostHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HandoffPostHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HandoffPostHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HandoffPostHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
