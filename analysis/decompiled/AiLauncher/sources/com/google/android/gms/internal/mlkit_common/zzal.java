package com.google.android.gms.internal.mlkit_common;

import java.util.Objects;
import y2.L;

/* loaded from: classes2.dex */
final class zzal extends zzaf {

    /* renamed from: e, reason: collision with root package name */
    public static final zzaf f19921e = new zzal(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f19922c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f19923d;

    public zzal(Object[] objArr, int i10) {
        this.f19922c = objArr;
        this.f19923d = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf, com.google.android.gms.internal.mlkit_common.zzab
    public final int b(Object[] objArr, int i10) {
        System.arraycopy(this.f19922c, 0, objArr, 0, this.f19923d);
        return this.f19923d;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int c() {
        return this.f19923d;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int e() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final Object[] f() {
        return this.f19922c;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        L.a(i10, this.f19923d, "index");
        Object obj = this.f19922c[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19923d;
    }
}
