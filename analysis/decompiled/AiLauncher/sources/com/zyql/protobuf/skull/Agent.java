package com.zyql.protobuf.skull;

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
public final class Agent extends GeneratedMessageLite<Agent, Builder> implements AgentOrBuilder {
    private static final Agent DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile Parser<Agent> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String id_ = "";
    private String version_ = "";
    private String name_ = "";
    private String description_ = "";

    /* renamed from: com.zyql.protobuf.skull.Agent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Agent, Builder> implements AgentOrBuilder {
        public Builder clearDescription() {
            copyOnWrite();
            ((Agent) this.instance).clearDescription();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((Agent) this.instance).clearId();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Agent) this.instance).clearName();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Agent) this.instance).clearVersion();
            return this;
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public String getDescription() {
            return ((Agent) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public ByteString getDescriptionBytes() {
            return ((Agent) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public String getId() {
            return ((Agent) this.instance).getId();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public ByteString getIdBytes() {
            return ((Agent) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public String getName() {
            return ((Agent) this.instance).getName();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public ByteString getNameBytes() {
            return ((Agent) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public String getVersion() {
            return ((Agent) this.instance).getVersion();
        }

        @Override // com.zyql.protobuf.skull.AgentOrBuilder
        public ByteString getVersionBytes() {
            return ((Agent) this.instance).getVersionBytes();
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((Agent) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Agent) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((Agent) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Agent) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Agent) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Agent) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((Agent) this.instance).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Agent) this.instance).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(Agent.DEFAULT_INSTANCE);
        }
    }

    static {
        Agent agent = new Agent();
        DEFAULT_INSTANCE = agent;
        GeneratedMessageLite.registerDefaultInstance(Agent.class, agent);
    }

    private Agent() {
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

    public static Agent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Agent parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Agent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Agent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Agent> parser() {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Agent();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"id_", "version_", "name_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Agent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Agent.class) {
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

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.zyql.protobuf.skull.AgentOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    public static Builder newBuilder(Agent agent) {
        return DEFAULT_INSTANCE.createBuilder(agent);
    }

    public static Agent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Agent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Agent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Agent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Agent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Agent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Agent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Agent parseFrom(InputStream inputStream) throws IOException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Agent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Agent parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Agent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Agent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
