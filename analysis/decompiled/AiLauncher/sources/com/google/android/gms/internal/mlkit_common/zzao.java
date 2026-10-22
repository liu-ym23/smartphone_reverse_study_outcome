package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class zzao extends zzaj {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzai f19928c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zzaf f19929d;

    public zzao(zzai zzaiVar, zzaf zzafVar) {
        this.f19928c = zzaiVar;
        this.f19929d = zzafVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int b(Object[] objArr, int i10) {
        return this.f19929d.b(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f19928c.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f19929d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f19928c.size();
    }
}
