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
import com.zyql.protobuf.agent.TokenUsage;
import com.zyql.protobuf.common.FunctionCall;
import com.zyql.protobuf.common.FunctionCallOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class CompletionResponse extends GeneratedMessageLite<CompletionResponse, Builder> implements CompletionResponseOrBuilder {
    private static final CompletionResponse DEFAULT_INSTANCE;
    public static final int FINISH_REASON_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile Parser<CompletionResponse> PARSER = null;
    public static final int PROVIDER_ERROR_FIELD_NUMBER = 5;
    public static final int TOKEN_USAGE_FIELD_NUMBER = 4;
    public static final int TOOL_CALLS_FIELD_NUMBER = 2;
    private int bitField0_;
    private ChatMessage message_;
    private TokenUsage tokenUsage_;
    private Internal.ProtobufList<FunctionCall> toolCalls_ = GeneratedMessageLite.emptyProtobufList();
    private String finishReason_ = "";
    private String providerError_ = "";

    /* renamed from: com.zyql.protobuf.agent.CompletionResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CompletionResponse, Builder> implements CompletionResponseOrBuilder {
        public Builder addAllToolCalls(Iterable<? extends FunctionCall> iterable) {
            copyOnWrite();
            ((CompletionResponse) this.instance).addAllToolCalls(iterable);
            return this;
        }

        public Builder addToolCalls(FunctionCall functionCall) {
            copyOnWrite();
            ((CompletionResponse) this.instance).addToolCalls(functionCall);
            return this;
        }

        public Builder clearFinishReason() {
            copyOnWrite();
            ((CompletionResponse) this.instance).clearFinishReason();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((CompletionResponse) this.instance).clearMessage();
            return this;
        }

        public Builder clearProviderError() {
            copyOnWrite();
            ((CompletionResponse) this.instance).clearProviderError();
            return this;
        }

        public Builder clearTokenUsage() {
            copyOnWrite();
            ((CompletionResponse) this.instance).clearTokenUsage();
            return this;
        }

        public Builder clearToolCalls() {
            copyOnWrite();
            ((CompletionResponse) this.instance).clearToolCalls();
            return this;
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public String getFinishReason() {
            return ((CompletionResponse) this.instance).getFinishReason();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public ByteString getFinishReasonBytes() {
            return ((CompletionResponse) this.instance).getFinishReasonBytes();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public ChatMessage getMessage() {
            return ((CompletionResponse) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public String getProviderError() {
            return ((CompletionResponse) this.instance).getProviderError();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public ByteString getProviderErrorBytes() {
            return ((CompletionResponse) this.instance).getProviderErrorBytes();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public TokenUsage getTokenUsage() {
            return ((CompletionResponse) this.instance).getTokenUsage();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public FunctionCall getToolCalls(int i10) {
            return ((CompletionResponse) this.instance).getToolCalls(i10);
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public int getToolCallsCount() {
            return ((CompletionResponse) this.instance).getToolCallsCount();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public List<FunctionCall> getToolCallsList() {
            return Collections.unmodifiableList(((CompletionResponse) this.instance).getToolCallsList());
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public boolean hasMessage() {
            return ((CompletionResponse) this.instance).hasMessage();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public boolean hasProviderError() {
            return ((CompletionResponse) this.instance).hasProviderError();
        }

        @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
        public boolean hasTokenUsage() {
            return ((CompletionResponse) this.instance).hasTokenUsage();
        }

        public Builder mergeMessage(ChatMessage chatMessage) {
            copyOnWrite();
            ((CompletionResponse) this.instance).mergeMessage(chatMessage);
            return this;
        }

        public Builder mergeTokenUsage(TokenUsage tokenUsage) {
            copyOnWrite();
            ((CompletionResponse) this.instance).mergeTokenUsage(tokenUsage);
            return this;
        }

        public Builder removeToolCalls(int i10) {
            copyOnWrite();
            ((CompletionResponse) this.instance).removeToolCalls(i10);
            return this;
        }

        public Builder setFinishReason(String str) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setFinishReason(str);
            return this;
        }

        public Builder setFinishReasonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((CompletionResponse) this.instance).setFinishReasonBytes(byteString);
            return this;
        }

        public Builder setMessage(ChatMessage chatMessage) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setMessage(chatMessage);
            return this;
        }

        public Builder setProviderError(String str) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setProviderError(str);
            return this;
        }

        public Builder setProviderErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((CompletionResponse) this.instance).setProviderErrorBytes(byteString);
            return this;
        }

        public Builder setTokenUsage(TokenUsage tokenUsage) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setTokenUsage(tokenUsage);
            return this;
        }

        public Builder setToolCalls(int i10, FunctionCall functionCall) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setToolCalls(i10, functionCall);
            return this;
        }

        private Builder() {
            super(CompletionResponse.DEFAULT_INSTANCE);
        }

        public Builder addToolCalls(int i10, FunctionCall functionCall) {
            copyOnWrite();
            ((CompletionResponse) this.instance).addToolCalls(i10, functionCall);
            return this;
        }

        public Builder setMessage(ChatMessage.Builder builder) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setMessage(builder.build());
            return this;
        }

        public Builder setTokenUsage(TokenUsage.Builder builder) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setTokenUsage(builder.build());
            return this;
        }

        public Builder setToolCalls(int i10, FunctionCall.Builder builder) {
            copyOnWrite();
            ((CompletionResponse) this.instance).setToolCalls(i10, builder.build());
            return this;
        }

        public Builder addToolCalls(FunctionCall.Builder builder) {
            copyOnWrite();
            ((CompletionResponse) this.instance).addToolCalls(builder.build());
            return this;
        }

        public Builder addToolCalls(int i10, FunctionCall.Builder builder) {
            copyOnWrite();
            ((CompletionResponse) this.instance).addToolCalls(i10, builder.build());
            return this;
        }
    }

    static {
        CompletionResponse completionResponse = new CompletionResponse();
        DEFAULT_INSTANCE = completionResponse;
        GeneratedMessageLite.registerDefaultInstance(CompletionResponse.class, completionResponse);
    }

    private CompletionResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllToolCalls(Iterable<? extends FunctionCall> iterable) {
        ensureToolCallsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.toolCalls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToolCalls(FunctionCall functionCall) {
        functionCall.getClass();
        ensureToolCallsIsMutable();
        this.toolCalls_.add(functionCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFinishReason() {
        this.finishReason_ = getDefaultInstance().getFinishReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProviderError() {
        this.bitField0_ &= -5;
        this.providerError_ = getDefaultInstance().getProviderError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTokenUsage() {
        this.tokenUsage_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCalls() {
        this.toolCalls_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureToolCallsIsMutable() {
        Internal.ProtobufList<FunctionCall> protobufList = this.toolCalls_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.toolCalls_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static CompletionResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessage(ChatMessage chatMessage) {
        chatMessage.getClass();
        ChatMessage chatMessage2 = this.message_;
        if (chatMessage2 == null || chatMessage2 == ChatMessage.getDefaultInstance()) {
            this.message_ = chatMessage;
        } else {
            this.message_ = ChatMessage.newBuilder(this.message_).mergeFrom((ChatMessage.Builder) chatMessage).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTokenUsage(TokenUsage tokenUsage) {
        tokenUsage.getClass();
        TokenUsage tokenUsage2 = this.tokenUsage_;
        if (tokenUsage2 == null || tokenUsage2 == TokenUsage.getDefaultInstance()) {
            this.tokenUsage_ = tokenUsage;
        } else {
            this.tokenUsage_ = TokenUsage.newBuilder(this.tokenUsage_).mergeFrom((TokenUsage.Builder) tokenUsage).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CompletionResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompletionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CompletionResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CompletionResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeToolCalls(int i10) {
        ensureToolCallsIsMutable();
        this.toolCalls_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinishReason(String str) {
        str.getClass();
        this.finishReason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinishReasonBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.finishReason_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(ChatMessage chatMessage) {
        chatMessage.getClass();
        this.message_ = chatMessage;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviderError(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.providerError_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviderErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.providerError_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokenUsage(TokenUsage tokenUsage) {
        tokenUsage.getClass();
        this.tokenUsage_ = tokenUsage;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCalls(int i10, FunctionCall functionCall) {
        functionCall.getClass();
        ensureToolCallsIsMutable();
        this.toolCalls_.set(i10, functionCall);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new CompletionResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003Ȉ\u0004ဉ\u0001\u0005ለ\u0002", new Object[]{"bitField0_", "message_", "toolCalls_", FunctionCall.class, "finishReason_", "tokenUsage_", "providerError_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CompletionResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CompletionResponse.class) {
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

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public String getFinishReason() {
        return this.finishReason_;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public ByteString getFinishReasonBytes() {
        return ByteString.copyFromUtf8(this.finishReason_);
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public ChatMessage getMessage() {
        ChatMessage chatMessage = this.message_;
        return chatMessage == null ? ChatMessage.getDefaultInstance() : chatMessage;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public String getProviderError() {
        return this.providerError_;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public ByteString getProviderErrorBytes() {
        return ByteString.copyFromUtf8(this.providerError_);
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public TokenUsage getTokenUsage() {
        TokenUsage tokenUsage = this.tokenUsage_;
        return tokenUsage == null ? TokenUsage.getDefaultInstance() : tokenUsage;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public FunctionCall getToolCalls(int i10) {
        return this.toolCalls_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public int getToolCallsCount() {
        return this.toolCalls_.size();
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public List<FunctionCall> getToolCallsList() {
        return this.toolCalls_;
    }

    public FunctionCallOrBuilder getToolCallsOrBuilder(int i10) {
        return this.toolCalls_.get(i10);
    }

    public List<? extends FunctionCallOrBuilder> getToolCallsOrBuilderList() {
        return this.toolCalls_;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public boolean hasProviderError() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.agent.CompletionResponseOrBuilder
    public boolean hasTokenUsage() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(CompletionResponse completionResponse) {
        return DEFAULT_INSTANCE.createBuilder(completionResponse);
    }

    public static CompletionResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompletionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CompletionResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CompletionResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToolCalls(int i10, FunctionCall functionCall) {
        functionCall.getClass();
        ensureToolCallsIsMutable();
        this.toolCalls_.add(i10, functionCall);
    }

    public static CompletionResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CompletionResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CompletionResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CompletionResponse parseFrom(InputStream inputStream) throws IOException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CompletionResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CompletionResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CompletionResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompletionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
