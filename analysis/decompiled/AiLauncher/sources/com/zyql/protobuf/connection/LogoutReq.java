package com.zyql.protobuf.connection;

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
public final class LogoutReq extends GeneratedMessageLite<LogoutReq, Builder> implements LogoutReqOrBuilder {
    private static final LogoutReq DEFAULT_INSTANCE;
    private static volatile Parser<LogoutReq> PARSER = null;
    public static final int RESERVED_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> reserved_ = MapFieldLite.emptyMapField();

    /* renamed from: com.zyql.protobuf.connection.LogoutReq$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LogoutReq, Builder> implements LogoutReqOrBuilder {
        public Builder clearReserved() {
            copyOnWrite();
            ((LogoutReq) this.instance).getMutableReservedMap().clear();
            return this;
        }

        @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
        public boolean containsReserved(String str) {
            str.getClass();
            return ((LogoutReq) this.instance).getReservedMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
        @Deprecated
        public Map<String, String> getReserved() {
            return getReservedMap();
        }

        @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
        public int getReservedCount() {
            return ((LogoutReq) this.instance).getReservedMap().size();
        }

        @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
        public Map<String, String> getReservedMap() {
            return Collections.unmodifiableMap(((LogoutReq) this.instance).getReservedMap());
        }

        @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
        public String getReservedOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> reservedMap = ((LogoutReq) this.instance).getReservedMap();
            return reservedMap.containsKey(str) ? reservedMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
        public String getReservedOrThrow(String str) {
            str.getClass();
            Map<String, String> reservedMap = ((LogoutReq) this.instance).getReservedMap();
            if (reservedMap.containsKey(str)) {
                return reservedMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        public Builder putAllReserved(Map<String, String> map) {
            copyOnWrite();
            ((LogoutReq) this.instance).getMutableReservedMap().putAll(map);
            return this;
        }

        public Builder putReserved(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((LogoutReq) this.instance).getMutableReservedMap().put(str, str2);
            return this;
        }

        public Builder removeReserved(String str) {
            str.getClass();
            copyOnWrite();
            ((LogoutReq) this.instance).getMutableReservedMap().remove(str);
            return this;
        }

        private Builder() {
            super(LogoutReq.DEFAULT_INSTANCE);
        }
    }

    public static final class ReservedDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ReservedDefaultEntryHolder() {
        }
    }

    static {
        LogoutReq logoutReq = new LogoutReq();
        DEFAULT_INSTANCE = logoutReq;
        GeneratedMessageLite.registerDefaultInstance(LogoutReq.class, logoutReq);
    }

    private LogoutReq() {
    }

    public static LogoutReq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableReservedMap() {
        return internalGetMutableReserved();
    }

    private MapFieldLite<String, String> internalGetMutableReserved() {
        if (!this.reserved_.isMutable()) {
            this.reserved_ = this.reserved_.mutableCopy();
        }
        return this.reserved_;
    }

    private MapFieldLite<String, String> internalGetReserved() {
        return this.reserved_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static LogoutReq parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LogoutReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LogoutReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<LogoutReq> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
    public boolean containsReserved(String str) {
        str.getClass();
        return internalGetReserved().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new LogoutReq();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"reserved_", ReservedDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LogoutReq> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (LogoutReq.class) {
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

    @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
    @Deprecated
    public Map<String, String> getReserved() {
        return getReservedMap();
    }

    @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
    public int getReservedCount() {
        return internalGetReserved().size();
    }

    @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
    public Map<String, String> getReservedMap() {
        return Collections.unmodifiableMap(internalGetReserved());
    }

    @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
    public String getReservedOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetReserved = internalGetReserved();
        return mapFieldLiteInternalGetReserved.containsKey(str) ? mapFieldLiteInternalGetReserved.get(str) : str2;
    }

    @Override // com.zyql.protobuf.connection.LogoutReqOrBuilder
    public String getReservedOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetReserved = internalGetReserved();
        if (mapFieldLiteInternalGetReserved.containsKey(str)) {
            return mapFieldLiteInternalGetReserved.get(str);
        }
        throw new IllegalArgumentException();
    }

    public static Builder newBuilder(LogoutReq logoutReq) {
        return DEFAULT_INSTANCE.createBuilder(logoutReq);
    }

    public static LogoutReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogoutReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LogoutReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LogoutReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LogoutReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LogoutReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LogoutReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LogoutReq parseFrom(InputStream inputStream) throws IOException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LogoutReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LogoutReq parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LogoutReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LogoutReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
