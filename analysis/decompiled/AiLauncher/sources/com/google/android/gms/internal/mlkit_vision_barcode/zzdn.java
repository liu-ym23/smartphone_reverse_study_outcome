package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import z2.AbstractC6072P;

/* loaded from: classes2.dex */
final class zzdn extends zzcv {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzcu f20000c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zzcs f20001d;

    public zzdn(zzcu zzcuVar, zzcs zzcsVar) {
        this.f20000c = zzcuVar;
        this.f20001d = zzcsVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int b(Object[] objArr, int i10) {
        return this.f20001d.b(objArr, i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f20000c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    /* renamed from: f */
    public final AbstractC6072P iterator() {
        return this.f20001d.listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f20001d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }
}
