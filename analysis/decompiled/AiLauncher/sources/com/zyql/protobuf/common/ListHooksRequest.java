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
public final class ListHooksRequest extends GeneratedMessageLite<ListHooksRequest, Builder> implements ListHooksRequestOrBuilder {
    private static final ListHooksRequest DEFAULT_INSTANCE;
    public static final int HOOK_POINT_FIELD_NUMBER = 2;
    public static final int LAYER_FIELD_NUMBER = 1;
    private static volatile Parser<ListHooksRequest> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    private int hookPoint_;
    private int layer_;
    private String sessionId_ = "";

    /* renamed from: com.zyql.protobuf.common.ListHooksRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ListHooksRequest, Builder> implements ListHooksRequestOrBuilder {
        public Builder clearHookPoint() {
            copyOnWrite();
            ((ListHooksRequest) this.instance).clearHookPoint();
            return this;
        }

        public Builder clearLayer() {
            copyOnWrite();
            ((ListHooksRequest) this.instance).clearLayer();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((ListHooksRequest) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
        public HookPoint getHookPoint() {
            return ((ListHooksRequest) this.instance).getHookPoint();
        }

        @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
        public int getHookPointValue() {
            return ((ListHooksRequest) this.instance).getHookPointValue();
        }

        @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
        public HookLayer getLayer() {
            return ((ListHooksRequest) this.instance).getLayer();
        }

        @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
        public int getLayerValue() {
            return ((ListHooksRequest) this.instance).getLayerValue();
        }

        @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
        public String getSessionId() {
            return ((ListHooksRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((ListHooksRequest) this.instance).getSessionIdBytes();
        }

        public Builder setHookPoint(HookPoint hookPoint) {
            copyOnWrite();
            ((ListHooksRequest) this.instance).setHookPoint(hookPoint);
            return this;
        }

        public Builder setHookPointValue(int i10) {
            copyOnWrite();
            ((ListHooksRequest) this.instance).setHookPointValue(i10);
            return this;
        }

        public Builder setLayer(HookLayer hookLayer) {
            copyOnWrite();
            ((ListHooksRequest) this.instance).setLayer(hookLayer);
            return this;
        }

        public Builder setLayerValue(int i10) {
            copyOnWrite();
            ((ListHooksRequest) this.instance).setLayerValue(i10);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((ListHooksRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((ListHooksRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(ListHooksRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        ListHooksRequest listHooksRequest = new ListHooksRequest();
        DEFAULT_INSTANCE = listHooksRequest;
        GeneratedMessageLite.registerDefaultInstance(ListHooksRequest.class, listHooksRequest);
    }

    private ListHooksRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookPoint() {
        this.hookPoint_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayer() {
        this.layer_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static ListHooksRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ListHooksRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListHooksRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListHooksRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListHooksRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookPoint(HookPoint hookPoint) {
        this.hookPoint_ = hookPoint.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookPointValue(int i10) {
        this.hookPoint_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayer(HookLayer hookLayer) {
        this.layer_ = hookLayer.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayerValue(int i10) {
        this.layer_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new ListHooksRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ", new Object[]{"layer_", "hookPoint_", "sessionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListHooksRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ListHooksRequest.class) {
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

    @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
    public HookPoint getHookPoint() {
        HookPoint hookPointForNumber = HookPoint.forNumber(this.hookPoint_);
        return hookPointForNumber == null ? HookPoint.UNRECOGNIZED : hookPointForNumber;
    }

    @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
    public int getHookPointValue() {
        return this.hookPoint_;
    }

    @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
    public HookLayer getLayer() {
        HookLayer hookLayerForNumber = HookLayer.forNumber(this.layer_);
        return hookLayerForNumber == null ? HookLayer.UNRECOGNIZED : hookLayerForNumber;
    }

    @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
    public int getLayerValue() {
        return this.layer_;
    }

    @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.common.ListHooksRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(ListHooksRequest listHooksRequest) {
        return DEFAULT_INSTANCE.createBuilder(listHooksRequest);
    }

    public static ListHooksRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListHooksRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListHooksRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListHooksRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ListHooksRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListHooksRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ListHooksRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListHooksRequest parseFrom(InputStream inputStream) throws IOException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListHooksRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListHooksRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListHooksRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListHooksRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
