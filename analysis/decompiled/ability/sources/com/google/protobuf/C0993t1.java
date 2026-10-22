package com.google.protobuf;

import java.util.Map;

/* renamed from: com.google.protobuf.t1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0993t1 implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public Map.Entry f2943a;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f2943a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof X1)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        com.stepos.statsrpk.service.c.m(this.f2943a.getValue());
        throw null;
    }
}
