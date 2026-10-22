package com.zyql.protobuf.agent;

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
public final class AgentTool extends GeneratedMessageLite<AgentTool, Builder> implements AgentToolOrBuilder {
    private static final AgentTool DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int PARAMETERS_SCHEMA_FIELD_NUMBER = 3;
    private static volatile Parser<AgentTool> PARSER;
    private String name_ = "";
    private String description_ = "";
    private String parametersSchema_ = "";

    /* renamed from: com.zyql.protobuf.agent.AgentTool$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AgentTool, Builder> implements AgentToolOrBuilder {
        public Builder clearDescription() {
            copyOnWrite();
            ((AgentTool) this.instance).clearDescription();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((AgentTool) this.instance).clearName();
            return this;
        }

        public Builder clearParametersSchema() {
            copyOnWrite();
            ((AgentTool) this.instance).clearParametersSchema();
            return this;
        }

        @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
        public String getDescription() {
            return ((AgentTool) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
        public ByteString getDescriptionBytes() {
            return ((AgentTool) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
        public String getName() {
            return ((AgentTool) this.instance).getName();
        }

        @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
        public ByteString getNameBytes() {
            return ((AgentTool) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
        public String getParametersSchema() {
            return ((AgentTool) this.instance).getParametersSchema();
        }

        @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
        public ByteString getParametersSchemaBytes() {
            return ((AgentTool) this.instance).getParametersSchemaBytes();
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((AgentTool) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentTool) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((AgentTool) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentTool) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setParametersSchema(String str) {
            copyOnWrite();
            ((AgentTool) this.instance).setParametersSchema(str);
            return this;
        }

        public Builder setParametersSchemaBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentTool) this.instance).setParametersSchemaBytes(byteString);
            return this;
        }

        private Builder() {
            super(AgentTool.DEFAULT_INSTANCE);
        }
    }

    static {
        AgentTool agentTool = new AgentTool();
        DEFAULT_INSTANCE = agentTool;
        GeneratedMessageLite.registerDefaultInstance(AgentTool.class, agentTool);
    }

    private AgentTool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParametersSchema() {
        this.parametersSchema_ = getDefaultInstance().getParametersSchema();
    }

    public static AgentTool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AgentTool parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgentTool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentTool parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AgentTool> parser() {
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
    public void setParametersSchema(String str) {
        str.getClass();
        this.parametersSchema_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParametersSchemaBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.parametersSchema_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AgentTool();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"name_", "description_", "parametersSchema_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AgentTool> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AgentTool.class) {
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

    @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
    public String getParametersSchema() {
        return this.parametersSchema_;
    }

    @Override // com.zyql.protobuf.agent.AgentToolOrBuilder
    public ByteString getParametersSchemaBytes() {
        return ByteString.copyFromUtf8(this.parametersSchema_);
    }

    public static Builder newBuilder(AgentTool agentTool) {
        return DEFAULT_INSTANCE.createBuilder(agentTool);
    }

    public static AgentTool parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentTool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentTool parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AgentTool parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AgentTool parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AgentTool parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AgentTool parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AgentTool parseFrom(InputStream inputStream) throws IOException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentTool parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentTool parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AgentTool parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentTool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
