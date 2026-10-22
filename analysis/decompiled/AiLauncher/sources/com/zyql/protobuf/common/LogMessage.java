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
public final class LogMessage extends GeneratedMessageLite<LogMessage, Builder> implements LogMessageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 3;
    private static final LogMessage DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 2;
    private static volatile Parser<LogMessage> PARSER = null;
    public static final int SENDER_FIELD_NUMBER = 1;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private String content_ = "";
    private int level_;
    private int sender_;
    private long timestamp_;

    /* renamed from: com.zyql.protobuf.common.LogMessage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LogMessage, Builder> implements LogMessageOrBuilder {
        public Builder clearContent() {
            copyOnWrite();
            ((LogMessage) this.instance).clearContent();
            return this;
        }

        public Builder clearLevel() {
            copyOnWrite();
            ((LogMessage) this.instance).clearLevel();
            return this;
        }

        public Builder clearSender() {
            copyOnWrite();
            ((LogMessage) this.instance).clearSender();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((LogMessage) this.instance).clearTimestamp();
            return this;
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public String getContent() {
            return ((LogMessage) this.instance).getContent();
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public ByteString getContentBytes() {
            return ((LogMessage) this.instance).getContentBytes();
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public LogLevel getLevel() {
            return ((LogMessage) this.instance).getLevel();
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public int getLevelValue() {
            return ((LogMessage) this.instance).getLevelValue();
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public LogSender getSender() {
            return ((LogMessage) this.instance).getSender();
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public int getSenderValue() {
            return ((LogMessage) this.instance).getSenderValue();
        }

        @Override // com.zyql.protobuf.common.LogMessageOrBuilder
        public long getTimestamp() {
            return ((LogMessage) this.instance).getTimestamp();
        }

        public Builder setContent(String str) {
            copyOnWrite();
            ((LogMessage) this.instance).setContent(str);
            return this;
        }

        public Builder setContentBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((LogMessage) this.instance).setContentBytes(byteString);
            return this;
        }

        public Builder setLevel(LogLevel logLevel) {
            copyOnWrite();
            ((LogMessage) this.instance).setLevel(logLevel);
            return this;
        }

        public Builder setLevelValue(int i10) {
            copyOnWrite();
            ((LogMessage) this.instance).setLevelValue(i10);
            return this;
        }

        public Builder setSender(LogSender logSender) {
            copyOnWrite();
            ((LogMessage) this.instance).setSender(logSender);
            return this;
        }

        public Builder setSenderValue(int i10) {
            copyOnWrite();
            ((LogMessage) this.instance).setSenderValue(i10);
            return this;
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((LogMessage) this.instance).setTimestamp(j10);
            return this;
        }

        private Builder() {
            super(LogMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        LogMessage logMessage = new LogMessage();
        DEFAULT_INSTANCE = logMessage;
        GeneratedMessageLite.registerDefaultInstance(LogMessage.class, logMessage);
    }

    private LogMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLevel() {
        this.level_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSender() {
        this.sender_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static LogMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static LogMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LogMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LogMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<LogMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContent(String str) {
        str.getClass();
        this.content_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.content_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLevel(LogLevel logLevel) {
        this.level_ = logLevel.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLevelValue(int i10) {
        this.level_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSender(LogSender logSender) {
        this.sender_ = logSender.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSenderValue(int i10) {
        this.sender_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j10) {
        this.timestamp_ = j10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new LogMessage();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ\u0004\u0002", new Object[]{"sender_", "level_", "content_", "timestamp_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LogMessage> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (LogMessage.class) {
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

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public String getContent() {
        return this.content_;
    }

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public LogLevel getLevel() {
        LogLevel logLevelForNumber = LogLevel.forNumber(this.level_);
        return logLevelForNumber == null ? LogLevel.UNRECOGNIZED : logLevelForNumber;
    }

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public int getLevelValue() {
        return this.level_;
    }

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public LogSender getSender() {
        LogSender logSenderForNumber = LogSender.forNumber(this.sender_);
        return logSenderForNumber == null ? LogSender.UNRECOGNIZED : logSenderForNumber;
    }

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public int getSenderValue() {
        return this.sender_;
    }

    @Override // com.zyql.protobuf.common.LogMessageOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    public static Builder newBuilder(LogMessage logMessage) {
        return DEFAULT_INSTANCE.createBuilder(logMessage);
    }

    public static LogMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LogMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LogMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LogMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LogMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LogMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LogMessage parseFrom(InputStream inputStream) throws IOException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LogMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LogMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LogMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
