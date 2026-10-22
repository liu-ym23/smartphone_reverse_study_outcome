package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.HookDefinition;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class ListHooksResponse extends GeneratedMessageLite<ListHooksResponse, Builder> implements ListHooksResponseOrBuilder {
    private static final ListHooksResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int HOOKS_FIELD_NUMBER = 1;
    private static volatile Parser<ListHooksResponse> PARSER;
    private Internal.ProtobufList<HookDefinition> hooks_ = GeneratedMessageLite.emptyProtobufList();
    private String error_ = "";

    /* renamed from: com.zyql.protobuf.common.ListHooksResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ListHooksResponse, Builder> implements ListHooksResponseOrBuilder {
        public Builder addAllHooks(Iterable<? extends HookDefinition> iterable) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).addAllHooks(iterable);
            return this;
        }

        public Builder addHooks(HookDefinition hookDefinition) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).addHooks(hookDefinition);
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((ListHooksResponse) this.instance).clearError();
            return this;
        }

        public Builder clearHooks() {
            copyOnWrite();
            ((ListHooksResponse) this.instance).clearHooks();
            return this;
        }

        @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
        public String getError() {
            return ((ListHooksResponse) this.instance).getError();
        }

        @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
        public ByteString getErrorBytes() {
            return ((ListHooksResponse) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
        public HookDefinition getHooks(int i10) {
            return ((ListHooksResponse) this.instance).getHooks(i10);
        }

        @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
        public int getHooksCount() {
            return ((ListHooksResponse) this.instance).getHooksCount();
        }

        @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
        public List<HookDefinition> getHooksList() {
            return Collections.unmodifiableList(((ListHooksResponse) this.instance).getHooksList());
        }

        public Builder removeHooks(int i10) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).removeHooks(i10);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ListHooksResponse) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setHooks(int i10, HookDefinition hookDefinition) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).setHooks(i10, hookDefinition);
            return this;
        }

        private Builder() {
            super(ListHooksResponse.DEFAULT_INSTANCE);
        }

        public Builder addHooks(int i10, HookDefinition hookDefinition) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).addHooks(i10, hookDefinition);
            return this;
        }

        public Builder setHooks(int i10, HookDefinition.Builder builder) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).setHooks(i10, builder.build());
            return this;
        }

        public Builder addHooks(HookDefinition.Builder builder) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).addHooks(builder.build());
            return this;
        }

        public Builder addHooks(int i10, HookDefinition.Builder builder) {
            copyOnWrite();
            ((ListHooksResponse) this.instance).addHooks(i10, builder.build());
            return this;
        }
    }

    static {
        ListHooksResponse listHooksResponse = new ListHooksResponse();
        DEFAULT_INSTANCE = listHooksResponse;
        GeneratedMessageLite.registerDefaultInstance(ListHooksResponse.class, listHooksResponse);
    }

    private ListHooksResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllHooks(Iterable<? extends HookDefinition> iterable) {
        ensureHooksIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.hooks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHooks(HookDefinition hookDefinition) {
        hookDefinition.getClass();
        ensureHooksIsMutable();
        this.hooks_.add(hookDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHooks() {
        this.hooks_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureHooksIsMutable() {
        Internal.ProtobufList<HookDefinition> protobufList = this.hooks_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.hooks_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ListHooksResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ListHooksResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListHooksResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListHooksResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListHooksResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeHooks(int i10) {
        ensureHooksIsMutable();
        this.hooks_.remove(i10);
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
    public void setHooks(int i10, HookDefinition hookDefinition) {
        hookDefinition.getClass();
        ensureHooksIsMutable();
        this.hooks_.set(i10, hookDefinition);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ListHooksResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"hooks_", HookDefinition.class, "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListHooksResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ListHooksResponse.class) {
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

    @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
    public HookDefinition getHooks(int i10) {
        return this.hooks_.get(i10);
    }

    @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
    public int getHooksCount() {
        return this.hooks_.size();
    }

    @Override // com.zyql.protobuf.common.ListHooksResponseOrBuilder
    public List<HookDefinition> getHooksList() {
        return this.hooks_;
    }

    public HookDefinitionOrBuilder getHooksOrBuilder(int i10) {
        return this.hooks_.get(i10);
    }

    public List<? extends HookDefinitionOrBuilder> getHooksOrBuilderList() {
        return this.hooks_;
    }

    public static Builder newBuilder(ListHooksResponse listHooksResponse) {
        return DEFAULT_INSTANCE.createBuilder(listHooksResponse);
    }

    public static ListHooksResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListHooksResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListHooksResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListHooksResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHooks(int i10, HookDefinition hookDefinition) {
        hookDefinition.getClass();
        ensureHooksIsMutable();
        this.hooks_.add(i10, hookDefinition);
    }

    public static ListHooksResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListHooksResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ListHooksResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListHooksResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListHooksResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListHooksResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListHooksResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListHooksResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
