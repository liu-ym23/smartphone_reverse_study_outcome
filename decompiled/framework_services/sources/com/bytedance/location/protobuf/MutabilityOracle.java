package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = null;

    void ensureMutable();

    static {
        IMMUTABLE = new AnonymousClass1();
    }
}
