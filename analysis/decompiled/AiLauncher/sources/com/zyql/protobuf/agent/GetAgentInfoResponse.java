package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.AgentInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class GetAgentInfoResponse extends GeneratedMessageLite<GetAgentInfoResponse, Builder> implements GetAgentInfoResponseOrBuilder {
    public static final int AGENT_INFO_FIELD_NUMBER = 2;
    private static final GetAgentInfoResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 3;
    private static volatile Parser<GetAgentInfoResponse> PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private AgentInfo agentInfo_;
    private int bitField0_;
    private String error_ = "";
    private boolean success_;

    /* renamed from: com.zyql.protobuf.agent.GetAgentInfoResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetAgentInfoResponse, Builder> implements GetAgentInfoResponseOrBuilder {
        public Builder clearAgentInfo() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearAgentInfo();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearError();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearSuccess();
            return this;
        }

        @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
        public AgentInfo getAgentInfo() {
            return ((GetAgentInfoResponse) this.instance).getAgentInfo();
        }

        @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
        public String getError() {
            return ((GetAgentInfoResponse) this.instance).getError();
        }

        @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
        public ByteString getErrorBytes() {
            return ((GetAgentInfoResponse) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
        public boolean getSuccess() {
            return ((GetAgentInfoResponse) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
        public boolean hasAgentInfo() {
            return ((GetAgentInfoResponse) this.instance).hasAgentInfo();
        }

        public Builder mergeAgentInfo(AgentInfo agentInfo) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).mergeAgentInfo(agentInfo);
            return this;
        }

        public Builder setAgentInfo(AgentInfo agentInfo) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setAgentInfo(agentInfo);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setSuccess(z10);
            return this;
        }

        private Builder() {
            super(GetAgentInfoResponse.DEFAULT_INSTANCE);
        }

        public Builder setAgentInfo(AgentInfo.Builder builder) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setAgentInfo(builder.build());
            return this;
        }
    }

    static {
        GetAgentInfoResponse getAgentInfoResponse = new GetAgentInfoResponse();
        DEFAULT_INSTANCE = getAgentInfoResponse;
        GeneratedMessageLite.registerDefaultInstance(GetAgentInfoResponse.class, getAgentInfoResponse);
    }

    private GetAgentInfoResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentInfo() {
        this.agentInfo_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static GetAgentInfoResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAgentInfo(AgentInfo agentInfo) {
        agentInfo.getClass();
        AgentInfo agentInfo2 = this.agentInfo_;
        if (agentInfo2 == null || agentInfo2 == AgentInfo.getDefaultInstance()) {
            this.agentInfo_ = agentInfo;
        } else {
            this.agentInfo_ = AgentInfo.newBuilder(this.agentInfo_).mergeFrom((AgentInfo.Builder) agentInfo).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetAgentInfoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetAgentInfoResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetAgentInfoResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentInfo(AgentInfo agentInfo) {
        agentInfo.getClass();
        this.agentInfo_ = agentInfo;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new GetAgentInfoResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000\u0003Ȉ", new Object[]{"bitField0_", "success_", "agentInfo_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetAgentInfoResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetAgentInfoResponse.class) {
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

    @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
    public AgentInfo getAgentInfo() {
        AgentInfo agentInfo = this.agentInfo_;
        return agentInfo == null ? AgentInfo.getDefaultInstance() : agentInfo;
    }

    @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.agent.GetAgentInfoResponseOrBuilder
    public boolean hasAgentInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GetAgentInfoResponse getAgentInfoResponse) {
        return DEFAULT_INSTANCE.createBuilder(getAgentInfoResponse);
    }

    public static GetAgentInfoResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GetAgentInfoResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetAgentInfoResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(InputStream inputStream) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetAgentInfoResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetAgentInfoResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
