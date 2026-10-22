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
public final class HookInvocation extends GeneratedMessageLite<HookInvocation, Builder> implements HookInvocationOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 7;
    private static final HookInvocation DEFAULT_INSTANCE;
    public static final int HOOK_DATA_FIELD_NUMBER = 8;
    public static final int HOOK_ID_FIELD_NUMBER = 2;
    public static final int HOOK_POINT_FIELD_NUMBER = 3;
    public static final int INVOCATION_ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 9;
    private static volatile Parser<HookInvocation> PARSER = null;
    public static final int RUN_ID_FIELD_NUMBER = 6;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private int hookPoint_;
    private long timestamp_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String invocationId_ = "";
    private String hookId_ = "";
    private String sessionId_ = "";
    private String runId_ = "";
    private String agentId_ = "";
    private ByteString hookData_ = ByteString.EMPTY;

    /* renamed from: com.zyql.protobuf.common.HookInvocation$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HookInvocation, Builder> implements HookInvocationOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearAgentId();
            return this;
        }

        public Builder clearHookData() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearHookData();
            return this;
        }

        public Builder clearHookId() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearHookId();
            return this;
        }

        public Builder clearHookPoint() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearHookPoint();
            return this;
        }

        public Builder clearInvocationId() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearInvocationId();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((HookInvocation) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearRunId() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearRunId();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearSessionId();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((HookInvocation) this.instance).clearTimestamp();
            return this;
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((HookInvocation) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getAgentId() {
            return ((HookInvocation) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public ByteString getAgentIdBytes() {
            return ((HookInvocation) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public ByteString getHookData() {
            return ((HookInvocation) this.instance).getHookData();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getHookId() {
            return ((HookInvocation) this.instance).getHookId();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public ByteString getHookIdBytes() {
            return ((HookInvocation) this.instance).getHookIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public HookPoint getHookPoint() {
            return ((HookInvocation) this.instance).getHookPoint();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public int getHookPointValue() {
            return ((HookInvocation) this.instance).getHookPointValue();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getInvocationId() {
            return ((HookInvocation) this.instance).getInvocationId();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public ByteString getInvocationIdBytes() {
            return ((HookInvocation) this.instance).getInvocationIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public int getMetadataCount() {
            return ((HookInvocation) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((HookInvocation) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((HookInvocation) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((HookInvocation) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getRunId() {
            return ((HookInvocation) this.instance).getRunId();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public ByteString getRunIdBytes() {
            return ((HookInvocation) this.instance).getRunIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public String getSessionId() {
            return ((HookInvocation) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public ByteString getSessionIdBytes() {
            return ((HookInvocation) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
        public long getTimestamp() {
            return ((HookInvocation) this.instance).getTimestamp();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((HookInvocation) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((HookInvocation) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((HookInvocation) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((HookInvocation) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookInvocation) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setHookData(ByteString byteString) {
            copyOnWrite();
            ((HookInvocation) this.instance).setHookData(byteString);
            return this;
        }

        public Builder setHookId(String str) {
            copyOnWrite();
            ((HookInvocation) this.instance).setHookId(str);
            return this;
        }

        public Builder setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookInvocation) this.instance).setHookIdBytes(byteString);
            return this;
        }

        public Builder setHookPoint(HookPoint hookPoint) {
            copyOnWrite();
            ((HookInvocation) this.instance).setHookPoint(hookPoint);
            return this;
        }

        public Builder setHookPointValue(int i10) {
            copyOnWrite();
            ((HookInvocation) this.instance).setHookPointValue(i10);
            return this;
        }

        public Builder setInvocationId(String str) {
            copyOnWrite();
            ((HookInvocation) this.instance).setInvocationId(str);
            return this;
        }

        public Builder setInvocationIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookInvocation) this.instance).setInvocationIdBytes(byteString);
            return this;
        }

        public Builder setRunId(String str) {
            copyOnWrite();
            ((HookInvocation) this.instance).setRunId(str);
            return this;
        }

        public Builder setRunIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookInvocation) this.instance).setRunIdBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((HookInvocation) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookInvocation) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((HookInvocation) this.instance).setTimestamp(j10);
            return this;
        }

        private Builder() {
            super(HookInvocation.DEFAULT_INSTANCE);
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
        HookInvocation hookInvocation = new HookInvocation();
        DEFAULT_INSTANCE = hookInvocation;
        GeneratedMessageLite.registerDefaultInstance(HookInvocation.class, hookInvocation);
    }

    private HookInvocation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookData() {
        this.hookData_ = getDefaultInstance().getHookData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookId() {
        this.hookId_ = getDefaultInstance().getHookId();
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
    public void clearRunId() {
        this.runId_ = getDefaultInstance().getRunId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static HookInvocation getDefaultInstance() {
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

    public static HookInvocation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HookInvocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookInvocation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HookInvocation> parser() {
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
    public void setHookData(ByteString byteString) {
        byteString.getClass();
        this.hookData_ = byteString;
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
    public void setTimestamp(long j10) {
        this.timestamp_ = j10;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
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
                return new HookInvocation();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\u0002\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\n\t2", new Object[]{"invocationId_", "hookId_", "hookPoint_", "timestamp_", "sessionId_", "runId_", "agentId_", "hookData_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HookInvocation> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HookInvocation.class) {
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

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public ByteString getHookData() {
        return this.hookData_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getHookId() {
        return this.hookId_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public ByteString getHookIdBytes() {
        return ByteString.copyFromUtf8(this.hookId_);
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public HookPoint getHookPoint() {
        HookPoint hookPointForNumber = HookPoint.forNumber(this.hookPoint_);
        return hookPointForNumber == null ? HookPoint.UNRECOGNIZED : hookPointForNumber;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public int getHookPointValue() {
        return this.hookPoint_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getInvocationId() {
        return this.invocationId_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public ByteString getInvocationIdBytes() {
        return ByteString.copyFromUtf8(this.invocationId_);
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getRunId() {
        return this.runId_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public ByteString getRunIdBytes() {
        return ByteString.copyFromUtf8(this.runId_);
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.HookInvocationOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    public static Builder newBuilder(HookInvocation hookInvocation) {
        return DEFAULT_INSTANCE.createBuilder(hookInvocation);
    }

    public static HookInvocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookInvocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookInvocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HookInvocation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HookInvocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HookInvocation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HookInvocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HookInvocation parseFrom(InputStream inputStream) throws IOException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookInvocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookInvocation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HookInvocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookInvocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
