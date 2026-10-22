package com.zyql.protobuf.connection;

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
public final class AuthBindResp extends GeneratedMessageLite<AuthBindResp, Builder> implements AuthBindRespOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int CONN_FIELD_NUMBER = 4;
    private static final AuthBindResp DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int LOGINED_FIELD_NUMBER = 6;
    public static final int NEW_FIELD_NUMBER = 7;
    private static volatile Parser<AuthBindResp> PARSER = null;
    public static final int UID_FIELD_NUMBER = 5;
    private int code_;
    private int logined_;
    private boolean new_;
    private String error_ = "";
    private String conn_ = "";
    private String uid_ = "";

    /* renamed from: com.zyql.protobuf.connection.AuthBindResp$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AuthBindResp, Builder> implements AuthBindRespOrBuilder {
        public Builder clearCode() {
            copyOnWrite();
            ((AuthBindResp) this.instance).clearCode();
            return this;
        }

        public Builder clearConn() {
            copyOnWrite();
            ((AuthBindResp) this.instance).clearConn();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((AuthBindResp) this.instance).clearError();
            return this;
        }

        public Builder clearLogined() {
            copyOnWrite();
            ((AuthBindResp) this.instance).clearLogined();
            return this;
        }

        public Builder clearNew() {
            copyOnWrite();
            ((AuthBindResp) this.instance).clearNew();
            return this;
        }

        public Builder clearUid() {
            copyOnWrite();
            ((AuthBindResp) this.instance).clearUid();
            return this;
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public int getCode() {
            return ((AuthBindResp) this.instance).getCode();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public String getConn() {
            return ((AuthBindResp) this.instance).getConn();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public ByteString getConnBytes() {
            return ((AuthBindResp) this.instance).getConnBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public String getError() {
            return ((AuthBindResp) this.instance).getError();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public ByteString getErrorBytes() {
            return ((AuthBindResp) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public int getLogined() {
            return ((AuthBindResp) this.instance).getLogined();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public boolean getNew() {
            return ((AuthBindResp) this.instance).getNew();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public String getUid() {
            return ((AuthBindResp) this.instance).getUid();
        }

        @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
        public ByteString getUidBytes() {
            return ((AuthBindResp) this.instance).getUidBytes();
        }

        public Builder setCode(int i10) {
            copyOnWrite();
            ((AuthBindResp) this.instance).setCode(i10);
            return this;
        }

        public Builder setConn(String str) {
            copyOnWrite();
            ((AuthBindResp) this.instance).setConn(str);
            return this;
        }

        public Builder setConnBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindResp) this.instance).setConnBytes(byteString);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((AuthBindResp) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindResp) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setLogined(int i10) {
            copyOnWrite();
            ((AuthBindResp) this.instance).setLogined(i10);
            return this;
        }

        public Builder setNew(boolean z10) {
            copyOnWrite();
            ((AuthBindResp) this.instance).setNew(z10);
            return this;
        }

        public Builder setUid(String str) {
            copyOnWrite();
            ((AuthBindResp) this.instance).setUid(str);
            return this;
        }

        public Builder setUidBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AuthBindResp) this.instance).setUidBytes(byteString);
            return this;
        }

        private Builder() {
            super(AuthBindResp.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthBindResp authBindResp = new AuthBindResp();
        DEFAULT_INSTANCE = authBindResp;
        GeneratedMessageLite.registerDefaultInstance(AuthBindResp.class, authBindResp);
    }

    private AuthBindResp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConn() {
        this.conn_ = getDefaultInstance().getConn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogined() {
        this.logined_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNew() {
        this.new_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUid() {
        this.uid_ = getDefaultInstance().getUid();
    }

    public static AuthBindResp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthBindResp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthBindResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthBindResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AuthBindResp> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i10) {
        this.code_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConn(String str) {
        str.getClass();
        this.conn_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.conn_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogined(int i10) {
        this.logined_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNew(boolean z10) {
        this.new_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(String str) {
        str.getClass();
        this.uid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUidBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uid_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AuthBindResp();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0007\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007\u0007", new Object[]{"code_", "error_", "conn_", "uid_", "logined_", "new_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthBindResp> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AuthBindResp.class) {
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

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public int getCode() {
        return this.code_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public String getConn() {
        return this.conn_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public ByteString getConnBytes() {
        return ByteString.copyFromUtf8(this.conn_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public int getLogined() {
        return this.logined_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public boolean getNew() {
        return this.new_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public String getUid() {
        return this.uid_;
    }

    @Override // com.zyql.protobuf.connection.AuthBindRespOrBuilder
    public ByteString getUidBytes() {
        return ByteString.copyFromUtf8(this.uid_);
    }

    public static Builder newBuilder(AuthBindResp authBindResp) {
        return DEFAULT_INSTANCE.createBuilder(authBindResp);
    }

    public static AuthBindResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthBindResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthBindResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuthBindResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthBindResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthBindResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthBindResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthBindResp parseFrom(InputStream inputStream) throws IOException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthBindResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthBindResp parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthBindResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthBindResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
