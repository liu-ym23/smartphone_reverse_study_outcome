package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;
import z2.AbstractC6072P;

/* loaded from: classes2.dex */
final class zzdm extends zzcv {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzcu f19997c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f19998d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f19999e = 1;

    public zzdm(zzcu zzcuVar, Object[] objArr, int i10, int i11) {
        this.f19997c = zzcuVar;
        this.f19998d = objArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int b(Object[] objArr, int i10) {
        return j().b(objArr, i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f19997c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    /* renamed from: f */
    public final AbstractC6072P iterator() {
        return j().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return j().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv
    public final zzcs k() {
        return new zzdl(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f19999e;
    }
}
