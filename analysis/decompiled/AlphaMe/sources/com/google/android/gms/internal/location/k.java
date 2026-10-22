package com.google.android.gms.internal.location;

/* loaded from: classes.dex */
public final class k extends j {

    /* renamed from: e, reason: collision with root package name */
    public static final k f9971e = new k(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f9972c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9973d;

    public k(Object[] objArr, int i4) {
        this.f9972c = objArr;
        this.f9973d = i4;
    }

    @Override // com.google.android.gms.internal.location.j, com.google.android.gms.internal.location.g
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f9972c;
        int i4 = this.f9973d;
        System.arraycopy(objArr2, 0, objArr, 0, i4);
        return i4;
    }

    @Override // com.google.android.gms.internal.location.g
    public final int c() {
        return this.f9973d;
    }

    @Override // com.google.android.gms.internal.location.g
    public final int d() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.g
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.g
    public final Object[] f() {
        return this.f9972c;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        com.airbnb.lottie.h.M(i4, this.f9973d);
        Object obj = this.f9972c[i4];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9973d;
    }
}
