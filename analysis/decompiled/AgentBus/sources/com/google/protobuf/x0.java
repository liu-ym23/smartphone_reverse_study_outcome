package com.google.protobuf;

import fi.iki.elonen.NanoHTTPD;
import java.util.List;

/* loaded from: classes.dex */
public final class x0 extends h2 implements DescriptorProtos$FieldOptionsOrBuilder {
    public static final int CTYPE_FIELD_NUMBER = 1;
    public static final int DEBUG_REDACT_FIELD_NUMBER = 16;
    private static final x0 DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int EDITION_DEFAULTS_FIELD_NUMBER = 20;
    public static final int FEATURES_FIELD_NUMBER = 21;
    public static final int FEATURE_SUPPORT_FIELD_NUMBER = 22;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    public static final int LAZY_FIELD_NUMBER = 5;
    public static final int PACKED_FIELD_NUMBER = 2;
    private static volatile p3 PARSER = null;
    public static final int RETENTION_FIELD_NUMBER = 17;
    public static final int TARGETS_FIELD_NUMBER = 19;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int UNVERIFIED_LAZY_FIELD_NUMBER = 15;
    public static final int WEAK_FIELD_NUMBER = 10;
    private static final m2 targets_converter_ = new i(2);
    private int bitField0_;
    private int ctype_;
    private boolean debugRedact_;
    private boolean deprecated_;
    private o2 editionDefaults_;
    private t0 featureSupport_;
    private m0 features_;
    private int jstype_;
    private boolean lazy_;
    private boolean packed_;
    private int retention_;
    private o2 uninterpretedOption_;
    private boolean unverifiedLazy_;
    private boolean weak_;
    private byte memoizedIsInitialized = 2;
    private Internal$IntList targets_ = j2.f2413j;

    static {
        x0 x0Var = new x0();
        DEFAULT_INSTANCE = x0Var;
        i2.n(x0.class, x0Var);
    }

    public x0() {
        r3 r3Var = r3.f2514j;
        this.editionDefaults_ = r3Var;
        this.uninterpretedOption_ = r3Var;
    }

    public static x0 q() {
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u000e\u0000\u0001\u0001ϧ\u000e\u0000\u0003\u0002\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0005\u0005ဇ\u0003\u0006᠌\u0002\nဇ\u0006\u000fဇ\u0004\u0010ဇ\u0007\u0011᠌\b\u0013ࠞ\u0014\u001b\u0015ᐉ\t\u0016ဉ\nϧЛ", new Object[]{"bitField0_", "ctype_", v.f2574l, "packed_", "deprecated_", "lazy_", "jstype_", v.f2575m, "weak_", "unverifiedLazy_", "debugRedact_", "retention_", v.f2576n, "targets_", v.f2577o, "editionDefaults_", s0.class, "features_", "featureSupport_", "uninterpretedOption_", o1.class});
            case 3:
                return new x0();
            case 4:
                return new z(4, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (x0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final r0 getCtype() {
        r0 r0VarA = r0.a(this.ctype_);
        return r0VarA == null ? r0.STRING : r0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean getDebugRedact() {
        return this.debugRedact_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final s0 getEditionDefaults(int i2) {
        return (s0) this.editionDefaults_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final int getEditionDefaultsCount() {
        return this.editionDefaults_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final List getEditionDefaultsList() {
        return this.editionDefaults_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final t0 getFeatureSupport() {
        t0 t0Var = this.featureSupport_;
        return t0Var == null ? t0.p() : t0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final u0 getJstype() {
        u0 u0VarA = u0.a(this.jstype_);
        return u0VarA == null ? u0.JS_NORMAL : u0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean getLazy() {
        return this.lazy_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final v0 getRetention() {
        v0 v0VarA = v0.a(this.retention_);
        return v0VarA == null ? v0.RETENTION_UNKNOWN : v0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final w0 getTargets(int i2) {
        w0 w0VarA = w0.a(this.targets_.getInt(i2));
        return w0VarA == null ? w0.TARGET_TYPE_UNKNOWN : w0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final int getTargetsCount() {
        return this.targets_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final List getTargetsList() {
        return new n2(this.targets_, targets_converter_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean getUnverifiedLazy() {
        return this.unverifiedLazy_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean getWeak() {
        return this.weak_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasCtype() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasDebugRedact() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasDeprecated() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasFeatureSupport() {
        return (this.bitField0_ & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasJstype() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasLazy() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasPacked() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasRetention() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasUnverifiedLazy() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public final boolean hasWeak() {
        return (this.bitField0_ & 64) != 0;
    }
}
