package com.zyql.protobuf.runtime;

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
public final class CancelAck extends GeneratedMessageLite<CancelAck, Builder> implements CancelAckOrBuilder {
    private static final CancelAck DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 1;
    private static volatile Parser<CancelAck> PARSER;
    private int bitField0_;
    private String details_ = "";

    /* renamed from: com.zyql.protobuf.runtime.CancelAck$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CancelAck, Builder> implements CancelAckOrBuilder {
        public Builder clearDetails() {
            copyOnWrite();
            ((CancelAck) this.instance).clearDetails();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.CancelAckOrBuilder
        public String getDetails() {
            return ((CancelAck) this.instance).getDetails();
        }

        @Override // com.zyql.protobuf.runtime.CancelAckOrBuilder
        public ByteString getDetailsBytes() {
            return ((CancelAck) this.instance).getDetailsBytes();
        }

        @Override // com.zyql.protobuf.runtime.CancelAckOrBuilder
        public boolean hasDetails() {
            return ((CancelAck) this.instance).hasDetails();
        }

        public Builder setDetails(String str) {
            copyOnWrite();
            ((CancelAck) this.instance).setDetails(str);
            return this;
        }

        public Builder setDetailsBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((CancelAck) this.instance).setDetailsBytes(byteString);
            return this;
        }

        private Builder() {
            super(CancelAck.DEFAULT_INSTANCE);
        }
    }

    static {
        CancelAck cancelAck = new CancelAck();
        DEFAULT_INSTANCE = cancelAck;
        GeneratedMessageLite.registerDefaultInstance(CancelAck.class, cancelAck);
    }

    private CancelAck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetails() {
        this.bitField0_ &= -2;
        this.details_ = getDefaultInstance().getDetails();
    }

    public static CancelAck getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CancelAck parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CancelAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelAck parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CancelAck> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetails(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.details_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailsBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.details_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new CancelAck();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ለ\u0000", new Object[]{"bitField0_", "details_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CancelAck> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CancelAck.class) {
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

    @Override // com.zyql.protobuf.runtime.CancelAckOrBuilder
    public String getDetails() {
        return this.details_;
    }

    @Override // com.zyql.protobuf.runtime.CancelAckOrBuilder
    public ByteString getDetailsBytes() {
        return ByteString.copyFromUtf8(this.details_);
    }

    @Override // com.zyql.protobuf.runtime.CancelAckOrBuilder
    public boolean hasDetails() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(CancelAck cancelAck) {
        return DEFAULT_INSTANCE.createBuilder(cancelAck);
    }

    public static CancelAck parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelAck parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CancelAck parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CancelAck parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CancelAck parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CancelAck parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CancelAck parseFrom(InputStream inputStream) throws IOException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelAck parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelAck parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CancelAck parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
