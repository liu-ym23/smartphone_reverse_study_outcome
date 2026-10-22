package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.zyql.protobuf.skull.Message;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class AskInput extends GeneratedMessageLite<AskInput, Builder> implements AskInputOrBuilder {
    private static final AskInput DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AskInput> PARSER;
    private int bitField0_;
    private Message message_;
    private MapFieldLite<String, String> params_ = MapFieldLite.emptyMapField();

    /* renamed from: com.zyql.protobuf.skull.AskInput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AskInput, Builder> implements AskInputOrBuilder {
        public Builder clearMessage() {
            copyOnWrite();
            ((AskInput) this.instance).clearMessage();
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AskInput) this.instance).getMutableParamsMap().clear();
            return this;
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public boolean containsParams(String str) {
            str.getClass();
            return ((AskInput) this.instance).getParamsMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public Message getMessage() {
            return ((AskInput) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        @Deprecated
        public Map<String, String> getParams() {
            return getParamsMap();
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public int getParamsCount() {
            return ((AskInput) this.instance).getParamsMap().size();
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public Map<String, String> getParamsMap() {
            return Collections.unmodifiableMap(((AskInput) this.instance).getParamsMap());
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public String getParamsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> paramsMap = ((AskInput) this.instance).getParamsMap();
            return paramsMap.containsKey(str) ? paramsMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public String getParamsOrThrow(String str) {
            str.getClass();
            Map<String, String> paramsMap = ((AskInput) this.instance).getParamsMap();
            if (paramsMap.containsKey(str)) {
                return paramsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.skull.AskInputOrBuilder
        public boolean hasMessage() {
            return ((AskInput) this.instance).hasMessage();
        }

        public Builder mergeMessage(Message message) {
            copyOnWrite();
            ((AskInput) this.instance).mergeMessage(message);
            return this;
        }

        public Builder putAllParams(Map<String, String> map) {
            copyOnWrite();
            ((AskInput) this.instance).getMutableParamsMap().putAll(map);
            return this;
        }

        public Builder putParams(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((AskInput) this.instance).getMutableParamsMap().put(str, str2);
            return this;
        }

        public Builder removeParams(String str) {
            str.getClass();
            copyOnWrite();
            ((AskInput) this.instance).getMutableParamsMap().remove(str);
            return this;
        }

        public Builder setMessage(Message message) {
            copyOnWrite();
            ((AskInput) this.instance).setMessage(message);
            return this;
        }

        private Builder() {
            super(AskInput.DEFAULT_INSTANCE);
        }

        public Builder setMessage(Message.Builder builder) {
            copyOnWrite();
            ((AskInput) this.instance).setMessage(builder.build());
            return this;
        }
    }

    public static final class ParamsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ParamsDefaultEntryHolder() {
        }
    }

    static {
        AskInput askInput = new AskInput();
        DEFAULT_INSTANCE = askInput;
        GeneratedMessageLite.registerDefaultInstance(AskInput.class, askInput);
    }

    private AskInput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    public static AskInput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableParamsMap() {
        return internalGetMutableParams();
    }

    private MapFieldLite<String, String> internalGetMutableParams() {
        if (!this.params_.isMutable()) {
            this.params_ = this.params_.mutableCopy();
        }
        return this.params_;
    }

    private MapFieldLite<String, String> internalGetParams() {
        return this.params_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessage(Message message) {
        message.getClass();
        Message message2 = this.message_;
        if (message2 == null || message2 == Message.getDefaultInstance()) {
            this.message_ = message;
        } else {
            this.message_ = Message.newBuilder(this.message_).mergeFrom((Message.Builder) message).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AskInput parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AskInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AskInput parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AskInput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(Message message) {
        message.getClass();
        this.message_ = message;
        this.bitField0_ |= 1;
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public boolean containsParams(String str) {
        str.getClass();
        return internalGetParams().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AskInput();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0001\u0000\u0000\u00012\u0002ဉ\u0000", new Object[]{"bitField0_", "params_", ParamsDefaultEntryHolder.defaultEntry, "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AskInput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AskInput.class) {
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

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public Message getMessage() {
        Message message = this.message_;
        return message == null ? Message.getDefaultInstance() : message;
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    @Deprecated
    public Map<String, String> getParams() {
        return getParamsMap();
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public int getParamsCount() {
        return internalGetParams().size();
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public Map<String, String> getParamsMap() {
        return Collections.unmodifiableMap(internalGetParams());
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public String getParamsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetParams = internalGetParams();
        return mapFieldLiteInternalGetParams.containsKey(str) ? mapFieldLiteInternalGetParams.get(str) : str2;
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public String getParamsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetParams = internalGetParams();
        if (mapFieldLiteInternalGetParams.containsKey(str)) {
            return mapFieldLiteInternalGetParams.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.skull.AskInputOrBuilder
    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(AskInput askInput) {
        return DEFAULT_INSTANCE.createBuilder(askInput);
    }

    public static AskInput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AskInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AskInput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AskInput parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AskInput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AskInput parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AskInput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AskInput parseFrom(InputStream inputStream) throws IOException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AskInput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AskInput parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AskInput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AskInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
