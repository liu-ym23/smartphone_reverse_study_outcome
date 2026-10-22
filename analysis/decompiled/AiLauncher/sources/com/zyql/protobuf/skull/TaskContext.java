package com.zyql.protobuf.skull;

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
public final class TaskContext extends GeneratedMessageLite<TaskContext, Builder> implements TaskContextOrBuilder {
    public static final int CONTEXT_ID_FIELD_NUMBER = 1;
    private static final TaskContext DEFAULT_INSTANCE;
    public static final int META_FIELD_NUMBER = 3;
    private static volatile Parser<TaskContext> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> meta_ = MapFieldLite.emptyMapField();
    private String contextId_ = "";
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.skull.TaskContext$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TaskContext, Builder> implements TaskContextOrBuilder {
        public Builder clearContextId() {
            copyOnWrite();
            ((TaskContext) this.instance).clearContextId();
            return this;
        }

        public Builder clearMeta() {
            copyOnWrite();
            ((TaskContext) this.instance).getMutableMetaMap().clear();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((TaskContext) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public boolean containsMeta(String str) {
            str.getClass();
            return ((TaskContext) this.instance).getMetaMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public String getContextId() {
            return ((TaskContext) this.instance).getContextId();
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public ByteString getContextIdBytes() {
            return ((TaskContext) this.instance).getContextIdBytes();
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        @Deprecated
        public Map<String, String> getMeta() {
            return getMetaMap();
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public int getMetaCount() {
            return ((TaskContext) this.instance).getMetaMap().size();
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public Map<String, String> getMetaMap() {
            return Collections.unmodifiableMap(((TaskContext) this.instance).getMetaMap());
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public String getMetaOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metaMap = ((TaskContext) this.instance).getMetaMap();
            return metaMap.containsKey(str) ? metaMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public String getMetaOrThrow(String str) {
            str.getClass();
            Map<String, String> metaMap = ((TaskContext) this.instance).getMetaMap();
            if (metaMap.containsKey(str)) {
                return metaMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public String getSessionId() {
            return ((TaskContext) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
        public ByteString getSessionIdBytes() {
            return ((TaskContext) this.instance).getSessionIdBytes();
        }

        public Builder putAllMeta(Map<String, String> map) {
            copyOnWrite();
            ((TaskContext) this.instance).getMutableMetaMap().putAll(map);
            return this;
        }

        public Builder putMeta(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((TaskContext) this.instance).getMutableMetaMap().put(str, str2);
            return this;
        }

        public Builder removeMeta(String str) {
            str.getClass();
            copyOnWrite();
            ((TaskContext) this.instance).getMutableMetaMap().remove(str);
            return this;
        }

        public Builder setContextId(String str) {
            copyOnWrite();
            ((TaskContext) this.instance).setContextId(str);
            return this;
        }

        public Builder setContextIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((TaskContext) this.instance).setContextIdBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((TaskContext) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((TaskContext) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(TaskContext.DEFAULT_INSTANCE);
        }
    }

    public static final class MetaDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetaDefaultEntryHolder() {
        }
    }

    static {
        TaskContext taskContext = new TaskContext();
        DEFAULT_INSTANCE = taskContext;
        GeneratedMessageLite.registerDefaultInstance(TaskContext.class, taskContext);
    }

    private TaskContext() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContextId() {
        this.contextId_ = getDefaultInstance().getContextId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static TaskContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetaMap() {
        return internalGetMutableMeta();
    }

    private MapFieldLite<String, String> internalGetMeta() {
        return this.meta_;
    }

    private MapFieldLite<String, String> internalGetMutableMeta() {
        if (!this.meta_.isMutable()) {
            this.meta_ = this.meta_.mutableCopy();
        }
        return this.meta_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TaskContext parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TaskContext) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskContext parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TaskContext> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContextId(String str) {
        str.getClass();
        this.contextId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContextIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.contextId_ = byteString.toStringUtf8();
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

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public boolean containsMeta(String str) {
        str.getClass();
        return internalGetMeta().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new TaskContext();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"contextId_", "sessionId_", "meta_", MetaDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TaskContext> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TaskContext.class) {
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

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public String getContextId() {
        return this.contextId_;
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public ByteString getContextIdBytes() {
        return ByteString.copyFromUtf8(this.contextId_);
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    @Deprecated
    public Map<String, String> getMeta() {
        return getMetaMap();
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public int getMetaCount() {
        return internalGetMeta().size();
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(internalGetMeta());
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMeta = internalGetMeta();
        return mapFieldLiteInternalGetMeta.containsKey(str) ? mapFieldLiteInternalGetMeta.get(str) : str2;
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public String getMetaOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMeta = internalGetMeta();
        if (mapFieldLiteInternalGetMeta.containsKey(str)) {
            return mapFieldLiteInternalGetMeta.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.skull.TaskContextOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(TaskContext taskContext) {
        return DEFAULT_INSTANCE.createBuilder(taskContext);
    }

    public static TaskContext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskContext) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskContext parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TaskContext parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TaskContext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TaskContext parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TaskContext parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TaskContext parseFrom(InputStream inputStream) throws IOException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskContext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskContext parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TaskContext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
