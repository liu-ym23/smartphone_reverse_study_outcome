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
public final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
    public static final int BLOB_FIELD_NUMBER = 2;
    private static final b DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 8;
    public static final int HEIGHT_FIELD_NUMBER = 7;
    public static final int METADATA_FIELD_NUMBER = 9;
    public static final int MIME_FIELD_NUMBER = 3;
    private static volatile Parser<b> PARSER = null;
    public static final int SHA256_FIELD_NUMBER = 4;
    public static final int SIZE_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int WIDTH_FIELD_NUMBER = 6;
    private long durationMs_;
    private int height_;
    private int size_;
    private int width_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String type_ = "";
    private String blob_ = "";
    private String mime_ = "";
    private String sha256_ = "";

    public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
        public a a(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((b) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public a d(String str) {
            copyOnWrite();
            ((b) this.instance).k(str);
            return this;
        }

        public a f(String str) {
            copyOnWrite();
            ((b) this.instance).l(str);
            return this;
        }

        public a g(int i10) {
            copyOnWrite();
            ((b) this.instance).m(i10);
            return this;
        }

        public a h(String str) {
            copyOnWrite();
            ((b) this.instance).setType(str);
            return this;
        }

        public a() {
            super(b.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: com.stepos.agentframework.protobuf.b$b, reason: collision with other inner class name */
    public static final class C0254b {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        GeneratedMessageLite.registerDefaultInstance(b.class, bVar);
    }

    public static a j() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new b();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0004\u0006\u0004\u0007\u0004\b\u0002\t2", new Object[]{"type_", "blob_", "mime_", "sha256_", "size_", "width_", "height_", "durationMs_", "metadata_", C0254b.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<b> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (b.class) {
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

    public String g() {
        return this.blob_;
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    public final Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    public String h() {
        return this.mime_;
    }

    public int i() {
        return this.size_;
    }

    public final MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    public final MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    public final void k(String str) {
        str.getClass();
        this.blob_ = str;
    }

    public final void l(String str) {
        str.getClass();
        this.mime_ = str;
    }

    public final void m(int i10) {
        this.size_ = i10;
    }

    public final void setType(String str) {
        str.getClass();
        this.type_ = str;
    }
}
