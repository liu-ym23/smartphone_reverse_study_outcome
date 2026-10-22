package com.google.protobuf;

/* loaded from: classes.dex */
public final class o3 extends i2 implements OptionOrBuilder {
    private static final o3 DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile p3 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String name_ = "";
    private f value_;

    static {
        o3 o3Var = new o3();
        DEFAULT_INSTANCE = o3Var;
        i2.n(o3.class, o3Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "name_", "value_"});
            case 3:
                return new o3();
            case 4:
                return new j3(1, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (o3.class) {
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

    @Override // com.google.protobuf.OptionOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public final f getValue() {
        f fVar = this.value_;
        return fVar == null ? f.p() : fVar;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public final boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }
}
