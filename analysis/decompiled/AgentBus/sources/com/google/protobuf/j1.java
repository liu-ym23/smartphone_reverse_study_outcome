package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class j1 extends i2 implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
    private static final j1 DEFAULT_INSTANCE;
    public static final int METHOD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile p3 PARSER;
    private int bitField0_;
    private k1 options_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private o2 method_ = r3.f2514j;

    static {
        j1 j1Var = new j1();
        DEFAULT_INSTANCE = j1Var;
        i2.n(j1.class, j1Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", e1.class, "options_"});
            case 3:
                return new j1();
            case 4:
                return new b7.a(22, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (j1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final e1 getMethod(int i2) {
        return (e1) this.method_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final int getMethodCount() {
        return this.method_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final List getMethodList() {
        return this.method_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    /* renamed from: getOptions */
    public final k1 mo6getOptions() {
        k1 k1Var = this.options_;
        return k1Var == null ? k1.q() : k1Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }
}
