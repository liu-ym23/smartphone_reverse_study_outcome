package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class z3 extends i2 implements StructOrBuilder {
    private static final z3 DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile p3 PARSER;
    private b3 fields_ = b3.f2320g;

    static {
        z3 z3Var = new z3();
        DEFAULT_INSTANCE = z3Var;
        i2.n(z3.class, z3Var);
    }

    public static z3 p() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public final boolean containsFields(String str) {
        str.getClass();
        return this.fields_.containsKey(str);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", y3.f2636a});
            case 3:
                return new z3();
            case 4:
                return new j3(3, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (z3.class) {
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

    @Override // com.google.protobuf.StructOrBuilder
    public final Map getFields() {
        return Collections.unmodifiableMap(this.fields_);
    }

    @Override // com.google.protobuf.StructOrBuilder
    public final int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public final Map getFieldsMap() {
        return Collections.unmodifiableMap(this.fields_);
    }

    @Override // com.google.protobuf.StructOrBuilder
    public final n4 getFieldsOrDefault(String str, n4 n4Var) {
        str.getClass();
        b3 b3Var = this.fields_;
        return b3Var.containsKey(str) ? (n4) b3Var.get(str) : n4Var;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public final n4 getFieldsOrThrow(String str) {
        str.getClass();
        b3 b3Var = this.fields_;
        if (b3Var.containsKey(str)) {
            return (n4) b3Var.get(str);
        }
        throw new IllegalArgumentException();
    }
}
