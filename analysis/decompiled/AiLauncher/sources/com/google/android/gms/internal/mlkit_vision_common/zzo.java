package com.google.android.gms.internal.mlkit_vision_common;

import A2.F1;
import java.util.List;

/* loaded from: classes2.dex */
final class zzo extends zzp {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f20170c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f20171d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzp f20172e;

    public zzo(zzp zzpVar, int i10, int i11) {
        this.f20172e = zzpVar;
        this.f20170c = i10;
        this.f20171d = i11;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int c() {
        return this.f20172e.e() + this.f20170c + this.f20171d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int e() {
        return this.f20172e.e() + this.f20170c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final Object[] f() {
        return this.f20172e.f();
    }

    @Override // java.util.List
    public final Object get(int i10) {
        F1.a(i10, this.f20171d, "index");
        return this.f20172e.get(i10 + this.f20170c);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzp
    /* renamed from: i */
    public final zzp subList(int i10, int i11) {
        F1.c(i10, i11, this.f20171d);
        zzp zzpVar = this.f20172e;
        int i12 = this.f20170c;
        return zzpVar.subList(i10 + i12, i11 + i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20171d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzp, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }
}
