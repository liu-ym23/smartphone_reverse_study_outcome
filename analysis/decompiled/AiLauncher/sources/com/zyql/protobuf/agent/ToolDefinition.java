package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.AgentTool;
import com.zyql.protobuf.agent.McpTool;
import com.zyql.protobuf.agent.ToolProvider;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ToolDefinition extends GeneratedMessageLite<ToolDefinition, Builder> implements ToolDefinitionOrBuilder {
    public static final int AGENT_TOOL_FIELD_NUMBER = 1;
    private static final ToolDefinition DEFAULT_INSTANCE;
    public static final int MCP_TOOL_FIELD_NUMBER = 3;
    private static volatile Parser<ToolDefinition> PARSER = null;
    public static final int TOOL_PROVIDER_FIELD_NUMBER = 2;
    private int toolCase_ = 0;
    private Object tool_;

    /* renamed from: com.zyql.protobuf.agent.ToolDefinition$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolDefinition, Builder> implements ToolDefinitionOrBuilder {
        public Builder clearAgentTool() {
            copyOnWrite();
            ((ToolDefinition) this.instance).clearAgentTool();
            return this;
        }

        public Builder clearMcpTool() {
            copyOnWrite();
            ((ToolDefinition) this.instance).clearMcpTool();
            return this;
        }

        public Builder clearTool() {
            copyOnWrite();
            ((ToolDefinition) this.instance).clearTool();
            return this;
        }

        public Builder clearToolProvider() {
            copyOnWrite();
            ((ToolDefinition) this.instance).clearToolProvider();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public AgentTool getAgentTool() {
            return ((ToolDefinition) this.instance).getAgentTool();
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public McpTool getMcpTool() {
            return ((ToolDefinition) this.instance).getMcpTool();
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public ToolCase getToolCase() {
            return ((ToolDefinition) this.instance).getToolCase();
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public ToolProvider getToolProvider() {
            return ((ToolDefinition) this.instance).getToolProvider();
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public boolean hasAgentTool() {
            return ((ToolDefinition) this.instance).hasAgentTool();
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public boolean hasMcpTool() {
            return ((ToolDefinition) this.instance).hasMcpTool();
        }

        @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
        public boolean hasToolProvider() {
            return ((ToolDefinition) this.instance).hasToolProvider();
        }

        public Builder mergeAgentTool(AgentTool agentTool) {
            copyOnWrite();
            ((ToolDefinition) this.instance).mergeAgentTool(agentTool);
            return this;
        }

        public Builder mergeMcpTool(McpTool mcpTool) {
            copyOnWrite();
            ((ToolDefinition) this.instance).mergeMcpTool(mcpTool);
            return this;
        }

        public Builder mergeToolProvider(ToolProvider toolProvider) {
            copyOnWrite();
            ((ToolDefinition) this.instance).mergeToolProvider(toolProvider);
            return this;
        }

        public Builder setAgentTool(AgentTool agentTool) {
            copyOnWrite();
            ((ToolDefinition) this.instance).setAgentTool(agentTool);
            return this;
        }

        public Builder setMcpTool(McpTool mcpTool) {
            copyOnWrite();
            ((ToolDefinition) this.instance).setMcpTool(mcpTool);
            return this;
        }

        public Builder setToolProvider(ToolProvider toolProvider) {
            copyOnWrite();
            ((ToolDefinition) this.instance).setToolProvider(toolProvider);
            return this;
        }

        private Builder() {
            super(ToolDefinition.DEFAULT_INSTANCE);
        }

        public Builder setAgentTool(AgentTool.Builder builder) {
            copyOnWrite();
            ((ToolDefinition) this.instance).setAgentTool(builder.build());
            return this;
        }

        public Builder setMcpTool(McpTool.Builder builder) {
            copyOnWrite();
            ((ToolDefinition) this.instance).setMcpTool(builder.build());
            return this;
        }

        public Builder setToolProvider(ToolProvider.Builder builder) {
            copyOnWrite();
            ((ToolDefinition) this.instance).setToolProvider(builder.build());
            return this;
        }
    }

    public enum ToolCase {
        AGENT_TOOL(1),
        TOOL_PROVIDER(2),
        MCP_TOOL(3),
        TOOL_NOT_SET(0);

        private final int value;

        ToolCase(int i10) {
            this.value = i10;
        }

        public static ToolCase forNumber(int i10) {
            if (i10 == 0) {
                return TOOL_NOT_SET;
            }
            if (i10 == 1) {
                return AGENT_TOOL;
            }
            if (i10 == 2) {
                return TOOL_PROVIDER;
            }
            if (i10 != 3) {
                return null;
            }
            return MCP_TOOL;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ToolCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        ToolDefinition toolDefinition = new ToolDefinition();
        DEFAULT_INSTANCE = toolDefinition;
        GeneratedMessageLite.registerDefaultInstance(ToolDefinition.class, toolDefinition);
    }

    private ToolDefinition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentTool() {
        if (this.toolCase_ == 1) {
            this.toolCase_ = 0;
            this.tool_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMcpTool() {
        if (this.toolCase_ == 3) {
            this.toolCase_ = 0;
            this.tool_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTool() {
        this.toolCase_ = 0;
        this.tool_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolProvider() {
        if (this.toolCase_ == 2) {
            this.toolCase_ = 0;
            this.tool_ = null;
        }
    }

    public static ToolDefinition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAgentTool(AgentTool agentTool) {
        agentTool.getClass();
        if (this.toolCase_ != 1 || this.tool_ == AgentTool.getDefaultInstance()) {
            this.tool_ = agentTool;
        } else {
            this.tool_ = AgentTool.newBuilder((AgentTool) this.tool_).mergeFrom((AgentTool.Builder) agentTool).buildPartial();
        }
        this.toolCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMcpTool(McpTool mcpTool) {
        mcpTool.getClass();
        if (this.toolCase_ != 3 || this.tool_ == McpTool.getDefaultInstance()) {
            this.tool_ = mcpTool;
        } else {
            this.tool_ = McpTool.newBuilder((McpTool) this.tool_).mergeFrom((McpTool.Builder) mcpTool).buildPartial();
        }
        this.toolCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToolProvider(ToolProvider toolProvider) {
        toolProvider.getClass();
        if (this.toolCase_ != 2 || this.tool_ == ToolProvider.getDefaultInstance()) {
            this.tool_ = toolProvider;
        } else {
            this.tool_ = ToolProvider.newBuilder((ToolProvider) this.tool_).mergeFrom((ToolProvider.Builder) toolProvider).buildPartial();
        }
        this.toolCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ToolDefinition parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolDefinition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolDefinition parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolDefinition> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentTool(AgentTool agentTool) {
        agentTool.getClass();
        this.tool_ = agentTool;
        this.toolCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMcpTool(McpTool mcpTool) {
        mcpTool.getClass();
        this.tool_ = mcpTool;
        this.toolCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolProvider(ToolProvider toolProvider) {
        toolProvider.getClass();
        this.tool_ = toolProvider;
        this.toolCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ToolDefinition();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"tool_", "toolCase_", AgentTool.class, ToolProvider.class, McpTool.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolDefinition> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolDefinition.class) {
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

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public AgentTool getAgentTool() {
        return this.toolCase_ == 1 ? (AgentTool) this.tool_ : AgentTool.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public McpTool getMcpTool() {
        return this.toolCase_ == 3 ? (McpTool) this.tool_ : McpTool.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public ToolCase getToolCase() {
        return ToolCase.forNumber(this.toolCase_);
    }

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public ToolProvider getToolProvider() {
        return this.toolCase_ == 2 ? (ToolProvider) this.tool_ : ToolProvider.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public boolean hasAgentTool() {
        return this.toolCase_ == 1;
    }

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public boolean hasMcpTool() {
        return this.toolCase_ == 3;
    }

    @Override // com.zyql.protobuf.agent.ToolDefinitionOrBuilder
    public boolean hasToolProvider() {
        return this.toolCase_ == 2;
    }

    public static Builder newBuilder(ToolDefinition toolDefinition) {
        return DEFAULT_INSTANCE.createBuilder(toolDefinition);
    }

    public static ToolDefinition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolDefinition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolDefinition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolDefinition parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolDefinition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolDefinition parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolDefinition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolDefinition parseFrom(InputStream inputStream) throws IOException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolDefinition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolDefinition parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolDefinition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
