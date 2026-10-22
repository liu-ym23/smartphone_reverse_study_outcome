package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class k1 extends h2 implements DescriptorProtos$ServiceOptionsOrBuilder {
    private static final k1 DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 33;
    public static final int FEATURES_FIELD_NUMBER = 34;
    private static volatile p3 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean deprecated_;
    private m0 features_;
    private byte memoizedIsInitialized = 2;
    private o2 uninterpretedOption_ = r3.f2514j;

    static {
        k1 k1Var = new k1();
        DEFAULT_INSTANCE = k1Var;
        i2.n(k1.class, k1Var);
    }

    public static k1 q() {
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001!ϧ\u0003\u0000\u0001\u0002!ဇ\u0001\"ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "features_", "uninterpretedOption_", o1.class});
            case 3:
                return new k1();
            case 4:
                return new z(9, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (k1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final boolean hasDeprecated() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 1) != 0;
    }
}
