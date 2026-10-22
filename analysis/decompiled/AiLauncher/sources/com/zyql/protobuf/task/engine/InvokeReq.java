package com.zyql.protobuf.task.engine;

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
public final class InvokeReq extends GeneratedMessageLite<InvokeReq, Builder> implements InvokeReqOrBuilder {
    public static final int BODY_FIELD_NUMBER = 4;
    public static final int COMMAND_FIELD_NUMBER = 2;
    private static final InvokeReq DEFAULT_INSTANCE;
    public static final int MODULE_FIELD_NUMBER = 1;
    public static final int MSGID_FIELD_NUMBER = 3;
    private static volatile Parser<InvokeReq> PARSER;
    private String module_ = "";
    private String command_ = "";
    private String msgId_ = "";
    private ByteString body_ = ByteString.EMPTY;

    /* renamed from: com.zyql.protobuf.task.engine.InvokeReq$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<InvokeReq, Builder> implements InvokeReqOrBuilder {
        public Builder clearBody() {
            copyOnWrite();
            ((InvokeReq) this.instance).clearBody();
            return this;
        }

        public Builder clearCommand() {
            copyOnWrite();
            ((InvokeReq) this.instance).clearCommand();
            return this;
        }

        public Builder clearModule() {
            copyOnWrite();
            ((InvokeReq) this.instance).clearModule();
            return this;
        }

        public Builder clearMsgId() {
            copyOnWrite();
            ((InvokeReq) this.instance).clearMsgId();
            return this;
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public ByteString getBody() {
            return ((InvokeReq) this.instance).getBody();
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public String getCommand() {
            return ((InvokeReq) this.instance).getCommand();
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public ByteString getCommandBytes() {
            return ((InvokeReq) this.instance).getCommandBytes();
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public String getModule() {
            return ((InvokeReq) this.instance).getModule();
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public ByteString getModuleBytes() {
            return ((InvokeReq) this.instance).getModuleBytes();
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public String getMsgId() {
            return ((InvokeReq) this.instance).getMsgId();
        }

        @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
        public ByteString getMsgIdBytes() {
            return ((InvokeReq) this.instance).getMsgIdBytes();
        }

        public Builder setBody(ByteString byteString) {
            copyOnWrite();
            ((InvokeReq) this.instance).setBody(byteString);
            return this;
        }

        public Builder setCommand(String str) {
            copyOnWrite();
            ((InvokeReq) this.instance).setCommand(str);
            return this;
        }

        public Builder setCommandBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((InvokeReq) this.instance).setCommandBytes(byteString);
            return this;
        }

        public Builder setModule(String str) {
            copyOnWrite();
            ((InvokeReq) this.instance).setModule(str);
            return this;
        }

        public Builder setModuleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((InvokeReq) this.instance).setModuleBytes(byteString);
            return this;
        }

        public Builder setMsgId(String str) {
            copyOnWrite();
            ((InvokeReq) this.instance).setMsgId(str);
            return this;
        }

        public Builder setMsgIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((InvokeReq) this.instance).setMsgIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(InvokeReq.DEFAULT_INSTANCE);
        }
    }

    static {
        InvokeReq invokeReq = new InvokeReq();
        DEFAULT_INSTANCE = invokeReq;
        GeneratedMessageLite.registerDefaultInstance(InvokeReq.class, invokeReq);
    }

    private InvokeReq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommand() {
        this.command_ = getDefaultInstance().getCommand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModule() {
        this.module_ = getDefaultInstance().getModule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMsgId() {
        this.msgId_ = getDefaultInstance().getMsgId();
    }

    public static InvokeReq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InvokeReq parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (InvokeReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InvokeReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InvokeReq> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBody(ByteString byteString) {
        byteString.getClass();
        this.body_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommand(String str) {
        str.getClass();
        this.command_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommandBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.command_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModule(String str) {
        str.getClass();
        this.module_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModuleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.module_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgId(String str) {
        str.getClass();
        this.msgId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.msgId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new InvokeReq();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\n", new Object[]{"module_", "command_", "msgId_", "body_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InvokeReq> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InvokeReq.class) {
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

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public ByteString getBody() {
        return this.body_;
    }

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public String getCommand() {
        return this.command_;
    }

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public ByteString getCommandBytes() {
        return ByteString.copyFromUtf8(this.command_);
    }

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public String getModule() {
        return this.module_;
    }

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public ByteString getModuleBytes() {
        return ByteString.copyFromUtf8(this.module_);
    }

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public String getMsgId() {
        return this.msgId_;
    }

    @Override // com.zyql.protobuf.task.engine.InvokeReqOrBuilder
    public ByteString getMsgIdBytes() {
        return ByteString.copyFromUtf8(this.msgId_);
    }

    public static Builder newBuilder(InvokeReq invokeReq) {
        return DEFAULT_INSTANCE.createBuilder(invokeReq);
    }

    public static InvokeReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvokeReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InvokeReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InvokeReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static InvokeReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static InvokeReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InvokeReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static InvokeReq parseFrom(InputStream inputStream) throws IOException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InvokeReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InvokeReq parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InvokeReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvokeReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
