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
public final class FunctionResponse extends GeneratedMessageLite<FunctionResponse, Builder> implements FunctionResponseOrBuilder {
    private static final FunctionResponse DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<FunctionResponse> PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 3;
    private int bitField0_;
    private String id_ = "";
    private String name_ = "";
    private Struct response_;

    /* renamed from: com.zyql.protobuf.common.FunctionResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<FunctionResponse, Builder> implements FunctionResponseOrBuilder {
        public Builder clearId() {
            copyOnWrite();
            ((FunctionResponse) this.instance).clearId();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((FunctionResponse) this.instance).clearName();
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            ((FunctionResponse) this.instance).clearResponse();
            return this;
        }

        @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
        public String getId() {
            return ((FunctionResponse) this.instance).getId();
        }

        @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
        public ByteString getIdBytes() {
            return ((FunctionResponse) this.instance).getIdBytes();
        }

        @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
        public String getName() {
            return ((FunctionResponse) this.instance).getName();
        }

        @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
        public ByteString getNameBytes() {
            return ((FunctionResponse) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
        public Struct getResponse() {
            return ((FunctionResponse) this.instance).getResponse();
        }

        @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
        public boolean hasResponse() {
            return ((FunctionResponse) this.instance).hasResponse();
        }

        public Builder mergeResponse(Struct struct) {
            copyOnWrite();
            ((FunctionResponse) this.instance).mergeResponse(struct);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((FunctionResponse) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FunctionResponse) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((FunctionResponse) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FunctionResponse) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setResponse(Struct struct) {
            copyOnWrite();
            ((FunctionResponse) this.instance).setResponse(struct);
            return this;
        }

        private Builder() {
            super(FunctionResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponse(Struct.Builder builder) {
            copyOnWrite();
            ((FunctionResponse) this.instance).setResponse(builder.build());
            return this;
        }
    }

    static {
        FunctionResponse functionResponse = new FunctionResponse();
        DEFAULT_INSTANCE = functionResponse;
        GeneratedMessageLite.registerDefaultInstance(FunctionResponse.class, functionResponse);
    }

    private FunctionResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        this.response_ = null;
        this.bitField0_ &= -2;
    }

    public static FunctionResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponse(Struct struct) {
        struct.getClass();
        Struct struct2 = this.response_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.response_ = struct;
        } else {
            this.response_ = Struct.newBuilder(this.response_).mergeFrom((Struct.Builder) struct).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static FunctionResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FunctionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FunctionResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<FunctionResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Struct struct) {
        struct.getClass();
        this.response_ = struct;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new FunctionResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "id_", "name_", "response_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FunctionResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FunctionResponse.class) {
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

    @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
    public Struct getResponse() {
        Struct struct = this.response_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.common.FunctionResponseOrBuilder
    public boolean hasResponse() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(FunctionResponse functionResponse) {
        return DEFAULT_INSTANCE.createBuilder(functionResponse);
    }

    public static FunctionResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FunctionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FunctionResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FunctionResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FunctionResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FunctionResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FunctionResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FunctionResponse parseFrom(InputStream inputStream) throws IOException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FunctionResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FunctionResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FunctionResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FunctionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
