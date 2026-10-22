package com.zyql.protobuf.connection;

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
public final class HeartbeatResp extends GeneratedMessageLite<HeartbeatResp, Builder> implements HeartbeatRespOrBuilder {
    private static final HeartbeatResp DEFAULT_INSTANCE;
    public static final int INTERVAL_FIELD_NUMBER = 1;
    private static volatile Parser<HeartbeatResp> PARSER;
    private int interval_;

    /* renamed from: com.zyql.protobuf.connection.HeartbeatResp$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HeartbeatResp, Builder> implements HeartbeatRespOrBuilder {
        public Builder clearInterval() {
            copyOnWrite();
            ((HeartbeatResp) this.instance).clearInterval();
            return this;
        }

        @Override // com.zyql.protobuf.connection.HeartbeatRespOrBuilder
        public int getInterval() {
            return ((HeartbeatResp) this.instance).getInterval();
        }

        public Builder setInterval(int i10) {
            copyOnWrite();
            ((HeartbeatResp) this.instance).setInterval(i10);
            return this;
        }

        private Builder() {
            super(HeartbeatResp.DEFAULT_INSTANCE);
        }
    }

    static {
        HeartbeatResp heartbeatResp = new HeartbeatResp();
        DEFAULT_INSTANCE = heartbeatResp;
        GeneratedMessageLite.registerDefaultInstance(HeartbeatResp.class, heartbeatResp);
    }

    private HeartbeatResp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInterval() {
        this.interval_ = 0;
    }

    public static HeartbeatResp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HeartbeatResp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HeartbeatResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HeartbeatResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HeartbeatResp> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterval(int i10) {
        this.interval_ = i10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new HeartbeatResp();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"interval_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HeartbeatResp> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HeartbeatResp.class) {
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

    @Override // com.zyql.protobuf.connection.HeartbeatRespOrBuilder
    public int getInterval() {
        return this.interval_;
    }

    public static Builder newBuilder(HeartbeatResp heartbeatResp) {
        return DEFAULT_INSTANCE.createBuilder(heartbeatResp);
    }

    public static HeartbeatResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HeartbeatResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HeartbeatResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HeartbeatResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HeartbeatResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HeartbeatResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HeartbeatResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HeartbeatResp parseFrom(InputStream inputStream) throws IOException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HeartbeatResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HeartbeatResp parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HeartbeatResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HeartbeatResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
