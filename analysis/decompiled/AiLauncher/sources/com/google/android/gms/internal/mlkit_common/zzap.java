package com.google.android.gms.internal.mlkit_common;

import java.util.Objects;
import y2.L;

/* loaded from: classes2.dex */
final class zzap extends zzaf {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f19930c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f19931d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f19932e;

    public zzap(Object[] objArr, int i10, int i11) {
        this.f19930c = objArr;
        this.f19931d = i10;
        this.f19932e = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        L.a(i10, this.f19932e, "index");
        Object obj = this.f19930c[i10 + i10 + this.f19931d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19932e;
    }
}
