package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import z2.C6195m;

/* loaded from: classes2.dex */
final class zzcr extends zzcs {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f19985c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f19986d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzcs f19987e;

    public zzcr(zzcs zzcsVar, int i10, int i11) {
        this.f19987e = zzcsVar;
        this.f19985c = i10;
        this.f19986d = i11;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int c() {
        return this.f19987e.e() + this.f19985c + this.f19986d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int e() {
        return this.f19987e.e() + this.f19985c;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        C6195m.a(i10, this.f19986d, "index");
        return this.f19987e.get(i10 + this.f19985c);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final Object[] i() {
        return this.f19987e.i();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcs
    /* renamed from: j */
    public final zzcs subList(int i10, int i11) {
        C6195m.d(i10, i11, this.f19986d);
        int i12 = this.f19985c;
        return this.f19987e.subList(i10 + i12, i11 + i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19986d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcs, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }
}
