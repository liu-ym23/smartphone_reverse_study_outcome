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
public final class Tool extends GeneratedMessageLite<Tool, Builder> implements ToolOrBuilder {
    private static final Tool DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int PARAMETERS_FIELD_NUMBER = 5;
    private static volatile Parser<Tool> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> parameters_ = MapFieldLite.emptyMapField();
    private String id_ = "";
    private String version_ = "";
    private String name_ = "";
    private String description_ = "";

    /* renamed from: com.zyql.protobuf.skull.Tool$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Tool, Builder> implements ToolOrBuilder {
        public Builder clearDescription() {
            copyOnWrite();
            ((Tool) this.instance).clearDescription();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((Tool) this.instance).clearId();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Tool) this.instance).clearName();
            return this;
        }

        public Builder clearParameters() {
            copyOnWrite();
            ((Tool) this.instance).getMutableParametersMap().clear();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Tool) this.instance).clearVersion();
            return this;
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public boolean containsParameters(String str) {
            str.getClass();
            return ((Tool) this.instance).getParametersMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public String getDescription() {
            return ((Tool) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public ByteString getDescriptionBytes() {
            return ((Tool) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public String getId() {
            return ((Tool) this.instance).getId();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public ByteString getIdBytes() {
            return ((Tool) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public String getName() {
            return ((Tool) this.instance).getName();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public ByteString getNameBytes() {
            return ((Tool) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        @Deprecated
        public Map<String, String> getParameters() {
            return getParametersMap();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public int getParametersCount() {
            return ((Tool) this.instance).getParametersMap().size();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public Map<String, String> getParametersMap() {
            return Collections.unmodifiableMap(((Tool) this.instance).getParametersMap());
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public String getParametersOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> parametersMap = ((Tool) this.instance).getParametersMap();
            return parametersMap.containsKey(str) ? parametersMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public String getParametersOrThrow(String str) {
            str.getClass();
            Map<String, String> parametersMap = ((Tool) this.instance).getParametersMap();
            if (parametersMap.containsKey(str)) {
                return parametersMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public String getVersion() {
            return ((Tool) this.instance).getVersion();
        }

        @Override // com.zyql.protobuf.skull.ToolOrBuilder
        public ByteString getVersionBytes() {
            return ((Tool) this.instance).getVersionBytes();
        }

        public Builder putAllParameters(Map<String, String> map) {
            copyOnWrite();
            ((Tool) this.instance).getMutableParametersMap().putAll(map);
            return this;
        }

        public Builder putParameters(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((Tool) this.instance).getMutableParametersMap().put(str, str2);
            return this;
        }

        public Builder removeParameters(String str) {
            str.getClass();
            copyOnWrite();
            ((Tool) this.instance).getMutableParametersMap().remove(str);
            return this;
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((Tool) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Tool) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((Tool) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Tool) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Tool) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Tool) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((Tool) this.instance).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Tool) this.instance).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(Tool.DEFAULT_INSTANCE);
        }
    }

    public static final class ParametersDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ParametersDefaultEntryHolder() {
        }
    }

    static {
        Tool tool = new Tool();
        DEFAULT_INSTANCE = tool;
        GeneratedMessageLite.registerDefaultInstance(Tool.class, tool);
    }

    private Tool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static Tool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableParametersMap() {
        return internalGetMutableParameters();
    }

    private MapFieldLite<String, String> internalGetMutableParameters() {
        if (!this.parameters_.isMutable()) {
            this.parameters_ = this.parameters_.mutableCopy();
        }
        return this.parameters_;
    }

    private MapFieldLite<String, String> internalGetParameters() {
        return this.parameters_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Tool parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Tool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tool parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Tool> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.version_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public boolean containsParameters(String str) {
        str.getClass();
        return internalGetParameters().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Tool();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"id_", "version_", "name_", "description_", "parameters_", ParametersDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Tool> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Tool.class) {
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

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    @Deprecated
    public Map<String, String> getParameters() {
        return getParametersMap();
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public int getParametersCount() {
        return internalGetParameters().size();
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public Map<String, String> getParametersMap() {
        return Collections.unmodifiableMap(internalGetParameters());
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public String getParametersOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetParameters = internalGetParameters();
        return mapFieldLiteInternalGetParameters.containsKey(str) ? mapFieldLiteInternalGetParameters.get(str) : str2;
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public String getParametersOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetParameters = internalGetParameters();
        if (mapFieldLiteInternalGetParameters.containsKey(str)) {
            return mapFieldLiteInternalGetParameters.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.zyql.protobuf.skull.ToolOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    public static Builder newBuilder(Tool tool) {
        return DEFAULT_INSTANCE.createBuilder(tool);
    }

    public static Tool parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Tool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Tool parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Tool parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Tool parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Tool parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tool parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Tool parseFrom(InputStream inputStream) throws IOException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tool parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Tool parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Tool parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Tool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
