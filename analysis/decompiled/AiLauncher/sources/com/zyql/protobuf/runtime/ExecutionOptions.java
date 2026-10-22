package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.LogLevel;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ExecutionOptions extends GeneratedMessageLite<ExecutionOptions, Builder> implements ExecutionOptionsOrBuilder {
    private static final ExecutionOptions DEFAULT_INSTANCE;
    public static final int INCLUDE_FUNCTION_CALL_OUTPUT_FIELD_NUMBER = 1;
    public static final int INCLUDE_SUB_AGENT_OUTPUT_FIELD_NUMBER = 3;
    public static final int LOG_LEVEL_FIELD_NUMBER = 5;
    public static final int OBSERVER_MODE_FIELD_NUMBER = 4;
    private static volatile Parser<ExecutionOptions> PARSER = null;
    public static final int SEND_COMPLETE_MESSAGE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean includeFunctionCallOutput_;
    private boolean includeSubAgentOutput_;
    private int logLevel_;
    private boolean observerMode_;
    private boolean sendCompleteMessage_;

    /* renamed from: com.zyql.protobuf.runtime.ExecutionOptions$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ExecutionOptions, Builder> implements ExecutionOptionsOrBuilder {
        public Builder clearIncludeFunctionCallOutput() {
            copyOnWrite();
            ((ExecutionOptions) this.instance).clearIncludeFunctionCallOutput();
            return this;
        }

        public Builder clearIncludeSubAgentOutput() {
            copyOnWrite();
            ((ExecutionOptions) this.instance).clearIncludeSubAgentOutput();
            return this;
        }

        public Builder clearLogLevel() {
            copyOnWrite();
            ((ExecutionOptions) this.instance).clearLogLevel();
            return this;
        }

        public Builder clearObserverMode() {
            copyOnWrite();
            ((ExecutionOptions) this.instance).clearObserverMode();
            return this;
        }

        public Builder clearSendCompleteMessage() {
            copyOnWrite();
            ((ExecutionOptions) this.instance).clearSendCompleteMessage();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean getIncludeFunctionCallOutput() {
            return ((ExecutionOptions) this.instance).getIncludeFunctionCallOutput();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean getIncludeSubAgentOutput() {
            return ((ExecutionOptions) this.instance).getIncludeSubAgentOutput();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public LogLevel getLogLevel() {
            return ((ExecutionOptions) this.instance).getLogLevel();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public int getLogLevelValue() {
            return ((ExecutionOptions) this.instance).getLogLevelValue();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean getObserverMode() {
            return ((ExecutionOptions) this.instance).getObserverMode();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean getSendCompleteMessage() {
            return ((ExecutionOptions) this.instance).getSendCompleteMessage();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean hasIncludeFunctionCallOutput() {
            return ((ExecutionOptions) this.instance).hasIncludeFunctionCallOutput();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean hasIncludeSubAgentOutput() {
            return ((ExecutionOptions) this.instance).hasIncludeSubAgentOutput();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean hasLogLevel() {
            return ((ExecutionOptions) this.instance).hasLogLevel();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean hasObserverMode() {
            return ((ExecutionOptions) this.instance).hasObserverMode();
        }

        @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
        public boolean hasSendCompleteMessage() {
            return ((ExecutionOptions) this.instance).hasSendCompleteMessage();
        }

        public Builder setIncludeFunctionCallOutput(boolean z10) {
            copyOnWrite();
            ((ExecutionOptions) this.instance).setIncludeFunctionCallOutput(z10);
            return this;
        }

        public Builder setIncludeSubAgentOutput(boolean z10) {
            copyOnWrite();
            ((ExecutionOptions) this.instance).setIncludeSubAgentOutput(z10);
            return this;
        }

        public Builder setLogLevel(LogLevel logLevel) {
            copyOnWrite();
            ((ExecutionOptions) this.instance).setLogLevel(logLevel);
            return this;
        }

        public Builder setLogLevelValue(int i10) {
            copyOnWrite();
            ((ExecutionOptions) this.instance).setLogLevelValue(i10);
            return this;
        }

        public Builder setObserverMode(boolean z10) {
            copyOnWrite();
            ((ExecutionOptions) this.instance).setObserverMode(z10);
            return this;
        }

        public Builder setSendCompleteMessage(boolean z10) {
            copyOnWrite();
            ((ExecutionOptions) this.instance).setSendCompleteMessage(z10);
            return this;
        }

        private Builder() {
            super(ExecutionOptions.DEFAULT_INSTANCE);
        }
    }

    static {
        ExecutionOptions executionOptions = new ExecutionOptions();
        DEFAULT_INSTANCE = executionOptions;
        GeneratedMessageLite.registerDefaultInstance(ExecutionOptions.class, executionOptions);
    }

    private ExecutionOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIncludeFunctionCallOutput() {
        this.bitField0_ &= -2;
        this.includeFunctionCallOutput_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIncludeSubAgentOutput() {
        this.bitField0_ &= -5;
        this.includeSubAgentOutput_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogLevel() {
        this.bitField0_ &= -17;
        this.logLevel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObserverMode() {
        this.bitField0_ &= -9;
        this.observerMode_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSendCompleteMessage() {
        this.bitField0_ &= -3;
        this.sendCompleteMessage_ = false;
    }

    public static ExecutionOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ExecutionOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ExecutionOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExecutionOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ExecutionOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeFunctionCallOutput(boolean z10) {
        this.bitField0_ |= 1;
        this.includeFunctionCallOutput_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeSubAgentOutput(boolean z10) {
        this.bitField0_ |= 4;
        this.includeSubAgentOutput_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel_ = logLevel.getNumber();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogLevelValue(int i10) {
        this.bitField0_ |= 16;
        this.logLevel_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setObserverMode(boolean z10) {
        this.bitField0_ |= 8;
        this.observerMode_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendCompleteMessage(boolean z10) {
        this.bitField0_ |= 2;
        this.sendCompleteMessage_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ExecutionOptions();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဌ\u0004", new Object[]{"bitField0_", "includeFunctionCallOutput_", "sendCompleteMessage_", "includeSubAgentOutput_", "observerMode_", "logLevel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExecutionOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ExecutionOptions.class) {
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

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean getIncludeFunctionCallOutput() {
        return this.includeFunctionCallOutput_;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean getIncludeSubAgentOutput() {
        return this.includeSubAgentOutput_;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public LogLevel getLogLevel() {
        LogLevel logLevelForNumber = LogLevel.forNumber(this.logLevel_);
        return logLevelForNumber == null ? LogLevel.UNRECOGNIZED : logLevelForNumber;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public int getLogLevelValue() {
        return this.logLevel_;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean getObserverMode() {
        return this.observerMode_;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean getSendCompleteMessage() {
        return this.sendCompleteMessage_;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean hasIncludeFunctionCallOutput() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean hasIncludeSubAgentOutput() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean hasLogLevel() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean hasObserverMode() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.zyql.protobuf.runtime.ExecutionOptionsOrBuilder
    public boolean hasSendCompleteMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(ExecutionOptions executionOptions) {
        return DEFAULT_INSTANCE.createBuilder(executionOptions);
    }

    public static ExecutionOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExecutionOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExecutionOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ExecutionOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ExecutionOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ExecutionOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExecutionOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ExecutionOptions parseFrom(InputStream inputStream) throws IOException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExecutionOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExecutionOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ExecutionOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExecutionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
