package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.LogMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class LogNotification extends GeneratedMessageLite<LogNotification, Builder> implements LogNotificationOrBuilder {
    private static final LogNotification DEFAULT_INSTANCE;
    public static final int LOG_FIELD_NUMBER = 2;
    private static volatile Parser<LogNotification> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private LogMessage log_;
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.common.LogNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LogNotification, Builder> implements LogNotificationOrBuilder {
        public Builder clearLog() {
            copyOnWrite();
            ((LogNotification) this.instance).clearLog();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((LogNotification) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
        public LogMessage getLog() {
            return ((LogNotification) this.instance).getLog();
        }

        @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
        public String getSessionId() {
            return ((LogNotification) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
        public ByteString getSessionIdBytes() {
            return ((LogNotification) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
        public boolean hasLog() {
            return ((LogNotification) this.instance).hasLog();
        }

        public Builder mergeLog(LogMessage logMessage) {
            copyOnWrite();
            ((LogNotification) this.instance).mergeLog(logMessage);
            return this;
        }

        public Builder setLog(LogMessage logMessage) {
            copyOnWrite();
            ((LogNotification) this.instance).setLog(logMessage);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((LogNotification) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((LogNotification) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(LogNotification.DEFAULT_INSTANCE);
        }

        public Builder setLog(LogMessage.Builder builder) {
            copyOnWrite();
            ((LogNotification) this.instance).setLog(builder.build());
            return this;
        }
    }

    static {
        LogNotification logNotification = new LogNotification();
        DEFAULT_INSTANCE = logNotification;
        GeneratedMessageLite.registerDefaultInstance(LogNotification.class, logNotification);
    }

    private LogNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLog() {
        this.log_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static LogNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLog(LogMessage logMessage) {
        logMessage.getClass();
        LogMessage logMessage2 = this.log_;
        if (logMessage2 == null || logMessage2 == LogMessage.getDefaultInstance()) {
            this.log_ = logMessage;
        } else {
            this.log_ = LogMessage.newBuilder(this.log_).mergeFrom((LogMessage.Builder) logMessage).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static LogNotification parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LogNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LogNotification parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<LogNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLog(LogMessage logMessage) {
        logMessage.getClass();
        this.log_ = logMessage;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new LogNotification();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "sessionId_", "log_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LogNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (LogNotification.class) {
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

    @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
    public LogMessage getLog() {
        LogMessage logMessage = this.log_;
        return logMessage == null ? LogMessage.getDefaultInstance() : logMessage;
    }

    @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.LogNotificationOrBuilder
    public boolean hasLog() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(LogNotification logNotification) {
        return DEFAULT_INSTANCE.createBuilder(logNotification);
    }

    public static LogNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LogNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LogNotification parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LogNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LogNotification parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LogNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LogNotification parseFrom(InputStream inputStream) throws IOException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LogNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LogNotification parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LogNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
