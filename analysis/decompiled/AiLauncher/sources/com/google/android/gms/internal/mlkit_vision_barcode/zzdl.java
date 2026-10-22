package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Objects;
import z2.C6195m;

/* loaded from: classes2.dex */
final class zzdl extends zzcs {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzdm f19996c;

    public zzdl(zzdm zzdmVar) {
        this.f19996c = zzdmVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        C6195m.a(i10, this.f19996c.f19999e, "index");
        int i11 = i10 + i10;
        Object obj = this.f19996c.f19998d[i11];
        Objects.requireNonNull(obj);
        Object obj2 = this.f19996c.f19998d[i11 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19996c.f19999e;
    }
}
