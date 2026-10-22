package com.stepos.agentframework.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends GeneratedMessageLite<f, a> implements MessageLiteOrBuilder {
    public static final int ATTACHMENTS_FIELD_NUMBER = 6;
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final f DEFAULT_INSTANCE;
    public static final int DELTA_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 5;
    private static volatile Parser<f> PARSER = null;
    public static final int REPLY_TO_FIELD_NUMBER = 3;
    public static final int ROLE_FIELD_NUMBER = 1;
    public static final int TOOL_CALLS_FIELD_NUMBER = 7;
    private int role_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String content_ = "";
    private String replyTo_ = "";
    private String delta_ = "";
    private Internal.ProtobufList<com.stepos.agentframework.protobuf.b> attachments_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<h> toolCalls_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.Builder<f, a> implements MessageLiteOrBuilder {
        public a a(Iterable<? extends com.stepos.agentframework.protobuf.b> iterable) {
            copyOnWrite();
            ((f) this.instance).f(iterable);
            return this;
        }

        public a d(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((f) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public a f(String str) {
            copyOnWrite();
            ((f) this.instance).setContent(str);
            return this;
        }

        public a g(Abbff$Role abbff$Role) {
            copyOnWrite();
            ((f) this.instance).n(abbff$Role);
            return this;
        }

        public a() {
            super(f.DEFAULT_INSTANCE);
        }
    }

    public static final class b {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.registerDefaultInstance(f.class, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    public static a l() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static f m(ByteString byteString) throws InvalidProtocolBufferException {
        return (f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new f();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0001\u0002\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052\u0006\u001b\u0007\u001b", new Object[]{"role_", "content_", "replyTo_", "delta_", "metadata_", b.defaultEntry, "attachments_", com.stepos.agentframework.protobuf.b.class, "toolCalls_", h.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<f> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (f.class) {
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

    public final void f(Iterable<? extends com.stepos.agentframework.protobuf.b> iterable) {
        g();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.attachments_);
    }

    public final void g() {
        Internal.ProtobufList<com.stepos.agentframework.protobuf.b> protobufList = this.attachments_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.attachments_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public String getContent() {
        return this.content_;
    }

    public String getDelta() {
        return this.delta_;
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    public int getToolCallsCount() {
        return this.toolCalls_.size();
    }

    public List<h> getToolCallsList() {
        return this.toolCalls_;
    }

    public int h() {
        return this.attachments_.size();
    }

    public List<com.stepos.agentframework.protobuf.b> i() {
        return this.attachments_;
    }

    public String j() {
        return this.replyTo_;
    }

    public Abbff$Role k() {
        Abbff$Role abbff$RoleForNumber = Abbff$Role.forNumber(this.role_);
        return abbff$RoleForNumber == null ? Abbff$Role.UNRECOGNIZED : abbff$RoleForNumber;
    }

    public final void n(Abbff$Role abbff$Role) {
        this.role_ = abbff$Role.getNumber();
    }

    public final void setContent(String str) {
        str.getClass();
        this.content_ = str;
    }
}
