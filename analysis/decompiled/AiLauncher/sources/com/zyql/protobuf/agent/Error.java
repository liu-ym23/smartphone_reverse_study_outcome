package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Error extends GeneratedMessageLite<Error, Builder> implements ErrorOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final Error DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<Error> PARSER;
    private int code_;
    private MapFieldLite<String, String> details_ = MapFieldLite.emptyMapField();
    private String message_ = "";

    /* renamed from: com.zyql.protobuf.agent.Error$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Error, Builder> implements ErrorOrBuilder {
        public Builder clearCode() {
            copyOnWrite();
            ((Error) this.instance).clearCode();
            return this;
        }

        public Builder clearDetails() {
            copyOnWrite();
            ((Error) this.instance).getMutableDetailsMap().clear();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((Error) this.instance).clearMessage();
            return this;
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public boolean containsDetails(String str) {
            str.getClass();
            return ((Error) this.instance).getDetailsMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public ErrorCode getCode() {
            return ((Error) this.instance).getCode();
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public int getCodeValue() {
            return ((Error) this.instance).getCodeValue();
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        @Deprecated
        public Map<String, String> getDetails() {
            return getDetailsMap();
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public int getDetailsCount() {
            return ((Error) this.instance).getDetailsMap().size();
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public Map<String, String> getDetailsMap() {
            return Collections.unmodifiableMap(((Error) this.instance).getDetailsMap());
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public String getDetailsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> detailsMap = ((Error) this.instance).getDetailsMap();
            return detailsMap.containsKey(str) ? detailsMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public String getDetailsOrThrow(String str) {
            str.getClass();
            Map<String, String> detailsMap = ((Error) this.instance).getDetailsMap();
            if (detailsMap.containsKey(str)) {
                return detailsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public String getMessage() {
            return ((Error) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.agent.ErrorOrBuilder
        public ByteString getMessageBytes() {
            return ((Error) this.instance).getMessageBytes();
        }

        public Builder putAllDetails(Map<String, String> map) {
            copyOnWrite();
            ((Error) this.instance).getMutableDetailsMap().putAll(map);
            return this;
        }

        public Builder putDetails(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((Error) this.instance).getMutableDetailsMap().put(str, str2);
            return this;
        }

        public Builder removeDetails(String str) {
            str.getClass();
            copyOnWrite();
            ((Error) this.instance).getMutableDetailsMap().remove(str);
            return this;
        }

        public Builder setCode(ErrorCode errorCode) {
            copyOnWrite();
            ((Error) this.instance).setCode(errorCode);
            return this;
        }

        public Builder setCodeValue(int i10) {
            copyOnWrite();
            ((Error) this.instance).setCodeValue(i10);
            return this;
        }

        public Builder setMessage(String str) {
            copyOnWrite();
            ((Error) this.instance).setMessage(str);
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Error) this.instance).setMessageBytes(byteString);
            return this;
        }

        private Builder() {
            super(Error.DEFAULT_INSTANCE);
        }
    }

    public static final class DetailsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private DetailsDefaultEntryHolder() {
        }
    }

    static {
        Error error = new Error();
        DEFAULT_INSTANCE = error;
        GeneratedMessageLite.registerDefaultInstance(Error.class, error);
    }

    private Error() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static Error getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableDetailsMap() {
        return internalGetMutableDetails();
    }

    private MapFieldLite<String, String> internalGetDetails() {
        return this.details_;
    }

    private MapFieldLite<String, String> internalGetMutableDetails() {
        if (!this.details_.isMutable()) {
            this.details_ = this.details_.mutableCopy();
        }
        return this.details_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Error parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Error) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Error parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Error> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(ErrorCode errorCode) {
        this.code_ = errorCode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodeValue(int i10) {
        this.code_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public boolean containsDetails(String str) {
        str.getClass();
        return internalGetDetails().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Error();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001\f\u0002Ȉ\u00032", new Object[]{"code_", "message_", "details_", DetailsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Error> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Error.class) {
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

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public ErrorCode getCode() {
        ErrorCode errorCodeForNumber = ErrorCode.forNumber(this.code_);
        return errorCodeForNumber == null ? ErrorCode.UNRECOGNIZED : errorCodeForNumber;
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public int getCodeValue() {
        return this.code_;
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    @Deprecated
    public Map<String, String> getDetails() {
        return getDetailsMap();
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public int getDetailsCount() {
        return internalGetDetails().size();
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public Map<String, String> getDetailsMap() {
        return Collections.unmodifiableMap(internalGetDetails());
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public String getDetailsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetDetails = internalGetDetails();
        return mapFieldLiteInternalGetDetails.containsKey(str) ? mapFieldLiteInternalGetDetails.get(str) : str2;
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public String getDetailsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetDetails = internalGetDetails();
        if (mapFieldLiteInternalGetDetails.containsKey(str)) {
            return mapFieldLiteInternalGetDetails.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public String getMessage() {
        return this.message_;
    }

    @Override // com.zyql.protobuf.agent.ErrorOrBuilder
    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    public static Builder newBuilder(Error error) {
        return DEFAULT_INSTANCE.createBuilder(error);
    }

    public static Error parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Error) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Error parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Error parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Error parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Error parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Error parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Error parseFrom(InputStream inputStream) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Error parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Error parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Error parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
