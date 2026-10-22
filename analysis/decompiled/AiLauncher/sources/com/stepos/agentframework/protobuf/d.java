package com.stepos.agentframework.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d extends GeneratedMessageLite<d, a> implements MessageLiteOrBuilder {
    private static final d DEFAULT_INSTANCE;
    public static final int EVENT_ID_FIELD_NUMBER = 1;
    public static final int EVENT_TYPE_FIELD_NUMBER = 3;
    public static final int METADATA_FIELD_NUMBER = 4;
    private static volatile Parser<d> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private int eventType_;
    private long timestamp_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String eventId_ = "";

    public static final class a extends GeneratedMessageLite.Builder<d, a> implements MessageLiteOrBuilder {
        public a a(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((d) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public a() {
            super(d.DEFAULT_INSTANCE);
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
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.registerDefaultInstance(d.class, dVar);
    }

    public static a d() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static d e(ByteString byteString) throws InvalidProtocolBufferException {
        return (d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
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

    public Abbff$EventType c() {
        Abbff$EventType abbff$EventTypeForNumber = Abbff$EventType.forNumber(this.eventType_);
        return abbff$EventTypeForNumber == null ? Abbff$EventType.UNRECOGNIZED : abbff$EventTypeForNumber;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new d();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\f\u00042", new Object[]{"eventId_", "timestamp_", "eventType_", "metadata_", b.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<d> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (d.class) {
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

    public String getEventId() {
        return this.eventId_;
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    public long getTimestamp() {
        return this.timestamp_;
    }
}
