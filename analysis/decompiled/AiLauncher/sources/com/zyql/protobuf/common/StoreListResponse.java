package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class StoreListResponse extends GeneratedMessageLite<StoreListResponse, Builder> implements StoreListResponseOrBuilder {
    private static final StoreListResponse DEFAULT_INSTANCE;
    public static final int KEYS_FIELD_NUMBER = 1;
    public static final int NEXT_CURSOR_FIELD_NUMBER = 2;
    private static volatile Parser<StoreListResponse> PARSER;
    private Internal.ProtobufList<String> keys_ = GeneratedMessageLite.emptyProtobufList();
    private String nextCursor_ = "";

    /* renamed from: com.zyql.protobuf.common.StoreListResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StoreListResponse, Builder> implements StoreListResponseOrBuilder {
        public Builder addAllKeys(Iterable<String> iterable) {
            copyOnWrite();
            ((StoreListResponse) this.instance).addAllKeys(iterable);
            return this;
        }

        public Builder addKeys(String str) {
            copyOnWrite();
            ((StoreListResponse) this.instance).addKeys(str);
            return this;
        }

        public Builder addKeysBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreListResponse) this.instance).addKeysBytes(byteString);
            return this;
        }

        public Builder clearKeys() {
            copyOnWrite();
            ((StoreListResponse) this.instance).clearKeys();
            return this;
        }

        public Builder clearNextCursor() {
            copyOnWrite();
            ((StoreListResponse) this.instance).clearNextCursor();
            return this;
        }

        @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
        public String getKeys(int i10) {
            return ((StoreListResponse) this.instance).getKeys(i10);
        }

        @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
        public ByteString getKeysBytes(int i10) {
            return ((StoreListResponse) this.instance).getKeysBytes(i10);
        }

        @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
        public int getKeysCount() {
            return ((StoreListResponse) this.instance).getKeysCount();
        }

        @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
        public List<String> getKeysList() {
            return Collections.unmodifiableList(((StoreListResponse) this.instance).getKeysList());
        }

        @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
        public String getNextCursor() {
            return ((StoreListResponse) this.instance).getNextCursor();
        }

        @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
        public ByteString getNextCursorBytes() {
            return ((StoreListResponse) this.instance).getNextCursorBytes();
        }

        public Builder setKeys(int i10, String str) {
            copyOnWrite();
            ((StoreListResponse) this.instance).setKeys(i10, str);
            return this;
        }

        public Builder setNextCursor(String str) {
            copyOnWrite();
            ((StoreListResponse) this.instance).setNextCursor(str);
            return this;
        }

        public Builder setNextCursorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StoreListResponse) this.instance).setNextCursorBytes(byteString);
            return this;
        }

        private Builder() {
            super(StoreListResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        StoreListResponse storeListResponse = new StoreListResponse();
        DEFAULT_INSTANCE = storeListResponse;
        GeneratedMessageLite.registerDefaultInstance(StoreListResponse.class, storeListResponse);
    }

    private StoreListResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKeys(Iterable<String> iterable) {
        ensureKeysIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.keys_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeys(String str) {
        str.getClass();
        ensureKeysIsMutable();
        this.keys_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeysBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        ensureKeysIsMutable();
        this.keys_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeys() {
        this.keys_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNextCursor() {
        this.nextCursor_ = getDefaultInstance().getNextCursor();
    }

    private void ensureKeysIsMutable() {
        Internal.ProtobufList<String> protobufList = this.keys_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.keys_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static StoreListResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StoreListResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StoreListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreListResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StoreListResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeys(int i10, String str) {
        str.getClass();
        ensureKeysIsMutable();
        this.keys_.set(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextCursor(String str) {
        str.getClass();
        this.nextCursor_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextCursorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.nextCursor_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StoreListResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002Ȉ", new Object[]{"keys_", "nextCursor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StoreListResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StoreListResponse.class) {
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

    @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
    public String getKeys(int i10) {
        return this.keys_.get(i10);
    }

    @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
    public ByteString getKeysBytes(int i10) {
        return ByteString.copyFromUtf8(this.keys_.get(i10));
    }

    @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
    public int getKeysCount() {
        return this.keys_.size();
    }

    @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
    public List<String> getKeysList() {
        return this.keys_;
    }

    @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
    public String getNextCursor() {
        return this.nextCursor_;
    }

    @Override // com.zyql.protobuf.common.StoreListResponseOrBuilder
    public ByteString getNextCursorBytes() {
        return ByteString.copyFromUtf8(this.nextCursor_);
    }

    public static Builder newBuilder(StoreListResponse storeListResponse) {
        return DEFAULT_INSTANCE.createBuilder(storeListResponse);
    }

    public static StoreListResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreListResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StoreListResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StoreListResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StoreListResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoreListResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StoreListResponse parseFrom(InputStream inputStream) throws IOException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoreListResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StoreListResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StoreListResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StoreListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
