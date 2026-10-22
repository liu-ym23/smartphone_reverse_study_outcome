package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class m1 extends h2 implements DescriptorProtos$SourceCodeInfoOrBuilder {
    private static final m1 DEFAULT_INSTANCE;
    public static final int LOCATION_FIELD_NUMBER = 1;
    private static volatile p3 PARSER;
    private byte memoizedIsInitialized = 2;
    private o2 location_ = r3.f2514j;

    static {
        m1 m1Var = new m1();
        DEFAULT_INSTANCE = m1Var;
        i2.n(m1.class, m1Var);
    }

    public static m1 q() {
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"location_", l1.class});
            case 3:
                return new m1();
            case 4:
                return new z(10, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (m1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder
    public final l1 getLocation(int i2) {
        return (l1) this.location_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder
    public final int getLocationCount() {
        return this.location_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder
    public final List getLocationList() {
        return this.location_;
    }
}
