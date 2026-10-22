package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;
import z2.C6195m;

/* loaded from: classes2.dex */
final class zzdk extends zzcs {

    /* renamed from: e, reason: collision with root package name */
    public static final zzcs f19993e = new zzdk(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f19994c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f19995d;

    public zzdk(Object[] objArr, int i10) {
        this.f19994c = objArr;
        this.f19995d = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcs, com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int b(Object[] objArr, int i10) {
        System.arraycopy(this.f19994c, 0, objArr, i10, this.f19995d);
        return i10 + this.f19995d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int c() {
        return this.f19995d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int e() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        C6195m.a(i10, this.f19995d, "index");
        Object obj = this.f19994c[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final Object[] i() {
        return this.f19994c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19995d;
    }
}
