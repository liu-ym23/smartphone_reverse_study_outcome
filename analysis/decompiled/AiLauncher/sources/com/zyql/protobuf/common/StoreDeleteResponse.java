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
public final class StoreDeleteResponse extends GeneratedMessageLite<StoreDeleteResponse, Builder> implements StoreDeleteResponseOrBuilder {
    private static final StoreDeleteResponse DEFAULT_INSTANCE;
    public static final int DELETED_FIELD_NUMBER = 1;
    private static volatile Parser<StoreDeleteResponse> PARSER = null;
    public static final int PREVIOUS_VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean deleted_;
    private String previousValue_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreDeleteResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreDeleteResponse, Builder> implements StoreDeleteResponseOrBuilder {
        public Builder clearDeleted() {
            copyOnWrite();
            ((StoreDeleteResponse) this.instance).clearDeleted();
            return this;
        }

        public Builder clearPreviousValue() {
            copyOnWrite();
            ((StoreDeleteResponse) this.instance).clearPreviousValue();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
        public boolean getDeleted() {
            return ((StoreDeleteResponse) this.instance).getDeleted();
        }

        @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
        public String getPreviousValue() {
            return ((StoreDeleteResponse) this.instance).getPreviousValue();
        }

        @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
        public ByteString getPreviousValueBytes() {
            return ((StoreDeleteResponse) this.instance).getPreviousValueBytes();
        }

        @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
        public boolean hasPreviousValue() {
            return ((StoreDeleteResponse) this.instance).hasPreviousValue();
        }

        public Builder setDeleted(boolean z10) {
            copyOnWrite();
            ((StoreDeleteResponse) this.instance).setDeleted(z10);
            return this;
        }

        public Builder setPreviousValue(String str) {
            copyOnWrite();
            ((StoreDeleteResponse) this.instance).setPreviousValue(str);
            return this;
        }

        public Builder setPreviousValueBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreDeleteResponse) this.instance).setPreviousValueBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreDeleteResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreDeleteResponse storeDeleteResponse = new StoreDeleteResponse();
        DEFAULT_INSTANCE = storeDeleteResponse;
        GeneratedMessageLite.registerDefaultInstance(StoreDeleteResponse.class, storeDeleteResponse);
    }

    private StoreDeleteResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeleted() {
        this.deleted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreviousValue() {
        this.bitField0_ &= -2;
        this.previousValue_ = getDefaultInstance().getPreviousValue();
    }

    public static StoreDeleteResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreDeleteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreDeleteResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreDeleteResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleted(boolean z10) {
        this.deleted_ = z10;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StoreDeleteResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002ለ\u0000", new Object[]{"bitField0_", "deleted_", "previousValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreDeleteResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreDeleteResponse.class) {
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

    @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
    public boolean getDeleted() {
        return this.deleted_;
    }

    @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
    public String getPreviousValue() {
        return this.previousValue_;
    }

    @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
    public ByteString getPreviousValueBytes() {
        return ByteString.copyFromUtf8(this.previousValue_);
    }

    @Override // com.zyql.protobuf.common.StoreDeleteResponseOrBuilder
    public boolean hasPreviousValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StoreDeleteResponse storeDeleteResponse) {
        return DEFAULT_INSTANCE.createBuilder(storeDeleteResponse);
    }

    public static StoreDeleteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreDeleteResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreDeleteResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreDeleteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreDeleteResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreDeleteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreDeleteResponse parseFrom(InputStream inputStream) throws IOException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreDeleteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreDeleteResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreDeleteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreDeleteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
