package com.stepos.agentframework.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e extends GeneratedMessageLite<e, a> implements MessageLiteOrBuilder {
    public static final int COMMAND_FIELD_NUMBER = 5;
    private static final e DEFAULT_INSTANCE;
    public static final int FRAME_TYPE_FIELD_NUMBER = 1;
    public static final int META_FIELD_NUMBER = 6;
    public static final int MODULE_FIELD_NUMBER = 4;
    public static final int MSG_ID_FIELD_NUMBER = 3;
    public static final int MSG_TYPE_FIELD_NUMBER = 2;
    private static volatile Parser<e> PARSER;
    private int frameType_;
    private int msgType_;
    private MapFieldLite<String, String> meta_ = MapFieldLite.emptyMapField();
    private String msgId_ = "";
    private String module_ = "";
    private String command_ = "";

    public static final class a extends GeneratedMessageLite.Builder<e, a> implements MessageLiteOrBuilder {
        public a a(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((e) this.instance).getMutableMetaMap().put(str, str2);
            return this;
        }

        public a d(String str) {
            copyOnWrite();
            ((e) this.instance).setCommand(str);
            return this;
        }

        public a f(String str) {
            copyOnWrite();
            ((e) this.instance).setModule(str);
            return this;
        }

        public a g(int i10) {
            copyOnWrite();
            ((e) this.instance).setMsgType(i10);
            return this;
        }

        public a() {
            super(e.DEFAULT_INSTANCE);
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
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        GeneratedMessageLite.registerDefaultInstance(e.class, eVar);
    }

    public static e f() {
        return DEFAULT_INSTANCE;
    }

    public static a g() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new e();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001\u000b\u0002\u000b\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"frameType_", "msgType_", "msgId_", "module_", "command_", "meta_", b.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<e> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (e.class) {
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

    public String getCommand() {
        return this.command_;
    }

    public int getFrameType() {
        return this.frameType_;
    }

    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(internalGetMeta());
    }

    public String getModule() {
        return this.module_;
    }

    public String getMsgId() {
        return this.msgId_;
    }

    public int getMsgType() {
        return this.msgType_;
    }

    public final Map<String, String> getMutableMetaMap() {
        return internalGetMutableMeta();
    }

    public final MapFieldLite<String, String> internalGetMeta() {
        return this.meta_;
    }

    public final MapFieldLite<String, String> internalGetMutableMeta() {
        if (!this.meta_.isMutable()) {
            this.meta_ = this.meta_.mutableCopy();
        }
        return this.meta_;
    }

    public final void setCommand(String str) {
        str.getClass();
        this.command_ = str;
    }

    public final void setModule(String str) {
        str.getClass();
        this.module_ = str;
    }

    public final void setMsgType(int i10) {
        this.msgType_ = i10;
    }
}
