package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class g1 extends h2 implements DescriptorProtos$MethodOptionsOrBuilder {
    private static final g1 DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 33;
    public static final int FEATURES_FIELD_NUMBER = 35;
    public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
    private static volatile p3 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean deprecated_;
    private m0 features_;
    private int idempotencyLevel_;
    private byte memoizedIsInitialized = 2;
    private o2 uninterpretedOption_ = r3.f2514j;

    static {
        g1 g1Var = new g1();
        DEFAULT_INSTANCE = g1Var;
        i2.n(g1.class, g1Var);
    }

    public static g1 q() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 1:
                this.memoizedIsInitialized = (byte) (i2Var == null ? 0 : 1);
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001!ϧ\u0004\u0000\u0001\u0002!ဇ\u0000\"᠌\u0001#ᐉ\u0002ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", v.f2580r, "features_", "uninterpretedOption_", o1.class});
            case 3:
                return new g1();
            case 4:
                return new z(7, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (g1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final f1 getIdempotencyLevel() {
        f1 f1VarA = f1.a(this.idempotencyLevel_);
        return f1VarA == null ? f1.IDEMPOTENCY_UNKNOWN : f1VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final boolean hasDeprecated() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public final boolean hasIdempotencyLevel() {
        return (this.bitField0_ & 2) != 0;
    }
}
