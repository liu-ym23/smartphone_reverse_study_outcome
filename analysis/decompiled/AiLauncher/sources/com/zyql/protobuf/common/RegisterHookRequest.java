package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.HookDefinition;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class RegisterHookRequest extends GeneratedMessageLite<RegisterHookRequest, Builder> implements RegisterHookRequestOrBuilder {
    private static final RegisterHookRequest DEFAULT_INSTANCE;
    public static final int HOOK_FIELD_NUMBER = 1;
    private static volatile Parser<RegisterHookRequest> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private HookDefinition hook_;
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.common.RegisterHookRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RegisterHookRequest, Builder> implements RegisterHookRequestOrBuilder {
        public Builder clearHook() {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).clearHook();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
        public HookDefinition getHook() {
            return ((RegisterHookRequest) this.instance).getHook();
        }

        @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
        public String getSessionId() {
            return ((RegisterHookRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((RegisterHookRequest) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
        public boolean hasHook() {
            return ((RegisterHookRequest) this.instance).hasHook();
        }

        public Builder mergeHook(HookDefinition hookDefinition) {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).mergeHook(hookDefinition);
            return this;
        }

        public Builder setHook(HookDefinition hookDefinition) {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).setHook(hookDefinition);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(RegisterHookRequest.DEFAULT_INSTANCE);
        }

        public Builder setHook(HookDefinition.Builder builder) {
            copyOnWrite();
            ((RegisterHookRequest) this.instance).setHook(builder.build());
            return this;
        }
    }

    static {
        RegisterHookRequest registerHookRequest = new RegisterHookRequest();
        DEFAULT_INSTANCE = registerHookRequest;
        GeneratedMessageLite.registerDefaultInstance(RegisterHookRequest.class, registerHookRequest);
    }

    private RegisterHookRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHook() {
        this.hook_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static RegisterHookRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHook(HookDefinition hookDefinition) {
        hookDefinition.getClass();
        HookDefinition hookDefinition2 = this.hook_;
        if (hookDefinition2 == null || hookDefinition2 == HookDefinition.getDefaultInstance()) {
            this.hook_ = hookDefinition;
        } else {
            this.hook_ = HookDefinition.newBuilder(this.hook_).mergeFrom((HookDefinition.Builder) hookDefinition).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RegisterHookRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RegisterHookRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RegisterHookRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RegisterHookRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHook(HookDefinition hookDefinition) {
        hookDefinition.getClass();
        this.hook_ = hookDefinition;
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
                return new RegisterHookRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "hook_", "sessionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RegisterHookRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RegisterHookRequest.class) {
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

    @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
    public HookDefinition getHook() {
        HookDefinition hookDefinition = this.hook_;
        return hookDefinition == null ? HookDefinition.getDefaultInstance() : hookDefinition;
    }

    @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.common.RegisterHookRequestOrBuilder
    public boolean hasHook() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(RegisterHookRequest registerHookRequest) {
        return DEFAULT_INSTANCE.createBuilder(registerHookRequest);
    }

    public static RegisterHookRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegisterHookRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RegisterHookRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RegisterHookRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RegisterHookRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RegisterHookRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RegisterHookRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RegisterHookRequest parseFrom(InputStream inputStream) throws IOException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RegisterHookRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RegisterHookRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RegisterHookRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegisterHookRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
