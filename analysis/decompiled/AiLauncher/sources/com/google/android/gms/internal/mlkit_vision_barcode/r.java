package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class r extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzci f19969a;

    public r(zzci zzciVar) {
        this.f19969a = zzciVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f19969a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzci zzciVar = this.f19969a;
        Map mapU = zzciVar.u();
        return mapU != null ? mapU.values().iterator() : new m(zzciVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f19969a.size();
    }
}
