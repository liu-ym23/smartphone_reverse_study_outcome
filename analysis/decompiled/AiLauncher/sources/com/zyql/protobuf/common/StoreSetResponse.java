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
public final class StoreSetResponse extends GeneratedMessageLite<StoreSetResponse, Builder> implements StoreSetResponseOrBuilder {
    private static final StoreSetResponse DEFAULT_INSTANCE;
    private static volatile Parser<StoreSetResponse> PARSER = null;
    public static final int PREVIOUS_VALUE_FIELD_NUMBER = 3;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    public static final int UPDATED_FIELD_NUMBER = 2;
    private int bitField0_;
    private String previousValue_ = "";
    private boolean success_;
    private boolean updated_;

    /* renamed from: com.zyql.protobuf.common.StoreSetResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreSetResponse, Builder> implements StoreSetResponseOrBuilder {
        public Builder clearPreviousValue() {
            copyOnWrite();
            ((StoreSetResponse) this.instance).clearPreviousValue();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((StoreSetResponse) this.instance).clearSuccess();
            return this;
        }

        public Builder clearUpdated() {
            copyOnWrite();
            ((StoreSetResponse) this.instance).clearUpdated();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
        public String getPreviousValue() {
            return ((StoreSetResponse) this.instance).getPreviousValue();
        }

        @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
        public ByteString getPreviousValueBytes() {
            return ((StoreSetResponse) this.instance).getPreviousValueBytes();
        }

        @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
        public boolean getSuccess() {
            return ((StoreSetResponse) this.instance).getSuccess();
        }

        @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
        public boolean getUpdated() {
            return ((StoreSetResponse) this.instance).getUpdated();
        }

        @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
        public boolean hasPreviousValue() {
            return ((StoreSetResponse) this.instance).hasPreviousValue();
        }

        public Builder setPreviousValue(String str) {
            copyOnWrite();
            ((StoreSetResponse) this.instance).setPreviousValue(str);
            return this;
        }

        public Builder setPreviousValueBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreSetResponse) this.instance).setPreviousValueBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((StoreSetResponse) this.instance).setSuccess(z10);
            return this;
        }

        public Builder setUpdated(boolean z10) {
            copyOnWrite();
            ((StoreSetResponse) this.instance).setUpdated(z10);
            return this;
        }

        private Builder() {
            super(StoreSetResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreSetResponse storeSetResponse = new StoreSetResponse();
        DEFAULT_INSTANCE = storeSetResponse;
        GeneratedMessageLite.registerDefaultInstance(StoreSetResponse.class, storeSetResponse);
    }

    private StoreSetResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreviousValue() {
        this.bitField0_ &= -2;
        this.previousValue_ = getDefaultInstance().getPreviousValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdated() {
        this.updated_ = false;
    }

    public static StoreSetResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreSetResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreSetResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreSetResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreSetResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreviousValue(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.previousValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreviousValueBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.previousValue_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdated(boolean z10) {
        this.updated_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StoreSetResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003ለ\u0000", new Object[]{"bitField0_", "success_", "updated_", "previousValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreSetResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreSetResponse.class) {
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

    @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
    public String getPreviousValue() {
        return this.previousValue_;
    }

    @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
    public ByteString getPreviousValueBytes() {
        return ByteString.copyFromUtf8(this.previousValue_);
    }

    @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
    public boolean getUpdated() {
        return this.updated_;
    }

    @Override // com.zyql.protobuf.common.StoreSetResponseOrBuilder
    public boolean hasPreviousValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StoreSetResponse storeSetResponse) {
        return DEFAULT_INSTANCE.createBuilder(storeSetResponse);
    }

    public static StoreSetResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreSetResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreSetResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreSetResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreSetResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreSetResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreSetResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreSetResponse parseFrom(InputStream inputStream) throws IOException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreSetResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreSetResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreSetResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreSetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
