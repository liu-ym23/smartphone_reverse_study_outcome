package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class FunctionCall extends GeneratedMessageLite<FunctionCall, Builder> implements FunctionCallOrBuilder {
    public static final int ARGS_FIELD_NUMBER = 3;
    private static final FunctionCall DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<FunctionCall> PARSER;
    private Struct args_;
    private int bitField0_;
    private String id_ = "";
    private String name_ = "";

    /* renamed from: com.zyql.protobuf.common.FunctionCall$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<FunctionCall, Builder> implements FunctionCallOrBuilder {
        public Builder clearArgs() {
            copyOnWrite();
            ((FunctionCall) this.instance).clearArgs();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((FunctionCall) this.instance).clearId();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((FunctionCall) this.instance).clearName();
            return this;
        }

        @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
        public Struct getArgs() {
            return ((FunctionCall) this.instance).getArgs();
        }

        @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
        public String getId() {
            return ((FunctionCall) this.instance).getId();
        }

        @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
        public ByteString getIdBytes() {
            return ((FunctionCall) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
        public String getName() {
            return ((FunctionCall) this.instance).getName();
        }

        @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
        public ByteString getNameBytes() {
            return ((FunctionCall) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
        public boolean hasArgs() {
            return ((FunctionCall) this.instance).hasArgs();
        }

        public Builder mergeArgs(Struct struct) {
            copyOnWrite();
            ((FunctionCall) this.instance).mergeArgs(struct);
            return this;
        }

        public Builder setArgs(Struct struct) {
            copyOnWrite();
            ((FunctionCall) this.instance).setArgs(struct);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((FunctionCall) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FunctionCall) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((FunctionCall) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FunctionCall) this.instance).setNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(FunctionCall.DEFAULT_INSTANCE);
        }

        public Builder setArgs(Struct.Builder builder) {
            copyOnWrite();
            ((FunctionCall) this.instance).setArgs(builder.build());
            return this;
        }
    }

    static {
        FunctionCall functionCall = new FunctionCall();
        DEFAULT_INSTANCE = functionCall;
        GeneratedMessageLite.registerDefaultInstance(FunctionCall.class, functionCall);
    }

    private FunctionCall() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArgs() {
        this.args_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static FunctionCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeArgs(Struct struct) {
        struct.getClass();
        Struct struct2 = this.args_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.args_ = struct;
        } else {
            this.args_ = Struct.newBuilder(this.args_).mergeFrom((Struct.Builder) struct).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static FunctionCall parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FunctionCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FunctionCall parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<FunctionCall> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArgs(Struct struct) {
        struct.getClass();
        this.args_ = struct;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new FunctionCall();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "id_", "name_", "args_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FunctionCall> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FunctionCall.class) {
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

    @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
    public Struct getArgs() {
        Struct struct = this.args_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.common.FunctionCallOrBuilder
    public boolean hasArgs() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(FunctionCall functionCall) {
        return DEFAULT_INSTANCE.createBuilder(functionCall);
    }

    public static FunctionCall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FunctionCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FunctionCall parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FunctionCall parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FunctionCall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FunctionCall parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FunctionCall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FunctionCall parseFrom(InputStream inputStream) throws IOException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FunctionCall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FunctionCall parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FunctionCall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FunctionCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
