package com.zyql.protobuf.skull;

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
public final class ToolCallResult extends GeneratedMessageLite<ToolCallResult, Builder> implements ToolCallResultOrBuilder {
    private static final ToolCallResult DEFAULT_INSTANCE;
    private static volatile Parser<ToolCallResult> PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 1;
    private String result_ = "";

    /* renamed from: com.zyql.protobuf.skull.ToolCallResult$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ToolCallResult, Builder> implements ToolCallResultOrBuilder {
        public Builder clearResult() {
            copyOnWrite();
            ((ToolCallResult) this.instance).clearResult();
            return this;
        }

        @Override // com.zyql.protobuf.skull.ToolCallResultOrBuilder
        public String getResult() {
            return ((ToolCallResult) this.instance).getResult();
        }

        @Override // com.zyql.protobuf.skull.ToolCallResultOrBuilder
        public ByteString getResultBytes() {
            return ((ToolCallResult) this.instance).getResultBytes();
        }

        public Builder setResult(String str) {
            copyOnWrite();
            ((ToolCallResult) this.instance).setResult(str);
            return this;
        }

        public Builder setResultBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ToolCallResult) this.instance).setResultBytes(byteString);
            return this;
        }

        private Builder() {
            super(ToolCallResult.DEFAULT_INSTANCE);
        }
    }

    static {
        ToolCallResult toolCallResult = new ToolCallResult();
        DEFAULT_INSTANCE = toolCallResult;
        GeneratedMessageLite.registerDefaultInstance(ToolCallResult.class, toolCallResult);
    }

    private ToolCallResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResult() {
        this.result_ = getDefaultInstance().getResult();
    }

    public static ToolCallResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ToolCallResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ToolCallResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ToolCallResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(String str) {
        str.getClass();
        this.result_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResultBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.result_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ToolCallResult();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"result_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ToolCallResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ToolCallResult.class) {
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

    @Override // com.zyql.protobuf.skull.ToolCallResultOrBuilder
    public String getResult() {
        return this.result_;
    }

    @Override // com.zyql.protobuf.skull.ToolCallResultOrBuilder
    public ByteString getResultBytes() {
        return ByteString.copyFromUtf8(this.result_);
    }

    public static Builder newBuilder(ToolCallResult toolCallResult) {
        return DEFAULT_INSTANCE.createBuilder(toolCallResult);
    }

    public static ToolCallResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ToolCallResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ToolCallResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ToolCallResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ToolCallResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ToolCallResult parseFrom(InputStream inputStream) throws IOException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ToolCallResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ToolCallResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ToolCallResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ToolCallResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
