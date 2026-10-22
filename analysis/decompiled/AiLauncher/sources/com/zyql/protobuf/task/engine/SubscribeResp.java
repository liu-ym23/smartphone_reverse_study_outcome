package com.zyql.protobuf.task.engine;

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
public final class SubscribeResp extends GeneratedMessageLite<SubscribeResp, Builder> implements SubscribeRespOrBuilder {
    private static final SubscribeResp DEFAULT_INSTANCE;
    private static volatile Parser<SubscribeResp> PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int state_;

    /* renamed from: com.zyql.protobuf.task.engine.SubscribeResp$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SubscribeResp, Builder> implements SubscribeRespOrBuilder {
        public Builder clearState() {
            copyOnWrite();
            ((SubscribeResp) this.instance).clearState();
            return this;
        }

        @Override // com.zyql.protobuf.task.engine.SubscribeRespOrBuilder
        public InvokeState getState() {
            return ((SubscribeResp) this.instance).getState();
        }

        @Override // com.zyql.protobuf.task.engine.SubscribeRespOrBuilder
        public int getStateValue() {
            return ((SubscribeResp) this.instance).getStateValue();
        }

        public Builder setState(InvokeState invokeState) {
            copyOnWrite();
            ((SubscribeResp) this.instance).setState(invokeState);
            return this;
        }

        public Builder setStateValue(int i10) {
            copyOnWrite();
            ((SubscribeResp) this.instance).setStateValue(i10);
            return this;
        }

        private Builder() {
            super(SubscribeResp.DEFAULT_INSTANCE);
        }
    }

    static {
        SubscribeResp subscribeResp = new SubscribeResp();
        DEFAULT_INSTANCE = subscribeResp;
        GeneratedMessageLite.registerDefaultInstance(SubscribeResp.class, subscribeResp);
    }

    private SubscribeResp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    public static SubscribeResp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SubscribeResp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SubscribeResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscribeResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SubscribeResp> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(InvokeState invokeState) {
        this.state_ = invokeState.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i10) {
        this.state_ = i10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new SubscribeResp();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SubscribeResp> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SubscribeResp.class) {
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

    @Override // com.zyql.protobuf.task.engine.SubscribeRespOrBuilder
    public InvokeState getState() {
        InvokeState invokeStateForNumber = InvokeState.forNumber(this.state_);
        return invokeStateForNumber == null ? InvokeState.UNRECOGNIZED : invokeStateForNumber;
    }

    @Override // com.zyql.protobuf.task.engine.SubscribeRespOrBuilder
    public int getStateValue() {
        return this.state_;
    }

    public static Builder newBuilder(SubscribeResp subscribeResp) {
        return DEFAULT_INSTANCE.createBuilder(subscribeResp);
    }

    public static SubscribeResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscribeResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscribeResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SubscribeResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SubscribeResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SubscribeResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SubscribeResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SubscribeResp parseFrom(InputStream inputStream) throws IOException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscribeResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscribeResp parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SubscribeResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscribeResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
