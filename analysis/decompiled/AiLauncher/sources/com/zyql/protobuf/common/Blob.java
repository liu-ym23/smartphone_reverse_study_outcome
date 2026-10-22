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
public final class Blob extends GeneratedMessageLite<Blob, Builder> implements BlobOrBuilder {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Blob DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int MIME_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<Blob> PARSER;
    private ByteString data_ = ByteString.EMPTY;
    private String displayName_ = "";
    private String mimeType_ = "";

    /* renamed from: com.zyql.protobuf.common.Blob$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Blob, Builder> implements BlobOrBuilder {
        public Builder clearData() {
            copyOnWrite();
            ((Blob) this.instance).clearData();
            return this;
        }

        public Builder clearDisplayName() {
            copyOnWrite();
            ((Blob) this.instance).clearDisplayName();
            return this;
        }

        public Builder clearMimeType() {
            copyOnWrite();
            ((Blob) this.instance).clearMimeType();
            return this;
        }

        @Override // com.zyql.protobuf.common.BlobOrBuilder
        public ByteString getData() {
            return ((Blob) this.instance).getData();
        }

        @Override // com.zyql.protobuf.common.BlobOrBuilder
        public String getDisplayName() {
            return ((Blob) this.instance).getDisplayName();
        }

        @Override // com.zyql.protobuf.common.BlobOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((Blob) this.instance).getDisplayNameBytes();
        }

        @Override // com.zyql.protobuf.common.BlobOrBuilder
        public String getMimeType() {
            return ((Blob) this.instance).getMimeType();
        }

        @Override // com.zyql.protobuf.common.BlobOrBuilder
        public ByteString getMimeTypeBytes() {
            return ((Blob) this.instance).getMimeTypeBytes();
        }

        public Builder setData(ByteString byteString) {
            copyOnWrite();
            ((Blob) this.instance).setData(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            copyOnWrite();
            ((Blob) this.instance).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Blob) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setMimeType(String str) {
            copyOnWrite();
            ((Blob) this.instance).setMimeType(str);
            return this;
        }

        public Builder setMimeTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Blob) this.instance).setMimeTypeBytes(byteString);
            return this;
        }

        private Builder() {
            super(Blob.DEFAULT_INSTANCE);
        }
    }

    static {
        Blob blob = new Blob();
        DEFAULT_INSTANCE = blob;
        GeneratedMessageLite.registerDefaultInstance(Blob.class, blob);
    }

    private Blob() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    public static Blob getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Blob parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Blob) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Blob parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Blob> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ByteString byteString) {
        byteString.getClass();
        this.data_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.mimeType_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Blob();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0002Ȉ\u0003Ȉ", new Object[]{"data_", "displayName_", "mimeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Blob> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Blob.class) {
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

    @Override // com.zyql.protobuf.common.BlobOrBuilder
    public ByteString getData() {
        return this.data_;
    }

    @Override // com.zyql.protobuf.common.BlobOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.zyql.protobuf.common.BlobOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.zyql.protobuf.common.BlobOrBuilder
    public String getMimeType() {
        return this.mimeType_;
    }

    @Override // com.zyql.protobuf.common.BlobOrBuilder
    public ByteString getMimeTypeBytes() {
        return ByteString.copyFromUtf8(this.mimeType_);
    }

    public static Builder newBuilder(Blob blob) {
        return DEFAULT_INSTANCE.createBuilder(blob);
    }

    public static Blob parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Blob) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Blob parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Blob parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Blob parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Blob parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Blob parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Blob parseFrom(InputStream inputStream) throws IOException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Blob parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Blob parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Blob parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Blob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
