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
public final class h extends GeneratedMessageLite<h, b> implements MessageLiteOrBuilder {
    public static final int ARGUMENTS_FIELD_NUMBER = 3;
    private static final h DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 8;
    public static final int ERROR_CODE_FIELD_NUMBER = 6;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<h> PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 5;
    public static final int STATUS_FIELD_NUMBER = 4;
    private int status_;
    private MapFieldLite<String, String> arguments_ = MapFieldLite.emptyMapField();
    private MapFieldLite<String, String> result_ = MapFieldLite.emptyMapField();
    private String id_ = "";
    private String name_ = "";
    private String errorCode_ = "";
    private String errorMessage_ = "";
    private String displayName_ = "";

    public static final class a {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }
    }

    public static final class b extends GeneratedMessageLite.Builder<h, b> implements MessageLiteOrBuilder {
        public b() {
            super(h.DEFAULT_INSTANCE);
        }
    }

    public static final class c {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        GeneratedMessageLite.registerDefaultInstance(h.class, hVar);
    }

    @Deprecated
    public Map<String, String> b() {
        return c();
    }

    public Map<String, String> c() {
        return Collections.unmodifiableMap(h());
    }

    public String d(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteH = h();
        return mapFieldLiteH.containsKey(str) ? mapFieldLiteH.get(str) : str2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new h();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0002\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032\u0004\f\u00052\u0006Ȉ\u0007Ȉ\bȈ", new Object[]{"id_", "name_", "arguments_", a.defaultEntry, "status_", "result_", c.defaultEntry, "errorCode_", "errorMessage_", "displayName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<h> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (h.class) {
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

    @Deprecated
    public Map<String, String> e() {
        return f();
    }

    public Map<String, String> f() {
        return Collections.unmodifiableMap(i());
    }

    public Abbff$ToolStatus g() {
        Abbff$ToolStatus abbff$ToolStatusForNumber = Abbff$ToolStatus.forNumber(this.status_);
        return abbff$ToolStatusForNumber == null ? Abbff$ToolStatus.UNRECOGNIZED : abbff$ToolStatusForNumber;
    }

    public String getDisplayName() {
        return this.displayName_;
    }

    public String getErrorMessage() {
        return this.errorMessage_;
    }

    public String getId() {
        return this.id_;
    }

    public String getName() {
        return this.name_;
    }

    public final MapFieldLite<String, String> h() {
        return this.arguments_;
    }

    public final MapFieldLite<String, String> i() {
        return this.result_;
    }
}
