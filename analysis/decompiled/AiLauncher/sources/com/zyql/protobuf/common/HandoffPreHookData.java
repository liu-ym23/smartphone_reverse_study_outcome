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
public final class HandoffPreHookData extends GeneratedMessageLite<HandoffPreHookData, Builder> implements HandoffPreHookDataOrBuilder {
    public static final int CONTEXT_FIELD_NUMBER = 5;
    private static final HandoffPreHookData DEFAULT_INSTANCE;
    public static final int FROM_AGENT_ID_FIELD_NUMBER = 1;
    private static volatile Parser<HandoffPreHookData> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int TO_AGENT_ID_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> context_ = MapFieldLite.emptyMapField();
    private String fromAgentId_ = "";
    private String toAgentId_ = "";
    private String reason_ = "";
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.common.HandoffPreHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HandoffPreHookData, Builder> implements HandoffPreHookDataOrBuilder {
        public Builder clearContext() {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).getMutableContextMap().clear();
            return this;
        }

        public Builder clearFromAgentId() {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).clearFromAgentId();
            return this;
        }

        public Builder clearReason() {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).clearReason();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).clearSessionId();
            return this;
        }

        public Builder clearToAgentId() {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).clearToAgentId();
            return this;
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public boolean containsContext(String str) {
            str.getClass();
            return ((HandoffPreHookData) this.instance).getContextMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        @Deprecated
        public Map<String, String> getContext() {
            return getContextMap();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public int getContextCount() {
            return ((HandoffPreHookData) this.instance).getContextMap().size();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public Map<String, String> getContextMap() {
            return Collections.unmodifiableMap(((HandoffPreHookData) this.instance).getContextMap());
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public String getContextOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> contextMap = ((HandoffPreHookData) this.instance).getContextMap();
            return contextMap.containsKey(str) ? contextMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public String getContextOrThrow(String str) {
            str.getClass();
            Map<String, String> contextMap = ((HandoffPreHookData) this.instance).getContextMap();
            if (contextMap.containsKey(str)) {
                return contextMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public String getFromAgentId() {
            return ((HandoffPreHookData) this.instance).getFromAgentId();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public ByteString getFromAgentIdBytes() {
            return ((HandoffPreHookData) this.instance).getFromAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public String getReason() {
            return ((HandoffPreHookData) this.instance).getReason();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public ByteString getReasonBytes() {
            return ((HandoffPreHookData) this.instance).getReasonBytes();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public String getSessionId() {
            return ((HandoffPreHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((HandoffPreHookData) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public String getToAgentId() {
            return ((HandoffPreHookData) this.instance).getToAgentId();
        }

        @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
        public ByteString getToAgentIdBytes() {
            return ((HandoffPreHookData) this.instance).getToAgentIdBytes();
        }

        public Builder putAllContext(Map<String, String> map) {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).getMutableContextMap().putAll(map);
            return this;
        }

        public Builder putContext(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((HandoffPreHookData) this.instance).getMutableContextMap().put(str, str2);
            return this;
        }

        public Builder removeContext(String str) {
            str.getClass();
            copyOnWrite();
            ((HandoffPreHookData) this.instance).getMutableContextMap().remove(str);
            return this;
        }

        public Builder setFromAgentId(String str) {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setFromAgentId(str);
            return this;
        }

        public Builder setFromAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setFromAgentIdBytes(byteString);
            return this;
        }

        public Builder setReason(String str) {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setReason(str);
            return this;
        }

        public Builder setReasonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setReasonBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setToAgentId(String str) {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setToAgentId(str);
            return this;
        }

        public Builder setToAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HandoffPreHookData) this.instance).setToAgentIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(HandoffPreHookData.DEFAULT_INSTANCE);
        }
    }

    public static final class ContextDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ContextDefaultEntryHolder() {
        }
    }

    static {
        HandoffPreHookData handoffPreHookData = new HandoffPreHookData();
        DEFAULT_INSTANCE = handoffPreHookData;
        GeneratedMessageLite.registerDefaultInstance(HandoffPreHookData.class, handoffPreHookData);
    }

    private HandoffPreHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFromAgentId() {
        this.fromAgentId_ = getDefaultInstance().getFromAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToAgentId() {
        this.toAgentId_ = getDefaultInstance().getToAgentId();
    }

    public static HandoffPreHookData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableContextMap() {
        return internalGetMutableContext();
    }

    private MapFieldLite<String, String> internalGetContext() {
        return this.context_;
    }

    private MapFieldLite<String, String> internalGetMutableContext() {
        if (!this.context_.isMutable()) {
            this.context_ = this.context_.mutableCopy();
        }
        return this.context_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HandoffPreHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HandoffPreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HandoffPreHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HandoffPreHookData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public boolean containsContext(String str) {
        str.getClass();
        return internalGetContext().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new HandoffPreHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"fromAgentId_", "toAgentId_", "reason_", "sessionId_", "context_", ContextDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HandoffPreHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HandoffPreHookData.class) {
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

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public int getContextCount() {
        return internalGetContext().size();
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(internalGetContext());
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        return mapFieldLiteInternalGetContext.containsKey(str) ? mapFieldLiteInternalGetContext.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public String getContextOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetContext = internalGetContext();
        if (mapFieldLiteInternalGetContext.containsKey(str)) {
            return mapFieldLiteInternalGetContext.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public String getFromAgentId() {
        return this.fromAgentId_;
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public ByteString getFromAgentIdBytes() {
        return ByteString.copyFromUtf8(this.fromAgentId_);
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public String getReason() {
        return this.reason_;
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public ByteString getReasonBytes() {
        return ByteString.copyFromUtf8(this.reason_);
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public String getToAgentId() {
        return this.toAgentId_;
    }

    @Override // com.zyql.protobuf.common.HandoffPreHookDataOrBuilder
    public ByteString getToAgentIdBytes() {
        return ByteString.copyFromUtf8(this.toAgentId_);
    }

    public static Builder newBuilder(HandoffPreHookData handoffPreHookData) {
        return DEFAULT_INSTANCE.createBuilder(handoffPreHookData);
    }

    public static HandoffPreHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HandoffPreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HandoffPreHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HandoffPreHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HandoffPreHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HandoffPreHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HandoffPreHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HandoffPreHookData parseFrom(InputStream inputStream) throws IOException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HandoffPreHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HandoffPreHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HandoffPreHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HandoffPreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
