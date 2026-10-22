package com.stepos.agentframework.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes2.dex */
public final class c extends GeneratedMessageLite<c, a> implements MessageLiteOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final c DEFAULT_INSTANCE;
    private static volatile Parser<c> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    private int code_;
    private String reason_ = "";

    public static final class a extends GeneratedMessageLite.Builder<c, a> implements MessageLiteOrBuilder {
        public a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
    }

    public static c b(ByteString byteString) throws InvalidProtocolBufferException {
        return (c) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new c();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"code_", "reason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<c> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (c.class) {
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

    public int getCode() {
        return this.code_;
    }

    public String getReason() {
        return this.reason_;
    }
}
