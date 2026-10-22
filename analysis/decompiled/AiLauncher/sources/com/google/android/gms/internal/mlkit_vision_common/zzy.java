package com.google.android.gms.internal.mlkit_vision_common;

import A2.F1;

/* loaded from: classes2.dex */
final class zzy extends zzp {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f20187c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f20188d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f20189e;

    public zzy(Object[] objArr, int i10, int i11) {
        this.f20187c = objArr;
        this.f20188d = i10;
        this.f20189e = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        F1.a(i10, this.f20189e, "index");
        Object obj = this.f20187c[i10 + i10 + this.f20188d];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20189e;
    }
}
