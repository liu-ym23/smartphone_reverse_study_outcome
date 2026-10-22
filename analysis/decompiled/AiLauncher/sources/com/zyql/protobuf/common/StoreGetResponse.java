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
public final class StoreGetResponse extends GeneratedMessageLite<StoreGetResponse, Builder> implements StoreGetResponseOrBuilder {
    private static final StoreGetResponse DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    private static volatile Parser<StoreGetResponse> PARSER = null;
    public static final int TTL_SECONDS_FIELD_NUMBER = 4;
    public static final int UPDATED_AT_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean found_;
    private long ttlSeconds_;
    private long updatedAt_;
    private String value_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreGetResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreGetResponse, Builder> implements StoreGetResponseOrBuilder {
        public Builder clearFound() {
            copyOnWrite();
            ((StoreGetResponse) this.instance).clearFound();
            return this;
        }

        public Builder clearTtlSeconds() {
            copyOnWrite();
            ((StoreGetResponse) this.instance).clearTtlSeconds();
            return this;
        }

        public Builder clearUpdatedAt() {
            copyOnWrite();
            ((StoreGetResponse) this.instance).clearUpdatedAt();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((StoreGetResponse) this.instance).clearValue();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
        public boolean getFound() {
            return ((StoreGetResponse) this.instance).getFound();
        }

        @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
        public long getTtlSeconds() {
            return ((StoreGetResponse) this.instance).getTtlSeconds();
        }

        @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
        public long getUpdatedAt() {
            return ((StoreGetResponse) this.instance).getUpdatedAt();
        }

        @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
        public String getValue() {
            return ((StoreGetResponse) this.instance).getValue();
        }

        @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
        public ByteString getValueBytes() {
            return ((StoreGetResponse) this.instance).getValueBytes();
        }

        public Builder setFound(boolean z10) {
            copyOnWrite();
            ((StoreGetResponse) this.instance).setFound(z10);
            return this;
        }

        public Builder setTtlSeconds(long j10) {
            copyOnWrite();
            ((StoreGetResponse) this.instance).setTtlSeconds(j10);
            return this;
        }

        public Builder setUpdatedAt(long j10) {
            copyOnWrite();
            ((StoreGetResponse) this.instance).setUpdatedAt(j10);
            return this;
        }

        public Builder setValue(String str) {
            copyOnWrite();
            ((StoreGetResponse) this.instance).setValue(str);
            return this;
        }

        public Builder setValueBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreGetResponse) this.instance).setValueBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreGetResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreGetResponse storeGetResponse = new StoreGetResponse();
        DEFAULT_INSTANCE = storeGetResponse;
        GeneratedMessageLite.registerDefaultInstance(StoreGetResponse.class, storeGetResponse);
    }

    private StoreGetResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFound() {
        this.found_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTtlSeconds() {
        this.ttlSeconds_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static StoreGetResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreGetResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreGetResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreGetResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreGetResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFound(boolean z10) {
        this.found_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTtlSeconds(long j10) {
        this.ttlSeconds_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdatedAt(long j10) {
        this.updatedAt_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.value_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StoreGetResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003\u0002\u0004\u0002", new Object[]{"found_", "value_", "updatedAt_", "ttlSeconds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreGetResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreGetResponse.class) {
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

    @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
    public boolean getFound() {
        return this.found_;
    }

    @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
    public long getTtlSeconds() {
        return this.ttlSeconds_;
    }

    @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
    public String getValue() {
        return this.value_;
    }

    @Override // com.zyql.protobuf.common.StoreGetResponseOrBuilder
    public ByteString getValueBytes() {
        return ByteString.copyFromUtf8(this.value_);
    }

    public static Builder newBuilder(StoreGetResponse storeGetResponse) {
        return DEFAULT_INSTANCE.createBuilder(storeGetResponse);
    }

    public static StoreGetResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreGetResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreGetResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreGetResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreGetResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreGetResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreGetResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreGetResponse parseFrom(InputStream inputStream) throws IOException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreGetResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreGetResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreGetResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreGetResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
