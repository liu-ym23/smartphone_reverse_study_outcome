package com.zyql.protobuf.runtime;

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
public final class StartAgentAck extends GeneratedMessageLite<StartAgentAck, Builder> implements StartAgentAckOrBuilder {
    public static final int AGENT_DESCRIPTION_FIELD_NUMBER = 4;
    public static final int AGENT_NAME_FIELD_NUMBER = 3;
    private static final StartAgentAck DEFAULT_INSTANCE;
    private static volatile Parser<StartAgentAck> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int TASK_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private long taskId_;
    private String sessionId_ = "";
    private String agentName_ = "";
    private String agentDescription_ = "";

    /* renamed from: com.zyql.protobuf.runtime.StartAgentAck$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StartAgentAck, Builder> implements StartAgentAckOrBuilder {
        public Builder clearAgentDescription() {
            copyOnWrite();
            ((StartAgentAck) this.instance).clearAgentDescription();
            return this;
        }

        public Builder clearAgentName() {
            copyOnWrite();
            ((StartAgentAck) this.instance).clearAgentName();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((StartAgentAck) this.instance).clearSessionId();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((StartAgentAck) this.instance).clearTaskId();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public String getAgentDescription() {
            return ((StartAgentAck) this.instance).getAgentDescription();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public ByteString getAgentDescriptionBytes() {
            return ((StartAgentAck) this.instance).getAgentDescriptionBytes();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public String getAgentName() {
            return ((StartAgentAck) this.instance).getAgentName();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public ByteString getAgentNameBytes() {
            return ((StartAgentAck) this.instance).getAgentNameBytes();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public String getSessionId() {
            return ((StartAgentAck) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public ByteString getSessionIdBytes() {
            return ((StartAgentAck) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public long getTaskId() {
            return ((StartAgentAck) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public boolean hasAgentDescription() {
            return ((StartAgentAck) this.instance).hasAgentDescription();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public boolean hasAgentName() {
            return ((StartAgentAck) this.instance).hasAgentName();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
        public boolean hasTaskId() {
            return ((StartAgentAck) this.instance).hasTaskId();
        }

        public Builder setAgentDescription(String str) {
            copyOnWrite();
            ((StartAgentAck) this.instance).setAgentDescription(str);
            return this;
        }

        public Builder setAgentDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StartAgentAck) this.instance).setAgentDescriptionBytes(byteString);
            return this;
        }

        public Builder setAgentName(String str) {
            copyOnWrite();
            ((StartAgentAck) this.instance).setAgentName(str);
            return this;
        }

        public Builder setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StartAgentAck) this.instance).setAgentNameBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((StartAgentAck) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StartAgentAck) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setTaskId(long j10) {
            copyOnWrite();
            ((StartAgentAck) this.instance).setTaskId(j10);
            return this;
        }

        private Builder() {
            super(StartAgentAck.DEFAULT_INSTANCE);
        }
    }

    static {
        StartAgentAck startAgentAck = new StartAgentAck();
        DEFAULT_INSTANCE = startAgentAck;
        GeneratedMessageLite.registerDefaultInstance(StartAgentAck.class, startAgentAck);
    }

    private StartAgentAck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentDescription() {
        this.bitField0_ &= -5;
        this.agentDescription_ = getDefaultInstance().getAgentDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.bitField0_ &= -3;
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.bitField0_ &= -2;
        this.taskId_ = 0L;
    }

    public static StartAgentAck getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StartAgentAck parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StartAgentAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StartAgentAck parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StartAgentAck> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentDescription(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.agentDescription_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentDescription_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentName(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.agentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentName_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskId(long j10) {
        this.bitField0_ |= 1;
        this.taskId_ = j10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StartAgentAck();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဃ\u0000\u0003ለ\u0001\u0004ለ\u0002", new Object[]{"bitField0_", "sessionId_", "taskId_", "agentName_", "agentDescription_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StartAgentAck> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StartAgentAck.class) {
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

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public String getAgentDescription() {
        return this.agentDescription_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public ByteString getAgentDescriptionBytes() {
        return ByteString.copyFromUtf8(this.agentDescription_);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public String getAgentName() {
        return this.agentName_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public ByteString getAgentNameBytes() {
        return ByteString.copyFromUtf8(this.agentName_);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public long getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public boolean hasAgentDescription() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public boolean hasAgentName() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentAckOrBuilder
    public boolean hasTaskId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StartAgentAck startAgentAck) {
        return DEFAULT_INSTANCE.createBuilder(startAgentAck);
    }

    public static StartAgentAck parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartAgentAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StartAgentAck parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StartAgentAck parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StartAgentAck parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StartAgentAck parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StartAgentAck parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StartAgentAck parseFrom(InputStream inputStream) throws IOException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StartAgentAck parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StartAgentAck parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StartAgentAck parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartAgentAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
