package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class q1 extends i2 implements EnumValueOrBuilder {
    private static final q1 DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile p3 PARSER;
    private int number_;
    private String name_ = "";
    private o2 options_ = r3.f2514j;

    static {
        q1 q1Var = new q1();
        DEFAULT_INSTANCE = q1Var;
        i2.n(q1.class, q1Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001b", new Object[]{"name_", "number_", "options_", o3.class});
            case 3:
                return new q1();
            case 4:
                return new b7.a(26, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (q1.class) {
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

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder
    public final int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final o3 getOptions(int i2) {
        return (o3) this.options_.get(i2);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final List getOptionsList() {
        return this.options_;
    }
}
