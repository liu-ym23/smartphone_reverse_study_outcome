package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzan extends zzaj {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzai f19925c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f19926d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f19927e;

    public zzan(zzai zzaiVar, Object[] objArr, int i10, int i11) {
        this.f19925c = zzaiVar;
        this.f19926d = objArr;
        this.f19927e = i11;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int b(Object[] objArr, int i10) {
        return i().b(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f19925c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return i().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaj
    public final zzaf j() {
        return new zzam(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f19927e;
    }
}
