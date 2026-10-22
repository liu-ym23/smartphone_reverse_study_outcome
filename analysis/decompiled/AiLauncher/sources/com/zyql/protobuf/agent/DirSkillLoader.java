package com.zyql.protobuf.agent;

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
public final class DirSkillLoader extends GeneratedMessageLite<DirSkillLoader, Builder> implements DirSkillLoaderOrBuilder {
    private static final DirSkillLoader DEFAULT_INSTANCE;
    public static final int IS_SEPARATE_FIELD_NUMBER = 2;
    private static volatile Parser<DirSkillLoader> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean isSeparate_;
    private String path_ = "";

    /* renamed from: com.zyql.protobuf.agent.DirSkillLoader$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<DirSkillLoader, Builder> implements DirSkillLoaderOrBuilder {
        public Builder clearIsSeparate() {
            copyOnWrite();
            ((DirSkillLoader) this.instance).clearIsSeparate();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((DirSkillLoader) this.instance).clearPath();
            return this;
        }

        @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
        public boolean getIsSeparate() {
            return ((DirSkillLoader) this.instance).getIsSeparate();
        }

        @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
        public String getPath() {
            return ((DirSkillLoader) this.instance).getPath();
        }

        @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
        public ByteString getPathBytes() {
            return ((DirSkillLoader) this.instance).getPathBytes();
        }

        @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
        public boolean hasIsSeparate() {
            return ((DirSkillLoader) this.instance).hasIsSeparate();
        }

        public Builder setIsSeparate(boolean z10) {
            copyOnWrite();
            ((DirSkillLoader) this.instance).setIsSeparate(z10);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((DirSkillLoader) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((DirSkillLoader) this.instance).setPathBytes(byteString);
            return this;
        }

        private Builder() {
            super(DirSkillLoader.DEFAULT_INSTANCE);
        }
    }

    static {
        DirSkillLoader dirSkillLoader = new DirSkillLoader();
        DEFAULT_INSTANCE = dirSkillLoader;
        GeneratedMessageLite.registerDefaultInstance(DirSkillLoader.class, dirSkillLoader);
    }

    private DirSkillLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsSeparate() {
        this.bitField0_ &= -2;
        this.isSeparate_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.path_ = getDefaultInstance().getPath();
    }

    public static DirSkillLoader getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DirSkillLoader parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DirSkillLoader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DirSkillLoader parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DirSkillLoader> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsSeparate(boolean z10) {
        this.bitField0_ |= 1;
        this.isSeparate_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(String str) {
        str.getClass();
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.path_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new DirSkillLoader();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဇ\u0000", new Object[]{"bitField0_", "path_", "isSeparate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DirSkillLoader> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DirSkillLoader.class) {
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

    @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
    public boolean getIsSeparate() {
        return this.isSeparate_;
    }

    @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // com.zyql.protobuf.agent.DirSkillLoaderOrBuilder
    public boolean hasIsSeparate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(DirSkillLoader dirSkillLoader) {
        return DEFAULT_INSTANCE.createBuilder(dirSkillLoader);
    }

    public static DirSkillLoader parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DirSkillLoader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DirSkillLoader parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DirSkillLoader parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DirSkillLoader parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DirSkillLoader parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DirSkillLoader parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DirSkillLoader parseFrom(InputStream inputStream) throws IOException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DirSkillLoader parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DirSkillLoader parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DirSkillLoader parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DirSkillLoader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
