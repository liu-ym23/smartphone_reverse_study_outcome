package com.stepos.agentframework.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes2.dex */
public final class g extends GeneratedMessageLite<g, a> implements MessageLiteOrBuilder {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final g DEFAULT_INSTANCE;
    public static final int HEAD_FIELD_NUMBER = 1;
    private static volatile Parser<g> PARSER;
    private int bitField0_;
    private ByteString body_ = ByteString.EMPTY;
    private e head_;

    public static final class a extends GeneratedMessageLite.Builder<g, a> implements MessageLiteOrBuilder {
        public a a(ByteString byteString) {
            copyOnWrite();
            ((g) this.instance).setBody(byteString);
            return this;
        }

        public a d(e eVar) {
            copyOnWrite();
            ((g) this.instance).g(eVar);
            return this;
        }

        public a() {
            super(g.DEFAULT_INSTANCE);
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        GeneratedMessageLite.registerDefaultInstance(g.class, gVar);
    }

    public static a e() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static g f(byte[] bArr) throws InvalidProtocolBufferException {
        return (g) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public e d() {
        e eVar = this.head_;
        return eVar == null ? e.f() : eVar;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = com.stepos.agentframework.protobuf.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new g();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n", new Object[]{"bitField0_", "head_", "body_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<g> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (g.class) {
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

    public final void g(e eVar) {
        eVar.getClass();
        this.head_ = eVar;
        this.bitField0_ |= 1;
    }

    public ByteString getBody() {
        return this.body_;
    }

    public final void setBody(ByteString byteString) {
        byteString.getClass();
        this.body_ = byteString;
    }
}
