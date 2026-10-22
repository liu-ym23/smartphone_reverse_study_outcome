package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class c0 extends h2 implements DescriptorProtos$EnumValueOptionsOrBuilder {
    public static final int DEBUG_REDACT_FIELD_NUMBER = 3;
    private static final c0 DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 1;
    public static final int FEATURES_FIELD_NUMBER = 2;
    public static final int FEATURE_SUPPORT_FIELD_NUMBER = 4;
    private static volatile p3 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean debugRedact_;
    private boolean deprecated_;
    private t0 featureSupport_;
    private m0 features_;
    private byte memoizedIsInitialized = 2;
    private o2 uninterpretedOption_ = r3.f2514j;

    static {
        c0 c0Var = new c0();
        DEFAULT_INSTANCE = c0Var;
        i2.n(c0.class, c0Var);
    }

    public static c0 q() {
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"bitField0_", "deprecated_", "features_", "debugRedact_", "featureSupport_", "uninterpretedOption_", o1.class});
            case 3:
                return new c0();
            case 4:
                return new z(1, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (c0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final boolean getDebugRedact() {
        return this.debugRedact_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final t0 getFeatureSupport() {
        t0 t0Var = this.featureSupport_;
        return t0Var == null ? t0.p() : t0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final boolean hasDebugRedact() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final boolean hasDeprecated() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final boolean hasFeatureSupport() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 2) != 0;
    }
}
