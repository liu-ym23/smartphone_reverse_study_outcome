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
public final class PongResponse extends GeneratedMessageLite<PongResponse, Builder> implements PongResponseOrBuilder {
    private static final PongResponse DEFAULT_INSTANCE;
    private static volatile Parser<PongResponse> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 2;
    private long timestamp_;
    private String version_ = "";

    /* renamed from: com.zyql.protobuf.runtime.PongResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PongResponse, Builder> implements PongResponseOrBuilder {
        public Builder clearTimestamp() {
            copyOnWrite();
            ((PongResponse) this.instance).clearTimestamp();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((PongResponse) this.instance).clearVersion();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.PongResponseOrBuilder
        public long getTimestamp() {
            return ((PongResponse) this.instance).getTimestamp();
        }

        @Override // com.zyql.protobuf.runtime.PongResponseOrBuilder
        public String getVersion() {
            return ((PongResponse) this.instance).getVersion();
        }

        @Override // com.zyql.protobuf.runtime.PongResponseOrBuilder
        public ByteString getVersionBytes() {
            return ((PongResponse) this.instance).getVersionBytes();
        }

        public Builder setTimestamp(long j10) {
            copyOnWrite();
            ((PongResponse) this.instance).setTimestamp(j10);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((PongResponse) this.instance).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((PongResponse) this.instance).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(PongResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        PongResponse pongResponse = new PongResponse();
        DEFAULT_INSTANCE = pongResponse;
        GeneratedMessageLite.registerDefaultInstance(PongResponse.class, pongResponse);
    }

    private PongResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static PongResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PongResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PongResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PongResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PongResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j10) {
        this.timestamp_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.version_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new PongResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"timestamp_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PongResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PongResponse.class) {
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

    @Override // com.zyql.protobuf.runtime.PongResponseOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.zyql.protobuf.runtime.PongResponseOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.zyql.protobuf.runtime.PongResponseOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    public static Builder newBuilder(PongResponse pongResponse) {
        return DEFAULT_INSTANCE.createBuilder(pongResponse);
    }

    public static PongResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PongResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PongResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PongResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PongResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PongResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PongResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PongResponse parseFrom(InputStream inputStream) throws IOException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PongResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PongResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PongResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PongResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
