package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ToolProvider extends GeneratedMessageLite<ToolProvider, Builder> implements ToolProviderOrBuilder {
    private static final ToolProvider DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 5;
    public static final int OVERRIDE_DESCRIPTION_FIELD_NUMBER = 3;
    public static final int OVERRIDE_NAME_FIELD_NUMBER = 2;
    public static final int OVERRIDE_PARAMETERS_SCHEMA_FIELD_NUMBER = 4;
    private static volatile Parser<ToolProvider> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Struct metadata_;
    private String type_ = "";
    private String overrideName_ = "";
    private String overrideDescription_ = "";
    private String overrideParametersSchema_ = "";

    /* renamed from: com.zyql.protobuf.agent.ToolProvider$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolProvider, Builder> implements ToolProviderOrBuilder {
        public Builder clearMetadata() {
            copyOnWrite();
            ((ToolProvider) this.instance).clearMetadata();
            return this;
        }

        public Builder clearOverrideDescription() {
            copyOnWrite();
            ((ToolProvider) this.instance).clearOverrideDescription();
            return this;
        }

        public Builder clearOverrideName() {
            copyOnWrite();
            ((ToolProvider) this.instance).clearOverrideName();
            return this;
        }

        public Builder clearOverrideParametersSchema() {
            copyOnWrite();
            ((ToolProvider) this.instance).clearOverrideParametersSchema();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((ToolProvider) this.instance).clearType();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public Struct getMetadata() {
            return ((ToolProvider) this.instance).getMetadata();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public String getOverrideDescription() {
            return ((ToolProvider) this.instance).getOverrideDescription();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public ByteString getOverrideDescriptionBytes() {
            return ((ToolProvider) this.instance).getOverrideDescriptionBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public String getOverrideName() {
            return ((ToolProvider) this.instance).getOverrideName();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public ByteString getOverrideNameBytes() {
            return ((ToolProvider) this.instance).getOverrideNameBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public String getOverrideParametersSchema() {
            return ((ToolProvider) this.instance).getOverrideParametersSchema();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public ByteString getOverrideParametersSchemaBytes() {
            return ((ToolProvider) this.instance).getOverrideParametersSchemaBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public String getType() {
            return ((ToolProvider) this.instance).getType();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public ByteString getTypeBytes() {
            return ((ToolProvider) this.instance).getTypeBytes();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public boolean hasMetadata() {
            return ((ToolProvider) this.instance).hasMetadata();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public boolean hasOverrideDescription() {
            return ((ToolProvider) this.instance).hasOverrideDescription();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public boolean hasOverrideName() {
            return ((ToolProvider) this.instance).hasOverrideName();
        }

        @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
        public boolean hasOverrideParametersSchema() {
            return ((ToolProvider) this.instance).hasOverrideParametersSchema();
        }

        public Builder mergeMetadata(Struct struct) {
            copyOnWrite();
            ((ToolProvider) this.instance).mergeMetadata(struct);
            return this;
        }

        public Builder setMetadata(Struct struct) {
            copyOnWrite();
            ((ToolProvider) this.instance).setMetadata(struct);
            return this;
        }

        public Builder setOverrideDescription(String str) {
            copyOnWrite();
            ((ToolProvider) this.instance).setOverrideDescription(str);
            return this;
        }

        public Builder setOverrideDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolProvider) this.instance).setOverrideDescriptionBytes(byteString);
            return this;
        }

        public Builder setOverrideName(String str) {
            copyOnWrite();
            ((ToolProvider) this.instance).setOverrideName(str);
            return this;
        }

        public Builder setOverrideNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolProvider) this.instance).setOverrideNameBytes(byteString);
            return this;
        }

        public Builder setOverrideParametersSchema(String str) {
            copyOnWrite();
            ((ToolProvider) this.instance).setOverrideParametersSchema(str);
            return this;
        }

        public Builder setOverrideParametersSchemaBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolProvider) this.instance).setOverrideParametersSchemaBytes(byteString);
            return this;
        }

        public Builder setType(String str) {
            copyOnWrite();
            ((ToolProvider) this.instance).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolProvider) this.instance).setTypeBytes(byteString);
            return this;
        }

        private Builder() {
            super(ToolProvider.DEFAULT_INSTANCE);
        }

        public Builder setMetadata(Struct.Builder builder) {
            copyOnWrite();
            ((ToolProvider) this.instance).setMetadata(builder.build());
            return this;
        }
    }

    static {
        ToolProvider toolProvider = new ToolProvider();
        DEFAULT_INSTANCE = toolProvider;
        GeneratedMessageLite.registerDefaultInstance(ToolProvider.class, toolProvider);
    }

    private ToolProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOverrideDescription() {
        this.bitField0_ &= -3;
        this.overrideDescription_ = getDefaultInstance().getOverrideDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOverrideName() {
        this.bitField0_ &= -2;
        this.overrideName_ = getDefaultInstance().getOverrideName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOverrideParametersSchema() {
        this.bitField0_ &= -5;
        this.overrideParametersSchema_ = getDefaultInstance().getOverrideParametersSchema();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    public static ToolProvider getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetadata(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = Struct.newBuilder(this.metadata_).mergeFrom((Struct.Builder) struct).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ToolProvider parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolProvider) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolProvider parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolProvider> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Struct struct) {
        struct.getClass();
        this.metadata_ = struct;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverrideDescription(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.overrideDescription_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverrideDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.overrideDescription_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverrideName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.overrideName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverrideNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.overrideName_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverrideParametersSchema(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.overrideParametersSchema_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverrideParametersSchemaBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.overrideParametersSchema_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ToolProvider();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002ለ\u0000\u0003ለ\u0001\u0004ለ\u0002\u0005ဉ\u0003", new Object[]{"bitField0_", "type_", "overrideName_", "overrideDescription_", "overrideParametersSchema_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolProvider> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolProvider.class) {
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

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public String getOverrideDescription() {
        return this.overrideDescription_;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public ByteString getOverrideDescriptionBytes() {
        return ByteString.copyFromUtf8(this.overrideDescription_);
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public String getOverrideName() {
        return this.overrideName_;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public ByteString getOverrideNameBytes() {
        return ByteString.copyFromUtf8(this.overrideName_);
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public String getOverrideParametersSchema() {
        return this.overrideParametersSchema_;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public ByteString getOverrideParametersSchemaBytes() {
        return ByteString.copyFromUtf8(this.overrideParametersSchema_);
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public boolean hasMetadata() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public boolean hasOverrideDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public boolean hasOverrideName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.agent.ToolProviderOrBuilder
    public boolean hasOverrideParametersSchema() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(ToolProvider toolProvider) {
        return DEFAULT_INSTANCE.createBuilder(toolProvider);
    }

    public static ToolProvider parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolProvider) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolProvider parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolProvider parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolProvider parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolProvider parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolProvider parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolProvider parseFrom(InputStream inputStream) throws IOException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolProvider parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolProvider parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolProvider parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
