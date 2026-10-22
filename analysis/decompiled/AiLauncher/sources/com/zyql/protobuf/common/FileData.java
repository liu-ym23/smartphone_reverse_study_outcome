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
public final class FileData extends GeneratedMessageLite<FileData, Builder> implements FileDataOrBuilder {
    private static final FileData DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int MIME_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<FileData> PARSER = null;
    public static final int URI_FIELD_NUMBER = 1;
    private String uri_ = "";
    private String displayName_ = "";
    private String mimeType_ = "";

    /* renamed from: com.zyql.protobuf.common.FileData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<FileData, Builder> implements FileDataOrBuilder {
        public Builder clearDisplayName() {
            copyOnWrite();
            ((FileData) this.instance).clearDisplayName();
            return this;
        }

        public Builder clearMimeType() {
            copyOnWrite();
            ((FileData) this.instance).clearMimeType();
            return this;
        }

        public Builder clearUri() {
            copyOnWrite();
            ((FileData) this.instance).clearUri();
            return this;
        }

        @Override // com.zyql.protobuf.common.FileDataOrBuilder
        public String getDisplayName() {
            return ((FileData) this.instance).getDisplayName();
        }

        @Override // com.zyql.protobuf.common.FileDataOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((FileData) this.instance).getDisplayNameBytes();
        }

        @Override // com.zyql.protobuf.common.FileDataOrBuilder
        public String getMimeType() {
            return ((FileData) this.instance).getMimeType();
        }

        @Override // com.zyql.protobuf.common.FileDataOrBuilder
        public ByteString getMimeTypeBytes() {
            return ((FileData) this.instance).getMimeTypeBytes();
        }

        @Override // com.zyql.protobuf.common.FileDataOrBuilder
        public String getUri() {
            return ((FileData) this.instance).getUri();
        }

        @Override // com.zyql.protobuf.common.FileDataOrBuilder
        public ByteString getUriBytes() {
            return ((FileData) this.instance).getUriBytes();
        }

        public Builder setDisplayName(String str) {
            copyOnWrite();
            ((FileData) this.instance).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FileData) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setMimeType(String str) {
            copyOnWrite();
            ((FileData) this.instance).setMimeType(str);
            return this;
        }

        public Builder setMimeTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FileData) this.instance).setMimeTypeBytes(byteString);
            return this;
        }

        public Builder setUri(String str) {
            copyOnWrite();
            ((FileData) this.instance).setUri(str);
            return this;
        }

        public Builder setUriBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((FileData) this.instance).setUriBytes(byteString);
            return this;
        }

        private Builder() {
            super(FileData.DEFAULT_INSTANCE);
        }
    }

    static {
        FileData fileData = new FileData();
        DEFAULT_INSTANCE = fileData;
        GeneratedMessageLite.registerDefaultInstance(FileData.class, fileData);
    }

    private FileData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUri() {
        this.uri_ = getDefaultInstance().getUri();
    }

    public static FileData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static FileData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FileData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FileData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<FileData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setUri(String str) {
        str.getClass();
        this.uri_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUriBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uri_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new FileData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"uri_", "displayName_", "mimeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FileData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FileData.class) {
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

    @Override // com.zyql.protobuf.common.FileDataOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.zyql.protobuf.common.FileDataOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.zyql.protobuf.common.FileDataOrBuilder
    public String getMimeType() {
        return this.mimeType_;
    }

    @Override // com.zyql.protobuf.common.FileDataOrBuilder
    public ByteString getMimeTypeBytes() {
        return ByteString.copyFromUtf8(this.mimeType_);
    }

    @Override // com.zyql.protobuf.common.FileDataOrBuilder
    public String getUri() {
        return this.uri_;
    }

    @Override // com.zyql.protobuf.common.FileDataOrBuilder
    public ByteString getUriBytes() {
        return ByteString.copyFromUtf8(this.uri_);
    }

    public static Builder newBuilder(FileData fileData) {
        return DEFAULT_INSTANCE.createBuilder(fileData);
    }

    public static FileData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FileData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FileData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FileData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FileData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FileData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FileData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FileData parseFrom(InputStream inputStream) throws IOException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FileData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FileData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FileData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FileData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
