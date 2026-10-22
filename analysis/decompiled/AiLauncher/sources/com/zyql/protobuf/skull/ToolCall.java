package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Tool;
import com.zyql.protobuf.skull.ToolCallParams;
import com.zyql.protobuf.skull.ToolCallResult;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class ToolCall extends GeneratedMessageLite<ToolCall, Builder> implements ToolCallOrBuilder {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final ToolCall DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile Parser<ToolCall> PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 4;
    public static final int TOOL_FIELD_NUMBER = 2;
    private int bitField0_;
    private String callId_ = "";
    private ToolCallParams params_;
    private ToolCallResult result_;
    private Tool tool_;

    /* renamed from: com.zyql.protobuf.skull.ToolCall$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolCall, Builder> implements ToolCallOrBuilder {
        public Builder clearCallId() {
            copyOnWrite();
            ((ToolCall) this.instance).clearCallId();
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((ToolCall) this.instance).clearParams();
            return this;
        }

        public Builder clearResult() {
            copyOnWrite();
            ((ToolCall) this.instance).clearResult();
            return this;
        }

        public Builder clearTool() {
            copyOnWrite();
            ((ToolCall) this.instance).clearTool();
            return this;
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public String getCallId() {
            return ((ToolCall) this.instance).getCallId();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public ByteString getCallIdBytes() {
            return ((ToolCall) this.instance).getCallIdBytes();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public ToolCallParams getParams() {
            return ((ToolCall) this.instance).getParams();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public ToolCallResult getResult() {
            return ((ToolCall) this.instance).getResult();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public Tool getTool() {
            return ((ToolCall) this.instance).getTool();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public boolean hasParams() {
            return ((ToolCall) this.instance).hasParams();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public boolean hasResult() {
            return ((ToolCall) this.instance).hasResult();
        }

        @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
        public boolean hasTool() {
            return ((ToolCall) this.instance).hasTool();
        }

        public Builder mergeParams(ToolCallParams toolCallParams) {
            copyOnWrite();
            ((ToolCall) this.instance).mergeParams(toolCallParams);
            return this;
        }

        public Builder mergeResult(ToolCallResult toolCallResult) {
            copyOnWrite();
            ((ToolCall) this.instance).mergeResult(toolCallResult);
            return this;
        }

        public Builder mergeTool(Tool tool) {
            copyOnWrite();
            ((ToolCall) this.instance).mergeTool(tool);
            return this;
        }

        public Builder setCallId(String str) {
            copyOnWrite();
            ((ToolCall) this.instance).setCallId(str);
            return this;
        }

        public Builder setCallIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCall) this.instance).setCallIdBytes(byteString);
            return this;
        }

        public Builder setParams(ToolCallParams toolCallParams) {
            copyOnWrite();
            ((ToolCall) this.instance).setParams(toolCallParams);
            return this;
        }

        public Builder setResult(ToolCallResult toolCallResult) {
            copyOnWrite();
            ((ToolCall) this.instance).setResult(toolCallResult);
            return this;
        }

        public Builder setTool(Tool tool) {
            copyOnWrite();
            ((ToolCall) this.instance).setTool(tool);
            return this;
        }

        private Builder() {
            super(ToolCall.DEFAULT_INSTANCE);
        }

        public Builder setParams(ToolCallParams.Builder builder) {
            copyOnWrite();
            ((ToolCall) this.instance).setParams(builder.build());
            return this;
        }

        public Builder setResult(ToolCallResult.Builder builder) {
            copyOnWrite();
            ((ToolCall) this.instance).setResult(builder.build());
            return this;
        }

        public Builder setTool(Tool.Builder builder) {
            copyOnWrite();
            ((ToolCall) this.instance).setTool(builder.build());
            return this;
        }
    }

    static {
        ToolCall toolCall = new ToolCall();
        DEFAULT_INSTANCE = toolCall;
        GeneratedMessageLite.registerDefaultInstance(ToolCall.class, toolCall);
    }

    private ToolCall() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallId() {
        this.callId_ = getDefaultInstance().getCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResult() {
        this.result_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTool() {
        this.tool_ = null;
        this.bitField0_ &= -2;
    }

    public static ToolCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(ToolCallParams toolCallParams) {
        toolCallParams.getClass();
        ToolCallParams toolCallParams2 = this.params_;
        if (toolCallParams2 == null || toolCallParams2 == ToolCallParams.getDefaultInstance()) {
            this.params_ = toolCallParams;
        } else {
            this.params_ = ToolCallParams.newBuilder(this.params_).mergeFrom((ToolCallParams.Builder) toolCallParams).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResult(ToolCallResult toolCallResult) {
        toolCallResult.getClass();
        ToolCallResult toolCallResult2 = this.result_;
        if (toolCallResult2 == null || toolCallResult2 == ToolCallResult.getDefaultInstance()) {
            this.result_ = toolCallResult;
        } else {
            this.result_ = ToolCallResult.newBuilder(this.result_).mergeFrom((ToolCallResult.Builder) toolCallResult).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTool(Tool tool) {
        tool.getClass();
        Tool tool2 = this.tool_;
        if (tool2 == null || tool2 == Tool.getDefaultInstance()) {
            this.tool_ = tool;
        } else {
            this.tool_ = Tool.newBuilder(this.tool_).mergeFrom((Tool.Builder) tool).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ToolCall parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCall parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolCall> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(String str) {
        str.getClass();
        this.callId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.callId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(ToolCallParams toolCallParams) {
        toolCallParams.getClass();
        this.params_ = toolCallParams;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(ToolCallResult toolCallResult) {
        toolCallResult.getClass();
        this.result_ = toolCallResult;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTool(Tool tool) {
        tool.getClass();
        this.tool_ = tool;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ToolCall();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "callId_", "tool_", "params_", "result_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolCall> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolCall.class) {
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

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public String getCallId() {
        return this.callId_;
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public ByteString getCallIdBytes() {
        return ByteString.copyFromUtf8(this.callId_);
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public ToolCallParams getParams() {
        ToolCallParams toolCallParams = this.params_;
        return toolCallParams == null ? ToolCallParams.getDefaultInstance() : toolCallParams;
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public ToolCallResult getResult() {
        ToolCallResult toolCallResult = this.result_;
        return toolCallResult == null ? ToolCallResult.getDefaultInstance() : toolCallResult;
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public Tool getTool() {
        Tool tool = this.tool_;
        return tool == null ? Tool.getDefaultInstance() : tool;
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public boolean hasParams() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public boolean hasResult() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.skull.ToolCallOrBuilder
    public boolean hasTool() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ToolCall toolCall) {
        return DEFAULT_INSTANCE.createBuilder(toolCall);
    }

    public static ToolCall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCall parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolCall parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolCall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolCall parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolCall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolCall parseFrom(InputStream inputStream) throws IOException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCall parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolCall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
