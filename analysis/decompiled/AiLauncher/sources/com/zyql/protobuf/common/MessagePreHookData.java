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
public final class MessagePreHookData extends GeneratedMessageLite<MessagePreHookData, Builder> implements MessagePreHookDataOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 2;
    public static final int CONTENT_FIELD_NUMBER = 4;
    private static final MessagePreHookData DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 5;
    private static volatile Parser<MessagePreHookData> PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 3;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String sessionId_ = "";
    private String agentId_ = "";
    private String role_ = "";
    private String content_ = "";

    /* renamed from: com.zyql.protobuf.common.MessagePreHookData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MessagePreHookData, Builder> implements MessagePreHookDataOrBuilder {
        public Builder clearAgentId() {
            copyOnWrite();
            ((MessagePreHookData) this.instance).clearAgentId();
            return this;
        }

        public Builder clearContent() {
            copyOnWrite();
            ((MessagePreHookData) this.instance).clearContent();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((MessagePreHookData) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearRole() {
            copyOnWrite();
            ((MessagePreHookData) this.instance).clearRole();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((MessagePreHookData) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((MessagePreHookData) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public String getAgentId() {
            return ((MessagePreHookData) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public ByteString getAgentIdBytes() {
            return ((MessagePreHookData) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public String getContent() {
            return ((MessagePreHookData) this.instance).getContent();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public ByteString getContentBytes() {
            return ((MessagePreHookData) this.instance).getContentBytes();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public int getMetadataCount() {
            return ((MessagePreHookData) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((MessagePreHookData) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((MessagePreHookData) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((MessagePreHookData) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public String getRole() {
            return ((MessagePreHookData) this.instance).getRole();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public ByteString getRoleBytes() {
            return ((MessagePreHookData) this.instance).getRoleBytes();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public String getSessionId() {
            return ((MessagePreHookData) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ((MessagePreHookData) this.instance).getSessionIdBytes();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((MessagePreHookData) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((MessagePreHookData) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((MessagePreHookData) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setContent(String str) {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setContent(str);
            return this;
        }

        public Builder setContentBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setContentBytes(byteString);
            return this;
        }

        public Builder setRole(String str) {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setRole(str);
            return this;
        }

        public Builder setRoleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setRoleBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((MessagePreHookData) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(MessagePreHookData.DEFAULT_INSTANCE);
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
        MessagePreHookData messagePreHookData = new MessagePreHookData();
        DEFAULT_INSTANCE = messagePreHookData;
        GeneratedMessageLite.registerDefaultInstance(MessagePreHookData.class, messagePreHookData);
    }

    private MessagePreHookData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRole() {
        this.role_ = getDefaultInstance().getRole();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static MessagePreHookData getDefaultInstance() {
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

    public static MessagePreHookData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MessagePreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagePreHookData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MessagePreHookData> parser() {
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
    public void setContent(String str) {
        str.getClass();
        this.content_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.content_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRole(String str) {
        str.getClass();
        this.role_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.role_ = byteString.toStringUtf8();
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

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
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
                return new MessagePreHookData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"sessionId_", "agentId_", "role_", "content_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagePreHookData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MessagePreHookData.class) {
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

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public String getContent() {
        return this.content_;
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public String getRole() {
        return this.role_;
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public ByteString getRoleBytes() {
        return ByteString.copyFromUtf8(this.role_);
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.MessagePreHookDataOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(MessagePreHookData messagePreHookData) {
        return DEFAULT_INSTANCE.createBuilder(messagePreHookData);
    }

    public static MessagePreHookData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MessagePreHookData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MessagePreHookData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MessagePreHookData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MessagePreHookData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MessagePreHookData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagePreHookData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MessagePreHookData parseFrom(InputStream inputStream) throws IOException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagePreHookData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MessagePreHookData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MessagePreHookData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MessagePreHookData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
