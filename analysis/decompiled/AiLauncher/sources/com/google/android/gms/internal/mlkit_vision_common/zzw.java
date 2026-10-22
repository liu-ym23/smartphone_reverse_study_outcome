package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzw extends zzs {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzr f20182c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f20183d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f20184e;

    public zzw(zzr zzrVar, Object[] objArr, int i10, int i11) {
        this.f20182c = zzrVar;
        this.f20183d = objArr;
        this.f20184e = i11;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int b(Object[] objArr, int i10) {
        return i().b(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f20182c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return i().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs
    public final zzp j() {
        return new zzv(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f20184e;
    }
}
