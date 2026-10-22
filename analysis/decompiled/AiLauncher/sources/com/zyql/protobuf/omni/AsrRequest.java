package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.omni.Audio;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class AsrRequest extends GeneratedMessageLite<AsrRequest, Builder> implements AsrRequestOrBuilder {
    public static final int AUDIO_FIELD_NUMBER = 1;
    private static final AsrRequest DEFAULT_INSTANCE;
    private static volatile Parser<AsrRequest> PARSER;
    private Audio audio_;
    private int bitField0_;

    /* renamed from: com.zyql.protobuf.omni.AsrRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AsrRequest, Builder> implements AsrRequestOrBuilder {
        public Builder clearAudio() {
            copyOnWrite();
            ((AsrRequest) this.instance).clearAudio();
            return this;
        }

        @Override // com.zyql.protobuf.omni.AsrRequestOrBuilder
        public Audio getAudio() {
            return ((AsrRequest) this.instance).getAudio();
        }

        @Override // com.zyql.protobuf.omni.AsrRequestOrBuilder
        public boolean hasAudio() {
            return ((AsrRequest) this.instance).hasAudio();
        }

        public Builder mergeAudio(Audio audio) {
            copyOnWrite();
            ((AsrRequest) this.instance).mergeAudio(audio);
            return this;
        }

        public Builder setAudio(Audio audio) {
            copyOnWrite();
            ((AsrRequest) this.instance).setAudio(audio);
            return this;
        }

        private Builder() {
            super(AsrRequest.DEFAULT_INSTANCE);
        }

        public Builder setAudio(Audio.Builder builder) {
            copyOnWrite();
            ((AsrRequest) this.instance).setAudio(builder.build());
            return this;
        }
    }

    static {
        AsrRequest asrRequest = new AsrRequest();
        DEFAULT_INSTANCE = asrRequest;
        GeneratedMessageLite.registerDefaultInstance(AsrRequest.class, asrRequest);
    }

    private AsrRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudio() {
        this.audio_ = null;
        this.bitField0_ &= -2;
    }

    public static AsrRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAudio(Audio audio) {
        audio.getClass();
        Audio audio2 = this.audio_;
        if (audio2 == null || audio2 == Audio.getDefaultInstance()) {
            this.audio_ = audio;
        } else {
            this.audio_ = Audio.newBuilder(this.audio_).mergeFrom((Audio.Builder) audio).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AsrRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AsrRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AsrRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AsrRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudio(Audio audio) {
        audio.getClass();
        this.audio_ = audio;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AsrRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "audio_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AsrRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AsrRequest.class) {
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

    @Override // com.zyql.protobuf.omni.AsrRequestOrBuilder
    public Audio getAudio() {
        Audio audio = this.audio_;
        return audio == null ? Audio.getDefaultInstance() : audio;
    }

    @Override // com.zyql.protobuf.omni.AsrRequestOrBuilder
    public boolean hasAudio() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(AsrRequest asrRequest) {
        return DEFAULT_INSTANCE.createBuilder(asrRequest);
    }

    public static AsrRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AsrRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AsrRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AsrRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AsrRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AsrRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AsrRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AsrRequest parseFrom(InputStream inputStream) throws IOException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AsrRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AsrRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AsrRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AsrRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
