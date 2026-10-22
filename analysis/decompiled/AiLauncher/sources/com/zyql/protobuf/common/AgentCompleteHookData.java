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
public final class AgentCompleteHookData extends GeneratedMessageLite<AgentCompleteHookData, Builder> implements AgentCompleteHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    private static final AgentCompleteHookData DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int METADATA_FIELD_NUMBER = 8;
    public static final int OUTPUT_TEXT_FIELD_NUMBER = 5;
    private static volatile Parser<AgentCompleteHookData> PARSER = null;
    public static final int RUN_ID_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int TURNS_TAKEN_FIELD_NUMBER = 6;
    private long durationMs_;
    private int turnsTaken_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String agentId_ = "";
    private String agentName_ = "";
    private String sessionId_ = "";
    private String runId_ = "";
    private String outputText_ = "";

    /* renamed from: com.zyql.protobuf.common.AgentCompleteHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AgentCompleteHookData, Builder> implements AgentCompleteHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearAgentName() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearAgentName();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearOutputText() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearOutputText();
            return this;
        }

        public Builder clearRunId() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearRunId();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearTurnsTaken() {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).clearTurnsTaken();
            return this;
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((AgentCompleteHookData) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getAgentId() {
            return ((AgentCompleteHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((AgentCompleteHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getAgentName() {
            return ((AgentCompleteHookData) this.instance).getAgentName();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public ByteString getAgentNameBytes() {
            return ((AgentCompleteHookData) this.instance).getAgentNameBytes();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public long getDurationMs() {
            return ((AgentCompleteHookData) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public int getMetadataCount() {
            return ((AgentCompleteHookData) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((AgentCompleteHookData) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((AgentCompleteHookData) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((AgentCompleteHookData) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getOutputText() {
            return ((AgentCompleteHookData) this.instance).getOutputText();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public ByteString getOutputTextBytes() {
            return ((AgentCompleteHookData) this.instance).getOutputTextBytes();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getRunId() {
            return ((AgentCompleteHookData) this.instance).getRunId();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public ByteString getRunIdBytes() {
            return ((AgentCompleteHookData) this.instance).getRunIdBytes();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public String getSessionId() {
            return ((AgentCompleteHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((AgentCompleteHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
        public int getTurnsTaken() {
            return ((AgentCompleteHookData) this.instance).getTurnsTaken();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setAgentName(String str) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setAgentName(str);
            return this;
        }

        public Builder setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setAgentNameBytes(byteString);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setOutputText(String str) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setOutputText(str);
            return this;
        }

        public Builder setOutputTextBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setOutputTextBytes(byteString);
            return this;
        }

        public Builder setRunId(String str) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setRunId(str);
            return this;
        }

        public Builder setRunIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setRunIdBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setTurnsTaken(int i10) {
            copyOnWrite();
            ((AgentCompleteHookData) this.instance).setTurnsTaken(i10);
            return this;
        }

        private Builder() {
            super(AgentCompleteHookData.DEFAULT_INSTANCE);
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
        AgentCompleteHookData agentCompleteHookData = new AgentCompleteHookData();
        DEFAULT_INSTANCE = agentCompleteHookData;
        GeneratedMessageLite.registerDefaultInstance(AgentCompleteHookData.class, agentCompleteHookData);
    }

    private AgentCompleteHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutputText() {
        this.outputText_ = getDefaultInstance().getOutputText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRunId() {
        this.runId_ = getDefaultInstance().getRunId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnsTaken() {
        this.turnsTaken_ = 0;
    }

    public static AgentCompleteHookData getDefaultInstance() {
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

    public static AgentCompleteHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentCompleteHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AgentCompleteHookData> parser() {
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
    public void setAgentName(String str) {
        str.getClass();
        this.agentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputText(String str) {
        str.getClass();
        this.outputText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputTextBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.outputText_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRunId(String str) {
        str.getClass();
        this.runId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRunIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.runId_ = byteString.toStringUtf8();
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
    public void setTurnsTaken(int i10) {
        this.turnsTaken_ = i10;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
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
                return new AgentCompleteHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007\u0002\b2", new Object[]{"agentId_", "agentName_", "sessionId_", "runId_", "outputText_", "turnsTaken_", "durationMs_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AgentCompleteHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AgentCompleteHookData.class) {
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

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getAgentName() {
        return this.agentName_;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public ByteString getAgentNameBytes() {
        return ByteString.copyFromUtf8(this.agentName_);
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getOutputText() {
        return this.outputText_;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public ByteString getOutputTextBytes() {
        return ByteString.copyFromUtf8(this.outputText_);
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getRunId() {
        return this.runId_;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public ByteString getRunIdBytes() {
        return ByteString.copyFromUtf8(this.runId_);
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.AgentCompleteHookDataOrBuilder
    public int getTurnsTaken() {
        return this.turnsTaken_;
    }

    public static Builder newBuilder(AgentCompleteHookData agentCompleteHookData) {
        return DEFAULT_INSTANCE.createBuilder(agentCompleteHookData);
    }

    public static AgentCompleteHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentCompleteHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AgentCompleteHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AgentCompleteHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AgentCompleteHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AgentCompleteHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AgentCompleteHookData parseFrom(InputStream inputStream) throws IOException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentCompleteHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentCompleteHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AgentCompleteHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentCompleteHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
