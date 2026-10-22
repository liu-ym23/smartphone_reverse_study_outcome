package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.ChatMessage;
import com.zyql.protobuf.agent.ModelConfig;
import com.zyql.protobuf.agent.ToolDefinition;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class CompletionRequest extends GeneratedMessageLite<CompletionRequest, Builder> implements CompletionRequestOrBuilder {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final CompletionRequest DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 2;
    private static volatile Parser<CompletionRequest> PARSER = null;
    public static final int TOOLS_FIELD_NUMBER = 3;
    private int bitField0_;
    private ModelConfig config_;
    private Internal.ProtobufList<ChatMessage> messages_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<ToolDefinition> tools_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.agent.CompletionRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CompletionRequest, Builder> implements CompletionRequestOrBuilder {
        public Builder addAllMessages(Iterable<? extends ChatMessage> iterable) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addAllMessages(iterable);
            return this;
        }

        public Builder addAllTools(Iterable<? extends ToolDefinition> iterable) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addAllTools(iterable);
            return this;
        }

        public Builder addMessages(ChatMessage chatMessage) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addMessages(chatMessage);
            return this;
        }

        public Builder addTools(ToolDefinition toolDefinition) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addTools(toolDefinition);
            return this;
        }

        public Builder clearConfig() {
            copyOnWrite();
            ((CompletionRequest) this.instance).clearConfig();
            return this;
        }

        public Builder clearMessages() {
            copyOnWrite();
            ((CompletionRequest) this.instance).clearMessages();
            return this;
        }

        public Builder clearTools() {
            copyOnWrite();
            ((CompletionRequest) this.instance).clearTools();
            return this;
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public ModelConfig getConfig() {
            return ((CompletionRequest) this.instance).getConfig();
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public ChatMessage getMessages(int i10) {
            return ((CompletionRequest) this.instance).getMessages(i10);
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public int getMessagesCount() {
            return ((CompletionRequest) this.instance).getMessagesCount();
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public List<ChatMessage> getMessagesList() {
            return Collections.unmodifiableList(((CompletionRequest) this.instance).getMessagesList());
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public ToolDefinition getTools(int i10) {
            return ((CompletionRequest) this.instance).getTools(i10);
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public int getToolsCount() {
            return ((CompletionRequest) this.instance).getToolsCount();
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public List<ToolDefinition> getToolsList() {
            return Collections.unmodifiableList(((CompletionRequest) this.instance).getToolsList());
        }

        @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
        public boolean hasConfig() {
            return ((CompletionRequest) this.instance).hasConfig();
        }

        public Builder mergeConfig(ModelConfig modelConfig) {
            copyOnWrite();
            ((CompletionRequest) this.instance).mergeConfig(modelConfig);
            return this;
        }

        public Builder removeMessages(int i10) {
            copyOnWrite();
            ((CompletionRequest) this.instance).removeMessages(i10);
            return this;
        }

        public Builder removeTools(int i10) {
            copyOnWrite();
            ((CompletionRequest) this.instance).removeTools(i10);
            return this;
        }

        public Builder setConfig(ModelConfig modelConfig) {
            copyOnWrite();
            ((CompletionRequest) this.instance).setConfig(modelConfig);
            return this;
        }

        public Builder setMessages(int i10, ChatMessage chatMessage) {
            copyOnWrite();
            ((CompletionRequest) this.instance).setMessages(i10, chatMessage);
            return this;
        }

        public Builder setTools(int i10, ToolDefinition toolDefinition) {
            copyOnWrite();
            ((CompletionRequest) this.instance).setTools(i10, toolDefinition);
            return this;
        }

        private Builder() {
            super(CompletionRequest.DEFAULT_INSTANCE);
        }

        public Builder addMessages(int i10, ChatMessage chatMessage) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addMessages(i10, chatMessage);
            return this;
        }

        public Builder addTools(int i10, ToolDefinition toolDefinition) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addTools(i10, toolDefinition);
            return this;
        }

        public Builder setConfig(ModelConfig.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).setConfig(builder.build());
            return this;
        }

        public Builder setMessages(int i10, ChatMessage.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).setMessages(i10, builder.build());
            return this;
        }

        public Builder setTools(int i10, ToolDefinition.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).setTools(i10, builder.build());
            return this;
        }

        public Builder addMessages(ChatMessage.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addMessages(builder.build());
            return this;
        }

        public Builder addTools(ToolDefinition.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addTools(builder.build());
            return this;
        }

        public Builder addMessages(int i10, ChatMessage.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addMessages(i10, builder.build());
            return this;
        }

        public Builder addTools(int i10, ToolDefinition.Builder builder) {
            copyOnWrite();
            ((CompletionRequest) this.instance).addTools(i10, builder.build());
            return this;
        }
    }

    static {
        CompletionRequest completionRequest = new CompletionRequest();
        DEFAULT_INSTANCE = completionRequest;
        GeneratedMessageLite.registerDefaultInstance(CompletionRequest.class, completionRequest);
    }

    private CompletionRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMessages(Iterable<? extends ChatMessage> iterable) {
        ensureMessagesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.messages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTools(Iterable<? extends ToolDefinition> iterable) {
        ensureToolsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tools_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(ChatMessage chatMessage) {
        chatMessage.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTools(ToolDefinition toolDefinition) {
        toolDefinition.getClass();
        ensureToolsIsMutable();
        this.tools_.add(toolDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTools() {
        this.tools_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMessagesIsMutable() {
        Internal.ProtobufList<ChatMessage> protobufList = this.messages_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureToolsIsMutable() {
        Internal.ProtobufList<ToolDefinition> protobufList = this.tools_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.tools_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static CompletionRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeConfig(ModelConfig modelConfig) {
        modelConfig.getClass();
        ModelConfig modelConfig2 = this.config_;
        if (modelConfig2 == null || modelConfig2 == ModelConfig.getDefaultInstance()) {
            this.config_ = modelConfig;
        } else {
            this.config_ = ModelConfig.newBuilder(this.config_).mergeFrom((ModelConfig.Builder) modelConfig).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CompletionRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompletionRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CompletionRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CompletionRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessages(int i10) {
        ensureMessagesIsMutable();
        this.messages_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTools(int i10) {
        ensureToolsIsMutable();
        this.tools_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfig(ModelConfig modelConfig) {
        modelConfig.getClass();
        this.config_ = modelConfig;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessages(int i10, ChatMessage chatMessage) {
        chatMessage.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i10, chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTools(int i10, ToolDefinition toolDefinition) {
        toolDefinition.getClass();
        ensureToolsIsMutable();
        this.tools_.set(i10, toolDefinition);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new CompletionRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"bitField0_", "config_", "messages_", ChatMessage.class, "tools_", ToolDefinition.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CompletionRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CompletionRequest.class) {
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

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public ModelConfig getConfig() {
        ModelConfig modelConfig = this.config_;
        return modelConfig == null ? ModelConfig.getDefaultInstance() : modelConfig;
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public ChatMessage getMessages(int i10) {
        return this.messages_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public int getMessagesCount() {
        return this.messages_.size();
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public List<ChatMessage> getMessagesList() {
        return this.messages_;
    }

    public ChatMessageOrBuilder getMessagesOrBuilder(int i10) {
        return this.messages_.get(i10);
    }

    public List<? extends ChatMessageOrBuilder> getMessagesOrBuilderList() {
        return this.messages_;
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public ToolDefinition getTools(int i10) {
        return this.tools_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public int getToolsCount() {
        return this.tools_.size();
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public List<ToolDefinition> getToolsList() {
        return this.tools_;
    }

    public ToolDefinitionOrBuilder getToolsOrBuilder(int i10) {
        return this.tools_.get(i10);
    }

    public List<? extends ToolDefinitionOrBuilder> getToolsOrBuilderList() {
        return this.tools_;
    }

    @Override // com.zyql.protobuf.agent.CompletionRequestOrBuilder
    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(CompletionRequest completionRequest) {
        return DEFAULT_INSTANCE.createBuilder(completionRequest);
    }

    public static CompletionRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompletionRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CompletionRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CompletionRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(int i10, ChatMessage chatMessage) {
        chatMessage.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i10, chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTools(int i10, ToolDefinition toolDefinition) {
        toolDefinition.getClass();
        ensureToolsIsMutable();
        this.tools_.add(i10, toolDefinition);
    }

    public static CompletionRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CompletionRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CompletionRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CompletionRequest parseFrom(InputStream inputStream) throws IOException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CompletionRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CompletionRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CompletionRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompletionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
