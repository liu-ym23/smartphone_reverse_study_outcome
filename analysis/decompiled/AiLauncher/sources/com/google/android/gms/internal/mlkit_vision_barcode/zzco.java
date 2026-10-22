package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import z2.AbstractC6225p;

/* loaded from: classes2.dex */
final class zzco extends AbstractC6225p implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19983a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19984b;

    public zzco(Object obj, Object obj2) {
        this.f19983a = obj;
        this.f19984b = obj2;
    }

    @Override // z2.AbstractC6225p, java.util.Map.Entry
    public final Object getKey() {
        return this.f19983a;
    }

    @Override // z2.AbstractC6225p, java.util.Map.Entry
    public final Object getValue() {
        return this.f19984b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
