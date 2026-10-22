package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends h2 implements DescriptorProtos$ExtensionRangeOptionsOrBuilder {
    public static final int DECLARATION_FIELD_NUMBER = 2;
    private static final f0 DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 50;
    private static volatile p3 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int VERIFICATION_FIELD_NUMBER = 3;
    private int bitField0_;
    private o2 declaration_;
    private m0 features_;
    private byte memoizedIsInitialized = 2;
    private o2 uninterpretedOption_;
    private int verification_;

    static {
        f0 f0Var = new f0();
        DEFAULT_INSTANCE = f0Var;
        i2.n(f0.class, f0Var);
    }

    public f0() {
        r3 r3Var = r3.f2514j;
        this.uninterpretedOption_ = r3Var;
        this.declaration_ = r3Var;
        this.verification_ = 1;
    }

    public static f0 q() {
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0002ϧ\u0004\u0000\u0002\u0002\u0002\u001b\u0003᠌\u00012ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "declaration_", d0.class, "verification_", v.f2565c, "features_", "uninterpretedOption_", o1.class});
            case 3:
                return new f0();
            case 4:
                return new z(2, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (f0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final d0 getDeclaration(int i2) {
        return (d0) this.declaration_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final int getDeclarationCount() {
        return this.declaration_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final List getDeclarationList() {
        return this.declaration_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final e0 getVerification() {
        int i2 = this.verification_;
        e0 e0Var = e0.UNVERIFIED;
        e0 e0Var2 = i2 != 0 ? i2 != 1 ? null : e0Var : e0.DECLARATION;
        return e0Var2 == null ? e0Var : e0Var2;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public final boolean hasVerification() {
        return (this.bitField0_ & 2) != 0;
    }
}
