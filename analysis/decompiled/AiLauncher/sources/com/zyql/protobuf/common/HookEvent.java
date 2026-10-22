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
public final class HookEvent extends GeneratedMessageLite<HookEvent, Builder> implements HookEventOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 6;
    public static final int BLOCKED_EXECUTION_FIELD_NUMBER = 9;
    private static final HookEvent DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 11;
    public static final int ERROR_FIELD_NUMBER = 12;
    public static final int HOOK_ID_FIELD_NUMBER = 1;
    public static final int HOOK_NAME_FIELD_NUMBER = 2;
    public static final int HOOK_POINT_FIELD_NUMBER = 3;
    public static final int INVOCATION_ID_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 13;
    public static final int MODIFIED_DATA_FIELD_NUMBER = 10;
    private static volatile Parser<HookEvent> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int SUCCESS_FIELD_NUMBER = 8;
    public static final int TIMESTAMP_FIELD_NUMBER = 7;
    private boolean blockedExecution_;
    private long durationMs_;
    private int hookPoint_;
    private boolean modifiedData_;
    private boolean success_;
    private long timestamp_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String hookId_ = "";
    private String hookName_ = "";
    private String invocationId_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";
    private String error_ = "";

    /* renamed from: com.zyql.protobuf.common.HookEvent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HookEvent, Builder> implements HookEventOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((HookEvent) this.instance).clearAgentId();
            return this;
        }

        public Builder clearBlockedExecution() {
            copyOnWrite();
            ((HookEvent) this.instance).clearBlockedExecution();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((HookEvent) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((HookEvent) this.instance).clearError();
            return this;
        }

        public Builder clearHookId() {
            copyOnWrite();
            ((HookEvent) this.instance).clearHookId();
            return this;
        }

        public Builder clearHookName() {
            copyOnWrite();
            ((HookEvent) this.instance).clearHookName();
            return this;
        }

        public Builder clearHookPoint() {
            copyOnWrite();
            ((HookEvent) this.instance).clearHookPoint();
            return this;
        }

        public Builder clearInvocationId() {
            copyOnWrite();
            ((HookEvent) this.instance).clearInvocationId();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((HookEvent) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearModifiedData() {
            copyOnWrite();
            ((HookEvent) this.instance).clearModifiedData();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((HookEvent) this.instance).clearSessionId();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((HookEvent) this.instance).clearSuccess();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((HookEvent) this.instance).clearTimestamp();
            return this;
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((HookEvent) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getAgentId() {
            return ((HookEvent) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public ByteString getAgentIdBytes() {
            return ((HookEvent) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public boolean getBlockedExecution() {
            return ((HookEvent) this.instance).getBlockedExecution();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public long getDurationMs() {
            return ((HookEvent) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getError() {
            return ((HookEvent) this.instance).getError();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public ByteString getErrorBytes() {
            return ((HookEvent) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getHookId() {
            return ((HookEvent) this.instance).getHookId();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public ByteString getHookIdBytes() {
            return ((HookEvent) this.instance).getHookIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getHookName() {
            return ((HookEvent) this.instance).getHookName();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public ByteString getHookNameBytes() {
            return ((HookEvent) this.instance).getHookNameBytes();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public HookPoint getHookPoint() {
            return ((HookEvent) this.instance).getHookPoint();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public int getHookPointValue() {
            return ((HookEvent) this.instance).getHookPointValue();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getInvocationId() {
            return ((HookEvent) this.instance).getInvocationId();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public ByteString getInvocationIdBytes() {
            return ((HookEvent) this.instance).getInvocationIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public int getMetadataCount() {
            return ((HookEvent) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((HookEvent) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((HookEvent) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((HookEvent) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public boolean getModifiedData() {
            return ((HookEvent) this.instance).getModifiedData();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public String getSessionId() {
            return ((HookEvent) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public ByteString getSessionIdBytes() {
            return ((HookEvent) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public boolean getSuccess() {
            return ((HookEvent) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.common.HookEventOrBuilder
        public long getTimestamp() {
            return ((HookEvent) this.instance).getTimestamp();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((HookEvent) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((HookEvent) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((HookEvent) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((HookEvent) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookEvent) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setBlockedExecution(boolean z10) {
            copyOnWrite();
            ((HookEvent) this.instance).setBlockedExecution(z10);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((HookEvent) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((HookEvent) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookEvent) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setHookId(String str) {
            copyOnWrite();
            ((HookEvent) this.instance).setHookId(str);
            return this;
        }

        public Builder setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookEvent) this.instance).setHookIdBytes(byteString);
            return this;
        }

        public Builder setHookName(String str) {
            copyOnWrite();
            ((HookEvent) this.instance).setHookName(str);
            return this;
        }

        public Builder setHookNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookEvent) this.instance).setHookNameBytes(byteString);
            return this;
        }

        public Builder setHookPoint(HookPoint hookPoint) {
            copyOnWrite();
            ((HookEvent) this.instance).setHookPoint(hookPoint);
            return this;
        }

        public Builder setHookPointValue(int i10) {
            copyOnWrite();
            ((HookEvent) this.instance).setHookPointValue(i10);
            return this;
        }

        public Builder setInvocationId(String str) {
            copyOnWrite();
            ((HookEvent) this.instance).setInvocationId(str);
            return this;
        }

        public Builder setInvocationIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookEvent) this.instance).setInvocationIdBytes(byteString);
            return this;
        }

        public Builder setModifiedData(boolean z10) {
            copyOnWrite();
            ((HookEvent) this.instance).setModifiedData(z10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((HookEvent) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookEvent) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((HookEvent) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((HookEvent) this.instance).setTimestamp(j10);
            return this;
        }

        private Builder() {
            super(HookEvent.DEFAULT_INSTANCE);
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
        HookEvent hookEvent = new HookEvent();
        DEFAULT_INSTANCE = hookEvent;
        GeneratedMessageLite.registerDefaultInstance(HookEvent.class, hookEvent);
    }

    private HookEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBlockedExecution() {
        this.blockedExecution_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookId() {
        this.hookId_ = getDefaultInstance().getHookId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookName() {
        this.hookName_ = getDefaultInstance().getHookName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookPoint() {
        this.hookPoint_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInvocationId() {
        this.invocationId_ = getDefaultInstance().getInvocationId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModifiedData() {
        this.modifiedData_ = false;
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
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static HookEvent getDefaultInstance() {
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

    public static HookEvent parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HookEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookEvent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HookEvent> parser() {
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
    public void setBlockedExecution(boolean z10) {
        this.blockedExecution_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookId(String str) {
        str.getClass();
        this.hookId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.hookId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookName(String str) {
        str.getClass();
        this.hookName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.hookName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookPoint(HookPoint hookPoint) {
        this.hookPoint_ = hookPoint.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookPointValue(int i10) {
        this.hookPoint_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInvocationId(String str) {
        str.getClass();
        this.invocationId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInvocationIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.invocationId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModifiedData(boolean z10) {
        this.modifiedData_ = z10;
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
    public void setTimestamp(long j10) {
        this.timestamp_ = j10;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HookEvent();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0007\t\u0007\n\u0007\u000b\u0002\fȈ\r2", new Object[]{"hookId_", "hookName_", "hookPoint_", "invocationId_", "sessionId_", "agentId_", "timestamp_", "success_", "blockedExecution_", "modifiedData_", "durationMs_", "error_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HookEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HookEvent.class) {
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

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public boolean getBlockedExecution() {
        return this.blockedExecution_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getHookId() {
        return this.hookId_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public ByteString getHookIdBytes() {
        return ByteString.copyFromUtf8(this.hookId_);
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getHookName() {
        return this.hookName_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public ByteString getHookNameBytes() {
        return ByteString.copyFromUtf8(this.hookName_);
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public HookPoint getHookPoint() {
        HookPoint hookPointForNumber = HookPoint.forNumber(this.hookPoint_);
        return hookPointForNumber == null ? HookPoint.UNRECOGNIZED : hookPointForNumber;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public int getHookPointValue() {
        return this.hookPoint_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getInvocationId() {
        return this.invocationId_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public ByteString getInvocationIdBytes() {
        return ByteString.copyFromUtf8(this.invocationId_);
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public boolean getModifiedData() {
        return this.modifiedData_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.common.HookEventOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    public static Builder newBuilder(HookEvent hookEvent) {
        return DEFAULT_INSTANCE.createBuilder(hookEvent);
    }

    public static HookEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HookEvent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HookEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HookEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HookEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HookEvent parseFrom(InputStream inputStream) throws IOException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookEvent parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HookEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
