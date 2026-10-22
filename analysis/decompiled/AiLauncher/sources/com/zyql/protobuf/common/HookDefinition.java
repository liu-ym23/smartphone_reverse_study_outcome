package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class HookDefinition extends GeneratedMessageLite<HookDefinition, Builder> implements HookDefinitionOrBuilder {
    private static final HookDefinition DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int HOOK_POINT_FIELD_NUMBER = 4;
    public static final int LAYER_FIELD_NUMBER = 3;
    public static final int MODE_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<HookDefinition> PARSER = null;
    public static final int TIMEOUT_MS_FIELD_NUMBER = 7;
    public static final int TOOL_NAME_PATTERN_FIELD_NUMBER = 6;
    private int bitField0_;
    private int hookPoint_;
    private int layer_;
    private int mode_;
    private int timeoutMs_;
    private String name_ = "";
    private String description_ = "";
    private String toolNamePattern_ = "";

    /* renamed from: com.zyql.protobuf.common.HookDefinition$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HookDefinition, Builder> implements HookDefinitionOrBuilder {
        public Builder clearDescription() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearDescription();
            return this;
        }

        public Builder clearHookPoint() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearHookPoint();
            return this;
        }

        public Builder clearLayer() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearLayer();
            return this;
        }

        public Builder clearMode() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearMode();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearName();
            return this;
        }

        public Builder clearTimeoutMs() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearTimeoutMs();
            return this;
        }

        public Builder clearToolNamePattern() {
            copyOnWrite();
            ((HookDefinition) this.instance).clearToolNamePattern();
            return this;
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public String getDescription() {
            return ((HookDefinition) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public ByteString getDescriptionBytes() {
            return ((HookDefinition) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public HookPoint getHookPoint() {
            return ((HookDefinition) this.instance).getHookPoint();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public int getHookPointValue() {
            return ((HookDefinition) this.instance).getHookPointValue();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public HookLayer getLayer() {
            return ((HookDefinition) this.instance).getLayer();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public int getLayerValue() {
            return ((HookDefinition) this.instance).getLayerValue();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public HookExecutionMode getMode() {
            return ((HookDefinition) this.instance).getMode();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public int getModeValue() {
            return ((HookDefinition) this.instance).getModeValue();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public String getName() {
            return ((HookDefinition) this.instance).getName();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public ByteString getNameBytes() {
            return ((HookDefinition) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public int getTimeoutMs() {
            return ((HookDefinition) this.instance).getTimeoutMs();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public String getToolNamePattern() {
            return ((HookDefinition) this.instance).getToolNamePattern();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public ByteString getToolNamePatternBytes() {
            return ((HookDefinition) this.instance).getToolNamePatternBytes();
        }

        @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
        public boolean hasToolNamePattern() {
            return ((HookDefinition) this.instance).hasToolNamePattern();
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((HookDefinition) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookDefinition) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setHookPoint(HookPoint hookPoint) {
            copyOnWrite();
            ((HookDefinition) this.instance).setHookPoint(hookPoint);
            return this;
        }

        public Builder setHookPointValue(int i10) {
            copyOnWrite();
            ((HookDefinition) this.instance).setHookPointValue(i10);
            return this;
        }

        public Builder setLayer(HookLayer hookLayer) {
            copyOnWrite();
            ((HookDefinition) this.instance).setLayer(hookLayer);
            return this;
        }

        public Builder setLayerValue(int i10) {
            copyOnWrite();
            ((HookDefinition) this.instance).setLayerValue(i10);
            return this;
        }

        public Builder setMode(HookExecutionMode hookExecutionMode) {
            copyOnWrite();
            ((HookDefinition) this.instance).setMode(hookExecutionMode);
            return this;
        }

        public Builder setModeValue(int i10) {
            copyOnWrite();
            ((HookDefinition) this.instance).setModeValue(i10);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((HookDefinition) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookDefinition) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setTimeoutMs(int i10) {
            copyOnWrite();
            ((HookDefinition) this.instance).setTimeoutMs(i10);
            return this;
        }

        public Builder setToolNamePattern(String str) {
            copyOnWrite();
            ((HookDefinition) this.instance).setToolNamePattern(str);
            return this;
        }

        public Builder setToolNamePatternBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookDefinition) this.instance).setToolNamePatternBytes(byteString);
            return this;
        }

        private Builder() {
            super(HookDefinition.DEFAULT_INSTANCE);
        }
    }

    static {
        HookDefinition hookDefinition = new HookDefinition();
        DEFAULT_INSTANCE = hookDefinition;
        GeneratedMessageLite.registerDefaultInstance(HookDefinition.class, hookDefinition);
    }

    private HookDefinition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookPoint() {
        this.hookPoint_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayer() {
        this.layer_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMode() {
        this.mode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeoutMs() {
        this.timeoutMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolNamePattern() {
        this.bitField0_ &= -2;
        this.toolNamePattern_ = getDefaultInstance().getToolNamePattern();
    }

    public static HookDefinition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HookDefinition parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HookDefinition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookDefinition parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HookDefinition> parser() {
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
    public void setHookPoint(HookPoint hookPoint) {
        this.hookPoint_ = hookPoint.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookPointValue(int i10) {
        this.hookPoint_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayer(HookLayer hookLayer) {
        this.layer_ = hookLayer.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayerValue(int i10) {
        this.layer_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(HookExecutionMode hookExecutionMode) {
        this.mode_ = hookExecutionMode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModeValue(int i10) {
        this.mode_ = i10;
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
    public void setTimeoutMs(int i10) {
        this.timeoutMs_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolNamePattern(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.toolNamePattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolNamePatternBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.toolNamePattern_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new HookDefinition();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f\u0005\f\u0006ለ\u0000\u0007\u0004", new Object[]{"bitField0_", "name_", "description_", "layer_", "hookPoint_", "mode_", "toolNamePattern_", "timeoutMs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HookDefinition> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HookDefinition.class) {
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

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public HookPoint getHookPoint() {
        HookPoint hookPointForNumber = HookPoint.forNumber(this.hookPoint_);
        return hookPointForNumber == null ? HookPoint.UNRECOGNIZED : hookPointForNumber;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public int getHookPointValue() {
        return this.hookPoint_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public HookLayer getLayer() {
        HookLayer hookLayerForNumber = HookLayer.forNumber(this.layer_);
        return hookLayerForNumber == null ? HookLayer.UNRECOGNIZED : hookLayerForNumber;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public int getLayerValue() {
        return this.layer_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public HookExecutionMode getMode() {
        HookExecutionMode hookExecutionModeForNumber = HookExecutionMode.forNumber(this.mode_);
        return hookExecutionModeForNumber == null ? HookExecutionMode.UNRECOGNIZED : hookExecutionModeForNumber;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public int getModeValue() {
        return this.mode_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public int getTimeoutMs() {
        return this.timeoutMs_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public String getToolNamePattern() {
        return this.toolNamePattern_;
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public ByteString getToolNamePatternBytes() {
        return ByteString.copyFromUtf8(this.toolNamePattern_);
    }

    @Override // com.zyql.protobuf.common.HookDefinitionOrBuilder
    public boolean hasToolNamePattern() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(HookDefinition hookDefinition) {
        return DEFAULT_INSTANCE.createBuilder(hookDefinition);
    }

    public static HookDefinition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookDefinition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookDefinition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HookDefinition parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HookDefinition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HookDefinition parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HookDefinition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HookDefinition parseFrom(InputStream inputStream) throws IOException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookDefinition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookDefinition parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HookDefinition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
