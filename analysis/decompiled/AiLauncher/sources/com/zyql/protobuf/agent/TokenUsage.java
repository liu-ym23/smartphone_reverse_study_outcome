package com.zyql.protobuf.agent;

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
public final class TokenUsage extends GeneratedMessageLite<TokenUsage, Builder> implements TokenUsageOrBuilder {
    public static final int COMPLETION_TOKENS_FIELD_NUMBER = 2;
    private static final TokenUsage DEFAULT_INSTANCE;
    private static volatile Parser<TokenUsage> PARSER = null;
    public static final int PROMPT_TOKENS_FIELD_NUMBER = 1;
    public static final int TOTAL_TOKENS_FIELD_NUMBER = 3;
    private int completionTokens_;
    private int promptTokens_;
    private int totalTokens_;

    /* renamed from: com.zyql.protobuf.agent.TokenUsage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TokenUsage, Builder> implements TokenUsageOrBuilder {
        public Builder clearCompletionTokens() {
            copyOnWrite();
            ((TokenUsage) this.instance).clearCompletionTokens();
            return this;
        }

        public Builder clearPromptTokens() {
            copyOnWrite();
            ((TokenUsage) this.instance).clearPromptTokens();
            return this;
        }

        public Builder clearTotalTokens() {
            copyOnWrite();
            ((TokenUsage) this.instance).clearTotalTokens();
            return this;
        }

        @Override // com.zyql.protobuf.agent.TokenUsageOrBuilder
        public int getCompletionTokens() {
            return ((TokenUsage) this.instance).getCompletionTokens();
        }

        @Override // com.zyql.protobuf.agent.TokenUsageOrBuilder
        public int getPromptTokens() {
            return ((TokenUsage) this.instance).getPromptTokens();
        }

        @Override // com.zyql.protobuf.agent.TokenUsageOrBuilder
        public int getTotalTokens() {
            return ((TokenUsage) this.instance).getTotalTokens();
        }

        public Builder setCompletionTokens(int i10) {
            copyOnWrite();
            ((TokenUsage) this.instance).setCompletionTokens(i10);
            return this;
        }

        public Builder setPromptTokens(int i10) {
            copyOnWrite();
            ((TokenUsage) this.instance).setPromptTokens(i10);
            return this;
        }

        public Builder setTotalTokens(int i10) {
            copyOnWrite();
            ((TokenUsage) this.instance).setTotalTokens(i10);
            return this;
        }

        private Builder() {
            super(TokenUsage.DEFAULT_INSTANCE);
        }
    }

    static {
        TokenUsage tokenUsage = new TokenUsage();
        DEFAULT_INSTANCE = tokenUsage;
        GeneratedMessageLite.registerDefaultInstance(TokenUsage.class, tokenUsage);
    }

    private TokenUsage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCompletionTokens() {
        this.completionTokens_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPromptTokens() {
        this.promptTokens_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTotalTokens() {
        this.totalTokens_ = 0;
    }

    public static TokenUsage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TokenUsage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TokenUsage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TokenUsage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TokenUsage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompletionTokens(int i10) {
        this.completionTokens_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPromptTokens(int i10) {
        this.promptTokens_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTotalTokens(int i10) {
        this.totalTokens_ = i10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new TokenUsage();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"promptTokens_", "completionTokens_", "totalTokens_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TokenUsage> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TokenUsage.class) {
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

    @Override // com.zyql.protobuf.agent.TokenUsageOrBuilder
    public int getCompletionTokens() {
        return this.completionTokens_;
    }

    @Override // com.zyql.protobuf.agent.TokenUsageOrBuilder
    public int getPromptTokens() {
        return this.promptTokens_;
    }

    @Override // com.zyql.protobuf.agent.TokenUsageOrBuilder
    public int getTotalTokens() {
        return this.totalTokens_;
    }

    public static Builder newBuilder(TokenUsage tokenUsage) {
        return DEFAULT_INSTANCE.createBuilder(tokenUsage);
    }

    public static TokenUsage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TokenUsage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TokenUsage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TokenUsage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TokenUsage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TokenUsage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TokenUsage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TokenUsage parseFrom(InputStream inputStream) throws IOException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TokenUsage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TokenUsage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TokenUsage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TokenUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
