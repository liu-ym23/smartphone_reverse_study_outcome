package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class p extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzci f19965a;

    public p(zzci zzciVar) {
        this.f19965a = zzciVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f19965a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f19965a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzci zzciVar = this.f19965a;
        Map mapU = zzciVar.u();
        return mapU != null ? mapU.keySet().iterator() : new k(zzciVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapU = this.f19965a.u();
        return mapU != null ? mapU.keySet().remove(obj) : this.f19965a.K(obj) != zzci.f19972j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f19965a.size();
    }
}
