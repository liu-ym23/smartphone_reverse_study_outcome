package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;
import z2.C6195m;

/* loaded from: classes2.dex */
final class zzdo extends zzcs {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f20002c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f20003d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f20004e = 1;

    public zzdo(Object[] objArr, int i10, int i11) {
        this.f20002c = objArr;
        this.f20003d = i10;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        C6195m.a(i10, this.f20004e, "index");
        Object obj = this.f20002c[i10 + i10 + this.f20003d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20004e;
    }
}
