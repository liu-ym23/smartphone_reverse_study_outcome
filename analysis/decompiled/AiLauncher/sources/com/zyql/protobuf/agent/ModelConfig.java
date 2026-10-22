package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ModelConfig extends GeneratedMessageLite<ModelConfig, Builder> implements ModelConfigOrBuilder {
    private static final ModelConfig DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int MAX_TOKENS_FIELD_NUMBER = 4;
    public static final int MODEL_FIELD_NUMBER = 2;
    private static volatile Parser<ModelConfig> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 1;
    public static final int STOP_FIELD_NUMBER = 6;
    public static final int TEMPERATURE_FIELD_NUMBER = 3;
    public static final int TOP_P_FIELD_NUMBER = 5;
    private int bitField0_;
    private int maxTokens_;
    private float temperature_;
    private float topP_;
    private MapFieldLite<String, String> extra_ = MapFieldLite.emptyMapField();
    private String provider_ = "";
    private String model_ = "";
    private Internal.ProtobufList<String> stop_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.agent.ModelConfig$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ModelConfig, Builder> implements ModelConfigOrBuilder {
        public Builder addAllStop(Iterable<String> iterable) {
            copyOnWrite();
            ((ModelConfig) this.instance).addAllStop(iterable);
            return this;
        }

        public Builder addStop(String str) {
            copyOnWrite();
            ((ModelConfig) this.instance).addStop(str);
            return this;
        }

        public Builder addStopBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelConfig) this.instance).addStopBytes(byteString);
            return this;
        }

        public Builder clearExtra() {
            copyOnWrite();
            ((ModelConfig) this.instance).getMutableExtraMap().clear();
            return this;
        }

        public Builder clearMaxTokens() {
            copyOnWrite();
            ((ModelConfig) this.instance).clearMaxTokens();
            return this;
        }

        public Builder clearModel() {
            copyOnWrite();
            ((ModelConfig) this.instance).clearModel();
            return this;
        }

        public Builder clearProvider() {
            copyOnWrite();
            ((ModelConfig) this.instance).clearProvider();
            return this;
        }

        public Builder clearStop() {
            copyOnWrite();
            ((ModelConfig) this.instance).clearStop();
            return this;
        }

        public Builder clearTemperature() {
            copyOnWrite();
            ((ModelConfig) this.instance).clearTemperature();
            return this;
        }

        public Builder clearTopP() {
            copyOnWrite();
            ((ModelConfig) this.instance).clearTopP();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public boolean containsExtra(String str) {
            str.getClass();
            return ((ModelConfig) this.instance).getExtraMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        @Deprecated
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public int getExtraCount() {
            return ((ModelConfig) this.instance).getExtraMap().size();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public Map<String, String> getExtraMap() {
            return Collections.unmodifiableMap(((ModelConfig) this.instance).getExtraMap());
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public String getExtraOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> extraMap = ((ModelConfig) this.instance).getExtraMap();
            return extraMap.containsKey(str) ? extraMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public String getExtraOrThrow(String str) {
            str.getClass();
            Map<String, String> extraMap = ((ModelConfig) this.instance).getExtraMap();
            if (extraMap.containsKey(str)) {
                return extraMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public int getMaxTokens() {
            return ((ModelConfig) this.instance).getMaxTokens();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public String getModel() {
            return ((ModelConfig) this.instance).getModel();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public ByteString getModelBytes() {
            return ((ModelConfig) this.instance).getModelBytes();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public String getProvider() {
            return ((ModelConfig) this.instance).getProvider();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public ByteString getProviderBytes() {
            return ((ModelConfig) this.instance).getProviderBytes();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public String getStop(int i10) {
            return ((ModelConfig) this.instance).getStop(i10);
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public ByteString getStopBytes(int i10) {
            return ((ModelConfig) this.instance).getStopBytes(i10);
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public int getStopCount() {
            return ((ModelConfig) this.instance).getStopCount();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public List<String> getStopList() {
            return Collections.unmodifiableList(((ModelConfig) this.instance).getStopList());
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public float getTemperature() {
            return ((ModelConfig) this.instance).getTemperature();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public float getTopP() {
            return ((ModelConfig) this.instance).getTopP();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public boolean hasMaxTokens() {
            return ((ModelConfig) this.instance).hasMaxTokens();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public boolean hasTemperature() {
            return ((ModelConfig) this.instance).hasTemperature();
        }

        @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
        public boolean hasTopP() {
            return ((ModelConfig) this.instance).hasTopP();
        }

        public Builder putAllExtra(Map<String, String> map) {
            copyOnWrite();
            ((ModelConfig) this.instance).getMutableExtraMap().putAll(map);
            return this;
        }

        public Builder putExtra(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ModelConfig) this.instance).getMutableExtraMap().put(str, str2);
            return this;
        }

        public Builder removeExtra(String str) {
            str.getClass();
            copyOnWrite();
            ((ModelConfig) this.instance).getMutableExtraMap().remove(str);
            return this;
        }

        public Builder setMaxTokens(int i10) {
            copyOnWrite();
            ((ModelConfig) this.instance).setMaxTokens(i10);
            return this;
        }

        public Builder setModel(String str) {
            copyOnWrite();
            ((ModelConfig) this.instance).setModel(str);
            return this;
        }

        public Builder setModelBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelConfig) this.instance).setModelBytes(byteString);
            return this;
        }

        public Builder setProvider(String str) {
            copyOnWrite();
            ((ModelConfig) this.instance).setProvider(str);
            return this;
        }

        public Builder setProviderBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ModelConfig) this.instance).setProviderBytes(byteString);
            return this;
        }

        public Builder setStop(int i10, String str) {
            copyOnWrite();
            ((ModelConfig) this.instance).setStop(i10, str);
            return this;
        }

        public Builder setTemperature(float f10) {
            copyOnWrite();
            ((ModelConfig) this.instance).setTemperature(f10);
            return this;
        }

        public Builder setTopP(float f10) {
            copyOnWrite();
            ((ModelConfig) this.instance).setTopP(f10);
            return this;
        }

        private Builder() {
            super(ModelConfig.DEFAULT_INSTANCE);
        }
    }

    public static final class ExtraDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ExtraDefaultEntryHolder() {
        }
    }

    static {
        ModelConfig modelConfig = new ModelConfig();
        DEFAULT_INSTANCE = modelConfig;
        GeneratedMessageLite.registerDefaultInstance(ModelConfig.class, modelConfig);
    }

    private ModelConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStop(Iterable<String> iterable) {
        ensureStopIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.stop_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStop(String str) {
        str.getClass();
        ensureStopIsMutable();
        this.stop_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStopBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        ensureStopIsMutable();
        this.stop_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxTokens() {
        this.bitField0_ &= -3;
        this.maxTokens_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModel() {
        this.model_ = getDefaultInstance().getModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProvider() {
        this.provider_ = getDefaultInstance().getProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStop() {
        this.stop_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTemperature() {
        this.bitField0_ &= -2;
        this.temperature_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTopP() {
        this.bitField0_ &= -5;
        this.topP_ = 0.0f;
    }

    private void ensureStopIsMutable() {
        Internal.ProtobufList<String> protobufList = this.stop_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.stop_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ModelConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private MapFieldLite<String, String> internalGetExtra() {
        return this.extra_;
    }

    private MapFieldLite<String, String> internalGetMutableExtra() {
        if (!this.extra_.isMutable()) {
            this.extra_ = this.extra_.mutableCopy();
        }
        return this.extra_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ModelConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ModelConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ModelConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ModelConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxTokens(int i10) {
        this.bitField0_ |= 2;
        this.maxTokens_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModel(String str) {
        str.getClass();
        this.model_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.model_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProvider(String str) {
        str.getClass();
        this.provider_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviderBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.provider_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStop(int i10, String str) {
        str.getClass();
        ensureStopIsMutable();
        this.stop_.set(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTemperature(float f10) {
        this.bitField0_ |= 1;
        this.temperature_ = f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopP(float f10) {
        this.bitField0_ |= 4;
        this.topP_ = f10;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ModelConfig();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ခ\u0000\u0004င\u0001\u0005ခ\u0002\u0006Ț\u00072", new Object[]{"bitField0_", "provider_", "model_", "temperature_", "maxTokens_", "topP_", "stop_", "extra_", ExtraDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ModelConfig> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ModelConfig.class) {
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

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public int getExtraCount() {
        return internalGetExtra().size();
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetExtra = internalGetExtra();
        return mapFieldLiteInternalGetExtra.containsKey(str) ? mapFieldLiteInternalGetExtra.get(str) : str2;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public String getExtraOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetExtra = internalGetExtra();
        if (mapFieldLiteInternalGetExtra.containsKey(str)) {
            return mapFieldLiteInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public int getMaxTokens() {
        return this.maxTokens_;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public String getModel() {
        return this.model_;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public String getProvider() {
        return this.provider_;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public ByteString getProviderBytes() {
        return ByteString.copyFromUtf8(this.provider_);
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public String getStop(int i10) {
        return this.stop_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public ByteString getStopBytes(int i10) {
        return ByteString.copyFromUtf8(this.stop_.get(i10));
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public int getStopCount() {
        return this.stop_.size();
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public List<String> getStopList() {
        return this.stop_;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public float getTemperature() {
        return this.temperature_;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public float getTopP() {
        return this.topP_;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public boolean hasMaxTokens() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public boolean hasTemperature() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.agent.ModelConfigOrBuilder
    public boolean hasTopP() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(ModelConfig modelConfig) {
        return DEFAULT_INSTANCE.createBuilder(modelConfig);
    }

    public static ModelConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ModelConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ModelConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ModelConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ModelConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ModelConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ModelConfig parseFrom(InputStream inputStream) throws IOException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ModelConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ModelConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ModelConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ModelConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
