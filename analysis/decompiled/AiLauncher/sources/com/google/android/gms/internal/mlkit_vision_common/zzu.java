package com.google.android.gms.internal.mlkit_vision_common;

import A2.F1;

/* loaded from: classes2.dex */
final class zzu extends zzp {

    /* renamed from: e, reason: collision with root package name */
    public static final zzp f20178e = new zzu(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f20179c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f20180d;

    public zzu(Object[] objArr, int i10) {
        this.f20179c = objArr;
        this.f20180d = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzp, com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int b(Object[] objArr, int i10) {
        System.arraycopy(this.f20179c, 0, objArr, 0, this.f20180d);
        return this.f20180d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int c() {
        return this.f20180d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int e() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final Object[] f() {
        return this.f20179c;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        F1.a(i10, this.f20180d, "index");
        Object obj = this.f20179c[i10];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20180d;
    }
}
