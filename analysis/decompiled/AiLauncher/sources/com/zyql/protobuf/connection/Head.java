package com.zyql.protobuf.connection;

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
public final class Head extends GeneratedMessageLite<Head, Builder> implements HeadOrBuilder {
    public static final int COMMAND_FIELD_NUMBER = 5;
    private static final Head DEFAULT_INSTANCE;
    public static final int FRAME_TYPE_FIELD_NUMBER = 1;
    public static final int META_FIELD_NUMBER = 6;
    public static final int MODULE_FIELD_NUMBER = 4;
    public static final int MSG_ID_FIELD_NUMBER = 3;
    public static final int MSG_TYPE_FIELD_NUMBER = 2;
    private static volatile Parser<Head> PARSER;
    private int frameType_;
    private int msgType_;
    private MapFieldLite<String, String> meta_ = MapFieldLite.emptyMapField();
    private String msgId_ = "";
    private String module_ = "";
    private String command_ = "";

    /* renamed from: com.zyql.protobuf.connection.Head$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Head, Builder> implements HeadOrBuilder {
        public Builder clearCommand() {
            copyOnWrite();
            ((Head) this.instance).clearCommand();
            return this;
        }

        public Builder clearFrameType() {
            copyOnWrite();
            ((Head) this.instance).clearFrameType();
            return this;
        }

        public Builder clearMeta() {
            copyOnWrite();
            ((Head) this.instance).getMutableMetaMap().clear();
            return this;
        }

        public Builder clearModule() {
            copyOnWrite();
            ((Head) this.instance).clearModule();
            return this;
        }

        public Builder clearMsgId() {
            copyOnWrite();
            ((Head) this.instance).clearMsgId();
            return this;
        }

        public Builder clearMsgType() {
            copyOnWrite();
            ((Head) this.instance).clearMsgType();
            return this;
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public boolean containsMeta(String str) {
            str.getClass();
            return ((Head) this.instance).getMetaMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public String getCommand() {
            return ((Head) this.instance).getCommand();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public ByteString getCommandBytes() {
            return ((Head) this.instance).getCommandBytes();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public int getFrameType() {
            return ((Head) this.instance).getFrameType();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        @Deprecated
        public Map<String, String> getMeta() {
            return getMetaMap();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public int getMetaCount() {
            return ((Head) this.instance).getMetaMap().size();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public Map<String, String> getMetaMap() {
            return Collections.unmodifiableMap(((Head) this.instance).getMetaMap());
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public String getMetaOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metaMap = ((Head) this.instance).getMetaMap();
            return metaMap.containsKey(str) ? metaMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public String getMetaOrThrow(String str) {
            str.getClass();
            Map<String, String> metaMap = ((Head) this.instance).getMetaMap();
            if (metaMap.containsKey(str)) {
                return metaMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public String getModule() {
            return ((Head) this.instance).getModule();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public ByteString getModuleBytes() {
            return ((Head) this.instance).getModuleBytes();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public String getMsgId() {
            return ((Head) this.instance).getMsgId();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public ByteString getMsgIdBytes() {
            return ((Head) this.instance).getMsgIdBytes();
        }

        @Override // com.zyql.protobuf.connection.HeadOrBuilder
        public int getMsgType() {
            return ((Head) this.instance).getMsgType();
        }

        public Builder putAllMeta(Map<String, String> map) {
            copyOnWrite();
            ((Head) this.instance).getMutableMetaMap().putAll(map);
            return this;
        }

        public Builder putMeta(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((Head) this.instance).getMutableMetaMap().put(str, str2);
            return this;
        }

        public Builder removeMeta(String str) {
            str.getClass();
            copyOnWrite();
            ((Head) this.instance).getMutableMetaMap().remove(str);
            return this;
        }

        public Builder setCommand(String str) {
            copyOnWrite();
            ((Head) this.instance).setCommand(str);
            return this;
        }

        public Builder setCommandBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Head) this.instance).setCommandBytes(byteString);
            return this;
        }

        public Builder setFrameType(int i10) {
            copyOnWrite();
            ((Head) this.instance).setFrameType(i10);
            return this;
        }

        public Builder setModule(String str) {
            copyOnWrite();
            ((Head) this.instance).setModule(str);
            return this;
        }

        public Builder setModuleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Head) this.instance).setModuleBytes(byteString);
            return this;
        }

        public Builder setMsgId(String str) {
            copyOnWrite();
            ((Head) this.instance).setMsgId(str);
            return this;
        }

        public Builder setMsgIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Head) this.instance).setMsgIdBytes(byteString);
            return this;
        }

        public Builder setMsgType(int i10) {
            copyOnWrite();
            ((Head) this.instance).setMsgType(i10);
            return this;
        }

        private Builder() {
            super(Head.DEFAULT_INSTANCE);
        }
    }

    public static final class MetaDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetaDefaultEntryHolder() {
        }
    }

    static {
        Head head = new Head();
        DEFAULT_INSTANCE = head;
        GeneratedMessageLite.registerDefaultInstance(Head.class, head);
    }

    private Head() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommand() {
        this.command_ = getDefaultInstance().getCommand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFrameType() {
        this.frameType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModule() {
        this.module_ = getDefaultInstance().getModule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMsgId() {
        this.msgId_ = getDefaultInstance().getMsgId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMsgType() {
        this.msgType_ = 0;
    }

    public static Head getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetaMap() {
        return internalGetMutableMeta();
    }

    private MapFieldLite<String, String> internalGetMeta() {
        return this.meta_;
    }

    private MapFieldLite<String, String> internalGetMutableMeta() {
        if (!this.meta_.isMutable()) {
            this.meta_ = this.meta_.mutableCopy();
        }
        return this.meta_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Head parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Head) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Head parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Head> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommand(String str) {
        str.getClass();
        this.command_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommandBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.command_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrameType(int i10) {
        this.frameType_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModule(String str) {
        str.getClass();
        this.module_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModuleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.module_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgId(String str) {
        str.getClass();
        this.msgId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.msgId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgType(int i10) {
        this.msgType_ = i10;
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public boolean containsMeta(String str) {
        str.getClass();
        return internalGetMeta().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Head();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001\u000b\u0002\u000b\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"frameType_", "msgType_", "msgId_", "module_", "command_", "meta_", MetaDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Head> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Head.class) {
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

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public String getCommand() {
        return this.command_;
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public ByteString getCommandBytes() {
        return ByteString.copyFromUtf8(this.command_);
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public int getFrameType() {
        return this.frameType_;
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    @Deprecated
    public Map<String, String> getMeta() {
        return getMetaMap();
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public int getMetaCount() {
        return internalGetMeta().size();
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(internalGetMeta());
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMeta = internalGetMeta();
        return mapFieldLiteInternalGetMeta.containsKey(str) ? mapFieldLiteInternalGetMeta.get(str) : str2;
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public String getMetaOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMeta = internalGetMeta();
        if (mapFieldLiteInternalGetMeta.containsKey(str)) {
            return mapFieldLiteInternalGetMeta.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public String getModule() {
        return this.module_;
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public ByteString getModuleBytes() {
        return ByteString.copyFromUtf8(this.module_);
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public String getMsgId() {
        return this.msgId_;
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public ByteString getMsgIdBytes() {
        return ByteString.copyFromUtf8(this.msgId_);
    }

    @Override // com.zyql.protobuf.connection.HeadOrBuilder
    public int getMsgType() {
        return this.msgType_;
    }

    public static Builder newBuilder(Head head) {
        return DEFAULT_INSTANCE.createBuilder(head);
    }

    public static Head parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Head) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Head parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Head parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Head parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Head parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Head parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Head parseFrom(InputStream inputStream) throws IOException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Head parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Head parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Head parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Head) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
