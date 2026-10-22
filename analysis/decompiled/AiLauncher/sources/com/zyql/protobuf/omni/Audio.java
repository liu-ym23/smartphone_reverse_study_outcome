package com.zyql.protobuf.omni;

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
public final class Audio extends GeneratedMessageLite<Audio, Builder> implements AudioOrBuilder {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Audio DEFAULT_INSTANCE;
    public static final int IS_END_FIELD_NUMBER = 2;
    private static volatile Parser<Audio> PARSER;
    private ByteString data_ = ByteString.EMPTY;
    private boolean isEnd_;

    /* renamed from: com.zyql.protobuf.omni.Audio$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Audio, Builder> implements AudioOrBuilder {
        public Builder clearData() {
            copyOnWrite();
            ((Audio) this.instance).clearData();
            return this;
        }

        public Builder clearIsEnd() {
            copyOnWrite();
            ((Audio) this.instance).clearIsEnd();
            return this;
        }

        @Override // com.zyql.protobuf.omni.AudioOrBuilder
        public ByteString getData() {
            return ((Audio) this.instance).getData();
        }

        @Override // com.zyql.protobuf.omni.AudioOrBuilder
        public boolean getIsEnd() {
            return ((Audio) this.instance).getIsEnd();
        }

        public Builder setData(ByteString byteString) {
            copyOnWrite();
            ((Audio) this.instance).setData(byteString);
            return this;
        }

        public Builder setIsEnd(boolean z10) {
            copyOnWrite();
            ((Audio) this.instance).setIsEnd(z10);
            return this;
        }

        private Builder() {
            super(Audio.DEFAULT_INSTANCE);
        }
    }

    static {
        Audio audio = new Audio();
        DEFAULT_INSTANCE = audio;
        GeneratedMessageLite.registerDefaultInstance(Audio.class, audio);
    }

    private Audio() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsEnd() {
        this.isEnd_ = false;
    }

    public static Audio getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Audio parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Audio) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Audio parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Audio> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ByteString byteString) {
        byteString.getClass();
        this.data_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsEnd(boolean z10) {
        this.isEnd_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Audio();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\u0007", new Object[]{"data_", "isEnd_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Audio> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Audio.class) {
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

    @Override // com.zyql.protobuf.omni.AudioOrBuilder
    public ByteString getData() {
        return this.data_;
    }

    @Override // com.zyql.protobuf.omni.AudioOrBuilder
    public boolean getIsEnd() {
        return this.isEnd_;
    }

    public static Builder newBuilder(Audio audio) {
        return DEFAULT_INSTANCE.createBuilder(audio);
    }

    public static Audio parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Audio) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Audio parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Audio parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Audio parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Audio parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Audio parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Audio parseFrom(InputStream inputStream) throws IOException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Audio parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Audio parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Audio parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
