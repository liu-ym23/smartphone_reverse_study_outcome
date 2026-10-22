package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Map;

/* loaded from: classes2.dex */
public final class P0 implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Map.Entry f20048a;

    public final R0 a() {
        return (R0) this.f20048a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f20048a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((R0) this.f20048a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof InterfaceC1720h1) {
            return ((R0) this.f20048a.getValue()).c((InterfaceC1720h1) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
