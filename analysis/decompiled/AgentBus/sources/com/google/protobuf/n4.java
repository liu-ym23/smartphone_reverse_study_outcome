package com.google.protobuf;

/* loaded from: classes.dex */
public final class n4 extends i2 implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final n4 DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile p3 PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_ = 0;
    private Object kind_;

    static {
        n4 n4Var = new n4();
        DEFAULT_INSTANCE = n4Var;
        i2.n(n4.class, n4Var);
    }

    public static n4 p() {
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", z3.class, w2.class});
            case 3:
                return new n4();
            case 4:
                return new j3(4, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (n4.class) {
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

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final m4 getKindCase() {
        switch (this.kindCase_) {
            case 0:
                return m4.f2448l;
            case 1:
                return m4.f2442f;
            case 2:
                return m4.f2443g;
            case 3:
                return m4.f2444h;
            case 4:
                return m4.f2445i;
            case 5:
                return m4.f2446j;
            case 6:
                return m4.f2447k;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final w2 getListValue() {
        return this.kindCase_ == 6 ? (w2) this.kind_ : w2.p();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final n3 getNullValue() {
        int i2 = this.kindCase_;
        n3 n3Var = n3.NULL_VALUE;
        if (i2 == 1) {
            if (((Integer) this.kind_).intValue() != 0) {
                n3Var = null;
            }
            if (n3Var == null) {
                return n3.UNRECOGNIZED;
            }
        }
        return n3Var;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final String getStringValue() {
        return this.kindCase_ == 3 ? (String) this.kind_ : "";
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final l getStringValueBytes() {
        return l.i(this.kindCase_ == 3 ? (String) this.kind_ : "");
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final z3 getStructValue() {
        return this.kindCase_ == 5 ? (z3) this.kind_ : z3.p();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean hasBoolValue() {
        return this.kindCase_ == 4;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean hasListValue() {
        return this.kindCase_ == 6;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean hasNullValue() {
        return this.kindCase_ == 1;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean hasNumberValue() {
        return this.kindCase_ == 2;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean hasStringValue() {
        return this.kindCase_ == 3;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public final boolean hasStructValue() {
        return this.kindCase_ == 5;
    }
}
