package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class zzx extends zzs {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzr f20185c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zzp f20186d;

    public zzx(zzr zzrVar, zzp zzpVar) {
        this.f20185c = zzrVar;
        this.f20186d = zzpVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int b(Object[] objArr, int i10) {
        return this.f20186d.b(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f20185c.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f20186d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f20185c.size();
    }
}
