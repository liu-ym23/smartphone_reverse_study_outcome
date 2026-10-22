package com.google.android.gms.internal.mlkit_common;

import java.util.List;
import y2.L;

/* loaded from: classes2.dex */
final class zzae extends zzaf {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f19913c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f19914d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzaf f19915e;

    public zzae(zzaf zzafVar, int i10, int i11) {
        this.f19915e = zzafVar;
        this.f19913c = i10;
        this.f19914d = i11;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int c() {
        return this.f19915e.e() + this.f19913c + this.f19914d;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int e() {
        return this.f19915e.e() + this.f19913c;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final Object[] f() {
        return this.f19915e.f();
    }

    @Override // java.util.List
    public final Object get(int i10) {
        L.a(i10, this.f19914d, "index");
        return this.f19915e.get(i10 + this.f19913c);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf
    /* renamed from: i */
    public final zzaf subList(int i10, int i11) {
        L.c(i10, i11, this.f19914d);
        int i12 = this.f19913c;
        return this.f19915e.subList(i10 + i12, i11 + i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19914d;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }
}
