package com.google.protobuf;

/* loaded from: classes.dex */
public final class f extends i2 implements AnyOrBuilder {
    private static final f DEFAULT_INSTANCE;
    private static volatile p3 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String typeUrl_ = "";
    private l value_ = l.f2424g;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        i2.n(f.class, fVar);
    }

    public static f p() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"typeUrl_", "value_"});
            case 3:
                return new f();
            case 4:
                return new b7.a(6, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (f.class) {
                    try {
                        g2Var = PARSER;
                        if (g2Var == null) {
                            g2Var = new g2();
                            PARSER = g2Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return g2Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.AnyOrBuilder, com.google.protobuf.FieldOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.protobuf.AnyOrBuilder, com.google.protobuf.FieldOrBuilder
    public final l getTypeUrlBytes() {
        return l.i(this.typeUrl_);
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public final l getValue() {
        return this.value_;
    }
}
