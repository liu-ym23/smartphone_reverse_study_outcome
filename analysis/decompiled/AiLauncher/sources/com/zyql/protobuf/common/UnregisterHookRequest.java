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
public final class UnregisterHookRequest extends GeneratedMessageLite<UnregisterHookRequest, Builder> implements UnregisterHookRequestOrBuilder {
    private static final UnregisterHookRequest DEFAULT_INSTANCE;
    public static final int HOOK_ID_FIELD_NUMBER = 1;
    private static volatile Parser<UnregisterHookRequest> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private String hookId_ = "";
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.common.UnregisterHookRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<UnregisterHookRequest, Builder> implements UnregisterHookRequestOrBuilder {
        public Builder clearHookId() {
            copyOnWrite();
            ((UnregisterHookRequest) this.instance).clearHookId();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((UnregisterHookRequest) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
        public String getHookId() {
            return ((UnregisterHookRequest) this.instance).getHookId();
        }

        @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
        public ByteString getHookIdBytes() {
            return ((UnregisterHookRequest) this.instance).getHookIdBytes();
        }

        @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
        public String getSessionId() {
            return ((UnregisterHookRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((UnregisterHookRequest) this.instance).getSessionIdBytes();
        }

        public Builder setHookId(String str) {
            copyOnWrite();
            ((UnregisterHookRequest) this.instance).setHookId(str);
            return this;
        }

        public Builder setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((UnregisterHookRequest) this.instance).setHookIdBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((UnregisterHookRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((UnregisterHookRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(UnregisterHookRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        UnregisterHookRequest unregisterHookRequest = new UnregisterHookRequest();
        DEFAULT_INSTANCE = unregisterHookRequest;
        GeneratedMessageLite.registerDefaultInstance(UnregisterHookRequest.class, unregisterHookRequest);
    }

    private UnregisterHookRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookId() {
        this.hookId_ = getDefaultInstance().getHookId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static UnregisterHookRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UnregisterHookRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UnregisterHookRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UnregisterHookRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookId(String str) {
        str.getClass();
        this.hookId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.hookId_ = byteString.toStringUtf8();
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
                return new UnregisterHookRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"hookId_", "sessionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UnregisterHookRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UnregisterHookRequest.class) {
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

    @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
    public String getHookId() {
        return this.hookId_;
    }

    @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
    public ByteString getHookIdBytes() {
        return ByteString.copyFromUtf8(this.hookId_);
    }

    @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.UnregisterHookRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(UnregisterHookRequest unregisterHookRequest) {
        return DEFAULT_INSTANCE.createBuilder(unregisterHookRequest);
    }

    public static UnregisterHookRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UnregisterHookRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UnregisterHookRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UnregisterHookRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UnregisterHookRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UnregisterHookRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UnregisterHookRequest parseFrom(InputStream inputStream) throws IOException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UnregisterHookRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UnregisterHookRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UnregisterHookRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UnregisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
