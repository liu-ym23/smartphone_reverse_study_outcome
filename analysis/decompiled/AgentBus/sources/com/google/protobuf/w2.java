package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class w2 extends i2 implements ListValueOrBuilder {
    private static final w2 DEFAULT_INSTANCE;
    private static volatile p3 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private o2 values_ = r3.f2514j;

    static {
        w2 w2Var = new w2();
        DEFAULT_INSTANCE = w2Var;
        i2.n(w2.class, w2Var);
    }

    public static w2 p() {
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", n4.class});
            case 3:
                return new w2();
            case 4:
                return new b7.a(28, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (w2.class) {
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

    @Override // com.google.protobuf.ListValueOrBuilder
    public final n4 getValues(int i2) {
        return (n4) this.values_.get(i2);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public final int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public final List getValuesList() {
        return this.values_;
    }
}
