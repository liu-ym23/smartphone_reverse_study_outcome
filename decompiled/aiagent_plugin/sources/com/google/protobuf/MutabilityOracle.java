package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = null;

    void ensureMutable();

    static {
        IMMUTABLE = new AnonymousClass1();
    }
}
